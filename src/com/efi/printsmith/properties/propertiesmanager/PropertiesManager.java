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
public class PropertiesManager implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _saveFilename;

    private boolean _flushToSystem = true;

    /**
     * keeps track of state for field: _flushToSystem
    **/
    private boolean _has_flushToSystem;

    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public PropertiesManager() {
        super();
        _items = new Vector();
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManager()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * @param vPropertiesManagerItem
    **/
    public void addPropertiesManagerItem(PropertiesManagerItem vPropertiesManagerItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vPropertiesManagerItem);
    } //-- void addPropertiesManagerItem(com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem) 

    /**
     * 
     * @param index
     * @param vPropertiesManagerItem
    **/
    public void addPropertiesManagerItem(int index, PropertiesManagerItem vPropertiesManagerItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vPropertiesManagerItem, index);
    } //-- void addPropertiesManagerItem(int, com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem) 

    /**
    **/
    public void deleteFlushToSystem()
    {
        this._has_flushToSystem= false;
    } //-- void deleteFlushToSystem() 

    /**
    **/
    public java.util.Enumeration enumeratePropertiesManagerItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumeratePropertiesManagerItem() 

    /**
    **/
    public boolean getFlushToSystem()
    {
        return this._flushToSystem;
    } //-- boolean getFlushToSystem() 

    /**
     * 
     * @param index
    **/
    public PropertiesManagerItem getPropertiesManagerItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (PropertiesManagerItem) _items.elementAt(index);
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem getPropertiesManagerItem(int) 

    /**
    **/
    public PropertiesManagerItem[] getPropertiesManagerItem()
    {
        int size = _items.size();
        PropertiesManagerItem[] mArray = new PropertiesManagerItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (PropertiesManagerItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem[] getPropertiesManagerItem() 

    /**
    **/
    public int getPropertiesManagerItemCount()
    {
        return _items.size();
    } //-- int getPropertiesManagerItemCount() 

    /**
    **/
    public java.lang.String getSaveFilename()
    {
        return this._saveFilename;
    } //-- java.lang.String getSaveFilename() 

    /**
    **/
    public boolean hasFlushToSystem()
    {
        return this._has_flushToSystem;
    } //-- boolean hasFlushToSystem() 

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
    public void removeAllPropertiesManagerItem()
    {
        _items.removeAllElements();
    } //-- void removeAllPropertiesManagerItem() 

    /**
     * 
     * @param index
    **/
    public PropertiesManagerItem removePropertiesManagerItem(int index)
    {
        Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (PropertiesManagerItem) obj;
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem removePropertiesManagerItem(int) 

    /**
     * 
     * @param flushToSystem
    **/
    public void setFlushToSystem(boolean flushToSystem)
    {
        this._flushToSystem = flushToSystem;
        this._has_flushToSystem = true;
    } //-- void setFlushToSystem(boolean) 

    /**
     * 
     * @param index
     * @param vPropertiesManagerItem
    **/
    public void setPropertiesManagerItem(int index, PropertiesManagerItem vPropertiesManagerItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vPropertiesManagerItem, index);
    } //-- void setPropertiesManagerItem(int, com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem) 

    /**
     * 
     * @param propertiesManagerItemArray
    **/
    public void setPropertiesManagerItem(PropertiesManagerItem[] propertiesManagerItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < propertiesManagerItemArray.length; i++) {
            _items.addElement(propertiesManagerItemArray[i]);
        }
    } //-- void setPropertiesManagerItem(com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem) 

    /**
     * 
     * @param saveFilename
    **/
    public void setSaveFilename(java.lang.String saveFilename)
    {
        this._saveFilename = saveFilename;
    } //-- void setSaveFilename(java.lang.String) 

    /**
     * 
     * @param reader
    **/
    public static PropertiesManager unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (PropertiesManager) Unmarshaller.unmarshal(PropertiesManager.class, reader);
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManager unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
