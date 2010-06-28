
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
	public static final String INVOICE = "Invoice";
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (TRANSACTIONTYPE.equals(propertyName)) return getTransactionType();
    if (TRANSACTIONSTATUS.equals(propertyName)) return getTransactionStatus();
    if (TRANSACTIONRESULTS.equals(propertyName)) return getTransactionResults();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TAXINAMOUNT.equals(propertyName)) return getTaxInAmount();
    if (INVOICE.equals(propertyName)) return getInvoice();
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
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (TRANSACTIONTYPE.equals(propertyName)) setTransactionType((String)newValue); else
    if (TRANSACTIONSTATUS.equals(propertyName)) setTransactionStatus((String)newValue); else
    if (TRANSACTIONRESULTS.equals(propertyName)) setTransactionResults((String)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
    if (TAXINAMOUNT.equals(propertyName)) setTaxInAmount((Boolean)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
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
      return new Class<?>[] {String.class};		
    if (TRANSACTIONSTATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRANSACTIONRESULTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXINAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
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
    if (INVOICE.equals(propertyName)) return CreditCardTransactions.class;
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
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
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
    return true;
  }			
}