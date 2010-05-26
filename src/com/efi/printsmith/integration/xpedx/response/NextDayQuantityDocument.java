/*
 * An XML document type.
 * Localname: NextDayQuantity
 * Namespace: 
 * Java type: com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument
 *
 * Automatically generated - do not modify.
 */
package com.efi.printsmith.integration.xpedx.response;


/**
 * A document containing one NextDayQuantity(@) element.
 *
 * This is a complex type.
 */
public interface NextDayQuantityDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(NextDayQuantityDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s82300A33593A14964FAE4C9DAA490598").resolveHandle("nextdayquantity559bdoctype");
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument newInstance() {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.efi.printsmith.integration.xpedx.response.NextDayQuantityDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
