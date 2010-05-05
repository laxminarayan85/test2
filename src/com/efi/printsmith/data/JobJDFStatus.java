
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
  @NamedQuery(name = "JobJDFStatus.findall", query = "from JobJDFStatus"),
  @NamedQuery(name = "JobJDFStatus.byId", query = "select a from JobJDFStatus a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "jobjdfstatus")
public class JobJDFStatus extends ModelBase {
	/**
	 * @generated
	 */
	public static final String LASTUPDATED = "LastUpdated";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String DEVICEID = "DeviceId";
	/**
	 * @generated
	 */
	public static final String QUEUEID = "QueueId";

	/**
	 * @generated
	 */
	public JobJDFStatus() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastUpdated;
	
	/**
	 * @generated
 	 */
	public Date getLastUpdated(){
    return lastUpdated; 
  }

	
	/**
	 * @generated
	 */	
	public void setLastUpdated(Date newVal) {
    this.lastUpdated = newVal;
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
 	@Basic
	private String deviceId;
	
	/**
	 * @generated
 	 */
	public String getDeviceId(){
    return deviceId; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeviceId(String newVal) {
    this.deviceId = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String queueId;
	
	/**
	 * @generated
 	 */
	public String getQueueId(){
    return queueId; 
  }

	
	/**
	 * @generated
	 */	
	public void setQueueId(String newVal) {
    this.queueId = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (LASTUPDATED.equals(propertyName)) return getLastUpdated();
    if (STATUS.equals(propertyName)) return getStatus();
    if (DEVICEID.equals(propertyName)) return getDeviceId();
    if (QUEUEID.equals(propertyName)) return getQueueId();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (LASTUPDATED.equals(propertyName)) setLastUpdated((Date)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (DEVICEID.equals(propertyName)) setDeviceId((String)newValue); else
    if (QUEUEID.equals(propertyName)) setQueueId((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (LASTUPDATED.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DEVICEID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (QUEUEID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (LASTUPDATED.equals(propertyName)) return JobJDFStatus.class;
    if (STATUS.equals(propertyName)) return JobJDFStatus.class;
    if (DEVICEID.equals(propertyName)) return JobJDFStatus.class;
    if (QUEUEID.equals(propertyName)) return JobJDFStatus.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    JobJDFStatus objT = (JobJDFStatus)obj;
    if (! SmartEquals(getLastUpdated(), objT.getLastUpdated()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getDeviceId(), objT.getDeviceId()))
      return false;
    if (! SmartEquals(getQueueId(), objT.getQueueId()))
      return false;
    return true;
  }			
}
