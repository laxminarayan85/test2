
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "AddressFormatting.findall", query = "from AddressFormatting"),
  @NamedQuery(name = "AddressFormatting.byId", query = "select a from AddressFormatting a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "addressformatting")
public class AddressFormatting extends ModelBase {
	/**
	 * @generated
	 */
	public static final String COUNTRY = "Country";
	/**
	 * @generated
	 */
	public static final String STREET1POSITION = "Street1Position";
	/**
	 * @generated
	 */
	public static final String STREET2POSITION = "Street2Position";
	/**
	 * @generated
	 */
	public static final String CITYPOSITION = "CityPosition";
	/**
	 * @generated
	 */
	public static final String STATEPOSITION = "StatePosition";
	/**
	 * @generated
	 */
	public static final String COUNTYPOSITION = "CountyPosition";
	/**
	 * @generated
	 */
	public static final String ZIPPOSITION = "ZipPosition";

	/**
	 * @generated
	 */
	public AddressFormatting() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer street1Position;
	
	/**
	 * @generated
 	 */
	public Integer getStreet1Position(){
    return street1Position; 
  }

	
	/**
	 * @generated
	 */	
	public void setStreet1Position(Integer newVal) {
    this.street1Position = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer street2Position;
	
	/**
	 * @generated
 	 */
	public Integer getStreet2Position(){
    return street2Position; 
  }

	
	/**
	 * @generated
	 */	
	public void setStreet2Position(Integer newVal) {
    this.street2Position = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer cityPosition;
	
	/**
	 * @generated
 	 */
	public Integer getCityPosition(){
    return cityPosition; 
  }

	
	/**
	 * @generated
	 */	
	public void setCityPosition(Integer newVal) {
    this.cityPosition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer statePosition;
	
	/**
	 * @generated
 	 */
	public Integer getStatePosition(){
    return statePosition; 
  }

	
	/**
	 * @generated
	 */	
	public void setStatePosition(Integer newVal) {
    this.statePosition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer countyPosition;
	
	/**
	 * @generated
 	 */
	public Integer getCountyPosition(){
    return countyPosition; 
  }

	
	/**
	 * @generated
	 */	
	public void setCountyPosition(Integer newVal) {
    this.countyPosition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer zipPosition;
	
	/**
	 * @generated
 	 */
	public Integer getZipPosition(){
    return zipPosition; 
  }

	
	/**
	 * @generated
	 */	
	public void setZipPosition(Integer newVal) {
    this.zipPosition = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (COUNTRY.equals(propertyName)) return getCountry();
    if (STREET1POSITION.equals(propertyName)) return getStreet1Position();
    if (STREET2POSITION.equals(propertyName)) return getStreet2Position();
    if (CITYPOSITION.equals(propertyName)) return getCityPosition();
    if (STATEPOSITION.equals(propertyName)) return getStatePosition();
    if (COUNTYPOSITION.equals(propertyName)) return getCountyPosition();
    if (ZIPPOSITION.equals(propertyName)) return getZipPosition();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (COUNTRY.equals(propertyName)) setCountry((Country)newValue); else
    if (STREET1POSITION.equals(propertyName)) setStreet1Position((Integer)newValue); else
    if (STREET2POSITION.equals(propertyName)) setStreet2Position((Integer)newValue); else
    if (CITYPOSITION.equals(propertyName)) setCityPosition((Integer)newValue); else
    if (STATEPOSITION.equals(propertyName)) setStatePosition((Integer)newValue); else
    if (COUNTYPOSITION.equals(propertyName)) setCountyPosition((Integer)newValue); else
    if (ZIPPOSITION.equals(propertyName)) setZipPosition((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (COUNTRY.equals(propertyName)) 
      return new Class<?>[] {Country.class};		
    if (STREET1POSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STREET2POSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CITYPOSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STATEPOSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COUNTYPOSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ZIPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (COUNTRY.equals(propertyName)) return AddressFormatting.class;
    if (STREET1POSITION.equals(propertyName)) return AddressFormatting.class;
    if (STREET2POSITION.equals(propertyName)) return AddressFormatting.class;
    if (CITYPOSITION.equals(propertyName)) return AddressFormatting.class;
    if (STATEPOSITION.equals(propertyName)) return AddressFormatting.class;
    if (COUNTYPOSITION.equals(propertyName)) return AddressFormatting.class;
    if (ZIPPOSITION.equals(propertyName)) return AddressFormatting.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    AddressFormatting objT = (AddressFormatting)obj;
    if (! SmartEquals(getCountry(), objT.getCountry()))
      return false;
    if (! SmartEquals(getStreet1Position(), objT.getStreet1Position()))
      return false;
    if (! SmartEquals(getStreet2Position(), objT.getStreet2Position()))
      return false;
    if (! SmartEquals(getCityPosition(), objT.getCityPosition()))
      return false;
    if (! SmartEquals(getStatePosition(), objT.getStatePosition()))
      return false;
    if (! SmartEquals(getCountyPosition(), objT.getCountyPosition()))
      return false;
    if (! SmartEquals(getZipPosition(), objT.getZipPosition()))
      return false;
    return true;
  }			
}
