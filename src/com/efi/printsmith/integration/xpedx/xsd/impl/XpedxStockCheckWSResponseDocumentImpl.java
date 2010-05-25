/*
 * An XML document type.
 * Localname: xpedxStockCheckWSResponse
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one xpedxStockCheckWSResponse(@) element.
 *
 * This is a complex type.
 */
public class XpedxStockCheckWSResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public XpedxStockCheckWSResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName XPEDXSTOCKCHECKWSRESPONSE$0 = 
        new javax.xml.namespace.QName("", "xpedxStockCheckWSResponse");
    
    
    /**
     * Gets the "xpedxStockCheckWSResponse" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse getXpedxStockCheckWSResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse)get_store().find_element_user(XPEDXSTOCKCHECKWSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "xpedxStockCheckWSResponse" element
     */
    public void setXpedxStockCheckWSResponse(com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse xpedxStockCheckWSResponse)
    {
        generatedSetterHelperImpl(xpedxStockCheckWSResponse, XPEDXSTOCKCHECKWSRESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "xpedxStockCheckWSResponse" element
     */
    public com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse addNewXpedxStockCheckWSResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse)get_store().add_element_user(XPEDXSTOCKCHECKWSRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML xpedxStockCheckWSResponse(@).
     *
     * This is a complex type.
     */
    public static class XpedxStockCheckWSResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse
    {
        private static final long serialVersionUID = 1L;
        
        public XpedxStockCheckWSResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ROOTERRORINFO$0 = 
            new javax.xml.namespace.QName("", "RootErrorInfo");
        private static final javax.xml.namespace.QName SENDERCREDENTIALS$2 = 
            new javax.xml.namespace.QName("", "SenderCredentials");
        private static final javax.xml.namespace.QName STOCKCHECKRESPONSE$4 = 
            new javax.xml.namespace.QName("", "StockCheckResponse");
        
        
        /**
         * Gets the "RootErrorInfo" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo getRootErrorInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo)get_store().find_element_user(ROOTERRORINFO$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "RootErrorInfo" element
         */
        public void setRootErrorInfo(com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo rootErrorInfo)
        {
            generatedSetterHelperImpl(rootErrorInfo, ROOTERRORINFO$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "RootErrorInfo" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo addNewRootErrorInfo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo)get_store().add_element_user(ROOTERRORINFO$0);
                return target;
            }
        }
        
        /**
         * Gets the "SenderCredentials" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials getSenderCredentials()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials)get_store().find_element_user(SENDERCREDENTIALS$2, 0);
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
            generatedSetterHelperImpl(senderCredentials, SENDERCREDENTIALS$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
                target = (com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials)get_store().add_element_user(SENDERCREDENTIALS$2);
                return target;
            }
        }
        
        /**
         * Gets the "StockCheckResponse" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse getStockCheckResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse)get_store().find_element_user(STOCKCHECKRESPONSE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "StockCheckResponse" element
         */
        public void setStockCheckResponse(com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse stockCheckResponse)
        {
            generatedSetterHelperImpl(stockCheckResponse, STOCKCHECKRESPONSE$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "StockCheckResponse" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse addNewStockCheckResponse()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .StockCheckResponseDocument.StockCheckResponse)get_store().add_element_user(STOCKCHECKRESPONSE$4);
                return target;
            }
        }
    }
}
