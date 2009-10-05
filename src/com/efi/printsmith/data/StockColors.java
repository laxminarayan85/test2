package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
	@NamedQuery(name = "StockColors.findall", query = "from StockColors"),
	@NamedQuery(name = "StockColors.byId", query = "select a from StockColors a where a.id= :id")
})


@Entity
@Table(name = "stockcolors")
public class StockColors extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String GENERICCOLOR = "GenericColor";

	/**
	 * @generated
	 */
	public StockColors() {
		this.created = new Date();
		this.modified = new Date();
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
 	
	
	@ManyToOne
	private GenericColors genericColor;
	/**
	 * @generated
 	 */
	public GenericColors getGenericColor(){
		return genericColor; 
	}

	/**
	 * @generated
	 */	
	public void setGenericColor(GenericColors newVal) {
		this.genericColor = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (GENERICCOLOR.equals(propertyName)) return getGenericColor();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (GENERICCOLOR.equals(propertyName)) setGenericColor((GenericColors)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (GENERICCOLOR.equals(propertyName)) 
			return new Class<?>[] {GenericColors.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return StockColors.class;
		if (GENERICCOLOR.equals(propertyName)) return StockColors.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockColors objT = (StockColors)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getGenericColor(), objT.getGenericColor()))
			return false;
		return true;
	}			
}