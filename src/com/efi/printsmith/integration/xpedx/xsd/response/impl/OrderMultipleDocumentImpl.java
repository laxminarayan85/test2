/*
 * An XML document type.
 * Localname: OrderMultiple
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.OrderMultipleDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one OrderMultiple(@) element.
 *
 * This is a complex type.
 */
public class OrderMultipleDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.OrderMultipleDocument
{
    private static final long serialVersionUID = 1L;
    
    public OrderMultipleDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ORDERMULTIPLE$0 = 
        new javax.xml.namespace.QName("", "OrderMultiple");
    
    
    /**
     * Gets the "OrderMultiple" element
     */
    public java.lang.String getOrderMultiple()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "OrderMultiple" element
     */
    public org.apache.xmlbeans.XmlString xgetOrderMultiple()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "OrderMultiple" element
     */
    public void setOrderMultiple(java.lang.String orderMultiple)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORDERMULTIPLE$0);
            }
            target.setStringValue(orderMultiple);
        }
    }
    
    /**
     * Sets (as xml) the "OrderMultiple" element
     */
    public void xsetOrderMultiple(org.apache.xmlbeans.XmlString orderMultiple)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORDERMULTIPLE$0);
            }
            target.set(orderMultiple);
        }
    }
}
