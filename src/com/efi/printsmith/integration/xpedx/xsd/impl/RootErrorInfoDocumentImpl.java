/*
 * An XML document type.
 * Localname: RootErrorInfo
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one RootErrorInfo(@) element.
 *
 * This is a complex type.
 */
public class RootErrorInfoDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument
{
    private static final long serialVersionUID = 1L;
    
    public RootErrorInfoDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ROOTERRORINFO$0 = 
        new javax.xml.namespace.QName("", "RootErrorInfo");
    
    
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
     * An XML RootErrorInfo(@).
     *
     * This is a complex type.
     */
    public static class RootErrorInfoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .RootErrorInfoDocument.RootErrorInfo
    {
        private static final long serialVersionUID = 1L;
        
        public RootErrorInfoImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ERRORCODE$0 = 
            new javax.xml.namespace.QName("", "ErrorCode");
        private static final javax.xml.namespace.QName ERRORMESSAGE$2 = 
            new javax.xml.namespace.QName("", "ErrorMessage");
        
        
        /**
         * Gets the "ErrorCode" element
         */
        public java.lang.String getErrorCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$0, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$0, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORCODE$0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORCODE$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$2, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$2, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORMESSAGE$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORMESSAGE$2);
                }
                target.set(errorMessage);
            }
        }
    }
}
