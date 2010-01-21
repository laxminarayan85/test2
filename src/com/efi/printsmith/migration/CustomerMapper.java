package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.SalesRep;

public class CustomerMapper extends ImportMapper{
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Account customer = new Account();
		Address shipToAddress = new Address();
		Address billToAddress = new Address();
		Contact shipToContact = new Contact();
		Contact billToContact = new Contact();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account number".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account type".equals(fieldTokens.get(i))) {
				if ("1".equals(currentImportToken)) {
					customer.setType("CustomerTypeDeposit");
				} else if ("2".equals(currentImportToken)) {
					customer.setType("CustomerTypeCash");					
				} else if ("3".equals(currentImportToken)) {
					customer.setType("CustomerTypeCheck");					
				} else if ("4".equals(currentImportToken)) {
					customer.setType("CustomerTypeCharge");					
				} else if ("5".equals(currentImportToken)) {
					customer.setType("CustomerTypeCreditCardOnFile");					
				}
			} else if ("account status".equals(fieldTokens.get(i))) {
				if ("1".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusNew");
				} else if ("2".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusCurrent");					
				} else if ("3".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusInactive");					
				} else if ("4".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusPastDue");					
				} else if ("5".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusDelinquent");					
				} else if ("6".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusFrozen");					
				}
			} else if ("resale id".equals(fieldTokens.get(i))) {
				customer.setResaleNumber(currentImportToken);
			} else if ("title".equals(fieldTokens.get(i))) {
				customer.setTitle(currentImportToken);
			} else if ("inv name".equals(fieldTokens.get(i))) {
				shipToAddress.setName(currentImportToken);
			} else if ("inv phone".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv fax".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv city".equals(fieldTokens.get(i))) {
				shipToAddress.setCity(currentImportToken);
			} else if ("inv zip".equals(fieldTokens.get(i))) {
				shipToAddress.setZip(currentImportToken);
			} else if ("inv first name".equals(fieldTokens.get(i))) {
				shipToContact.setFirstName(currentImportToken);
			} else if ("inv last name".equals(fieldTokens.get(i))) {
				shipToContact.setLastName(currentImportToken);
			} else if ("inv addr1".equals(fieldTokens.get(i))) {
				shipToAddress.setStreet1(currentImportToken);
			} else if ("inv addr2".equals(fieldTokens.get(i))) {
				shipToAddress.setStreet2(currentImportToken);
			} else if ("inv state".equals(fieldTokens.get(i))) {
				shipToAddress.setState(currentImportToken);
			} else if ("inv refno".equals(fieldTokens.get(i))) {
				customer.setExternalRef(currentImportToken);
			} else if ("bill name".equals(fieldTokens.get(i))) {
				billToAddress.setName(currentImportToken);
			} else if ("bill street1".equals(fieldTokens.get(i))) {
				billToAddress.setStreet1(currentImportToken);
			} else if ("bill street2".equals(fieldTokens.get(i))) {
				billToAddress.setStreet2(currentImportToken);
			} else if ("bill city".equals(fieldTokens.get(i))) {
				billToAddress.setCity(currentImportToken);
			} else if ("bill state".equals(fieldTokens.get(i))) {
				billToAddress.setState(currentImportToken);
			} else if ("bill zip".equals(fieldTokens.get(i))) {
				billToAddress.setZip(currentImportToken);
			} else if ("bill phone".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill last name".equals(fieldTokens.get(i))) {
				billToContact.setLastName(currentImportToken);
			} else if ("bill fax".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Fax"));
				}
			} else if ("bill refno".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table".equals(fieldTokens.get(i))) {
				/* TODO */				
			} else if ("sales ranking".equals(fieldTokens.get(i))) {
				/* TODO */		
			} else if ("do statement".equals(fieldTokens.get(i))) {
				customer.setGenerateStatements(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("do finance charges".equals(fieldTokens.get(i))) {
				customer.setApplyFinanceCharges(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("po required".equals(fieldTokens.get(i))) {
				customer.setPoRequired(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("business type code".equals(fieldTokens.get(i))) {
				
			} else if ("sales rep".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					SalesRep salesRep = new SalesRep(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					salesRep.setName(currentImportToken);
					customer.setSalesRep(salesRep);
				}				
			} else if ("on account".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("balance".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales month".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales prior year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("orders year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate count".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("credit limit".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("discount rate".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("finance rate".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("finance YTD".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("created".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoice date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last aged".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last billed".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last payment".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last posted".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("rank date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoice notes".equals(fieldTokens.get(i))) {
				customer.setAccountNote(currentImportToken);
			} else if ("job notes".equals(fieldTokens.get(i))) {
				customer.setJobNote(currentImportToken);
			} else if ("contact record".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("master acct".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("access level".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("external ref number".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax exempt".equals(fieldTokens.get(i))) {
				customer.setTaxExempt(Utilities.tokenToBooleanValue(currentImportToken));
				/* TODO */
			} else if ("rtype".equals(fieldTokens.get(i))) {
				/* TODO */ /* Note: determines whether this is customer or prospect */
			} else if ("inv addr".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv country".equals(fieldTokens.get(i))) {
				shipToAddress.setCountry(currentImportToken);
			} else if ("bill addr".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill country".equals(fieldTokens.get(i))) {
				billToAddress.setCountry(currentImportToken);
			} else if ("ship contact".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv salutation".equals(fieldTokens.get(i))) {
				shipToContact.setSalutation(currentImportToken);
			} else if ("inv job title".equals(fieldTokens.get(i))) {
				shipToContact.setJobTitle(currentImportToken);
			} else if ("inv phone 2".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv phone 3".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv prefix".equals(fieldTokens.get(i))) {
				shipToContact.setPrefix(currentImportToken);
			} else if ("inv suffix".equals(fieldTokens.get(i))) {
				shipToContact.setSuffix(currentImportToken);
			} else if ("bill contact".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill first name".equals(fieldTokens.get(i))) {
				billToContact.setFirstName(currentImportToken);
			} else if ("bill salutation".equals(fieldTokens.get(i))) {
				billToContact.setSalutation(currentImportToken);
			} else if ("bill job title".equals(fieldTokens.get(i))) {
				billToContact.setJobTitle(currentImportToken);
			} else if ("bill phone 2".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill phone 3".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill prefix".equals(fieldTokens.get(i))) {
				billToContact.setPrefix(currentImportToken);
			} else if ("bill suffix".equals(fieldTokens.get(i))) {
				billToContact.setSuffix(currentImportToken);
			} else if ("do commissions".equals(fieldTokens.get(i))) {
				customer.setPayCommissions(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("notCompany".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("do not mail".equals(fieldTokens.get(i))) {
				customer.setOptOutMarketing(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("default inv".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("default est".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("shipping mode".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("history notes".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("statement notes".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill contact record".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user1".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user2".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user5".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user6".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user7".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user8".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("number employees".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("business type".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("business type name".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("annual revenue".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("master acct name".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account PO".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv addr3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv addr4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill addr3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill addr4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv phone 4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("ship address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table title".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code title".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("expand short".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("external accounting ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("filler bits".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("file originals".equals(fieldTokens.get(i))) {
				customer.setFileOriginals(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("web access".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("never a customer".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoiceTemplateID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimateTemplateID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("shipping mode ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("total invoices".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("terms net".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("terms discount".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate won cnt".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate lost cnt".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("discount single amount".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("first invoice date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("first estimate date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("touch date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("contact count".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource1 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource2 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource2".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user1 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user2 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user3 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user4 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user5 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user6 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user7 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user8 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("items paid".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("time to pay".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("autopay Template ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Company ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Catalog Role ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Pricing Role ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Bill Address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("resale cert expire".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last notified date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last notified time".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("exp data 2".equals(fieldTokens.get(i))) {
				/* TODO */
			}
		}
		customer.setShipToAddress(shipToAddress);
		customer.setBillToAddress(billToAddress);
		customer.setContact(shipToContact);
		customer.setBillToContact(billToContact);
		
		return customer;
	}
}
