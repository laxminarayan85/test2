/*
 * An XML document type.
 * Localname: UnitPrice2
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.UnitPrice2Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one UnitPrice2(@) element.
 *
 * This is a complex type.
 */
public class UnitPrice2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.UnitPrice2Document
{
    private static final long serialVersionUID = 1L;
    
    public UnitPrice2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNITPRICE2$0 = 
        new javax.xml.namespace.QName("", "UnitPrice2");
    
    
    /**
     * Gets the "UnitPrice2" element
     */
    public java.lang.String getUnitPrice2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UnitPrice2" element
     */
    public org.apache.xmlbeans.XmlString xgetUnitPrice2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE2$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UnitPrice2" element
     */
    public void setUnitPrice2(java.lang.String unitPrice2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICE2$0);
            }
            target.setStringValue(unitPrice2);
        }
    }
    
    /**
     * Sets (as xml) the "UnitPrice2" element
     */
    public void xsetUnitPrice2(org.apache.xmlbeans.XmlString unitPrice2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE2$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICE2$0);
            }
            target.set(unitPrice2);
        }
    }
}
