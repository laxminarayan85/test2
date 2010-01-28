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
	@NamedQuery(name = "PreferencesSequenceValues.findall", query = "from PreferencesSequenceValues"),
	@NamedQuery(name = "PreferencesSequenceValues.byId", query = "select a from PreferencesSequenceValues a where a.id= :id")
})


@Entity
@Table(name = "preferencessequencevalues")
public class PreferencesSequenceValues extends ModelBase {
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String JOB = "Job";
	/**
	 * @generated
	 */
	public static final String PRESSDEFINITION = "PressDefinition";
	/**
	 * @generated
	 */
	public static final String CHARGEDEFINITION = "ChargeDefinition";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String STOCKDEFINITION = "StockDefinition";

	/**
	 * @generated
	 */
	public PreferencesSequenceValues() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Long invoice;
	/**
	 * @generated
 	 */
	public Long getInvoice(){
		return invoice; 
	}

	/**
	 * @generated
	 */	
	public void setInvoice(Long newVal) {
		this.invoice = newVal;
	}
 	
	
 	@Basic
	private Long job;
	/**
	 * @generated
 	 */
	public Long getJob(){
		return job; 
	}

	/**
	 * @generated
	 */	
	public void setJob(Long newVal) {
		this.job = newVal;
	}
 	
	
 	@Basic
	private Long pressDefinition;
	/**
	 * @generated
 	 */
	public Long getPressDefinition(){
		return pressDefinition; 
	}

	/**
	 * @generated
	 */	
	public void setPressDefinition(Long newVal) {
		this.pressDefinition = newVal;
	}
 	
	
 	@Basic
	private Long chargeDefinition;
	/**
	 * @generated
 	 */
	public Long getChargeDefinition(){
		return chargeDefinition; 
	}

	/**
	 * @generated
	 */	
	public void setChargeDefinition(Long newVal) {
		this.chargeDefinition = newVal;
	}
 	
	
 	@Basic
	private Long account;
	/**
	 * @generated
 	 */
	public Long getAccount(){
		return account; 
	}

	/**
	 * @generated
	 */	
	public void setAccount(Long newVal) {
		this.account = newVal;
	}
 	
	
 	@Basic
	private Long contact;
	/**
	 * @generated
 	 */
	public Long getContact(){
		return contact; 
	}

	/**
	 * @generated
	 */	
	public void setContact(Long newVal) {
		this.contact = newVal;
	}
 	
	
 	@Basic
	private Long stockDefinition;
	/**
	 * @generated
 	 */
	public Long getStockDefinition(){
		return stockDefinition; 
	}

	/**
	 * @generated
	 */	
	public void setStockDefinition(Long newVal) {
		this.stockDefinition = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (INVOICE.equals(propertyName)) return getInvoice();
		if (JOB.equals(propertyName)) return getJob();
		if (PRESSDEFINITION.equals(propertyName)) return getPressDefinition();
		if (CHARGEDEFINITION.equals(propertyName)) return getChargeDefinition();
		if (ACCOUNT.equals(propertyName)) return getAccount();
		if (CONTACT.equals(propertyName)) return getContact();
		if (STOCKDEFINITION.equals(propertyName)) return getStockDefinition();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (INVOICE.equals(propertyName)) setInvoice((Long)newValue); else
		if (JOB.equals(propertyName)) setJob((Long)newValue); else
		if (PRESSDEFINITION.equals(propertyName)) setPressDefinition((Long)newValue); else
		if (CHARGEDEFINITION.equals(propertyName)) setChargeDefinition((Long)newValue); else
		if (ACCOUNT.equals(propertyName)) setAccount((Long)newValue); else
		if (CONTACT.equals(propertyName)) setContact((Long)newValue); else
		if (STOCKDEFINITION.equals(propertyName)) setStockDefinition((Long)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (INVOICE.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (JOB.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PRESSDEFINITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CHARGEDEFINITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ACCOUNT.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CONTACT.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (STOCKDEFINITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (INVOICE.equals(propertyName)) return PreferencesSequenceValues.class;
		if (JOB.equals(propertyName)) return PreferencesSequenceValues.class;
		if (PRESSDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
		if (CHARGEDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
		if (ACCOUNT.equals(propertyName)) return PreferencesSequenceValues.class;
		if (CONTACT.equals(propertyName)) return PreferencesSequenceValues.class;
		if (STOCKDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesSequenceValues objT = (PreferencesSequenceValues)obj;
		if (! SmartEquals(getInvoice(), objT.getInvoice()))
			return false;
		if (! SmartEquals(getJob(), objT.getJob()))
			return false;
		if (! SmartEquals(getPressDefinition(), objT.getPressDefinition()))
			return false;
		if (! SmartEquals(getChargeDefinition(), objT.getChargeDefinition()))
			return false;
		if (! SmartEquals(getAccount(), objT.getAccount()))
			return false;
		if (! SmartEquals(getContact(), objT.getContact()))
			return false;
		if (! SmartEquals(getStockDefinition(), objT.getStockDefinition()))
			return false;
		return true;
	}			
}