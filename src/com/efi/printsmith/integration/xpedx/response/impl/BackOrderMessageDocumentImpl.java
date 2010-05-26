/*
 * An XML document type.
 * Localname: BackOrderMessage
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response.impl;
/**
 * A document containing one BackOrderMessage(@) element.
 *
 * This is a complex type.
 */
public class BackOrderMessageDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument
{
    private static final long serialVersionUID = 1L;
    
    public BackOrderMessageDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BACKORDERMESSAGE$0 = 
        new javax.xml.namespace.QName("", "BackOrderMessage");
    
    
    /**
     * Gets the "BackOrderMessage" element
     */
    public java.lang.String getBackOrderMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BACKORDERMESSAGE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "BackOrderMessage" element
     */
    public org.apache.xmlbeans.XmlString xgetBackOrderMessage()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BACKORDERMESSAGE$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "BackOrderMessage" element
     */
    public void setBackOrderMessage(java.lang.String backOrderMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BACKORDERMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BACKORDERMESSAGE$0);
            }
            target.setStringValue(backOrderMessage);
        }
    }
    
    /**
     * Sets (as xml) the "BackOrderMessage" element
     */
    public void xsetBackOrderMessage(org.apache.xmlbeans.XmlString backOrderMessage)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BACKORDERMESSAGE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BACKORDERMESSAGE$0);
            }
            target.set(backOrderMessage);
        }
    }
}
