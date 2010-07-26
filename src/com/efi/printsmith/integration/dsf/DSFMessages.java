package com.efi.printsmith.integration.dsf;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.service.DataService;
import java.util.List;

public class DSFMessages {
	@SuppressWarnings("unchecked")
	public static Document generateMediaResponse() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation impl = builder.getDOMImplementation();
		
		Document doc = impl.createDocument(null,null,null);
		Element media = doc.createElementNS("com.printcafe.printersiteinternal", "pcpsi:MediaResponse");
		doc.appendChild(media);
		Element jdf = doc.createElementNS("http://www.CIP4.org/JDFSchema_1_1", "jdf:JDF");
		media.appendChild(jdf);
		String attributeName = "xmlns:jdf";
		jdf.setAttribute(attributeName, "http://www.CIP4.org/JDFSchema_1_1");
		attributeName = "xmlns:xsi";
		jdf.setAttribute(attributeName, "http://www.w3.org/2001/XMLSchema-instance");
		attributeName = "Type";
		jdf.setAttribute(attributeName, "Product");
		attributeName = "xsi:type";
		jdf.setAttribute(attributeName, "Product");
		attributeName = "Status";
		jdf.setAttribute(attributeName, "Pool");
		attributeName = "ID";
		jdf.setAttribute(attributeName, "id1");
		
		Element resourcePool = doc.createElementNS("http://www.CIP4.org/JDFSchema_1_1", "jdf:ResourcePool");
		jdf.appendChild(resourcePool);
		
		DataService dataService = new DataService();
		List<StockDefinition> stockDefinitions = (List<StockDefinition>)dataService.getAll("StockDefinition");
		for (int i=0;i<stockDefinitions.size();i++) {
			StockDefinition stockDefinition = stockDefinitions.get(i);
			Element mediaItem = doc.createElementNS("http://www.CIP4.org/JDFSchema_1_1", "jdf:Media");
			attributeName = "DescriptiveName";
			mediaItem.setAttribute(attributeName, stockDefinition.getName());
			attributeName = "Class";
			mediaItem.setAttribute(attributeName, "Consumable");
			attributeName = "ID";
			mediaItem.setAttribute(attributeName, "ps-" + stockDefinition.getStockId());
			attributeName = "ProductID";
			mediaItem.setAttribute(attributeName, stockDefinition.getStockId());
			attributeName = "Status";
			mediaItem.setAttribute(attributeName, "Available");
			attributeName = "Dimension";
			mediaItem.setAttribute(attributeName, stockDefinition.getParentsize().getName());
			attributeName = "HoleType";
			mediaItem.setAttribute(attributeName, "None");
			attributeName = "MediaType";
			mediaItem.setAttribute(attributeName, "Paper");
			attributeName = "Weight";
			mediaItem.setAttribute(attributeName, stockDefinition.getWeight().toString());
			resourcePool.appendChild(mediaItem);
		}
		
		return doc;
	}
	
	@SuppressWarnings("unchecked")
	public static Document generateCustomerListResponse() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation impl = builder.getDOMImplementation();
		
		Document doc = impl.createDocument(null,null,null);
		Element customerList = doc.createElementNS("com.printcafe.printersiteinternal", "pcpsi:CustomerListResponse");
		doc.appendChild(customerList);
		
		DataService dataService = new DataService();
		List<Account> accounts = (List<Account>)dataService.getAll("Account");
		for (int i=0;i<accounts.size();i++) {
			Account account = accounts.get(i);
			Element customer = doc.createElementNS("com.printcafe.printersiteinternal", "pcpsi:Customer");
			customerList.appendChild(customer);
			String attributeName = "CustomerId";
			customer.setAttribute(attributeName,account.getAccountId().toString());
			attributeName = "SalesAgent";
			customer.setAttribute(attributeName, account.getSalesRep().getName());
			attributeName = "CustomerPostalCode";
			customer.setAttribute(attributeName, account.getShipToAddress().getZip());
			attributeName = "CustomerCity";
			customer.setAttribute(attributeName, account.getShipToAddress().getCity());
			attributeName = "CustomerName";
			customer.setAttribute(attributeName, account.getTitle());
			attributeName = "CustomerState";
			customer.setAttribute(attributeName, account.getShipToAddress().getState());
			attributeName = "CustomerCountry";
			customer.setAttribute(attributeName, account.getShipToAddress().getCountry());
			attributeName = "CustomerAddress1";
			customer.setAttribute(attributeName, account.getShipToAddress().getStreet1());
			attributeName = "CustomerAddress2";
			customer.setAttribute(attributeName, account.getShipToAddress().getStreet2());
		}
		
		return doc;
	}
}