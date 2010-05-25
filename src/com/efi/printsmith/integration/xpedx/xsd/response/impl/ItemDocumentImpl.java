/*
 * An XML document type.
 * Localname: Item
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response.impl;
/**
 * A document containing one Item(@) element.
 *
 * This is a complex type.
 */
public class ItemDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument
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
    public com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item getItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item)get_store().find_element_user(ITEM$0, 0);
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
    public void setItem(com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item item)
    {
        generatedSetterHelperImpl(item, ITEM$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Item" element
     */
    public com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item addNewItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item target = null;
            target = (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item)get_store().add_element_user(ITEM$0);
            return target;
        }
    }
    /**
     * An XML Item(@).
     *
     * This is a complex type.
     */
    public static class ItemImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item
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
        private static final javax.xml.namespace.QName UNITOFMEASURE$8 = 
            new javax.xml.namespace.QName("", "UnitOfMeasure");
        private static final javax.xml.namespace.QName ERRORCODE$10 = 
            new javax.xml.namespace.QName("", "ErrorCode");
        private static final javax.xml.namespace.QName ERRORMESSAGE$12 = 
            new javax.xml.namespace.QName("", "ErrorMessage");
        private static final javax.xml.namespace.QName CUSTOMERNUMBER$14 = 
            new javax.xml.namespace.QName("", "CustomerNumber");
        private static final javax.xml.namespace.QName CATEGORY1$16 = 
            new javax.xml.namespace.QName("", "Category1");
        private static final javax.xml.namespace.QName CATEGORY2$18 = 
            new javax.xml.namespace.QName("", "Category2");
        private static final javax.xml.namespace.QName CATEGORY3$20 = 
            new javax.xml.namespace.QName("", "Category3");
        private static final javax.xml.namespace.QName CATEGORY4$22 = 
            new javax.xml.namespace.QName("", "Category4");
        private static final javax.xml.namespace.QName PUN$24 = 
            new javax.xml.namespace.QName("", "PUN");
        private static final javax.xml.namespace.QName ITEMDESCRIPTION$26 = 
            new javax.xml.namespace.QName("", "ItemDescription");
        private static final javax.xml.namespace.QName ITEMSELLTEXT$28 = 
            new javax.xml.namespace.QName("", "ItemSellText");
        private static final javax.xml.namespace.QName AVAILABILITYMESSAGE$30 = 
            new javax.xml.namespace.QName("", "AvailabilityMessage");
        private static final javax.xml.namespace.QName BACKORDERMESSAGE$32 = 
            new javax.xml.namespace.QName("", "BackOrderMessage");
        private static final javax.xml.namespace.QName SAMEDAYDESCRIPTION$34 = 
            new javax.xml.namespace.QName("", "SameDayDescription");
        private static final javax.xml.namespace.QName SAMEDAYQUANTITY$36 = 
            new javax.xml.namespace.QName("", "SameDayQuantity");
        private static final javax.xml.namespace.QName NEXTDAYDESCRIPTION$38 = 
            new javax.xml.namespace.QName("", "NextDayDescription");
        private static final javax.xml.namespace.QName NEXTDAYQUANTITY$40 = 
            new javax.xml.namespace.QName("", "NextDayQuantity");
        private static final javax.xml.namespace.QName TWODAYDESCRIPTION$42 = 
            new javax.xml.namespace.QName("", "TwoDayDescription");
        private static final javax.xml.namespace.QName TWODAYQUANTITY$44 = 
            new javax.xml.namespace.QName("", "TwoDayQuantity");
        private static final javax.xml.namespace.QName ORDERMULTIPLE$46 = 
            new javax.xml.namespace.QName("", "OrderMultiple");
        private static final javax.xml.namespace.QName ORDERMULTIPLEMESSAGE$48 = 
            new javax.xml.namespace.QName("", "OrderMultipleMessage");
        private static final javax.xml.namespace.QName TOTALPRICE$50 = 
            new javax.xml.namespace.QName("", "TotalPrice");
        private static final javax.xml.namespace.QName MANUFACTURER$52 = 
            new javax.xml.namespace.QName("", "Manufacturer");
        private static final javax.xml.namespace.QName MANUFACTURERPARTNUMBER$54 = 
            new javax.xml.namespace.QName("", "ManufacturerPartNumber");
        private static final javax.xml.namespace.QName ITEMSTATUS$56 = 
            new javax.xml.namespace.QName("", "ItemStatus");
        private static final javax.xml.namespace.QName UNITPRICE1$58 = 
            new javax.xml.namespace.QName("", "UnitPrice1");
        private static final javax.xml.namespace.QName UNITPRICE2$60 = 
            new javax.xml.namespace.QName("", "UnitPrice2");
        private static final javax.xml.namespace.QName UNITPRICEN$62 = 
            new javax.xml.namespace.QName("", "UnitPrice..n");
        private static final javax.xml.namespace.QName UOMCODE1$64 = 
            new javax.xml.namespace.QName("", "UOMCode1");
        private static final javax.xml.namespace.QName UOMDESCRIPTION1$66 = 
            new javax.xml.namespace.QName("", "UOMDescription1");
        private static final javax.xml.namespace.QName UOMCODE2$68 = 
            new javax.xml.namespace.QName("", "UOMCode2");
        private static final javax.xml.namespace.QName UOMDESCRIPTION2$70 = 
            new javax.xml.namespace.QName("", "UOMDescription2");
        private static final javax.xml.namespace.QName UOMCODEN$72 = 
            new javax.xml.namespace.QName("", "UOMCode..n");
        private static final javax.xml.namespace.QName UOMDESCRIPTIONN$74 = 
            new javax.xml.namespace.QName("", "UOMDescription..n");
        private static final javax.xml.namespace.QName CATALOGATTRIBUTENAME1$76 = 
            new javax.xml.namespace.QName("", "CatalogAttributeName1");
        private static final javax.xml.namespace.QName CATALOGATTRIBUTEVALUE1$78 = 
            new javax.xml.namespace.QName("", "CatalogAttributeValue1");
        
        
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
        public java.lang.String getQuantity()
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
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Quantity" element
         */
        public org.apache.xmlbeans.XmlString xgetQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(QUANTITY$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Quantity" element
         */
        public void setQuantity(java.lang.String quantity)
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
                target.setStringValue(quantity);
            }
        }
        
        /**
         * Sets (as xml) the "Quantity" element
         */
        public void xsetQuantity(org.apache.xmlbeans.XmlString quantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(QUANTITY$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(QUANTITY$6);
                }
                target.set(quantity);
            }
        }
        
        /**
         * Gets the "UnitOfMeasure" element
         */
        public java.lang.String getUnitOfMeasure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITOFMEASURE$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UnitOfMeasure" element
         */
        public org.apache.xmlbeans.XmlString xgetUnitOfMeasure()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITOFMEASURE$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UnitOfMeasure" element
         */
        public void setUnitOfMeasure(java.lang.String unitOfMeasure)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITOFMEASURE$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITOFMEASURE$8);
                }
                target.setStringValue(unitOfMeasure);
            }
        }
        
        /**
         * Sets (as xml) the "UnitOfMeasure" element
         */
        public void xsetUnitOfMeasure(org.apache.xmlbeans.XmlString unitOfMeasure)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITOFMEASURE$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITOFMEASURE$8);
                }
                target.set(unitOfMeasure);
            }
        }
        
        /**
         * Gets the "ErrorCode" element
         */
        public java.lang.String getErrorCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$10, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$10, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORCODE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORCODE$10);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORCODE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORCODE$10);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$12, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$12, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ERRORMESSAGE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ERRORMESSAGE$12);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ERRORMESSAGE$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ERRORMESSAGE$12);
                }
                target.set(errorMessage);
            }
        }
        
        /**
         * Gets the "CustomerNumber" element
         */
        public java.lang.String getCustomerNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERNUMBER$14, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CustomerNumber" element
         */
        public org.apache.xmlbeans.XmlString xgetCustomerNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERNUMBER$14, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CustomerNumber" element
         */
        public void setCustomerNumber(java.lang.String customerNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CUSTOMERNUMBER$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CUSTOMERNUMBER$14);
                }
                target.setStringValue(customerNumber);
            }
        }
        
        /**
         * Sets (as xml) the "CustomerNumber" element
         */
        public void xsetCustomerNumber(org.apache.xmlbeans.XmlString customerNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CUSTOMERNUMBER$14, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CUSTOMERNUMBER$14);
                }
                target.set(customerNumber);
            }
        }
        
        /**
         * Gets the "Category1" element
         */
        public java.lang.String getCategory1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY1$16, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Category1" element
         */
        public org.apache.xmlbeans.XmlString xgetCategory1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY1$16, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Category1" element
         */
        public void setCategory1(java.lang.String category1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY1$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY1$16);
                }
                target.setStringValue(category1);
            }
        }
        
        /**
         * Sets (as xml) the "Category1" element
         */
        public void xsetCategory1(org.apache.xmlbeans.XmlString category1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY1$16, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY1$16);
                }
                target.set(category1);
            }
        }
        
        /**
         * Gets the "Category2" element
         */
        public java.lang.String getCategory2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY2$18, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Category2" element
         */
        public org.apache.xmlbeans.XmlString xgetCategory2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY2$18, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Category2" element
         */
        public void setCategory2(java.lang.String category2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY2$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY2$18);
                }
                target.setStringValue(category2);
            }
        }
        
        /**
         * Sets (as xml) the "Category2" element
         */
        public void xsetCategory2(org.apache.xmlbeans.XmlString category2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY2$18, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY2$18);
                }
                target.set(category2);
            }
        }
        
        /**
         * Gets the "Category3" element
         */
        public java.lang.String getCategory3()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY3$20, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Category3" element
         */
        public org.apache.xmlbeans.XmlString xgetCategory3()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY3$20, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Category3" element
         */
        public void setCategory3(java.lang.String category3)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY3$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY3$20);
                }
                target.setStringValue(category3);
            }
        }
        
        /**
         * Sets (as xml) the "Category3" element
         */
        public void xsetCategory3(org.apache.xmlbeans.XmlString category3)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY3$20, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY3$20);
                }
                target.set(category3);
            }
        }
        
        /**
         * Gets the "Category4" element
         */
        public java.lang.String getCategory4()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY4$22, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Category4" element
         */
        public org.apache.xmlbeans.XmlString xgetCategory4()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY4$22, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Category4" element
         */
        public void setCategory4(java.lang.String category4)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATEGORY4$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATEGORY4$22);
                }
                target.setStringValue(category4);
            }
        }
        
        /**
         * Sets (as xml) the "Category4" element
         */
        public void xsetCategory4(org.apache.xmlbeans.XmlString category4)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATEGORY4$22, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATEGORY4$22);
                }
                target.set(category4);
            }
        }
        
        /**
         * Gets the "PUN" element
         */
        public java.lang.String getPUN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUN$24, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "PUN" element
         */
        public org.apache.xmlbeans.XmlString xgetPUN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUN$24, 0);
                return target;
            }
        }
        
        /**
         * Sets the "PUN" element
         */
        public void setPUN(java.lang.String pun)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PUN$24, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PUN$24);
                }
                target.setStringValue(pun);
            }
        }
        
        /**
         * Sets (as xml) the "PUN" element
         */
        public void xsetPUN(org.apache.xmlbeans.XmlString pun)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PUN$24, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PUN$24);
                }
                target.set(pun);
            }
        }
        
        /**
         * Gets the "ItemDescription" element
         */
        public java.lang.String getItemDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMDESCRIPTION$26, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ItemDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetItemDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMDESCRIPTION$26, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ItemDescription" element
         */
        public void setItemDescription(java.lang.String itemDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMDESCRIPTION$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMDESCRIPTION$26);
                }
                target.setStringValue(itemDescription);
            }
        }
        
        /**
         * Sets (as xml) the "ItemDescription" element
         */
        public void xsetItemDescription(org.apache.xmlbeans.XmlString itemDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMDESCRIPTION$26, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMDESCRIPTION$26);
                }
                target.set(itemDescription);
            }
        }
        
        /**
         * Gets the "ItemSellText" element
         */
        public java.lang.String getItemSellText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSELLTEXT$28, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ItemSellText" element
         */
        public org.apache.xmlbeans.XmlString xgetItemSellText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSELLTEXT$28, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ItemSellText" element
         */
        public void setItemSellText(java.lang.String itemSellText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSELLTEXT$28, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMSELLTEXT$28);
                }
                target.setStringValue(itemSellText);
            }
        }
        
        /**
         * Sets (as xml) the "ItemSellText" element
         */
        public void xsetItemSellText(org.apache.xmlbeans.XmlString itemSellText)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSELLTEXT$28, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMSELLTEXT$28);
                }
                target.set(itemSellText);
            }
        }
        
        /**
         * Gets the "AvailabilityMessage" element
         */
        public java.lang.String getAvailabilityMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYMESSAGE$30, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "AvailabilityMessage" element
         */
        public org.apache.xmlbeans.XmlString xgetAvailabilityMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYMESSAGE$30, 0);
                return target;
            }
        }
        
        /**
         * Sets the "AvailabilityMessage" element
         */
        public void setAvailabilityMessage(java.lang.String availabilityMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(AVAILABILITYMESSAGE$30, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(AVAILABILITYMESSAGE$30);
                }
                target.setStringValue(availabilityMessage);
            }
        }
        
        /**
         * Sets (as xml) the "AvailabilityMessage" element
         */
        public void xsetAvailabilityMessage(org.apache.xmlbeans.XmlString availabilityMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(AVAILABILITYMESSAGE$30, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(AVAILABILITYMESSAGE$30);
                }
                target.set(availabilityMessage);
            }
        }
        
        /**
         * Gets the "BackOrderMessage" element
         */
        public java.lang.String getBackOrderMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BACKORDERMESSAGE$32, 0);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BACKORDERMESSAGE$32, 0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BACKORDERMESSAGE$32, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BACKORDERMESSAGE$32);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BACKORDERMESSAGE$32, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BACKORDERMESSAGE$32);
                }
                target.set(backOrderMessage);
            }
        }
        
        /**
         * Gets the "SameDayDescription" element
         */
        public java.lang.String getSameDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYDESCRIPTION$34, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SameDayDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetSameDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYDESCRIPTION$34, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SameDayDescription" element
         */
        public void setSameDayDescription(java.lang.String sameDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYDESCRIPTION$34, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SAMEDAYDESCRIPTION$34);
                }
                target.setStringValue(sameDayDescription);
            }
        }
        
        /**
         * Sets (as xml) the "SameDayDescription" element
         */
        public void xsetSameDayDescription(org.apache.xmlbeans.XmlString sameDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYDESCRIPTION$34, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SAMEDAYDESCRIPTION$34);
                }
                target.set(sameDayDescription);
            }
        }
        
        /**
         * Gets the "SameDayQuantity" element
         */
        public java.lang.String getSameDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYQUANTITY$36, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "SameDayQuantity" element
         */
        public org.apache.xmlbeans.XmlString xgetSameDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYQUANTITY$36, 0);
                return target;
            }
        }
        
        /**
         * Sets the "SameDayQuantity" element
         */
        public void setSameDayQuantity(java.lang.String sameDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SAMEDAYQUANTITY$36, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SAMEDAYQUANTITY$36);
                }
                target.setStringValue(sameDayQuantity);
            }
        }
        
        /**
         * Sets (as xml) the "SameDayQuantity" element
         */
        public void xsetSameDayQuantity(org.apache.xmlbeans.XmlString sameDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SAMEDAYQUANTITY$36, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SAMEDAYQUANTITY$36);
                }
                target.set(sameDayQuantity);
            }
        }
        
        /**
         * Gets the "NextDayDescription" element
         */
        public java.lang.String getNextDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYDESCRIPTION$38, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "NextDayDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetNextDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYDESCRIPTION$38, 0);
                return target;
            }
        }
        
        /**
         * Sets the "NextDayDescription" element
         */
        public void setNextDayDescription(java.lang.String nextDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYDESCRIPTION$38, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTDAYDESCRIPTION$38);
                }
                target.setStringValue(nextDayDescription);
            }
        }
        
        /**
         * Sets (as xml) the "NextDayDescription" element
         */
        public void xsetNextDayDescription(org.apache.xmlbeans.XmlString nextDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYDESCRIPTION$38, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTDAYDESCRIPTION$38);
                }
                target.set(nextDayDescription);
            }
        }
        
        /**
         * Gets the "NextDayQuantity" element
         */
        public java.lang.String getNextDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYQUANTITY$40, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "NextDayQuantity" element
         */
        public org.apache.xmlbeans.XmlString xgetNextDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYQUANTITY$40, 0);
                return target;
            }
        }
        
        /**
         * Sets the "NextDayQuantity" element
         */
        public void setNextDayQuantity(java.lang.String nextDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NEXTDAYQUANTITY$40, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NEXTDAYQUANTITY$40);
                }
                target.setStringValue(nextDayQuantity);
            }
        }
        
        /**
         * Sets (as xml) the "NextDayQuantity" element
         */
        public void xsetNextDayQuantity(org.apache.xmlbeans.XmlString nextDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NEXTDAYQUANTITY$40, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NEXTDAYQUANTITY$40);
                }
                target.set(nextDayQuantity);
            }
        }
        
        /**
         * Gets the "TwoDayDescription" element
         */
        public java.lang.String getTwoDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYDESCRIPTION$42, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "TwoDayDescription" element
         */
        public org.apache.xmlbeans.XmlString xgetTwoDayDescription()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYDESCRIPTION$42, 0);
                return target;
            }
        }
        
        /**
         * Sets the "TwoDayDescription" element
         */
        public void setTwoDayDescription(java.lang.String twoDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYDESCRIPTION$42, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TWODAYDESCRIPTION$42);
                }
                target.setStringValue(twoDayDescription);
            }
        }
        
        /**
         * Sets (as xml) the "TwoDayDescription" element
         */
        public void xsetTwoDayDescription(org.apache.xmlbeans.XmlString twoDayDescription)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYDESCRIPTION$42, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TWODAYDESCRIPTION$42);
                }
                target.set(twoDayDescription);
            }
        }
        
        /**
         * Gets the "TwoDayQuantity" element
         */
        public java.lang.String getTwoDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYQUANTITY$44, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "TwoDayQuantity" element
         */
        public org.apache.xmlbeans.XmlString xgetTwoDayQuantity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYQUANTITY$44, 0);
                return target;
            }
        }
        
        /**
         * Sets the "TwoDayQuantity" element
         */
        public void setTwoDayQuantity(java.lang.String twoDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TWODAYQUANTITY$44, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TWODAYQUANTITY$44);
                }
                target.setStringValue(twoDayQuantity);
            }
        }
        
        /**
         * Sets (as xml) the "TwoDayQuantity" element
         */
        public void xsetTwoDayQuantity(org.apache.xmlbeans.XmlString twoDayQuantity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TWODAYQUANTITY$44, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TWODAYQUANTITY$44);
                }
                target.set(twoDayQuantity);
            }
        }
        
        /**
         * Gets the "OrderMultiple" element
         */
        public java.lang.String getOrderMultiple()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLE$46, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "OrderMultiple" element
         */
        public org.apache.xmlbeans.XmlString xgetOrderMultiple()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLE$46, 0);
                return target;
            }
        }
        
        /**
         * Sets the "OrderMultiple" element
         */
        public void setOrderMultiple(java.lang.String orderMultiple)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLE$46, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORDERMULTIPLE$46);
                }
                target.setStringValue(orderMultiple);
            }
        }
        
        /**
         * Sets (as xml) the "OrderMultiple" element
         */
        public void xsetOrderMultiple(org.apache.xmlbeans.XmlString orderMultiple)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLE$46, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORDERMULTIPLE$46);
                }
                target.set(orderMultiple);
            }
        }
        
        /**
         * Gets the "OrderMultipleMessage" element
         */
        public java.lang.String getOrderMultipleMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLEMESSAGE$48, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "OrderMultipleMessage" element
         */
        public org.apache.xmlbeans.XmlString xgetOrderMultipleMessage()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLEMESSAGE$48, 0);
                return target;
            }
        }
        
        /**
         * Sets the "OrderMultipleMessage" element
         */
        public void setOrderMultipleMessage(java.lang.String orderMultipleMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ORDERMULTIPLEMESSAGE$48, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ORDERMULTIPLEMESSAGE$48);
                }
                target.setStringValue(orderMultipleMessage);
            }
        }
        
        /**
         * Sets (as xml) the "OrderMultipleMessage" element
         */
        public void xsetOrderMultipleMessage(org.apache.xmlbeans.XmlString orderMultipleMessage)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ORDERMULTIPLEMESSAGE$48, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ORDERMULTIPLEMESSAGE$48);
                }
                target.set(orderMultipleMessage);
            }
        }
        
        /**
         * Gets the "TotalPrice" element
         */
        public java.lang.String getTotalPrice()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALPRICE$50, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "TotalPrice" element
         */
        public org.apache.xmlbeans.XmlString xgetTotalPrice()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOTALPRICE$50, 0);
                return target;
            }
        }
        
        /**
         * Sets the "TotalPrice" element
         */
        public void setTotalPrice(java.lang.String totalPrice)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TOTALPRICE$50, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TOTALPRICE$50);
                }
                target.setStringValue(totalPrice);
            }
        }
        
        /**
         * Sets (as xml) the "TotalPrice" element
         */
        public void xsetTotalPrice(org.apache.xmlbeans.XmlString totalPrice)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TOTALPRICE$50, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TOTALPRICE$50);
                }
                target.set(totalPrice);
            }
        }
        
        /**
         * Gets the "Manufacturer" element
         */
        public java.lang.String getManufacturer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$52, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Manufacturer" element
         */
        public org.apache.xmlbeans.XmlString xgetManufacturer()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$52, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Manufacturer" element
         */
        public void setManufacturer(java.lang.String manufacturer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURER$52, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MANUFACTURER$52);
                }
                target.setStringValue(manufacturer);
            }
        }
        
        /**
         * Sets (as xml) the "Manufacturer" element
         */
        public void xsetManufacturer(org.apache.xmlbeans.XmlString manufacturer)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURER$52, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MANUFACTURER$52);
                }
                target.set(manufacturer);
            }
        }
        
        /**
         * Gets the "ManufacturerPartNumber" element
         */
        public java.lang.String getManufacturerPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURERPARTNUMBER$54, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ManufacturerPartNumber" element
         */
        public org.apache.xmlbeans.XmlString xgetManufacturerPartNumber()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURERPARTNUMBER$54, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ManufacturerPartNumber" element
         */
        public void setManufacturerPartNumber(java.lang.String manufacturerPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MANUFACTURERPARTNUMBER$54, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MANUFACTURERPARTNUMBER$54);
                }
                target.setStringValue(manufacturerPartNumber);
            }
        }
        
        /**
         * Sets (as xml) the "ManufacturerPartNumber" element
         */
        public void xsetManufacturerPartNumber(org.apache.xmlbeans.XmlString manufacturerPartNumber)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MANUFACTURERPARTNUMBER$54, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MANUFACTURERPARTNUMBER$54);
                }
                target.set(manufacturerPartNumber);
            }
        }
        
        /**
         * Gets the "ItemStatus" element
         */
        public java.lang.String getItemStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSTATUS$56, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ItemStatus" element
         */
        public org.apache.xmlbeans.XmlString xgetItemStatus()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSTATUS$56, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ItemStatus" element
         */
        public void setItemStatus(java.lang.String itemStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ITEMSTATUS$56, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ITEMSTATUS$56);
                }
                target.setStringValue(itemStatus);
            }
        }
        
        /**
         * Sets (as xml) the "ItemStatus" element
         */
        public void xsetItemStatus(org.apache.xmlbeans.XmlString itemStatus)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ITEMSTATUS$56, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ITEMSTATUS$56);
                }
                target.set(itemStatus);
            }
        }
        
        /**
         * Gets the "UnitPrice1" element
         */
        public java.lang.String getUnitPrice1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE1$58, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UnitPrice1" element
         */
        public org.apache.xmlbeans.XmlString xgetUnitPrice1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE1$58, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UnitPrice1" element
         */
        public void setUnitPrice1(java.lang.String unitPrice1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE1$58, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICE1$58);
                }
                target.setStringValue(unitPrice1);
            }
        }
        
        /**
         * Sets (as xml) the "UnitPrice1" element
         */
        public void xsetUnitPrice1(org.apache.xmlbeans.XmlString unitPrice1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE1$58, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICE1$58);
                }
                target.set(unitPrice1);
            }
        }
        
        /**
         * Gets the "UnitPrice2" element
         */
        public java.lang.String getUnitPrice2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE2$60, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UnitPrice2" element
         */
        public org.apache.xmlbeans.XmlString xgetUnitPrice2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE2$60, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UnitPrice2" element
         */
        public void setUnitPrice2(java.lang.String unitPrice2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICE2$60, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICE2$60);
                }
                target.setStringValue(unitPrice2);
            }
        }
        
        /**
         * Sets (as xml) the "UnitPrice2" element
         */
        public void xsetUnitPrice2(org.apache.xmlbeans.XmlString unitPrice2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICE2$60, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICE2$60);
                }
                target.set(unitPrice2);
            }
        }
        
        /**
         * Gets the "UnitPrice..n" element
         */
        public java.lang.String getUnitPriceN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICEN$62, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UnitPrice..n" element
         */
        public org.apache.xmlbeans.XmlString xgetUnitPriceN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICEN$62, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UnitPrice..n" element
         */
        public void setUnitPriceN(java.lang.String unitPriceN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UNITPRICEN$62, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UNITPRICEN$62);
                }
                target.setStringValue(unitPriceN);
            }
        }
        
        /**
         * Sets (as xml) the "UnitPrice..n" element
         */
        public void xsetUnitPriceN(org.apache.xmlbeans.XmlString unitPriceN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UNITPRICEN$62, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UNITPRICEN$62);
                }
                target.set(unitPriceN);
            }
        }
        
        /**
         * Gets the "UOMCode1" element
         */
        public java.lang.String getUOMCode1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE1$64, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMCode1" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMCode1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE1$64, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMCode1" element
         */
        public void setUOMCode1(java.lang.String uomCode1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE1$64, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODE1$64);
                }
                target.setStringValue(uomCode1);
            }
        }
        
        /**
         * Sets (as xml) the "UOMCode1" element
         */
        public void xsetUOMCode1(org.apache.xmlbeans.XmlString uomCode1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE1$64, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODE1$64);
                }
                target.set(uomCode1);
            }
        }
        
        /**
         * Gets the "UOMDescription1" element
         */
        public java.lang.String getUOMDescription1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION1$66, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMDescription1" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMDescription1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION1$66, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMDescription1" element
         */
        public void setUOMDescription1(java.lang.String uomDescription1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION1$66, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTION1$66);
                }
                target.setStringValue(uomDescription1);
            }
        }
        
        /**
         * Sets (as xml) the "UOMDescription1" element
         */
        public void xsetUOMDescription1(org.apache.xmlbeans.XmlString uomDescription1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION1$66, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTION1$66);
                }
                target.set(uomDescription1);
            }
        }
        
        /**
         * Gets the "UOMCode2" element
         */
        public java.lang.String getUOMCode2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE2$68, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMCode2" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMCode2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE2$68, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMCode2" element
         */
        public void setUOMCode2(java.lang.String uomCode2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODE2$68, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODE2$68);
                }
                target.setStringValue(uomCode2);
            }
        }
        
        /**
         * Sets (as xml) the "UOMCode2" element
         */
        public void xsetUOMCode2(org.apache.xmlbeans.XmlString uomCode2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODE2$68, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODE2$68);
                }
                target.set(uomCode2);
            }
        }
        
        /**
         * Gets the "UOMDescription2" element
         */
        public java.lang.String getUOMDescription2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION2$70, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMDescription2" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMDescription2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION2$70, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMDescription2" element
         */
        public void setUOMDescription2(java.lang.String uomDescription2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTION2$70, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTION2$70);
                }
                target.setStringValue(uomDescription2);
            }
        }
        
        /**
         * Sets (as xml) the "UOMDescription2" element
         */
        public void xsetUOMDescription2(org.apache.xmlbeans.XmlString uomDescription2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTION2$70, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTION2$70);
                }
                target.set(uomDescription2);
            }
        }
        
        /**
         * Gets the "UOMCode..n" element
         */
        public java.lang.String getUOMCodeN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODEN$72, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMCode..n" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMCodeN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODEN$72, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMCode..n" element
         */
        public void setUOMCodeN(java.lang.String uomCodeN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMCODEN$72, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMCODEN$72);
                }
                target.setStringValue(uomCodeN);
            }
        }
        
        /**
         * Sets (as xml) the "UOMCode..n" element
         */
        public void xsetUOMCodeN(org.apache.xmlbeans.XmlString uomCodeN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMCODEN$72, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMCODEN$72);
                }
                target.set(uomCodeN);
            }
        }
        
        /**
         * Gets the "UOMDescription..n" element
         */
        public java.lang.String getUOMDescriptionN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTIONN$74, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "UOMDescription..n" element
         */
        public org.apache.xmlbeans.XmlString xgetUOMDescriptionN()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTIONN$74, 0);
                return target;
            }
        }
        
        /**
         * Sets the "UOMDescription..n" element
         */
        public void setUOMDescriptionN(java.lang.String uomDescriptionN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(UOMDESCRIPTIONN$74, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(UOMDESCRIPTIONN$74);
                }
                target.setStringValue(uomDescriptionN);
            }
        }
        
        /**
         * Sets (as xml) the "UOMDescription..n" element
         */
        public void xsetUOMDescriptionN(org.apache.xmlbeans.XmlString uomDescriptionN)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(UOMDESCRIPTIONN$74, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(UOMDESCRIPTIONN$74);
                }
                target.set(uomDescriptionN);
            }
        }
        
        /**
         * Gets the "CatalogAttributeName1" element
         */
        public java.lang.String getCatalogAttributeName1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTENAME1$76, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CatalogAttributeName1" element
         */
        public org.apache.xmlbeans.XmlString xgetCatalogAttributeName1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTENAME1$76, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CatalogAttributeName1" element
         */
        public void setCatalogAttributeName1(java.lang.String catalogAttributeName1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTENAME1$76, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATALOGATTRIBUTENAME1$76);
                }
                target.setStringValue(catalogAttributeName1);
            }
        }
        
        /**
         * Sets (as xml) the "CatalogAttributeName1" element
         */
        public void xsetCatalogAttributeName1(org.apache.xmlbeans.XmlString catalogAttributeName1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTENAME1$76, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATALOGATTRIBUTENAME1$76);
                }
                target.set(catalogAttributeName1);
            }
        }
        
        /**
         * Gets the "CatalogAttributeValue1" element
         */
        public java.lang.String getCatalogAttributeValue1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$78, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "CatalogAttributeValue1" element
         */
        public org.apache.xmlbeans.XmlString xgetCatalogAttributeValue1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$78, 0);
                return target;
            }
        }
        
        /**
         * Sets the "CatalogAttributeValue1" element
         */
        public void setCatalogAttributeValue1(java.lang.String catalogAttributeValue1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$78, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CATALOGATTRIBUTEVALUE1$78);
                }
                target.setStringValue(catalogAttributeValue1);
            }
        }
        
        /**
         * Sets (as xml) the "CatalogAttributeValue1" element
         */
        public void xsetCatalogAttributeValue1(org.apache.xmlbeans.XmlString catalogAttributeValue1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CATALOGATTRIBUTEVALUE1$78, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CATALOGATTRIBUTEVALUE1$78);
                }
                target.set(catalogAttributeValue1);
            }
        }
    }
}
