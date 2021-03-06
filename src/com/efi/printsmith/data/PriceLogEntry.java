
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
  @NamedQuery(name = "PriceLogEntry.findall", query = "from PriceLogEntry"),
  @NamedQuery(name = "PriceLogEntry.byId", query = "select a from PriceLogEntry a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "pricelogentry")
@SQLDelete(sql="update pricelogentry set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PriceLogEntry extends ModelBase {
	/**
	 * @generated
	 */
	public static final String VERSION = "Version";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String METHOD = "Method";
	/**
	 * @generated
	 */
	public static final String VALUE = "Value";
	/**
	 * @generated
	 */
	public static final String DATE = "Date";
	/**
	 * @generated
	 */
	public static final String CHILDREN = "Children";

	/**
	 * @generated
	 */
	public PriceLogEntry() {
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
	private Integer version;
	
	/**
	 * @generated
 	 */
	public Integer getVersion(){
    return version; 
  }

	
	/**
	 * @generated
	 */	
	public void setVersion(Integer newVal) {
    this.version = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
    return description; 
  }

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
    this.description = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String method;
	
	/**
	 * @generated
 	 */
	public String getMethod(){
    return method; 
  }

	
	/**
	 * @generated
	 */	
	public void setMethod(String newVal) {
    this.method = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal value;
	
	/**
	 * @generated
 	 */
	public BigDecimal getValue(){
    return value; 
  }

	
	/**
	 * @generated
	 */	
	public void setValue(BigDecimal newVal) {
    this.value = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setValue(double newVal) {
    this.value = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date date;
	
	/**
	 * @generated
 	 */
	public Date getDate(){
    return date; 
  }

	
	/**
	 * @generated
	 */	
	public void setDate(Date newVal) {
    this.date = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @Where(clause="isdeleted <> 'TRUE'")
	@JoinTable( name = "pricelogentry_children")
	private java.util.List<PriceLogEntry> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<PriceLogEntry> getChildren(){
    return children; 
  }

	/**
	 * @generated
	 */	
	public void addChildren(PriceLogEntry obj) {
    if (children == null) {
      children = new java.util.ArrayList<PriceLogEntry>();
    }
    children.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<PriceLogEntry> newVal) {
    this.children = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (VERSION.equals(propertyName)) return getVersion();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (METHOD.equals(propertyName)) return getMethod();
    if (VALUE.equals(propertyName)) return getValue();
    if (DATE.equals(propertyName)) return getDate();
    if (CHILDREN.equals(propertyName)) return getChildren();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (VERSION.equals(propertyName)) setVersion((Integer)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (METHOD.equals(propertyName)) setMethod((String)newValue); else
    if (VALUE.equals(propertyName)) setValue((BigDecimal)newValue); else
    if (DATE.equals(propertyName)) setDate((Date)newValue); else
    if (CHILDREN.equals(propertyName)) setChildren((java.util.List<PriceLogEntry>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (VERSION.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (METHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VALUE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (DATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CHILDREN.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, PriceLogEntry.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (VERSION.equals(propertyName)) return PriceLogEntry.class;
    if (DESCRIPTION.equals(propertyName)) return PriceLogEntry.class;
    if (METHOD.equals(propertyName)) return PriceLogEntry.class;
    if (VALUE.equals(propertyName)) return PriceLogEntry.class;
    if (DATE.equals(propertyName)) return PriceLogEntry.class;
    if (CHILDREN.equals(propertyName)) return PriceLogEntry.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PriceLogEntry objT = (PriceLogEntry)obj;
    if (! SmartEquals(getVersion(), objT.getVersion()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getMethod(), objT.getMethod()))
      return false;
    if (! SmartEquals(getValue(), objT.getValue()))
      return false;
    if (! SmartEquals(getDate(), objT.getDate()))
      return false;
    if (! SmartEquals(getChildren(), objT.getChildren()))
      return false;
    return true;
  }			
}
