
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
  @NamedQuery(name = "AccountHistoryData.findall", query = "from AccountHistoryData"),
  @NamedQuery(name = "AccountHistoryData.byId", query = "select a from AccountHistoryData a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "accounthistorydata")
public class AccountHistoryData extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String JOURNAL = "Journal";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String PAYMENTS = "Payments";
	/**
	 * @generated
	 */
	public static final String FINANCECHARGE = "FinanceCharge";
	/**
	 * @generated
	 */
	public static final String DEPOSITTAKEN = "DepositTaken";
	/**
	 * @generated
	 */
	public static final String DEPOSITREFUND = "DepositRefund";

	/**
	 * @generated
	 */
	public AccountHistoryData() {
    this.created = new Date();
    this.modified = new Date();
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
    @ManyToOne()
	private Journal journal;
	
	/**
	 * @generated
 	 */
	public Journal getJournal(){
    return journal; 
  }

	
	/**
	 * @generated
	 */	
	public void setJournal(Journal newVal) {
    this.journal = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
    @ManyToOne()
	private CashRegister payments;
	
	/**
	 * @generated
 	 */
	public CashRegister getPayments(){
    return payments; 
  }

	
	/**
	 * @generated
	 */	
	public void setPayments(CashRegister newVal) {
    this.payments = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer financeCharge;
	
	/**
	 * @generated
 	 */
	public Integer getFinanceCharge(){
    return financeCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinanceCharge(Integer newVal) {
    this.financeCharge = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer depositTaken;
	
	/**
	 * @generated
 	 */
	public Integer getDepositTaken(){
    return depositTaken; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepositTaken(Integer newVal) {
    this.depositTaken = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer depositRefund;
	
	/**
	 * @generated
 	 */
	public Integer getDepositRefund(){
    return depositRefund; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepositRefund(Integer newVal) {
    this.depositRefund = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (JOURNAL.equals(propertyName)) return getJournal();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (PAYMENTS.equals(propertyName)) return getPayments();
    if (FINANCECHARGE.equals(propertyName)) return getFinanceCharge();
    if (DEPOSITTAKEN.equals(propertyName)) return getDepositTaken();
    if (DEPOSITREFUND.equals(propertyName)) return getDepositRefund();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (JOURNAL.equals(propertyName)) setJournal((Journal)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (PAYMENTS.equals(propertyName)) setPayments((CashRegister)newValue); else
    if (FINANCECHARGE.equals(propertyName)) setFinanceCharge((Integer)newValue); else
    if (DEPOSITTAKEN.equals(propertyName)) setDepositTaken((Integer)newValue); else
    if (DEPOSITREFUND.equals(propertyName)) setDepositRefund((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (JOURNAL.equals(propertyName)) 
      return new Class<?>[] {Journal.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (PAYMENTS.equals(propertyName)) 
      return new Class<?>[] {CashRegister.class};		
    if (FINANCECHARGE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DEPOSITTAKEN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DEPOSITREFUND.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return AccountHistoryData.class;
    if (ACCOUNT.equals(propertyName)) return AccountHistoryData.class;
    if (JOURNAL.equals(propertyName)) return AccountHistoryData.class;
    if (INVOICE.equals(propertyName)) return AccountHistoryData.class;
    if (PAYMENTS.equals(propertyName)) return AccountHistoryData.class;
    if (FINANCECHARGE.equals(propertyName)) return AccountHistoryData.class;
    if (DEPOSITTAKEN.equals(propertyName)) return AccountHistoryData.class;
    if (DEPOSITREFUND.equals(propertyName)) return AccountHistoryData.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    AccountHistoryData objT = (AccountHistoryData)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getJournal(), objT.getJournal()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getPayments(), objT.getPayments()))
      return false;
    if (! SmartEquals(getFinanceCharge(), objT.getFinanceCharge()))
      return false;
    if (! SmartEquals(getDepositTaken(), objT.getDepositTaken()))
      return false;
    if (! SmartEquals(getDepositRefund(), objT.getDepositRefund()))
      return false;
    return true;
  }			
}
