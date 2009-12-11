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
	@NamedQuery(name = "PreferencesQuantityBreaks.findall", query = "from PreferencesQuantityBreaks"),
	@NamedQuery(name = "PreferencesQuantityBreaks.byId", query = "select a from PreferencesQuantityBreaks a where a.id= :id")
})


@Entity
@Table(name = "preferencesquantitybreaks")
public class PreferencesQuantityBreaks extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String QTYBREAK = "QtyBreak";

	/**
	 * @generated
	 */
	public PreferencesQuantityBreaks() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
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
	public void setQuantity(Integer newVal) {
		this.quantity = newVal;
	}
 	
	
 	@Basic
	private Boolean qtyBreak;
	/**
	 * @generated
 	 */
	public Boolean getQtyBreak(){
		return qtyBreak; 
	}

	/**
	 * @generated
	 */	
	public void setQtyBreak(Boolean newVal) {
		this.qtyBreak = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (QTYBREAK.equals(propertyName)) return getQtyBreak();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QUANTITY.equals(propertyName)) setQuantity((Integer)newValue); else
		if (QTYBREAK.equals(propertyName)) setQtyBreak((Boolean)newValue); else
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
		if (QTYBREAK.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) return PreferencesQuantityBreaks.class;
		if (QTYBREAK.equals(propertyName)) return PreferencesQuantityBreaks.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesQuantityBreaks objT = (PreferencesQuantityBreaks)obj;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getQtyBreak(), objT.getQtyBreak()))
			return false;
		return true;
	}			
}