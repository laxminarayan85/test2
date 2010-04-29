package com.efi.printsmith.reporting;

import javax.servlet.ServletException;

/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
public class StaticVersionCrystalClearViewerServlet extends AbstractCrystalClearViewerServlet
{
    public void init() throws ServletException
    {
        setVersion( getInitParameter( "version" ) );
    }
}