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
 * @!generated
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
	public static final String CREDITCARDDROPFOLDER = "CreditCardDropFolder";
	/**
	 * @generated
	 */
	public static final String POLLINGINTERVAL = "PollingInterval";
	/**
	 * @generated
	 */
	public static final String USEADDRESSVALIDATION = "UseAddressValidation";
	/**
	 * @generated
	 */
	public static final String PROMPTUSERFORVALIDATION = "PromptUserForValidation";
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
	public PreferencesAccounting() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
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
 	
	
 	@Basic
	private Integer pollingInterval;
	/**
	 * @generated
 	 */
	public Integer getPollingInterval(){
		return pollingInterval; 
	}

	/**
	 * @generated
	 */	
	public void setPollingInterval(Integer newVal) {
		this.pollingInterval = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean promptUserForValidation;
	/**
	 * @generated
 	 */
	public Boolean getPromptUserForValidation(){
		return promptUserForValidation; 
	}

	/**
	 * @generated
	 */	
	public void setPromptUserForValidation(Boolean newVal) {
		this.promptUserForValidation = newVal;
	}
 	
	
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
		if (CREDITCARDDROPFOLDER.equals(propertyName)) return getCreditCardDropFolder();
		if (POLLINGINTERVAL.equals(propertyName)) return getPollingInterval();
		if (USEADDRESSVALIDATION.equals(propertyName)) return getUseAddressValidation();
		if (PROMPTUSERFORVALIDATION.equals(propertyName)) return getPromptUserForValidation();
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
		if (CREDITCARDDROPFOLDER.equals(propertyName)) setCreditCardDropFolder((String)newValue); else
		if (POLLINGINTERVAL.equals(propertyName)) setPollingInterval((Integer)newValue); else
		if (USEADDRESSVALIDATION.equals(propertyName)) setUseAddressValidation((Boolean)newValue); else
		if (PROMPTUSERFORVALIDATION.equals(propertyName)) setPromptUserForValidation((Boolean)newValue); else
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
		if (CREDITCARDDROPFOLDER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (POLLINGINTERVAL.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (USEADDRESSVALIDATION.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PROMPTUSERFORVALIDATION.equals(propertyName)) 
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
		if (CREDITCARDDROPFOLDER.equals(propertyName)) return PreferencesAccounting.class;
		if (POLLINGINTERVAL.equals(propertyName)) return PreferencesAccounting.class;
		if (USEADDRESSVALIDATION.equals(propertyName)) return PreferencesAccounting.class;
		if (PROMPTUSERFORVALIDATION.equals(propertyName)) return PreferencesAccounting.class;
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
		if (! SmartEquals(getCreditCardDropFolder(), objT.getCreditCardDropFolder()))
			return false;
		if (! SmartEquals(getPollingInterval(), objT.getPollingInterval()))
			return false;
		if (! SmartEquals(getUseAddressValidation(), objT.getUseAddressValidation()))
			return false;
		if (! SmartEquals(getPromptUserForValidation(), objT.getPromptUserForValidation()))
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
		return true;
	}			
}