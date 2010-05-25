/*
 * An XML document type.
 * Localname: ItemDescription
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.ItemDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one ItemDescription(@) element.
 *
 * This is a complex type.
 */
public class ItemDescriptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ItemDescriptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItemDescriptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEMDESCRIPTION$0 = 
        new javax.xml.namespace.QName("", "ItemDescription");
    
    
    /**
     * Gets the "ItemDescription" element
     */
    public java.lang.String getItemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMDESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ItemDescription" element
     */
    public org.apache.xmlbeans.XmlString xgetItemDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMDESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ItemDescription" element
     */
    public void setItemDescription(java.lang.String itemDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMDESCRIPTION$0);
            }
            target.setStringValue(itemDescription);
        }
    }
    
    /**
     * Sets (as xml) the "ItemDescription" element
     */
    public void xsetItemDescription(org.apache.xmlbeans.XmlString itemDescription)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMDESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMDESCRIPTION$0);
            }
            target.set(itemDescription);
        }
    }
}
