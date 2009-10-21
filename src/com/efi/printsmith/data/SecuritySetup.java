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
	@NamedQuery(name = "SecuritySetup.findall", query = "from SecuritySetup"),
	@NamedQuery(name = "SecuritySetup.byId", query = "select a from SecuritySetup a where a.id= :id")
})


@Entity
@Table(name = "securitysetup")
public class SecuritySetup extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ENABLE = "Enable";
	/**
	 * @generated
	 */
	public static final String MENU = "Menu";
	/**
	 * @generated
	 */
	public static final String COMMANDNAME = "CommandName";
	/**
	 * @generated
	 */
	public static final String ACCESSGROUP = "AccessGroup";

	/**
	 * @generated
	 */
	public SecuritySetup() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Boolean enable;
	/**
	 * @generated
 	 */
	public Boolean getEnable(){
		return enable; 
	}

	/**
	 * @generated
	 */	
	public void setEnable(Boolean newVal) {
		this.enable = newVal;
	}
 	
	
 	@Basic
	private String menu;
	/**
	 * @generated
 	 */
	public String getMenu(){
		return menu; 
	}

	/**
	 * @generated
	 */	
	public void setMenu(String newVal) {
		this.menu = newVal;
	}
 	
	
 	@Basic
	private String commandName;
	/**
	 * @generated
 	 */
	public String getCommandName(){
		return commandName; 
	}

	/**
	 * @generated
	 */	
	public void setCommandName(String newVal) {
		this.commandName = newVal;
	}
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<AccessGroup> accessGroups;
	/**
	 * @generated
 	 */
	public java.util.List<AccessGroup> getAccessGroups(){
		return accessGroups; 
	}

	public void addAccessGroups(AccessGroup obj) {
		if (accessGroups == null) {
			accessGroups = new java.util.ArrayList<AccessGroup>();
		}
		accessGroups.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setAccessGroups(java.util.List<AccessGroup> newVal) {
		this.accessGroups = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (ENABLE.equals(propertyName)) return getEnable();
		if (MENU.equals(propertyName)) return getMenu();
		if (COMMANDNAME.equals(propertyName)) return getCommandName();
		if (ACCESSGROUP.equals(propertyName)) return getAccessGroups();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (ENABLE.equals(propertyName)) setEnable((Boolean)newValue); else
		if (MENU.equals(propertyName)) setMenu((String)newValue); else
		if (COMMANDNAME.equals(propertyName)) setCommandName((String)newValue); else
		if (ACCESSGROUP.equals(propertyName)) setAccessGroups((java.util.List<AccessGroup>)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (ENABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MENU.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COMMANDNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ACCESSGROUP.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, AccessGroup.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (ENABLE.equals(propertyName)) return SecuritySetup.class;
		if (MENU.equals(propertyName)) return SecuritySetup.class;
		if (COMMANDNAME.equals(propertyName)) return SecuritySetup.class;
		if (ACCESSGROUP.equals(propertyName)) return SecuritySetup.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		SecuritySetup objT = (SecuritySetup)obj;
		if (! SmartEquals(getEnable(), objT.getEnable()))
			return false;
		if (! SmartEquals(getMenu(), objT.getMenu()))
			return false;
		if (! SmartEquals(getCommandName(), objT.getCommandName()))
			return false;
		if (! SmartEquals(getAccessGroups(), objT.getAccessGroups()))
			return false;
		return true;
	}			
}