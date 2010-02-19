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
	@NamedQuery(name = "PricingRecord.findall", query = "from PricingRecord"),
	@NamedQuery(name = "PricingRecord.byId", query = "select a from PricingRecord a where a.id= :id")
})


@Entity
@Table(name = "pricingrecord")
public class PricingRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String PRICELOGENTRY = "PriceLogEntry";

	/**
	 * @generated
	 */
	public PricingRecord() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PriceLogEntry priceLogEntry;
	/**
	 * @generated
 	 */
	public PriceLogEntry getPriceLogEntry(){
		return priceLogEntry; 
	}

	/**
	 * @generated
	 */	
	public void setPriceLogEntry(PriceLogEntry newVal) {
		this.priceLogEntry = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (PRICELOGENTRY.equals(propertyName)) return getPriceLogEntry();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (PRICELOGENTRY.equals(propertyName)) setPriceLogEntry((PriceLogEntry)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (PRICELOGENTRY.equals(propertyName)) 
			return new Class<?>[] {PriceLogEntry.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (PRICELOGENTRY.equals(propertyName)) return PricingRecord.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PricingRecord objT = (PricingRecord)obj;
		if (! SmartEquals(getPriceLogEntry(), objT.getPriceLogEntry()))
			return false;
		return true;
	}			
}