package com.efi.printsmith.reporting;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet filter to limit requests by epace itself
 *
 * @author <a href="proyal@pace2020.com">peter royal</a>
 */
public class EPaceInternalRequestFilter implements Filter
{
    public void init( final FilterConfig filterConfig ) throws ServletException
    {
    }

    public void destroy()
    {
    }

    public void doFilter( final ServletRequest req, final ServletResponse resp, final FilterChain chain )
        throws IOException, ServletException
    {
        final HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)resp;

        if( null == request.getHeader( "X-Forwarded-Host" ) && "127.0.0.1".equals( request.getRemoteAddr() ) )
        {
            chain.doFilter( request, response );
        }
        else
        {
            response.sendError( 403 );
        }
    }
}
