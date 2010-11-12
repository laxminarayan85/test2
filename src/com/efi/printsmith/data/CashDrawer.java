
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
  @NamedQuery(name = "CashDrawer.findall", query = "from CashDrawer"),
  @NamedQuery(name = "CashDrawer.byId", query = "select a from CashDrawer a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cashdrawer")
@SQLDelete(sql="update cashdrawer set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
  public static final String CHECKCOUNT = "CheckCount";
	/**
   * @generated
   */
  public static final String CARDCOUNT = "CardCount";
	/**
   * @generated
   */
  public static final String CHECKTOTAL = "CheckTotal";
	/**
   * @generated
   */
  public static final String CARDTOTAL = "CardTotal";
	/**
   * @generated
   */
  public static final String CASHTOTAL = "CashTotal";
	/**
   * @generated
   */
  public static final String ARBALANCE = "ArBalance";
	/**
   * @generated
   */
  public static final String CHANGEFUND = "ChangeFund";
	/**
   * @generated
   */
  public static final String PAIDOUTS = "PaidOuts";
	/**
   * @generated
   */
  public static final String LASTCLOSEOUTDATE = "LastCloseOutDate";
	/**
   * @generated
   */
  public static final String LASTSTARTUPDATE = "LastStartupDate";
	/**
   * @generated
   */
  public static final String PREVARBALANCE = "PrevArBalance";

	/**
	 * @generated
	 */
	public CashDrawer() {
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
 	@Basic
  private Integer checkCount;

	/**
   * @generated
 	 */
  public Integer getCheckCount(){
    return checkCount; 
  }


	/**
   * @generated
   */	
  public void setCheckCount(Integer newVal) {
    this.checkCount = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Integer cardCount;

	/**
   * @generated
 	 */
  public Integer getCardCount(){
    return cardCount; 
  }


	/**
   * @generated
   */	
  public void setCardCount(Integer newVal) {
    this.cardCount = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal checkTotal;

	/**
   * @generated
 	 */
  public BigDecimal getCheckTotal(){
    return checkTotal; 
  }


	/**
   * @generated
   */	
  public void setCheckTotal(BigDecimal newVal) {
    this.checkTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setCheckTotal(double newVal) {
    this.checkTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal cardTotal;

	/**
   * @generated
 	 */
  public BigDecimal getCardTotal(){
    return cardTotal; 
  }


	/**
   * @generated
   */	
  public void setCardTotal(BigDecimal newVal) {
    this.cardTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setCardTotal(double newVal) {
    this.cardTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal cashTotal;

	/**
   * @generated
 	 */
  public BigDecimal getCashTotal(){
    return cashTotal; 
  }


	/**
   * @generated
   */	
  public void setCashTotal(BigDecimal newVal) {
    this.cashTotal = newVal;
  }


	/**
   * @generated
   */	
  public void setCashTotal(double newVal) {
    this.cashTotal = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal arBalance;

	/**
   * @generated
 	 */
  public BigDecimal getArBalance(){
    return arBalance; 
  }


	/**
   * @generated
   */	
  public void setArBalance(BigDecimal newVal) {
    this.arBalance = newVal;
  }


	/**
   * @generated
   */	
  public void setArBalance(double newVal) {
    this.arBalance = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal changeFund;

	/**
   * @generated
 	 */
  public BigDecimal getChangeFund(){
    return changeFund; 
  }


	/**
   * @generated
   */	
  public void setChangeFund(BigDecimal newVal) {
    this.changeFund = newVal;
  }


	/**
   * @generated
   */	
  public void setChangeFund(double newVal) {
    this.changeFund = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal paidOuts;

	/**
   * @generated
 	 */
  public BigDecimal getPaidOuts(){
    return paidOuts; 
  }


	/**
   * @generated
   */	
  public void setPaidOuts(BigDecimal newVal) {
    this.paidOuts = newVal;
  }


	/**
   * @generated
   */	
  public void setPaidOuts(double newVal) {
    this.paidOuts = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private Date lastCloseOutDate;

	/**
   * @generated
 	 */
  public Date getLastCloseOutDate(){
    return lastCloseOutDate; 
  }


	/**
   * @generated
   */	
  public void setLastCloseOutDate(Date newVal) {
    this.lastCloseOutDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date lastStartupDate;

	/**
   * @generated
 	 */
  public Date getLastStartupDate(){
    return lastStartupDate; 
  }


	/**
   * @generated
   */	
  public void setLastStartupDate(Date newVal) {
    this.lastStartupDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal prevArBalance;

	/**
   * @generated
 	 */
  public BigDecimal getPrevArBalance(){
    return prevArBalance; 
  }


	/**
   * @generated
   */	
  public void setPrevArBalance(BigDecimal newVal) {
    this.prevArBalance = newVal;
  }


	/**
   * @generated
   */	
  public void setPrevArBalance(double newVal) {
    this.prevArBalance = BigDecimal.valueOf(newVal);
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
    if (CHECKCOUNT.equals(propertyName)) return getCheckCount();
    if (CARDCOUNT.equals(propertyName)) return getCardCount();
    if (CHECKTOTAL.equals(propertyName)) return getCheckTotal();
    if (CARDTOTAL.equals(propertyName)) return getCardTotal();
    if (CASHTOTAL.equals(propertyName)) return getCashTotal();
    if (ARBALANCE.equals(propertyName)) return getArBalance();
    if (CHANGEFUND.equals(propertyName)) return getChangeFund();
    if (PAIDOUTS.equals(propertyName)) return getPaidOuts();
    if (LASTCLOSEOUTDATE.equals(propertyName)) return getLastCloseOutDate();
    if (LASTSTARTUPDATE.equals(propertyName)) return getLastStartupDate();
    if (PREVARBALANCE.equals(propertyName)) return getPrevArBalance();
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
    if (CHECKCOUNT.equals(propertyName)) setCheckCount((Integer)newValue); else
    if (CARDCOUNT.equals(propertyName)) setCardCount((Integer)newValue); else
    if (CHECKTOTAL.equals(propertyName)) setCheckTotal((BigDecimal)newValue); else
    if (CARDTOTAL.equals(propertyName)) setCardTotal((BigDecimal)newValue); else
    if (CASHTOTAL.equals(propertyName)) setCashTotal((BigDecimal)newValue); else
    if (ARBALANCE.equals(propertyName)) setArBalance((BigDecimal)newValue); else
    if (CHANGEFUND.equals(propertyName)) setChangeFund((BigDecimal)newValue); else
    if (PAIDOUTS.equals(propertyName)) setPaidOuts((BigDecimal)newValue); else
    if (LASTCLOSEOUTDATE.equals(propertyName)) setLastCloseOutDate((Date)newValue); else
    if (LASTSTARTUPDATE.equals(propertyName)) setLastStartupDate((Date)newValue); else
    if (PREVARBALANCE.equals(propertyName)) setPrevArBalance((BigDecimal)newValue); else
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
    if (CHECKCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CARDCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CHECKTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CARDTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CASHTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ARBALANCE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CHANGEFUND.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PAIDOUTS.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LASTCLOSEOUTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LASTSTARTUPDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PREVARBALANCE.equals(propertyName)) 
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
    if (CHECKCOUNT.equals(propertyName)) return CashDrawer.class;
    if (CARDCOUNT.equals(propertyName)) return CashDrawer.class;
    if (CHECKTOTAL.equals(propertyName)) return CashDrawer.class;
    if (CARDTOTAL.equals(propertyName)) return CashDrawer.class;
    if (CASHTOTAL.equals(propertyName)) return CashDrawer.class;
    if (ARBALANCE.equals(propertyName)) return CashDrawer.class;
    if (CHANGEFUND.equals(propertyName)) return CashDrawer.class;
    if (PAIDOUTS.equals(propertyName)) return CashDrawer.class;
    if (LASTCLOSEOUTDATE.equals(propertyName)) return CashDrawer.class;
    if (LASTSTARTUPDATE.equals(propertyName)) return CashDrawer.class;
    if (PREVARBALANCE.equals(propertyName)) return CashDrawer.class;
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
    if (! SmartEquals(getCheckCount(), objT.getCheckCount()))
      return false;
    if (! SmartEquals(getCardCount(), objT.getCardCount()))
      return false;
    if (! SmartEquals(getCheckTotal(), objT.getCheckTotal()))
      return false;
    if (! SmartEquals(getCardTotal(), objT.getCardTotal()))
      return false;
    if (! SmartEquals(getCashTotal(), objT.getCashTotal()))
      return false;
    if (! SmartEquals(getArBalance(), objT.getArBalance()))
      return false;
    if (! SmartEquals(getChangeFund(), objT.getChangeFund()))
      return false;
    if (! SmartEquals(getPaidOuts(), objT.getPaidOuts()))
      return false;
    if (! SmartEquals(getLastCloseOutDate(), objT.getLastCloseOutDate()))
      return false;
    if (! SmartEquals(getLastStartupDate(), objT.getLastStartupDate()))
      return false;
    if (! SmartEquals(getPrevArBalance(), objT.getPrevArBalance()))
      return false;
    return true;
  }			
}
