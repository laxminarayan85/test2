
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
  @NamedQuery(name = "TapeSaleRecord.findall", query = "from TapeSaleRecord"),
  @NamedQuery(name = "TapeSaleRecord.byId", query = "select a from TapeSaleRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapesalerecord")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapesalerecord where modelbase.id=?")
@SQLDelete(sql="update tapesalerecord set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeSaleRecord extends Transactions {
	/**
	 * @generated
	 */
	public static final String ISPICKUP = "IsPickup";
	/**
	 * @generated
	 */
	public static final String OPPRICE = "OpPrice";
	/**
	 * @generated
	 */
	public static final String ORRATE = "OrRate";
	/**
	 * @generated
	 */
	public static final String CASHREGISTERDEPT = "CashRegisterDept";
	/**
	 * @generated
	 */
	public static final String UNITPRICE = "UnitPrice";
	/**
	 * @generated
	 */
	public static final String TOTAL = "Total";
	/**
	 * @generated
	 */
	public static final String AMOUNTPAID = "AmountPaid";
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String DEPARTMENT = "Department";
	/**
	 * @generated
	 */
	public static final String PAYMODE = "Paymode";
	/**
	 * @generated
	 */
	public static final String SALESCATEGORY = "SalesCategory";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";

	/**
	 * @generated
	 */
	public TapeSaleRecord() {
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
	private Boolean isPickup;
	
	/**
	 * @generated
 	 */
	public Boolean getIsPickup(){
    return isPickup; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsPickup(Boolean newVal) {
    this.isPickup = newVal;
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
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private PreferencesCashRegister cashRegisterDept;
	
	/**
	 * @generated
 	 */
	public PreferencesCashRegister getCashRegisterDept(){
    return cashRegisterDept; 
  }

	
	/**
	 * @generated
	 */	
	public void setCashRegisterDept(PreferencesCashRegister newVal) {
    this.cashRegisterDept = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double unitPrice;
	
	/**
	 * @generated
 	 */
	public Double getUnitPrice(){
    return unitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitPrice(Double newVal) {
    this.unitPrice = newVal;
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
	private Double amountPaid;
	
	/**
	 * @generated
 	 */
	public Double getAmountPaid(){
    return amountPaid; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmountPaid(Double newVal) {
    this.amountPaid = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double quantity;
	
	/**
	 * @generated
 	 */
	public Double getQuantity(){
    return quantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuantity(Double newVal) {
    this.quantity = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String department;
	
	/**
	 * @generated
 	 */
	public String getDepartment(){
    return department; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepartment(String newVal) {
    this.department = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String paymode;
	
	/**
	 * @generated
 	 */
	public String getPaymode(){
    return paymode; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaymode(String newVal) {
    this.paymode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private SalesCategory salesCategory;
	
	/**
	 * @generated
 	 */
	public SalesCategory getSalesCategory(){
    return salesCategory; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesCategory(SalesCategory newVal) {
    this.salesCategory = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ISPICKUP.equals(propertyName)) return getIsPickup();
    if (OPPRICE.equals(propertyName)) return getOpPrice();
    if (ORRATE.equals(propertyName)) return getOrRate();
    if (CASHREGISTERDEPT.equals(propertyName)) return getCashRegisterDept();
    if (UNITPRICE.equals(propertyName)) return getUnitPrice();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (AMOUNTPAID.equals(propertyName)) return getAmountPaid();
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (DEPARTMENT.equals(propertyName)) return getDepartment();
    if (PAYMODE.equals(propertyName)) return getPaymode();
    if (SALESCATEGORY.equals(propertyName)) return getSalesCategory();
    if (INVOICE.equals(propertyName)) return getInvoice();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ISPICKUP.equals(propertyName)) setIsPickup((Boolean)newValue); else
    if (OPPRICE.equals(propertyName)) setOpPrice((Boolean)newValue); else
    if (ORRATE.equals(propertyName)) setOrRate((Boolean)newValue); else
    if (CASHREGISTERDEPT.equals(propertyName)) setCashRegisterDept((PreferencesCashRegister)newValue); else
    if (UNITPRICE.equals(propertyName)) setUnitPrice((Double)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((Double)newValue); else
    if (AMOUNTPAID.equals(propertyName)) setAmountPaid((Double)newValue); else
    if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else
    if (DEPARTMENT.equals(propertyName)) setDepartment((String)newValue); else
    if (PAYMODE.equals(propertyName)) setPaymode((String)newValue); else
    if (SALESCATEGORY.equals(propertyName)) setSalesCategory((SalesCategory)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ISPICKUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OPPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CASHREGISTERDEPT.equals(propertyName)) 
      return new Class<?>[] {PreferencesCashRegister.class};		
    if (UNITPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (AMOUNTPAID.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEPARTMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PAYMODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESCATEGORY.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ISPICKUP.equals(propertyName)) return TapeSaleRecord.class;
    if (OPPRICE.equals(propertyName)) return TapeSaleRecord.class;
    if (ORRATE.equals(propertyName)) return TapeSaleRecord.class;
    if (CASHREGISTERDEPT.equals(propertyName)) return TapeSaleRecord.class;
    if (UNITPRICE.equals(propertyName)) return TapeSaleRecord.class;
    if (TOTAL.equals(propertyName)) return TapeSaleRecord.class;
    if (AMOUNTPAID.equals(propertyName)) return TapeSaleRecord.class;
    if (QUANTITY.equals(propertyName)) return TapeSaleRecord.class;
    if (DEPARTMENT.equals(propertyName)) return TapeSaleRecord.class;
    if (PAYMODE.equals(propertyName)) return TapeSaleRecord.class;
    if (SALESCATEGORY.equals(propertyName)) return TapeSaleRecord.class;
    if (INVOICE.equals(propertyName)) return TapeSaleRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapeSaleRecord objT = (TapeSaleRecord)obj;
    if (! SmartEquals(getIsPickup(), objT.getIsPickup()))
      return false;
    if (! SmartEquals(getOpPrice(), objT.getOpPrice()))
      return false;
    if (! SmartEquals(getOrRate(), objT.getOrRate()))
      return false;
    if (! SmartEquals(getCashRegisterDept(), objT.getCashRegisterDept()))
      return false;
    if (! SmartEquals(getUnitPrice(), objT.getUnitPrice()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getAmountPaid(), objT.getAmountPaid()))
      return false;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getDepartment(), objT.getDepartment()))
      return false;
    if (! SmartEquals(getPaymode(), objT.getPaymode()))
      return false;
    if (! SmartEquals(getSalesCategory(), objT.getSalesCategory()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    return true;
  }			
}
