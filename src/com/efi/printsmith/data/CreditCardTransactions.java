
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
  @NamedQuery(name = "CreditCardTransactions.findall", query = "from CreditCardTransactions"),
  @NamedQuery(name = "CreditCardTransactions.byId", query = "select a from CreditCardTransactions a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "creditcardtransactions")
@SQLDelete(sql="update creditcardtransactions set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class CreditCardTransactions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TRANSACTIONDATE = "TransactionDate";
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
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String TAXINAMOUNT = "TaxInAmount";
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
	public static final String USERNAME = "UserName";
	/**
	 * @generated
	 */
	public static final String TRACKONE = "TrackOne";
	/**
	 * @generated
	 */
	public static final String TRACKTWO = "TrackTwo";
	/**
	 * @generated
	 */
	public static final String TEMPCVV2 = "TempCVV2";

	/**
   * @generated
   */
  public static final String CREDITCARD = "CreditCard";

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
  public static final String WSID = "WsId";

	/**
   * @generated
   */
  public static final String ISCURRENTTRANSACTION = "IsCurrentTransaction";

	/**
   * @generated
   */
  public static final String VERBALAUTHCODE = "VerbalAuthCode";
	/**
   * @generated
   */
  public static final String VERBALAUTHDATE = "VerbalAuthDate";
	/**
   * @generated
   */
  public static final String ORDERNUMBER = "OrderNumber";

	/**
	 * @generated
	 */
	public CreditCardTransactions() {
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
	private Integer transactionType;
	
	/**
	 * @generated
 	 */
	public Integer getTransactionType(){
    return transactionType; 
  }

	
	/**
   * @generated
   */	
  public void setTransactionType(Integer newVal) {
    this.transactionType = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Integer transactionStatus;
	
	/**
	 * @generated
 	 */
	public Integer getTransactionStatus(){
    return transactionStatus; 
  }

	
	/**
   * @generated
   */	
  public void setTransactionStatus(Integer newVal) {
    this.transactionStatus = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Integer transactionResults;
	
	/**
	 * @generated
 	 */
	public Integer getTransactionResults(){
    return transactionResults; 
  }

	
	/**
   * @generated
   */	
  public void setTransactionResults(Integer newVal) {
    this.transactionResults = newVal;
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
 	@Basic
	private String userName;
	
	/**
	 * @generated
 	 */
	public String getUserName(){
    return userName; 
  }

	
	/**
	 * @generated
	 */	
	public void setUserName(String newVal) {
    this.userName = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String trackOne;
	
	/**
	 * @generated
 	 */
	public String getTrackOne(){
    return trackOne; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackOne(String newVal) {
    this.trackOne = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String trackTwo;
	
	/**
	 * @generated
 	 */
	public String getTrackTwo(){
    return trackTwo; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackTwo(String newVal) {
    this.trackTwo = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String tempCVV2;
	
	/**
	 * @generated
 	 */
	public String getTempCVV2(){
    return tempCVV2; 
  }

	
	/**
	 * @generated
	 */	
	public void setTempCVV2(String newVal) {
    this.tempCVV2 = newVal;
  }
	
	/**
   * @generated
   */	
    @ManyToOne( cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
  private CreditCard creditCard;

	/**
   * @generated
 	 */
  public CreditCard getCreditCard(){
    return creditCard; 
  }


	/**
   * @generated
   */	
  public void setCreditCard(CreditCard newVal) {
    this.creditCard = newVal;
  }


	/**
   * @generated
   */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
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
 	@Basic
  private Integer wsId;

	/**
   * @generated
 	 */
  public Integer getWsId(){
    return wsId; 
  }


	/**
   * @generated
   */	
  public void setWsId(Integer newVal) {
    this.wsId = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Integer isCurrentTransaction;

	/**
   * @generated
 	 */
  public Integer getIsCurrentTransaction(){
    return isCurrentTransaction; 
  }


	/**
   * @generated
   */	
  public void setIsCurrentTransaction(Integer newVal) {
    this.isCurrentTransaction = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private String verbalAuthCode;

	/**
   * @generated
 	 */
  public String getVerbalAuthCode(){
    return verbalAuthCode; 
  }


	/**
   * @generated
   */	
  public void setVerbalAuthCode(String newVal) {
    this.verbalAuthCode = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date verbalAuthDate;

	/**
   * @generated
 	 */
  public Date getVerbalAuthDate(){
    return verbalAuthDate; 
  }


	/**
   * @generated
   */	
  public void setVerbalAuthDate(Date newVal) {
    this.verbalAuthDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String orderNumber;

	/**
   * @generated
 	 */
  public String getOrderNumber(){
    return orderNumber; 
  }


	/**
   * @generated
   */	
  public void setOrderNumber(String newVal) {
    this.orderNumber = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (TRANSACTIONTYPE.equals(propertyName)) return getTransactionType();
    if (TRANSACTIONSTATUS.equals(propertyName)) return getTransactionStatus();
    if (TRANSACTIONRESULTS.equals(propertyName)) return getTransactionResults();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TAXINAMOUNT.equals(propertyName)) return getTaxInAmount();
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
    if (USERNAME.equals(propertyName)) return getUserName();
    if (TRACKONE.equals(propertyName)) return getTrackOne();
    if (TRACKTWO.equals(propertyName)) return getTrackTwo();
    if (TEMPCVV2.equals(propertyName)) return getTempCVV2();
    if (CREDITCARD.equals(propertyName)) return getCreditCard();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (CONTACT.equals(propertyName)) return getContact();
    if (WSID.equals(propertyName)) return getWsId();
    if (ISCURRENTTRANSACTION.equals(propertyName)) return getIsCurrentTransaction();
    if (VERBALAUTHCODE.equals(propertyName)) return getVerbalAuthCode();
    if (VERBALAUTHDATE.equals(propertyName)) return getVerbalAuthDate();
    if (ORDERNUMBER.equals(propertyName)) return getOrderNumber();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (TRANSACTIONTYPE.equals(propertyName)) setTransactionType((Integer)newValue); else
    if (TRANSACTIONSTATUS.equals(propertyName)) setTransactionStatus((Integer)newValue); else
    if (TRANSACTIONRESULTS.equals(propertyName)) setTransactionResults((Integer)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
    if (TAXINAMOUNT.equals(propertyName)) setTaxInAmount((Boolean)newValue); else
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
    if (USERNAME.equals(propertyName)) setUserName((String)newValue); else
    if (TRACKONE.equals(propertyName)) setTrackOne((String)newValue); else
    if (TRACKTWO.equals(propertyName)) setTrackTwo((String)newValue); else
    if (TEMPCVV2.equals(propertyName)) setTempCVV2((String)newValue); else
    if (CREDITCARD.equals(propertyName)) setCreditCard((CreditCard)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
    if (WSID.equals(propertyName)) setWsId((Integer)newValue); else
    if (ISCURRENTTRANSACTION.equals(propertyName)) setIsCurrentTransaction((Integer)newValue); else
    if (VERBALAUTHCODE.equals(propertyName)) setVerbalAuthCode((String)newValue); else
    if (VERBALAUTHDATE.equals(propertyName)) setVerbalAuthDate((Date)newValue); else
    if (ORDERNUMBER.equals(propertyName)) setOrderNumber((String)newValue); else
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
    if (TRANSACTIONTYPE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TRANSACTIONSTATUS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TRANSACTIONRESULTS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXINAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
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
    if (USERNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRACKONE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRACKTWO.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TEMPCVV2.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CREDITCARD.equals(propertyName)) 
      return new Class<?>[] {CreditCard.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (CONTACT.equals(propertyName)) 
      return new Class<?>[] {Contact.class};		
    if (WSID.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ISCURRENTTRANSACTION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (VERBALAUTHCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VERBALAUTHDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ORDERNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONDATE.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONTYPE.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONSTATUS.equals(propertyName)) return CreditCardTransactions.class;
    if (TRANSACTIONRESULTS.equals(propertyName)) return CreditCardTransactions.class;
    if (AMOUNT.equals(propertyName)) return CreditCardTransactions.class;
    if (TAXINAMOUNT.equals(propertyName)) return CreditCardTransactions.class;
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
    if (USERNAME.equals(propertyName)) return CreditCardTransactions.class;
    if (TRACKONE.equals(propertyName)) return CreditCardTransactions.class;
    if (TRACKTWO.equals(propertyName)) return CreditCardTransactions.class;
    if (TEMPCVV2.equals(propertyName)) return CreditCardTransactions.class;
    if (CREDITCARD.equals(propertyName)) return CreditCardTransactions.class;
    if (ACCOUNT.equals(propertyName)) return CreditCardTransactions.class;
    if (CONTACT.equals(propertyName)) return CreditCardTransactions.class;
    if (WSID.equals(propertyName)) return CreditCardTransactions.class;
    if (ISCURRENTTRANSACTION.equals(propertyName)) return CreditCardTransactions.class;
    if (VERBALAUTHCODE.equals(propertyName)) return CreditCardTransactions.class;
    if (VERBALAUTHDATE.equals(propertyName)) return CreditCardTransactions.class;
    if (ORDERNUMBER.equals(propertyName)) return CreditCardTransactions.class;
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
    if (! SmartEquals(getTransactionType(), objT.getTransactionType()))
      return false;
    if (! SmartEquals(getTransactionStatus(), objT.getTransactionStatus()))
      return false;
    if (! SmartEquals(getTransactionResults(), objT.getTransactionResults()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getTaxInAmount(), objT.getTaxInAmount()))
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
    if (! SmartEquals(getUserName(), objT.getUserName()))
      return false;
    if (! SmartEquals(getTrackOne(), objT.getTrackOne()))
      return false;
    if (! SmartEquals(getTrackTwo(), objT.getTrackTwo()))
      return false;
    if (! SmartEquals(getTempCVV2(), objT.getTempCVV2()))
      return false;
    if (! SmartEquals(getCreditCard(), objT.getCreditCard()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getContact(), objT.getContact()))
      return false;
    if (! SmartEquals(getWsId(), objT.getWsId()))
      return false;
    if (! SmartEquals(getIsCurrentTransaction(), objT.getIsCurrentTransaction()))
      return false;
    if (! SmartEquals(getVerbalAuthCode(), objT.getVerbalAuthCode()))
      return false;
    if (! SmartEquals(getVerbalAuthDate(), objT.getVerbalAuthDate()))
      return false;
    if (! SmartEquals(getOrderNumber(), objT.getOrderNumber()))
      return false;
    return true;
  }			
}
