
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
  @NamedQuery(name = "UnpurchasedMerchandise.findall", query = "from UnpurchasedMerchandise"),
  @NamedQuery(name = "UnpurchasedMerchandise.byId", query = "select a from UnpurchasedMerchandise a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "unpurchasedmerchandise")
@SQLDelete(sql="update unpurchasedmerchandise set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class UnpurchasedMerchandise extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String TRANSACTIONDATE = "TransactionDate";
	/**
   * @generated
   */
  public static final String SALERECORD = "SaleRecord";
	/**
	 * @generated
	 */
	public UnpurchasedMerchandise() {
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
    @Where(clause="isdeleted <> 'TRUE'")
  private TapeSaleRecord saleRecord;

	/**
   * @generated
 	 */
  public TapeSaleRecord getSaleRecord(){
    return saleRecord; 
  }


	/**
   * @generated
   */	
  public void setSaleRecord(TapeSaleRecord newVal) {
    this.saleRecord = newVal;
  }



	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (SALERECORD.equals(propertyName)) return getSaleRecord();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (SALERECORD.equals(propertyName)) setSaleRecord((TapeSaleRecord)newValue); else
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
    if (TRANSACTIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (SALERECORD.equals(propertyName)) 
      return new Class<?>[] {TapeSaleRecord.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ACCOUNT.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (TRANSACTIONDATE.equals(propertyName)) return UnpurchasedMerchandise.class;
    if (SALERECORD.equals(propertyName)) return UnpurchasedMerchandise.class;
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
    if (! SmartEquals(getTransactionDate(), objT.getTransactionDate()))
      return false;
    if (! SmartEquals(getSaleRecord(), objT.getSaleRecord()))
      return false;
    return true;
  }			
}
