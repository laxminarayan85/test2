/*
 * An XML document type.
 * Localname: UserPassword
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.UserPasswordDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one UserPassword(@) element.
 *
 * This is a complex type.
 */
public class UserPasswordDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.UserPasswordDocument
{
    private static final long serialVersionUID = 1L;
    
    public UserPasswordDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USERPASSWORD$0 = 
        new javax.xml.namespace.QName("", "UserPassword");
    
    
    /**
     * Gets the "UserPassword" element
     */
    public java.lang.String getUserPassword()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERPASSWORD$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERPASSWORD$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERPASSWORD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERPASSWORD$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERPASSWORD$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERPASSWORD$0);
            }
            target.set(userPassword);
        }
    }
}
