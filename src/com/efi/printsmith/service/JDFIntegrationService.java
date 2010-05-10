package com.efi.printsmith.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;

import javax.mail.BodyPart;
import javax.mail.Multipart;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;
import org.cip4.jdflib.auto.JDFAutoComponent.EnumComponentType;
import org.cip4.jdflib.auto.JDFAutoLayoutPreparationParams.EnumSides;
import org.cip4.jdflib.auto.JDFAutoMedia.EnumMediaType;
import org.cip4.jdflib.auto.JDFAutoNodeInfo.EnumDueLevel;
import org.cip4.jdflib.auto.JDFAutoComChannel.EnumChannelType;
import org.cip4.jdflib.core.ElementName;
import org.cip4.jdflib.core.JDFCustomerInfo;
import org.cip4.jdflib.core.JDFDoc;
import org.cip4.jdflib.core.JDFResourceLink;
import org.cip4.jdflib.core.JDFResourceLink.EnumUsage;
import org.cip4.jdflib.core.KElement;
import org.cip4.jdflib.core.JDFElement.EnumVersion;
import org.cip4.jdflib.core.JDFNodeInfo;
import org.cip4.jdflib.core.JDFElement.EnumNodeStatus;
import org.cip4.jdflib.core.VString;
import org.cip4.jdflib.datatypes.JDFIntegerRangeList;
import org.cip4.jdflib.datatypes.JDFXYPair;
import org.cip4.jdflib.jmf.JDFCommand;
import org.cip4.jdflib.jmf.JDFJMF;
import org.cip4.jdflib.jmf.JDFMessage;
import org.cip4.jdflib.jmf.JDFQueueEntry;
import org.cip4.jdflib.jmf.JDFMessage.EnumFamily;
import org.cip4.jdflib.jmf.JDFQuery;
import org.cip4.jdflib.jmf.JDFQueueSubmissionParams;
import org.cip4.jdflib.node.JDFNode;
import org.cip4.jdflib.node.JDFNode.EnumProcessUsage;
import org.cip4.jdflib.node.JDFNode.EnumType;
import org.cip4.jdflib.pool.JDFAuditPool;
import org.cip4.jdflib.pool.JDFResourcePool;
import org.cip4.jdflib.resource.JDFCreated;
import org.cip4.jdflib.resource.JDFLayoutPreparationParams;
import org.cip4.jdflib.resource.JDFResource.EnumResStatus;
import org.cip4.jdflib.resource.process.JDFAddress;
import org.cip4.jdflib.resource.process.JDFComChannel;
import org.cip4.jdflib.resource.process.JDFCompany;
import org.cip4.jdflib.resource.process.JDFComponent;
import org.cip4.jdflib.resource.process.JDFContact;
import org.cip4.jdflib.resource.process.JDFDigitalPrintingParams;
import org.cip4.jdflib.resource.process.JDFMedia;
import org.cip4.jdflib.resource.process.JDFPerson;
import org.cip4.jdflib.resource.process.JDFRunList;
import org.cip4.jdflib.resource.process.JDFContact.EnumContactType;
import org.cip4.jdflib.util.JDFDate;
import org.cip4.jdflib.util.MimeUtil;
import org.cip4.jdflib.util.MimeUtil.MIMEDetails;
import org.cip4.jdflib.util.mime.MimeWriter;
import org.cip4.jdflib.core.JDFParser;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.efi.printsmith.data.JobJDFStatus;
import com.efi.printsmith.data.PreferencesIntegration;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.integration.JDF.JMFMessages;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.HttpPostContent;
import com.efi.printsmith.network.HttpResponse;
import com.efi.printsmith.network.NetworkHelper;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

public class JDFIntegrationService extends HibernateService {
	private Logger log = Logger.getLogger(JDFIntegrationService.class);

	public void sendJobToFiery(long invoiceId, long jobId) throws InvalidParameterException, Exception {
		DataService dataService = new DataService();
				
		Job job = (Job) dataService.getById("Job", jobId);		
		if (job == null) {
			throw new InvalidParameterException("No Job found for id: " + jobId);
		}
		
		Invoice invoice = (Invoice) dataService.getById("Invoice", invoiceId);
		if (invoice == null) {
			throw new InvalidParameterException("No Invoice found for id: " + invoiceId);
		}
		
		CopierDefinition copierDefinition = job.getCostingCopier();
		if (copierDefinition == null) {
			throw new InvalidParameterException("No copier definition found in job");
		}
//				
//		if (!copierDefinition.getIntegratedDevice()) {
//			throw new InvalidParameterException("Copier definition is not an integrated digital press");
//		}
//				
		if (copierDefinition.getOemDeviceID() == null || copierDefinition.getOemDeviceID().length() == 0) {
			throw new InvalidParameterException("Copier definition does not contain a valid OEM Device ID. Unable to send job to undefined device.");
		}
		
		copierDefinition = (CopierDefinition) dataService.getById("CopierDefinition", copierDefinition.getId());
		String deviceId = copierDefinition.getOemDeviceID();
		JDFDoc jdfDoc = new JDFDoc("JDF");
		JDFNode jdfNode = jdfDoc.getJDFRoot();
		if (job.getDescription() != null) {
			jdfNode.setDescriptiveName(job.getDescription());
		} else {
			jdfNode.setDescriptiveName(job.getPricingMethod().toString());
		}
		jdfNode.setJobID(job.getId().toString());
		jdfNode.setJobPartID(job.getId().toString() + job.getJobIndex().toString());
		jdfNode.setType(EnumType.ProcessGroup);
		VString types = new VString();
		types.add(EnumType.ResourceDefinition);
		types.add(EnumType.RIPing);
		types.add(EnumType.DigitalPrinting);
		jdfNode.setTypes(types);
		jdfNode.setStatus(EnumNodeStatus.Ready);
		jdfNode.setVersion(EnumVersion.Version_1_3);
		jdfNode.addNameSpace("EFI", "http://www.efi.com/efijdf");
		
		Account acct = invoice.getAccount();
		Contact contact = invoice.getContact();
		
		JDFCustomerInfo jdfCustomerInfo = jdfNode.appendCustomerInfo();
		JDFContact jdfContact = jdfCustomerInfo.appendContact(EnumContactType.Customer);
		jdfContact.setID("1");
		
		JDFAddress jdfAddress = jdfContact.appendAddress();
		jdfAddress.setCity("Denver");
		jdfAddress.setRegion("CO");
		jdfAddress.setStreet("2242 High St.");
		jdfAddress.setPostalCode("80205");
		
		JDFPerson jdfPerson = jdfContact.appendPerson();
		jdfPerson.setFirstName("Brad");
		jdfPerson.setFamilyName("Knabel");
		
		JDFCompany jdfCompany = jdfContact.appendCompany();
		jdfCompany.setOrganizationName("EFI");
		
		JDFComChannel jdfComChannel = jdfContact.appendComChannel();
		jdfComChannel.setLocator("412-979-7347");
		jdfComChannel.setChannelType(EnumChannelType.Phone);
		
		JDFNodeInfo jdfNodeInfo = jdfNode.appendNodeInfo();
		jdfNodeInfo.setLastEnd(new JDFDate());
		jdfNodeInfo.setDueLevel(EnumDueLevel.Penalty);
		
		JDFAuditPool jdfAuditPool = jdfNode.getAuditPool();
		if (jdfAuditPool == null) {
			jdfAuditPool = jdfNode.appendAuditPool();
		}
		JDFCreated jdfCreated = jdfAuditPool.addCreated(null,null);
		jdfCreated.setAuthor("Brad Knabel");
		jdfCreated.setAgentName("Snowmass Digital Press Connector");
		jdfCreated.setAgentVersion("1.0a1");
		jdfCreated.setTimeStamp(new JDFDate());
		
		
		JDFResourcePool jdfResourcePool = jdfNode.getResourcePool();
		if (jdfResourcePool == null) {
			jdfNode.appendResourcePool();
		}	
		JDFRunList jdfRunList = (JDFRunList)jdfNode.getCreateResource(ElementName.RUNLIST, EnumUsage.Input, 0);
		jdfRunList.setID("r0001");
		jdfRunList.setStatus(EnumResStatus.Available);
		jdfRunList.setLocked(false);
		JDFResourceLink runListResourceLink = jdfNode.getLink(jdfRunList, null);
//		runListResourceLink.setProcessUsage(EnumProcessUsage.Document);
		JDFRunList jdfRun = jdfRunList.addRun("file://c:/test.pdf");
		jdfRun.setNPage(16);
		jdfRun.setStatus(EnumResStatus.Available);
		jdfRun.setEndOfSet(true);
		jdfRun.setEndOfDocument(true);
		//JDFIntegerRangeList rangeList = new JDFIntegerRangeList();
		jdfRun.setPages(null);
		JDFLayoutPreparationParams jdfLayoutPreparationParams = (JDFLayoutPreparationParams)jdfResourcePool.appendElementN(ElementName.LAYOUTPREPARATIONPARAMS, 1, null);
		jdfLayoutPreparationParams.setID("r0002");
		jdfLayoutPreparationParams.setLocked(false);
		jdfLayoutPreparationParams.setStatus(EnumNodeStatus.Ready);
		jdfLayoutPreparationParams.setSides(EnumSides.OneSidedFront);
		JDFMedia jdfMedia = (JDFMedia)jdfResourcePool.appendElementN(ElementName.MEDIA, 1, null);
		jdfMedia.setID("m0001");
		StockDefinition stockDefinition = job.getStock();
		long width = PriceListUtilities.getLengthFromSizeString(job.getFinishSize());
		long length = PriceListUtilities.getLengthFromSizeString(job.getFinishSize());
		JDFXYPair dimensions = new JDFXYPair(width, length);
		if (stockDefinition != null) {
			stockDefinition = (StockDefinition)dataService.getByStockId(stockDefinition.getStockId());
			jdfMedia.setDimension(dimensions);
			jdfMedia.setMediaType(EnumMediaType.Paper); // TODO: Handle other media types here
			jdfMedia.setStatus(EnumNodeStatus.Ready);
			jdfMedia.setProductID(stockDefinition.getStockId());
			jdfMedia.setStockType(" ");
		} else {
			jdfMedia.setDimension(dimensions);
			jdfMedia.setMediaType(EnumMediaType.Paper);
			jdfMedia.setStatus(EnumNodeStatus.Ready);
			jdfMedia.setProductID("0");
			jdfMedia.setStockType(" ");
		}
		
		JDFDigitalPrintingParams jdfDigitalPrintingParams = (JDFDigitalPrintingParams)jdfResourcePool.appendElementN(ElementName.DIGITALPRINTINGPARAMS, 1, null);
		jdfDigitalPrintingParams.appendMedia();
		jdfDigitalPrintingParams.setStatus(EnumNodeStatus.Ready);
		jdfDigitalPrintingParams.setID("p0001");
		jdfDigitalPrintingParams.setLocked(false);
		
		JDFComponent jdfComponent = (JDFComponent)jdfResourcePool.appendElementN(ElementName.COMPONENT, 1, null);
		jdfComponent.setID("c0001");
		jdfComponent.setLocked(false);
		Vector<EnumComponentType> componentType = new Vector<EnumComponentType>();
		componentType.add(EnumComponentType.FinalProduct);
		jdfComponent.setComponentType(componentType);
		
		URL url = null;
		URL returnURL = null;
		try {
			
			List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
			PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
			
			url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId); //new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
			InetAddress addr = InetAddress.getLocalHost();
			returnURL = new URL("http://"+addr.getHostAddress()+":8080/Snowmass/IntegrationServlet"); // TODO Fix this too
			JobJDFStatus jdfStatus = new JobJDFStatus();
			jdfStatus.setDeviceId(deviceId);
			job.setJdfStatus(jdfStatus);
			HttpResponse response = submitJDFToDevice(jdfDoc, url, true, returnURL, true);
			handleSubmitQueueEntryResponse(response, job);
			sendSubscriptionRequest(url, returnURL, deviceId, job.getId().toString());
			log.info("Submitting job to Fiery: " + jdfDoc.toXML());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private HttpResponse submitJDFToDevice(JDFDoc theDoc, final URL url,
			final boolean bMime, final URL returnURL, final boolean packageAll) {
		try {
			final JDFDoc jmfDoc = new JDFDoc("JMF");
			final JDFCommand command = jmfDoc.getJMFRoot().appendCommand(org.cip4.jdflib.jmf.JDFMessage.EnumType.SubmitQueueEntry);
			final JDFQueueSubmissionParams qsp = command.appendQueueSubmissionParams();
			qsp.setURL("cid:TheJDF.jdf");
			qsp.setReturnJMF(returnURL);
			
			final Multipart mp = MimeUtil.buildMimePackage(jmfDoc, theDoc, packageAll);
			BodyPart mbp = mp.getBodyPart(1);
			mbp.setHeader("Content-Transfer-Encoding", "8bit");
			final MimeWriter mw = new MimeWriter();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			MimeUtil.writeToStream(mp, bos);
			String sendStr = new String(bos.toByteArray());
			log.info(sendStr);
			HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_MULTIPART_RELATED);
			return NetworkHelper.httpPost(postContent, url.toString(), null);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	public boolean cancelFieryJob(Job job) throws Exception {
		if (job == null) {
			throw new InvalidParameterException("No job passed to cancelFieryJob");
		}
		
		if (job.getJdfStatus() == null) {
			throw new InvalidParameterException("No job submission information found for job in cancelFieryJob");
		}
		
		JobJDFStatus jobStatus = job.getJdfStatus();
		
		String queueId = jobStatus.getQueueId();
		if (queueId == null || queueId.length() == 0) {
			throw new InvalidParameterException("No queue id found for job in cancelFieryJob");			
		}
		
		String deviceId = jobStatus.getDeviceId();
		if (deviceId == null || deviceId.length() == 0) {
			throw new InvalidParameterException("No deviceId found for job in cancelFieryJob");			
		}
		JDFDoc message = JMFMessages.AbortQueueEntry(deviceId, queueId, false);
		String messageStr = message.toXML() + "\n";
		HttpPostContent postContent = new HttpPostContent(messageStr, HttpContentType.CONTENT_TYPE_JMF);
		DataService dataService = new DataService();
		List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
		PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
		URL url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId); //new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
		HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);
		// TODO: Parse the response cleanly here.
		return true;
	}
	private void handleSubmitQueueEntryResponse(HttpResponse response, Job job) {
		if (response.getBody() != null) {
			log.info(response.getBody());
		
			JDFParser parser = new JDFParser();
			JDFDoc responseDoc = parser.parseString(response.getBody());
			JDFJMF responseRoot = responseDoc.getJMFRoot();
			
			if (responseRoot != null) {
				JDFMessage responseMessage = responseRoot.getMessageElement(EnumFamily.Response, JDFMessage.EnumType.SubmitQueueEntry,0);
				if (responseMessage != null) {
					JDFQueueEntry responseQueueEntry = responseMessage.getQueueEntry(0);
					
					if (responseQueueEntry != null) {
						responseQueueEntry.getQueueEntryID();
						
						JobJDFStatus jdfStatus = job.getJdfStatus();
						if (jdfStatus != null) {
							jdfStatus.setQueueId(responseQueueEntry.getQueueEntryID());
							if (responseQueueEntry.getStatus() != null) {
								jdfStatus.setStatus(responseQueueEntry.getStatus().toString());
							} else {
								jdfStatus.setStatus(EnumNodeStatus.Ready.toString());
							}
						}
					}
				}
			}
		}		
	}
	
	public void sendSubscriptionRequest(final URL url, final URL returnURL, String deviceId, String jobId) {
		try {
			JDFDoc subscriptionMsg = JMFMessages.QueryStatusSubscription(deviceId, returnURL.toString(), 30, jobId);
		
			String subscriptionString = subscriptionMsg.toXML() + "\n";
			HttpPostContent postContent = new HttpPostContent(subscriptionString, HttpContentType.CONTENT_TYPE_JMF);
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);
			System.out.println(subscriptionString);
			System.out.println(response.getBody());
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	public void cancelFierySubscription(long jobId) throws Exception {
		try {
//			URL url = new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
//			URL returnURL = new URL("http://10.34.80.80:8080/Snowmass/IntegrationServlet");
			DataService dataService = new DataService();
			Job job = (Job) dataService.getById("Job", jobId);
			if (job == null) {
				throw new InvalidParameterException("No Job found for id: " + jobId);
			}
			
			CopierDefinition copierDefinition = job.getCostingCopier();
			if (copierDefinition == null) {
				throw new InvalidParameterException("No copier definition found in job");
			}
		
			String deviceId = copierDefinition.getOemDeviceID();
			
			List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
			PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);

			URL url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId);
			InetAddress addr = InetAddress.getLocalHost();
			URL returnURL = new URL("http://"+addr.getHostAddress()+":8080/Snowmass/IntegrationServlet"); // TODO Fix this too
			sendSubscriptionCancelation(url, returnURL, deviceId, String.valueOf(jobId));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendSubscriptionCancelation(final URL url, final URL returnURL, String deviceId, String jobId) {
		try {
			JDFDoc subscriptionMsg = JMFMessages.StopPersistentChannel(url.toString(), deviceId, jobId, null);
			String subscriptionString = subscriptionMsg.toXML() + "\n";
			HttpPostContent postContent = new HttpPostContent(subscriptionString, HttpContentType.CONTENT_TYPE_JMF);
     		HttpResponse response = NetworkHelper.httpPost(subscriptionString, url.toString(), null);
			System.out.println(subscriptionString);
			System.out.println(response.getBody());
		} catch (Exception e) {
			log.error(e);
		}
	}
	public Object load(Class clazz, long id) {
		Session session = null;
		Object result;

		try {
			session = DataService.getSession();
			long tStart = new Date().getTime();
			result = session.get(clazz, id);
			long tEnd = new Date().getTime();
			// log.debug("{load()}" +(tEnd-tStart) +"ms class=" +clazz.getName()
			// );

		} catch (HibernateException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} catch (RuntimeException ex) {
			HibernateUtil.rollbackTransaction();
			ex.printStackTrace();
			throw ex;
		} finally {
			session.close();
		}

		return result;
	}
	
	private static String readFileAsString(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = new BufferedInputStream(new FileInputStream(filePath));
	    f.read(buffer);
	    return new String(buffer);
	}

}
