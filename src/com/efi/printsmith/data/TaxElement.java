
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
  @NamedQuery(name = "TaxElement.findall", query = "from TaxElement"),
  @NamedQuery(name = "TaxElement.byId", query = "select a from TaxElement a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "taxelement")
@SQLDelete(sql="update taxelement set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class TaxElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String SHOWTAX = "ShowTax";
	/**
	 * @generated
	 */
	public static final String USERFORSEPARATESHIPPINGTAX = "UserForSeparateShippingTax";
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";
	/**
	 * @generated
	 */
	public static final String SEQUENCEID = "Sequenceid";

	/**
	 * @generated
	 */
	public TaxElement() {
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
	private BigDecimal rate;
	
	/**
	 * @generated
 	 */
	public BigDecimal getRate(){
    return rate; 
  }

	
	/**
	 * @generated
	 */	
	public void setRate(BigDecimal newVal) {
    this.rate = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setRate(double newVal) {
    this.rate = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showTax;
	
	/**
	 * @generated
 	 */
	public Boolean getShowTax(){
    return showTax; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowTax(Boolean newVal) {
    this.showTax = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean userForSeparateShippingTax;
	
	/**
	 * @generated
 	 */
	public Boolean getUserForSeparateShippingTax(){
    return userForSeparateShippingTax; 
  }

	
	/**
	 * @generated
	 */	
	public void setUserForSeparateShippingTax(Boolean newVal) {
    this.userForSeparateShippingTax = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private TaxTablesElements tax;
	
	/**
	 * @generated
 	 */
	public TaxTablesElements getTax(){
    return tax; 
  }

	
	/**
	 * @generated
	 */	
	public void setTax(TaxTablesElements newVal) {
    this.tax = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer sequenceid;
	
	/**
	 * @generated
 	 */
	public Integer getSequenceid(){
    return sequenceid; 
  }

	
	/**
	 * @generated
	 */	
	public void setSequenceid(Integer newVal) {
    this.sequenceid = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (RATE.equals(propertyName)) return getRate();
    if (SHOWTAX.equals(propertyName)) return getShowTax();
    if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) return getUserForSeparateShippingTax();
    if (TAX.equals(propertyName)) return getTax();
    if (SEQUENCEID.equals(propertyName)) return getSequenceid();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (RATE.equals(propertyName)) setRate((BigDecimal)newValue); else
    if (SHOWTAX.equals(propertyName)) setShowTax((Boolean)newValue); else
    if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) setUserForSeparateShippingTax((Boolean)newValue); else
    if (TAX.equals(propertyName)) setTax((TaxTablesElements)newValue); else
    if (SEQUENCEID.equals(propertyName)) setSequenceid((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (RATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SHOWTAX.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {TaxTablesElements.class};		
    if (SEQUENCEID.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (RATE.equals(propertyName)) return TaxElement.class;
    if (SHOWTAX.equals(propertyName)) return TaxElement.class;
    if (USERFORSEPARATESHIPPINGTAX.equals(propertyName)) return TaxElement.class;
    if (TAX.equals(propertyName)) return TaxElement.class;
    if (SEQUENCEID.equals(propertyName)) return TaxElement.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    TaxElement objT = (TaxElement)obj;
    if (! SmartEquals(getRate(), objT.getRate()))
      return false;
    if (! SmartEquals(getShowTax(), objT.getShowTax()))
      return false;
    if (! SmartEquals(getUserForSeparateShippingTax(), objT.getUserForSeparateShippingTax()))
      return false;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    if (! SmartEquals(getSequenceid(), objT.getSequenceid()))
      return false;
    return true;
  }			
}
