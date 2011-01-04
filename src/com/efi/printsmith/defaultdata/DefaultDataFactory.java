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
	private void ProcessTableEditor() throws Exception {
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
	private void ProcessPricingMethods() throws Exception {

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

	private void ProcessColumnNames() throws Exception {
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
		columnnames.setInternalName("basicsize");
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
		
		//Fix for BugId 1209
		item = item + 1;

		columnnames = new ColumnNames();
		columnnames.setInternalName("stktype");
		columnnames.setName("stockPickerCmd.Type");
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
		adminaccessgroup.setOrderby(0);
		
		try {
			adminaccessgroup = (AccessGroup) dataservice.addUpdate(adminaccessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(adminaccessgroup, null);

		AccessGroup accessgroup = new AccessGroup();
		accessgroup.setName("Minimum");
		accessgroup.setOrderby(1);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, permissionsList.get("Minimum"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Production");
		accessgroup.setOrderby(2);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup, permissionsList.get("Production"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Counter");
		accessgroup.setOrderby(3);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup,permissionsList.get("Counter"));

		accessgroup = new AccessGroup();
		accessgroup.setName("Manager");
		accessgroup.setOrderby(4);
		
		try {
			accessgroup = (AccessGroup) dataservice.addUpdate(accessgroup);
		} catch (Exception e) {
			log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
		}
		AddSecuritySetup(accessgroup,permissionsList.get("Manager"));
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
		users.setShowUserNameLog(true);
		users.setAccessGroup(adminaccessgroup);
		users.setDisableUser(false);
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

	private void ProcessCreditCards() throws Exception {

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

	private void ProcessComLinkType() throws Exception {
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

	private void ProcessShippingMethod() throws Exception {
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
	private int doInkColor(File file) throws Exception {

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
	private int doStockType(File file) throws Exception {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
		int index = 0;
		while ((fieldTokens = csvReader.readNext()) != null) {
			if (fieldTokens.length != 2) {
				throw new java.io.IOException("Expected 2 fields per line in Dimension");
			}
			index++;
			Dimension dimension = new Dimension();
			StockType stockType = new StockType();
			dimension = dataservice.getByDimensionName("Dimension", fieldTokens[1]);
			stockType.setSize(dimension);
			stockType.setName(fieldTokens[0]);
			stockType.setViewableID(index);
			
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
			if (fieldTokens.length != 3) {
				throw new java.io.IOException("Expected 3 fields per line in Dimension");
			}
			Dimension dimension = new Dimension();
			
			dimension.setName(fieldTokens[2]);
			dimension.setType("US - Imperial");
			dimension.setWidth(Float.valueOf(fieldTokens[0]).floatValue());
			dimension.setHeight(Float.valueOf(fieldTokens[1]).floatValue());
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
		List<?> productCodeList = (List<?>) dataservice.getAll("ProductCode");

		FileInputStream f = new FileInputStream(file);
		InputStreamReader ip = new InputStreamReader(f);
		java.io.BufferedReader br = new java.io.BufferedReader(ip);
		String line = null;
		int rv = -1;
		while ((line = br.readLine()) != null) {
			if (line.length() > 0) {
				if (productCodeList.size() > 0) {
					boolean found = false;
					for (int i = 0; i < productCodeList.size(); i++) {
						if (((ProductCode) productCodeList.get(i)).getName().trim()
								.equals(line.trim()) == true) {
							found = true;
							break;
						}
					}
					if (found != true) {
						ProductCode productCode = new ProductCode();
						productCode.setName(line.trim());
						try {
							dataservice.addUpdate(productCode);
						} catch (Exception e) {
							log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
							break;
						}
					}
				} else {
					ProductCode productCode = new ProductCode();
					productCode.setName(line.trim());
					try {
						dataservice.addUpdate(productCode);
					} catch (Exception e) {
						log.debug("** Exception: " + ExceptionUtil.getExceptionStackTraceAsString(e));
						break;
					}
				}
			}
		}
		return rv;
	}
	private int doCountryFile(File file) throws Exception {

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
	private int doProductionLocationsFile(File file) throws Exception {

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
