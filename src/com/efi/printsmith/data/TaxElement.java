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
	@NamedQuery(name = "TaxElement.findall", query = "from TaxElement"),
	@NamedQuery(name = "TaxElement.byId", query = "select a from TaxElement a where a.id= :id")
})


@Entity
@Table(name = "taxelement")
public class TaxElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String SHOWTAX = "ShowTax";
	/**
	 * @generated
	 */
	public static final String USERFORSEPARATESHIPPINGTAX = "UserForSeparateShippingTax";

	/**
	 * @generated
	 */
	public TaxElement() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Double rate;
	/**
	 * @generated
 	 */
	public Double getRate(){
		return rate; 
	}

	/**
	 * @generated
	 */	
	public void setRate(Double newVal) {
		this.rate = newVal;
	}
 	
	
 	@Basic
	private Boolean showTax;
	/**
	 * @generated
 	 */
	public Boolean getShowTax(){
		return showTax; 
	}

	/**
	 * @generated
	 */	
	public void setShowTax(Boolean newVal) {
		this.showTax = newVal;
	}
 	
	
 	@Basic
	private Boolean userForSeparateShippingTax;
	/**
	 * @generated
 	 */
	public Boolean getUserForSeparateShippingTax(){
		return userForSeparateShippingTax; 
	}

	/**
	 * @generated
	 */	
	public void setUserForSeparateShippingTax(Boolean newVal) {
		this.userForSeparateShippingTax = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (RATE.equals(propertyName)) return getRate();
		if (SHOWTAX.equals(propertyName)) return getShowTax();
		if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) return getUserForSeparateShippingTax();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (RATE.equals(propertyName)) setRate((Double)newValue); else
		if (SHOWTAX.equals(propertyName)) setShowTax((Boolean)newValue); else
		if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) setUserForSeparateShippingTax((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (RATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SHOWTAX.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (RATE.equals(propertyName)) return TaxElement.class;
		if (SHOWTAX.equals(propertyName)) return TaxElement.class;
		if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) return TaxElement.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		TaxElement objT = (TaxElement)obj;
		if (! SmartEquals(getRate(), objT.getRate()))
			return false;
		if (! SmartEquals(getShowTax(), objT.getShowTax()))
			return false;
		if (! SmartEquals(getUserForSeparateShippingTax(), objT.getUserForSeparateShippingTax()))
			return false;
		return true;
	}			
}