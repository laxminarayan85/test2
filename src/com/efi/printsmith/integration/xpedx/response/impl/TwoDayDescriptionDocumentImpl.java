/*
 * An XML document type.
 * Localname: TwoDayDescription
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.TwoDayDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one TwoDayDescription(@) element.
 *
 * This is a complex type.
 */
public class TwoDayDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.TwoDayDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public TwoDayDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TWODAYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("", "TwoDayDescription");
    
    
    /**
     * Gets the "TwoDayDescription" element
     */
    public java.lang.String getTwoDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TwoDayDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetTwoDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TwoDayDescription" element
     */
    public void setTwoDayDescription(java.lang.String twoDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TWODAYDESCRIPTION$0);
            }
            target.setStringValue(twoDayDescription);
        }
    }
    
    /**
     * Sets (as xml) the "TwoDayDescription" element
     */
    public void xsetTwoDayDescription(org.apache.xmlbeans.XmlString twoDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TWODAYDESCRIPTION$0);
            }
            target.set(twoDayDescription);
        }
    }
}
