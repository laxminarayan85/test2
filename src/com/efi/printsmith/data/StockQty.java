package com.efi.printsmith.data;

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
	@NamedQuery(name = "StockQty.findall", query = "from StockQty"),
	@NamedQuery(name = "StockQty.byId", query = "select a from StockQty a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockQty")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockqty")
public class StockQty extends ModelBase {
	/**
	 * @generated
	 */
	public static final String COSTUNITS = "CostUnits";
	/**
	 * @generated
	 */
	public static final String SHEETSPERSET = "SheetsPerSet";
	/**
	 * @generated
	 */
	public static final String ISCOSTINSETS = "IsCostInSets";
	/**
	 * @generated
	 */
	public static final String QTYBREAK = "QtyBreak";
	/**
	 * @generated
	 */
	public static final String PRICEEXPIRES = "PriceExpires";

	/**
	 * @generated
	 */
	public StockQty() {
	}

 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="costunits", nullable=true, unique=false)
	private Integer costUnits;
	/**
	 * @generated
 	 */
	public Integer getCostUnits(){
		return costUnits; 
	}

	/**
	 * @generated
	 */	
	public Integer setCostUnits(Integer newVal) {
		return this.costUnits = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="sheetsperset", nullable=true, unique=false)
	private Integer sheetsPerSet;
	/**
	 * @generated
 	 */
	public Integer getSheetsPerSet(){
		return sheetsPerSet; 
	}

	/**
	 * @generated
	 */	
	public Integer setSheetsPerSet(Integer newVal) {
		return this.sheetsPerSet = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="iscostinsets", nullable=true, unique=false)
	private Integer isCostInSets;
	/**
	 * @generated
 	 */
	public Integer getIsCostInSets(){
		return isCostInSets; 
	}

	/**
	 * @generated
	 */	
	public Integer setIsCostInSets(Integer newVal) {
		return this.isCostInSets = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockQtyBreak qtyBreak;
	/**
	 * @generated
 	 */
	public StockQtyBreak getQtyBreak(){
		return qtyBreak; 
	}

	/**
	 * @generated
	 */	
	public StockQtyBreak setQtyBreak(StockQtyBreak newVal) {
		return this.qtyBreak = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="priceexpires", nullable=true, unique=false)
	private Integer priceExpires;
	/**
	 * @generated
 	 */
	public Integer getPriceExpires(){
		return priceExpires; 
	}

	/**
	 * @generated
	 */	
	public Integer setPriceExpires(Integer newVal) {
		return this.priceExpires = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (COSTUNITS.equals(propertyName)) return getCostUnits();
		if (SHEETSPERSET.equals(propertyName)) return getSheetsPerSet();
		if (ISCOSTINSETS.equals(propertyName)) return getIsCostInSets();
		if (QTYBREAK.equals(propertyName)) return getQtyBreak();
		if (PRICEEXPIRES.equals(propertyName)) return getPriceExpires();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (COSTUNITS.equals(propertyName)) setCostUnits((Integer)newValue); else
		if (SHEETSPERSET.equals(propertyName)) setSheetsPerSet((Integer)newValue); else
		if (ISCOSTINSETS.equals(propertyName)) setIsCostInSets((Integer)newValue); else
		if (QTYBREAK.equals(propertyName)) setQtyBreak((StockQtyBreak)newValue); else
		if (PRICEEXPIRES.equals(propertyName)) setPriceExpires((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (COSTUNITS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SHEETSPERSET.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (ISCOSTINSETS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (QTYBREAK.equals(propertyName)) 
			return new Class<?>[] {StockQtyBreak.class};		
		if (PRICEEXPIRES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (COSTUNITS.equals(propertyName)) return StockQty.class;
		if (SHEETSPERSET.equals(propertyName)) return StockQty.class;
		if (ISCOSTINSETS.equals(propertyName)) return StockQty.class;
		if (QTYBREAK.equals(propertyName)) return StockQty.class;
		if (PRICEEXPIRES.equals(propertyName)) return StockQty.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockQty objT = (StockQty)obj;
		if (! SmartEquals(getCostUnits(), objT.getCostUnits()))
			return false;
		if (! SmartEquals(getSheetsPerSet(), objT.getSheetsPerSet()))
			return false;
		if (! SmartEquals(getIsCostInSets(), objT.getIsCostInSets()))
			return false;
		if (! SmartEquals(getQtyBreak(), objT.getQtyBreak()))
			return false;
		if (! SmartEquals(getPriceExpires(), objT.getPriceExpires()))
			return false;
		return true;
	}			
}