package com.efi.printsmith.reporting;

//import org.apache.avalon.excalibur.io.IOUtil;
//import org.apache.avalon.framework.service.ServiceException;
//import org.apache.avalon.framework.service.ServiceManager;
//import org.apache.avalon.framework.service.Serviceable;
//import org.apache.avalon.framework.logger.LogEnabled;
//import org.apache.avalon.framework.logger.Logger;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.HeadMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
public class ProxyServlet extends GenericServlet
{
    private static final Set PROXY_SKIP_HEADERS;

    static
    {
        final Set set = new HashSet();

        set.add( "Content-Length" );
        set.add( "Connection" );
        set.add( "Proxy-Connection" );
        set.add( "keep-alive" );
        set.add( "Date" );
        set.add( "Server" );

        PROXY_SKIP_HEADERS = Collections.unmodifiableSet( set );
    }

    private HttpConnectionManager m_connectionManager;

    private int m_timeout;
    private URI m_remoteHost;
    private Logger log = Logger.getLogger(ProxyServlet.class);

    public void init() throws ServletException
    {
        m_timeout = Integer.parseInt( getServletConfig().getInitParameter( "timeout" ) );

        try
        {
            m_remoteHost = new URI( getServletConfig().getInitParameter( "remote-host" ) );
        }
        catch( URISyntaxException e )
        {
            throw new ServletException( "Invalid remote-host URI", e );
        }
    }

    protected void service( final HttpServletRequest req, final HttpServletResponse resp )
        throws ServletException, IOException
    {
        final HttpClient client = new HttpClient( m_connectionManager );
        final HttpMethod method = createMethod( req );

        client.setTimeout( m_timeout );

        log.debug( "Proxying request - " + method.getURI() );

        try
        {
            final int responseCode = client.executeMethod( method );

            if( responseCode >= HttpServletResponse.SC_BAD_REQUEST )
            {
                resp.sendError( responseCode, method.getStatusText() );
            }
            else
            {
                resp.setStatus( responseCode );
            }

            final Header[] headers = method.getResponseHeaders();

            for( int i = 0; i < headers.length; i++ )
            {
                final Header header = headers[i];

                if( !PROXY_SKIP_HEADERS.contains( header.getName() ) )
                {
                    resp.addHeader( header.getName(), header.getValue() );
                }
            }

            IOUtils.copy( method.getResponseBodyAsStream(), resp.getOutputStream() );
        }
        finally
        {
            method.releaseConnection();
        }
    }

    private HttpMethod createMethod( final HttpServletRequest request ) throws IOException
    {
        final String uri = m_remoteHost.resolve( request.getRequestURI() ).toString();
        final HttpMethod method;

        if( "HEAD".equals( request.getMethod() ) )
        {
            method = new HeadMethod( uri );
        }
        else if( "GET".equals( request.getMethod() ) )
        {
            method = new GetMethod( uri );
        }
        else if( "POST".equals( request.getMethod() ) )
        {
            final PostMethod post = new PostMethod( uri );

            post.setRequestBody( request.getInputStream() );

            method = post;
        }
        else
        {
            throw new IOException( "Unsupported HTTP Method type for proxy: " + request.getMethod() );
        }

        method.setQueryString( request.getQueryString() );
        method.setFollowRedirects( false );

        final Enumeration headers = request.getHeaderNames();

        while( headers.hasMoreElements() )
        {
            final String header = (String)headers.nextElement();

            method.addRequestHeader( header, request.getHeader( header ) );
        }

        method.setRequestHeader( "X-Forwarded-Host", request.getServerName() + ":" + request.getServerPort() );

        return method;
    }

    public void service( final ServletRequest req, final ServletResponse res ) throws ServletException, IOException
    {
        final HttpServletRequest request;
        final HttpServletResponse response;

        try
        {
            request = (HttpServletRequest)req;
            response = (HttpServletResponse)res;
        }
        catch( ClassCastException e )
        {
            throw new ServletException( "non-HTTP request or response" );
        }

        service( request, response );
    }
}