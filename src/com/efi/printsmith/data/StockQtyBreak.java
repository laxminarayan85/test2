package com.efi.printsmith.data;

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
	@NamedQuery(name = "StockQtyBreak.findall", query = "from StockQtyBreak"),
	@NamedQuery(name = "StockQtyBreak.byId", query = "select a from StockQtyBreak a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockQtyBreak")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockqtybreak")
public class StockQtyBreak extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String COST = "Cost";
	/**
	 * @generated
	 */
	public static final String CWT = "Cwt";
	/**
	 * @generated
	 */
	public static final String MARKUP = "Markup";
	/**
	 * @generated
	 */
	public static final String LISTPERM = "ListPerM";

	/**
	 * @generated
	 */
	public StockQtyBreak() {
	}

 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="quantity", nullable=true, unique=false)
	private Integer quantity;
	/**
	 * @generated
 	 */
	public Integer getQuantity(){
		return quantity; 
	}

	/**
	 * @generated
	 */	
	public Integer setQuantity(Integer newVal) {
		return this.quantity = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="cost", nullable=true, unique=false)
	private Integer cost;
	/**
	 * @generated
 	 */
	public Integer getCost(){
		return cost; 
	}

	/**
	 * @generated
	 */	
	public Integer setCost(Integer newVal) {
		return this.cost = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="cwt", nullable=true, unique=false)
	private Integer cwt;
	/**
	 * @generated
 	 */
	public Integer getCwt(){
		return cwt; 
	}

	/**
	 * @generated
	 */	
	public Integer setCwt(Integer newVal) {
		return this.cwt = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="markup", nullable=true, unique=false)
	private Integer markup;
	/**
	 * @generated
 	 */
	public Integer getMarkup(){
		return markup; 
	}

	/**
	 * @generated
	 */	
	public Integer setMarkup(Integer newVal) {
		return this.markup = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="listperm", nullable=true, unique=false)
	private Integer listPerM;
	/**
	 * @generated
 	 */
	public Integer getListPerM(){
		return listPerM; 
	}

	/**
	 * @generated
	 */	
	public Integer setListPerM(Integer newVal) {
		return this.listPerM = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (COST.equals(propertyName)) return getCost();
		if (CWT.equals(propertyName)) return getCwt();
		if (MARKUP.equals(propertyName)) return getMarkup();
		if (LISTPERM.equals(propertyName)) return getListPerM();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QUANTITY.equals(propertyName)) setQuantity((Integer)newValue); else
		if (COST.equals(propertyName)) setCost((Integer)newValue); else
		if (CWT.equals(propertyName)) setCwt((Integer)newValue); else
		if (MARKUP.equals(propertyName)) setMarkup((Integer)newValue); else
		if (LISTPERM.equals(propertyName)) setListPerM((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COST.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CWT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MARKUP.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (LISTPERM.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) return StockQtyBreak.class;
		if (COST.equals(propertyName)) return StockQtyBreak.class;
		if (CWT.equals(propertyName)) return StockQtyBreak.class;
		if (MARKUP.equals(propertyName)) return StockQtyBreak.class;
		if (LISTPERM.equals(propertyName)) return StockQtyBreak.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockQtyBreak objT = (StockQtyBreak)obj;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getCost(), objT.getCost()))
			return false;
		if (! SmartEquals(getCwt(), objT.getCwt()))
			return false;
		if (! SmartEquals(getMarkup(), objT.getMarkup()))
			return false;
		if (! SmartEquals(getListPerM(), objT.getListPerM()))
			return false;
		return true;
	}			
}