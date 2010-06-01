/*
 * An XML document type.
 * Localname: CatalogAttributeValue1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.CatalogAttributeValue1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one CatalogAttributeValue1(@) element.
 *
 * This is a complex type.
 */
public class CatalogAttributeValue1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.CatalogAttributeValue1Document
{
    private static final long serialVersionUID = 1L;
    
    public CatalogAttributeValue1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATALOGATTRIBUTEVALUE1$0 = 
        new javax.xml.namespace.QName("", "CatalogAttributeValue1");
    
    
    /**
     * Gets the "CatalogAttributeValue1" element
     */
    public java.lang.String getCatalogAttributeValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CatalogAttributeValue1" element
     */
    public org.apache.xmlbeans.XmlString xgetCatalogAttributeValue1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CatalogAttributeValue1" element
     */
    public void setCatalogAttributeValue1(java.lang.String catalogAttributeValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATALOGATTRIBUTEVALUE1$0);
            }
            target.setStringValue(catalogAttributeValue1);
        }
    }
    
    /**
     * Sets (as xml) the "CatalogAttributeValue1" element
     */
    public void xsetCatalogAttributeValue1(org.apache.xmlbeans.XmlString catalogAttributeValue1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATALOGATTRIBUTEVALUE1$0);
            }
            target.set(catalogAttributeValue1);
        }
    }
}
