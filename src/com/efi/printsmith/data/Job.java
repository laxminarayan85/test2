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
	@NamedQuery(name = "Job.findall", query = "from Job"),
	@NamedQuery(name = "Job.byId", query = "select a from Job a where a.id= :id")
})


@Entity
@Table(name = "job")
public class Job extends ModelBase {
	/**
	 * @generated
	 */
	public static final String JOBNUMBER = "JobNumber";

	/**
	 * @generated
	 */
	public Job() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String jobNumber;
	/**
	 * @generated
 	 */
	public String getJobNumber(){
		return jobNumber; 
	}

	/**
	 * @generated
	 */	
	public void setJobNumber(String newVal) {
		this.jobNumber = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (JOBNUMBER.equals(propertyName)) return getJobNumber();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (JOBNUMBER.equals(propertyName)) setJobNumber((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (JOBNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (JOBNUMBER.equals(propertyName)) return Job.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Job objT = (Job)obj;
		if (! SmartEquals(getJobNumber(), objT.getJobNumber()))
			return false;
		return true;
	}			
}