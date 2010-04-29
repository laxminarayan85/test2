package com.efi.printsmith.reporting;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.connection.ConnectionProviderFactory;

//import org.apache.avalon.framework.activity.Initializable;
//import org.apache.avalon.framework.context.Context;
//import org.apache.avalon.framework.context.ContextException;
//import org.apache.avalon.framework.context.Contextualizable;
//import org.apache.avalon.framework.logger.LogEnabled;
//import org.apache.avalon.framework.logger.Logger;
//import org.apache.avalon.framework.service.ServiceException;
//import org.apache.avalon.framework.service.ServiceManager;
//import org.apache.avalon.framework.service.Serviceable;

import com.inet.report.Engine;
import com.inet.report.ReportException;
import com.mchange.v2.c3p0.DataSources;

//import com.pace2020.appbox.Constants;
//import com.pace2020.appbox.services.datasource.DataSourceSelector;
//import com.pace2020.appbox.services.reporting.ReportRepository;
//import com.pace2020.appbox.util.LoggerAwareOutputStream;

/**
 * @author <a href="mailto:jduval@pace2020.com">jerry duval</a>
 */
public class CrystalClearInspectionServlet extends HttpServlet 
{
    private Logger log = Logger.getLogger(CrystalClearInspectionServlet.class);
    private File m_appHome;
    private DataSource m_dataSource;
//    private ReportRepository m_repository;

//    public void service() throws ServiceException
//    {
//        m_manager = manager;
//        m_repository = (ReportRepository)manager.lookup( ReportRepository.class.getName() );
//    }

    public void initialize() throws Exception
    {
    	Properties connectionProps = ConnectionProviderFactory.getConnectionProperties( null );
    	m_dataSource = DataSources.unpooledDataSource( "jdbc:postgresql://localhost/printsmith_db", connectionProps );
    }

    protected void doGet( final HttpServletRequest request, final HttpServletResponse response )
        throws ServletException, IOException
    {
        if( log.isDebugEnabled() )
        {
            final StringBuffer sb = new StringBuffer( 128 );

            sb.append( "Servlet Information:\n" );
            sb.append( "PathInfo: " ).append( request.getPathInfo() ).append( '\n' );
            sb.append( "ContextPath: " ).append( request.getContextPath() ).append( '\n' );
            sb.append( "RequestURI: " ).append( request.getRequestURI() ).append( '\n' );
            sb.append( "PathTranslated: " ).append( request.getPathTranslated() ).append( '\n' );

            log.debug( sb.toString() );
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
            log.error( "Unable to inspect report due to error:", e );
            writer.print( "Unable to inspect report due to error:" + e.getMessage() );
        }
        writer.flush();
    }

    private CrystalClearReportInspection getCrystalClearReportInspection( final HttpServletRequest request )
        throws ServletException, ReportException
    {
        final Engine engine = new Engine();

        engine.setReportFile( request.getParameter( "report" ) );

        return new CrystalClearReportInspection( m_dataSource,
                                                 engine,
                                                 null != request.getParameter( "excludeudf" ),
                                                 request.getParameter( "preparetable" ) );
    }

    public void init( final ServletConfig config ) throws ServletException
    {
        final File properties = new File( m_appHome, config.getInitParameter( CrystalClearServlet.CCPROPS_LOCATION ) );

        if( log.isDebugEnabled() )
            log.debug( "Properties location: " + properties );

        try
        {
            Engine.setPath( properties.toURL() );
        }
        catch( IOException e )
        {
            final String msg = "Unable to set engine properties path. " + e.getMessage();
            throw new ServletException( msg, e );
        }

        super.init( config );
    }
}