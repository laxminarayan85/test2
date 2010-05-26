/*
 * An XML document type.
 * Localname: UOMDescription1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.UOMDescription1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one UOMDescription1(@) element.
 *
 * This is a complex type.
 */
public class UOMDescription1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.UOMDescription1Document
{
    private static final long serialVersionUID = 1L;
    
    public UOMDescription1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMDESCRIPTION1$0 = 
        new javax.xml.namespace.QName("", "UOMDescription1");
    
    
    /**
     * Gets the "UOMDescription1" element
     */
    public java.lang.String getUOMDescription1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMDescription1" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMDescription1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMDescription1" element
     */
    public void setUOMDescription1(java.lang.String uomDescription1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTION1$0);
            }
            target.setStringValue(uomDescription1);
        }
    }
    
    /**
     * Sets (as xml) the "UOMDescription1" element
     */
    public void xsetUOMDescription1(org.apache.xmlbeans.XmlString uomDescription1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTION1$0);
            }
            target.set(uomDescription1);
        }
    }
}
