/*
 * An XML document type.
 * Localname: AvailabilityMessage
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.AvailabilityMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one AvailabilityMessage(@) element.
 *
 * This is a complex type.
 */
public class AvailabilityMessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.AvailabilityMessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public AvailabilityMessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AVAILABILITYMESSAGE$0 = 
        new javax.xml.namespace.QName("", "AvailabilityMessage");
    
    
    /**
     * Gets the "AvailabilityMessage" element
     */
    public java.lang.String getAvailabilityMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYMESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "AvailabilityMessage" element
     */
    public org.apache.xmlbeans.XmlString xgetAvailabilityMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYMESSAGE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "AvailabilityMessage" element
     */
    public void setAvailabilityMessage(java.lang.String availabilityMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYMESSAGE$0);
            }
            target.setStringValue(availabilityMessage);
        }
    }
    
    /**
     * Sets (as xml) the "AvailabilityMessage" element
     */
    public void xsetAvailabilityMessage(org.apache.xmlbeans.XmlString availabilityMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AVAILABILITYMESSAGE$0);
            }
            target.set(availabilityMessage);
        }
    }
}
