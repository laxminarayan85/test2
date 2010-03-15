package com.efi.printsmith.migration;


import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.TaxElement;
import java.io.File;

public class TaxTableMapper extends ImportMapper {
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		TaxTable taxTable = new TaxTable();
		TaxElement taxElement = null;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableTableID".equals(currentFieldToken)) {
				taxTable.setPrevId(currentImportToken);
			} else if ("taxTableTableName".equals(currentFieldToken)) {
				taxTable.setName(currentImportToken);
			} else if ("taxTableTableKey".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableEntryCreated".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableEntryCreatedTime".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableEntryCreatedAsLocalDate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableEntryCreatedAsLocalTime".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				taxTable.setEffectiveTaxRate(Utilities.tokenToDouble(currentImportToken));
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				if (taxElement != null)
					taxTable.addTaxElements(taxElement);
				taxElement = new TaxElement();
				taxElement.setPrevId(currentImportToken);
			} else if ("taxTableElementTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableKey".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rate".equals(currentFieldToken)) {
				taxElement.setRate(Utilities.tokenToDouble(currentImportToken));
			} else if ("showTheTax".equals(currentFieldToken)) {
				taxElement.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				taxElement.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxTableIsTheCurrentOne".equals(currentFieldToken)) {
				taxTable.setTaxTableIsCurrent(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxShipping".equals(currentFieldToken)) {
				taxTable.setTaxShipping(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("separateShippingTaxElements".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTax".equals(currentFieldToken)) {
				taxTable.setTaxOnTax(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("roundTaxUp".equals(currentFieldToken)) {
				taxTable.setRoundTaxUp(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxInPrice".equals(currentFieldToken)) {
				taxTable.setTaxInPrice(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("doDetail".equals(currentFieldToken)) {
				taxTable.setDoDetail(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("dontRoundShownTaxElements".equals(currentFieldToken)) {
				taxTable.setDontRoundShownTaxElements(Utilities.tokenToInt(currentImportToken));
			}
		}
		return taxTable;
	}
}
