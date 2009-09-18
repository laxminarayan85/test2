package com.efi.printsmith.data;

import java.util.Date;

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


@DiscriminatorValue("com.efi.printsmith.data.Contact")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
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
	public static final String CONTACT = "Contact";
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
	public Contact() {
	}

 	
	
	private String title;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="title", nullable=true, unique=false)
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public String setTitle(String newVal) {
		return this.title = newVal;
	}
 	
	
	private Address address;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Address getAddress(){
		return address; 
	}

	/**
	 * @generated
	 */	
	public Address setAddress(Address newVal) {
		return this.address = newVal;
	}
 	
	
	private Contact contact;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Contact getContact(){
		return contact; 
	}

	/**
	 * @generated
	 */	
	public Contact setContact(Contact newVal) {
		return this.contact = newVal;
	}
 	
	
	private String userAcctId;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="useracctid", nullable=true, unique=false)
	public String getUserAcctId(){
		return userAcctId; 
	}

	/**
	 * @generated
	 */	
	public String setUserAcctId(String newVal) {
		return this.userAcctId = newVal;
	}
 	
	
	private Boolean webAcctNameIncomplete;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="webacctnameincomplete", nullable=true, unique=false)
	public Boolean getWebAcctNameIncomplete(){
		return webAcctNameIncomplete; 
	}

	/**
	 * @generated
	 */	
	public Boolean setWebAcctNameIncomplete(Boolean newVal) {
		return this.webAcctNameIncomplete = newVal;
	}
 	
	
	private Boolean webCatalogChange;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="webcatalogchange", nullable=true, unique=false)
	public Boolean getWebCatalogChange(){
		return webCatalogChange; 
	}

	/**
	 * @generated
	 */	
	public Boolean setWebCatalogChange(Boolean newVal) {
		return this.webCatalogChange = newVal;
	}
 	
	
	private Boolean webStateChange;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="webstatechange", nullable=true, unique=false)
	public Boolean getWebStateChange(){
		return webStateChange; 
	}

	/**
	 * @generated
	 */	
	public Boolean setWebStateChange(Boolean newVal) {
		return this.webStateChange = newVal;
	}
 	
	
	private Boolean transmitted;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="transmitted", nullable=true, unique=false)
	public Boolean getTransmitted(){
		return transmitted; 
	}

	/**
	 * @generated
	 */	
	public Boolean setTransmitted(Boolean newVal) {
		return this.transmitted = newVal;
	}
 	
	
	private Boolean doNotMail;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="donotmail", nullable=true, unique=false)
	public Boolean getDoNotMail(){
		return doNotMail; 
	}

	/**
	 * @generated
	 */	
	public Boolean setDoNotMail(Boolean newVal) {
		return this.doNotMail = newVal;
	}
 	
	
	private Boolean useContactAddress;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="usecontactaddress", nullable=true, unique=false)
	public Boolean getUseContactAddress(){
		return useContactAddress; 
	}

	/**
	 * @generated
	 */	
	public Boolean setUseContactAddress(Boolean newVal) {
		return this.useContactAddress = newVal;
	}
 	
	
	private Boolean isIndividual;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="isindividual", nullable=true, unique=false)
	public Boolean getIsIndividual(){
		return isIndividual; 
	}

	/**
	 * @generated
	 */	
	public Boolean setIsIndividual(Boolean newVal) {
		return this.isIndividual = newVal;
	}
 	
	
	private SalesRep defaultSalesRep;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public SalesRep getDefaultSalesRep(){
		return defaultSalesRep; 
	}

	/**
	 * @generated
	 */	
	public SalesRep setDefaultSalesRep(SalesRep newVal) {
		return this.defaultSalesRep = newVal;
	}
 	
	
	private Boolean mailerCampaigns;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="mailercampaigns", nullable=true, unique=false)
	public Boolean getMailerCampaigns(){
		return mailerCampaigns; 
	}

	/**
	 * @generated
	 */	
	public Boolean setMailerCampaigns(Boolean newVal) {
		return this.mailerCampaigns = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TITLE.equals(propertyName)) return getTitle();
		if (ADDRESS.equals(propertyName)) return getAddress();
		if (CONTACT.equals(propertyName)) return getContact();
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
		if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
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
		if (CONTACT.equals(propertyName)) 
			return new Class<?>[] {Contact.class};		
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
		if (CONTACT.equals(propertyName)) return Contact.class;
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
		if (! SmartEquals(getContact(), objT.getContact()))
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
		return true;
	}			
}