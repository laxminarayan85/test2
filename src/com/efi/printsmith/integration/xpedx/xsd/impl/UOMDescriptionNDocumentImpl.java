/*
 * An XML document type.
 * Localname: UOMDescription..n
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UOMDescriptionNDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UOMDescription..n(@) element.
 *
 * This is a complex type.
 */
public class UOMDescriptionNDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UOMDescriptionNDocument
{
    private static final long serialVersionUID = 1L;
    
    public UOMDescriptionNDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMDESCRIPTIONN$0 = 
        new javax.xml.namespace.QName("", "UOMDescription..n");
    
    
    /**
     * Gets the "UOMDescription..n" element
     */
    public java.lang.String getUOMDescriptionN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTIONN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMDescription..n" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMDescriptionN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTIONN$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMDescription..n" element
     */
    public void setUOMDescriptionN(java.lang.String uomDescriptionN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTIONN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTIONN$0);
            }
            target.setStringValue(uomDescriptionN);
        }
    }
    
    /**
     * Sets (as xml) the "UOMDescription..n" element
     */
    public void xsetUOMDescriptionN(org.apache.xmlbeans.XmlString uomDescriptionN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTIONN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTIONN$0);
            }
            target.set(uomDescriptionN);
        }
    }
}
