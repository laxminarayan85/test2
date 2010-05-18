/*
 * An XML document type.
 * Localname: SenderCredentials
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one SenderCredentials(@) element.
 *
 * This is a complex type.
 */
public class SenderCredentialsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument
{
    private static final long serialVersionUID = 1L;
    
    public SenderCredentialsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SENDERCREDENTIALS$0 = 
        new javax.xml.namespace.QName("", "SenderCredentials");
    
    
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
     * An XML SenderCredentials(@).
     *
     * This is a complex type.
     */
    public static class SenderCredentialsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials
    {
        private static final long serialVersionUID = 1L;
        
        public SenderCredentialsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName USEREMAIL$0 = 
            new javax.xml.namespace.QName("", "UserEmail");
        private static final javax.xml.namespace.QName USERPASSWORD$2 = 
            new javax.xml.namespace.QName("", "UserPassword");
        
        
        /**
         * Gets the "UserEmail" element
         */
        public java.lang.String getUserEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USEREMAIL$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UserEmail" element
         */
        public com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail xgetUserEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail)get_store().find_element_user(USEREMAIL$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UserEmail" element
         */
        public void setUserEmail(java.lang.String userEmail)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USEREMAIL$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USEREMAIL$0);
                }
                target.setStringValue(userEmail);
            }
        }
        
        /**
         * Sets (as xml) the "UserEmail" element
         */
        public void xsetUserEmail(com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail userEmail)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail target = null;
                target = (com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail)get_store().find_element_user(USEREMAIL$0, 0);
                if (target == null)
                {
                    target = (com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail)get_store().add_element_user(USEREMAIL$0);
                }
                target.set(userEmail);
            }
        }
        
        /**
         * Gets the "UserPassword" element
         */
        public java.lang.String getUserPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERPASSWORD$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UserPassword" element
         */
        public org.apache.xmlbeans.XmlString xgetUserPassword()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERPASSWORD$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UserPassword" element
         */
        public void setUserPassword(java.lang.String userPassword)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERPASSWORD$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERPASSWORD$2);
                }
                target.setStringValue(userPassword);
            }
        }
        
        /**
         * Sets (as xml) the "UserPassword" element
         */
        public void xsetUserPassword(org.apache.xmlbeans.XmlString userPassword)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERPASSWORD$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERPASSWORD$2);
                }
                target.set(userPassword);
            }
        }
    }
}
