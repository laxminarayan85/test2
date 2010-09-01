
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
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.efi.printsmith.exceptions.PropertyException;
import com.efi.printsmith.exceptions.UnknownPropertyException;

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
@SQLDelete(sql="update addressformatting set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
  public static final String COUNTRYPOSITION = "CountryPosition";
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
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
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
  private Integer countryPosition;

	/**
   * @generated
 	 */
  public Integer getCountryPosition(){
    return countryPosition; 
  }


	/**
   * @generated
   */	
  public void setCountryPosition(Integer newVal) {
    this.countryPosition = newVal;
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
	
	private String street1Separator;
	
	private String street2Separator;
	
	private String stateSeparator;
	
	private String citySeparator;
	
	private String zipSeparator;
	
	private String countrySeparator;
	
	
	
	/**
	 * @return the street1Separator
	 */
	public String getStreet1Separator() {
		return street1Separator;
	}


	/**
	 * @param street1Separator the street1Separator to set
	 */
	public void setStreet1Separator(String street1Separator) {
		this.street1Separator = street1Separator;
	}


	/**
	 * @return the street2Separator
	 */
	public String getStreet2Separator() {
		return street2Separator;
	}


	/**
	 * @param street2Separator the street2Separator to set
	 */
	public void setStreet2Separator(String street2Separator) {
		this.street2Separator = street2Separator;
	}


	/**
	 * @return the stateSeparator
	 */
	public String getStateSeparator() {
		return stateSeparator;
	}


	/**
	 * @param stateSeparator the stateSeparator to set
	 */
	public void setStateSeparator(String stateSeparator) {
		this.stateSeparator = stateSeparator;
	}


	/**
	 * @return the citySeparator
	 */
	public String getCitySeparator() {
		return citySeparator;
	}


	/**
	 * @param citySeparator the citySeparator to set
	 */
	public void setCitySeparator(String citySeparator) {
		this.citySeparator = citySeparator;
	}


	/**
	 * @return the zipSeparator
	 */
	public String getZipSeparator() {
		return zipSeparator;
	}


	/**
	 * @param zipSeparator the zipSeparator to set
	 */
	public void setZipSeparator(String zipSeparator) {
		this.zipSeparator = zipSeparator;
	}


	/**
	 * @return the countrySeparator
	 */
	public String getCountrySeparator() {
		return countrySeparator;
	}


	/**
	 * @param countrySeparator the countrySeparator to set
	 */
	public void setCountrySeparator(String countrySeparator) {
		this.countrySeparator = countrySeparator;
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
    if (COUNTRYPOSITION.equals(propertyName)) return getCountryPosition();
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
    if (COUNTRYPOSITION.equals(propertyName)) setCountryPosition((Integer)newValue); else
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
    if (COUNTRYPOSITION.equals(propertyName)) 
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
    if (COUNTRYPOSITION.equals(propertyName)) return AddressFormatting.class;
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
    if (! SmartEquals(getCountryPosition(), objT.getCountryPosition()))
      return false;
    if (! SmartEquals(getZipPosition(), objT.getZipPosition()))
      return false;
    return true;
  }			
}
