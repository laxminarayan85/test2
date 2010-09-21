package com.efi.printsmith.migration;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Merchandise;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.OutsideService;
import com.efi.printsmith.data.PreferencesAccounting;
import com.efi.printsmith.data.PreferencesCashRegister;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.data.PreferencesPOS;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PreferencesQuantityBreaks;
import com.efi.printsmith.data.PreferencesStocks;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.PreferencesCreditCard;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.SizeTable;
import com.efi.printsmith.data.TaxCodes;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.Country;
import com.efi.printsmith.data.AddressFormatting;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
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
		else if (group.equals("Blank Stock Setup") || group.equals("Stock Setup") || group.equals("Customer Stock Setup")) {
			importPreferencesSystemField(key, fieldName, fieldValue);
			importPreferencesStocksField(group, key, fieldName, fieldValue);
		}
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
			importPreferencesPOSField(key, fieldName, fieldValue);
			importPreferencesAccountingField(key, fieldName, fieldValue);
		}
		else if (group.equals("Def Customer")) {
			importPreferencesSystemField(key, fieldName, fieldValue);
			importPreferencesEstimatingField(key, fieldName, fieldValue);
			importPreferencesAccountingField(key, fieldName, fieldValue);
		}
		else if (group.equals("Address Formats")) {
			importAddressFormats(key, fieldName, fieldValue);
		}
		else if (group.equals("CreditCard Info"))
			importPreferencesCreditCardField(key, fieldName, fieldValue);
		else if (group.equals("Money Formats"))
			importPreferencesSystemField(key, fieldName, fieldValue);
	}
	private void importAddressFormats(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		Country country = (Country)dataService.getByPrevId("Country", key);
		PreferencesSystem preferencesSystem = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		AddressFormatting addressFormatting = null;
		if (country == null && name.equals("Country Title")) {
			country = new Country();
			country.setName(value);
			country.setPrevId(key);
			addressFormatting = new AddressFormatting();
			addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
			country.addAddressFormattings(addressFormatting);
		}
		if (country.getAddressFormattings().size() == 0) {
			addressFormatting = new AddressFormatting();
			addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
			country.addAddressFormattings(addressFormatting);
		}
		if (name.equals("Country Format")) {
			int i = value.indexOf("]");
			int count = 0;
			int nextStart = 0;
			while (i > -1) {
				count++;
				String fieldName = value.substring(nextStart, i+1);
				nextStart = i+1;
				addressFormatting = country.getAddressFormattings().get(country.getAddressFormattings().size() - 1);
				if (fieldName.equals("[NewLine]")) {
					addressFormatting = new AddressFormatting();
					addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
					country.addAddressFormattings(addressFormatting);
					count = 0;
				}
				else if (fieldName.equals("[Address1]")) {
					addressFormatting.setStreet1Position(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setStreet1Separator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				else if (fieldName.equals("[Address2]")) {
					addressFormatting.setStreet2Position(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setStreet2Separator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				else if (fieldName.equals("[Zip]")) {
					addressFormatting.setZipPosition(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setZipSeparator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				else if (fieldName.equals("[State]")) {
					addressFormatting.setStatePosition(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setStateSeparator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				else if (fieldName.equals("[City]")) {
					addressFormatting.setCityPosition(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setCitySeparator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				else if (fieldName.equals("[Country]")) {
					addressFormatting.setCountryPosition(count);
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						addressFormatting.setCountrySeparator(value.substring(nextStart,nextStart));
						nextStart++;
					}
				}
				i = value.indexOf("]", nextStart);
			}
		} else if (name.equals("Format is Default"))
			preferencesSystem.setDefaultCountry(Utilities.tokenToInt(key));
		dataService.addUpdate(country);
	}
	private void importPreferencesCreditCardField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesCreditCard preferencesCreditCard = (PreferencesCreditCard)dataService.getByPrevId("PreferencesCreditCard", key);
		if (preferencesCreditCard == null) {
			preferencesCreditCard = new PreferencesCreditCard();
			preferencesCreditCard.setPrevId(key);
		}
		
		if (name.equals("name"))
			preferencesCreditCard.setCardType(value);
		else if (name.equals("abbrev"))
			preferencesCreditCard.setAbbreviation(value);
		else if (name.equals("key"))
			preferencesCreditCard.setCode(value);
		else if (name.equals("firstNumberPrefix"))
			preferencesCreditCard.setFirstNumberPrefix(Utilities.tokenToLong(value));
		else if (name.equals("active_accepted"))
			preferencesCreditCard.setActiveAccepted(Utilities.tokenToBooleanValue(value));
		dataService.addUpdate(preferencesCreditCard);
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
	private void importPreferencesStocksField(String group, String key, String name, String value) throws Exception {
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
		else if (name.equals("ChainOfCustOpenStr"))
			preferencesStocks.setOpen(value);
		else if (name.equals("ChainOfCustCloseStr"))
			preferencesStocks.setClose(value);
		else if (name.equals("ChainOfCustIncludeCert"))
			preferencesStocks.setIncludeCerifiedOption(Utilities.tokenToBooleanValue(value));
		else if (name.equals("ChainOfCustIncludeMgt"))
			preferencesStocks.setIncludeManagementType(Utilities.tokenToBooleanValue(value));
		else if (name.equals("ChainOfCustIncludeRcy"))
			preferencesStocks.setIncludeRecyclePercent(Utilities.tokenToBooleanValue(value));
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
		dataService.addUpdate(preferencesStocks);
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
		else if (name.equals("Memos_printJournalMemo"))
			preferencesAccounting.setPrintDocument(Utilities.tokenToBooleanValue(value));
		dataService.addUpdate(preferencesAccounting);
	}
	private void importPreferencesPOSField(String key, String name, String value) throws Exception {
		String hexDecimalValue= "";
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
			if(currentHeader.indexOf(value)==-1) {
				preferencesPOS.setReceiptHeader(currentHeader + value);
			}
		} else if (name.equals("Footer Text")) {
			String currentFooter = "";
			if (preferencesPOS.getReceiptFooter() != null)
				currentFooter = preferencesPOS.getReceiptFooter();
			if (Utilities.tokenToInt(key) > 1)
				currentFooter = currentFooter + "\r";
			if(currentFooter.indexOf(value)==-1) {
				preferencesPOS.setReceiptFooter(currentFooter + value);
			}
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
		else if (name.equals("PendingList_show_doc_type_in_number")) 
			preferencesPOS.setShowDocumentType(Utilities.tokenToBooleanValue(value));
		else if (name.equals("PendingList_always_show_past_due")) 
			preferencesPOS.setIncludePastDueDocuments(Utilities.tokenToBooleanValue(value));
		else if (name.equals("PendingList_showPastDue_colored")) 
			preferencesPOS.setColorPastDueEntries(Utilities.tokenToBooleanValue(value));
		else if (name.equals("readyForPickupColor_RGB_red")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPickupColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPickupColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("readyForPickupColor_RGB_green")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPickupColor(preferencesPOS.getPickupColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPickupColor(preferencesPOS.getPickupColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("readyForPickupColor_RGB_blue")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPickupColor(preferencesPOS.getPickupColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPickupColor(preferencesPOS.getPickupColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		}
		else if (name.equals("Receipts starting serial number")) {
			preferencesPOS.setStartingNumber(Utilities.tokenToInt(value));
			if (value != "")
				preferencesPOS.setReceiptStartNumber(true);
		}
		else if (name.equals("pastDueColor_RGB_red")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPastDueColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPastDueColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("pastDueColor_RGB_green")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPastDueColor(preferencesPOS.getPastDueColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPastDueColor(preferencesPOS.getPastDueColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("pastDueColor_RGB_blue")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setPastDueColor(preferencesPOS.getPastDueColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setPastDueColor(preferencesPOS.getPastDueColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		}
		else if (name.equals("invoiceItemColor_RGB_red")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setInvoiceColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setInvoiceColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("invoiceItemColor_RGB_green")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setInvoiceColor(preferencesPOS.getInvoiceColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setInvoiceColor(preferencesPOS.getInvoiceColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("invoiceItemColor_RGB_blue")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setInvoiceColor(preferencesPOS.getInvoiceColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setInvoiceColor(preferencesPOS.getInvoiceColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		}
		else if (name.equals("estimateItemColor_RGB_red")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setEstimateColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setEstimateColor("0x"+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("estimateItemColor_RGB_green")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setEstimateColor(preferencesPOS.getEstimateColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setEstimateColor(preferencesPOS.getEstimateColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
		} else if (name.equals("estimateItemColor_RGB_blue")) {
			if(Utilities.tokenToInt(value)<=255) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value));
				preferencesPOS.setEstimateColor(preferencesPOS.getEstimateColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			} else if(Utilities.tokenToInt(value)<=65535) {
				hexDecimalValue = Integer.toHexString(Utilities.tokenToInt(value)/256);
				preferencesPOS.setEstimateColor(preferencesPOS.getEstimateColor()+(hexDecimalValue.length()==1?"0"+hexDecimalValue:hexDecimalValue));
			}
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
		else if (name.equals("Estimator_leave_OpenAfterPrint")) {
			boolean fieldValue = false;
			if (Utilities.tokenToBooleanValue(value) == false)
				fieldValue = true;
			preferencesEstimating.setCloseInvoicesAndEstimateAfterPrinting(fieldValue);
		} else if (name.equals("InkByImpressions_not_press"))
			preferencesEstimating.setCalculateInkbyImpressions(Utilities.tokenToBooleanValue(value));
		else if (name.equals("ignoreHistoryTitleOnNewDocuments")) {
			if (Utilities.tokenToBooleanValue(value))
				preferencesEstimating.setUseHistoryTitleforNewTitle(false);
			else
				preferencesEstimating.setUseHistoryTitleforNewTitle(true);
		} else if (name.equals("Estimator_close_source_doc_on_copy"))
			preferencesEstimating.setCloseAfterCopy(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_skipAutoShowJobCharges")) {
			if (Utilities.tokenToBooleanValue(value) == false)
				preferencesEstimating.setAutoShowCharges(true);
			else
				preferencesEstimating.setAutoShowCharges(false);
		} else if (name.equals("Estimator_lockParentSize_field"))
			preferencesEstimating.setUseStockParentSize(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_dueDate_days_out"))
			preferencesEstimating.setDueFrom(Utilities.tokenToInt(value));
		else if (name.equals("Estimator_invAddressEditable"))
			preferencesEstimating.setCanChangeAddress(Utilities.tokenToBooleanValue(value));
		else if (name.equals("skipAutoCost_at_posting"))
			preferencesEstimating.setDoNotCostDuringPost(Utilities.tokenToBooleanValue(value));
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
		if (name.equals("title") && value.equals("") == false)
			address.setName(value);
		else if (name.equals("address1"))
			address.setStreet1(value);
		else if (name.equals("address2"))
			address.setStreet2(value);
		else if (name.equals("citystatezip")) {
			int i = value.indexOf(",");
			if (i > -1) {
				address.setCity(value.substring(0,i));
			}
			int x = value.indexOf(" ",i+2);
			if (x > -1) {
				address.setState(value.substring(i+2, x));
				address.setZip(value.substring(x+1));
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
		else if (name.equals("App_autoQuitText")) {
			if (value.equals(""))
				value = "Warning: PrintSmith is automatically shutting down at ^0.  This is your only warning.  Please finish up and quit now.";
			preferencesSystem.setShutdownMessage(value);
		}
		else if (name.equals("companyIDLabel"))
			if (value == "")
				preferencesSystem.setCompanyIdLabel("Company ID");
			else
				preferencesSystem.setCompanyIdLabel(value);
		else if (name.equals("companyID"))
			preferencesSystem.setCompanyId(value);
		else if (name.equals("other1"))
			preferencesSystem.setCompanyOther1(value);
		else if (name.equals("other2"))
			preferencesSystem.setCompanyOther2(value);
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
		else if (name.equals("firstDayOfWeek_SundayIsZero"))
			preferencesSystem.setWorkFirstDayOfWeek(Utilities.tokenToInt(value) + 1);
		else if (name.equals("useBusinessDaysForFutureDateParsing"))
			preferencesSystem.setFutureDatesExcludeClosed(Utilities.tokenToBooleanValue(value));
		else if (name.equals("inkWeightSingular"))
			preferencesSystem.setInkWeightSingular(value);
		else if (name.equals("inkWeightPlural"))
			preferencesSystem.setInkWeightPlural(value);
		else if (name.equals("DaysOfTheWeek_Sunday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(1);
			}
		} else if (name.equals("DaysOfTheWeek_Monday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(2);
			}
		} else if (name.equals("DaysOfTheWeek_Tuesday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(3);
			}
		} else if (name.equals("DaysOfTheWeek_Wednesday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(4);
			}
		} else if (name.equals("DaysOfTheWeek_Thursday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(5);
			}
		} else if (name.equals("DaysOfTheWeek_Friday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(6);
			}
		} else if (name.equals("DaysOfTheWeek_Saturday")) {
			if(Utilities.tokenToBooleanValue(value)) {
				preferencesSystem.setWorkFirstDayOfWeek(7);
			}
		} else if (name.equals("minimumWarnings"))
			preferencesSystem.setEliminateWarningMessages(Utilities.tokenToBooleanValue(value));
		else if (name.equals("activateUserEventLogging_PCI_rules"))
			preferencesSystem.setActivateUserEventLogging(Utilities.tokenToBooleanValue(value));
		else if (name.equals("autosignon_active"))
			preferencesSystem.setEnableAutoLogOut(Utilities.tokenToBooleanValue(value));
		else if (name.equals("autosign_seconds"))
			preferencesSystem.setAutoLogOutSeconds(Utilities.tokenToInt(value));
		else if (name.equals("PendingList_restrict_pickup_to_ready_items"))
			preferencesSystem.setOnlyPostMarkedReadyInvoices(Utilities.tokenToBooleanValue(value));
		else if (name.equals("App_autoAppQuit"))
			preferencesSystem.setAutomaticQuit(Utilities.tokenToBooleanValue(value));
		else if (name.equals("App_autoQuitTime"))
			preferencesSystem.setQuitTime(value);
		else if (name.equals("App_showFirmInvoicesAtLogin"))
			preferencesSystem.setShowInvoicesWithToday(Utilities.tokenToBooleanValue(value));
		else if (name.equals("App_enableLineItemTaxes"))
			preferencesSystem.setLineItemTaxes(Utilities.tokenToBooleanValue(value));
		else if (name.equals("format"))
			preferencesSystem.setDisplayFormat(value);
		else if (name.equals("numberFormatINT"))
			preferencesSystem.setNumbersIntegers(value);
		else if (name.equals("numberFormatPCT"))
			preferencesSystem.setNumbersPercentages(value);
		else if (name.equals("numberFormatCURRENCY"))
			preferencesSystem.setNumbersAmount(value);
		else if (name.equals("numberFormatTAX"))
			preferencesSystem.setNumbersTaxRate(value);
		else if (name.equals("numberFormatRATE"))
			preferencesSystem.setNumbersRate(value);
		else if (name.equals("numberFormatFACTOR"))
			preferencesSystem.setNumbersFactor(value);
		else if (name.equals("numberFormatINVAMT"))
			preferencesSystem.setNumbersInvoice(value);
		else if (name.equals("numberFormatINVPCT"))
			preferencesSystem.setNumbersShortPercent(value);
		else if (name.equals("App_storeLocationID"))
			preferencesSystem.setCompanyStoreLocationRef(value);
		if (address != null)
			preferencesSystem.setCompanyAddress(address);
		dataService.addUpdate(preferencesSystem);
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		return null;
	}
}