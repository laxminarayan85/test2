/*
 * An XML document type.
 * Localname: BackOrderMessage
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response;


/**
 * A document containing one BackOrderMessage(@) element.
 *
 * This is a complex type.
 */
public interface BackOrderMessageDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(BackOrderMessageDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82300A33593A14964FAE4C9DAA490598").resolveHandle("backordermessage4df9doctype");
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.BackOrderMessageDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
