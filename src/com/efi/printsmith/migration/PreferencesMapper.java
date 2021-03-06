package com.efi.printsmith.migration;

import java.io.File;
import java.util.List;
import java.lang.String;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.efi.printsmith.Constants;
import com.efi.printsmith.data.AccessGroup;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.Merchandise;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.OutsideService;
import com.efi.printsmith.data.PreferencesAccounting;
import com.efi.printsmith.data.PreferencesCashRegister;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.data.PreferencesPOS;
import com.efi.printsmith.data.PreferencesPendingList;
import com.efi.printsmith.data.PreferencesPricingMethod;
import com.efi.printsmith.data.PreferencesQuantityBreaks;
import com.efi.printsmith.data.PreferencesStocks;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.PreferencesCreditCard;
import com.efi.printsmith.data.PreferencesStockDefinition;
import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.SizeTable;
import com.efi.printsmith.data.StampSchedule;
import com.efi.printsmith.data.TaxCodes;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.Country;
import com.efi.printsmith.data.AddressFormatting;
import com.efi.printsmith.data.EstimatorTypes;
import com.efi.printsmith.data.Users;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.service.MatrixService;

public class PreferencesMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	@SuppressWarnings("unchecked")
	public void importFile(File uploadedFile) throws Exception {
		String currentGroup = "";
		try {
			DataService dataService = new DataService();
			deletePricingMethods();
			deleteCreditCards();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(uploadedFile);
			doc.getDocumentElement().normalize();
			NodeList groupNodes = doc.getElementsByTagName("Group");
			for (int i=0;i<groupNodes.getLength();i++) {
				NodeList itemNodes = groupNodes.item(i).getChildNodes();
				NamedNodeMap groupAttributes = groupNodes.item(i).getAttributes();
				Node groupTitleNode = groupAttributes.getNamedItem("Title");
				currentGroup = groupTitleNode.getNodeValue();
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
						} else if (groupTitleNode.getNodeValue().equals("Sales General Ledger Categories")) {
							importSalesCategoryAccountRecord(keyValue, valueValue);
						} else if (groupTitleNode.getNodeValue().equals("User Name List")) { 
							NodeList subGroupNodes = itemNodes.item(x).getChildNodes();
							Users user = null;
							for (int z=0;z<subGroupNodes.getLength();z++) {
								if (subGroupNodes.item(z) != null && subGroupNodes.item(z).getNodeType() == Node.ELEMENT_NODE) {
									//if (titleNode.getNodeValue().equals("User Details")) {
										user = (Users)dataService.getByPrevId("Users", keyValue);
										if (user == null) {
											user = new Users();
											user.setPrevId(keyValue);
											user.setDisableUser(false);
											user.setShowUserNameLog(true);
										}
										NamedNodeMap fieldAttributes = subGroupNodes.item(z).getAttributes();
										titleNode = fieldAttributes.getNamedItem("Title");
										valueNode = fieldAttributes.getNamedItem("Value");
										if (titleNode.getNodeValue().equals("title"))
											user.setName(valueNode.getNodeValue());
										else if (titleNode.getNodeValue().equals("access_group_id"))
											user.setPrevPassword4(valueNode.getNodeValue()); //Temp to use to map access groups after importing access groups
										else if (titleNode.getNodeValue().equals("access_level"))
											user.setAccessLevel(Utilities.tokenToInt(valueNode.getNodeValue()));
										else if (titleNode.getNodeValue().equals("can_return_cash"))
											user.setNoCashReturn(Utilities.tokenToBooleanValue(valueNode.getNodeValue()));
										else if (titleNode.getNodeValue().equals("can_override_credit_limits"))
											user.setOverrideCredit(Utilities.tokenToBooleanValue(valueNode.getNodeValue()));
										else if (titleNode.getNodeValue().equals("show_quickaccess_panel_at_signon"))
											user.setQuickAccess(Utilities.tokenToBooleanValue(valueNode.getNodeValue()));
										else if (titleNode.getNodeValue().equals("can_refund_credit_cards"))
											user.setRefundCreditCards(Utilities.tokenToBooleanValue(valueNode.getNodeValue()));
										else if (titleNode.getNodeValue().equals("use_strong_password_rules"))
											user.setRobustPassword(Utilities.tokenToBooleanValue(valueNode.getNodeValue()));
									//}
								}
								if (user != null) {
									dataService.addUpdate(user);
									user = null;
								}
							}
						} else if (groupTitleNode.getNodeValue().equals("Access Group List")) {
							NodeList subGroupNodes = itemNodes.item(x).getChildNodes();
							List <Users> users = (List<Users>)dataService.getUsers("Users");
							AccessGroup accessGroup = null;
							NamedNodeMap fieldAttributes = itemNodes.item(x).getAttributes();
							titleNode = fieldAttributes.getNamedItem("Title");
							valueNode = fieldAttributes.getNamedItem("VarName");
							keyNode = fieldAttributes.getNamedItem("Key");
							if (titleNode.getNodeValue().equals("Access Group ID")) {
								String key = keyNode.getNodeValue();
								String groupName = valueNode.getNodeValue();
								if (groupName.equals("Admin All"))
									groupName = "System Admin";
								accessGroup = (AccessGroup)dataService.getByName("AccessGroup", groupName);
								if (accessGroup == null) {
									accessGroup = new AccessGroup();
									accessGroup.setName(groupName);
									accessGroup = (AccessGroup)dataService.addUpdate(accessGroup);
								}
								for (int u=0;u<users.size();u++) {
									if (users.get(u).getPrevPassword4() != null && users.get(u).getPrevPassword4().equals(key)) {
										Users user = users.get(u);
										user.setPrevPassword4("");
										user.setAccessGroup(accessGroup);
										dataService.addUpdate(user);
									}
								}
							}
						}else if (groupTitleNode.getNodeValue().equals("Global Stamp Schedule")) {
							MatrixService matrixService = new MatrixService();
							StampSchedule stampSchedule = (StampSchedule)dataService.getStampSchedule();
							if (stampSchedule == null)
								stampSchedule = matrixService.newStampSchedule();
							NodeList stampNodes = itemNodes.item(x).getChildNodes();
							for(int s=0;s<stampNodes.getLength();s++) {
								if (stampNodes.item(s) != null && stampNodes.item(s).getNodeType() == Node.ELEMENT_NODE) {
									if (stampNodes.item(s).getNodeName() == "inches") {
										NamedNodeMap fieldAttributes = stampNodes.item(s).getAttributes();
										Node indexNode = fieldAttributes.getNamedItem("index");
										Node qtyNode = fieldAttributes.getNamedItem("inches_quantity");
										int index = Utilities.tokenToInt(indexNode.getNodeValue());
										switch (index) {
										case 0:
											stampSchedule.setHeader1(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 1:
											stampSchedule.setHeader2(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 2:
											stampSchedule.setHeader3(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 3:
											stampSchedule.setHeader4(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 4:
											stampSchedule.setHeader5(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 5:
											stampSchedule.setHeader6(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 6:
											stampSchedule.setHeader7(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 7:
											stampSchedule.setHeader8(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										case 8:
											stampSchedule.setHeader9(Utilities.tokenToLong(qtyNode.getNodeValue()));
											break;
										}
									} else if (stampNodes.item(s).getNodeName() == "lines") {
										NamedNodeMap fieldAttributes = stampNodes.item(s).getAttributes();
										Node indexNode = fieldAttributes.getNamedItem("index");
										Node qtyNode = fieldAttributes.getNamedItem("lines_quantity");
										stampSchedule.getElements().get(Utilities.tokenToInt(indexNode.getNodeValue())).setQty(Utilities.tokenToInt(qtyNode.getNodeValue()));
									} else if (stampNodes.item(s).getNodeName() == "prices_y") {
										NodeList pricesNodes = stampNodes.item(s).getChildNodes();
										for (int z=0;z<pricesNodes.getLength();z++) {
											if (pricesNodes.item(z).getNodeType() == Node.ELEMENT_NODE) {
												NamedNodeMap fieldAttributes = pricesNodes.item(z).getAttributes();
												Node yNode = fieldAttributes.getNamedItem("y");
												Node xNode = fieldAttributes.getNamedItem("x");
												Node priceNode = fieldAttributes.getNamedItem("price");
												int xValue = Utilities.tokenToInt(xNode.getNodeValue());
												int yValue = Utilities.tokenToInt(yNode.getNodeValue());
												double price = Utilities.tokenToDouble(priceNode.getNodeValue());
												switch (xValue) {
												case 0:
													stampSchedule.getElements().get(yValue).setPrice1(price);
													break;
												case 1:
													stampSchedule.getElements().get(yValue).setPrice2(price);
													break;
												case 2:
													stampSchedule.getElements().get(yValue).setPrice3(price);
													break;
												case 3:
													stampSchedule.getElements().get(yValue).setPrice4(price);
													break;
												case 4:
													stampSchedule.getElements().get(yValue).setPrice5(price);
													break;
												case 5:
													stampSchedule.getElements().get(yValue).setPrice6(price);
													break;
												case 6:
													stampSchedule.getElements().get(yValue).setPrice7(price);
													break;
												case 7:
													stampSchedule.getElements().get(yValue).setPrice8(price);
													break;
												case 8:
													stampSchedule.getElements().get(yValue).setPrice9(price);
													break;
												}
											}
										}
									}
								}
							}
							dataService.addUpdate(stampSchedule);
						} else
							this.importField(groupTitleNode.getNodeValue(), keyValue, titleValue, valueValue);
					}
				}
			}
			List<PreferencesPricingMethod> preferencesPricingMethodList = (List<PreferencesPricingMethod>) dataService.getAll("PreferencesPricingMethod");
			int orderByCounter = 1;
			for (PreferencesPricingMethod preferencesPricingMethod : preferencesPricingMethodList) {
				if(preferencesPricingMethod.getTitle().equalsIgnoreCase("Multi-part Job")) {
					preferencesPricingMethod.setOrderby(1);
				} else {
					preferencesPricingMethod.setOrderby(++orderByCounter);
				}
				dataService.addUpdate(preferencesPricingMethod);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	@SuppressWarnings({"unchecked"})
	private void deletePricingMethods() throws Exception {
		DataService dataService = new DataService();
		List<PreferencesPricingMethod> pricingMethods = (List<PreferencesPricingMethod>)dataService.getAll("PreferencesPricingMethod");
		for (int i=0;i<pricingMethods.size();i++) {
			dataService.deleteItem("PreferencesPricingMethod", pricingMethods.get(i).getId());
		}
	}
	
	@SuppressWarnings("unchecked")
	private void deleteCreditCards() throws Exception {
		DataService dataService = new DataService();
		List<PreferencesCreditCard> creditCards = (List<PreferencesCreditCard>)dataService.getAll("PreferencesCreditCard");
		for (int i=0;i<creditCards.size();i++) {
			dataService.deleteItem("PreferencesCreditCard", creditCards.get(i).getId());
		}
	}
	private void importField(String group, String key, String fieldName, String fieldValue) throws Exception {
		if (group.equals("Statements Notices"))
			importPreferencesAccountingField(key, fieldName, fieldValue);
		else if (group.equals("Receipts Notices"))
			importPreferencesPOSField(key, fieldName, fieldValue);
		else if (group.equals("Paper Calculator"))
			importPreferencesEstimatingField(key, fieldName, fieldValue);
		else if (group.equals("Company Info")) {
			importPreferencesSystemField(key, fieldName, fieldValue, true);
			importPreferencesAccountingField(key, fieldName, fieldValue);
		}
		else if (group.equals("Quantity Breaks"))
			importPreferencesQuantityBreaksField(fieldValue);
		else if (group.equals("Blank Stock Setup") || group.equals("Stock Setup") || group.equals("Customer Stock Setup")) {
			importPreferencesSystemField(key, fieldName, fieldValue, true);
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
			importPreferencesSystemField(key, fieldName, fieldValue, true);
		else if (group.equals("Dongle"))
			importPreferencesSystemField(key, fieldName, fieldValue, true);
		else if (group.equals("Local Workstation")) {
			importPreferencesSystemField(key, fieldName, fieldValue, true);
			importPreferencesEstimatingField(key, fieldName, fieldValue);
			importPreferencesPOSField(key, fieldName, fieldValue);
			importPreferencesAccountingField(key, fieldName, fieldValue);
			importPreferencesStockDefinitionField(key, fieldName, fieldValue);
			importPreferencesPendingListField(key, fieldName, fieldValue);
		}
		else if (group.equals("Def Customer")) {
			importPreferencesSystemField(key, fieldName, fieldValue, true);
			importPreferencesEstimatingField(key, fieldName, fieldValue);
			importPreferencesAccountingField(key, fieldName, fieldValue);
		}
		else if (group.equals("Address Formats")) {
			importAddressFormats(key, fieldName, fieldValue);
		}
		else if (group.equals("CreditCard Info"))
			importPreferencesCreditCardField(key, fieldName, fieldValue);
		else if (group.equals("Money Formats"))
			importPreferencesSystemField(key, fieldName, fieldValue, true);
	}
	
	private void importAddressFormats(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		Country country = null;
		if(name.equals("Country Title")){
			country = (Country)dataService.getByName("Country", value);
		} else {
			country = (Country)dataService.getByPrevId("Country", key);
		}
		PreferencesSystem preferencesSystem = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		AddressFormatting addressFormatting = null;
		if (country == null && name.equals("Country Title")) {
			country = new Country();
			country.setName(value);
			country.setPrevId(key);
			country = (Country) dataService.addTableEditorItem(country);
			addressFormatting = new AddressFormatting();
			addressFormatting.setCountry(country);
			addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
			//country.addAddressFormattings(addressFormatting);
		} else if(country!=null) {
			country.setPrevId(key);
			country = (Country) dataService.addTableEditorItem(country);
			if (country.getAddressFormattings()==null || country.getAddressFormattings().size() == 0) {
				addressFormatting = new AddressFormatting();
				addressFormatting.setCountry(country);
				addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
			} else {
				addressFormatting = country.getAddressFormattings().get(country.getAddressFormattings().size() - 1);
			}
		}
		/*if (country.getAddressFormattings().size() == 0) {
			addressFormatting = new AddressFormatting();
			addressFormatting.setCountry(country);
			addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
			country.addAddressFormattings(addressFormatting);
		}*/
		if (name.equals("Country Format")) {
			int i = value.indexOf("]");
			int rowCount = 1;
			int columnCount = 1;
			int nextStart = 0;
			while (i > -1) {
				Integer position = 0;
				String fieldName = value.substring(nextStart, i+1);
				nextStart = i+1;
				if (fieldName.equals("[NewLine]")) {
					/*addressFormatting = new AddressFormatting();
					addressFormatting.setCountry(country);
					addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
					country.addAddressFormattings(addressFormatting);*/
					rowCount++;
					columnCount = 1;
				}
				else if (fieldName.equals("[Address1]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setStreet1Position(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setStreet1Separator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setStreet1Separator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				else if (fieldName.equals("[Address2]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setStreet2Position(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setStreet2Separator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setStreet2Separator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				else if (fieldName.equals("[Zip]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setZipPosition(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setZipSeparator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setZipSeparator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				else if (fieldName.equals("[State]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setStatePosition(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setStateSeparator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setStateSeparator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				else if (fieldName.equals("[City]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setCityPosition(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setCitySeparator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setCitySeparator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				else if (fieldName.equals("[Country]")) {
					position = Integer.valueOf(rowCount+""+columnCount);
					addressFormatting.setCountryPosition(position);
					columnCount++;
					if (nextStart < value.length() && value.substring(nextStart,nextStart+1).equals("[") == false) {
						if(value.indexOf("[", nextStart)>-1) {
							addressFormatting.setCountrySeparator(value.substring(nextStart,value.indexOf("[", nextStart)));
							nextStart = value.indexOf("[", nextStart);
						} else {
							addressFormatting.setCountrySeparator(value.substring(nextStart,nextStart+1));
							nextStart++;
						}
					}
				}
				/*addressFormatting.setCountry(country);
				addressFormatting = (AddressFormatting)dataService.addUpdate(addressFormatting);
				country.addAddressFormattings(addressFormatting);*/
				i = value.indexOf("]", nextStart);
			}
		} else if (name.equals("Format is Default")) {
			if(Utilities.tokenToBooleanValue(value)) {
				Country defaultCountry = (Country) dataService.getByPrevId("Country", key);
				if(defaultCountry!=null) {
					preferencesSystem.setDefaultCountry(Integer.parseInt(String.valueOf(defaultCountry.getId())));
					dataService.addUpdate(preferencesSystem);
				}
			}
		}
		dataService.addUpdate(addressFormatting);
	}
	
	private void importPreferencesStockDefinitionField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		if (name.equals("StockCol_column_show")) {
			PreferencesStockDefinition preferencesStockDefinition = (PreferencesStockDefinition)dataService.getQuery("PreferencesStockDefinition", " where columnorder="+key);
			preferencesStockDefinition.setVisible(Utilities.tokenToBooleanValue(value));
			dataService.addUpdate(preferencesStockDefinition);
		}
	}
	
	private void importPreferencesPendingListField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		if (name.equals("PendingList_column_show")) {
			PreferencesPendingList preferencesPendingList = (PreferencesPendingList)dataService.getQuery("PreferencesPendingList", " where columnorder="+key);
			preferencesPendingList.setVisible(Utilities.tokenToBooleanValue(value));
			dataService.addUpdate(preferencesPendingList);
		}
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
		} else if (name.equals("buttonPrefixCharacter"))
			preferencesCashRegister.setButtonPrefixCharacter(value);
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
		else if (name.equals("pricingMethod")) {
			preferencesPricingMethod.setMethod(getPricingMethodName(Utilities.tokenToInt(key)));
			String estimatorName = getEstimatorName(Utilities.tokenToInt(key));
			EstimatorTypes estimatorType = (EstimatorTypes)dataService.getByName("EstimatorTypes", estimatorName);
			if (estimatorType == null) {
				estimatorType = new EstimatorTypes();
				estimatorType.setName(estimatorName);
				estimatorType = (EstimatorTypes)dataService.addUpdate(estimatorType);
			}
			preferencesPricingMethod.setEstimator(estimatorType);
		}
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
	private String getEstimatorName(int key) {
		String retValue = "";
		switch (key) {
		case 1:
			retValue = "Press Definitions";
			break;
		case 2:
			retValue = "Copier Definitions";
			break;
		case 3:
			retValue = "Copier Definitions";
			break;
		case 4:
			retValue = "Blank Stock";
			break;
		case 5:
			retValue = "List Price";
			break;
		case 6:
			retValue = "In Stock";
			break;
		case 7:
			retValue = "Special Order";
			break;
		case 8:
			retValue = "Customer";
			break;
		case 9:
			retValue = "Outside Service";
			break;
		case 10:
			retValue = "Generic Merchandise";
			break;
		case 11:
			retValue = "Line and Inches";
			break;
		case 12:
			retValue = "Multiple Parts";
			break;
		case 13:
			retValue = "Outside Service";
			break;
		case 14:
			retValue = "Outside Service";
			break;
		case 15:
			retValue = "Outside Service";
			break;
		case 16:
			retValue = "Outside Service";
			break;
		case 17:
			retValue = "Outside Service";
			break;
		case 18:
			retValue = "Press Definitions";
			break;
		case 19:
			retValue = "Copier Definitions";
			break;
		case 20:
			retValue = "Charges Only";
			break;
			
		}
		
		return retValue;
	}
	private String getPricingMethodName(int key) {
		String retValue = "";
		switch (key) {
		case 1:
			retValue = "Printing";
			break;
		case 2:
			retValue = "B&W";
			break;
		case 3:
			retValue = "Color";
			break;
		case 4:
			retValue = "Blank";
			break;
		case 5:
			retValue = "List";
			break;
		case 6:
			retValue = "In Stock";
			break;
		case 7:
			retValue = "Special Order";
			break;
		case 8:
			retValue = "Customer";
			break;
		case 9:
			retValue = "Outside Services";
			break;
		case 10:
			retValue = "Merchandise";
			break;
		case 11:
			retValue = "Lines & Inches";
			break;
		case 12:
			retValue = "Multi-part Job";
			break;
		case 13:
			retValue = "Outside Services";
			break;
		case 14:
			retValue = "Outside Services";
			break;
		case 15:
			retValue = "Outside Services";
			break;
		case 16:
			retValue = "Outside Services";
			break;
		case 17:
			retValue = "Outside Services";
			break;
		case 18:
			retValue = "Roll Fed";
			break;
		case 19:
			retValue = "Large Format";
			break;
		case 20:
			retValue = "Charges Only";
			break;
			
		}
		
		return retValue;
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
			if ( (Utilities.tokenToInt(key) >= 17 )&& ( Utilities.tokenToInt(key) <= 21))
				salesCategory.setNonSale(true);
			else	
				salesCategory.setNonSale(false);
			salesCategory.setName(name);
			dataService.addUpdate(salesCategory);
		}
	}
	
	private void importSalesCategoryAccountRecord(String key, String name) throws Exception {
		DataService dataService = new DataService();
		SalesCategory salesCategory = (SalesCategory) dataService.getByPrevId("SalesCategory", key);
		if(salesCategory!=null) {
			salesCategory.setGlAccount(name);
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
			preferencesAccounting.setFinanceChange(Utilities.tokenToDouble(value) * 100);
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
		else if (name.equals("Estimator_defaultJournalFormat"))
			preferencesAccounting.setJournalDocumentPreference(value);
		else if (name.equals("CreditLimit"))
			preferencesAccounting.setCreditLimit(Utilities.tokenToDouble(value));
		else if (name.equals("noDraftDeposit_on_ticket"))
			preferencesAccounting.setRemoveDraftsFromDeposit(Utilities.tokenToBooleanValue(value));
		else if (name.equals("defaultNewAcctSalesRep"))
			preferencesAccounting.setDefaultSalesRep(value);
		else if (name.equals("defaultShippingMode"))
			preferencesAccounting.setDefaultShipping(value);
		else if (name.equals("creditCardApproval_Active"))
			preferencesAccounting.setActivateCreditCardApproval(Utilities.tokenToBooleanValue(value));
		else if (name.equals("creditCardIntegration")) {
			if (value.equals("SkipJack"))
				preferencesAccounting.setCreditCardProcessor("useskipjackprocessor");
			else if (value.equals("SuperCharge"))
				preferencesAccounting.setCreditCardProcessor("useobsoletedropfolder");
			else if (value.equals("EFS"))
				preferencesAccounting.setCreditCardProcessor("useefsprocessor");
		} else if (name.equals("skipjackMode")) {
			if (value.equals("normal"))
				preferencesAccounting.setSkipJackMode(0);
			else if (value.equals("advanced"))
				preferencesAccounting.setSkipJackMode(1);
			else
				preferencesAccounting.setSkipJackMode(3);
		} else if (name.equals("skipjackPortNumber"))
			preferencesAccounting.setPortNumber(value);
			
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
		else if (name.equals("cashReceiptTwoCopies"))
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
		} else if (name.equals("hideTax_australia"))
			preferencesPOS.setHideTaxLines(Utilities.tokenToBooleanValue(value));
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
			preferencesEstimating.setBackTrimRun(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useWhiteSpace"))
			preferencesEstimating.setUseWhiteSpace(Utilities.tokenToBooleanValue(value));
		else if (name.equals("grain"))
			if (Utilities.tokenToBooleanValue(value))
				preferencesEstimating.setRunToFinishGrain(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_MATCH_GRAIN);
			else
				preferencesEstimating.setRunToFinishGrain(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_NEITHER);
		else if (name.equals("dutch")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesEstimating.setRunToFinishGrain(Constants.PAPER_CALCULATOR_GRAIN_DIRECTION_SWING_COMBINATION);
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
		else if (name.equals("Estimator_skipAutoShowJobCharges")) {
			if (Utilities.tokenToBooleanValue(value))
				preferencesEstimating.setAutoShowCharges(false);
			else
				preferencesEstimating.setAutoShowCharges(true);
		}
		else if (name.equals("ignorePresetPress_from_stock"))
			preferencesEstimating.setNeverUsePresetPressOnStockChanges(Utilities.tokenToBooleanValue(value));
		else if (name.equals("fixedWastePass_from_press"))
			preferencesEstimating.setAddFixedWasteForEachPass(Utilities.tokenToBooleanValue(value));
		else if (name.equals("fixedWasteColor_from_press"))
			preferencesEstimating.setAddFixedWasteForEachColor(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_ticketClose_after_print"))
			preferencesEstimating.setCloseInvoiceAfterPrintingTicket(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_dueDate_days_out"))
			preferencesEstimating.setNormalDueDateDays(Utilities.tokenToInt(value));
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
		else if (name.equals("Estimator_invAddressEditable"))
			preferencesEstimating.setCanChangeAddress(Utilities.tokenToBooleanValue(value));
		else if (name.equals("skipAutoCost_at_posting"))
			preferencesEstimating.setDoNotCostDuringPost(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_defaultInvoiceFormat"))
			preferencesEstimating.setDefaultInvoice(getDefaultDocumentFormat(value));
		else if (name.equals("Estimator_defaultEstimateFormat"))
			preferencesEstimating.setDefaultEstimate(getDefaultDocumentFormat(value));
		else if (name.equals("reportParent_show_cut_diagram"))
			preferencesEstimating.setPrintParentToFinishSection(Utilities.tokenToBooleanValue(value));
		else if (name.equals("Estimator_autoShowJobPaperCalc"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("numberOfDaysBeforePaymentDue"))
			preferencesEstimating.setNumberOfDaysBeforeDue(Utilities.tokenToInt(value));
		else if (name.equals("StockPicker_twoStageClearSearch"))
			preferencesEstimating.setTwoStageClearSearch(Utilities.tokenToBooleanValue(value));
		else if (name.equals("forceHistroyViewToThisYear"))
			preferencesEstimating.setDefaultHistoryView(Utilities.tokenToBooleanValue(value));
		dataService.addUpdate(preferencesEstimating);
	}
	
	private int getDefaultDocumentFormat(String document) {
		int returnValue = 0;
		
		if (document.equals("No default specified"))
			returnValue = 0;
		else if (document.equals("Alternate Currency"))
			returnValue = 1;
		else if (document.equals("Credit Memo"))
			returnValue = 2;
		else if (document.equals("Estimate - Long Form"))
			returnValue = 3;
		else if (document.equals("Estimate - Short Form"))
			returnValue = 4;
		else if (document.equals("Fax Form"))
			returnValue = 5;
		else if (document.equals("Invoice - Long Form"))
			returnValue = 6;
		else if (document.equals("Invoice - Short Form"))
			returnValue = 7;
		else if (document.equals("Quote Form"))
			returnValue = 8;
		else if (document.equals("Quote Letter"))
			returnValue = 9;
		else if (document.equals("Standard"))
			returnValue = 10;
		else if (document.equals("Thank you letter"))
			returnValue = 11;
		else if (document.equals("Unit pricing / each"))
			returnValue = 12;
		else if (document.equals("Unit pricing / thousand"))
			returnValue = 13;
		else if (document.equals("[en]!TaxName !Remarks"))
			returnValue = 14;
		else if (document.equals("[en]!TaxName +Remarks"))
			returnValue = 15;
		else if (document.equals("[en]+Tax Name !Remarks"))
			returnValue = 16;
		else if (document.equals("[en]+Tax Name +Remards"))
			returnValue = 17;
		
		return returnValue;
	}
	
	private void importPreferencesSystemField(String key, String name, String value, boolean importRoundDown) throws Exception {
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
		else if (name.equals("roundDown") && importRoundDown)
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
		else if (name.equals("autosign_seconds")) {
			preferencesSystem.setAutoLogOutSeconds(Utilities.tokenToInt(value));
			if (Utilities.tokenToInt(value) > 0)
				preferencesSystem.setSecondsOfInactivity(true);
		}
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
		else if (name.equals("numberFormatINTPCT"))
			preferencesSystem.setNumbersShortPercent(value);
		else if (name.equals("App_storeLocationID"))
			preferencesSystem.setCompanyStoreLocationRef(value);
		else if (name.equals("App_enable_import_export"))
			preferencesSystem.setEnablePricingSystem(Utilities.tokenToBooleanValue(value));
		else if (name.equals("roundto"))
			preferencesSystem.setNumbersRoundto(Utilities.tokenToInt(value));
		else if (name.equals("roundTaxUp"))
			preferencesSystem.setRoundTaxUp(Utilities.tokenToBooleanValue(value));
		else if (name.equals("roundDown") && importRoundDown)
			preferencesSystem.setAlwaysRoundDown(Utilities.tokenToBooleanValue(value));
		else if (name.equals("fiscalYearStartMonth")) {
			int month = Utilities.tokenToInt(value);
			switch (month) {
			case 1:
				preferencesSystem.setFiscalYearStartMonth("January");
				break;
			case 2:
				preferencesSystem.setFiscalYearStartMonth("Feburary");
				break;
			case 3:
				preferencesSystem.setFiscalYearStartMonth("March");
				break;
			case 4:
				preferencesSystem.setFiscalYearStartMonth("April");
				break;
			case 5:
				preferencesSystem.setFiscalYearStartMonth("May");
				break;
			case 6:
				preferencesSystem.setFiscalYearStartMonth("June");
				break;
			case 7:
				preferencesSystem.setFiscalYearStartMonth("July");
				break;
			case 8:
				preferencesSystem.setFiscalYearStartMonth("August");
				break;
			case 9:
				preferencesSystem.setFiscalYearStartMonth("September");
				break;
			case 10:
				preferencesSystem.setFiscalYearStartMonth("October");
				break;
			case 11:
				preferencesSystem.setFiscalYearStartMonth("November");
				break;
			case 12:
				preferencesSystem.setFiscalYearStartMonth("December");
				break;
			}
		} else if (name.equals("sortInternational_string_compare"))
			preferencesSystem.setUseTextSorting(Utilities.tokenToBooleanValue(value));
		else if (name.equals("aussieRounding"))
			preferencesSystem.setAustrailianInvoiceRounding(Utilities.tokenToBooleanValue(value));
		else if (name.equals("disableFontStyles"))
			preferencesSystem.setDisableTextStyles(Utilities.tokenToBooleanValue(value));
		else if (name.equals("disableNonTaxable_Inv_Job_Charge"))
			preferencesSystem.setDisableNonTaxableOptions(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useChileTaxVerify"))
			preferencesSystem.setUseChileTaxIdVerification(Utilities.tokenToBooleanValue(value));
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