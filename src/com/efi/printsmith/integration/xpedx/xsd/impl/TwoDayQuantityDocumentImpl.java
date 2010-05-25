/*
 * An XML document type.
 * Localname: TwoDayQuantity
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .TwoDayQuantityDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one TwoDayQuantity(@) element.
 *
 * This is a complex type.
 */
public class TwoDayQuantityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .TwoDayQuantityDocument
{
    private static final long serialVersionUID = 1L;
    
    public TwoDayQuantityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TWODAYQUANTITY$0 = 
        new javax.xml.namespace.QName("", "TwoDayQuantity");
    
    
    /**
     * Gets the "TwoDayQuantity" element
     */
    public java.lang.String getTwoDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYQUANTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TwoDayQuantity" element
     */
    public org.apache.xmlbeans.XmlString xgetTwoDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYQUANTITY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TwoDayQuantity" element
     */
    public void setTwoDayQuantity(java.lang.String twoDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TWODAYQUANTITY$0);
            }
            target.setStringValue(twoDayQuantity);
        }
    }
    
    /**
     * Sets (as xml) the "TwoDayQuantity" element
     */
    public void xsetTwoDayQuantity(org.apache.xmlbeans.XmlString twoDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TWODAYQUANTITY$0);
            }
            target.set(twoDayQuantity);
        }
    }
}
