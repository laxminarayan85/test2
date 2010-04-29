package com.efi.printsmith.service;

import java.security.InvalidParameterException;

import org.cip4.jdflib.auto.JDFAutoMedia.EnumMediaType;
import org.cip4.jdflib.auto.JDFAutoNodeInfo.EnumDueLevel;
import org.cip4.jdflib.auto.JDFAutoComChannel.EnumChannelType;
import org.cip4.jdflib.core.ElementName;
import org.cip4.jdflib.core.JDFCustomerInfo;
import org.cip4.jdflib.core.JDFDoc;
import org.cip4.jdflib.core.JDFElement.EnumVersion;
import org.cip4.jdflib.core.JDFNodeInfo;
import org.cip4.jdflib.core.JDFElement.EnumNodeStatus;
import org.cip4.jdflib.core.VString;
import org.cip4.jdflib.datatypes.JDFXYPair;
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

import com.efi.printsmith.data.CopierDefinition;
import com.efi.printsmith.data.Job;

public class JDFIntegrationService {
	public void sendJobToFiery(Job job) throws InvalidParameterException {
		CopierDefinition copierDefinition = job.getCostingCopier();
		
		if (copierDefinition == null) {
			throw new InvalidParameterException("No copier definition found in job");
		}
		
		if (!copierDefinition.getIntegratedDevice()) {
			throw new InvalidParameterException("Copier definition is not an integrated digital press");
		}
		
		if (copierDefinition.getOemDeviceID() == null || copierDefinition.getOemDeviceID().length() == 0) {
			throw new InvalidParameterException("Copier definition does not contain a valid OEM Device ID. Unable to send job to undefined device.");
		}
		
		JDFDoc jdfDoc = new JDFDoc();
		
		JDFNode jdfNode = jdfDoc.getJDFRoot();
		jdfNode.setDescriptiveName("");
		jdfNode.setJobID("");
		jdfNode.setJobPartID("");
		jdfNode.setType(EnumType.ProcessGroup);
		jdfNode.setTypes(new VString());
		jdfNode.setStatus(EnumNodeStatus.Ready);
		jdfNode.setVersion(EnumVersion.Version_1_3);
		jdfNode.addNameSpace("EFI", "http://www.efi.com/efijdf");
		
		JDFCustomerInfo jdfCustomerInfo = jdfNode.appendCustomerInfo();
		JDFContact jdfContact = jdfCustomerInfo.appendContact(EnumContactType.Customer);
		jdfContact.setID("");
		
		JDFAddress jdfAddress = jdfContact.appendAddress();
		jdfAddress.setCity("");
		jdfAddress.setRegion("");
		jdfAddress.setStreet("");
		jdfAddress.setPostalCode("");
		
		JDFPerson jdfPerson = jdfContact.appendPerson();
		jdfPerson.setFirstName("");
		jdfPerson.setFamilyName("");
		
		JDFCompany jdfCompany = jdfContact.appendCompany();
		jdfCompany.setOrganizationName("");
		
		JDFComChannel jdfComChannel = jdfContact.appendComChannel();
		jdfComChannel.setLocator("");
		jdfComChannel.setChannelType(EnumChannelType.Phone);
		
		JDFNodeInfo jdfNodeInfo = jdfNode.appendNodeInfo();
		jdfNodeInfo.setLastEnd(new JDFDate());
		jdfNodeInfo.setDueLevel(EnumDueLevel.Penalty);
		
		JDFAuditPool jdfAuditPool = jdfNode.appendAuditPool();
		JDFCreated jdfCreated = jdfAuditPool.addCreated(null,null);
		jdfCreated.setAuthor("");
		jdfCreated.setAgentName("");
		jdfCreated.setAgentVersion("");
		jdfCreated.setTimeStamp(new JDFDate());
		
		JDFResourcePool jdfResourcePool = jdfNode.appendResourcePool();
		JDFRunList jdfRunList = (JDFRunList)jdfResourcePool.appendElementN(ElementName.RUNLIST, 1, null);
		
		JDFLayoutPreparationParams jdfLayoutPreparationParams = (JDFLayoutPreparationParams)jdfResourcePool.appendElementN(ElementName.LAYOUTPREPARATIONPARAMS, 1, null);

		JDFMedia jdfMedia = (JDFMedia)jdfResourcePool.appendElementN(ElementName.MEDIA, 1, null);
		jdfMedia.setID("");
		jdfMedia.setDimension(new JDFXYPair());
		jdfMedia.setMediaType(EnumMediaType.Paper);
		jdfMedia.setStatus(EnumNodeStatus.Ready);
		
		JDFDigitalPrintingParams jdfDigitalPrintingParams = (JDFDigitalPrintingParams)jdfResourcePool.appendElementN(ElementName.DIGITALPRINTINGPARAMS, 1, null);
		jdfDigitalPrintingParams.appendMedia();
		
		JDFComponent jdfComponent = (JDFComponent)jdfResourcePool.appendElementN(ElementName.COMPONENT, 1, null);
		
	}
}
