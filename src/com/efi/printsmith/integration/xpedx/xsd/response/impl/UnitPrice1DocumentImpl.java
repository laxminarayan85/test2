/*
 * An XML document type.
 * Localname: UnitPrice1
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.UnitPrice1Document
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one UnitPrice1(@) element.
 *
 * This is a complex type.
 */
public class UnitPrice1DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.UnitPrice1Document
{
    private static final long serialVersionUID = 1L;
    
    public UnitPrice1DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNITPRICE1$0 = 
        new javax.xml.namespace.QName("", "UnitPrice1");
    
    
    /**
     * Gets the "UnitPrice1" element
     */
    public java.lang.String getUnitPrice1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE1$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UnitPrice1" element
     */
    public org.apache.xmlbeans.XmlString xgetUnitPrice1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE1$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UnitPrice1" element
     */
    public void setUnitPrice1(java.lang.String unitPrice1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICE1$0);
            }
            target.setStringValue(unitPrice1);
        }
    }
    
    /**
     * Sets (as xml) the "UnitPrice1" element
     */
    public void xsetUnitPrice1(org.apache.xmlbeans.XmlString unitPrice1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE1$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICE1$0);
            }
            target.set(unitPrice1);
        }
    }
}
