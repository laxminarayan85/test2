
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
  @NamedQuery(name = "ChargeCategory.findall", query = "from ChargeCategory"),
  @NamedQuery(name = "ChargeCategory.byId", query = "select a from ChargeCategory a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargecategory")
@SQLDelete(sql="update chargecategory set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class ChargeCategory extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CHILDREN = "Children";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String PARENT = "Parent";

	/**
	 * @generated
	 */
	public ChargeCategory() {
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
    @OneToMany(  cascade = {CascadeType.ALL})
	@Where(clause="isdeleted <> 'TRUE'")
	@JoinTable( name = "chargecategory_children")
	private java.util.List<ChargeDefinition> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getChildren(){
    return children; 
  }

	/**
	 * @generated
	 */	
	public void addChildren(ChargeDefinition obj) {
    obj.setParent(this);
    if (children == null) {
      children = new java.util.ArrayList<ChargeDefinition>();
    }
    children.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<ChargeDefinition> newVal) {
    this.children = newVal;
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
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private ChargeCommand parent;
	
	/**
	 * @generated
 	 */
	public ChargeCommand getParent(){
    return parent; 
  }

	
	/**
	 * @generated
	 */	
	public void setParent(ChargeCommand newVal) {
    this.parent = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CHILDREN.equals(propertyName)) return getChildren();
    if (NAME.equals(propertyName)) return getName();
    if (PARENT.equals(propertyName)) return getParent();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CHILDREN.equals(propertyName)) setChildren((java.util.List<ChargeDefinition>)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (PARENT.equals(propertyName)) setParent((ChargeCommand)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CHILDREN.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARENT.equals(propertyName)) 
      return new Class<?>[] {ChargeCommand.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CHILDREN.equals(propertyName)) return ChargeCategory.class;
    if (NAME.equals(propertyName)) return ChargeCategory.class;
    if (PARENT.equals(propertyName)) return ChargeCategory.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    ChargeCategory objT = (ChargeCategory)obj;
    if (! SmartEquals(getChildren(), objT.getChildren()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getParent(), objT.getParent()))
      return false;
    return true;
  }			
}
