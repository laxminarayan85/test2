/*
 * An XML document type.
 * Localname: OrderMultipleMessage
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .OrderMultipleMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one OrderMultipleMessage(@) element.
 *
 * This is a complex type.
 */
public class OrderMultipleMessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .OrderMultipleMessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrderMultipleMessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORDERMULTIPLEMESSAGE$0 = 
        new javax.xml.namespace.QName("", "OrderMultipleMessage");
    
    
    /**
     * Gets the "OrderMultipleMessage" element
     */
    public java.lang.String getOrderMultipleMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLEMESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OrderMultipleMessage" element
     */
    public org.apache.xmlbeans.XmlString xgetOrderMultipleMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLEMESSAGE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "OrderMultipleMessage" element
     */
    public void setOrderMultipleMessage(java.lang.String orderMultipleMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLEMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORDERMULTIPLEMESSAGE$0);
            }
            target.setStringValue(orderMultipleMessage);
        }
    }
    
    /**
     * Sets (as xml) the "OrderMultipleMessage" element
     */
    public void xsetOrderMultipleMessage(org.apache.xmlbeans.XmlString orderMultipleMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLEMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORDERMULTIPLEMESSAGE$0);
            }
            target.set(orderMultipleMessage);
        }
    }
}
