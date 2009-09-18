package com.efi.printsmith.data;

import java.util.Date;

import com.efi.printsmith.data.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
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
	@NamedQuery(name = "Account.findall", query = "from Account"),
	@NamedQuery(name = "Account.byId", query = "select a from Account a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.data.Account")
@DiscriminatorColumn(name="dtype", length=255)
@Table(name = "account")
public class Account extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCOUNTID = "AccountId";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String MASTERACCT = "MasterAcct";
	/**
	 * @generated
	 */
	public static final String RESALENUMBER = "ResaleNumber";
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String CUSTOMERPO = "CustomerPO";
	/**
	 * @generated
	 */
	public static final String SHIPTOADDRESS = "ShipToAddress";
	/**
	 * @generated
	 */
	public static final String BILLTOADDRESS = "BillToAddress";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String BILLTOCONTACT = "BillToContact";
	/**
	 * @generated
	 */
	public static final String SALESRANK = "SalesRank";
	/**
	 * @generated
	 */
	public static final String USERACCTID = "UserAcctId";
	/**
	 * @generated
	 */
	public static final String EXTERNALACCTID = "ExternalAcctId";
	/**
	 * @generated
	 */
	public static final String DOLLARDISCOUNT = "DollarDiscount";
	/**
	 * @generated
	 */
	public static final String FILEORIGINALS = "FileOriginals";
	/**
	 * @generated
	 */
	public static final String WEBACCESSENABLED = "WebAccessEnabled";
	/**
	 * @generated
	 */
	public static final String PROSPECT = "Prospect";
	/**
	 * @generated
	 */
	public static final String AUTOPAYENABLED = "AutoPayEnabled";
	/**
	 * @generated
	 */
	public static final String OPTOUTMARKETING = "OptOutMarketing";
	/**
	 * @generated
	 */
	public static final String ACCTISINDIVIDUAL = "AcctIsIndividual";
	/**
	 * @generated
	 */
	public static final String TAXEXEMPT = "TaxExempt";
	/**
	 * @generated
	 */
	public static final String PAYCOMMISSIONS = "PayCommissions";
	/**
	 * @generated
	 */
	public static final String POREQUIRED = "PoRequired";
	/**
	 * @generated
	 */
	public static final String APPLYFINANCECHARGES = "ApplyFinanceCharges";
	/**
	 * @generated
	 */
	public static final String GENERATESTATEMENTS = "GenerateStatements";
	/**
	 * @generated
	 */
	public static final String BUSINESSTYPE = "BusinessType";
	/**
	 * @generated
	 */
	public static final String SALESREP = "SalesRep";
	/**
	 * @generated
	 */
	public static final String SHIPPINGMODE = "ShippingMode";

	/**
	 * @generated
	 */
	public Account() {
	}

 	
	
	private Long accountId;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="accountid", nullable=true, unique=false)
	public Long getAccountId(){
		return accountId; 
	}

	/**
	 * @generated
	 */	
	public Long setAccountId(Long newVal) {
		return this.accountId = newVal;
	}
 	
	
	private String status;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="status", nullable=true, unique=false)
	public String getStatus(){
		return status; 
	}

	/**
	 * @generated
	 */	
	public String setStatus(String newVal) {
		return this.status = newVal;
	}
 	
	
	private Long masterAcct;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="masteracct", nullable=true, unique=false)
	public Long getMasterAcct(){
		return masterAcct; 
	}

	/**
	 * @generated
	 */	
	public Long setMasterAcct(Long newVal) {
		return this.masterAcct = newVal;
	}
 	
	
	private String resaleNumber;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="resalenumber", nullable=true, unique=false)
	public String getResaleNumber(){
		return resaleNumber; 
	}

	/**
	 * @generated
	 */	
	public String setResaleNumber(String newVal) {
		return this.resaleNumber = newVal;
	}
 	
	
	private String title;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="title", nullable=true, unique=false)
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public String setTitle(String newVal) {
		return this.title = newVal;
	}
 	
	
	private String customerPO;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="customerpo", nullable=true, unique=false)
	public String getCustomerPO(){
		return customerPO; 
	}

	/**
	 * @generated
	 */	
	public String setCustomerPO(String newVal) {
		return this.customerPO = newVal;
	}
 	
	
	private Address shipToAddress;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Address getShipToAddress(){
		return shipToAddress; 
	}

	/**
	 * @generated
	 */	
	public Address setShipToAddress(Address newVal) {
		return this.shipToAddress = newVal;
	}
 	
	
	private Address billToAddress;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Address getBillToAddress(){
		return billToAddress; 
	}

	/**
	 * @generated
	 */	
	public Address setBillToAddress(Address newVal) {
		return this.billToAddress = newVal;
	}
 	
	
	private Contact contact;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Contact getContact(){
		return contact; 
	}

	/**
	 * @generated
	 */	
	public Contact setContact(Contact newVal) {
		return this.contact = newVal;
	}
 	
	
	private Contact billToContact;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Contact getBillToContact(){
		return billToContact; 
	}

	/**
	 * @generated
	 */	
	public Contact setBillToContact(Contact newVal) {
		return this.billToContact = newVal;
	}
 	
	
	private Long salesRank;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="salesrank", nullable=true, unique=false)
	public Long getSalesRank(){
		return salesRank; 
	}

	/**
	 * @generated
	 */	
	public Long setSalesRank(Long newVal) {
		return this.salesRank = newVal;
	}
 	
	
	private String userAcctId;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="useracctid", nullable=true, unique=false)
	public String getUserAcctId(){
		return userAcctId; 
	}

	/**
	 * @generated
	 */	
	public String setUserAcctId(String newVal) {
		return this.userAcctId = newVal;
	}
 	
	
	private String externalAcctId;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="externalacctid", nullable=true, unique=false)
	public String getExternalAcctId(){
		return externalAcctId; 
	}

	/**
	 * @generated
	 */	
	public String setExternalAcctId(String newVal) {
		return this.externalAcctId = newVal;
	}
 	
	
	private Boolean dollarDiscount;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="dollardiscount", nullable=true, unique=false)
	public Boolean getDollarDiscount(){
		return dollarDiscount; 
	}

	/**
	 * @generated
	 */	
	public Boolean setDollarDiscount(Boolean newVal) {
		return this.dollarDiscount = newVal;
	}
 	
	
	private Boolean fileOriginals;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="fileoriginals", nullable=true, unique=false)
	public Boolean getFileOriginals(){
		return fileOriginals; 
	}

	/**
	 * @generated
	 */	
	public Boolean setFileOriginals(Boolean newVal) {
		return this.fileOriginals = newVal;
	}
 	
	
	private Boolean webAccessEnabled;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="webaccessenabled", nullable=true, unique=false)
	public Boolean getWebAccessEnabled(){
		return webAccessEnabled; 
	}

	/**
	 * @generated
	 */	
	public Boolean setWebAccessEnabled(Boolean newVal) {
		return this.webAccessEnabled = newVal;
	}
 	
	
	private Boolean prospect;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="prospect", nullable=true, unique=false)
	public Boolean getProspect(){
		return prospect; 
	}

	/**
	 * @generated
	 */	
	public Boolean setProspect(Boolean newVal) {
		return this.prospect = newVal;
	}
 	
	
	private Boolean autoPayEnabled;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="autopayenabled", nullable=true, unique=false)
	public Boolean getAutoPayEnabled(){
		return autoPayEnabled; 
	}

	/**
	 * @generated
	 */	
	public Boolean setAutoPayEnabled(Boolean newVal) {
		return this.autoPayEnabled = newVal;
	}
 	
	
	private Boolean optOutMarketing;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="optoutmarketing", nullable=true, unique=false)
	public Boolean getOptOutMarketing(){
		return optOutMarketing; 
	}

	/**
	 * @generated
	 */	
	public Boolean setOptOutMarketing(Boolean newVal) {
		return this.optOutMarketing = newVal;
	}
 	
	
	private Boolean acctIsIndividual;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="acctisindividual", nullable=true, unique=false)
	public Boolean getAcctIsIndividual(){
		return acctIsIndividual; 
	}

	/**
	 * @generated
	 */	
	public Boolean setAcctIsIndividual(Boolean newVal) {
		return this.acctIsIndividual = newVal;
	}
 	
	
	private Boolean taxExempt;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="taxexempt", nullable=true, unique=false)
	public Boolean getTaxExempt(){
		return taxExempt; 
	}

	/**
	 * @generated
	 */	
	public Boolean setTaxExempt(Boolean newVal) {
		return this.taxExempt = newVal;
	}
 	
	
	private String payCommissions;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="paycommissions", nullable=true, unique=false)
	public String getPayCommissions(){
		return payCommissions; 
	}

	/**
	 * @generated
	 */	
	public String setPayCommissions(String newVal) {
		return this.payCommissions = newVal;
	}
 	
	
	private Boolean poRequired;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="porequired", nullable=true, unique=false)
	public Boolean getPoRequired(){
		return poRequired; 
	}

	/**
	 * @generated
	 */	
	public Boolean setPoRequired(Boolean newVal) {
		return this.poRequired = newVal;
	}
 	
	
	private Boolean applyFinanceCharges;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="applyfinancecharges", nullable=true, unique=false)
	public Boolean getApplyFinanceCharges(){
		return applyFinanceCharges; 
	}

	/**
	 * @generated
	 */	
	public Boolean setApplyFinanceCharges(Boolean newVal) {
		return this.applyFinanceCharges = newVal;
	}
 	
	
	private Boolean generateStatements;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="generatestatements", nullable=true, unique=false)
	public Boolean getGenerateStatements(){
		return generateStatements; 
	}

	/**
	 * @generated
	 */	
	public Boolean setGenerateStatements(Boolean newVal) {
		return this.generateStatements = newVal;
	}
 	
	
	private String businessType;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="businesstype", nullable=true, unique=false)
	public String getBusinessType(){
		return businessType; 
	}

	/**
	 * @generated
	 */	
	public String setBusinessType(String newVal) {
		return this.businessType = newVal;
	}
 	
	
	private SalesRep salesRep;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public SalesRep getSalesRep(){
		return salesRep; 
	}

	/**
	 * @generated
	 */	
	public SalesRep setSalesRep(SalesRep newVal) {
		return this.salesRep = newVal;
	}
 	
	
	private String shippingMode;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="shippingmode", nullable=true, unique=false)
	public String getShippingMode(){
		return shippingMode; 
	}

	/**
	 * @generated
	 */	
	public String setShippingMode(String newVal) {
		return this.shippingMode = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (ACCOUNTID.equals(propertyName)) return getAccountId();
		if (STATUS.equals(propertyName)) return getStatus();
		if (MASTERACCT.equals(propertyName)) return getMasterAcct();
		if (RESALENUMBER.equals(propertyName)) return getResaleNumber();
		if (TITLE.equals(propertyName)) return getTitle();
		if (CUSTOMERPO.equals(propertyName)) return getCustomerPO();
		if (SHIPTOADDRESS.equals(propertyName)) return getShipToAddress();
		if (BILLTOADDRESS.equals(propertyName)) return getBillToAddress();
		if (CONTACT.equals(propertyName)) return getContact();
		if (BILLTOCONTACT.equals(propertyName)) return getBillToContact();
		if (SALESRANK.equals(propertyName)) return getSalesRank();
		if (USERACCTID.equals(propertyName)) return getUserAcctId();
		if (EXTERNALACCTID.equals(propertyName)) return getExternalAcctId();
		if (DOLLARDISCOUNT.equals(propertyName)) return getDollarDiscount();
		if (FILEORIGINALS.equals(propertyName)) return getFileOriginals();
		if (WEBACCESSENABLED.equals(propertyName)) return getWebAccessEnabled();
		if (PROSPECT.equals(propertyName)) return getProspect();
		if (AUTOPAYENABLED.equals(propertyName)) return getAutoPayEnabled();
		if (OPTOUTMARKETING.equals(propertyName)) return getOptOutMarketing();
		if (ACCTISINDIVIDUAL.equals(propertyName)) return getAcctIsIndividual();
		if (TAXEXEMPT.equals(propertyName)) return getTaxExempt();
		if (PAYCOMMISSIONS.equals(propertyName)) return getPayCommissions();
		if (POREQUIRED.equals(propertyName)) return getPoRequired();
		if (APPLYFINANCECHARGES.equals(propertyName)) return getApplyFinanceCharges();
		if (GENERATESTATEMENTS.equals(propertyName)) return getGenerateStatements();
		if (BUSINESSTYPE.equals(propertyName)) return getBusinessType();
		if (SALESREP.equals(propertyName)) return getSalesRep();
		if (SHIPPINGMODE.equals(propertyName)) return getShippingMode();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (ACCOUNTID.equals(propertyName)) setAccountId((Long)newValue); else
		if (STATUS.equals(propertyName)) setStatus((String)newValue); else
		if (MASTERACCT.equals(propertyName)) setMasterAcct((Long)newValue); else
		if (RESALENUMBER.equals(propertyName)) setResaleNumber((String)newValue); else
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (CUSTOMERPO.equals(propertyName)) setCustomerPO((String)newValue); else
		if (SHIPTOADDRESS.equals(propertyName)) setShipToAddress((Address)newValue); else
		if (BILLTOADDRESS.equals(propertyName)) setBillToAddress((Address)newValue); else
		if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
		if (BILLTOCONTACT.equals(propertyName)) setBillToContact((Contact)newValue); else
		if (SALESRANK.equals(propertyName)) setSalesRank((Long)newValue); else
		if (USERACCTID.equals(propertyName)) setUserAcctId((String)newValue); else
		if (EXTERNALACCTID.equals(propertyName)) setExternalAcctId((String)newValue); else
		if (DOLLARDISCOUNT.equals(propertyName)) setDollarDiscount((Boolean)newValue); else
		if (FILEORIGINALS.equals(propertyName)) setFileOriginals((Boolean)newValue); else
		if (WEBACCESSENABLED.equals(propertyName)) setWebAccessEnabled((Boolean)newValue); else
		if (PROSPECT.equals(propertyName)) setProspect((Boolean)newValue); else
		if (AUTOPAYENABLED.equals(propertyName)) setAutoPayEnabled((Boolean)newValue); else
		if (OPTOUTMARKETING.equals(propertyName)) setOptOutMarketing((Boolean)newValue); else
		if (ACCTISINDIVIDUAL.equals(propertyName)) setAcctIsIndividual((Boolean)newValue); else
		if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
		if (PAYCOMMISSIONS.equals(propertyName)) setPayCommissions((String)newValue); else
		if (POREQUIRED.equals(propertyName)) setPoRequired((Boolean)newValue); else
		if (APPLYFINANCECHARGES.equals(propertyName)) setApplyFinanceCharges((Boolean)newValue); else
		if (GENERATESTATEMENTS.equals(propertyName)) setGenerateStatements((Boolean)newValue); else
		if (BUSINESSTYPE.equals(propertyName)) setBusinessType((String)newValue); else
		if (SALESREP.equals(propertyName)) setSalesRep((SalesRep)newValue); else
		if (SHIPPINGMODE.equals(propertyName)) setShippingMode((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (ACCOUNTID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (STATUS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MASTERACCT.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (RESALENUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CUSTOMERPO.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SHIPTOADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (BILLTOADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (CONTACT.equals(propertyName)) 
			return new Class<?>[] {Contact.class};		
		if (BILLTOCONTACT.equals(propertyName)) 
			return new Class<?>[] {Contact.class};		
		if (SALESRANK.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (USERACCTID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (EXTERNALACCTID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DOLLARDISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FILEORIGINALS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WEBACCESSENABLED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PROSPECT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (AUTOPAYENABLED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (OPTOUTMARKETING.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ACCTISINDIVIDUAL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXEXEMPT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PAYCOMMISSIONS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (POREQUIRED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (APPLYFINANCECHARGES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (GENERATESTATEMENTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (BUSINESSTYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESREP.equals(propertyName)) 
			return new Class<?>[] {SalesRep.class};		
		if (SHIPPINGMODE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (ACCOUNTID.equals(propertyName)) return Account.class;
		if (STATUS.equals(propertyName)) return Account.class;
		if (MASTERACCT.equals(propertyName)) return Account.class;
		if (RESALENUMBER.equals(propertyName)) return Account.class;
		if (TITLE.equals(propertyName)) return Account.class;
		if (CUSTOMERPO.equals(propertyName)) return Account.class;
		if (SHIPTOADDRESS.equals(propertyName)) return Account.class;
		if (BILLTOADDRESS.equals(propertyName)) return Account.class;
		if (CONTACT.equals(propertyName)) return Account.class;
		if (BILLTOCONTACT.equals(propertyName)) return Account.class;
		if (SALESRANK.equals(propertyName)) return Account.class;
		if (USERACCTID.equals(propertyName)) return Account.class;
		if (EXTERNALACCTID.equals(propertyName)) return Account.class;
		if (DOLLARDISCOUNT.equals(propertyName)) return Account.class;
		if (FILEORIGINALS.equals(propertyName)) return Account.class;
		if (WEBACCESSENABLED.equals(propertyName)) return Account.class;
		if (PROSPECT.equals(propertyName)) return Account.class;
		if (AUTOPAYENABLED.equals(propertyName)) return Account.class;
		if (OPTOUTMARKETING.equals(propertyName)) return Account.class;
		if (ACCTISINDIVIDUAL.equals(propertyName)) return Account.class;
		if (TAXEXEMPT.equals(propertyName)) return Account.class;
		if (PAYCOMMISSIONS.equals(propertyName)) return Account.class;
		if (POREQUIRED.equals(propertyName)) return Account.class;
		if (APPLYFINANCECHARGES.equals(propertyName)) return Account.class;
		if (GENERATESTATEMENTS.equals(propertyName)) return Account.class;
		if (BUSINESSTYPE.equals(propertyName)) return Account.class;
		if (SALESREP.equals(propertyName)) return Account.class;
		if (SHIPPINGMODE.equals(propertyName)) return Account.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Account objT = (Account)obj;
		if (! SmartEquals(getAccountId(), objT.getAccountId()))
			return false;
		if (! SmartEquals(getStatus(), objT.getStatus()))
			return false;
		if (! SmartEquals(getMasterAcct(), objT.getMasterAcct()))
			return false;
		if (! SmartEquals(getResaleNumber(), objT.getResaleNumber()))
			return false;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getCustomerPO(), objT.getCustomerPO()))
			return false;
		if (! SmartEquals(getShipToAddress(), objT.getShipToAddress()))
			return false;
		if (! SmartEquals(getBillToAddress(), objT.getBillToAddress()))
			return false;
		if (! SmartEquals(getContact(), objT.getContact()))
			return false;
		if (! SmartEquals(getBillToContact(), objT.getBillToContact()))
			return false;
		if (! SmartEquals(getSalesRank(), objT.getSalesRank()))
			return false;
		if (! SmartEquals(getUserAcctId(), objT.getUserAcctId()))
			return false;
		if (! SmartEquals(getExternalAcctId(), objT.getExternalAcctId()))
			return false;
		if (! SmartEquals(getDollarDiscount(), objT.getDollarDiscount()))
			return false;
		if (! SmartEquals(getFileOriginals(), objT.getFileOriginals()))
			return false;
		if (! SmartEquals(getWebAccessEnabled(), objT.getWebAccessEnabled()))
			return false;
		if (! SmartEquals(getProspect(), objT.getProspect()))
			return false;
		if (! SmartEquals(getAutoPayEnabled(), objT.getAutoPayEnabled()))
			return false;
		if (! SmartEquals(getOptOutMarketing(), objT.getOptOutMarketing()))
			return false;
		if (! SmartEquals(getAcctIsIndividual(), objT.getAcctIsIndividual()))
			return false;
		if (! SmartEquals(getTaxExempt(), objT.getTaxExempt()))
			return false;
		if (! SmartEquals(getPayCommissions(), objT.getPayCommissions()))
			return false;
		if (! SmartEquals(getPoRequired(), objT.getPoRequired()))
			return false;
		if (! SmartEquals(getApplyFinanceCharges(), objT.getApplyFinanceCharges()))
			return false;
		if (! SmartEquals(getGenerateStatements(), objT.getGenerateStatements()))
			return false;
		if (! SmartEquals(getBusinessType(), objT.getBusinessType()))
			return false;
		if (! SmartEquals(getSalesRep(), objT.getSalesRep()))
			return false;
		if (! SmartEquals(getShippingMode(), objT.getShippingMode()))
			return false;
		return true;
	}			
}