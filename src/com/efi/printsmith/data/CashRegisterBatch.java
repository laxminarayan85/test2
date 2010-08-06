
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "CashRegisterBatch.findall", query = "from CashRegisterBatch"),
  @NamedQuery(name = "CashRegisterBatch.byId", query = "select a from CashRegisterBatch a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cashregisterbatch")
public class CashRegisterBatch extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CHANGE = "Change";
	/**
	 * @generated
	 */
	public static final String TENDERED = "Tendered";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "SubTotal";
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String TAXAMOUNT = "TaxAmount";
	/**
	 * @generated
	 */
	public static final String TOTALPRICE = "TotalPrice";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONS = "Transactions";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String POSTED = "Posted";
	/**
	 * @generated
	 */
	public static final String POSTEDDATE = "PostedDate";

	/**
	 * @generated
	 */
	public CashRegisterBatch() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double change;
	
	/**
	 * @generated
 	 */
	public Double getChange(){
    return change; 
  }

	
	/**
	 * @generated
	 */	
	public void setChange(Double newVal) {
    this.change = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double tendered;
	
	/**
	 * @generated
 	 */
	public Double getTendered(){
    return tendered; 
  }

	
	/**
	 * @generated
	 */	
	public void setTendered(Double newVal) {
    this.tendered = newVal;
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
	private BigDecimal taxAmount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTaxAmount(){
    return taxAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxAmount(BigDecimal newVal) {
    this.taxAmount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTaxAmount(double newVal) {
    this.taxAmount = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal totalPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalPrice(){
    return totalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalPrice(BigDecimal newVal) {
    this.totalPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotalPrice(double newVal) {
    this.totalPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "cashregisterbatch_transactions")
	private java.util.List<CashRegister> transactions;
	
	/**
	 * @generated
 	 */
	public java.util.List<CashRegister> getTransactions(){
    return transactions; 
  }

	/**
	 * @generated
	 */	
	public void addTransactions(CashRegister obj) {
    if (transactions == null) {
      transactions = new java.util.ArrayList<CashRegister>();
    }
    transactions.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setTransactions(java.util.List<CashRegister> newVal) {
    this.transactions = newVal;
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
 	@Basic
	private Boolean posted;
	
	/**
	 * @generated
 	 */
	public Boolean getPosted(){
    return posted; 
  }

	
	/**
	 * @generated
	 */	
	public void setPosted(Boolean newVal) {
    this.posted = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CHANGE.equals(propertyName)) return getChange();
    if (TENDERED.equals(propertyName)) return getTendered();
    if (SUBTOTAL.equals(propertyName)) return getSubTotal();
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
    if (TOTALPRICE.equals(propertyName)) return getTotalPrice();
    if (TRANSACTIONS.equals(propertyName)) return getTransactions();
    if (NAME.equals(propertyName)) return getName();
    if (POSTED.equals(propertyName)) return getPosted();
    if (POSTEDDATE.equals(propertyName)) return getPostedDate();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CHANGE.equals(propertyName)) setChange((Double)newValue); else
    if (TENDERED.equals(propertyName)) setTendered((Double)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
    if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxAmount((BigDecimal)newValue); else
    if (TOTALPRICE.equals(propertyName)) setTotalPrice((BigDecimal)newValue); else
    if (TRANSACTIONS.equals(propertyName)) setTransactions((java.util.List<CashRegister>)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (POSTED.equals(propertyName)) setPosted((Boolean)newValue); else
    if (POSTEDDATE.equals(propertyName)) setPostedDate((Date)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CHANGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TENDERED.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TRANSACTIONS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, CashRegister.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (POSTED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (POSTEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CHANGE.equals(propertyName)) return CashRegisterBatch.class;
    if (TENDERED.equals(propertyName)) return CashRegisterBatch.class;
    if (SUBTOTAL.equals(propertyName)) return CashRegisterBatch.class;
    if (QUANTITY.equals(propertyName)) return CashRegisterBatch.class;
    if (TAXAMOUNT.equals(propertyName)) return CashRegisterBatch.class;
    if (TOTALPRICE.equals(propertyName)) return CashRegisterBatch.class;
    if (TRANSACTIONS.equals(propertyName)) return CashRegisterBatch.class;
    if (NAME.equals(propertyName)) return CashRegisterBatch.class;
    if (POSTED.equals(propertyName)) return CashRegisterBatch.class;
    if (POSTEDDATE.equals(propertyName)) return CashRegisterBatch.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CashRegisterBatch objT = (CashRegisterBatch)obj;
    if (! SmartEquals(getChange(), objT.getChange()))
      return false;
    if (! SmartEquals(getTendered(), objT.getTendered()))
      return false;
    if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
      return false;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
      return false;
    if (! SmartEquals(getTotalPrice(), objT.getTotalPrice()))
      return false;
    if (! SmartEquals(getTransactions(), objT.getTransactions()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getPosted(), objT.getPosted()))
      return false;
    if (! SmartEquals(getPostedDate(), objT.getPostedDate()))
      return false;
    return true;
  }			
}
