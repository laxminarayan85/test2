package com.efi.printsmith.defaultdata;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.data.*;

import java.io.File;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.utilities.*;


import flex.messaging.io.ArrayCollection;

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
			ProcessDepositTypes();
			ProcessComLinkType();
			ProcessShippingMethod();
			ProcessProductionLocations();
			ProcessProductionFacilty();
			ProcessColumnNames();
			ProcessEstimatorTypes();
			ProcessJobMethods();
			ProcessPricingMethods();
			ProcessWebTranslation();
			ProcessTableProperties();
			ProcessInkColor();
			ProcessTablesElements();
			ProcessFoldTemplates();
			ProcessProductCodesNames();
			ProcessDoDimension();
			ProcessStockType();
			ProcessLabelFormats();
			ProcessFormPreferences();
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessFormPreferences() throws Exception {
		List<?> formPreferencesList = (List<?>) dataservice.getAll("FormPreferences");

		if (formPreferencesList.size() > 0)
			return;
		
		FormPreferences formPreferences = new FormPreferences();
		formPreferences.setTitle("Standard Form");
		formPreferences.setStyleOption("GenerateFormImage");
		formPreferences.setShowFromAddress(true);
		formPreferences.setShowToAddress(true);
		formPreferences.setShowAttn(true);
		formPreferences.setShowShipVia(true);
		formPreferences.setShowDeliveryDate(true);
		formPreferences.setShowDescription(true);
		formPreferences.setShowComment(true);
		formPreferences.setShowDeliveryNumber(true);
		formPreferences.setLogoAcrossWidth(216D);
		formPreferences.setLogoDownWidth(72D);
		formPreferences.setFromAddressTopPosition(90D);
		formPreferences.setFromAddressAcrossWidth(180D);
		formPreferences.setFromAddressDownWidth(90D);
		formPreferences.setToAddressLeftPosition(190D);
		formPreferences.setToAddressTopPosition(90D);
		formPreferences.setToAddressAcrossWidth(180D);
		formPreferences.setToAddressDownWidth(90D);
		formPreferences.setAttnLeftPosition(375D);
		formPreferences.setAttnTopPosition(90D);
		formPreferences.setAttnAcrossWidth(180D);
		formPreferences.setAttnDownWidth(90D);
		formPreferences.setLineTopPosition(236D);
		formPreferences.setLineAcrossWidth(522D);
		formPreferences.setLineDownWidth(216D);
		formPreferences.setCommentTopPosition(475D);
		formPreferences.setCommentAcrossWidth(540D);
		formPreferences.setCommentDownWidth(100D);
		formPreferences.setDeliveryDateLeftPosition(480D);
		formPreferences.setDeliveryDateTopPosition(25D);
		formPreferences.setReferenceLeftPosition(480D);
		formPreferences.setReferenceTopPosition(45D);
		formPreferences.setShipViaLeftPosition(480D);
		formPreferences.setShipViaTopPosition(35D);
		formPreferences.setCustomerPOLeftPosition(275D);
		formPreferences.setCustomerPOTopPosition(35D);
		formPreferences.setOrderNumberLeftPosition(275D);
		formPreferences.setOrderNumberTopPosition(25D);
		formPreferences.setPartNumberLeftPosition(275D);
		formPreferences.setPartNumberTopPosition(45D);
		formPreferences.setTrackingNumberLeftPosition(275D);
		formPreferences.setTrackingNumberTopPosition(55D);
		formPreferences.setDeliveryNumberLeftPosition(480D);
		formPreferences.setDeliveryNumberTopPosition(15D);
		formPreferences.setDriverLeftPosition(40D);
		formPreferences.setDriverTopPosition(15D);
		formPreferences.setCartonCountLeftPosition(40D);
		formPreferences.setCartonCountTopPosition(27D);
		formPreferences.setCodLeftPosition(190D);
		formPreferences.setCodTopPosition(65D);
		formPreferences.setDescriptionTopPosition(200D);
		formPreferences.setSignatureTopPosition(700D);
		formPreferences.setShowDeliveryDateTitle(true);
		formPreferences.setShowDriverTitle(true);
		formPreferences.setShowCartonCountTitle(true);
		formPreferences.setInvoiceNumberMargin(3D);
		formPreferences.setInvoiceNumberWidth(50D);
		formPreferences.setOrderedQtyMargin(5D);
		formPreferences.setOrderedQtyWidth(60D);
		formPreferences.setShippedQtyMargin(5D);
		formPreferences.setShippedQtyWidth(60D);
		formPreferences.setDescriptionMargin(5D);
		formPreferences.setDescriptionWidth(310D);
		formPreferences.setWeightMargin(3D);
		formPreferences.setWeightWidth(55D);
		Double totalWidth = formPreferences.getInvoiceNumberMargin()+formPreferences.getInvoiceNumberWidth()+formPreferences.getOrderedQtyMargin()
		+formPreferences.getOrderedQtyWidth()+formPreferences.getShippedQtyMargin()+formPreferences.getShippedQtyWidth()+formPreferences.getDescriptionMargin()
		+formPreferences.getDescriptionWidth()+formPreferences.getWeightMargin()+formPreferences.getWeightWidth();
		formPreferences.setWidthOfAllItems(totalWidth);
		FontDefinition addressFontBean = new FontDefinition();
		addressFontBean.setFontName("Arial");
		addressFontBean.setSize(9);
		formPreferences.setAddressFontBean(addressFontBean);
		FontDefinition dateFontBean = new FontDefinition();
		dateFontBean.setFontName("Arial");
		dateFontBean.setSize(9);
		dateFontBean.setIsBold(true);
		formPreferences.setDateFontBean(dateFontBean);
		FontDefinition bodyTextFontBean = new FontDefinition();
		bodyTextFontBean.setFontName("Arial");
		bodyTextFontBean.setSize(10);
		formPreferences.setBodyTextFontBean(bodyTextFontBean);
		FontDefinition formFontBean = new FontDefinition();
		formFontBean.setFontName("Arial");
		formFontBean.setSize(9);
		formFontBean.setIsBold(true);
		formPreferences.setFormFontBean(formFontBean);
		formPreferences.setFormImageSource("ResourceFile");
		formPreferences.setLogoImageSource("ResourceFile");
		formPreferences.setMeasurement("Pixels");
		formPreferences.setDefaultFlag(true);
		try {
			dataservice.addUpdate(formPreferences);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessLabelFormats() throws Exception {
		List<?> labelFotmatList = (List<?>) dataservice.getAll("LabelFormat");
		long displayId = 1L;
		
		if (labelFotmatList.size() > 0)
			return;
		
		LabelFormat labelFormat = new LabelFormat();
		labelFormat.setName("Carton Labels");
		labelFormat.setNoOfLabelsAcross(2.0);
		labelFormat.setNoOfLabelsDown(3.0);
		labelFormat.setLabelWidth(252.0);
		labelFormat.setLabelHeight(216.0);
		labelFormat.setLeftMargin(1.0);
		labelFormat.setTopMargin(36.0);
		labelFormat.setSpaceOnRight(1.0);
		labelFormat.setSpaceOnBottom(18.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		FontDefinition fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		labelFormat = new LabelFormat();
		labelFormat.setName("Shipping Labels");
		labelFormat.setNoOfLabelsAcross(2.0);
		labelFormat.setNoOfLabelsDown(4.0);
		labelFormat.setLabelWidth(260.0);
		labelFormat.setLabelHeight(170.0);
		labelFormat.setLeftMargin(10.0);
		labelFormat.setTopMargin(10.0);
		labelFormat.setSpaceOnRight(10.0);
		labelFormat.setSpaceOnBottom(10.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		labelFormat = new LabelFormat();
		labelFormat.setName("LaserWriter 3 x 10");
		labelFormat.setNoOfLabelsAcross(3.0);
		labelFormat.setNoOfLabelsDown(10.0);
		labelFormat.setLabelWidth(185.0);
		labelFormat.setLabelHeight(72.0);
		labelFormat.setLeftMargin(2.0);
		labelFormat.setTopMargin(12.0);
		labelFormat.setSpaceOnRight(10.0);
		labelFormat.setSpaceOnBottom(0.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		labelFormat = new LabelFormat();
		labelFormat.setName("Laser Avery 5160 3 x 10");
		labelFormat.setNoOfLabelsAcross(3.0);
		labelFormat.setNoOfLabelsDown(10.0);
		labelFormat.setLabelWidth(165.0);
		labelFormat.setLabelHeight(62.0);
		labelFormat.setLeftMargin(2.0);
		labelFormat.setTopMargin(18.0);
		labelFormat.setSpaceOnRight(30.0);
		labelFormat.setSpaceOnBottom(10.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		labelFormat = new LabelFormat();
		labelFormat.setName("ImageWriter 3 x 10");
		labelFormat.setNoOfLabelsAcross(3.0);
		labelFormat.setNoOfLabelsDown(10.0);
		labelFormat.setLabelWidth(190.0);
		labelFormat.setLabelHeight(72.0);
		labelFormat.setLeftMargin(5.0);
		labelFormat.setTopMargin(12.0);
		labelFormat.setSpaceOnRight(0.0);
		labelFormat.setSpaceOnBottom(0.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		labelFormat = new LabelFormat();
		labelFormat.setName("Laser 2 x 3");
		labelFormat.setNoOfLabelsAcross(2.0);
		labelFormat.setNoOfLabelsDown(3.0);
		labelFormat.setLabelWidth(185.0);
		labelFormat.setLabelHeight(85.0);
		labelFormat.setLeftMargin(69.0);
		labelFormat.setTopMargin(160.0);
		labelFormat.setSpaceOnRight(123.0);
		labelFormat.setSpaceOnBottom(154.0);
		labelFormat.setMeasurements("Pixels");
		labelFormat.setDisplayId(displayId++);
		fontDefinition = new FontDefinition();
		fontDefinition.setFontName("Arial");
		fontDefinition.setSize(12);
		labelFormat.setFontDefinition(fontDefinition);
		try {
			dataservice.addUpdate(labelFormat);
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
	private void ProcessInkColor()  throws Exception {
		try {
			LoadInkData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessStockType() throws Exception {
		try {
			LoadStockTypeData(new String[] {currentPath});
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));			
		}
	}
	private void ProcessDoDimension(){
		try {
			LoadDimesionData(new String[] {currentPath});
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
	private void ProcessTablesElements() throws Exception {
		try {
			LoadTaxElements(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessWebTranslation() throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("WebTranslation");
		long displayId = 1L;
		
		if (itemList.size() > 0)
			return;

		WebTranslation webtranslation = new WebTranslation();
		webtranslation.setName("Bindery");
		webtranslation.setDisplayId(displayId++);
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("PrePress");
		webtranslation.setDisplayId(displayId++);
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("Production");
		webtranslation.setDisplayId(displayId++);
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		webtranslation = new WebTranslation();
		webtranslation.setName("Ready for Customer");
		webtranslation.setDisplayId(displayId++);
		try {
			webtranslation = (WebTranslation) dataservice.addUpdate(webtranslation);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}
	private void ProcessTableProperties() throws Exception {
	List<?> itemList = (List<?>) dataservice.getAll("TableProperties");

	if (itemList.size() > 0)
		return;
			
		TableProperties tableEditor = new TableProperties();
		tableEditor.setTableName("BusinessType");
		tableEditor.setUserName("Business Type");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("City");
		tableEditor.setUserName("City");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("CommonInterest");
		tableEditor.setUserName("Common Interest");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ContactNamePrefix");
		tableEditor.setUserName("Contact Name Prefix");
		try{
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("Dimension");
		tableEditor.setUserName("Dimension");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ContactNameSuffixes");
		tableEditor.setUserName("Contact Name Suffixes");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		
		tableEditor = new TableProperties();
		tableEditor.setTableName("Country");
		tableEditor.setUserName("Country");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("CTPSubstrate");
		tableEditor.setUserName("CTP Substrate");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("Driver");
		tableEditor.setUserName("Driver");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("GenericColors");
		tableEditor.setUserName("Generic Colors");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("HoldState");
		tableEditor.setUserName("Hold State");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("InkColor");
		tableEditor.setUserName("Ink Color");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("JobTitle");
		tableEditor.setUserName("Job Title");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("LeadSource");
		tableEditor.setUserName("Lead Source");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("MailerType");
		tableEditor.setUserName("Mailer Type");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("MarketingDateLabels");
		tableEditor.setUserName("Marketing Date Labels");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("MarketingMailers");
		tableEditor.setUserName("Marketing Mailers");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("PhoneTags");
		tableEditor.setUserName("Phone Tags");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionCopiers");
		tableEditor.setUserName("Production Copiers");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionDates");
		tableEditor.setUserName("Production Dates");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionExceptions");
		tableEditor.setUserName("Production Exceptions");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionFacilities");
		tableEditor.setUserName("Production Facilities");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionLocations");
		tableEditor.setUserName("Production Locations");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionPress");
		tableEditor.setUserName("Production Presses");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionPriority");
		tableEditor.setUserName("Production Priority");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ProductionStations");
		tableEditor.setUserName("Production Stations");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("Products");
		tableEditor.setUserName("Products");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ReportCategories");
		tableEditor.setUserName("Report Categories");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("SalesRep");
		tableEditor.setUserName("Sales Rep");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("ShippingMethod");
		tableEditor.setUserName("ShipVia");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("SportsInterest");
		tableEditor.setUserName("Sports Interest");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("State");
		tableEditor.setUserName("State");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("StockColors");
		tableEditor.setUserName("Stock Colors");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("StockFinish");
		tableEditor.setUserName("Stock Finish");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("StockForest");
		tableEditor.setUserName("Stock Forest Management");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("StockGrade");
		tableEditor.setUserName("Stock Grade");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("StockGroup");
		tableEditor.setUserName("Stock Group");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("TaxCodes");
		tableEditor.setUserName("Tax Codes");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("TaxTablesElements");
		tableEditor.setUserName("Tax Tables Elements");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableProperties();
		tableEditor.setTableName("TaxTable");
		tableEditor.setUserName("Tax Tables");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor = new TableProperties();
		tableEditor.setTableName("TypeofWork");
		tableEditor.setUserName("Type of Work");
		
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableProperties();
		tableEditor.setTableName("Vendor");
		tableEditor.setUserName("Vendor");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}tableEditor = new TableProperties();
		
		tableEditor.setTableName("WebLocations");
		tableEditor.setUserName("Web Locations");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		tableEditor.setTableName("Zip");
		tableEditor.setUserName("Zip");
		try {
			tableEditor = (TableProperties) dataservice.addUpdate(tableEditor);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	
	private void ProcessPricingMethods() throws Exception {

		List<?> itemList = (List<?>) dataservice.getAll("PreferencesPricingMethod");
		Long displayId = 1L;
		
		if (itemList.size() > 0)
			return;
		
		PreferencesPricingMethod pricingMethod = new PreferencesPricingMethod();
		pricingMethod.setUsed(true);
		pricingMethod.setTitle("Multi Part");
		pricingMethod.setAbbreviation("Multi Part");
		pricingMethod.setMethod("Multi Part");
		pricingMethod.setDisplayId(displayId++);
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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

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
		pricingMethod.setDisplayId(displayId++);

		try {
			pricingMethod = (PreferencesPricingMethod) dataservice.addUpdate(pricingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}
	private void ProcessEstimatorTypes() throws Exception {
		try {
			LoadEstimatorTypesData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessJobMethods() throws Exception {
		// Offset
		// Digital
		// Large Format
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0)
			return;

		JobMethod jobmethod = new JobMethod();
		jobmethod.setName("Offset");
		jobmethod.setDisplayId(1L);
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		jobmethod = new JobMethod();
		jobmethod.setName("Digital");
		jobmethod.setDisplayId(2L);
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		jobmethod = new JobMethod();
		jobmethod.setName("Large Format");
		jobmethod.setDisplayId(3L);
		try {
			jobmethod = (JobMethod) dataservice.addUpdate(jobmethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}

	private void ProcessColumnNames() throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("ColumnNames");
		long displayId = 1L;
		
		if (itemList.size() > 0)
			return;

		int item = 1;
		ColumnNames columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Account");
		columnnames.setDisplayId(1L);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, true, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Document");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, true, item);
		item = item + 1;

		//Commented for Bug Fix (Id-1110)  
		/*columnnames = new ColumnNames();
		columnnames.setName("ReOrderInvCmd.Contact");
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;*/
		
		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Phone");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Location");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.WantedDate");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("scheduleLateAndCompletedCmd.Hold");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.Type");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.DocumentTitle");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.JobComment");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.ProofDate");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.TakenBy");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.SalesRep");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.WebReference");
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencePendingList(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setName("posPendCmd.JobCount");
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("basicsize");
		columnnames.setName("stockPickerCmd.BasicSize");
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
		try {
			columnnames = (ColumnNames) dataservice.addUpdate(columnnames);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		ProcessPreferencesStockDefinition(columnnames, false, item);
		
		//Fix for BugId 1209
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("stktype");
		columnnames.setName("stockPickerCmd.Type");
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
		columnnames.setDisplayId(displayId++);
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
	AccessGroup owneraccessgroup = new AccessGroup();

	private HashMap<String, ArrayList<String>> createPermissionsList()	{
		String path = new File(currentPath).getParent();
		File accessFile = new File(path + File.separator + "AccessGroupSecurity.txt");
		String line = null;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put("Minimum", new ArrayList<String>());
		map.put("Production", new ArrayList<String>());
		map.put("Counter", new ArrayList<String>());
		map.put("Manager", new ArrayList<String>());
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(accessFile));
			while ((line = br.readLine()) != null)	{
				StringTokenizer st = new StringTokenizer(line,",");
				String key = st.nextToken();
				String value = ((String) st.nextToken()) + "-" + ((String) st.nextToken()); 
				((ArrayList<String>) map.get(key) ).add(value);
			}
		}
		catch (IOException ioe)	{
			log.error("error in createPermissionsList " + ioe);
		}
		return map;
	}
	private void ProcessAccessGroup() throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("AccessGroup");

		if (itemList.size() > 0)
			return;

		HashMap<String, ArrayList<String>> permissionsList = createPermissionsList();
		
		adminaccessgroup.setName("System Admin");
		adminaccessgroup.setOrderby(4);
		
		try {
			adminaccessgroup = (AccessGroup) dataservice.addUpdate(adminaccessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(adminaccessgroup, null);

		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("Minimum");
		accessgroup.setOrderby(0);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, permissionsList.get("Minimum"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Production");
		accessgroup.setOrderby(1);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, permissionsList.get("Production"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Counter");
		accessgroup.setOrderby(2);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup,permissionsList.get("Counter"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Manager");
		accessgroup.setOrderby(3);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup,permissionsList.get("Owner"));
		
		
		owneraccessgroup.setName("Owner");
		owneraccessgroup.setOrderby(5);
		
		try {
			owneraccessgroup = (AccessGroup) dataservice.addUpdate(owneraccessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(owneraccessgroup, null);
		
	}

	private void AddSecuritySetup(AccessGroup accessGroup, ArrayList<String> permissions) throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("SecurityCommands");
			
		for (int i = 0; i < itemList.size(); i++) {
			SecurityCommands seccom = (SecurityCommands) itemList.get(i);
			
			if ((permissions == null)	
					|| ((permissions != null)
						 &&	(permissions.contains(seccom.getMenu() + "-" + seccom.getCommandName()))))	{
					SecuritySetup securitySetup = new SecuritySetup();
					securitySetup.setAccessGroup(accessGroup);
					securitySetup.setSecurityCmd((SecurityCommands) itemList.get(i));
					try {
						dataservice.addUpdate(securitySetup);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
					}
				
			}

		}

	}

	private void ProcessEmployee() throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("Employee");

		if (itemList.size() > 0)
			return;

		Employee employee = new Employee();
		employee.setDisplayId(1L);
		employee.setFirstName("Efi");
		employee.setLastName("Printsmith");
		try {
			dataservice.addUpdate(employee);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessUsers() throws Exception {
		List<?> itemList = (List<?>) dataservice.getAll("Users");

		if (itemList.size() > 0)
			return;

		Users users = new Users();
		users.setName("admin");
		users.setPassword("admin");
		users.setDisplayId(1L);
		users.setShowUserNameLog(true);
		users.setAccessLevel(99);
		users.setAccessGroup(owneraccessgroup);
		users.setForcePasswordChange(false);
		users.setDisableUser(false);
		users.setRobustPassword(false);
		try {
			dataservice.addUpdate(users);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessCountryFile() throws Exception {
		try {
			LoadCountryData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}
	private void ProcessProductCodesNames() throws Exception {
		try {
			LoadProductCodesNamesData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessSecurityCommands() throws Exception {
		try {
			LoadSecurityCommandsData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}
	private void ProcessDepositTypes() throws Exception	{
		List<?> typeList = (List<?>) dataservice
		.getAll("DepositType");
		
		if (typeList.size() > 0)	{
			return;
		}
		
		DepositType dt = new DepositType();
		dt.setName("Cash");
		try {
			dataservice.addUpdate(dt);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		 dt= new DepositType();
		 dt.setName("Check");
		 try {
				dataservice.addUpdate(dt);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
			} 
		 dt= new DepositType();
		 dt.setName("Credit Card");
		 try {
				dataservice.addUpdate(dt);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
			} 
			
	}
	private void ProcessCreditCards() throws Exception {

		List<?> creditcardList = (List<?>) dataservice
				.getAll("PreferencesCreditCard");

		if (creditcardList.size() > 0)
			return;

		PreferencesCreditCard creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("AMEX");
		creditcard.setCardType("American Express");
		creditcard.setCode("AM");
		creditcard.setDisplayId(1L);
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("MC");
		creditcard.setCardType("Mastercard");
		creditcard.setCode("M");
		creditcard.setDisplayId(2L);
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("VI");
		creditcard.setCardType("Visa");
		creditcard.setCode("V");
		creditcard.setDisplayId(3L);
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

		creditcard = new PreferencesCreditCard();
		creditcard.setAbbreviation("DIS");
		creditcard.setCardType("Discover");
		creditcard.setCode("D");
		creditcard.setDisplayId(4L);
		try {
			dataservice.addUpdate(creditcard);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessComLinkType() throws Exception {
		List<?> comLinkTypeList = (List<?>) dataservice.getAll("ComLinkType");

		if (comLinkTypeList.size() > 0)
			return;

		ComLinkType comLinkType = new ComLinkType();
		comLinkType.setType("Phone");
		comLinkType.setDisplayId(1L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Cell");
		comLinkType.setDisplayId(2L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Fax");
		comLinkType.setDisplayId(3L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("E-Mail");
		comLinkType.setDisplayId(4L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("IM");
		comLinkType.setDisplayId(5L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("FaceBook");
		comLinkType.setDisplayId(6L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Twitter");
		comLinkType.setDisplayId(7L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("LinkedIn");
		comLinkType.setDisplayId(8L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Web Site");
		comLinkType.setDisplayId(9L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		comLinkType = new ComLinkType();
		comLinkType.setType("Other");
		comLinkType.setDisplayId(10L);
		try {
			dataservice.addUpdate(comLinkType);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
	}

	private void ProcessShippingMethod() throws Exception {
		List<?> shippingMethodList = (List<?>) dataservice
				.getAll("ShippingMethod");

		if (shippingMethodList.size() > 0)
			return;

		ShippingMethod shippingMethod = new ShippingMethod();
		shippingMethod.setName("Will Call");
		shippingMethod.setDisplayId(1L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Call");
		shippingMethod.setDisplayId(2L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Deliver");
		shippingMethod.setDisplayId(3L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("Ground");
		shippingMethod.setDisplayId(4L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("FexEx");
		shippingMethod.setDisplayId(5L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS");
		shippingMethod.setDisplayId(6L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Red");
		shippingMethod.setDisplayId(7L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("UPS Blue");
		shippingMethod.setDisplayId(8L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("USPS");
		shippingMethod.setDisplayId(9L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		shippingMethod = new ShippingMethod();
		shippingMethod.setName("International");
		shippingMethod.setDisplayId(10L);
		try {
			dataservice.addUpdate(shippingMethod);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}

	}

	private void ProcessProductionLocations()  throws Exception {
		try {
			LoadProductionLocationsData(new String[] { currentPath });
		} catch (IOException e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));		}
	}
	private void ProcessProductionFacilty() throws Exception {
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

	private void LoadEstimatorTypesData(String[] args) throws Exception {
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
	private void LoadStockTypeData(String [] args) throws Exception {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("stocktypes") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doStockType(f);
				break;
			}
		}
	}		
	
	private void LoadDimesionData(String [] args) throws IOException {
		if (args.length == 0)
			args = new String[] { ".." };
		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("dimensions") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				doDimension(f);
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
	
	private void LoadInkData(String[] args) throws Exception {
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
	private void LoadTaxElements(String[] args) throws Exception {
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
	private int doTaxElements(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in TaxElement");
			}
			TaxTablesElements taxElement = new TaxTablesElements();
			
			taxElement.setDisplayId(Long.parseLong(fieldTokens[0]));
			taxElement.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(taxElement);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private int doInkColor(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in InkColor");
			}
			InkColor inkColor = new InkColor();
			
			inkColor.setDisplayId(Long.parseLong(fieldTokens[0]));
			inkColor.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(inkColor);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private int doStatesFile(File file) throws java.io.IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in States");
			}
			State state = new State();
			
			state.setDisplayId(Long.parseLong(fieldTokens[0]));
			state.setName(fieldTokens[1]);;
			
			try {
				dataservice.addUpdate(state);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private int doStockType(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
		int index = 0;
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 3 fields per line in Dimension");
			}
			index++;
			Dimension dimension = new Dimension();
			StockType stockType = new StockType();
			dimension = dataservice.getByDimensionName("Dimension", fieldTokens[2]);
			stockType.setSize(new DimensionInstance(dimension));
			stockType.setName(fieldTokens[1]);
			stockType.setDisplayId(Long.parseLong(fieldTokens[0]));
			stockType.setViewableID(Integer.parseInt(fieldTokens[0]));
			
			try {
				dataservice.addUpdate(stockType);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	private int doDimension(File file) throws java.io.IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 4) {
				throw new java.io.IOException("Expected 4 fields per line in Dimension");
			}
			Dimension dimension = new Dimension();
			
			dimension.setDisplayId(Long.parseLong(fieldTokens[0]));
			dimension.setName(fieldTokens[3]);
			dimension.setType("US - Imperial");
			dimension.setWidth(Float.valueOf(fieldTokens[1]).floatValue());
			dimension.setHeight(Float.valueOf(fieldTokens[2]).floatValue());
			try {
				dataservice.addUpdate(dimension);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
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
	
	private int doEstimatorTypes(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in EstimatorTypes");
			}
			EstimatorTypes estimatorType = new EstimatorTypes();
			
			estimatorType.setDisplayId(Long.parseLong(fieldTokens[0]));
			estimatorType.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(estimatorType);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private void LoadProductCodesNamesData(String[] args) throws Exception {
		if (args.length == 0)
			args = new String[] { ".." };

		String path = new File(args[0]).getParent();
		File pathName = new File(path);
		String[] fileNames = pathName.list();
		for (int i = 0; i < fileNames.length; i++) {
			if (fileNames[i].endsWith(".txt") == true
					&& fileNames[i].toLowerCase().startsWith("productcodenames") == true) {
				File f = new File(pathName.getPath(), fileNames[i]);
				int result = doProductCodeFile(f);
				if (result < 0) {
					log.debug("** Results: ProductCode file returned -1.");
				}
				break;
			}
		}
	}
	private void LoadCountryData(String[] args) throws Exception {
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
	private int doProductCodeFile(File file) throws Exception{
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in ProductCode");
			}
			ProductCode productCode = new ProductCode();
			
			productCode.setDisplayId(Long.parseLong(fieldTokens[0]));
			productCode.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(productCode);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}

	private int doCountryFile(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in Countries");
			}
			Country country = new Country();
			
			country.setDisplayId(Long.parseLong(fieldTokens[0]));
			country.setName(fieldTokens[1]);;
			
			try {
				dataservice.addUpdate(country);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
private void LoadProductionFaciltyData(String[] args) throws Exception {
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
	private void LoadProductionLocationsData(String[] args) throws Exception {
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
	
	private int doProductionFacilityFile(File file)throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in ProductionFacility");
			}
			ProductionFacilities productionFacility = new ProductionFacilities();
			
			productionFacility.setDisplayId(Long.parseLong(fieldTokens[0]));
			productionFacility.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(productionFacility);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}
	
	private int doProductionLocationsFile(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
	
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in ProductionLocations");
			}
			ProductionLocations productionLocation = new ProductionLocations();
			
			productionLocation.setDisplayId(Long.parseLong(fieldTokens[0]));
			productionLocation.setName(fieldTokens[1]);
			try {
				dataservice.addUpdate(productionLocation);
			} catch (Exception e) {
				log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
				break;
			}
		}
		return -1;
	}

	private void LoadSecurityCommandsData(String[] args) throws Exception {
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

	private int doSecurityCommandsFile(File file) throws Exception {

		List<?> securityCommandsList = (List<?>) dataservice
				.getAll("SecurityCommands");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1; 
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				StringTokenizer stringTokenizer = new StringTokenizer(line,",");
				String menu = stringTokenizer.nextToken();
				String command = stringTokenizer.nextToken();
				String cmdId = stringTokenizer.nextToken();
				if (cmdId.trim().equalsIgnoreCase("null"))
					cmdId = null;
				
				boolean menuItemFlag;
				
				int id;
				
				if (line.trim().startsWith("kVersionActivationCmd.PrintSmith"))
					id = 0;
				
				if (stringTokenizer.countTokens() == 0) // no more tokens left	
					menuItemFlag = false;
				else	{
					if (stringTokenizer.nextToken().trim().equals("1"))
						menuItemFlag = true;
					else
						menuItemFlag = false;
				}
				
				if (securityCommandsList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < securityCommandsList.size(); i++) {
						if (
								((SecurityCommands) securityCommandsList.get(i)).getCommandName().trim().equals(command)
								&& 
								((SecurityCommands) securityCommandsList.get(i)).getMenu().trim().equals(menu)								
								&& 
								((SecurityCommands) securityCommandsList.get(i)).getMenuItemFlag() == menuItemFlag
							)
			
						{ 
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
							
							securityCommands.setMenu(menu);
							securityCommands.setCommandName(command);
							securityCommands.setCommandId(cmdId);
							securityCommands.setMenuItemFlag(menuItemFlag);
							dataservice.addUpdate(securityCommands);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					try {
						SecurityCommands securityCommands = new SecurityCommands();
						
						securityCommands.setMenu(menu);
						securityCommands.setCommandName(command);
						securityCommands.setCommandId(cmdId);
						securityCommands.setMenuItemFlag(menuItemFlag);
						
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
