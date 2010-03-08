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
	@NamedQuery(name = "CustomerLog.findall", query = "from CustomerLog"),
	@NamedQuery(name = "CustomerLog.byId", query = "select a from CustomerLog a where a.id= :id")
})


@Entity
@Table(name = "customerlog")
public class CustomerLog extends ModelBase {
	/**
	 * @generated
	 */
	public static final String LOGENTRY = "LogEntry";

	/**
	 * @generated
	 */
	public CustomerLog() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String logEntry;
	
	/**
	 * @generated
 	 */
	public String getLogEntry(){
		return logEntry; 
	}

	/**
	 * @generated
	 */	
	public void setLogEntry(String newVal) {
		this.logEntry = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (LOGENTRY.equals(propertyName)) return getLogEntry();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (LOGENTRY.equals(propertyName)) setLogEntry((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (LOGENTRY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (LOGENTRY.equals(propertyName)) return CustomerLog.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		CustomerLog objT = (CustomerLog)obj;
		if (! SmartEquals(getLogEntry(), objT.getLogEntry()))
			return false;
		return true;
	}			
}