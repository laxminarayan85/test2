/*
 * An XML document type.
 * Localname: StockCheckRequests
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one StockCheckRequests(@) element.
 *
 * This is a complex type.
 */
public class StockCheckRequestsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument
{
    private static final long serialVersionUID = 1L;
    
    public StockCheckRequestsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName STOCKCHECKREQUESTS$0 = 
        new javax.xml.namespace.QName("", "StockCheckRequests");
    
    
    /**
     * Gets the "StockCheckRequests" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests getStockCheckRequests()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests)get_store().find_element_user(STOCKCHECKREQUESTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "StockCheckRequests" element
     */
    public void setStockCheckRequests(com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests stockCheckRequests)
    {
        generatedSetterHelperImpl(stockCheckRequests, STOCKCHECKREQUESTS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "StockCheckRequests" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests addNewStockCheckRequests()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests)get_store().add_element_user(STOCKCHECKREQUESTS$0);
            return target;
        }
    }
    /**
     * An XML StockCheckRequests(@).
     *
     * This is a complex type.
     */
    public static class StockCheckRequestsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests
    {
        private static final long serialVersionUID = 1L;
        
        public StockCheckRequestsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ETRADINGPARTNERID$0 = 
            new javax.xml.namespace.QName("", "eTradingPartnerID");
        private static final javax.xml.namespace.QName STOCKCHECKREQUEST$2 = 
            new javax.xml.namespace.QName("", "StockCheckRequest");
        
        
        /**
         * Gets the "eTradingPartnerID" element
         */
        public java.lang.String getETradingPartnerID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ETRADINGPARTNERID$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "eTradingPartnerID" element
         */
        public org.apache.xmlbeans.XmlString xgetETradingPartnerID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ETRADINGPARTNERID$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "eTradingPartnerID" element
         */
        public void setETradingPartnerID(java.lang.String eTradingPartnerID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ETRADINGPARTNERID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ETRADINGPARTNERID$0);
                }
                target.setStringValue(eTradingPartnerID);
            }
        }
        
        /**
         * Sets (as xml) the "eTradingPartnerID" element
         */
        public void xsetETradingPartnerID(org.apache.xmlbeans.XmlString eTradingPartnerID)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ETRADINGPARTNERID$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ETRADINGPARTNERID$0);
                }
                target.set(eTradingPartnerID);
            }
        }
        
        /**
         * Gets the "StockCheckRequest" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest getStockCheckRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest)get_store().find_element_user(STOCKCHECKREQUEST$2, 0);
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
        public void setStockCheckRequest(com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest stockCheckRequest)
        {
            generatedSetterHelperImpl(stockCheckRequest, STOCKCHECKREQUEST$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "StockCheckRequest" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest addNewStockCheckRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestDocument.StockCheckRequest)get_store().add_element_user(STOCKCHECKREQUEST$2);
                return target;
            }
        }
    }
}
