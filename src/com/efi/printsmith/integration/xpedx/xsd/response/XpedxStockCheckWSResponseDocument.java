/*
 * An XML document type.
 * Localname: xpedxStockCheckWSResponse
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.xsd.response;


/**
 * A document containing one xpedxStockCheckWSResponse(@) element.
 *
 * This is a complex type.
 */
public interface XpedxStockCheckWSResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XpedxStockCheckWSResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s04547F11DB3F13AB93484CE8440F8EA9").resolveHandle("xpedxstockcheckwsresponse9557doctype");
    
    /**
     * Gets the "xpedxStockCheckWSResponse" element
     */
    com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse getXpedxStockCheckWSResponse();
    
    /**
     * Sets the "xpedxStockCheckWSResponse" element
     */
    void setXpedxStockCheckWSResponse(com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse xpedxStockCheckWSResponse);
    
    /**
     * Appends and returns a new empty "xpedxStockCheckWSResponse" element
     */
    com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse addNewXpedxStockCheckWSResponse();
    
    /**
     * An XML xpedxStockCheckWSResponse(@).
     *
     * This is a complex type.
     */
    public interface XpedxStockCheckWSResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(XpedxStockCheckWSResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s04547F11DB3F13AB93484CE8440F8EA9").resolveHandle("xpedxstockcheckwsresponse8d83elemtype");
        
        /**
         * Gets the "RootErrorInfo" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.RootErrorInfoDocument.RootErrorInfo getRootErrorInfo();
        
        /**
         * Sets the "RootErrorInfo" element
         */
        void setRootErrorInfo(com.efi.printsmith.integration.xpedx.xsd.response.RootErrorInfoDocument.RootErrorInfo rootErrorInfo);
        
        /**
         * Appends and returns a new empty "RootErrorInfo" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.RootErrorInfoDocument.RootErrorInfo addNewRootErrorInfo();
        
        /**
         * Gets the "SenderCredentials" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.SenderCredentialsDocument.SenderCredentials getSenderCredentials();
        
        /**
         * Sets the "SenderCredentials" element
         */
        void setSenderCredentials(com.efi.printsmith.integration.xpedx.xsd.response.SenderCredentialsDocument.SenderCredentials senderCredentials);
        
        /**
         * Appends and returns a new empty "SenderCredentials" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.SenderCredentialsDocument.SenderCredentials addNewSenderCredentials();
        
        /**
         * Gets the "StockCheckResponse" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse getStockCheckResponse();
        
        /**
         * Sets the "StockCheckResponse" element
         */
        void setStockCheckResponse(com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse stockCheckResponse);
        
        /**
         * Appends and returns a new empty "StockCheckResponse" element
         */
        com.efi.printsmith.integration.xpedx.xsd.response.StockCheckResponseDocument.StockCheckResponse addNewStockCheckResponse();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse newInstance() {
              return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument.XpedxStockCheckWSResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
