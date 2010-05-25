/*
 * An XML document type.
 * Localname: UnitOfMeasure
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UnitOfMeasureDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UnitOfMeasure(@) element.
 *
 * This is a complex type.
 */
public class UnitOfMeasureDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UnitOfMeasureDocument
{
    private static final long serialVersionUID = 1L;
    
    public UnitOfMeasureDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName UNITOFMEASURE$0 = 
        new javax.xml.namespace.QName("", "UnitOfMeasure");
    
    
    /**
     * Gets the "UnitOfMeasure" element
     */
    public java.lang.String getUnitOfMeasure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITOFMEASURE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "UnitOfMeasure" element
     */
    public org.apache.xmlbeans.XmlString xgetUnitOfMeasure()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITOFMEASURE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "UnitOfMeasure" element
     */
    public void setUnitOfMeasure(java.lang.String unitOfMeasure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITOFMEASURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITOFMEASURE$0);
            }
            target.setStringValue(unitOfMeasure);
        }
    }
    
    /**
     * Sets (as xml) the "UnitOfMeasure" element
     */
    public void xsetUnitOfMeasure(org.apache.xmlbeans.XmlString unitOfMeasure)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITOFMEASURE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITOFMEASURE$0);
            }
            target.set(unitOfMeasure);
        }
    }
}
