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

import java.io.Serializable;
import org.exolab.castor.xml.*;

/**
 * 
 * @version $Revision$ $Date$
**/
public class XMLPropertySetItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private XPathMapping _XPathMapping;


      //----------------/
     //- Constructors -/
    //----------------/

    public XMLPropertySetItem() {
        super();
    } //-- com.printcafe.common.xmlbinding.propertiesmanager.XMLPropertySetItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
    **/
    public XPathMapping getXPathMapping()
    {
        return this._XPathMapping;
    } //-- XPathMapping getXPathMapping() 

    /**
     * 
     * @param XPathMapping
    **/
    public void setXPathMapping(XPathMapping XPathMapping)
    {
        this._XPathMapping = XPathMapping;
    } //-- void setXPathMapping(XPathMapping) 

}
