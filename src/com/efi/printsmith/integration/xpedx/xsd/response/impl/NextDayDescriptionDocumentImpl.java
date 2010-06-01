/*
 * An XML document type.
 * Localname: NextDayDescription
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.NextDayDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one NextDayDescription(@) element.
 *
 * This is a complex type.
 */
public class NextDayDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.NextDayDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public NextDayDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NEXTDAYDESCRIPTION$0 = 
        new javax.xml.namespace.QName("", "NextDayDescription");
    
    
    /**
     * Gets the "NextDayDescription" element
     */
    public java.lang.String getNextDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NextDayDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetNextDayDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "NextDayDescription" element
     */
    public void setNextDayDescription(java.lang.String nextDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTDAYDESCRIPTION$0);
            }
            target.setStringValue(nextDayDescription);
        }
    }
    
    /**
     * Sets (as xml) the "NextDayDescription" element
     */
    public void xsetNextDayDescription(org.apache.xmlbeans.XmlString nextDayDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTDAYDESCRIPTION$0);
            }
            target.set(nextDayDescription);
        }
    }
}
