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

import com.efi.printsmith.data.*;
import com.efi.printsmith.service.DataService;

public class TableEditorMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(uploadedFile);
		doc.getDocumentElement().normalize();
		NodeList fileNodes = doc.getElementsByTagName("file");
		ModelBase modelBase = null;
		DataService dataService = new DataService();
		String title = "";
		String name = "";
		boolean firstRec = true;
		int recordNumber = 0;
		for (int i=0;i<fileNodes.getLength();i++) {
			NodeList fileChildNodes = fileNodes.item(i).getChildNodes();
			for (int x=0;x<fileChildNodes.getLength();x++) {
				if (fileChildNodes.item(x).getNodeType() == Node.ELEMENT_NODE && fileChildNodes.item(x).getNodeName() == "record") {
					NodeList recordNodes = fileChildNodes.item(x).getChildNodes();
					for (int z=0;z<recordNodes.getLength();z++) {
						if (recordNodes.item(z).getNodeType() == Node.ELEMENT_NODE && recordNodes.item(z).getNodeName() == "field") {
							NamedNodeMap fieldAttributes = recordNodes.item(z).getAttributes();
							Node nameNode = fieldAttributes.getNamedItem("name");
							if (nameNode.getNodeValue().equals("title")) {
								title = recordNodes.item(z).getTextContent();
							} else if (nameNode.getNodeValue().equals("id") && recordNodes.item(z).getTextContent().equals("0") == false) {
								if (firstRec == false && name.equals("") == false)
									dataService.addUpdate(modelBase);
								if (title.equals("Business Type"))
									modelBase = new BusinessType();
								else if (title.equals("Basic Sizes"))
									modelBase = new BasicSize();
								else if (title.equals("City"))
									modelBase = new City();
								else if (title.equals("Common Interest"))
									modelBase = new CommonInterest();
								else if (title.equals("Country"))
									modelBase = new Country();
								else if (title.equals("CTP Substrate"))
									modelBase = new CTPSubstrate();
								else if (title.equals("Contact Name Prefixes"))
									modelBase = new ContactNamePrefix();
								else if (title.equals("Contact Name Suffixes"))
									modelBase = new ContactNameSuffixes();
								else if (title.equals("Driver"))
									modelBase = new Driver();
								else if (title.equals("Generic Colors"))
									modelBase = new GenericColors();
								else if (title.equals("Hold State"))
									modelBase = new HoldState();
								else if (title.equals("Ink Color"))
									modelBase = new InkColor();
								else if (title.equals("Lead Source"))
									modelBase = new LeadSource();
								else if (title.equals("Mailer Type"))
									modelBase = new MailerType();
								else if (title.equals("Marketing Date Lables"))
									modelBase = new MarketingDateLabels();
								else if (title.equals("Marketing Mailers"))
									modelBase = new MarketingMailers();
								else if (title.equals("Phone Tags"))
									modelBase = new PhoneTags();
								else if (title.equals("Production Copiers"))
									modelBase = new ProductionCopiers();
								else if (title.equals("Production Dates"))
									modelBase = new ProductionDates();
								else if (title.equals("Production Exceptions"))
									modelBase = new ProductionExceptions();
								else if (title.equals("Production Facilities"))
									modelBase = new ProductionFacilities();
								else if (title.equals("Production Locations"))
									modelBase = new ProductionLocations();
								else if (title.equals("Production Presses"))
									modelBase = new ProductionPress();
								else if (title.equals("Production Priority"))
									modelBase = new ProductionPriority();
								else if (title.equals("ProductionStations"))
									modelBase = new ProductionStations();
								else if (title.equals("Products"))
									modelBase = new Products();
								else if (title.equals("Report Categories"))
									modelBase = new ReportCategories();
								else if (title.equals("Sales Rep:"))
									modelBase = new SalesRep();
								else if (title.equals("Ship Via:"))
									modelBase = new ShippingMethod();
								else if (title.equals("Sizes - Metric CM")) {
									modelBase = new SizeMetricCM();
									SizeTable sizeTable = (SizeTable)dataService.getByName("SizeTable", title);
									if (sizeTable == null) {
										sizeTable = new SizeTable();
										sizeTable.setName(title);
										dataService.addUpdate(sizeTable);
									}
								}	
								else if (title.equals("Sizes - Metric IN")) {
									modelBase = new SizeMetricIN();
									SizeTable sizeTable = (SizeTable)dataService.getByName("SizeTable", title);
									if (sizeTable == null) {
										sizeTable = new SizeTable();
										sizeTable.setName(title);
										dataService.addUpdate(sizeTable);
									}
								}
								else if (title.equals("Sizes - Metric MM")) {
									modelBase = new SizeMetricMM();
									SizeTable sizeTable = (SizeTable)dataService.getByName("SizeTable", title);
									if (sizeTable == null) {
										sizeTable = new SizeTable();
										sizeTable.setName(title);
										dataService.addUpdate(sizeTable);
									}
								}
								else if (title.equals("Sizes - United States")) {
									modelBase = new SizeUS();
									SizeTable sizeTable = (SizeTable)dataService.getByName("SizeTable", title);
									if (sizeTable == null) {
										sizeTable = new SizeTable();
										sizeTable.setName(title);
										dataService.addUpdate(sizeTable);
									}
								}	
								else if (title.equals("Sports Interest"))
									modelBase = new SportsInterest();
								else if (title.equals("State"))
									modelBase = new State();
								else if (title.equals("Stock Colors"))
									modelBase = new StockColors();
								else if (title.equals("Stock Finish"))
									modelBase = new StockFinish();
								else if (title.equals("Stock Forest Management"))
									modelBase = new StockForest();
								else if (title.equals("Stock Grade"))
									modelBase = new StockGrade();
								else if (title.equals("Stock Group"))
									modelBase = new StockGroup();
								else if (title.equals("Tax Codes"))
									modelBase = new TaxCodes();
								else if (title.equals("Tax Tables"))
									modelBase = new TaxTable();
								else if (title.equals("Type of Work"))
									modelBase = new TypeofWork();
								else if (title.equals("Vendor"))
									modelBase = new Vendor();
								else if (title.equals("WEB Locations"))
									modelBase = new WebLocations();
								else if (title.equals("Zip"))
									modelBase = new Zip();
								recordNumber++;
								if (firstRec && title.equals("Tax Tables") == false)
									deleteAll(modelBase);
								modelBase.setOrderby(recordNumber);
								modelBase.setPrevId(recordNodes.item(z).getTextContent());
								modelBase.setDisplayId(Utilities.tokenToLong(recordNodes.item(z).getTextContent()));
								firstRec = false;
							} else if (nameNode.getNodeValue().equals("name")) {
								if (title.equals("Tax Tables") && recordNodes.item(z).getTextContent().equals("") == false) {
									TaxTable taxTable = (TaxTable)dataService.getByName("TaxTable", recordNodes.item(z).getTextContent());
									if (taxTable == null) {
										taxTable = new TaxTable();
										taxTable.setName(recordNodes.item(z).getTextContent());
										taxTable.setTaxTableIsCurrent(true);
										taxTable.setDisableTable(false);
										modelBase = dataService.addUpdate(taxTable);
									} else
										modelBase = taxTable;
								}
								name = recordNodes.item(z).getTextContent();
								modelBase = setName(modelBase,recordNodes.item(z).getTextContent());
							} else if (nameNode.getNodeValue().equals("key")) {
								modelBase = setKey(modelBase,recordNodes.item(z).getTextContent());
							} else if (nameNode.getNodeValue().equals("attributes")) {
								if (title.equals("Tax Tables")) {
									Node disabledNode = null;
									try {
										disabledNode = fieldAttributes.getNamedItem("disabled");
									} catch (Exception e) {
										disabledNode = null;
									}
									
									if (disabledNode != null)
										((TaxTable) modelBase).setDisableTable(Utilities.tokenToBooleanValue(disabledNode.getNodeValue()));
									
									Node defaultNode = null;
									try {
										defaultNode = fieldAttributes.getNamedItem("default");
									} catch (Exception e) {
										defaultNode = null;
									}
									
									if (defaultNode != null)
										((TaxTable) modelBase).setDefaultTable(Utilities.tokenToBooleanValue(disabledNode.getNodeValue()));
									if (((TaxTable) modelBase).getName().equals("") == false)
										dataService.addUpdate(modelBase);
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void deleteAll(ModelBase modelBase) throws Exception {
		DataService dataService = new DataService();
		String className = modelBase.getClass().getName();
		if (className.lastIndexOf(".") > -1)
			className = className.substring(className.lastIndexOf(".") + 1);
		List <ModelBase> list = (List<ModelBase>)dataService.getAll(className);
		for (int i=0;i<list.size();i++) {
			dataService.deleteItem(className, list.get(i).getId());
		}
	}
	
	private ModelBase setName(ModelBase modelBase, String value) {
		if (modelBase instanceof BusinessType) {
			((BusinessType) modelBase).setName(value);
		} else if (modelBase instanceof BasicSize) {
			((BasicSize) modelBase).setName(value);
		} else if (modelBase instanceof City) {
			((City) modelBase).setName(value);
		} else if (modelBase instanceof CommonInterest) {
			((CommonInterest) modelBase).setName(value);
		} else if (modelBase instanceof Country) {
			((Country) modelBase).setName(value);
		} else if (modelBase instanceof CTPSubstrate) {
			((CTPSubstrate) modelBase).setName(value);
		}else if (modelBase instanceof ContactNamePrefix) {
				((ContactNamePrefix) modelBase).setName(value);
		}else if (modelBase instanceof ContactNameSuffixes) {
				((ContactNameSuffixes) modelBase).setName(value);
		} else if (modelBase instanceof Driver) {
			((Driver) modelBase).setName(value);
		} else if (modelBase instanceof GenericColors) {
			((GenericColors) modelBase).setName(value);
		} else if (modelBase instanceof HoldState) {
			((HoldState) modelBase).setName(value);
		} else if (modelBase instanceof InkColor) {
			((InkColor) modelBase).setName(value);
		} else if (modelBase instanceof LeadSource) {
			((LeadSource) modelBase).setName(value);
		} else if (modelBase instanceof MailerType) {
			((MailerType) modelBase).setName(value);
		} else if (modelBase instanceof MarketingDateLabels) {
			((MarketingDateLabels) modelBase).setName(value);
		} else if (modelBase instanceof MarketingMailers) {
			((MarketingMailers) modelBase).setName(value);
		} else if (modelBase instanceof PhoneTags) {
			((PhoneTags) modelBase).setName(value);
		} else if (modelBase instanceof ProductionCopiers) {
			((ProductionCopiers) modelBase).setName(value);
		} else if (modelBase instanceof ProductionDates) {
			((ProductionDates) modelBase).setName(value);
		} else if (modelBase instanceof ProductionExceptions) {
			((ProductionExceptions) modelBase).setName(value);
		} else if (modelBase instanceof ProductionFacilities) {
			((ProductionFacilities) modelBase).setName(value);
		} else if (modelBase instanceof ProductionLocations) {
			((ProductionLocations) modelBase).setName(value);
		} else if (modelBase instanceof ProductionPress) {
			((ProductionPress) modelBase).setName(value);
		} else if (modelBase instanceof ProductionPriority) {
			((ProductionPriority) modelBase).setName(value);
		} else if (modelBase instanceof ProductionStations) {
			((ProductionStations) modelBase).setName(value);
		} else if (modelBase instanceof Products) {
			((Products) modelBase).setName(value);
		} else if (modelBase instanceof ReportCategories) {
			((ReportCategories) modelBase).setName(value);
		} else if (modelBase instanceof SalesRep) {
			((SalesRep) modelBase).setName(value);
		} else if (modelBase instanceof SizeMetricCM) {
			((SizeMetricCM) modelBase).setName(value);
		} else if (modelBase instanceof SizeMetricIN) {
			((SizeMetricIN) modelBase).setName(value);
		} else if (modelBase instanceof SizeMetricMM) {
			((SizeMetricMM) modelBase).setName(value);
		} else if (modelBase instanceof SizeUS) {
			((SizeUS) modelBase).setName(value);
		} else if (modelBase instanceof SportsInterest) {
			((SportsInterest) modelBase).setName(value);
		} else if (modelBase instanceof State) {
			((State) modelBase).setName(value);
		} else if (modelBase instanceof StockColors) {
			((StockColors) modelBase).setName(value);
		} else if (modelBase instanceof StockFinish) {
			((StockFinish) modelBase).setName(value);
		} else if (modelBase instanceof StockForest) {
			((StockForest) modelBase).setName(value);
		} else if (modelBase instanceof StockGrade) {
			((StockGrade) modelBase).setName(value);
		} else if (modelBase instanceof StockGroup) {
			((StockGroup) modelBase).setName(value);
		} else if (modelBase instanceof TaxCodes) {
			((TaxCodes) modelBase).setName(value);
		} else if (modelBase instanceof TaxTable) { 
			((TaxTable) modelBase).setName(value);
		} else if (modelBase instanceof TypeofWork) {
			((TypeofWork) modelBase).setName(value);
		} else if (modelBase instanceof Vendor) {
			((Vendor) modelBase).setName(value);
		} else if (modelBase instanceof Zip) {
			((Zip) modelBase).setName(value);
		} else if (modelBase instanceof ShippingMethod) {
			((ShippingMethod) modelBase).setName(value);
		}

		return modelBase;
	}
	private ModelBase setKey(ModelBase modelBase, String value) {
		if (modelBase instanceof BusinessType) {
			((BusinessType) modelBase).setKey(value);
		} else if (modelBase instanceof CTPSubstrate) {
			((CTPSubstrate) modelBase).setKey(value);
		} else if (modelBase instanceof Driver) {
			((Driver) modelBase).setKey(value);
		} else if (modelBase instanceof HoldState) {
			((HoldState) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionCopiers) {
			((ProductionCopiers) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionDates) {
			((ProductionDates) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionExceptions) {
			((ProductionExceptions) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionFacilities) {
			((ProductionFacilities) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionLocations) {
			((ProductionLocations) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionPress) {
			((ProductionPress) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionPriority) {
			((ProductionPriority) modelBase).setKey(value);
		} else if (modelBase instanceof ProductionStations) {
			((ProductionStations) modelBase).setKey(value);
		} else if (modelBase instanceof Products) {
			((Products) modelBase).setKey(value);
		} else if (modelBase instanceof ReportCategories) {
			((ReportCategories) modelBase).setKey(value);
		} else if (modelBase instanceof StockFinish) {
			((StockFinish) modelBase).setKey(value);
		} else if (modelBase instanceof StockForest) {
			((StockForest) modelBase).setKey(value);
		} else if (modelBase instanceof StockGrade) {
			((StockGrade) modelBase).setKey(value);
		} else if (modelBase instanceof StockGroup) {
			((StockGroup) modelBase).setKey(value);
		} else if (modelBase instanceof TaxCodes) {
			((TaxCodes) modelBase).setKey(value);
		}

		return modelBase;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		return null;
	}
}