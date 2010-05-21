package com.efi.printsmith.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.efi.printsmith.service.ReportService;
import com.inet.report.ReportException;

public class ReportServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private File tmpDir;

	protected static Logger log = Logger.getLogger(ReportServlet.class);

	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String tmpProp = System.getProperty("crystalclear.config");
			if (tmpProp != null) {
				System.out.println(tmpProp);
			}
			String reportName = request.getParameter("reportName");
			String invoiceName = request.getParameter("invoiceName");
			String reportParameter = request.getParameter("reportParameter");
			
			if ((reportName == null || reportName.length() == 0) && 
					(invoiceName == null || invoiceName.length() == 0) ) {
				throw new IOException(
						"Invalid report URL received by ReportServlet");
			}
			ReportService reportService = new ReportService();

			File file = null;
			if (reportName != null && reportName.length() > 0) {
				file = reportService.generateReport(reportName, reportParameter);
			} else if (invoiceName != null && invoiceName.length() > 0) {
				file = reportService.generateInvoice(invoiceName, reportParameter);
			}
			response.setContentType("application/pdf");
		    response.setHeader("Content-disposition",
		      "inline; filename=\"invoice.pdf\"");
		    response.setContentLength((int) file.length());
					
			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
 
			byte[] buf = new byte[4096];

			int count = 0;
			while ((count = in.read(buf)) >= 0) {
				out.write(buf, 0, count);
			}
			in.close();
			out.close();
			file.delete();
		} catch (ReportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String realPath = request.getSession().getServletContext().getRealPath(
				"/")
				+ "WEB-INF" + File.separator + "upload" + File.separator;

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		/*
		 *Set the size threshold, above which content will be stored on disk.
		 */
		fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB
		/*
		 * Set the temporary directory to store the uploaded files of size above threshold.
		 */
		fileItemFactory.setRepository(tmpDir);

		try {
			/*
			 * Parse the request
			 */
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				/*
				 * Handle Form Fields.
				 */
				if (item.isFormField()) {
				} else {
					//Handle Uploaded files.
					File file = new File(realPath, item.getName());
					if (!file.exists()) {
						item.write(file);
					} else {
						throw new IOException("File already exists.");
					}
				}
			}
		} catch (IOException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			log.error(ex);
		}

	}

}