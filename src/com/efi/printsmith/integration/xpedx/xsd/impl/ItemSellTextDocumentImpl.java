/*
 * An XML document type.
 * Localname: ItemSellText
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .ItemSellTextDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one ItemSellText(@) element.
 *
 * This is a complex type.
 */
public class ItemSellTextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .ItemSellTextDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItemSellTextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEMSELLTEXT$0 = 
        new javax.xml.namespace.QName("", "ItemSellText");
    
    
    /**
     * Gets the "ItemSellText" element
     */
    public java.lang.String getItemSellText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSELLTEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ItemSellText" element
     */
    public org.apache.xmlbeans.XmlString xgetItemSellText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSELLTEXT$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ItemSellText" element
     */
    public void setItemSellText(java.lang.String itemSellText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSELLTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMSELLTEXT$0);
            }
            target.setStringValue(itemSellText);
        }
    }
    
    /**
     * Sets (as xml) the "ItemSellText" element
     */
    public void xsetItemSellText(org.apache.xmlbeans.XmlString itemSellText)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSELLTEXT$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMSELLTEXT$0);
            }
            target.set(itemSellText);
        }
    }
}
