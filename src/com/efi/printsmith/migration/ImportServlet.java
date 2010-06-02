package com.efi.printsmith.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.service.DataService;
import com.efi.printsmith.service.PropertiesService;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;

public class ImportServlet extends HttpServlet implements Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Logger log = Logger.getLogger(ImportServlet.class);
	protected static PropertiesService propertiesService = new PropertiesService();
	protected static DataService dataService = new DataService();
	public XpdexImportParams importParams = new XpdexImportParams();
	public ImportServlet() {
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iter = items.iterator();
				String importType = null;
				/*
				 * First figure out what kind of file we're importing based on
				 * the hint given by the client
				 */
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString();
						if (name.equals("importType")) {
							importType = value;
						}
						if (name.equals("importAll")) {
							this.importParams.importAll = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("fullUpdate")) {
							this.importParams.fullUpdate = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("updatePrice1")) {
							this.importParams.updatePrice1 = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("updatePrice2")) {
							this.importParams.updatePrice2 = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("updatePrice3")) {
							this.importParams.updatePrice3 = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("updatePrice4")) {
							this.importParams.updatePrice4 = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("updatePrice5")) {
							this.importParams.updatePrice5 = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("adjustValue1")) {
							this.importParams.adjustValue1 = Utilities.tokenToDouble(value);
						}
						if (name.equals("adjustValue2")) {
							this.importParams.adjustValue2 = Utilities.tokenToDouble(value);
						}
						if (name.equals("adjustValue3")) {
							this.importParams.adjustValue3 = Utilities.tokenToDouble(value);
						}
						if (name.equals("adjustValue4")) {
							this.importParams.adjustValue4 = Utilities.tokenToDouble(value);
						}
						if (name.equals("adjustValue5")) {
							this.importParams.adjustValue5 = Utilities.tokenToDouble(value);
						}
						if (name.equals("updateType")) {
							this.importParams.updateType = Utilities.tokenToInt(value);
						}
						if (name.equals("selectMetric")) {
							this.importParams.selectMetric = Utilities.tokenToBooleanValue(value);
						}
						if (name.equals("noBrokenCartons")) {
							this.importParams.noBrokenCartons = Utilities.tokenToBooleanValue(value);
						}
					}
				}
				iter = items.iterator();

				/*
				 * Now perform the actual import once we've found the file
				 * information in the passed parameters
				 */
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (!item.isFormField()) {
						if (importType != null) {
							processUploadedFile(item, importType);
						} else {
							throw new ServletException(
									"Unknown import type passed to ImportServlet");
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void processUploadedFile(FileItem item, String importType)
			throws Exception {
		boolean writeToFile = true;

		if (writeToFile) {
			try {
				File uploadedFile = File.createTempFile("PSImport", ".tmp");
				if (!uploadedFile.exists()) {
					uploadedFile.createNewFile();
				}
				item.write(uploadedFile);
				importData(uploadedFile, importType, importParams);
				uploadedFile.delete();
			} catch (Exception e) {
				log.error("Exception: " + e);
			}
		} else {

		}
	}

	void importData(File uploadedFile, String importType, XpdexImportParams importParams) throws Exception {
		FileInputStream fis = new FileInputStream(uploadedFile);
		InputStreamReader fileReader = new InputStreamReader(fis);
		CSVReader csvReader = new CSVReader(fileReader);
		String[] fieldTokens = null;
		if (importType.equals("Xpedx") == false)
			fieldTokens = csvReader.readNext();

		ImportMapper mapper = null;

		if (importType != null && "ChargeDefinitions".equals(importType)) {
			mapper = new ChargeDefinitionMapper();
			mapper.importFile(uploadedFile);
		} else {
			if (importType != null) {
				if ("ChargeDefinitions".equals(importType)) {
					mapper = new ChargeDefinitionMapper();
				} else if ("Contacts".equals(importType)) {
					mapper = new ContactMapper();
				} else if ("CopierDefinitions".equals(importType)) {
					mapper = new CopierDefinitionMapper();
				} else if ("CustomerLogs".equals(importType)) {
					mapper = new CustomerLogMapper();
				} else if ("Customers".equals(importType)) {
					mapper = new CustomerMapper();
				} else if ("Invoices".equals(importType)) {
					mapper = new InvoiceMapper();
				} else if ("Jobs".equals(importType)) {
					mapper = new JobMapper();
				} else if ("PressDefinitions".equals(importType)) {
					mapper = new PressDefinitionMapper();
				} else if ("PriceLists".equals(importType)) {
					mapper = new PriceListMapper();
				} else if ("StockDefinitions".equals(importType)) {
					mapper = new StockDefinitionMapper();
				} else if ("TaxTables".equals(importType)) {
					mapper = new TaxTableMapper();
				} else if ("PriceSchedules".equals(importType)) {
					mapper = new PriceScheduleMapper();
				} else if ("Charge".equals(importType)) {
					mapper = new ChargeMapper();
				} else if ("StockChange".equals(importType)) {
					mapper = new StockChangeMapper();
				} else if ("Xpedx".equals(importType)) {
					mapper = new XpedxMapper();
				}else if ("ChargeCosting".equals(importType)) {
						mapper = new ChargeCostingMapper();
				} else {
					throw (new ServletException(
							"Unknown import type passed to ImportServlet"));
				}
			} else {
				throw (new ServletException(
						"Unknown import type passed to ImportServlet"));
			}

			int lineNumber = 2;
			String[] importTokens = null;

			while ((importTokens = csvReader.readNext()) != null) {
				// if (importTokens.length != fieldTokens.length) {
				// throw new
				// InvalidParameterException("Wrong number of fields on line #"
				// + lineNumber + ".");
				// } else {
				if (importType.equals("Xpedx") == false && importTokens.length == fieldTokens.length) {
					try {
						ModelBase modelBase = mapper.importTokens(fieldTokens,
								importTokens);
						dataService.addUpdate(modelBase);
					} catch (Exception e) {
						log.error(e);
					}
				} else {
					try {
						ModelBase modelBase = mapper.importTokens(fieldTokens,
								importTokens, this.importParams);
						dataService.addUpdate(modelBase);
					} catch (Exception e) {
						log.error(e);
					}
				}
				lineNumber++;
			}
			if (importType.equals("Charge"))
				Utilities.setJobChargesFromRootRecord();
		}
	}
}
