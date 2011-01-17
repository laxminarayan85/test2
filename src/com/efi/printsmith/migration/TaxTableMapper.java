package com.efi.printsmith.migration;


import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PaperPrice;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.TaxElement;
import com.efi.printsmith.data.TaxTablesElements;
import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import com.efi.printsmith.service.DataService;
public class TaxTableMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(TaxTableMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering TaxTableMapper->importTokens");
		TaxTable taxTable = new TaxTable();
		taxTable.setTaxTableIsCurrent(true);
		taxTable.setDisableTable(false);
		TaxElement taxElement = null;
		TaxElement taxElement2 = null;
		TaxElement taxElement3 = null;
		TaxElement taxElement4 = null;
		TaxElement taxElement5 = null;
		TaxElement taxElement6 = null;
		TaxElement taxElement7 = null;
		TaxElement taxElement8 = null;
		TaxElement taxElement9 = null;
		TaxElement taxElement10 = null;
		TaxElement taxElement11 = null;
		TaxElement taxElement12 = null;
		
		DataService dataService = new DataService();
		ModelBase modelBase = null;
		String CreatedDate;
		String CreatedTime;
		String LocalDate;
		String LocalTime;
		
		Date createDateTime =new Date();
		Date localDateTime=new Date();
		String prevId = "";
		int count = 0;
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
				prevId = currentImportToken;
			} else if ("taxTableTableName".equals(currentFieldToken)) {
				TaxTable testTable = dataService.getByTaxTableName(currentImportToken);
				if (testTable != null) {
					taxTable = null;
					taxTable = dataService.getByTaxTableName(currentImportToken);
					taxTable.setPrevId(prevId);
				}
				taxTable.setName(currentImportToken);
				taxTable.setDefaultTable(false);
			} else if ("taxTableTableKey".equals(currentFieldToken)) {
				taxTable.setAbbr(currentImportToken);
			} else if ("taxTableEntryCreated".equals(currentFieldToken)) {
				taxTable.setTableCreateDateTime(Utilities.tokenToDate(currentImportToken));
			} else if ("taxTableEntryCreatedTime".equals(currentFieldToken)) {
				CreatedTime = currentImportToken;
			} else if ("taxTableEntryCreatedAsLocalDate".equals(currentFieldToken)) {
				taxTable.setTableCreateLocalDateTime(Utilities.tokenToDate(currentImportToken));
			} else if ("taxTableEntryCreatedAsLocalTime".equals(currentFieldToken)) {
				LocalTime = currentImportToken;
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				taxTable.setEffectiveTaxRate(Utilities.tokenToDouble(currentImportToken));
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				count++;
				modelBase = dataService.getByPrevId("TaxTablesElements",currentImportToken);
				switch (count){
					case 1 :
						if (modelBase != null) {
							taxElement = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement.setTax(tax);
							taxElement.setSequenceid(count);
						}
						break;
					case 2 : 
						if (modelBase != null) {
							taxElement2 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement2.setTax(tax);
							taxElement2.setSequenceid(count);
						}
						break;
					case 3 :
						if (modelBase != null) {
							taxElement3 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement3.setTax(tax);
							taxElement3.setSequenceid(count);
						}
						break;
					case 4 : 
						if (modelBase != null) {
							taxElement4 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement4.setTax(tax);
							taxElement4.setSequenceid(count);
						}
						break;
					case 5 :
						if (modelBase != null) {
							taxElement5 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement5.setTax(tax);
							taxElement5.setSequenceid(count);
						}
						break;
					case 6 : 
						if (modelBase != null) {
							taxElement6 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement6.setTax(tax);
							taxElement6.setSequenceid(count);
						}
						break;
					case 7 :
						if (modelBase != null) {
							taxElement7 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement7.setTax(tax);
							taxElement7.setSequenceid(count);
						}
						break;
					case 8 : 
						if (modelBase != null) {
							taxElement8 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement8.setTax(tax);
							taxElement8.setSequenceid(count);
						}
						break;
					case 9 :
						if (modelBase != null) {
							taxElement9 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement9.setTax(tax);
							taxElement9.setSequenceid(count);
						}
						break;
					case 10 : 
						if (modelBase != null) {
							taxElement10 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement10.setTax(tax);
							taxElement10.setSequenceid(count);
						}
						break;
					case 11 :
						if (modelBase != null) {
							taxElement11 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement11.setTax(tax);
							taxElement11.setSequenceid(count);
						}
						break;
					case 12 : 
						if (modelBase != null) {
							taxElement12 = new TaxElement();
							long id = modelBase.getId();
							TaxTablesElements tax= (TaxTablesElements)dataService.getById("TaxTablesElements", id);
							taxElement12.setTax(tax);
							taxElement12.setSequenceid(count);
						}
						break;
				}
				
			} else if ("taxTableElementTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableKey".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rate".equals(currentFieldToken)) {
				switch (count){
					case 1 :
						if (taxElement != null)
							taxElement.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 2 : 
						if (taxElement2 != null)
							taxElement2.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 3 :
						if (taxElement3 != null)
							taxElement3.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 4 : 
						if (taxElement4 != null)
							taxElement4.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 5 :
						if (taxElement5 != null)
							taxElement5.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 6 : 
						if (taxElement6 != null)
							taxElement6.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 7 :
						if (taxElement7 != null)
							taxElement7.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
						
					case 8 : 
						if (taxElement8 != null)
							taxElement8.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 9 :
						if (taxElement9 != null)
							taxElement9.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
						
					case 10 :
						if (taxElement10 != null)
							taxElement10.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 11 :
						if (taxElement11 != null)
							taxElement11.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					case 12 : 
						if (taxElement12 != null)
							taxElement12.setRate(Utilities.tokenToDouble(currentImportToken));
						break;
					}
					
				
				
			} else if ("showTheTax".equals(currentFieldToken)) {
				switch (count){
				case 1 :
					if (taxElement != null)
						taxElement.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 2 :
					if (taxElement2 != null)
						taxElement2.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 3 :
					if (taxElement3 != null)
						taxElement3.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
					
				case 4 : 
					if (taxElement4 != null)
						taxElement4.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 5 :
					if (taxElement5 != null)
						taxElement5.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 6 : 
					if (taxElement6 != null)
						taxElement6.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 7 :
					if (taxElement7 != null)
						taxElement7.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 8 :
					if (taxElement8 != null)
						taxElement8.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 9 :
					if (taxElement9 != null)
						taxElement9.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 10 : 
					if (taxElement10 != null)
						taxElement10.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 11 :
					if (taxElement11 != null)
						taxElement11.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 12 :
					if (taxElement12 != null)
						taxElement12.setShowTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				}
				
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				switch (count){
				case 1 :
					if (taxElement != null)
						taxElement.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 2 : 
					if (taxElement2 != null)
						taxElement2.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 3 :
					if (taxElement3 != null)
						taxElement3.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 4 :
					if (taxElement4 != null)
						taxElement4.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 5 :
					if (taxElement5 != null)
						taxElement5.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 6 :
					if (taxElement6 != null)
						taxElement6.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 7 :
					if (taxElement7 != null)
						taxElement7.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 8 : 
					if (taxElement8 != null)
						taxElement8.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 9 :
					if (taxElement9 != null)
						taxElement9.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 10 :
					if (taxElement10 != null)
						taxElement10.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 11 :
					if (taxElement11 != null)
						taxElement11.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				case 12 : 
					if (taxElement12 != null)
						taxElement12.setUserForSeparateShippingTax(Utilities.tokenToBooleanValue(currentImportToken));
					break;
				} 
					
			} else if ("taxTableIsTheCurrentOne".equals(currentFieldToken)) {
				taxTable.setTaxTableIsCurrent(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxShipping".equals(currentFieldToken)) {
				taxTable.setTaxShipping(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("separateShippingTaxElements".equals(currentFieldToken)) {
				taxTable.setSeparateShipping(Utilities.tokenToBooleanValue(currentImportToken));
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
			}else if ("minimumTaxableAmount".equals(currentFieldToken)) {
				taxTable.setMinAmount(Utilities.tokenToDouble(currentImportToken));
			}
			          
           }
		 taxTable = (TaxTable)dataService.addUpdate(taxTable);
		 if (taxElement != null)
      	   taxTable.addTaxElements(taxElement);
		 if (taxElement2 != null)
	      	   taxTable.addTaxElements(taxElement2); 
		 if (taxElement3 != null)
	      	   taxTable.addTaxElements(taxElement3);
		 if (taxElement4 != null)
	      	   taxTable.addTaxElements(taxElement4);
		 if (taxElement5 != null)
	      	   taxTable.addTaxElements(taxElement5);
		 if (taxElement6 != null)
	      	   taxTable.addTaxElements(taxElement6);
		 if (taxElement7 != null)
	      	   taxTable.addTaxElements(taxElement7);
		 if (taxElement8 != null)
	      	   taxTable.addTaxElements(taxElement8);
		 if (taxElement9 != null)
	      	   taxTable.addTaxElements(taxElement9);
		 if (taxElement10 != null)
	      	   taxTable.addTaxElements(taxElement10);
		 if (taxElement11 != null)
	      	   taxTable.addTaxElements(taxElement11);
		 if (taxElement12 != null)
	      	   taxTable.addTaxElements(taxElement12);
		 
		 
		log.info("Leaving TaxTableMapper->importTokens");
		return taxTable;
	}
}
