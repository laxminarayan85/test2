package com.efi.printsmith.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;

import javax.mail.Multipart;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.cip4.jdflib.auto.JDFAutoComponent.EnumComponentType;
import org.cip4.jdflib.auto.JDFAutoLayoutPreparationParams.EnumSides;
import org.cip4.jdflib.auto.JDFAutoMedia.EnumMediaType;
import org.cip4.jdflib.auto.JDFAutoNodeInfo.EnumDueLevel;
import org.cip4.jdflib.auto.JDFAutoComChannel.EnumChannelType;
import org.cip4.jdflib.core.ElementName;
import org.cip4.jdflib.core.JDFCustomerInfo;
import org.cip4.jdflib.core.JDFDoc;
import org.cip4.jdflib.core.KElement;
import org.cip4.jdflib.core.JDFElement.EnumVersion;
import org.cip4.jdflib.core.JDFNodeInfo;
import org.cip4.jdflib.core.JDFElement.EnumNodeStatus;
import org.cip4.jdflib.core.VString;
import org.cip4.jdflib.datatypes.JDFXYPair;
import org.cip4.jdflib.jmf.JDFCommand;
import org.cip4.jdflib.jmf.JDFQueueSubmissionParams;
import org.cip4.jdflib.node.JDFNode;
import org.cip4.jdflib.node.JDFNode.EnumType;
import org.cip4.jdflib.pool.JDFAuditPool;
import org.cip4.jdflib.pool.JDFResourcePool;
import org.cip4.jdflib.resource.JDFCreated;
import org.cip4.jdflib.resource.JDFLayoutPreparationParams;
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
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import java.util.Date;
import java.util.Vector;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.network.HttpPostContent;
import com.efi.printsmith.network.HttpResponse;
import com.efi.printsmith.network.NetworkHelper;

public class JDFIntegrationService extends HibernateService {
	private Logger log = Logger.getLogger(JDFIntegrationService.class);

	public void sendJobToFiery(long invoiceId, long jobId) throws InvalidParameterException, Exception {
		DataService dataService = new DataService();
				
		Job job = (Job) dataService.getById("Job", jobId);
		Invoice invoice = (Invoice) dataService.getById("Invoice", invoiceId);
		
		CopierDefinition copierDefinition = job.getCostingCopier();
		if (job == null) {
			throw new InvalidParameterException("No Job found for id: " + jobId);
		}
		
		if (invoice == null) {
			throw new InvalidParameterException("No Invoice found for id: " + invoiceId);
		}
		
//		if (copierDefinition == null) {
//			throw new InvalidParameterException("No copier definition found in job");
//		}
//				
//		if (!copierDefinition.getIntegratedDevice()) {
//			throw new InvalidParameterException("Copier definition is not an integrated digital press");
//		}
//				
//		if (copierDefinition.getOemDeviceID() == null || copierDefinition.getOemDeviceID().length() == 0) {
//			throw new InvalidParameterException("Copier definition does not contain a valid OEM Device ID. Unable to send job to undefined device.");
//		}
		
		copierDefinition = (CopierDefinition) dataService.getById("CopierDefinition", copierDefinition.getId());
		
		JDFDoc jdfDoc = new JDFDoc("JDF");
		JDFNode jdfNode = jdfDoc.getJDFRoot();
		if (job.getDescription() != null) {
			jdfNode.setDescriptiveName(job.getDescription());
		} else {
			jdfNode.setDescriptiveName(job.getPricingMethod().toString());
		}
		jdfNode.setJobID(job.getJobNumber());
		jdfNode.setJobPartID(job.getJobNumber() + job.getJobIndex().toString());
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
		JDFRunList jdfRunList = (JDFRunList)jdfResourcePool.appendElementN(ElementName.RUNLIST, 1, null);
		jdfRunList.setID("r0001");
		jdfRunList.setNPage(1);
		jdfRunList.setLocked(false);
		JDFLayoutPreparationParams jdfLayoutPreparationParams = (JDFLayoutPreparationParams)jdfResourcePool.appendElementN(ElementName.LAYOUTPREPARATIONPARAMS, 1, null);
		jdfLayoutPreparationParams.setID("r0002");
		jdfLayoutPreparationParams.setLocked(false);
		jdfLayoutPreparationParams.setStatus(EnumNodeStatus.Ready);
		jdfLayoutPreparationParams.setSides(EnumSides.OneSidedFront);
		JDFMedia jdfMedia = (JDFMedia)jdfResourcePool.appendElementN(ElementName.MEDIA, 1, null);
		jdfMedia.setID("m0001");
		jdfMedia.setDimension(new JDFXYPair());
		jdfMedia.setMediaType(EnumMediaType.Paper);
		jdfMedia.setStatus(EnumNodeStatus.Ready);
		jdfMedia.setProductID("0");
		jdfMedia.setStockType(" ");
		
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
			url = new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
			returnURL = new URL("http://10.34.80.80:8080");
			submitJDFToDevice(jdfDoc, url, true, returnURL, true);
			System.out.println(jdfDoc.toXML());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean submitJDFToDevice(JDFDoc theDoc, final URL url,
			final boolean bMime, final URL returnURL, final boolean packageAll) {
		boolean bSendTrue = false;

		try {
//			HttpClient client = new HttpClient();
//
//			client.getHostConfiguration().setHost(url.getHost(), url.getPort(),
//					url.getProtocol());
//
			String sendStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r<JMF xmlns=\"http://www.CIP4.org/JDFSchema_1_1\" MaxVersion=\"1.3\" SenderID=\"New Value\" TimeStamp=\"2008-06-02T07:05:17-04:00\" Version=\"1.3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"JMFRootMessage\">\r<!--Generated by the CIP4 Java open source JDF Library version : CIP4 JDF Writer Java 1.3 BLD 48-->\r<Command ID=\"m.NewValue.080602_070535882_000000\" Type=\"SubmitQueueEntry\">\r <QueueSubmissionParams URL=\"file://c:/test.jdf\"/>\r</Command>\r</JMF>\r";
//
//			PostMethod method = new PostMethod(url.toString());
//			HttpPostContent content = new HttpPostContent(sendStr);
//			method.setRequestBody(content.getInputStream());
//			client.executeMethod(method);
//			InputStream in = method.getResponseBodyAsStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}

			 HttpResponse response = NetworkHelper.httpPost(sendStr, url.toString(), null);
			 URLConnection conn = url.openConnection();
			 conn.setReadTimeout(30000);
			 conn.setDoOutput(true);
			 OutputStreamWriter owr = new
			 OutputStreamWriter(conn.getOutputStream());
			 owr.write(sendStr);
			 owr.flush();
						
			 BufferedReader rd = new BufferedReader(new
			 InputStreamReader(conn.getInputStream()));
			 String line;
			 while ((line = rd.readLine()) != null) {
			 System.out.println(line);
			 }
			 owr.close();
			 rd.close();
		} catch (IOException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}

		// final JDFDoc jmfDoc = new JDFDoc("JMF");
		// final JDFCommand command =
		// jmfDoc.getJMFRoot().appendCommand(org.cip4.jdflib.jmf.JDFMessage.EnumType.SubmitQueueEntry);
		// final JDFQueueSubmissionParams qsp =
		// command.appendQueueSubmissionParams();
		// if (returnURL != null)
		// {
		// qsp.setReturnJMF(returnURL);
		// }
		// int rc = -2;
		// String message = "Snafu";
		//		
		// HttpURLConnection uc = null;
		// try
		// {
		// final KElement root = theDoc.getRoot();
		// if (root == null)
		// {
		// return false;
		// }
		// // updateJobID(root);
		// if (bMime)
		// {
		// qsp.setURL("dummy");
		// final Multipart mp = MimeUtil.buildMimePackage(jmfDoc, theDoc,
		// packageAll);
		// uc = MimeUtil.writeToURL(mp, url.toExternalForm());
		// System.out.println(uc.toString());
		// }
		// else
		// {
		// uc = jmfDoc.write2HTTPURL(url, null);
		// }
		// if (uc != null)
		// {
		// rc = uc.getResponseCode();
		// message = uc.getResponseMessage();
		// }
		// bSendTrue = rc == 200;
		// // if (bSendTrue)
		// // createResponse(uc);
		// }
		// catch (final Exception x)
		// {
		// bSendTrue = false;
		// }

		return bSendTrue;
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
}
