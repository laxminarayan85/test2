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
	@NamedQuery(name = "NotePad.findall", query = "from NotePad"),
	@NamedQuery(name = "NotePad.byId", query = "select a from NotePad a where a.id= :id")
})


@Entity
@Table(name = "notepad")
public class NotePad extends ModelBase {
	/**
	 * @generated
	 */
	public static final String WHO = "Who";
	/**
	 * @generated
	 */
	public static final String PHONENUMBER = "PhoneNumber";
	/**
	 * @generated
	 */
	public static final String WHAT = "What";
	/**
	 * @generated
	 */
	public static final String HOWMANY = "HowMany";
	/**
	 * @generated
	 */
	public static final String WHATSIZE = "WhatSize";
	/**
	 * @generated
	 */
	public static final String PAPER = "Paper";
	/**
	 * @generated
	 */
	public static final String NOTES = "Notes";
	/**
	 * @generated
	 */
	public static final String WHEN = "When";
	/**
	 * @generated
	 */
	public static final String SHOWONOPEN = "ShowOnOpen";

	/**
	 * @generated
	 */
	public NotePad() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String who;
	/**
	 * @generated
 	 */
	public String getWho(){
		return who; 
	}

	/**
	 * @generated
	 */	
	public void setWho(String newVal) {
		this.who = newVal;
	}
 	
	
 	@Basic
	private String phoneNumber;
	/**
	 * @generated
 	 */
	public String getPhoneNumber(){
		return phoneNumber; 
	}

	/**
	 * @generated
	 */	
	public void setPhoneNumber(String newVal) {
		this.phoneNumber = newVal;
	}
 	
	
 	@Basic
	private String what;
	/**
	 * @generated
 	 */
	public String getWhat(){
		return what; 
	}

	/**
	 * @generated
	 */	
	public void setWhat(String newVal) {
		this.what = newVal;
	}
 	
	
 	@Basic
	private String howMany;
	/**
	 * @generated
 	 */
	public String getHowMany(){
		return howMany; 
	}

	/**
	 * @generated
	 */	
	public void setHowMany(String newVal) {
		this.howMany = newVal;
	}
 	
	
 	@Basic
	private String whatSize;
	/**
	 * @generated
 	 */
	public String getWhatSize(){
		return whatSize; 
	}

	/**
	 * @generated
	 */	
	public void setWhatSize(String newVal) {
		this.whatSize = newVal;
	}
 	
	
 	@Basic
	private String paper;
	/**
	 * @generated
 	 */
	public String getPaper(){
		return paper; 
	}

	/**
	 * @generated
	 */	
	public void setPaper(String newVal) {
		this.paper = newVal;
	}
 	
	
 	@Basic
	private String notes;
	/**
	 * @generated
 	 */
	public String getNotes(){
		return notes; 
	}

	/**
	 * @generated
	 */	
	public void setNotes(String newVal) {
		this.notes = newVal;
	}
 	
	
 	@Basic
	private String when;
	/**
	 * @generated
 	 */
	public String getWhen(){
		return when; 
	}

	/**
	 * @generated
	 */	
	public void setWhen(String newVal) {
		this.when = newVal;
	}
 	
	
 	@Basic
	private Boolean showOnOpen;
	/**
	 * @generated
 	 */
	public Boolean getShowOnOpen(){
		return showOnOpen; 
	}

	/**
	 * @generated
	 */	
	public void setShowOnOpen(Boolean newVal) {
		this.showOnOpen = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (WHO.equals(propertyName)) return getWho();
		if (PHONENUMBER.equals(propertyName)) return getPhoneNumber();
		if (WHAT.equals(propertyName)) return getWhat();
		if (HOWMANY.equals(propertyName)) return getHowMany();
		if (WHATSIZE.equals(propertyName)) return getWhatSize();
		if (PAPER.equals(propertyName)) return getPaper();
		if (NOTES.equals(propertyName)) return getNotes();
		if (WHEN.equals(propertyName)) return getWhen();
		if (SHOWONOPEN.equals(propertyName)) return getShowOnOpen();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (WHO.equals(propertyName)) setWho((String)newValue); else
		if (PHONENUMBER.equals(propertyName)) setPhoneNumber((String)newValue); else
		if (WHAT.equals(propertyName)) setWhat((String)newValue); else
		if (HOWMANY.equals(propertyName)) setHowMany((String)newValue); else
		if (WHATSIZE.equals(propertyName)) setWhatSize((String)newValue); else
		if (PAPER.equals(propertyName)) setPaper((String)newValue); else
		if (NOTES.equals(propertyName)) setNotes((String)newValue); else
		if (WHEN.equals(propertyName)) setWhen((String)newValue); else
		if (SHOWONOPEN.equals(propertyName)) setShowOnOpen((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (WHO.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PHONENUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (WHAT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (HOWMANY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (WHATSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PAPER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (WHEN.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SHOWONOPEN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (WHO.equals(propertyName)) return NotePad.class;
		if (PHONENUMBER.equals(propertyName)) return NotePad.class;
		if (WHAT.equals(propertyName)) return NotePad.class;
		if (HOWMANY.equals(propertyName)) return NotePad.class;
		if (WHATSIZE.equals(propertyName)) return NotePad.class;
		if (PAPER.equals(propertyName)) return NotePad.class;
		if (NOTES.equals(propertyName)) return NotePad.class;
		if (WHEN.equals(propertyName)) return NotePad.class;
		if (SHOWONOPEN.equals(propertyName)) return NotePad.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		NotePad objT = (NotePad)obj;
		if (! SmartEquals(getWho(), objT.getWho()))
			return false;
		if (! SmartEquals(getPhoneNumber(), objT.getPhoneNumber()))
			return false;
		if (! SmartEquals(getWhat(), objT.getWhat()))
			return false;
		if (! SmartEquals(getHowMany(), objT.getHowMany()))
			return false;
		if (! SmartEquals(getWhatSize(), objT.getWhatSize()))
			return false;
		if (! SmartEquals(getPaper(), objT.getPaper()))
			return false;
		if (! SmartEquals(getNotes(), objT.getNotes()))
			return false;
		if (! SmartEquals(getWhen(), objT.getWhen()))
			return false;
		if (! SmartEquals(getShowOnOpen(), objT.getShowOnOpen()))
			return false;
		return true;
	}			
}