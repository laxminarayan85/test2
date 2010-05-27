package com.efi.printsmith.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

import com.efi.printsmith.service.DataService;
import com.efi.printsmith.service.PropertiesService;
import com.efi.printsmith.data.ModelBase;

public class AssetRepositoryServlet extends HttpServlet implements Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Logger log = Logger.getLogger(AssetRepositoryServlet.class);
	protected static PropertiesService propertiesService = new PropertiesService();
	protected static DataService dataService = new DataService();

	public AssetRepositoryServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		try {
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items;
				items = upload.parseRequest(request);

				Iterator<FileItem> iter = items.iterator();
				
				iter = items.iterator();

				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (!item.isFormField()) {
						File resultFile = processUploadedFile(item);
						PrintWriter writer = response.getWriter();
						writer.print(resultFile.getName());
					}
				}
			} 
		} catch (FileUploadException e) {
			log.error(e);
			throw new ServletException(e);
		} catch (Exception e) {
			log.error(e);
			throw new ServletException(e);
		}
			
	}

	private File processUploadedFile(FileItem item)
			throws Exception {
		try {
			String assetDirectoryPath = System.getProperty("com.efi.printsmith.digitalAssetRepository", "./assetRepository");
			File assetDirectory = new File(assetDirectoryPath);
			if (!assetDirectory.exists()) {
				if (assetDirectory.mkdir()) {
					log.info("Created asset directory: " + assetDirectory.getAbsolutePath());
				} else {
					log.error("Unable to create asset directory: " + assetDirectory.getPath());
				}
			} else {
				if (!assetDirectory.isDirectory()) {
					log.error("Asset directory exists but is not a directory: " + assetDirectory.getAbsolutePath());
				}
			}
			
			if (assetDirectory.exists() && assetDirectory.isDirectory()) {
				
			} else {
				log.error("Unable to save file to asset directory.");
			}
			File uploadedFile = File.createTempFile("PSAsset", ".tmp", assetDirectory);
			if (!uploadedFile.exists()) {
				uploadedFile.createNewFile();
			} else {
				log.error("Unable to create asset file - it already exists." + uploadedFile.getAbsolutePath());
			}
			item.write(uploadedFile);
			return uploadedFile;
		} catch (Exception e) {
			log.error("Exception: " + e);
			throw e;
		}
	}
}
