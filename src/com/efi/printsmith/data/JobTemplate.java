
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "JobTemplate.findall", query = "from JobTemplate"),
  @NamedQuery(name = "JobTemplate.byId", query = "select a from JobTemplate a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "jobtemplate")
public class JobTemplate extends Job {
	/**
	 * @generated
	 */
	public static final String TEMPLATENAME = "TemplateName";
	/**
	 * @generated
	 */
	public static final String USER = "User";
	/**
	 * @generated
	 */
	public static final String SHARED = "Shared";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";

	/**
	 * @generated
	 */
	public JobTemplate() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer templateName;
	
	/**
	 * @generated
 	 */
	public Integer getTemplateName(){
    return templateName; 
  }

	
	/**
	 * @generated
	 */	
	public void setTemplateName(Integer newVal) {
    this.templateName = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Users user;
	
	/**
	 * @generated
 	 */
	public Users getUser(){
    return user; 
  }

	
	/**
	 * @generated
	 */	
	public void setUser(Users newVal) {
    this.user = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean shared;
	
	/**
	 * @generated
 	 */
	public Boolean getShared(){
    return shared; 
  }

	
	/**
	 * @generated
	 */	
	public void setShared(Boolean newVal) {
    this.shared = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Account account;
	
	/**
	 * @generated
 	 */
	public Account getAccount(){
    return account; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccount(Account newVal) {
    this.account = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TEMPLATENAME.equals(propertyName)) return getTemplateName();
    if (USER.equals(propertyName)) return getUser();
    if (SHARED.equals(propertyName)) return getShared();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TEMPLATENAME.equals(propertyName)) setTemplateName((Integer)newValue); else
    if (USER.equals(propertyName)) setUser((Users)newValue); else
    if (SHARED.equals(propertyName)) setShared((Boolean)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TEMPLATENAME.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (USER.equals(propertyName)) 
      return new Class<?>[] {Users.class};		
    if (SHARED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TEMPLATENAME.equals(propertyName)) return JobTemplate.class;
    if (USER.equals(propertyName)) return JobTemplate.class;
    if (SHARED.equals(propertyName)) return JobTemplate.class;
    if (ACCOUNT.equals(propertyName)) return JobTemplate.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    JobTemplate objT = (JobTemplate)obj;
    if (! SmartEquals(getTemplateName(), objT.getTemplateName()))
      return false;
    if (! SmartEquals(getUser(), objT.getUser()))
      return false;
    if (! SmartEquals(getShared(), objT.getShared()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    return true;
  }			
}
