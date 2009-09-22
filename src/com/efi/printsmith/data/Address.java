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
	@NamedQuery(name = "address.findall", query = "from address"),
	@NamedQuery(name = "address.byId", query = "select a from address a where a.id= :id")
})


@Entity
@Table(name = "address")
public class Address extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String STREET1 = "Street1";
	/**
	 * @generated
	 */
	public static final String STREET2 = "Street2";
	/**
	 * @generated
	 */
	public static final String CITY = "City";
	/**
	 * @generated
	 */
	public static final String STATE = "State";
	/**
	 * @generated
	 */
	public static final String ZIP = "Zip";
	/**
	 * @generated
	 */
	public static final String COUNTRY = "Country";
	/**
	 * @generated
	 */
	public static final String ZONE = "Zone";
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
	public static final String JOBTITLE = "JobTitle";
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
	public static final String PREFIX = "Prefix";
	/**
	 * @generated
	 */
	public static final String SUFFIX = "Suffix";
	/**
	 * @generated
	 */
	public static final String TAKENBY = "TakenBy";

	/**
	 * @generated
	 */
	public Address() {
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
	private String street1;
	/**
	 * @generated
 	 */
	public String getStreet1(){
		return street1; 
	}

	/**
	 * @generated
	 */	
	public void setStreet1(String newVal) {
		this.street1 = newVal;
	}
 	
	
 	@Basic
	private String street2;
	/**
	 * @generated
 	 */
	public String getStreet2(){
		return street2; 
	}

	/**
	 * @generated
	 */	
	public void setStreet2(String newVal) {
		this.street2 = newVal;
	}
 	
	
 	@Basic
	private String city;
	/**
	 * @generated
 	 */
	public String getCity(){
		return city; 
	}

	/**
	 * @generated
	 */	
	public void setCity(String newVal) {
		this.city = newVal;
	}
 	
	
 	@Basic
	private String state;
	/**
	 * @generated
 	 */
	public String getState(){
		return state; 
	}

	/**
	 * @generated
	 */	
	public void setState(String newVal) {
		this.state = newVal;
	}
 	
	
 	@Basic
	private String zip;
	/**
	 * @generated
 	 */
	public String getZip(){
		return zip; 
	}

	/**
	 * @generated
	 */	
	public void setZip(String newVal) {
		this.zip = newVal;
	}
 	
	
 	@Basic
	private String country;
	/**
	 * @generated
 	 */
	public String getCountry(){
		return country; 
	}

	/**
	 * @generated
	 */	
	public void setCountry(String newVal) {
		this.country = newVal;
	}
 	
	
 	@Basic
	private String zone;
	/**
	 * @generated
 	 */
	public String getZone(){
		return zone; 
	}

	/**
	 * @generated
	 */	
	public void setZone(String newVal) {
		this.zone = newVal;
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
 	
	
    @OneToMany
	private java.util.List<Address> comLinks;
	/**
	 * @generated
 	 */
	public java.util.List<Address> getComLinks(){
		return comLinks; 
	}

	/**
	 * @generated
	 */	
	public void setComLinks(java.util.List<Address> newVal) {
		this.comLinks = newVal;
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
	private String takenBy;
	/**
	 * @generated
 	 */
	public String getTakenBy(){
		return takenBy; 
	}

	/**
	 * @generated
	 */	
	public void setTakenBy(String newVal) {
		this.takenBy = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (STREET1.equals(propertyName)) return getStreet1();
		if (STREET2.equals(propertyName)) return getStreet2();
		if (CITY.equals(propertyName)) return getCity();
		if (STATE.equals(propertyName)) return getState();
		if (ZIP.equals(propertyName)) return getZip();
		if (COUNTRY.equals(propertyName)) return getCountry();
		if (ZONE.equals(propertyName)) return getZone();
		if (FIRSTNAME.equals(propertyName)) return getFirstName();
		if (LASTNAME.equals(propertyName)) return getLastName();
		if (JOBTITLE.equals(propertyName)) return getJobTitle();
		if (SALUTATION.equals(propertyName)) return getSalutation();
		if (COMLINKS.equals(propertyName)) return getComLinks();
		if (PREFIX.equals(propertyName)) return getPrefix();
		if (SUFFIX.equals(propertyName)) return getSuffix();
		if (TAKENBY.equals(propertyName)) return getTakenBy();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (STREET1.equals(propertyName)) setStreet1((String)newValue); else
		if (STREET2.equals(propertyName)) setStreet2((String)newValue); else
		if (CITY.equals(propertyName)) setCity((String)newValue); else
		if (STATE.equals(propertyName)) setState((String)newValue); else
		if (ZIP.equals(propertyName)) setZip((String)newValue); else
		if (COUNTRY.equals(propertyName)) setCountry((String)newValue); else
		if (ZONE.equals(propertyName)) setZone((String)newValue); else
		if (FIRSTNAME.equals(propertyName)) setFirstName((String)newValue); else
		if (LASTNAME.equals(propertyName)) setLastName((String)newValue); else
		if (JOBTITLE.equals(propertyName)) setJobTitle((String)newValue); else
		if (SALUTATION.equals(propertyName)) setSalutation((String)newValue); else
		if (COMLINKS.equals(propertyName)) setComLinks((java.util.List<Address>)newValue); else
		if (PREFIX.equals(propertyName)) setPrefix((String)newValue); else
		if (SUFFIX.equals(propertyName)) setSuffix((String)newValue); else
		if (TAKENBY.equals(propertyName)) setTakenBy((String)newValue); else
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
		if (STREET1.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STREET2.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CITY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STATE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ZIP.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COUNTRY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ZONE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FIRSTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LASTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (JOBTITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALUTATION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COMLINKS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Address.class};		
		if (PREFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SUFFIX.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TAKENBY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return Address.class;
		if (STREET1.equals(propertyName)) return Address.class;
		if (STREET2.equals(propertyName)) return Address.class;
		if (CITY.equals(propertyName)) return Address.class;
		if (STATE.equals(propertyName)) return Address.class;
		if (ZIP.equals(propertyName)) return Address.class;
		if (COUNTRY.equals(propertyName)) return Address.class;
		if (ZONE.equals(propertyName)) return Address.class;
		if (FIRSTNAME.equals(propertyName)) return Address.class;
		if (LASTNAME.equals(propertyName)) return Address.class;
		if (JOBTITLE.equals(propertyName)) return Address.class;
		if (SALUTATION.equals(propertyName)) return Address.class;
		if (COMLINKS.equals(propertyName)) return Address.class;
		if (PREFIX.equals(propertyName)) return Address.class;
		if (SUFFIX.equals(propertyName)) return Address.class;
		if (TAKENBY.equals(propertyName)) return Address.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Address objT = (Address)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getStreet1(), objT.getStreet1()))
			return false;
		if (! SmartEquals(getStreet2(), objT.getStreet2()))
			return false;
		if (! SmartEquals(getCity(), objT.getCity()))
			return false;
		if (! SmartEquals(getState(), objT.getState()))
			return false;
		if (! SmartEquals(getZip(), objT.getZip()))
			return false;
		if (! SmartEquals(getCountry(), objT.getCountry()))
			return false;
		if (! SmartEquals(getZone(), objT.getZone()))
			return false;
		if (! SmartEquals(getFirstName(), objT.getFirstName()))
			return false;
		if (! SmartEquals(getLastName(), objT.getLastName()))
			return false;
		if (! SmartEquals(getJobTitle(), objT.getJobTitle()))
			return false;
		if (! SmartEquals(getSalutation(), objT.getSalutation()))
			return false;
		if (! SmartEquals(getComLinks(), objT.getComLinks()))
			return false;
		if (! SmartEquals(getPrefix(), objT.getPrefix()))
			return false;
		if (! SmartEquals(getSuffix(), objT.getSuffix()))
			return false;
		if (! SmartEquals(getTakenBy(), objT.getTakenBy()))
			return false;
		return true;
	}			
}