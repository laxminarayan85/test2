/*
 * An XML document type.
 * Localname: UOMCode2
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.UOMCode2Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one UOMCode2(@) element.
 *
 * This is a complex type.
 */
public class UOMCode2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.UOMCode2Document
{
    private static final long serialVersionUID = 1L;
    
    public UOMCode2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UOMCODE2$0 = 
        new javax.xml.namespace.QName("", "UOMCode2");
    
    
    /**
     * Gets the "UOMCode2" element
     */
    public java.lang.String getUOMCode2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UOMCode2" element
     */
    public org.apache.xmlbeans.XmlString xgetUOMCode2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UOMCode2" element
     */
    public void setUOMCode2(java.lang.String uomCode2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODE2$0);
            }
            target.setStringValue(uomCode2);
        }
    }
    
    /**
     * Sets (as xml) the "UOMCode2" element
     */
    public void xsetUOMCode2(org.apache.xmlbeans.XmlString uomCode2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODE2$0);
            }
            target.set(uomCode2);
        }
    }
}
