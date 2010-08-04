
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
  @NamedQuery(name = "CashDrawer.findall", query = "from CashDrawer"),
  @NamedQuery(name = "CashDrawer.byId", query = "select a from CashDrawer a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cashdrawer")
public class CashDrawer extends ModelBase {
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
	public static final String HELD = "Held";
	/**
	 * @generated
	 */
	public static final String FUND = "Fund";

	/**
	 * @generated
	 */
	public CashDrawer() {
    this.created = new Date();
    this.modified = new Date();
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
 	@Basic
	private Boolean held;
	
	/**
	 * @generated
 	 */
	public Boolean getHeld(){
    return held; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeld(Boolean newVal) {
    this.held = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal fund;
	
	/**
	 * @generated
 	 */
	public BigDecimal getFund(){
    return fund; 
  }

	
	/**
	 * @generated
	 */	
	public void setFund(BigDecimal newVal) {
    this.fund = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setFund(double newVal) {
    this.fund = BigDecimal.valueOf(newVal);
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (HELD.equals(propertyName)) return getHeld();
    if (FUND.equals(propertyName)) return getFund();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (AMOUNT.equals(propertyName)) setAmount((BigDecimal)newValue); else
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (HELD.equals(propertyName)) setHeld((Boolean)newValue); else
    if (FUND.equals(propertyName)) setFund((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TRANSACTIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (HELD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FUND.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (AMOUNT.equals(propertyName)) return CashDrawer.class;
    if (TRANSACTIONDATE.equals(propertyName)) return CashDrawer.class;
    if (HELD.equals(propertyName)) return CashDrawer.class;
    if (FUND.equals(propertyName)) return CashDrawer.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CashDrawer objT = (CashDrawer)obj;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getTransactionDate(), objT.getTransactionDate()))
      return false;
    if (! SmartEquals(getHeld(), objT.getHeld()))
      return false;
    if (! SmartEquals(getFund(), objT.getFund()))
      return false;
    return true;
  }			
}
