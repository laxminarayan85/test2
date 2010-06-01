/*
 * An XML document type.
 * Localname: PUN
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.PUNDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one PUN(@) element.
 *
 * This is a complex type.
 */
public class PUNDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.PUNDocument
{
    private static final long serialVersionUID = 1L;
    
    public PUNDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PUN$0 = 
        new javax.xml.namespace.QName("", "PUN");
    
    
    /**
     * Gets the "PUN" element
     */
    public java.lang.String getPUN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PUN" element
     */
    public org.apache.xmlbeans.XmlString xgetPUN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUN$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "PUN" element
     */
    public void setPUN(java.lang.String pun)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUN$0);
            }
            target.setStringValue(pun);
        }
    }
    
    /**
     * Sets (as xml) the "PUN" element
     */
    public void xsetPUN(org.apache.xmlbeans.XmlString pun)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUN$0);
            }
            target.set(pun);
        }
    }
}
