
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
  @NamedQuery(name = "CashRegisterBatch.findall", query = "from CashRegisterBatch"),
  @NamedQuery(name = "CashRegisterBatch.byId", query = "select a from CashRegisterBatch a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cashregisterbatch")
@SQLDelete(sql="update cashregisterbatch set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class CashRegisterBatch extends ModelBase {
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
  public static final String ACCUMSUBTOTAL = "AccumSubTotal";
	/**
   * @generated
   */
  public static final String ACCUMTOTAL = "AccumTotal";
	/**
   * @generated
   */
  public static final String ACCUMTAXTOTAL = "AccumTaxTotal";
	/**
   * @generated
   */
  public static final String ACCUMTENDERED = "AccumTendered";
	/**
   * @generated
   */
  public static final String ACCUMCHANGE = "AccumChange";
	/**
	 * @generated
	 */
	public CashRegisterBatch() {
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
    @OneToMany(  cascade = {CascadeType.ALL})
    @Where(clause="isdeleted <> 'TRUE'")
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
  private BigDecimal accumSubTotal;
	/**
   * @generated
 	 */
  public BigDecimal getAccumSubTotal(){
    return accumSubTotal; 
  }


	/**
   * @generated
   */	
  public void setAccumSubTotal(BigDecimal newVal) {
    this.accumSubTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setAccumSubTotal(double newVal) {
    this.accumSubTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal accumTotal;
	/**
   * @generated
 	 */
  public BigDecimal getAccumTotal(){
    return accumTotal; 
  }


	/**
   * @generated
   */	
  public void setAccumTotal(BigDecimal newVal) {
    this.accumTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setAccumTotal(double newVal) {
    this.accumTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal accumTaxTotal;
	/**
   * @generated
 	 */
  public BigDecimal getAccumTaxTotal(){
    return accumTaxTotal; 
  }


	/**
   * @generated
   */	
  public void setAccumTaxTotal(BigDecimal newVal) {
    this.accumTaxTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setAccumTaxTotal(double newVal) {
    this.accumTaxTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal accumTendered;
	/**
   * @generated
 	 */
  public BigDecimal getAccumTendered(){
    return accumTendered; 
  }


	/**
   * @generated
   */	
  public void setAccumTendered(BigDecimal newVal) {
    this.accumTendered = newVal;
  }


	/**
   * @generated
   */	
  public void setAccumTendered(double newVal) {
    this.accumTendered = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal accumChange;
	/**
   * @generated
 	 */
  public BigDecimal getAccumChange(){
    return accumChange; 
  }


	/**
   * @generated
   */	
  public void setAccumChange(BigDecimal newVal) {
    this.accumChange = newVal;
  }


	/**
   * @generated
   */	
  public void setAccumChange(double newVal) {
    this.accumChange = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONS.equals(propertyName)) return getTransactions();
    if (NAME.equals(propertyName)) return getName();
    if (ACCUMSUBTOTAL.equals(propertyName)) return getAccumSubTotal();
    if (ACCUMTOTAL.equals(propertyName)) return getAccumTotal();
    if (ACCUMTAXTOTAL.equals(propertyName)) return getAccumTaxTotal();
    if (ACCUMTENDERED.equals(propertyName)) return getAccumTendered();
    if (ACCUMCHANGE.equals(propertyName)) return getAccumChange();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONS.equals(propertyName)) setTransactions((java.util.List<CashRegister>)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (ACCUMSUBTOTAL.equals(propertyName)) setAccumSubTotal((BigDecimal)newValue); else
    if (ACCUMTOTAL.equals(propertyName)) setAccumTotal((BigDecimal)newValue); else
    if (ACCUMTAXTOTAL.equals(propertyName)) setAccumTaxTotal((BigDecimal)newValue); else
    if (ACCUMTENDERED.equals(propertyName)) setAccumTendered((BigDecimal)newValue); else
    if (ACCUMCHANGE.equals(propertyName)) setAccumChange((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, CashRegister.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCUMSUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACCUMTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACCUMTAXTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACCUMTENDERED.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACCUMCHANGE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONS.equals(propertyName)) return CashRegisterBatch.class;
    if (NAME.equals(propertyName)) return CashRegisterBatch.class;
    if (ACCUMSUBTOTAL.equals(propertyName)) return CashRegisterBatch.class;
    if (ACCUMTOTAL.equals(propertyName)) return CashRegisterBatch.class;
    if (ACCUMTAXTOTAL.equals(propertyName)) return CashRegisterBatch.class;
    if (ACCUMTENDERED.equals(propertyName)) return CashRegisterBatch.class;
    if (ACCUMCHANGE.equals(propertyName)) return CashRegisterBatch.class;
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
    if (! SmartEquals(getTransactions(), objT.getTransactions()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getAccumSubTotal(), objT.getAccumSubTotal()))
      return false;
    if (! SmartEquals(getAccumTotal(), objT.getAccumTotal()))
      return false;
    if (! SmartEquals(getAccumTaxTotal(), objT.getAccumTaxTotal()))
      return false;
    if (! SmartEquals(getAccumTendered(), objT.getAccumTendered()))
      return false;
    if (! SmartEquals(getAccumChange(), objT.getAccumChange()))
      return false;
    return true;
  }			
}
