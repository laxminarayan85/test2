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
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "ColumnNames.findall", query = "from ColumnNames"),
	@NamedQuery(name = "ColumnNames.byId", query = "select a from ColumnNames a where a.id= :id")
})


@Entity
@Table(name = "columnnames")
public class ColumnNames extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String INTERNALNAME = "InternalName";

	/**
	 * @generated
	 */
	public ColumnNames() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String internalName;
	
	/**
	 * @generated
 	 */
	public String getInternalName(){
		return internalName; 
	}

	
	/**
	 * @generated
	 */	
	public void setInternalName(String newVal) {
		this.internalName = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (INTERNALNAME.equals(propertyName)) return getInternalName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (INTERNALNAME.equals(propertyName)) setInternalName((String)newValue); else
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
		if (INTERNALNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return ColumnNames.class;
		if (INTERNALNAME.equals(propertyName)) return ColumnNames.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ColumnNames objT = (ColumnNames)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getInternalName(), objT.getInternalName()))
			return false;
		return true;
	}			
}