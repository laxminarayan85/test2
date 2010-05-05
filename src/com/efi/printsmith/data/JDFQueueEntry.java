
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
  @NamedQuery(name = "JDFQueueEntry.findall", query = "from JDFQueueEntry"),
  @NamedQuery(name = "JDFQueueEntry.byId", query = "select a from JDFQueueEntry a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "jdfqueueentry")
public class JDFQueueEntry extends ModelBase {
	/**
	 * @generated
	 */
	public static final String MESSAGE = "Message";
	/**
	 * @generated
	 */
	public static final String RESPONSE = "Response";
	/**
	 * @generated
	 */
	public static final String SENT = "Sent";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";

	/**
	 * @generated
	 */
	public JDFQueueEntry() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String message;
	
	/**
	 * @generated
 	 */
	public String getMessage(){
    return message; 
  }

	
	/**
	 * @generated
	 */	
	public void setMessage(String newVal) {
    this.message = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String response;
	
	/**
	 * @generated
 	 */
	public String getResponse(){
    return response; 
  }

	
	/**
	 * @generated
	 */	
	public void setResponse(String newVal) {
    this.response = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date sent;
	
	/**
	 * @generated
 	 */
	public Date getSent(){
    return sent; 
  }

	
	/**
	 * @generated
	 */	
	public void setSent(Date newVal) {
    this.sent = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String status;
	
	/**
	 * @generated
 	 */
	public String getStatus(){
    return status; 
  }

	
	/**
	 * @generated
	 */	
	public void setStatus(String newVal) {
    this.status = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (MESSAGE.equals(propertyName)) return getMessage();
    if (RESPONSE.equals(propertyName)) return getResponse();
    if (SENT.equals(propertyName)) return getSent();
    if (STATUS.equals(propertyName)) return getStatus();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (MESSAGE.equals(propertyName)) setMessage((String)newValue); else
    if (RESPONSE.equals(propertyName)) setResponse((String)newValue); else
    if (SENT.equals(propertyName)) setSent((Date)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (MESSAGE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (RESPONSE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SENT.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (MESSAGE.equals(propertyName)) return JDFQueueEntry.class;
    if (RESPONSE.equals(propertyName)) return JDFQueueEntry.class;
    if (SENT.equals(propertyName)) return JDFQueueEntry.class;
    if (STATUS.equals(propertyName)) return JDFQueueEntry.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    JDFQueueEntry objT = (JDFQueueEntry)obj;
    if (! SmartEquals(getMessage(), objT.getMessage()))
      return false;
    if (! SmartEquals(getResponse(), objT.getResponse()))
      return false;
    if (! SmartEquals(getSent(), objT.getSent()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    return true;
  }			
}
