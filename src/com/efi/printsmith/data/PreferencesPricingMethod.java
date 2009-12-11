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
	@NamedQuery(name = "PreferencesPricingMethod.findall", query = "from PreferencesPricingMethod"),
	@NamedQuery(name = "PreferencesPricingMethod.byId", query = "select a from PreferencesPricingMethod a where a.id= :id")
})


@Entity
@Table(name = "preferencespricingmethod")
public class PreferencesPricingMethod extends ModelBase {
	/**
	 * @generated
	 */
	public static final String USED = "Used";
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String ABBREVIATION = "Abbreviation";
	/**
	 * @generated
	 */
	public static final String BROKERED = "Brokered";
	/**
	 * @generated
	 */
	public static final String TAXABLE = "Taxable";
	/**
	 * @generated
	 */
	public static final String FINISHED = "Finished";
	/**
	 * @generated
	 */
	public static final String SHOWNOTES = "ShowNotes";
	/**
	 * @generated
	 */
	public static final String CATEGORY = "Category";
	/**
	 * @generated
	 */
	public static final String ESTIMATOR = "Estimator";

	/**
	 * @generated
	 */
	public PreferencesPricingMethod() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Boolean used;
	/**
	 * @generated
 	 */
	public Boolean getUsed(){
		return used; 
	}

	/**
	 * @generated
	 */	
	public void setUsed(Boolean newVal) {
		this.used = newVal;
	}
 	
	
 	@Basic
	private String title;
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
 	
	
 	@Basic
	private String abbreviation;
	/**
	 * @generated
 	 */
	public String getAbbreviation(){
		return abbreviation; 
	}

	/**
	 * @generated
	 */	
	public void setAbbreviation(String newVal) {
		this.abbreviation = newVal;
	}
 	
	
 	@Basic
	private Boolean brokered;
	/**
	 * @generated
 	 */
	public Boolean getBrokered(){
		return brokered; 
	}

	/**
	 * @generated
	 */	
	public void setBrokered(Boolean newVal) {
		this.brokered = newVal;
	}
 	
	
 	@Basic
	private Boolean taxable;
	/**
	 * @generated
 	 */
	public Boolean getTaxable(){
		return taxable; 
	}

	/**
	 * @generated
	 */	
	public void setTaxable(Boolean newVal) {
		this.taxable = newVal;
	}
 	
	
 	@Basic
	private Boolean finished;
	/**
	 * @generated
 	 */
	public Boolean getFinished(){
		return finished; 
	}

	/**
	 * @generated
	 */	
	public void setFinished(Boolean newVal) {
		this.finished = newVal;
	}
 	
	
 	@Basic
	private Boolean showNotes;
	/**
	 * @generated
 	 */
	public Boolean getShowNotes(){
		return showNotes; 
	}

	/**
	 * @generated
	 */	
	public void setShowNotes(Boolean newVal) {
		this.showNotes = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private SalesCategory category;
	/**
	 * @generated
 	 */
	public SalesCategory getCategory(){
		return category; 
	}

	/**
	 * @generated
	 */	
	public void setCategory(SalesCategory newVal) {
		this.category = newVal;
	}
 	
	
 	@Basic
	private String estimator;
	/**
	 * @generated
 	 */
	public String getEstimator(){
		return estimator; 
	}

	/**
	 * @generated
	 */	
	public void setEstimator(String newVal) {
		this.estimator = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (USED.equals(propertyName)) return getUsed();
		if (TITLE.equals(propertyName)) return getTitle();
		if (ABBREVIATION.equals(propertyName)) return getAbbreviation();
		if (BROKERED.equals(propertyName)) return getBrokered();
		if (TAXABLE.equals(propertyName)) return getTaxable();
		if (FINISHED.equals(propertyName)) return getFinished();
		if (SHOWNOTES.equals(propertyName)) return getShowNotes();
		if (CATEGORY.equals(propertyName)) return getCategory();
		if (ESTIMATOR.equals(propertyName)) return getEstimator();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (USED.equals(propertyName)) setUsed((Boolean)newValue); else
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (ABBREVIATION.equals(propertyName)) setAbbreviation((String)newValue); else
		if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else
		if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
		if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else
		if (SHOWNOTES.equals(propertyName)) setShowNotes((Boolean)newValue); else
		if (CATEGORY.equals(propertyName)) setCategory((SalesCategory)newValue); else
		if (ESTIMATOR.equals(propertyName)) setEstimator((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (USED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ABBREVIATION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (BROKERED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FINISHED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWNOTES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CATEGORY.equals(propertyName)) 
			return new Class<?>[] {SalesCategory.class};		
		if (ESTIMATOR.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (USED.equals(propertyName)) return PreferencesPricingMethod.class;
		if (TITLE.equals(propertyName)) return PreferencesPricingMethod.class;
		if (ABBREVIATION.equals(propertyName)) return PreferencesPricingMethod.class;
		if (BROKERED.equals(propertyName)) return PreferencesPricingMethod.class;
		if (TAXABLE.equals(propertyName)) return PreferencesPricingMethod.class;
		if (FINISHED.equals(propertyName)) return PreferencesPricingMethod.class;
		if (SHOWNOTES.equals(propertyName)) return PreferencesPricingMethod.class;
		if (CATEGORY.equals(propertyName)) return PreferencesPricingMethod.class;
		if (ESTIMATOR.equals(propertyName)) return PreferencesPricingMethod.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesPricingMethod objT = (PreferencesPricingMethod)obj;
		if (! SmartEquals(getUsed(), objT.getUsed()))
			return false;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getAbbreviation(), objT.getAbbreviation()))
			return false;
		if (! SmartEquals(getBrokered(), objT.getBrokered()))
			return false;
		if (! SmartEquals(getTaxable(), objT.getTaxable()))
			return false;
		if (! SmartEquals(getFinished(), objT.getFinished()))
			return false;
		if (! SmartEquals(getShowNotes(), objT.getShowNotes()))
			return false;
		if (! SmartEquals(getCategory(), objT.getCategory()))
			return false;
		if (! SmartEquals(getEstimator(), objT.getEstimator()))
			return false;
		return true;
	}			
}