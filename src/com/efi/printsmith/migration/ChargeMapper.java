package com.efi.printsmith.migration;

import java.io.File;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import org.apache.log4j.Logger;
import java.util.List;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.ProductionLocations;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.InvoiceBase;

public class ChargeMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ChargeMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering ChargeDefinitionMapper->importTokens");
		Charge charge = new Charge();
		DataService dataService = new DataService();
		String documentNumber = "";
		String documentType = "";
		String jobNumber = "";
		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				charge.setPrevId(currentImportToken);
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doc number".equals(currentFieldToken)) {
				documentNumber = currentImportToken;
			} else if ("doc type".equals(currentFieldToken)) {
				documentType = currentImportToken;
			} else if ("next record".equals(currentFieldToken)) {
				if (documentType.equals("") == true) {
					charge.setNextRecord(currentImportToken);
				}
			} else if ("job number".equals(currentFieldToken)) {
				jobNumber = currentImportToken;
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
					ProductionLocations location = (ProductionLocations)dataService.getByName("Location", currentImportToken);
					if (location == null) {
						location = new ProductionLocations();
						location.setName(currentImportToken);
						location = (ProductionLocations)dataService.addUpdate(location);
					}
					charge.setProductionLocation(location);
				}
			}
		}
		charge = (Charge)dataService.addUpdate(charge);
		charge.setId(charge.getId());
		if (documentNumber.equals("") == false && jobNumber.equals("") == false) {
			InvoiceBase invoice = (InvoiceBase)dataService.getInvoiceByInvoiceNumber(documentNumber, documentType);
			if (invoice != null) {
				List<JobBase> jobs = invoice.getJobs();
				for (int i = 0; i < jobs.size(); i++) {
					if (jobs.get(i).getJobNumber().equals(jobNumber)) {
						JobBase job = jobs.get(i);
						job.addCharges(charge);
						dataService.addUpdate(job);
					}
				}
			}
		}
		log.info("Leaving ChargeDefinitionMapper->importTokens");	
		return charge;
	}
}