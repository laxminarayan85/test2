
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
  @NamedQuery(name = "SecuritySetup.findall", query = "from SecuritySetup"),
  @NamedQuery(name = "SecuritySetup.byId", query = "select a from SecuritySetup a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "securitysetup")
@SQLDelete(sql="update securitysetup set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class SecuritySetup extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCESSGROUP = "AccessGroup";

	/**
   * @generated
   */
  public static final String SECURITYCMD = "SecurityCmd";

	/**
	 * @generated
	 */
	public SecuritySetup() {
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
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
  private SecurityCommands securityCmd;

	/**
   * @generated
 	 */
  public SecurityCommands getSecurityCmd(){
    return securityCmd; 
  }


	/**
   * @generated
   */	
  public void setSecurityCmd(SecurityCommands newVal) {
    this.securityCmd = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACCESSGROUP.equals(propertyName)) return getAccessGroup();
    if (SECURITYCMD.equals(propertyName)) return getSecurityCmd();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACCESSGROUP.equals(propertyName)) setAccessGroup((AccessGroup)newValue); else
    if (SECURITYCMD.equals(propertyName)) setSecurityCmd((SecurityCommands)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ACCESSGROUP.equals(propertyName)) 
      return new Class<?>[] {AccessGroup.class};		
    if (SECURITYCMD.equals(propertyName)) 
      return new Class<?>[] {SecurityCommands.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ACCESSGROUP.equals(propertyName)) return SecuritySetup.class;
    if (SECURITYCMD.equals(propertyName)) return SecuritySetup.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    SecuritySetup objT = (SecuritySetup)obj;
    if (! SmartEquals(getAccessGroup(), objT.getAccessGroup()))
      return false;
    if (! SmartEquals(getSecurityCmd(), objT.getSecurityCmd()))
      return false;
    return true;
  }			
}
