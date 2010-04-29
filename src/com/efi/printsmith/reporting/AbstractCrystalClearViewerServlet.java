package com.efi.printsmith.reporting;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.efi.printsmith.service.DataService;

/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
public abstract class AbstractCrystalClearViewerServlet extends HttpServlet implements Servlet
{
	protected static Logger log = Logger.getLogger(DataService.class);
    private String m_version;

    protected void service( final HttpServletRequest req, final HttpServletResponse resp )
        throws ServletException, IOException
    {
        final String path = req.getServletPath();
        final String file = path.substring( path.lastIndexOf( '/' ) );
        final String resource = "/WEB-INF/CrystalClear/" + getVersion() + file;

        if( log.isDebugEnabled() ) log.debug( "Sending to '" + resource + "' for '" + path + "'" );

        req.getRequestDispatcher( resource ).forward( req, resp );
    }

    protected String getVersion()
    {
        return m_version;
    }

    protected void setVersion( final String version )
    {
        m_version = version;
    }
}