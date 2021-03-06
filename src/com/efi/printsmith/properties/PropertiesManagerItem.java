package com.efi.printsmith.properties;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;

/**
 * 
 * @version $Revision$ $Date$
**/
public class PropertiesManagerItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private JavaPropertySet _javaPropertySet;
    private XMLPropertySet _XMLPropertySet;

      //----------------/
     //- Constructors -/
    //----------------/

    public PropertiesManagerItem() {
        super();
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.PropertiesManagerItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public JavaPropertySet getJavaPropertySet()
    {
        return this._javaPropertySet;
    } //-- JavaPropertySet getJavaPropertySet() 

    /**
    **/
    public XMLPropertySet getXMLPropertySet()
    {
        return this._XMLPropertySet;
    } //-- XMLPropertySet getXMLPropertySet() 

    /**
     * 
     * @param javaPropertySet
    **/
    public void setJavaPropertySet(JavaPropertySet javaPropertySet)
    {
        this._javaPropertySet = javaPropertySet;
    } //-- void setJavaPropertySet(JavaPropertySet) 

    /**
     * 
     * @param XMLPropertySet
    **/
    public void setXMLPropertySet(XMLPropertySet XMLPropertySet)
    {
        this._XMLPropertySet = XMLPropertySet;
    } //-- void setXMLPropertySet(XMLPropertySet) 

}
