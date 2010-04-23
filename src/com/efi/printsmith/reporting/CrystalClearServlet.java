package com.efi.printsmith.reporting;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import org.apache.log4j.Logger;

import com.inet.report.Area;
import com.inet.report.Element;
import com.inet.report.Engine;
import com.inet.report.FormulaField;
import com.inet.report.Picture;
import com.inet.report.ReportException;
import com.inet.report.ReportServlet;
import com.inet.report.Section;
/**
 * @author <a href="proyal@pace2020.com">peter royal</a>
 */
public class CrystalClearServlet extends ReportServlet
    implements LogEnabled, Contextualizable
{
    public static final String CCPROPS_LOCATION = "properties.location";
    private static final Pattern LOADKEY = Pattern.compile( "\"key=(.*)\"" );

    private final MultiThreadedHttpConnectionManager m_connectionManager = new MultiThreadedHttpConnectionManager();
    private final HttpClient m_client = new HttpClient( m_connectionManager );

    private URL m_logoUrl;
    private URL m_reportLogoUrl;
    private String m_viewerPrefix;
    private File m_appHome;
    private Logger m_logger;
    private ServiceManager m_manager;
    private DataSource m_dataSource;
    private ReportRepository m_repository;

    public void enableLogging( final Logger logger )
    {
        m_logger = logger;
    }

    private Logger getLogger()
    {
        return m_logger;
    }

    public void contextualize( final Context context )
        throws ContextException
    {
        m_appHome = (File)context.get( "app.home" );
    }

    @SuppressWarnings("deprecation")
	public void init( final ServletConfig config ) throws ServletException
    {
        final File properties = new File( m_appHome, config.getInitParameter( CCPROPS_LOCATION ) );

        if( getLogger().isDebugEnabled() )
            getLogger().debug( "Properties location: " + properties );

        try
        {
            Engine.setPath( properties.toURL() );
        }
        catch( IOException e )
        {
            final String msg = "Unable to set engine properties path. " + e.getMessage();
            throw new ServletException( msg, e );
        }

        m_viewerPrefix = config.getInitParameter( "viewer.prefix" );

        if( null == m_viewerPrefix )
        {
            m_viewerPrefix = "";
        }

        Engine.setLogStream( new PrintStream( new LoggerAwareOutputStream( this.getLogger() )
        {
            @SuppressWarnings("unused")
			protected void logMessage( final String message )
            {
                if( m_logger.isInfoEnabled() )
                {
                    m_logger.info( message );
                }
            }
        } ) );

        try
        {
            m_logoUrl = new URL( config.getInitParameter( "logo.url" ) );
        }
        catch( MalformedURLException e )
        {
            throw new ServletException( "Invalid logo.url", e );
        }

        try
        {
            m_reportLogoUrl = new URL( config.getInitParameter( "reportlogo.url" ) );
        }
        catch( MalformedURLException e )
        {
            throw new ServletException( "Invalid reportlogo.url: " + config.getInitParameter( "reportlogo.url" ), e );
        }

        m_connectionManager.setMaxConnectionsPerHost( 10 );
        m_connectionManager.setMaxTotalConnections( 10 );

        super.init( config );
    }

    public void destroy()
    {
        m_connectionManager.shutdown();

        super.destroy();
    }

    /**
     * @phoenix:dependency name="com.pace2020.appbox.services.datasource.DataSourceSelector"
     * @phoenix:dependency name="com.pace2020.appbox.services.reporting.ReportRepository"
     */
    public void service( final ServiceManager manager ) throws ServiceException
    {
        m_manager = manager;
        m_repository = (ReportRepository)manager.lookup( ReportRepository.class.getName() );
    }

    public void initialize() throws Exception
    {
        DataSourceSelector dss = null;

        try
        {
            dss = (DataSourceSelector)m_manager.lookup( DataSourceSelector.class.getName() );

            m_dataSource = dss.getDataSource( Constants.DATA_SOURCE_NAME );
        }
        finally
        {
            m_manager.release( dss );
        }
    }

    @SuppressWarnings("unchecked")
	public void checkProperties( final Engine engine, final Properties properties, final Object o )
        throws ReportException
    {
        final HttpServletRequest request = (HttpServletRequest)o;
        final List connections = new ArrayList();

        try
        {
            setConnection( engine, connections );
        }
        catch( ReportException e )
        {
            closeConnections( connections, request );
            throw e;
        }
        catch( RuntimeException e )
        {
            closeConnections( connections, request );
            throw e;
        }

// We are trusting CC to screw us here
//        request.setAttribute( "connections", connections );
        properties.put( "schema", "" );

        if( "true".equals( request.getParameter( "showlogo" ) ) )
        {
            replaceLogo( engine, new LogoLoader(), properties );
        }
        else
        {
            replaceLogo( engine, null, properties );
        }
    }

    public static void replaceLogo( final Engine engine, final LogoLoader logo, final Properties properties )
        throws ReportException
    {
        int areas = 0;
		try {
			areas = engine.getAreaCount();
		} catch (ReportException e) {
			e.printStackTrace();
		}

        for( int i = 0; i < areas; i++ )
        {
            replaceLogoInArea( engine.getArea( i ), logo, properties );
        }
    }

    private static void replaceLogoInArea( final Area area, final LogoLoader logo, final Properties properties )
        throws ReportException
    {
        if( null != area )
        {
            final int sections = area.getSectionCount();

            for( int i = 0; i < sections; i++ )
            {
                replaceLogoInSection( area.getSection( i ), logo, properties );
            }
        }
    }

    @SuppressWarnings("unchecked")
	private static void replaceLogoInSection( final Section section, final LogoLoader logo,
                                              final Properties properties ) throws ReportException
    {
        final Enumeration e = section.getElementsV().elements();

        while( e.hasMoreElements() )
        {
            final Element element = (Element)e.nextElement();

            if( element instanceof Picture )
            {
                final FormulaField toolTipsTextFormel = element.getToolTipsTextFormula();
                final String value = null == toolTipsTextFormel ? "" : toolTipsTextFormel.getFormula();
                final Matcher m = LOADKEY.matcher( value );

                if( "\"CompanyLogo\"".equals( value.trim() ) )
                {
                    final Picture picture = (Picture)element;

                    if( null != logo && null != logo.getLogo() )
                    {
                        final Picture newPicture = section.addPicture( picture.getX(),
                                                                       picture.getY(),
                                                                       picture.getWidth(),
                                                                       picture.getHeight(),
                                                                       logo.getLogo() );

                        newPicture.setSuppressFormula( picture.getSuppressFormula() );
                    }

                    section.remove( picture );
                }
                else if( m.matches() )
                {
                    final String param = m.group( 1 );
                    final String key = properties.getProperty( param );

                    final Picture picture = (Picture)element;

                    final boolean hasKey = null != key && !"".equals( key );

                    if( hasKey && null != logo )
                    {
                        final byte[] loaded = logo.getLogo( key );

                        if( null != loaded  )
                        {
                            final Picture newPicture = section.addPicture( picture.getX(),
                                                                           picture.getY(),
                                                                           picture.getWidth(),
                                                                           picture.getHeight(),
                                                                           loaded );

                            newPicture.setSuppressFormula( picture.getSuppressFormula() );
                        }
                    }

                    section.remove( picture );
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
	private void setConnection( final Engine engine, final List connections ) throws ReportException
    {
        try
        {
            final Connection connection = getConnection();
            engine.setConnection( connection );
            connections.add( connection );
        }
        catch( SQLException e )
        {
            try {
				throw new AppboxRuntimeException( "Unable to get connection" );
			} catch (AppboxRuntimeException e1) {
				e1.printStackTrace();
			}
        }

        setSubReports( engine, connections );
    }

    private Connection getConnection() throws SQLException
    {
        return ConnectionClosedOnceInvocationHandler.newInstance( m_dataSource.getConnection(), getLogger() );
    }

    @SuppressWarnings("unchecked")
	private void setSubReports( final Engine engine, final List connections ) throws ReportException
    {
        for( int i = 0; i < engine.getSubReportCount(); i++ )
        {
            setConnection( engine.getSubReport( i ), connections );
        }
    }

    public void afterPropertiesStoredHook( javax.servlet.http.HttpServletRequest httpServletRequest,
                                           javax.servlet.http.HttpServletResponse httpServletResponse,
                                           java.util.Properties properties )
        throws javax.servlet.ServletException, java.io.IOException
    {
        final String reportName = getReportName( httpServletRequest );

        final URL reportURL = m_repository.getURL( reportName );

		if( null == reportURL )
		{
		    throw new ServletException( "Unknown Report File" + reportName );
		}
		else
		{
		    properties.put( "report", reportURL.toExternalForm() );
		}

        super.afterPropertiesStoredHook( httpServletRequest, httpServletResponse, properties );
    }

    public void checkProperties( final Properties properties, final Object o ) throws ReportException
    {
        final HttpServletRequest request = (HttpServletRequest)o;
        final String reportName = getReportName( request );

        logParameters( request, reportName );

        if( getLogger().isDebugEnabled() ) getLogger().debug( "Using report name: " + reportName );
    }

    @SuppressWarnings("unchecked")
	private void logParameters( final HttpServletRequest request, final String fileName )
    {
        final Map parameters = request.getParameterMap();
        final Iterator i = parameters.entrySet().iterator();
        final StringBuffer buffer = new StringBuffer();

        buffer.append( "Executing" + fileName + " report using " + parameters.size() + " parameters." );

        while( i.hasNext() )
        {
            final Map.Entry entry = (Map.Entry)i.next();
            final String value = null != entry.getValue() ? (String)( (String[])( entry.getValue() ) )[0] : "";

            buffer.append( " " + entry.getKey() + " : " + value );
        }

        getLogger().info( buffer.toString() );
    }

    public static String getReportName( final HttpServletRequest request )
    {
        final String name = request.getRequestURI().substring( request.getContextPath().length() );
        final int i = name.indexOf( ";jsessionid" );

        if( 0 < i )
        {
            return name.substring( 0, i );
        }
        else
        {
            return name.replaceAll( "epace-internal-rpt", "rpt" );
        }
    }

    @SuppressWarnings("unchecked")
	public void service( final HttpServletRequest request, final HttpServletResponse response )
        throws ServletException, IOException
    {
        try
        {
            super.service( request, response );
        }
        finally
        {
            final List connections = (List)request.getAttribute( "connections" );

            if( null != connections )
            {
                closeConnections( connections, request );
            }
        }
    }

    public void checkHtmlPageProperties( final Properties properties )
    {
        final HttpServletResponse response = (HttpServletResponse)properties.remove( "appbox.response.key" );

        properties.put( "title", "report viewer" );
        properties.put( "cabbase", "/reports/crystalclear" + m_viewerPrefix + "/JavaClient.cab" );
        properties.put( "archive", "/reports/crystalclear" + m_viewerPrefix + "/JavaClient.jar" );
        properties.put( "codebase", "/reports/crystalclear" + m_viewerPrefix );
        properties.put( "hasgrouptree", "true" );

        String reportUrl = properties.getProperty( "report" );

        final String secure = properties.getProperty( "secure" );

        if( null != secure && "true".equals( secure ) )
        {
            final Pattern pattern = Pattern.compile( "http(.*)" );

            if( pattern.matcher( reportUrl ).matches() ) ;
            {
                reportUrl = reportUrl.replaceFirst( "http", "https" ).replaceFirst( "80", "443" );
            }
        }

        properties.put( "report", response.encodeURL( reportUrl ) );

        if( !properties.containsKey( "promptonrefresh" ) )
        {
            properties.put( "promptonrefresh", "true" );
        }
    }

    public void doWriteHtmlPage( final Properties properties,
                                 final HttpServletRequest request,
                                 final HttpServletResponse response ) throws Exception
    {
        properties.put( "appbox.response.key", response );

        super.doWriteHtmlPage( properties, request, response );
    }

    @SuppressWarnings("unchecked")
	private void closeConnections( final List connections, final HttpServletRequest request )
    {
        final Iterator i = connections.iterator();

        while( i.hasNext() )
        {
            final Connection connection = (Connection)i.next();
            final ConnectionClosedOnceInvocationHandler handler =
                ConnectionClosedOnceInvocationHandler.getHandler( connection );

            if( !handler.isClosed() )
            {
                try
                {
                    getLogger().warn( "Closing connection CC left open on report '"
                            + getReportName( request ) + "?" + request.getQueryString()
                            + "' - " + connection );

                    connection.close();
                }
                catch( SQLException e )
                {
                    getLogger().error( "Unexpected error closing connection", e );
                }
            }
        }
    }

    private class LogoLoader
    {
        private byte[] m_logo;
        private boolean m_loaded;

        byte[] getLogo()
        {
            if( !m_loaded )
            {
                m_logo = loadLogo( m_logoUrl );
                m_loaded = true;
            }

            return m_logo;
        }

        byte[] getLogo( final String key )
        {
            final URL url;

            try
            {
                url = new URL( m_reportLogoUrl.toExternalForm() + "/" + key );
            }
            catch( MalformedURLException e )
            {
                getLogger().error( "Unable to load print logo", e );
                return null;
            }
            return loadLogo( url );
        }

        private byte[] loadLogo( final URL location )
        {
            final GetMethod method = new GetMethod( location.toExternalForm() );

            try
            {

                final int response = m_client.executeMethod( method );

                if( HttpStatus.SC_OK == response )
                {
                    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream( 8096 );

                    IOUtil.copy( method.getResponseBodyAsStream(), outputStream );

                    return outputStream.toByteArray();
                }
                else
                {
                    getLogger()
                            .warn( "Attempt to load print logo returned " + response );

                    return null;
                }
            }
            catch( IOException e )
            {
                getLogger().error( "Unable to load print logo", e );

                return null;
            }
            finally
            {
                method.releaseConnection();
            }
        }
    }
}