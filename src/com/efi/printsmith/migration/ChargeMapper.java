package com.efi.printsmith.migration;

import java.io.File;

import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.Location;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.Charge;

public class ChargeMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
		
	}
	
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		Charge charge = new Charge();
		DataService dataService = new DataService();
		
		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				charge.setPrevId(currentImportToken);
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("description".equals(currentFieldToken)) {
				charge.setDescription(currentImportToken);
			} else if ("finished".equals(currentFieldToken)) {
				charge.setFinished(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("displayqty".equals(currentFieldToken)) {
				charge.setDisplayQty(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("brokered".equals(currentFieldToken)) {
				charge.setBrokered(Utilities.tokenToBooleanValue(currentImportToken));
//			} else if ("attribute1".equals(currentFieldToken)) {
//				charge.setAttribute1(Utilities.tokenToInt(currentImportToken));
//			} else if ("attribute2".equals(currentFieldToken)) {
//				charge.setAttribute2(Utilities.tokenToInt(currentImportToken));
//			} else if ("attribute3".equals(currentFieldToken)) {
//				charge.setAttribute3(Utilities.tokenToInt(currentImportToken));
			} else if ("hide price".equals(currentFieldToken)) {
				charge.setHidePrice(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("notes".equals(currentFieldToken)) {
				charge.setNotes(currentImportToken);
			} else if ("total price".equals(currentFieldToken)) {
				charge.setPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("shownotes".equals(currentFieldToken)) {
				charge.setShowNotes(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				charge.setTaxable(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("charge ID".equals(currentFieldToken)) {
				ModelBase modelBase = dataService.getByPrevId("ChargeDefinition",currentImportToken);
				if (modelBase != null) {
					long id = modelBase.getId();
					ChargeDefinition chargeDefinition = (ChargeDefinition)dataService.getById("ChargeDefinition", id);
					charge.setChargeDefinition(chargeDefinition);
				}
			} else if ("production location".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					Location location = (Location)dataService.getByName("Location", currentImportToken);
					if (location == null) {
						location = new Location();
						location.setName(currentImportToken);
						location = (Location)dataService.addUpdate(location);
					}
					charge.setProductionLocation(location);
				}
			}
		}
		
		return charge;
	}
}