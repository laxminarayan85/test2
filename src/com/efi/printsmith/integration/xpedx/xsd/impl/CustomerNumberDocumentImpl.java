/*
 * An XML document type.
 * Localname: CustomerNumber
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .CustomerNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one CustomerNumber(@) element.
 *
 * This is a complex type.
 */
public class CustomerNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .CustomerNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public CustomerNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CUSTOMERNUMBER$0 = 
        new javax.xml.namespace.QName("", "CustomerNumber");
    
    
    /**
     * Gets the "CustomerNumber" element
     */
    public java.lang.String getCustomerNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "CustomerNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetCustomerNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "CustomerNumber" element
     */
    public void setCustomerNumber(java.lang.String customerNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CUSTOMERNUMBER$0);
            }
            target.setStringValue(customerNumber);
        }
    }
    
    /**
     * Sets (as xml) the "CustomerNumber" element
     */
    public void xsetCustomerNumber(org.apache.xmlbeans.XmlString customerNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CUSTOMERNUMBER$0);
            }
            target.set(customerNumber);
        }
    }
}
