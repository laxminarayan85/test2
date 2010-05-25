/*
 * An XML document type.
 * Localname: Category3
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .Category3Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one Category3(@) element.
 *
 * This is a complex type.
 */
public class Category3DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .Category3Document
{
    private static final long serialVersionUID = 1L;
    
    public Category3DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATEGORY3$0 = 
        new javax.xml.namespace.QName("", "Category3");
    
    
    /**
     * Gets the "Category3" element
     */
    public java.lang.String getCategory3()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY3$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category3" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory3()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY3$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category3" element
     */
    public void setCategory3(java.lang.String category3)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY3$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY3$0);
            }
            target.setStringValue(category3);
        }
    }
    
    /**
     * Sets (as xml) the "Category3" element
     */
    public void xsetCategory3(org.apache.xmlbeans.XmlString category3)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY3$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY3$0);
            }
            target.set(category3);
        }
    }
}
