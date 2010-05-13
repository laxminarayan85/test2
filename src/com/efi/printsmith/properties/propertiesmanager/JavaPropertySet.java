/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id$
 */

package com.efi.printsmith.properties.propertiesmanager;

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

public class JavaPropertySet implements java.io.Serializable {
    private java.lang.String _name;
    private java.lang.String _propertiesFilename;
    private boolean _quiet = false;

    /**
     * keeps track of state for field: _quiet
    **/
    private boolean _has_quiet;

    private java.lang.String _resourceName;

    public JavaPropertySet() {
        super();
    }
 

    public void deleteQuiet()
    {
        this._has_quiet= false;
    } 
  
    public java.lang.String getName()
    {
        return this._name;
    }

    public java.lang.String getPropertiesFilename()
    {
        return this._propertiesFilename;
    }

    public boolean getQuiet()
    {
        return this._quiet;
    }
    
    public java.lang.String getResourceName()
    {
        return this._resourceName;
    }

    public boolean hasQuiet()
    {
        return this._has_quiet;
    }
    
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param out
    **/
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.DocumentHandler handler)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    }

    /**
     * 
     * @param name
    **/
    public void setName(java.lang.String name)
    {
        this._name = name;
    }

    /**
     * 
     * @param propertiesFilename
    **/
    public void setPropertiesFilename(java.lang.String propertiesFilename)
    {
        this._propertiesFilename = propertiesFilename;
    }

    /**
     * 
     * @param quiet
    **/
    public void setQuiet(boolean quiet)
    {
        this._quiet = quiet;
        this._has_quiet = true;
    }

    /**
     * 
     * @param resourceName
    **/
    public void setResourceName(java.lang.String resourceName)
    {
        this._resourceName = resourceName;
    }

    /**
     * 
     * @param reader
    **/
    public static JavaPropertySet unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (JavaPropertySet) Unmarshaller.unmarshal(JavaPropertySet.class, reader);
    }
    
    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
