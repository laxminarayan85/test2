/*
 * An XML document type.
 * Localname: CustomerPartNumber
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .CustomerPartNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one CustomerPartNumber(@) element.
 *
 * This is a complex type.
 */
public class CustomerPartNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .CustomerPartNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public CustomerPartNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CUSTOMERPARTNUMBER$0 = 
        new javax.xml.namespace.QName("", "CustomerPartNumber");
    
    
    /**
     * Gets the "CustomerPartNumber" element
     */
    public java.lang.String getCustomerPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERPARTNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CustomerPartNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetCustomerPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERPARTNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CustomerPartNumber" element
     */
    public void setCustomerPartNumber(java.lang.String customerPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CUSTOMERPARTNUMBER$0);
            }
            target.setStringValue(customerPartNumber);
        }
    }
    
    /**
     * Sets (as xml) the "CustomerPartNumber" element
     */
    public void xsetCustomerPartNumber(org.apache.xmlbeans.XmlString customerPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CUSTOMERPARTNUMBER$0);
            }
            target.set(customerPartNumber);
        }
    }
}
