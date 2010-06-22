package com.efi.printsmith.migration;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import nextapp.echo2.webrender.output.XmlDocument;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.xml.internal.txw2.Document;

import com.efi.printsmith.data.SalesCategory;
import com.efi.printsmith.data.PreferencesAccounting;
import com.efi.printsmith.data.PreferencesPOS;
import com.efi.printsmith.data.PreferencesEstimating;
import com.efi.printsmith.data.PreferencesSystem;
import com.efi.printsmith.data.Address;

import com.efi.printsmith.service.DataService;

public class PreferencesMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(uploadedFile);
		doc.getDocumentElement().normalize();
		NodeList groupNodes = doc.getElementsByTagName("Group");
		for (int i=0;i<groupNodes.getLength();i++) {
			NodeList itemNodes = groupNodes.item(i).getChildNodes();
			NamedNodeMap groupAttributes = groupNodes.item(i).getAttributes();
			Node groupTitleNode = groupAttributes.getNamedItem("Title");
			for(int x=0;x<itemNodes.getLength();x++) {
				if (itemNodes.item(x).getNodeType() == Node.ELEMENT_NODE) {
					NamedNodeMap itemAttributes = itemNodes.item(x).getAttributes();
					Node titleNode = itemAttributes.getNamedItem("Title");
					Node valueNode = itemAttributes.getNamedItem("Value");
					Node keyNode = itemAttributes.getNamedItem("Key");
					if (groupTitleNode.getNodeValue().equals("Sales Category List")) {
						importSalesCategoryListRecord(keyNode.getNodeValue(), valueNode.getNodeValue());
					}
					this.importField(groupTitleNode.getNodeValue(), keyNode.getNodeValue(), titleNode.getNodeValue(), valueNode.getNodeValue());
				}
			}
		}
	}
	private void importField(String group, String key, String fieldName, String fieldValue) throws Exception {
		if (group.equals("Statements Notices"))
			importPreferencesAccountingField(key, fieldName, fieldValue);
		else if (group.equals("Receipts Notices"))
			importPreferencesPOSField(key, fieldName, fieldValue);
		else if (group.equals("Paper Calculator"))
			importPreferencesEstimatingField(key, fieldName, fieldValue);
	}
	private void importDongleField(String fieldName, String fieldValue) {
		
	}
	private void importSalesCategoryListRecord(String key, String name) throws Exception {
		DataService dataService = new DataService();
		SalesCategory salesCategory = new SalesCategory();
		salesCategory.setPrevId(key);
		salesCategory.setName(name);
		dataService.addUpdate(salesCategory);
	}
	private void importPreferencesAccountingField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesAccounting preferencesAccounting = (PreferencesAccounting)dataService.getSingle("PreferencesAccounting");
		if (preferencesAccounting == null)
			preferencesAccounting = new PreferencesAccounting();
		if (name.equals("pastDue")) {
			preferencesAccounting.setPastDue(Utilities.tokenToInt(key));
			preferencesAccounting.setPastDueNote(value);
		} else if (name.equals("delinquint")) {
			preferencesAccounting.setDelinquent(Utilities.tokenToInt(key));
			preferencesAccounting.setDelinquentNote(value);
		} else if (name.equals("frozen")) {
			preferencesAccounting.setFrozen(Utilities.tokenToInt(key));
			preferencesAccounting.setFrozenNote(value);
		}
		dataService.addUpdate(preferencesAccounting);
	}
	private void importPreferencesPOSField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesPOS preferencesPOS = (PreferencesPOS)dataService.getSingle("PreferencesPOS");
		if (preferencesPOS == null)
			preferencesPOS = new PreferencesPOS();
		if (name.equals("Header Text")) {
			String currentHeader = preferencesPOS.getReceiptHeader();
			if (Utilities.tokenToInt(key) > 1)
				currentHeader = currentHeader + "\r";
			preferencesPOS.setReceiptHeader(currentHeader + value);
		} else if (name.equals("Footer Text")) {
			String currentFooter = preferencesPOS.getReceiptFooter();
			if (Utilities.tokenToInt(key) > 1)
				currentFooter = currentFooter + "\r";
			preferencesPOS.setReceiptFooter(currentFooter + value);
		}
		dataService.addUpdate(preferencesPOS);
	}
	private void importPreferencesEstimatingField(String key, String name, String value) throws Exception {
		DataService dataService = new DataService();
		PreferencesEstimating preferencesEstimating = (PreferencesEstimating)dataService.getSingle("PreferencesEstimating");
		if (preferencesEstimating == null)
			preferencesEstimating = new PreferencesEstimating();
		if (name.equals("gripperEdge"))
			preferencesEstimating.setGripEdgeGap(Utilities.tokenToDouble(value));
		else if (name.equals("gripSide"))
			preferencesEstimating.setGripLocation(value);
		else if (name.equals("folioEdge"))
			preferencesEstimating.setFolioEdge(Utilities.tokenToDouble(value));
		else if (name.equals("folioSide"))
			preferencesEstimating.setFolioLocation(value);
		else if (name.equals("finishBleedAll"))
			preferencesEstimating.setBleed(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedRight"))
			preferencesEstimating.setBleedRight(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedTop"))
			preferencesEstimating.setBleedTop(Utilities.tokenToDouble(value));
		else if (name.equals("finishBleedBottom"))
			preferencesEstimating.setBleedBottom(Utilities.tokenToDouble(value));
		else if (name.equals("useGrip"))
			preferencesEstimating.setUseGripEdgeGap(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFolio"))
			preferencesEstimating.setUseFolioEdge(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFinishBleed"))
			preferencesEstimating.setUseBleed(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useFinishGutter"))
			preferencesEstimating.setUseGutter(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useColorBar"))
			preferencesEstimating.setUseColorBar(Utilities.tokenToBooleanValue(value));
		else if (name.equals("backtrimParent"))
			preferencesEstimating.setBackTrimParent(Utilities.tokenToBooleanValue(value));
		else if (name.equals("attDiagramToJob"))
			preferencesEstimating.setAttachToJobTicket(Utilities.tokenToBooleanValue(value));
		else if (name.equals("colorBarWidth"))
			preferencesEstimating.setColorBar(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceLeft"))
			preferencesEstimating.setWhiteSpace(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceRight"))
			preferencesEstimating.setWhiteSpaceRight(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceTop"))
			preferencesEstimating.setWhiteSpaceTop(Utilities.tokenToDouble(value));
		else if (name.equals("whiteSpaceBottom"))
			preferencesEstimating.setWhiteSpaceBottom(Utilities.tokenToDouble(value));
		else if (name.equals("backtrimRun"))
			preferencesEstimating.setTrimFourSides(Utilities.tokenToBooleanValue(value));
		else if (name.equals("useWhiteSpace"))
			preferencesEstimating.setUseWhiteSpace(Utilities.tokenToBooleanValue(value));
		else if (name.equals("grain"))
			if (Utilities.tokenToBooleanValue(value))
				preferencesEstimating.setRunToFinishGrain("Match Grain");
			else
				preferencesEstimating.setRunToFinishGrain("Neither");
		else if (name.equals("dutch")) {
			if (Utilities.tokenToBooleanValue(value)) {
				preferencesEstimating.setRunToFinishGrain("Swing / Combination");
			}
		} else if (name.equals("runNTumble"))
			preferencesEstimating.setWorkandTumble(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportParent_show_cut_diagram"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportRun_show_cut_diagram"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("reportFinish_show_cut_diagram"))
			preferencesEstimating.setShowPaperCalculator(Utilities.tokenToBooleanValue(value));
		else if (name.equals("pressCutoff_default"))
			preferencesEstimating.setDefaultPressCuttOff(Utilities.tokenToDouble(value));
		dataService.addUpdate(preferencesEstimating);
	}
	private void importPreferencesSystemField(String key, String name, String value) {
		DataService dataService = new DataService();
		PreferencesSystem preferencesSystem = (PreferencesSystem)dataService.getSingle("PreferencesSystem");
		if (preferencesSystem == null)
			preferencesSystem = new PreferencesSystem();
		Address address = new Address();
		if (name.equals("title"))
			address.setName(value);
		else if (name.equals("address1"))
			address.setStreet1(value);
		else if (name.equals("address2"))
			address.setStreet2(value);
		else if (name.equals("citystatzip")) {
			int i = value.indexOf(",");
			if (i > -1) {
				address.setCity(value.substring(0,i-1));
			}
			int x = value.indexOf(" ",i+2);
			if (x > -1) {
				address.setState(value.substring(i+2, x-1));
				address.setCity(value.substring(x+1));
			}
		} else if (name.equals("phone"))
			preferencesSystem.setCompanyPhone(value);
		else if (name.equals("fax"))
			preferencesSystem.setCompanyFax(value);
		else if (name.equals("email"))
			preferencesSystem.setCompanyEmail(value);
		else if (name.equals("creditCardAuthCode"))
			preferencesSystem.setCCEncryptionData(value);
		else if (name.equals("creditCardIntegration"))
			preferencesSystem.setCreditCardApproval(value);
		else if (name.equals("streNum"))
			preferencesSystem.setCompanyStoreNumber(value);
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		return null;
	}
}