package com.efi.printsmith.migration;

import java.io.File;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.FoldTemplate;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.ChargeCost;
import com.efi.printsmith.data.CostCenter;
import com.efi.printsmith.data.PreferencesDefaultPresses;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.ProductionLocations;
import com.efi.printsmith.data.PriceList;
import com.efi.printsmith.data.ShippingMethod;
import com.efi.printsmith.data.Substrate;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.WasteChart;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.ChargeCommand;
import com.efi.printsmith.data.ChargeCategory;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.ProductCode;

public class ChargeDefinitionMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(ChargeDefinitionMapper.class);
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public void importFile(File uploadedFile) throws Exception {
		log.info("Entering ChargeDefinitionMapper->importFile");
		FileInputStream fis = new FileInputStream(uploadedFile);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = csvReader.readNext();
		DataService dataService = new DataService();
		int lineNumber = 2;
		String[] importTokens = null;
		ArrayList<String> commandnames = new ArrayList<String>();
		ArrayList<String> commandlinkids = new ArrayList<String>();
		ArrayList<String> categorynames = new ArrayList<String>();
		ArrayList<String> categoryids = new ArrayList<String>();
		int categoryindex = 0;
		boolean newCommand = false;
		boolean newCategory = false;
		boolean useRateSets = false;
		String description = "";
		String linkId = "";
		String categoryId = "";
		String method = "";
		String setuptemp ="";
		String qtyType= "";
		while ((importTokens = csvReader.readNext()) != null) {
			if (importTokens.length != fieldTokens.length) {
				throw new InvalidParameterException(
						"Wrong number of fields on line #" + lineNumber + ".");
			} else {
				Charge charge = new Charge();
				ChargeDefinition chargeDefinition = new ChargeDefinition();
				PreferencesSystem preferences = (PreferencesSystem) dataService.getSingle("PreferencesSystem");
				/* TODO: These strings need to come in from PrintSmith, until then use english defaults */
				chargeDefinition.setPresetDescriptionLabel("Description");
				chargeDefinition.setPresetInSetsOfLabel("In sets of:");
				chargeDefinition.setPresetMaterialRateLabel("Material:");
				chargeDefinition.setPresetMaterialQuantityLabel("Material Quantity:");
				chargeDefinition.setPresetMaterialSetsOfLabel("In sets of:");
				chargeDefinition.setPresetNotesLabel("Notes:");
				chargeDefinition.setPresetPriceLabel("Price:");
				chargeDefinition.setPresetQuantityLabel("Quantity:");
				chargeDefinition.setPresetQuantityPerSetLabel("Qty/Set:");
				chargeDefinition.setPresetRateLabel("Rate:");
				chargeDefinition.setPresetSetupLabel("Setup:");
				chargeDefinition.setPresetUpLabel("Up:");
				chargeDefinition.setPresetTimeStartLabel("Time Start:");
				chargeDefinition.setPresetTimeStopLabel("Time Stop:");
				chargeDefinition.setPresetNumberOfColorsLabel("Colors");
				chargeDefinition.setPresetCoverageLabel("Pct. Coverage:");
				chargeDefinition.setPresetPricePerPoundLabel("Price/"+preferences.getInkWeightSingular()+":");
				chargeDefinition.setPresetPoundsOfInkLabel(preferences.getInkWeightPlural() + " of Ink");
				chargeDefinition.setPresetTotalWeightLabel("Total Weight");
				chargeDefinition.setPresetAreaLabel("Area:");
				chargeDefinition.setPresetCutsLabel("Cuts:");		
				chargeDefinition.setPresetSheetsPerLiftLabel("Sheets/Lift");			
				chargeDefinition.setPresetCoverPerPoundLabel("Coverage/lb");
				
				SalesCategory salesCategory = null;
				newCommand = false;
				newCategory = false;
				boolean addSalesCategory = false;
				description = "";
				linkId = "";
				categoryId = "";
				method = "";
				for (int i = 0; i < fieldTokens.length; i++) {
					String currentImportToken = importTokens[i];
					String currentFieldToken = fieldTokens[i];
					if ("recno".equals(currentFieldToken)) {
						/* TODO */
					} else if ("rtype".equals(currentFieldToken)) {
						/* TODO */
					} else if ("importedChargeID".equals(currentFieldToken)) {
						chargeDefinition.setId(Utilities
								.tokenToLong(currentImportToken));
					} else if ("description".equals(currentFieldToken)) {
						charge.setDescription(currentImportToken);
						chargeDefinition.setTitle(currentImportToken);
						chargeDefinition.setName(currentImportToken);
						description = currentImportToken;
					} else if ("notes".equals(currentFieldToken)) {
						chargeDefinition.setNote(currentImportToken);
						charge.setNotes(currentImportToken);
					} else if ("list ID".equals(currentFieldToken)) {
						if (commandlinkids.isEmpty() == true) {
							ChargeCommand chargeCommand = new ChargeCommand();
							chargeCommand.setName(description);
							commandlinkids.add(currentImportToken);
							commandnames.add(description);
							dataService.addUpdate(chargeCommand);
							newCommand = true;
						} else {
							int index = commandlinkids
									.indexOf(currentImportToken);
							if (index < 0) {
								ChargeCommand chargeCommand = new ChargeCommand();
								chargeCommand.setName(description);
								commandlinkids.add(currentImportToken);
								commandnames.add(description);
								dataService.addUpdate(chargeCommand);
								newCommand = true;
							}
						}
						linkId = currentImportToken;
					} else if ("charge ID".equals(currentFieldToken)) {
						ChargeCost chargeCost = new ChargeCost();
						chargeCost.setId(Utilities
								.tokenToLong(currentImportToken));
						chargeDefinition.setChargeCost(chargeCost);
						chargeDefinition.setPrevId(currentImportToken);
					} else if ("sales cat".equals(currentFieldToken)) {
						if (currentImportToken.equals("0") == false) {
							salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", currentImportToken);
							if (salesCategory != null)
								chargeDefinition.setSalesCategory(salesCategory);
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
							chargeDefinition.setSalesCategory(salesCategory);
						}
					} else if ("rate qty".equals(currentFieldToken)) {
						chargeDefinition.setRateQty(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("mat qty".equals(currentFieldToken)) {
						chargeDefinition.setMaterialQty(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("number of sets".equals(currentFieldToken)) {
						/* TODO */
					} else if ("material sets".equals(currentFieldToken)) {
						chargeDefinition.setMaterialSetCount(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("price".equals(currentFieldToken)) {
						chargeDefinition.setPrice(Utilities
								.tokenToDouble(currentImportToken));
						charge.setPrice(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("start".equals(currentFieldToken)) {
						/* TODO */
					} else if ("stop".equals(currentFieldToken)) {
						/* TODO */
					} else if ("shownotes".equals(currentFieldToken)) {
						chargeDefinition.setPresetShowNotes(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setShowNotes(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("finished".equals(currentFieldToken)) {
						chargeDefinition.setPresetFinished(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setFinished(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("brokered".equals(currentFieldToken)) {
						chargeDefinition.setPresetBrokered(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setBrokered(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("taxable".equals(currentFieldToken)) {
						chargeDefinition.setPresetTaxable(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setTaxable(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("displayqty".equals(currentFieldToken)) {
						chargeDefinition.setPresetDisplayQuantity(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setDisplayQty(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("oprice".equals(currentFieldToken)) {
						/* TODO */
					} else if ("orqty".equals(currentFieldToken)) {
						/* TODO */
					} else if ("omqty".equals(currentFieldToken)) {
						/* TODO */
					} else if ("method".equals(currentFieldToken)) {
						method = currentImportToken;
						if (method.equals("0")) {
							chargeDefinition.setMethod("None");
						} else if (method.equals("1")) {
							chargeDefinition.setMethod("JobAware");
						} else if (method.equals("2")) {
							chargeDefinition.setMethod("Markup");
						} else if (method.equals("3")) {
							chargeDefinition.setMethod("FlatRate");
						}else if (method.equals("4")) {
								chargeDefinition.setMethod("Ask");
						} else if (method.equals("5")) {
							chargeDefinition.setMethod("PriceList");
						} else if (method.equals("6")) {
							chargeDefinition.setMethod("RateList");
						} else if (method.equals("7")) {
							chargeDefinition.setMethod("Cut");
						} else if (method.equals("8")){
							chargeDefinition.setMethod("Ink");
						} else if (method.equals("9")) {
							chargeDefinition.setMethod("Shipping");
						} else if (method.equals("10")) {
							chargeDefinition.setMethod("Linear");
						} else if (method.equals("11")) {
							chargeDefinition.setMethod("Fold");
						} else if (method.equals("12")) {
							chargeDefinition.setMethod("SquareArea");
						}
								
					} else if ("qty type".equals(currentFieldToken)) {
						qtyType = currentImportToken;
						
					} else if ("markup type".equals(currentFieldToken)) {
						if (currentImportToken.equals("1")) {
							chargeDefinition.setMarkupType("JobPrice");
						} else if (currentImportToken.equals("2")) {
							chargeDefinition.setMarkupType("Charges");
						} else if (currentImportToken.equals("3")) {
							chargeDefinition.setMarkupType("EntireJob");
						} else if (currentImportToken.equals("4")) {
							chargeDefinition.setMarkupType("Invoice");
						}
						
						
					} else if ("job qty type".equals(currentFieldToken)) {
						if (currentImportToken.equals("0")) {
							chargeDefinition.setJobQty("None");
						} else if (currentImportToken.equals("1")) {
							chargeDefinition.setJobQty("Press");
						} else if (currentImportToken.equals("2")) {
							chargeDefinition.setJobQty("Ordered");
						}
					
					} else if ("hidden".equals(currentFieldToken)) {
						chargeDefinition.setHideChargeInPrintouts(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setHidden(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("no overrrides".equals(currentFieldToken)) {
						chargeDefinition.setNoOverrides(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("adjust sets".equals(currentFieldToken)) {
						chargeDefinition.setAdjustableSets(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("enter rate".equals(currentFieldToken)) {
						chargeDefinition.setAdjustableRate(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("enter material".equals(currentFieldToken)) {
						chargeDefinition.setAdjustableMaterial(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use material".equals(currentFieldToken)) {
						chargeDefinition.setUseMaterial(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use rate".equals(currentFieldToken)) {
						chargeDefinition.setUseRate(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use rate sets".equals(currentFieldToken)) {
						useRateSets = Utilities.tokenToBooleanValue(currentImportToken);
						if (method.equals("1")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("2")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("3")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("4")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("5")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("6")) {
							chargeDefinition.setUseRateSets(useRateSets);
							
						} else if (method.equals("7")) {
							chargeDefinition.setSheet_lift_check(useRateSets);
													
						} else if (method.equals("8")) {
							chargeDefinition.setCoverlb_check(true);
						} else if (method.equals("9")) {
							chargeDefinition.setShip_markup_check(useRateSets);
						} else if (method.equals("10")) {
							chargeDefinition.setUseRateSets(useRateSets);
						} else if (method.equals("11")) {
							chargeDefinition.setUseRateSets(useRateSets);
						} else if (method.equals("12")) {
							chargeDefinition.setUseArea(useRateSets);
						}
									
					} else if ("use material sets".equals(currentFieldToken)) {
						chargeDefinition.setUseMaterialSets(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use setup".equals(currentFieldToken)) {
						chargeDefinition.setUseSetup(Utilities
								.tokenToBooleanValue(currentImportToken));
						setuptemp = currentImportToken;
					} else if ("use minimum".equals(currentFieldToken)) {
						chargeDefinition.setUseMinimumCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("bindery operation".equals(currentFieldToken)) {
						chargeDefinition.setBinderyCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use colors".equals(currentFieldToken)) {
						chargeDefinition.setUseColors(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use orig".equals(currentFieldToken)) {
						chargeDefinition.setUseOriginals(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use sigs".equals(currentFieldToken)) {
						chargeDefinition.setUseSignatures(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("rate set count".equals(currentFieldToken)) {
						Double rateSetCount = 0.0;
						
						if (useRateSets) {
							Utilities.tokenToDouble(currentImportToken);
						}
						if (method.equals("1")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("2")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("3")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("4")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("5")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("6")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("7")) {
							chargeDefinition.setSheetliftCut(rateSetCount);
							chargeDefinition.setSheet_lift_check(true);
						} else if (method.equals("8")) {
							chargeDefinition.setCoverlbInk(rateSetCount);
							chargeDefinition.setCoverlb_check(true);
						} else if (method.equals("9")) {
							chargeDefinition.setShipMarkup(rateSetCount);
						} else if (method.equals("10")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("11")) {
							chargeDefinition.setRateSetCount(rateSetCount);
						} else if (method.equals("12")) {
							chargeDefinition.setArea(rateSetCount);
						}
						
					} else if ("rate".equals(currentFieldToken)) {
						if (method.equals("8")) {
							chargeDefinition.setPrice(Utilities.tokenToDouble(currentImportToken));
						} else {
							chargeDefinition.setRate(Utilities
									.tokenToDouble(currentImportToken));
						}
					} else if ("material rate".equals(currentFieldToken)) {
						if (setuptemp.equals("1"))
							chargeDefinition.setSetupPrice(Utilities.tokenToDouble(currentImportToken));
						else
							chargeDefinition.setMaterial(Utilities.tokenToDouble(currentImportToken));
					} else if ("minimum".equals(currentFieldToken)) {
						chargeDefinition.setMinimum(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("xNotUsed".equals(currentFieldToken)) {
						/* TODO */
					} else if ("sku".equals(currentFieldToken)) {
						chargeDefinition.setSku(currentImportToken);
						if (currentImportToken.equals("") == false){
							ProductCode  code = (ProductCode) dataService.getByName("ProductCode", currentImportToken);
							if (code != null) {
								code.setName(currentImportToken);
								
							} else{
								code = new  ProductCode();
								code.setName(currentImportToken);
								code = (ProductCode)dataService.addUpdate(code);
							}
							chargeDefinition.setProductCode(code);
						}
					} else if ("special".equals(currentFieldToken)) {
						/* TODO */
					} else if ("rstatus".equals(currentFieldToken)) {
						/* TODO */
					} else if ("xdesc".equals(currentFieldToken)) {
						/* TODO */
					} else if ("category id".equals(currentFieldToken)) {
						if (newCommand == false) {
							if (categoryids.isEmpty() == true) {
								ChargeCategory chargeCategory = new ChargeCategory();
								chargeCategory.setName(description);
								chargeCategory.setPrevId(currentImportToken);
								int index = commandlinkids.indexOf(linkId);
								if (index >= 0) {
									ChargeCommand chargeCommand = dataService
											.getByChargeCommandName(commandnames
													.get(index));
									dataService.addChargeCategoryToCommand(
											chargeCategory, chargeCommand);
								}
								categoryids.add(currentImportToken);
								categorynames.add(description);
								categoryindex++;
								newCategory = true;
							} else {
								int index = categoryids
										.indexOf(currentImportToken);
								if (index < 0) {
									ChargeCategory chargeCategory = new ChargeCategory();
									chargeCategory.setName(description);
									chargeCategory.setPrevId(currentImportToken);
									index = commandlinkids.indexOf(linkId);
									ChargeCommand chargeCommand = dataService
											.getByChargeCommandName(commandnames
													.get(index));
									dataService.addChargeCategoryToCommand(
											chargeCategory, chargeCommand);
									categoryids.add(currentImportToken);
									categorynames.add(description);
									categoryindex++;
									newCategory = true;
								}
							}
						}
						categoryId = currentImportToken;
					} else if ("labels".equals(currentFieldToken)) {
						chargeDefinition.setLabel(currentImportToken);
					} else if ("description custom".equals(currentFieldToken)) {
						/* TODO */
					} else if ("expandedShort".equals(currentFieldToken)) {
						/* TODO */
					} else if ("obs_tax rate ID".equals(currentFieldToken)) {
						/* TODO */
					} else if ("not used byte".equals(currentFieldToken)) {
						/* TODO */
					} else if ("tax table ID".equals(currentFieldToken)) {
						if (currentImportToken.equals("0") == false) {
							TaxTable taxTable = (TaxTable)dataService.getByPrevId("TaxTable", currentImportToken);
							if (taxTable != null)
								chargeDefinition.setTaxTable(taxTable);
						}
					} else if ("tax table".equals(currentFieldToken)) {
						/* TODO */
					} else if ("customer charge".equals(currentFieldToken)) {
						chargeDefinition.setCustomerCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("press charge".equals(currentFieldToken)) {
						chargeDefinition.setPressCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("deleted preset".equals(currentFieldToken)) {
						chargeDefinition.setDeletedPreset(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("ignore cuts".equals(currentFieldToken)) {
						chargeDefinition.setIgnoreCuts(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("stock charge".equals(currentFieldToken)) {
						chargeDefinition.setStockCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("o Cut qty".equals(currentFieldToken)) {
						/* TODO */
					} else if ("version".equals(currentFieldToken)) {
						chargeDefinition.setVersion(Utilities
								.tokenToInt(currentImportToken));
					} else if ("sequence".equals(currentFieldToken)) {
						/* TODO */
					} else if ("ship method".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false && currentImportToken.equals("0") == false) {
							ShippingMethod shippingMethod = dataService
									.getByShippingMethodName(currentImportToken);
							if (shippingMethod == null) {
								shippingMethod = new ShippingMethod();
								shippingMethod.setName(currentImportToken);
								shippingMethod = (ShippingMethod)dataService.addUpdate(shippingMethod);
							}
							chargeDefinition.setShipMode(shippingMethod);
						}
					} else if ("adjust up count".equals(currentFieldToken)) {
						chargeDefinition.setAdjustUpsCount(Utilities
								.tokenToInt(currentImportToken));
					} else if ("extra long".equals(currentFieldToken)) {
						/* TODO */
					} else if ("has link charge".equals(currentFieldToken)) {
						chargeDefinition.setHasLinkPrice(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("need link charge".equals(currentFieldToken)) {
						chargeDefinition.setNeedLinkPrice(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("has shipped".equals(currentFieldToken)) {
						chargeDefinition.setHasShipped(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("should ship".equals(currentFieldToken)) {
						chargeDefinition.setShouldShip(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("reserve bit 5".equals(currentFieldToken)) {
						/* TODO */
					} else if ("hide price".equals(currentFieldToken)) {
						chargeDefinition.setHidePrice(Utilities
								.tokenToBooleanValue(currentImportToken));
						charge.setHidePrice(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("ignore price adj".equals(currentFieldToken)) {
						chargeDefinition.setIgnoreGlobalPriceChanges(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("costing press charge".equals(currentFieldToken)) {
						chargeDefinition.setCostingPressCharge(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("linear x1".equals(currentFieldToken)) {
						chargeDefinition.setLinearX1(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("linear x2".equals(currentFieldToken)) {
						chargeDefinition.setLinearX2(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("linear y1".equals(currentFieldToken)) {
						chargeDefinition.setLinearY1(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("linear y2".equals(currentFieldToken)) {
						chargeDefinition.setLinearY2(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("override rate".equals(currentFieldToken)) {
						chargeDefinition.setOverrideRate(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("pricing type".equals(currentFieldToken)) {
						if (currentImportToken.equals("0") == true) {
							chargeDefinition.setPriceMethod("PiecePrice");
						}
						else
							chargeDefinition.setPriceMethod("CostPlus");
						
						
					} else if ("ink coverage type".equals(currentFieldToken)) {
						if (method.equals("12")){
							if (currentImportToken.equals("2"))
								chargeDefinition.setUseRunArea(false);
							else
								chargeDefinition.setUseRunArea(true);
									
						}
						else
							chargeDefinition.setInkCoverage(currentImportToken);
					} else if ("use sides".equals(currentFieldToken)) {
						chargeDefinition.setUseSides(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("noDiscount".equals(currentFieldToken)) {
						chargeDefinition.setDoNotDiscount(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("no m quant".equals(currentFieldToken)) {
						chargeDefinition.setNoMaterialQuantity(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("mat set count".equals(currentFieldToken)) {
						chargeDefinition.setMaterialSetCount(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("markup".equals(currentFieldToken)) {
						chargeDefinition.setMarkup(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("price list".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false) {
							PriceList priceList = (PriceList)dataService
									.getByPrevId("PriceList", currentImportToken);
							if (priceList != null) 
								chargeDefinition.setPriceList(priceList);
						}
					} else if ("waste chart".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false) {
							WasteChart wasteChart = (WasteChart)dataService.getByPrevId("WasteChart", currentImportToken);
							if (wasteChart != null)
								chargeDefinition.setWasteChart(wasteChart);
						}
					} else if ("fixed waste".equals(currentFieldToken)) {
						chargeDefinition.setFixedWaste(Utilities
								.tokenToLong(currentImportToken));
					} else if ("waste percent".equals(currentFieldToken)) {
						chargeDefinition.setWastePercentage(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("base linear number".equals(currentFieldToken)) {
						/* TODO */
					} else if ("production location ID"
							.equals(currentFieldToken)) {
						/* TODO */
					} else if ("production location".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false) {
							ProductionLocations location = dataService
									.getByLocationName(currentImportToken);
							if (location == null) {
								location = new ProductionLocations();
								location.setName(currentImportToken);
								location = (ProductionLocations)dataService.addProductionLocation(location);
							}
							chargeDefinition.setLocation(location);
							charge.setProductionLocation(location);
						}
					} else if ("cost center ID".equals(currentFieldToken)) {
						/* TODO */
					} else if ("cost center".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false) {
							CostCenter costCenter = dataService
									.getByCostCenterName(currentImportToken);
							if (costCenter == null) {
								costCenter = new CostCenter();
								costCenter.setName(currentImportToken);
								costCenter = (CostCenter)dataService.addUpdate(costCenter);
							}
							chargeDefinition.setCostCenter(costCenter);
						}
					} else if ("substrate ID".equals(currentFieldToken)) {
						/* TODO */
					} else if ("plate substrate".equals(currentFieldToken)) {
						if (currentImportToken.equals("") == false) {
							Substrate substrate = dataService
									.getBySubstrateName(currentImportToken);
							if (substrate == null) {
								substrate = new Substrate();
								substrate.setName(currentImportToken);
								substrate = (Substrate)dataService.addUpdate(substrate);
							}
							chargeDefinition.setSubstrate(substrate);
						}
					} else if ("min time".equals(currentFieldToken)) {
						chargeDefinition.setMinimumTime(Utilities
						.tokenToLong(currentImportToken));
					} else if ("plate size X".equals(currentFieldToken)) {
						chargeDefinition.setSizeX(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("plate size".equals(currentFieldToken)) {
						/* TODO */
					} else if ("plate size Y".equals(currentFieldToken)) {
						chargeDefinition.setSizeY(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("plate thickness".equals(currentFieldToken)) {
						chargeDefinition.setPlateThickness(Utilities
								.tokenToDouble(currentImportToken));
					} else if ("exclude from production"
							.equals(currentFieldToken)) {
						chargeDefinition.setExcludedFromWorkflow(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("pre production".equals(currentFieldToken)) {
						chargeDefinition.setPreproduction(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use min time".equals(currentFieldToken)) {
						chargeDefinition.setUseMinimumTime(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use divide up count".equals(currentFieldToken)) {
						chargeDefinition.setUseDivideByUpCount(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("use multiply up count"
							.equals(currentFieldToken)) {
						chargeDefinition.setUseMultiplyUpCount(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("adjust up".equals(currentFieldToken)) {
						chargeDefinition.setAdjustUps(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("cuts are prepress".equals(currentFieldToken)) {
						chargeDefinition.setCutsArePrePress(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("integrated CTP".equals(currentFieldToken)) {
						chargeDefinition.setIntegratedCTP(Utilities
								.tokenToBooleanValue(currentImportToken));
					} else if ("new from import".equals(currentFieldToken)) {
						/* TODO */
					} else if ("fold templete ID".equals(currentFieldToken)) {
						int templateId = Utilities.tokenToInt(currentImportToken);
						try {
							if (templateId >= 2) {
								FoldTemplate template = dataService.getFoldTemplateByIndex(templateId-2);
								if (template != null) {
									chargeDefinition.setFoldTemplate(template);
								}
							}
						} catch (Exception e) {
							log.error(e);
						}
					}
				}
				if ( chargeDefinition.getPriceMethod() != "Shipping" ){
					if (qtyType.equals("1")) {
						chargeDefinition.setQuantityType("Sets");
					} else if (qtyType.equals("2")) {
						chargeDefinition.setQuantityType("Quantity");
					} else if (qtyType.equals("3")) {
						chargeDefinition.setQuantityType("Time");
					} else if (qtyType.equals("4")) {
						chargeDefinition.setQuantityType("None");
					} else if (qtyType.equals("5")) {
						chargeDefinition.setQuantityType("SetupSets");
					} 
				} else {
					if (qtyType.equals("1")) {
						chargeDefinition.setQuantityType("TotalWeight");
					} else if (qtyType.equals("2")) {
						chargeDefinition.setQuantityType("ShippingQty");
					} else if (qtyType.equals("3")) {
						chargeDefinition.setQuantityType("Time");
					} else if (qtyType.equals("4")) {
						chargeDefinition.setQuantityType("None");
					} else if (qtyType.equals("5")) {
						chargeDefinition.setQuantityType("SetupSets");
					} 
				}
								
								
				if (newCommand == false && newCategory == false) {
					ChargeCategory chargeCategory = dataService
							.getByChargeCategoryPrevId(categoryId);
					dataService.addChargeToCategory(chargeDefinition,
							chargeCategory);
				}
			}
			lineNumber++;
		}
	}

	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		Charge charge = new Charge();
		DataService dataService = new DataService();
		ChargeCommand chargeCommand = dataService
				.getByChargeCommandName("Unknown");
		ChargeCategory chargeCategory = dataService
				.getByChargeCategoryName("Untitled Category");

		if (chargeCommand == null) {
			chargeCommand = new ChargeCommand();
			chargeCommand.setName("Unknown");
			chargeCommand = (ChargeCommand) dataService
					.addUpdate(chargeCommand);
			chargeCommand.setId(chargeCommand.getId());
		}

		if (chargeCategory == null) {
			chargeCategory = new ChargeCategory();
			chargeCategory.setName("Untitled Category");
			chargeCategory = (ChargeCategory) dataService
					.addChargeCategoryToCommand(chargeCategory, chargeCommand);
			chargeCategory.setId(chargeCategory.getId());
		}
		ChargeDefinition chargeDefinition = new ChargeDefinition();

		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];

			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("importedChargeID".equals(currentFieldToken)) {
				chargeDefinition.setId(Utilities
						.tokenToLong(currentImportToken));
			} else if ("description".equals(currentFieldToken)) {
				charge.setDescription(currentImportToken);
				chargeDefinition.setTitle(currentImportToken);
				chargeDefinition.setName(currentImportToken);
			} else if ("notes".equals(currentFieldToken)) {
				chargeDefinition.setNote(currentImportToken);
				charge.setNotes(currentImportToken);
			} else if ("list ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("charge ID".equals(currentFieldToken)) {
				ChargeCost chargeCost = new ChargeCost();
				chargeCost.setId(Utilities.tokenToLong(currentImportToken));
				chargeDefinition.setChargeCost(chargeCost);
				chargeDefinition.setPrevId(currentImportToken);
			} else if ("sales cat".equals(currentFieldToken)) {
			//	chargeDefinition.setSalesCategory(currentImportToken);
			} else if ("sales cat name".equals(currentFieldToken)) {
		//		chargeDefinition.setSalesCategory(currentImportToken);
			} else if ("rate qty".equals(currentFieldToken)) {
				chargeDefinition.setRateQty(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("mat qty".equals(currentFieldToken)) {
				chargeDefinition.setMaterialQty(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("number of sets".equals(currentFieldToken)) {
				/* TODO */
			} else if ("material sets".equals(currentFieldToken)) {
				chargeDefinition.setMaterialSetCount(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("price".equals(currentFieldToken)) {
				chargeDefinition.setPrice(Utilities
						.tokenToDouble(currentImportToken));
				charge.setPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("start".equals(currentFieldToken)) {
				/* TODO */
			} else if ("stop".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shownotes".equals(currentFieldToken)) {
				chargeDefinition.setPresetShowNotes(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setShowNotes(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("finished".equals(currentFieldToken)) {
				chargeDefinition.setPresetFinished(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setFinished(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("brokered".equals(currentFieldToken)) {
				chargeDefinition.setPresetBrokered(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setBrokered(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				chargeDefinition.setPresetTaxable(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setTaxable(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("displayqty".equals(currentFieldToken)) {
				chargeDefinition.setPresetDisplayQuantity(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setDisplayQty(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("oprice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("orqty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("omqty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("method".equals(currentFieldToken)) {
				chargeDefinition.setMethod(currentImportToken);
			} else if ("qty type".equals(currentFieldToken)) {
				chargeDefinition.setQuantityType(currentImportToken);
			} else if ("markup type".equals(currentFieldToken)) {
				chargeDefinition.setMarkupType(currentImportToken);
			} else if ("job qty type".equals(currentFieldToken)) {
				chargeDefinition.setJobQty(currentImportToken);
			} else if ("hidden".equals(currentFieldToken)) {
				chargeDefinition.setHidePrice(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setHidden(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("no overrrides".equals(currentFieldToken)) {
				chargeDefinition.setNoOverrides(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("adjust sets".equals(currentFieldToken)) {
				chargeDefinition.setAdjustableSets(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("enter rate".equals(currentFieldToken)) {
				chargeDefinition.setAdjustableRate(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("enter material".equals(currentFieldToken)) {
				chargeDefinition.setAdjustableMaterial(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use material".equals(currentFieldToken)) {
				chargeDefinition.setUseMaterial(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use rate".equals(currentFieldToken)) {
				chargeDefinition.setUseRate(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use rate sets".equals(currentFieldToken)) {
				chargeDefinition.setUseRateSets(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use material sets".equals(currentFieldToken)) {
				chargeDefinition.setUseMaterialSets(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use setup".equals(currentFieldToken)) {
				chargeDefinition.setUseSetup(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use minimum".equals(currentFieldToken)) {
				chargeDefinition.setUseMinimumCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("bindery operation".equals(currentFieldToken)) {
				chargeDefinition.setBinderyCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use colors".equals(currentFieldToken)) {
				chargeDefinition.setUseColors(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use orig".equals(currentFieldToken)) {
				chargeDefinition.setUseOriginals(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use sigs".equals(currentFieldToken)) {
				chargeDefinition.setUseSignatures(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("rate set count".equals(currentFieldToken)) {
				chargeDefinition.setRateSetCount(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("rate".equals(currentFieldToken)) {
				chargeDefinition.setRate(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("material rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("minimum".equals(currentFieldToken)) {
				chargeDefinition.setMinimum(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("xNotUsed".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sku".equals(currentFieldToken)) {
				
				chargeDefinition.setSku(currentImportToken);
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("xdesc".equals(currentFieldToken)) {
				/* TODO */
			} else if ("category id".equals(currentFieldToken)) {
				/* TODO */
			} else if ("labels".equals(currentFieldToken)) {
				chargeDefinition.setLabel(currentImportToken);
			} else if ("description custom".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expandedShort".equals(currentFieldToken)) {
				/* TODO */
			} else if ("obs_tax rate ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("not used byte".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					TaxTable taxTable = dataService
							.getByTaxTableName(currentImportToken);
					if (taxTable == null) {
						taxTable = new TaxTable();
						taxTable.setName(currentImportToken);
						taxTable = (TaxTable)dataService.addUpdate(taxTable);
					}
					chargeDefinition.setTaxTable(taxTable);
				}
			} else if ("customer charge".equals(currentFieldToken)) {
				chargeDefinition.setCustomerCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("press charge".equals(currentFieldToken)) {
				chargeDefinition.setPressCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("deleted preset".equals(currentFieldToken)) {
				chargeDefinition.setDeletedPreset(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("ignore cuts".equals(currentFieldToken)) {
				chargeDefinition.setIgnoreCuts(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("stock charge".equals(currentFieldToken)) {
				chargeDefinition.setStockCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("o Cut qty".equals(currentFieldToken)) {
				/* TODO */
			} else if ("version".equals(currentFieldToken)) {
				chargeDefinition.setVersion(Utilities
						.tokenToInt(currentImportToken));
			} else if ("sequence".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship method".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					ShippingMethod shippingMethod = dataService
							.getByShippingMethodName(currentImportToken);
					if (shippingMethod == null) {
						shippingMethod = new ShippingMethod();
						shippingMethod.setName(currentImportToken);
						shippingMethod = (ShippingMethod)dataService.addUpdate(shippingMethod);
					}
					chargeDefinition.setShipMode(shippingMethod);
				}
			} else if ("adjust up count".equals(currentFieldToken)) {
				chargeDefinition.setAdjustUpsCount(Utilities
						.tokenToInt(currentImportToken));
			} else if ("extra long".equals(currentFieldToken)) {
				/* TODO */
			} else if ("has link charge".equals(currentFieldToken)) {
				chargeDefinition.setHasLinkPrice(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("need link charge".equals(currentFieldToken)) {
				chargeDefinition.setNeedLinkPrice(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("has shipped".equals(currentFieldToken)) {
				chargeDefinition.setHasShipped(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("should ship".equals(currentFieldToken)) {
				chargeDefinition.setShouldShip(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("reserve bit 5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hide price".equals(currentFieldToken)) {
				chargeDefinition.setHidePrice(Utilities
						.tokenToBooleanValue(currentImportToken));
				charge.setHidePrice(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("ignore price adj".equals(currentFieldToken)) {
				chargeDefinition.setIgnoreGlobalPriceChanges(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("costing press charge".equals(currentFieldToken)) {
				chargeDefinition.setCostingPressCharge(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("linear x1".equals(currentFieldToken)) {
				chargeDefinition.setLinearX1(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("linear x2".equals(currentFieldToken)) {
				chargeDefinition.setLinearX2(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("linear y1".equals(currentFieldToken)) {
				chargeDefinition.setLinearY1(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("linear y2".equals(currentFieldToken)) {
				chargeDefinition.setLinearY2(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("override rate".equals(currentFieldToken)) {
				chargeDefinition.setOverrideRate(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("pricing type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ink coverage type".equals(currentFieldToken)) {
				chargeDefinition.setInkCoverage(currentImportToken);
			} else if ("use sides".equals(currentFieldToken)) {
				chargeDefinition.setUseSides(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("noDiscount".equals(currentFieldToken)) {
				chargeDefinition.setDoNotDiscount(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("no m quant".equals(currentFieldToken)) {
				chargeDefinition.setNoMaterialQuantity(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("mat set count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markup".equals(currentFieldToken)) {
				chargeDefinition.setMarkup(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("price list".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					PriceList priceList = dataService
							.getByPriceListName(currentImportToken);
					if (priceList == null) {
						priceList = new PriceList();
						priceList.setName(currentImportToken);
						priceList = (PriceList)dataService.addUpdate(priceList);
					}
					chargeDefinition.setPriceList(priceList);
				}
			} else if ("waste chart".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					WasteChart wasteChart = dataService
							.getByWasteChartName(currentImportToken);
					if (wasteChart == null) {
						wasteChart = new WasteChart();
						wasteChart.setName(currentImportToken);
						wasteChart = (WasteChart)dataService.addUpdate(wasteChart);
					}
					chargeDefinition.setWasteChart(wasteChart);
				}
			} else if ("fixed waste".equals(currentFieldToken)) {
				chargeDefinition.setFixedWaste(Utilities
						.tokenToLong(currentImportToken));
			} else if ("waste percent".equals(currentFieldToken)) {
				chargeDefinition.setWastePercentage(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("base linear number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production location ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("production location".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					ProductionLocations location = dataService
							.getByLocationName(currentImportToken);
					if (location == null) {
						location = new ProductionLocations();
						location.setName(currentImportToken);
						location = (ProductionLocations)dataService.addUpdate(location);
					}
					chargeDefinition.setLocation(location);
					charge.setProductionLocation(location);
				}
			} else if ("cost center ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost center".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					CostCenter costCenter = dataService
							.getByCostCenterName(currentImportToken);
					if (costCenter == null) {
						costCenter = new CostCenter();
						costCenter.setName(currentImportToken);
						costCenter = (CostCenter)dataService.addUpdate(costCenter);
					}
					chargeDefinition.setCostCenter(costCenter);
				}
			} else if ("substrate ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate substrate".equals(currentFieldToken)) {
				if (currentImportToken != "") {
					Substrate substrate = dataService
							.getBySubstrateName(currentImportToken);
					if (substrate == null) {
						substrate = new Substrate();
						substrate.setName(currentImportToken);
						substrate = (Substrate)dataService.addUpdate(substrate);
					}
					chargeDefinition.setSubstrate(substrate);
				}
			} else if ("min time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate size X".equals(currentFieldToken)) {
				chargeDefinition.setSizeX(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("plate size".equals(currentFieldToken)) {
				/* TODO */
			} else if ("plate size Y".equals(currentFieldToken)) {
				chargeDefinition.setSizeY(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("plate thickness".equals(currentFieldToken)) {
				chargeDefinition.setPlateThickness(Utilities
						.tokenToDouble(currentImportToken));
			} else if ("exclude from production".equals(currentFieldToken)) {
				chargeDefinition.setExcludedFromWorkflow(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("pre production".equals(currentFieldToken)) {
				chargeDefinition.setPreproduction(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use min time".equals(currentFieldToken)) {
				chargeDefinition.setUseMinimumTime(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use divide up count".equals(currentFieldToken)) {
				chargeDefinition.setUseDivideByUpCount(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("use multiply up count".equals(currentFieldToken)) {
				chargeDefinition.setUseMultiplyUpCount(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("adjust up".equals(currentFieldToken)) {
				chargeDefinition.setAdjustUps(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("cuts are prepress".equals(currentFieldToken)) {
				chargeDefinition.setCutsArePrePress(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("integrated CTP".equals(currentFieldToken)) {
				chargeDefinition.setIntegratedCTP(Utilities
						.tokenToBooleanValue(currentImportToken));
			} else if ("new from import".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		dataService.addChargeToCategory(chargeDefinition, chargeCategory);
		log.info("Leaving ChargeDefinitionMapper->importFile");
		return null;
	}
}
