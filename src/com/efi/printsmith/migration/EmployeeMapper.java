package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Employee;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

public class EmployeeMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(CopierDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {

	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		log.info("Entering EmployeeMapper->importTokens");
		Employee employee = new Employee();
		Address address = new Address();
		DataService dataService = new DataService();

		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if (currentFieldToken.equals("") == false) {
				if (currentFieldToken.equals("employee number"))
					employee.setEmployeeId(currentImportToken);
				else if (currentFieldToken.equals("first name"))
					employee.setFirstName(currentImportToken);
				else if (currentFieldToken.equals("last name"))
					employee.setLastName(currentImportToken);
				else if (currentFieldToken.equals("street1"))
					address.setStreet1(currentImportToken);
				else if (currentFieldToken.equals("street2"))
					address.setStreet2(currentImportToken);
				else if (currentFieldToken.equals("city"))
					address.setCity(currentImportToken);
				else if (currentFieldToken.equals("state"))
					address.setState(currentImportToken);
				else if (currentFieldToken.equals("zip"))
					address.setZip(currentImportToken);
				else if (currentFieldToken.equals("country"))
					address.setCountry(currentImportToken);
				else if (currentFieldToken.equals("ssn"))
					employee.setSocialSecurity(currentImportToken);
				else if (currentFieldToken.equals("export code"))
					employee.setExportCode(Utilities.tokenToInt(currentImportToken));
				else if (currentFieldToken.equals("PIN"))
					employee.setPin(currentImportToken);
				else if (currentFieldToken.equals("rate"))
					employee.setRate(Utilities.tokenToDouble(currentImportToken));
			}
		}
		address = (Address)dataService.addUpdate(address);
		employee.setAddress(address);
		return employee;
	}
}