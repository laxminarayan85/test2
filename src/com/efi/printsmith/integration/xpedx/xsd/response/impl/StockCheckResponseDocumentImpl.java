/*
 * An XML document type.
 * Localname: StockCheckResponse
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one StockCheckResponse(@) element.
 *
 * This is a complex type.
 */
public class StockCheckResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public StockCheckResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName STOCKCHECKRESPONSE$0 = 
        new javax.xml.namespace.QName("", "StockCheckResponse");
    
    
    /**
     * Gets the "StockCheckResponse" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse getStockCheckResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse)get_store().find_element_user(STOCKCHECKRESPONSE$0, 0);
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
    public void setStockCheckResponse(com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse stockCheckResponse)
    {
        generatedSetterHelperImpl(stockCheckResponse, STOCKCHECKRESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "StockCheckResponse" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse addNewStockCheckResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse)get_store().add_element_user(STOCKCHECKRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML StockCheckResponse(@).
     *
     * This is a complex type.
     */
    public static class StockCheckResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse
    {
        private static final long serialVersionUID = 1L;
        
        public StockCheckResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ETRADINGPARTNERID$0 = 
            new javax.xml.namespace.QName("", "eTradingPartnerID");
        private static final javax.xml.namespace.QName ERRORCODE$2 = 
            new javax.xml.namespace.QName("", "ErrorCode");
        private static final javax.xml.namespace.QName ERRORMESSAGE$4 = 
            new javax.xml.namespace.QName("", "ErrorMessage");
        private static final javax.xml.namespace.QName ITEMS$6 = 
            new javax.xml.namespace.QName("", "Items");
        
        
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
         * Gets the "ErrorCode" element
         */
        public java.lang.String getErrorCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ErrorCode" element
         */
        public org.apache.xmlbeans.XmlString xgetErrorCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ErrorCode" element
         */
        public void setErrorCode(java.lang.String errorCode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORCODE$2);
                }
                target.setStringValue(errorCode);
            }
        }
        
        /**
         * Sets (as xml) the "ErrorCode" element
         */
        public void xsetErrorCode(org.apache.xmlbeans.XmlString errorCode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORCODE$2);
                }
                target.set(errorCode);
            }
        }
        
        /**
         * Gets the "ErrorMessage" element
         */
        public java.lang.String getErrorMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ErrorMessage" element
         */
        public org.apache.xmlbeans.XmlString xgetErrorMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ErrorMessage" element
         */
        public void setErrorMessage(java.lang.String errorMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORMESSAGE$4);
                }
                target.setStringValue(errorMessage);
            }
        }
        
        /**
         * Sets (as xml) the "ErrorMessage" element
         */
        public void xsetErrorMessage(org.apache.xmlbeans.XmlString errorMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORMESSAGE$4);
                }
                target.set(errorMessage);
            }
        }
        
        /**
         * Gets the "Items" element
         */
        public com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items getItems()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items)get_store().find_element_user(ITEMS$6, 0);
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
            generatedSetterHelperImpl(items, ITEMS$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
                target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items)get_store().add_element_user(ITEMS$6);
                return target;
            }
        }
    }
}
