/*
 * An XML document type.
 * Localname: UOMCode1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UOMCode1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UOMCode1(@) element.
 *
 * This is a complex type.
 */
public class UOMCode1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UOMCode1Document
{
    private static final long serialVersionUID = 1L;
    
    public UOMCode1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMCODE1$0 = 
        new javax.xml.namespace.QName("", "UOMCode1");
    
    
    /**
     * Gets the "UOMCode1" element
     */
    public java.lang.String getUOMCode1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMCode1" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMCode1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMCode1" element
     */
    public void setUOMCode1(java.lang.String uomCode1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODE1$0);
            }
            target.setStringValue(uomCode1);
        }
    }
    
    /**
     * Sets (as xml) the "UOMCode1" element
     */
    public void xsetUOMCode1(org.apache.xmlbeans.XmlString uomCode1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODE1$0);
            }
            target.set(uomCode1);
        }
    }
}
