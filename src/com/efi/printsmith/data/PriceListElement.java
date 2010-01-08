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
	@NamedQuery(name = "PriceListElement.findall", query = "from PriceListElement"),
	@NamedQuery(name = "PriceListElement.byId", query = "select a from PriceListElement a where a.id= :id")
})


@Entity
@Table(name = "pricelistelement")
public class PriceListElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";

	/**
	 * @generated
	 */
	public PriceListElement() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Long quantity;
	/**
	 * @generated
 	 */
	public Long getQuantity(){
		return quantity; 
	}

	/**
	 * @generated
	 */	
	public void setQuantity(Long newVal) {
		this.quantity = newVal;
	}
 	
	
 	@Basic
	private Double amount;
	/**
	 * @generated
 	 */
	public Double getAmount(){
		return amount; 
	}

	/**
	 * @generated
	 */	
	public void setAmount(Double newVal) {
		this.amount = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (AMOUNT.equals(propertyName)) return getAmount();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QUANTITY.equals(propertyName)) setQuantity((Long)newValue); else
		if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (AMOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) return PriceListElement.class;
		if (AMOUNT.equals(propertyName)) return PriceListElement.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PriceListElement objT = (PriceListElement)obj;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getAmount(), objT.getAmount()))
			return false;
		return true;
	}			
}