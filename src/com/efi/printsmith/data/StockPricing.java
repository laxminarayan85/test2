package com.efi.printsmith;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
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
	@NamedQuery(name = "StockPricing.findall", query = "from StockPricing"),
	@NamedQuery(name = "StockPricing.byId", query = "select a from StockPricing a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockPricing")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockpricing")
public class StockPricing extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NORMALRUNSIZE = "NormalRunSize";
	/**
	 * @generated
	 */
	public static final String CUTSPER100 = "CutsPer100";
	/**
	 * @generated
	 */
	public static final String MINCUTCHARGE = "MinCutCharge";
	/**
	 * @generated
	 */
	public static final String DEFAULTPRESS = "DefaultPress";
	/**
	 * @generated
	 */
	public static final String LISTPRICINGSCHEDULE = "ListPricingSchedule";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETS = "BlankSheets";
	/**
	 * @generated
	 */
	public static final String AUTOCALCULATEBLANK = "AutoCalculateBlank";

	/**
	 * @generated
	 */
	public StockPricing() {
	}

 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="normalrunsize", nullable=true, unique=false)
	private Integer normalRunSize;
	/**
	 * @generated
 	 */
	public Integer getNormalRunSize(){
		return normalRunSize; 
	}

	/**
	 * @generated
	 */	
	public Integer setNormalRunSize(Integer newVal) {
		return this.normalRunSize = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="cutsper100", nullable=true, unique=false)
	private Float cutsPer100;
	/**
	 * @generated
 	 */
	public Float getCutsPer100(){
		return cutsPer100; 
	}

	/**
	 * @generated
	 */	
	public Float setCutsPer100(Float newVal) {
		return this.cutsPer100 = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="mincutcharge", nullable=true, unique=false)
	private Integer minCutCharge;
	/**
	 * @generated
 	 */
	public Integer getMinCutCharge(){
		return minCutCharge; 
	}

	/**
	 * @generated
	 */	
	public Integer setMinCutCharge(Integer newVal) {
		return this.minCutCharge = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="defaultpress", nullable=true, unique=false)
	private Integer defaultPress;
	/**
	 * @generated
 	 */
	public Integer getDefaultPress(){
		return defaultPress; 
	}

	/**
	 * @generated
	 */	
	public Integer setDefaultPress(Integer newVal) {
		return this.defaultPress = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="listpricingschedule", nullable=true, unique=false)
	private Integer listPricingSchedule;
	/**
	 * @generated
 	 */
	public Integer getListPricingSchedule(){
		return listPricingSchedule; 
	}

	/**
	 * @generated
	 */	
	public Integer setListPricingSchedule(Integer newVal) {
		return this.listPricingSchedule = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockBlankSheets blankSheets;
	/**
	 * @generated
 	 */
	public StockBlankSheets getBlankSheets(){
		return blankSheets; 
	}

	/**
	 * @generated
	 */	
	public StockBlankSheets setBlankSheets(StockBlankSheets newVal) {
		return this.blankSheets = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="autocalculateblank", nullable=true, unique=false)
	private Boolean autoCalculateBlank;
	/**
	 * @generated
 	 */
	public Boolean getAutoCalculateBlank(){
		return autoCalculateBlank; 
	}

	/**
	 * @generated
	 */	
	public Boolean setAutoCalculateBlank(Boolean newVal) {
		return this.autoCalculateBlank = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NORMALRUNSIZE.equals(propertyName)) return getNormalRunSize();
		if (CUTSPER100.equals(propertyName)) return getCutsPer100();
		if (MINCUTCHARGE.equals(propertyName)) return getMinCutCharge();
		if (DEFAULTPRESS.equals(propertyName)) return getDefaultPress();
		if (LISTPRICINGSCHEDULE.equals(propertyName)) return getListPricingSchedule();
		if (BLANKSHEETS.equals(propertyName)) return getBlankSheets();
		if (AUTOCALCULATEBLANK.equals(propertyName)) return getAutoCalculateBlank();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NORMALRUNSIZE.equals(propertyName)) setNormalRunSize((Integer)newValue); else
		if (CUTSPER100.equals(propertyName)) setCutsPer100((Float)newValue); else
		if (MINCUTCHARGE.equals(propertyName)) setMinCutCharge((Integer)newValue); else
		if (DEFAULTPRESS.equals(propertyName)) setDefaultPress((Integer)newValue); else
		if (LISTPRICINGSCHEDULE.equals(propertyName)) setListPricingSchedule((Integer)newValue); else
		if (BLANKSHEETS.equals(propertyName)) setBlankSheets((StockBlankSheets)newValue); else
		if (AUTOCALCULATEBLANK.equals(propertyName)) setAutoCalculateBlank((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (NORMALRUNSIZE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CUTSPER100.equals(propertyName)) 
			return new Class<?>[] {Float.class};		
		if (MINCUTCHARGE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DEFAULTPRESS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (LISTPRICINGSCHEDULE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BLANKSHEETS.equals(propertyName)) 
			return new Class<?>[] {StockBlankSheets.class};		
		if (AUTOCALCULATEBLANK.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NORMALRUNSIZE.equals(propertyName)) return StockPricing.class;
		if (CUTSPER100.equals(propertyName)) return StockPricing.class;
		if (MINCUTCHARGE.equals(propertyName)) return StockPricing.class;
		if (DEFAULTPRESS.equals(propertyName)) return StockPricing.class;
		if (LISTPRICINGSCHEDULE.equals(propertyName)) return StockPricing.class;
		if (BLANKSHEETS.equals(propertyName)) return StockPricing.class;
		if (AUTOCALCULATEBLANK.equals(propertyName)) return StockPricing.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockPricing objT = (StockPricing)obj;
		if (! SmartEquals(getNormalRunSize(), objT.getNormalRunSize()))
			return false;
		if (! SmartEquals(getCutsPer100(), objT.getCutsPer100()))
			return false;
		if (! SmartEquals(getMinCutCharge(), objT.getMinCutCharge()))
			return false;
		if (! SmartEquals(getDefaultPress(), objT.getDefaultPress()))
			return false;
		if (! SmartEquals(getListPricingSchedule(), objT.getListPricingSchedule()))
			return false;
		if (! SmartEquals(getBlankSheets(), objT.getBlankSheets()))
			return false;
		if (! SmartEquals(getAutoCalculateBlank(), objT.getAutoCalculateBlank()))
			return false;
		return true;
	}			
}