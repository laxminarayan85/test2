/*
 * An XML document type.
 * Localname: SameDayDescription
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.SameDayDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one SameDayDescription(@) element.
 *
 * This is a complex type.
 */
public class SameDayDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.SameDayDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public SameDayDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SAMEDAYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("", "SameDayDescription");
    
    
    /**
     * Gets the "SameDayDescription" element
     */
    public java.lang.String getSameDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SameDayDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetSameDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "SameDayDescription" element
     */
    public void setSameDayDescription(java.lang.String sameDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SAMEDAYDESCRIPTION$0);
            }
            target.setStringValue(sameDayDescription);
        }
    }
    
    /**
     * Sets (as xml) the "SameDayDescription" element
     */
    public void xsetSameDayDescription(org.apache.xmlbeans.XmlString sameDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SAMEDAYDESCRIPTION$0);
            }
            target.set(sameDayDescription);
        }
    }
}
