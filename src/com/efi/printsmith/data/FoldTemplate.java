
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
  @NamedQuery(name = "FoldTemplate.findall", query = "from FoldTemplate"),
  @NamedQuery(name = "FoldTemplate.byId", query = "select a from FoldTemplate a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "foldtemplate")
@SQLDelete(sql="update foldtemplate set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class FoldTemplate extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";

	/**
   * @generated
   */
  public static final String IMAGEFILE = "ImageFile";
	/**
   * @generated
   */
  public static final String DESCRIPTION = "Description";

	/**
   * @generated
   */
  public static final String ENABLED = "Enabled";

	/**
	 * @generated
	 */
	public FoldTemplate() {
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
  private String imageFile;

	/**
   * @generated
 	 */
  public String getImageFile(){
    return imageFile; 
  }


	/**
   * @generated
   */	
  public void setImageFile(String newVal) {
    this.imageFile = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (IMAGEFILE.equals(propertyName)) return getImageFile();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (ENABLED.equals(propertyName)) return getEnabled();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (IMAGEFILE.equals(propertyName)) setImageFile((String)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (ENABLED.equals(propertyName)) setEnabled((Boolean)newValue); else
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
    if (IMAGEFILE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return FoldTemplate.class;
    if (IMAGEFILE.equals(propertyName)) return FoldTemplate.class;
    if (DESCRIPTION.equals(propertyName)) return FoldTemplate.class;
    if (ENABLED.equals(propertyName)) return FoldTemplate.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    FoldTemplate objT = (FoldTemplate)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getImageFile(), objT.getImageFile()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getEnabled(), objT.getEnabled()))
      return false;
    return true;
  }			
}
