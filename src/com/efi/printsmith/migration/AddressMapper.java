package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.City;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.State;
import com.efi.printsmith.data.Zip;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class AddressMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ContactMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering AddresMapper->importTokens");
		Address address = new Address();
		DataService dataService = new DataService();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];

			if ("recno".equals(currentFieldToken)) {
				address.setPrevId(currentImportToken);
			} else if ("name".equals(currentFieldToken)) {
				address.setName(currentImportToken);
			} else if ("street 1".equals(currentFieldToken)) {
				address.setStreet1(currentImportToken);
			} else if ("street 2".equals(currentFieldToken)) {
				address.setStreet2(currentImportToken);
			} else if ("country".equals(currentFieldToken)) {
				address.setCountry(currentImportToken);
			} else if ("city".equals(currentFieldToken)) {
//				City city = (City)dataService.getByName("City", currentImportToken);
//				if (city == null) {
//					city = new City();
//					city.setName(currentImportToken);
//					city = (City)dataService.addUpdate(city);
//				}
				address.setCity(currentImportToken);
			} else if ("state".equals(currentFieldToken)) {
//				State state = (State)dataService.getByName("State", currentImportToken);
//				if (state == null) {
//					state = new State();
//					state.setName(currentImportToken);
//					state = (State)dataService.addUpdate(state);
//				}
				address.setState(currentImportToken);
			} else if ("zip".equals(currentFieldToken)) {
//				Zip zip = (Zip)dataService.getByName("Zip", currentImportToken);
//				if (zip == null) {
//					zip = new Zip();
//					zip.setName(currentImportToken);
//					zip = (Zip)dataService.addUpdate(zip);
//				}
				address.setZip(currentImportToken);
			}
		}
		log.info("Leaving AddressMapper->importTokens");
		return address;
	}
}
