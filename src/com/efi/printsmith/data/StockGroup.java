
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
  @NamedQuery(name = "StockGroup.findall", query = "from StockGroup"),
  @NamedQuery(name = "StockGroup.byId", query = "select a from StockGroup a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "stockgroup")
@SQLDelete(sql="update stockgroup set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class StockGroup extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String KEY = "Key";

	/**
   * @generated
   */
  public static final String ORDERBY = "Orderby";

	/**
	 * @generated
	 */
	public StockGroup() {
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
	private String key;
	
	/**
	 * @generated
 	 */
	public String getKey(){
    return key; 
  }

	
	/**
	 * @generated
	 */	
	public void setKey(String newVal) {
    this.key = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Integer orderby;

	/**
   * @generated
 	 */
  public Integer getOrderby(){
    return orderby; 
  }


	/**
   * @generated
   */	
  public void setOrderby(Integer newVal) {
    this.orderby = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (KEY.equals(propertyName)) return getKey();
    if (ORDERBY.equals(propertyName)) return getOrderby();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (KEY.equals(propertyName)) setKey((String)newValue); else
    if (ORDERBY.equals(propertyName)) setOrderby((Integer)newValue); else
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
    if (KEY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ORDERBY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return StockGroup.class;
    if (KEY.equals(propertyName)) return StockGroup.class;
    if (ORDERBY.equals(propertyName)) return StockGroup.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    StockGroup objT = (StockGroup)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getKey(), objT.getKey()))
      return false;
    if (! SmartEquals(getOrderby(), objT.getOrderby()))
      return false;
    return true;
  }			
}
