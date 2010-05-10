package com.efi.printsmith.integration;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
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
import org.cip4.jdflib.jmf.JDFReturnQueueEntryParams;
import org.cip4.jdflib.jmf.JDFSignal;
import org.cip4.jdflib.util.mime.MimeReader;

import com.efi.printsmith.network.NetworkHelper;

	public class IntegrationServlet extends HttpServlet implements Servlet {
		private static final long serialVersionUID = 1L;

		protected static Logger log = Logger.getLogger(IntegrationServlet.class);
	 
		public void init() throws ServletException {
		}
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//			String realPath = request.getSession().getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"integration"+File.separator;
			if (request != null) {
				System.out.println(request);
			}
			String deviceId = request.getParameter("device");
			if (deviceId != null) {
				
			}
			
			MimeReader mimeReader = new MimeReader();
			JDFDoc jdfDoc = mimeReader.getJDFDoc(request.getInputStream(), 0);
			Collection<JDFCommand> commands = jdfDoc.getJMFRoot().getAllCommand();
			if (commands != null) {
				Iterator commandIterator = commands.iterator();
				
				while (commandIterator.hasNext()) {
					JDFCommand command = (JDFCommand)commandIterator.next();
					
					if (command.getType().equals("ReturnQueueEntry")) {
						handleReturnQueueEntry(command);
					}
				}
			}
			Collection<JDFSignal> signals = jdfDoc.getJMFRoot().getAllSignal();
			if (signals != null) {
				Iterator signalIterator = signals.iterator();
				
				while (signalIterator.hasNext()) {
					JDFSignal signal = (JDFSignal)signalIterator.next();
					
					if (signal != null) {
					}
					System.out.println(signal.toXML());
				}
			}
			
			System.out.println(jdfDoc.toXML());
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if (request != null) {
				System.out.println(request);
			}
		}
	 
		private void handleReturnQueueEntry(JDFCommand command) {
			if (command != null) {
				JDFReturnQueueEntryParams params = command.getReturnQueueEntryParams(0);
				
				String queueID = params.getQueueEntryID();
				
			}
		}
//		private boolean isStringMime(String in) {
//			boolean stringIsMime = false;
//			if (in == null || in.length() == 0) {
//				return stringIsMime;
//			} else {
//				if (in.trim().toLowerCase().indexOf(MIME_VERSION_ATTRIBUTE.toLowerCase()) > - 1) {
//					stringIsMime = true;
//				}
//			}
//			return stringIsMime;
//		}
//		
//		private void convertRequestToNode(String request, boolean isMime) throws Exception {
//			if (isMime) {
//				log.info("* got MIME document\n:" + request);
//
//				String mimeType = 
//				document = MimeEncoder.mimeToDom(request);
//				if (log.isInfoEnabled()) {
//					log.info("* converted MIME document to:\n"
//							+ document.asXML());
//				}
//			} else {
//				JDFParser parser = new JDFParser();
//				JDFDoc doc = parser.parseString(request);
//			}
//			
//		}
	}