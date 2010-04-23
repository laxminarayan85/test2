package com.efi.printsmith.reporting;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

import com.inet.report.Engine;
import com.inet.report.ReportException;

/**
 * @author <a href="mailto:jduval@pace2020.com">jerry duval</a>
 */
public class CrystalClearInspectionServlet extends HttpServlet implements LogEnabled,
    Contextualizable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Logger log = Logger.getLogger(CrystalClearInspectionServlet.class);
    private File m_appHome;
    private ServiceManager m_manager;
    private DataSource m_dataSource;
    @SuppressWarnings("unused")
	private ReportRepository m_repository;
	private Logger m_logger;

    public void contextualize( final Context context )
        throws ContextException
    {
        m_appHome = (File)context.get( "app.home" );
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

    public void enableLogging( final Logger logger )
    {
        m_logger = logger;
    }

    private Logger getLogger()
    {
        return m_logger;
    }

    protected void doGet( final HttpServletRequest request, final HttpServletResponse response )
        throws ServletException, IOException
    {
        if( getLogger().isDebugEnabled() )
        {
            final StringBuffer sb = new StringBuffer( 128 );

            sb.append( "Servlet Information:\n" );
            sb.append( "PathInfo: " ).append( request.getPathInfo() ).append( '\n' );
            sb.append( "ContextPath: " ).append( request.getContextPath() ).append( '\n' );
            sb.append( "RequestURI: " ).append( request.getRequestURI() ).append( '\n' );
            sb.append( "PathTranslated: " ).append( request.getPathTranslated() ).append( '\n' );

            getLogger().debug( sb.toString() );
        }

        response.setStatus( HttpServletResponse.SC_OK );
        response.setContentType( "application/xml; charset=UTF-8" );

        final PrintWriter writer = response.getWriter();

        try
        {
            writer.print( getCrystalClearReportInspection( request ).getInspectionResults().asXML() );
        }
        catch( ReportException e )
        {
            getLogger().error( "Unable to inspect report due to error:", e );
            writer.print( "Unable to inspect report due to error:" + e.getMessage() );
        }
        writer.flush();
    }

    private CrystalClearReportInspection getCrystalClearReportInspection( final HttpServletRequest request )
        throws ServletException, ReportException
    {
        final Engine engine = new Engine();

        try {
			engine.setReportFile( request.getParameter( "report" ) );
		} catch (ReportException e) {
			e.printStackTrace();
		}

        return new CrystalClearReportInspection( m_dataSource,
                                                 engine,
                                                 log,
                                                 null != request.getParameter( "excludeudf" ),
                                                 request.getParameter( "preparetable" ) );
    }

    @SuppressWarnings("deprecation")
	public void init( final ServletConfig config ) throws ServletException
    {
        final File properties = new File( m_appHome, config.getInitParameter( CrystalClearServlet.CCPROPS_LOCATION ) );

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

        getLogger();
		Engine.setLogStream( new PrintStream( new LoggerAwareOutputStream( Logger.getLogger( "engine" ) )
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

        super.init( config );
    }
}