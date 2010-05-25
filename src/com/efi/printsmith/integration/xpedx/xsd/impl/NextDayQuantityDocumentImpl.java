/*
 * An XML document type.
 * Localname: NextDayQuantity
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .NextDayQuantityDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one NextDayQuantity(@) element.
 *
 * This is a complex type.
 */
public class NextDayQuantityDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .NextDayQuantityDocument
{
    private static final long serialVersionUID = 1L;
    
    public NextDayQuantityDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NEXTDAYQUANTITY$0 = 
        new javax.xml.namespace.QName("", "NextDayQuantity");
    
    
    /**
     * Gets the "NextDayQuantity" element
     */
    public java.lang.String getNextDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYQUANTITY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NextDayQuantity" element
     */
    public org.apache.xmlbeans.XmlString xgetNextDayQuantity()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYQUANTITY$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "NextDayQuantity" element
     */
    public void setNextDayQuantity(java.lang.String nextDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTDAYQUANTITY$0);
            }
            target.setStringValue(nextDayQuantity);
        }
    }
    
    /**
     * Sets (as xml) the "NextDayQuantity" element
     */
    public void xsetNextDayQuantity(org.apache.xmlbeans.XmlString nextDayQuantity)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYQUANTITY$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTDAYQUANTITY$0);
            }
            target.set(nextDayQuantity);
        }
    }
}
