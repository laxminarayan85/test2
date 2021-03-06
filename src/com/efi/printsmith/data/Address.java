
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "Address.findall", query = "from Address"),
  @NamedQuery(name = "Address.byId", query = "select a from Address a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "address")
@SQLDelete(sql="update address set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
	public Address() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	@Basic
  private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
    return isDeleted;
  }


	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }



	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
    if (CITY.equals(propertyName)) setCity((String)newValue); else
    if (STATE.equals(propertyName)) setState((String)newValue); else
    if (ZIP.equals(propertyName)) setZip((String)newValue); else
    if (COUNTRY.equals(propertyName)) setCountry((String)newValue); else
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
      return new Class<?>[] {String.class};		
    if (STATE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ZIP.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COUNTRY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
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
