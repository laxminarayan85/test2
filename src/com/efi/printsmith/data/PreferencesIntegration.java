
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
  @NamedQuery(name = "PreferencesIntegration.findall", query = "from PreferencesIntegration"),
  @NamedQuery(name = "PreferencesIntegration.byId", query = "select a from PreferencesIntegration a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesintegration")
public class PreferencesIntegration extends ModelBase {
	/**
	 * @generated
	 */
	public static final String FIERYCONNECTORURL = "FieryConnectorURL";

	/**
	 * @generated
	 */
	public PreferencesIntegration() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String fieryConnectorURL;
	
	/**
	 * @generated
 	 */
	public String getFieryConnectorURL(){
    return fieryConnectorURL; 
  }

	
	/**
	 * @generated
	 */	
	public void setFieryConnectorURL(String newVal) {
    this.fieryConnectorURL = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (FIERYCONNECTORURL.equals(propertyName)) return getFieryConnectorURL();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (FIERYCONNECTORURL.equals(propertyName)) setFieryConnectorURL((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (FIERYCONNECTORURL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (FIERYCONNECTORURL.equals(propertyName)) return PreferencesIntegration.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesIntegration objT = (PreferencesIntegration)obj;
    if (! SmartEquals(getFieryConnectorURL(), objT.getFieryConnectorURL()))
      return false;
    return true;
  }			
}
