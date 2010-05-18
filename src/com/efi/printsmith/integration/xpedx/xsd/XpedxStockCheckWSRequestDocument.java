/*
 * An XML document type.
 * Localname: xpedxStockCheckWSRequest
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd ;


/**
 * A document containing one xpedxStockCheckWSRequest(@) element.
 *
 * This is a complex type.
 */
public interface XpedxStockCheckWSRequestDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XpedxStockCheckWSRequestDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82F17C311881AA701A43592266A02732").resolveHandle("xpedxstockcheckwsrequestf6b9doctype");
    
    /**
     * Gets the "xpedxStockCheckWSRequest" element
     */
    com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest getXpedxStockCheckWSRequest();
    
    /**
     * Sets the "xpedxStockCheckWSRequest" element
     */
    void setXpedxStockCheckWSRequest(com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest xpedxStockCheckWSRequest);
    
    /**
     * Appends and returns a new empty "xpedxStockCheckWSRequest" element
     */
    com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest addNewXpedxStockCheckWSRequest();
    
    /**
     * An XML xpedxStockCheckWSRequest(@).
     *
     * This is a complex type.
     */
    public interface XpedxStockCheckWSRequest extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XpedxStockCheckWSRequest.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82F17C311881AA701A43592266A02732").resolveHandle("xpedxstockcheckwsrequest7b6delemtype");
        
        /**
         * Gets the "SenderCredentials" element
         */
        com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials getSenderCredentials();
        
        /**
         * Sets the "SenderCredentials" element
         */
        void setSenderCredentials(com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials senderCredentials);
        
        /**
         * Appends and returns a new empty "SenderCredentials" element
         */
        com.efi.printsmith.integration.xpedx.xsd .SenderCredentialsDocument.SenderCredentials addNewSenderCredentials();
        
        /**
         * Gets the "StockCheckRequests" element
         */
        com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests getStockCheckRequests();
        
        /**
         * Sets the "StockCheckRequests" element
         */
        void setStockCheckRequests(com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests stockCheckRequests);
        
        /**
         * Appends and returns a new empty "StockCheckRequests" element
         */
        com.efi.printsmith.integration.xpedx.xsd .StockCheckRequestsDocument.StockCheckRequests addNewStockCheckRequests();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest newInstance() {
              return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd .XpedxStockCheckWSRequestDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
