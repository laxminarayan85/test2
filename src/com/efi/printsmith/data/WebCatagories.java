
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
  @NamedQuery(name = "WebCatagories.findall", query = "from WebCatagories"),
  @NamedQuery(name = "WebCatagories.byId", query = "select a from WebCatagories a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "webcatagories")
@SQLDelete(sql="update webcatagories set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class WebCatagories extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STATUS = "Status";
	/**
	 * @generated
	 */
	public static final String IMAGE = "Image";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String CHILDREN = "Children";

	/**
	 * @generated
	 */
	public WebCatagories() {
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
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private WebGraphics image;
	
	/**
	 * @generated
 	 */
	public WebGraphics getImage(){
    return image; 
  }

	
	/**
	 * @generated
	 */	
	public void setImage(WebGraphics newVal) {
    this.image = newVal;
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
    @OneToMany()
    @Where(clause="isdeleted <> 'TRUE'")
	@JoinTable( name = "webcatagories_children")
	private java.util.List<WebSubCatagories> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<WebSubCatagories> getChildren(){
    return children; 
  }

	/**
	 * @generated
	 */	
	public void addChildren(WebSubCatagories obj) {
    if (children == null) {
      children = new java.util.ArrayList<WebSubCatagories>();
    }
    children.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<WebSubCatagories> newVal) {
    this.children = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (STATUS.equals(propertyName)) return getStatus();
    if (IMAGE.equals(propertyName)) return getImage();
    if (NAME.equals(propertyName)) return getName();
    if (CHILDREN.equals(propertyName)) return getChildren();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (STATUS.equals(propertyName)) setStatus((String)newValue); else
    if (IMAGE.equals(propertyName)) setImage((WebGraphics)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (CHILDREN.equals(propertyName)) setChildren((java.util.List<WebSubCatagories>)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (STATUS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (IMAGE.equals(propertyName)) 
      return new Class<?>[] {WebGraphics.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHILDREN.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, WebSubCatagories.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (STATUS.equals(propertyName)) return WebCatagories.class;
    if (IMAGE.equals(propertyName)) return WebCatagories.class;
    if (NAME.equals(propertyName)) return WebCatagories.class;
    if (CHILDREN.equals(propertyName)) return WebCatagories.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebCatagories objT = (WebCatagories)obj;
    if (! SmartEquals(getStatus(), objT.getStatus()))
      return false;
    if (! SmartEquals(getImage(), objT.getImage()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getChildren(), objT.getChildren()))
      return false;
    return true;
  }			
}
