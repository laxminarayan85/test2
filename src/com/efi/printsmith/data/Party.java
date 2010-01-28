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
	@NamedQuery(name = "Party.findall", query = "from Party"),
	@NamedQuery(name = "Party.byId", query = "select a from Party a where a.id= :id")
})


@Entity
@Table(name = "party")
public class Party extends ModelBase {
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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<ComLink> comLinks;
	/**
	 * @generated
 	 */
	public java.util.List<ComLink> getComLinks(){
		return comLinks; 
	}

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