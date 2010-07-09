package com.efi.printsmith.service;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import net.sourceforge.jeuclid.dom.AbstractPartialNodeImpl.NodeList;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

import com.efi.printsmith.integration.xpedx.XpedxStockCheckRequestParams;
import com.efi.printsmith.integration.xpedx.soap.StockCheckWS;
import com.efi.printsmith.integration.xpedx.soap.StockCheckWSLocator;
import com.efi.printsmith.integration.xpedx.soap.StockCheckWSSoap;

import com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument;
import com.efi.printsmith.integration.xpedx.xsd.request.ItemDocument.Item;
import com.efi.printsmith.integration.xpedx.xsd.request.ItemsDocument.Items;
import com.efi.printsmith.integration.xpedx.xsd.request.SenderCredentialsDocument.SenderCredentials;
import com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestDocument.StockCheckRequest;
import com.efi.printsmith.integration.xpedx.xsd.request.StockCheckRequestsDocument.StockCheckRequests;
import com.efi.printsmith.integration.xpedx.xsd.request.XpedxStockCheckWSRequestDocument;
import com.efi.printsmith.integration.xpedx.xsd.request.XpedxStockCheckWSRequestDocument.XpedxStockCheckWSRequest;
import com.efi.printsmith.integration.xpedx.xsd.response.XpedxStockCheckWSResponseDocument;
import com.efi.printsmith.migration.Utilities;

import com.efi.printsmith.data.StockOrder;

import flex.messaging.io.ArrayList;

public class XpedxIntegrationService extends SnowmassHibernateService {
	private static Logger log = Logger.getLogger(XpedxIntegrationService.class);
	
	private static XpedxStockCheckWSRequestDocument generateStockCheckRequest() {
		XpedxStockCheckWSRequestDocument stockCheckWSRequestDocument = XpedxStockCheckWSRequestDocument.Factory.newInstance();
		XpedxStockCheckWSRequest stockCheckWSRequest = stockCheckWSRequestDocument.addNewXpedxStockCheckWSRequest();
		SenderCredentials credentials = stockCheckWSRequest.addNewSenderCredentials();
		
		// TODO: We might want to actually use the user's name/password
		credentials.setUserEmail("danney.rodgers@efi.com");
		credentials.setUserPassword("Password1");
		
		StockCheckRequest stockCheckRequest = stockCheckWSRequest.addNewStockCheckRequests().addNewStockCheckRequest();
		stockCheckWSRequest.getStockCheckRequests().setETradingPartnerID("Pilgrim12");
		
		return stockCheckWSRequestDocument;
	}
	
	private static XpedxStockCheckWSResponseDocument sendStockCheckRequest(String request) throws ServiceException, RemoteException, XmlException {
		StockCheckWS service = new StockCheckWSLocator();
		StockCheckWSSoap stockCheck = service.getStockCheckWSSoap();
		log.info("Sending request to xpedx: " + request);
		String response = stockCheck.stockCheck(request);
		System.out.println("Response received from sendStockCheckRequest: " + response);
		Map nsSubst = new HashMap();
		nsSubst.put("http://b2b.xpedx.com/StockCheck_WebService/", "");
		XmlOptions parseOptions = new XmlOptions();
		parseOptions.setLoadSubstituteNamespaces(nsSubst);
		XpedxStockCheckWSResponseDocument responseDoc = XpedxStockCheckWSResponseDocument.Factory.parse(response, parseOptions);
		return responseDoc;
	}
	
	public static void checkStock(XpedxStockCheckRequestParams params) throws Exception {
		checkStock(params.getId(), params.getXpedxId(), params.getQty());
	}
	
	public static void checkStocks(List<XpedxStockCheckRequestParams> params) throws Exception {
		try {
			XpedxStockCheckWSRequestDocument stockCheckWSRequestDocument = generateStockCheckRequest();
			
			Iterator<XpedxStockCheckRequestParams> it = params.iterator();
			Items items = stockCheckWSRequestDocument.getXpedxStockCheckWSRequest().getStockCheckRequests().getStockCheckRequest().addNewItems();
			int counter = 1;	
			while (it.hasNext()) {
				XpedxStockCheckRequestParams param = it.next();
				Item item = items.addNewItem();			
				item.setIndexID(String.valueOf(counter++));
				item.setCustomerPartNumber(String.valueOf(param.getId()));
				item.setXpedxPartNumber(param.getXpedxId());
				item.setQuantity(BigInteger.valueOf(param.getQty()));
				item.setUOM("LB");
			}
			
			XpedxStockCheckWSResponseDocument response = sendStockCheckRequest(stockCheckWSRequestDocument.toString());
			
			/* Handle the response here */
			
		} catch (ServiceException e) {
			log.error(e);
			throw e;
		} catch (RemoteException e) {
			log.error(e);
			throw e;
		} catch (XmlException e) {
			log.error(e);
			throw e;
		}
	}
	
	public static boolean submitOrder(StockOrder stockOrder) {
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static List checkStock(long id, String xpedxId, long qty) throws Exception {
		List fieldList = new ArrayList();
		List valueList = new ArrayList();
		List returnList = new ArrayList();
		try {
			XpedxStockCheckWSRequestDocument stockCheckWSRequestDocument = generateStockCheckRequest();
			Item item = stockCheckWSRequestDocument.getXpedxStockCheckWSRequest().getStockCheckRequests().getStockCheckRequest().addNewItems().addNewItem();			
			item.setIndexID("1");
			item.setCustomerPartNumber(String.valueOf(id));
			item.setXpedxPartNumber(xpedxId);
			item.setQuantity(BigInteger.valueOf(qty));
			item.setUOM("LB");
			
			XpedxStockCheckWSResponseDocument response = sendStockCheckRequest(stockCheckWSRequestDocument.toString());
			/* Handle the response here */
			com.efi.printsmith.integration.xpedx.xsd.response.ItemsDocument.Items items = response.getXpedxStockCheckWSResponse().getStockCheckResponse().getItems();
			com.efi.printsmith.integration.xpedx.xsd.response.ItemDocument.Item[] itemArray = items.getItemArray();
			for (int i=0;i<itemArray.length;i++) {
				org.w3c.dom.NodeList nodes = itemArray[i].getDomNode().getChildNodes();
				int errorCode = 0;
				for (int x=0;x<nodes.getLength();x++) {
					Node node = nodes.item(x);
					String nodeName = node.getNodeName();
					String nodeValue = "";
					if (nodeName.equals("xpedxPartNumber"))
						nodeValue = itemArray[i].getXpedxPartNumber();
					else if (nodeName.equals("CustomerNumber"))
						nodeValue = itemArray[i].getCustomerNumber();
					else if (nodeName.equals("ItemDescription"))
						nodeValue = itemArray[i].getItemDescription();
					else if (nodeName.equals("AvailabilityMessage"))
						nodeValue = itemArray[i].getAvailabilityMessage();
					else if (nodeName.equals("TotalPrice"))
						nodeValue = itemArray[i].getTotalPrice();
					else if (nodeName.equals("ItemStatus"))
						nodeValue = itemArray[i].getItemStatus();
					else if (nodeName.equals("Category1"))
						nodeValue = itemArray[i].getCategory1();
					else if (nodeName.equals("Manufacturer"))
						nodeValue = itemArray[i].getManufacturer();
					else if (nodeName.equals("UnitPrice1"))
						nodeValue = itemArray[i].getUnitPrice1();
					else if (nodeName.equals("UOMDescription1"))
						nodeValue = itemArray[i].getUOMDescription1();
					else if (nodeName.equals("UOMCode1"))
						nodeValue = itemArray[i].getUOMCode1();
					else if (nodeName.equals("ErrorCode")) {
						errorCode = Utilities.tokenToInt(itemArray[i].getErrorCode());
					}
					else if (nodeName.equals("ErrorMessage") && errorCode > 0) {
						nodeValue = itemArray[i].getErrorMessage();
					}
					if (nodeValue.equals("") == false) {
						fieldList.add(nodeName);
						valueList.add(nodeValue);
					}
				}
			}
		} catch (ServiceException e) {
			log.error(e);
			throw e;
		} catch (RemoteException e) {
			log.error(e);
			throw e;
		} catch (XmlException e) {
			log.error(e);
			throw e;
		}
		returnList.add(fieldList);
		returnList.add(valueList);
		return returnList;
	}
}
