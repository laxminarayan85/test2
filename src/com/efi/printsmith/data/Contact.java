
package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
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
  @NamedQuery(name = "Contact.findall", query = "from Contact"),
  @NamedQuery(name = "Contact.byId", query = "select a from Contact a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "contact")
public class Contact extends Party {
	/**
	 * @generated
	 */
	public static final String SHIPTOADDRESS = "ShipToAddress";
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
	public static final String CAMPAIGNS = "Campaigns";
	/**
	 * @generated
	 */
	public static final String CONTACTID = "ContactId";
	/**
	 * @generated
	 */
	public static final String WEBACCESS = "WebAccess";
	/**
	 * @generated
	 */
	public static final String WEBREGISTERED = "WebRegistered";
	/**
	 * @generated
	 */
	public static final String WEBCONTACTID = "WebContactID";
	/**
	 * @generated
	 */
	public static final String WEBCATALOG = "WebCatalog";
	/**
	 * @generated
	 */
	public static final String WEBSTATUS = "WebStatus";

	/**
	 * @generated
	 */
	public Contact() {
    this.created = new Date();
    this.modified = new Date();
  }

	public Contact(long id, String firstName, String lastName, String accountID) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.contactId = accountID;
	}
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL} )
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL} )
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL} )
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
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @IndexColumn(name="campaignscontact")
    @JoinTable( name = "contact_campaigns")
	private java.util.List<Campaigns> campaigns;
	
	/**
	 * @generated
 	 */
	public java.util.List<Campaigns> getCampaigns(){
    return campaigns; 
  }

	/**
	 * @generated
	 */	
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
 	@Basic
	private String contactId;
	
	/**
	 * @generated
 	 */
	public String getContactId(){
    return contactId; 
  }

	
	/**
	 * @generated
	 */	
	public void setContactId(String newVal) {
    this.contactId = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean webAccess;
	
	/**
	 * @generated
 	 */
	public Boolean getWebAccess(){
    return webAccess; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebAccess(Boolean newVal) {
    this.webAccess = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean webRegistered;
	
	/**
	 * @generated
 	 */
	public Boolean getWebRegistered(){
    return webRegistered; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebRegistered(Boolean newVal) {
    this.webRegistered = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String webContactID;
	
	/**
	 * @generated
 	 */
	public String getWebContactID(){
    return webContactID; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebContactID(String newVal) {
    this.webContactID = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private WebCatalogs webCatalog;
	
	/**
	 * @generated
 	 */
	public WebCatalogs getWebCatalog(){
    return webCatalog; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebCatalog(WebCatalogs newVal) {
    this.webCatalog = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private WebStatus webStatus;
	
	/**
	 * @generated
 	 */
	public WebStatus getWebStatus(){
    return webStatus; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebStatus(WebStatus newVal) {
    this.webStatus = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (SHIPTOADDRESS.equals(propertyName)) return getShipToAddress();
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
    if (CAMPAIGNS.equals(propertyName)) return getCampaigns();
    if (CONTACTID.equals(propertyName)) return getContactId();
    if (WEBACCESS.equals(propertyName)) return getWebAccess();
    if (WEBREGISTERED.equals(propertyName)) return getWebRegistered();
    if (WEBCONTACTID.equals(propertyName)) return getWebContactID();
    if (WEBCATALOG.equals(propertyName)) return getWebCatalog();
    if (WEBSTATUS.equals(propertyName)) return getWebStatus();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SHIPTOADDRESS.equals(propertyName)) setShipToAddress((Address)newValue); else
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
    if (CAMPAIGNS.equals(propertyName)) setCampaigns((java.util.List<Campaigns>)newValue); else
    if (CONTACTID.equals(propertyName)) setContactId((String)newValue); else
    if (WEBACCESS.equals(propertyName)) setWebAccess((Boolean)newValue); else
    if (WEBREGISTERED.equals(propertyName)) setWebRegistered((Boolean)newValue); else
    if (WEBCONTACTID.equals(propertyName)) setWebContactID((String)newValue); else
    if (WEBCATALOG.equals(propertyName)) setWebCatalog((WebCatalogs)newValue); else
    if (WEBSTATUS.equals(propertyName)) setWebStatus((WebStatus)newValue); else
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
    if (CAMPAIGNS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, Campaigns.class};		
    if (CONTACTID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBACCESS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WEBREGISTERED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WEBCONTACTID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBCATALOG.equals(propertyName)) 
      return new Class<?>[] {WebCatalogs.class};		
    if (WEBSTATUS.equals(propertyName)) 
      return new Class<?>[] {WebStatus.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (SHIPTOADDRESS.equals(propertyName)) return Contact.class;
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
    if (CAMPAIGNS.equals(propertyName)) return Contact.class;
    if (CONTACTID.equals(propertyName)) return Contact.class;
    if (WEBACCESS.equals(propertyName)) return Contact.class;
    if (WEBREGISTERED.equals(propertyName)) return Contact.class;
    if (WEBCONTACTID.equals(propertyName)) return Contact.class;
    if (WEBCATALOG.equals(propertyName)) return Contact.class;
    if (WEBSTATUS.equals(propertyName)) return Contact.class;
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
    if (! SmartEquals(getCampaigns(), objT.getCampaigns()))
      return false;
    if (! SmartEquals(getContactId(), objT.getContactId()))
      return false;
    if (! SmartEquals(getWebAccess(), objT.getWebAccess()))
      return false;
    if (! SmartEquals(getWebRegistered(), objT.getWebRegistered()))
      return false;
    if (! SmartEquals(getWebContactID(), objT.getWebContactID()))
      return false;
    if (! SmartEquals(getWebCatalog(), objT.getWebCatalog()))
      return false;
    if (! SmartEquals(getWebStatus(), objT.getWebStatus()))
      return false;
    return true;
  }			
}
