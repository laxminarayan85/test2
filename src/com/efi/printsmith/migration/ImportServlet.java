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
import com.efi.printsmith.data.PressDefinition;
import com.efi.printsmith.data.SalesRep;
import com.efi.printsmith.data.State;
import com.efi.printsmith.data.StockDefinition;
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
			importDataString = importDataString.replaceAll("\"\"", "\" \""); // Insert a space into blank records so the tokenizer recognizes them as actual tokens
			StringTokenizer importDataParser = new StringTokenizer(importDataString, "\",\"", false);
			while (importDataParser.hasMoreTokens()) {
				importTokens.add(importDataParser.nextToken().replaceAll("\"","")); 
			}
			if (importTokens.size() != fieldTokens.size()) {
				throw new InvalidParameterException("Wrong number of fields on line #" + lineNumber + ".");
			} else {
				CustomerMapper customerMapper = new CustomerMapper();
				customerMapper.importTokens(fieldTokens, importTokens);
			}
			lineNumber++;
			importDataString = bufferedReader.readLine();
		}
	}
	

	

	void importPressDefinitionTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {

	}
}
