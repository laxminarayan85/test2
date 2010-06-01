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
import javax.mail.internet.MimeBodyPart;

import net.digitalprimates.persistence.hibernate.utils.HibernateUtil;
import net.digitalprimates.persistence.hibernate.utils.services.HibernateService;

import org.apache.commons.codec.binary.Base64;
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
import org.cip4.jdflib.jmf.JDFDeviceInfo;
import org.cip4.jdflib.jmf.JDFJMF;
import org.cip4.jdflib.jmf.JDFMessage;
import org.cip4.jdflib.jmf.JDFQueueEntry;
import org.cip4.jdflib.jmf.JDFMessage.EnumFamily;
import org.cip4.jdflib.jmf.JDFQuery;
import org.cip4.jdflib.jmf.JDFQueueSubmissionParams;
import org.cip4.jdflib.node.JDFNode;
import org.cip4.jdflib.node.JDFNode.EnumActivation;
import org.cip4.jdflib.node.JDFNode.EnumProcessUsage;
import org.cip4.jdflib.node.JDFNode.EnumType;
import org.cip4.jdflib.pool.JDFAuditPool;
import org.cip4.jdflib.pool.JDFResourcePool;
import org.cip4.jdflib.resource.JDFCreated;
import org.cip4.jdflib.resource.JDFDeviceList;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.ComLink;
import com.efi.printsmith.data.DigitalAsset;
import com.efi.printsmith.data.JobJDFStatus;
import com.efi.printsmith.data.PreferencesIntegration;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.StockDefinition;
import com.efi.printsmith.data.Users;
import com.efi.printsmith.integration.jdf.JMFMessages;
import com.efi.printsmith.messaging.MessageServiceAdapter;
import com.efi.printsmith.messaging.MessageTypes;
import com.efi.printsmith.network.HttpContentType;
import com.efi.printsmith.network.HttpPostContent;
import com.efi.printsmith.network.HttpResponse;
import com.efi.printsmith.network.NetworkHelper;
import com.efi.printsmith.pricing.utilities.PriceListUtilities;

import flex.messaging.FlexContext;

public class JDFIntegrationService extends SnowmassHibernateService {
	private Logger log = Logger.getLogger(JDFIntegrationService.class);

	public void sendJobToFiery(long invoiceId, long jobId) throws InvalidParameterException, Exception {
		DataService dataService = new DataService();
				
		Job job = dataService.getJob(jobId);		
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
		
		List<DigitalAsset> assetList = job.getDigitalAssets();
		DigitalAsset asset = null;
		byte[] encodedPDF = null;
		
//		if (assetList != null) {
//			asset = assetList.get(0);
//			String assetDirectoryPath = System.getProperty("com.efi.printsmith.digitalAssetRepository", "./assetRepository");
//		    String s = this.readFileAsString(assetDirectoryPath + "/" + asset.getRepositoryPath());
//		    encodedPDF = Base64.encodeBase64(s.getBytes());
//		}
		
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
		if (acct != null) {
			JDFCustomerInfo jdfCustomerInfo = jdfNode.appendCustomerInfo();
			JDFContact jdfContact = jdfCustomerInfo.appendContact(EnumContactType.Customer);
			jdfContact.setID(acct.getAccountId());
						
			if (contact != null) {
				Address address;
				if ((address = contact.getAddress()) != null) {
					JDFAddress jdfAddress = jdfContact.appendAddress();
					jdfAddress.setCity(address.getCity());
					jdfAddress.setRegion(address.getState());
					jdfAddress.setStreet(address.getStreet1() + " " + address.getStreet2());
					jdfAddress.setPostalCode(address.getZip());				
				}

				JDFPerson jdfPerson = jdfContact.appendPerson();
				jdfPerson.setFirstName(contact.getFirstName());
				jdfPerson.setFamilyName(contact.getLastName());
			}
			JDFCompany jdfCompany = jdfContact.appendCompany();
			jdfCompany.setOrganizationName(acct.getTitle());

			
//			List<ComLink> comLinks = contact.getComLinks();
//			if (comLinks != null) {
//				Iterator<ComLink> iter = comLinks.iterator();
//				
//				while(iter.hasNext()) {
//					ComLink comLink = iter.next();
//					
//					JDFComChannel jdfComChannel = jdfContact.appendComChannel();
//					jdfComChannel.setLocator(comLink.getValue());
//					jdfComChannel.setChannelType(EnumChannelType.Phone);
//
//				}
//			}
		}
		
		JDFNodeInfo jdfNodeInfo = jdfNode.appendNodeInfo();
		jdfNodeInfo.setLastEnd(new JDFDate());
		jdfNodeInfo.setDueLevel(EnumDueLevel.Penalty);
		
		JDFAuditPool jdfAuditPool = jdfNode.getAuditPool();
		if (jdfAuditPool == null) {
			jdfAuditPool = jdfNode.appendAuditPool();
		}
		JDFCreated jdfCreated = jdfAuditPool.addCreated(null,null);
		Users user = (Users) FlexContext.getFlexSession().getAttribute("userInfo");
		if (user != null) {
			jdfCreated.setAuthor(user.getName());
		}
		jdfCreated.setAgentName("Snowmass Digital Press Connector");
		jdfCreated.setAgentVersion("1.0a1");
		jdfCreated.setTimeStamp(new JDFDate());
		
		
		JDFResourcePool jdfResourcePool = jdfNode.getResourcePool();
		if (jdfResourcePool == null) {
			jdfResourcePool = jdfNode.appendResourcePool();
		}
		JDFRunList jdfRunList = (JDFRunList)jdfNode.getCreateResource(ElementName.RUNLIST, EnumUsage.Input, 0);
		jdfRunList.setID("r0001");
		jdfRunList.setStatus(EnumResStatus.Available);
		jdfRunList.setLocked(false);
		JDFResourceLink runListResourceLink = jdfNode.getLink(jdfRunList, null);
//		runListResourceLink.setProcessUsage(EnumProcessUsage.Document);
		String assetDirectoryPath = System.getProperty("com.efi.printsmith.digitalAssetRepository", "./assetRepository");
//		if (assetList != null) {
//		asset = assetList.get(0);
//		String assetDirectoryPath = System.getProperty("com.efi.printsmith.digitalAssetRepository", "./assetRepository");
//	    String s = this.readFileAsString(assetDirectoryPath + "/" + asset.getRepositoryPath());
//	    encodedPDF = Base64.encodeBase64(s.getBytes());
//	}

		if (assetList != null) {
			Iterator<DigitalAsset> assetIter = assetList.iterator();
			int runIndex = 0;
			while (assetIter.hasNext()) {
				asset = assetIter.next();
				InetAddress addr = InetAddress.getLocalHost();
				JDFRunList jdfRun = jdfRunList.addRun("file://" + addr.getHostAddress() + assetDirectoryPath + "/" + asset.getRepositoryPath());//"file://c:/test.jdf");//"cid:PS-0001");
				jdfRun.setRun("0_" + runIndex++);
				jdfRun.setStatus(EnumResStatus.Available);
				jdfRun.setEndOfSet(true);
				jdfRun.setEndOfDocument(true);
				//JDFIntegerRangeList rangeList = new JDFIntegerRangeList();
				jdfRun.setPages(null);				
			}
			
		}
		
		JDFLayoutPreparationParams jdfLayoutPreparationParams = (JDFLayoutPreparationParams)jdfResourcePool.appendElementN(ElementName.LAYOUTPREPARATIONPARAMS, 1, null);
		jdfLayoutPreparationParams.setID("r0002");
		jdfLayoutPreparationParams.setLocked(false);
		jdfLayoutPreparationParams.setStatus(EnumNodeStatus.Ready);
		jdfLayoutPreparationParams.setSides(EnumSides.OneSidedFront);
		JDFMedia jdfMedia = (JDFMedia)jdfResourcePool.appendElementN(ElementName.MEDIA, 1, null);
		jdfMedia.setID("m0001");
//EFI:EFPaperCatalogID=\"19568\"
		jdfMedia.setAttribute("MID", "19568");
		StockDefinition stockDefinition = job.getStock();
		float width = PriceListUtilities.getLengthFromSizeString(job.getFinishSize());
		float length = PriceListUtilities.getLengthFromSizeString(job.getFinishSize());
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
		
		JDFNode processGroup = jdfNode.addJDFNode(EnumType.ProcessGroup);
		processGroup.setActivation(EnumActivation.Active);
		processGroup.setStatus(EnumNodeStatus.Waiting);
		VString processTypes = new VString();
		processTypes.add(EnumType.ResourceDefinition);
		processTypes.add(EnumType.RIPing);
		processTypes.add(EnumType.DigitalPrinting);
		processGroup.setTypes(processTypes);
		processGroup.setJobPartID(job.getId().toString() + job.getJobIndex().toString() + ".2");
		processGroup.setDescriptiveName("Part 2");
		
		JDFResourcePool pgResoucePool = processGroup.appendResourcePool();
		JDFRunList pgRunList = (JDFRunList)processGroup.getCreateResource(ElementName.RUNLIST, EnumUsage.Input, 0);
		pgRunList.setLocked(false);
		pgRunList.setStatus(EnumNodeStatus.Ready);
		if (assetList != null) {
			Iterator<DigitalAsset> assetIter = assetList.iterator();
			int runIndex = 0;
			while (assetIter.hasNext()) {
				asset = assetIter.next();
				InetAddress addr = InetAddress.getLocalHost();
				JDFRunList jdfRun = pgRunList.addRun("file://" + addr.getHostAddress() + "/" + assetDirectoryPath + "/" + asset.getRepositoryPath());//"file://c:/test.jdf");//"cid:PS-0001");
				jdfRun.setRun("0_" + runIndex++);
				jdfRun.setStatus(EnumResStatus.Available);
				jdfRun.setEndOfSet(true);
				jdfRun.setEndOfDocument(true);
				//JDFIntegerRangeList rangeList = new JDFIntegerRangeList();
				jdfRun.setPages(null);				
			}
			
		}
		
		JDFMedia pgJdfMedia = (JDFMedia)pgResoucePool.appendElementN(ElementName.MEDIA, 1, null);
		pgJdfMedia.setAttribute("EFI:EFPaperCatalogID", "19568");
//		pgRunList.setPartIDKeys(new VString().add("Run"));
//		pgResoucePool.
//	      <JDF Status="Waiting" JobPartID="02-007002-00-00" DescriptiveName="Part 2" ID="_3bd11b9e-56c2-4dc2-b274-ce30bd1ed4a8" Type="ProcessGroup" 
//	    	  Types="ResourceDefinition RIPing DigitalPrinting">
//        <ResourcePool>
//          <DigitalPrintingParams ID="r145_1" Class="Parameter" PrintingType="SheetFed" Status="Unavailable"/>
//          <RunList ID="r145" Class="Parameter" Locked="false" Status="Incomplete" PartIDKeys="Run"/>
//          <Media ID="r145_3" MediaType="Paper" Class="Consumable" Status="Unavailable" ProductID="  7002" DescriptiveName="Stock 2" StockType="C1S COVER " Weight="199.702"/>
//          <Component ID="r145_4" Class="Quantity" Status="Unavailable" ComponentType="FinalProduct" DescriptiveName="Digital Printing Output"/>
//        </ResourcePool>
//        <ResourceLinkPool>
//          <DigitalPrintingParamsLink rRef="r145_1" Usage="Input"/>
//          <RunListLink rRef="r145_2" Usage="Input" ProcessUsage="Document"/>
//          <MediaLink rRef="r145_3" Usage="Input" Amount=""/>
//          <ComponentLink rRef="r145_4" Usage="Output" Amount="5500"/>
//        </ResourceLinkPool>
//      </JDF>

		URL url = null;
		URL returnURL = null;
		try {
			
			List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
			PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
			
			url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId); //new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
			InetAddress addr = InetAddress.getLocalHost();
			returnURL = new URL("http://"+addr.getHostAddress()+":8080/Snowmass/JDFIntegrationServlet"); // TODO Fix this too
			JobJDFStatus jdfStatus = new JobJDFStatus();
			jdfStatus.setDeviceId(deviceId);
			job.setJdfStatus(jdfStatus);
			log.info("Submitting job to Fiery: " + jdfDoc.toXML());
			HttpResponse response = submitJDFToDevice(jdfDoc, url, true, returnURL, true, encodedPDF);
			if (handleSubmitQueueEntryResponse(response, job) == 200) {
				sendSubscriptionRequest(url, returnURL, deviceId, job.getId().toString());
			} else {
				handleCommFailure(response,job);
			}
			addJDFQueueEntry(deviceId, job.getId(), jdfDoc.toXML(), "SubmitQueueEntry", jdfStatus.getStatus(), url.toString());
			dataService.addUpdate(job);
			MessageServiceAdapter.sendNotification(MessageTypes.JDFSTATUS, job.getId().toString(), job.getJdfStatus());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addJDFQueueEntry(String deviceId, Long jobId, String message, String msgType, String status, String url) {
		com.efi.printsmith.data.JDFQueueEntry jdfQueueEntry = new com.efi.printsmith.data.JDFQueueEntry();
		jdfQueueEntry.setDeviceId(deviceId);
		jdfQueueEntry.setJobid(jobId);
		if (message.length() > 250) {
			jdfQueueEntry.setMessage(message.substring(0,250));
		} else {
			jdfQueueEntry.setMessage(message);
		}
		jdfQueueEntry.setMsgType(msgType);
		jdfQueueEntry.setStatus(status);
		jdfQueueEntry.setUrl(url);
		jdfQueueEntry.setSent(new Date());
		DataService dataService = new DataService();
		try {
			dataService.addUpdate(jdfQueueEntry);
		} catch (Exception e) {
			log.error(e);
		}
	}
	private HttpResponse submitJDFToDevice(JDFDoc theDoc, final URL url,
			final boolean bMime, final URL returnURL, final boolean packageAll, byte[] encodedPDF) {
		try {
			final JDFDoc jmfDoc = new JDFDoc("JMF");
			final JDFCommand command = jmfDoc.getJMFRoot().appendCommand(org.cip4.jdflib.jmf.JDFMessage.EnumType.SubmitQueueEntry);
			final JDFQueueSubmissionParams qsp = command.appendQueueSubmissionParams();
			qsp.setURL("cid:PS-0001");
			qsp.setReturnJMF(returnURL);
			
//			theDoc = JDFDoc.parseFile("/Users/bknabel/submit.jdf");
			final Multipart mp = MimeUtil.buildMimePackage(jmfDoc, theDoc, packageAll);
			BodyPart mbp = mp.getBodyPart(1);
			mbp.setHeader("Content-Transfer-Encoding", "8bit");
			
			if (encodedPDF != null) {
				MimeBodyPart bp = new MimeBodyPart();
				bp.setContent(new String(encodedPDF), "application/pdf");
				bp.setHeader("Content-Transfer-Encoding", "base64");
				bp.setHeader("Content-ID","<PS-0001>");
				mp.addBodyPart(bp);
			}
			
			final MimeWriter mw = new MimeWriter();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			MimeUtil.writeToStream(mp, bos);
			String sendStr = new String(bos.toByteArray());
//			
//			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\r<JDF xmlns=\"http://www.CIP4.org/JDFSchema_1_1\" " +
//					"DescriptiveName=\"B&amp;W\" ID=\"n_100531_181154647_000000\" JobID=\"16115\" JobPartID=\"161150\" Status=\"Ready\" Type=\"ProcessGroup\" " +
//					"Version=\"1.3\" xmlns:EFI=\"http://www.efi.com/efijdf\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ProcessGroup\">\r\r  " +
//					"<AuditPool>\r    <Created AgentName=\"CIP4 JDF Writer Java\" AgentVersion=\"1.4a BLD 61\" ID=\"a_100531_181154895_000001\" " +
//					"TimeStamp=\"2010-05-31T18:11:54-04:00\"/>\r    <Created AgentName=\"Snowmass Digital Press Connector\" AgentVersion=\"1.0a1\" " +
//					"Author=\"Brad Knabel\" ID=\"a_100531_18115531_000004\" TimeStamp=\"2010-05-31T18:11:55-04:00\"/>\r  </AuditPool>" +
//					"\r\r  \r  \r  \r  \r\r<!--Generated by the CIP4 Java open source JDF Library version : CIP4 JDF Writer Java 1.4a BLD 61-->\r\r  <ResourcePool>\r    " +
//					"<CustomerInfo Class=\"Parameter\" ID=\"r_100531_181154969_000002\" PartUsage=\"Implicit\" Status=\"Available\">\r      <Contact Class=\"Parameter\" " +
//					"ContactTypes=\"Customer\" ID=\"1\">\r        <Address City=\"Denver\" Class=\"Parameter\" PostalCode=\"80205\" " +
//					"Region=\"CO\" Street=\"2242 High St.\"/>\r        <Person Class=\"Parameter\" FamilyName=\"Knabel\" FirstName=\"Brad\"/>\r        " +
//					"<Company Class=\"Parameter\" OrganizationName=\"EFI\"/>\r        <ComChannel ChannelType=\"Phone\" Class=\"Parameter\" Locator=\"412-979-7347\"/>\r      " +
//					"</Contact>\r    </CustomerInfo>\r    <NodeInfo Class=\"Parameter\" DueLevel=\"Penalty\" ID=\"r_100531_18115530_000003\" LastEnd=\"2010-05-31T18:11:55-04:00\" " +
//					"PartUsage=\"Implicit\" Status=\"Available\"/>\r    <RunList Class=\"Parameter\" ID=\"r0001\" PartIDKeys=\"Run\" Status=\"Available\">\r      " +
//					"<RunList EndOfDocument=\"true\" EndOfSet=\"true\" Run=\"0_1\" Status=\"Available\">\r        <LayoutElement Class=\"Parameter\">\r          " +
//					"<FileSpec Class=\"Parameter\" MimeType=\"application/vnd.cip4-jdf+xml\" URL=\"file://c:/test.jdf\"/>\r        </LayoutElement>\r      " +
//					"</RunList>\r    </RunList>\r    <LayoutPreparationParams Class=\"Parameter\" ID=\"r0002\" Sides=\"OneSidedFront\" Status=\"Ready\"/>\r   " +
//					" <Media Class=\"Consumable\" Dimension=\"11 11\" ID=\"m0001\" MediaType=\"Paper\" ProductID=\"174040\" Status=\"Ready\" StockType=\" \"/>\r    " +
//					"<DigitalPrintingParams Class=\"Parameter\" ID=\"p0001\" Status=\"Ready\">\r      <Media Class=\"Consumable\"/>\r    </DigitalPrintingParams>\r   " +
//					" <Component Class=\"Quantity\" ComponentType=\"FinalProduct\" ID=\"c0001\" Status=\"Unavailable\"/>\r  </ResourcePool>\r\r  " +
//					"<ResourceLinkPool>\r    <CustomerInfoLink CombinedProcessIndex=\"0 1 2\" Usage=\"Input\" rRef=\"r_100531_181154969_000002\"/>\r    " +
//					"<NodeInfoLink Usage=\"Input\" rRef=\"r_100531_18115530_000003\"/>\r    <RunListLink CombinedProcessIndex=\"1 2\" Usage=\"Input\" " +
//					"rRef=\"r_100531_18115555_000005\"/>\r  </ResourceLinkPool>\r\r  <JDF Activation=\"Active\" DescriptiveName=\"Part 2\" ID=\"n_100531_181155246_000011\" " +
//					"JobPartID=\"161150.2\" Status=\"Waiting\" Type=\"ProcessGroup\" xsi:type=\"ProcessGroup\">\r    <AuditPool>\r     " +
//					" <Created AgentName=\"CIP4 JDF Writer Java\" AgentVersion=\"1.4a BLD 61\" ID=\"a_100531_181155246_000012\" " +
//					"TimeStamp=\"2010-05-31T18:11:55-04:00\"/>\r    </AuditPool>\r    <ResourcePool>\r      <RunList Class=\"Parameter\" " +
//					"ID=\"r_100531_181155247_000013\" PartIDKeys=\"Run\" Status=\"Ready\">\r        <RunList EndOfDocument=\"true\" EndOfSet=\"true\" " +
//					"NPage=\"16\" Run=\"Run1275326370\">\r          <LayoutElement>\r            <FileSpec URL=\"file://C:/test.pdf\"/>\r          " +
//					"</LayoutElement>\r        </RunList>\r      </RunList>\r    </ResourcePool>\r    <ResourceLinkPool>\r      <RunListLink CombinedProcessIndex=\"1 2\" " +
//					"Usage=\"Input\" rRef=\"r_100531_181155247_000013\"/>\r    </ResourceLinkPool>\r    <JDF Activation=\"Active\" ID=\"n100531181200_1243\" " +
//					"JobPartID=\"161150.2.1\" Status=\"Ready\" Type=\"Combined\" Types=\"LayoutPreparation Imposition Interpreting Rendering DigitalPrinting\" " +
//					"xsi:type=\"Combined\">\r      <ResourceLinkPool>\r        <RunListLink CombinedProcessIndex=\"0 1\" Usage=\"Input\" rRef=\"r_100531_181155247_000013\"/>\r        " +
//					"<LayoutPreparationParamsLink CombinedProcessIndex=\"0\" Usage=\"Input\" rRef=\"r100531181200_1244\"/>\r        " +
//					"<ColorantControlLink CombinedProcessIndex=\"2\" Usage=\"Input\" rRef=\"r100531181200_1245\"/>\r        " +
//					"<RenderingParamsLink CombinedProcessIndex=\"3\" Usage=\"Input\" rRef=\"r100531181200_1246\"/>\r        " +
//					"<DigitalPrintingParamsLink CombinedProcessIndex=\"4\" Usage=\"Input\" rRef=\"r100531181200_1247\"/>\r        " +
//					"<ComponentLink Amount=\"1\" ProcessUsage=\"Waste\" Usage=\"Output\" rRef=\"r100531181200_1248\"/>\r        " +
//					"<MediaLink Usage=\"Input\" rRef=\"r100531182014_1832\"/></ResourceLinkPool>\r      <ResourcePool>\r        " +
//					"<LayoutPreparationParams Class=\"Parameter\" ID=\"r100531181200_1244\" Status=\"Available\"/>\r        " +
//					"<ColorantControl Class=\"Parameter\" ID=\"r100531181200_1245\" Status=\"Available\"/>\r        " +
//					"<RenderingParams Class=\"Parameter\" ID=\"r100531181200_1246\" Status=\"Available\"/>\r        " +
//					"<DigitalPrintingParams Class=\"Parameter\" ID=\"r100531181200_1247\" Status=\"Available\"/>\r        " +
//					"<Component Class=\"Quantity\" ID=\"r100531181200_1248\" Status=\"Unavailable\"/>\r        " +
//					"<Media BackCoatings=\"None\" Brand=\"Glatfelter Xcelerator Digital Carbonless 174040 8 1/2&quot; x 11&quot; 83 gsm White, Canary &amp; Pink 3-Part forward\" DescriptiveName=\"NCR Letter 3-Part\" Dimension=\"612 792\" EFI:EFPaperCatalogID=\"19568\" FeedDirection=\"LEF\" FrontCoatings=\"None\" GrainDirection=\"LongEdge\" HoleType=\"None\" ID=\"r100531182014_1832\" MID=\"19568\" MediaColorName=\"MultiColor\" MediaColorNameDetails=\"White, Pink, Canary\" MediaType=\"Paper\" MediaTypeDetails=\"MultiPartForm\" MediaUnit=\"Sheet\" Opacity=\"Opaque\" PrePrinted=\"false\" PrintingTechnology=\"Laser\" ProductID=\"174040\" RecycledPercentage=\"0\" Texture=\"Smooth\" Thickness=\"102\" Weight=\"83\"></Media></ResourcePool>\r      <AuditPool>\r        <Created AgentName=\"EFI JDF Connector\" AgentVersion=\"1.8.0.21\" Author=\"DP Process Node From Process Group Resources\" ID=\"a100531181200_1249\" TimeStamp=\"2010-05-31T18:12:00-04:00\"/>\r        <PhaseTime AgentName=\"EFI JDF Connector\" AgentVersion=\"1.8.0.21\" DescriptiveName=\"Modified Media Resource\" End=\"2010-05-31T18:12:00-04:00\" ID=\"_4dfba529-f6a1-4df1-a55e-c58695a000fc\" Start=\"2010-05-31T18:12:00-04:00\" Status=\"Setup\" TimeStamp=\"2010-05-31T18:12:00-04:00\">\r          <Device DeviceID=\"SERVER-D9XWFR4E\"/>\r        </PhaseTime>\r        <Notification AgentName=\"EFI JDF Connector\" AgentVersion=\"1.8.0.21\" Class=\"Error\" ID=\"a100531181201_2624\" TimeStamp=\"2010-05-31T18:12:01-04:00\">\r          <Comment>Job Not Eligible for Auto-Submit:The Run List in the Digital Printing Node is not complete\rProblem getting runs list details</Comment>\r        </Notification>\r        <Notification AgentName=\"EFI JDF Connector\" AgentVersion=\"1.8.0.21\" Class=\"Warning\" ID=\"a100531181201_2625\" TimeStamp=\"2010-05-31T18:12:01-04:00\">\r          <Comment>The Run List in the Digital Printing Node is not complete\r\r</Comment>\r        </Notification>\r        <PhaseTime AgentName=\"Fiery JDF Connector\" AgentVersion=\"1.8.0.21\" Author=\"\" DescriptiveName=\"Modified RunList Resource\" End=\"2010-05-31T18:19:47-04:00\" ID=\"_26340024-ea35-417b-a35a-e53b814a0cb6\" Start=\"2010-05-31T18:19:30-04:00\" Status=\"Setup\" TimeStamp=\"2010-05-31T18:19:47-04:00\">\r          <Device DeviceID=\"SERVER-D9XWFR4E\"/>\r        </PhaseTime>\r        <ResourceAudit AgentName=\"Fiery JDF Connector UI\" AgentVersion=\"1.8.0.21\" ContentsModified=\"true\" ID=\"a100531181947_2435\" TimeStamp=\"2010-05-31T18:19:47-04:00\">\r          <RunListLink Usage=\"Input\" rRef=\"r_100531_181155247_000013\"/>\r        </ResourceAudit>\r      </AuditPool>\r    </JDF>\r    <JDF Activation=\"Active\" ID=\"n100531181200_0947\" JobPartID=\"161150.2.2\" Status=\"Ready\" Type=\"ResourceDefinition\" xsi:type=\"ResourceDefinition\">\r      <AuditPool>\r        <Created AgentName=\"CIP4 JDF Writer C++\" AgentVersion=\"2.1.5BLD074\" Author=\"Resource Definition Node From Process Group\" ID=\"a100531181200_0948\" TimeStamp=\"2010-05-31T18:12:00-04:00\"/>\r        <Created AgentName=\"EFI JDF Connector\" AgentVersion=\"1.8.0.21\" Author=\"DP Process Node From Process Group Resources\" ID=\"a100531181200_0949\" " +
//					"TimeStamp=\"2010-05-31T18:12:00-04:00\"/>\r      </AuditPool>\r    </JDF>\r  </JDF></JDF>\r"+
//					"\r\r</JMF>";
			
			
			
			
			
			
			
			
			System.out.println(sendStr);
			log.info(sendStr);
			HttpPostContent postContent = new HttpPostContent(sendStr, HttpContentType.CONTENT_TYPE_MULTIPART_RELATED);
			return NetworkHelper.httpPost(postContent, url.toString(), null);
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	public boolean cancelFieryJob(long jobId) throws Exception {
		DataService dataService = new DataService();
		Job job =(Job)dataService.getById("Job", jobId);
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
		List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
		PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
		URL url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId); //new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
		HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);
		
		if (response.getStatusCode() == 200) {
			message = JMFMessages.RemoveQueueEntry(deviceId, queueId, false);
			messageStr = message.toXML() + "\n";
			postContent = new HttpPostContent(messageStr, HttpContentType.CONTENT_TYPE_JMF);
			response = NetworkHelper.httpPost(postContent, url.toString(), null);
		}
		addJDFQueueEntry(deviceId, job.getId(), message.toXML(), "AbortQueueEntry", jobStatus.getStatus(), url.toString());
		// TODO: Parse the response cleanly here.
		return true;
	}
	
	public List<String> getDeviceIds() throws Exception {
		try {
			String test = JMFMessages.Test();
			
			JDFDoc message = JMFMessages.QueryKnownDevices();
		
			String messageString = message.toXML() + "\n";
			HttpPostContent postContent = new HttpPostContent(messageString, HttpContentType.CONTENT_TYPE_JMF);
			DataService dataService = new DataService();
			List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
			PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
			URL url = new URL(integrationPreferences.getFieryConnectorURL());		
			HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);
			System.out.println(messageString);
			System.out.println(response.getBody());
			return (handleQueryKnownDevicesResponse(response));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}
	
	private List<String> handleQueryKnownDevicesResponse(HttpResponse response) {
		List<String> devices = new ArrayList<String>();
		if (response.getBody() != null) {
			log.info(response.getBody());
		
			JDFParser parser = new JDFParser();
			JDFDoc responseDoc = parser.parseString(response.getBody());
			JDFJMF responseRoot = responseDoc.getJMFRoot();
			
			if (responseRoot != null) {
				JDFMessage responseMessage = responseRoot.getMessageElement(EnumFamily.Response, JDFMessage.EnumType.KnownDevices,0);
				if (responseMessage != null) {
					JDFDeviceList deviceList = responseMessage.getDeviceList(0);
					if (deviceList != null) {
						Collection<JDFDeviceInfo> deviceInfoList = deviceList.getAllDeviceInfo();
						if (deviceInfoList != null) {
							Iterator deviceIter = deviceInfoList.iterator();
							while(deviceIter.hasNext()) {
								JDFDeviceInfo deviceInfo = (JDFDeviceInfo)deviceIter.next();
								if (deviceInfo != null) {
									String deviceId = deviceInfo.getDeviceID();
									if (deviceId != null && deviceId.length() > 0) {
										devices.add(deviceId);
									}
								}
							}

						}
					}
				}
			}
		}		
		return devices;
	}

	public boolean resend(com.efi.printsmith.data.JDFQueueEntry entry)  throws Exception {
		if (entry.getJobid() != 0) {
			if (entry.getMsgType().equals("SubmitQueueEntry")) {
				DataService dataService = new DataService();
				Job job = (Job) dataService.getById("Job", entry.getJobid());
				if (job.getParentInvoice() == null) {
					throw new InvalidParameterException("Job has no parent Invoice");
				}
				this.sendJobToFiery(job.getParentInvoice().getId(), entry.getJobid());
			}
			
		}
		return true;
	}
	
	public boolean pauseFieryJob(long jobId) throws Exception {
		DataService dataService = new DataService();
		Job job =(Job)dataService.getById("Job", jobId);
		
		if (job == null) {
			throw new InvalidParameterException("No job passed to pauseFieryJob");
		}
		
		if (job.getJdfStatus() == null) {
			throw new InvalidParameterException("No job submission information found for job in pauseFieryJob");
		}
		
		JobJDFStatus jobStatus = job.getJdfStatus();
		
		String queueId = jobStatus.getQueueId();
		if (queueId == null || queueId.length() == 0) {
			throw new InvalidParameterException("No queue id found for job in pauseFieryJob");			
		}
		
		String deviceId = jobStatus.getDeviceId();
		if (deviceId == null || deviceId.length() == 0) {
			throw new InvalidParameterException("No deviceId found for job in pauseFieryJob");			
		}
		JDFDoc message = JMFMessages.HoldQueueEntry(deviceId, queueId, false);
		String messageStr = message.toXML() + "\n";
		HttpPostContent postContent = new HttpPostContent(messageStr, HttpContentType.CONTENT_TYPE_JMF);
		List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
		PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);
		URL url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId); //new URL("http://10.34.80.228:8010/FJC/SERVER-D9XWFR4E");
		HttpResponse response = NetworkHelper.httpPost(postContent, url.toString(), null);
		addJDFQueueEntry(deviceId, job.getId(), message.toXML(), "HoldQueueEntry", jobStatus.getStatus(), url.toString());
		MessageServiceAdapter.sendNotification(MessageTypes.JDFSTATUS, job.getId().toString(), job.getJdfStatus());
		// TODO: Parse the response cleanly here.
		return true;
	}
	
	private void handleCommFailure(HttpResponse response, Job job) {
		JobJDFStatus jdfStatus = job.getJdfStatus();
		if (jdfStatus != null) {
			jdfStatus.setQueueId("None");
			jdfStatus.setStatus("Communication Error");
		}	
	}
	
	private int handleSubmitQueueEntryResponse(HttpResponse response, Job job) {
		if (response.getBody() != null) {
			log.info(response.getBody());
		
			JDFParser parser = new JDFParser();
			if (response.getStatusCode() != 200) return response.getStatusCode();
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
							jdfStatus.setDeviceId(job.getPricingCopier().getOemDeviceID());
							if (responseQueueEntry.getStatus() != null) {
								jdfStatus.setStatus(responseQueueEntry.getStatus().getName());
							} else {
								jdfStatus.setStatus(EnumNodeStatus.Ready.getName());
							}
						}
					}
				}
			}
		}		
		return response.getStatusCode();
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
//			URL returnURL = new URL("http://10.34.80.80:8080/Snowmass/JDFIntegrationServlet");
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
			URL returnURL = new URL("http://"+addr.getHostAddress()+":8080/Snowmass/JDFIntegrationServlet"); // TODO Fix this too
			sendSubscriptionCancelation(url, returnURL, deviceId, String.valueOf(jobId));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void queryJobStatus(long jobId) throws Exception {
		try {
			DataService dataService = new DataService();
			Job job = (Job) dataService.getById("Job", jobId);
			if (job == null) {
				throw new InvalidParameterException("No Job found for id: " + jobId);
			}
			
			CopierDefinition copierDefinition = job.getCostingCopier();
			if (copierDefinition == null) {
				throw new InvalidParameterException("No copier definition found in job");
			}
		
			JobJDFStatus jdfStatus = job.getJdfStatus();
			String queueId = jdfStatus.getQueueId();
			
			String deviceId = copierDefinition.getOemDeviceID();
			
			List<PreferencesIntegration> integrationPreferenceList = (List<PreferencesIntegration>) dataService.getAll("PreferencesIntegration"); //TODO: Fix this Paulism
			PreferencesIntegration integrationPreferences = integrationPreferenceList.get(0);

			URL url = new URL(integrationPreferences.getFieryConnectorURL() + "/" + deviceId);
			InetAddress addr = InetAddress.getLocalHost();
			URL returnURL = new URL("http://"+addr.getHostAddress()+":8080/Snowmass/JDFIntegrationServlet"); // TODO Fix this too
			sendQueryJobStatus(url, returnURL, deviceId, queueId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private void sendQueryJobStatus(final URL url, final URL returnURL, String deviceId, String queueId) {
		try {
			
			JDFDoc subscriptionMsg = JMFMessages.QueryQueueEntryStatus(deviceId, queueId);
			String subscriptionString = subscriptionMsg.toXML() + "\n";
			HttpPostContent postContent = new HttpPostContent(subscriptionString, HttpContentType.CONTENT_TYPE_JMF);
     		HttpResponse response = NetworkHelper.httpPost(subscriptionString, url.toString(), null);
			System.out.println(subscriptionString);
			System.out.println(response.getBody());
		} catch (Exception e) {
			log.error(e);
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
	

	private String readFileAsString(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = new BufferedInputStream(new FileInputStream(filePath));
	    f.read(buffer);
	    return new String(buffer);
	}

}
