/*
 * An XML document type.
 * Localname: UnitPrice..n
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UnitPriceNDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UnitPrice..n(@) element.
 *
 * This is a complex type.
 */
public class UnitPriceNDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UnitPriceNDocument
{
    private static final long serialVersionUID = 1L;
    
    public UnitPriceNDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNITPRICEN$0 = 
        new javax.xml.namespace.QName("", "UnitPrice..n");
    
    
    /**
     * Gets the "UnitPrice..n" element
     */
    public java.lang.String getUnitPriceN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICEN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UnitPrice..n" element
     */
    public org.apache.xmlbeans.XmlString xgetUnitPriceN()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICEN$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UnitPrice..n" element
     */
    public void setUnitPriceN(java.lang.String unitPriceN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICEN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICEN$0);
            }
            target.setStringValue(unitPriceN);
        }
    }
    
    /**
     * Sets (as xml) the "UnitPrice..n" element
     */
    public void xsetUnitPriceN(org.apache.xmlbeans.XmlString unitPriceN)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICEN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICEN$0);
            }
            target.set(unitPriceN);
        }
    }
}
