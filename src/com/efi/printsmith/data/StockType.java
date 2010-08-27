
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
  @NamedQuery(name = "StockType.findall", query = "from StockType"),
  @NamedQuery(name = "StockType.byId", query = "select a from StockType a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "stocktype")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from stocktype where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class StockType extends ModelBase {
	/**
	 * @generated
	 */
	public static final String SIZE = "Size";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String VIEWABLEID = "ViewableID";

	/**
	 * @generated
	 */
	public StockType() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
 	@ManyToOne()
	@Basic
	private Dimension size;
	
	/**
	 * @generated
 	 */
	public Dimension getSize(){
    return size; 
  }

	
	/**
   * @generated
   */	
  public void setSize(Dimension newVal) {
    this.size = newVal;
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
	private Integer viewableID;
	
	/**
	 * @generated
 	 */
	public Integer getViewableID(){
    return viewableID; 
  }

	
	/**
	 * @generated
	 */	
	public void setViewableID(Integer newVal) {
    this.viewableID = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (SIZE.equals(propertyName)) return getSize();
    if (NAME.equals(propertyName)) return getName();
    if (VIEWABLEID.equals(propertyName)) return getViewableID();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SIZE.equals(propertyName)) setSize((Dimension)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (VIEWABLEID.equals(propertyName)) setViewableID((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (SIZE.equals(propertyName)) 
      return new Class<?>[] {Dimension.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VIEWABLEID.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (SIZE.equals(propertyName)) return StockType.class;
    if (NAME.equals(propertyName)) return StockType.class;
    if (VIEWABLEID.equals(propertyName)) return StockType.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    StockType objT = (StockType)obj;
    if (! SmartEquals(getSize(), objT.getSize()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getViewableID(), objT.getViewableID()))
      return false;
    return true;
  }			
}
