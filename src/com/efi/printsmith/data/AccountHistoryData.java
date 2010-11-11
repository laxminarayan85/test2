
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
	public static final String PAYMENTS = "Payments";
	/**
	 * @generated
	 */
	public static final String FINANCECHARGE = "FinanceCharge";
	/**
	 * @generated
	 */
	public static final String DEPOSITTAKEN = "DepositTaken";
	/**
	 * @generated
	 */
	public static final String DEPOSITREFUND = "DepositRefund";

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
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
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
	@Where(clause="isdeleted <> 'TRUE'")
	private TapePaymentRecord payments;
	
	/**
	 * @generated
 	 */
	public TapePaymentRecord getPayments(){
    return payments; 
  }

	
	/**
   * @generated
   */	
  public void setPayments(TapePaymentRecord newVal) {
    this.payments = newVal;
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
	private Integer depositTaken;
	
	/**
	 * @generated
 	 */
	public Integer getDepositTaken(){
    return depositTaken; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepositTaken(Integer newVal) {
    this.depositTaken = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer depositRefund;
	
	/**
	 * @generated
 	 */
	public Integer getDepositRefund(){
    return depositRefund; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepositRefund(Integer newVal) {
    this.depositRefund = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (JOURNAL.equals(propertyName)) return getJournal();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (PAYMENTS.equals(propertyName)) return getPayments();
    if (FINANCECHARGE.equals(propertyName)) return getFinanceCharge();
    if (DEPOSITTAKEN.equals(propertyName)) return getDepositTaken();
    if (DEPOSITREFUND.equals(propertyName)) return getDepositRefund();
    if (STORENUMBER.equals(propertyName)) return getStoreNumber();
    if (POSTEDDATE.equals(propertyName)) return getPostedDate();
    if (PAYMENTDUEDATE.equals(propertyName)) return getPaymentDueDate();
    if (FINALPAYMENTDATE.equals(propertyName)) return getFinalPaymentDate();
    if (SUBTOTALPOSTED.equals(propertyName)) return getSubTotalPosted();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (REFUNDTOTAL.equals(propertyName)) return getRefundTotal();
    if (BALANCE.equals(propertyName)) return getBalance();
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
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (PAYMENTS.equals(propertyName)) setPayments((TapePaymentRecord)newValue); else
    if (FINANCECHARGE.equals(propertyName)) setFinanceCharge((Integer)newValue); else
    if (DEPOSITTAKEN.equals(propertyName)) setDepositTaken((Integer)newValue); else
    if (DEPOSITREFUND.equals(propertyName)) setDepositRefund((Integer)newValue); else
    if (STORENUMBER.equals(propertyName)) setStoreNumber((String)newValue); else
    if (POSTEDDATE.equals(propertyName)) setPostedDate((Date)newValue); else
    if (PAYMENTDUEDATE.equals(propertyName)) setPaymentDueDate((Date)newValue); else
    if (FINALPAYMENTDATE.equals(propertyName)) setFinalPaymentDate((Date)newValue); else
    if (SUBTOTALPOSTED.equals(propertyName)) setSubTotalPosted((BigDecimal)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((BigDecimal)newValue); else
    if (REFUNDTOTAL.equals(propertyName)) setRefundTotal((BigDecimal)newValue); else
    if (BALANCE.equals(propertyName)) setBalance((BigDecimal)newValue); else
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
      return new Class<?>[] {Invoice.class};		
    if (PAYMENTS.equals(propertyName)) 
      return new Class<?>[] {TapePaymentRecord.class};		
    if (FINANCECHARGE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DEPOSITTAKEN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DEPOSITREFUND.equals(propertyName)) 
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
    if (PAYMENTS.equals(propertyName)) return AccountHistoryData.class;
    if (FINANCECHARGE.equals(propertyName)) return AccountHistoryData.class;
    if (DEPOSITTAKEN.equals(propertyName)) return AccountHistoryData.class;
    if (DEPOSITREFUND.equals(propertyName)) return AccountHistoryData.class;
    if (STORENUMBER.equals(propertyName)) return AccountHistoryData.class;
    if (POSTEDDATE.equals(propertyName)) return AccountHistoryData.class;
    if (PAYMENTDUEDATE.equals(propertyName)) return AccountHistoryData.class;
    if (FINALPAYMENTDATE.equals(propertyName)) return AccountHistoryData.class;
    if (SUBTOTALPOSTED.equals(propertyName)) return AccountHistoryData.class;
    if (TOTAL.equals(propertyName)) return AccountHistoryData.class;
    if (REFUNDTOTAL.equals(propertyName)) return AccountHistoryData.class;
    if (BALANCE.equals(propertyName)) return AccountHistoryData.class;
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
    if (! SmartEquals(getPayments(), objT.getPayments()))
      return false;
    if (! SmartEquals(getFinanceCharge(), objT.getFinanceCharge()))
      return false;
    if (! SmartEquals(getDepositTaken(), objT.getDepositTaken()))
      return false;
    if (! SmartEquals(getDepositRefund(), objT.getDepositRefund()))
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
    return true;
  }			
}
