/*
 * An XML document type.
 * Localname: UserEmail
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.UserEmailDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one UserEmail(@) element.
 *
 * This is a complex type.
 */
public class UserEmailDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.UserEmailDocument
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
    public org.apache.xmlbeans.XmlString xgetUserEmail()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USEREMAIL$0, 0);
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
    public void xsetUserEmail(org.apache.xmlbeans.XmlString userEmail)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USEREMAIL$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USEREMAIL$0);
            }
            target.set(userEmail);
        }
    }
}
