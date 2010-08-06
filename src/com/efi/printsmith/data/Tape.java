
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
  @NamedQuery(name = "Tape.findall", query = "from Tape"),
  @NamedQuery(name = "Tape.byId", query = "select a from Tape a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tape")
public class Tape extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TRANSACTIONDATE = "TransactionDate";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
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
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String CHECKNUM = "CheckNum";
	/**
	 * @generated
	 */
	public static final String REF = "Ref";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "SubTotal";
	/**
	 * @generated
	 */
	public static final String TOTAL = "Total";
	/**
	 * @generated
	 */
	public static final String POS = "Pos";
	/**
	 * @generated
	 */
	public static final String AR = "Ar";
	/**
	 * @generated
	 */
	public static final String PAYMENTAMOUNT = "PaymentAmount";

	/**
	 * @generated
	 */
	public Tape() {
    this.created = new Date();
    this.modified = new Date();
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
	private BigDecimal taxAmount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTaxAmount(){
    return taxAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxAmount(BigDecimal newVal) {
    this.taxAmount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTaxAmount(double newVal) {
    this.taxAmount = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String type;
	
	/**
	 * @generated
 	 */
	public String getType(){
    return type; 
  }

	
	/**
	 * @generated
	 */	
	public void setType(String newVal) {
    this.type = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String checkNum;
	
	/**
	 * @generated
 	 */
	public String getCheckNum(){
    return checkNum; 
  }

	
	/**
	 * @generated
	 */	
	public void setCheckNum(String newVal) {
    this.checkNum = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String ref;
	
	/**
	 * @generated
 	 */
	public String getRef(){
    return ref; 
  }

	
	/**
	 * @generated
	 */	
	public void setRef(String newVal) {
    this.ref = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal subTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSubTotal(){
    return subTotal; 
  }

	
	/**
	 * @generated
	 */	
	public void setSubTotal(BigDecimal newVal) {
    this.subTotal = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSubTotal(double newVal) {
    this.subTotal = BigDecimal.valueOf(newVal);
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
 	@Basic
	private Boolean pos;
	
	/**
	 * @generated
 	 */
	public Boolean getPos(){
    return pos; 
  }

	
	/**
	 * @generated
	 */	
	public void setPos(Boolean newVal) {
    this.pos = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean ar;
	
	/**
	 * @generated
 	 */
	public Boolean getAr(){
    return ar; 
  }

	
	/**
	 * @generated
	 */	
	public void setAr(Boolean newVal) {
    this.ar = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) return getTransactionDate();
    if (STATUS.equals(propertyName)) return getStatus();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
    if (TYPE.equals(propertyName)) return getType();
    if (CHECKNUM.equals(propertyName)) return getCheckNum();
    if (REF.equals(propertyName)) return getRef();
    if (SUBTOTAL.equals(propertyName)) return getSubTotal();
    if (TOTAL.equals(propertyName)) return getTotal();
    if (POS.equals(propertyName)) return getPos();
    if (AR.equals(propertyName)) return getAr();
    if (PAYMENTAMOUNT.equals(propertyName)) return getPaymentAmount();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TRANSACTIONDATE.equals(propertyName)) setTransactionDate((Date)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxAmount((BigDecimal)newValue); else
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (CHECKNUM.equals(propertyName)) setCheckNum((String)newValue); else
    if (REF.equals(propertyName)) setRef((String)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
    if (TOTAL.equals(propertyName)) setTotal((BigDecimal)newValue); else
    if (POS.equals(propertyName)) setPos((Boolean)newValue); else
    if (AR.equals(propertyName)) setAr((Boolean)newValue); else
    if (PAYMENTAMOUNT.equals(propertyName)) setPaymentAmount((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHECKNUM.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REF.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (POS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PAYMENTAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TRANSACTIONDATE.equals(propertyName)) return Tape.class;
    if (STATUS.equals(propertyName)) return Tape.class;
    if (TAXTABLE.equals(propertyName)) return Tape.class;
    if (TAXCODE.equals(propertyName)) return Tape.class;
    if (TAXAMOUNT.equals(propertyName)) return Tape.class;
    if (TYPE.equals(propertyName)) return Tape.class;
    if (CHECKNUM.equals(propertyName)) return Tape.class;
    if (REF.equals(propertyName)) return Tape.class;
    if (SUBTOTAL.equals(propertyName)) return Tape.class;
    if (TOTAL.equals(propertyName)) return Tape.class;
    if (POS.equals(propertyName)) return Tape.class;
    if (AR.equals(propertyName)) return Tape.class;
    if (PAYMENTAMOUNT.equals(propertyName)) return Tape.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Tape objT = (Tape)obj;
    if (! SmartEquals(getTransactionDate(), objT.getTransactionDate()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
      return false;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getCheckNum(), objT.getCheckNum()))
      return false;
    if (! SmartEquals(getRef(), objT.getRef()))
      return false;
    if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
      return false;
    if (! SmartEquals(getTotal(), objT.getTotal()))
      return false;
    if (! SmartEquals(getPos(), objT.getPos()))
      return false;
    if (! SmartEquals(getAr(), objT.getAr()))
      return false;
    if (! SmartEquals(getPaymentAmount(), objT.getPaymentAmount()))
      return false;
    return true;
  }			
}
