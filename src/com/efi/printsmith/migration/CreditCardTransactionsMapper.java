package com.efi.printsmith.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.CreditCard;
import com.efi.printsmith.data.CreditCardTransactions;
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
		log.info("Entering CreditCardTransactionsMapper->importFile");
		DataService dataService = new DataService();
		CreditCard creditCard = new CreditCard();
		CreditCardTransactions creditCardTransaction = new CreditCardTransactions();
		Contact contact = null;
		boolean permanent = false;
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
			else if ("transaction type".equals(currentFieldToken))
				creditCardTransaction.setTransactionType(currentImportToken);
			else if ("transaction status".equals(currentFieldToken))
				creditCardTransaction.setTransactionStatus(currentImportToken);
			else if ("transaction results".equals(currentFieldToken))
				creditCardTransaction.setTransactionResults(currentImportToken);
			else if ("encryption".equals(currentFieldToken))
				creditCard.setEncryption(currentImportToken);
			else if ("address ID".equals(currentFieldToken)) {
				Address address = (Address)dataService.getByPrevId("Address", currentImportToken);
				if (address != null)
					creditCard.setAddress(address);
			} else if ("CC Holder Name".equals(currentFieldToken))
				creditCard.setCardHolderName(currentImportToken);
			else if ("CC Number".equals(currentFieldToken)) {
				CreditCard checkForCard = (CreditCard)dataService.getQuery("CreditCard", " where cardNumber = '" + currentImportToken + "'");
				if (checkForCard != null) {
					creditCard = checkForCard;
				}
				creditCard.setCardNumber(currentImportToken);
			}
			else if ("CC Number Display".equals(currentFieldToken))
				creditCard.setCardDisplayNumber(currentImportToken);
			else if ("amount".equals(currentFieldToken))
				creditCardTransaction.setAmount(Utilities.tokenToDouble(currentImportToken));
			else if ("taxInAmount".equals(currentFieldToken))
				creditCardTransaction.setTaxInAmount(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("user name".equals(currentFieldToken))
				creditCardTransaction.setUserName(currentImportToken);
			else if ("PO number".equals(currentFieldToken)) 
				creditCardTransaction.setPoNumber(currentImportToken);
			else if ("reference number".equals(currentFieldToken))
				creditCardTransaction.setReferenceNumber(currentImportToken);
			else if ("approval code".equals(currentFieldToken))
				creditCardTransaction.setApprovalCode(currentImportToken);
			else if ("approval date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					creditCardTransaction.setApprovalDate(Utilities.tokenToDate(currentImportToken));
				}
			}
			else if ("message".equals(currentFieldToken))
				creditCardTransaction.setMessage(currentImportToken);
			else if ("manual code".equals(currentFieldToken))
				creditCardTransaction.setManualCode(currentImportToken);
			else if ("failedAVS".equals(currentFieldToken))
				creditCardTransaction.setFailedAVS(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("hasCVV2data".equals(currentFieldToken))
				creditCardTransaction.setHasCVVdata(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("trackDataUsed".equals(currentFieldToken))
				creditCardTransaction.setTrackDataUsed(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("taxExempt".equals(currentFieldToken))
				creditCardTransaction.setTaxExempt(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("tax".equals(currentFieldToken))
				creditCardTransaction.setTax(Utilities.tokenToDouble(currentImportToken));
			else if ("tax code".equals(currentFieldToken)) {
				TaxCodes taxCode = (TaxCodes)dataService.getByName("TaxCodes", currentImportToken);
				if (taxCode != null)
					creditCardTransaction.setTaxCode(taxCode);
			}
			else if ("tax table".equals(currentFieldToken)) {
				TaxTable taxTable = (TaxTable)dataService.getByName("TaxTable", currentImportToken);
				if (taxTable != null)
					creditCardTransaction.setTaxTable(taxTable);
			}
			else if ("permanent".equals(currentFieldToken))
				creditCardTransaction.setPermanent(Utilities.tokenToBooleanValue(currentImportToken));
		}
		if (contact != null) {
			contact.setCreditCard(creditCard);
			creditCard = (CreditCard)dataService.addUpdate(contact);
		}
		creditCard = (CreditCard)dataService.addUpdate(creditCard);
		creditCardTransaction.setCreditCard(creditCard);
		dataService.addUpdate(creditCardTransaction);
		return null;
	}
}