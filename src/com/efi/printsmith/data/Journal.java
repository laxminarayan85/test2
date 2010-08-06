
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
  @NamedQuery(name = "Journal.findall", query = "from Journal"),
  @NamedQuery(name = "Journal.byId", query = "select a from Journal a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "journal")
public class Journal extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String SALESCAT = "SalesCat";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String TAXABLE = "Taxable";
	/**
	 * @generated
	 */
	public static final String BALANCE = "Balance";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "Subtotal";
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String TOTAL = "Total";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "Taxtable";
	/**
	 * @generated
	 */
	public static final String COMMENT = "Comment";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String SALESREP = "SalesRep";
	/**
	 * @generated
	 */
	public static final String AFFECTSALES = "AffectSales";
	/**
	 * @generated
	 */
	public static final String CUSTOMERSTATS = "CustomerStats";

	/**
	 * @generated
	 */
	public Journal() {
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
	private SalesCategory salesCat;
	
	/**
	 * @generated
 	 */
	public SalesCategory getSalesCat(){
    return salesCat; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesCat(SalesCategory newVal) {
    this.salesCat = newVal;
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
	private String status;
	
	/**
	 * @generated
 	 */
	public String getStatus(){
    return status; 
  }

	
	/**
	 * @generated
	 */	
	public void setStatus(String newVal) {
    this.status = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxable;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxable(){
    return taxable; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxable(Boolean newVal) {
    this.taxable = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal balance;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBalance(){
    return balance; 
  }

	
	/**
	 * @generated
	 */	
	public void setBalance(BigDecimal newVal) {
    this.balance = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBalance(double newVal) {
    this.balance = BigDecimal.valueOf(newVal);
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
	private BigDecimal total;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotal(){
    return total; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotal(BigDecimal newVal) {
    this.total = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotal(double newVal) {
    this.total = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private TaxTable taxtable;
	
	/**
	 * @generated
 	 */
	public TaxTable getTaxtable(){
    return taxtable; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxtable(TaxTable newVal) {
    this.taxtable = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String comment;
	
	/**
	 * @generated
 	 */
	public String getComment(){
    return comment; 
  }

	
	/**
	 * @generated
	 */	
	public void setComment(String newVal) {
    this.comment = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
    return description; 
  }

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
    this.description = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean salesRep;
	
	/**
	 * @generated
 	 */
	public Boolean getSalesRep(){
    return salesRep; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesRep(Boolean newVal) {
    this.salesRep = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer affectSales;
	
	/**
	 * @generated
 	 */
	public Integer getAffectSales(){
    return affectSales; 
  }

	
	/**
	 * @generated
	 */	
	public void setAffectSales(Integer newVal) {
    this.affectSales = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean customerStats;
	
	/**
	 * @generated
 	 */
	public Boolean getCustomerStats(){
    return customerStats; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerStats(Boolean newVal) {
    this.customerStats = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (SALESCAT.equals(propertyName)) return getSalesCat();
    if (NAME.equals(propertyName)) return getName();
    if (STATUS.equals(propertyName)) return getStatus();
    if (TAXABLE.equals(propertyName)) return getTaxable();
    if (BALANCE.equals(propertyName)) return getBalance();
    if (SUBTOTAL.equals(propertyName)) return getSubtotal();
    if (TAX.equals(propertyName)) return getTax();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (TAXTABLE.equals(propertyName)) return getTaxtable();
    if (COMMENT.equals(propertyName)) return getComment();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (SALESREP.equals(propertyName)) return getSalesRep();
    if (AFFECTSALES.equals(propertyName)) return getAffectSales();
    if (CUSTOMERSTATS.equals(propertyName)) return getCustomerStats();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    if (SALESCAT.equals(propertyName)) setSalesCat((SalesCategory)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
    if (BALANCE.equals(propertyName)) setBalance((BigDecimal)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubtotal((BigDecimal)newValue); else
    if (TAX.equals(propertyName)) setTax((BigDecimal)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((BigDecimal)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxtable((TaxTable)newValue); else
    if (COMMENT.equals(propertyName)) setComment((String)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (SALESREP.equals(propertyName)) setSalesRep((Boolean)newValue); else
    if (AFFECTSALES.equals(propertyName)) setAffectSales((Integer)newValue); else
    if (CUSTOMERSTATS.equals(propertyName)) setCustomerStats((Boolean)newValue); else
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
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (SALESCAT.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TAXABLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (BALANCE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (COMMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESREP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AFFECTSALES.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CUSTOMERSTATS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ACCOUNT.equals(propertyName)) return Journal.class;
    if (INVOICE.equals(propertyName)) return Journal.class;
    if (SALESCAT.equals(propertyName)) return Journal.class;
    if (NAME.equals(propertyName)) return Journal.class;
    if (STATUS.equals(propertyName)) return Journal.class;
    if (TAXABLE.equals(propertyName)) return Journal.class;
    if (BALANCE.equals(propertyName)) return Journal.class;
    if (SUBTOTAL.equals(propertyName)) return Journal.class;
    if (TAX.equals(propertyName)) return Journal.class;
    if (TOTAL.equals(propertyName)) return Journal.class;
    if (TAXTABLE.equals(propertyName)) return Journal.class;
    if (COMMENT.equals(propertyName)) return Journal.class;
    if (DESCRIPTION.equals(propertyName)) return Journal.class;
    if (SALESREP.equals(propertyName)) return Journal.class;
    if (AFFECTSALES.equals(propertyName)) return Journal.class;
    if (CUSTOMERSTATS.equals(propertyName)) return Journal.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Journal objT = (Journal)obj;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getSalesCat(), objT.getSalesCat()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getTaxable(), objT.getTaxable()))
      return false;
    if (! SmartEquals(getBalance(), objT.getBalance()))
      return false;
    if (! SmartEquals(getSubtotal(), objT.getSubtotal()))
      return false;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getTaxtable(), objT.getTaxtable()))
      return false;
    if (! SmartEquals(getComment(), objT.getComment()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getSalesRep(), objT.getSalesRep()))
      return false;
    if (! SmartEquals(getAffectSales(), objT.getAffectSales()))
      return false;
    if (! SmartEquals(getCustomerStats(), objT.getCustomerStats()))
      return false;
    return true;
  }			
}
