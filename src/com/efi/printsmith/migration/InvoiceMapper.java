package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.Account;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.SalesRep;
import com.efi.printsmith.data.SpecialInstructions;
import com.efi.printsmith.data.Contact;
import com.efi.printsmith.data.Job;
import com.efi.printsmith.data.ChargeDefinition;
import com.efi.printsmith.data.Charge;
import com.efi.printsmith.data.Estimate;
import com.efi.printsmith.data.NotePad;
import com.efi.printsmith.data.PreferencesSequenceValues;

public class InvoiceMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(InvoiceMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering InvoiceMapper->importTokens");
		String type = "";
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("doc type".equals(currentFieldToken)) {
				type = currentImportToken;
			}
		}
		ModelBase modelBase = null;
		if (type.equals("I") == true) {
			modelBase = this.createInvoice(fieldTokens, importTokens);
		}
		else {
			modelBase = this.createEstimate(fieldTokens, importTokens);
		}
		log.info("Leaving InvoiceMapper->importTokens");		
		return modelBase;
	}
	
	private ModelBase createEstimate(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering InvoiceMapper->createEstimate");
		Estimate invoice = new Estimate();
		NotePad notePad = new NotePad();
		DataService dataService = new DataService();
		String last = new String();
		String first = new String();
		Account account= null;
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doc type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cust number".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					account = dataService.getByAccountId(currentImportToken);
					if (account != null)
						invoice.setAccount(account);
				}
			} else if ("doc number".equals(currentFieldToken)) {
				invoice.setInvoiceNumber(currentImportToken);
			} else if ("name".equals(currentFieldToken)) {
				invoice.setName(currentImportToken);
			} else if ("sale rep".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					SalesRep salesRep = (SalesRep) dataService.getByName("SalesRep", currentImportToken);
					if (salesRep == null) {
						salesRep = new SalesRep();
						salesRep.setName(currentImportToken);
						salesRep = (SalesRep)dataService.addUpdate(salesRep);
					}
					invoice.setSalesRep(salesRep);
				}
			} else if ("PO number".equals(currentFieldToken)) {
				invoice.setCustomerPO(currentImportToken);
			} else if ("addr1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("city".equals(currentFieldToken)) {
				/* TODO */
			} else if ("state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("zip".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone".equals(currentFieldToken)) {
				/* TODO */
			} else if ("last name".equals(currentFieldToken)) {
				last = currentImportToken;
			} else if ("fax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taken by".equals(currentFieldToken)) {
				invoice.setTakenBy(currentImportToken);
			} else if ("sales code".equals(currentFieldToken)) {
				invoice.setSalesCode(currentImportToken);
			} else if ("resale number".equals(currentFieldToken)) {
				invoice.setResaleId(currentImportToken);
			} else if ("tax code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship mode".equals(currentFieldToken)) {
				/* TODO */
			} else if ("print count".equals(currentFieldToken)) {
				invoice.setPrintCount(Utilities.tokenToLong(currentImportToken));
			} else if ("special instructions".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					SpecialInstructions specialInstructions = new SpecialInstructions();
					specialInstructions.setInstructions(currentImportToken);
					dataService.addUpdate(specialInstructions);
					invoice.setSpecialInstructions(specialInstructions);
				}
			} else if ("old estimate number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setOrderedDate(Utilities.tokenToDate(currentImportToken));
			} else if ("due date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proof date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setProofDate(Utilities.tokenToDate(currentImportToken));
			} else if ("old invoice number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date completed".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setCompletedDate(Utilities.tokenToDate(currentImportToken));
			} else if ("date notified".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pickup date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setPickupDate(Utilities.tokenToDate(currentImportToken));
			} else if ("reorder date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setReorderDate(Utilities.tokenToDate(currentImportToken));
			} else if ("sales category[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[17]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[18]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[19]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[20]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("note pad WHO".equals(currentFieldToken)) {
				notePad.setNotesWho(currentImportToken);
			} else if ("order time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("due time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("complete time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notify time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pickup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship charges".equals(currentFieldToken)) {
				invoice.setShipCharges(Utilities.tokenToDouble(currentImportToken));
			} else if ("discountFactor".equals(currentFieldToken)) {
				invoice.setDiscountFactor(Utilities.tokenToDouble(currentImportToken));
			} else if ("discount".equals(currentFieldToken)) {
				invoice.setDiscount(Utilities.tokenToDouble(currentImportToken));
			} else if ("tax rate".equals(currentFieldToken)) {
				invoice.setTax(Utilities.tokenToDouble(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales tax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("subtotal".equals(currentFieldToken)) {
				invoice.setSubTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("shipping".equals(currentFieldToken)) {
				invoice.setShipPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("total".equals(currentFieldToken)) {
				invoice.setGrandTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("amount due".equals(currentFieldToken)) {
				invoice.setAmountDue(Utilities.tokenToDouble(currentImportToken));
			} else if ("total cost".equals(currentFieldToken)) {
				/* TODO */invoice.setTotalCost(Utilities.tokenToDouble(currentImportToken));
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				invoice.setAmountDue(Utilities.tokenToDouble(currentImportToken));
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costed".equals(currentFieldToken)) {
				invoice.setCosted(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("odiscount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("completed".equals(currentFieldToken)) {
				invoice.setCompleted(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("pends".equals(currentFieldToken)) {
				invoice.setOnPendingList(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("locked".equals(currentFieldToken)) {
				invoice.setLocked(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("printed invoice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("printed estimate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("obs_tax shipping".equals(currentFieldToken)) {
				/* TODO */
			} else if ("po required".equals(currentFieldToken)) {
				invoice.setPoRequired(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("file originals".equals(currentFieldToken)) {
				invoice.setFileOriginals(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("no tax".equals(currentFieldToken)) {
				invoice.setNotTaxable(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expense code".equals(currentFieldToken)) {
				invoice.setExpenseCode(currentImportToken);
			} else if ("addr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("country".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship city".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship zip".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship country".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship taken by".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					
					
				}
			} else if ("first name".equals(currentFieldToken)) {
				first = currentImportToken;
			} else if ("salutation".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job title".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prefix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("suffix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("A.R.F".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shipping address type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship mode text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display prefix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display suffix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display no".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job rec".equals(currentFieldToken)) {
				/* Don't use job linkage done in job mapper */
			} else if ("charge rec".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					Charge charge = (Charge) dataService.getByPrevId("Charge", currentImportToken);
					if (charge != null)
						invoice.addCharges(charge);
				}
			} else if ("markup rec".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ChargeDefinition chargeDefinition = (ChargeDefinition) dataService.getByPrevId("ChargeDefinition", currentImportToken);
					if (chargeDefinition != null)
						invoice.addMarkupCharges(chargeDefinition);
				}
			} else if ("note pad rec".equals(currentFieldToken)) {
				notePad.setPrevId(currentImportToken);
			} else if ("note pad PHONE".equals(currentFieldToken)) {
				notePad.setPhoneNumber(currentImportToken);
			} else if ("note pad WHAT".equals(currentFieldToken)) {
				notePad.setNotesWhat(currentImportToken);
			} else if ("note pad HOW MANY".equals(currentFieldToken)) {
				notePad.setHowMany(currentImportToken);
			} else if ("note pad WHAT SIZE".equals(currentFieldToken)) {
				notePad.setWhatSize(currentImportToken);
			} else if ("note pad PAPER".equals(currentFieldToken)) {
				notePad.setPaper(currentImportToken);
			} else if ("note pad NOTES".equals(currentFieldToken)) {
				notePad.setNotes(currentImportToken);
			} else if ("note pad WHEN".equals(currentFieldToken)) {
				notePad.setNotesWhen(currentImportToken);
			} else if ("remarks  rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("CCT rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("format res ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hold state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hold state text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker record".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker duration".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker priority".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proofreader".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proof time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("reorder time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("location change date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("location change time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("touch date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("touch time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("delivery date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("delivery time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web order ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web company ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web expand 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web extra".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web shipping ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Extra ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Comment rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Comment Text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web RFQ ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web reference ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment approval code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[21]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[22]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[23]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[24]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[25]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[26]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[27]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[28]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[29]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[30]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[31]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[32]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[33]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[34]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[35]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[36]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[37]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[38]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[39]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[40]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markups".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dollar discount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("oAddress".equals(currentFieldToken)) {
				/* TODO */
			} else if ("auto show note pad".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price locked".equals(currentFieldToken)) {
				/* TODO */
			} else if ("firmWantedBy".equals(currentFieldToken)) {
				/* TODO */
			} else if ("invoice production release".equals(currentFieldToken)) {
				/* TODO */
			} else if ("has inventoried stock".equals(currentFieldToken)) {
				/* TODO */
			} else if ("discount is dollars".equals(currentFieldToken)) {
				/* TODO */
			} else if ("discount is one time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment auth waiting".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment complete".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[5]".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		notePad = (NotePad)dataService.addUpdate(notePad);
		notePad.setId(notePad.getId());
		invoice.setNotes(notePad);
		if (account != null) {
			Contact contact = (Contact) dataService.getByLastFirstName("Contact", last, first, account.getId());
			if (contact != null)
				invoice.setContact(contact);
		}
		return invoice;
	}
	
	private ModelBase createInvoice(String[] fieldTokens, String[] importTokens) throws Exception {
		Invoice invoice = new Invoice();
		NotePad notePad = new NotePad();
		String last = new String();
		String first = new String();
		Account account = null;
		DataService dataService = new DataService();
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("doc type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cust number".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					account = dataService.getByAccountId(currentImportToken);
					if (account != null)
						invoice.setAccount(account);
				}
			} else if ("doc number".equals(currentFieldToken)) {
				invoice.setInvoiceNumber(currentImportToken);
			} else if ("name".equals(currentFieldToken)) {
				invoice.setName(currentImportToken);
			} else if ("sale rep".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					SalesRep salesRep = (SalesRep) dataService.getByName("SalesRep", currentImportToken);
					if (salesRep == null) {
						salesRep = new SalesRep();
						salesRep.setName(currentImportToken);
						salesRep = (SalesRep)dataService.addUpdate(salesRep);
					}
					invoice.setSalesRep(salesRep);
				}
			} else if ("PO number".equals(currentFieldToken)) {
				invoice.setCustomerPO(currentImportToken);
			} else if ("addr1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addr5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("city".equals(currentFieldToken)) {
				/* TODO */
			} else if ("state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("zip".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone".equals(currentFieldToken)) {
				/* TODO */
			} else if ("last name".equals(currentFieldToken)) {
				last = currentFieldToken;
			} else if ("fax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taken by".equals(currentFieldToken)) {
				invoice.setTakenBy(currentImportToken);
			} else if ("sales code".equals(currentFieldToken)) {
				invoice.setSalesCode(currentImportToken);
			} else if ("resale number".equals(currentFieldToken)) {
				invoice.setResaleId(currentImportToken);
			} else if ("tax code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship mode".equals(currentFieldToken)) {
				/* TODO */
			} else if ("print count".equals(currentFieldToken)) {
				invoice.setPrintCount(Utilities.tokenToLong(currentImportToken));
			} else if ("special instructions".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
					SpecialInstructions specialInstructions = new SpecialInstructions();
					specialInstructions.setInstructions(currentImportToken);
					dataService.addUpdate(specialInstructions);
					invoice.setSpecialInstructions(specialInstructions);
				}
			} else if ("old estimate number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setOrderedDate(Utilities.tokenToDate(currentImportToken));
			} else if ("due date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proof date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setProofDate(Utilities.tokenToDate(currentImportToken));
			} else if ("old invoice number".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date completed".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setCompletedDate(Utilities.tokenToDate(currentImportToken));
			} else if ("date notified".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pickup date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setPickupDate(Utilities.tokenToDate(currentImportToken));
			} else if ("reorder date".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false)
					invoice.setReorderDate(Utilities.tokenToDate(currentImportToken));
			} else if ("sales category[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[5]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[6]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[7]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[8]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[9]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[10]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[11]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[12]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[13]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[14]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[15]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[16]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[17]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[18]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[19]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[20]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("note pad WHO".equals(currentFieldToken)) {
				notePad.setNotesWho(currentImportToken);
			} else if ("order time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("due time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("complete time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("notify time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("pickup time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship charges".equals(currentFieldToken)) {
				invoice.setShipCharges(Utilities.tokenToDouble(currentImportToken));
			} else if ("discountFactor".equals(currentFieldToken)) {
				invoice.setDiscountFactor(Utilities.tokenToDouble(currentImportToken));
			} else if ("discount".equals(currentFieldToken)) {
				invoice.setDiscount(Utilities.tokenToDouble(currentImportToken));
			} else if ("tax rate".equals(currentFieldToken)) {
				invoice.setTax(Utilities.tokenToDouble(currentImportToken));
			} else if ("taxable".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales tax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("subtotal".equals(currentFieldToken)) {
				invoice.setSubTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("shipping".equals(currentFieldToken)) {
				invoice.setShipPrice(Utilities.tokenToDouble(currentImportToken));
			} else if ("total".equals(currentFieldToken)) {
				invoice.setGrandTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("amount due".equals(currentFieldToken)) {
				invoice.setAmountDue(Utilities.tokenToDouble(currentImportToken));
			} else if ("total cost".equals(currentFieldToken)) {
				/* TODO */invoice.setTotalCost(Utilities.tokenToDouble(currentImportToken));
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				invoice.setAmountDue(Utilities.tokenToDouble(currentImportToken));
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("costed".equals(currentFieldToken)) {
				invoice.setCosted(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("odiscount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("completed".equals(currentFieldToken)) {
				invoice.setCompleted(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("pends".equals(currentFieldToken)) {
				invoice.setOnPendingList(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("locked".equals(currentFieldToken)) {
				invoice.setLocked(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("printed invoice".equals(currentFieldToken)) {
				/* TODO */
			} else if ("printed estimate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("obs_tax shipping".equals(currentFieldToken)) {
				/* TODO */
			} else if ("po required".equals(currentFieldToken)) {
				invoice.setPoRequired(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("file originals".equals(currentFieldToken)) {
				invoice.setFileOriginals(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("no tax".equals(currentFieldToken)) {
				invoice.setNotTaxable(Utilities.tokenToBooleanValue(currentImportToken));
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expense code".equals(currentFieldToken)) {
				invoice.setExpenseCode(currentImportToken);
			} else if ("addr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("country".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship addr5".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship city".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship zip".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship country".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship taken by".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact".equals(currentFieldToken)) {
				if (currentImportToken.equals("") == false) {
				
				}
			} else if ("first name".equals(currentFieldToken)) {
				first = currentFieldToken;
			} else if ("salutation".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job title".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 2".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 3".equals(currentFieldToken)) {
				/* TODO */
			} else if ("phone 4".equals(currentFieldToken)) {
				/* TODO */
			} else if ("prefix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("suffix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("A.R.F".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shipping address type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ship mode text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display prefix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display suffix".equals(currentFieldToken)) {
				/* TODO */
			} else if ("order display no".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job rec".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					Job job = (Job) dataService.getByPrevId("Job",currentImportToken);
					if (job != null)
						invoice.addJobs(job);
				}
			} else if ("charge rec".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					Charge charge = (Charge) dataService.getByPrevId("Charge", currentImportToken);
					if (charge != null)
						invoice.addCharges(charge);
				}
			} else if ("markup rec".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					ChargeDefinition chargeDefinition = (ChargeDefinition) dataService.getByPrevId("ChargeDefinition", currentImportToken);
					if (chargeDefinition != null)
						invoice.addMarkupCharges(chargeDefinition);
				}
			} else if ("note pad rec".equals(currentFieldToken)) {
				notePad.setPrevId(currentImportToken);
			} else if ("note pad PHONE".equals(currentFieldToken)) {
				notePad.setPhoneNumber(currentImportToken);
			} else if ("note pad WHAT".equals(currentFieldToken)) {
				notePad.setNotesWhat(currentImportToken);
			} else if ("note pad HOW MANY".equals(currentFieldToken)) {
				notePad.setHowMany(currentImportToken);
			} else if ("note pad WHAT SIZE".equals(currentFieldToken)) {
				notePad.setWhatSize(currentImportToken);
			} else if ("note pad PAPER".equals(currentFieldToken)) {
				notePad.setPaper(currentImportToken);
			} else if ("note pad NOTES".equals(currentFieldToken)) {
				notePad.setNotes(currentImportToken);
			} else if ("note pad WHEN".equals(currentFieldToken)) {
				notePad.setNotesWhen(currentImportToken);
			} else if ("remarks  rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("contact rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("CCT rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("format res ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hold state".equals(currentFieldToken)) {
				/* TODO */
			} else if ("hold state text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("job count".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker record".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker duration".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tracker priority".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proofreader".equals(currentFieldToken)) {
				/* TODO */
			} else if ("proof time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("reorder time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("location change date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("location change time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("touch date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("touch time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("delivery date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("delivery time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("expand time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web order ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web company ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web expand 1".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web extra".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web shipping ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Extra ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Comment rec".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web Comment Text".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web RFQ ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web reference ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web address ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment approval code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[21]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[22]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[23]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[24]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[25]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[26]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[27]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[28]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[29]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[30]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[31]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[32]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[33]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[34]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[35]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[36]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[37]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[38]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[39]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sales category[40]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("markups".equals(currentFieldToken)) {
				/* TODO */
			} else if ("dollar discount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentFieldToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("checkno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("date".equals(currentFieldToken)) {
				/* TODO */
			} else if ("amount".equals(currentFieldToken)) {
				/* TODO */
			} else if ("type".equals(currentFieldToken)) {
				/* TODO */
			} else if ("card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("oAddress".equals(currentFieldToken)) {
				/* TODO */
			} else if ("auto show note pad".equals(currentFieldToken)) {
				/* TODO */
			} else if ("price locked".equals(currentFieldToken)) {
				/* TODO */
			} else if ("firmWantedBy".equals(currentFieldToken)) {
				/* TODO */
			} else if ("invoice production release".equals(currentFieldToken)) {
				/* TODO */
			} else if ("has inventoried stock".equals(currentFieldToken)) {
				/* TODO */
			} else if ("discount is dollars".equals(currentFieldToken)) {
				/* TODO */
			} else if ("discount is one time".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment auth waiting".equals(currentFieldToken)) {
				/* TODO */
			} else if ("web payment complete".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[4]".equals(currentFieldToken)) {
				/* TODO */
			} else if ("addl tax[5]".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		notePad = (NotePad)dataService.addUpdate(notePad);
		notePad.setId(notePad.getId());
		invoice.setNotes(notePad);
		if (account != null) {
			Contact contact = (Contact) dataService.getByLastFirstName("Contact", last, first, account.getId());
			if (contact != null)
				invoice.setContact(contact);
		}
		if (invoice.getInvoiceNumber() != null
				&& invoice.getInvoiceNumber().length() > 0) {
			PreferencesSequenceValues sequenceValues = dataService.getSequenceValues();
			sequenceValues.setInvoice(Long.parseLong(invoice.getInvoiceNumber()));
			dataService.addUpdate(sequenceValues);
		}
		log.info("Leaving InvoiceMapper->createEstimate");
		return invoice;
	}
}
