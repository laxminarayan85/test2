
package com.efi.printsmith.data;

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
  @NamedQuery(name = "TaxTable.findall", query = "from TaxTable"),
  @NamedQuery(name = "TaxTable.byId", query = "select a from TaxTable a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "taxtable")
public class TaxTable extends ModelBase {
	/**
	 * @generated
	 */
	public static final String EFFECTIVETAXRATE = "EffectiveTaxRate";
	/**
	 * @generated
	 */
	public static final String TAXELEMENTS = "TaxElements";
	/**
	 * @generated
	 */
	public static final String TAXTABLEISCURRENT = "TaxTableIsCurrent";
	/**
	 * @generated
	 */
	public static final String TAXSHIPPING = "TaxShipping";
	/**
	 * @generated
	 */
	public static final String TAXONTAX = "TaxOnTax";
	/**
	 * @generated
	 */
	public static final String ROUNDTAXUP = "RoundTaxUp";
	/**
	 * @generated
	 */
	public static final String TAXINPRICE = "TaxInPrice";
	/**
	 * @generated
	 */
	public static final String DODETAIL = "DoDetail";
	/**
	 * @generated
	 */
	public static final String DONTROUNDSHOWNTAXELEMENTS = "DontRoundShownTaxElements";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
	 * @generated
	 */
	public TaxTable() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double effectiveTaxRate;
	
	/**
	 * @generated
 	 */
	public Double getEffectiveTaxRate(){
    return effectiveTaxRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setEffectiveTaxRate(Double newVal) {
    this.effectiveTaxRate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    @IndexColumn(name="taxelementstaxtable")
    @JoinTable( name = "taxtable_taxelements")
	private java.util.List<TaxElement> taxElements;
	
	/**
	 * @generated
 	 */
	public java.util.List<TaxElement> getTaxElements(){
    return taxElements; 
  }

	/**
	 * @generated
	 */	
	public void addTaxElements(TaxElement obj) {
    if (taxElements == null) {
      taxElements = new java.util.ArrayList<TaxElement>();
    }
    taxElements.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setTaxElements(java.util.List<TaxElement> newVal) {
    this.taxElements = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxTableIsCurrent;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxTableIsCurrent(){
    return taxTableIsCurrent; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxTableIsCurrent(Boolean newVal) {
    this.taxTableIsCurrent = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxShipping;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxShipping(){
    return taxShipping; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxShipping(Boolean newVal) {
    this.taxShipping = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxOnTax;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxOnTax(){
    return taxOnTax; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxOnTax(Boolean newVal) {
    this.taxOnTax = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean roundTaxUp;
	
	/**
	 * @generated
 	 */
	public Boolean getRoundTaxUp(){
    return roundTaxUp; 
  }

	
	/**
	 * @generated
	 */	
	public void setRoundTaxUp(Boolean newVal) {
    this.roundTaxUp = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxInPrice;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxInPrice(){
    return taxInPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxInPrice(Boolean newVal) {
    this.taxInPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean doDetail;
	
	/**
	 * @generated
 	 */
	public Boolean getDoDetail(){
    return doDetail; 
  }

	
	/**
	 * @generated
	 */	
	public void setDoDetail(Boolean newVal) {
    this.doDetail = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer dontRoundShownTaxElements;
	
	/**
	 * @generated
 	 */
	public Integer getDontRoundShownTaxElements(){
    return dontRoundShownTaxElements; 
  }

	
	/**
	 * @generated
	 */	
	public void setDontRoundShownTaxElements(Integer newVal) {
    this.dontRoundShownTaxElements = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (EFFECTIVETAXRATE.equals(propertyName)) return getEffectiveTaxRate();
    if (TAXELEMENTS.equals(propertyName)) return getTaxElements();
    if (TAXTABLEISCURRENT.equals(propertyName)) return getTaxTableIsCurrent();
    if (TAXSHIPPING.equals(propertyName)) return getTaxShipping();
    if (TAXONTAX.equals(propertyName)) return getTaxOnTax();
    if (ROUNDTAXUP.equals(propertyName)) return getRoundTaxUp();
    if (TAXINPRICE.equals(propertyName)) return getTaxInPrice();
    if (DODETAIL.equals(propertyName)) return getDoDetail();
    if (DONTROUNDSHOWNTAXELEMENTS.equals(propertyName)) return getDontRoundShownTaxElements();
    if (NAME.equals(propertyName)) return getName();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (EFFECTIVETAXRATE.equals(propertyName)) setEffectiveTaxRate((Double)newValue); else
    if (TAXELEMENTS.equals(propertyName)) setTaxElements((java.util.List<TaxElement>)newValue); else
    if (TAXTABLEISCURRENT.equals(propertyName)) setTaxTableIsCurrent((Boolean)newValue); else
    if (TAXSHIPPING.equals(propertyName)) setTaxShipping((Boolean)newValue); else
    if (TAXONTAX.equals(propertyName)) setTaxOnTax((Boolean)newValue); else
    if (ROUNDTAXUP.equals(propertyName)) setRoundTaxUp((Boolean)newValue); else
    if (TAXINPRICE.equals(propertyName)) setTaxInPrice((Boolean)newValue); else
    if (DODETAIL.equals(propertyName)) setDoDetail((Boolean)newValue); else
    if (DONTROUNDSHOWNTAXELEMENTS.equals(propertyName)) setDontRoundShownTaxElements((Integer)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (EFFECTIVETAXRATE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXELEMENTS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, TaxElement.class};		
    if (TAXTABLEISCURRENT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXSHIPPING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXONTAX.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ROUNDTAXUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXINPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DODETAIL.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DONTROUNDSHOWNTAXELEMENTS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (EFFECTIVETAXRATE.equals(propertyName)) return TaxTable.class;
    if (TAXELEMENTS.equals(propertyName)) return TaxTable.class;
    if (TAXTABLEISCURRENT.equals(propertyName)) return TaxTable.class;
    if (TAXSHIPPING.equals(propertyName)) return TaxTable.class;
    if (TAXONTAX.equals(propertyName)) return TaxTable.class;
    if (ROUNDTAXUP.equals(propertyName)) return TaxTable.class;
    if (TAXINPRICE.equals(propertyName)) return TaxTable.class;
    if (DODETAIL.equals(propertyName)) return TaxTable.class;
    if (DONTROUNDSHOWNTAXELEMENTS.equals(propertyName)) return TaxTable.class;
    if (NAME.equals(propertyName)) return TaxTable.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TaxTable objT = (TaxTable)obj;
    if (! SmartEquals(getEffectiveTaxRate(), objT.getEffectiveTaxRate()))
      return false;
    if (! SmartEquals(getTaxElements(), objT.getTaxElements()))
      return false;
    if (! SmartEquals(getTaxTableIsCurrent(), objT.getTaxTableIsCurrent()))
      return false;
    if (! SmartEquals(getTaxShipping(), objT.getTaxShipping()))
      return false;
    if (! SmartEquals(getTaxOnTax(), objT.getTaxOnTax()))
      return false;
    if (! SmartEquals(getRoundTaxUp(), objT.getRoundTaxUp()))
      return false;
    if (! SmartEquals(getTaxInPrice(), objT.getTaxInPrice()))
      return false;
    if (! SmartEquals(getDoDetail(), objT.getDoDetail()))
      return false;
    if (! SmartEquals(getDontRoundShownTaxElements(), objT.getDontRoundShownTaxElements()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    return true;
  }			
}
