package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import com.efi.printsmith.data.CostingRecord;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.PricingRecord;
import com.efi.printsmith.data.ProductionLocations;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PaperCalculator;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.Dimension;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.Constants;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class JobMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(JobMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering JobMapper->importTokens");
		DataService dataService = new DataService();
		Job job = new Job();
		PricingRecord pricingRecord = new PricingRecord();
		CostingRecord costingRecord = new CostingRecord();
		costingRecord = (CostingRecord)dataService.addUpdate(costingRecord);
		job.setCostingRecord(costingRecord);
		PaperCalculator tempPaper = new PaperCalculator();
		Dimension dimension = new Dimension();
		Dimension parentdimension = new Dimension();
		Dimension finishdimension = new Dimension();
		Dimension folddimension = new Dimension();
		SalesCategory salesCategory = null;
		String method = "";
		String docType = "";
		String invoiceNumber = "";
		Boolean dutch = false;
		Boolean grain = false;
		Boolean Copy = false;
		Long qtyPress = null;
		Long totalQty= null;
		boolean addSalesCategory = false;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			
			if ("recno".equals(currentFieldToken)) {
				job.setPrevId(currentImportToken);
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doc type".equals(currentFieldToken)) {
				docType = currentImportToken;
			} else if ("prep rec".equals(currentFieldToken)) {
				job.setRootChargeRecord(currentImportToken);
			} else if ("invoice number".equals(currentFieldToken)) {
				invoiceNumber = currentImportToken;
			} else if ("order number".equals(currentFieldToken)) {
				invoiceNumber = currentImportToken;
			} else if ("job number".equals(currentFieldToken)) {
				job.setJobNumber(currentImportToken);
				job.setJobIndex(Utilities.tokenToLong(currentImportToken));
			} else if ("sales category".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", currentImportToken);
					if (salesCategory != null)
						job.setSalesCategory(salesCategory);
					else {
						salesCategory = new SalesCategory();
						salesCategory.setPrevId(currentImportToken);
						salesCategory = (SalesCategory)dataService.addUpdate(salesCategory);
						addSalesCategory = true;
					}
				}	
			} else if ("sales cat name".equals(currentFieldToken)) {
				if (addSalesCategory == true) {
					salesCategory.setName(currentImportToken);
					salesCategory = (SalesCategory)dataService.addUpdate(salesCategory);
					salesCategory.setId(salesCategory.getId());
					job.setSalesCategory(salesCategory);
				}
			} else if ("press ID".equals(currentFieldToken)) {
//				if (job.getPricingMethod().equals(Constants.))
				PressDefinition pressDefinition = (PressDefinition) dataService.getByPressId(currentImportToken);
				if (pressDefinition != null){
					job.setPress(pressDefinition);
					job.setPricingPress(pressDefinition);
				}
			
			} else if ("press name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job ticket notes".equals(currentFieldToken)) {
				job.setJobTicketNotes(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("order qty".equals(currentFieldToken)) {
				job.setQtyOrdered(Utilities.tokenToLong(currentImportToken));
			} else if ("addl qty[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl qty[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl qty[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("product code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("book id".equals(currentFieldToken)) {
				/* TODO */
			} else if ("press".equals(currentFieldToken)) {
				qtyPress= Utilities.tokenToLong(currentImportToken);
							
			} else if ("runs".equals(currentFieldToken)) {
				/* TODO */
			} else if ("originals".equals(currentFieldToken)) {
				job.setSheets(Utilities.tokenToLong(currentImportToken));
				job.setStockQty(Utilities.tokenToLong(currentImportToken));
			} else if ("signatures".equals(currentFieldToken)) {
				job.setSignatures(Utilities.tokenToLong(currentImportToken));
			} else if ("sets".equals(currentFieldToken)) {
				job.setInSetsOf(Utilities.tokenToLong(currentImportToken));
			} else if ("up".equals(currentFieldToken)) {
				job.setNumUp(Utilities.tokenToLong(currentImportToken));
			} else if ("on".equals(currentFieldToken)) {
				job.setNumOn(Utilities.tokenToLong(currentImportToken));
			} else if ("runout".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pricing method".equals(currentFieldToken)) {
				method = currentImportToken;
				if (method.equals("16")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(false);
					
				} else if (method.equals("17")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(true);
					
				} else if (method.equals("18")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(true);
					job.setSpecialOrderStock(false);

				} else if (method.equals("26")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(false);
				}else if (method.equals("27")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(true);	
				} else if (method.equals("28")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(true);
					job.setSpecialOrderStock(false);
				} else if (method.equals("36")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(false);
				} else if (method.equals("37")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(true);
				} else if (method.equals("38")){
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(true);
					job.setSpecialOrderStock(false);
				} else if (method.equals("46")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(false);
				} else if (method.equals("47")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(true);
				} else if (method.equals("48")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(true);
					job.setSpecialOrderStock(false);
				} else if (method.equals("56")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(false);
				} else if (method.equals("57")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(false);
					job.setSpecialOrderStock(true);
				} else if (method.equals("58")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					job.setCustomerSuppliedStock(true);
					job.setSpecialOrderStock(false);
				} else if (method.equals("60")){
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("70")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("80")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("90")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("100")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("110")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("120")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("130")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("140")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("150")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("160")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("170")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
					
				} else if (method.equals("190")) {
					PreferencesPricingMethod Method = dataService.getByMethodType(method);
					job.setPricingMethod(Method);
				
				}
			} else if ("colors front".equals(currentFieldToken)) {
				job.setFrontColors(Utilities.tokenToInt(currentImportToken));
			} else if ("colors back".equals(currentFieldToken)) {
				job.setBackColors(Utilities.tokenToInt(currentImportToken));
			} else if ("passes front".equals(currentFieldToken)) {
				job.setFrontPasses(Utilities.tokenToInt(currentImportToken));
			} else if ("passes back".equals(currentFieldToken)) {
				job.setBackPasses(Utilities.tokenToInt(currentImportToken));
			} else if ("wash front".equals(currentFieldToken)) {
				job.setFrontWashes(Utilities.tokenToInt(currentImportToken));
			} else if ("wash back".equals(currentFieldToken)) {
				job.setBackWashes(Utilities.tokenToInt(currentImportToken));
			} else if ("sheets".equals(currentFieldToken)) {
				job.setTotalImpressions(Utilities.tokenToLong(currentImportToken));
			} else if ("waste".equals(currentFieldToken)) {
				job.setEstWaste(Utilities.tokenToLong(currentImportToken));
			} else if ("impressions".equals(currentFieldToken)) {
				job.setImpressionsPerRun(Utilities.tokenToLong(currentImportToken));
			} else if ("total impressions".equals(currentFieldToken)) {
				totalQty = Utilities.tokenToLong(currentImportToken);
				
			} else if ("stock id".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false && currentImportToken.equals("0") == false) {
					StockDefinition stockDefinition = dataService.getByStockId(currentImportToken);
					if (stockDefinition != null) {
						job.setStock(stockDefinition);
					}
				}
			} else if ("parent X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("parent size".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					parentdimension = (Dimension) dataService.getByName("Dimension",currentImportToken);
					if (parentdimension != null)
						job.setParentSize(parentdimension);
						
					}
			} else if ("parent Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run size".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					dimension = (Dimension) dataService.getByName("Dimension",currentImportToken);
					if (dimension != null)
						job.setRunSize(dimension);
					}
			} else if ("run Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finish size".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					finishdimension = (Dimension) dataService.getByName("Dimension",currentImportToken);
					if (finishdimension != null)
						job.setFinishSize(finishdimension);
					
					}
			} else if ("finish Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock units".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material markup amt".equals(currentFieldToken)) {
				/* TODO */
			} else if ("press speed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor markup".equals(currentFieldToken)) {
				/* TODO */
			} else if ("setup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor cost".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labor markup amt".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o sets".equals(currentFieldToken)) {
				job.setOrSets(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o overprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o overunitprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o runtime".equals(currentFieldToken)) {
				job.setOrRuntime(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o Setuptime".equals(currentFieldToken)) {
				job.setOrSetupTime(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o stockUnits".equals(currentFieldToken)) {
				job.setOrStockUnits(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o stockMarkup".equals(currentFieldToken)) {
				job.setOrStockMarkup(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o stockCost".equals(currentFieldToken)) {
				job.setOrStockCost(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o Waste".equals(currentFieldToken)) {
				job.setOrWaste(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o Prod".equals(currentFieldToken)) {
				job.setOrProduction(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o unit".equals(currentFieldToken)) {
				job.setOrUnit(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o price".equals(currentFieldToken)) {
				job.setOrPrice(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o runout".equals(currentFieldToken)) {
				job.setOrRunOut(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o labor markup".equals(currentFieldToken)) {
				job.setOrLaborMarkup(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o labor rate".equals(currentFieldToken)) {
				job.setOrLaborRate(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o aimp".equals(currentFieldToken)) {
				/* TODO */
			} else if ("isWeb".equals(currentFieldToken)) {
				/* TODO */
			} else if ("workNturn".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dutch".equals(currentFieldToken)) {
				dutch = Utilities.tokenToBooleanValue(currentImportToken);
				
			} else if ("grain".equals(currentFieldToken)) {
				grain = Utilities.tokenToBooleanValue(currentImportToken);
			} else if ("stock ordered".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tickets printed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("finished".equals(currentFieldToken)) {
				job.setFinished(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("brokered".equals(currentFieldToken)) {
				job.setBrokered(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				job.setTaxable(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o pass front".equals(currentFieldToken)) {
				job.setOrPassFront(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o pass back".equals(currentFieldToken)) {
				job.setOrPassBack(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("noPages".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hasCover".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hidden".equals(currentFieldToken)) {
				/* TODO */
			} else if ("overs".equals(currentFieldToken)) {
				job.setOversUnders(Utilities.tokenToLong(currentImportToken));
			} else if ("overs unit price".equals(currentFieldToken)) {
				pricingRecord.setOversUnitPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("overs price".equals(currentFieldToken)) {
				pricingRecord.setOversTotalPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("prep price".equals(currentFieldToken)) {
				pricingRecord.setPrepPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("prod price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("bind price".equals(currentFieldToken)) {
				pricingRecord.setBindPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("markup total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prod charge total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("add M".equals(currentFieldToken)) {
				/* TODO */
			} else if ("unit price".equals(currentFieldToken)) {
				pricingRecord.setUnitPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("total price".equals(currentFieldToken)) {
				pricingRecord.setTotalPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("description".equals(currentFieldToken)) {
				job.setDescription(currentImportToken);
			} else if ("stock name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock color".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0) {
					String currentString = currentImportToken;
					ArrayList<String> colors = getInkColors(currentImportToken);
					
					for (int index=0; index < 7 && index < colors.size(); index++) {
						if (index == 0) {
							job.setFrontColor1(colors.get(index));
						} else if (index == 1) {
							job.setFrontColor2(colors.get(index));
						} else if (index == 2) {
							job.setFrontColor3(colors.get(index));
						} else if (index == 3) {
							job.setFrontColor4(colors.get(index));
						} else if (index == 4) {
							job.setFrontColor5(colors.get(index));
						} else if (index == 5) {
							job.setFrontColor6(colors.get(index));
						} else if (index == 6) {
							job.setFrontColor7(colors.get(index));
						}
					}
				}
			} else if ("ink back".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0) {
					String currentString = currentImportToken;
					ArrayList<String> colors = getInkColors(currentImportToken);
					
					for (int index=0; index < 7 && index < colors.size(); index++) {
						if (index == 0) {
							job.setBackColor1(colors.get(index));
						} else if (index == 1) {
							job.setBackColor2(colors.get(index));
						} else if (index == 2) {
							job.setBackColor3(colors.get(index));
						} else if (index == 3) {
							job.setBackColor4(colors.get(index));
						} else if (index == 4) {
							job.setBackColor5(colors.get(index));
						} else if (index == 5) {
							job.setBackColor6(colors.get(index));
						} else if (index == 6) {
							job.setBackColor7(colors.get(index));
						}
					}
				}
			} else if ("notes".equals(currentFieldToken)) {
				job.setJobNotes(currentImportToken);
			} else if ("location".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					ProductionLocations location = dataService
							.getByLocationName(currentImportToken);
					if (location == null) {
						location = new ProductionLocations();
						location.setName(currentImportToken);
						location = (ProductionLocations)dataService.addUpdate(location);
						location.setId(location.getId());
					}
					job.setLocation(location);
				}
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("base sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("gripper edge".equals(currentFieldToken)) {
				tempPaper.setGripEdgeGap(Utilities.tokenToDouble(currentImportToken));
			} else if ("grip side".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true) 
					tempPaper.setGripLocation("Top");
				if (currentImportToken.equals("2") == true) 
					tempPaper.setGripLocation("Left");
			} else if ("folio edge".equals(currentFieldToken)) {
				tempPaper.setFolioEdge(Utilities.tokenToDouble(currentImportToken));	
			} else if ("which start size".equals(currentFieldToken)) {
				tempPaper.setWhichStartSize(Utilities.tokenToInt(currentImportToken));
			} else if ("folio side".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true) 
					tempPaper.setFolioLocation("Top");
				if (currentImportToken.equals("2") == true) 
					tempPaper.setFolioLocation("Left");
			} else if ("finish bleed[1]".equals(currentFieldToken)) {
				tempPaper.setBleedLeft(Utilities.tokenToDouble(currentImportToken));
			} else if ("finish bleed[2]".equals(currentFieldToken)) {
				tempPaper.setBleedRight(Utilities.tokenToDouble(currentImportToken));
			} else if ("finish bleed[3]".equals(currentFieldToken)) {
				tempPaper.setBleedTop(Utilities.tokenToDouble(currentImportToken));
			} else if ("finish bleed[4]".equals(currentFieldToken)) {
				tempPaper.setBleedBottom(Utilities.tokenToDouble(currentImportToken));
			} else if ("finish gutter[1]".equals(currentFieldToken)) {
				tempPaper.setGutterHorizontal(Utilities.tokenToDouble(currentImportToken));
			} else if ("finish gutter[2]".equals(currentFieldToken)) {
				tempPaper.setGutter(Utilities.tokenToDouble(currentImportToken));
			} else if ("parent out".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cuts run".equals(currentFieldToken)) {
				tempPaper.setCutstoRun(Utilities.tokenToInt(currentImportToken));
			} else if ("cuts finish".equals(currentFieldToken)) {
				tempPaper.setCutstoFinish(Utilities.tokenToInt(currentImportToken));
			} else if ("use grip".equals(currentFieldToken)) {
				tempPaper.setUseGripEdgeGap(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use folio".equals(currentFieldToken)) {
				tempPaper.setUseFolioEdge(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use finish bleed".equals(currentFieldToken)) {
				tempPaper.setUseBleed(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use finish gutter".equals(currentFieldToken)) {
				tempPaper.setUseGutter(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("use color bar".equals(currentFieldToken)) {
				tempPaper.setUseColorBar(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o run cuts".equals(currentFieldToken)) {
				job.setOrRunCuts(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o finish cuts".equals(currentFieldToken)) {
				job.setOrFinishCuts(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o up".equals(currentFieldToken)) {
				job.setOrUp(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("o parent out".equals(currentFieldToken)) {
				job.setOrParentOut(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("product code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costing press id".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					PressDefinition pressDefinition = dataService.getByPressId(currentImportToken);
					if (pressDefinition != null)
						job.setCostingPress(pressDefinition);
				}
			} else if ("costing press name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital que ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job comment".equals(currentFieldToken)) {
				job.setComment(currentImportToken);
			} else if ("ink front 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink front 7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 6".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink back 7".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital asset 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("fiery workflow".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web notes rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web notes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("paper template ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("paper template name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker route rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker route def".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker total time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker total time text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker priority ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock committed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock consumed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker location ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker location".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock ordered date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock ordered time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web component ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking date[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracking time[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital submit date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital submit time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital start by date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital start by time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital run by date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital run by time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital completed date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("digital completed time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("percent complete".equals(currentFieldToken)) {
				/* TODO */
			} else if ("jdf submit status".equals(currentFieldToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentFieldToken)) {
				/* TODO */
			} else if ("extra stock".equals(currentFieldToken)) {
				/* TODO */
			} else if ("odd run count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("odd sig per run".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folded X".equals(currentFieldToken)) {
				/* TODO */
			} else if ("folded size".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					folddimension = (Dimension) dataService.getByName("Dimension",currentImportToken);
					if (folddimension != null)
						job.setFoldedSize(folddimension);
							
					}
			} else if ("folded Y".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock lot count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run size area".equals(currentFieldToken)) {
				/* TODO */
			} else if ("white space[1]".equals(currentFieldToken)) {
				tempPaper.setWhiteSpaceLeft(Utilities.tokenToDouble(currentImportToken));
			} else if ("white space[2]".equals(currentFieldToken)) {
				tempPaper.setWhiteSpaceRight(Utilities.tokenToDouble(currentImportToken));
			} else if ("white space[3]".equals(currentFieldToken)) {
				tempPaper.setWhiteSpaceTop(Utilities.tokenToDouble(currentImportToken));
			} else if ("white space[4]".equals(currentFieldToken)) {
				tempPaper.setWhiteSpaceBottom(Utilities.tokenToDouble(currentImportToken));
			} else if ("across".equals(currentFieldToken)) {
				tempPaper.setAcross(Utilities.tokenToInt(currentImportToken));
			} else if ("down".equals(currentFieldToken)) {
				tempPaper.setDown(Utilities.tokenToInt(currentImportToken));
			} else if ("dAcross".equals(currentFieldToken)) {
				tempPaper.setdAcross(Utilities.tokenToInt(currentImportToken));
			} else if ("dDown".equals(currentFieldToken)) {
				tempPaper.setdDown(Utilities.tokenToInt(currentImportToken));
			} else if ("r margin".equals(currentFieldToken)) {
				tempPaper.setrMargin(Utilities.tokenToDouble(currentImportToken));
			} else if ("b margin".equals(currentFieldToken)) {
				tempPaper.setbMargin(Utilities.tokenToDouble(currentImportToken));
			} else if ("t margin".equals(currentFieldToken)) {
				tempPaper.settMargin(Utilities.tokenToDouble(currentImportToken));
			} else if ("used area".equals(currentFieldToken)) {
				tempPaper.setUsedSqrArea(Utilities.tokenToDouble(currentImportToken));
			} else if ("parent area".equals(currentFieldToken)) {
				tempPaper.setParentSqrArea(Utilities.tokenToDouble(currentImportToken));
			} else if ("washup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock group".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock coat".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock grade".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock generic finish".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock generic color".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock vendor ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("vender name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pick stock weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shipping weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run weight".equals(currentFieldToken)) {
				/* TODO */
			} else if ("mQuant".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use paper calc up".equals(currentFieldToken)) {
				job.setUsePaperCalcUp(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("completed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("show notes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("oParentSize".equals(currentFieldToken)) {
				job.setOrParentSize(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("price locked".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o bind waste".equals(currentFieldToken)) {
				job.setOrBinderyWaste(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("copier side adjust".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use white space".equals(currentFieldToken)) {
				tempPaper.setUseWhiteSpace(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("is crouser".equals(currentFieldToken)) {
				/* TODO */
			} else if ("run & tumble".equals(currentFieldToken)) {
				tempPaper.setRunAndTumble(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("obs_tax in price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dutch bottom".equals(currentFieldToken)) {
				tempPaper.setDutchBottom(Utilities.tokenToInt(currentImportToken));
			} else if ("finish".equals(currentFieldToken)) {
				/* TODO */
			} else if ("back trim parent".equals(currentFieldToken)) {
				tempPaper.setBackTrimParent(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("back trim run".equals(currentFieldToken)) {
				tempPaper.setTrimFourSides(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("diagram on job".equals(currentFieldToken)) {
				tempPaper.setAttachToJobTicket(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("digital submitted".equals(currentFieldToken)) {
				/* TODO */
			} else if ("work & turn new".equals(currentFieldToken)) {
				tempPaper.setWorkandTurn(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("override washup time".equals(currentFieldToken)) {
				job.setOrWashupTime(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("production release".equals(currentFieldToken)) {
				/* TODO */
			} else if ("attach routing list".equals(currentFieldToken)) {
				/* TODO */
			} else if ("use booklet total clicks".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stock is inventoried".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inventory consumed by Tracker".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web adjusted price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("o Qty Ordered".equals(currentFieldToken)) {
				job.setOrQtyOrder(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("is Print Job".equals(currentFieldToken)) {
				/* TODO */
			} else if ("is Copy Job".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true){
					Copy = true;
				}
			} else if ("is large format".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true){
					PreferencesPricingMethod Method = dataService.getByMethodType("Large Format");
					job.setPricingMethod(Method);
				}
			} else if ("is Roll Job".equals(currentFieldToken)) {
				if (currentImportToken.equals("1") == true){
					PreferencesPricingMethod Method = dataService.getByMethodType("Roll-Fed");
					job.setPricingMethod(Method);
				}
			} else if ("est has mult qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("est selected multi qty version".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("quantity".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("accumulatedTaxes".equals(currentFieldToken)) {
				/* TODO */
			} else if ("target price".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl price[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax sub".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("OBSv3job".equals(currentFieldToken)) {
				tempPaper.setDisableFSC(Utilities.tokenToBooleanValue(currentImportToken));
			}
			else if ("bindery waste".equals(currentFieldToken)) {
				job.setBinderyWaste(Utilities.tokenToLong(currentImportToken));
			}
		}
		if (job.getJobNumber() != null
				&& job.getJobNumber().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setJob(Long.parseLong(job.getJobNumber()));
			dataService.addUpdate(sequenceValues);
		}
		if (Copy){
			job.setNumCopies(qtyPress);
			job.setTotalCopies(totalQty);
		}
		else{
				job.setPressQty(qtyPress);
				job.setTotalImpressions(totalQty);
		}
		if( dutch)
			tempPaper.setRunToFinishGrain("Swing / Combination");
		else if (grain)
			tempPaper.setRunToFinishGrain("Match Grain");
			else
				tempPaper.setRunToFinishGrain("Neither");
		job.setPaperCal(tempPaper);
		pricingRecord = (PricingRecord)dataService.addUpdate(pricingRecord);
		pricingRecord.setId(pricingRecord.getId());
		job.setPricingRecord(pricingRecord);
		if (job.getFrontColors() > 0 && job.getBackColors() > 0) {
			job.setSingleSided(false);
			job.setDoubleSided(true);
		} else {
			job.setSingleSided(true);
			job.setDoubleSided(false);
		}
		job = (Job)dataService.addUpdate(job);
		job.setId(job.getId());
		if (invoiceNumber.equals("") == false && docType.equals("") == false) {
			InvoiceBase invoice = (InvoiceBase)dataService.getInvoiceByInvoiceNumber(invoiceNumber, docType);
			if (invoice != null) {
				job.setParentInvoice(invoice);
				invoice.addJobs(job);
				dataService.addUpdate(invoice);
			}
		}
		log.info("Leaving JobMapper->importTokens");
		return null;
	}
		
	private ArrayList<String> getInkColors(String field) {
		ArrayList<String> colors = new ArrayList<String>();
		while (field.contains(",")) {
			colors.add(field.substring(0, field.indexOf(',')).trim());
			field = field.substring(field.indexOf(',')).trim();
		}
		if (field.contains("&")) {
			colors.add(field.substring(0, field.indexOf('&')-1).trim());
			colors.add(field.substring(field.indexOf('&')+1).trim());
		} else {
			colors.add(field.trim());
		}
		return colors;
	}
}
