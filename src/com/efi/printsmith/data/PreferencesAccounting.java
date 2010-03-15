package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "PreferencesAccounting.findall", query = "from PreferencesAccounting"),
	@NamedQuery(name = "PreferencesAccounting.byId", query = "select a from PreferencesAccounting a where a.id= :id")
})


@Entity
@Table(name = "preferencesaccounting")
public class PreferencesAccounting extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CREDITLIMIT = "CreditLimit";
	/**
	 * @generated
	 */
	public static final String FINANCECHANGE = "FinanceChange";
	/**
	 * @generated
	 */
	public static final String INACTIVEPERIOD = "InactivePeriod";
	/**
	 * @generated
	 */
	public static final String REMOVEDRAFTSFROMDEPOSIT = "RemoveDraftsFromDeposit";
	/**
	 * @generated
	 */
	public static final String DEFAULTSALESREP = "DefaultSalesRep";
	/**
	 * @generated
	 */
	public static final String DEFAULTSHIPPING = "DefaultShipping";
	/**
	 * @generated
	 */
	public static final String PASTDUE = "PastDue";
	/**
	 * @generated
	 */
	public static final String PASTDUENOTE = "PastDueNote";
	/**
	 * @generated
	 */
	public static final String DELINQUENT = "Delinquent";
	/**
	 * @generated
	 */
	public static final String DELINQUENTNOTE = "DelinquentNote";
	/**
	 * @generated
	 */
	public static final String FROZEN = "Frozen";
	/**
	 * @generated
	 */
	public static final String FROZENNOTE = "FrozenNote";
	/**
	 * @generated
	 */
	public static final String ACTIVATECREDITCARDAPPROVAL = "ActivateCreditCardApproval";
	/**
	 * @generated
	 */
	public static final String INVOICEPREFIX = "InvoicePrefix";
	/**
	 * @generated
	 */
	public static final String INVOICEDOCUMENT = "InvoiceDocument";
	/**
	 * @generated
	 */
	public static final String INVOICESUFFIX = "InvoiceSuffix";
	/**
	 * @generated
	 */
	public static final String INVOICEALLOWPREFIXMOD = "InvoiceAllowPrefixMod";
	/**
	 * @generated
	 */
	public static final String INVOICEALLOWSUFFIXMOD = "InvoiceAllowSuffixMod";
	/**
	 * @generated
	 */
	public static final String ESTIMATEPREFIX = "EstimatePrefix";
	/**
	 * @generated
	 */
	public static final String ESTIMATEDOCUMENT = "EstimateDocument";
	/**
	 * @generated
	 */
	public static final String ESTIMATESUFFIX = "EstimateSuffix";
	/**
	 * @generated
	 */
	public static final String ESTIMATEALLOWPREFIXMOD = "EstimateAllowPrefixMod";
	/**
	 * @generated
	 */
	public static final String ESTIMATEALLOWSUFFIXMOD = "EstimateAllowSuffixMod";
	/**
	 * @generated
	 */
	public static final String PRINTDOCUMENT = "PrintDocument";
	/**
	 * @generated
	 */
	public static final String JOURNALDOCUMENTPREFERENCE = "JournalDocumentPreference";
	/**
	 * @generated
	 */
	public static final String ACCOUNTINGLINKTO = "AccountingLinkTo";
	/**
	 * @generated
	 */
	public static final String SHIPPINGCOLLECTED = "ShippingCollected";
	/**
	 * @generated
	 */
	public static final String ACTUALBANKDEPOSIT = "ActualBankDeposit";
	/**
	 * @generated
	 */
	public static final String UNDEPOSITEDRECEIPTS = "UndepositedReceipts";
	/**
	 * @generated
	 */
	public static final String DISCOUNTS = "Discounts";
	/**
	 * @generated
	 */
	public static final String SALESTAX = "SalesTax";
	/**
	 * @generated
	 */
	public static final String TOTALARRECEIPTS = "TotalARReceipts";
	/**
	 * @generated
	 */
	public static final String DEPOSITSONINVOICES = "DepositsOnInvoices";
	/**
	 * @generated
	 */
	public static final String NEWCHARGESTOAR = "NewChargesToAR";
	/**
	 * @generated
	 */
	public static final String CASHOVERSHORT = "CashOverShort";
	/**
	 * @generated
	 */
	public static final String PAIDOUT = "PaidOut";
	/**
	 * @generated
	 */
	public static final String REFUNDCHECKS = "RefundChecks";
	/**
	 * @generated
	 */
	public static final String USEOBSOLETEDROPFOLDER = "UseObsoleteDropFolder";
	/**
	 * @generated
	 */
	public static final String USESKIPJACKPROCESSOR = "UseSkipJackProcessor";
	/**
	 * @generated
	 */
	public static final String USEEFSPROCESSOR = "UseEfsProcessor";
	/**
	 * @generated
	 */
	public static final String CREDITCARDDROPFOLDER = "CreditCardDropFolder";
	/**
	 * @generated
	 */
	public static final String SKIPJACKMODE = "SkipJackMode";
	/**
	 * @generated
	 */
	public static final String INTERNETURL = "InternetURL";
	/**
	 * @generated
	 */
	public static final String SERIALNUMBER = "SerialNumber";
	/**
	 * @generated
	 */
	public static final String DEVELOPMENTNUMBER = "DevelopmentNumber";
	/**
	 * @generated
	 */
	public static final String PORTNUMBER = "PortNumber";
	/**
	 * @generated
	 */
	public static final String MERCHANTID = "MerchantID";
	/**
	 * @generated
	 */
	public static final String MERCHANTKEY = "MerchantKey";
	/**
	 * @generated
	 */
	public static final String USEADDRESSVALIDATION = "UseAddressValidation";
	/**
	 * @generated
	 */
	public static final String PROMPTUSERFORVALIDATIONINFO = "PromptUserForValidationInfo";

	/**
	 * @generated
	 */
	public PreferencesAccounting() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double creditLimit;
	
	/**
	 * @generated
 	 */
	public Double getCreditLimit(){
		return creditLimit; 
	}

	
	/**
	 * @generated
	 */	
	public void setCreditLimit(Double newVal) {
		this.creditLimit = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double financeChange;
	
	/**
	 * @generated
 	 */
	public Double getFinanceChange(){
		return financeChange; 
	}

	
	/**
	 * @generated
	 */	
	public void setFinanceChange(Double newVal) {
		this.financeChange = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double inactivePeriod;
	
	/**
	 * @generated
 	 */
	public Double getInactivePeriod(){
		return inactivePeriod; 
	}

	
	/**
	 * @generated
	 */	
	public void setInactivePeriod(Double newVal) {
		this.inactivePeriod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean removeDraftsFromDeposit;
	
	/**
	 * @generated
 	 */
	public Boolean getRemoveDraftsFromDeposit(){
		return removeDraftsFromDeposit; 
	}

	
	/**
	 * @generated
	 */	
	public void setRemoveDraftsFromDeposit(Boolean newVal) {
		this.removeDraftsFromDeposit = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String defaultSalesRep;
	
	/**
	 * @generated
 	 */
	public String getDefaultSalesRep(){
		return defaultSalesRep; 
	}

	
	/**
	 * @generated
	 */	
	public void setDefaultSalesRep(String newVal) {
		this.defaultSalesRep = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String defaultShipping;
	
	/**
	 * @generated
 	 */
	public String getDefaultShipping(){
		return defaultShipping; 
	}

	
	/**
	 * @generated
	 */	
	public void setDefaultShipping(String newVal) {
		this.defaultShipping = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer pastDue;
	
	/**
	 * @generated
 	 */
	public Integer getPastDue(){
		return pastDue; 
	}

	
	/**
	 * @generated
	 */	
	public void setPastDue(Integer newVal) {
		this.pastDue = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String pastDueNote;
	
	/**
	 * @generated
 	 */
	public String getPastDueNote(){
		return pastDueNote; 
	}

	
	/**
	 * @generated
	 */	
	public void setPastDueNote(String newVal) {
		this.pastDueNote = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer delinquent;
	
	/**
	 * @generated
 	 */
	public Integer getDelinquent(){
		return delinquent; 
	}

	
	/**
	 * @generated
	 */	
	public void setDelinquent(Integer newVal) {
		this.delinquent = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String delinquentNote;
	
	/**
	 * @generated
 	 */
	public String getDelinquentNote(){
		return delinquentNote; 
	}

	
	/**
	 * @generated
	 */	
	public void setDelinquentNote(String newVal) {
		this.delinquentNote = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer frozen;
	
	/**
	 * @generated
 	 */
	public Integer getFrozen(){
		return frozen; 
	}

	
	/**
	 * @generated
	 */	
	public void setFrozen(Integer newVal) {
		this.frozen = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String frozenNote;
	
	/**
	 * @generated
 	 */
	public String getFrozenNote(){
		return frozenNote; 
	}

	
	/**
	 * @generated
	 */	
	public void setFrozenNote(String newVal) {
		this.frozenNote = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean activateCreditCardApproval;
	
	/**
	 * @generated
 	 */
	public Boolean getActivateCreditCardApproval(){
		return activateCreditCardApproval; 
	}

	
	/**
	 * @generated
	 */	
	public void setActivateCreditCardApproval(Boolean newVal) {
		this.activateCreditCardApproval = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String invoicePrefix;
	
	/**
	 * @generated
 	 */
	public String getInvoicePrefix(){
		return invoicePrefix; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoicePrefix(String newVal) {
		this.invoicePrefix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String invoiceDocument;
	
	/**
	 * @generated
 	 */
	public String getInvoiceDocument(){
		return invoiceDocument; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceDocument(String newVal) {
		this.invoiceDocument = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String invoiceSuffix;
	
	/**
	 * @generated
 	 */
	public String getInvoiceSuffix(){
		return invoiceSuffix; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceSuffix(String newVal) {
		this.invoiceSuffix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean invoiceAllowPrefixMod;
	
	/**
	 * @generated
 	 */
	public Boolean getInvoiceAllowPrefixMod(){
		return invoiceAllowPrefixMod; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceAllowPrefixMod(Boolean newVal) {
		this.invoiceAllowPrefixMod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean invoiceAllowSuffixMod;
	
	/**
	 * @generated
 	 */
	public Boolean getInvoiceAllowSuffixMod(){
		return invoiceAllowSuffixMod; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceAllowSuffixMod(Boolean newVal) {
		this.invoiceAllowSuffixMod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String estimatePrefix;
	
	/**
	 * @generated
 	 */
	public String getEstimatePrefix(){
		return estimatePrefix; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstimatePrefix(String newVal) {
		this.estimatePrefix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String estimateDocument;
	
	/**
	 * @generated
 	 */
	public String getEstimateDocument(){
		return estimateDocument; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstimateDocument(String newVal) {
		this.estimateDocument = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String estimateSuffix;
	
	/**
	 * @generated
 	 */
	public String getEstimateSuffix(){
		return estimateSuffix; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstimateSuffix(String newVal) {
		this.estimateSuffix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean estimateAllowPrefixMod;
	
	/**
	 * @generated
 	 */
	public Boolean getEstimateAllowPrefixMod(){
		return estimateAllowPrefixMod; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstimateAllowPrefixMod(Boolean newVal) {
		this.estimateAllowPrefixMod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean estimateAllowSuffixMod;
	
	/**
	 * @generated
 	 */
	public Boolean getEstimateAllowSuffixMod(){
		return estimateAllowSuffixMod; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstimateAllowSuffixMod(Boolean newVal) {
		this.estimateAllowSuffixMod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean printDocument;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintDocument(){
		return printDocument; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrintDocument(Boolean newVal) {
		this.printDocument = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String journalDocumentPreference;
	
	/**
	 * @generated
 	 */
	public String getJournalDocumentPreference(){
		return journalDocumentPreference; 
	}

	
	/**
	 * @generated
	 */	
	public void setJournalDocumentPreference(String newVal) {
		this.journalDocumentPreference = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String accountingLinkTo;
	
	/**
	 * @generated
 	 */
	public String getAccountingLinkTo(){
		return accountingLinkTo; 
	}

	
	/**
	 * @generated
	 */	
	public void setAccountingLinkTo(String newVal) {
		this.accountingLinkTo = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String shippingCollected;
	
	/**
	 * @generated
 	 */
	public String getShippingCollected(){
		return shippingCollected; 
	}

	
	/**
	 * @generated
	 */	
	public void setShippingCollected(String newVal) {
		this.shippingCollected = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String actualBankDeposit;
	
	/**
	 * @generated
 	 */
	public String getActualBankDeposit(){
		return actualBankDeposit; 
	}

	
	/**
	 * @generated
	 */	
	public void setActualBankDeposit(String newVal) {
		this.actualBankDeposit = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String undepositedReceipts;
	
	/**
	 * @generated
 	 */
	public String getUndepositedReceipts(){
		return undepositedReceipts; 
	}

	
	/**
	 * @generated
	 */	
	public void setUndepositedReceipts(String newVal) {
		this.undepositedReceipts = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String discounts;
	
	/**
	 * @generated
 	 */
	public String getDiscounts(){
		return discounts; 
	}

	
	/**
	 * @generated
	 */	
	public void setDiscounts(String newVal) {
		this.discounts = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String salesTax;
	
	/**
	 * @generated
 	 */
	public String getSalesTax(){
		return salesTax; 
	}

	
	/**
	 * @generated
	 */	
	public void setSalesTax(String newVal) {
		this.salesTax = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String totalARReceipts;
	
	/**
	 * @generated
 	 */
	public String getTotalARReceipts(){
		return totalARReceipts; 
	}

	
	/**
	 * @generated
	 */	
	public void setTotalARReceipts(String newVal) {
		this.totalARReceipts = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String depositsOnInvoices;
	
	/**
	 * @generated
 	 */
	public String getDepositsOnInvoices(){
		return depositsOnInvoices; 
	}

	
	/**
	 * @generated
	 */	
	public void setDepositsOnInvoices(String newVal) {
		this.depositsOnInvoices = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String newChargesToAR;
	
	/**
	 * @generated
 	 */
	public String getNewChargesToAR(){
		return newChargesToAR; 
	}

	
	/**
	 * @generated
	 */	
	public void setNewChargesToAR(String newVal) {
		this.newChargesToAR = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cashOverShort;
	
	/**
	 * @generated
 	 */
	public String getCashOverShort(){
		return cashOverShort; 
	}

	
	/**
	 * @generated
	 */	
	public void setCashOverShort(String newVal) {
		this.cashOverShort = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String paidOut;
	
	/**
	 * @generated
 	 */
	public String getPaidOut(){
		return paidOut; 
	}

	
	/**
	 * @generated
	 */	
	public void setPaidOut(String newVal) {
		this.paidOut = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String refundChecks;
	
	/**
	 * @generated
 	 */
	public String getRefundChecks(){
		return refundChecks; 
	}

	
	/**
	 * @generated
	 */	
	public void setRefundChecks(String newVal) {
		this.refundChecks = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useObsoleteDropFolder;
	
	/**
	 * @generated
 	 */
	public Boolean getUseObsoleteDropFolder(){
		return useObsoleteDropFolder; 
	}

	
	/**
	 * @generated
	 */	
	public void setUseObsoleteDropFolder(Boolean newVal) {
		this.useObsoleteDropFolder = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useSkipJackProcessor;
	
	/**
	 * @generated
 	 */
	public Boolean getUseSkipJackProcessor(){
		return useSkipJackProcessor; 
	}

	
	/**
	 * @generated
	 */	
	public void setUseSkipJackProcessor(Boolean newVal) {
		this.useSkipJackProcessor = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useEfsProcessor;
	
	/**
	 * @generated
 	 */
	public Boolean getUseEfsProcessor(){
		return useEfsProcessor; 
	}

	
	/**
	 * @generated
	 */	
	public void setUseEfsProcessor(Boolean newVal) {
		this.useEfsProcessor = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String creditCardDropFolder;
	
	/**
	 * @generated
 	 */
	public String getCreditCardDropFolder(){
		return creditCardDropFolder; 
	}

	
	/**
	 * @generated
	 */	
	public void setCreditCardDropFolder(String newVal) {
		this.creditCardDropFolder = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer skipJackMode;
	
	/**
	 * @generated
 	 */
	public Integer getSkipJackMode(){
		return skipJackMode; 
	}

	
	/**
	 * @generated
	 */	
	public void setSkipJackMode(Integer newVal) {
		this.skipJackMode = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String internetURL;
	
	/**
	 * @generated
 	 */
	public String getInternetURL(){
		return internetURL; 
	}

	
	/**
	 * @generated
	 */	
	public void setInternetURL(String newVal) {
		this.internetURL = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String serialNumber;
	
	/**
	 * @generated
 	 */
	public String getSerialNumber(){
		return serialNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setSerialNumber(String newVal) {
		this.serialNumber = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String developmentNumber;
	
	/**
	 * @generated
 	 */
	public String getDevelopmentNumber(){
		return developmentNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setDevelopmentNumber(String newVal) {
		this.developmentNumber = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String portNumber;
	
	/**
	 * @generated
 	 */
	public String getPortNumber(){
		return portNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setPortNumber(String newVal) {
		this.portNumber = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String merchantID;
	
	/**
	 * @generated
 	 */
	public String getMerchantID(){
		return merchantID; 
	}

	
	/**
	 * @generated
	 */	
	public void setMerchantID(String newVal) {
		this.merchantID = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String merchantKey;
	
	/**
	 * @generated
 	 */
	public String getMerchantKey(){
		return merchantKey; 
	}

	
	/**
	 * @generated
	 */	
	public void setMerchantKey(String newVal) {
		this.merchantKey = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useAddressValidation;
	
	/**
	 * @generated
 	 */
	public Boolean getUseAddressValidation(){
		return useAddressValidation; 
	}

	
	/**
	 * @generated
	 */	
	public void setUseAddressValidation(Boolean newVal) {
		this.useAddressValidation = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean promptUserForValidationInfo;
	
	/**
	 * @generated
 	 */
	public Boolean getPromptUserForValidationInfo(){
		return promptUserForValidationInfo; 
	}

	
	/**
	 * @generated
	 */	
	public void setPromptUserForValidationInfo(Boolean newVal) {
		this.promptUserForValidationInfo = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CREDITLIMIT.equals(propertyName)) return getCreditLimit();
		if (FINANCECHANGE.equals(propertyName)) return getFinanceChange();
		if (INACTIVEPERIOD.equals(propertyName)) return getInactivePeriod();
		if (REMOVEDRAFTSFROMDEPOSIT.equals(propertyName)) return getRemoveDraftsFromDeposit();
		if (DEFAULTSALESREP.equals(propertyName)) return getDefaultSalesRep();
		if (DEFAULTSHIPPING.equals(propertyName)) return getDefaultShipping();
		if (PASTDUE.equals(propertyName)) return getPastDue();
		if (PASTDUENOTE.equals(propertyName)) return getPastDueNote();
		if (DELINQUENT.equals(propertyName)) return getDelinquent();
		if (DELINQUENTNOTE.equals(propertyName)) return getDelinquentNote();
		if (FROZEN.equals(propertyName)) return getFrozen();
		if (FROZENNOTE.equals(propertyName)) return getFrozenNote();
		if (ACTIVATECREDITCARDAPPROVAL.equals(propertyName)) return getActivateCreditCardApproval();
		if (INVOICEPREFIX.equals(propertyName)) return getInvoicePrefix();
		if (INVOICEDOCUMENT.equals(propertyName)) return getInvoiceDocument();
		if (INVOICESUFFIX.equals(propertyName)) return getInvoiceSuffix();
		if (INVOICEALLOWPREFIXMOD.equals(propertyName)) return getInvoiceAllowPrefixMod();
		if (INVOICEALLOWSUFFIXMOD.equals(propertyName)) return getInvoiceAllowSuffixMod();
		if (ESTIMATEPREFIX.equals(propertyName)) return getEstimatePrefix();
		if (ESTIMATEDOCUMENT.equals(propertyName)) return getEstimateDocument();
		if (ESTIMATESUFFIX.equals(propertyName)) return getEstimateSuffix();
		if (ESTIMATEALLOWPREFIXMOD.equals(propertyName)) return getEstimateAllowPrefixMod();
		if (ESTIMATEALLOWSUFFIXMOD.equals(propertyName)) return getEstimateAllowSuffixMod();
		if (PRINTDOCUMENT.equals(propertyName)) return getPrintDocument();
		if (JOURNALDOCUMENTPREFERENCE.equals(propertyName)) return getJournalDocumentPreference();
		if (ACCOUNTINGLINKTO.equals(propertyName)) return getAccountingLinkTo();
		if (SHIPPINGCOLLECTED.equals(propertyName)) return getShippingCollected();
		if (ACTUALBANKDEPOSIT.equals(propertyName)) return getActualBankDeposit();
		if (UNDEPOSITEDRECEIPTS.equals(propertyName)) return getUndepositedReceipts();
		if (DISCOUNTS.equals(propertyName)) return getDiscounts();
		if (SALESTAX.equals(propertyName)) return getSalesTax();
		if (TOTALARRECEIPTS.equals(propertyName)) return getTotalARReceipts();
		if (DEPOSITSONINVOICES.equals(propertyName)) return getDepositsOnInvoices();
		if (NEWCHARGESTOAR.equals(propertyName)) return getNewChargesToAR();
		if (CASHOVERSHORT.equals(propertyName)) return getCashOverShort();
		if (PAIDOUT.equals(propertyName)) return getPaidOut();
		if (REFUNDCHECKS.equals(propertyName)) return getRefundChecks();
		if (USEOBSOLETEDROPFOLDER.equals(propertyName)) return getUseObsoleteDropFolder();
		if (USESKIPJACKPROCESSOR.equals(propertyName)) return getUseSkipJackProcessor();
		if (USEEFSPROCESSOR.equals(propertyName)) return getUseEfsProcessor();
		if (CREDITCARDDROPFOLDER.equals(propertyName)) return getCreditCardDropFolder();
		if (SKIPJACKMODE.equals(propertyName)) return getSkipJackMode();
		if (INTERNETURL.equals(propertyName)) return getInternetURL();
		if (SERIALNUMBER.equals(propertyName)) return getSerialNumber();
		if (DEVELOPMENTNUMBER.equals(propertyName)) return getDevelopmentNumber();
		if (PORTNUMBER.equals(propertyName)) return getPortNumber();
		if (MERCHANTID.equals(propertyName)) return getMerchantID();
		if (MERCHANTKEY.equals(propertyName)) return getMerchantKey();
		if (USEADDRESSVALIDATION.equals(propertyName)) return getUseAddressValidation();
		if (PROMPTUSERFORVALIDATIONINFO.equals(propertyName)) return getPromptUserForValidationInfo();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CREDITLIMIT.equals(propertyName)) setCreditLimit((Double)newValue); else
		if (FINANCECHANGE.equals(propertyName)) setFinanceChange((Double)newValue); else
		if (INACTIVEPERIOD.equals(propertyName)) setInactivePeriod((Double)newValue); else
		if (REMOVEDRAFTSFROMDEPOSIT.equals(propertyName)) setRemoveDraftsFromDeposit((Boolean)newValue); else
		if (DEFAULTSALESREP.equals(propertyName)) setDefaultSalesRep((String)newValue); else
		if (DEFAULTSHIPPING.equals(propertyName)) setDefaultShipping((String)newValue); else
		if (PASTDUE.equals(propertyName)) setPastDue((Integer)newValue); else
		if (PASTDUENOTE.equals(propertyName)) setPastDueNote((String)newValue); else
		if (DELINQUENT.equals(propertyName)) setDelinquent((Integer)newValue); else
		if (DELINQUENTNOTE.equals(propertyName)) setDelinquentNote((String)newValue); else
		if (FROZEN.equals(propertyName)) setFrozen((Integer)newValue); else
		if (FROZENNOTE.equals(propertyName)) setFrozenNote((String)newValue); else
		if (ACTIVATECREDITCARDAPPROVAL.equals(propertyName)) setActivateCreditCardApproval((Boolean)newValue); else
		if (INVOICEPREFIX.equals(propertyName)) setInvoicePrefix((String)newValue); else
		if (INVOICEDOCUMENT.equals(propertyName)) setInvoiceDocument((String)newValue); else
		if (INVOICESUFFIX.equals(propertyName)) setInvoiceSuffix((String)newValue); else
		if (INVOICEALLOWPREFIXMOD.equals(propertyName)) setInvoiceAllowPrefixMod((Boolean)newValue); else
		if (INVOICEALLOWSUFFIXMOD.equals(propertyName)) setInvoiceAllowSuffixMod((Boolean)newValue); else
		if (ESTIMATEPREFIX.equals(propertyName)) setEstimatePrefix((String)newValue); else
		if (ESTIMATEDOCUMENT.equals(propertyName)) setEstimateDocument((String)newValue); else
		if (ESTIMATESUFFIX.equals(propertyName)) setEstimateSuffix((String)newValue); else
		if (ESTIMATEALLOWPREFIXMOD.equals(propertyName)) setEstimateAllowPrefixMod((Boolean)newValue); else
		if (ESTIMATEALLOWSUFFIXMOD.equals(propertyName)) setEstimateAllowSuffixMod((Boolean)newValue); else
		if (PRINTDOCUMENT.equals(propertyName)) setPrintDocument((Boolean)newValue); else
		if (JOURNALDOCUMENTPREFERENCE.equals(propertyName)) setJournalDocumentPreference((String)newValue); else
		if (ACCOUNTINGLINKTO.equals(propertyName)) setAccountingLinkTo((String)newValue); else
		if (SHIPPINGCOLLECTED.equals(propertyName)) setShippingCollected((String)newValue); else
		if (ACTUALBANKDEPOSIT.equals(propertyName)) setActualBankDeposit((String)newValue); else
		if (UNDEPOSITEDRECEIPTS.equals(propertyName)) setUndepositedReceipts((String)newValue); else
		if (DISCOUNTS.equals(propertyName)) setDiscounts((String)newValue); else
		if (SALESTAX.equals(propertyName)) setSalesTax((String)newValue); else
		if (TOTALARRECEIPTS.equals(propertyName)) setTotalARReceipts((String)newValue); else
		if (DEPOSITSONINVOICES.equals(propertyName)) setDepositsOnInvoices((String)newValue); else
		if (NEWCHARGESTOAR.equals(propertyName)) setNewChargesToAR((String)newValue); else
		if (CASHOVERSHORT.equals(propertyName)) setCashOverShort((String)newValue); else
		if (PAIDOUT.equals(propertyName)) setPaidOut((String)newValue); else
		if (REFUNDCHECKS.equals(propertyName)) setRefundChecks((String)newValue); else
		if (USEOBSOLETEDROPFOLDER.equals(propertyName)) setUseObsoleteDropFolder((Boolean)newValue); else
		if (USESKIPJACKPROCESSOR.equals(propertyName)) setUseSkipJackProcessor((Boolean)newValue); else
		if (USEEFSPROCESSOR.equals(propertyName)) setUseEfsProcessor((Boolean)newValue); else
		if (CREDITCARDDROPFOLDER.equals(propertyName)) setCreditCardDropFolder((String)newValue); else
		if (SKIPJACKMODE.equals(propertyName)) setSkipJackMode((Integer)newValue); else
		if (INTERNETURL.equals(propertyName)) setInternetURL((String)newValue); else
		if (SERIALNUMBER.equals(propertyName)) setSerialNumber((String)newValue); else
		if (DEVELOPMENTNUMBER.equals(propertyName)) setDevelopmentNumber((String)newValue); else
		if (PORTNUMBER.equals(propertyName)) setPortNumber((String)newValue); else
		if (MERCHANTID.equals(propertyName)) setMerchantID((String)newValue); else
		if (MERCHANTKEY.equals(propertyName)) setMerchantKey((String)newValue); else
		if (USEADDRESSVALIDATION.equals(propertyName)) setUseAddressValidation((Boolean)newValue); else
		if (PROMPTUSERFORVALIDATIONINFO.equals(propertyName)) setPromptUserForValidationInfo((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CREDITLIMIT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (FINANCECHANGE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (INACTIVEPERIOD.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (REMOVEDRAFTSFROMDEPOSIT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DEFAULTSALESREP.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DEFAULTSHIPPING.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PASTDUE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PASTDUENOTE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DELINQUENT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DELINQUENTNOTE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FROZEN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FROZENNOTE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ACTIVATECREDITCARDAPPROVAL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INVOICEPREFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (INVOICEDOCUMENT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (INVOICESUFFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (INVOICEALLOWPREFIXMOD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INVOICEALLOWSUFFIXMOD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ESTIMATEPREFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ESTIMATEDOCUMENT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ESTIMATESUFFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ESTIMATEALLOWPREFIXMOD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ESTIMATEALLOWSUFFIXMOD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRINTDOCUMENT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (JOURNALDOCUMENTPREFERENCE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ACCOUNTINGLINKTO.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SHIPPINGCOLLECTED.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ACTUALBANKDEPOSIT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (UNDEPOSITEDRECEIPTS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DISCOUNTS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESTAX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TOTALARRECEIPTS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DEPOSITSONINVOICES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NEWCHARGESTOAR.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CASHOVERSHORT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PAIDOUT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (REFUNDCHECKS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USEOBSOLETEDROPFOLDER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USESKIPJACKPROCESSOR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USEEFSPROCESSOR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CREDITCARDDROPFOLDER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SKIPJACKMODE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (INTERNETURL.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SERIALNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DEVELOPMENTNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PORTNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MERCHANTID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MERCHANTKEY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USEADDRESSVALIDATION.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PROMPTUSERFORVALIDATIONINFO.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CREDITLIMIT.equals(propertyName)) return PreferencesAccounting.class;
		if (FINANCECHANGE.equals(propertyName)) return PreferencesAccounting.class;
		if (INACTIVEPERIOD.equals(propertyName)) return PreferencesAccounting.class;
		if (REMOVEDRAFTSFROMDEPOSIT.equals(propertyName)) return PreferencesAccounting.class;
		if (DEFAULTSALESREP.equals(propertyName)) return PreferencesAccounting.class;
		if (DEFAULTSHIPPING.equals(propertyName)) return PreferencesAccounting.class;
		if (PASTDUE.equals(propertyName)) return PreferencesAccounting.class;
		if (PASTDUENOTE.equals(propertyName)) return PreferencesAccounting.class;
		if (DELINQUENT.equals(propertyName)) return PreferencesAccounting.class;
		if (DELINQUENTNOTE.equals(propertyName)) return PreferencesAccounting.class;
		if (FROZEN.equals(propertyName)) return PreferencesAccounting.class;
		if (FROZENNOTE.equals(propertyName)) return PreferencesAccounting.class;
		if (ACTIVATECREDITCARDAPPROVAL.equals(propertyName)) return PreferencesAccounting.class;
		if (INVOICEPREFIX.equals(propertyName)) return PreferencesAccounting.class;
		if (INVOICEDOCUMENT.equals(propertyName)) return PreferencesAccounting.class;
		if (INVOICESUFFIX.equals(propertyName)) return PreferencesAccounting.class;
		if (INVOICEALLOWPREFIXMOD.equals(propertyName)) return PreferencesAccounting.class;
		if (INVOICEALLOWSUFFIXMOD.equals(propertyName)) return PreferencesAccounting.class;
		if (ESTIMATEPREFIX.equals(propertyName)) return PreferencesAccounting.class;
		if (ESTIMATEDOCUMENT.equals(propertyName)) return PreferencesAccounting.class;
		if (ESTIMATESUFFIX.equals(propertyName)) return PreferencesAccounting.class;
		if (ESTIMATEALLOWPREFIXMOD.equals(propertyName)) return PreferencesAccounting.class;
		if (ESTIMATEALLOWSUFFIXMOD.equals(propertyName)) return PreferencesAccounting.class;
		if (PRINTDOCUMENT.equals(propertyName)) return PreferencesAccounting.class;
		if (JOURNALDOCUMENTPREFERENCE.equals(propertyName)) return PreferencesAccounting.class;
		if (ACCOUNTINGLINKTO.equals(propertyName)) return PreferencesAccounting.class;
		if (SHIPPINGCOLLECTED.equals(propertyName)) return PreferencesAccounting.class;
		if (ACTUALBANKDEPOSIT.equals(propertyName)) return PreferencesAccounting.class;
		if (UNDEPOSITEDRECEIPTS.equals(propertyName)) return PreferencesAccounting.class;
		if (DISCOUNTS.equals(propertyName)) return PreferencesAccounting.class;
		if (SALESTAX.equals(propertyName)) return PreferencesAccounting.class;
		if (TOTALARRECEIPTS.equals(propertyName)) return PreferencesAccounting.class;
		if (DEPOSITSONINVOICES.equals(propertyName)) return PreferencesAccounting.class;
		if (NEWCHARGESTOAR.equals(propertyName)) return PreferencesAccounting.class;
		if (CASHOVERSHORT.equals(propertyName)) return PreferencesAccounting.class;
		if (PAIDOUT.equals(propertyName)) return PreferencesAccounting.class;
		if (REFUNDCHECKS.equals(propertyName)) return PreferencesAccounting.class;
		if (USEOBSOLETEDROPFOLDER.equals(propertyName)) return PreferencesAccounting.class;
		if (USESKIPJACKPROCESSOR.equals(propertyName)) return PreferencesAccounting.class;
		if (USEEFSPROCESSOR.equals(propertyName)) return PreferencesAccounting.class;
		if (CREDITCARDDROPFOLDER.equals(propertyName)) return PreferencesAccounting.class;
		if (SKIPJACKMODE.equals(propertyName)) return PreferencesAccounting.class;
		if (INTERNETURL.equals(propertyName)) return PreferencesAccounting.class;
		if (SERIALNUMBER.equals(propertyName)) return PreferencesAccounting.class;
		if (DEVELOPMENTNUMBER.equals(propertyName)) return PreferencesAccounting.class;
		if (PORTNUMBER.equals(propertyName)) return PreferencesAccounting.class;
		if (MERCHANTID.equals(propertyName)) return PreferencesAccounting.class;
		if (MERCHANTKEY.equals(propertyName)) return PreferencesAccounting.class;
		if (USEADDRESSVALIDATION.equals(propertyName)) return PreferencesAccounting.class;
		if (PROMPTUSERFORVALIDATIONINFO.equals(propertyName)) return PreferencesAccounting.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesAccounting objT = (PreferencesAccounting)obj;
		if (! SmartEquals(getCreditLimit(), objT.getCreditLimit()))
			return false;
		if (! SmartEquals(getFinanceChange(), objT.getFinanceChange()))
			return false;
		if (! SmartEquals(getInactivePeriod(), objT.getInactivePeriod()))
			return false;
		if (! SmartEquals(getRemoveDraftsFromDeposit(), objT.getRemoveDraftsFromDeposit()))
			return false;
		if (! SmartEquals(getDefaultSalesRep(), objT.getDefaultSalesRep()))
			return false;
		if (! SmartEquals(getDefaultShipping(), objT.getDefaultShipping()))
			return false;
		if (! SmartEquals(getPastDue(), objT.getPastDue()))
			return false;
		if (! SmartEquals(getPastDueNote(), objT.getPastDueNote()))
			return false;
		if (! SmartEquals(getDelinquent(), objT.getDelinquent()))
			return false;
		if (! SmartEquals(getDelinquentNote(), objT.getDelinquentNote()))
			return false;
		if (! SmartEquals(getFrozen(), objT.getFrozen()))
			return false;
		if (! SmartEquals(getFrozenNote(), objT.getFrozenNote()))
			return false;
		if (! SmartEquals(getActivateCreditCardApproval(), objT.getActivateCreditCardApproval()))
			return false;
		if (! SmartEquals(getInvoicePrefix(), objT.getInvoicePrefix()))
			return false;
		if (! SmartEquals(getInvoiceDocument(), objT.getInvoiceDocument()))
			return false;
		if (! SmartEquals(getInvoiceSuffix(), objT.getInvoiceSuffix()))
			return false;
		if (! SmartEquals(getInvoiceAllowPrefixMod(), objT.getInvoiceAllowPrefixMod()))
			return false;
		if (! SmartEquals(getInvoiceAllowSuffixMod(), objT.getInvoiceAllowSuffixMod()))
			return false;
		if (! SmartEquals(getEstimatePrefix(), objT.getEstimatePrefix()))
			return false;
		if (! SmartEquals(getEstimateDocument(), objT.getEstimateDocument()))
			return false;
		if (! SmartEquals(getEstimateSuffix(), objT.getEstimateSuffix()))
			return false;
		if (! SmartEquals(getEstimateAllowPrefixMod(), objT.getEstimateAllowPrefixMod()))
			return false;
		if (! SmartEquals(getEstimateAllowSuffixMod(), objT.getEstimateAllowSuffixMod()))
			return false;
		if (! SmartEquals(getPrintDocument(), objT.getPrintDocument()))
			return false;
		if (! SmartEquals(getJournalDocumentPreference(), objT.getJournalDocumentPreference()))
			return false;
		if (! SmartEquals(getAccountingLinkTo(), objT.getAccountingLinkTo()))
			return false;
		if (! SmartEquals(getShippingCollected(), objT.getShippingCollected()))
			return false;
		if (! SmartEquals(getActualBankDeposit(), objT.getActualBankDeposit()))
			return false;
		if (! SmartEquals(getUndepositedReceipts(), objT.getUndepositedReceipts()))
			return false;
		if (! SmartEquals(getDiscounts(), objT.getDiscounts()))
			return false;
		if (! SmartEquals(getSalesTax(), objT.getSalesTax()))
			return false;
		if (! SmartEquals(getTotalARReceipts(), objT.getTotalARReceipts()))
			return false;
		if (! SmartEquals(getDepositsOnInvoices(), objT.getDepositsOnInvoices()))
			return false;
		if (! SmartEquals(getNewChargesToAR(), objT.getNewChargesToAR()))
			return false;
		if (! SmartEquals(getCashOverShort(), objT.getCashOverShort()))
			return false;
		if (! SmartEquals(getPaidOut(), objT.getPaidOut()))
			return false;
		if (! SmartEquals(getRefundChecks(), objT.getRefundChecks()))
			return false;
		if (! SmartEquals(getUseObsoleteDropFolder(), objT.getUseObsoleteDropFolder()))
			return false;
		if (! SmartEquals(getUseSkipJackProcessor(), objT.getUseSkipJackProcessor()))
			return false;
		if (! SmartEquals(getUseEfsProcessor(), objT.getUseEfsProcessor()))
			return false;
		if (! SmartEquals(getCreditCardDropFolder(), objT.getCreditCardDropFolder()))
			return false;
		if (! SmartEquals(getSkipJackMode(), objT.getSkipJackMode()))
			return false;
		if (! SmartEquals(getInternetURL(), objT.getInternetURL()))
			return false;
		if (! SmartEquals(getSerialNumber(), objT.getSerialNumber()))
			return false;
		if (! SmartEquals(getDevelopmentNumber(), objT.getDevelopmentNumber()))
			return false;
		if (! SmartEquals(getPortNumber(), objT.getPortNumber()))
			return false;
		if (! SmartEquals(getMerchantID(), objT.getMerchantID()))
			return false;
		if (! SmartEquals(getMerchantKey(), objT.getMerchantKey()))
			return false;
		if (! SmartEquals(getUseAddressValidation(), objT.getUseAddressValidation()))
			return false;
		if (! SmartEquals(getPromptUserForValidationInfo(), objT.getPromptUserForValidationInfo()))
			return false;
		return true;
	}			
}