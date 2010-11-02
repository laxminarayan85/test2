
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONS.equals(propertyName)) return getTransactions();
    if (NAME.equals(propertyName)) return getName();
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
    return true;
  }			
}
