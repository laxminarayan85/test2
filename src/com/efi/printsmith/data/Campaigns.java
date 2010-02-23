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
	public static final String APPLIED = "Applied";
	/**
	 * @generated
	 */
	public static final String GLOBALCAMPAIGN = "GlobalCampaign";
	/**
	 * @generated
	 */
	public static final String CAMPAIGNID = "CampaignId";

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
	private Boolean applied;
	/**
	 * @generated
 	 */
	public Boolean getApplied(){
		return applied; 
	}

	/**
	 * @generated
	 */	
	public void setApplied(Boolean newVal) {
		this.applied = newVal;
	}
 	
	
 	@Basic
	private Boolean globalCampaign;
	/**
	 * @generated
 	 */
	public Boolean getGlobalCampaign(){
		return globalCampaign; 
	}

	/**
	 * @generated
	 */	
	public void setGlobalCampaign(Boolean newVal) {
		this.globalCampaign = newVal;
	}
 	
	
 	@Basic
	private String campaignId;
	/**
	 * @generated
 	 */
	public String getCampaignId(){
		return campaignId; 
	}

	/**
	 * @generated
	 */	
	public void setCampaignId(String newVal) {
		this.campaignId = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (APPLIED.equals(propertyName)) return getApplied();
		if (GLOBALCAMPAIGN.equals(propertyName)) return getGlobalCampaign();
		if (CAMPAIGNID.equals(propertyName)) return getCampaignId();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (APPLIED.equals(propertyName)) setApplied((Boolean)newValue); else
		if (GLOBALCAMPAIGN.equals(propertyName)) setGlobalCampaign((Boolean)newValue); else
		if (CAMPAIGNID.equals(propertyName)) setCampaignId((String)newValue); else
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
		if (APPLIED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (GLOBALCAMPAIGN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CAMPAIGNID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return Campaigns.class;
		if (APPLIED.equals(propertyName)) return Campaigns.class;
		if (GLOBALCAMPAIGN.equals(propertyName)) return Campaigns.class;
		if (CAMPAIGNID.equals(propertyName)) return Campaigns.class;
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
		if (! SmartEquals(getApplied(), objT.getApplied()))
			return false;
		if (! SmartEquals(getGlobalCampaign(), objT.getGlobalCampaign()))
			return false;
		if (! SmartEquals(getCampaignId(), objT.getCampaignId()))
			return false;
		return true;
	}			
}