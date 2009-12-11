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
	@NamedQuery(name = "Campaigns.findall", query = "from Campaigns"),
	@NamedQuery(name = "Campaigns.byId", query = "select a from Campaigns a where a.id= :id")
})


@Entity
@Table(name = "campaigns")
public class Campaigns extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String CAMPAIGNID = "CampaignID";
	/**
	 * @generated
	 */
	public static final String CAMPAIGNGRADEID = "CampaignGradeID";

	/**
	 * @generated
	 */
	public Campaigns() {
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
 	
	
 	@Basic
	private Integer campaignID;
	/**
	 * @generated
 	 */
	public Integer getCampaignID(){
		return campaignID; 
	}

	/**
	 * @generated
	 */	
	public void setCampaignID(Integer newVal) {
		this.campaignID = newVal;
	}
 	
	
 	@Basic
	private Integer campaignGradeID;
	/**
	 * @generated
 	 */
	public Integer getCampaignGradeID(){
		return campaignGradeID; 
	}

	/**
	 * @generated
	 */	
	public void setCampaignGradeID(Integer newVal) {
		this.campaignGradeID = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (CAMPAIGNID.equals(propertyName)) return getCampaignID();
		if (CAMPAIGNGRADEID.equals(propertyName)) return getCampaignGradeID();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (CAMPAIGNID.equals(propertyName)) setCampaignID((Integer)newValue); else
		if (CAMPAIGNGRADEID.equals(propertyName)) setCampaignGradeID((Integer)newValue); else
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
		if (CAMPAIGNID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CAMPAIGNGRADEID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return Campaigns.class;
		if (CAMPAIGNID.equals(propertyName)) return Campaigns.class;
		if (CAMPAIGNGRADEID.equals(propertyName)) return Campaigns.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Campaigns objT = (Campaigns)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getCampaignID(), objT.getCampaignID()))
			return false;
		if (! SmartEquals(getCampaignGradeID(), objT.getCampaignGradeID()))
			return false;
		return true;
	}			
}