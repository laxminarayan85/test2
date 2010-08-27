
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from jdfqueueentry where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
	public static final String URL = "Url";
	/**
	 * @generated
	 */
	public static final String JOBID = "Jobid";
	/**
	 * @generated
	 */
	public static final String DEVICEID = "DeviceId";
	/**
	 * @generated
	 */
	public static final String MSGTYPE = "MsgType";

	/**
	 * @generated
	 */
	public JDFQueueEntry() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
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
 	@Basic
	private String url;
	
	/**
	 * @generated
 	 */
	public String getUrl(){
    return url; 
  }

	
	/**
	 * @generated
	 */	
	public void setUrl(String newVal) {
    this.url = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long jobid;
	
	/**
	 * @generated
 	 */
	public Long getJobid(){
    return jobid; 
  }

	
	/**
	 * @generated
	 */	
	public void setJobid(Long newVal) {
    this.jobid = newVal;
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
	private String msgType;
	
	/**
	 * @generated
 	 */
	public String getMsgType(){
    return msgType; 
  }

	
	/**
	 * @generated
	 */	
	public void setMsgType(String newVal) {
    this.msgType = newVal;
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
    if (URL.equals(propertyName)) return getUrl();
    if (JOBID.equals(propertyName)) return getJobid();
    if (DEVICEID.equals(propertyName)) return getDeviceId();
    if (MSGTYPE.equals(propertyName)) return getMsgType();
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
    if (URL.equals(propertyName)) setUrl((String)newValue); else
    if (JOBID.equals(propertyName)) setJobid((Long)newValue); else
    if (DEVICEID.equals(propertyName)) setDeviceId((String)newValue); else
    if (MSGTYPE.equals(propertyName)) setMsgType((String)newValue); else
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
    if (URL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (DEVICEID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (MSGTYPE.equals(propertyName)) 
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
    if (URL.equals(propertyName)) return JDFQueueEntry.class;
    if (JOBID.equals(propertyName)) return JDFQueueEntry.class;
    if (DEVICEID.equals(propertyName)) return JDFQueueEntry.class;
    if (MSGTYPE.equals(propertyName)) return JDFQueueEntry.class;
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
    if (! SmartEquals(getUrl(), objT.getUrl()))
      return false;
    if (! SmartEquals(getJobid(), objT.getJobid()))
      return false;
    if (! SmartEquals(getDeviceId(), objT.getDeviceId()))
      return false;
    if (! SmartEquals(getMsgType(), objT.getMsgType()))
      return false;
    return true;
  }			
}
