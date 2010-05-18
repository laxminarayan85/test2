/*
 * An XML document type.
 * Localname: xpedxPartNumber
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .XpedxPartNumberDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one xpedxPartNumber(@) element.
 *
 * This is a complex type.
 */
public class XpedxPartNumberDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .XpedxPartNumberDocument
{
    private static final long serialVersionUID = 1L;
    
    public XpedxPartNumberDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName XPEDXPARTNUMBER$0 = 
        new javax.xml.namespace.QName("", "xpedxPartNumber");
    
    
    /**
     * Gets the "xpedxPartNumber" element
     */
    public java.lang.String getXpedxPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(XPEDXPARTNUMBER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "xpedxPartNumber" element
     */
    public org.apache.xmlbeans.XmlString xgetXpedxPartNumber()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(XPEDXPARTNUMBER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "xpedxPartNumber" element
     */
    public void setXpedxPartNumber(java.lang.String xpedxPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(XPEDXPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(XPEDXPARTNUMBER$0);
            }
            target.setStringValue(xpedxPartNumber);
        }
    }
    
    /**
     * Sets (as xml) the "xpedxPartNumber" element
     */
    public void xsetXpedxPartNumber(org.apache.xmlbeans.XmlString xpedxPartNumber)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(XPEDXPARTNUMBER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(XPEDXPARTNUMBER$0);
            }
            target.set(xpedxPartNumber);
        }
    }
}
