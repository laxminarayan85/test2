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
	@NamedQuery(name = "Contact.findall", query = "from Contact"),
	@NamedQuery(name = "Contact.byId", query = "select a from Contact a where a.id= :id")
})


@Entity
@Table(name = "contact")
public class Contact extends ModelBase {
	/**
	 * @generated
	 */
	public static final String SHIPTOADDRESS = "ShipToAddress";
	/**
	 * @generated
	 */
	public static final String FIRSTNAME = "FirstName";
	/**
	 * @generated
	 */
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String PARENTACCOUNT = "ParentAccount";
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
	public static final String CREDITCARD = "CreditCard";
	/**
	 * @generated
	 */
	public static final String MARKETING = "Marketing";
	/**
	 * @generated
	 */
	public static final String LASTNAME = "LastName";
	/**
	 * @generated
	 */
	public static final String JOBTITLE = "JobTitle";
	/**
	 * @generated
	 */
	public static final String SUFFIX = "Suffix";
	/**
	 * @generated
	 */
	public static final String PREFIX = "Prefix";
	/**
	 * @generated
	 */
	public static final String SALUTATION = "Salutation";
	/**
	 * @generated
	 */
	public static final String COMLINKS = "ComLinks";

	/**
	 * @generated
	 */
	public Contact() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Address shipToAddress;
	/**
	 * @generated
 	 */
	public Address getShipToAddress(){
		return shipToAddress; 
	}

	/**
	 * @generated
	 */	
	public void setShipToAddress(Address newVal) {
		this.shipToAddress = newVal;
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Account parentAccount;
	/**
	 * @generated
 	 */
	public Account getParentAccount(){
		return parentAccount; 
	}

	/**
	 * @generated
	 */	
	public void setParentAccount(Account newVal) {
		this.parentAccount = newVal;
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private CreditCard creditCard;
	/**
	 * @generated
 	 */
	public CreditCard getCreditCard(){
		return creditCard; 
	}

	/**
	 * @generated
	 */	
	public void setCreditCard(CreditCard newVal) {
		this.creditCard = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Marketing marketing;
	/**
	 * @generated
 	 */
	public Marketing getMarketing(){
		return marketing; 
	}

	/**
	 * @generated
	 */	
	public void setMarketing(Marketing newVal) {
		this.marketing = newVal;
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
 	
	
 	@Basic
	private String jobTitle;
	/**
	 * @generated
 	 */
	public String getJobTitle(){
		return jobTitle; 
	}

	/**
	 * @generated
	 */	
	public void setJobTitle(String newVal) {
		this.jobTitle = newVal;
	}
 	
	
 	@Basic
	private String suffix;
	/**
	 * @generated
 	 */
	public String getSuffix(){
		return suffix; 
	}

	/**
	 * @generated
	 */	
	public void setSuffix(String newVal) {
		this.suffix = newVal;
	}
 	
	
 	@Basic
	private String prefix;
	/**
	 * @generated
 	 */
	public String getPrefix(){
		return prefix; 
	}

	/**
	 * @generated
	 */	
	public void setPrefix(String newVal) {
		this.prefix = newVal;
	}
 	
	
 	@Basic
	private String salutation;
	/**
	 * @generated
 	 */
	public String getSalutation(){
		return salutation; 
	}

	/**
	 * @generated
	 */	
	public void setSalutation(String newVal) {
		this.salutation = newVal;
	}
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<ComLink> comLinks;
	/**
	 * @generated
 	 */
	public java.util.List<ComLink> getComLinks(){
		return comLinks; 
	}

	/**
	 * @generated
	 */	
	public void setComLinks(java.util.List<ComLink> newVal) {
		this.comLinks = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (SHIPTOADDRESS.equals(propertyName)) return getShipToAddress();
		if (FIRSTNAME.equals(propertyName)) return getFirstName();
		if (ADDRESS.equals(propertyName)) return getAddress();
		if (PARENTACCOUNT.equals(propertyName)) return getParentAccount();
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) return getWebAcctNameIncomplete();
		if (WEBCATALOGCHANGE.equals(propertyName)) return getWebCatalogChange();
		if (WEBSTATECHANGE.equals(propertyName)) return getWebStateChange();
		if (TRANSMITTED.equals(propertyName)) return getTransmitted();
		if (USECONTACTADDRESS.equals(propertyName)) return getUseContactAddress();
		if (ISINDIVIDUAL.equals(propertyName)) return getIsIndividual();
		if (DEFAULTSALESREP.equals(propertyName)) return getDefaultSalesRep();
		if (MAILERCAMPAIGNS.equals(propertyName)) return getMailerCampaigns();
		if (CREDITCARD.equals(propertyName)) return getCreditCard();
		if (MARKETING.equals(propertyName)) return getMarketing();
		if (LASTNAME.equals(propertyName)) return getLastName();
		if (JOBTITLE.equals(propertyName)) return getJobTitle();
		if (SUFFIX.equals(propertyName)) return getSuffix();
		if (PREFIX.equals(propertyName)) return getPrefix();
		if (SALUTATION.equals(propertyName)) return getSalutation();
		if (COMLINKS.equals(propertyName)) return getComLinks();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (SHIPTOADDRESS.equals(propertyName)) setShipToAddress((Address)newValue); else
		if (FIRSTNAME.equals(propertyName)) setFirstName((String)newValue); else
		if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
		if (PARENTACCOUNT.equals(propertyName)) setParentAccount((Account)newValue); else
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) setWebAcctNameIncomplete((Boolean)newValue); else
		if (WEBCATALOGCHANGE.equals(propertyName)) setWebCatalogChange((Boolean)newValue); else
		if (WEBSTATECHANGE.equals(propertyName)) setWebStateChange((Boolean)newValue); else
		if (TRANSMITTED.equals(propertyName)) setTransmitted((Boolean)newValue); else
		if (USECONTACTADDRESS.equals(propertyName)) setUseContactAddress((Boolean)newValue); else
		if (ISINDIVIDUAL.equals(propertyName)) setIsIndividual((Boolean)newValue); else
		if (DEFAULTSALESREP.equals(propertyName)) setDefaultSalesRep((SalesRep)newValue); else
		if (MAILERCAMPAIGNS.equals(propertyName)) setMailerCampaigns((Boolean)newValue); else
		if (CREDITCARD.equals(propertyName)) setCreditCard((CreditCard)newValue); else
		if (MARKETING.equals(propertyName)) setMarketing((Marketing)newValue); else
		if (LASTNAME.equals(propertyName)) setLastName((String)newValue); else
		if (JOBTITLE.equals(propertyName)) setJobTitle((String)newValue); else
		if (SUFFIX.equals(propertyName)) setSuffix((String)newValue); else
		if (PREFIX.equals(propertyName)) setPrefix((String)newValue); else
		if (SALUTATION.equals(propertyName)) setSalutation((String)newValue); else
		if (COMLINKS.equals(propertyName)) setComLinks((java.util.List<ComLink>)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (SHIPTOADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (FIRSTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (PARENTACCOUNT.equals(propertyName)) 
			return new Class<?>[] {Account.class};		
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WEBCATALOGCHANGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WEBSTATECHANGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TRANSMITTED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USECONTACTADDRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISINDIVIDUAL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DEFAULTSALESREP.equals(propertyName)) 
			return new Class<?>[] {SalesRep.class};		
		if (MAILERCAMPAIGNS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CREDITCARD.equals(propertyName)) 
			return new Class<?>[] {CreditCard.class};		
		if (MARKETING.equals(propertyName)) 
			return new Class<?>[] {Marketing.class};		
		if (LASTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (JOBTITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SUFFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PREFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALUTATION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COMLINKS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, ComLink.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (SHIPTOADDRESS.equals(propertyName)) return Contact.class;
		if (FIRSTNAME.equals(propertyName)) return Contact.class;
		if (ADDRESS.equals(propertyName)) return Contact.class;
		if (PARENTACCOUNT.equals(propertyName)) return Contact.class;
		if (WEBACCTNAMEINCOMPLETE.equals(propertyName)) return Contact.class;
		if (WEBCATALOGCHANGE.equals(propertyName)) return Contact.class;
		if (WEBSTATECHANGE.equals(propertyName)) return Contact.class;
		if (TRANSMITTED.equals(propertyName)) return Contact.class;
		if (USECONTACTADDRESS.equals(propertyName)) return Contact.class;
		if (ISINDIVIDUAL.equals(propertyName)) return Contact.class;
		if (DEFAULTSALESREP.equals(propertyName)) return Contact.class;
		if (MAILERCAMPAIGNS.equals(propertyName)) return Contact.class;
		if (CREDITCARD.equals(propertyName)) return Contact.class;
		if (MARKETING.equals(propertyName)) return Contact.class;
		if (LASTNAME.equals(propertyName)) return Contact.class;
		if (JOBTITLE.equals(propertyName)) return Contact.class;
		if (SUFFIX.equals(propertyName)) return Contact.class;
		if (PREFIX.equals(propertyName)) return Contact.class;
		if (SALUTATION.equals(propertyName)) return Contact.class;
		if (COMLINKS.equals(propertyName)) return Contact.class;
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
		if (! SmartEquals(getShipToAddress(), objT.getShipToAddress()))
			return false;
		if (! SmartEquals(getFirstName(), objT.getFirstName()))
			return false;
		if (! SmartEquals(getAddress(), objT.getAddress()))
			return false;
		if (! SmartEquals(getParentAccount(), objT.getParentAccount()))
			return false;
		if (! SmartEquals(getWebAcctNameIncomplete(), objT.getWebAcctNameIncomplete()))
			return false;
		if (! SmartEquals(getWebCatalogChange(), objT.getWebCatalogChange()))
			return false;
		if (! SmartEquals(getWebStateChange(), objT.getWebStateChange()))
			return false;
		if (! SmartEquals(getTransmitted(), objT.getTransmitted()))
			return false;
		if (! SmartEquals(getUseContactAddress(), objT.getUseContactAddress()))
			return false;
		if (! SmartEquals(getIsIndividual(), objT.getIsIndividual()))
			return false;
		if (! SmartEquals(getDefaultSalesRep(), objT.getDefaultSalesRep()))
			return false;
		if (! SmartEquals(getMailerCampaigns(), objT.getMailerCampaigns()))
			return false;
		if (! SmartEquals(getCreditCard(), objT.getCreditCard()))
			return false;
		if (! SmartEquals(getMarketing(), objT.getMarketing()))
			return false;
		if (! SmartEquals(getLastName(), objT.getLastName()))
			return false;
		if (! SmartEquals(getJobTitle(), objT.getJobTitle()))
			return false;
		if (! SmartEquals(getSuffix(), objT.getSuffix()))
			return false;
		if (! SmartEquals(getPrefix(), objT.getPrefix()))
			return false;
		if (! SmartEquals(getSalutation(), objT.getSalutation()))
			return false;
		if (! SmartEquals(getComLinks(), objT.getComLinks()))
			return false;
		return true;
	}			
}