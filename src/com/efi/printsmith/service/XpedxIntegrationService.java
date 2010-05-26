package com.efi.printsmith.service;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

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

public class XpedxIntegrationService extends SnowmassHibernateService {
	private static Logger log = Logger.getLogger(XpedxIntegrationService.class);
	
	public static void xpedxStockCheck() {
		try {
			StockCheckWS service = new StockCheckWSLocator();
			StockCheckWSSoap stockCheck = service.getStockCheckWSSoap();
			XpedxStockCheckWSRequestDocument stockCheckWSRequestDocument = XpedxStockCheckWSRequestDocument.Factory.newInstance();
			XpedxStockCheckWSRequest stockCheckWSRequest = stockCheckWSRequestDocument.addNewXpedxStockCheckWSRequest();
			SenderCredentials credentials = stockCheckWSRequest.addNewSenderCredentials();
			
			// TODO: We might want to actually pass the user's name/password
			credentials.setUserEmail("danney.rodgers@efi.com");
			credentials.setUserPassword("Password1");
			
			StockCheckRequest stockCheckRequest = stockCheckWSRequest.addNewStockCheckRequests().addNewStockCheckRequest();
			stockCheckWSRequest.getStockCheckRequests().setETradingPartnerID("Pilgrim12");
			
			Item item = stockCheckRequest.addNewItems().addNewItem();			
			item.setIndexID("1");
			item.setCustomerPartNumber("460");
			item.setXpedxPartNumber("2257624");
			item.setQuantity(BigInteger.valueOf(100));
			item.setUOM("LB");
			
			System.out.println("Sending request to xpedx: " + stockCheckWSRequestDocument.toString());
			log.info("Sending request to xpedx: " + stockCheckWSRequestDocument.toString());
			String response = stockCheck.stockCheck(stockCheckWSRequestDocument.toString());
			System.out.println("Response received from xpedx (pre-parsing): " + response);
			Map nsSubst = new HashMap();
			nsSubst.put("http://b2b.xpedx.com/StockCheck_WebService/", "");
			XmlOptions parseOptions = new XmlOptions();
			parseOptions.setLoadSubstituteNamespaces(nsSubst);
			XpedxStockCheckWSResponseDocument responseDoc = XpedxStockCheckWSResponseDocument.Factory.parse(response, parseOptions);
			
			System.out.println("Response received from xpedx: " + responseDoc.toString());
			log.info("Response received from xpedx: " + responseDoc.toString());
		} catch (ServiceException e) {
			log.error(e);
		} catch (RemoteException e) {
			log.error(e);
		} catch (XmlException e) {
			log.error(e);
		}
	}

}
