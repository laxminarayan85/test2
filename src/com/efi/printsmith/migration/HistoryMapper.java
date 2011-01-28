package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class HistoryMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(HistoryMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering HistoryMapper->importTokens");
		Address address = new Address();
		DataService dataService = new DataService();
		
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("title".equals(currentImportToken)) {
				/* TODO */
			} else if ("custno".equals(currentImportToken)) {
				/* TODO */
			} else if ("account name".equals(currentImportToken)) {
				/* TODO */
			} else if ("ordno".equals(currentImportToken)) {
				/* TODO */
			} else if ("date posted".equals(currentImportToken)) {
				/* TODO */
			} else if ("due date".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax total".equals(currentImportToken)) {
				/* TODO */
			} else if ("sub total".equals(currentImportToken)) {
				/* TODO */
			} else if ("total".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax due".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax balance".equals(currentImportToken)) {
				/* TODO */
			} else if ("refund".equals(currentImportToken)) {
				/* TODO */
			} else if ("balance".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial checkno".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial date".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial type".equals(currentImportToken)) {
				/* TODO */
			} else if ("part count".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial total".equals(currentImportToken)) {
				/* TODO */
			} else if ("final checkno".equals(currentImportToken)) {
				/* TODO */
			} else if ("final date".equals(currentImportToken)) {
				/* TODO */
			} else if ("final amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("final type".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("cust PO".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales rep".equals(currentImportToken)) {
				/* TODO */
			} else if ("store number".equals(currentImportToken)) {
				/* TODO */
			} else if ("order display no".equals(currentImportToken)) {
				/* TODO */
			} else if ("reference inv number".equals(currentImportToken)) {
				/* TODO */
			} else if ("web reference ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial card ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("partial cct".equals(currentImportToken)) {
				/* TODO */
			} else if ("final card ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("final cct".equals(currentImportToken)) {
				/* TODO */
			}
		}
		log.info("Leaving HistoryMapper->importTokens");
		return address;
	}
}
