/*
 * An XML document type.
 * Localname: Category2
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.Category2Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one Category2(@) element.
 *
 * This is a complex type.
 */
public class Category2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.Category2Document
{
    private static final long serialVersionUID = 1L;
    
    public Category2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CATEGORY2$0 = 
        new javax.xml.namespace.QName("", "Category2");
    
    
    /**
     * Gets the "Category2" element
     */
    public java.lang.String getCategory2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Category2" element
     */
    public org.apache.xmlbeans.XmlString xgetCategory2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Category2" element
     */
    public void setCategory2(java.lang.String category2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY2$0);
            }
            target.setStringValue(category2);
        }
    }
    
    /**
     * Sets (as xml) the "Category2" element
     */
    public void xsetCategory2(org.apache.xmlbeans.XmlString category2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY2$0);
            }
            target.set(category2);
        }
    }
}
