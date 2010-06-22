package com.efi.printsmith.migration;

import java.io.File;
import java.text.ParseException;

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

import com.efi.printsmith.service.DataService;

public class PreferencesMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	public void importFile(File uploadedFile) throws Exception {
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
					Node titleNode = itemAttributes.getNamedItem("Title");
					Node valueNode = itemAttributes.getNamedItem("Value");
					Node keyNode = itemAttributes.getNamedItem("Key");
					if (groupTitleNode.getNodeValue().equals("Sales Category List")) {
						importSalesCategoryListRecord(keyNode.getNodeValue(), valueNode.getNodeValue());
					}
					this.importField(groupTitleNode.getNodeValue(), keyNode.getNodeValue(), titleNode.getNodeValue(), valueNode.getNodeValue());
				}
			}
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
		else if (group.equals("Standard Markup"))
			importPreferencesStocksField(group, key, fieldName, fieldValue);
	}
	private void importDongleField(String fieldName, String fieldValue) {
		
	}
	private void importPreferencesPricingMethodField(String key, String name, String value) {
		DataService dataService = new DataService();
		PreferencesPricingMethod preferencesPricingMethod = (PreferencesPricingMethod)dataService.getByPrevId("PreferencesPricingMethod", key);
		if (preferencesPricingMethod == null) {
			preferencesPricingMethod = new PreferencesPricingMethod();
			preferencesPricingMethod.setPrevId(key);
		}
		if (name.equals("salesCat_bucket_number")) {
			SalesCategory salesCategory = (SalesCategory)dataService.getByPrevId("SalesCategory", value);
			preferencesPricingMethod.setCategory(salesCategory);
		}
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
		SalesCategory salesCategory = new SalesCategory();
		salesCategory.setPrevId(key);
		salesCategory.setName(name);
		dataService.addUpdate(salesCategory);
	}
	private void importPreferencesAccountingField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesAccounting preferencesAccounting = (PreferencesAccounting)dataService.getSingle("PreferencesAccounting");
		if (preferencesAccounting == null)
			preferencesAccounting = new PreferencesAccounting();
		if (name.equals("pastDue")) {
			preferencesAccounting.setPastDue(Utilities.tokenToInt(key));
			preferencesAccounting.setPastDueNote(value);
		} else if (name.equals("delinquint")) {
			preferencesAccounting.setDelinquent(Utilities.tokenToInt(key));
			preferencesAccounting.setDelinquentNote(value);
		} else if (name.equals("frozen")) {
			preferencesAccounting.setFrozen(Utilities.tokenToInt(key));
			preferencesAccounting.setFrozenNote(value);
		}
		dataService.addUpdate(preferencesAccounting);
	}
	private void importPreferencesPOSField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesPOS preferencesPOS = (PreferencesPOS)dataService.getSingle("PreferencesPOS");
		if (preferencesPOS == null)
			preferencesPOS = new PreferencesPOS();
		if (name.equals("Header Text")) {
			String currentHeader = preferencesPOS.getReceiptHeader();
			if (Utilities.tokenToInt(key) > 1)
				currentHeader = currentHeader + "\r";
			preferencesPOS.setReceiptHeader(currentHeader + value);
		} else if (name.equals("Footer Text")) {
			String currentFooter = preferencesPOS.getReceiptFooter();
			if (Utilities.tokenToInt(key) > 1)
				currentFooter = currentFooter + "\r";
			preferencesPOS.setReceiptFooter(currentFooter + value);
		}
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
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportFinish_show_cut_diagram"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("pressCutoff_default"))
			preferencesEstimating.setDefaultPressCuttOff(Utilities.tokenToDouble(value));
		dataService.addUpdate(preferencesEstimating);
	}
	private void importPreferencesSystemField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesSystem preferencesSystem = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		if (preferencesSystem == null)
			preferencesSystem = new PreferencesSystem();
		Address address = new Address();
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
		dataService.addUpdate(preferencesSystem);
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		return null;
	}
}