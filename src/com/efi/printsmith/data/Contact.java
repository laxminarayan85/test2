package com.efi.printsmith.data;

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
	@NamedQuery(name = "Contact.findall", query = "from Contact"),
	@NamedQuery(name = "Contact.byId", query = "select a from Contact a where a.id= :id")
})


@Entity
@Table(name = "contact")
public class Contact extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String USERACCTID = "UserAcctId";
	/**
	 * @generated
	 */
	public static final String WEBACCTNAMEINCOMPLETE = "WebAcctNameIncomplete";
	/**
	 * @generated
	 */
	public static final String WEBCATALOGCHANGE = "WebCatalogChange";
	/**
	 * @generated
	 */
	public static final String WEBSTATECHANGE = "WebStateChange";
	/**
	 * @generated
	 */
	public static final String TRANSMITTED = "Transmitted";
	/**
	 * @generated
	 */
	public static final String DONOTMAIL = "DoNotMail";
	/**
	 * @generated
	 */
	public static final String USECONTACTADDRESS = "UseContactAddress";
	/**
	 * @generated
	 */
	public static final String ISINDIVIDUAL = "IsIndividual";
	/**
	 * @generated
	 */
	public static final String DEFAULTSALESREP = "DefaultSalesRep";
	/**
	 * @generated
	 */
	public static final String MAILERCAMPAIGNS = "MailerCampaigns";
	/**
	 * @generated
	 */
	public static final String FIRSTNAME = "FirstName";
	/**
	 * @generated
	 */
	public static final String LASTNAME = "LastName";

	/**
	 * @generated
	 */
	public Contact() {
	}

 	
	
 	@Basic
	private String title;
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private Address address;
	/**
	 * @generated
 	 */
	public Address getAddress(){
		return address; 
	}

	/**
	 * @generated
	 */	
	public void setAddress(Address newVal) {
		this.address = newVal;
	}
 	
	
 	@Basic
	private String userAcctId;
	/**
	 * @generated
 	 */
	public String getUserAcctId(){
		return userAcctId; 
	}

	/**
	 * @generated
	 */	
	public void setUserAcctId(String newVal) {
		this.userAcctId = newVal;
	}
 	
	
 	@Basic
	private Boolean webAcctNameIncomplete;
	/**
	 * @generated
 	 */
	public Boolean getWebAcctNameIncomplete(){
		return webAcctNameIncomplete; 
	}

	/**
	 * @generated
	 */	
	public void setWebAcctNameIncomplete(Boolean newVal) {
		this.webAcctNameIncomplete = newVal;
	}
 	
	
 	@Basic
	private Boolean webCatalogChange;
	/**
	 * @generated
 	 */
	public Boolean getWebCatalogChange(){
		return webCatalogChange; 
	}

	/**
	 * @generated
	 */	
	public void setWebCatalogChange(Boolean newVal) {
		this.webCatalogChange = newVal;
	}
 	
	
 	@Basic
	private Boolean webStateChange;
	/**
	 * @generated
 	 */
	public Boolean getWebStateChange(){
		return webStateChange; 
	}

	/**
	 * @generated
	 */	
	public void setWebStateChange(Boolean newVal) {
		this.webStateChange = newVal;
	}
 	
	
 	@Basic
	private Boolean transmitted;
	/**
	 * @generated
 	 */
	public Boolean getTransmitted(){
		return transmitted; 
	}

	/**
	 * @generated
	 */	
	public void setTransmitted(Boolean newVal) {
		this.transmitted = newVal;
	}
 	
	
 	@Basic
	private Boolean doNotMail;
	/**
	 * @generated
 	 */
	public Boolean getDoNotMail(){
		return doNotMail; 
	}

	/**
	 * @generated
	 */	
	public void setDoNotMail(Boolean newVal) {
		this.doNotMail = newVal;
	}
 	
	
 	@Basic
	private Boolean useContactAddress;
	/**
	 * @generated
 	 */
	public Boolean getUseContactAddress(){
		return useContactAddress; 
	}

	/**
	 * @generated
	 */	
	public void setUseContactAddress(Boolean newVal) {
		this.useContactAddress = newVal;
	}
 	
	
 	@Basic
	private Boolean isIndividual;
	/**
	 * @generated
 	 */
	public Boolean getIsIndividual(){
		return isIndividual; 
	}

	/**
	 * @generated
	 */	
	public void setIsIndividual(Boolean newVal) {
		this.isIndividual = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private SalesRep defaultSalesRep;
	/**
	 * @generated
 	 */
	public SalesRep getDefaultSalesRep(){
		return defaultSalesRep; 
	}

	/**
	 * @generated
	 */	
	public void setDefaultSalesRep(SalesRep newVal) {
		this.defaultSalesRep = newVal;
	}
 	
	
 	@Basic
	private Boolean mailerCampaigns;
	/**
	 * @generated
 	 */
	public Boolean getMailerCampaigns(){
		return mailerCampaigns; 
	}

	/**
	 * @generated
	 */	
	public void setMailerCampaigns(Boolean newVal) {
		this.mailerCampaigns = newVal;
	}
 	
	
 	@Basic
	private String firstName;
	/**
	 * @generated
 	 */
	public String getFirstName(){
		return firstName; 
	}

	/**
	 * @generated
	 */	
	public void setFirstName(String newVal) {
		this.firstName = newVal;
	}
 	
	
 	@Basic
	private String lastName;
	/**
	 * @generated
 	 */
	public String getLastName(){
		return lastName; 
	}

	/**
	 * @generated
	 */	
	public void setLastName(String newVal) {
		this.lastName = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TITLE.equals(propertyName)) return getTitle();
		if (ADDRESS.equals(propertyName)) return getAddress();
		if (USERACCTID.equals(propertyName)) return getUserAcctId();
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) return getWebAcctNameIncomplete();
		if (WEBCATALOGCHANGE.equals(propertyName)) return getWebCatalogChange();
		if (WEBSTATECHANGE.equals(propertyName)) return getWebStateChange();
		if (TRANSMITTED.equals(propertyName)) return getTransmitted();
		if (DONOTMAIL.equals(propertyName)) return getDoNotMail();
		if (USECONTACTADDRESS.equals(propertyName)) return getUseContactAddress();
		if (ISINDIVIDUAL.equals(propertyName)) return getIsIndividual();
		if (DEFAULTSALESREP.equals(propertyName)) return getDefaultSalesRep();
		if (MAILERCAMPAIGNS.equals(propertyName)) return getMailerCampaigns();
		if (FIRSTNAME.equals(propertyName)) return getFirstName();
		if (LASTNAME.equals(propertyName)) return getLastName();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
		if (USERACCTID.equals(propertyName)) setUserAcctId((String)newValue); else
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) setWebAcctNameIncomplete((Boolean)newValue); else
		if (WEBCATALOGCHANGE.equals(propertyName)) setWebCatalogChange((Boolean)newValue); else
		if (WEBSTATECHANGE.equals(propertyName)) setWebStateChange((Boolean)newValue); else
		if (TRANSMITTED.equals(propertyName)) setTransmitted((Boolean)newValue); else
		if (DONOTMAIL.equals(propertyName)) setDoNotMail((Boolean)newValue); else
		if (USECONTACTADDRESS.equals(propertyName)) setUseContactAddress((Boolean)newValue); else
		if (ISINDIVIDUAL.equals(propertyName)) setIsIndividual((Boolean)newValue); else
		if (DEFAULTSALESREP.equals(propertyName)) setDefaultSalesRep((SalesRep)newValue); else
		if (MAILERCAMPAIGNS.equals(propertyName)) setMailerCampaigns((Boolean)newValue); else
		if (FIRSTNAME.equals(propertyName)) setFirstName((String)newValue); else
		if (LASTNAME.equals(propertyName)) setLastName((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (USERACCTID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WEBCATALOGCHANGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WEBSTATECHANGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TRANSMITTED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DONOTMAIL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USECONTACTADDRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISINDIVIDUAL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DEFAULTSALESREP.equals(propertyName)) 
			return new Class<?>[] {SalesRep.class};		
		if (MAILERCAMPAIGNS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FIRSTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LASTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TITLE.equals(propertyName)) return Contact.class;
		if (ADDRESS.equals(propertyName)) return Contact.class;
		if (USERACCTID.equals(propertyName)) return Contact.class;
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) return Contact.class;
		if (WEBCATALOGCHANGE.equals(propertyName)) return Contact.class;
		if (WEBSTATECHANGE.equals(propertyName)) return Contact.class;
		if (TRANSMITTED.equals(propertyName)) return Contact.class;
		if (DONOTMAIL.equals(propertyName)) return Contact.class;
		if (USECONTACTADDRESS.equals(propertyName)) return Contact.class;
		if (ISINDIVIDUAL.equals(propertyName)) return Contact.class;
		if (DEFAULTSALESREP.equals(propertyName)) return Contact.class;
		if (MAILERCAMPAIGNS.equals(propertyName)) return Contact.class;
		if (FIRSTNAME.equals(propertyName)) return Contact.class;
		if (LASTNAME.equals(propertyName)) return Contact.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Contact objT = (Contact)obj;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getAddress(), objT.getAddress()))
			return false;
		if (! SmartEquals(getUserAcctId(), objT.getUserAcctId()))
			return false;
		if (! SmartEquals(getWebAcctNameIncomplete(), objT.getWebAcctNameIncomplete()))
			return false;
		if (! SmartEquals(getWebCatalogChange(), objT.getWebCatalogChange()))
			return false;
		if (! SmartEquals(getWebStateChange(), objT.getWebStateChange()))
			return false;
		if (! SmartEquals(getTransmitted(), objT.getTransmitted()))
			return false;
		if (! SmartEquals(getDoNotMail(), objT.getDoNotMail()))
			return false;
		if (! SmartEquals(getUseContactAddress(), objT.getUseContactAddress()))
			return false;
		if (! SmartEquals(getIsIndividual(), objT.getIsIndividual()))
			return false;
		if (! SmartEquals(getDefaultSalesRep(), objT.getDefaultSalesRep()))
			return false;
		if (! SmartEquals(getMailerCampaigns(), objT.getMailerCampaigns()))
			return false;
		if (! SmartEquals(getFirstName(), objT.getFirstName()))
			return false;
		if (! SmartEquals(getLastName(), objT.getLastName()))
			return false;
		return true;
	}			
}