/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.3</a>, using an
 * XML Schema.
 * $Id$
 */

package com.efi.printsmith.properties.propertiesmanager;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.DocumentHandler;

/**
 * 
 * @version $Revision$ $Date$
**/
public class XMLPropertySet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _name;

    private java.lang.String _xmlFilename;

    private java.lang.String _resourceName;

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public XMLPropertySet() {
        super();
        _items = new Vector();
    } //-- XMLPropertySet()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vXMLPropertySetItem
    **/
    public void addXMLPropertySetItem(XMLPropertySetItem vXMLPropertySetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vXMLPropertySetItem);
    } //-- void addXMLPropertySetItem(XMLPropertySetItem) 

    /**
     * 
     * @param index
     * @param vXMLPropertySetItem
    **/
    public void addXMLPropertySetItem(int index, XMLPropertySetItem vXMLPropertySetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vXMLPropertySetItem, index);
    } //-- void addXMLPropertySetItem(int, XMLPropertySetItem) 

    /**
    **/
    public java.util.Enumeration enumerateXMLPropertySetItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateXMLPropertySetItem() 

    /**
    **/
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
    **/
    public java.lang.String getResourceName()
    {
        return this._resourceName;
    } //-- java.lang.String getResourceName() 

    /**
     * 
     * @param index
    **/
    public XMLPropertySetItem getXMLPropertySetItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (XMLPropertySetItem) _items.elementAt(index);
    } //-- XMLPropertySetItem getXMLPropertySetItem(int) 

    /**
    **/
    public XMLPropertySetItem[] getXMLPropertySetItem()
    {
        int size = _items.size();
        XMLPropertySetItem[] mArray = new XMLPropertySetItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (XMLPropertySetItem) _items.elementAt(index);
        }
        return mArray;
    } //-- XMLPropertySetItem[] getXMLPropertySetItem() 

    /**
    **/
    public int getXMLPropertySetItemCount()
    {
        return _items.size();
    } //-- int getXMLPropertySetItemCount() 

    /**
    **/
    public java.lang.String getXmlFilename()
    {
        return this._xmlFilename;
    } //-- java.lang.String getXmlFilename() 

    /**
    **/
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * @param out
    **/
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.DocumentHandler handler)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.DocumentHandler) 

    /**
    **/
    public void removeAllXMLPropertySetItem()
    {
        _items.removeAllElements();
    } //-- void removeAllXMLPropertySetItem() 

    /**
     * 
     * @param index
    **/
    public XMLPropertySetItem removeXMLPropertySetItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (XMLPropertySetItem) obj;
    } //-- XMLPropertySetItem removeXMLPropertySetItem(int) 

    /**
     * 
     * @param name
    **/
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * 
     * @param resourceName
    **/
    public void setResourceName(java.lang.String resourceName)
    {
        this._resourceName = resourceName;
    } //-- void setResourceName(java.lang.String) 

    /**
     * 
     * @param index
     * @param vXMLPropertySetItem
    **/
    public void setXMLPropertySetItem(int index, XMLPropertySetItem vXMLPropertySetItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vXMLPropertySetItem, index);
    } //-- void setXMLPropertySetItem(int, XMLPropertySetItem) 

    /**
     * 
     * @param XMLPropertySetItemArray
    **/
    public void setXMLPropertySetItem(XMLPropertySetItem[] XMLPropertySetItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < XMLPropertySetItemArray.length; i++) {
            _items.addElement(XMLPropertySetItemArray[i]);
        }
    } //-- void setXMLPropertySetItem(XMLPropertySetItem) 

    /**
     * 
     * @param xmlFilename
    **/
    public void setXmlFilename(java.lang.String xmlFilename)
    {
        this._xmlFilename = xmlFilename;
    } //-- void setXmlFilename(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static XMLPropertySet unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (XMLPropertySet) Unmarshaller.unmarshal(XMLPropertySet.class, reader);
    } //-- XMLPropertySet unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
