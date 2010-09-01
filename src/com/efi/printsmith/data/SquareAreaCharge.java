
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
  @NamedQuery(name = "SquareAreaCharge.findall", query = "from SquareAreaCharge"),
  @NamedQuery(name = "SquareAreaCharge.byId", query = "select a from SquareAreaCharge a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "squareareacharge")
@SQLDelete(sql="update squareareacharge set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class SquareAreaCharge extends Charge {
	/**
	 * @generated
	 */
	public static final String OVERRIDEAREA = "OverrideArea";
	/**
	 * @generated
	 */
	public static final String AREA = "Area";

	/**
	 * @generated
	 */
	public SquareAreaCharge() {
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
	private Boolean overrideArea;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideArea(){
    return overrideArea; 
  }

	
	/**
	 * @generated
	 */	
	public void setOverrideArea(Boolean newVal) {
    this.overrideArea = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double area;
	
	/**
	 * @generated
 	 */
	public Double getArea(){
    return area; 
  }

	
	/**
	 * @generated
	 */	
	public void setArea(Double newVal) {
    this.area = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (OVERRIDEAREA.equals(propertyName)) return getOverrideArea();
    if (AREA.equals(propertyName)) return getArea();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (OVERRIDEAREA.equals(propertyName)) setOverrideArea((Boolean)newValue); else
    if (AREA.equals(propertyName)) setArea((Double)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (OVERRIDEAREA.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AREA.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (OVERRIDEAREA.equals(propertyName)) return SquareAreaCharge.class;
    if (AREA.equals(propertyName)) return SquareAreaCharge.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    SquareAreaCharge objT = (SquareAreaCharge)obj;
    if (! SmartEquals(getOverrideArea(), objT.getOverrideArea()))
      return false;
    if (! SmartEquals(getArea(), objT.getArea()))
      return false;
    return true;
  }			
}
