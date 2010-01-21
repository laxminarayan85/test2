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
	@NamedQuery(name = "Grade.findall", query = "from Grade"),
	@NamedQuery(name = "Grade.byId", query = "select a from Grade a where a.id= :id")
})


@Entity
@Table(name = "grade")
public class Grade extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String CAMPAIGNS = "Campaigns";

	/**
	 * @generated
	 */
	public Grade() {
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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Campaigns> campaigns;
	/**
	 * @generated
 	 */
	public java.util.List<Campaigns> getCampaigns(){
		return campaigns; 
	}

	public void addCampaigns(Campaigns obj) {
		if (campaigns == null) {
			campaigns = new java.util.ArrayList<Campaigns>();
		}
		campaigns.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setCampaigns(java.util.List<Campaigns> newVal) {
		this.campaigns = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (CAMPAIGNS.equals(propertyName)) return getCampaigns();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (CAMPAIGNS.equals(propertyName)) setCampaigns((java.util.List<Campaigns>)newValue); else
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
		if (CAMPAIGNS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Campaigns.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return Grade.class;
		if (CAMPAIGNS.equals(propertyName)) return Grade.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Grade objT = (Grade)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getCampaigns(), objT.getCampaigns()))
			return false;
		return true;
	}			
}