package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.City;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Marketing;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.State;
import com.efi.printsmith.data.Zip;
import com.efi.printsmith.data.JobTitle;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class ContactMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ContactMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering ContactMapper->importTokens");
		Contact contact = null;
		Address address = new Address();
		Marketing marketing = new Marketing();
		String custAcct = "";
		DataService dataService = new DataService();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];

			if ("recno".equals(currentFieldToken)) {
				contact = (Contact)dataService.getByPrevId("Contact", currentImportToken);
				if (contact == null)
					contact = new Contact();
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
//				if (currentImportToken.equals("") == false) {
//					City city = (City)dataService.getByName("City", currentImportToken);
//					if (city == null) {
//						city = new City();
//						city.setName(currentImportToken);
//						city = (City)dataService.addUpdate(city);
//					}
//				}
			} else if ("state".equals(currentFieldToken)) {
				address.setState(currentImportToken);
//				if (currentImportToken.equals("") == false) {
//					State state = (State)dataService.getByName("State", currentImportToken);
//					if (state == null) {
//						state = new State();
//						state.setName(currentImportToken);
//						state = (State)dataService.addUpdate(state);
//					}
//				}
			} else if ("zip".equals(currentFieldToken)) {
				address.setZip(currentImportToken);
//				if (currentImportToken.equals("") == false) {
//					Zip zip = (Zip)dataService.getByName("Zip", currentImportToken);
//					if (zip == null) {
//						zip = new Zip();
//						zip.setName(currentImportToken);
//						zip = (Zip)dataService.addUpdate(zip);
//					}
//				}
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
				if (currentImportToken.equals("") == false) {
					JobTitle title = (JobTitle)dataService.getByName("JobTitle", currentImportToken);
					if (title == null) {
						title = new JobTitle();
						title.setName(currentImportToken);
						title = (JobTitle)dataService.addUpdate(title);
					}
					contact.setJobTitle(title);
				}
				
				
			} else if ("phone".equals(currentFieldToken)) {
				try {
					if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
						contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Phone"));
					}
				} catch (Exception e) {
					/* CURRENT PROBLEM WITH COM LINK LAZY LOAD, THIS IS HERE UNTIL RESOLVED */
				}
			} else if ("fax".equals(currentFieldToken)) {
				try {
					if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
						contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Fax"));
					}
				} catch (Exception e) {
					/* CURRENT PROBLEM WITH COM LINK LAZY LOAD, THIS IS HERE UNTIL RESOLVED */
				}
			} else if ("phone 2".equals(currentFieldToken)) {
				try {
					if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
						contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Cell"));
					}
				} catch (Exception e) {
					/* CURRENT PROBLEM WITH COM LINK LAZY LOAD, THIS IS HERE UNTIL RESOLVED */
				}
			} else if ("phone 3".equals(currentFieldToken)) {
				try {
					if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
						contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Other"));
					}
				} catch (Exception e) {
					/* CURRENT PROBLEM WITH COM LINK LAZY LOAD, THIS IS HERE UNTIL RESOLVED */
				}
			} else if ("phone 4".equals(currentFieldToken)) {
				try {
					if (currentImportToken.length() > 0 && !currentImportToken.equals(" ")) {
						contact.addComLinks(Utilities.tokenToComLink(currentImportToken, "E-Mail"));
					}
				} catch (Exception e) {
					/* CURRENT PROBLEM WITH COM LINK LAZY LOAD, THIS IS HERE UNTIL RESOLVED */
				}
			} else if ("prefix".equals(currentFieldToken)) {
				contact.setPrefix(currentImportToken);
			} else if ("suffix".equals(currentFieldToken)) {
				contact.setSuffix(currentImportToken);
			} else if ("ship address ID".equals(currentFieldToken)) {
				address = (Address)dataService.getByPrevId("Address", currentImportToken);
				if (address != null)
					contact.addShipToAddress(address);
			} else if ("bill address ID".equals(currentFieldToken)) {
				address = (Address)dataService.getByPrevId("Address", currentImportToken);
				if (address != null)
					contact.setAddress(address);
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
				contact.setCcImportRec(currentImportToken);
			} else if ("created".equals(currentFieldToken)) {
				 contact.setCreated(Utilities.tokenToDate(currentImportToken));
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
		if (contact.getFirstName().equals("") && contact.getLastName().equals(""))
			return null;
		if (contact.getContactId() != null
				&& contact.getContactId().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setContact(Long.parseLong(contact.getContactId()));
			dataService.addUpdate(sequenceValues);
		}
		log.info("Leaving ContactMapper->importTokens");
		return contact;
	}
}
