package com.efi.printsmith.migration;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.log4j.Logger;

import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.City;
import com.efi.printsmith.data.ComLink;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Country;
import com.efi.printsmith.data.SalesRep;
import com.efi.printsmith.data.State;
import com.efi.printsmith.data.Zip;

import com.efi.printsmith.migration.Utilities;

public class ImportServlet extends HttpServlet implements Servlet {
	protected static Logger log = Logger.getLogger(ImportServlet.class);
	protected static DataService dataService = new DataService();
	
	public ImportServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				List items = upload.parseRequest(request);
				
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.isFormField()) {
						processFormField(item);
					} else {
						processUploadedFile(item);
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	private void processFormField(FileItem item) {
		String name = item.getFieldName();
		String value = item.getString();
		System.out.println("Item name: " + name + " ; value: " + value);
	}
	
	private void processUploadedFile(FileItem item) throws Exception {
		String fieldName = item.getFieldName();
		String fileName = item.getName();
		String contentType = item.getContentType();
		boolean isInMemory = item.isInMemory();
		long sizeInBytes = item.getSize();
		
		boolean writeToFile = true;
				
		if (writeToFile) {
			File uploadedFile = File.createTempFile("PSImport", ".tmp");
			if (!uploadedFile.exists()) {
				uploadedFile.createNewFile();
			}
			item.write(uploadedFile);
			
			importCustomers(uploadedFile);
		} else {
			
		}
	}
	
	void importCustomers(File uploadedFile) throws Exception {
		FileInputStream fis = new FileInputStream(uploadedFile);
		boolean validTokens = true;
		InputStreamReader fileReader = new InputStreamReader(fis);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String fieldString = bufferedReader.readLine();
		ArrayList<String> fieldTokens = new ArrayList<String>();
		
		StringTokenizer parser = new StringTokenizer(fieldString, "\",\"", false); // Use "," as the delimiter - ensures that commas embedded in the data are not treated as a delimiter

		while(parser.hasMoreTokens()) {
			fieldTokens.add(parser.nextToken().replaceAll("\"","")); // Add token to the tokens list (strip any quotation marks)
		}
		
		int lineNumber = 2;
		String importDataString = bufferedReader.readLine();
		while (importDataString != null) {
			ArrayList<String> importTokens = new ArrayList<String>();
			
			StringTokenizer importDataParser = new StringTokenizer(importDataString, "\",\"", false);
			while (importDataParser.hasMoreTokens()) {
				importTokens.add(importDataParser.nextToken().replaceAll("\"","")); 
			}
			if (importTokens.size() != fieldTokens.size()) {
				throw new InvalidParameterException("Wrong number of fields on line #" + lineNumber + ".");
			} else {
				importCustomerTokens(fieldTokens, importTokens);
			}
			lineNumber++;
			importDataString = bufferedReader.readLine();
		}
	}
	
	void importCustomerTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Account customer = new Account();
		Address shipToAddress = new Address();
		Address billToAddress = new Address();
		Contact shipToContact = new Contact();
		Contact billToContact = new Contact();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account number".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account type".equals(fieldTokens.get(i))) {
				if ("1".equals(currentImportToken)) {
					customer.setType("CustomerTypeDeposit");
				} else if ("2".equals(currentImportToken)) {
					customer.setType("CustomerTypeCash");					
				} else if ("3".equals(currentImportToken)) {
					customer.setType("CustomerTypeCheck");					
				} else if ("4".equals(currentImportToken)) {
					customer.setType("CustomerTypeCharge");					
				} else if ("5".equals(currentImportToken)) {
					customer.setType("CustomerTypeCreditCardOnFile");					
				}
			} else if ("account status".equals(fieldTokens.get(i))) {
				if ("1".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusNew");
				} else if ("2".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusCurrent");					
				} else if ("3".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusInactive");					
				} else if ("4".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusPastDue");					
				} else if ("5".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusDelinquent");					
				} else if ("6".equals(currentImportToken)) {
					customer.setStatus("CustomerStatusFrozen");					
				}
			} else if ("resale id".equals(fieldTokens.get(i))) {
				customer.setResaleNumber(currentImportToken);
			} else if ("title".equals(fieldTokens.get(i))) {
				customer.setTitle(currentImportToken);
			} else if ("inv name".equals(fieldTokens.get(i))) {
				shipToAddress.setName(currentImportToken);
			} else if ("inv phone".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv fax".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv city".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					City city = new City(); /* TODO - this needs to use existing city if it exists. Don't always create one. */
					
					city.setName(currentImportToken);
					shipToAddress.setCity(city);
				}
			} else if ("inv zip".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					Zip zip = new Zip(); /* TODO - this needs to use existing zip if it exists. Don't always create one. */
					
					zip.setName(currentImportToken);
					shipToAddress.setZip(zip);
				}
			} else if ("inv first name".equals(fieldTokens.get(i))) {
				shipToContact.setFirstName(currentImportToken);
			} else if ("inv last name".equals(fieldTokens.get(i))) {
				shipToContact.setLastName(currentImportToken);
			} else if ("inv addr1".equals(fieldTokens.get(i))) {
				shipToAddress.setStreet1(currentImportToken);
			} else if ("inv addr2".equals(fieldTokens.get(i))) {
				shipToAddress.setStreet2(currentImportToken);
			} else if ("inv state".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					State state = new State(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					state.setName(currentImportToken);
					shipToAddress.setState(state);
				}
			} else if ("inv refno".equals(fieldTokens.get(i))) {
				customer.setExternalRef(currentImportToken);
			} else if ("bill name".equals(fieldTokens.get(i))) {
				billToAddress.setName(currentImportToken);
			} else if ("bill street1".equals(fieldTokens.get(i))) {
				billToAddress.setStreet1(currentImportToken);
			} else if ("bill street2".equals(fieldTokens.get(i))) {
				billToAddress.setStreet2(currentImportToken);
			} else if ("bill city".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					City city = new City(); /* TODO - this needs to use existing city if it exists. Don't always create one. */
					
					city.setName(currentImportToken);
					billToAddress.setCity(city);
				}				
			} else if ("bill state".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					State state = new State(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					state.setName(currentImportToken);
					billToAddress.setState(state);
				}
			} else if ("bill zip".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					Zip zip = new Zip(); /* TODO - this needs to use existing zip if it exists. Don't always create one. */
					
					zip.setName(currentImportToken);
					billToAddress.setZip(zip);
				}
			} else if ("bill phone".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill last name".equals(fieldTokens.get(i))) {
				billToContact.setLastName(currentImportToken);
			} else if ("bill fax".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Fax"));
				}
			} else if ("bill refno".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table".equals(fieldTokens.get(i))) {
				/* TODO */				
			} else if ("sales ranking".equals(fieldTokens.get(i))) {
				/* TODO */		
			} else if ("do statement".equals(fieldTokens.get(i))) {
				customer.setGenerateStatements(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("do finance charges".equals(fieldTokens.get(i))) {
				customer.setApplyFinanceCharges(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("po required".equals(fieldTokens.get(i))) {
				customer.setPoRequired(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("business type code".equals(fieldTokens.get(i))) {
				
			} else if ("sales rep".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					SalesRep salesRep = new SalesRep(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					salesRep.setName(currentImportToken);
					customer.setSalesRep(salesRep);
				}				
			} else if ("on account".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("balance".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales month".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("sales prior year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("orders year".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate count".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("credit limit".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("discount rate".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("finance rate".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("finance YTD".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("created".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoice date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last aged".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last billed".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last payment".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last posted".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("rank date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoice notes".equals(fieldTokens.get(i))) {
				customer.setAccountNote(currentImportToken);
			} else if ("job notes".equals(fieldTokens.get(i))) {
				customer.setJobNote(currentImportToken);
			} else if ("contact record".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("master acct".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("access level".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("external ref number".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax exempt".equals(fieldTokens.get(i))) {
				customer.setTaxExempt(Utilities.tokenToBooleanValue(currentImportToken));
				/* TODO */
			} else if ("rtype".equals(fieldTokens.get(i))) {
				/* TODO */ /* Note: determines whether this is customer or prospect */
			} else if ("inv addr".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv country".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					Country country = new Country(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					country.setName(currentImportToken);
					shipToAddress.setCountry(country);
				}				
			} else if ("bill addr".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill country".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					Country country = new Country(); /* TODO - this needs to use existing state if it exists. Don't always create one. */
					
					country.setName(currentImportToken);
					billToAddress.setCountry(country);
				}				
			} else if ("ship contact".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv salutation".equals(fieldTokens.get(i))) {
				shipToContact.setSalutation(currentImportToken);
			} else if ("inv job title".equals(fieldTokens.get(i))) {
				shipToContact.setJobTitle(currentImportToken);
			} else if ("inv phone 2".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv phone 3".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					shipToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("inv prefix".equals(fieldTokens.get(i))) {
				shipToContact.setPrefix(currentImportToken);
			} else if ("inv suffix".equals(fieldTokens.get(i))) {
				shipToContact.setSuffix(currentImportToken);
			} else if ("bill contact".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill first name".equals(fieldTokens.get(i))) {
				billToContact.setFirstName(currentImportToken);
			} else if ("bill salutation".equals(fieldTokens.get(i))) {
				billToContact.setSalutation(currentImportToken);
			} else if ("bill job title".equals(fieldTokens.get(i))) {
				billToContact.setJobTitle(currentImportToken);
			} else if ("bill phone 2".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill phone 3".equals(fieldTokens.get(i))) {
				if (currentImportToken.length() > 0) {
					billToContact.addComLinks(Utilities.tokenToComLink(currentImportToken, "Telephone"));
				}
			} else if ("bill prefix".equals(fieldTokens.get(i))) {
				billToContact.setPrefix(currentImportToken);
			} else if ("bill suffix".equals(fieldTokens.get(i))) {
				billToContact.setSuffix(currentImportToken);
			} else if ("do commissions".equals(fieldTokens.get(i))) {
				customer.setPayCommissions(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("notCompany".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("do not mail".equals(fieldTokens.get(i))) {
				customer.setOptOutMarketing(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("default inv".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("default est".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("shipping mode".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("aging[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("history notes".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("statement notes".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill contact record".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("marketing dates[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user1".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user2".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user5".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user6".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user7".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user8".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("number employees".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("business type".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("business type name".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("annual revenue".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("master acct name".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("account PO".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv addr3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv addr4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill addr3".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill addr4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("inv phone 4".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("ship address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("bill address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax table title".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("tax code title".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("expand short".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("customRanking[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("external accounting ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("filler bits".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("file originals".equals(fieldTokens.get(i))) {
				customer.setFileOriginals(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("web access".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("never a customer".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("invoiceTemplateID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimateTemplateID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("shipping mode ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("total invoices".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("terms net".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("terms discount".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate won cnt".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("estimate lost cnt".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("discount single amount".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("first invoice date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("first estimate date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("touch date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset job charges[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[1]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[2]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[3]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[4]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[5]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[6]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[7]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[8]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[9]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("preset inv charges[10]".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("contact count".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource1 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource2 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("leadsource2".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user1 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user2 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user3 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user4 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user5 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user6 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user7 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("user8 ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("items paid".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("time to pay".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("autopay Template ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Company ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Catalog Role ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Pricing Role ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("web Bill Address ID".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("resale cert expire".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last notified date".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("last notified time".equals(fieldTokens.get(i))) {
				/* TODO */
			} else if ("exp data 2".equals(fieldTokens.get(i))) {
				/* TODO */
			}
			customer.setShipToAddress(shipToAddress);
			customer.setBillToAddress(billToAddress);
			customer.setContact(shipToContact);
			customer.setBillToContact(billToContact);
			
			dataService.addUpdate(customer);
		}
	}
}
