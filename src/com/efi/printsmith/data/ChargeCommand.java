
package com.efi.printsmith.data;

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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "ChargeCommand.findall", query = "from ChargeCommand"),
  @NamedQuery(name = "ChargeCommand.byId", query = "select a from ChargeCommand a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargecommand")
public class ChargeCommand extends ModelBase {
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
	public ChargeCommand() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
	@OneToMany( fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable( name = "chargecommand_children")
	private java.util.List<ChargeCategory> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeCategory> getChildren(){
    return children; 
  }

	/**
	 * @generated
	 */	
	public void addChildren(ChargeCategory obj) {
    obj.setParent(this);
    if (children == null) {
      children = new java.util.ArrayList<ChargeCategory>();
    }
    children.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<ChargeCategory> newVal) {
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (CHILDREN.equals(propertyName)) return getChildren();
    if (NAME.equals(propertyName)) return getName();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (CHILDREN.equals(propertyName)) setChildren((java.util.List<ChargeCategory>)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (CHILDREN.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeCategory.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (CHILDREN.equals(propertyName)) return ChargeCommand.class;
    if (NAME.equals(propertyName)) return ChargeCommand.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    ChargeCommand objT = (ChargeCommand)obj;
    if (! SmartEquals(getChildren(), objT.getChildren()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    return true;
  }			
}
