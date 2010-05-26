/*
 * An XML document type.
 * Localname: Category4
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.Category4Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one Category4(@) element.
 *
 * This is a complex type.
 */
public class Category4DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.Category4Document
{
    private static final long serialVersionUID = 1L;
    
    public Category4DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATEGORY4$0 = 
        new javax.xml.namespace.QName("", "Category4");
    
    
    /**
     * Gets the "Category4" element
     */
    public java.lang.String getCategory4()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY4$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category4" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory4()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY4$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category4" element
     */
    public void setCategory4(java.lang.String category4)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY4$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY4$0);
            }
            target.setStringValue(category4);
        }
    }
    
    /**
     * Sets (as xml) the "Category4" element
     */
    public void xsetCategory4(org.apache.xmlbeans.XmlString category4)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY4$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY4$0);
            }
            target.set(category4);
        }
    }
}
