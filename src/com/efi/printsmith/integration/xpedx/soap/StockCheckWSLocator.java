/**
 * StockCheckWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.efi.printsmith.integration.xpedx.soap;

public class StockCheckWSLocator extends org.apache.axis.client.Service implements com.efi.printsmith.integration.xpedx.soap.StockCheckWS {

    public StockCheckWSLocator() {
    }


    public StockCheckWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StockCheckWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StockCheckWSSoap
    private java.lang.String StockCheckWSSoap_address = "https://b2bstg.xpedx.com/webservices/stockcheck.asmx";

    public java.lang.String getStockCheckWSSoapAddress() {
        return StockCheckWSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StockCheckWSSoapWSDDServiceName = "StockCheckWSSoap";

    public java.lang.String getStockCheckWSSoapWSDDServiceName() {
        return StockCheckWSSoapWSDDServiceName;
    }

    public void setStockCheckWSSoapWSDDServiceName(java.lang.String name) {
        StockCheckWSSoapWSDDServiceName = name;
    }

    public com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap getStockCheckWSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StockCheckWSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStockCheckWSSoap(endpoint);
    }

    public com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap getStockCheckWSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoapStub _stub = new com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoapStub(portAddress, this);
            _stub.setPortName(getStockCheckWSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStockCheckWSSoapEndpointAddress(java.lang.String address) {
        StockCheckWSSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoapStub _stub = new com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoapStub(new java.net.URL(StockCheckWSSoap_address), this);
                _stub.setPortName(getStockCheckWSSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StockCheckWSSoap".equals(inputPortName)) {
            return getStockCheckWSSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/StockCheck_WebService/Service1", "StockCheckWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/StockCheck_WebService/Service1", "StockCheckWSSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StockCheckWSSoap".equals(portName)) {
            setStockCheckWSSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
