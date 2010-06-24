
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "PreferencesCashRegister.findall", query = "from PreferencesCashRegister"),
  @NamedQuery(name = "PreferencesCashRegister.byId", query = "select a from PreferencesCashRegister a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencescashregister")
public class PreferencesCashRegister extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String CATEGORY = "Category";
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String TAXCODES = "TaxCodes";

	/**
	 * @generated
	 */
	public PreferencesCashRegister() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean tax;
	
	/**
	 * @generated
 	 */
	public Boolean getTax(){
    return tax; 
  }

	
	/**
	 * @generated
	 */	
	public void setTax(Boolean newVal) {
    this.tax = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String title;
	
	/**
	 * @generated
 	 */
	public String getTitle(){
    return title; 
  }

	
	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
    this.title = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private SalesCategory category;
	
	/**
	 * @generated
 	 */
	public SalesCategory getCategory(){
    return category; 
  }

	
	/**
	 * @generated
	 */	
	public void setCategory(SalesCategory newVal) {
    this.category = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal rate;
	
	/**
	 * @generated
 	 */
	public BigDecimal getRate(){
    return rate; 
  }

	
	/**
   * @generated
   */	
  public void setRate(BigDecimal newVal) {
    this.rate = newVal;
  }


	/**
   * @generated
   */	
  public void setRate(double newVal) {
    this.rate = BigDecimal.valueOf(newVal);
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
	private TaxCodes taxCodes;
	
	/**
	 * @generated
 	 */
	public TaxCodes getTaxCodes(){
    return taxCodes; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxCodes(TaxCodes newVal) {
    this.taxCodes = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TAX.equals(propertyName)) return getTax();
    if (TITLE.equals(propertyName)) return getTitle();
    if (CATEGORY.equals(propertyName)) return getCategory();
    if (RATE.equals(propertyName)) return getRate();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (TAXCODES.equals(propertyName)) return getTaxCodes();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TAX.equals(propertyName)) setTax((Boolean)newValue); else
    if (TITLE.equals(propertyName)) setTitle((String)newValue); else
    if (CATEGORY.equals(propertyName)) setCategory((SalesCategory)newValue); else
    if (RATE.equals(propertyName)) setRate((BigDecimal)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (TAXCODES.equals(propertyName)) setTaxCodes((TaxCodes)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TITLE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CATEGORY.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (RATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (TAXCODES.equals(propertyName)) 
      return new Class<?>[] {TaxCodes.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TAX.equals(propertyName)) return PreferencesCashRegister.class;
    if (TITLE.equals(propertyName)) return PreferencesCashRegister.class;
    if (CATEGORY.equals(propertyName)) return PreferencesCashRegister.class;
    if (RATE.equals(propertyName)) return PreferencesCashRegister.class;
    if (TAXTABLE.equals(propertyName)) return PreferencesCashRegister.class;
    if (TAXCODES.equals(propertyName)) return PreferencesCashRegister.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesCashRegister objT = (PreferencesCashRegister)obj;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    if (! SmartEquals(getTitle(), objT.getTitle()))
      return false;
    if (! SmartEquals(getCategory(), objT.getCategory()))
      return false;
    if (! SmartEquals(getRate(), objT.getRate()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getTaxCodes(), objT.getTaxCodes()))
      return false;
    return true;
  }			
}
