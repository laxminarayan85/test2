
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
  @NamedQuery(name = "PreferencesSalesCategory.findall", query = "from PreferencesSalesCategory"),
  @NamedQuery(name = "PreferencesSalesCategory.byId", query = "select a from PreferencesSalesCategory a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencessalescategory")
@SQLDelete(sql="update preferencessalescategory set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesSalesCategory extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CATEGORY = "Category";
	/**
	 * @generated
	 */
	public static final String ACCOUNTNUMBER = "AccountNumber";

	/**
	 * @generated
	 */
	public PreferencesSalesCategory() {
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
	private SalesCategory category;
	
	/**
	 * @generated
 	 */
	public SalesCategory getCategory(){
    return category; 
  }

	
	/**
	 * @generated
	 */	
	public void setCategory(SalesCategory newVal) {
    this.category = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String accountNumber;
	
	/**
	 * @generated
 	 */
	public String getAccountNumber(){
    return accountNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccountNumber(String newVal) {
    this.accountNumber = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CATEGORY.equals(propertyName)) return getCategory();
    if (ACCOUNTNUMBER.equals(propertyName)) return getAccountNumber();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CATEGORY.equals(propertyName)) setCategory((SalesCategory)newValue); else
    if (ACCOUNTNUMBER.equals(propertyName)) setAccountNumber((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CATEGORY.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (ACCOUNTNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CATEGORY.equals(propertyName)) return PreferencesSalesCategory.class;
    if (ACCOUNTNUMBER.equals(propertyName)) return PreferencesSalesCategory.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesSalesCategory objT = (PreferencesSalesCategory)obj;
    if (! SmartEquals(getCategory(), objT.getCategory()))
      return false;
    if (! SmartEquals(getAccountNumber(), objT.getAccountNumber()))
      return false;
    return true;
  }			
}
