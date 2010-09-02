
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
  @NamedQuery(name = "UserEvent.findall", query = "from UserEvent"),
  @NamedQuery(name = "UserEvent.byId", query = "select a from UserEvent a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "userevent")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from userevent where modelbase.id=?")
@SQLDelete(sql="update userevent set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class UserEvent extends ModelBase {
	/**
	 * @generated
	 */
	public static final String USERNAME = "UserName";
	/**
	 * @generated
	 */
	public static final String DATESTAMP = "DateStamp";
	/**
	 * @generated
	 */
	public static final String REASONCODE = "ReasonCode";
	/**
	 * @generated
	 */
	public static final String EVENTSTRING = "EventString";
	/**
	 * @generated
	 */
	public static final String WORKSTATIONID = "WorkstationId";

	/**
	 * @generated
	 */
	public UserEvent() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

	@Basic
	private Boolean isDeleted = false;
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String userName;
	
	/**
	 * @generated
 	 */
	public String getUserName(){
    return userName; 
  }

	
	/**
	 * @generated
	 */	
	public void setUserName(String newVal) {
    this.userName = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date dateStamp;
	
	/**
	 * @generated
 	 */
	public Date getDateStamp(){
    return dateStamp; 
  }

	
	/**
	 * @generated
	 */	
	public void setDateStamp(Date newVal) {
    this.dateStamp = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer reasonCode;
	
	/**
	 * @generated
 	 */
	public Integer getReasonCode(){
    return reasonCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setReasonCode(Integer newVal) {
    this.reasonCode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String eventString;
	
	/**
	 * @generated
 	 */
	public String getEventString(){
    return eventString; 
  }

	
	/**
	 * @generated
	 */	
	public void setEventString(String newVal) {
    this.eventString = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer workstationId;
	
	/**
	 * @generated
 	 */
	public Integer getWorkstationId(){
    return workstationId; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkstationId(Integer newVal) {
    this.workstationId = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (USERNAME.equals(propertyName)) return getUserName();
    if (DATESTAMP.equals(propertyName)) return getDateStamp();
    if (REASONCODE.equals(propertyName)) return getReasonCode();
    if (EVENTSTRING.equals(propertyName)) return getEventString();
    if (WORKSTATIONID.equals(propertyName)) return getWorkstationId();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (USERNAME.equals(propertyName)) setUserName((String)newValue); else
    if (DATESTAMP.equals(propertyName)) setDateStamp((Date)newValue); else
    if (REASONCODE.equals(propertyName)) setReasonCode((Integer)newValue); else
    if (EVENTSTRING.equals(propertyName)) setEventString((String)newValue); else
    if (WORKSTATIONID.equals(propertyName)) setWorkstationId((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (USERNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DATESTAMP.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (REASONCODE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (EVENTSTRING.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WORKSTATIONID.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (USERNAME.equals(propertyName)) return UserEvent.class;
    if (DATESTAMP.equals(propertyName)) return UserEvent.class;
    if (REASONCODE.equals(propertyName)) return UserEvent.class;
    if (EVENTSTRING.equals(propertyName)) return UserEvent.class;
    if (WORKSTATIONID.equals(propertyName)) return UserEvent.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    UserEvent objT = (UserEvent)obj;
    if (! SmartEquals(getUserName(), objT.getUserName()))
      return false;
    if (! SmartEquals(getDateStamp(), objT.getDateStamp()))
      return false;
    if (! SmartEquals(getReasonCode(), objT.getReasonCode()))
      return false;
    if (! SmartEquals(getEventString(), objT.getEventString()))
      return false;
    if (! SmartEquals(getWorkstationId(), objT.getWorkstationId()))
      return false;
    return true;
  }			
}
