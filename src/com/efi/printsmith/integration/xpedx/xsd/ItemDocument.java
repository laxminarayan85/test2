/*
 * An XML document type.
 * Localname: Item
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .ItemDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd ;


/**
 * A document containing one Item(@) element.
 *
 * This is a complex type.
 */
public interface ItemDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ItemDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82F17C311881AA701A43592266A02732").resolveHandle("item132cdoctype");
    
    /**
     * Gets the "Item" element
     */
    com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item getItem();
    
    /**
     * Sets the "Item" element
     */
    void setItem(com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item item);
    
    /**
     * Appends and returns a new empty "Item" element
     */
    com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item addNewItem();
    
    /**
     * An XML Item(@).
     *
     * This is a complex type.
     */
    public interface Item extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Item.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82F17C311881AA701A43592266A02732").resolveHandle("item788delemtype");
        
        /**
         * Gets the "IndexID" element
         */
        java.lang.String getIndexID();
        
        /**
         * Gets (as xml) the "IndexID" element
         */
        org.apache.xmlbeans.XmlString xgetIndexID();
        
        /**
         * Tests for nil "IndexID" element
         */
        boolean isNilIndexID();
        
        /**
         * Sets the "IndexID" element
         */
        void setIndexID(java.lang.String indexID);
        
        /**
         * Sets (as xml) the "IndexID" element
         */
        void xsetIndexID(org.apache.xmlbeans.XmlString indexID);
        
        /**
         * Nils the "IndexID" element
         */
        void setNilIndexID();
        
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
        java.math.BigInteger getQuantity();
        
        /**
         * Gets (as xml) the "Quantity" element
         */
        org.apache.xmlbeans.XmlInteger xgetQuantity();
        
        /**
         * Sets the "Quantity" element
         */
        void setQuantity(java.math.BigInteger quantity);
        
        /**
         * Sets (as xml) the "Quantity" element
         */
        void xsetQuantity(org.apache.xmlbeans.XmlInteger quantity);
        
        /**
         * Gets the "UOM" element
         */
        java.lang.String getUOM();
        
        /**
         * Gets (as xml) the "UOM" element
         */
        org.apache.xmlbeans.XmlString xgetUOM();
        
        /**
         * Sets the "UOM" element
         */
        void setUOM(java.lang.String uom);
        
        /**
         * Sets (as xml) the "UOM" element
         */
        void xsetUOM(org.apache.xmlbeans.XmlString uom);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item newInstance() {
              return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument.Item) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd .ItemDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd .ItemDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
