package com.efi.printsmith.integration.mobileapp;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.cip4.jdflib.core.JDFDoc;
import org.cip4.jdflib.core.JDFParser;
import org.cip4.jdflib.jmf.JDFCommand;
import org.cip4.jdflib.jmf.JDFDeviceInfo;
import org.cip4.jdflib.jmf.JDFJobPhase;
import org.cip4.jdflib.jmf.JDFReturnQueueEntryParams;
import org.cip4.jdflib.jmf.JDFSignal;
import org.cip4.jdflib.util.mime.MimeReader;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.JobJDFStatus;
import com.efi.printsmith.integration.jdf.JMFMessages;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.NetworkHelper;
import com.efi.printsmith.service.DataService;

public class MobileIntegrationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(MobileIntegrationServlet.class);

	public void init() throws ServletException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request != null) {
			log.info(request);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			log.info(request);
		}
		String requestType = request.getParameter("data");
		
		if (requestType != null && requestType.toUpperCase().equals("WIP")) {
			log.info("Received WIP request");
			try {
				DataService dataService = new DataService();
				
				List<Invoice> invoices = (List<Invoice>)dataService.getPending();
				response.setContentType(HttpContentType.CONTENT_TYPE_DEFAULT_XML);
				if (invoices != null) {
					XMLEncoder encoder = new XMLEncoder(response.getOutputStream());
					encoder.writeObject(invoices);
					encoder.close();
				}
			} catch (Exception e) {
				log.error(e);
			}
		}

	}
}