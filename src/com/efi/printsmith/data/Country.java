
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
  @NamedQuery(name = "Country.findall", query = "from Country"),
  @NamedQuery(name = "Country.byId", query = "select a from Country a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "country")
@SQLDelete(sql="update country set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class Country extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	
	public static final String ADDRESSFORMATTINGS = "AddressFormattings";

	/**
	 * @generated
	 */
	public Country() {
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
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="country", fetch=FetchType.EAGER)
    @JoinTable( name = "addressformatting")
	private List<AddressFormatting> addressFormattings;
	
	public List<AddressFormatting> getAddressFormattings(){
		return this.addressFormattings; 
	}
	
	public void addAddressFormattings(AddressFormatting obj) {
	    if (addressFormattings == null) {
	    	addressFormattings = new java.util.ArrayList<AddressFormatting>();
	    }
	    addressFormattings.add(obj);
	}
	
	public void setAddressFormattings(List<AddressFormatting> newVal){
		this.addressFormattings = newVal;
	}
	
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
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
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return Country.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Country objT = (Country)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    return true;
  }			
}
