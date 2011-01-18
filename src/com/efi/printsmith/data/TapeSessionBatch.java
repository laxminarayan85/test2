
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
  @NamedQuery(name = "TapeSessionBatch.findall", query = "from TapeSessionBatch"),
  @NamedQuery(name = "TapeSessionBatch.byId", query = "select a from TapeSessionBatch a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapesessionbatch")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapesessionbatch where modelbase.id=?")
@SQLDelete(sql="update tapesessionbatch set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeSessionBatch extends ModelBase {
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
	public static final String SESSIONID = "SessionID";

	/**
   * @generated
   */
  public static final String ROUNDAMOUNT = "RoundAmount";
	/**
   * @generated
   */
  public static final String USER = "User";
	/**
   * @generated
   */
  public static final String WORKSTATION = "Workstation";
	/**
   * @generated
   */
  public static final String ACCOUNT = "Account";
	/**
   * @generated
   */
  public static final String ISVOIDED = "IsVoided";
	/**
	 * @generated
	 */
	public TapeSessionBatch() {
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
    @JoinTable( name = "tapesessionbatch_transactions")
  private java.util.List<Transaction> transactions;
	/**
   * @generated
 	 */
  public java.util.List<Transaction> getTransactions(){
    return transactions; 
  }

	/**
   * @generated
   */	
  public void addTransactions(Transaction obj) {
    if (transactions == null) {
      transactions = new java.util.ArrayList<Transaction>();
    }
    transactions.add(obj);
  }

	/**
   * @generated
   */	
  public void setTransactions(java.util.List<Transaction> newVal) {
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
 	@Basic
	private Long sessionID;
	
	/**
	 * @generated
 	 */
	public Long getSessionID(){
    return sessionID; 
  }

	
	/**
	 * @generated
	 */	
	public void setSessionID(Long newVal) {
    this.sessionID = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private BigDecimal roundAmount;

	/**
   * @generated
 	 */
  public BigDecimal getRoundAmount(){
    return roundAmount; 
  }

	/**
   * @generated
   */	
  public void setRoundAmount(BigDecimal newVal) {
    this.roundAmount = newVal;
  }

	/**
   * @generated
   */	
  public void setRoundAmount(double newVal) {
    this.roundAmount = BigDecimal.valueOf(newVal);
  }

	/**
   * @generated
   */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private Users user;

	/**
   * @generated
 	 */
  public Users getUser(){
    return user; 
  }

	/**
   * @generated
   */	
  public void setUser(Users newVal) {
    this.user = newVal;
  }

	/**
   * @generated
   */	
 	@Basic
  private String workstation;

	/**
   * @generated
 	 */
  public String getWorkstation(){
    return workstation; 
  }

	/**
   * @generated
   */	
  public void setWorkstation(String newVal) {
    this.workstation = newVal;
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
 	@Basic
  private Boolean isVoided;
	/**
   * @generated
 	 */
  public Boolean getIsVoided(){
    return isVoided; 
  }

	/**
   * @generated
   */	
  public void setIsVoided(Boolean newVal) {
    this.isVoided = newVal;
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
    if (SESSIONID.equals(propertyName)) return getSessionID();
    if (ROUNDAMOUNT.equals(propertyName)) return getRoundAmount();
    if (USER.equals(propertyName)) return getUser();
    if (WORKSTATION.equals(propertyName)) return getWorkstation();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (ISVOIDED.equals(propertyName)) return getIsVoided();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONS.equals(propertyName)) setTransactions((java.util.List<Transaction>)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (ACCUMSUBTOTAL.equals(propertyName)) setAccumSubTotal((BigDecimal)newValue); else
    if (ACCUMTOTAL.equals(propertyName)) setAccumTotal((BigDecimal)newValue); else
    if (ACCUMTAXTOTAL.equals(propertyName)) setAccumTaxTotal((BigDecimal)newValue); else
    if (ACCUMTENDERED.equals(propertyName)) setAccumTendered((BigDecimal)newValue); else
    if (ACCUMCHANGE.equals(propertyName)) setAccumChange((BigDecimal)newValue); else
    if (SESSIONID.equals(propertyName)) setSessionID((Long)newValue); else
    if (ROUNDAMOUNT.equals(propertyName)) setRoundAmount((BigDecimal)newValue); else
    if (USER.equals(propertyName)) setUser((Users)newValue); else
    if (WORKSTATION.equals(propertyName)) setWorkstation((String)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (ISVOIDED.equals(propertyName)) setIsVoided((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, Transaction.class};		
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
    if (SESSIONID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ROUNDAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (USER.equals(propertyName)) 
      return new Class<?>[] {Users.class};		
    if (WORKSTATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (ISVOIDED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONS.equals(propertyName)) return TapeSessionBatch.class;
    if (NAME.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCUMSUBTOTAL.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCUMTOTAL.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCUMTAXTOTAL.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCUMTENDERED.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCUMCHANGE.equals(propertyName)) return TapeSessionBatch.class;
    if (SESSIONID.equals(propertyName)) return TapeSessionBatch.class;
    if (ROUNDAMOUNT.equals(propertyName)) return TapeSessionBatch.class;
    if (USER.equals(propertyName)) return TapeSessionBatch.class;
    if (WORKSTATION.equals(propertyName)) return TapeSessionBatch.class;
    if (ACCOUNT.equals(propertyName)) return TapeSessionBatch.class;
    if (ISVOIDED.equals(propertyName)) return TapeSessionBatch.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapeSessionBatch objT = (TapeSessionBatch)obj;
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
    if (! SmartEquals(getSessionID(), objT.getSessionID()))
      return false;
    if (! SmartEquals(getRoundAmount(), objT.getRoundAmount()))
      return false;
    if (! SmartEquals(getUser(), objT.getUser()))
      return false;
    if (! SmartEquals(getWorkstation(), objT.getWorkstation()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getIsVoided(), objT.getIsVoided()))
      return false;
    return true;
  }			
}
