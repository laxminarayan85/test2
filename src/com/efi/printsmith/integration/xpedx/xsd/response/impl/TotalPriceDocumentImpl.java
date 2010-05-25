/*
 * An XML document type.
 * Localname: TotalPrice
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.TotalPriceDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one TotalPrice(@) element.
 *
 * This is a complex type.
 */
public class TotalPriceDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.TotalPriceDocument
{
    private static final long serialVersionUID = 1L;
    
    public TotalPriceDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TOTALPRICE$0 = 
        new javax.xml.namespace.QName("", "TotalPrice");
    
    
    /**
     * Gets the "TotalPrice" element
     */
    public java.lang.String getTotalPrice()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALPRICE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TotalPrice" element
     */
    public org.apache.xmlbeans.XmlString xgetTotalPrice()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOTALPRICE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TotalPrice" element
     */
    public void setTotalPrice(java.lang.String totalPrice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALPRICE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOTALPRICE$0);
            }
            target.setStringValue(totalPrice);
        }
    }
    
    /**
     * Sets (as xml) the "TotalPrice" element
     */
    public void xsetTotalPrice(org.apache.xmlbeans.XmlString totalPrice)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOTALPRICE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TOTALPRICE$0);
            }
            target.set(totalPrice);
        }
    }
}
