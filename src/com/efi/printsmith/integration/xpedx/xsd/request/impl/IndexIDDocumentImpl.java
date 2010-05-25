/*
 * An XML document type.
 * Localname: IndexID
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.request.IndexIDDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.request.impl;
/**
 * A document containing one IndexID(@) element.
 *
 * This is a complex type.
 */
public class IndexIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.IndexIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public IndexIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDEXID$0 = 
        new javax.xml.namespace.QName("", "IndexID");
    
    
    /**
     * Gets the "IndexID" element
     */
    public java.lang.String getIndexID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDEXID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "IndexID" element
     */
    public org.apache.xmlbeans.XmlString xgetIndexID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDEXID$0, 0);
            return target;
        }
    }
    
    /**
     * Tests for nil "IndexID" element
     */
    public boolean isNilIndexID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDEXID$0, 0);
            if (target == null) return false;
            return target.isNil();
        }
    }
    
    /**
     * Sets the "IndexID" element
     */
    public void setIndexID(java.lang.String indexID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INDEXID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INDEXID$0);
            }
            target.setStringValue(indexID);
        }
    }
    
    /**
     * Sets (as xml) the "IndexID" element
     */
    public void xsetIndexID(org.apache.xmlbeans.XmlString indexID)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDEXID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDEXID$0);
            }
            target.set(indexID);
        }
    }
    
    /**
     * Nils the "IndexID" element
     */
    public void setNilIndexID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INDEXID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INDEXID$0);
            }
            target.setNil();
        }
    }
}
