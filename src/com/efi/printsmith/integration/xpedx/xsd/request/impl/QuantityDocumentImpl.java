/*
 * An XML document type.
 * Localname: Quantity
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.request.QuantityDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.request.impl;
/**
 * A document containing one Quantity(@) element.
 *
 * This is a complex type.
 */
public class QuantityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.QuantityDocument
{
    private static final long serialVersionUID = 1L;
    
    public QuantityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName QUANTITY$0 = 
        new javax.xml.namespace.QName("", "Quantity");
    
    
    /**
     * Gets the "Quantity" element
     */
    public java.math.BigInteger getQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "Quantity" element
     */
    public org.apache.xmlbeans.XmlInteger xgetQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "Quantity" element
     */
    public void setQuantity(java.math.BigInteger quantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(QUANTITY$0);
            }
            target.setBigIntegerValue(quantity);
        }
    }
    
    /**
     * Sets (as xml) the "Quantity" element
     */
    public void xsetQuantity(org.apache.xmlbeans.XmlInteger quantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(QUANTITY$0);
            }
            target.set(quantity);
        }
    }
}
