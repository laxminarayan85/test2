/*
 * An XML document type.
 * Localname: ManufacturerPartNumber
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.ManufacturerPartNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one ManufacturerPartNumber(@) element.
 *
 * This is a complex type.
 */
public class ManufacturerPartNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ManufacturerPartNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public ManufacturerPartNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MANUFACTURERPARTNUMBER$0 = 
        new javax.xml.namespace.QName("", "ManufacturerPartNumber");
    
    
    /**
     * Gets the "ManufacturerPartNumber" element
     */
    public java.lang.String getManufacturerPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURERPARTNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ManufacturerPartNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetManufacturerPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURERPARTNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ManufacturerPartNumber" element
     */
    public void setManufacturerPartNumber(java.lang.String manufacturerPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURERPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MANUFACTURERPARTNUMBER$0);
            }
            target.setStringValue(manufacturerPartNumber);
        }
    }
    
    /**
     * Sets (as xml) the "ManufacturerPartNumber" element
     */
    public void xsetManufacturerPartNumber(org.apache.xmlbeans.XmlString manufacturerPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURERPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MANUFACTURERPARTNUMBER$0);
            }
            target.set(manufacturerPartNumber);
        }
    }
}
