package com.efi.printsmith.reporting;

import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.collections.iterators.IteratorEnumeration;

/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
class CrystalClearServletConfig implements ServletConfig
{
    @SuppressWarnings("unchecked")
	private final Map m_parameters;
    private final ServletContext m_context;

    @SuppressWarnings("unchecked")
	public CrystalClearServletConfig( final ServletContext context, final Map parameters )
    {
        m_context = context;
        m_parameters = parameters;
    }

    public String getInitParameter( final String name )
    {
        return (String)m_parameters.get( name );
    }

    @SuppressWarnings("unchecked")
	public Enumeration getInitParameterNames()
    {
        return new IteratorEnumeration( m_parameters.keySet().iterator() );
    }

    public ServletContext getServletContext()
    {
        return m_context;
    }

    public String getServletName()
    {
        return "cc";
    }
}