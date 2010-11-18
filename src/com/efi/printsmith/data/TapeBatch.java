
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
  @NamedQuery(name = "TapeBatch.findall", query = "from TapeBatch"),
  @NamedQuery(name = "TapeBatch.byId", query = "select a from TapeBatch a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapebatch")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapebatch where modelbase.id=?")
@SQLDelete(sql="update tapebatch set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeBatch extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String OPENDATE = "OpenDate";
	/**
	 * @generated
	 */
	public static final String APPVERSION = "AppVersion";
	/**
	 * @generated
	 */
	public static final String CLOSED = "Closed";
	/**
   * @generated
   */
  public static final String SESSIONBATCHES = "SessionBatches";
	/**
	 * @generated
	 */
	public TapeBatch() {
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
	private Integer name;
	
	/**
	 * @generated
 	 */
	public Integer getName(){
    return name; 
  }

	
	/**
	 * @generated
	 */	
	public void setName(Integer newVal) {
    this.name = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date openDate;
	
	/**
	 * @generated
 	 */
	public Date getOpenDate(){
    return openDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setOpenDate(Date newVal) {
    this.openDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String appVersion;
	
	/**
	 * @generated
 	 */
	public String getAppVersion(){
    return appVersion; 
  }

	
	/**
	 * @generated
	 */	
	public void setAppVersion(String newVal) {
    this.appVersion = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean closed;
	
	/**
	 * @generated
 	 */
	public Boolean getClosed(){
    return closed; 
  }

	
	/**
	 * @generated
	 */	
	public void setClosed(Boolean newVal) {
    this.closed = newVal;
  }
	
 	
	
	/**
   * @generated
   */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @Where(clause="isdeleted <> 'TRUE'")
    @JoinTable( name = "tapebatch_sessionbatches")
  private java.util.List<TapeSessionBatch> sessionBatches;

	/**
   * @generated
 	 */
  public java.util.List<TapeSessionBatch> getSessionBatches(){
    return sessionBatches; 
  }

	/**
   * @generated
   */	
  public void addSessionBatches(TapeSessionBatch obj) {
    if (sessionBatches == null) {
      sessionBatches = new java.util.ArrayList<TapeSessionBatch>();
    }
    sessionBatches.add(obj);
  }

	/**
   * @generated
   */	
  public void setSessionBatches(java.util.List<TapeSessionBatch> newVal) {
    this.sessionBatches = newVal;
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (OPENDATE.equals(propertyName)) return getOpenDate();
    if (APPVERSION.equals(propertyName)) return getAppVersion();
    if (CLOSED.equals(propertyName)) return getClosed();
    if (SESSIONBATCHES.equals(propertyName)) return getSessionBatches();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((Integer)newValue); else
    if (OPENDATE.equals(propertyName)) setOpenDate((Date)newValue); else
    if (APPVERSION.equals(propertyName)) setAppVersion((String)newValue); else
    if (CLOSED.equals(propertyName)) setClosed((Boolean)newValue); else
    if (SESSIONBATCHES.equals(propertyName)) setSessionBatches((java.util.List<TapeSessionBatch>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (OPENDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (APPVERSION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CLOSED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SESSIONBATCHES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, TapeSessionBatch.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return TapeBatch.class;
    if (OPENDATE.equals(propertyName)) return TapeBatch.class;
    if (APPVERSION.equals(propertyName)) return TapeBatch.class;
    if (CLOSED.equals(propertyName)) return TapeBatch.class;
    if (SESSIONBATCHES.equals(propertyName)) return TapeBatch.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TapeBatch objT = (TapeBatch)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getOpenDate(), objT.getOpenDate()))
      return false;
    if (! SmartEquals(getAppVersion(), objT.getAppVersion()))
      return false;
    if (! SmartEquals(getClosed(), objT.getClosed()))
      return false;
    if (! SmartEquals(getSessionBatches(), objT.getSessionBatches()))
      return false;
    return true;
  }			
}
