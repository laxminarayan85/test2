package com.efi.printsmith.migration;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.PreferencesAccounting;
import com.efi.printsmith.data.PreferencesPOS;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.PreferencesQuantityBreaks;
import com.efi.printsmith.data.PreferencesStocks;
import com.efi.printsmith.data.SizeTable;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PreferencesCashRegister;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.TaxCodes;
import com.efi.printsmith.data.OutsideService;
import com.efi.printsmith.data.Merchandise;

import com.efi.printsmith.service.DataService;

public class PreferencesMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		try {
			deletePricingMethods();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(uploadedFile);
			doc.getDocumentElement().normalize();
			NodeList groupNodes = doc.getElementsByTagName("Group");
			for (int i=0;i<groupNodes.getLength();i++) {
				NodeList itemNodes = groupNodes.item(i).getChildNodes();
				NamedNodeMap groupAttributes = groupNodes.item(i).getAttributes();
				Node groupTitleNode = groupAttributes.getNamedItem("Title");
				for(int x=0;x<itemNodes.getLength();x++) {
					if (itemNodes.item(x).getNodeType() == Node.ELEMENT_NODE) {
						NamedNodeMap itemAttributes = itemNodes.item(x).getAttributes();
						Node titleNode = null;
						Node valueNode = null;
						Node keyNode = null;
						String keyValue = "";
						String valueValue = "";
						String titleValue = "";
						try {
							titleNode = itemAttributes.getNamedItem("Title");
							keyNode = itemAttributes.getNamedItem("Key");
							valueNode = itemAttributes.getNamedItem("Value");
						} catch (Exception e) {
							/* One of the above nodes does not exist. */
						}
						if (titleNode != null)
							titleValue = titleNode.getNodeValue();
						if (valueNode != null)
							valueValue = valueNode.getNodeValue();
						if (keyNode != null)
							keyValue = keyNode.getNodeValue();
						if (groupTitleNode.getNodeValue().equals("Sales Category List")) {
							importSalesCategoryListRecord(keyValue, valueValue);
						}
						this.importField(groupTitleNode.getNodeValue(), keyValue, titleValue, valueValue);
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	@SuppressWarnings({"unchecked"})
	private void deletePricingMethods() {
		DataService dataService = new DataService();
		List<PreferencesPricingMethod> pricingMethods = (List<PreferencesPricingMethod>)dataService.getAll("PreferencesPricingMethod");
		for (int i=0;i<pricingMethods.size();i++) {
			dataService.deleteItem("PreferencesPricingMethod", pricingMethods.get(i).getId());
		}
	}
	private void importField(String group, String key, String fieldName, String fieldValue) throws Exception {
		if (group.equals("Statements Notices"))
			importPreferencesAccountingField(key, fieldName, fieldValue);
		else if (group.equals("Receipts Notices"))
			importPreferencesPOSField(key, fieldName, fieldValue);
		else if (group.equals("Paper Calculator"))
			importPreferencesEstimatingField(key, fieldName, fieldValue);
		else if (group.equals("Company Info"))
			importPreferencesSystemField(key, fieldName, fieldValue);
		else if (group.equals("Quantity Breaks"))
			importPreferencesQuantityBreaksField(fieldValue);
		else if (group.equals("Blank Stock Setup"))
			importPreferencesStocksField(group, key, fieldName, fieldValue);
		else if (group.equals("Standard Markup")) {
			importPreferencesStocksField(group, key, fieldName, fieldValue);
			importPreferencesMarkupsField(group, key, fieldName, fieldValue);
		}
		else if (group.equals("Pricing Methods"))
			importPreferencesPricingMethodField(key, fieldName, fieldValue);
		else if (group.equals("Cash Register")) {
			importPreferencesCashRegisterField(key, fieldName, fieldValue);
			importPreferencesPOSField(key, fieldName, fieldValue);
		} else if (group.equals("Alternate Currency"))
			importPreferencesSystemField(key, fieldName, fieldValue);
		else if (group.equals("Dongle"))
			importPreferencesSystemField(key, fieldName, fieldValue);
		else if (group.equals("Local Workstation")) {
			importPreferencesSystemField(key, fieldName, fieldValue);
			importPreferencesEstimatingField(key, fieldName, fieldValue);
		}
		else if (group.equals("Def Customer")) {
			importPreferencesSystemField(key, fieldName, fieldValue);
			importPreferencesEstimatingField(key, fieldName, fieldValue);
			importPreferencesAccountingField(key, fieldName, fieldValue);
		}
	}
	private void importPreferencesMarkupsField(String group, String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		if (name.equals("OutsideMatrix_cost") || name.equals("OutsideMatrix_markup")) {
			OutsideService outsideService = (OutsideService)dataService.getByPrevId("OutsideService", key);
			if (outsideService == null) {
				outsideService = new OutsideService();
				outsideService.setPrevId(key);
			}
			if (name.equals("OutsideMatrix_cost")) {
				double cost = Utilities.tokenToDouble(value);
				if (cost == 999999.0)
					outsideService.setAbove(true);
				else {
					outsideService.setAbove(false);
					outsideService.setTotalCost(cost);
				}
			} else if (name.equals("OutsideMatrix_markup"))
				outsideService.setMarkup(Utilities.tokenToDouble(value));
			dataService.addUpdate(outsideService);
		}
		if (name.equals("MechMatrix_cost") || name.equals("MechMatrix_markup")) {
			Merchandise merchandise = (Merchandise)dataService.getByPrevId("Merchandise", key);
			if (merchandise == null) {
				merchandise = new Merchandise();
				merchandise.setPrevId(key);
			}
			if (name.equals("MechMatrix_cost")) {
				double cost = Utilities.tokenToDouble(value);
				if (cost == 999999.0)
					merchandise.setAbove(true);
				else {
					merchandise.setAbove(false);
					merchandise.setTotalCost(cost);
				}
			} else if (name.equals("MechMatrix_markup"))
				merchandise.setMarkup(Utilities.tokenToDouble(value));
			dataService.addUpdate(merchandise);
		}
	}
	private void importPreferencesCashRegisterField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesCashRegister preferencesCashRegister = (PreferencesCashRegister)dataService.getByPrevId("PreferencesCashRegister", key);
		if (preferencesCashRegister == null) {
			preferencesCashRegister = new PreferencesCashRegister();
			preferencesCashRegister.setPrevId(key);
		}
		if (name.equals("buttonName"))
			preferencesCashRegister.setTitle(value);
		else if (name.equals("ButtonRate"))
			preferencesCashRegister.setRate(Utilities.tokenToDouble(value));
		else if (name.equals("buttonSalesCat")) {
			SalesCategory salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", value);
			preferencesCashRegister.setCategory(salesCategory);
		} else if (name.equals("buttonTaxTableID")) {
			TaxTable taxTable = (TaxTable)dataService.getByPrevId("TaxTable", value);
			preferencesCashRegister.setTaxTable(taxTable);
		} else if (name.equals("buttonTaxCodeID")) {
			TaxCodes taxCodes = (TaxCodes)dataService.getByPrevId("TaxCodes",value);
			preferencesCashRegister.setTaxCodes(taxCodes);
		}
		dataService.addUpdate(preferencesCashRegister);
	}
	private void importPreferencesPricingMethodField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesPricingMethod preferencesPricingMethod = (PreferencesPricingMethod)dataService.getByPrevId("PreferencesPricingMethod", key);
		if (preferencesPricingMethod == null) {
			preferencesPricingMethod = new PreferencesPricingMethod();
			preferencesPricingMethod.setPrevId(key);
		}
		if (name.equals("salesCat_bucket_number")) {
			SalesCategory salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", value);
			preferencesPricingMethod.setCategory(salesCategory);
		} else if (name.equals("pricingMethodName"))
			preferencesPricingMethod.setTitle(value);
		else if (name.equals("pricingMethodAbbrev"))
			preferencesPricingMethod.setAbbreviation(value);
		else if (name.equals("pricingMethod"))
			preferencesPricingMethod.setMethod(value);
		else if (name.equals("showNotes"))
			preferencesPricingMethod.setShowNotes(Utilities.tokenToBooleanValue(value));
		else if (name.equals("finished"))
			preferencesPricingMethod.setFinished(Utilities.tokenToBooleanValue(value));
		else if (name.equals("taxable"))
			preferencesPricingMethod.setTaxable(Utilities.tokenToBooleanValue(value));
		else if (name.equals("brokered"))
			preferencesPricingMethod.setBrokered(Utilities.tokenToBooleanValue(value));
		else if (name.equals("enabled"))
			preferencesPricingMethod.setUsed(Utilities.tokenToBooleanValue(value));
		dataService.addUpdate(preferencesPricingMethod);
	}
	private void importPreferencesStocksField(String group, String key, String name, String value) throws NumberFormatException, ParseException {
		DataService dataService = new DataService();
		PreferencesStocks preferencesStocks = (PreferencesStocks)dataService.getSingle("PreferencesStocks");
		SizeTable sizeTable = null;
		if (preferencesStocks == null)
			preferencesStocks = new PreferencesStocks();
		if (name.equals("sizeTable")) {
			/*if (value.equals("defaultUS")) {
				sizeTable = (SizeTable)dataService.getByName("SizeTable", "Sizes - United States");
				if (sizeTable == null) {
					sizeTable = new SizeTable();
					sizeTable.setName("Sizes - United States");
					
				}
			}*/
		} else if (name.equals("calipersFormatString"))
			preferencesStocks.setWeight(value);
		else if (name.equals("pointsFormatString"))
			preferencesStocks.setPoints(value);
		else if (name.equals("pliesFormatString"))
			preferencesStocks.setPlies(value);
		else if (name.equals("micronsFormatString"))
			preferencesStocks.setMicrons(value);
		else if (name.equals("cost_customer_supplied"))
			preferencesStocks.setCustomerCost(Utilities.tokenToDouble(value));
		else if (name.equals("units_default"))
			preferencesStocks.setCustomerQuantity(Utilities.tokenToInt(value));
		else if (name.equals("markup_default"))
			preferencesStocks.setCustomerMarkup(Utilities.tokenToDouble(value));
		else if (name.equals("onlyMarkup_customer_supplied"))
			preferencesStocks.setMarkupOnly(Utilities.tokenToBooleanValue(value));
		else if (name.equals("stockUnits_qty_breaks")) {
			int keyValue = Utilities.tokenToInt(key);
			switch (keyValue) {
			case 1:
				preferencesStocks.setBlankQty1(Utilities.tokenToInt(value));
				break;
			case 2:
				preferencesStocks.setBlankQty2(Utilities.tokenToInt(value));
				break;
			case 3:
				preferencesStocks.setBlankQty3(Utilities.tokenToInt(value));
				break;
			case 4:
				preferencesStocks.setBlankQty4(Utilities.tokenToInt(value));
				break;
			case 5:
				preferencesStocks.setBlankQty5(Utilities.tokenToInt(value));
				break;
			case 6:
				preferencesStocks.setBlankQty6(Utilities.tokenToInt(value));
				break;
			}
		}
		else if (name.equals("stockMarkup") && group.equals("Blank Stock Setup")) {
			int keyValue = Utilities.tokenToInt(key);
			switch (keyValue) {
			case 1:
				preferencesStocks.setBlankMarkup1(Utilities.tokenToDouble(value));
				break;
			case 2:
				preferencesStocks.setBlankMarkup2(Utilities.tokenToDouble(value));
				break;
			case 3:
				preferencesStocks.setBlankMarkup3(Utilities.tokenToDouble(value));
				break;
			case 4:
				preferencesStocks.setBlankMarkup4(Utilities.tokenToDouble(value));
				break;
			case 5:
				preferencesStocks.setBlankMarkup5(Utilities.tokenToDouble(value));
				break;
			case 6:
				preferencesStocks.setBlankMarkup6(Utilities.tokenToDouble(value));
				break;
			}
		} else if (name.equals("stockMarkup") && group.equals("Standard Markup")) {
			int keyValue = Utilities.tokenToInt(key);
			switch (keyValue) {
			case 1:
				preferencesStocks.setStdMarkup1(Utilities.tokenToDouble(value));
				break;
			case 2:
				preferencesStocks.setStdMarkup2(Utilities.tokenToDouble(value));
				break;
			case 3:
				preferencesStocks.setStdMarkup3(Utilities.tokenToDouble(value));
				break;
			case 4:
				preferencesStocks.setStdMarkup4(Utilities.tokenToDouble(value));
				break;
			case 5:
				preferencesStocks.setStdMarkup5(Utilities.tokenToDouble(value));
				break;
			case 6:
				preferencesStocks.setStdMarkup6(Utilities.tokenToDouble(value));
				break;
			}
		} else if (name.equals("stockUnits")) {
			int keyValue = Utilities.tokenToInt(key);
			switch (keyValue) {
			case 1:
				preferencesStocks.setStdQty1(Utilities.tokenToInt(value));
				break;
			case 2:
				preferencesStocks.setStdQty2(Utilities.tokenToInt(value));
				break;
			case 3:
				preferencesStocks.setStdQty3(Utilities.tokenToInt(value));
				break;
			case 4:
				preferencesStocks.setStdQty4(Utilities.tokenToInt(value));
				break;
			case 5:
				preferencesStocks.setStdQty5(Utilities.tokenToInt(value));
				break;
			case 6:
				preferencesStocks.setStdQty6(Utilities.tokenToInt(value));
				break;
			}
		}
	}
	private void importPreferencesQuantityBreaksField(String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesQuantityBreaks quantityBreak = new PreferencesQuantityBreaks();
		quantityBreak.setQtyBreak(true);
		quantityBreak.setQuantity(Utilities.tokenToInt(value));
		dataService.addUpdate(quantityBreak);
	}
	private void importSalesCategoryListRecord(String key, String name) throws Exception {
		DataService dataService = new DataService();
		SalesCategory salesCategory = (SalesCategory)dataService.getByName("SalesCategory", name);
		if (salesCategory == null) {
			salesCategory = new SalesCategory();
			salesCategory.setPrevId(key);
			salesCategory.setName(name);
			dataService.addUpdate(salesCategory);
		}
	}
	private void importPreferencesAccountingField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesAccounting preferencesAccounting = (PreferencesAccounting)dataService.getSingle("PreferencesAccounting");
		if (preferencesAccounting == null)
			preferencesAccounting = new PreferencesAccounting();
		if (name.equals("pastDue")) {
			preferencesAccounting.setPastDueNote(value);
		} else if (name.equals("delinquent")) {
			preferencesAccounting.setDelinquentNote(value);
		} else if (name.equals("frozen")) {
			preferencesAccounting.setFrozenNote(value);
		} else if (name.equals("FinanceCharge"))
			preferencesAccounting.setFinanceChange(Utilities.tokenToDouble(value));
		else if (name.equals("CreditLimit"))
			preferencesAccounting.setCreditLimit(Utilities.tokenToDouble(value) * 100);
		else if (name.equals("daysinactive"))
			preferencesAccounting.setInactivePeriod(Utilities.tokenToDouble(value));
		else if (name.equals("pastDueDays"))
			preferencesAccounting.setPastDue(Utilities.tokenToInt(value));
		else if (name.equals("delinquentDays"))
			preferencesAccounting.setDelinquent(Utilities.tokenToInt(value));
		else if (name.equals("frozenDays"))
			preferencesAccounting.setFrozen(Utilities.tokenToInt(value));
		else if (name.equals("invordnoPrefix"))
			preferencesAccounting.setInvoicePrefix(value);
		else if (name.equals("invordnoSuffix"))
			preferencesAccounting.setInvoiceSuffix(value);
		else if (name.equals("invAllowPrefixMod"))
			preferencesAccounting.setInvoiceAllowPrefixMod(Utilities.tokenToBooleanValue(value));
		else if (name.equals("invAllowSuffixMod"))
			preferencesAccounting.setInvoiceAllowSuffixMod(Utilities.tokenToBooleanValue(value));
		else if (name.equals("estordnoPrefix"))
			preferencesAccounting.setEstimatePrefix(value);
		else if (name.equals("estordnoSuffix"))
			preferencesAccounting.setEstimateSuffix(value);
		else if (name.equals("estAllowPrefixMod"))
			preferencesAccounting.setEstimateAllowPrefixMod(Utilities.tokenToBooleanValue(value));
		else if (name.equals("estAllowSuffixMod"))
			preferencesAccounting.setEstimateAllowSuffixMod(Utilities.tokenToBooleanValue(value));
		dataService.addUpdate(preferencesAccounting);
	}
	private void importPreferencesPOSField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesPOS preferencesPOS = (PreferencesPOS)dataService.getSingle("PreferencesPOS");
		if (preferencesPOS == null)
			preferencesPOS = new PreferencesPOS();
		if (name.equals("Header Text")) {
			String currentHeader = "";
			if (preferencesPOS.getReceiptHeader() != null)
				currentHeader = preferencesPOS.getReceiptHeader();
			if (Utilities.tokenToInt(key) > 1)
				currentHeader = currentHeader + "\r";
			preferencesPOS.setReceiptHeader(currentHeader + value);
		} else if (name.equals("Footer Text")) {
			String currentFooter = "";
			if (preferencesPOS.getReceiptFooter() != null)
				currentFooter = preferencesPOS.getReceiptFooter();
			if (Utilities.tokenToInt(key) > 1)
				currentFooter = currentFooter + "\r";
			preferencesPOS.setReceiptFooter(currentFooter + value);
		} else if (name.equals("recieptBlankLine_after"))
			preferencesPOS.setBlankLinesAfterReceipt(Utilities.tokenToInt(value));
		else if (name.equals("recieptBlankLine_before"))
			preferencesPOS.setBlankLinesBeforeReceipt(Utilities.tokenToInt(value));
		else if (name.equals("caseReceiptTwoCopies"))
			preferencesPOS.setPrint2forCash(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useNamedSerial")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesPOS.setReceiptPrinterStatus("Named Serial Port");
			}
		} else if (name.equals("useNamedPrinter")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesPOS.setReceiptPrinterStatus("Named Graphic Printer");
			}
		} else if (name.equals("ccReceiptTwoCopies"))
			preferencesPOS.setPrint2forCreditCards(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useUSBPrinter")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesPOS.setReceiptPrinterStatus("USB Serial Printer");
			}
		} else if (name.equals("usePrinterPort")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesPOS.setReceiptPrinterStatus("Printer Port");
			}
		} else if (name.equals("remoteDrawer"))
			preferencesPOS.setUseMasterDrawer(Utilities.tokenToBooleanValue(value));
		else if (name.equals("printInv"))
			preferencesPOS.setPrintInvoices(Utilities.tokenToBooleanValue(value));
		else if (name.equals("receiptOn"))
			preferencesPOS.setPrintReceipts(Utilities.tokenToBooleanValue(value));
		else if (name.equals("drawerOn"))
			preferencesPOS.setEnableCashDrawer(Utilities.tokenToBooleanValue(value));
		else if (name.equals("printerName"))
			preferencesPOS.setDefaultPrinter(value);
		dataService.addUpdate(preferencesPOS);
	}
	private void importPreferencesEstimatingField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesEstimating preferencesEstimating = (PreferencesEstimating)dataService.getSingle("PreferencesEstimating");
		if (preferencesEstimating == null)
			preferencesEstimating = new PreferencesEstimating();
		if (name.equals("gripperEdge"))
			preferencesEstimating.setGripEdgeGap(Utilities.tokenToDouble(value));
		else if (name.equals("gripSide"))
			preferencesEstimating.setGripLocation(value);
		else if (name.equals("folioEdge"))
			preferencesEstimating.setFolioEdge(Utilities.tokenToDouble(value));
		else if (name.equals("folioSide"))
			preferencesEstimating.setFolioLocation(value);
		else if (name.equals("finishBleedAll"))
			preferencesEstimating.setBleed(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedRight"))
			preferencesEstimating.setBleedRight(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedTop"))
			preferencesEstimating.setBleedTop(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedBottom"))
			preferencesEstimating.setBleedBottom(Utilities.tokenToDouble(value));
		else if (name.equals("useGrip"))
			preferencesEstimating.setUseGripEdgeGap(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFolio"))
			preferencesEstimating.setUseFolioEdge(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFinishBleed"))
			preferencesEstimating.setUseBleed(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFinishGutter"))
			preferencesEstimating.setUseGutter(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useColorBar"))
			preferencesEstimating.setUseColorBar(Utilities.tokenToBooleanValue(value));
		else if (name.equals("backtrimParent"))
			preferencesEstimating.setBackTrimParent(Utilities.tokenToBooleanValue(value));
		else if (name.equals("attDiagramToJob"))
			preferencesEstimating.setAttachToJobTicket(Utilities.tokenToBooleanValue(value));
		else if (name.equals("colorBarWidth"))
			preferencesEstimating.setColorBar(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceLeft"))
			preferencesEstimating.setWhiteSpace(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceRight"))
			preferencesEstimating.setWhiteSpaceRight(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceTop"))
			preferencesEstimating.setWhiteSpaceTop(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceBottom"))
			preferencesEstimating.setWhiteSpaceBottom(Utilities.tokenToDouble(value));
		else if (name.equals("backtrimRun"))
			preferencesEstimating.setTrimFourSides(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useWhiteSpace"))
			preferencesEstimating.setUseWhiteSpace(Utilities.tokenToBooleanValue(value));
		else if (name.equals("grain"))
			if (Utilities.tokenToBooleanValue(value))
				preferencesEstimating.setRunToFinishGrain("Match Grain");
			else
				preferencesEstimating.setRunToFinishGrain("Neither");
		else if (name.equals("dutch")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesEstimating.setRunToFinishGrain("Swing / Combination");
			}
		} else if (name.equals("runNTumble"))
			preferencesEstimating.setWorkandTumble(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportParent_show_cut_diagram"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportRun_show_cut_diagram"))
			preferencesEstimating.setPrintParentToRunSection(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportFinish_show_cut_diagram"))
			preferencesEstimating.setPrintRunToFinishSection(Utilities.tokenToBooleanValue(value));
		else if (name.equals("pressCutoff_default"))
			preferencesEstimating.setDefaultPressCuttOff(Utilities.tokenToDouble(value));
		else if (name.equals("Estimator_enterStock_cost_in_job"))
			preferencesEstimating.setStockCostInEstimator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_invAddreessEditable"))
			preferencesEstimating.setCanChangeAddress(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_autocalcReorder"))
			preferencesEstimating.setCalculateReOrderDate(Utilities.tokenToBooleanValue(value));
		else if (name.equals("validateSalesRep"))
			preferencesEstimating.setValidateSalesRep(Utilities.tokenToBooleanValue(value));
		else if (name.equals("foldedSizeIsManual_leave_empty"))
			preferencesEstimating.setLeaveFoldedSizeEmpty(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_skipAutoShowJobCharges"))
			preferencesEstimating.setAutoShowCharges(Utilities.tokenToBooleanValue(value));
		else if (name.equals("ignorePresetPress_from_stock"))
			preferencesEstimating.setNeverUsePresetPressOnStockChanges(Utilities.tokenToBooleanValue(value));
		else if (name.equals("fixedWastePass_from_press"))
			preferencesEstimating.setAddFixedWasteForEachPass(Utilities.tokenToBooleanValue(value));
		else if (name.equals("fixedWasteColor_from_press"))
			preferencesEstimating.setAddFixedWasteForEachColor(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_ticketClose_after_print"))
			preferencesEstimating.setCloseInvoiceAfterPrintingTicket(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_dueDate_days_out"))
			preferencesEstimating.setDueFrom(Utilities.tokenToInt(value));
		else if (name.equals("finishGutterX"))
			preferencesEstimating.setGutterHorizontal(Utilities.tokenToDouble(value));
		else if (name.equals("finishGutterY"))
			preferencesEstimating.setGutter(Utilities.tokenToDouble(value));
		dataService.addUpdate(preferencesEstimating);
	}
	private void importPreferencesSystemField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesSystem preferencesSystem = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		Address address = null;
		if (preferencesSystem == null) {
			preferencesSystem = new PreferencesSystem();
			address = new Address();
			preferencesSystem.setCompanyAddress(address);
		}
		if (address == null)
			address = preferencesSystem.getCompanyAddress();
		if (name.equals("title"))
			address.setName(value);
		else if (name.equals("address1"))
			address.setStreet1(value);
		else if (name.equals("address2"))
			address.setStreet2(value);
		else if (name.equals("citystatzip")) {
			int i = value.indexOf(",");
			if (i > -1) {
				address.setCity(value.substring(0,i-1));
			}
			int x = value.indexOf(" ",i+2);
			if (x > -1) {
				address.setState(value.substring(i+2, x-1));
				address.setCity(value.substring(x+1));
			}
		} else if (name.equals("phone"))
			preferencesSystem.setCompanyPhone(value);
		else if (name.equals("fax"))
			preferencesSystem.setCompanyFax(value);
		else if (name.equals("email"))
			preferencesSystem.setCompanyEmail(value);
		else if (name.equals("storeNum"))
			preferencesSystem.setCompanyStoreNumber(value);
		else if (name.equals("useAltCurrency"))
			preferencesSystem.setUseAlternateCurrency(Utilities.tokenToBooleanValue(value));
		else if (name.equals("factor"))
			preferencesSystem.setConversionFactor(Utilities.tokenToDouble(value));
		else if (name.equals("roundDown"))
			preferencesSystem.setAlwaysRoundDown(Utilities.tokenToBooleanValue(value));
		else if (name.equals("roundToCnt"))
			preferencesSystem.setAlternateRoundto(Utilities.tokenToInt(value));
		else if (name.equals("Serial Number"))
			preferencesSystem.setSerialNumber(Utilities.tokenToLong(value));
		else if (name.equals("Web Enabled"))
			preferencesSystem.setWebEnabled(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Scheduler Enabled"))
			preferencesSystem.setSchedulerEnabled(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Program Type"))
			preferencesSystem.setProgramType(value);
		else if (name.equals("Maximum Node Count"))
			preferencesSystem.setMaximumNodeCount(Utilities.tokenToInt(value));
		else if (name.equals("Expiration Date"))
			preferencesSystem.setExpirationDate(Utilities.tokenToDate(value.substring(0, 7)));
		else if (name.equals("ReportWriter Enabled"))
			preferencesSystem.setReportWriterEnabled(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Extended Price Book Enabled"))
			preferencesSystem.setExtendedPriceBookEnabled(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Maximum Transaction Count"))
			preferencesSystem.setMaximumTransactionCount(Utilities.tokenToInt(value));
		else if (name.equals("PEK 1"))
			preferencesSystem.setConfig(value);
		else if (name.equals("PEK 2"))
			preferencesSystem.setProcess(value);
		else if (name.equals("PEK 3"))
			preferencesSystem.setSlogan(value);
		else if (name.equals("PEK 4"))
			preferencesSystem.setSettings(value);
		else if (name.equals("app_autoQuitText"))
			preferencesSystem.setShutdownMessage(value);
		else if (name.equals("companyIDLabel"))
			preferencesSystem.setCompanyIdLabel(value);
		else if (name.equals("companyID"))
			preferencesSystem.setCompanyId(value);
		else if (name.equals("workDay_Sunday"))
			preferencesSystem.setWorkSunday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Monday"))
			preferencesSystem.setWorkMonday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Tuesday"))
			preferencesSystem.setWorkTuesday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Wednesday"))
			preferencesSystem.setWorkWednesday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Thursday"))
			preferencesSystem.setWorkThursday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Friday"))
			preferencesSystem.setWorkFriday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("workDay_Saturday"))
			preferencesSystem.setWorkSaturday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useBusinessDaysForFutureDateParsing"))
			preferencesSystem.setFutureDatesExcludeClosed(Utilities.tokenToBooleanValue(value));
		else if (name.equals("inkWeightSingular"))
			preferencesSystem.setInkWeightSingular(value);
		else if (name.equals("inkWeightPlural"))
			preferencesSystem.setInkWeightPlural(value);
		dataService.addUpdate(preferencesSystem);
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		return null;
	}
}