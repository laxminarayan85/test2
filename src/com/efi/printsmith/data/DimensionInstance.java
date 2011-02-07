
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
  @NamedQuery(name = "DimensionInstance.findall", query = "from DimensionInstance"),
  @NamedQuery(name = "DimensionInstance.byId", query = "select a from DimensionInstance a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "dimensioninstance")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from dimensioninstance where modelbase.id=?")
@SQLDelete(sql="update dimensioninstance set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class DimensionInstance extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String WIDTH = "Width";
	/**
	 * @generated
	 */
	public static final String HEIGHT = "Height";
	/**
	 * @generated
	 */
	public static final String METRIC = "Metric";

	/**
	 * @generated
	 */
	public DimensionInstance() {
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
	private String type;
	
	/**
	 * @generated
 	 */
	public String getType(){
    return type; 
  }

	
	/**
	 * @generated
	 */	
	public void setType(String newVal) {
    this.type = newVal;
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
	private Float width;
	
	/**
	 * @generated
 	 */
	public Float getWidth(){
    return width; 
  }

	
	/**
	 * @generated
	 */	
	public void setWidth(Float newVal) {
    this.width = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Float height;
	
	/**
	 * @generated
 	 */
	public Float getHeight(){
    return height; 
  }

	
	/**
	 * @generated
	 */	
	public void setHeight(Float newVal) {
    this.height = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean metric;
	
	/**
	 * @generated
 	 */
	public Boolean getMetric(){
    return metric; 
  }

	
	/**
	 * @generated
	 */	
	public void setMetric(Boolean newVal) {
    this.metric = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TYPE.equals(propertyName)) return getType();
    if (NAME.equals(propertyName)) return getName();
    if (WIDTH.equals(propertyName)) return getWidth();
    if (HEIGHT.equals(propertyName)) return getHeight();
    if (METRIC.equals(propertyName)) return getMetric();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (WIDTH.equals(propertyName)) setWidth((Float)newValue); else
    if (HEIGHT.equals(propertyName)) setHeight((Float)newValue); else
    if (METRIC.equals(propertyName)) setMetric((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WIDTH.equals(propertyName)) 
      return new Class<?>[] {Float.class};		
    if (HEIGHT.equals(propertyName)) 
      return new Class<?>[] {Float.class};		
    if (METRIC.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TYPE.equals(propertyName)) return DimensionInstance.class;
    if (NAME.equals(propertyName)) return DimensionInstance.class;
    if (WIDTH.equals(propertyName)) return DimensionInstance.class;
    if (HEIGHT.equals(propertyName)) return DimensionInstance.class;
    if (METRIC.equals(propertyName)) return DimensionInstance.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DimensionInstance objT = (DimensionInstance)obj;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getWidth(), objT.getWidth()))
      return false;
    if (! SmartEquals(getHeight(), objT.getHeight()))
      return false;
    if (! SmartEquals(getMetric(), objT.getMetric()))
      return false;
    return true;
  }			
}
