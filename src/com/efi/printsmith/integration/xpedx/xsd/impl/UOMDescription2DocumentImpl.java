/*
 * An XML document type.
 * Localname: UOMDescription2
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UOMDescription2Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UOMDescription2(@) element.
 *
 * This is a complex type.
 */
public class UOMDescription2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UOMDescription2Document
{
    private static final long serialVersionUID = 1L;
    
    public UOMDescription2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMDESCRIPTION2$0 = 
        new javax.xml.namespace.QName("", "UOMDescription2");
    
    
    /**
     * Gets the "UOMDescription2" element
     */
    public java.lang.String getUOMDescription2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMDescription2" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMDescription2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMDescription2" element
     */
    public void setUOMDescription2(java.lang.String uomDescription2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTION2$0);
            }
            target.setStringValue(uomDescription2);
        }
    }
    
    /**
     * Sets (as xml) the "UOMDescription2" element
     */
    public void xsetUOMDescription2(org.apache.xmlbeans.XmlString uomDescription2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTION2$0);
            }
            target.set(uomDescription2);
        }
    }
}
