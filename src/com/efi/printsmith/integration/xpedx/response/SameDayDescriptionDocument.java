/*
 * An XML document type.
 * Localname: SameDayDescription
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response;


/**
 * A document containing one SameDayDescription(@) element.
 *
 * This is a complex type.
 */
public interface SameDayDescriptionDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SameDayDescriptionDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82300A33593A14964FAE4C9DAA490598").resolveHandle("samedaydescription691fdoctype");
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.SameDayDescriptionDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
