/*
 * An XML document type.
 * Localname: ErrorMessage
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.ErrorMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one ErrorMessage(@) element.
 *
 * This is a complex type.
 */
public class ErrorMessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.ErrorMessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public ErrorMessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ERRORMESSAGE$0 = 
        new javax.xml.namespace.QName("", "ErrorMessage");
    
    
    /**
     * Gets the "ErrorMessage" element
     */
    public java.lang.String getErrorMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORMESSAGE$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORMESSAGE$0);
            }
            target.set(errorMessage);
        }
    }
}
