package com.efi.printsmith.reporting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.sql.DataSource;
import org.apache.log4j.Logger;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.inet.report.DatabaseField;
import com.inet.report.DatabaseTables;
import com.inet.report.Engine;
import com.inet.report.ReportException;

/**
 * @author <a href="mailto:jduval@pace2020.com">jerry duval</a>
 */
public class CrystalClearReportInspection
{
    private final DataSource m_dataSource;
    private final Engine m_engine;
    private final Logger m_logger;
    private boolean m_excludeUDFTables;
    private final String m_preparerTable;


    public CrystalClearReportInspection( DataSource dataSource, Engine engine, Logger logger, boolean excludeUDFTables,
                                         String preparerTable )
    {
        m_dataSource = dataSource;
        m_engine = engine;
        m_logger = logger;
        m_excludeUDFTables = excludeUDFTables;
        m_preparerTable = preparerTable;
    }

    private DataSource getDataSource()
    {
        return m_dataSource;
    }

    private Engine getEngine()
    {
        return m_engine;
    }

    private Logger getLogger()
    {
        return m_logger;
    }

    public String getPreparerTable()
    {
        return m_preparerTable;
    }

    private boolean isSkipTable( final String table )
    {
        return m_excludeUDFTables && ( table.toLowerCase().startsWith( "u_" ) || table.toLowerCase()
            .startsWith( "udo_" ) );
    }

    @SuppressWarnings("unchecked")
	public Document getInspectionResults() throws ReportException
    {
        Connection c = null;

        final Document document = DocumentHelper.createDocument();

        final Element root = document.addElement( "report" );

//        root.addAttribute( "file", (getEngine().getReportFile()).toExternalForm() );

        try
        {
            try
            {
                c = getDataSource().getConnection();

                final Map attributes = new HashMap();

                inspect( c, getEngine(), root, attributes );//check main report

                try {
					for( int i = 0; i < getEngine().getSubReportCount(); i++ )
					{
					    inspect( c, getEngine().getSubReport( i ), root, attributes );//check sub report
					}
				} catch (ReportException e) {
					e.printStackTrace();
				}

                final String preparer = getPreparerTable();

                if( null != preparer )
                {
                    if( !attributes.containsKey( preparer ) )
                    {
                        addElement( root,
                                    "warn",
                                    "The report is setup to utilize a data preparer, but the actual .rpt does not reference " + preparer );
                    }
                }

                addObjectsMap( attributes, root );
            }
            finally
            {
                if( null != c )
                {
                    c.close();
                }
            }
        }
        catch( SQLException e )
        {
            final String message = "Unable to inspect report due to sql execption.";

            getLogger().error( message, e );

            addElement( root, "warn", "Unable to inspect report due to sql execption" );
        }

        return document;
    }

    @SuppressWarnings("unchecked")
	private void addObjectsMap( final Map attributes, final Element root )
    {
        final Iterator i = attributes.entrySet().iterator();

        while( i.hasNext() )
        {
            final Map.Entry entry = (Map.Entry)i.next();

            final Element table = addElement( root, "object", null );

            table.addAttribute( "name", (String)entry.getKey() );

            addAttributes( (List)entry.getValue(), table );
        }
    }

    @SuppressWarnings("unchecked")
	private void addAttributes( final List attributes, final Element root )
    {
        final Iterator i = attributes.iterator();

        while( i.hasNext() )
        {
            final String attribute = (String)i.next();

            addElement( root, "attribute", attribute );
        }
    }

    private Element addElement( final Element root, final String attr, final Object value )
    {
        final Element element = root.addElement( attr.trim() );

        if( null != value )
        {
            element.setText( value.toString().trim() );
        }

        return element;
    }

    @SuppressWarnings("unchecked")
	private void inspect( final Connection connection, final Engine engine, final Element root, final Map attributes )
        throws SQLException, ReportException
    {
        final DatabaseTables dbTables = engine.getDatabaseTables();
        final String[] tables = dbTables.getSqlAliasNames();

        for( int i = 0; i < tables.length; i++ )
        {
            final String alias = tables[i];
            final String[] sources = split( dbTables.getSqlSourcesView()[i], ".", false );
            final String table;

            if( sources.length == 1 )
            {
                table = sources[0];
            }
            else
            {
                table = sources[1];
            }

            if( !isSkipTable( table ) )
            {
                if( doesTableExist( connection, table ) )
                {
                    final List attrs;

                    if( !attributes.containsKey( table ) )
                    {
                        attrs = new ArrayList();
                        attributes.put( table, attrs );
                    }
                    else
                    {
                        attrs = (List)attributes.get( table );
                    }

                    final String[] columns = dbTables.getColumnNames( alias );

                    inspect( connection, columns, alias, table, engine, root, attrs );

                }
                else
                {
                    final String message = "Report references database table " + table + ", but it does not exist.";

                    getLogger().warn( message );
                    addElement( root, "warn", message );
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
	private void inspect( final Connection connection, String[] columns, final String alias, final String table,
                          final Engine engine, final Element root, final List attrs )
        throws SQLException, ReportException
    {
        for( int i = 0; i < columns.length; i++ )
        {
            final String column = columns[i];
            final String translated = alias + "." + column;

            final DatabaseField field = (engine.getFields()).getDatabaseField( translated );

            if( null != field )
            {
                try
                {
                    final Method meth = field.getClass().getMethod( "getRealReferenceCount" );
                    final Integer result = (Integer)meth.invoke( field );

                    if( 0 < result.intValue() )
                    {
                        final String use = result.intValue() == 1 ? "use" : "usages";

                        if( !doesFieldExist( connection, table, column ) )
                        {
                            final String message =
                                "found " + result + " " + use + " for " + table + "." + column + " but it does not exist in database";

                            getLogger().warn( message );
                            addElement( root, "warn", message );
                        }
                        else
                        {
                            addElement( root, "info", "found " + result + " " + use + " for " + table + "." + column );

                            if( !attrs.contains( column ) )
                            {
                                attrs.add( column );
                            }
                        }
                    }
                }
                catch( NoSuchMethodException e )
                {
                    getLogger().error( "Unable to inspect, not such method", e );
                }
                catch( InvocationTargetException e )
                {
                    getLogger().error( "Unable to inspect, not such method", e );
                }
                catch( IllegalAccessException e )
                {
                    getLogger().error( "Unable to inspect, not such method", e );
                }
            }
        }
    }

    public static String[] split( final String s, final String delimiters, final boolean returnDelims )
    {
        final StringTokenizer st = new StringTokenizer( s, delimiters, returnDelims );
        final int tokenCount = st.countTokens();
        final String[] tokens = new String[tokenCount];

        for( int i = 0; i < tokenCount; i++ )
        {
            tokens[i] = ( (String)st.nextElement() );
        }

        return tokens;
    }

    private boolean doesTableExist
        (
            final Connection con,
            final String tableName ) throws SQLException
    {
        final ResultSet rs = con.getMetaData().getColumns( null, null, tableName.toLowerCase(), null );

        try
        {
            return rs.next();
        }
        finally
        {
            rs.close();
        }
    }

    private boolean doesFieldExist
        (
            final Connection con,
            final String tableName,
            final String fieldName )
        throws SQLException
    {
        final ResultSet rs =
            con.getMetaData().getColumns( null, null, tableName.toLowerCase(), fieldName.toLowerCase() );

        try
        {
            return rs.next();
        }
        finally
        {
            rs.close();
        }
    }
}