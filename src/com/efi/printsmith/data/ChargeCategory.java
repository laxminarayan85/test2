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
	@NamedQuery(name = "ChargeCategory.findall", query = "from ChargeCategory"),
	@NamedQuery(name = "ChargeCategory.byId", query = "select a from ChargeCategory a where a.id= :id")
})


@Entity
@Table(name = "chargecategory")
public class ChargeCategory extends ModelBase {
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
	public static final String PARENT = "Parent";

	/**
	 * @generated
	 */
	public ChargeCategory() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Charge> childrens;
	/**
	 * @generated
 	 */
	public java.util.List<Charge> getChildrens(){
		return childrens; 
	}

	/**
	 * @generated
	 */	
	public void setChildrens(java.util.List<Charge> newVal) {
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private ChargeCommand parent;
	/**
	 * @generated
 	 */
	public ChargeCommand getParent(){
		return parent; 
	}

	/**
	 * @generated
	 */	
	public void setParent(ChargeCommand newVal) {
		this.parent = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CHILDREN.equals(propertyName)) return getChildrens();
		if (NAME.equals(propertyName)) return getName();
		if (PARENT.equals(propertyName)) return getParent();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CHILDREN.equals(propertyName)) setChildrens((java.util.List<Charge>)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (PARENT.equals(propertyName)) setParent((ChargeCommand)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CHILDREN.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Charge.class};		
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PARENT.equals(propertyName)) 
			return new Class<?>[] {ChargeCommand.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CHILDREN.equals(propertyName)) return ChargeCategory.class;
		if (NAME.equals(propertyName)) return ChargeCategory.class;
		if (PARENT.equals(propertyName)) return ChargeCategory.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ChargeCategory objT = (ChargeCategory)obj;
		if (! SmartEquals(getChildrens(), objT.getChildrens()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getParent(), objT.getParent()))
			return false;
		return true;
	}			
}