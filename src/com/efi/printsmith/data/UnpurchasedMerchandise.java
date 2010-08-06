
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
  @NamedQuery(name = "UnpurchasedMerchandise.findall", query = "from UnpurchasedMerchandise"),
  @NamedQuery(name = "UnpurchasedMerchandise.byId", query = "select a from UnpurchasedMerchandise a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "unpurchasedmerchandise")
public class UnpurchasedMerchandise extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONDATE = "TransactionDate";
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
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "Subtotal";

	/**
	 * @generated
	 */
	public UnpurchasedMerchandise() {
    this.created = new Date();
    this.modified = new Date();
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
 	@Basic
	private BigDecimal amount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAmount(){
    return amount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmount(BigDecimal newVal) {
    this.amount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAmount(double newVal) {
    this.amount = BigDecimal.valueOf(newVal);
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
 	@Basic
	private BigDecimal tax;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTax(){
    return tax; 
  }

	
	/**
	 * @generated
	 */	
	public void setTax(BigDecimal newVal) {
    this.tax = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTax(double newVal) {
    this.tax = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal subtotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSubtotal(){
    return subtotal; 
  }

	
	/**
	 * @generated
	 */	
	public void setSubtotal(BigDecimal newVal) {
    this.subtotal = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSubtotal(double newVal) {
    this.subtotal = BigDecimal.valueOf(newVal);
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAX.equals(propertyName)) return getTax();
    if (SUBTOTAL.equals(propertyName)) return getSubtotal();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((BigDecimal)newValue); else
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAX.equals(propertyName)) setTax((BigDecimal)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubtotal((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TRANSACTIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
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
    if (ACCOUNT.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (AMOUNT.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (TRANSACTIONDATE.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (TAXTABLE.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (TAXCODE.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (TAX.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (SUBTOTAL.equals(propertyName)) return UnpurchasedMerchandise.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    UnpurchasedMerchandise objT = (UnpurchasedMerchandise)obj;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getTransactionDate(), objT.getTransactionDate()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    if (! SmartEquals(getSubtotal(), objT.getSubtotal()))
      return false;
    return true;
  }			
}
