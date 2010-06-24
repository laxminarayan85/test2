
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
  @NamedQuery(name = "PriceListBase.findall", query = "from PriceListBase"),
  @NamedQuery(name = "PriceListBase.byId", query = "select a from PriceListBase a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "pricelistbase")
public class PriceListBase extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String IGNOREPRICEADJUSTMENTS = "IgnorePriceAdjustments";
	/**
	 * @generated
	 */
	public static final String ISDISCOUNT = "IsDiscount";
	/**
	 * @generated
	 */
	public static final String ISRATE = "IsRate";
	/**
	 * @generated
	 */
	public static final String INTERPOLATE = "Interpolate";
	/**
	 * @generated
	 */
	public static final String ISDOLLAR = "IsDollar";
	/**
	 * @generated
	 */
	public static final String FILLALLVALUES = "FillAllValues";
	/**
	 * @generated
	 */
	public static final String SEQUENCE = "Sequence";
	/**
	 * @generated
	 */
	public static final String ISPERCENTAGE = "IsPercentage";
	/**
	 * @generated
	 */
	public static final String LASTITEMISPRICEADDITIONALQTY = "LastItemIsPriceAdditionalQty";
	/**
	 * @generated
	 */
	public static final String ELEMENTS = "Elements";
	/**
	 * @generated
	 */
	public static final String PRICEMETHOD = "PriceMethod";

	/**
	 * @generated
	 */
	public PriceListBase() {
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
 	@Basic
	private Boolean ignorePriceAdjustments;
	
	/**
	 * @generated
 	 */
	public Boolean getIgnorePriceAdjustments(){
    return ignorePriceAdjustments; 
  }

	
	/**
	 * @generated
	 */	
	public void setIgnorePriceAdjustments(Boolean newVal) {
    this.ignorePriceAdjustments = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isDiscount;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDiscount(){
    return isDiscount; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsDiscount(Boolean newVal) {
    this.isDiscount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isRate;
	
	/**
	 * @generated
 	 */
	public Boolean getIsRate(){
    return isRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsRate(Boolean newVal) {
    this.isRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean interpolate;
	
	/**
	 * @generated
 	 */
	public Boolean getInterpolate(){
    return interpolate; 
  }

	
	/**
	 * @generated
	 */	
	public void setInterpolate(Boolean newVal) {
    this.interpolate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isDollar;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDollar(){
    return isDollar; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsDollar(Boolean newVal) {
    this.isDollar = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean fillAllValues;
	
	/**
	 * @generated
 	 */
	public Boolean getFillAllValues(){
    return fillAllValues; 
  }

	
	/**
	 * @generated
	 */	
	public void setFillAllValues(Boolean newVal) {
    this.fillAllValues = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean sequence;
	
	/**
	 * @generated
 	 */
	public Boolean getSequence(){
    return sequence; 
  }

	
	/**
	 * @generated
	 */	
	public void setSequence(Boolean newVal) {
    this.sequence = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isPercentage;
	
	/**
	 * @generated
 	 */
	public Boolean getIsPercentage(){
    return isPercentage; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsPercentage(Boolean newVal) {
    this.isPercentage = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean lastItemIsPriceAdditionalQty;
	
	/**
	 * @generated
 	 */
	public Boolean getLastItemIsPriceAdditionalQty(){
    return lastItemIsPriceAdditionalQty; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastItemIsPriceAdditionalQty(Boolean newVal) {
    this.lastItemIsPriceAdditionalQty = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "pricelistbase_elements")
	private java.util.List<PriceListElement> elements;
	
	/**
	 * @generated
 	 */
	public java.util.List<PriceListElement> getElements(){
    return elements; 
  }

	/**
	 * @generated
	 */	
	public void addElements(PriceListElement obj) {
    if (elements == null) {
      elements = new java.util.ArrayList<PriceListElement>();
    }
    elements.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setElements(java.util.List<PriceListElement> newVal) {
    this.elements = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer priceMethod;
	
	/**
	 * @generated
 	 */
	public Integer getPriceMethod(){
    return priceMethod; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceMethod(Integer newVal) {
    this.priceMethod = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return getIgnorePriceAdjustments();
    if (ISDISCOUNT.equals(propertyName)) return getIsDiscount();
    if (ISRATE.equals(propertyName)) return getIsRate();
    if (INTERPOLATE.equals(propertyName)) return getInterpolate();
    if (ISDOLLAR.equals(propertyName)) return getIsDollar();
    if (FILLALLVALUES.equals(propertyName)) return getFillAllValues();
    if (SEQUENCE.equals(propertyName)) return getSequence();
    if (ISPERCENTAGE.equals(propertyName)) return getIsPercentage();
    if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) return getLastItemIsPriceAdditionalQty();
    if (ELEMENTS.equals(propertyName)) return getElements();
    if (PRICEMETHOD.equals(propertyName)) return getPriceMethod();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) setIgnorePriceAdjustments((Boolean)newValue); else
    if (ISDISCOUNT.equals(propertyName)) setIsDiscount((Boolean)newValue); else
    if (ISRATE.equals(propertyName)) setIsRate((Boolean)newValue); else
    if (INTERPOLATE.equals(propertyName)) setInterpolate((Boolean)newValue); else
    if (ISDOLLAR.equals(propertyName)) setIsDollar((Boolean)newValue); else
    if (FILLALLVALUES.equals(propertyName)) setFillAllValues((Boolean)newValue); else
    if (SEQUENCE.equals(propertyName)) setSequence((Boolean)newValue); else
    if (ISPERCENTAGE.equals(propertyName)) setIsPercentage((Boolean)newValue); else
    if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) setLastItemIsPriceAdditionalQty((Boolean)newValue); else
    if (ELEMENTS.equals(propertyName)) setElements((java.util.List<PriceListElement>)newValue); else
    if (PRICEMETHOD.equals(propertyName)) setPriceMethod((Integer)newValue); else
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
    if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISDISCOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INTERPOLATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISDOLLAR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FILLALLVALUES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SEQUENCE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISPERCENTAGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ELEMENTS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, PriceListElement.class};		
    if (PRICEMETHOD.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return PriceListBase.class;
    if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return PriceListBase.class;
    if (ISDISCOUNT.equals(propertyName)) return PriceListBase.class;
    if (ISRATE.equals(propertyName)) return PriceListBase.class;
    if (INTERPOLATE.equals(propertyName)) return PriceListBase.class;
    if (ISDOLLAR.equals(propertyName)) return PriceListBase.class;
    if (FILLALLVALUES.equals(propertyName)) return PriceListBase.class;
    if (SEQUENCE.equals(propertyName)) return PriceListBase.class;
    if (ISPERCENTAGE.equals(propertyName)) return PriceListBase.class;
    if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) return PriceListBase.class;
    if (ELEMENTS.equals(propertyName)) return PriceListBase.class;
    if (PRICEMETHOD.equals(propertyName)) return PriceListBase.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PriceListBase objT = (PriceListBase)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getIgnorePriceAdjustments(), objT.getIgnorePriceAdjustments()))
      return false;
    if (! SmartEquals(getIsDiscount(), objT.getIsDiscount()))
      return false;
    if (! SmartEquals(getIsRate(), objT.getIsRate()))
      return false;
    if (! SmartEquals(getInterpolate(), objT.getInterpolate()))
      return false;
    if (! SmartEquals(getIsDollar(), objT.getIsDollar()))
      return false;
    if (! SmartEquals(getFillAllValues(), objT.getFillAllValues()))
      return false;
    if (! SmartEquals(getSequence(), objT.getSequence()))
      return false;
    if (! SmartEquals(getIsPercentage(), objT.getIsPercentage()))
      return false;
    if (! SmartEquals(getLastItemIsPriceAdditionalQty(), objT.getLastItemIsPriceAdditionalQty()))
      return false;
    if (! SmartEquals(getElements(), objT.getElements()))
      return false;
    if (! SmartEquals(getPriceMethod(), objT.getPriceMethod()))
      return false;
    return true;
  }			
}
