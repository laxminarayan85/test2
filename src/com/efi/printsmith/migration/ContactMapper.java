package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.ModelBase;

public class ContactMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Contact contact = new Contact();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);

			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact id".equals(currentImportToken)) {
				/* TODO */
			} else if ("cust acct".equals(currentImportToken)) {
				/* TODO */
			} else if ("cust record".equals(currentImportToken)) {
				/* TODO */
			} else if ("title".equals(currentImportToken)) {
				/* TODO */
			} else if ("address".equals(currentImportToken)) {
				/* TODO */
			} else if ("name".equals(currentImportToken)) {
				/* TODO */
			} else if ("street1".equals(currentImportToken)) {
				/* TODO */
			} else if ("street2".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr3".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr4".equals(currentImportToken)) {
				/* TODO */
			} else if ("city".equals(currentImportToken)) {
				/* TODO */
			} else if ("state".equals(currentImportToken)) {
				/* TODO */
			} else if ("zip".equals(currentImportToken)) {
				/* TODO */
			} else if ("country".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact".equals(currentImportToken)) {
				/* TODO */
			} else if ("first name".equals(currentImportToken)) {
				/* TODO */
			} else if ("last name".equals(currentImportToken)) {
				/* TODO */
			} else if ("salutation".equals(currentImportToken)) {
				/* TODO */
			} else if ("job title".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone".equals(currentImportToken)) {
				/* TODO */
			} else if ("fax".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 3".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 4".equals(currentImportToken)) {
				/* TODO */
			} else if ("prefix".equals(currentImportToken)) {
				/* TODO */
			} else if ("suffix".equals(currentImportToken)) {
				/* TODO */
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
				/* TODO */
			} else if ("use contact address".equals(currentImportToken)) {
				/* TODO */
			} else if ("notCompany".equals(currentImportToken)) {
				/* TODO */
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
