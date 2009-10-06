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
	@NamedQuery(name = "ChargeCommand.findall", query = "from ChargeCommand"),
	@NamedQuery(name = "ChargeCommand.byId", query = "select a from ChargeCommand a where a.id= :id")
})


@Entity
@Table(name = "chargecommand")
public class ChargeCommand extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CHILDREN = "Children";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
	 * @generated
	 */
	public ChargeCommand() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<ChargeCategory> childrens;
	/**
	 * @generated
 	 */
	public java.util.List<ChargeCategory> getChildrens(){
		return childrens; 
	}

	/**
	 * @generated
	 */	
	public void setChildrens(java.util.List<ChargeCategory> newVal) {
		this.childrens = newVal;
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

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CHILDREN.equals(propertyName)) return getChildrens();
		if (NAME.equals(propertyName)) return getName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CHILDREN.equals(propertyName)) setChildrens((java.util.List<ChargeCategory>)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CHILDREN.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, ChargeCategory.class};		
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CHILDREN.equals(propertyName)) return ChargeCommand.class;
		if (NAME.equals(propertyName)) return ChargeCommand.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ChargeCommand objT = (ChargeCommand)obj;
		if (! SmartEquals(getChildrens(), objT.getChildrens()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		return true;
	}			
}