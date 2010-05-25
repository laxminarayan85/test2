/*
 * An XML document type.
 * Localname: Category1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .Category1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one Category1(@) element.
 *
 * This is a complex type.
 */
public class Category1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .Category1Document
{
    private static final long serialVersionUID = 1L;
    
    public Category1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATEGORY1$0 = 
        new javax.xml.namespace.QName("", "Category1");
    
    
    /**
     * Gets the "Category1" element
     */
    public java.lang.String getCategory1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category1" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category1" element
     */
    public void setCategory1(java.lang.String category1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY1$0);
            }
            target.setStringValue(category1);
        }
    }
    
    /**
     * Sets (as xml) the "Category1" element
     */
    public void xsetCategory1(org.apache.xmlbeans.XmlString category1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY1$0);
            }
            target.set(category1);
        }
    }
}
