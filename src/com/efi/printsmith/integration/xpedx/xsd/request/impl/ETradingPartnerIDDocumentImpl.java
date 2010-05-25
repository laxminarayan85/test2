/*
 * An XML document type.
 * Localname: eTradingPartnerID
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.request.ETradingPartnerIDDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.request.impl;
/**
 * A document containing one eTradingPartnerID(@) element.
 *
 * This is a complex type.
 */
public class ETradingPartnerIDDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.ETradingPartnerIDDocument
{
    private static final long serialVersionUID = 1L;
    
    public ETradingPartnerIDDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ETRADINGPARTNERID$0 = 
        new javax.xml.namespace.QName("", "eTradingPartnerID");
    
    
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
}
