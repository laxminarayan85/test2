
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
  @NamedQuery(name = "TapePaymentRecord.findall", query = "from TapePaymentRecord"),
  @NamedQuery(name = "TapePaymentRecord.byId", query = "select a from TapePaymentRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapepaymentrecord")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapepaymentrecord where modelbase.id=?")
@SQLDelete(sql="update tapepaymentrecord set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapePaymentRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String PAYMENTMETHOD = "PaymentMethod";
	/**
	 * @generated
	 */
	public static final String REFNUMBER = "RefNumber";
	/**
	 * @generated
	 */
	public static final String CHECKNUMBER = "CheckNumber";
	/**
	 * @generated
	 */
	public static final String CCT = "Cct";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String TOTAL = "Total";
	/**
	 * @generated
	 */
	public static final String ORRATE = "OrRate";
	/**
	 * @generated
	 */
	public static final String OPPRICE = "OpPrice";
	/**
	 * @generated
	 */
	public static final String TAXEXEMPT = "TaxExempt";
	/**
	 * @generated
	 */
	public static final String TAXAMOUNT = "TaxAmount";
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
	public static final String ISDELETEDRECORD = "IsDeletedRecord";
	/**
	 * @generated
	 */
	public static final String AMOUNTBALANCE = "AmountBalance";
	/**
	 * @generated
	 */
	public static final String CHANGEAMOUNT = "ChangeAmount";
	/**
	 * @generated
	 */
	public static final String REFUNDAMOUNT = "RefundAmount";

	/**
   * @generated
   */
  public static final String SUBTOTAL = "SubTotal";

	/**
	 * @generated
	 */
	public TapePaymentRecord() {
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
	private String paymentMethod;
	
	/**
	 * @generated
 	 */
	public String getPaymentMethod(){
    return paymentMethod; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaymentMethod(String newVal) {
    this.paymentMethod = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String refNumber;
	
	/**
	 * @generated
 	 */
	public String getRefNumber(){
    return refNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setRefNumber(String newVal) {
    this.refNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String checkNumber;
	
	/**
	 * @generated
 	 */
	public String getCheckNumber(){
    return checkNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setCheckNumber(String newVal) {
    this.checkNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private CreditCardTransactions cct;
	
	/**
	 * @generated
 	 */
	public CreditCardTransactions getCct(){
    return cct; 
  }

	
	/**
	 * @generated
	 */	
	public void setCct(CreditCardTransactions newVal) {
    this.cct = newVal;
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
 	@Basic
	private Double total;
	
	/**
	 * @generated
 	 */
	public Double getTotal(){
    return total; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotal(Double newVal) {
    this.total = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean orRate;
	
	/**
	 * @generated
 	 */
	public Boolean getOrRate(){
    return orRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrRate(Boolean newVal) {
    this.orRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean opPrice;
	
	/**
	 * @generated
 	 */
	public Boolean getOpPrice(){
    return opPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOpPrice(Boolean newVal) {
    this.opPrice = newVal;
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
	private Double taxAmount;
	
	/**
	 * @generated
 	 */
	public Double getTaxAmount(){
    return taxAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxAmount(Double newVal) {
    this.taxAmount = newVal;
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
	private Boolean isDeletedRecord;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDeletedRecord(){
    return isDeletedRecord; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsDeletedRecord(Boolean newVal) {
    this.isDeletedRecord = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double amountBalance;
	
	/**
	 * @generated
 	 */
	public Double getAmountBalance(){
    return amountBalance; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmountBalance(Double newVal) {
    this.amountBalance = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double changeAmount;
	
	/**
	 * @generated
 	 */
	public Double getChangeAmount(){
    return changeAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setChangeAmount(Double newVal) {
    this.changeAmount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double refundAmount;
	
	/**
	 * @generated
 	 */
	public Double getRefundAmount(){
    return refundAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setRefundAmount(Double newVal) {
    this.refundAmount = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private BigDecimal subTotal;

	/**
   * @generated
 	 */
  public BigDecimal getSubTotal(){
    return subTotal; 
  }

	/**
   * @generated
   */	
  public void setSubTotal(BigDecimal newVal) {
    this.subTotal = newVal;
  }

	/**
   * @generated
   */	
  public void setSubTotal(double newVal) {
    this.subTotal = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PAYMENTMETHOD.equals(propertyName)) return getPaymentMethod();
    if (REFNUMBER.equals(propertyName)) return getRefNumber();
    if (CHECKNUMBER.equals(propertyName)) return getCheckNumber();
    if (CCT.equals(propertyName)) return getCct();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (ORRATE.equals(propertyName)) return getOrRate();
    if (OPPRICE.equals(propertyName)) return getOpPrice();
    if (TAXEXEMPT.equals(propertyName)) return getTaxExempt();
    if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (ISDELETEDRECORD.equals(propertyName)) return getIsDeletedRecord();
    if (AMOUNTBALANCE.equals(propertyName)) return getAmountBalance();
    if (CHANGEAMOUNT.equals(propertyName)) return getChangeAmount();
    if (REFUNDAMOUNT.equals(propertyName)) return getRefundAmount();
    if (SUBTOTAL.equals(propertyName)) return getSubTotal();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PAYMENTMETHOD.equals(propertyName)) setPaymentMethod((String)newValue); else
    if (REFNUMBER.equals(propertyName)) setRefNumber((String)newValue); else
    if (CHECKNUMBER.equals(propertyName)) setCheckNumber((String)newValue); else
    if (CCT.equals(propertyName)) setCct((CreditCardTransactions)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((Double)newValue); else
    if (ORRATE.equals(propertyName)) setOrRate((Boolean)newValue); else
    if (OPPRICE.equals(propertyName)) setOpPrice((Boolean)newValue); else
    if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxAmount((Double)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (ISDELETEDRECORD.equals(propertyName)) setIsDeletedRecord((Boolean)newValue); else
    if (AMOUNTBALANCE.equals(propertyName)) setAmountBalance((Double)newValue); else
    if (CHANGEAMOUNT.equals(propertyName)) setChangeAmount((Double)newValue); else
    if (REFUNDAMOUNT.equals(propertyName)) setRefundAmount((Double)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PAYMENTMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REFNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHECKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CCT.equals(propertyName)) 
      return new Class<?>[] {CreditCardTransactions.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ORRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OPPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXEXEMPT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (ISDELETEDRECORD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AMOUNTBALANCE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CHANGEAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (REFUNDAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PAYMENTMETHOD.equals(propertyName)) return TapePaymentRecord.class;
    if (REFNUMBER.equals(propertyName)) return TapePaymentRecord.class;
    if (CHECKNUMBER.equals(propertyName)) return TapePaymentRecord.class;
    if (CCT.equals(propertyName)) return TapePaymentRecord.class;
    if (INVOICE.equals(propertyName)) return TapePaymentRecord.class;
    if (TOTAL.equals(propertyName)) return TapePaymentRecord.class;
    if (ORRATE.equals(propertyName)) return TapePaymentRecord.class;
    if (OPPRICE.equals(propertyName)) return TapePaymentRecord.class;
    if (TAXEXEMPT.equals(propertyName)) return TapePaymentRecord.class;
    if (TAXAMOUNT.equals(propertyName)) return TapePaymentRecord.class;
    if (TAXCODE.equals(propertyName)) return TapePaymentRecord.class;
    if (TAXTABLE.equals(propertyName)) return TapePaymentRecord.class;
    if (ISDELETEDRECORD.equals(propertyName)) return TapePaymentRecord.class;
    if (AMOUNTBALANCE.equals(propertyName)) return TapePaymentRecord.class;
    if (CHANGEAMOUNT.equals(propertyName)) return TapePaymentRecord.class;
    if (REFUNDAMOUNT.equals(propertyName)) return TapePaymentRecord.class;
    if (SUBTOTAL.equals(propertyName)) return TapePaymentRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapePaymentRecord objT = (TapePaymentRecord)obj;
    if (! SmartEquals(getPaymentMethod(), objT.getPaymentMethod()))
      return false;
    if (! SmartEquals(getRefNumber(), objT.getRefNumber()))
      return false;
    if (! SmartEquals(getCheckNumber(), objT.getCheckNumber()))
      return false;
    if (! SmartEquals(getCct(), objT.getCct()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getOrRate(), objT.getOrRate()))
      return false;
    if (! SmartEquals(getOpPrice(), objT.getOpPrice()))
      return false;
    if (! SmartEquals(getTaxExempt(), objT.getTaxExempt()))
      return false;
    if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getIsDeletedRecord(), objT.getIsDeletedRecord()))
      return false;
    if (! SmartEquals(getAmountBalance(), objT.getAmountBalance()))
      return false;
    if (! SmartEquals(getChangeAmount(), objT.getChangeAmount()))
      return false;
    if (! SmartEquals(getRefundAmount(), objT.getRefundAmount()))
      return false;
    if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
      return false;
    return true;
  }			
}
