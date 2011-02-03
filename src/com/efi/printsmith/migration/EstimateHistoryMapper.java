package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import com.efi.printsmith.service.DataService;

public class EstimateHistoryMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(EstimateHistoryMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering EstimateHistoryMapper->importTokens");
		InvoiceBase estimate = new  InvoiceBase();
		DataService dataService = new DataService();
		Boolean won = false;
		Boolean lost = false;
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("title".equals(currentFieldToken)) {
				/* TODO */
			} else if ("custno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("account name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ordno".equals(currentFieldToken)) {
				estimate = (InvoiceBase)dataService.getInvoiceByInvoiceNumber(currentImportToken, "E");
			} else if ("order display no".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notes pointer".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notes text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand1 ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand2 ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand3 ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inv won ordno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date est created".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date removed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand1 date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand2 date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand3 date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inv won date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand double".equals(currentFieldToken)) {
				/* TODO */
			} else if ("won".equals(currentFieldToken)) {
				won = Utilities.tokenToBooleanValue(currentImportToken);
			} else if ("lost".equals(currentFieldToken)) {
				lost = Utilities.tokenToBooleanValue(currentImportToken);
			} else if ("converted".equals(currentFieldToken)) {
				/* TODO */
			} else if ("voided".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("exp6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("flags".equals(currentFieldToken)) {
				/* TODO */
			} else if ("user name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand string".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		log.info("Leaving EstimateHistoryMapper->importTokens");
		if (won && lost)
			estimate.setStatus("Neutral");
		else if (won  && !lost)
			estimate.setStatus("Won");
		else
			estimate.setStatus("Lost");
			
		return estimate; 
	}
}
