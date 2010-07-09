
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
  @NamedQuery(name = "Party.findall", query = "from Party"),
  @NamedQuery(name = "Party.byId", query = "select a from Party a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "party")
public class Party extends ModelBase {
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
	public static final String SALUTATION = "Salutation";
	/**
	 * @generated
	 */
	public static final String JOBTITLE = "JobTitle";
	/**
	 * @generated
	 */
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String LASTNAME = "LastName";
	/**
	 * @generated
	 */
	public static final String FIRSTNAME = "FirstName";
	/**
	 * @generated
	 */
	public static final String COMLINKS = "ComLinks";

	/**
	 * @generated
	 */
	public Party() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
 	@ManyToOne( cascade = {CascadeType.ALL})
	@Basic
	private JobTitle jobTitle;
	
	/**
	 * @generated
 	 */
	public JobTitle getJobTitle(){
    return jobTitle; 
  }

	
	/**
   * @generated
   */	
  public void setJobTitle(JobTitle newVal) {
    this.jobTitle = newVal;
  }


	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL}, optional=true)
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
	
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "party_comlinks")
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
	public void addComLinks(ComLink obj) {
    if (comLinks == null) {
      comLinks = new java.util.ArrayList<ComLink>();
    }
    comLinks.add(obj);
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
    if (PREFIX.equals(propertyName)) return getPrefix();
    if (SUFFIX.equals(propertyName)) return getSuffix();
    if (SALUTATION.equals(propertyName)) return getSalutation();
    if (JOBTITLE.equals(propertyName)) return getJobTitle();
    if (ADDRESS.equals(propertyName)) return getAddress();
    if (LASTNAME.equals(propertyName)) return getLastName();
    if (FIRSTNAME.equals(propertyName)) return getFirstName();
    if (COMLINKS.equals(propertyName)) return getComLinks();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PREFIX.equals(propertyName)) setPrefix((String)newValue); else
    if (SUFFIX.equals(propertyName)) setSuffix((String)newValue); else
    if (SALUTATION.equals(propertyName)) setSalutation((String)newValue); else
    if (JOBTITLE.equals(propertyName)) setJobTitle((JobTitle)newValue); else
    if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
    if (LASTNAME.equals(propertyName)) setLastName((String)newValue); else
    if (FIRSTNAME.equals(propertyName)) setFirstName((String)newValue); else
    if (COMLINKS.equals(propertyName)) setComLinks((java.util.List<ComLink>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PREFIX.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SUFFIX.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALUTATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBTITLE.equals(propertyName)) 
      return new Class<?>[] {JobTitle.class};		
    if (ADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (LASTNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FIRSTNAME.equals(propertyName)) 
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
    if (PREFIX.equals(propertyName)) return Party.class;
    if (SUFFIX.equals(propertyName)) return Party.class;
    if (SALUTATION.equals(propertyName)) return Party.class;
    if (JOBTITLE.equals(propertyName)) return Party.class;
    if (ADDRESS.equals(propertyName)) return Party.class;
    if (LASTNAME.equals(propertyName)) return Party.class;
    if (FIRSTNAME.equals(propertyName)) return Party.class;
    if (COMLINKS.equals(propertyName)) return Party.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Party objT = (Party)obj;
    if (! SmartEquals(getPrefix(), objT.getPrefix()))
      return false;
    if (! SmartEquals(getSuffix(), objT.getSuffix()))
      return false;
    if (! SmartEquals(getSalutation(), objT.getSalutation()))
      return false;
    if (! SmartEquals(getJobTitle(), objT.getJobTitle()))
      return false;
    if (! SmartEquals(getAddress(), objT.getAddress()))
      return false;
    if (! SmartEquals(getLastName(), objT.getLastName()))
      return false;
    if (! SmartEquals(getFirstName(), objT.getFirstName()))
      return false;
    if (! SmartEquals(getComLinks(), objT.getComLinks()))
      return false;
    return true;
  }			
}
