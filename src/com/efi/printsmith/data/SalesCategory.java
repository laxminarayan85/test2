
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
  @NamedQuery(name = "SalesCategory.findall", query = "from SalesCategory"),
  @NamedQuery(name = "SalesCategory.byId", query = "select a from SalesCategory a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "salescategory")
@SQLDelete(sql="update salescategory set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class SalesCategory extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
   * @generated
   */
  public static final String GLACCOUNT = "GlAccount";

	/**
   * @generated
   */
  public static final String NONSALE = "NonSale";

	/**
	 * @generated
	 */
	public SalesCategory() {
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
  private String glAccount;

	/**
   * @generated
 	 */
  public String getGlAccount(){
    return glAccount; 
  }


	/**
   * @generated
   */	
  public void setGlAccount(String newVal) {
    this.glAccount = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Boolean nonSale;

	/**
   * @generated
 	 */
  public Boolean getNonSale(){
    return nonSale; 
  }


	/**
   * @generated
   */	
  public void setNonSale(Boolean newVal) {
    this.nonSale = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (GLACCOUNT.equals(propertyName)) return getGlAccount();
    if (NONSALE.equals(propertyName)) return getNonSale();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (GLACCOUNT.equals(propertyName)) setGlAccount((String)newValue); else
    if (NONSALE.equals(propertyName)) setNonSale((Boolean)newValue); else
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
    if (GLACCOUNT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NONSALE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return SalesCategory.class;
    if (GLACCOUNT.equals(propertyName)) return SalesCategory.class;
    if (NONSALE.equals(propertyName)) return SalesCategory.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    SalesCategory objT = (SalesCategory)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getGlAccount(), objT.getGlAccount()))
      return false;
    if (! SmartEquals(getNonSale(), objT.getNonSale()))
      return false;
    return true;
  }			
}
