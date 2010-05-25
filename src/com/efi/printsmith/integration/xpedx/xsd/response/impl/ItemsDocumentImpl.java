/*
 * An XML document type.
 * Localname: Items
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one Items(@) element.
 *
 * This is a complex type.
 */
public class ItemsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItemsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEMS$0 = 
        new javax.xml.namespace.QName("", "Items");
    
    
    /**
     * Gets the "Items" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items getItems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items)get_store().find_element_user(ITEMS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Items" element
     */
    public void setItems(com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items items)
    {
        generatedSetterHelperImpl(items, ITEMS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Items" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items addNewItems()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items)get_store().add_element_user(ITEMS$0);
            return target;
        }
    }
    /**
     * An XML Items(@).
     *
     * This is a complex type.
     */
    public static class ItemsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items
    {
        private static final long serialVersionUID = 1L;
        
        public ItemsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ITEM$0 = 
            new javax.xml.namespace.QName("", "Item");
        
        
        /**
         * Gets the "Item" element
         */
        public com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item getItem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item)get_store().find_element_user(ITEM$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "Item" element
         */
        public void setItem(com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item item)
        {
            generatedSetterHelperImpl(item, ITEM$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "Item" element
         */
        public com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item addNewItem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item)get_store().add_element_user(ITEM$0);
                return target;
            }
        }
    }
}
