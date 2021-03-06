package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.ComLink;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.JobTitle;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.PreferencesSequenceValues;
import com.efi.printsmith.data.SalesRep;
import com.efi.printsmith.data.Marketing;
import com.efi.printsmith.data.BusinessType;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.data.State;
import com.efi.printsmith.data.Zip;
import com.efi.printsmith.data.City;
import com.efi.printsmith.data.ShippingMethod;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class CustomerMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(CopierDefinitionMapper.class);
	public void importFile(File uploadedFile) throws Exception {

	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens)
			throws Exception {
		log.info("Entering CustomerMapper->importTokens");
		Account customer = new Account();
		Address shipToAddress = new Address();
		Address billToAddress = new Address();
		Contact shipToContact = new Contact();
		Contact billToContact = new Contact();
		TaxTable taxTable = new TaxTable();
		Marketing marketing = new Marketing();
		BusinessType businessType = new BusinessType();
		String contactId = "";
		String billContactId = "";
		String lastNotifiedDate = "";
		DataService dataService = new DataService();

		for (int i = 0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if (currentImportToken.equals("") == false) {
				if ("recno".equals(currentFieldToken)) {
					customer.setPrevId(currentImportToken);
				} else if ("account number".equals(currentFieldToken)) {
					customer.setAccountId(currentImportToken);
				} else if ("account type".equals(currentFieldToken)) {
					if ("1".equals(currentImportToken)) {
						customer.setType("full_deposit");
					} else if ("2".equals(currentImportToken)) {
						customer.setType("cash_only");
					} else if ("3".equals(currentImportToken)) {
						customer.setType("cash_check_credit");
					} else if ("4".equals(currentImportToken)) {
						customer.setType("charge_acct");
					} else if ("5".equals(currentImportToken)) {
						customer.setType("credit_card_on_file");
					}
				} else if ("account status".equals(currentFieldToken)) {
					if ("1".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusNew");
					} else if ("2".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusCurrent");
					} else if ("3".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusInactive");
					} else if ("4".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusPastDue");
					} else if ("5".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusDelinquent");
					} else if ("6".equals(currentImportToken)) {
						customer.setStatus("CustomerStatusFrozen");
					}
				} else if ("resale id".equals(currentFieldToken)) {
					customer.setResaleNumber(currentImportToken);
				} else if ("title".equals(currentFieldToken)) {
					customer.setTitle(currentImportToken);
				} else if ("inv name".equals(currentFieldToken)) {
					shipToAddress.setName(currentImportToken);
				} else if ("inv phone".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Phone");
						comlink = (ComLink)dataService.addUpdate(comlink);
						shipToContact.addComLinks(comlink);
					}
				} else if ("inv fax".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Fax");
						comlink = (ComLink)dataService.addUpdate(comlink);
						shipToContact.addComLinks(comlink);
					}
				} else if ("inv city".equals(currentFieldToken)) {
					shipToAddress.setCity(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						City city = (City)dataService.getByName("City", currentImportToken);
//						if (city == null) {
//							city = new City();
//							city.setName(currentImportToken);
//							city = (City)dataService.addUpdate(city);
//						}
//					}
				} else if ("inv zip".equals(currentFieldToken)) {
					shipToAddress.setZip(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						Zip zip = (Zip)dataService.getByName("Zip", currentImportToken);
//						if (zip == null) {
//							zip = new Zip();
//							zip.setName(currentImportToken);
//							zip = (Zip)dataService.addUpdate(zip);
//						}
//					}
				} else if ("inv first name".equals(currentFieldToken)) {
					shipToContact.setFirstName(currentImportToken);
				} else if ("inv last name".equals(currentFieldToken)) {
					shipToContact.setLastName(currentImportToken);
				} else if ("inv addr1".equals(currentFieldToken)) {
					shipToAddress.setStreet1(currentImportToken);
				} else if ("inv addr2".equals(currentFieldToken)) {
					shipToAddress.setStreet2(currentImportToken);
				} else if ("inv state".equals(currentFieldToken)) {
					shipToAddress.setState(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						State state = (State)dataService.getByName("State", currentImportToken);
//						if (state == null) {
//							state = new State();
//							state.setName(currentImportToken);
//							state = (State)dataService.addUpdate(state);
//						}
//					}
				} else if ("inv refno".equals(currentFieldToken)) {
					customer.setExternalRef(currentImportToken);
				} else if ("bill name".equals(currentFieldToken)) {
					billToAddress.setName(currentImportToken);
				} else if ("bill street1".equals(currentFieldToken)) {
					billToAddress.setStreet1(currentImportToken);
				} else if ("bill street2".equals(currentFieldToken)) {
					billToAddress.setStreet2(currentImportToken);
				} else if ("bill city".equals(currentFieldToken)) {
					billToAddress.setCity(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						City city = (City)dataService.getByName("City", currentImportToken);
//						if (city == null) {
//							city = new City();
//							city.setName(currentImportToken);
//							city = (City)dataService.addUpdate(city);
//						}
//					}
				} else if ("bill state".equals(currentFieldToken)) {
					billToAddress.setState(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						State state = (State)dataService.getByName("State", currentImportToken);
//						if (state == null) {
//							state = new State();
//							state.setName(currentImportToken);
//							state = (State)dataService.addUpdate(state);
//						}
//					}
				} else if ("bill zip".equals(currentFieldToken)) {
					billToAddress.setZip(currentImportToken);
//					if (currentImportToken.equals("") == false) {
//						Zip zip = (Zip)dataService.getByName("Zip", currentImportToken);
//						if (zip == null) {
//							zip = new Zip();
//							zip.setName(currentImportToken);
//							zip = (Zip)dataService.addUpdate(zip);
//						}
//					}
				} else if ("bill phone".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Phone");
						comlink = (ComLink)dataService.addUpdate(comlink);
						billToContact.addComLinks(comlink);
					}
				} else if ("bill last name".equals(currentFieldToken)) {
					billToContact.setLastName(currentImportToken);
				} else if ("bill fax".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Fax");
						comlink = (ComLink)dataService.addUpdate(comlink);
						billToContact.addComLinks(comlink);
					}
				} else if ("bill refno".equals(currentFieldToken)) {
					/* TODO */
				} else if ("tax code".equals(currentFieldToken)) {
					/* TODO */
				} else if ("tax table ID".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						 taxTable = (TaxTable)dataService.getByPrevId("TaxTable", currentImportToken);
						if (taxTable != null)
							customer.setTaxTable(taxTable);
					}
				} else if ("tax table is default".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false  && taxTable != null) {
						if (taxTable.getDefaultTable() != null && taxTable.getDefaultTable() != true && taxTable.getName() != null && taxTable.getName().length() > 0){
							taxTable.setDefaultTable(true);
							dataService.addTaxTable(taxTable);
						}					
					}
				}else if ("sales ranking".equals(currentFieldToken)) {
					customer.setSalesRank(Utilities
							.tokenToLong(currentImportToken));
				} else if ("do statement".equals(currentFieldToken)) {
					Boolean TempB;
					TempB = Utilities.tokenToBooleanValue(currentImportToken);
					customer.setGenerateStatements(!TempB);
				} else if ("do finance charges".equals(currentFieldToken)) {
					Boolean tempF;
					tempF = Utilities.tokenToBooleanValue(currentImportToken);
					customer.setApplyFinanceCharges(!tempF);
				} else if ("po required".equals(currentFieldToken)) {
					customer.setPoRequired(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("business type code".equals(currentFieldToken)) {
					/* TODO */
				} else if ("sales rep".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						SalesRep salesRep = (SalesRep) dataService.getByName("SalesRep", currentImportToken);
						if (salesRep == null) {
							salesRep = new SalesRep();
							salesRep.setName(currentImportToken);
							salesRep = (SalesRep)dataService.addTableEditorItem(salesRep);
						}
						customer.setSalesRep(salesRep);
					}
				} else if ("on account".equals(currentFieldToken)) {
					customer.setOnAccount(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("balance".equals(currentFieldToken)) {
					customer.setBalance(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("sales month".equals(currentFieldToken)) {
					customer.setSalesMonth(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("sales year".equals(currentFieldToken)) {
					customer.setSalesYear(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("sales prior year".equals(currentFieldToken)) {
					customer.setSalesPriorYear(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("orders year".equals(currentFieldToken)) {
					customer.setOrdersYear(Utilities
							.tokenToLong(currentImportToken));
				} else if ("orders month".equals(currentFieldToken)) {
					customer.setOrdersMonth(Utilities
							.tokenToLong(currentImportToken));
				} else if ("estimate count".equals(currentFieldToken)) {
					customer.setEstimateCount(Utilities
							.tokenToLong(currentImportToken));
				} else if ("credit limit".equals(currentFieldToken)) {
					customer.setCreditLimit(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("discount rate".equals(currentFieldToken)) {
					customer.setDiscount(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("finance rate".equals(currentFieldToken)) {
					customer.setFinanceRate(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("finance YTD".equals(currentFieldToken)) {
					customer.setFinanceYear(Utilities
							.tokenToDouble(currentImportToken));
				} else if ("created".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setCreated(Utilities
								.tokenToDate(currentImportToken));
				} else if ("invoice date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastInvoiceDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("estimate date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastEstimateDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("last aged".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastAgedDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("last billed".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastBilledDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("last payment".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastPaymentDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("last posted".equals(currentFieldToken)) {
					/* TODO */
				} else if ("rank date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastRankingDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("invoice notes".equals(currentFieldToken)) {
					customer.setAccountNote(currentImportToken);
				} else if ("job notes".equals(currentFieldToken)) {
					customer.setJobNote(currentImportToken);
				} else if ("contact record".equals(currentFieldToken)) {
					contactId = currentImportToken;
					shipToContact.setContactId(currentImportToken);
					shipToContact.setPrevId(currentImportToken);
				} else if ("master acct".equals(currentFieldToken)) {
					customer.setMasterAcct(Utilities
							.tokenToLong(currentImportToken));
				} else if ("access level".equals(currentFieldToken)) {
					customer.setAccess_level(Utilities.tokenToInt(currentImportToken));
				} else if ("external ref number".equals(currentFieldToken)) {
					customer.setExternalRef(currentImportToken);
				} else if ("tax exempt".equals(currentFieldToken)) {
					customer.setTaxExempt(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("rtype".equals(currentFieldToken)) {
					 if (currentImportToken.equals("0") == false)
						customer.setProspect(true);
					 else
						 customer.setProspect(false);
				} else if ("inv addr".equals(currentFieldToken)) {
					/* TODO */
				} else if ("inv country".equals(currentFieldToken)) {
					shipToAddress.setCountry(currentImportToken);
				} else if ("bill addr".equals(currentFieldToken)) {
					/* TODO */
				} else if ("bill country".equals(currentFieldToken)) {
					billToAddress.setCountry(currentImportToken);
				} else if ("ship contact".equals(currentFieldToken)) {
					/* TODO */
				} else if ("inv salutation".equals(currentFieldToken)) {
					shipToContact.setSalutation(currentImportToken);
				} else if ("inv job title".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false) {
						JobTitle title = (JobTitle)dataService.getByName("JobTitle", currentImportToken);
						if (title == null) {
							title = new JobTitle();
							title.setName(currentImportToken);
							title = (JobTitle)dataService.addUpdate(title);
						}
						shipToContact.setJobTitle(title);
					}
					
				
				} else if ("inv phone 2".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Cell");
						comlink = (ComLink)dataService.addUpdate(comlink);
						shipToContact.addComLinks(comlink);
					}
				} else if ("inv phone 3".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Other");
						comlink = (ComLink)dataService.addUpdate(comlink);
						shipToContact.addComLinks(comlink);
					}
				} else if ("inv prefix".equals(currentFieldToken)) {
					shipToContact.setPrefix(currentImportToken);
				} else if ("inv suffix".equals(currentFieldToken)) {
					shipToContact.setSuffix(currentImportToken);
				} else if ("bill contact".equals(currentFieldToken)) {
					billToContact.setContactId(currentImportToken);
					billToContact.setPrevId(currentImportToken);
				} else if ("bill first name".equals(currentFieldToken)) {
					billToContact.setFirstName(currentImportToken);
				} else if ("bill salutation".equals(currentFieldToken)) {
					billToContact.setSalutation(currentImportToken);
				} else if ("bill job title".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false) {
						JobTitle title = (JobTitle)dataService.getByName("JobTitle", currentImportToken);
						if (title == null) {
							title = new JobTitle();
							title.setName(currentImportToken);
							title = (JobTitle)dataService.addUpdate(title);
						}
						billToContact.setJobTitle(title);
					}
					
					
				} else if ("bill phone 2".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Cell");
						comlink = (ComLink)dataService.addUpdate(comlink);
						billToContact.addComLinks(comlink);
					}
				} else if ("bill phone 3".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "Other");
						comlink = (ComLink)dataService.addUpdate(comlink);
						billToContact.addComLinks(comlink);
					}
				} else if ("bill prefix".equals(currentFieldToken)) {
					billToContact.setPrefix(currentImportToken);
				} else if ("bill suffix".equals(currentFieldToken)) {
					billToContact.setSuffix(currentImportToken);
				} else if ("do commissions".equals(currentFieldToken)) {
					customer.setPayCommissions(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("notCompany".equals(currentFieldToken)) {
					/* TODO */
				} else if ("do not mail".equals(currentFieldToken)) {
					customer.setOptOutMarketing(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("default inv".equals(currentFieldToken)) {
					/* TODO */
				} else if ("default est".equals(currentFieldToken)) {
					/* TODO */
				} else if ("shipping mode".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false && currentImportToken.equals("0") == false) {
						ShippingMethod method = (ShippingMethod)dataService.getByName("ShippingMethod", currentImportToken);
						if (method == null) {
							method = new ShippingMethod();
							method.setName(currentImportToken);
							method = (ShippingMethod)dataService.addUpdate(method);
						}
						customer.setShippingMode(method);
					}
					
				} else if ("aging[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("aging[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("aging[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("aging[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("aging[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("history notes".equals(currentFieldToken)) {
					/* TODO */
				} else if ("statement notes".equals(currentFieldToken)) {
					customer.setStatementNote(currentImportToken);
				} else if ("bill contact record".equals(currentFieldToken)) {
					billContactId = currentImportToken;
				} else if ("marketing dates[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[7]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[8]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[9]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("marketing dates[10]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("leadsource".equals(currentFieldToken)) {
					marketing.setLeadSource(currentImportToken);
				} else if ("user1".equals(currentFieldToken)) {
					marketing.setCommonInterst(currentImportToken);
				} else if ("user2".equals(currentFieldToken)) {
					marketing.setSportsInterst(currentImportToken);
				} else if ("user3".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						marketing.setUser3(Utilities
								.tokenToDate(currentImportToken));
				} else if ("user4".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						marketing.setUser4(Utilities
								.tokenToDate(currentImportToken));
				} else if ("user5".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						marketing.setUser5(Utilities
								.tokenToDate(currentImportToken));
				} else if ("user6".equals(currentFieldToken)) {
					marketing.setUser6(currentImportToken);
				} else if ("user7".equals(currentFieldToken)) {
					marketing.setUser7(currentImportToken);
				} else if ("user8".equals(currentFieldToken)) {
					marketing.setUser8(currentImportToken);
				} else if ("number employees".equals(currentFieldToken)) {
					marketing.setNumberofEmployees(Utilities
							.tokenToInt(currentImportToken));
				} else if ("business type".equals(currentFieldToken)) {
					businessType.setKey(currentImportToken);
				} else if ("business type name".equals(currentFieldToken)) {
					businessType.setName(currentImportToken);
				} else if ("annual revenue".equals(currentFieldToken)) {
					marketing.setAnnualRev(Utilities
							.tokenToInt(currentImportToken));
				} else if ("master acct name".equals(currentFieldToken)) {
					/* TODO */
				} else if ("account PO".equals(currentFieldToken)) {
					customer.setCustomerPO(currentImportToken);
				} else if ("inv addr3".equals(currentFieldToken)) {
					/* TODO */
				} else if ("inv addr4".equals(currentFieldToken)) {
					/* TODO */
				} else if ("bill addr3".equals(currentFieldToken)) {
					/* TODO */
				} else if ("bill addr4".equals(currentFieldToken)) {
					/* TODO */
				} else if ("inv phone 4".equals(currentFieldToken)) {
					if (currentImportToken.length() > 0
							&& !currentImportToken.equals(" ")) {
						ComLink comlink = Utilities.tokenToComLink(
								currentImportToken, "E-Mail");
						comlink = (ComLink)dataService.addUpdate(comlink);
						shipToContact.addComLinks(comlink);
					}
				}else if ("bill phone 4".equals(currentFieldToken)) {
						if (currentImportToken.length() > 0
								&& !currentImportToken.equals(" ")) {
							ComLink comlink = Utilities.tokenToComLink(
									currentImportToken, "E-Mail");
							comlink = (ComLink)dataService.addUpdate(comlink);
							billToContact.addComLinks(comlink);
						}
						
				} else if ("ship address ID".equals(currentFieldToken)) {
					Address address = (Address)dataService.getByPrevId("Address", currentImportToken);
					if (address != null)
						shipToAddress = address;
				} else if ("bill address ID".equals(currentFieldToken)) {
					Address address = (Address)dataService.getByPrevId("Address", currentImportToken);
					if (address != null)
						billToAddress = address;
				} else if ("tax table ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("tax table title".equals(currentFieldToken)) {
					/* TODO */
				} else if ("tax code ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("tax code title".equals(currentFieldToken)) {
					/* TODO */
				} else if ("expand short".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[1]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[2]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[3]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[4]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[5]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("customRanking[6]".equals(currentFieldToken)) {
					/* TODO */
				} else if ("external accounting ID".equals(currentFieldToken)) {
					customer.setExternalAcctId(currentImportToken);
				} else if ("filler bits".equals(currentFieldToken)) {
					/* TODO */
				} else if ("file originals".equals(currentFieldToken)) {
					customer.setFileOriginals(Utilities
							.tokenToBooleanValue(currentImportToken));
				} else if ("web access".equals(currentFieldToken)) {
					/* TODO */
				} else if ("never a customer".equals(currentFieldToken)) {
					/* TODO */
				} else if ("invoiceTemplateID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("estimateTemplateID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("shipping mode ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("total invoices".equals(currentFieldToken)) {
					/* TODO */
				} else if ("terms net".equals(currentFieldToken)) {
					customer.setTermsNet(Utilities.tokenToLong(currentImportToken));
				} else if ("terms discount".equals(currentFieldToken)) {
					customer.setTermsDiscount(Utilities.tokenToDouble(currentImportToken));
				} else if ("estimate won cnt".equals(currentFieldToken)) {
					customer.setEstimatesWon(Utilities
							.tokenToLong(currentImportToken));
				} else if ("estimate lost cnt".equals(currentFieldToken)) {
					customer.setEstimatesLost(Utilities
							.tokenToLong(currentImportToken));
				} else if ("discount single amount".equals(currentFieldToken)) {
					/* TODO */
				} else if ("first invoice date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setFirstInvoiceDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("first estimate date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setFirstEstimateDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("touch date".equals(currentFieldToken)) {
					/* TODO */
				} else if ("preset job charges[1]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[2]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[3]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[4]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[5]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[6]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[7]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[8]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[9]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset job charges[10]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer.addJobCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[1]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[2]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[3]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[4]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[5]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[6]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[7]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[8]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[9]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("preset inv charges[10]".equals(currentFieldToken)) {
					if (currentImportToken.equals("0") == false) {
						ModelBase modelBase = dataService
								.getByPrevId("ChargeDefinition",currentImportToken);
						if (modelBase != null) {
							long id = modelBase.getId();
							ChargeDefinition chargeDefinition = (ChargeDefinition) dataService
									.getById("ChargeDefinition", id);
							customer
									.addInvoiceEstimateCharges(chargeDefinition);
						}
					}
				} else if ("contact count".equals(currentFieldToken)) {
					/* TODO */
				} else if ("leadsource1 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("leadsource2 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("leadsource2".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user1 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user2 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user3 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user4 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user5 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user6 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user7 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("user8 ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("items paid".equals(currentFieldToken)) {
					/* TODO */
				} else if ("time to pay".equals(currentFieldToken)) {
					/* TODO */
				} else if ("autopay Template ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("web Company ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("web Catalog Role ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("web Pricing Role ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("web Address ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("web Bill Address ID".equals(currentFieldToken)) {
					/* TODO */
				} else if ("resale cert expire".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setResaleCertExpirationDate(Utilities
								.tokenToDate(currentImportToken));
				} else if ("last notified date".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastNotifiedDate(Utilities
								.tokenToDate(currentImportToken));
						lastNotifiedDate = currentImportToken;
				} else if ("last notified time".equals(currentFieldToken)) {
					if (currentImportToken.equals("") == false)
						customer.setLastNotifiedDate(Utilities
								.tokenToDateTime(lastNotifiedDate + " " + currentImportToken));
				} else if ("exp data 2".equals(currentFieldToken)) {
					/* TODO */
				}
			}
		}
		customer.setShipToAddress(shipToAddress);
		customer.setBillToAddress(billToAddress);
		if (shipToContact.getFirstName() != null || shipToContact.getLastName() != null)
			customer.setContact(shipToContact);
		if (contactId.equals(billContactId) && (shipToContact.getFirstName() != null || shipToContact.getLastName() != null)) {
			customer.setBillToContact(shipToContact);
		} else if (billToContact.getFirstName() != null || billToContact.getLastName() != null) {
			customer.setBillToContact(billToContact);
		}
		customer.setMarketing(marketing);
		marketing.setBusinessType(businessType.getName());
		shipToContact.setParentAccount(customer);
		billToContact.setParentAccount(customer);

		if (customer.getAccountId() != null
				&& customer.getAccountId().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setAccount(Long.parseLong(customer.getAccountId()));
			dataService.addUpdate(sequenceValues);
		}
		log.info("Leaving CustomerMapper->importTokens");		
		return customer;
	}
}
