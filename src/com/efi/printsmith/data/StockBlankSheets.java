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
	@NamedQuery(name = "StockBlankSheets.findall", query = "from StockBlankSheets"),
	@NamedQuery(name = "StockBlankSheets.byId", query = "select a from StockBlankSheets a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockBlankSheets")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockblanksheets")
public class StockBlankSheets extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String PRICE = "Price";

	/**
	 * @generated
	 */
	public StockBlankSheets() {
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
	@Column(name="price", nullable=true, unique=false)
	private Integer price;
	/**
	 * @generated
 	 */
	public Integer getPrice(){
		return price; 
	}

	/**
	 * @generated
	 */	
	public Integer setPrice(Integer newVal) {
		return this.price = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (PRICE.equals(propertyName)) return getPrice();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QUANTITY.equals(propertyName)) setQuantity((Integer)newValue); else
		if (PRICE.equals(propertyName)) setPrice((Integer)newValue); else
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
		if (PRICE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) return StockBlankSheets.class;
		if (PRICE.equals(propertyName)) return StockBlankSheets.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockBlankSheets objT = (StockBlankSheets)obj;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getPrice(), objT.getPrice()))
			return false;
		return true;
	}			
}