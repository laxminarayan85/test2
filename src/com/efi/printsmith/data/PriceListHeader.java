package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */
 
 
/**
 * @!generated
 */	
@NamedQueries({
	@NamedQuery(name = "PriceListHeader.findall", query = "from PriceListHeader"),
	@NamedQuery(name = "PriceListHeader.byId", query = "select a from PriceListHeader a where a.id= :id")
})


@Entity
@Table(name = "pricelistheader")
public class PriceListHeader extends ModelBase {
	/**
	 * @generated
	 */
	public static final String LASTITEMISPRICEADDITIONALQTY = "LastItemIsPriceAdditionalQty";
	/**
	 * @generated
	 */
	public static final String ISPERCENTAGE = "IsPercentage";
	/**
	 * @generated
	 */
	public static final String SEQUENCE = "Sequence";
	/**
	 * @generated
	 */
	public static final String FILLALLVALUES = "FillAllValues";
	/**
	 * @generated
	 */
	public static final String ISDOLLAR = "IsDollar";
	/**
	 * @generated
	 */
	public static final String INTERPOLATE = "Interpolate";
	/**
	 * @generated
	 */
	public static final String ISRATE = "IsRate";
	/**
	 * @generated
	 */
	public static final String ISDISCOUNT = "IsDiscount";
	/**
	 * @generated
	 */
	public static final String IGNOREPRICEADJUSTMENTS = "IgnorePriceAdjustments";
	/**
	 * @generated
	 */
	public static final String PRICEMETHOD = "PriceMethod";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
	 * @generated
	 */
	public PriceListHeader() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
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
		if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) return getLastItemIsPriceAdditionalQty();
		if (ISPERCENTAGE.equals(propertyName)) return getIsPercentage();
		if (SEQUENCE.equals(propertyName)) return getSequence();
		if (FILLALLVALUES.equals(propertyName)) return getFillAllValues();
		if (ISDOLLAR.equals(propertyName)) return getIsDollar();
		if (INTERPOLATE.equals(propertyName)) return getInterpolate();
		if (ISRATE.equals(propertyName)) return getIsRate();
		if (ISDISCOUNT.equals(propertyName)) return getIsDiscount();
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return getIgnorePriceAdjustments();
		if (PRICEMETHOD.equals(propertyName)) return getPriceMethod();
		if (NAME.equals(propertyName)) return getName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) setLastItemIsPriceAdditionalQty((Boolean)newValue); else
		if (ISPERCENTAGE.equals(propertyName)) setIsPercentage((Boolean)newValue); else
		if (SEQUENCE.equals(propertyName)) setSequence((Boolean)newValue); else
		if (FILLALLVALUES.equals(propertyName)) setFillAllValues((Boolean)newValue); else
		if (ISDOLLAR.equals(propertyName)) setIsDollar((Boolean)newValue); else
		if (INTERPOLATE.equals(propertyName)) setInterpolate((Boolean)newValue); else
		if (ISRATE.equals(propertyName)) setIsRate((Boolean)newValue); else
		if (ISDISCOUNT.equals(propertyName)) setIsDiscount((Boolean)newValue); else
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) setIgnorePriceAdjustments((Boolean)newValue); else
		if (PRICEMETHOD.equals(propertyName)) setPriceMethod((Integer)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISPERCENTAGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SEQUENCE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FILLALLVALUES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISDOLLAR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTERPOLATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISRATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISDISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRICEMETHOD.equals(propertyName)) 
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
		if (LASTITEMISPRICEADDITIONALQTY.equals(propertyName)) return PriceListHeader.class;
		if (ISPERCENTAGE.equals(propertyName)) return PriceListHeader.class;
		if (SEQUENCE.equals(propertyName)) return PriceListHeader.class;
		if (FILLALLVALUES.equals(propertyName)) return PriceListHeader.class;
		if (ISDOLLAR.equals(propertyName)) return PriceListHeader.class;
		if (INTERPOLATE.equals(propertyName)) return PriceListHeader.class;
		if (ISRATE.equals(propertyName)) return PriceListHeader.class;
		if (ISDISCOUNT.equals(propertyName)) return PriceListHeader.class;
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return PriceListHeader.class;
		if (PRICEMETHOD.equals(propertyName)) return PriceListHeader.class;
		if (NAME.equals(propertyName)) return PriceListHeader.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PriceListHeader objT = (PriceListHeader)obj;
		if (! SmartEquals(getLastItemIsPriceAdditionalQty(), objT.getLastItemIsPriceAdditionalQty()))
			return false;
		if (! SmartEquals(getIsPercentage(), objT.getIsPercentage()))
			return false;
		if (! SmartEquals(getSequence(), objT.getSequence()))
			return false;
		if (! SmartEquals(getFillAllValues(), objT.getFillAllValues()))
			return false;
		if (! SmartEquals(getIsDollar(), objT.getIsDollar()))
			return false;
		if (! SmartEquals(getInterpolate(), objT.getInterpolate()))
			return false;
		if (! SmartEquals(getIsRate(), objT.getIsRate()))
			return false;
		if (! SmartEquals(getIsDiscount(), objT.getIsDiscount()))
			return false;
		if (! SmartEquals(getIgnorePriceAdjustments(), objT.getIgnorePriceAdjustments()))
			return false;
		if (! SmartEquals(getPriceMethod(), objT.getPriceMethod()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		return true;
	}			
}