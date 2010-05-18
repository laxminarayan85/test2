/*
 * An XML document type.
 * Localname: xpedxStockCheckWSRequest
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one xpedxStockCheckWSRequest(@) element.
 *
 * This is a complex type.
 */
public class XpedxStockCheckWSRequestDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument
{
    private static final long serialVersionUID = 1L;
    
    public XpedxStockCheckWSRequestDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName XPEDXSTOCKCHECKWSREQUEST$0 = 
        new javax.xml.namespace.QName("", "xpedxStockCheckWSRequest");
    
    
    /**
     * Gets the "xpedxStockCheckWSRequest" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest getXpedxStockCheckWSRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest)get_store().find_element_user(XPEDXSTOCKCHECKWSREQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "xpedxStockCheckWSRequest" element
     */
    public void setXpedxStockCheckWSRequest(com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest xpedxStockCheckWSRequest)
    {
        generatedSetterHelperImpl(xpedxStockCheckWSRequest, XPEDXSTOCKCHECKWSREQUEST$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "xpedxStockCheckWSRequest" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest addNewXpedxStockCheckWSRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest)get_store().add_element_user(XPEDXSTOCKCHECKWSREQUEST$0);
            return target;
        }
    }
    /**
     * An XML xpedxStockCheckWSRequest(@).
     *
     * This is a complex type.
     */
    public static class XpedxStockCheckWSRequestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest
    {
        private static final long serialVersionUID = 1L;
        
        public XpedxStockCheckWSRequestImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SENDERCREDENTIALS$0 = 
            new javax.xml.namespace.QName("", "SenderCredentials");
        private static final javax.xml.namespace.QName STOCKCHECKREQUESTS$2 = 
            new javax.xml.namespace.QName("", "StockCheckRequests");
        
        
        /**
         * Gets the "SenderCredentials" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials getSenderCredentials()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials)get_store().find_element_user(SENDERCREDENTIALS$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "SenderCredentials" element
         */
        public void setSenderCredentials(com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials senderCredentials)
        {
            generatedSetterHelperImpl(senderCredentials, SENDERCREDENTIALS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "SenderCredentials" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials addNewSenderCredentials()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials)get_store().add_element_user(SENDERCREDENTIALS$0);
                return target;
            }
        }
        
        /**
         * Gets the "StockCheckRequests" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests getStockCheckRequests()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests)get_store().find_element_user(STOCKCHECKREQUESTS$2, 0);
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
            generatedSetterHelperImpl(stockCheckRequests, STOCKCHECKREQUESTS$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests)get_store().add_element_user(STOCKCHECKREQUESTS$2);
                return target;
            }
        }
    }
}
