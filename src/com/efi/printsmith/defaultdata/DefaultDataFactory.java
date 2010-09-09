package com.efi.printsmith.defaultdata;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.utilities.*;

public class DefaultDataFactory {

	protected static Logger log = Logger.getLogger(DataService.class);

	private DataService dataservice;
	private String currentPath;

	public DefaultDataFactory() {
		log.info("** DefaultDataFactory class Initializing.");
		try {
			currentPath = java.net.URLDecoder.decode(this.getClass().getResource("DefaultDataFactory.class").getPath());
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	public void LoadDefaultData(DataService ds) {
		// load states from file
		try {
			dataservice = ds;
			ProcessStateFile();
			ProcessSecurityCommands();
			ProcessAccessGroup();
			ProcessEmployee();
			ProcessCountryFile();
			ProcessUsers();
			ProcessCreditCards();
			ProcessComLinkType();
			ProcessShippingMethod();
			ProcessProductionLocations();
			ProcessProductionFacilty();
			ProcessColumnNames();
			ProcessEstimatorTypes();
			ProcessJobMethods();
			ProcessPricingMethods();
			ProcessWebTranslation();
			ProcessTableEditor();
			ProcessInkColor();
			ProcessTablesElements();
			ProcessFoldTemplates();
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessStateFile() {
		try {
			LoadStatesData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessInkColor() {
		try {
			LoadInkData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessFoldTemplates() {
		try {
			LoadFoldTemplateData(new String[] {currentPath});
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));			
		}
	}
	private void ProcessTablesElements() {
		try {
			LoadTaxElements(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessWebTranslation(){
		List<?> itemList = (List<?>) dataservice.getAll("WebTranslation");

		if (itemList.size() > 0)
			return;

		WebTranslation webtranslation = new WebTranslation();
		webtranslation.setName("Bindery");
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("PrePress");
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("Production");
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("Ready for Customer");
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}
	private void ProcessTableEditor(){
	List<?> itemList = (List<?>) dataservice.getAll("TableEditor");

	if (itemList.size() > 0)
		return;
			
		TableEditor tableEditor = new TableEditor();
		tableEditor.setName("Business Type");
		tableEditor.setUserName("Business Type");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("City");
		tableEditor.setUserName("City");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("CommonInterest");
		tableEditor.setUserName("Common Interest");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ContactNamePrefix");
		tableEditor.setUserName("Contact Name Prefix");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("Dimension");
		tableEditor.setUserName("Dimension");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ContactNameSuffixes");
		tableEditor.setUserName("Contact Name Suffixes");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		tableEditor = new TableEditor();
		tableEditor.setName("Country");
		tableEditor.setUserName("Country");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("CTPSubstrate");
		tableEditor.setUserName("CTP Substrate");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("Driver");
		tableEditor.setUserName("Driver");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("GenericColors");
		tableEditor.setUserName("Generic Colors");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("HoldState");
		tableEditor.setUserName("Hold State");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("InkColor");
		tableEditor.setUserName("Ink Color");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("JobTitle");
		tableEditor.setUserName("Job Title");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("LeadSource");
		tableEditor.setUserName("Lead Source");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("MailerType");
		tableEditor.setUserName("Mailer Type");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("MarketingDateLabels");
		tableEditor.setUserName("Marketing Date Labels");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("MarketingMailers");
		tableEditor.setUserName("Marketing Mailers");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("PhoneTags");
		tableEditor.setUserName("Phone Tags");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionCopiers");
		tableEditor.setUserName("Production Copiers");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionDates");
		tableEditor.setUserName("Production Dates");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionExceptions");
		tableEditor.setUserName("Production Exceptions");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionFacilities");
		tableEditor.setUserName("Production Facilities");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionLocations");
		tableEditor.setUserName("Production Locations");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionPress");
		tableEditor.setUserName("Production Presses");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionPriority");
		tableEditor.setUserName("Production Priority");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ProductionStations");
		tableEditor.setUserName("Production Stations");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("Products");
		tableEditor.setUserName("Products");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ReportCategories");
		tableEditor.setUserName("Report Categories");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("SalesRep");
		tableEditor.setUserName("Sales Rep");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("ShippingMethod");
		tableEditor.setUserName("ShipVia");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("SportsInterest");
		tableEditor.setUserName("Sports Interest");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("State");
		tableEditor.setUserName("State");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("StockColors");
		tableEditor.setUserName("Stock Colors");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("StockFinish");
		tableEditor.setUserName("Stock Finish");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("StockForest");
		tableEditor.setUserName("Stock Forest Management");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("StockGrade");
		tableEditor.setUserName("Stock Grade");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("StockGroup");
		tableEditor.setUserName("Stock Group");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("TaxCodes");
		tableEditor.setUserName("Tax Codes");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("TaxTablesElements");
		tableEditor.setUserName("Tax Tables Elements");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableEditor();
		tableEditor.setName("TaxTable");
		tableEditor.setUserName("Tax Tables");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableEditor();
		tableEditor.setName("TypeofWork");
		tableEditor.setUserName("Type of Work");
		
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableEditor();
		tableEditor.setName("Vendor");
		tableEditor.setUserName("Vendor");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableEditor();
		
		tableEditor.setName("WebLocations");
		tableEditor.setUserName("Web Locations");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor.setName("Zip");
		tableEditor.setUserName("Zip");
		try {
			tableEditor = (TableEditor) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
	}
	private void ProcessPricingMethods(){

		List<?> itemList = (List<?>) dataservice.getAll("PreferencesPricingMethod");

		if (itemList.size() > 0)
			return;
		
		PreferencesPricingMethod pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Multi Part");
		pricingMethod.setAbbreviation("Multi Part");
		pricingMethod.setMethod("Multi Part");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Printing");
		pricingMethod.setAbbreviation("Printing");
		pricingMethod.setMethod("Printing");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Roll-Fed");
		pricingMethod.setAbbreviation("Roll-Fed");
		pricingMethod.setMethod("RollFed");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("B&W");
		pricingMethod.setAbbreviation("B&W");
		pricingMethod.setMethod("B&W");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Color");
		pricingMethod.setAbbreviation("Color");
		pricingMethod.setMethod("Color");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Large Format");
		pricingMethod.setAbbreviation("Large Format");
		pricingMethod.setMethod("Large Format");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Blank");
		pricingMethod.setAbbreviation("Blank");
		pricingMethod.setMethod("Blank");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("List");
		pricingMethod.setAbbreviation("List");
		pricingMethod.setMethod("List");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Charges Only");
		pricingMethod.setAbbreviation("Charges Only");
		pricingMethod.setMethod("Charges Only");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Outside Services");
		pricingMethod.setAbbreviation("Outside Services");
		pricingMethod.setMethod("Outside Services");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Merchandise");
		pricingMethod.setAbbreviation("Merchandise");
		pricingMethod.setMethod("Merchandise");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Lines & Inches");
		pricingMethod.setAbbreviation("Lines & Inches");
		pricingMethod.setMethod("Lines & Inches");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Mailing");
		pricingMethod.setAbbreviation("Mailing");
		pricingMethod.setMethod("Mailing");

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}
	private void ProcessEstimatorTypes() {
		try {
			LoadEstimatorTypesData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessJobMethods() {
		// Offset
		// Digital
		// Large Format
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0)
			return;

		JobMethod jobmethod = new JobMethod();
		jobmethod.setName("Offset");
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		jobmethod = new JobMethod();
		jobmethod.setName("Digital");
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		jobmethod = new JobMethod();
		jobmethod.setName("Large Format");
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}

	private void ProcessColumnNames() {
		List<?> itemList = (List<?>) dataservice.getAll("ColumnNames");

		if (itemList.size() > 0)
			return;

		int item = 1;
		ColumnNames columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Account");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Document");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("ReOrderInvCmd.Contact");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;
		
		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Phone");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Location");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.WantedDate");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("scheduleLateAndCompletedCmd.Hold");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Type");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.DocumentTitle");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.JobComment");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.ProofDate");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.TakenBy");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.SalesRep");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.WebReference");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.JobCount");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);

//stock columns
		item = 1;
		columnnames = new ColumnNames();
		columnnames.setInternalName("name");
		columnnames.setName("stockPickerCmd.Name");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;
		
		columnnames = new ColumnNames();
		columnnames.setInternalName("weight");
		columnnames.setName("stockPickerCmd.Weight");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("parentsize");
		columnnames.setName("stockPickerCmd.Size");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("color");
		columnnames.setName("stockPickerCmd.Color");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("genericcolor");
		columnnames.setName("stockPickerCmd.GenericColor");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("finish");
		columnnames.setName("stockPickerCmd.Finish");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("thickness");
		columnnames.setName("stockPickerCmd.Thickness");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("grade");
		columnnames.setName("stockPickerCmd.Grade");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("cwt1");
		columnnames.setName("stockPickerCmd.CWT");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("vendor");
		columnnames.setName("stockPickerCmd.Vendor");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("stocknumber");
		columnnames.setName("stockPickerCmd.StockNumber");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("id");
		columnnames.setName("stockPickerCmd.ProductID");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("onhand");
		columnnames.setName("stockPickerCmd.QtyOnHand");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("committed");
		columnnames.setName("stockPickerCmd.Committed");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("ordered");
		columnnames.setName("stockPickerCmd.Ordered");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("shellitem");
		columnnames.setName("stockPickerCmd.Shell");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("normalrunsize");
		columnnames.setName("stockPickerCmd.RunSize");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("stktype");
		columnnames.setName("stockPickerCmd.BasicSize");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("stkgroup");
		columnnames.setName("stockPickerCmd.Group");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("coated");
		columnnames.setName("stockPickerCmd.CoatedSides");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("minorder");
		columnnames.setName("stockPickerCmd.MinimumOrder");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("cost1");
		columnnames.setName("stockPickerCmd.Price");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("priceexpires");
		columnnames.setName("stockPickerCmd.PriceExpires");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;
		
		columnnames = new ColumnNames();
		columnnames.setInternalName("forestmanagement");
		columnnames.setName("stockPickerCmd.ForestMgmt");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("pcwrecycledpercent");
		columnnames.setName("stockPickerCmd.Recycle");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("fsccertified");
		columnnames.setName("stockPickerCmd.FSC");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("sficertified");
		columnnames.setName("stockPickerCmd.SFI");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("greensealcertified");
		columnnames.setName("stockPickerCmd.GreenSeal");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
	}

	private void ProcessPreferencePendingList(ColumnNames columnname,
			Boolean visible, Integer columnorder) {
		PreferencesPendingList preferencesPendingList = new PreferencesPendingList();
		preferencesPendingList.setColumns(columnname);
		preferencesPendingList.setVisible(visible);
		preferencesPendingList.setColumnOrder(columnorder);
		try {
			dataservice.addUpdate(preferencesPendingList);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessPreferencesStockDefinition(ColumnNames columnname,
			Boolean visible, Integer columnorder) {
		PreferencesStockDefinition preferencesStockDefinition = new PreferencesStockDefinition();
		preferencesStockDefinition.setColumns(columnname);
		preferencesStockDefinition.setVisible(visible);
		preferencesStockDefinition.setColumnOrder(columnorder);
		try {
			dataservice.addUpdate(preferencesStockDefinition);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	AccessGroup adminaccessgroup = new AccessGroup();

	private void ProcessAccessGroup() {
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0)
			return;

		
		adminaccessgroup.setName("System Admin");
		try {
			adminaccessgroup = (AccessGroup) dataservice.addUpdate(adminaccessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(adminaccessgroup, true);

		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("Minimum");
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, false);

		accessgroup = new AccessGroup();
		accessgroup.setName("Production");
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, false);

		accessgroup = new AccessGroup();
		accessgroup.setName("Counter");
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, false);

		accessgroup = new AccessGroup();
		accessgroup.setName("Manager");
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, false);
	}

	private void AddSecuritySetup(AccessGroup accessGroup, Boolean enabledStatus) {
		List<?> itemList = (List<?>) dataservice.getAll("SecurityCommands");

		for (int i = 0; i < itemList.size(); i++) {
			SecuritySetup securitySetup = new SecuritySetup();
			securitySetup.setAccessGroup(accessGroup);
			securitySetup.setMenu(((SecurityCommands) itemList.get(i))
					.getMenu());
			if (enabledStatus == true) {
				securitySetup.setEnable(true);
			}
			securitySetup.setCommandName((((SecurityCommands) itemList.get(i))
					.getCommandName()));
			
			securitySetup.setCommandId((((SecurityCommands) itemList.get(i))
					.getCommandId()));
			try {
				dataservice.addUpdate(securitySetup);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
			}

		}

	}

	private void ProcessEmployee() {
		List<?> itemList = (List<?>) dataservice.getAll("Employee");

		if (itemList.size() > 0)
			return;

		Employee employee = new Employee();
		employee.setFirstName("Efi");
		employee.setLastName("Printsmith");
		try {
			dataservice.addUpdate(employee);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessUsers() {
		List<?> itemList = (List<?>) dataservice.getAll("Users");

		if (itemList.size() > 0)
			return;

		Users users = new Users();
		users.setName("admin");
		users.setPassword("admin");
		users.setShowUserNameLog(true);
		users.setAccessGroup(adminaccessgroup);
		users.setDisableUser(false);
		try {
			dataservice.addUpdate(users);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessCountryFile() {
		try {
			LoadCountryData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessSecurityCommands() {
		try {
			LoadSecurityCommandsData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}

	private void ProcessCreditCards() {

		List<?> creditcardList = (List<?>) dataservice
				.getAll("PreferencesCreditCard");

		if (creditcardList.size() > 0)
			return;

		PreferencesCreditCard creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("AMEX");
		creditcard.setCardType("American Express");
		creditcard.setCode("AM");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("MC");
		creditcard.setCardType("Mastercard");
		creditcard.setCode("M");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("VI");
		creditcard.setCardType("Visa");
		creditcard.setCode("V");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("DIS");
		creditcard.setCardType("Discover");
		creditcard.setCode("D");
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessComLinkType() {
		List<?> comLinkTypeList = (List<?>) dataservice.getAll("ComLinkType");

		if (comLinkTypeList.size() > 0)
			return;

		ComLinkType comLinkType = new ComLinkType();
		comLinkType.setType("Phone");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Cell");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Fax");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("E-Mail");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("IM");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("FaceBook");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Twitter");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("LinkedIn");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Web Site");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Other");
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessShippingMethod() {
		List<?> shippingMethodList = (List<?>) dataservice
				.getAll("ShippingMethod");

		if (shippingMethodList.size() > 0)
			return;

		ShippingMethod shippingMethod = new ShippingMethod();
		shippingMethod.setName("Will Call");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Call");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Deliver");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Ground");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("FexEx");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Red");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Blue");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("USPS");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("International");
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}

	private void ProcessProductionLocations() {
		try {
			LoadProductionLocationsData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));		}
	}
	private void ProcessProductionFacilty(){
		try{
			LoadProductionFaciltyData(new String[] {currentPath});
			
		}catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
	}

	private void LoadStatesData(String[] args) throws IOException {
		try {
			if (args.length == 0)
				args = new String[] { ".." };
			String path = new File(args[0]).getParent();

			log.info("** Information: " + path);

			File pathName = new File(path);

			log.info("** Information: " + pathName.toString());

			String[] fileNames = pathName.list();

			log.info("** Information: " + fileNames.toString());

			for (int i = 0; i < fileNames.length; i++) {
				if (fileNames[i].endsWith(".txt") == true
						&& fileNames[i].toLowerCase().startsWith("state") == true) {
					File f = new File(pathName.getPath(), fileNames[i]);
					doStatesFile(f);
					break;
				}
			}
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void LoadEstimatorTypesData(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("estimatortypes") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doEstimatorTypes(f);
				break;
			}
		}
	}
	private void LoadFoldTemplateData(String [] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("foldtemplates") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doFoldTemplates(f);
				break;
			}
		}		
	}
	
	private void LoadInkData(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("inkcolor") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doInkColor(f);
				break;
			}
		}
	}
	private void LoadTaxElements(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("taxelements") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doTaxElements(f);
				break;
			}
		}
	}
	private int doTaxElements(File file)throws java.io.IOException{
		List<?> taxElementList = (List<?>) dataservice
		.getAll("TaxTablesElements");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		String prevID = null;
		int rv = -1;
		int count = 0;
		while ((line = br.readLine()) != null) {
			count++;
			if (line.length() > 0) {
				if (taxElementList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < taxElementList.size(); i++) {
						if (((TaxTablesElements) taxElementList.get(i))
								.getName().trim().equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						TaxTablesElements taxElement = new TaxTablesElements();
						taxElement.setName(line.trim());
						prevID= Integer.toString(count);
						taxElement.setPrevId(prevID);
						try {
							dataservice.addUpdate(taxElement);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					TaxTablesElements taxElement = new TaxTablesElements();
					taxElement.setName(line.trim());
					prevID= Integer.toString(count);
					taxElement.setPrevId(prevID);
					try {
						dataservice.addUpdate(taxElement);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
}
return rv;
	}
	private int doInkColor(File file) throws java.io.IOException {

		List<?> inkColorList = (List<?>) dataservice
				.getAll("InkColor");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (inkColorList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < inkColorList.size(); i++) {
						if (((InkColor) inkColorList.get(i))
								.getName().trim().equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						InkColor inkcolors = new InkColor();
						inkcolors.setName(line.trim());
						try {
							dataservice.addUpdate(inkcolors);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					InkColor inkcolors = new InkColor();
					inkcolors.setName(line.trim());
					try {
						dataservice.addUpdate(inkcolors);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}
	
	private int doStatesFile(File file) throws java.io.IOException {
		int rv = -1;
		try {
			List<?> stateList = (List<?>) dataservice.getAll("State");

			FileInputStream f = new FileInputStream(file);
			InputStreamReader ip = new InputStreamReader(f);
			java.io.BufferedReader br = new java.io.BufferedReader(ip);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					if (stateList.size() > 0) {
						boolean found = false;
						for (int i = 0; i < stateList.size(); i++) {
							if (((State) stateList.get(i)).getName().trim()
									.equals(line.trim()) == true) {
								found = true;
								break;
							}
						}
						if (found != true) {
							State state = new State();
							state.setName(line.trim());
							try {
								dataservice.addUpdate(state);
							} catch (Exception e) {
								log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
								break;
							}
						}
					} else {
						State state = new State();
						state.setName(line.trim());
						try {
							dataservice.addUpdate(state);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		return rv;
	}
	private int doFoldTemplates(File file) throws java.io.IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
		
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 6) {
				throw new java.io.IOException("Expected 6 fields per line in FoldTemplates");
			}
			FoldTemplate foldTemplate = new FoldTemplate();
			
			foldTemplate.setImageFile(fieldTokens[0]);
			foldTemplate.setName(fieldTokens[1]);
			foldTemplate.setDescription(fieldTokens[2]);
			foldTemplate.setEnabled(fieldTokens[4].equals("1"));
		
			try {
				dataservice.addUpdate(foldTemplate);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private int doEstimatorTypes(File file) throws java.io.IOException {

		List<?> estimatorTypesList = (List<?>) dataservice
				.getAll("EstimatorTypes");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (estimatorTypesList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < estimatorTypesList.size(); i++) {
						if (((EstimatorTypes) estimatorTypesList.get(i))
								.getName().trim().equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						EstimatorTypes estimatortypes = new EstimatorTypes();
						estimatortypes.setName(line.trim());
						try {
							dataservice.addUpdate(estimatortypes);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					EstimatorTypes estimatortypes = new EstimatorTypes();
					estimatortypes.setName(line.trim());
					try {
						dataservice.addUpdate(estimatortypes);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}

	private void LoadCountryData(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };

		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("country") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				int result = doCountryFile(f);
				if (result < 0) {
					log.debug("** Results: Country file returned -1.");
				}
				break;
			}
		}
	}

	private int doCountryFile(File file) throws java.io.IOException {

		List<?> countryList = (List<?>) dataservice.getAll("Country");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (countryList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < countryList.size(); i++) {
						if (((Country) countryList.get(i)).getName().trim()
								.equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						Country country = new Country();
						country.setName(line.trim());
						try {
							dataservice.addUpdate(country);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					Country country = new Country();
					country.setName(line.trim());
					try {
						dataservice.addUpdate(country);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}
private void LoadProductionFaciltyData(String[] args) throws IOException {
	if (args.length == 0)
		args = new String[] { ".." };
	String path = new File(args[0]).getParent();
	File pathName = new File(path);
	String[] fileNames = pathName.list();
	for (int i = 0; i < fileNames.length; i++) {
		if (fileNames[i].endsWith(".txt") == true
				&& fileNames[i].toLowerCase().startsWith(
						"productionfacility") == true) {
			File f = new File(pathName.getPath(), fileNames[i]);
			int result = doProductionFacilityFile(f);
			if (result < 0) {
				log
						.debug("** Exception: ProductionLocations file Load failed.");
			}
			break;
		}
	}
}
	private void LoadProductionLocationsData(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith(
							"productionlocations") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				int result = doProductionLocationsFile(f);
				if (result < 0) {
					log
							.debug("** Exception: ProductionLocations file Load failed.");
				}
				break;
			}
		}
	}
	private int doProductionFacilityFile(File file)throws java.io.IOException {

		List<?> productionFacilityList = (List<?>) dataservice
				.getAll("ProductionFacilities");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (productionFacilityList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < productionFacilityList.size(); i++) {
						if (((ProductionFacilities) productionFacilityList
								.get(i)).getName().trim().equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						ProductionFacilities productionFacility = new ProductionFacilities();
						productionFacility.setName(line.trim());
						try {
							dataservice.addUpdate(productionFacility);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					ProductionFacilities productionFacility = new ProductionFacilities();
					productionFacility.setName(line.trim());
					try {
						dataservice.addUpdate(productionFacility);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}
	private int doProductionLocationsFile(File file) throws java.io.IOException {

		List<?> productionLocationsList = (List<?>) dataservice
				.getAll("ProductionLocations");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (productionLocationsList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < productionLocationsList.size(); i++) {
						if (((ProductionLocations) productionLocationsList
								.get(i)).getName().trim().equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						ProductionLocations productionLocations = new ProductionLocations();
						productionLocations.setName(line.trim());
						try {
							dataservice.addUpdate(productionLocations);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					ProductionLocations productionLocations = new ProductionLocations();
					productionLocations.setName(line.trim());
					try {
						dataservice.addUpdate(productionLocations);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}

	private void LoadSecurityCommandsData(String[] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase()
							.startsWith("securitycommands") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				int result = doSecurityCommandsFile(f);
				if (result < 0) {
					log
							.debug("** Exception: SecurityCommands file Load failed.");
				}
				break;
			}
		}
	}

	private int doSecurityCommandsFile(File file) throws java.io.IOException {

		List<?> securityCommandsList = (List<?>) dataservice
				.getAll("SecurityCommands");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (securityCommandsList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < securityCommandsList.size(); i++) {
						if (((SecurityCommands) securityCommandsList.get(i))
								.getCommandName().trim().equals(
										line.substring(line.indexOf(",") + 1)) == true
								&& ((SecurityCommands) securityCommandsList
										.get(i)).getMenu().trim().equals(
										line.substring(0, line.indexOf(",")))) {
							found = true;
							break;
						}
					}
					if (found != true) {
//						securityCommands.setCommandName(line.substring(line
//								.indexOf(",") + 1));
//						securityCommands.setMenu(line.substring(0, line
//								.indexOf(",")));
//						securityCommands.setCommandId(line.substring(line.indexOf(",")+1));
						try {
							SecurityCommands securityCommands = new SecurityCommands();
							StringTokenizer stringTokenizer = new StringTokenizer(line,",");
						
							securityCommands.setMenu(stringTokenizer.nextToken());
							securityCommands.setCommandName(stringTokenizer.nextToken());
							securityCommands.setCommandId(stringTokenizer.nextToken());
							dataservice.addUpdate(securityCommands);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					try {
						SecurityCommands securityCommands = new SecurityCommands();
						StringTokenizer stringTokenizer = new StringTokenizer(line,",");
					
						securityCommands.setMenu(stringTokenizer.nextToken());
						securityCommands.setCommandName(stringTokenizer.nextToken());
						securityCommands.setCommandId(stringTokenizer.nextToken());
						dataservice.addUpdate(securityCommands);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}
}
