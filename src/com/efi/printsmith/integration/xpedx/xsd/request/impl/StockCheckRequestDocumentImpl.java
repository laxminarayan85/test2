/*
 * An XML document type.
 * Localname: StockCheckRequest
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.request.impl;
/**
 * A document containing one StockCheckRequest(@) element.
 *
 * This is a complex type.
 */
public class StockCheckRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument
{
    private static final long serialVersionUID = 1L;
    
    public StockCheckRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName STOCKCHECKREQUEST$0 = 
        new javax.xml.namespace.QName("", "StockCheckRequest");
    
    
    /**
     * Gets the "StockCheckRequest" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest getStockCheckRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest)get_store().find_element_user(STOCKCHECKREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "StockCheckRequest" element
     */
    public void setStockCheckRequest(com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest stockCheckRequest)
    {
        generatedSetterHelperImpl(stockCheckRequest, STOCKCHECKREQUEST$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "StockCheckRequest" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest addNewStockCheckRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest)get_store().add_element_user(STOCKCHECKREQUEST$0);
            return target;
        }
    }
    /**
     * An XML StockCheckRequest(@).
     *
     * This is a complex type.
     */
    public static class StockCheckRequestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest
    {
        private static final long serialVersionUID = 1L;
        
        public StockCheckRequestImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ITEMS$0 = 
            new javax.xml.namespace.QName("", "Items");
        
        
        /**
         * Gets the "Items" element
         */
        public com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items getItems()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items)get_store().find_element_user(ITEMS$0, 0);
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
        public void setItems(com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items items)
        {
            generatedSetterHelperImpl(items, ITEMS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "Items" element
         */
        public com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items addNewItems()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items)get_store().add_element_user(ITEMS$0);
                return target;
            }
        }
    }
}
