package com.efi.printsmith;

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
	@NamedQuery(name = "StockComments.findall", query = "from StockComments"),
	@NamedQuery(name = "StockComments.byId", query = "select a from StockComments a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.StockComments")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stockcomments")
public class StockComments extends ModelBase {
	/**
	 * @generated
	 */
	public static final String VALUE = "Value";

	/**
	 * @generated
	 */
	public StockComments() {
	}

 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private UnlimitedNatural value;
	/**
	 * @generated
 	 */
	public UnlimitedNatural getValue(){
		return value; 
	}

	/**
	 * @generated
	 */	
	public UnlimitedNatural setValue(UnlimitedNatural newVal) {
		return this.value = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (VALUE.equals(propertyName)) return getValue();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (VALUE.equals(propertyName)) setValue((UnlimitedNatural)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (VALUE.equals(propertyName)) 
			return new Class<?>[] {UnlimitedNatural.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (VALUE.equals(propertyName)) return StockComments.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		StockComments objT = (StockComments)obj;
		if (! SmartEquals(getValue(), objT.getValue()))
			return false;
		return true;
	}			
}