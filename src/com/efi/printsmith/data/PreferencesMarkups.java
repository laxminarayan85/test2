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
	@NamedQuery(name = "PreferencesMarkups.findall", query = "from PreferencesMarkups"),
	@NamedQuery(name = "PreferencesMarkups.byId", query = "select a from PreferencesMarkups a where a.id= :id")
})


@Entity
@Table(name = "preferencesmarkups")
public class PreferencesMarkups extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TOTALCOST = "TotalCost";
	/**
	 * @generated
	 */
	public static final String MARKUP = "Markup";
	/**
	 * @generated
	 */
	public static final String ABOVE = "Above";

	/**
	 * @generated
	 */
	public PreferencesMarkups() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Double totalCost;
	/**
	 * @generated
 	 */
	public Double getTotalCost(){
		return totalCost; 
	}

	/**
	 * @generated
	 */	
	public void setTotalCost(Double newVal) {
		this.totalCost = newVal;
	}
 	
	
 	@Basic
	private Double markup;
	/**
	 * @generated
 	 */
	public Double getMarkup(){
		return markup; 
	}

	/**
	 * @generated
	 */	
	public void setMarkup(Double newVal) {
		this.markup = newVal;
	}
 	
	
 	@Basic
	private Boolean above;
	/**
	 * @generated
 	 */
	public Boolean getAbove(){
		return above; 
	}

	/**
	 * @generated
	 */	
	public void setAbove(Boolean newVal) {
		this.above = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TOTALCOST.equals(propertyName)) return getTotalCost();
		if (MARKUP.equals(propertyName)) return getMarkup();
		if (ABOVE.equals(propertyName)) return getAbove();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TOTALCOST.equals(propertyName)) setTotalCost((Double)newValue); else
		if (MARKUP.equals(propertyName)) setMarkup((Double)newValue); else
		if (ABOVE.equals(propertyName)) setAbove((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TOTALCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (MARKUP.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (ABOVE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TOTALCOST.equals(propertyName)) return PreferencesMarkups.class;
		if (MARKUP.equals(propertyName)) return PreferencesMarkups.class;
		if (ABOVE.equals(propertyName)) return PreferencesMarkups.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesMarkups objT = (PreferencesMarkups)obj;
		if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
			return false;
		if (! SmartEquals(getMarkup(), objT.getMarkup()))
			return false;
		if (! SmartEquals(getAbove(), objT.getAbove()))
			return false;
		return true;
	}			
}