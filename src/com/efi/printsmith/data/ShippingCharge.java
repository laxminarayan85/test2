
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
  @NamedQuery(name = "ShippingCharge.findall", query = "from ShippingCharge"),
  @NamedQuery(name = "ShippingCharge.byId", query = "select a from ShippingCharge a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "shippingcharge")
@SQLDelete(sql="update shippingcharge set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class ShippingCharge extends Charge {
	/**
	 * @generated
	 */
	public static final String SHIPVIA = "ShipVia";
	/**
	 * @generated
	 */
	public static final String SHIPTO = "ShipTo";
	/**
	 * @generated
	 */
	public static final String TOTALWEIGHT = "TotalWeight";

	/**
   * @generated
   */
  public static final String OVERRIDETOTALWEIGHT = "OverrideTotalWeight";

	/**
	 * @generated
	 */
	public ShippingCharge() {
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
	private String shipVia;
	
	/**
	 * @generated
 	 */
	public String getShipVia(){
    return shipVia; 
  }

	
	/**
	 * @generated
	 */	
	public void setShipVia(String newVal) {
    this.shipVia = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private Address shipTo;
	
	/**
	 * @generated
 	 */
	public Address getShipTo(){
    return shipTo; 
  }

	
	/**
	 * @generated
	 */	
	public void setShipTo(Address newVal) {
    this.shipTo = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double totalWeight;
	
	/**
	 * @generated
 	 */
	public Double getTotalWeight(){
    return totalWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalWeight(Double newVal) {
    this.totalWeight = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Boolean overrideTotalWeight;

	/**
   * @generated
 	 */
  public Boolean getOverrideTotalWeight(){
    return overrideTotalWeight; 
  }


	/**
   * @generated
   */	
  public void setOverrideTotalWeight(Boolean newVal) {
    this.overrideTotalWeight = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (SHIPVIA.equals(propertyName)) return getShipVia();
    if (SHIPTO.equals(propertyName)) return getShipTo();
    if (TOTALWEIGHT.equals(propertyName)) return getTotalWeight();
    if (OVERRIDETOTALWEIGHT.equals(propertyName)) return getOverrideTotalWeight();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SHIPVIA.equals(propertyName)) setShipVia((String)newValue); else
    if (SHIPTO.equals(propertyName)) setShipTo((Address)newValue); else
    if (TOTALWEIGHT.equals(propertyName)) setTotalWeight((Double)newValue); else
    if (OVERRIDETOTALWEIGHT.equals(propertyName)) setOverrideTotalWeight((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (SHIPVIA.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHIPTO.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (TOTALWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (OVERRIDETOTALWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (SHIPVIA.equals(propertyName)) return ShippingCharge.class;
    if (SHIPTO.equals(propertyName)) return ShippingCharge.class;
    if (TOTALWEIGHT.equals(propertyName)) return ShippingCharge.class;
    if (OVERRIDETOTALWEIGHT.equals(propertyName)) return ShippingCharge.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    ShippingCharge objT = (ShippingCharge)obj;
    if (! SmartEquals(getShipVia(), objT.getShipVia()))
      return false;
    if (! SmartEquals(getShipTo(), objT.getShipTo()))
      return false;
    if (! SmartEquals(getTotalWeight(), objT.getTotalWeight()))
      return false;
    if (! SmartEquals(getOverrideTotalWeight(), objT.getOverrideTotalWeight()))
      return false;
    return true;
  }			
}
