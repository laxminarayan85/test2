
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "Broker.findall", query = "from Broker"),
  @NamedQuery(name = "Broker.byId", query = "select a from Broker a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "broker")
public class Broker extends Party {
	/**
	 * @generated
	 */
	public static final String BROKERID = "BrokerId";

	/**
	 * @generated
	 */
	public Broker() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String brokerId;
	
	/**
	 * @generated
 	 */
	public String getBrokerId(){
    return brokerId; 
  }

	
	/**
	 * @generated
	 */	
	public void setBrokerId(String newVal) {
    this.brokerId = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (BROKERID.equals(propertyName)) return getBrokerId();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (BROKERID.equals(propertyName)) setBrokerId((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (BROKERID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (BROKERID.equals(propertyName)) return Broker.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Broker objT = (Broker)obj;
    if (! SmartEquals(getBrokerId(), objT.getBrokerId()))
      return false;
    return true;
  }			
}
