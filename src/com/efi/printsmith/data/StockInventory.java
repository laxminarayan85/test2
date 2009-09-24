package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

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
	@NamedQuery(name = "StockInventory.findall", query = "from StockInventory"),
	@NamedQuery(name = "StockInventory.byId", query = "select a from StockInventory a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockInventory")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockinventory")
public class StockInventory extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STANDARDITEM = "StandardItem";
	/**
	 * @generated
	 */
	public static final String ONHAND = "OnHand";
	/**
	 * @generated
	 */
	public static final String COMMITTED = "Committed";
	/**
	 * @generated
	 */
	public static final String AVAILABLE = "Available";
	/**
	 * @generated
	 */
	public static final String ONORDER = "OnOrder";
	/**
	 * @generated
	 */
	public static final String TARGETLEVEL = "TargetLevel";
	/**
	 * @generated
	 */
	public static final String REORDERPOINT = "ReOrderPoint";
	/**
	 * @generated
	 */
	public static final String MINORDERQTY = "MinOrderQty";
	/**
	 * @generated
	 */
	public static final String EVENINCREMENTS = "EvenIncrements";
	/**
	 * @generated
	 */
	public static final String EXPIRES = "Expires";
	/**
	 * @generated
	 */
	public static final String BINLOCATION = "BinLocation";

	/**
	 * @generated
	 */
	public StockInventory() {
	}

 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="standarditem", nullable=true, unique=false)
	private Boolean standardItem;
	/**
	 * @generated
 	 */
	public Boolean getStandardItem(){
		return standardItem; 
	}

	/**
	 * @generated
	 */	
	public Boolean setStandardItem(Boolean newVal) {
		return this.standardItem = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="onhand", nullable=true, unique=false)
	private Integer onHand;
	/**
	 * @generated
 	 */
	public Integer getOnHand(){
		return onHand; 
	}

	/**
	 * @generated
	 */	
	public Integer setOnHand(Integer newVal) {
		return this.onHand = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="committed", nullable=true, unique=false)
	private Integer committed;
	/**
	 * @generated
 	 */
	public Integer getCommitted(){
		return committed; 
	}

	/**
	 * @generated
	 */	
	public Integer setCommitted(Integer newVal) {
		return this.committed = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="available", nullable=true, unique=false)
	private Integer available;
	/**
	 * @generated
 	 */
	public Integer getAvailable(){
		return available; 
	}

	/**
	 * @generated
	 */	
	public Integer setAvailable(Integer newVal) {
		return this.available = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="onorder", nullable=true, unique=false)
	private Integer onOrder;
	/**
	 * @generated
 	 */
	public Integer getOnOrder(){
		return onOrder; 
	}

	/**
	 * @generated
	 */	
	public Integer setOnOrder(Integer newVal) {
		return this.onOrder = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="targetlevel", nullable=true, unique=false)
	private Integer targetLevel;
	/**
	 * @generated
 	 */
	public Integer getTargetLevel(){
		return targetLevel; 
	}

	/**
	 * @generated
	 */	
	public Integer setTargetLevel(Integer newVal) {
		return this.targetLevel = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="reorderpoint", nullable=true, unique=false)
	private Integer reOrderPoint;
	/**
	 * @generated
 	 */
	public Integer getReOrderPoint(){
		return reOrderPoint; 
	}

	/**
	 * @generated
	 */	
	public Integer setReOrderPoint(Integer newVal) {
		return this.reOrderPoint = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minorderqty", nullable=true, unique=false)
	private Integer minOrderQty;
	/**
	 * @generated
 	 */
	public Integer getMinOrderQty(){
		return minOrderQty; 
	}

	/**
	 * @generated
	 */	
	public Integer setMinOrderQty(Integer newVal) {
		return this.minOrderQty = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="evenincrements", nullable=true, unique=false)
	private Boolean evenIncrements;
	/**
	 * @generated
 	 */
	public Boolean getEvenIncrements(){
		return evenIncrements; 
	}

	/**
	 * @generated
	 */	
	public Boolean setEvenIncrements(Boolean newVal) {
		return this.evenIncrements = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="expires", nullable=true, unique=false)
	private Integer expires;
	/**
	 * @generated
 	 */
	public Integer getExpires(){
		return expires; 
	}

	/**
	 * @generated
	 */	
	public Integer setExpires(Integer newVal) {
		return this.expires = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="binlocation", nullable=true, unique=false)
	private Integer binLocation;
	/**
	 * @generated
 	 */
	public Integer getBinLocation(){
		return binLocation; 
	}

	/**
	 * @generated
	 */	
	public Integer setBinLocation(Integer newVal) {
		return this.binLocation = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (STANDARDITEM.equals(propertyName)) return getStandardItem();
		if (ONHAND.equals(propertyName)) return getOnHand();
		if (COMMITTED.equals(propertyName)) return getCommitted();
		if (AVAILABLE.equals(propertyName)) return getAvailable();
		if (ONORDER.equals(propertyName)) return getOnOrder();
		if (TARGETLEVEL.equals(propertyName)) return getTargetLevel();
		if (REORDERPOINT.equals(propertyName)) return getReOrderPoint();
		if (MINORDERQTY.equals(propertyName)) return getMinOrderQty();
		if (EVENINCREMENTS.equals(propertyName)) return getEvenIncrements();
		if (EXPIRES.equals(propertyName)) return getExpires();
		if (BINLOCATION.equals(propertyName)) return getBinLocation();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (STANDARDITEM.equals(propertyName)) setStandardItem((Boolean)newValue); else
		if (ONHAND.equals(propertyName)) setOnHand((Integer)newValue); else
		if (COMMITTED.equals(propertyName)) setCommitted((Integer)newValue); else
		if (AVAILABLE.equals(propertyName)) setAvailable((Integer)newValue); else
		if (ONORDER.equals(propertyName)) setOnOrder((Integer)newValue); else
		if (TARGETLEVEL.equals(propertyName)) setTargetLevel((Integer)newValue); else
		if (REORDERPOINT.equals(propertyName)) setReOrderPoint((Integer)newValue); else
		if (MINORDERQTY.equals(propertyName)) setMinOrderQty((Integer)newValue); else
		if (EVENINCREMENTS.equals(propertyName)) setEvenIncrements((Boolean)newValue); else
		if (EXPIRES.equals(propertyName)) setExpires((Integer)newValue); else
		if (BINLOCATION.equals(propertyName)) setBinLocation((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (STANDARDITEM.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ONHAND.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COMMITTED.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (AVAILABLE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (ONORDER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (TARGETLEVEL.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (REORDERPOINT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MINORDERQTY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (EVENINCREMENTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (EXPIRES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BINLOCATION.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (STANDARDITEM.equals(propertyName)) return StockInventory.class;
		if (ONHAND.equals(propertyName)) return StockInventory.class;
		if (COMMITTED.equals(propertyName)) return StockInventory.class;
		if (AVAILABLE.equals(propertyName)) return StockInventory.class;
		if (ONORDER.equals(propertyName)) return StockInventory.class;
		if (TARGETLEVEL.equals(propertyName)) return StockInventory.class;
		if (REORDERPOINT.equals(propertyName)) return StockInventory.class;
		if (MINORDERQTY.equals(propertyName)) return StockInventory.class;
		if (EVENINCREMENTS.equals(propertyName)) return StockInventory.class;
		if (EXPIRES.equals(propertyName)) return StockInventory.class;
		if (BINLOCATION.equals(propertyName)) return StockInventory.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockInventory objT = (StockInventory)obj;
		if (! SmartEquals(getStandardItem(), objT.getStandardItem()))
			return false;
		if (! SmartEquals(getOnHand(), objT.getOnHand()))
			return false;
		if (! SmartEquals(getCommitted(), objT.getCommitted()))
			return false;
		if (! SmartEquals(getAvailable(), objT.getAvailable()))
			return false;
		if (! SmartEquals(getOnOrder(), objT.getOnOrder()))
			return false;
		if (! SmartEquals(getTargetLevel(), objT.getTargetLevel()))
			return false;
		if (! SmartEquals(getReOrderPoint(), objT.getReOrderPoint()))
			return false;
		if (! SmartEquals(getMinOrderQty(), objT.getMinOrderQty()))
			return false;
		if (! SmartEquals(getEvenIncrements(), objT.getEvenIncrements()))
			return false;
		if (! SmartEquals(getExpires(), objT.getExpires()))
			return false;
		if (! SmartEquals(getBinLocation(), objT.getBinLocation()))
			return false;
		return true;
	}			
}