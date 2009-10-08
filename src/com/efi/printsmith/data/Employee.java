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
	@NamedQuery(name = "Employee.findall", query = "from Employee"),
	@NamedQuery(name = "Employee.byId", query = "select a from Employee a where a.id= :id")
})


@Entity
@Table(name = "employee")
public class Employee extends ModelBase {
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
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String COMLINKS = "ComLinks";
	/**
	 * @generated
	 */
	public static final String SSN = "SSN";
	/**
	 * @generated
	 */
	public static final String EXPORTCODE = "ExportCode";
	/**
	 * @generated
	 */
	public static final String CLOCKIN = "ClockIn";
	/**
	 * @generated
	 */
	public static final String CLOCKOUT = "ClockOut";
	/**
	 * @generated
	 */
	public static final String CLOCKBREAK = "ClockBreak";

	/**
	 * @generated
	 */
	public Employee() {
		this.created = new Date();
		this.modified = new Date();
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
 	
	
 	@Basic
	private String sSN;
	/**
	 * @generated
 	 */
	public String getSSN(){
		return sSN; 
	}

	/**
	 * @generated
	 */	
	public void setSSN(String newVal) {
		this.sSN = newVal;
	}
 	
	
 	@Basic
	private Integer exportCode;
	/**
	 * @generated
 	 */
	public Integer getExportCode(){
		return exportCode; 
	}

	/**
	 * @generated
	 */	
	public void setExportCode(Integer newVal) {
		this.exportCode = newVal;
	}
 	
	
 	@Basic
	private Boolean clockIn;
	/**
	 * @generated
 	 */
	public Boolean getClockIn(){
		return clockIn; 
	}

	/**
	 * @generated
	 */	
	public void setClockIn(Boolean newVal) {
		this.clockIn = newVal;
	}
 	
	
 	@Basic
	private Boolean clockOut;
	/**
	 * @generated
 	 */
	public Boolean getClockOut(){
		return clockOut; 
	}

	/**
	 * @generated
	 */	
	public void setClockOut(Boolean newVal) {
		this.clockOut = newVal;
	}
 	
	
 	@Basic
	private Boolean clockBreak;
	/**
	 * @generated
 	 */
	public Boolean getClockBreak(){
		return clockBreak; 
	}

	/**
	 * @generated
	 */	
	public void setClockBreak(Boolean newVal) {
		this.clockBreak = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (FIRSTNAME.equals(propertyName)) return getFirstName();
		if (LASTNAME.equals(propertyName)) return getLastName();
		if (ADDRESS.equals(propertyName)) return getAddress();
		if (COMLINKS.equals(propertyName)) return getComLinks();
		if (SSN.equals(propertyName)) return getSSN();
		if (EXPORTCODE.equals(propertyName)) return getExportCode();
		if (CLOCKIN.equals(propertyName)) return getClockIn();
		if (CLOCKOUT.equals(propertyName)) return getClockOut();
		if (CLOCKBREAK.equals(propertyName)) return getClockBreak();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (FIRSTNAME.equals(propertyName)) setFirstName((String)newValue); else
		if (LASTNAME.equals(propertyName)) setLastName((String)newValue); else
		if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
		if (COMLINKS.equals(propertyName)) setComLinks((java.util.List<ComLink>)newValue); else
		if (SSN.equals(propertyName)) setSSN((String)newValue); else
		if (EXPORTCODE.equals(propertyName)) setExportCode((Integer)newValue); else
		if (CLOCKIN.equals(propertyName)) setClockIn((Boolean)newValue); else
		if (CLOCKOUT.equals(propertyName)) setClockOut((Boolean)newValue); else
		if (CLOCKBREAK.equals(propertyName)) setClockBreak((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (FIRSTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LASTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (COMLINKS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, ComLink.class};		
		if (SSN.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (EXPORTCODE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CLOCKIN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CLOCKOUT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CLOCKBREAK.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (FIRSTNAME.equals(propertyName)) return Employee.class;
		if (LASTNAME.equals(propertyName)) return Employee.class;
		if (ADDRESS.equals(propertyName)) return Employee.class;
		if (COMLINKS.equals(propertyName)) return Employee.class;
		if (SSN.equals(propertyName)) return Employee.class;
		if (EXPORTCODE.equals(propertyName)) return Employee.class;
		if (CLOCKIN.equals(propertyName)) return Employee.class;
		if (CLOCKOUT.equals(propertyName)) return Employee.class;
		if (CLOCKBREAK.equals(propertyName)) return Employee.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Employee objT = (Employee)obj;
		if (! SmartEquals(getFirstName(), objT.getFirstName()))
			return false;
		if (! SmartEquals(getLastName(), objT.getLastName()))
			return false;
		if (! SmartEquals(getAddress(), objT.getAddress()))
			return false;
		if (! SmartEquals(getComLinks(), objT.getComLinks()))
			return false;
		if (! SmartEquals(getSSN(), objT.getSSN()))
			return false;
		if (! SmartEquals(getExportCode(), objT.getExportCode()))
			return false;
		if (! SmartEquals(getClockIn(), objT.getClockIn()))
			return false;
		if (! SmartEquals(getClockOut(), objT.getClockOut()))
			return false;
		if (! SmartEquals(getClockBreak(), objT.getClockBreak()))
			return false;
		return true;
	}			
}