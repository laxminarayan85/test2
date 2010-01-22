package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Marketing;
import com.efi.printsmith.data.ModelBase;

public class ContactMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Contact contact = new Contact();
		Address address = new Address();
		Marketing marketing = new Marketing();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);

			if ("recno".equals(currentImportToken)) {
				contact.setPrefix(currentImportToken);
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact id".equals(currentImportToken)) {
				contact.setContactId(currentImportToken);
			} else if ("cust acct".equals(currentImportToken)) {
				/* TODO */
			} else if ("cust record".equals(currentImportToken)) {
				/* TODO */
			} else if ("title".equals(currentImportToken)) {
				/* TODO */
			} else if ("address".equals(currentImportToken)) {
				/* TODO */
			} else if ("name".equals(currentImportToken)) {
				address.setName(currentImportToken);
			} else if ("street1".equals(currentImportToken)) {
				address.setStreet1(currentImportToken);
			} else if ("street2".equals(currentImportToken)) {
				address.setStreet2(currentImportToken);
			} else if ("addr3".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr4".equals(currentImportToken)) {
				/* TODO */
			} else if ("city".equals(currentImportToken)) {
				address.setCity(currentImportToken);
			} else if ("state".equals(currentImportToken)) {
				address.setState(currentImportToken);
			} else if ("zip".equals(currentImportToken)) {
				address.setZip(currentImportToken);
			} else if ("country".equals(currentImportToken)) {
				address.setCountry(currentImportToken);
			} else if ("contact".equals(currentImportToken)) {
				/* TODO */
			} else if ("first name".equals(currentImportToken)) {
				contact.setFirstName(currentImportToken);
			} else if ("last name".equals(currentImportToken)) {
				contact.setLastName(currentImportToken);
			} else if ("salutation".equals(currentImportToken)) {
				contact.setSalutation(currentImportToken);
			} else if ("job title".equals(currentImportToken)) {
				contact.setJobTitle(currentImportToken);
			} else if ("phone".equals(currentImportToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("fax".equals(currentImportToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Fax"));
				}
			} else if ("phone 2".equals(currentImportToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("phone 3".equals(currentImportToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("phone 4".equals(currentImportToken)) {
				if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
					contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("prefix".equals(currentImportToken)) {
				contact.setPrefix(currentImportToken);
			} else if ("suffix".equals(currentImportToken)) {
				contact.setSuffix(currentImportToken);
			} else if ("ship address ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("bill address ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales ranking".equals(currentImportToken)) {
				/* TODO */
			} else if ("external ref number".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Access".equals(currentImportToken)) {
				/* TODO */
			} else if ("do not mail".equals(currentImportToken)) {
				marketing.setNoMail(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use contact address".equals(currentImportToken)) {
				contact.setUseContactAddress(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("notCompany".equals(currentImportToken)) {
				marketing.setPersonalAcct(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("sales rep".equals(currentImportToken)) {
				/* TODO */
			} else if ("shipping data".equals(currentImportToken)) {
				/* TODO */
			} else if ("cc ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("created".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("marketing dates[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("leadsource ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("leadsource".equals(currentImportToken)) {
				/* TODO */
			} else if ("leadsource2 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("leadsource2".equals(currentImportToken)) {
				/* TODO */
			} else if ("user1 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user1".equals(currentImportToken)) {
				/* TODO */
			} else if ("user2 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user2".equals(currentImportToken)) {
				/* TODO */
			} else if ("user3 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user3".equals(currentImportToken)) {
				/* TODO */
			} else if ("user4 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user4".equals(currentImportToken)) {
				/* TODO */
			} else if ("user5 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user5".equals(currentImportToken)) {
				/* TODO */
			} else if ("user6 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user6".equals(currentImportToken)) {
				/* TODO */
			} else if ("user7 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user7".equals(currentImportToken)) {
				/* TODO */
			} else if ("user8 ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("user8".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Contact ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Catalog Role ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Pricing Role ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Currency Code".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Language Code".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Address ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Parent Org ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Company ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Acct Name".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return contact;
	}
}
