
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
	@NamedQuery(name = "Users.findall", query = "from Users"),
	@NamedQuery(name = "Users.byId", query = "select a from Users a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "users")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from users where modelbase.id=?")
@SQLDelete(sql="update users set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
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
	public static final String DISABLEUSER = "DisableUser";
	/**
	 * @generated
	 */
	public static final String PREVPASSWORD1 = "PrevPassword1";
	/**
	 * @generated
	 */
	public static final String PREVPASSWORD2 = "PrevPassword2";
	/**
	 * @generated
	 */
	public static final String PREVPASSWORD3 = "PrevPassword3";
	/**
	 * @generated
	 */
	public static final String PREVPASSWORD4 = "PrevPassword4";
	/**
	 * @generated
	 */
	public static final String LOGINATTEMPTS = "LoginAttempts";
	/**
	 * @generated
	 */
	public static final String LASTLOGIN = "LastLogin";
	/**
	 * @generated
	 */
	public static final String PASSWORDCHANGEDDATE = "PasswordChangedDate";

	/**
	 * @generated
	 */
	public Users() {
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
    @Basic
	@Where(clause="isdeleted <> 'TRUE'")
	private Integer accessLevel;
	
	/**
	 * @generated
 	 */
	public Integer getAccessLevel(){
		return accessLevel; 
	}

	
	/**
	 * @generated
	 */	
	public void setAccessLevel(Integer newVal) {
		this.accessLevel = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
 	@Basic
	private Boolean disableUser;
	
	/**
	 * @generated
 	 */
	public Boolean getDisableUser(){
		return disableUser; 
	}

	
	/**
	 * @generated
	 */	
	public void setDisableUser(Boolean newVal) {
		this.disableUser = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String prevPassword1;
	
	/**
	 * @generated
 	 */
	public String getPrevPassword1(){
		return prevPassword1; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrevPassword1(String newVal) {
		this.prevPassword1 = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String prevPassword2;
	
	/**
	 * @generated
 	 */
	public String getPrevPassword2(){
		return prevPassword2; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrevPassword2(String newVal) {
		this.prevPassword2 = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String prevPassword3;
	
	/**
	 * @generated
 	 */
	public String getPrevPassword3(){
		return prevPassword3; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrevPassword3(String newVal) {
		this.prevPassword3 = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String prevPassword4;
	
	/**
	 * @generated
 	 */
	public String getPrevPassword4(){
		return prevPassword4; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrevPassword4(String newVal) {
		this.prevPassword4 = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer loginAttempts;
	
	/**
	 * @generated
 	 */
	public Integer getLoginAttempts(){
		return loginAttempts; 
	}

	
	/**
	 * @generated
	 */	
	public void setLoginAttempts(Integer newVal) {
		this.loginAttempts = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date lastLogin;
	
	/**
	 * @generated
 	 */
	public Date getLastLogin(){
		return lastLogin; 
	}

	
	/**
	 * @generated
	 */	
	public void setLastLogin(Date newVal) {
		this.lastLogin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date passwordChangedDate;
	
	/**
	 * @generated
 	 */
	public Date getPasswordChangedDate(){
		return passwordChangedDate; 
	}

	
	/**
	 * @generated
	 */	
	public void setPasswordChangedDate(Date newVal) {
		this.passwordChangedDate = newVal;
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
		if (DISABLEUSER.equals(propertyName)) return getDisableUser();
		if (PREVPASSWORD1.equals(propertyName)) return getPrevPassword1();
		if (PREVPASSWORD2.equals(propertyName)) return getPrevPassword2();
		if (PREVPASSWORD3.equals(propertyName)) return getPrevPassword3();
		if (PREVPASSWORD4.equals(propertyName)) return getPrevPassword4();
		if (LOGINATTEMPTS.equals(propertyName)) return getLoginAttempts();
		if (LASTLOGIN.equals(propertyName)) return getLastLogin();
		if (PASSWORDCHANGEDDATE.equals(propertyName)) return getPasswordChangedDate();
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
		if (ACCESSLEVEL.equals(propertyName)) setAccessLevel((Integer)newValue); else
		if (ACCESSGROUP.equals(propertyName)) setAccessGroup((AccessGroup)newValue); else
		if (DISABLEUSER.equals(propertyName)) setDisableUser((Boolean)newValue); else
		if (PREVPASSWORD1.equals(propertyName)) setPrevPassword1((String)newValue); else
		if (PREVPASSWORD2.equals(propertyName)) setPrevPassword2((String)newValue); else
		if (PREVPASSWORD3.equals(propertyName)) setPrevPassword3((String)newValue); else
		if (PREVPASSWORD4.equals(propertyName)) setPrevPassword4((String)newValue); else
		if (LOGINATTEMPTS.equals(propertyName)) setLoginAttempts((Integer)newValue); else
		if (LASTLOGIN.equals(propertyName)) setLastLogin((Date)newValue); else
		if (PASSWORDCHANGEDDATE.equals(propertyName)) setPasswordChangedDate((Date)newValue); else
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
			return new Class<?>[] {Integer.class};		
		if (ACCESSGROUP.equals(propertyName)) 
			return new Class<?>[] {AccessGroup.class};		
		if (DISABLEUSER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PREVPASSWORD1.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PREVPASSWORD2.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PREVPASSWORD3.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PREVPASSWORD4.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LOGINATTEMPTS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (LASTLOGIN.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (PASSWORDCHANGEDDATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
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
		if (DISABLEUSER.equals(propertyName)) return Users.class;
		if (PREVPASSWORD1.equals(propertyName)) return Users.class;
		if (PREVPASSWORD2.equals(propertyName)) return Users.class;
		if (PREVPASSWORD3.equals(propertyName)) return Users.class;
		if (PREVPASSWORD4.equals(propertyName)) return Users.class;
		if (LOGINATTEMPTS.equals(propertyName)) return Users.class;
		if (LASTLOGIN.equals(propertyName)) return Users.class;
		if (PASSWORDCHANGEDDATE.equals(propertyName)) return Users.class;
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
		if (! SmartEquals(getDisableUser(), objT.getDisableUser()))
			return false;
		if (! SmartEquals(getPrevPassword1(), objT.getPrevPassword1()))
			return false;
		if (! SmartEquals(getPrevPassword2(), objT.getPrevPassword2()))
			return false;
		if (! SmartEquals(getPrevPassword3(), objT.getPrevPassword3()))
			return false;
		if (! SmartEquals(getPrevPassword4(), objT.getPrevPassword4()))
			return false;
		if (! SmartEquals(getLoginAttempts(), objT.getLoginAttempts()))
			return false;
		if (! SmartEquals(getLastLogin(), objT.getLastLogin()))
			return false;
		if (! SmartEquals(getPasswordChangedDate(), objT.getPasswordChangedDate()))
			return false;
		return true;
	}			
}