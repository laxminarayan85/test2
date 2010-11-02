
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
  @NamedQuery(name = "TapeSaleRecord.findall", query = "from TapeSaleRecord"),
  @NamedQuery(name = "TapeSaleRecord.byId", query = "select a from TapeSaleRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapesalerecord")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapesalerecord where modelbase.id=?")
@SQLDelete(sql="update tapesalerecord set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeSaleRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ISDELETEDRECORD = "IsDeletedRecord";
	/**
	 * @generated
	 */
	public static final String ISPICKUP = "IsPickup";
	/**
	 * @generated
	 */
	public static final String OPPRICE = "OpPrice";
	/**
	 * @generated
	 */
	public static final String ORRATE = "OrRate";
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
	public static final String TAXAMOUNT = "TaxAmount";
	/**
	 * @generated
	 */
	public static final String TAXEXEMPT = "TaxExempt";
	/**
	 * @generated
	 */
	public static final String CASHREGISTERDEPT = "CashRegisterDept";
	/**
	 * @generated
	 */
	public static final String UNITPRICE = "UnitPrice";
	/**
	 * @generated
	 */
	public static final String TOTAL = "Total";
	/**
	 * @generated
	 */
	public static final String AMOUNTPAID = "AmountPaid";
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String DEPARTMENT = "Department";
	/**
	 * @generated
	 */
	public static final String PAYMODE = "Paymode";
	/**
	 * @generated
	 */
	public static final String SALESCATEGORY = "SalesCategory";
	/**
	 * @generated
	 */
	public static final String REFNUMBER = "RefNumber";
	/**
	 * @generated
	 */
	public static final String CHECKNUMBER = "CheckNumber";
	/**
	 * @generated
	 */
	public static final String CCT = "Cct";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";

	/**
	 * @generated
	 */
	public TapeSaleRecord() {
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
	private Boolean isDeletedRecord;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDeletedRecord(){
    return isDeletedRecord; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsDeletedRecord(Boolean newVal) {
    this.isDeletedRecord = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isPickup;
	
	/**
	 * @generated
 	 */
	public Boolean getIsPickup(){
    return isPickup; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsPickup(Boolean newVal) {
    this.isPickup = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean opPrice;
	
	/**
	 * @generated
 	 */
	public Boolean getOpPrice(){
    return opPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOpPrice(Boolean newVal) {
    this.opPrice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean orRate;
	
	/**
	 * @generated
 	 */
	public Boolean getOrRate(){
    return orRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrRate(Boolean newVal) {
    this.orRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
    @Where(clause="isdeleted <> 'TRUE'")
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
	private Double taxAmount;
	
	/**
	 * @generated
 	 */
	public Double getTaxAmount(){
    return taxAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxAmount(Double newVal) {
    this.taxAmount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxExempt;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxExempt(){
    return taxExempt; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxExempt(Boolean newVal) {
    this.taxExempt = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
 	@Basic
	private Double unitPrice;
	
	/**
	 * @generated
 	 */
	public Double getUnitPrice(){
    return unitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitPrice(Double newVal) {
    this.unitPrice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double total;
	
	/**
	 * @generated
 	 */
	public Double getTotal(){
    return total; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotal(Double newVal) {
    this.total = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double amountPaid;
	
	/**
	 * @generated
 	 */
	public Double getAmountPaid(){
    return amountPaid; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmountPaid(Double newVal) {
    this.amountPaid = newVal;
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
	private String department;
	
	/**
	 * @generated
 	 */
	public String getDepartment(){
    return department; 
  }

	
	/**
	 * @generated
	 */	
	public void setDepartment(String newVal) {
    this.department = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String paymode;
	
	/**
	 * @generated
 	 */
	public String getPaymode(){
    return paymode; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaymode(String newVal) {
    this.paymode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private SalesCategory salesCategory;
	
	/**
	 * @generated
 	 */
	public SalesCategory getSalesCategory(){
    return salesCategory; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesCategory(SalesCategory newVal) {
    this.salesCategory = newVal;
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
    @Where(clause="isdeleted <> 'TRUE'")
	private CreditCardTransactions cct;
	
	/**
	 * @generated
 	 */
	public CreditCardTransactions getCct(){
    return cct; 
  }

	
	/**
	 * @generated
	 */	
	public void setCct(CreditCardTransactions newVal) {
    this.cct = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ISDELETEDRECORD.equals(propertyName)) return getIsDeletedRecord();
    if (ISPICKUP.equals(propertyName)) return getIsPickup();
    if (OPPRICE.equals(propertyName)) return getOpPrice();
    if (ORRATE.equals(propertyName)) return getOrRate();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
    if (TAXEXEMPT.equals(propertyName)) return getTaxExempt();
    if (CASHREGISTERDEPT.equals(propertyName)) return getCashRegisterDept();
    if (UNITPRICE.equals(propertyName)) return getUnitPrice();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (AMOUNTPAID.equals(propertyName)) return getAmountPaid();
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (DEPARTMENT.equals(propertyName)) return getDepartment();
    if (PAYMODE.equals(propertyName)) return getPaymode();
    if (SALESCATEGORY.equals(propertyName)) return getSalesCategory();
    if (REFNUMBER.equals(propertyName)) return getRefNumber();
    if (CHECKNUMBER.equals(propertyName)) return getCheckNumber();
    if (CCT.equals(propertyName)) return getCct();
    if (INVOICE.equals(propertyName)) return getInvoice();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ISDELETEDRECORD.equals(propertyName)) setIsDeletedRecord((Boolean)newValue); else
    if (ISPICKUP.equals(propertyName)) setIsPickup((Boolean)newValue); else
    if (OPPRICE.equals(propertyName)) setOpPrice((Boolean)newValue); else
    if (ORRATE.equals(propertyName)) setOrRate((Boolean)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxAmount((Double)newValue); else
    if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
    if (CASHREGISTERDEPT.equals(propertyName)) setCashRegisterDept((PreferencesCashRegister)newValue); else
    if (UNITPRICE.equals(propertyName)) setUnitPrice((Double)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((Double)newValue); else
    if (AMOUNTPAID.equals(propertyName)) setAmountPaid((Double)newValue); else
    if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else
    if (DEPARTMENT.equals(propertyName)) setDepartment((String)newValue); else
    if (PAYMODE.equals(propertyName)) setPaymode((String)newValue); else
    if (SALESCATEGORY.equals(propertyName)) setSalesCategory((SalesCategory)newValue); else
    if (REFNUMBER.equals(propertyName)) setRefNumber((String)newValue); else
    if (CHECKNUMBER.equals(propertyName)) setCheckNumber((String)newValue); else
    if (CCT.equals(propertyName)) setCct((CreditCardTransactions)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ISDELETEDRECORD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISPICKUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OPPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXEXEMPT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CASHREGISTERDEPT.equals(propertyName)) 
      return new Class<?>[] {PreferencesCashRegister.class};		
    if (UNITPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (AMOUNTPAID.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEPARTMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PAYMODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESCATEGORY.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (REFNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHECKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CCT.equals(propertyName)) 
      return new Class<?>[] {CreditCardTransactions.class};		
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ISDELETEDRECORD.equals(propertyName)) return TapeSaleRecord.class;
    if (ISPICKUP.equals(propertyName)) return TapeSaleRecord.class;
    if (OPPRICE.equals(propertyName)) return TapeSaleRecord.class;
    if (ORRATE.equals(propertyName)) return TapeSaleRecord.class;
    if (TAXTABLE.equals(propertyName)) return TapeSaleRecord.class;
    if (TAXCODE.equals(propertyName)) return TapeSaleRecord.class;
    if (TAXAMOUNT.equals(propertyName)) return TapeSaleRecord.class;
    if (TAXEXEMPT.equals(propertyName)) return TapeSaleRecord.class;
    if (CASHREGISTERDEPT.equals(propertyName)) return TapeSaleRecord.class;
    if (UNITPRICE.equals(propertyName)) return TapeSaleRecord.class;
    if (TOTAL.equals(propertyName)) return TapeSaleRecord.class;
    if (AMOUNTPAID.equals(propertyName)) return TapeSaleRecord.class;
    if (QUANTITY.equals(propertyName)) return TapeSaleRecord.class;
    if (DEPARTMENT.equals(propertyName)) return TapeSaleRecord.class;
    if (PAYMODE.equals(propertyName)) return TapeSaleRecord.class;
    if (SALESCATEGORY.equals(propertyName)) return TapeSaleRecord.class;
    if (REFNUMBER.equals(propertyName)) return TapeSaleRecord.class;
    if (CHECKNUMBER.equals(propertyName)) return TapeSaleRecord.class;
    if (CCT.equals(propertyName)) return TapeSaleRecord.class;
    if (INVOICE.equals(propertyName)) return TapeSaleRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapeSaleRecord objT = (TapeSaleRecord)obj;
    if (! SmartEquals(getIsDeletedRecord(), objT.getIsDeletedRecord()))
      return false;
    if (! SmartEquals(getIsPickup(), objT.getIsPickup()))
      return false;
    if (! SmartEquals(getOpPrice(), objT.getOpPrice()))
      return false;
    if (! SmartEquals(getOrRate(), objT.getOrRate()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
      return false;
    if (! SmartEquals(getTaxExempt(), objT.getTaxExempt()))
      return false;
    if (! SmartEquals(getCashRegisterDept(), objT.getCashRegisterDept()))
      return false;
    if (! SmartEquals(getUnitPrice(), objT.getUnitPrice()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getAmountPaid(), objT.getAmountPaid()))
      return false;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getDepartment(), objT.getDepartment()))
      return false;
    if (! SmartEquals(getPaymode(), objT.getPaymode()))
      return false;
    if (! SmartEquals(getSalesCategory(), objT.getSalesCategory()))
      return false;
    if (! SmartEquals(getRefNumber(), objT.getRefNumber()))
      return false;
    if (! SmartEquals(getCheckNumber(), objT.getCheckNumber()))
      return false;
    if (! SmartEquals(getCct(), objT.getCct()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    return true;
  }			
}
