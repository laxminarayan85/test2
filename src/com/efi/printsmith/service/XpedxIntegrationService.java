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
	
	public static String[][] checkStock(long id, String xpedxId, long qty) throws Exception {
		String[][] nodeArray = null;
		try {
			XpedxStockCheckWSRequestDocument stockCheckWSRequestDocument = generateStockCheckRequest();
			Item item = stockCheckWSRequestDocument.getXpedxStockCheckWSRequest().getStockCheckRequests().getStockCheckRequest().addNewItems().addNewItem();			
			item.setIndexID("1");
			item.setCustomerPartNumber(String.valueOf(id));
			item.setXpedxPartNumber(xpedxId);
			item.setQuantity(BigInteger.valueOf(qty));
			item.setUOM("LB");
			
			XpedxStockCheckWSResponseDocument response = sendStockCheckRequest(stockCheckWSRequestDocument.toString());
			int errorCode = Utilities.tokenToInt(response.getXpedxStockCheckWSResponse().getRootErrorInfo().getErrorCode());
			if (errorCode > 0) {
				nodeArray = new String[1][2];
				nodeArray[0][0] = "Error";
				nodeArray[0][1] = response.getXpedxStockCheckWSResponse().getRootErrorInfo().getErrorMessage();
				return nodeArray;
			}
			/* Handle the response here */
			Items items = (Items) response.getXpedxStockCheckWSResponse().getStockCheckResponse().getItems();
			Item[] itemArray = items.getItemArray();
			for (int i=0;i<itemArray.length;i++) {
				NodeList nodes = (NodeList) itemArray[i].getDomNode().getChildNodes();
				nodeArray = new String[nodes.getLength()][2];
				for (int x=0;x<nodes.getLength();i++) {
					String nodeName = nodes.item(x).getNodeName();
					String nodeValue = nodes.item(x).getNodeValue();
					nodeArray[x][0] = nodeName;
					nodeArray[x][1] = nodeValue;
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
		return nodeArray;
	}

}
