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
	@NamedQuery(name = "EstimatorTypes.findall", query = "from EstimatorTypes"),
	@NamedQuery(name = "EstimatorTypes.byId", query = "select a from EstimatorTypes a where a.id= :id")
})


@Entity
@Table(name = "estimatortypes")
public class EstimatorTypes extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
	 * @generated
	 */
	public EstimatorTypes() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Integer name;
	/**
	 * @generated
 	 */
	public Integer getName(){
		return name; 
	}

	/**
	 * @generated
	 */	
	public void setName(Integer newVal) {
		this.name = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return EstimatorTypes.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		EstimatorTypes objT = (EstimatorTypes)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		return true;
	}			
}