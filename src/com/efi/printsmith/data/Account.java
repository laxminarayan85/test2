
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "Account.findall", query = "from Account"),
  @NamedQuery(name = "Account.byId", query = "select a from Account a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "account")
@SQLDelete(sql="update account set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class Account extends ModelBase {
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
	public static final String ONETIMEDISCOUNT = "OneTimeDiscount";
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
	public static final String EXTERNALREF = "ExternalRef";
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
	public static final String LASTINVOICEDATE = "LastInvoiceDate";
	/**
	 * @generated
	 */
	public static final String LASTESTIMATEDATE = "LastEstimateDate";
	/**
	 * @generated
	 */
	public static final String FIRSTINVOICEDATE = "FirstInvoiceDate";
	/**
	 * @generated
	 */
	public static final String FIRSTESTIMATEDATE = "FirstEstimateDate";
	/**
	 * @generated
	 */
	public static final String LASTAGEDDATE = "LastAgedDate";
	/**
	 * @generated
	 */
	public static final String LASTBILLEDDATE = "LastBilledDate";
	/**
	 * @generated
	 */
	public static final String MARKETING = "Marketing";
	/**
	 * @generated
	 */
	public static final String LASTPAYMENTDATE = "LastPaymentDate";
	/**
	 * @generated
	 */
	public static final String LASTPOSTINGDATE = "LastPostingDate";
	/**
	 * @generated
	 */
	public static final String LASTRANKINGDATE = "LastRankingDate";
	/**
	 * @generated
	 */
	public static final String CREDITCARDEXPIRATION = "CreditCardExpiration";
	/**
	 * @generated
	 */
	public static final String CREDITCARDINFO = "CreditCardInfo";
	/**
	 * @generated
	 */
	public static final String AUTOPAYMODE = "AutoPayMode";
	/**
	 * @generated
	 */
	public static final String AUTOPAYINTERVAL = "AutoPayInterval";
	/**
	 * @generated
	 */
	public static final String CREDITCARDTYPE = "CreditCardType";
	/**
	 * @generated
	 */
	public static final String AUTOPAYMINIMUM = "AutoPayMinimum";
	/**
	 * @generated
	 */
	public static final String AUTOPAYMAXIMUM = "AutoPayMaximum";
	/**
	 * @generated
	 */
	public static final String AUTOPAYTOTAL = "AutoPayTotal";
	/**
	 * @generated
	 */
	public static final String AUTOPAYAMOUNT = "AutoPayAmount";
	/**
	 * @generated
	 */
	public static final String AUTOPAYSTOP = "AutoPayStop";
	/**
	 * @generated
	 */
	public static final String AUTOPAYSTART = "AutoPayStart";
	/**
	 * @generated
	 */
	public static final String AUTOPAYLASTPOSTED = "AutoPayLastPosted";
	/**
	 * @generated
	 */
	public static final String AUTOPAYPAYMENTQTY = "AutoPayPaymentQty";
	/**
	 * @generated
	 */
	public static final String LASTNOTIFIEDDATE = "LastNotifiedDate";
	/**
	 * @generated
	 */
	public static final String RESALECERTEXPIRATIONDATE = "ResaleCertExpirationDate";
	/**
	 * @generated
	 */
	public static final String ONACCOUNT = "OnAccount";
	/**
	 * @generated
	 */
	public static final String BALANCE = "Balance";
	/**
	 * @generated
	 */
	public static final String SALESMONTH = "SalesMonth";
	/**
	 * @generated
	 */
	public static final String ORDERSMONTH = "OrdersMonth";
	/**
	 * @generated
	 */
	public static final String SALESYEAR = "SalesYear";
	/**
	 * @generated
	 */
	public static final String SALESPRIORYEAR = "SalesPriorYear";
	/**
	 * @generated
	 */
	public static final String ORDERSYEAR = "OrdersYear";
	/**
	 * @generated
	 */
	public static final String ORDERSTOTAL = "OrdersTotal";
	/**
	 * @generated
	 */
	public static final String ESTIMATECOUNT = "EstimateCount";
	/**
	 * @generated
	 */
	public static final String CREDITLIMIT = "CreditLimit";
	/**
	 * @generated
	 */
	public static final String DISCOUNT = "Discount";
	/**
	 * @generated
	 */
	public static final String TERMSNET = "TermsNet";
	/**
	 * @generated
	 */
	public static final String TERMSDISCOUNT = "TermsDiscount";
	/**
	 * @generated
	 */
	public static final String FINANCERATE = "FinanceRate";
	/**
	 * @generated
	 */
	public static final String FINANCEYEAR = "FinanceYear";
	/**
	 * @generated
	 */
	public static final String ESTIMATESWON = "EstimatesWon";
	/**
	 * @generated
	 */
	public static final String ESTIMATESLOST = "EstimatesLost";
	/**
	 * @generated
	 */
	public static final String DISCOUNTDOLLARAMT = "DiscountDollarAmt";
	/**
	 * @generated
	 */
	public static final String BALANCE30DAY = "Balance30Day";
	/**
	 * @generated
	 */
	public static final String BALANCE60DAY = "Balance60Day";
	/**
	 * @generated
	 */
	public static final String BALANCE90DAY = "Balance90Day";
	/**
	 * @generated
	 */
	public static final String BALANCECURRENT = "BalanceCurrent";
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String TAXCODE = "TaxCode";
	/**
	 * @generated
	 */
	public static final String STATEMENTNOTE = "StatementNote";
	/**
	 * @generated
	 */
	public static final String JOBNOTE = "JobNote";
	/**
	 * @generated
	 */
	public static final String ACCOUNTNOTE = "AccountNote";
	/**
	 * @generated
	 */
	public static final String ACCOUNTID = "AccountId";
	/**
	 * @generated
	 */
	public static final String INVOICEESTIMATECHARGES = "InvoiceEstimateCharges";
	/**
	 * @generated
	 */
	public static final String JOBCHARGES = "JobCharges";
	/**
	 * @generated
	 */
	public static final String WEBREGISTERED = "WebRegistered";
	/**
	 * @generated
	 */
	public static final String WEBCOMPANYID = "WebCompanyId";
	/**
	 * @generated
	 */
	public static final String WEBCATALOG = "WebCatalog";

	/**
   * @generated
   */
  public static final String ACCESS_LEVEL = "Access_level";

	/**
   * @generated
   */
  public static final String WALKIN = "WalkIn";

	/**
	 * @generated
	 */
	public Account() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }
	
	@Basic
  private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
    return isDeleted;
  }

	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

	public Account(long id, String Name, String accountID,String externalID, long masterID, boolean prospect) {
		this.id = id;
		this.title = Name;
		this.accountId = accountID;
		this.externalRef = externalID;
		this.masterAcct = masterID;
		this.prospect = prospect;
	}
 	
	public Account(long id, String Name, String accountID,String externalID, long masterID, boolean prospect, String externalAcctId, Contact contact) {
		this.id = id;
		this.title = Name;
		this.accountId = accountID;
		this.externalRef = externalID;
		this.masterAcct = masterID;
		this.prospect = prospect;
		this.externalAcctId = externalAcctId;
		this.contact = contact;
	}
	
	public Account(long id, String Name, String accountID,String externalID, long masterID, boolean prospect, String externalAcctId) {
		this.id = id;
		this.title = Name;
		this.accountId = accountID;
		this.externalRef = externalID;
		this.masterAcct = masterID;
		this.prospect = prospect;
		this.externalAcctId = externalAcctId;
	}

 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
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
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
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
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	@Where(clause="isdeleted <> 'TRUE'")
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
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean oneTimeDiscount;
	
	/**
	 * @generated
 	 */
	public Boolean getOneTimeDiscount(){
    return oneTimeDiscount; 
  }

	
	/**
	 * @generated
	 */	
	public void setOneTimeDiscount(Boolean newVal) {
    this.oneTimeDiscount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean payCommissions;
	
	/**
	 * @generated
 	 */
	public Boolean getPayCommissions(){
    return payCommissions; 
  }

	
	/**
	 * @generated
	 */	
	public void setPayCommissions(Boolean newVal) {
    this.payCommissions = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String externalRef;
	
	/**
	 * @generated
 	 */
	public String getExternalRef(){
    return externalRef; 
  }

	
	/**
	 * @generated
	 */	
	public void setExternalRef(String newVal) {
    this.externalRef = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
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
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private ShippingMethod shippingMode;
	
	/**
	 * @generated
 	 */
	public ShippingMethod getShippingMode(){
    return shippingMode; 
  }

	
	/**
	 * @generated
	 */	
	public void setShippingMode(ShippingMethod newVal) {
    this.shippingMode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastInvoiceDate;
	
	/**
	 * @generated
 	 */
	public Date getLastInvoiceDate(){
    return lastInvoiceDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastInvoiceDate(Date newVal) {
    this.lastInvoiceDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastEstimateDate;
	
	/**
	 * @generated
 	 */
	public Date getLastEstimateDate(){
    return lastEstimateDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastEstimateDate(Date newVal) {
    this.lastEstimateDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date firstInvoiceDate;
	
	/**
	 * @generated
 	 */
	public Date getFirstInvoiceDate(){
    return firstInvoiceDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setFirstInvoiceDate(Date newVal) {
    this.firstInvoiceDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date firstEstimateDate;
	
	/**
	 * @generated
 	 */
	public Date getFirstEstimateDate(){
    return firstEstimateDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setFirstEstimateDate(Date newVal) {
    this.firstEstimateDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastAgedDate;
	
	/**
	 * @generated
 	 */
	public Date getLastAgedDate(){
    return lastAgedDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastAgedDate(Date newVal) {
    this.lastAgedDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastBilledDate;
	
	/**
	 * @generated
 	 */
	public Date getLastBilledDate(){
    return lastBilledDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastBilledDate(Date newVal) {
    this.lastBilledDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
	private Marketing marketing;
	
	/**
	 * @generated
 	 */
	public Marketing getMarketing(){
    return marketing; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarketing(Marketing newVal) {
    this.marketing = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastPaymentDate;
	
	/**
	 * @generated
 	 */
	public Date getLastPaymentDate(){
    return lastPaymentDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastPaymentDate(Date newVal) {
    this.lastPaymentDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastPostingDate;
	
	/**
	 * @generated
 	 */
	public Date getLastPostingDate(){
    return lastPostingDate; 
  }

	
	/**
   * @generated
   */	
  public void setLastPostingDate(Date newVal) {
    this.lastPostingDate = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Date lastRankingDate;
	
	/**
	 * @generated
 	 */
	public Date getLastRankingDate(){
    return lastRankingDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastRankingDate(Date newVal) {
    this.lastRankingDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date creditCardExpiration;
	
	/**
	 * @generated
 	 */
	public Date getCreditCardExpiration(){
    return creditCardExpiration; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardExpiration(Date newVal) {
    this.creditCardExpiration = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String creditCardInfo;
	
	/**
	 * @generated
 	 */
	public String getCreditCardInfo(){
    return creditCardInfo; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardInfo(String newVal) {
    this.creditCardInfo = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long autoPayMode;
	
	/**
	 * @generated
 	 */
	public Long getAutoPayMode(){
    return autoPayMode; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayMode(Long newVal) {
    this.autoPayMode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long autoPayInterval;
	
	/**
	 * @generated
 	 */
	public Long getAutoPayInterval(){
    return autoPayInterval; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayInterval(Long newVal) {
    this.autoPayInterval = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String creditCardType;
	
	/**
	 * @generated
 	 */
	public String getCreditCardType(){
    return creditCardType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardType(String newVal) {
    this.creditCardType = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal autoPayMinimum;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAutoPayMinimum(){
    return autoPayMinimum; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayMinimum(BigDecimal newVal) {
    this.autoPayMinimum = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAutoPayMinimum(double newVal) {
    this.autoPayMinimum = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal autoPayMaximum;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAutoPayMaximum(){
    return autoPayMaximum; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayMaximum(BigDecimal newVal) {
    this.autoPayMaximum = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAutoPayMaximum(double newVal) {
    this.autoPayMaximum = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal autoPayTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAutoPayTotal(){
    return autoPayTotal; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayTotal(BigDecimal newVal) {
    this.autoPayTotal = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAutoPayTotal(double newVal) {
    this.autoPayTotal = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal autoPayAmount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAutoPayAmount(){
    return autoPayAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayAmount(BigDecimal newVal) {
    this.autoPayAmount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAutoPayAmount(double newVal) {
    this.autoPayAmount = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date autoPayStop;
	
	/**
	 * @generated
 	 */
	public Date getAutoPayStop(){
    return autoPayStop; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayStop(Date newVal) {
    this.autoPayStop = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date autoPayStart;
	
	/**
	 * @generated
 	 */
	public Date getAutoPayStart(){
    return autoPayStart; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayStart(Date newVal) {
    this.autoPayStart = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date autoPayLastPosted;
	
	/**
	 * @generated
 	 */
	public Date getAutoPayLastPosted(){
    return autoPayLastPosted; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayLastPosted(Date newVal) {
    this.autoPayLastPosted = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long autoPayPaymentQty;
	
	/**
	 * @generated
 	 */
	public Long getAutoPayPaymentQty(){
    return autoPayPaymentQty; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoPayPaymentQty(Long newVal) {
    this.autoPayPaymentQty = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastNotifiedDate;
	
	/**
	 * @generated
 	 */
	public Date getLastNotifiedDate(){
    return lastNotifiedDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastNotifiedDate(Date newVal) {
    this.lastNotifiedDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date resaleCertExpirationDate;
	
	/**
	 * @generated
 	 */
	public Date getResaleCertExpirationDate(){
    return resaleCertExpirationDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setResaleCertExpirationDate(Date newVal) {
    this.resaleCertExpirationDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal onAccount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getOnAccount(){
    return onAccount; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnAccount(BigDecimal newVal) {
    this.onAccount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setOnAccount(double newVal) {
    this.onAccount = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balance;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalance(){
    return balance; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalance(BigDecimal newVal) {
    this.balance = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalance(double newVal) {
    this.balance = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal salesMonth;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSalesMonth(){
    return salesMonth; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesMonth(BigDecimal newVal) {
    this.salesMonth = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSalesMonth(double newVal) {
    this.salesMonth = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long ordersMonth;
	
	/**
	 * @generated
 	 */
	public Long getOrdersMonth(){
    return ordersMonth; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrdersMonth(Long newVal) {
    this.ordersMonth = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal salesYear;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSalesYear(){
    return salesYear; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesYear(BigDecimal newVal) {
    this.salesYear = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSalesYear(double newVal) {
    this.salesYear = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal salesPriorYear;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSalesPriorYear(){
    return salesPriorYear; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesPriorYear(BigDecimal newVal) {
    this.salesPriorYear = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSalesPriorYear(double newVal) {
    this.salesPriorYear = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long ordersYear;
	
	/**
	 * @generated
 	 */
	public Long getOrdersYear(){
    return ordersYear; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrdersYear(Long newVal) {
    this.ordersYear = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long ordersTotal;
	
	/**
	 * @generated
 	 */
	public Long getOrdersTotal(){
    return ordersTotal; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrdersTotal(Long newVal) {
    this.ordersTotal = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long estimateCount;
	
	/**
	 * @generated
 	 */
	public Long getEstimateCount(){
    return estimateCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstimateCount(Long newVal) {
    this.estimateCount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal creditLimit;
	
	/**
	 * @generated
 	 */
	public BigDecimal getCreditLimit(){
    return creditLimit; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditLimit(BigDecimal newVal) {
    this.creditLimit = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setCreditLimit(double newVal) {
    this.creditLimit = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double discount;
	
	/**
	 * @generated
 	 */
	public Double getDiscount(){
    return discount; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscount(Double newVal) {
    this.discount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long termsNet;
	
	/**
	 * @generated
 	 */
	public Long getTermsNet(){
    return termsNet; 
  }

	
	/**
	 * @generated
	 */	
	public void setTermsNet(Long newVal) {
    this.termsNet = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double termsDiscount;
	
	/**
	 * @generated
 	 */
	public Double getTermsDiscount(){
    return termsDiscount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTermsDiscount(Double newVal) {
    this.termsDiscount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double financeRate;
	
	/**
	 * @generated
 	 */
	public Double getFinanceRate(){
    return financeRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinanceRate(Double newVal) {
    this.financeRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double financeYear;
	
	/**
	 * @generated
 	 */
	public Double getFinanceYear(){
    return financeYear; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinanceYear(Double newVal) {
    this.financeYear = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long estimatesWon;
	
	/**
	 * @generated
 	 */
	public Long getEstimatesWon(){
    return estimatesWon; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstimatesWon(Long newVal) {
    this.estimatesWon = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long estimatesLost;
	
	/**
	 * @generated
 	 */
	public Long getEstimatesLost(){
    return estimatesLost; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstimatesLost(Long newVal) {
    this.estimatesLost = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal discountDollarAmt;
	
	/**
	 * @generated
 	 */
	public BigDecimal getDiscountDollarAmt(){
    return discountDollarAmt; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscountDollarAmt(BigDecimal newVal) {
    this.discountDollarAmt = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setDiscountDollarAmt(double newVal) {
    this.discountDollarAmt = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balance30Day;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalance30Day(){
    return balance30Day; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalance30Day(BigDecimal newVal) {
    this.balance30Day = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalance30Day(double newVal) {
    this.balance30Day = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balance60Day;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalance60Day(){
    return balance60Day; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalance60Day(BigDecimal newVal) {
    this.balance60Day = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalance60Day(double newVal) {
    this.balance60Day = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balance90Day;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalance90Day(){
    return balance90Day; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalance90Day(BigDecimal newVal) {
    this.balance90Day = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalance90Day(double newVal) {
    this.balance90Day = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balanceCurrent;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalanceCurrent(){
    return balanceCurrent; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalanceCurrent(BigDecimal newVal) {
    this.balanceCurrent = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalanceCurrent(double newVal) {
    this.balanceCurrent = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String type;
	
	/**
	 * @generated
 	 */
	public String getType(){
    return type; 
  }

	
	/**
	 * @generated
	 */	
	public void setType(String newVal) {
    this.type = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private TaxTable taxTable;
	
	/**
	 * @generated
 	 */
	public TaxTable getTaxTable(){
    return taxTable; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxTable(TaxTable newVal) {
    this.taxTable = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private TaxCodes taxCode;
	
	/**
	 * @generated
 	 */
	public TaxCodes getTaxCode(){
    return taxCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxCode(TaxCodes newVal) {
    this.taxCode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String statementNote;
	
	/**
	 * @generated
 	 */
	public String getStatementNote(){
    return statementNote; 
  }

	
	/**
	 * @generated
	 */	
	public void setStatementNote(String newVal) {
    this.statementNote = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String jobNote;
	
	/**
	 * @generated
 	 */
	public String getJobNote(){
    return jobNote; 
  }

	
	/**
	 * @generated
	 */	
	public void setJobNote(String newVal) {
    this.jobNote = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String accountNote;
	
	/**
	 * @generated
 	 */
	public String getAccountNote(){
    return accountNote; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccountNote(String newVal) {
    this.accountNote = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String accountId;
	
	/**
	 * @generated
 	 */
	public String getAccountId(){
    return accountId; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccountId(String newVal) {
    this.accountId = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @Where(clause="isdeleted <> 'TRUE'")
	@JoinTable( name = "account_invoiceestimatecharges")
	private java.util.List<ChargeDefinition> invoiceEstimateCharges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getInvoiceEstimateCharges(){
    return invoiceEstimateCharges; 
  }

	/**
	 * @generated
	 */	
	public void addInvoiceEstimateCharges(ChargeDefinition obj) {
    if (invoiceEstimateCharges == null) {
      invoiceEstimateCharges = new java.util.ArrayList<ChargeDefinition>();
    }
    invoiceEstimateCharges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setInvoiceEstimateCharges(java.util.List<ChargeDefinition> newVal) {
    this.invoiceEstimateCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @Where(clause="isdeleted <> 'TRUE'")
	@JoinTable( name = "account_jobcharges")
	private java.util.List<ChargeDefinition> jobCharges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getJobCharges(){
    return jobCharges; 
  }

	/**
	 * @generated
	 */	
	public void addJobCharges(ChargeDefinition obj) {
    if (jobCharges == null) {
      jobCharges = new java.util.ArrayList<ChargeDefinition>();
    }
    jobCharges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setJobCharges(java.util.List<ChargeDefinition> newVal) {
    this.jobCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean webRegistered;
	
	/**
	 * @generated
 	 */
	public Boolean getWebRegistered(){
    return webRegistered; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebRegistered(Boolean newVal) {
    this.webRegistered = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private WebCompany webCompanyId;
	
	/**
	 * @generated
 	 */
	public WebCompany getWebCompanyId(){
    return webCompanyId; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebCompanyId(WebCompany newVal) {
    this.webCompanyId = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private WebCatalogs webCatalog;
	
	/**
	 * @generated
 	 */
	public WebCatalogs getWebCatalog(){
    return webCatalog; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebCatalog(WebCatalogs newVal) {
    this.webCatalog = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Integer access_level;

	/**
   * @generated
 	 */
  public Integer getAccess_level(){
    return access_level; 
  }

	/**
   * @generated
   */	
  public void setAccess_level(Integer newVal) {
    this.access_level = newVal;
  }

	/**
   * @generated
   */	
 	@Basic
  private Boolean walkIn;

	/**
   * @generated
 	 */
  public Boolean getWalkIn(){
    return walkIn; 
  }

	/**
   * @generated
   */	
  public void setWalkIn(Boolean newVal) {
    this.walkIn = newVal;
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
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
    if (ONETIMEDISCOUNT.equals(propertyName)) return getOneTimeDiscount();
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
    if (EXTERNALREF.equals(propertyName)) return getExternalRef();
    if (SALESREP.equals(propertyName)) return getSalesRep();
    if (SHIPPINGMODE.equals(propertyName)) return getShippingMode();
    if (LASTINVOICEDATE.equals(propertyName)) return getLastInvoiceDate();
    if (LASTESTIMATEDATE.equals(propertyName)) return getLastEstimateDate();
    if (FIRSTINVOICEDATE.equals(propertyName)) return getFirstInvoiceDate();
    if (FIRSTESTIMATEDATE.equals(propertyName)) return getFirstEstimateDate();
    if (LASTAGEDDATE.equals(propertyName)) return getLastAgedDate();
    if (LASTBILLEDDATE.equals(propertyName)) return getLastBilledDate();
    if (MARKETING.equals(propertyName)) return getMarketing();
    if (LASTPAYMENTDATE.equals(propertyName)) return getLastPaymentDate();
    if (LASTPOSTINGDATE.equals(propertyName)) return getLastPostingDate();
    if (LASTRANKINGDATE.equals(propertyName)) return getLastRankingDate();
    if (CREDITCARDEXPIRATION.equals(propertyName)) return getCreditCardExpiration();
    if (CREDITCARDINFO.equals(propertyName)) return getCreditCardInfo();
    if (AUTOPAYMODE.equals(propertyName)) return getAutoPayMode();
    if (AUTOPAYINTERVAL.equals(propertyName)) return getAutoPayInterval();
    if (CREDITCARDTYPE.equals(propertyName)) return getCreditCardType();
    if (AUTOPAYMINIMUM.equals(propertyName)) return getAutoPayMinimum();
    if (AUTOPAYMAXIMUM.equals(propertyName)) return getAutoPayMaximum();
    if (AUTOPAYTOTAL.equals(propertyName)) return getAutoPayTotal();
    if (AUTOPAYAMOUNT.equals(propertyName)) return getAutoPayAmount();
    if (AUTOPAYSTOP.equals(propertyName)) return getAutoPayStop();
    if (AUTOPAYSTART.equals(propertyName)) return getAutoPayStart();
    if (AUTOPAYLASTPOSTED.equals(propertyName)) return getAutoPayLastPosted();
    if (AUTOPAYPAYMENTQTY.equals(propertyName)) return getAutoPayPaymentQty();
    if (LASTNOTIFIEDDATE.equals(propertyName)) return getLastNotifiedDate();
    if (RESALECERTEXPIRATIONDATE.equals(propertyName)) return getResaleCertExpirationDate();
    if (ONACCOUNT.equals(propertyName)) return getOnAccount();
    if (BALANCE.equals(propertyName)) return getBalance();
    if (SALESMONTH.equals(propertyName)) return getSalesMonth();
    if (ORDERSMONTH.equals(propertyName)) return getOrdersMonth();
    if (SALESYEAR.equals(propertyName)) return getSalesYear();
    if (SALESPRIORYEAR.equals(propertyName)) return getSalesPriorYear();
    if (ORDERSYEAR.equals(propertyName)) return getOrdersYear();
    if (ORDERSTOTAL.equals(propertyName)) return getOrdersTotal();
    if (ESTIMATECOUNT.equals(propertyName)) return getEstimateCount();
    if (CREDITLIMIT.equals(propertyName)) return getCreditLimit();
    if (DISCOUNT.equals(propertyName)) return getDiscount();
    if (TERMSNET.equals(propertyName)) return getTermsNet();
    if (TERMSDISCOUNT.equals(propertyName)) return getTermsDiscount();
    if (FINANCERATE.equals(propertyName)) return getFinanceRate();
    if (FINANCEYEAR.equals(propertyName)) return getFinanceYear();
    if (ESTIMATESWON.equals(propertyName)) return getEstimatesWon();
    if (ESTIMATESLOST.equals(propertyName)) return getEstimatesLost();
    if (DISCOUNTDOLLARAMT.equals(propertyName)) return getDiscountDollarAmt();
    if (BALANCE30DAY.equals(propertyName)) return getBalance30Day();
    if (BALANCE60DAY.equals(propertyName)) return getBalance60Day();
    if (BALANCE90DAY.equals(propertyName)) return getBalance90Day();
    if (BALANCECURRENT.equals(propertyName)) return getBalanceCurrent();
    if (TYPE.equals(propertyName)) return getType();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (STATEMENTNOTE.equals(propertyName)) return getStatementNote();
    if (JOBNOTE.equals(propertyName)) return getJobNote();
    if (ACCOUNTNOTE.equals(propertyName)) return getAccountNote();
    if (ACCOUNTID.equals(propertyName)) return getAccountId();
    if (INVOICEESTIMATECHARGES.equals(propertyName)) return getInvoiceEstimateCharges();
    if (JOBCHARGES.equals(propertyName)) return getJobCharges();
    if (WEBREGISTERED.equals(propertyName)) return getWebRegistered();
    if (WEBCOMPANYID.equals(propertyName)) return getWebCompanyId();
    if (WEBCATALOG.equals(propertyName)) return getWebCatalog();
    if (ACCESS_LEVEL.equals(propertyName)) return getAccess_level();
    if (WALKIN.equals(propertyName)) return getWalkIn();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
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
    if (ONETIMEDISCOUNT.equals(propertyName)) setOneTimeDiscount((Boolean)newValue); else
    if (FILEORIGINALS.equals(propertyName)) setFileOriginals((Boolean)newValue); else
    if (WEBACCESSENABLED.equals(propertyName)) setWebAccessEnabled((Boolean)newValue); else
    if (PROSPECT.equals(propertyName)) setProspect((Boolean)newValue); else
    if (AUTOPAYENABLED.equals(propertyName)) setAutoPayEnabled((Boolean)newValue); else
    if (OPTOUTMARKETING.equals(propertyName)) setOptOutMarketing((Boolean)newValue); else
    if (ACCTISINDIVIDUAL.equals(propertyName)) setAcctIsIndividual((Boolean)newValue); else
    if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
    if (PAYCOMMISSIONS.equals(propertyName)) setPayCommissions((Boolean)newValue); else
    if (POREQUIRED.equals(propertyName)) setPoRequired((Boolean)newValue); else
    if (APPLYFINANCECHARGES.equals(propertyName)) setApplyFinanceCharges((Boolean)newValue); else
    if (GENERATESTATEMENTS.equals(propertyName)) setGenerateStatements((Boolean)newValue); else
    if (EXTERNALREF.equals(propertyName)) setExternalRef((String)newValue); else
    if (SALESREP.equals(propertyName)) setSalesRep((SalesRep)newValue); else
    if (SHIPPINGMODE.equals(propertyName)) setShippingMode((ShippingMethod)newValue); else
    if (LASTINVOICEDATE.equals(propertyName)) setLastInvoiceDate((Date)newValue); else
    if (LASTESTIMATEDATE.equals(propertyName)) setLastEstimateDate((Date)newValue); else
    if (FIRSTINVOICEDATE.equals(propertyName)) setFirstInvoiceDate((Date)newValue); else
    if (FIRSTESTIMATEDATE.equals(propertyName)) setFirstEstimateDate((Date)newValue); else
    if (LASTAGEDDATE.equals(propertyName)) setLastAgedDate((Date)newValue); else
    if (LASTBILLEDDATE.equals(propertyName)) setLastBilledDate((Date)newValue); else
    if (MARKETING.equals(propertyName)) setMarketing((Marketing)newValue); else
    if (LASTPAYMENTDATE.equals(propertyName)) setLastPaymentDate((Date)newValue); else
    if (LASTPOSTINGDATE.equals(propertyName)) setLastPostingDate((Date)newValue); else
    if (LASTRANKINGDATE.equals(propertyName)) setLastRankingDate((Date)newValue); else
    if (CREDITCARDEXPIRATION.equals(propertyName)) setCreditCardExpiration((Date)newValue); else
    if (CREDITCARDINFO.equals(propertyName)) setCreditCardInfo((String)newValue); else
    if (AUTOPAYMODE.equals(propertyName)) setAutoPayMode((Long)newValue); else
    if (AUTOPAYINTERVAL.equals(propertyName)) setAutoPayInterval((Long)newValue); else
    if (CREDITCARDTYPE.equals(propertyName)) setCreditCardType((String)newValue); else
    if (AUTOPAYMINIMUM.equals(propertyName)) setAutoPayMinimum((BigDecimal)newValue); else
    if (AUTOPAYMAXIMUM.equals(propertyName)) setAutoPayMaximum((BigDecimal)newValue); else
    if (AUTOPAYTOTAL.equals(propertyName)) setAutoPayTotal((BigDecimal)newValue); else
    if (AUTOPAYAMOUNT.equals(propertyName)) setAutoPayAmount((BigDecimal)newValue); else
    if (AUTOPAYSTOP.equals(propertyName)) setAutoPayStop((Date)newValue); else
    if (AUTOPAYSTART.equals(propertyName)) setAutoPayStart((Date)newValue); else
    if (AUTOPAYLASTPOSTED.equals(propertyName)) setAutoPayLastPosted((Date)newValue); else
    if (AUTOPAYPAYMENTQTY.equals(propertyName)) setAutoPayPaymentQty((Long)newValue); else
    if (LASTNOTIFIEDDATE.equals(propertyName)) setLastNotifiedDate((Date)newValue); else
    if (RESALECERTEXPIRATIONDATE.equals(propertyName)) setResaleCertExpirationDate((Date)newValue); else
    if (ONACCOUNT.equals(propertyName)) setOnAccount((BigDecimal)newValue); else
    if (BALANCE.equals(propertyName)) setBalance((BigDecimal)newValue); else
    if (SALESMONTH.equals(propertyName)) setSalesMonth((BigDecimal)newValue); else
    if (ORDERSMONTH.equals(propertyName)) setOrdersMonth((Long)newValue); else
    if (SALESYEAR.equals(propertyName)) setSalesYear((BigDecimal)newValue); else
    if (SALESPRIORYEAR.equals(propertyName)) setSalesPriorYear((BigDecimal)newValue); else
    if (ORDERSYEAR.equals(propertyName)) setOrdersYear((Long)newValue); else
    if (ORDERSTOTAL.equals(propertyName)) setOrdersTotal((Long)newValue); else
    if (ESTIMATECOUNT.equals(propertyName)) setEstimateCount((Long)newValue); else
    if (CREDITLIMIT.equals(propertyName)) setCreditLimit((BigDecimal)newValue); else
    if (DISCOUNT.equals(propertyName)) setDiscount((Double)newValue); else
    if (TERMSNET.equals(propertyName)) setTermsNet((Long)newValue); else
    if (TERMSDISCOUNT.equals(propertyName)) setTermsDiscount((Double)newValue); else
    if (FINANCERATE.equals(propertyName)) setFinanceRate((Double)newValue); else
    if (FINANCEYEAR.equals(propertyName)) setFinanceYear((Double)newValue); else
    if (ESTIMATESWON.equals(propertyName)) setEstimatesWon((Long)newValue); else
    if (ESTIMATESLOST.equals(propertyName)) setEstimatesLost((Long)newValue); else
    if (DISCOUNTDOLLARAMT.equals(propertyName)) setDiscountDollarAmt((BigDecimal)newValue); else
    if (BALANCE30DAY.equals(propertyName)) setBalance30Day((BigDecimal)newValue); else
    if (BALANCE60DAY.equals(propertyName)) setBalance60Day((BigDecimal)newValue); else
    if (BALANCE90DAY.equals(propertyName)) setBalance90Day((BigDecimal)newValue); else
    if (BALANCECURRENT.equals(propertyName)) setBalanceCurrent((BigDecimal)newValue); else
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (STATEMENTNOTE.equals(propertyName)) setStatementNote((String)newValue); else
    if (JOBNOTE.equals(propertyName)) setJobNote((String)newValue); else
    if (ACCOUNTNOTE.equals(propertyName)) setAccountNote((String)newValue); else
    if (ACCOUNTID.equals(propertyName)) setAccountId((String)newValue); else
    if (INVOICEESTIMATECHARGES.equals(propertyName)) setInvoiceEstimateCharges((java.util.List<ChargeDefinition>)newValue); else
    if (JOBCHARGES.equals(propertyName)) setJobCharges((java.util.List<ChargeDefinition>)newValue); else
    if (WEBREGISTERED.equals(propertyName)) setWebRegistered((Boolean)newValue); else
    if (WEBCOMPANYID.equals(propertyName)) setWebCompanyId((WebCompany)newValue); else
    if (WEBCATALOG.equals(propertyName)) setWebCatalog((WebCatalogs)newValue); else
    if (ACCESS_LEVEL.equals(propertyName)) setAccess_level((Integer)newValue); else
    if (WALKIN.equals(propertyName)) setWalkIn((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
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
    if (ONETIMEDISCOUNT.equals(propertyName)) 
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
      return new Class<?>[] {Boolean.class};		
    if (POREQUIRED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (APPLYFINANCECHARGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (GENERATESTATEMENTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EXTERNALREF.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESREP.equals(propertyName)) 
      return new Class<?>[] {SalesRep.class};		
    if (SHIPPINGMODE.equals(propertyName)) 
      return new Class<?>[] {ShippingMethod.class};		
    if (LASTINVOICEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTESTIMATEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FIRSTINVOICEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FIRSTESTIMATEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTAGEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTBILLEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (MARKETING.equals(propertyName)) 
      return new Class<?>[] {Marketing.class};		
    if (LASTPAYMENTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTPOSTINGDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTRANKINGDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CREDITCARDEXPIRATION.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CREDITCARDINFO.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AUTOPAYMODE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (AUTOPAYINTERVAL.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CREDITCARDTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AUTOPAYMINIMUM.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (AUTOPAYMAXIMUM.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (AUTOPAYTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (AUTOPAYAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (AUTOPAYSTOP.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (AUTOPAYSTART.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (AUTOPAYLASTPOSTED.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (AUTOPAYPAYMENTQTY.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (LASTNOTIFIEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (RESALECERTEXPIRATIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ONACCOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SALESMONTH.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ORDERSMONTH.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (SALESYEAR.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SALESPRIORYEAR.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ORDERSYEAR.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ORDERSTOTAL.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ESTIMATECOUNT.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CREDITLIMIT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (DISCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TERMSNET.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (TERMSDISCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FINANCERATE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FINANCEYEAR.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ESTIMATESWON.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ESTIMATESLOST.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (DISCOUNTDOLLARAMT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCE30DAY.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCE60DAY.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCE90DAY.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCECURRENT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (STATEMENTNOTE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBNOTE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCOUNTNOTE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCOUNTID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (INVOICEESTIMATECHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
    if (JOBCHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
    if (WEBREGISTERED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WEBCOMPANYID.equals(propertyName)) 
      return new Class<?>[] {WebCompany.class};		
    if (WEBCATALOG.equals(propertyName)) 
      return new Class<?>[] {WebCatalogs.class};		
    if (ACCESS_LEVEL.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (WALKIN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
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
    if (ONETIMEDISCOUNT.equals(propertyName)) return Account.class;
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
    if (EXTERNALREF.equals(propertyName)) return Account.class;
    if (SALESREP.equals(propertyName)) return Account.class;
    if (SHIPPINGMODE.equals(propertyName)) return Account.class;
    if (LASTINVOICEDATE.equals(propertyName)) return Account.class;
    if (LASTESTIMATEDATE.equals(propertyName)) return Account.class;
    if (FIRSTINVOICEDATE.equals(propertyName)) return Account.class;
    if (FIRSTESTIMATEDATE.equals(propertyName)) return Account.class;
    if (LASTAGEDDATE.equals(propertyName)) return Account.class;
    if (LASTBILLEDDATE.equals(propertyName)) return Account.class;
    if (MARKETING.equals(propertyName)) return Account.class;
    if (LASTPAYMENTDATE.equals(propertyName)) return Account.class;
    if (LASTPOSTINGDATE.equals(propertyName)) return Account.class;
    if (LASTRANKINGDATE.equals(propertyName)) return Account.class;
    if (CREDITCARDEXPIRATION.equals(propertyName)) return Account.class;
    if (CREDITCARDINFO.equals(propertyName)) return Account.class;
    if (AUTOPAYMODE.equals(propertyName)) return Account.class;
    if (AUTOPAYINTERVAL.equals(propertyName)) return Account.class;
    if (CREDITCARDTYPE.equals(propertyName)) return Account.class;
    if (AUTOPAYMINIMUM.equals(propertyName)) return Account.class;
    if (AUTOPAYMAXIMUM.equals(propertyName)) return Account.class;
    if (AUTOPAYTOTAL.equals(propertyName)) return Account.class;
    if (AUTOPAYAMOUNT.equals(propertyName)) return Account.class;
    if (AUTOPAYSTOP.equals(propertyName)) return Account.class;
    if (AUTOPAYSTART.equals(propertyName)) return Account.class;
    if (AUTOPAYLASTPOSTED.equals(propertyName)) return Account.class;
    if (AUTOPAYPAYMENTQTY.equals(propertyName)) return Account.class;
    if (LASTNOTIFIEDDATE.equals(propertyName)) return Account.class;
    if (RESALECERTEXPIRATIONDATE.equals(propertyName)) return Account.class;
    if (ONACCOUNT.equals(propertyName)) return Account.class;
    if (BALANCE.equals(propertyName)) return Account.class;
    if (SALESMONTH.equals(propertyName)) return Account.class;
    if (ORDERSMONTH.equals(propertyName)) return Account.class;
    if (SALESYEAR.equals(propertyName)) return Account.class;
    if (SALESPRIORYEAR.equals(propertyName)) return Account.class;
    if (ORDERSYEAR.equals(propertyName)) return Account.class;
    if (ORDERSTOTAL.equals(propertyName)) return Account.class;
    if (ESTIMATECOUNT.equals(propertyName)) return Account.class;
    if (CREDITLIMIT.equals(propertyName)) return Account.class;
    if (DISCOUNT.equals(propertyName)) return Account.class;
    if (TERMSNET.equals(propertyName)) return Account.class;
    if (TERMSDISCOUNT.equals(propertyName)) return Account.class;
    if (FINANCERATE.equals(propertyName)) return Account.class;
    if (FINANCEYEAR.equals(propertyName)) return Account.class;
    if (ESTIMATESWON.equals(propertyName)) return Account.class;
    if (ESTIMATESLOST.equals(propertyName)) return Account.class;
    if (DISCOUNTDOLLARAMT.equals(propertyName)) return Account.class;
    if (BALANCE30DAY.equals(propertyName)) return Account.class;
    if (BALANCE60DAY.equals(propertyName)) return Account.class;
    if (BALANCE90DAY.equals(propertyName)) return Account.class;
    if (BALANCECURRENT.equals(propertyName)) return Account.class;
    if (TYPE.equals(propertyName)) return Account.class;
    if (TAXTABLE.equals(propertyName)) return Account.class;
    if (TAXCODE.equals(propertyName)) return Account.class;
    if (STATEMENTNOTE.equals(propertyName)) return Account.class;
    if (JOBNOTE.equals(propertyName)) return Account.class;
    if (ACCOUNTNOTE.equals(propertyName)) return Account.class;
    if (ACCOUNTID.equals(propertyName)) return Account.class;
    if (INVOICEESTIMATECHARGES.equals(propertyName)) return Account.class;
    if (JOBCHARGES.equals(propertyName)) return Account.class;
    if (WEBREGISTERED.equals(propertyName)) return Account.class;
    if (WEBCOMPANYID.equals(propertyName)) return Account.class;
    if (WEBCATALOG.equals(propertyName)) return Account.class;
    if (ACCESS_LEVEL.equals(propertyName)) return Account.class;
    if (WALKIN.equals(propertyName)) return Account.class;
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
    if (! SmartEquals(getOneTimeDiscount(), objT.getOneTimeDiscount()))
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
    if (! SmartEquals(getExternalRef(), objT.getExternalRef()))
      return false;
    if (! SmartEquals(getSalesRep(), objT.getSalesRep()))
      return false;
    if (! SmartEquals(getShippingMode(), objT.getShippingMode()))
      return false;
    if (! SmartEquals(getLastInvoiceDate(), objT.getLastInvoiceDate()))
      return false;
    if (! SmartEquals(getLastEstimateDate(), objT.getLastEstimateDate()))
      return false;
    if (! SmartEquals(getFirstInvoiceDate(), objT.getFirstInvoiceDate()))
      return false;
    if (! SmartEquals(getFirstEstimateDate(), objT.getFirstEstimateDate()))
      return false;
    if (! SmartEquals(getLastAgedDate(), objT.getLastAgedDate()))
      return false;
    if (! SmartEquals(getLastBilledDate(), objT.getLastBilledDate()))
      return false;
    if (! SmartEquals(getMarketing(), objT.getMarketing()))
      return false;
    if (! SmartEquals(getLastPaymentDate(), objT.getLastPaymentDate()))
      return false;
    if (! SmartEquals(getLastPostingDate(), objT.getLastPostingDate()))
      return false;
    if (! SmartEquals(getLastRankingDate(), objT.getLastRankingDate()))
      return false;
    if (! SmartEquals(getCreditCardExpiration(), objT.getCreditCardExpiration()))
      return false;
    if (! SmartEquals(getCreditCardInfo(), objT.getCreditCardInfo()))
      return false;
    if (! SmartEquals(getAutoPayMode(), objT.getAutoPayMode()))
      return false;
    if (! SmartEquals(getAutoPayInterval(), objT.getAutoPayInterval()))
      return false;
    if (! SmartEquals(getCreditCardType(), objT.getCreditCardType()))
      return false;
    if (! SmartEquals(getAutoPayMinimum(), objT.getAutoPayMinimum()))
      return false;
    if (! SmartEquals(getAutoPayMaximum(), objT.getAutoPayMaximum()))
      return false;
    if (! SmartEquals(getAutoPayTotal(), objT.getAutoPayTotal()))
      return false;
    if (! SmartEquals(getAutoPayAmount(), objT.getAutoPayAmount()))
      return false;
    if (! SmartEquals(getAutoPayStop(), objT.getAutoPayStop()))
      return false;
    if (! SmartEquals(getAutoPayStart(), objT.getAutoPayStart()))
      return false;
    if (! SmartEquals(getAutoPayLastPosted(), objT.getAutoPayLastPosted()))
      return false;
    if (! SmartEquals(getAutoPayPaymentQty(), objT.getAutoPayPaymentQty()))
      return false;
    if (! SmartEquals(getLastNotifiedDate(), objT.getLastNotifiedDate()))
      return false;
    if (! SmartEquals(getResaleCertExpirationDate(), objT.getResaleCertExpirationDate()))
      return false;
    if (! SmartEquals(getOnAccount(), objT.getOnAccount()))
      return false;
    if (! SmartEquals(getBalance(), objT.getBalance()))
      return false;
    if (! SmartEquals(getSalesMonth(), objT.getSalesMonth()))
      return false;
    if (! SmartEquals(getOrdersMonth(), objT.getOrdersMonth()))
      return false;
    if (! SmartEquals(getSalesYear(), objT.getSalesYear()))
      return false;
    if (! SmartEquals(getSalesPriorYear(), objT.getSalesPriorYear()))
      return false;
    if (! SmartEquals(getOrdersYear(), objT.getOrdersYear()))
      return false;
    if (! SmartEquals(getOrdersTotal(), objT.getOrdersTotal()))
      return false;
    if (! SmartEquals(getEstimateCount(), objT.getEstimateCount()))
      return false;
    if (! SmartEquals(getCreditLimit(), objT.getCreditLimit()))
      return false;
    if (! SmartEquals(getDiscount(), objT.getDiscount()))
      return false;
    if (! SmartEquals(getTermsNet(), objT.getTermsNet()))
      return false;
    if (! SmartEquals(getTermsDiscount(), objT.getTermsDiscount()))
      return false;
    if (! SmartEquals(getFinanceRate(), objT.getFinanceRate()))
      return false;
    if (! SmartEquals(getFinanceYear(), objT.getFinanceYear()))
      return false;
    if (! SmartEquals(getEstimatesWon(), objT.getEstimatesWon()))
      return false;
    if (! SmartEquals(getEstimatesLost(), objT.getEstimatesLost()))
      return false;
    if (! SmartEquals(getDiscountDollarAmt(), objT.getDiscountDollarAmt()))
      return false;
    if (! SmartEquals(getBalance30Day(), objT.getBalance30Day()))
      return false;
    if (! SmartEquals(getBalance60Day(), objT.getBalance60Day()))
      return false;
    if (! SmartEquals(getBalance90Day(), objT.getBalance90Day()))
      return false;
    if (! SmartEquals(getBalanceCurrent(), objT.getBalanceCurrent()))
      return false;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getStatementNote(), objT.getStatementNote()))
      return false;
    if (! SmartEquals(getJobNote(), objT.getJobNote()))
      return false;
    if (! SmartEquals(getAccountNote(), objT.getAccountNote()))
      return false;
    if (! SmartEquals(getAccountId(), objT.getAccountId()))
      return false;
    if (! SmartEquals(getInvoiceEstimateCharges(), objT.getInvoiceEstimateCharges()))
      return false;
    if (! SmartEquals(getJobCharges(), objT.getJobCharges()))
      return false;
    if (! SmartEquals(getWebRegistered(), objT.getWebRegistered()))
      return false;
    if (! SmartEquals(getWebCompanyId(), objT.getWebCompanyId()))
      return false;
    if (! SmartEquals(getWebCatalog(), objT.getWebCatalog()))
      return false;
    if (! SmartEquals(getAccess_level(), objT.getAccess_level()))
      return false;
    if (! SmartEquals(getWalkIn(), objT.getWalkIn()))
      return false;
    return true;
  }			
}
