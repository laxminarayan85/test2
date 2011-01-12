
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
  @NamedQuery(name = "PaperPrice.findall", query = "from PaperPrice"),
  @NamedQuery(name = "PaperPrice.byId", query = "select a from PaperPrice a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "paperprice")
@SQLDelete(sql="update paperprice set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PaperPrice extends Matrix {

	/**
   * @generated
   */
  public static final String NAME = "Name";
	/**
   * @generated
   */
  public static final String TYPE = "Type";
	/**
   * @generated
   */
  public static final String METHOD = "Method";

	/**
	 * @generated
	 */
	public PaperPrice() {
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
  private Integer type;

	/**
   * @generated
 	 */
  public Integer getType(){
    return type; 
  }

	/**
   * @generated
   */	
  public void setType(Integer newVal) {
    this.type = newVal;
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
  @Transient
  @Override
  public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (TYPE.equals(propertyName)) return getType();
    if (METHOD.equals(propertyName)) return getMethod();
    return super.getProperty(propertyName);
  }

	/**
   * @generated
   */		
  @SuppressWarnings("unchecked")
  @Override
  public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (TYPE.equals(propertyName)) setType((Integer)newValue); else
    if (METHOD.equals(propertyName)) setMethod((String)newValue); else
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
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (METHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }

	/**
   * @generated
   */		
  @Transient
  @Override
  public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return PaperPrice.class;
    if (TYPE.equals(propertyName)) return PaperPrice.class;
    if (METHOD.equals(propertyName)) return PaperPrice.class;
    return super.getPropertyOwner(propertyName);
  }

	/**
   * @generated
   */			
  @Override
  public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PaperPrice objT = (PaperPrice)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getMethod(), objT.getMethod()))
      return false;
    return true;
  }

}
