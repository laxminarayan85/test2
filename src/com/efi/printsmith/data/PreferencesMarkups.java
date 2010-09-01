
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
  @NamedQuery(name = "PreferencesMarkups.findall", query = "from PreferencesMarkups"),
  @NamedQuery(name = "PreferencesMarkups.byId", query = "select a from PreferencesMarkups a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesmarkups")
@SQLDelete(sql="update preferencesmarkups set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesMarkups extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TOTALCOST = "TotalCost";
	/**
	 * @generated
	 */
	public static final String MARKUP = "Markup";
	/**
	 * @generated
	 */
	public static final String ABOVE = "Above";
	/**
	 * @generated
	 */
	public static final String MARKUPTYPE = "MarkupType";

	/**
	 * @generated
	 */
	public PreferencesMarkups() {
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
	private BigDecimal totalCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalCost(){
    return totalCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalCost(BigDecimal newVal) {
    this.totalCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotalCost(double newVal) {
    this.totalCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup;
	
	/**
	 * @generated
 	 */
	public Double getMarkup(){
    return markup; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup(Double newVal) {
    this.markup = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean above;
	
	/**
	 * @generated
 	 */
	public Boolean getAbove(){
    return above; 
  }

	
	/**
	 * @generated
	 */	
	public void setAbove(Boolean newVal) {
    this.above = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer markupType;
	
	/**
	 * @generated
 	 */
	public Integer getMarkupType(){
    return markupType; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkupType(Integer newVal) {
    this.markupType = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TOTALCOST.equals(propertyName)) return getTotalCost();
    if (MARKUP.equals(propertyName)) return getMarkup();
    if (ABOVE.equals(propertyName)) return getAbove();
    if (MARKUPTYPE.equals(propertyName)) return getMarkupType();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TOTALCOST.equals(propertyName)) setTotalCost((BigDecimal)newValue); else
    if (MARKUP.equals(propertyName)) setMarkup((Double)newValue); else
    if (ABOVE.equals(propertyName)) setAbove((Boolean)newValue); else
    if (MARKUPTYPE.equals(propertyName)) setMarkupType((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TOTALCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (MARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ABOVE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MARKUPTYPE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TOTALCOST.equals(propertyName)) return PreferencesMarkups.class;
    if (MARKUP.equals(propertyName)) return PreferencesMarkups.class;
    if (ABOVE.equals(propertyName)) return PreferencesMarkups.class;
    if (MARKUPTYPE.equals(propertyName)) return PreferencesMarkups.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesMarkups objT = (PreferencesMarkups)obj;
    if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
      return false;
    if (! SmartEquals(getMarkup(), objT.getMarkup()))
      return false;
    if (! SmartEquals(getAbove(), objT.getAbove()))
      return false;
    if (! SmartEquals(getMarkupType(), objT.getMarkupType()))
      return false;
    return true;
  }			
}
