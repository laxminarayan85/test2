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
	@NamedQuery(name = "PreferencesCashRegister.findall", query = "from PreferencesCashRegister"),
	@NamedQuery(name = "PreferencesCashRegister.byId", query = "select a from PreferencesCashRegister a where a.id= :id")
})


@Entity
@Table(name = "preferencescashregister")
public class PreferencesCashRegister extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String CATEGORY = "Category";
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";

	/**
	 * @generated
	 */
	public PreferencesCashRegister() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Boolean tax;
	/**
	 * @generated
 	 */
	public Boolean getTax(){
		return tax; 
	}

	/**
	 * @generated
	 */	
	public void setTax(Boolean newVal) {
		this.tax = newVal;
	}
 	
	
 	@Basic
	private String title;
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private SalesCategory category;
	/**
	 * @generated
 	 */
	public SalesCategory getCategory(){
		return category; 
	}

	/**
	 * @generated
	 */	
	public void setCategory(SalesCategory newVal) {
		this.category = newVal;
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

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TAX.equals(propertyName)) return getTax();
		if (TITLE.equals(propertyName)) return getTitle();
		if (CATEGORY.equals(propertyName)) return getCategory();
		if (RATE.equals(propertyName)) return getRate();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TAX.equals(propertyName)) setTax((Boolean)newValue); else
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (CATEGORY.equals(propertyName)) setCategory((SalesCategory)newValue); else
		if (RATE.equals(propertyName)) setRate((Double)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TAX.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CATEGORY.equals(propertyName)) 
			return new Class<?>[] {SalesCategory.class};		
		if (RATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TAX.equals(propertyName)) return PreferencesCashRegister.class;
		if (TITLE.equals(propertyName)) return PreferencesCashRegister.class;
		if (CATEGORY.equals(propertyName)) return PreferencesCashRegister.class;
		if (RATE.equals(propertyName)) return PreferencesCashRegister.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesCashRegister objT = (PreferencesCashRegister)obj;
		if (! SmartEquals(getTax(), objT.getTax()))
			return false;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getCategory(), objT.getCategory()))
			return false;
		if (! SmartEquals(getRate(), objT.getRate()))
			return false;
		return true;
	}			
}