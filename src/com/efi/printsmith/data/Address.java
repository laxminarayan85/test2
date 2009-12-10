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
	@NamedQuery(name = "Address.findall", query = "from Address"),
	@NamedQuery(name = "Address.byId", query = "select a from Address a where a.id= :id")
})


@Entity
@Table(name = "address")
public abstract class Address extends ModelBase {
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
	public Address() {
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private City city;
	/**
	 * @generated
 	 */
	public City getCity(){
		return city; 
	}

	/**
	 * @generated
	 */	
	public void setCity(City newVal) {
		this.city = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private State state;
	/**
	 * @generated
 	 */
	public State getState(){
		return state; 
	}

	/**
	 * @generated
	 */	
	public void setState(State newVal) {
		this.state = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Zip zip;
	/**
	 * @generated
 	 */
	public Zip getZip(){
		return zip; 
	}

	/**
	 * @generated
	 */	
	public void setZip(Zip newVal) {
		this.zip = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Country country;
	/**
	 * @generated
 	 */
	public Country getCountry(){
		return country; 
	}

	/**
	 * @generated
	 */	
	public void setCountry(Country newVal) {
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
		if (CITY.equals(propertyName)) setCity((City)newValue); else
		if (STATE.equals(propertyName)) setState((State)newValue); else
		if (ZIP.equals(propertyName)) setZip((Zip)newValue); else
		if (COUNTRY.equals(propertyName)) setCountry((Country)newValue); else
		if (ZONE.equals(propertyName)) setZone((String)newValue); else
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
			return new Class<?>[] {City.class};		
		if (STATE.equals(propertyName)) 
			return new Class<?>[] {State.class};		
		if (ZIP.equals(propertyName)) 
			return new Class<?>[] {Zip.class};		
		if (COUNTRY.equals(propertyName)) 
			return new Class<?>[] {Country.class};		
		if (ZONE.equals(propertyName)) 
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
		return true;
	}			
}