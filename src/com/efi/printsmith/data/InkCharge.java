
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "InkCharge.findall", query = "from InkCharge"),
  @NamedQuery(name = "InkCharge.byId", query = "select a from InkCharge a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "inkcharge")
public class InkCharge extends Charge {
	/**
	 * @generated
	 */
	public static final String COVERAGE = "Coverage";
	/**
	 * @generated
	 */
	public static final String INKWEIGHT = "InkWeight";
	/**
	 * @generated
	 */
	public static final String COVERPERPOUND = "CoverPerPound";
	/**
	 * @generated
	 */
	public static final String PRICEPERPOUND = "PricePerPound";
	/**
	 * @generated
	 */
	public static final String POUNDSOFINK = "PoundsOfInk";

	/**
	 * @generated
	 */
	public InkCharge() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double coverage;
	
	/**
	 * @generated
 	 */
	public Double getCoverage(){
    return coverage; 
  }

	
	/**
	 * @generated
	 */	
	public void setCoverage(Double newVal) {
    this.coverage = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double inkWeight;
	
	/**
	 * @generated
 	 */
	public Double getInkWeight(){
    return inkWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setInkWeight(Double newVal) {
    this.inkWeight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double coverPerPound;
	
	/**
	 * @generated
 	 */
	public Double getCoverPerPound(){
    return coverPerPound; 
  }

	
	/**
	 * @generated
	 */	
	public void setCoverPerPound(Double newVal) {
    this.coverPerPound = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal pricePerPound;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPricePerPound(){
    return pricePerPound; 
  }

	
	/**
   * @generated
   */	
  public void setPricePerPound(BigDecimal newVal) {
    this.pricePerPound = newVal;
  }


	/**
   * @generated
   */	
  public void setPricePerPound(double newVal) {
    this.pricePerPound = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Double poundsOfInk;
	
	/**
	 * @generated
 	 */
	public Double getPoundsOfInk(){
    return poundsOfInk; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoundsOfInk(Double newVal) {
    this.poundsOfInk = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (COVERAGE.equals(propertyName)) return getCoverage();
    if (INKWEIGHT.equals(propertyName)) return getInkWeight();
    if (COVERPERPOUND.equals(propertyName)) return getCoverPerPound();
    if (PRICEPERPOUND.equals(propertyName)) return getPricePerPound();
    if (POUNDSOFINK.equals(propertyName)) return getPoundsOfInk();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (COVERAGE.equals(propertyName)) setCoverage((Double)newValue); else
    if (INKWEIGHT.equals(propertyName)) setInkWeight((Double)newValue); else
    if (COVERPERPOUND.equals(propertyName)) setCoverPerPound((Double)newValue); else
    if (PRICEPERPOUND.equals(propertyName)) setPricePerPound((BigDecimal)newValue); else
    if (POUNDSOFINK.equals(propertyName)) setPoundsOfInk((Double)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (COVERAGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (INKWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COVERPERPOUND.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICEPERPOUND.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (POUNDSOFINK.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (COVERAGE.equals(propertyName)) return InkCharge.class;
    if (INKWEIGHT.equals(propertyName)) return InkCharge.class;
    if (COVERPERPOUND.equals(propertyName)) return InkCharge.class;
    if (PRICEPERPOUND.equals(propertyName)) return InkCharge.class;
    if (POUNDSOFINK.equals(propertyName)) return InkCharge.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    InkCharge objT = (InkCharge)obj;
    if (! SmartEquals(getCoverage(), objT.getCoverage()))
      return false;
    if (! SmartEquals(getInkWeight(), objT.getInkWeight()))
      return false;
    if (! SmartEquals(getCoverPerPound(), objT.getCoverPerPound()))
      return false;
    if (! SmartEquals(getPricePerPound(), objT.getPricePerPound()))
      return false;
    if (! SmartEquals(getPoundsOfInk(), objT.getPoundsOfInk()))
      return false;
    return true;
  }			
}
