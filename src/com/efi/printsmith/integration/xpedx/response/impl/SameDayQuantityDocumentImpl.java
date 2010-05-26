/*
 * An XML document type.
 * Localname: SameDayQuantity
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.SameDayQuantityDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one SameDayQuantity(@) element.
 *
 * This is a complex type.
 */
public class SameDayQuantityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.SameDayQuantityDocument
{
    private static final long serialVersionUID = 1L;
    
    public SameDayQuantityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SAMEDAYQUANTITY$0 = 
        new javax.xml.namespace.QName("", "SameDayQuantity");
    
    
    /**
     * Gets the "SameDayQuantity" element
     */
    public java.lang.String getSameDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYQUANTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SameDayQuantity" element
     */
    public org.apache.xmlbeans.XmlString xgetSameDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYQUANTITY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SameDayQuantity" element
     */
    public void setSameDayQuantity(java.lang.String sameDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SAMEDAYQUANTITY$0);
            }
            target.setStringValue(sameDayQuantity);
        }
    }
    
    /**
     * Sets (as xml) the "SameDayQuantity" element
     */
    public void xsetSameDayQuantity(org.apache.xmlbeans.XmlString sameDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SAMEDAYQUANTITY$0);
            }
            target.set(sameDayQuantity);
        }
    }
}
