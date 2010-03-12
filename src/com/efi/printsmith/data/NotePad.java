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
	public static final String NOTESWHO = "NotesWho";
	/**
	 * @generated
	 */
	public static final String PHONENUMBER = "PhoneNumber";
	/**
	 * @generated
	 */
	public static final String NOTESWHAT = "NotesWhat";
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
	public static final String NOTESWHEN = "NotesWhen";
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
	private String notesWho;
	
	/**
	 * @generated
 	 */
	public String getNotesWho(){
		return notesWho; 
	}

	/**
	 * @generated
	 */	
	public void setNotesWho(String newVal) {
		this.notesWho = newVal;
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
	private String notesWhat;
	
	/**
	 * @generated
 	 */
	public String getNotesWhat(){
		return notesWhat; 
	}

	/**
	 * @generated
	 */	
	public void setNotesWhat(String newVal) {
		this.notesWhat = newVal;
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
	private String notesWhen;
	
	/**
	 * @generated
 	 */
	public String getNotesWhen(){
		return notesWhen; 
	}

	/**
	 * @generated
	 */	
	public void setNotesWhen(String newVal) {
		this.notesWhen = newVal;
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
		if (NOTESWHO.equals(propertyName)) return getNotesWho();
		if (PHONENUMBER.equals(propertyName)) return getPhoneNumber();
		if (NOTESWHAT.equals(propertyName)) return getNotesWhat();
		if (HOWMANY.equals(propertyName)) return getHowMany();
		if (WHATSIZE.equals(propertyName)) return getWhatSize();
		if (PAPER.equals(propertyName)) return getPaper();
		if (NOTES.equals(propertyName)) return getNotes();
		if (NOTESWHEN.equals(propertyName)) return getNotesWhen();
		if (SHOWONOPEN.equals(propertyName)) return getShowOnOpen();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NOTESWHO.equals(propertyName)) setNotesWho((String)newValue); else
		if (PHONENUMBER.equals(propertyName)) setPhoneNumber((String)newValue); else
		if (NOTESWHAT.equals(propertyName)) setNotesWhat((String)newValue); else
		if (HOWMANY.equals(propertyName)) setHowMany((String)newValue); else
		if (WHATSIZE.equals(propertyName)) setWhatSize((String)newValue); else
		if (PAPER.equals(propertyName)) setPaper((String)newValue); else
		if (NOTES.equals(propertyName)) setNotes((String)newValue); else
		if (NOTESWHEN.equals(propertyName)) setNotesWhen((String)newValue); else
		if (SHOWONOPEN.equals(propertyName)) setShowOnOpen((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (NOTESWHO.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PHONENUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTESWHAT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (HOWMANY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (WHATSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PAPER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTESWHEN.equals(propertyName)) 
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
		if (NOTESWHO.equals(propertyName)) return NotePad.class;
		if (PHONENUMBER.equals(propertyName)) return NotePad.class;
		if (NOTESWHAT.equals(propertyName)) return NotePad.class;
		if (HOWMANY.equals(propertyName)) return NotePad.class;
		if (WHATSIZE.equals(propertyName)) return NotePad.class;
		if (PAPER.equals(propertyName)) return NotePad.class;
		if (NOTES.equals(propertyName)) return NotePad.class;
		if (NOTESWHEN.equals(propertyName)) return NotePad.class;
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
		if (! SmartEquals(getNotesWho(), objT.getNotesWho()))
			return false;
		if (! SmartEquals(getPhoneNumber(), objT.getPhoneNumber()))
			return false;
		if (! SmartEquals(getNotesWhat(), objT.getNotesWhat()))
			return false;
		if (! SmartEquals(getHowMany(), objT.getHowMany()))
			return false;
		if (! SmartEquals(getWhatSize(), objT.getWhatSize()))
			return false;
		if (! SmartEquals(getPaper(), objT.getPaper()))
			return false;
		if (! SmartEquals(getNotes(), objT.getNotes()))
			return false;
		if (! SmartEquals(getNotesWhen(), objT.getNotesWhen()))
			return false;
		if (! SmartEquals(getShowOnOpen(), objT.getShowOnOpen()))
			return false;
		return true;
	}			
}