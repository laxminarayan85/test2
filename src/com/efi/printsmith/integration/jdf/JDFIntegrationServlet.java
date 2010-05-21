package com.efi.printsmith.integration.jdf;

import java.io.IOException;
import java.io.OutputStream;
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
import org.cip4.jdflib.jmf.JDFDeviceInfo;
import org.cip4.jdflib.jmf.JDFJobPhase;
import org.cip4.jdflib.jmf.JDFReturnQueueEntryParams;
import org.cip4.jdflib.jmf.JDFSignal;
import org.cip4.jdflib.util.mime.MimeReader;

import com.efi.printsmith.data.JobBase;
import com.efi.printsmith.data.JobJDFStatus;
import com.efi.printsmith.integration.jdf.JMFMessages;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.NetworkHelper;
import com.efi.printsmith.service.DataService;

public class JDFIntegrationServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(JDFIntegrationServlet.class);

	public void init() throws ServletException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
				JDFCommand command = (JDFCommand) commandIterator.next();

				if (command.getType().equals("ReturnQueueEntry")) {
					handleReturnQueueEntry(command);

					JDFDoc jmfResponse = JMFMessages
							.ReturnQueueEntryResponse(0);

					response.setContentType(HttpContentType.CONTENT_TYPE_JMF);
					String responseBody = jmfResponse.toXML();
					response.setContentLength(responseBody.length());
					OutputStream out = response.getOutputStream();
					out.write(responseBody.getBytes());
//					out.close();
				}
			}
		}
		Collection<JDFSignal> signals = jdfDoc.getJMFRoot().getAllSignal();
		if (signals != null) {
			Iterator signalIterator = signals.iterator();

			while (signalIterator.hasNext()) {
				JDFSignal signal = (JDFSignal) signalIterator.next();

				if (signal != null) {
					JDFDeviceInfo deviceInfo = signal.getDeviceInfo(0);
					if (deviceInfo != null) {
						JDFJobPhase jobPhase = deviceInfo.getJobPhase(0);
						if (jobPhase != null) {
							try {
								double percentComplete = jobPhase
										.getPercentCompleted();
								String status = jobPhase.getStatus().getName();
								String jobId = jobPhase.getJobID();
								String queueEntryId = jobPhase
										.getQueueEntryID();

								DataService dataService = new DataService();

								JobBase job = (JobBase) dataService.getById(
										"JobBase", Long.parseLong(jobId));
								if (job != null) {
									JobJDFStatus jdfStatus = job.getJdfStatus();
									if (jdfStatus != null) {
										jdfStatus.setStatus(status);
										if (jdfStatus.getQueueId() != queueEntryId) {
											jdfStatus.setQueueId(queueEntryId);
										}
										dataService.addUpdate(jdfStatus);
									} else {
										jdfStatus = new JobJDFStatus();
										jdfStatus.setQueueId(queueEntryId);
										jdfStatus.setStatus(status);
										jdfStatus = (JobJDFStatus) dataService
												.addUpdate(jdfStatus);
										job.setJdfStatus(jdfStatus);
										dataService.addUpdate(job);
									}
								}
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

					}
				}
				System.out.println(signal.toXML());
			}
		}

		System.out.println(jdfDoc.toXML());
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request != null) {
			System.out.println(request);
		}
	}

	private void handleReturnQueueEntry(JDFCommand command) {
		if (command != null) {
			JDFReturnQueueEntryParams params = command
					.getReturnQueueEntryParams(0);

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