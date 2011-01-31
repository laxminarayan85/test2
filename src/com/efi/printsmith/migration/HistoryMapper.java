package com.efi.printsmith.migration;

import java.io.File;

import org.apache.log4j.Logger;

import com.efi.printsmith.data.Account;
import com.efi.printsmith.data.Address;
import com.efi.printsmith.data.ModelBase;
import com.efi.printsmith.data.TaxTable;
import com.efi.printsmith.service.DataService;
import com.efi.printsmith.data.AccountHistoryData;
import com.efi.printsmith.data.TapePaymentRecord;
import com.efi.printsmith.data.SalesRep;
import com.efi.printsmith.data.InvoiceBase;
import com.efi.printsmith.integration.xpedx.XpdexImportParams;
public class HistoryMapper extends ImportMapper {
	protected static Logger log = Logger.getLogger(HistoryMapper.class);
	public void importFile(File uploadedFile) throws Exception {
		
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens, XpdexImportParams importParams) {
		return null;
	}
	public ModelBase importTokens(String[] fieldTokens, String[] importTokens) throws Exception {
		log.info("Entering HistoryMapper->importTokens");
		Address address = new Address();
		DataService dataService = new DataService();
		AccountHistoryData accountHistoryData = new AccountHistoryData();
		TaxTable taxTable = new TaxTable();
		TapePaymentRecord partialPayment = new TapePaymentRecord();
		SalesRep salesrep = new SalesRep();
		for (int i=0; i < fieldTokens.length; i++) {
			String currentImportToken = importTokens[i];
			String currentFieldToken = fieldTokens[i];
			if ("recno".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rtype".equals(currentFieldToken)) {
				accountHistoryData.setRecordType(currentImportToken);
			} else if ("title".equals(currentFieldToken)) {
				accountHistoryData.setName(currentImportToken);
			} else if ("custno".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					Account account = (Account) dataService.getByAccountId(currentImportToken);
					if (account != null)
						accountHistoryData.setAccount(account);
				}
			} else if ("account name".equals(currentFieldToken)) {
				/* TODO */
			} else if ("ordno".equals(currentFieldToken)) {
				accountHistoryData.setOrderby(Utilities.tokenToInt(currentImportToken));
			} else if ("date posted".equals(currentFieldToken)) {
				accountHistoryData.setPostedDate(Utilities.tokenToDate(currentImportToken));
			} else if ("due date".equals(currentFieldToken)) {
				accountHistoryData.setPaymentDueDate(Utilities.tokenToDate(currentImportToken));
			} else if ("tax table".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax code".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax rate".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("sub total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("total".equals(currentFieldToken)) {
				/* TODO */
			} else if ("tax due".equals(currentFieldToken)) {
				
			} else if ("tax balance".equals(currentFieldToken)) {
				/* TODO */
			} else if ("refund".equals(currentFieldToken)) {
				accountHistoryData.setRefundTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("balance".equals(currentFieldToken)) {
				accountHistoryData.setBalance(Utilities.tokenToDouble(currentImportToken));
			} else if ("partial checkno".equals(currentFieldToken)) {
				accountHistoryData.setPartialPayCheckNumber(currentImportToken);
			} else if ("partial date".equals(currentFieldToken)) {
				accountHistoryData.setPartialPayPaydate(Utilities.tokenToDate(currentImportToken));
			} else if ("partial amount".equals(currentFieldToken)) {
				
			} else if ("partial type".equals(currentFieldToken)) {
				accountHistoryData.setPartialPayPayMethod(currentImportToken);
			} else if ("part count".equals(currentFieldToken)) {
				accountHistoryData.setPartialPayCnt(Utilities.tokenToDouble(currentImportToken));
			} else if ("partial total".equals(currentFieldToken)) {
				accountHistoryData.setPartialPayTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("final checkno".equals(currentFieldToken)) {
				accountHistoryData.setFinalPayCheckNumber(currentImportToken);
			} else if ("final date".equals(currentFieldToken)) {
				accountHistoryData.setFinalPaymentDate(Utilities.tokenToDate(currentImportToken));
			} else if ("final amount".equals(currentFieldToken)) {
				accountHistoryData.setFinalPayTotal(Utilities.tokenToDouble(currentImportToken));
			} else if ("final type".equals(currentFieldToken)) {
				accountHistoryData.setFinalPayPayMethod(currentImportToken);
			} else if ("special".equals(currentFieldToken)) {
				/* TODO */
			} else if ("rstatus".equals(currentFieldToken)) {
				/* TODO */
			} else if ("cust PO".equals(currentFieldToken)) {
				accountHistoryData.setCustPO(currentImportToken);
			} else if ("sales rep".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0
						&& !currentImportToken.equals(" ")) {
					 salesrep = (SalesRep) dataService.getByName("SalesRep", currentImportToken);
					if (salesrep == null) {
						salesrep = new SalesRep();
						salesrep.setName(currentImportToken);
						salesrep = (SalesRep)dataService.addUpdate(salesrep);
					}
					accountHistoryData.setSalesRep(salesrep);
				}
			} else if ("store number".equals(currentFieldToken)) {
				accountHistoryData.setStoreNumber(currentImportToken);
			} else if ("order display no".equals(currentFieldToken)) {
				accountHistoryData.setOrderNoDisplay(currentImportToken);
			} else if ("reference inv number".equals(currentFieldToken)) {
				if (currentImportToken.length() > 0
						&& !currentImportToken.equals(" ")) {
					 InvoiceBase invoice = (InvoiceBase) dataService.getByPrevId("InvoiceBase", currentImportToken);
					 if ( invoice != null)
						 accountHistoryData.setInvoice(invoice);
				}
			} else if ("web reference ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("inUse".equals(currentFieldToken)) {
				/* TODO */
			} else if ("taxTable_taxTableTableID".equals(currentFieldToken)) {
				if (currentImportToken.equals("0") == false) {
					 taxTable = (TaxTable)dataService.getByPrevId("TaxTable", currentImportToken);
					if (taxTable != null)
						accountHistoryData.setTaxDetail(taxTable);
				}
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
			} else if ("partial card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("partial cct".equals(currentFieldToken)) {
				/* TODO */
			} else if ("final card ID".equals(currentFieldToken)) {
				/* TODO */
			} else if ("final cct".equals(currentFieldToken)) {
				/* TODO */
			}
		}
		log.info("Leaving HistoryMapper->importTokens");
		return accountHistoryData;
	}
}
