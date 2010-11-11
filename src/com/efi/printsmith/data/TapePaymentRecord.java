
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
public class TapePaymentRecord extends Transactions {
	/**
	 * @generated
	 */
	public static final String PAYMENTMETHOD = "PaymentMethod";
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
  public static final String POSTAR = "PostAR";

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
  private Boolean postAR;

	/**
   * @generated
 	 */
  public Boolean getPostAR(){
    return postAR; 
  }

	/**
   * @generated
   */	
  public void setPostAR(Boolean newVal) {
    this.postAR = newVal;
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PAYMENTMETHOD.equals(propertyName)) return getPaymentMethod();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (ORRATE.equals(propertyName)) return getOrRate();
    if (OPPRICE.equals(propertyName)) return getOpPrice();
    if (AMOUNTBALANCE.equals(propertyName)) return getAmountBalance();
    if (CHANGEAMOUNT.equals(propertyName)) return getChangeAmount();
    if (REFUNDAMOUNT.equals(propertyName)) return getRefundAmount();
    if (POSTAR.equals(propertyName)) return getPostAR();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PAYMENTMETHOD.equals(propertyName)) setPaymentMethod((String)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((Double)newValue); else
    if (ORRATE.equals(propertyName)) setOrRate((Boolean)newValue); else
    if (OPPRICE.equals(propertyName)) setOpPrice((Boolean)newValue); else
    if (AMOUNTBALANCE.equals(propertyName)) setAmountBalance((Double)newValue); else
    if (CHANGEAMOUNT.equals(propertyName)) setChangeAmount((Double)newValue); else
    if (REFUNDAMOUNT.equals(propertyName)) setRefundAmount((Double)newValue); else
    if (POSTAR.equals(propertyName)) setPostAR((Boolean)newValue); else
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
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ORRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OPPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AMOUNTBALANCE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CHANGEAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (REFUNDAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (POSTAR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PAYMENTMETHOD.equals(propertyName)) return TapePaymentRecord.class;
    if (INVOICE.equals(propertyName)) return TapePaymentRecord.class;
    if (TOTAL.equals(propertyName)) return TapePaymentRecord.class;
    if (ORRATE.equals(propertyName)) return TapePaymentRecord.class;
    if (OPPRICE.equals(propertyName)) return TapePaymentRecord.class;
    if (AMOUNTBALANCE.equals(propertyName)) return TapePaymentRecord.class;
    if (CHANGEAMOUNT.equals(propertyName)) return TapePaymentRecord.class;
    if (REFUNDAMOUNT.equals(propertyName)) return TapePaymentRecord.class;
    if (POSTAR.equals(propertyName)) return TapePaymentRecord.class;
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
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getOrRate(), objT.getOrRate()))
      return false;
    if (! SmartEquals(getOpPrice(), objT.getOpPrice()))
      return false;
    if (! SmartEquals(getAmountBalance(), objT.getAmountBalance()))
      return false;
    if (! SmartEquals(getChangeAmount(), objT.getChangeAmount()))
      return false;
    if (! SmartEquals(getRefundAmount(), objT.getRefundAmount()))
      return false;
    if (! SmartEquals(getPostAR(), objT.getPostAR()))
      return false;
    return true;
  }			
}
