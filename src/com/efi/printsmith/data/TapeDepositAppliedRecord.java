
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
  @NamedQuery(name = "TapeDepositAppliedRecord.findall", query = "from TapeDepositAppliedRecord"),
  @NamedQuery(name = "TapeDepositAppliedRecord.byId", query = "select a from TapeDepositAppliedRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapedepositappliedrecord")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapedepositappliedrecord where modelbase.id=?")
@SQLDelete(sql="update tapedepositappliedrecord set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeDepositAppliedRecord extends Transaction {
	/**
	 * @generated
	 */
	public static final String TOTALDEPOSITS = "TotalDeposits";
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";

	/**
	 * @generated
	 */
	public TapeDepositAppliedRecord() {
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
	private Double totalDeposits;
	
	/**
	 * @generated
 	 */
	public Double getTotalDeposits(){
    return totalDeposits; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalDeposits(Double newVal) {
    this.totalDeposits = newVal;
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
    if (TOTALDEPOSITS.equals(propertyName)) return getTotalDeposits();
    if (INVOICE.equals(propertyName)) return getInvoice();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TOTALDEPOSITS.equals(propertyName)) setTotalDeposits((Double)newValue); else
    if (INVOICE.equals(propertyName)) setInvoice((Invoice)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TOTALDEPOSITS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
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
    if (TOTALDEPOSITS.equals(propertyName)) return TapeDepositAppliedRecord.class;
    if (INVOICE.equals(propertyName)) return TapeDepositAppliedRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapeDepositAppliedRecord objT = (TapeDepositAppliedRecord)obj;
    if (! SmartEquals(getTotalDeposits(), objT.getTotalDeposits()))
      return false;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    return true;
  }			
}
