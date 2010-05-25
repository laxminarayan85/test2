/*
 * An XML document type.
 * Localname: UOMCode..n
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UOMCodeNDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UOMCode..n(@) element.
 *
 * This is a complex type.
 */
public class UOMCodeNDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UOMCodeNDocument
{
    private static final long serialVersionUID = 1L;
    
    public UOMCodeNDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMCODEN$0 = 
        new javax.xml.namespace.QName("", "UOMCode..n");
    
    
    /**
     * Gets the "UOMCode..n" element
     */
    public java.lang.String getUOMCodeN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODEN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMCode..n" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMCodeN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODEN$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMCode..n" element
     */
    public void setUOMCodeN(java.lang.String uomCodeN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODEN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODEN$0);
            }
            target.setStringValue(uomCodeN);
        }
    }
    
    /**
     * Sets (as xml) the "UOMCode..n" element
     */
    public void xsetUOMCodeN(org.apache.xmlbeans.XmlString uomCodeN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODEN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODEN$0);
            }
            target.set(uomCodeN);
        }
    }
}
