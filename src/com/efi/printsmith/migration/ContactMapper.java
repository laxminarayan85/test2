package com.efi.printsmith.migration;

import java.io.File;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Marketing;
import com.efi.printsmith.data.ModelBase;

public class ContactMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		Contact contact = new Contact();
		Address address = new Address();
		Marketing marketing = new Marketing();
		String custAcct = "";
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];

			if ("recno".equals(currentFieldToken)) {
				contact.setPrevId(currentImportToken);
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact id".equals(currentFieldToken)) {
				contact.setContactId(currentImportToken);
			} else if ("cust acct".equals(currentFieldToken)) {
				custAcct = currentImportToken;
			} else if ("cust record".equals(currentFieldToken)) {
				/* TODO */
			} else if ("title".equals(currentFieldToken)) {
				/* TODO */
			} else if ("address".equals(currentFieldToken)) {
				/* TODO */
			} else if ("name".equals(currentFieldToken)) {
				address.setName(currentImportToken);
			} else if ("street1".equals(currentFieldToken)) {
				address.setStreet1(currentImportToken);
			} else if ("street2".equals(currentFieldToken)) {
				address.setStreet2(currentImportToken);
			} else if ("addr3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("city".equals(currentFieldToken)) {
				address.setCity(currentImportToken);
			} else if ("state".equals(currentFieldToken)) {
				address.setState(currentImportToken);
			} else if ("zip".equals(currentFieldToken)) {
				address.setZip(currentImportToken);
			} else if ("country".equals(currentFieldToken)) {
				address.setCountry(currentImportToken);
			} else if ("contact".equals(currentFieldToken)) {
				/* TODO */
			} else if ("first name".equals(currentFieldToken)) {
				contact.setFirstName(currentImportToken);
			} else if ("last name".equals(currentFieldToken)) {
				contact.setLastName(currentImportToken);
			} else if ("salutation".equals(currentFieldToken)) {
				contact.setSalutation(currentImportToken);
			} else if ("job title".equals(currentFieldToken)) {
				contact.setJobTitle(currentImportToken);
			} else if ("phone".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("fax".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Fax"));
				}
			} else if ("phone 2".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("phone 3".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("phone 4".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("prefix".equals(currentFieldToken)) {
				contact.setPrefix(currentImportToken);
			} else if ("suffix".equals(currentFieldToken)) {
				contact.setSuffix(currentImportToken);
			} else if ("ship address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("bill address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales ranking".equals(currentFieldToken)) {
				/* TODO */
			} else if ("external ref number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Access".equals(currentFieldToken)) {
				/* TODO */
			} else if ("do not mail".equals(currentFieldToken)) {
				marketing.setNoMail(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use contact address".equals(currentFieldToken)) {
				contact.setUseContactAddress(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("notCompany".equals(currentFieldToken)) {
				marketing.setPersonalAcct(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("sales rep".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shipping data".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cc ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("created".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("marketing dates[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("leadsource ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("leadsource".equals(currentFieldToken)) {
				/* TODO */
			} else if ("leadsource2 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("leadsource2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user1 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user2 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user3 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user4 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user5 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user6 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user7 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user8 ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user8".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Contact ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Catalog Role ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Pricing Role ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Currency Code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Language Code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Parent Org ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Company ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Acct Name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		
		if (!custAcct.equals("") && !custAcct.equals("0"))
		{
			contact = null;
		}
		return contact;
	}
}
