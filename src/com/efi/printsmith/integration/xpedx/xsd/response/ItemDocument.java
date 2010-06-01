/*
 * An XML document type.
 * Localname: Item
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response;


/**
 * A document containing one Item(@) element.
 *
 * This is a complex type.
 */
public interface ItemDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ItemDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s04547F11DB3F13AB93484CE8440F8EA9").resolveHandle("item132cdoctype");
    
    /**
     * Gets the "Item" element
     */
    com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item getItem();
    
    /**
     * Sets the "Item" element
     */
    void setItem(com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item item);
    
    /**
     * Appends and returns a new empty "Item" element
     */
    com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item addNewItem();
    
    /**
     * An XML Item(@).
     *
     * This is a complex type.
     */
    public interface Item extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s04547F11DB3F13AB93484CE8440F8EA9").resolveHandle("item788delemtype");
        
        /**
         * Gets the "IndexID" element
         */
        java.lang.String getIndexID();
        
        /**
         * Gets (as xml) the "IndexID" element
         */
        org.apache.xmlbeans.XmlString xgetIndexID();
        
        /**
         * Sets the "IndexID" element
         */
        void setIndexID(java.lang.String indexID);
        
        /**
         * Sets (as xml) the "IndexID" element
         */
        void xsetIndexID(org.apache.xmlbeans.XmlString indexID);
        
        /**
         * Gets the "xpedxPartNumber" element
         */
        java.lang.String getXpedxPartNumber();
        
        /**
         * Gets (as xml) the "xpedxPartNumber" element
         */
        org.apache.xmlbeans.XmlString xgetXpedxPartNumber();
        
        /**
         * Sets the "xpedxPartNumber" element
         */
        void setXpedxPartNumber(java.lang.String xpedxPartNumber);
        
        /**
         * Sets (as xml) the "xpedxPartNumber" element
         */
        void xsetXpedxPartNumber(org.apache.xmlbeans.XmlString xpedxPartNumber);
        
        /**
         * Gets the "CustomerPartNumber" element
         */
        java.lang.String getCustomerPartNumber();
        
        /**
         * Gets (as xml) the "CustomerPartNumber" element
         */
        org.apache.xmlbeans.XmlString xgetCustomerPartNumber();
        
        /**
         * Sets the "CustomerPartNumber" element
         */
        void setCustomerPartNumber(java.lang.String customerPartNumber);
        
        /**
         * Sets (as xml) the "CustomerPartNumber" element
         */
        void xsetCustomerPartNumber(org.apache.xmlbeans.XmlString customerPartNumber);
        
        /**
         * Gets the "Quantity" element
         */
        java.lang.String getQuantity();
        
        /**
         * Gets (as xml) the "Quantity" element
         */
        org.apache.xmlbeans.XmlString xgetQuantity();
        
        /**
         * Sets the "Quantity" element
         */
        void setQuantity(java.lang.String quantity);
        
        /**
         * Sets (as xml) the "Quantity" element
         */
        void xsetQuantity(org.apache.xmlbeans.XmlString quantity);
        
        /**
         * Gets the "UnitOfMeasure" element
         */
        java.lang.String getUnitOfMeasure();
        
        /**
         * Gets (as xml) the "UnitOfMeasure" element
         */
        org.apache.xmlbeans.XmlString xgetUnitOfMeasure();
        
        /**
         * Sets the "UnitOfMeasure" element
         */
        void setUnitOfMeasure(java.lang.String unitOfMeasure);
        
        /**
         * Sets (as xml) the "UnitOfMeasure" element
         */
        void xsetUnitOfMeasure(org.apache.xmlbeans.XmlString unitOfMeasure);
        
        /**
         * Gets the "ErrorCode" element
         */
        java.lang.String getErrorCode();
        
        /**
         * Gets (as xml) the "ErrorCode" element
         */
        org.apache.xmlbeans.XmlString xgetErrorCode();
        
        /**
         * Sets the "ErrorCode" element
         */
        void setErrorCode(java.lang.String errorCode);
        
        /**
         * Sets (as xml) the "ErrorCode" element
         */
        void xsetErrorCode(org.apache.xmlbeans.XmlString errorCode);
        
        /**
         * Gets the "ErrorMessage" element
         */
        java.lang.String getErrorMessage();
        
        /**
         * Gets (as xml) the "ErrorMessage" element
         */
        org.apache.xmlbeans.XmlString xgetErrorMessage();
        
        /**
         * Sets the "ErrorMessage" element
         */
        void setErrorMessage(java.lang.String errorMessage);
        
        /**
         * Sets (as xml) the "ErrorMessage" element
         */
        void xsetErrorMessage(org.apache.xmlbeans.XmlString errorMessage);
        
        /**
         * Gets the "CustomerNumber" element
         */
        java.lang.String getCustomerNumber();
        
        /**
         * Gets (as xml) the "CustomerNumber" element
         */
        org.apache.xmlbeans.XmlString xgetCustomerNumber();
        
        /**
         * Sets the "CustomerNumber" element
         */
        void setCustomerNumber(java.lang.String customerNumber);
        
        /**
         * Sets (as xml) the "CustomerNumber" element
         */
        void xsetCustomerNumber(org.apache.xmlbeans.XmlString customerNumber);
        
        /**
         * Gets the "Category1" element
         */
        java.lang.String getCategory1();
        
        /**
         * Gets (as xml) the "Category1" element
         */
        org.apache.xmlbeans.XmlString xgetCategory1();
        
        /**
         * Sets the "Category1" element
         */
        void setCategory1(java.lang.String category1);
        
        /**
         * Sets (as xml) the "Category1" element
         */
        void xsetCategory1(org.apache.xmlbeans.XmlString category1);
        
        /**
         * Gets the "Category2" element
         */
        java.lang.String getCategory2();
        
        /**
         * Gets (as xml) the "Category2" element
         */
        org.apache.xmlbeans.XmlString xgetCategory2();
        
        /**
         * Sets the "Category2" element
         */
        void setCategory2(java.lang.String category2);
        
        /**
         * Sets (as xml) the "Category2" element
         */
        void xsetCategory2(org.apache.xmlbeans.XmlString category2);
        
        /**
         * Gets the "Category3" element
         */
        java.lang.String getCategory3();
        
        /**
         * Gets (as xml) the "Category3" element
         */
        org.apache.xmlbeans.XmlString xgetCategory3();
        
        /**
         * Sets the "Category3" element
         */
        void setCategory3(java.lang.String category3);
        
        /**
         * Sets (as xml) the "Category3" element
         */
        void xsetCategory3(org.apache.xmlbeans.XmlString category3);
        
        /**
         * Gets the "Category4" element
         */
        java.lang.String getCategory4();
        
        /**
         * Gets (as xml) the "Category4" element
         */
        org.apache.xmlbeans.XmlString xgetCategory4();
        
        /**
         * Sets the "Category4" element
         */
        void setCategory4(java.lang.String category4);
        
        /**
         * Sets (as xml) the "Category4" element
         */
        void xsetCategory4(org.apache.xmlbeans.XmlString category4);
        
        /**
         * Gets the "PUN" element
         */
        java.lang.String getPUN();
        
        /**
         * Gets (as xml) the "PUN" element
         */
        org.apache.xmlbeans.XmlString xgetPUN();
        
        /**
         * Sets the "PUN" element
         */
        void setPUN(java.lang.String pun);
        
        /**
         * Sets (as xml) the "PUN" element
         */
        void xsetPUN(org.apache.xmlbeans.XmlString pun);
        
        /**
         * Gets the "ItemDescription" element
         */
        java.lang.String getItemDescription();
        
        /**
         * Gets (as xml) the "ItemDescription" element
         */
        org.apache.xmlbeans.XmlString xgetItemDescription();
        
        /**
         * Sets the "ItemDescription" element
         */
        void setItemDescription(java.lang.String itemDescription);
        
        /**
         * Sets (as xml) the "ItemDescription" element
         */
        void xsetItemDescription(org.apache.xmlbeans.XmlString itemDescription);
        
        /**
         * Gets the "ItemSellText" element
         */
        java.lang.String getItemSellText();
        
        /**
         * Gets (as xml) the "ItemSellText" element
         */
        org.apache.xmlbeans.XmlString xgetItemSellText();
        
        /**
         * Sets the "ItemSellText" element
         */
        void setItemSellText(java.lang.String itemSellText);
        
        /**
         * Sets (as xml) the "ItemSellText" element
         */
        void xsetItemSellText(org.apache.xmlbeans.XmlString itemSellText);
        
        /**
         * Gets the "AvailabilityMessage" element
         */
        java.lang.String getAvailabilityMessage();
        
        /**
         * Gets (as xml) the "AvailabilityMessage" element
         */
        org.apache.xmlbeans.XmlString xgetAvailabilityMessage();
        
        /**
         * Sets the "AvailabilityMessage" element
         */
        void setAvailabilityMessage(java.lang.String availabilityMessage);
        
        /**
         * Sets (as xml) the "AvailabilityMessage" element
         */
        void xsetAvailabilityMessage(org.apache.xmlbeans.XmlString availabilityMessage);
        
        /**
         * Gets the "BackOrderMessage" element
         */
        java.lang.String getBackOrderMessage();
        
        /**
         * Gets (as xml) the "BackOrderMessage" element
         */
        org.apache.xmlbeans.XmlString xgetBackOrderMessage();
        
        /**
         * Sets the "BackOrderMessage" element
         */
        void setBackOrderMessage(java.lang.String backOrderMessage);
        
        /**
         * Sets (as xml) the "BackOrderMessage" element
         */
        void xsetBackOrderMessage(org.apache.xmlbeans.XmlString backOrderMessage);
        
        /**
         * Gets the "SameDayDescription" element
         */
        java.lang.String getSameDayDescription();
        
        /**
         * Gets (as xml) the "SameDayDescription" element
         */
        org.apache.xmlbeans.XmlString xgetSameDayDescription();
        
        /**
         * Sets the "SameDayDescription" element
         */
        void setSameDayDescription(java.lang.String sameDayDescription);
        
        /**
         * Sets (as xml) the "SameDayDescription" element
         */
        void xsetSameDayDescription(org.apache.xmlbeans.XmlString sameDayDescription);
        
        /**
         * Gets the "SameDayQuantity" element
         */
        java.lang.String getSameDayQuantity();
        
        /**
         * Gets (as xml) the "SameDayQuantity" element
         */
        org.apache.xmlbeans.XmlString xgetSameDayQuantity();
        
        /**
         * Sets the "SameDayQuantity" element
         */
        void setSameDayQuantity(java.lang.String sameDayQuantity);
        
        /**
         * Sets (as xml) the "SameDayQuantity" element
         */
        void xsetSameDayQuantity(org.apache.xmlbeans.XmlString sameDayQuantity);
        
        /**
         * Gets the "NextDayDescription" element
         */
        java.lang.String getNextDayDescription();
        
        /**
         * Gets (as xml) the "NextDayDescription" element
         */
        org.apache.xmlbeans.XmlString xgetNextDayDescription();
        
        /**
         * Sets the "NextDayDescription" element
         */
        void setNextDayDescription(java.lang.String nextDayDescription);
        
        /**
         * Sets (as xml) the "NextDayDescription" element
         */
        void xsetNextDayDescription(org.apache.xmlbeans.XmlString nextDayDescription);
        
        /**
         * Gets the "NextDayQuantity" element
         */
        java.lang.String getNextDayQuantity();
        
        /**
         * Gets (as xml) the "NextDayQuantity" element
         */
        org.apache.xmlbeans.XmlString xgetNextDayQuantity();
        
        /**
         * Sets the "NextDayQuantity" element
         */
        void setNextDayQuantity(java.lang.String nextDayQuantity);
        
        /**
         * Sets (as xml) the "NextDayQuantity" element
         */
        void xsetNextDayQuantity(org.apache.xmlbeans.XmlString nextDayQuantity);
        
        /**
         * Gets the "TwoDayDescription" element
         */
        java.lang.String getTwoDayDescription();
        
        /**
         * Gets (as xml) the "TwoDayDescription" element
         */
        org.apache.xmlbeans.XmlString xgetTwoDayDescription();
        
        /**
         * Sets the "TwoDayDescription" element
         */
        void setTwoDayDescription(java.lang.String twoDayDescription);
        
        /**
         * Sets (as xml) the "TwoDayDescription" element
         */
        void xsetTwoDayDescription(org.apache.xmlbeans.XmlString twoDayDescription);
        
        /**
         * Gets the "TwoDayQuantity" element
         */
        java.lang.String getTwoDayQuantity();
        
        /**
         * Gets (as xml) the "TwoDayQuantity" element
         */
        org.apache.xmlbeans.XmlString xgetTwoDayQuantity();
        
        /**
         * Sets the "TwoDayQuantity" element
         */
        void setTwoDayQuantity(java.lang.String twoDayQuantity);
        
        /**
         * Sets (as xml) the "TwoDayQuantity" element
         */
        void xsetTwoDayQuantity(org.apache.xmlbeans.XmlString twoDayQuantity);
        
        /**
         * Gets the "OrderMultiple" element
         */
        java.lang.String getOrderMultiple();
        
        /**
         * Gets (as xml) the "OrderMultiple" element
         */
        org.apache.xmlbeans.XmlString xgetOrderMultiple();
        
        /**
         * Sets the "OrderMultiple" element
         */
        void setOrderMultiple(java.lang.String orderMultiple);
        
        /**
         * Sets (as xml) the "OrderMultiple" element
         */
        void xsetOrderMultiple(org.apache.xmlbeans.XmlString orderMultiple);
        
        /**
         * Gets the "OrderMultipleMessage" element
         */
        java.lang.String getOrderMultipleMessage();
        
        /**
         * Gets (as xml) the "OrderMultipleMessage" element
         */
        org.apache.xmlbeans.XmlString xgetOrderMultipleMessage();
        
        /**
         * Sets the "OrderMultipleMessage" element
         */
        void setOrderMultipleMessage(java.lang.String orderMultipleMessage);
        
        /**
         * Sets (as xml) the "OrderMultipleMessage" element
         */
        void xsetOrderMultipleMessage(org.apache.xmlbeans.XmlString orderMultipleMessage);
        
        /**
         * Gets the "TotalPrice" element
         */
        java.lang.String getTotalPrice();
        
        /**
         * Gets (as xml) the "TotalPrice" element
         */
        org.apache.xmlbeans.XmlString xgetTotalPrice();
        
        /**
         * Sets the "TotalPrice" element
         */
        void setTotalPrice(java.lang.String totalPrice);
        
        /**
         * Sets (as xml) the "TotalPrice" element
         */
        void xsetTotalPrice(org.apache.xmlbeans.XmlString totalPrice);
        
        /**
         * Gets the "Manufacturer" element
         */
        java.lang.String getManufacturer();
        
        /**
         * Gets (as xml) the "Manufacturer" element
         */
        org.apache.xmlbeans.XmlString xgetManufacturer();
        
        /**
         * Sets the "Manufacturer" element
         */
        void setManufacturer(java.lang.String manufacturer);
        
        /**
         * Sets (as xml) the "Manufacturer" element
         */
        void xsetManufacturer(org.apache.xmlbeans.XmlString manufacturer);
        
        /**
         * Gets the "ManufacturerPartNumber" element
         */
        java.lang.String getManufacturerPartNumber();
        
        /**
         * Gets (as xml) the "ManufacturerPartNumber" element
         */
        org.apache.xmlbeans.XmlString xgetManufacturerPartNumber();
        
        /**
         * Sets the "ManufacturerPartNumber" element
         */
        void setManufacturerPartNumber(java.lang.String manufacturerPartNumber);
        
        /**
         * Sets (as xml) the "ManufacturerPartNumber" element
         */
        void xsetManufacturerPartNumber(org.apache.xmlbeans.XmlString manufacturerPartNumber);
        
        /**
         * Gets the "ItemStatus" element
         */
        java.lang.String getItemStatus();
        
        /**
         * Gets (as xml) the "ItemStatus" element
         */
        org.apache.xmlbeans.XmlString xgetItemStatus();
        
        /**
         * Sets the "ItemStatus" element
         */
        void setItemStatus(java.lang.String itemStatus);
        
        /**
         * Sets (as xml) the "ItemStatus" element
         */
        void xsetItemStatus(org.apache.xmlbeans.XmlString itemStatus);
        
        /**
         * Gets the "UnitPrice1" element
         */
        java.lang.String getUnitPrice1();
        
        /**
         * Gets (as xml) the "UnitPrice1" element
         */
        org.apache.xmlbeans.XmlString xgetUnitPrice1();
        
        /**
         * Sets the "UnitPrice1" element
         */
        void setUnitPrice1(java.lang.String unitPrice1);
        
        /**
         * Sets (as xml) the "UnitPrice1" element
         */
        void xsetUnitPrice1(org.apache.xmlbeans.XmlString unitPrice1);
        
        /**
         * Gets the "UnitPrice2" element
         */
        java.lang.String getUnitPrice2();
        
        /**
         * Gets (as xml) the "UnitPrice2" element
         */
        org.apache.xmlbeans.XmlString xgetUnitPrice2();
        
        /**
         * Sets the "UnitPrice2" element
         */
        void setUnitPrice2(java.lang.String unitPrice2);
        
        /**
         * Sets (as xml) the "UnitPrice2" element
         */
        void xsetUnitPrice2(org.apache.xmlbeans.XmlString unitPrice2);
        
        /**
         * Gets the "UnitPrice..n" element
         */
        java.lang.String getUnitPriceN();
        
        /**
         * Gets (as xml) the "UnitPrice..n" element
         */
        org.apache.xmlbeans.XmlString xgetUnitPriceN();
        
        /**
         * Sets the "UnitPrice..n" element
         */
        void setUnitPriceN(java.lang.String unitPriceN);
        
        /**
         * Sets (as xml) the "UnitPrice..n" element
         */
        void xsetUnitPriceN(org.apache.xmlbeans.XmlString unitPriceN);
        
        /**
         * Gets the "UOMCode1" element
         */
        java.lang.String getUOMCode1();
        
        /**
         * Gets (as xml) the "UOMCode1" element
         */
        org.apache.xmlbeans.XmlString xgetUOMCode1();
        
        /**
         * Sets the "UOMCode1" element
         */
        void setUOMCode1(java.lang.String uomCode1);
        
        /**
         * Sets (as xml) the "UOMCode1" element
         */
        void xsetUOMCode1(org.apache.xmlbeans.XmlString uomCode1);
        
        /**
         * Gets the "UOMDescription1" element
         */
        java.lang.String getUOMDescription1();
        
        /**
         * Gets (as xml) the "UOMDescription1" element
         */
        org.apache.xmlbeans.XmlString xgetUOMDescription1();
        
        /**
         * Sets the "UOMDescription1" element
         */
        void setUOMDescription1(java.lang.String uomDescription1);
        
        /**
         * Sets (as xml) the "UOMDescription1" element
         */
        void xsetUOMDescription1(org.apache.xmlbeans.XmlString uomDescription1);
        
        /**
         * Gets the "UOMCode2" element
         */
        java.lang.String getUOMCode2();
        
        /**
         * Gets (as xml) the "UOMCode2" element
         */
        org.apache.xmlbeans.XmlString xgetUOMCode2();
        
        /**
         * Sets the "UOMCode2" element
         */
        void setUOMCode2(java.lang.String uomCode2);
        
        /**
         * Sets (as xml) the "UOMCode2" element
         */
        void xsetUOMCode2(org.apache.xmlbeans.XmlString uomCode2);
        
        /**
         * Gets the "UOMDescription2" element
         */
        java.lang.String getUOMDescription2();
        
        /**
         * Gets (as xml) the "UOMDescription2" element
         */
        org.apache.xmlbeans.XmlString xgetUOMDescription2();
        
        /**
         * Sets the "UOMDescription2" element
         */
        void setUOMDescription2(java.lang.String uomDescription2);
        
        /**
         * Sets (as xml) the "UOMDescription2" element
         */
        void xsetUOMDescription2(org.apache.xmlbeans.XmlString uomDescription2);
        
        /**
         * Gets the "UOMCode..n" element
         */
        java.lang.String getUOMCodeN();
        
        /**
         * Gets (as xml) the "UOMCode..n" element
         */
        org.apache.xmlbeans.XmlString xgetUOMCodeN();
        
        /**
         * Sets the "UOMCode..n" element
         */
        void setUOMCodeN(java.lang.String uomCodeN);
        
        /**
         * Sets (as xml) the "UOMCode..n" element
         */
        void xsetUOMCodeN(org.apache.xmlbeans.XmlString uomCodeN);
        
        /**
         * Gets the "UOMDescription..n" element
         */
        java.lang.String getUOMDescriptionN();
        
        /**
         * Gets (as xml) the "UOMDescription..n" element
         */
        org.apache.xmlbeans.XmlString xgetUOMDescriptionN();
        
        /**
         * Sets the "UOMDescription..n" element
         */
        void setUOMDescriptionN(java.lang.String uomDescriptionN);
        
        /**
         * Sets (as xml) the "UOMDescription..n" element
         */
        void xsetUOMDescriptionN(org.apache.xmlbeans.XmlString uomDescriptionN);
        
        /**
         * Gets the "CatalogAttributeName1" element
         */
        java.lang.String getCatalogAttributeName1();
        
        /**
         * Gets (as xml) the "CatalogAttributeName1" element
         */
        org.apache.xmlbeans.XmlString xgetCatalogAttributeName1();
        
        /**
         * Sets the "CatalogAttributeName1" element
         */
        void setCatalogAttributeName1(java.lang.String catalogAttributeName1);
        
        /**
         * Sets (as xml) the "CatalogAttributeName1" element
         */
        void xsetCatalogAttributeName1(org.apache.xmlbeans.XmlString catalogAttributeName1);
        
        /**
         * Gets the "CatalogAttributeValue1" element
         */
        java.lang.String getCatalogAttributeValue1();
        
        /**
         * Gets (as xml) the "CatalogAttributeValue1" element
         */
        org.apache.xmlbeans.XmlString xgetCatalogAttributeValue1();
        
        /**
         * Sets the "CatalogAttributeValue1" element
         */
        void setCatalogAttributeValue1(java.lang.String catalogAttributeValue1);
        
        /**
         * Sets (as xml) the "CatalogAttributeValue1" element
         */
        void xsetCatalogAttributeValue1(org.apache.xmlbeans.XmlString catalogAttributeValue1);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item newInstance() {
              return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
