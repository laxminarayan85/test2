/*
 * An XML document type.
 * Localname: UserEmail
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd .impl;
/**
 * A document containing one UserEmail(@) element.
 *
 * This is a complex type.
 */
public class UserEmailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument
{
    private static final long serialVersionUID = 1L;
    
    public UserEmailDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USEREMAIL$0 = 
        new javax.xml.namespace.QName("", "UserEmail");
    
    
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
     * An XML UserEmail(@).
     *
     * This is an atomic type that is a restriction of com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument$UserEmail.
     */
    public static class UserEmailImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements com.efi.printsmith.integration.xpedx.xsd .UserEmailDocument.UserEmail
    {
        private static final long serialVersionUID = 1L;
        
        public UserEmailImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected UserEmailImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
