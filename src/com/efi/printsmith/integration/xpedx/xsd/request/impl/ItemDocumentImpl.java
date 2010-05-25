/*
 * An XML document type.
 * Localname: Item
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.request.impl;
/**
 * A document containing one Item(@) element.
 *
 * This is a complex type.
 */
public class ItemDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument
{
    private static final long serialVersionUID = 1L;
    
    public ItemDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEM$0 = 
        new javax.xml.namespace.QName("", "Item");
    
    
    /**
     * Gets the "Item" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item getItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item)get_store().find_element_user(ITEM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Item" element
     */
    public void setItem(com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item item)
    {
        generatedSetterHelperImpl(item, ITEM$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Item" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item addNewItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item)get_store().add_element_user(ITEM$0);
            return target;
        }
    }
    /**
     * An XML Item(@).
     *
     * This is a complex type.
     */
    public static class ItemImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item
    {
        private static final long serialVersionUID = 1L;
        
        public ItemImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName INDEXID$0 = 
            new javax.xml.namespace.QName("", "IndexID");
        private static final javax.xml.namespace.QName XPEDXPARTNUMBER$2 = 
            new javax.xml.namespace.QName("", "xpedxPartNumber");
        private static final javax.xml.namespace.QName CUSTOMERPARTNUMBER$4 = 
            new javax.xml.namespace.QName("", "CustomerPartNumber");
        private static final javax.xml.namespace.QName QUANTITY$6 = 
            new javax.xml.namespace.QName("", "Quantity");
        private static final javax.xml.namespace.QName UOM$8 = 
            new javax.xml.namespace.QName("", "UOM");
        
        
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
        
        /**
         * Gets the "xpedxPartNumber" element
         */
        public java.lang.String getXpedxPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(XPEDXPARTNUMBER$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "xpedxPartNumber" element
         */
        public org.apache.xmlbeans.XmlString xgetXpedxPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(XPEDXPARTNUMBER$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "xpedxPartNumber" element
         */
        public void setXpedxPartNumber(java.lang.String xpedxPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(XPEDXPARTNUMBER$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(XPEDXPARTNUMBER$2);
                }
                target.setStringValue(xpedxPartNumber);
            }
        }
        
        /**
         * Sets (as xml) the "xpedxPartNumber" element
         */
        public void xsetXpedxPartNumber(org.apache.xmlbeans.XmlString xpedxPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(XPEDXPARTNUMBER$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(XPEDXPARTNUMBER$2);
                }
                target.set(xpedxPartNumber);
            }
        }
        
        /**
         * Gets the "CustomerPartNumber" element
         */
        public java.lang.String getCustomerPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERPARTNUMBER$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CustomerPartNumber" element
         */
        public org.apache.xmlbeans.XmlString xgetCustomerPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERPARTNUMBER$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CustomerPartNumber" element
         */
        public void setCustomerPartNumber(java.lang.String customerPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERPARTNUMBER$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CUSTOMERPARTNUMBER$4);
                }
                target.setStringValue(customerPartNumber);
            }
        }
        
        /**
         * Sets (as xml) the "CustomerPartNumber" element
         */
        public void xsetCustomerPartNumber(org.apache.xmlbeans.XmlString customerPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERPARTNUMBER$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CUSTOMERPARTNUMBER$4);
                }
                target.set(customerPartNumber);
            }
        }
        
        /**
         * Gets the "Quantity" element
         */
        public java.math.BigInteger getQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getBigIntegerValue();
            }
        }
        
        /**
         * Gets (as xml) the "Quantity" element
         */
        public org.apache.xmlbeans.XmlInteger xgetQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInteger target = null;
                target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Quantity" element
         */
        public void setQuantity(java.math.BigInteger quantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(QUANTITY$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(QUANTITY$6);
                }
                target.setBigIntegerValue(quantity);
            }
        }
        
        /**
         * Sets (as xml) the "Quantity" element
         */
        public void xsetQuantity(org.apache.xmlbeans.XmlInteger quantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlInteger target = null;
                target = (org.apache.xmlbeans.XmlInteger)get_store().find_element_user(QUANTITY$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlInteger)get_store().add_element_user(QUANTITY$6);
                }
                target.set(quantity);
            }
        }
        
        /**
         * Gets the "UOM" element
         */
        public java.lang.String getUOM()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOM$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOM" element
         */
        public org.apache.xmlbeans.XmlString xgetUOM()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOM$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOM" element
         */
        public void setUOM(java.lang.String uom)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOM$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOM$8);
                }
                target.setStringValue(uom);
            }
        }
        
        /**
         * Sets (as xml) the "UOM" element
         */
        public void xsetUOM(org.apache.xmlbeans.XmlString uom)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOM$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOM$8);
                }
                target.set(uom);
            }
        }
    }
}
