
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
  @NamedQuery(name = "TableProperties.findall", query = "from TableProperties"),
  @NamedQuery(name = "TableProperties.byId", query = "select a from TableProperties a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tableproperties")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tableproperties where modelbase.id=?")
@SQLDelete(sql="update tableproperties set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TableProperties extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TABLE = "Table";
	/**
	 * @generated
	 */
	public static final String USERNAME = "UserName";
	/**
	 * @generated
	 */
	public static final String ENABLED = "Enabled";
	/**
	 * @generated
	 */
	public static final String SORTBY = "SortBy";
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";

	/**
	 * @generated
	 */
	public TableProperties() {
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
	private String table;
	
	/**
	 * @generated
 	 */
	public String getTable(){
    return table; 
  }

	
	/**
	 * @generated
	 */	
	public void setTable(String newVal) {
    this.table = newVal;
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
	private Boolean enabled;
	
	/**
	 * @generated
 	 */
	public Boolean getEnabled(){
    return enabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setEnabled(Boolean newVal) {
    this.enabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String sortBy;
	
	/**
	 * @generated
 	 */
	public String getSortBy(){
    return sortBy; 
  }

	
	/**
	 * @generated
	 */	
	public void setSortBy(String newVal) {
    this.sortBy = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TABLE.equals(propertyName)) return getTable();
    if (USERNAME.equals(propertyName)) return getUserName();
    if (ENABLED.equals(propertyName)) return getEnabled();
    if (SORTBY.equals(propertyName)) return getSortBy();
    if (STATUS.equals(propertyName)) return getStatus();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TABLE.equals(propertyName)) setTable((String)newValue); else
    if (USERNAME.equals(propertyName)) setUserName((String)newValue); else
    if (ENABLED.equals(propertyName)) setEnabled((Boolean)newValue); else
    if (SORTBY.equals(propertyName)) setSortBy((String)newValue); else
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TABLE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (USERNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SORTBY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TABLE.equals(propertyName)) return TableProperties.class;
    if (USERNAME.equals(propertyName)) return TableProperties.class;
    if (ENABLED.equals(propertyName)) return TableProperties.class;
    if (SORTBY.equals(propertyName)) return TableProperties.class;
    if (STATUS.equals(propertyName)) return TableProperties.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TableProperties objT = (TableProperties)obj;
    if (! SmartEquals(getTable(), objT.getTable()))
      return false;
    if (! SmartEquals(getUserName(), objT.getUserName()))
      return false;
    if (! SmartEquals(getEnabled(), objT.getEnabled()))
      return false;
    if (! SmartEquals(getSortBy(), objT.getSortBy()))
      return false;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    return true;
  }			
}
