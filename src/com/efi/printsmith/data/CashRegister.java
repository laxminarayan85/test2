
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
  @NamedQuery(name = "CashRegister.findall", query = "from CashRegister"),
  @NamedQuery(name = "CashRegister.byId", query = "select a from CashRegister a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "cashregister")
public class CashRegister extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CUSTOMERACCOUNT = "CustomerAccount";
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
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String UNITPRICE = "Unitprice";
	/**
	 * @generated
	 */
	public static final String TOTALPRICE = "Totalprice";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String INVOICEFORMAT = "InvoiceFormat";
	/**
	 * @generated
	 */
	public static final String PAYMENTMETHOD = "PaymentMethod";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "Subtotal";
	/**
	 * @generated
	 */
	public static final String TAXAMOUNT = "Taxamount";
	/**
	 * @generated
	 */
	public static final String TENDERED = "Tendered";
	/**
	 * @generated
	 */
	public static final String CHANGE = "Change";
	/**
	 * @generated
	 */
	public static final String CREDITCARD = "CreditCard";
	/**
	 * @generated
	 */
	public static final String REFNUMBER = "RefNumber";
	/**
	 * @generated
	 */
	public static final String PAYMENTAMOUNT = "PaymentAmount";
	/**
	 * @generated
	 */
	public static final String CHECKNUMBER = "CheckNumber";

	/**
   * @generated
   */
  public static final String CASHREGISTERDEPT = "CashRegisterDept";

	/**
	 * @generated
	 */
	public CashRegister() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Account customerAccount;
	
	/**
	 * @generated
 	 */
	public Account getCustomerAccount(){
    return customerAccount; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerAccount(Account newVal) {
    this.customerAccount = newVal;
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
	private BigDecimal unitprice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getUnitprice(){
    return unitprice; 
  }

	
	/**
   * @generated
   */	
  public void setUnitprice(BigDecimal newVal) {
    this.unitprice = newVal;
  }


	/**
   * @generated
   */	
  public void setUnitprice(double newVal) {
    this.unitprice = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal totalprice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalprice(){
    return totalprice; 
  }

	
	/**
   * @generated
   */	
  public void setTotalprice(BigDecimal newVal) {
    this.totalprice = newVal;
  }


	/**
   * @generated
   */	
  public void setTotalprice(double newVal) {
    this.totalprice = BigDecimal.valueOf(newVal);
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
	private String invoiceFormat;
	
	/**
	 * @generated
 	 */
	public String getInvoiceFormat(){
    return invoiceFormat; 
  }

	
	/**
	 * @generated
	 */	
	public void setInvoiceFormat(String newVal) {
    this.invoiceFormat = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String paymentMethod;
	
	/**
	 * @generated
 	 */
	public String getPaymentMethod(){
    return paymentMethod; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaymentMethod(String newVal) {
    this.paymentMethod = newVal;
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
	private BigDecimal taxamount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTaxamount(){
    return taxamount; 
  }

	
	/**
   * @generated
   */	
  public void setTaxamount(BigDecimal newVal) {
    this.taxamount = newVal;
  }


	/**
   * @generated
   */	
  public void setTaxamount(double newVal) {
    this.taxamount = BigDecimal.valueOf(newVal);
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
    @ManyToOne()
	private PreferencesCreditCard creditCard;
	
	/**
	 * @generated
 	 */
	public PreferencesCreditCard getCreditCard(){
    return creditCard; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCard(PreferencesCreditCard newVal) {
    this.creditCard = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String refNumber;
	
	/**
	 * @generated
 	 */
	public String getRefNumber(){
    return refNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setRefNumber(String newVal) {
    this.refNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal paymentAmount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPaymentAmount(){
    return paymentAmount; 
  }

	
	/**
   * @generated
   */	
  public void setPaymentAmount(BigDecimal newVal) {
    this.paymentAmount = newVal;
  }


	/**
   * @generated
   */	
  public void setPaymentAmount(double newVal) {
    this.paymentAmount = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private String checkNumber;
	
	/**
	 * @generated
 	 */
	public String getCheckNumber(){
    return checkNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setCheckNumber(String newVal) {
    this.checkNumber = newVal;
  }
	
	/**
   * @generated
   */	
    @ManyToOne()
  private PreferencesCashRegister cashRegisterDept;

	/**
   * @generated
 	 */
  public PreferencesCashRegister getCashRegisterDept(){
    return cashRegisterDept; 
  }


	/**
   * @generated
   */	
  public void setCashRegisterDept(PreferencesCashRegister newVal) {
    this.cashRegisterDept = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CUSTOMERACCOUNT.equals(propertyName)) return getCustomerAccount();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (UNITPRICE.equals(propertyName)) return getUnitprice();
    if (TOTALPRICE.equals(propertyName)) return getTotalprice();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (INVOICEFORMAT.equals(propertyName)) return getInvoiceFormat();
    if (PAYMENTMETHOD.equals(propertyName)) return getPaymentMethod();
    if (SUBTOTAL.equals(propertyName)) return getSubtotal();
    if (TAXAMOUNT.equals(propertyName)) return getTaxamount();
    if (TENDERED.equals(propertyName)) return getTendered();
    if (CHANGE.equals(propertyName)) return getChange();
    if (CREDITCARD.equals(propertyName)) return getCreditCard();
    if (REFNUMBER.equals(propertyName)) return getRefNumber();
    if (PAYMENTAMOUNT.equals(propertyName)) return getPaymentAmount();
    if (CHECKNUMBER.equals(propertyName)) return getCheckNumber();
    if (CASHREGISTERDEPT.equals(propertyName)) return getCashRegisterDept();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CUSTOMERACCOUNT.equals(propertyName)) setCustomerAccount((Account)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else
    if (UNITPRICE.equals(propertyName)) setUnitprice((BigDecimal)newValue); else
    if (TOTALPRICE.equals(propertyName)) setTotalprice((BigDecimal)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (INVOICEFORMAT.equals(propertyName)) setInvoiceFormat((String)newValue); else
    if (PAYMENTMETHOD.equals(propertyName)) setPaymentMethod((String)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubtotal((BigDecimal)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxamount((BigDecimal)newValue); else
    if (TENDERED.equals(propertyName)) setTendered((Double)newValue); else
    if (CHANGE.equals(propertyName)) setChange((Double)newValue); else
    if (CREDITCARD.equals(propertyName)) setCreditCard((PreferencesCreditCard)newValue); else
    if (REFNUMBER.equals(propertyName)) setRefNumber((String)newValue); else
    if (PAYMENTAMOUNT.equals(propertyName)) setPaymentAmount((BigDecimal)newValue); else
    if (CHECKNUMBER.equals(propertyName)) setCheckNumber((String)newValue); else
    if (CASHREGISTERDEPT.equals(propertyName)) setCashRegisterDept((PreferencesCashRegister)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CUSTOMERACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (UNITPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (INVOICEFORMAT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PAYMENTMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TENDERED.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CHANGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CREDITCARD.equals(propertyName)) 
      return new Class<?>[] {PreferencesCreditCard.class};		
    if (REFNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PAYMENTAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CHECKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CASHREGISTERDEPT.equals(propertyName)) 
      return new Class<?>[] {PreferencesCashRegister.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CUSTOMERACCOUNT.equals(propertyName)) return CashRegister.class;
    if (TAXTABLE.equals(propertyName)) return CashRegister.class;
    if (TAXCODE.equals(propertyName)) return CashRegister.class;
    if (QUANTITY.equals(propertyName)) return CashRegister.class;
    if (UNITPRICE.equals(propertyName)) return CashRegister.class;
    if (TOTALPRICE.equals(propertyName)) return CashRegister.class;
    if (DESCRIPTION.equals(propertyName)) return CashRegister.class;
    if (INVOICEFORMAT.equals(propertyName)) return CashRegister.class;
    if (PAYMENTMETHOD.equals(propertyName)) return CashRegister.class;
    if (SUBTOTAL.equals(propertyName)) return CashRegister.class;
    if (TAXAMOUNT.equals(propertyName)) return CashRegister.class;
    if (TENDERED.equals(propertyName)) return CashRegister.class;
    if (CHANGE.equals(propertyName)) return CashRegister.class;
    if (CREDITCARD.equals(propertyName)) return CashRegister.class;
    if (REFNUMBER.equals(propertyName)) return CashRegister.class;
    if (PAYMENTAMOUNT.equals(propertyName)) return CashRegister.class;
    if (CHECKNUMBER.equals(propertyName)) return CashRegister.class;
    if (CASHREGISTERDEPT.equals(propertyName)) return CashRegister.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CashRegister objT = (CashRegister)obj;
    if (! SmartEquals(getCustomerAccount(), objT.getCustomerAccount()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getUnitprice(), objT.getUnitprice()))
      return false;
    if (! SmartEquals(getTotalprice(), objT.getTotalprice()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getInvoiceFormat(), objT.getInvoiceFormat()))
      return false;
    if (! SmartEquals(getPaymentMethod(), objT.getPaymentMethod()))
      return false;
    if (! SmartEquals(getSubtotal(), objT.getSubtotal()))
      return false;
    if (! SmartEquals(getTaxamount(), objT.getTaxamount()))
      return false;
    if (! SmartEquals(getTendered(), objT.getTendered()))
      return false;
    if (! SmartEquals(getChange(), objT.getChange()))
      return false;
    if (! SmartEquals(getCreditCard(), objT.getCreditCard()))
      return false;
    if (! SmartEquals(getRefNumber(), objT.getRefNumber()))
      return false;
    if (! SmartEquals(getPaymentAmount(), objT.getPaymentAmount()))
      return false;
    if (! SmartEquals(getCheckNumber(), objT.getCheckNumber()))
      return false;
    if (! SmartEquals(getCashRegisterDept(), objT.getCashRegisterDept()))
      return false;
    return true;
  }			
}
