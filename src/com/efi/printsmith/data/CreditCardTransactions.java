
package com.efi.printsmith.data;

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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "CreditCardTransactions.findall", query = "from CreditCardTransactions"),
  @NamedQuery(name = "CreditCardTransactions.byId", query = "select a from CreditCardTransactions a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "creditcardtransactions")
public class CreditCardTransactions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TRANSACTIONDATE = "TransactionDate";
	/**
	 * @generated
	 */
	public static final String CARDTYPE = "CardType";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONTYPE = "TransactionType";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONSTATUS = "TransactionStatus";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONRESULTS = "TransactionResults";
	/**
	 * @generated
	 */
	public static final String ENCRYPTION = "Encryption";
	/**
	 * @generated
	 */
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String CCHOLDERNAME = "CCHolderName";
	/**
	 * @generated
	 */
	public static final String CCNUMBER = "CCNumber";
	/**
	 * @generated
	 */
	public static final String CCNUMBERDISPLAY = "CCNumberDisplay";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String TAXINAMOUNT = "TaxInAmount";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String USER = "User";
	/**
	 * @generated
	 */
	public static final String PONUMBER = "PoNumber";
	/**
	 * @generated
	 */
	public static final String REFERENCENUMBER = "ReferenceNumber";
	/**
	 * @generated
	 */
	public static final String APPROVALCODE = "ApprovalCode";
	/**
	 * @generated
	 */
	public static final String APPROVALDATE = "ApprovalDate";
	/**
	 * @generated
	 */
	public static final String MESSAGE = "Message";
	/**
	 * @generated
	 */
	public static final String PERMANENT = "Permanent";
	/**
	 * @generated
	 */
	public static final String MANUALCODE = "ManualCode";
	/**
	 * @generated
	 */
	public static final String FAILEDAVS = "FailedAVS";
	/**
   * @generated
   */
  public static final String HASCVVDATA = "HasCVVdata";
	/**
	 * @generated
	 */
	public static final String TRACKDATAUSED = "TrackDataUsed";
	/**
	 * @generated
	 */
	public static final String TAXEXEMPT = "TaxExempt";
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String TAXCODE = "TaxCode";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";

	/**
	 * @generated
	 */
	public CreditCardTransactions() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date transactionDate;
	
	/**
	 * @generated
 	 */
	public Date getTransactionDate(){
    return transactionDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setTransactionDate(Date newVal) {
    this.transactionDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cardType;
	
	/**
	 * @generated
 	 */
	public String getCardType(){
    return cardType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCardType(String newVal) {
    this.cardType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String transactionType;
	
	/**
	 * @generated
 	 */
	public String getTransactionType(){
    return transactionType; 
  }

	
	/**
	 * @generated
	 */	
	public void setTransactionType(String newVal) {
    this.transactionType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String transactionStatus;
	
	/**
	 * @generated
 	 */
	public String getTransactionStatus(){
    return transactionStatus; 
  }

	
	/**
	 * @generated
	 */	
	public void setTransactionStatus(String newVal) {
    this.transactionStatus = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String transactionResults;
	
	/**
	 * @generated
 	 */
	public String getTransactionResults(){
    return transactionResults; 
  }

	
	/**
	 * @generated
	 */	
	public void setTransactionResults(String newVal) {
    this.transactionResults = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String encryption;
	
	/**
	 * @generated
 	 */
	public String getEncryption(){
    return encryption; 
  }

	
	/**
	 * @generated
	 */	
	public void setEncryption(String newVal) {
    this.encryption = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Address address;
	
	/**
	 * @generated
 	 */
	public Address getAddress(){
    return address; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddress(Address newVal) {
    this.address = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cCHolderName;
	
	/**
	 * @generated
 	 */
	public String getCCHolderName(){
    return cCHolderName; 
  }

	
	/**
	 * @generated
	 */	
	public void setCCHolderName(String newVal) {
    this.cCHolderName = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cCNumber;
	
	/**
	 * @generated
 	 */
	public String getCCNumber(){
    return cCNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setCCNumber(String newVal) {
    this.cCNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cCNumberDisplay;
	
	/**
	 * @generated
 	 */
	public String getCCNumberDisplay(){
    return cCNumberDisplay; 
  }

	
	/**
	 * @generated
	 */	
	public void setCCNumberDisplay(String newVal) {
    this.cCNumberDisplay = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double amount;
	
	/**
	 * @generated
 	 */
	public Double getAmount(){
    return amount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmount(Double newVal) {
    this.amount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxInAmount;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxInAmount(){
    return taxInAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxInAmount(Boolean newVal) {
    this.taxInAmount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Invoice invoice;
	
	/**
	 * @generated
 	 */
	public Invoice getInvoice(){
    return invoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setInvoice(Invoice newVal) {
    this.invoice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Account account;
	
	/**
	 * @generated
 	 */
	public Account getAccount(){
    return account; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccount(Account newVal) {
    this.account = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
    @Basic
	@ManyToOne()
	private String user;
	
	/**
	 * @generated
 	 */
	public String getUser(){
    return user; 
  }

	
	/**
   * @generated
   */	
  public void setUser(String newVal) {
    this.user = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private String poNumber;
	
	/**
	 * @generated
 	 */
	public String getPoNumber(){
    return poNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoNumber(String newVal) {
    this.poNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String referenceNumber;
	
	/**
	 * @generated
 	 */
	public String getReferenceNumber(){
    return referenceNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setReferenceNumber(String newVal) {
    this.referenceNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String approvalCode;
	
	/**
	 * @generated
 	 */
	public String getApprovalCode(){
    return approvalCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setApprovalCode(String newVal) {
    this.approvalCode = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date approvalDate;
	
	/**
	 * @generated
 	 */
	public Date getApprovalDate(){
    return approvalDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setApprovalDate(Date newVal) {
    this.approvalDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String message;
	
	/**
	 * @generated
 	 */
	public String getMessage(){
    return message; 
  }

	
	/**
	 * @generated
	 */	
	public void setMessage(String newVal) {
    this.message = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean permanent;
	
	/**
	 * @generated
 	 */
	public Boolean getPermanent(){
    return permanent; 
  }

	
	/**
	 * @generated
	 */	
	public void setPermanent(Boolean newVal) {
    this.permanent = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String manualCode;
	
	/**
	 * @generated
 	 */
	public String getManualCode(){
    return manualCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setManualCode(String newVal) {
    this.manualCode = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean failedAVS;
	
	/**
	 * @generated
 	 */
	public Boolean getFailedAVS(){
    return failedAVS; 
  }

	
	/**
	 * @generated
	 */	
	public void setFailedAVS(Boolean newVal) {
    this.failedAVS = newVal;
  }
 	
	
	/**
   * @generated
   */	
 	@Basic
  private Boolean hasCVVdata;

	/**
   * @generated
 	 */
  public Boolean getHasCVVdata(){
    return hasCVVdata; 
  }


	/**
   * @generated
   */	
  public void setHasCVVdata(Boolean newVal) {
    this.hasCVVdata = newVal;
  }



	/**
	 * @generated
	 */	
 	@Basic
	private Boolean trackDataUsed;
	
	/**
	 * @generated
 	 */
	public Boolean getTrackDataUsed(){
    return trackDataUsed; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackDataUsed(Boolean newVal) {
    this.trackDataUsed = newVal;
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
	private Double tax;
	
	/**
	 * @generated
 	 */
	public Double getTax(){
    return tax; 
  }

	
	/**
	 * @generated
	 */	
	public void setTax(Double newVal) {
    this.tax = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
    @ManyToOne()
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (CARDTYPE.equals(propertyName)) return getCardType();
    if (TRANSACTIONTYPE.equals(propertyName)) return getTransactionType();
    if (TRANSACTIONSTATUS.equals(propertyName)) return getTransactionStatus();
    if (TRANSACTIONRESULTS.equals(propertyName)) return getTransactionResults();
    if (ENCRYPTION.equals(propertyName)) return getEncryption();
    if (ADDRESS.equals(propertyName)) return getAddress();
    if (CCHOLDERNAME.equals(propertyName)) return getCCHolderName();
    if (CCNUMBER.equals(propertyName)) return getCCNumber();
    if (CCNUMBERDISPLAY.equals(propertyName)) return getCCNumberDisplay();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TAXINAMOUNT.equals(propertyName)) return getTaxInAmount();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (CONTACT.equals(propertyName)) return getContact();
    if (USER.equals(propertyName)) return getUser();
    if (PONUMBER.equals(propertyName)) return getPoNumber();
    if (REFERENCENUMBER.equals(propertyName)) return getReferenceNumber();
    if (APPROVALCODE.equals(propertyName)) return getApprovalCode();
    if (APPROVALDATE.equals(propertyName)) return getApprovalDate();
    if (MESSAGE.equals(propertyName)) return getMessage();
    if (PERMANENT.equals(propertyName)) return getPermanent();
    if (MANUALCODE.equals(propertyName)) return getManualCode();
    if (FAILEDAVS.equals(propertyName)) return getFailedAVS();
    if (HASCVVDATA.equals(propertyName)) return getHasCVVdata();
    if (TRACKDATAUSED.equals(propertyName)) return getTrackDataUsed();
    if (TAXEXEMPT.equals(propertyName)) return getTaxExempt();
    if (TAX.equals(propertyName)) return getTax();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (CARDTYPE.equals(propertyName)) setCardType((String)newValue); else
    if (TRANSACTIONTYPE.equals(propertyName)) setTransactionType((String)newValue); else
    if (TRANSACTIONSTATUS.equals(propertyName)) setTransactionStatus((String)newValue); else
    if (TRANSACTIONRESULTS.equals(propertyName)) setTransactionResults((String)newValue); else
    if (ENCRYPTION.equals(propertyName)) setEncryption((String)newValue); else
    if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
    if (CCHOLDERNAME.equals(propertyName)) setCCHolderName((String)newValue); else
    if (CCNUMBER.equals(propertyName)) setCCNumber((String)newValue); else
    if (CCNUMBERDISPLAY.equals(propertyName)) setCCNumberDisplay((String)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
    if (TAXINAMOUNT.equals(propertyName)) setTaxInAmount((Boolean)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
    if (USER.equals(propertyName)) setUser((String)newValue); else
    if (PONUMBER.equals(propertyName)) setPoNumber((String)newValue); else
    if (REFERENCENUMBER.equals(propertyName)) setReferenceNumber((String)newValue); else
    if (APPROVALCODE.equals(propertyName)) setApprovalCode((String)newValue); else
    if (APPROVALDATE.equals(propertyName)) setApprovalDate((Date)newValue); else
    if (MESSAGE.equals(propertyName)) setMessage((String)newValue); else
    if (PERMANENT.equals(propertyName)) setPermanent((Boolean)newValue); else
    if (MANUALCODE.equals(propertyName)) setManualCode((String)newValue); else
    if (FAILEDAVS.equals(propertyName)) setFailedAVS((Boolean)newValue); else
    if (HASCVVDATA.equals(propertyName)) setHasCVVdata((Boolean)newValue); else
    if (TRACKDATAUSED.equals(propertyName)) setTrackDataUsed((Boolean)newValue); else
    if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
    if (TAX.equals(propertyName)) setTax((Double)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CARDTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRANSACTIONTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRANSACTIONSTATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRANSACTIONRESULTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ENCRYPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (CCHOLDERNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CCNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CCNUMBERDISPLAY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXINAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (CONTACT.equals(propertyName)) 
      return new Class<?>[] {Contact.class};		
    if (USER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PONUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REFERENCENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (APPROVALCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (APPROVALDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (MESSAGE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PERMANENT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MANUALCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FAILEDAVS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (HASCVVDATA.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TRACKDATAUSED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXEXEMPT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONDATE.equals(propertyName)) return CreditCardTransactions.class;
    if (CARDTYPE.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONTYPE.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONSTATUS.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONRESULTS.equals(propertyName)) return CreditCardTransactions.class;
    if (ENCRYPTION.equals(propertyName)) return CreditCardTransactions.class;
    if (ADDRESS.equals(propertyName)) return CreditCardTransactions.class;
    if (CCHOLDERNAME.equals(propertyName)) return CreditCardTransactions.class;
    if (CCNUMBER.equals(propertyName)) return CreditCardTransactions.class;
    if (CCNUMBERDISPLAY.equals(propertyName)) return CreditCardTransactions.class;
    if (AMOUNT.equals(propertyName)) return CreditCardTransactions.class;
    if (TAXINAMOUNT.equals(propertyName)) return CreditCardTransactions.class;
    if (INVOICE.equals(propertyName)) return CreditCardTransactions.class;
    if (ACCOUNT.equals(propertyName)) return CreditCardTransactions.class;
    if (CONTACT.equals(propertyName)) return CreditCardTransactions.class;
    if (USER.equals(propertyName)) return CreditCardTransactions.class;
    if (PONUMBER.equals(propertyName)) return CreditCardTransactions.class;
    if (REFERENCENUMBER.equals(propertyName)) return CreditCardTransactions.class;
    if (APPROVALCODE.equals(propertyName)) return CreditCardTransactions.class;
    if (APPROVALDATE.equals(propertyName)) return CreditCardTransactions.class;
    if (MESSAGE.equals(propertyName)) return CreditCardTransactions.class;
    if (PERMANENT.equals(propertyName)) return CreditCardTransactions.class;
    if (MANUALCODE.equals(propertyName)) return CreditCardTransactions.class;
    if (FAILEDAVS.equals(propertyName)) return CreditCardTransactions.class;
    if (HASCVVDATA.equals(propertyName)) return CreditCardTransactions.class;
    if (TRACKDATAUSED.equals(propertyName)) return CreditCardTransactions.class;
    if (TAXEXEMPT.equals(propertyName)) return CreditCardTransactions.class;
    if (TAX.equals(propertyName)) return CreditCardTransactions.class;
    if (TAXCODE.equals(propertyName)) return CreditCardTransactions.class;
    if (TAXTABLE.equals(propertyName)) return CreditCardTransactions.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CreditCardTransactions objT = (CreditCardTransactions)obj;
    if (! SmartEquals(getTransactionDate(), objT.getTransactionDate()))
      return false;
    if (! SmartEquals(getCardType(), objT.getCardType()))
      return false;
    if (! SmartEquals(getTransactionType(), objT.getTransactionType()))
      return false;
    if (! SmartEquals(getTransactionStatus(), objT.getTransactionStatus()))
      return false;
    if (! SmartEquals(getTransactionResults(), objT.getTransactionResults()))
      return false;
    if (! SmartEquals(getEncryption(), objT.getEncryption()))
      return false;
    if (! SmartEquals(getAddress(), objT.getAddress()))
      return false;
    if (! SmartEquals(getCCHolderName(), objT.getCCHolderName()))
      return false;
    if (! SmartEquals(getCCNumber(), objT.getCCNumber()))
      return false;
    if (! SmartEquals(getCCNumberDisplay(), objT.getCCNumberDisplay()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getTaxInAmount(), objT.getTaxInAmount()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getContact(), objT.getContact()))
      return false;
    if (! SmartEquals(getUser(), objT.getUser()))
      return false;
    if (! SmartEquals(getPoNumber(), objT.getPoNumber()))
      return false;
    if (! SmartEquals(getReferenceNumber(), objT.getReferenceNumber()))
      return false;
    if (! SmartEquals(getApprovalCode(), objT.getApprovalCode()))
      return false;
    if (! SmartEquals(getApprovalDate(), objT.getApprovalDate()))
      return false;
    if (! SmartEquals(getMessage(), objT.getMessage()))
      return false;
    if (! SmartEquals(getPermanent(), objT.getPermanent()))
      return false;
    if (! SmartEquals(getManualCode(), objT.getManualCode()))
      return false;
    if (! SmartEquals(getFailedAVS(), objT.getFailedAVS()))
      return false;
    if (! SmartEquals(getHasCVVdata(), objT.getHasCVVdata()))
      return false;
    if (! SmartEquals(getTrackDataUsed(), objT.getTrackDataUsed()))
      return false;
    if (! SmartEquals(getTaxExempt(), objT.getTaxExempt()))
      return false;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    return true;
  }			
}
