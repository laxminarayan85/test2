
package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "DataManager.findall", query = "from DataManager"),
	@NamedQuery(name = "DataManager.byId", query = "select a from DataManager a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "datamanager")
public class DataManager extends ModelBase {
	/**
	 * @generated
	 */
	public static final String DATALOADED = "Dataloaded";

	/**
	 * @generated
	 */
	public DataManager() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean dataloaded;
	
	/**
	 * @generated
 	 */
	public Boolean getDataloaded(){
		return dataloaded; 
	}

	
	/**
	 * @generated
	 */	
	public void setDataloaded(Boolean newVal) {
		this.dataloaded = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (DATALOADED.equals(propertyName)) return getDataloaded();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (DATALOADED.equals(propertyName)) setDataloaded((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (DATALOADED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (DATALOADED.equals(propertyName)) return DataManager.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		DataManager objT = (DataManager)obj;
		if (! SmartEquals(getDataloaded(), objT.getDataloaded()))
			return false;
		return true;
	}			
}