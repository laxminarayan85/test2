/*
 * An XML document type.
 * Localname: CatalogAttributeName1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.CatalogAttributeName1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one CatalogAttributeName1(@) element.
 *
 * This is a complex type.
 */
public class CatalogAttributeName1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.CatalogAttributeName1Document
{
    private static final long serialVersionUID = 1L;
    
    public CatalogAttributeName1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATALOGATTRIBUTENAME1$0 = 
        new javax.xml.namespace.QName("", "CatalogAttributeName1");
    
    
    /**
     * Gets the "CatalogAttributeName1" element
     */
    public java.lang.String getCatalogAttributeName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTENAME1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CatalogAttributeName1" element
     */
    public org.apache.xmlbeans.XmlString xgetCatalogAttributeName1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTENAME1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CatalogAttributeName1" element
     */
    public void setCatalogAttributeName1(java.lang.String catalogAttributeName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTENAME1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATALOGATTRIBUTENAME1$0);
            }
            target.setStringValue(catalogAttributeName1);
        }
    }
    
    /**
     * Sets (as xml) the "CatalogAttributeName1" element
     */
    public void xsetCatalogAttributeName1(org.apache.xmlbeans.XmlString catalogAttributeName1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTENAME1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATALOGATTRIBUTENAME1$0);
            }
            target.set(catalogAttributeName1);
        }
    }
}
