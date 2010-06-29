package com.efi.printsmith.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.CreditCard;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.TaxCodes;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.Users;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.service.DataService;

public class CreditCardTransactionsMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ChargeDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering ChargeCostingMapper->importFile");
		DataService dataService = new DataService();
		CreditCard creditCard = new CreditCard();
		
		Contact contact = null;
		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				creditCard.setPrevId(currentImportToken);
				contact = (Contact)dataService.getQuery("Contact", " where ccImportRec = '" + currentImportToken + "'");
			} else if ("date".equals(currentFieldToken) && currentImportToken.equals("") == false)
				creditCard.setCreated(Utilities.tokenToDate(currentImportToken));
			else if ("card type".equals(currentFieldToken))
				creditCard.setType(currentImportToken);
			else if ("encryption".equals(currentFieldToken))
				creditCard.setEncryption(currentImportToken);
			else if ("address ID".equals(currentFieldToken)) {
				Address address = (Address)dataService.getByPrevId("Address", currentImportToken);
				if (address != null)
					creditCard.setAddress(address);
			} else if ("CC Holder Name".equals(currentFieldToken))
				creditCard.setCardHolderName(currentImportToken);
			else if ("CC Number".equals(currentFieldToken))
				creditCard.setCardNumber(currentImportToken);
			else if ("CC Number Display".equals(currentFieldToken))
				creditCard.setCardDisplayNumber(currentImportToken);
		}
		creditCard = (CreditCard)dataService.addUpdate(creditCard);
		if (contact != null) {
			contact.setCreditCard(creditCard);
			dataService.addUpdate(contact);
		}
		return null;
	}
}