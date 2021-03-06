
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
  @NamedQuery(name = "AccountHistoryData.findall", query = "from AccountHistoryData"),
  @NamedQuery(name = "AccountHistoryData.byId", query = "select a from AccountHistoryData a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "accounthistorydata")
@SQLDelete(sql="update accounthistorydata set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class AccountHistoryData extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String JOURNAL = "Journal";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String FINANCECHARGE = "FinanceCharge";
	/**
   * @generated
   */
  public static final String STORENUMBER = "StoreNumber";
	/**
   * @generated
   */
  public static final String POSTEDDATE = "PostedDate";
	/**
   * @generated
   */
  public static final String PAYMENTDUEDATE = "PaymentDueDate";
	/**
   * @generated
   */
  public static final String FINALPAYMENTDATE = "FinalPaymentDate";
	/**
   * @generated
   */
  public static final String SUBTOTALPOSTED = "SubTotalPosted";
	/**
   * @generated
   */
  public static final String TOTAL = "Total";
	/**
   * @generated
   */
  public static final String REFUNDTOTAL = "RefundTotal";
	/**
   * @generated
   */
  public static final String BALANCE = "Balance";

	/**
   * @generated
   */
  public static final String RECORDTYPE = "RecordType";
	/**
   * @generated
   */
  public static final String PARTIALPAY = "PartialPay";
	/**
   * @generated
   */
  public static final String PARTIALPAYCNT = "PartialPayCnt";
	/**
   * @generated
   */
  public static final String PARTIALPAYTOTAL = "PartialPayTotal";
	/**
   * @generated
   */
  public static final String FINALPAY = "FinalPay";
	/**
   * @generated
   */
  public static final String TAXDETAIL = "TaxDetail";
	/**
   * @generated
   */
  public static final String WEBREFERENCEID = "WebReferenceID";
	/**
   * @generated
   */
  public static final String STORENUM = "StoreNum";
	/**
   * @generated
   */
  public static final String CUSTPO = "CustPO";
	/**
   * @generated
   */
  public static final String SALESREP = "SalesRep";
	/**
   * @generated
   */
  public static final String ORDERNODISPLAY = "OrderNoDisplay";

	/**
   * @generated
   */
  public static final String PARTIALPAYPAYDATE = "PartialPayPaydate";
	/**
   * @generated
   */
  public static final String FINALPAYPAYDATE = "FinalPayPaydate";
	/**
   * @generated
   */
  public static final String PARTIALPAYCHECKNUMBER = "PartialPayCheckNumber";
	/**
   * @generated
   */
  public static final String FINALPAYCHECKNUMBER = "FinalPayCheckNumber";
	/**
   * @generated
   */
  public static final String PARTIALPAYREFNUMBER = "PartialPayRefNumber";
	/**
   * @generated
   */
  public static final String FINALPAYREFNUMBER = "FinalPayRefNumber";
	/**
   * @generated
   */
  public static final String PARTIALPAYCCT = "PartialPayCCT";
	/**
   * @generated
   */
  public static final String FINALPAYCCT = "FinalPayCCT";
	/**
   * @generated
   */
  public static final String PARTIALPAYPAYMETHOD = "PartialPayPayMethod";
	/**
   * @generated
   */
  public static final String FINALPAYPAYMETHOD = "FinalPayPayMethod";
	/**
   * @generated
   */
  public static final String FINALPAYTOTAL = "FinalPayTotal";

	/**
	 * @generated
	 */
	public AccountHistoryData() {
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
	private String name;
	
	/**
	 * @generated
 	 */
	public String getName(){
    return name; 
  }

	
	/**
	 * @generated
	 */	
	public void setName(String newVal) {
    this.name = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne(fetch=FetchType.LAZY)
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
    @ManyToOne(fetch=FetchType.LAZY)
	@Where(clause="isdeleted <> 'TRUE'")
	private Journal journal;
	
	/**
	 * @generated
 	 */
	public Journal getJournal(){
    return journal; 
  }

	
	/**
	 * @generated
	 */	
	public void setJournal(Journal newVal) {
    this.journal = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne(fetch=FetchType.LAZY)
	@Where(clause="isdeleted <> 'TRUE'")
	private InvoiceBase invoice;
	
	/**
	 * @generated
 	 */
	public InvoiceBase getInvoice(){
    return invoice; 
  }

	
	/**
   * @generated
   */	
  public void setInvoice(InvoiceBase newVal) {
    this.invoice = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Integer financeCharge;
	
	/**
	 * @generated
 	 */
	public Integer getFinanceCharge(){
    return financeCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinanceCharge(Integer newVal) {
    this.financeCharge = newVal;
  }
	
 	
	
	/**
   * @generated
   */	
 	@Basic
  private String storeNumber;

	/**
   * @generated
 	 */
  public String getStoreNumber(){
    return storeNumber; 
  }


	/**
   * @generated
   */	
  public void setStoreNumber(String newVal) {
    this.storeNumber = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date postedDate;

	/**
   * @generated
 	 */
  public Date getPostedDate(){
    return postedDate; 
  }


	/**
   * @generated
   */	
  public void setPostedDate(Date newVal) {
    this.postedDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date paymentDueDate;

	/**
   * @generated
 	 */
  public Date getPaymentDueDate(){
    return paymentDueDate; 
  }


	/**
   * @generated
   */	
  public void setPaymentDueDate(Date newVal) {
    this.paymentDueDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date finalPaymentDate;

	/**
   * @generated
 	 */
  public Date getFinalPaymentDate(){
    return finalPaymentDate; 
  }


	/**
   * @generated
   */	
  public void setFinalPaymentDate(Date newVal) {
    this.finalPaymentDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  @Column(name="subTotalPosted", precision=19, scale=8)
  private BigDecimal subTotalPosted;

	/**
   * @generated
 	 */
  public BigDecimal getSubTotalPosted(){
    return subTotalPosted; 
  }


	/**
   * @generated
   */	
  public void setSubTotalPosted(BigDecimal newVal) {
    this.subTotalPosted = newVal;
    this.subTotalPosted.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setSubTotalPosted(double newVal) {
    this.subTotalPosted = BigDecimal.valueOf(newVal);
    this.subTotalPosted.setScale(8, RoundingMode.HALF_UP);
  }



	/**
   * @generated
   */	
 	@Basic
  @Column(name="total", precision=19, scale=8)
  private BigDecimal total;

	/**
   * @generated
 	 */
  public BigDecimal getTotal(){
    return total; 
  }


	/**
   * @generated
   */	
  public void setTotal(BigDecimal newVal) {
    this.total = newVal;
    this.total.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setTotal(double newVal) {
    this.total = BigDecimal.valueOf(newVal);
    this.total.setScale(8, RoundingMode.HALF_UP);
  }



	/**
   * @generated
   */	
 	@Basic
  @Column(name="refundTotal", precision=19, scale=8)
  private BigDecimal refundTotal;

	/**
   * @generated
 	 */
  public BigDecimal getRefundTotal(){
    return refundTotal; 
  }


	/**
   * @generated
   */	
  public void setRefundTotal(BigDecimal newVal) {
    this.refundTotal = newVal;
    this.refundTotal.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setRefundTotal(double newVal) {
    this.refundTotal = BigDecimal.valueOf(newVal);
    this.refundTotal.setScale(8, RoundingMode.HALF_UP);
  }



	/**
   * @generated
   */	
 	@Basic
  @Column(name="balance", precision=19, scale=8)
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
    this.balance.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setBalance(double newVal) {
    this.balance = BigDecimal.valueOf(newVal);
    this.balance.setScale(8, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
 	@Basic
  private String recordType;

	/**
   * @generated
 	 */
  public String getRecordType(){
    return recordType; 
  }


	/**
   * @generated
   */	
  public void setRecordType(String newVal) {
    this.recordType = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private TapePaymentRecord partialPay;

	/**
   * @generated
 	 */
  public TapePaymentRecord getPartialPay(){
    return partialPay; 
  }


	/**
   * @generated
   */	
  public void setPartialPay(TapePaymentRecord newVal) {
    this.partialPay = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal partialPayCnt;

	/**
   * @generated
 	 */
  public BigDecimal getPartialPayCnt(){
    return partialPayCnt; 
  }


	/**
   * @generated
   */	
  public void setPartialPayCnt(BigDecimal newVal) {
    this.partialPayCnt = newVal;
  }


	/**
   * @generated
   */	
  public void setPartialPayCnt(double newVal) {
    this.partialPayCnt = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal partialPayTotal;

	/**
   * @generated
 	 */
  public BigDecimal getPartialPayTotal(){
    return partialPayTotal; 
  }


	/**
   * @generated
   */	
  public void setPartialPayTotal(BigDecimal newVal) {
    this.partialPayTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setPartialPayTotal(double newVal) {
    this.partialPayTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@ManyToOne()
@Where(clause="isdeleted <> 'TRUE'")
	@Basic
  private TapePaymentRecord finalPay;

	/**
   * @generated
 	 */
  public TapePaymentRecord getFinalPay(){
    return finalPay; 
  }


	/**
   * @generated
   */	
  public void setFinalPay(TapePaymentRecord newVal) {
    this.finalPay = newVal;
  }


	/**
   * @generated
   */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private TaxTable taxDetail;

	/**
   * @generated
 	 */
  public TaxTable getTaxDetail(){
    return taxDetail; 
  }


	/**
   * @generated
   */	
  public void setTaxDetail(TaxTable newVal) {
    this.taxDetail = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Long webReferenceID;

	/**
   * @generated
 	 */
  public Long getWebReferenceID(){
    return webReferenceID; 
  }


	/**
   * @generated
   */	
  public void setWebReferenceID(Long newVal) {
    this.webReferenceID = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String storeNum;

	/**
   * @generated
 	 */
  public String getStoreNum(){
    return storeNum; 
  }


	/**
   * @generated
   */	
  public void setStoreNum(String newVal) {
    this.storeNum = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String custPO;

	/**
   * @generated
 	 */
  public String getCustPO(){
    return custPO; 
  }


	/**
   * @generated
   */	
  public void setCustPO(String newVal) {
    this.custPO = newVal;
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
 	@Basic
  private String orderNoDisplay;

	/**
   * @generated
 	 */
  public String getOrderNoDisplay(){
    return orderNoDisplay; 
  }


	/**
   * @generated
   */	
  public void setOrderNoDisplay(String newVal) {
    this.orderNoDisplay = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Date partialPayPaydate;

	/**
   * @generated
 	 */
  public Date getPartialPayPaydate(){
    return partialPayPaydate; 
  }


	/**
   * @generated
   */	
  public void setPartialPayPaydate(Date newVal) {
    this.partialPayPaydate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date finalPayPaydate;

	/**
   * @generated
 	 */
  public Date getFinalPayPaydate(){
    return finalPayPaydate; 
  }


	/**
   * @generated
   */	
  public void setFinalPayPaydate(Date newVal) {
    this.finalPayPaydate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String partialPayCheckNumber;

	/**
   * @generated
 	 */
  public String getPartialPayCheckNumber(){
    return partialPayCheckNumber; 
  }


	/**
   * @generated
   */	
  public void setPartialPayCheckNumber(String newVal) {
    this.partialPayCheckNumber = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String finalPayCheckNumber;

	/**
   * @generated
 	 */
  public String getFinalPayCheckNumber(){
    return finalPayCheckNumber; 
  }


	/**
   * @generated
   */	
  public void setFinalPayCheckNumber(String newVal) {
    this.finalPayCheckNumber = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String partialPayRefNumber;

	/**
   * @generated
 	 */
  public String getPartialPayRefNumber(){
    return partialPayRefNumber; 
  }


	/**
   * @generated
   */	
  public void setPartialPayRefNumber(String newVal) {
    this.partialPayRefNumber = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String finalPayRefNumber;

	/**
   * @generated
 	 */
  public String getFinalPayRefNumber(){
    return finalPayRefNumber; 
  }


	/**
   * @generated
   */	
  public void setFinalPayRefNumber(String newVal) {
    this.finalPayRefNumber = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private CreditCardTransactions partialPayCCT;

	/**
   * @generated
 	 */
  public CreditCardTransactions getPartialPayCCT(){
    return partialPayCCT; 
  }


	/**
   * @generated
   */	
  public void setPartialPayCCT(CreditCardTransactions newVal) {
    this.partialPayCCT = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private CreditCardTransactions finalPayCCT;

	/**
   * @generated
 	 */
  public CreditCardTransactions getFinalPayCCT(){
    return finalPayCCT; 
  }


	/**
   * @generated
   */	
  public void setFinalPayCCT(CreditCardTransactions newVal) {
    this.finalPayCCT = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String partialPayPayMethod;

	/**
   * @generated
 	 */
  public String getPartialPayPayMethod(){
    return partialPayPayMethod; 
  }


	/**
   * @generated
   */	
  public void setPartialPayPayMethod(String newVal) {
    this.partialPayPayMethod = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String finalPayPayMethod;

	/**
   * @generated
 	 */
  public String getFinalPayPayMethod(){
    return finalPayPayMethod; 
  }


	/**
   * @generated
   */	
  public void setFinalPayPayMethod(String newVal) {
    this.finalPayPayMethod = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal finalPayTotal;

	/**
   * @generated
 	 */
  public BigDecimal getFinalPayTotal(){
    return finalPayTotal; 
  }


	/**
   * @generated
   */	
  public void setFinalPayTotal(BigDecimal newVal) {
    this.finalPayTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setFinalPayTotal(double newVal) {
    this.finalPayTotal = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (JOURNAL.equals(propertyName)) return getJournal();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (FINANCECHARGE.equals(propertyName)) return getFinanceCharge();
    if (STORENUMBER.equals(propertyName)) return getStoreNumber();
    if (POSTEDDATE.equals(propertyName)) return getPostedDate();
    if (PAYMENTDUEDATE.equals(propertyName)) return getPaymentDueDate();
    if (FINALPAYMENTDATE.equals(propertyName)) return getFinalPaymentDate();
    if (SUBTOTALPOSTED.equals(propertyName)) return getSubTotalPosted();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (REFUNDTOTAL.equals(propertyName)) return getRefundTotal();
    if (BALANCE.equals(propertyName)) return getBalance();
    if (RECORDTYPE.equals(propertyName)) return getRecordType();
    if (PARTIALPAY.equals(propertyName)) return getPartialPay();
    if (PARTIALPAYCNT.equals(propertyName)) return getPartialPayCnt();
    if (PARTIALPAYTOTAL.equals(propertyName)) return getPartialPayTotal();
    if (FINALPAY.equals(propertyName)) return getFinalPay();
    if (TAXDETAIL.equals(propertyName)) return getTaxDetail();
    if (WEBREFERENCEID.equals(propertyName)) return getWebReferenceID();
    if (STORENUM.equals(propertyName)) return getStoreNum();
    if (CUSTPO.equals(propertyName)) return getCustPO();
    if (SALESREP.equals(propertyName)) return getSalesRep();
    if (ORDERNODISPLAY.equals(propertyName)) return getOrderNoDisplay();
    if (PARTIALPAYPAYDATE.equals(propertyName)) return getPartialPayPaydate();
    if (FINALPAYPAYDATE.equals(propertyName)) return getFinalPayPaydate();
    if (PARTIALPAYCHECKNUMBER.equals(propertyName)) return getPartialPayCheckNumber();
    if (FINALPAYCHECKNUMBER.equals(propertyName)) return getFinalPayCheckNumber();
    if (PARTIALPAYREFNUMBER.equals(propertyName)) return getPartialPayRefNumber();
    if (FINALPAYREFNUMBER.equals(propertyName)) return getFinalPayRefNumber();
    if (PARTIALPAYCCT.equals(propertyName)) return getPartialPayCCT();
    if (FINALPAYCCT.equals(propertyName)) return getFinalPayCCT();
    if (PARTIALPAYPAYMETHOD.equals(propertyName)) return getPartialPayPayMethod();
    if (FINALPAYPAYMETHOD.equals(propertyName)) return getFinalPayPayMethod();
    if (FINALPAYTOTAL.equals(propertyName)) return getFinalPayTotal();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (JOURNAL.equals(propertyName)) setJournal((Journal)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((InvoiceBase)newValue); else
    if (FINANCECHARGE.equals(propertyName)) setFinanceCharge((Integer)newValue); else
    if (STORENUMBER.equals(propertyName)) setStoreNumber((String)newValue); else
    if (POSTEDDATE.equals(propertyName)) setPostedDate((Date)newValue); else
    if (PAYMENTDUEDATE.equals(propertyName)) setPaymentDueDate((Date)newValue); else
    if (FINALPAYMENTDATE.equals(propertyName)) setFinalPaymentDate((Date)newValue); else
    if (SUBTOTALPOSTED.equals(propertyName)) setSubTotalPosted((BigDecimal)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((BigDecimal)newValue); else
    if (REFUNDTOTAL.equals(propertyName)) setRefundTotal((BigDecimal)newValue); else
    if (BALANCE.equals(propertyName)) setBalance((BigDecimal)newValue); else
    if (RECORDTYPE.equals(propertyName)) setRecordType((String)newValue); else
    if (PARTIALPAY.equals(propertyName)) setPartialPay((TapePaymentRecord)newValue); else
    if (PARTIALPAYCNT.equals(propertyName)) setPartialPayCnt((BigDecimal)newValue); else
    if (PARTIALPAYTOTAL.equals(propertyName)) setPartialPayTotal((BigDecimal)newValue); else
    if (FINALPAY.equals(propertyName)) setFinalPay((TapePaymentRecord)newValue); else
    if (TAXDETAIL.equals(propertyName)) setTaxDetail((TaxTable)newValue); else
    if (WEBREFERENCEID.equals(propertyName)) setWebReferenceID((Long)newValue); else
    if (STORENUM.equals(propertyName)) setStoreNum((String)newValue); else
    if (CUSTPO.equals(propertyName)) setCustPO((String)newValue); else
    if (SALESREP.equals(propertyName)) setSalesRep((SalesRep)newValue); else
    if (ORDERNODISPLAY.equals(propertyName)) setOrderNoDisplay((String)newValue); else
    if (PARTIALPAYPAYDATE.equals(propertyName)) setPartialPayPaydate((Date)newValue); else
    if (FINALPAYPAYDATE.equals(propertyName)) setFinalPayPaydate((Date)newValue); else
    if (PARTIALPAYCHECKNUMBER.equals(propertyName)) setPartialPayCheckNumber((String)newValue); else
    if (FINALPAYCHECKNUMBER.equals(propertyName)) setFinalPayCheckNumber((String)newValue); else
    if (PARTIALPAYREFNUMBER.equals(propertyName)) setPartialPayRefNumber((String)newValue); else
    if (FINALPAYREFNUMBER.equals(propertyName)) setFinalPayRefNumber((String)newValue); else
    if (PARTIALPAYCCT.equals(propertyName)) setPartialPayCCT((CreditCardTransactions)newValue); else
    if (FINALPAYCCT.equals(propertyName)) setFinalPayCCT((CreditCardTransactions)newValue); else
    if (PARTIALPAYPAYMETHOD.equals(propertyName)) setPartialPayPayMethod((String)newValue); else
    if (FINALPAYPAYMETHOD.equals(propertyName)) setFinalPayPayMethod((String)newValue); else
    if (FINALPAYTOTAL.equals(propertyName)) setFinalPayTotal((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (JOURNAL.equals(propertyName)) 
      return new Class<?>[] {Journal.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {InvoiceBase.class};		
    if (FINANCECHARGE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STORENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (POSTEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PAYMENTDUEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FINALPAYMENTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (SUBTOTALPOSTED.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (REFUNDTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BALANCE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (RECORDTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARTIALPAY.equals(propertyName)) 
      return new Class<?>[] {TapePaymentRecord.class};		
    if (PARTIALPAYCNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PARTIALPAYTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (FINALPAY.equals(propertyName)) 
      return new Class<?>[] {TapePaymentRecord.class};		
    if (TAXDETAIL.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (WEBREFERENCEID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (STORENUM.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUSTPO.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESREP.equals(propertyName)) 
      return new Class<?>[] {SalesRep.class};		
    if (ORDERNODISPLAY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARTIALPAYPAYDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FINALPAYPAYDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PARTIALPAYCHECKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FINALPAYCHECKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARTIALPAYREFNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FINALPAYREFNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARTIALPAYCCT.equals(propertyName)) 
      return new Class<?>[] {CreditCardTransactions.class};		
    if (FINALPAYCCT.equals(propertyName)) 
      return new Class<?>[] {CreditCardTransactions.class};		
    if (PARTIALPAYPAYMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FINALPAYPAYMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FINALPAYTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return AccountHistoryData.class;
    if (ACCOUNT.equals(propertyName)) return AccountHistoryData.class;
    if (JOURNAL.equals(propertyName)) return AccountHistoryData.class;
    if (INVOICE.equals(propertyName)) return AccountHistoryData.class;
    if (FINANCECHARGE.equals(propertyName)) return AccountHistoryData.class;
    if (STORENUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (POSTEDDATE.equals(propertyName)) return AccountHistoryData.class;
    if (PAYMENTDUEDATE.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYMENTDATE.equals(propertyName)) return AccountHistoryData.class;
    if (SUBTOTALPOSTED.equals(propertyName)) return AccountHistoryData.class;
    if (TOTAL.equals(propertyName)) return AccountHistoryData.class;
    if (REFUNDTOTAL.equals(propertyName)) return AccountHistoryData.class;
    if (BALANCE.equals(propertyName)) return AccountHistoryData.class;
    if (RECORDTYPE.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAY.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYCNT.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYTOTAL.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAY.equals(propertyName)) return AccountHistoryData.class;
    if (TAXDETAIL.equals(propertyName)) return AccountHistoryData.class;
    if (WEBREFERENCEID.equals(propertyName)) return AccountHistoryData.class;
    if (STORENUM.equals(propertyName)) return AccountHistoryData.class;
    if (CUSTPO.equals(propertyName)) return AccountHistoryData.class;
    if (SALESREP.equals(propertyName)) return AccountHistoryData.class;
    if (ORDERNODISPLAY.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYPAYDATE.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYPAYDATE.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYCHECKNUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYCHECKNUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYREFNUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYREFNUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYCCT.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYCCT.equals(propertyName)) return AccountHistoryData.class;
    if (PARTIALPAYPAYMETHOD.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYPAYMETHOD.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYTOTAL.equals(propertyName)) return AccountHistoryData.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    AccountHistoryData objT = (AccountHistoryData)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getJournal(), objT.getJournal()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getFinanceCharge(), objT.getFinanceCharge()))
      return false;
    if (! SmartEquals(getStoreNumber(), objT.getStoreNumber()))
      return false;
    if (! SmartEquals(getPostedDate(), objT.getPostedDate()))
      return false;
    if (! SmartEquals(getPaymentDueDate(), objT.getPaymentDueDate()))
      return false;
    if (! SmartEquals(getFinalPaymentDate(), objT.getFinalPaymentDate()))
      return false;
    if (! SmartEquals(getSubTotalPosted(), objT.getSubTotalPosted()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getRefundTotal(), objT.getRefundTotal()))
      return false;
    if (! SmartEquals(getBalance(), objT.getBalance()))
      return false;
    if (! SmartEquals(getRecordType(), objT.getRecordType()))
      return false;
    if (! SmartEquals(getPartialPay(), objT.getPartialPay()))
      return false;
    if (! SmartEquals(getPartialPayCnt(), objT.getPartialPayCnt()))
      return false;
    if (! SmartEquals(getPartialPayTotal(), objT.getPartialPayTotal()))
      return false;
    if (! SmartEquals(getFinalPay(), objT.getFinalPay()))
      return false;
    if (! SmartEquals(getTaxDetail(), objT.getTaxDetail()))
      return false;
    if (! SmartEquals(getWebReferenceID(), objT.getWebReferenceID()))
      return false;
    if (! SmartEquals(getStoreNum(), objT.getStoreNum()))
      return false;
    if (! SmartEquals(getCustPO(), objT.getCustPO()))
      return false;
    if (! SmartEquals(getSalesRep(), objT.getSalesRep()))
      return false;
    if (! SmartEquals(getOrderNoDisplay(), objT.getOrderNoDisplay()))
      return false;
    if (! SmartEquals(getPartialPayPaydate(), objT.getPartialPayPaydate()))
      return false;
    if (! SmartEquals(getFinalPayPaydate(), objT.getFinalPayPaydate()))
      return false;
    if (! SmartEquals(getPartialPayCheckNumber(), objT.getPartialPayCheckNumber()))
      return false;
    if (! SmartEquals(getFinalPayCheckNumber(), objT.getFinalPayCheckNumber()))
      return false;
    if (! SmartEquals(getPartialPayRefNumber(), objT.getPartialPayRefNumber()))
      return false;
    if (! SmartEquals(getFinalPayRefNumber(), objT.getFinalPayRefNumber()))
      return false;
    if (! SmartEquals(getPartialPayCCT(), objT.getPartialPayCCT()))
      return false;
    if (! SmartEquals(getFinalPayCCT(), objT.getFinalPayCCT()))
      return false;
    if (! SmartEquals(getPartialPayPayMethod(), objT.getPartialPayPayMethod()))
      return false;
    if (! SmartEquals(getFinalPayPayMethod(), objT.getFinalPayPayMethod()))
      return false;
    if (! SmartEquals(getFinalPayTotal(), objT.getFinalPayTotal()))
      return false;
    return true;
  }			
}
