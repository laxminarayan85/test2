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
	@NamedQuery(name = "ShippingCharge.findall", query = "from ShippingCharge"),
	@NamedQuery(name = "ShippingCharge.byId", query = "select a from ShippingCharge a where a.id= :id")
})


@Entity
@Table(name = "shippingcharge")
public class ShippingCharge extends Charge {
	/**
	 * @generated
	 */
	public static final String SHIPVIA = "ShipVia";
	/**
	 * @generated
	 */
	public static final String SHIPTO = "ShipTo";

	/**
	 * @generated
	 */
	public ShippingCharge() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String shipVia;
	
	/**
	 * @generated
 	 */
	public String getShipVia(){
		return shipVia; 
	}

	/**
	 * @generated
	 */	
	public void setShipVia(String newVal) {
		this.shipVia = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Address shipTo;
	
	/**
	 * @generated
 	 */
	public Address getShipTo(){
		return shipTo; 
	}

	/**
	 * @generated
	 */	
	public void setShipTo(Address newVal) {
		this.shipTo = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (SHIPVIA.equals(propertyName)) return getShipVia();
		if (SHIPTO.equals(propertyName)) return getShipTo();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (SHIPVIA.equals(propertyName)) setShipVia((String)newValue); else
		if (SHIPTO.equals(propertyName)) setShipTo((Address)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (SHIPVIA.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SHIPTO.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (SHIPVIA.equals(propertyName)) return ShippingCharge.class;
		if (SHIPTO.equals(propertyName)) return ShippingCharge.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ShippingCharge objT = (ShippingCharge)obj;
		if (! SmartEquals(getShipVia(), objT.getShipVia()))
			return false;
		if (! SmartEquals(getShipTo(), objT.getShipTo()))
			return false;
		return true;
	}			
}