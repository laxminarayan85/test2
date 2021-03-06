package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

import com.efi.printsmith.data.CreditCard;
import com.efi.printsmith.data.CreditCardTransactions;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.TaxCodes;
import com.efi.printsmith.data.TaxTable;
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
				creditCardTransaction.setTransactionType(Utilities.tokenToInt(currentImportToken));
			else if ("transaction status".equals(currentFieldToken))
				creditCardTransaction.setTransactionStatus(Utilities.tokenToInt(currentImportToken));
			else if ("transaction results".equals(currentFieldToken))
				creditCardTransaction.setTransactionResults(Utilities.tokenToInt(currentImportToken));
			else if ("encryption".equals(currentFieldToken))
				creditCard.setEncryption(currentImportToken);
			else if ("address ID".equals(currentFieldToken)) {
				Address address = (Address)dataService.getByPrevId("Address", currentImportToken);
				if (address != null) {
					if (address.getStreet1() != null) {
						creditCard.setAddress1(address.getStreet1());
					}
					if (address.getZip() != null) {
						creditCard.setZipCode(address.getZip());
					}
				}
			} else if ("CC Holder Name".equals(currentFieldToken))
				creditCard.setCardHolderName(currentImportToken);
			else if ("CC Number".equals(currentFieldToken)) {
				CreditCard checkForCard = (CreditCard)dataService.getQuery("CreditCard", " where cardNumber = '" + currentImportToken + "'");
				if (checkForCard != null) {
					creditCard = checkForCard;
				}
				creditCard.setCardNumber(currentImportToken);
			}
			else if ("customer number".equals(currentFieldToken)) {
				Account account = (Account)dataService.getByAccountId(currentImportToken);
				// Per Danney - no longer used.
//				if (account != null)
//					creditCardTransaction.setAccount(account);
				
				if (account != null) {
					creditCard.setAccountNumber(account.getId());
				}
			}
			else if ("contact ID".equals(currentFieldToken)) {
				Contact contact2 = (Contact)dataService.getByPrevId("Contact",currentImportToken);
				// Per Danney - no longer used
//				if (contact2 != null)
//					creditCardTransaction.setContact(contact2);
			}
			else if ("ws ID".equals(currentFieldToken))
				creditCardTransaction.setWsId(Utilities.tokenToInt(currentImportToken));
			else if ("CC Number Display".equals(currentFieldToken))
				creditCard.setCardDisplayNumber(currentImportToken);
			else if ("CC Expire Date".equals(currentFieldToken))
				creditCard.setExpiresDate(Utilities.tokenToDate(currentImportToken));
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
				creditCard.setPermanent(Utilities.tokenToBooleanValue(currentImportToken));
			else if ("internal use1".equals(currentFieldToken))
				creditCardTransaction.setOrderName(currentFieldToken);
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