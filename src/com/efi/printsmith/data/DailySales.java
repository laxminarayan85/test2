
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
  @NamedQuery(name = "DailySales.findall", query = "from DailySales"),
  @NamedQuery(name = "DailySales.byId", query = "select a from DailySales a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "dailysales")
public class DailySales extends ModelBase {
	/**
	 * @generated
	 */
	public static final String SALESCAT = "SalesCat";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "SubTotal";
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
	public static final String TOTALAMOUNT = "TotalAmount";

	/**
	 * @generated
	 */
	public DailySales() {
    this.created = new Date();
    this.modified = new Date();
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
	private BigDecimal totalAmount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalAmount(){
    return totalAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalAmount(BigDecimal newVal) {
    this.totalAmount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotalAmount(double newVal) {
    this.totalAmount = BigDecimal.valueOf(newVal);
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (SALESCAT.equals(propertyName)) return getSalesCat();
    if (SUBTOTAL.equals(propertyName)) return getSubTotal();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODE.equals(propertyName)) return getTaxCode();
    if (TAXAMOUNT.equals(propertyName)) return getTaxAmount();
    if (TOTALAMOUNT.equals(propertyName)) return getTotalAmount();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SALESCAT.equals(propertyName)) setSalesCat((SalesCategory)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODE.equals(propertyName)) setTaxCode((TaxCodes)newValue); else
    if (TAXAMOUNT.equals(propertyName)) setTaxAmount((BigDecimal)newValue); else
    if (TOTALAMOUNT.equals(propertyName)) setTotalAmount((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (SALESCAT.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODE.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    if (TAXAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALAMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (SALESCAT.equals(propertyName)) return DailySales.class;
    if (SUBTOTAL.equals(propertyName)) return DailySales.class;
    if (TAXTABLE.equals(propertyName)) return DailySales.class;
    if (TAXCODE.equals(propertyName)) return DailySales.class;
    if (TAXAMOUNT.equals(propertyName)) return DailySales.class;
    if (TOTALAMOUNT.equals(propertyName)) return DailySales.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DailySales objT = (DailySales)obj;
    if (! SmartEquals(getSalesCat(), objT.getSalesCat()))
      return false;
    if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCode(), objT.getTaxCode()))
      return false;
    if (! SmartEquals(getTaxAmount(), objT.getTaxAmount()))
      return false;
    if (! SmartEquals(getTotalAmount(), objT.getTotalAmount()))
      return false;
    return true;
  }			
}
