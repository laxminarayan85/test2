package com.efi.printsmith.integration.xpedx.soap;

public class StockCheckWSSoapProxy implements com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap {
  private String _endpoint = null;
  private com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap stockCheckWSSoap = null;
  
  public StockCheckWSSoapProxy() {
    _initStockCheckWSSoapProxy();
  }
  
  public StockCheckWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initStockCheckWSSoapProxy();
  }
  
  private void _initStockCheckWSSoapProxy() {
    try {
      stockCheckWSSoap = (new com.efi.printsmith.integration.xpedx.soap.StockCheckWSLocator()).getStockCheckWSSoap();
      if (stockCheckWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stockCheckWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stockCheckWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stockCheckWSSoap != null)
      ((javax.xml.rpc.Stub)stockCheckWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap getStockCheckWSSoap() {
    if (stockCheckWSSoap == null)
      _initStockCheckWSSoapProxy();
    return stockCheckWSSoap;
  }
  
  public java.lang.String stockCheck(java.lang.String SC_Xml_Request) throws java.rmi.RemoteException{
    if (stockCheckWSSoap == null)
      _initStockCheckWSSoapProxy();
    return stockCheckWSSoap.stockCheck(SC_Xml_Request);
  }
  
  
}