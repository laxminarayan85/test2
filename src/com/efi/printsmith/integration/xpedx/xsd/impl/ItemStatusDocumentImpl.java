/*
 * An XML document type.
 * Localname: ItemStatus
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .ItemStatusDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one ItemStatus(@) element.
 *
 * This is a complex type.
 */
public class ItemStatusDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .ItemStatusDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItemStatusDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEMSTATUS$0 = 
        new javax.xml.namespace.QName("", "ItemStatus");
    
    
    /**
     * Gets the "ItemStatus" element
     */
    public java.lang.String getItemStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSTATUS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ItemStatus" element
     */
    public org.apache.xmlbeans.XmlString xgetItemStatus()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSTATUS$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ItemStatus" element
     */
    public void setItemStatus(java.lang.String itemStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSTATUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMSTATUS$0);
            }
            target.setStringValue(itemStatus);
        }
    }
    
    /**
     * Sets (as xml) the "ItemStatus" element
     */
    public void xsetItemStatus(org.apache.xmlbeans.XmlString itemStatus)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSTATUS$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMSTATUS$0);
            }
            target.set(itemStatus);
        }
    }
}
