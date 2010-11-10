
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
	@NamedQuery(name = "Transactions.findall", query = "from Transactions"),
	@NamedQuery(name = "Transactions.byId", query = "select a from Transactions a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "transactions")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from transactions where modelbase.id=?")
@SQLDelete(sql="update transactions set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class Transactions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TAXAMOUNT = "TaxAmount";
	/**
	 * @generated
	 */
	public static final String TAXCODE = "TaxCode";
	/**
	 * @generated
	 */
	public static final String TAXEXEMPT = "TaxExempt";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String ISDELETEDRECORD = "IsDeletedRecord";
	/**
	 * @generated
	 */
	public static final String INDEX = "Index";
	/**
	 * @generated
	 */
	public static final String CHECKNUMBER = "CheckNumber";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "SubTotal";
	/**
	 * @generated
	 */
	public static final String REFNUMBER = "RefNumber";
	/**
	 * @generated
	 */
	public static final String CCT = "Cct";

	/**
	 * @generated
	 */
	public Transactions() {
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
	private Integer index;
	
	/**
	 * @generated
 	 */
	public Integer getIndex(){
		return index; 
	}

	
	/**
	 * @generated
	 */	
	public void setIndex(Integer newVal) {
		this.index = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
		if (TAXCODE.equals(propertyName)) return getTaxCode();
		if (TAXEXEMPT.equals(propertyName)) return getTaxExempt();
		if (TAXTABLE.equals(propertyName)) return getTaxTable();
		if (ISDELETEDRECORD.equals(propertyName)) return getIsDeletedRecord();
		if (INDEX.equals(propertyName)) return getIndex();
		if (CHECKNUMBER.equals(propertyName)) return getCheckNumber();
		if (SUBTOTAL.equals(propertyName)) return getSubTotal();
		if (REFNUMBER.equals(propertyName)) return getRefNumber();
		if (CCT.equals(propertyName)) return getCct();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TAXAMOUNT.equals(propertyName)) setTaxAmount((Double)newValue); else
		if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
		if (TAXEXEMPT.equals(propertyName)) setTaxExempt((Boolean)newValue); else
		if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
		if (ISDELETEDRECORD.equals(propertyName)) setIsDeletedRecord((Boolean)newValue); else
		if (INDEX.equals(propertyName)) setIndex((Integer)newValue); else
		if (CHECKNUMBER.equals(propertyName)) setCheckNumber((String)newValue); else
		if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
		if (REFNUMBER.equals(propertyName)) setRefNumber((String)newValue); else
		if (CCT.equals(propertyName)) setCct((CreditCardTransactions)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TAXAMOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TAXCODE.equals(propertyName)) 
			return new Class<?>[] {TaxCodes.class};		
		if (TAXEXEMPT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXTABLE.equals(propertyName)) 
			return new Class<?>[] {TaxTable.class};		
		if (ISDELETEDRECORD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INDEX.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CHECKNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SUBTOTAL.equals(propertyName)) 
			return new Class<?>[] {BigDecimal.class};		
		if (REFNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CCT.equals(propertyName)) 
			return new Class<?>[] {CreditCardTransactions.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TAXAMOUNT.equals(propertyName)) return Transactions.class;
		if (TAXCODE.equals(propertyName)) return Transactions.class;
		if (TAXEXEMPT.equals(propertyName)) return Transactions.class;
		if (TAXTABLE.equals(propertyName)) return Transactions.class;
		if (ISDELETEDRECORD.equals(propertyName)) return Transactions.class;
		if (INDEX.equals(propertyName)) return Transactions.class;
		if (CHECKNUMBER.equals(propertyName)) return Transactions.class;
		if (SUBTOTAL.equals(propertyName)) return Transactions.class;
		if (REFNUMBER.equals(propertyName)) return Transactions.class;
		if (CCT.equals(propertyName)) return Transactions.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Transactions objT = (Transactions)obj;
		if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
			return false;
		if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
			return false;
		if (! SmartEquals(getTaxExempt(), objT.getTaxExempt()))
			return false;
		if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
			return false;
		if (! SmartEquals(getIsDeletedRecord(), objT.getIsDeletedRecord()))
			return false;
		if (! SmartEquals(getIndex(), objT.getIndex()))
			return false;
		if (! SmartEquals(getCheckNumber(), objT.getCheckNumber()))
			return false;
		if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
			return false;
		if (! SmartEquals(getRefNumber(), objT.getRefNumber()))
			return false;
		if (! SmartEquals(getCct(), objT.getCct()))
			return false;
		return true;
	}			
}