/*
 * An XML document type.
 * Localname: Manufacturer
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .ManufacturerDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one Manufacturer(@) element.
 *
 * This is a complex type.
 */
public class ManufacturerDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .ManufacturerDocument
{
    private static final long serialVersionUID = 1L;
    
    public ManufacturerDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MANUFACTURER$0 = 
        new javax.xml.namespace.QName("", "Manufacturer");
    
    
    /**
     * Gets the "Manufacturer" element
     */
    public java.lang.String getManufacturer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Manufacturer" element
     */
    public org.apache.xmlbeans.XmlString xgetManufacturer()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Manufacturer" element
     */
    public void setManufacturer(java.lang.String manufacturer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MANUFACTURER$0);
            }
            target.setStringValue(manufacturer);
        }
    }
    
    /**
     * Sets (as xml) the "Manufacturer" element
     */
    public void xsetManufacturer(org.apache.xmlbeans.XmlString manufacturer)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MANUFACTURER$0);
            }
            target.set(manufacturer);
        }
    }
}
