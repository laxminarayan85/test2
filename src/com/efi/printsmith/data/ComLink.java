package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
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
	@NamedQuery(name = "ComLink.findall", query = "from ComLink"),
	@NamedQuery(name = "ComLink.byId", query = "select a from ComLink a where a.id= :id")
})


@Entity
@Table(name = "comlink")
public class ComLink extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String VALUE = "Value";

	/**
	 * @generated
	 */
	public ComLink() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String type;
	/**
	 * @generated
 	 */
	public String getType(){
		return type; 
	}

	/**
	 * @generated
	 */	
	public void setType(String newVal) {
		this.type = newVal;
	}
 	
	
 	@Basic
	private String value;
	/**
	 * @generated
 	 */
	public String getValue(){
		return value; 
	}

	/**
	 * @generated
	 */	
	public void setValue(String newVal) {
		this.value = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TYPE.equals(propertyName)) return getType();
		if (VALUE.equals(propertyName)) return getValue();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TYPE.equals(propertyName)) setType((String)newValue); else
		if (VALUE.equals(propertyName)) setValue((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (VALUE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TYPE.equals(propertyName)) return ComLink.class;
		if (VALUE.equals(propertyName)) return ComLink.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ComLink objT = (ComLink)obj;
		if (! SmartEquals(getType(), objT.getType()))
			return false;
		if (! SmartEquals(getValue(), objT.getValue()))
			return false;
		return true;
	}			
}