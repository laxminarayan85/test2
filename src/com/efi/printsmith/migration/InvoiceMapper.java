package com.efi.printsmith.migration;

import java.util.ArrayList;

import com.efi.printsmith.data.Invoice;
import com.efi.printsmith.data.ModelBase;

public class InvoiceMapper extends ImportMapper {
	public ModelBase importTokens(ArrayList<String> fieldTokens, ArrayList<String> importTokens) throws Exception {
		Invoice invoice = new Invoice();
		
		for (int i=0; i < fieldTokens.size(); i++) {
			String currentImportToken = importTokens.get(i);
			
			if ("recno".equals(currentImportToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentImportToken)) {
				/* TODO */
			} else if ("doc type".equals(currentImportToken)) {
				/* TODO */
			} else if ("cust number".equals(currentImportToken)) {
				/* TODO */
			} else if ("doc number".equals(currentImportToken)) {
				/* TODO */
			} else if ("name".equals(currentImportToken)) {
				/* TODO */
			} else if ("sale rep".equals(currentImportToken)) {
				/* TODO */
			} else if ("PO number".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr1".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr2".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr3".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr4".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr5".equals(currentImportToken)) {
				/* TODO */
			} else if ("city".equals(currentImportToken)) {
				/* TODO */
			} else if ("state".equals(currentImportToken)) {
				/* TODO */
			} else if ("zip".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone".equals(currentImportToken)) {
				/* TODO */
			} else if ("last name".equals(currentImportToken)) {
				/* TODO */
			} else if ("fax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taken by".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales code".equals(currentImportToken)) {
				/* TODO */
			} else if ("resale number".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship mode".equals(currentImportToken)) {
				/* TODO */
			} else if ("print count".equals(currentImportToken)) {
				/* TODO */
			} else if ("special instructions".equals(currentImportToken)) {
				/* TODO */
			} else if ("old estimate number".equals(currentImportToken)) {
				/* TODO */
			} else if ("order date".equals(currentImportToken)) {
				/* TODO */
			} else if ("due date".equals(currentImportToken)) {
				/* TODO */
			} else if ("proof date".equals(currentImportToken)) {
				/* TODO */
			} else if ("old invoice number".equals(currentImportToken)) {
				/* TODO */
			} else if ("date completed".equals(currentImportToken)) {
				/* TODO */
			} else if ("date notified".equals(currentImportToken)) {
				/* TODO */
			} else if ("pickup date".equals(currentImportToken)) {
				/* TODO */
			} else if ("reorder date".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[5]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[6]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[7]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[8]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[9]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[10]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[11]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[12]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[13]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[14]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[15]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[16]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[17]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[18]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[19]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[20]".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad WHO".equals(currentImportToken)) {
				/* TODO */
			} else if ("order time".equals(currentImportToken)) {
				/* TODO */
			} else if ("due time".equals(currentImportToken)) {
				/* TODO */
			} else if ("complete time".equals(currentImportToken)) {
				/* TODO */
			} else if ("notify time".equals(currentImportToken)) {
				/* TODO */
			} else if ("pickup time".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship charges".equals(currentImportToken)) {
				/* TODO */
			} else if ("discountFactor".equals(currentImportToken)) {
				/* TODO */
			} else if ("discount".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax rate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxable".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales tax".equals(currentImportToken)) {
				/* TODO */
			} else if ("subtotal".equals(currentImportToken)) {
				/* TODO */
			} else if ("shipping".equals(currentImportToken)) {
				/* TODO */
			} else if ("total".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount due".equals(currentImportToken)) {
				/* TODO */
			} else if ("total cost".equals(currentImportToken)) {
				/* TODO */
			} else if ("checkno".equals(currentImportToken)) {
				/* TODO */
			} else if ("date".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("type".equals(currentImportToken)) {
				/* TODO */
			} else if ("costed".equals(currentImportToken)) {
				/* TODO */
			} else if ("odiscount".equals(currentImportToken)) {
				/* TODO */
			} else if ("completed".equals(currentImportToken)) {
				/* TODO */
			} else if ("pends".equals(currentImportToken)) {
				/* TODO */
			} else if ("locked".equals(currentImportToken)) {
				/* TODO */
			} else if ("printed invoice".equals(currentImportToken)) {
				/* TODO */
			} else if ("printed estimate".equals(currentImportToken)) {
				/* TODO */
			} else if ("obs_tax shipping".equals(currentImportToken)) {
				/* TODO */
			} else if ("po required".equals(currentImportToken)) {
				/* TODO */
			} else if ("file originals".equals(currentImportToken)) {
				/* TODO */
			} else if ("no tax".equals(currentImportToken)) {
				/* TODO */
			} else if ("special".equals(currentImportToken)) {
				/* TODO */
			} else if ("rtype".equals(currentImportToken)) {
				/* TODO */
			} else if ("expense code".equals(currentImportToken)) {
				/* TODO */
			} else if ("addr".equals(currentImportToken)) {
				/* TODO */
			} else if ("country".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr1".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr2".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr3".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr4".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship addr5".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship city".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship state".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship zip".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship country".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship taken by".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact".equals(currentImportToken)) {
				/* TODO */
			} else if ("first name".equals(currentImportToken)) {
				/* TODO */
			} else if ("salutation".equals(currentImportToken)) {
				/* TODO */
			} else if ("job title".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 2".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 3".equals(currentImportToken)) {
				/* TODO */
			} else if ("phone 4".equals(currentImportToken)) {
				/* TODO */
			} else if ("prefix".equals(currentImportToken)) {
				/* TODO */
			} else if ("suffix".equals(currentImportToken)) {
				/* TODO */
			} else if ("A.R.F".equals(currentImportToken)) {
				/* TODO */
			} else if ("shipping address type".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact address ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("ship mode text".equals(currentImportToken)) {
				/* TODO */
			} else if ("order display prefix".equals(currentImportToken)) {
				/* TODO */
			} else if ("order display suffix".equals(currentImportToken)) {
				/* TODO */
			} else if ("order display no".equals(currentImportToken)) {
				/* TODO */
			} else if ("job rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("charge rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("markup rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad PHONE".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad WHAT".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad HOW MANY".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad WHAT SIZE".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad PAPER".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad NOTES".equals(currentImportToken)) {
				/* TODO */
			} else if ("note pad WHEN".equals(currentImportToken)) {
				/* TODO */
			} else if ("remarks  rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("cost rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("contact rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("CCT rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("format res ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("hold state".equals(currentImportToken)) {
				/* TODO */
			} else if ("hold state text".equals(currentImportToken)) {
				/* TODO */
			} else if ("job count".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker record".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker duration".equals(currentImportToken)) {
				/* TODO */
			} else if ("tracker priority".equals(currentImportToken)) {
				/* TODO */
			} else if ("proofreader".equals(currentImportToken)) {
				/* TODO */
			} else if ("proof time".equals(currentImportToken)) {
				/* TODO */
			} else if ("reorder time".equals(currentImportToken)) {
				/* TODO */
			} else if ("location change date".equals(currentImportToken)) {
				/* TODO */
			} else if ("location change time".equals(currentImportToken)) {
				/* TODO */
			} else if ("touch date".equals(currentImportToken)) {
				/* TODO */
			} else if ("touch time".equals(currentImportToken)) {
				/* TODO */
			} else if ("delivery date".equals(currentImportToken)) {
				/* TODO */
			} else if ("delivery time".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand date".equals(currentImportToken)) {
				/* TODO */
			} else if ("expand time".equals(currentImportToken)) {
				/* TODO */
			} else if ("web order ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web company ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web expand 1".equals(currentImportToken)) {
				/* TODO */
			} else if ("web extra".equals(currentImportToken)) {
				/* TODO */
			} else if ("web shipping ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Extra ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Comment rec".equals(currentImportToken)) {
				/* TODO */
			} else if ("web Comment Text".equals(currentImportToken)) {
				/* TODO */
			} else if ("web RFQ ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web reference ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web address ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("web payment approval code".equals(currentImportToken)) {
				/* TODO */
			} else if ("web payment amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("web payment type".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[21]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[22]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[23]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[24]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[25]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[26]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[27]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[28]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[29]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[30]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[31]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[32]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[33]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[34]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[35]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[36]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[37]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[38]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[39]".equals(currentImportToken)) {
				/* TODO */
			} else if ("sales category[40]".equals(currentImportToken)) {
				/* TODO */
			} else if ("markups".equals(currentImportToken)) {
				/* TODO */
			} else if ("dollar discount".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table ptr".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax table name".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("tax code name".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTableElementTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("showTheTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("useForSeparateShippingTax".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("inUse".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxTableDBRecNo".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableID".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxTable_taxCodeTableName".equals(currentImportToken)) {
				/* TODO */
			} else if ("effectiveTaxRate".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_shippingInAmount".equals(currentImportToken)) {
				/* TODO */
			} else if ("taxableAmount_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("calculatedTax_amountPaid".equals(currentImportToken)) {
				/* TODO */
			} else if ("card ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cct".equals(currentImportToken)) {
				/* TODO */
			} else if ("checkno".equals(currentImportToken)) {
				/* TODO */
			} else if ("date".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("type".equals(currentImportToken)) {
				/* TODO */
			} else if ("card ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cct".equals(currentImportToken)) {
				/* TODO */
			} else if ("checkno".equals(currentImportToken)) {
				/* TODO */
			} else if ("date".equals(currentImportToken)) {
				/* TODO */
			} else if ("amount".equals(currentImportToken)) {
				/* TODO */
			} else if ("type".equals(currentImportToken)) {
				/* TODO */
			} else if ("card ID".equals(currentImportToken)) {
				/* TODO */
			} else if ("cct".equals(currentImportToken)) {
				/* TODO */
			} else if ("oAddress".equals(currentImportToken)) {
				/* TODO */
			} else if ("auto show note pad".equals(currentImportToken)) {
				/* TODO */
			} else if ("price locked".equals(currentImportToken)) {
				/* TODO */
			} else if ("firmWantedBy".equals(currentImportToken)) {
				/* TODO */
			} else if ("invoice production release".equals(currentImportToken)) {
				/* TODO */
			} else if ("has inventoried stock".equals(currentImportToken)) {
				/* TODO */
			} else if ("discount is dollars".equals(currentImportToken)) {
				/* TODO */
			} else if ("discount is one time".equals(currentImportToken)) {
				/* TODO */
			} else if ("web payment auth waiting".equals(currentImportToken)) {
				/* TODO */
			} else if ("web payment complete".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[1]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[2]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[3]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[4]".equals(currentImportToken)) {
				/* TODO */
			} else if ("addl tax[5]".equals(currentImportToken)) {
				/* TODO */
			}
		}
		return invoice;
	}
}
