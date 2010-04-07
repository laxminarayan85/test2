
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
  @NamedQuery(name = "TaxTablesElements.findall", query = "from TaxTablesElements"),
  @NamedQuery(name = "TaxTablesElements.byId", query = "select a from TaxTablesElements a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "taxtableselements")
public class TaxTablesElements extends ModelBase {
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
	public TaxTablesElements() {
    this.created = new Date();
    this.modified = new Date();
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (KEY.equals(propertyName)) return getKey();
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
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return TaxTablesElements.class;
    if (KEY.equals(propertyName)) return TaxTablesElements.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TaxTablesElements objT = (TaxTablesElements)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getKey(), objT.getKey()))
      return false;
    return true;
  }			
}
