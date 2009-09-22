package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

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
	@NamedQuery(name = "account.findall", query = "from account"),
	@NamedQuery(name = "account.byId", query = "select a from account a where a.id= :id")
})


@Entity
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

 	
	
 	@Basic
	private Long accountId;
	/**
	 * @generated
 	 */
	public Long getAccountId(){
		return accountId; 
	}

	/**
	 * @generated
	 */	
	public void setAccountId(Long newVal) {
		this.accountId = newVal;
	}
 	
	
 	@Basic
	private String status;
	/**
	 * @generated
 	 */
	public String getStatus(){
		return status; 
	}

	/**
	 * @generated
	 */	
	public void setStatus(String newVal) {
		this.status = newVal;
	}
 	
	
 	@Basic
	private Long masterAcct;
	/**
	 * @generated
 	 */
	public Long getMasterAcct(){
		return masterAcct; 
	}

	/**
	 * @generated
	 */	
	public void setMasterAcct(Long newVal) {
		this.masterAcct = newVal;
	}
 	
	
 	@Basic
	private String resaleNumber;
	/**
	 * @generated
 	 */
	public String getResaleNumber(){
		return resaleNumber; 
	}

	/**
	 * @generated
	 */	
	public void setResaleNumber(String newVal) {
		this.resaleNumber = newVal;
	}
 	
	
 	@Basic
	private String title;
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
 	
	
 	@Basic
	private String customerPO;
	/**
	 * @generated
 	 */
	public String getCustomerPO(){
		return customerPO; 
	}

	/**
	 * @generated
	 */	
	public void setCustomerPO(String newVal) {
		this.customerPO = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private Address shipToAddress;
	/**
	 * @generated
 	 */
	public Address getShipToAddress(){
		return shipToAddress; 
	}

	/**
	 * @generated
	 */	
	public void setShipToAddress(Address newVal) {
		this.shipToAddress = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private Address billToAddress;
	/**
	 * @generated
 	 */
	public Address getBillToAddress(){
		return billToAddress; 
	}

	/**
	 * @generated
	 */	
	public void setBillToAddress(Address newVal) {
		this.billToAddress = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private Contact contact;
	/**
	 * @generated
 	 */
	public Contact getContact(){
		return contact; 
	}

	/**
	 * @generated
	 */	
	public void setContact(Contact newVal) {
		this.contact = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private Contact billToContact;
	/**
	 * @generated
 	 */
	public Contact getBillToContact(){
		return billToContact; 
	}

	/**
	 * @generated
	 */	
	public void setBillToContact(Contact newVal) {
		this.billToContact = newVal;
	}
 	
	
 	@Basic
	private Long salesRank;
	/**
	 * @generated
 	 */
	public Long getSalesRank(){
		return salesRank; 
	}

	/**
	 * @generated
	 */	
	public void setSalesRank(Long newVal) {
		this.salesRank = newVal;
	}
 	
	
 	@Basic
	private String userAcctId;
	/**
	 * @generated
 	 */
	public String getUserAcctId(){
		return userAcctId; 
	}

	/**
	 * @generated
	 */	
	public void setUserAcctId(String newVal) {
		this.userAcctId = newVal;
	}
 	
	
 	@Basic
	private String externalAcctId;
	/**
	 * @generated
 	 */
	public String getExternalAcctId(){
		return externalAcctId; 
	}

	/**
	 * @generated
	 */	
	public void setExternalAcctId(String newVal) {
		this.externalAcctId = newVal;
	}
 	
	
 	@Basic
	private Boolean dollarDiscount;
	/**
	 * @generated
 	 */
	public Boolean getDollarDiscount(){
		return dollarDiscount; 
	}

	/**
	 * @generated
	 */	
	public void setDollarDiscount(Boolean newVal) {
		this.dollarDiscount = newVal;
	}
 	
	
 	@Basic
	private Boolean fileOriginals;
	/**
	 * @generated
 	 */
	public Boolean getFileOriginals(){
		return fileOriginals; 
	}

	/**
	 * @generated
	 */	
	public void setFileOriginals(Boolean newVal) {
		this.fileOriginals = newVal;
	}
 	
	
 	@Basic
	private Boolean webAccessEnabled;
	/**
	 * @generated
 	 */
	public Boolean getWebAccessEnabled(){
		return webAccessEnabled; 
	}

	/**
	 * @generated
	 */	
	public void setWebAccessEnabled(Boolean newVal) {
		this.webAccessEnabled = newVal;
	}
 	
	
 	@Basic
	private Boolean prospect;
	/**
	 * @generated
 	 */
	public Boolean getProspect(){
		return prospect; 
	}

	/**
	 * @generated
	 */	
	public void setProspect(Boolean newVal) {
		this.prospect = newVal;
	}
 	
	
 	@Basic
	private Boolean autoPayEnabled;
	/**
	 * @generated
 	 */
	public Boolean getAutoPayEnabled(){
		return autoPayEnabled; 
	}

	/**
	 * @generated
	 */	
	public void setAutoPayEnabled(Boolean newVal) {
		this.autoPayEnabled = newVal;
	}
 	
	
 	@Basic
	private Boolean optOutMarketing;
	/**
	 * @generated
 	 */
	public Boolean getOptOutMarketing(){
		return optOutMarketing; 
	}

	/**
	 * @generated
	 */	
	public void setOptOutMarketing(Boolean newVal) {
		this.optOutMarketing = newVal;
	}
 	
	
 	@Basic
	private Boolean acctIsIndividual;
	/**
	 * @generated
 	 */
	public Boolean getAcctIsIndividual(){
		return acctIsIndividual; 
	}

	/**
	 * @generated
	 */	
	public void setAcctIsIndividual(Boolean newVal) {
		this.acctIsIndividual = newVal;
	}
 	
	
 	@Basic
	private Boolean taxExempt;
	/**
	 * @generated
 	 */
	public Boolean getTaxExempt(){
		return taxExempt; 
	}

	/**
	 * @generated
	 */	
	public void setTaxExempt(Boolean newVal) {
		this.taxExempt = newVal;
	}
 	
	
 	@Basic
	private String payCommissions;
	/**
	 * @generated
 	 */
	public String getPayCommissions(){
		return payCommissions; 
	}

	/**
	 * @generated
	 */	
	public void setPayCommissions(String newVal) {
		this.payCommissions = newVal;
	}
 	
	
 	@Basic
	private Boolean poRequired;
	/**
	 * @generated
 	 */
	public Boolean getPoRequired(){
		return poRequired; 
	}

	/**
	 * @generated
	 */	
	public void setPoRequired(Boolean newVal) {
		this.poRequired = newVal;
	}
 	
	
 	@Basic
	private Boolean applyFinanceCharges;
	/**
	 * @generated
 	 */
	public Boolean getApplyFinanceCharges(){
		return applyFinanceCharges; 
	}

	/**
	 * @generated
	 */	
	public void setApplyFinanceCharges(Boolean newVal) {
		this.applyFinanceCharges = newVal;
	}
 	
	
 	@Basic
	private Boolean generateStatements;
	/**
	 * @generated
 	 */
	public Boolean getGenerateStatements(){
		return generateStatements; 
	}

	/**
	 * @generated
	 */	
	public void setGenerateStatements(Boolean newVal) {
		this.generateStatements = newVal;
	}
 	
	
 	@Basic
	private String businessType;
	/**
	 * @generated
 	 */
	public String getBusinessType(){
		return businessType; 
	}

	/**
	 * @generated
	 */	
	public void setBusinessType(String newVal) {
		this.businessType = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private SalesRep salesRep;
	/**
	 * @generated
 	 */
	public SalesRep getSalesRep(){
		return salesRep; 
	}

	/**
	 * @generated
	 */	
	public void setSalesRep(SalesRep newVal) {
		this.salesRep = newVal;
	}
 	
	
 	@Basic
	private String shippingMode;
	/**
	 * @generated
 	 */
	public String getShippingMode(){
		return shippingMode; 
	}

	/**
	 * @generated
	 */	
	public void setShippingMode(String newVal) {
		this.shippingMode = newVal;
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