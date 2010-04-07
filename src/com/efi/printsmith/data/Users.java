
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
  @NamedQuery(name = "Users.findall", query = "from Users"),
  @NamedQuery(name = "Users.byId", query = "select a from Users a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "users")
public class Users extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String PASSWORD = "Password";
	/**
	 * @generated
	 */
	public static final String FORCEPASSWORDCHANGE = "ForcePasswordChange";
	/**
	 * @generated
	 */
	public static final String ROBUSTPASSWORD = "RobustPassword";
	/**
	 * @generated
	 */
	public static final String NOOVERRIDE = "NoOverride";
	/**
	 * @generated
	 */
	public static final String OVERRIDECREDIT = "OverrideCredit";
	/**
	 * @generated
	 */
	public static final String LOCKSALESREP = "LockSalesRep";
	/**
	 * @generated
	 */
	public static final String REFUNDCREDITCARDS = "RefundCreditCards";
	/**
	 * @generated
	 */
	public static final String NOCASHRETURN = "NoCashReturn";
	/**
	 * @generated
	 */
	public static final String SHOWUSERNAMELOG = "ShowUserNameLog";
	/**
	 * @generated
	 */
	public static final String QUICKACCESS = "QuickAccess";
	/**
	 * @generated
	 */
	public static final String ACCESSLEVEL = "AccessLevel";
	/**
	 * @generated
	 */
	public static final String ACCESSGROUP = "AccessGroup";

	/**
	 * @generated
	 */
	public Users() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String name;
	
	/**
	 * @generated
 	 */
	public String getName(){
    return name; 
  }

	
	/**
	 * @generated
	 */	
	public void setName(String newVal) {
    this.name = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String password;
	
	/**
	 * @generated
 	 */
	public String getPassword(){
    return password; 
  }

	
	/**
	 * @generated
	 */	
	public void setPassword(String newVal) {
    this.password = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean forcePasswordChange;
	
	/**
	 * @generated
 	 */
	public Boolean getForcePasswordChange(){
    return forcePasswordChange; 
  }

	
	/**
	 * @generated
	 */	
	public void setForcePasswordChange(Boolean newVal) {
    this.forcePasswordChange = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean robustPassword;
	
	/**
	 * @generated
 	 */
	public Boolean getRobustPassword(){
    return robustPassword; 
  }

	
	/**
	 * @generated
	 */	
	public void setRobustPassword(Boolean newVal) {
    this.robustPassword = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getNoOverride(){
    return noOverride; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoOverride(Boolean newVal) {
    this.noOverride = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideCredit;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideCredit(){
    return overrideCredit; 
  }

	
	/**
	 * @generated
	 */	
	public void setOverrideCredit(Boolean newVal) {
    this.overrideCredit = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean lockSalesRep;
	
	/**
	 * @generated
 	 */
	public Boolean getLockSalesRep(){
    return lockSalesRep; 
  }

	
	/**
	 * @generated
	 */	
	public void setLockSalesRep(Boolean newVal) {
    this.lockSalesRep = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean refundCreditCards;
	
	/**
	 * @generated
 	 */
	public Boolean getRefundCreditCards(){
    return refundCreditCards; 
  }

	
	/**
	 * @generated
	 */	
	public void setRefundCreditCards(Boolean newVal) {
    this.refundCreditCards = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noCashReturn;
	
	/**
	 * @generated
 	 */
	public Boolean getNoCashReturn(){
    return noCashReturn; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoCashReturn(Boolean newVal) {
    this.noCashReturn = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showUserNameLog;
	
	/**
	 * @generated
 	 */
	public Boolean getShowUserNameLog(){
    return showUserNameLog; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowUserNameLog(Boolean newVal) {
    this.showUserNameLog = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean quickAccess;
	
	/**
	 * @generated
 	 */
	public Boolean getQuickAccess(){
    return quickAccess; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuickAccess(Boolean newVal) {
    this.quickAccess = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private AccessLevel accessLevel;
	
	/**
	 * @generated
 	 */
	public AccessLevel getAccessLevel(){
    return accessLevel; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccessLevel(AccessLevel newVal) {
    this.accessLevel = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private AccessGroup accessGroup;
	
	/**
	 * @generated
 	 */
	public AccessGroup getAccessGroup(){
    return accessGroup; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccessGroup(AccessGroup newVal) {
    this.accessGroup = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (PASSWORD.equals(propertyName)) return getPassword();
    if (FORCEPASSWORDCHANGE.equals(propertyName)) return getForcePasswordChange();
    if (ROBUSTPASSWORD.equals(propertyName)) return getRobustPassword();
    if (NOOVERRIDE.equals(propertyName)) return getNoOverride();
    if (OVERRIDECREDIT.equals(propertyName)) return getOverrideCredit();
    if (LOCKSALESREP.equals(propertyName)) return getLockSalesRep();
    if (REFUNDCREDITCARDS.equals(propertyName)) return getRefundCreditCards();
    if (NOCASHRETURN.equals(propertyName)) return getNoCashReturn();
    if (SHOWUSERNAMELOG.equals(propertyName)) return getShowUserNameLog();
    if (QUICKACCESS.equals(propertyName)) return getQuickAccess();
    if (ACCESSLEVEL.equals(propertyName)) return getAccessLevel();
    if (ACCESSGROUP.equals(propertyName)) return getAccessGroup();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (PASSWORD.equals(propertyName)) setPassword((String)newValue); else
    if (FORCEPASSWORDCHANGE.equals(propertyName)) setForcePasswordChange((Boolean)newValue); else
    if (ROBUSTPASSWORD.equals(propertyName)) setRobustPassword((Boolean)newValue); else
    if (NOOVERRIDE.equals(propertyName)) setNoOverride((Boolean)newValue); else
    if (OVERRIDECREDIT.equals(propertyName)) setOverrideCredit((Boolean)newValue); else
    if (LOCKSALESREP.equals(propertyName)) setLockSalesRep((Boolean)newValue); else
    if (REFUNDCREDITCARDS.equals(propertyName)) setRefundCreditCards((Boolean)newValue); else
    if (NOCASHRETURN.equals(propertyName)) setNoCashReturn((Boolean)newValue); else
    if (SHOWUSERNAMELOG.equals(propertyName)) setShowUserNameLog((Boolean)newValue); else
    if (QUICKACCESS.equals(propertyName)) setQuickAccess((Boolean)newValue); else
    if (ACCESSLEVEL.equals(propertyName)) setAccessLevel((AccessLevel)newValue); else
    if (ACCESSGROUP.equals(propertyName)) setAccessGroup((AccessGroup)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PASSWORD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FORCEPASSWORDCHANGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ROBUSTPASSWORD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NOOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OVERRIDECREDIT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LOCKSALESREP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (REFUNDCREDITCARDS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NOCASHRETURN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWUSERNAMELOG.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (QUICKACCESS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ACCESSLEVEL.equals(propertyName)) 
      return new Class<?>[] {AccessLevel.class};		
    if (ACCESSGROUP.equals(propertyName)) 
      return new Class<?>[] {AccessGroup.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return Users.class;
    if (PASSWORD.equals(propertyName)) return Users.class;
    if (FORCEPASSWORDCHANGE.equals(propertyName)) return Users.class;
    if (ROBUSTPASSWORD.equals(propertyName)) return Users.class;
    if (NOOVERRIDE.equals(propertyName)) return Users.class;
    if (OVERRIDECREDIT.equals(propertyName)) return Users.class;
    if (LOCKSALESREP.equals(propertyName)) return Users.class;
    if (REFUNDCREDITCARDS.equals(propertyName)) return Users.class;
    if (NOCASHRETURN.equals(propertyName)) return Users.class;
    if (SHOWUSERNAMELOG.equals(propertyName)) return Users.class;
    if (QUICKACCESS.equals(propertyName)) return Users.class;
    if (ACCESSLEVEL.equals(propertyName)) return Users.class;
    if (ACCESSGROUP.equals(propertyName)) return Users.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Users objT = (Users)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getPassword(), objT.getPassword()))
      return false;
    if (! SmartEquals(getForcePasswordChange(), objT.getForcePasswordChange()))
      return false;
    if (! SmartEquals(getRobustPassword(), objT.getRobustPassword()))
      return false;
    if (! SmartEquals(getNoOverride(), objT.getNoOverride()))
      return false;
    if (! SmartEquals(getOverrideCredit(), objT.getOverrideCredit()))
      return false;
    if (! SmartEquals(getLockSalesRep(), objT.getLockSalesRep()))
      return false;
    if (! SmartEquals(getRefundCreditCards(), objT.getRefundCreditCards()))
      return false;
    if (! SmartEquals(getNoCashReturn(), objT.getNoCashReturn()))
      return false;
    if (! SmartEquals(getShowUserNameLog(), objT.getShowUserNameLog()))
      return false;
    if (! SmartEquals(getQuickAccess(), objT.getQuickAccess()))
      return false;
    if (! SmartEquals(getAccessLevel(), objT.getAccessLevel()))
      return false;
    if (! SmartEquals(getAccessGroup(), objT.getAccessGroup()))
      return false;
    return true;
  }			
}
