package com.efi.printsmith.reporting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
public class VersionSelectingCrystalClearViewerServlet extends HttpServlet
{
    protected void doGet( final HttpServletRequest req, final HttpServletResponse resp )
        throws ServletException, IOException
    {
        req.getRequestDispatcher( "/WEB-INF/CrystalClear" + req.getPathInfo() ).forward( req, resp );
    }
}