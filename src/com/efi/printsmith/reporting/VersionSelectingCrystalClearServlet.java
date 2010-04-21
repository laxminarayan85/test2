package com.efi.printsmith.reporting;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/**
 * @author <a href="mailto:proyal@pace2020.com">peter royal</a>
 */
public class VersionSelectingCrystalClearServlet extends HttpServlet
    implements Serviceable, Contextualizable, Servlet, LogEnabled
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Pattern NAME = Pattern.compile( "^properties\\.location\\.(.*)$" );
    private static final String SERVLET_NAME = "com.pace2020.epace.web.crystalclear.CrystalClearServlet";
    private static final String INSPECTION_SERVLET_NAME =
        "com.pace2020.epace.web.crystalclear.CrystalClearInspectionServlet";

    private static final String CC_VERSION_4_2 = "4.2";
    private static final String CC_VERSION_6_5 = "6.5";

    private Logger m_logger;
    private Context m_context;
    private File m_appHome;
    private ServiceManager m_manager;

    @SuppressWarnings("unchecked")
	private Map m_servlets;
    private String m_defaultVersion;
    private String m_inspectionVersion;

    public void enableLogging( final Logger logger )
    {
        m_logger = logger;
    }

    private Logger getLogger()
    {
        return m_logger;
    }

    public void contextualize( final Context context ) throws ContextException
    {
        m_context = context;
        m_appHome = (File)context.get( "app.home" );
    }

    public void service( final ServiceManager manager ) throws ServiceException
    {
        m_manager = manager;
    }

    public void init() throws ServletException
    {
        m_inspectionVersion = getServletConfig().getInitParameter( "inspection.version" );
        m_servlets = createServlets( getServletConfig() );
        m_defaultVersion = getServletConfig().getInitParameter( "default.version" );

        if( m_servlets.isEmpty() )
        {
            throw new ServletException( "No versions specified" );
        }
        else if( null == m_defaultVersion )
        {
            throw new ServletException( "No default version specified in default.version" );
        }
        else if( null == m_inspectionVersion )
        {
            throw new ServletException( "No inspection version specified in inspection.version" );
        }
        else if( !m_servlets.containsKey( "inspection" ) )
        {
            throw new ServletException( "No inspection version of '" + m_inspectionVersion + "' is not a configured version" );
        }
        else if( !m_servlets.containsKey( m_defaultVersion ) )
        {
            throw new ServletException( "No default version of '" + m_defaultVersion + "' is not a configured version" );
        }
    }

    @SuppressWarnings("unchecked")
	private Map createServlets( final ServletConfig config ) throws ServletException
    {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final URL epaceCrystalClearURL = createEPaceCrystalClearURL();
        final Map servlets = new HashMap();
        final Enumeration e = config.getInitParameterNames();

        while( e.hasMoreElements() )
        {
            final String name = (String)e.nextElement();
            final Matcher m = NAME.matcher( name );

            if( m.matches() )
            {
                final String version = m.group( 1 );

                try
                {
                    servlets.put( version, createCrystalClearServlet( version, loader, epaceCrystalClearURL, SERVLET_NAME ) );
                }
                catch( Exception e1 )
                {
                    throw new RuntimeException( "Unable to create CC " + version + " servlet", e1 );
                }

                if( getLogger().isInfoEnabled() ) getLogger().info( "Created CC " + version + " servlet" );
            }

        }

        try
        {
            servlets.put( "inspection",
                          createCrystalClearServlet( m_inspectionVersion, loader, epaceCrystalClearURL, INSPECTION_SERVLET_NAME ) );
        }
        catch( Exception e1 )
        {
            throw new RuntimeException( "Unable to create CC " + m_inspectionVersion + " inspection servlet", e1 );
        }
        if( getLogger().isInfoEnabled() )
            getLogger().info( "Created CC " + m_inspectionVersion + " inspection servlet" );

        return servlets;
    }

    @SuppressWarnings("unchecked")
	private HttpServlet createCrystalClearServlet( final String version,
                                                   final ClassLoader parent,
                                                   final URL epaceCrystalClearURL,
                                                   final String clazz)
        throws Exception
    {
        final ClassLoader loader;

        if (version.equals(CC_VERSION_4_2) || version.equals( CC_VERSION_6_5 )) {
         loader=
            new URLClassLoader(
                new URL[]{createCrystalClearJarURL( version, "CrystalClear.jar" ),
                          createCrystalClearJarURL( version, "JavaClient.jar" ) ,
                          epaceCrystalClearURL
                },
                parent );
        } else {
            loader=
               new URLClassLoader(
                   new URL[]{createCrystalClearJarURL( version, "CrystalClear.jar" ),
                             createCrystalClearJarURL( version, "JavaClient.jar" ) ,
                             epaceCrystalClearURL ,
                             getJarURL("jcommon.jar", "SAR-INF/CrystalClear/jcommon.jar") ,
                             getJarURL("jfreechartCC.jar", "SAR-INF/CrystalClear/jfreechartCC.jar")  ,
                             getJarURL( "jcommon.jar", "SAR-INF/CrystalClear/milton-api-1.4.jar" ),
                            getJarURL( "jcommon.jar", "SAR-INF/CrystalClear/milton-servlet-1.4.jar" ),
                            getJarURL( "jcommon.jar", "SAR-INF/CrystalClear/mime-util.jar" ),
                            getJarURL( "jcommon.jar", "SAR-INF/CrystalClear/slf4j-api-1.5.6.jar" ),
                            getJarURL( "jcommon.jar", "SAR-INF/CrystalClear/slf4j-simple-1.5.6.jar" ),

                   },
                   parent );

        }

        if( getLogger().isDebugEnabled() ) getLogger().debug( "Created version ClassLoader" );

        final Class servletClass = loader.loadClass( clazz );

        if( getLogger().isDebugEnabled() ) getLogger().debug( "Loaded servlet" );

        final HttpServlet servlet = (HttpServlet)servletClass.newInstance();

        if( getLogger().isDebugEnabled() ) getLogger().debug( "Instantiated servlet" );

        ContainerUtil.enableLogging( servlet, getLogger() );
        ContainerUtil.contextualize( servlet, m_context );
        ContainerUtil.service( servlet, m_manager );
        ContainerUtil.initialize( servlet );

        servlet.init( createServletConfig( version ) );

        return servlet;
    }

    @SuppressWarnings("unchecked")
	private ServletConfig createServletConfig( final String version )
    {
        final Map parameters = new HashMap();

        parameters.put( "viewer.prefix", "/" + version );
        parameters.put( "logo.url", getServletConfig().getInitParameter( "logo.url" ) );
        parameters.put( "reportlogo.url", getServletConfig().getInitParameter( "reportlogo.url" ) );
        parameters.put( CrystalClearServlet.CCPROPS_LOCATION,
                        getServletConfig().getInitParameter( CrystalClearServlet.CCPROPS_LOCATION + "." + version ) );

        return new CrystalClearServletConfig( getServletContext(), parameters );
    }

    private URL createEPaceCrystalClearURL() throws ServletException
    {
        final String jarName = "epace-crystal-clear-" + Version.SHORT_VERSION + ".jar";
        return getJarURL( jarName, "SAR-INF/CrystalClear/" + jarName );
    }

    private URL createCrystalClearJarURL( final String version, final String jarName ) throws Exception
    {
        return getJarURL( jarName, "SAR-INF/CrystalClear/" + version + "/" + jarName );
    }



    @SuppressWarnings("deprecation")
	private URL getJarURL( final String jarName, final String location )
        throws ServletException
    {
        final File file = new File( m_appHome, location );

        if( file.exists() )
        {
            try
            {
                final URL resource = file.toURL();

                getLogger().debug( "Using " + jarName + " from " + resource );

                return resource;
            }
            catch( MalformedURLException e )
            {
                throw new ServletException( e );
            }
        }
        else
        {
            throw new ServletException( "Unable to load " + jarName + " from " + location );
        }
    }

    public void destroy()
    {
        destroyCrystalClearServlets();
    }

    @SuppressWarnings("unchecked")
	private void destroyCrystalClearServlets()
    {
        if( null != m_servlets )
        {
            final Iterator i = m_servlets.values().iterator();

            while( i.hasNext() )
            {
                ( (Servlet)i.next() ).destroy();
            }
        }
    }

    public void service( final ServletRequest req, final ServletResponse res ) throws ServletException, IOException
    {
        final String version = req.getParameter( "version" );
        final String inspect = req.getParameter( "inspect" );

        Servlet servlet;

        if( null != inspect )
        {
            servlet = (Servlet)m_servlets.get( "inspection" );
        }
        else
        {
            servlet = (Servlet)m_servlets.get( version );
        }

        if( null == servlet )
        {
            getLogger().warn( "Invalid CC version '" + version + "' specified in request for "
                    + ( (HttpServletRequest)req ).getRequestURI() );

            servlet = (Servlet)m_servlets.get( m_defaultVersion );
        }

        final long start = System.currentTimeMillis();

        servlet.service( req, res );

        if( getLogger().isDebugEnabled() )
            getLogger().debug( "Processed in " + ( System.currentTimeMillis() - start ) + "ms" );
    }
}