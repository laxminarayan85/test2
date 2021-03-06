
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
  @NamedQuery(name = "CostingRecord.findall", query = "from CostingRecord"),
  @NamedQuery(name = "CostingRecord.byId", query = "select a from CostingRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "costingrecord")
@SQLDelete(sql="update costingrecord set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class CostingRecord extends ModelBase {
	/**
   * @generated
   */
  public static final String ACTUALWASHUPTIME = "ActualWashupTime";
	/**
   * @generated
   */
  public static final String ACTUALTOTALCOST = "ActualTotalCost";
	/**
   * @generated
   */
  public static final String ACTUALLABORCOST = "ActualLaborCost";
	/**
   * @generated
   */
  public static final String ACTUALLABORUNITCOST = "ActualLaborUnitCost";
	/**
   * @generated
   */
  public static final String ACTUALRUNTIME = "ActualRunTime";
	/**
   * @generated
   */
  public static final String ACTUALSETUPTIME = "ActualSetupTime";
	/**
   * @generated
   */
  public static final String ACTUALMATERIALS = "ActualMaterials";
	/**
   * @generated
   */
  public static final String ACTUALSPOILAGE = "ActualSpoilage";
	/**
   * @generated
   */
  public static final String ACTUALSTOCKCOST = "ActualStockCost";
	/**
   * @generated
   */
  public static final String ACTUALUNITCOUNT = "ActualUnitCount";
	/**
   * @generated
   */
  public static final String COSTENTERED = "CostEntered";
	/**
   * @generated
   */
  public static final String DATACOLLECTED = "DataCollected";
	/**
	 * @generated
	 */
	public CostingRecord() {
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
  private Double actualWashupTime;

	/**
   * @generated
 	 */
  public Double getActualWashupTime(){
    return actualWashupTime; 
  }


	/**
   * @generated
   */	
  public void setActualWashupTime(Double newVal) {
    this.actualWashupTime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal actualTotalCost;

	/**
   * @generated
 	 */
  public BigDecimal getActualTotalCost(){
    return actualTotalCost; 
  }


	/**
   * @generated
   */	
  public void setActualTotalCost(BigDecimal newVal) {
    this.actualTotalCost = newVal;
  }



	/**
   * @generated
   */	
  public void setActualTotalCost(double newVal) {
    this.actualTotalCost = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal actualLaborCost;

	/**
   * @generated
 	 */
  public BigDecimal getActualLaborCost(){
    return actualLaborCost; 
  }


	/**
   * @generated
   */	
  public void setActualLaborCost(BigDecimal newVal) {
    this.actualLaborCost = newVal;
  }


	/**
   * @generated
   */	
  public void setActualLaborCost(double newVal) {
    this.actualLaborCost = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal actualLaborUnitCost;

	/**
   * @generated
 	 */
  public BigDecimal getActualLaborUnitCost(){
    return actualLaborUnitCost; 
  }


	/**
   * @generated
   */	
  public void setActualLaborUnitCost(BigDecimal newVal) {
    this.actualLaborUnitCost = newVal;
  }


	/**
   * @generated
   */	
  public void setActualLaborUnitCost(double newVal) {
    this.actualLaborUnitCost = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private Double actualRunTime;

	/**
   * @generated
 	 */
  public Double getActualRunTime(){
    return actualRunTime; 
  }


	/**
   * @generated
   */	
  public void setActualRunTime(Double newVal) {
    this.actualRunTime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double actualSetupTime;

	/**
   * @generated
 	 */
  public Double getActualSetupTime(){
    return actualSetupTime; 
  }


	/**
   * @generated
   */	
  public void setActualSetupTime(Double newVal) {
    this.actualSetupTime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double actualMaterials;

	/**
   * @generated
 	 */
  public Double getActualMaterials(){
    return actualMaterials; 
  }


	/**
   * @generated
   */	
  public void setActualMaterials(Double newVal) {
    this.actualMaterials = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double actualSpoilage;

	/**
   * @generated
 	 */
  public Double getActualSpoilage(){
    return actualSpoilage; 
  }


	/**
   * @generated
   */	
  public void setActualSpoilage(Double newVal) {
    this.actualSpoilage = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal actualStockCost;

	/**
   * @generated
 	 */
  public BigDecimal getActualStockCost(){
    return actualStockCost; 
  }


	/**
   * @generated
   */	
  public void setActualStockCost(BigDecimal newVal) {
    this.actualStockCost = newVal;
  }


	/**
   * @generated
   */	
  public void setActualStockCost(double newVal) {
    this.actualStockCost = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private Double actualUnitCount;

	/**
   * @generated
 	 */
  public Double getActualUnitCount(){
    return actualUnitCount; 
  }


	/**
   * @generated
   */	
  public void setActualUnitCount(Double newVal) {
    this.actualUnitCount = newVal;
  }


  	private Boolean costEntered;
  	
  	private Boolean dataCollected;
  	
  	

	/**
	 * @return the costEntered
	 */
	public Boolean getCostEntered() {
		return costEntered;
	}


	/**
	 * @param costEntered the costEntered to set
	 */
	public void setCostEntered(Boolean costEntered) {
		this.costEntered = costEntered;
	}


	/**
	 * @return the dataCollected
	 */
	public Boolean getDataCollected() {
		return dataCollected;
	}


	/**
	 * @param dataCollected the dataCollected to set
	 */
	public void setDataCollected(Boolean dataCollected) {
		this.dataCollected = dataCollected;
	}


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACTUALWASHUPTIME.equals(propertyName)) return getActualWashupTime();
    if (ACTUALTOTALCOST.equals(propertyName)) return getActualTotalCost();
    if (ACTUALLABORCOST.equals(propertyName)) return getActualLaborCost();
    if (ACTUALLABORUNITCOST.equals(propertyName)) return getActualLaborUnitCost();
    if (ACTUALRUNTIME.equals(propertyName)) return getActualRunTime();
    if (ACTUALSETUPTIME.equals(propertyName)) return getActualSetupTime();
    if (ACTUALMATERIALS.equals(propertyName)) return getActualMaterials();
    if (ACTUALSPOILAGE.equals(propertyName)) return getActualSpoilage();
    if (ACTUALSTOCKCOST.equals(propertyName)) return getActualStockCost();
    if (ACTUALUNITCOUNT.equals(propertyName)) return getActualUnitCount();
    if (COSTENTERED.equals(propertyName)) return getCostEntered();
    if (DATACOLLECTED.equals(propertyName)) return getDataCollected();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACTUALWASHUPTIME.equals(propertyName)) setActualWashupTime((Double)newValue); else
    if (ACTUALTOTALCOST.equals(propertyName)) setActualTotalCost((BigDecimal)newValue); else
    if (ACTUALLABORCOST.equals(propertyName)) setActualLaborCost((BigDecimal)newValue); else
    if (ACTUALLABORUNITCOST.equals(propertyName)) setActualLaborUnitCost((BigDecimal)newValue); else
    if (ACTUALRUNTIME.equals(propertyName)) setActualRunTime((Double)newValue); else
    if (ACTUALSETUPTIME.equals(propertyName)) setActualSetupTime((Double)newValue); else
    if (ACTUALMATERIALS.equals(propertyName)) setActualMaterials((Double)newValue); else
    if (ACTUALSPOILAGE.equals(propertyName)) setActualSpoilage((Double)newValue); else
    if (ACTUALSTOCKCOST.equals(propertyName)) setActualStockCost((BigDecimal)newValue); else
    if (ACTUALUNITCOUNT.equals(propertyName)) setActualUnitCount((Double)newValue); else
    if (COSTENTERED.equals(propertyName)) setCostEntered((Boolean)newValue); else
    if (DATACOLLECTED.equals(propertyName)) setDataCollected((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ACTUALWASHUPTIME.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALTOTALCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTUALLABORCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTUALLABORUNITCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTUALRUNTIME.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALSETUPTIME.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALMATERIALS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALSPOILAGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALSTOCKCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTUALUNITCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COSTENTERED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DATACOLLECTED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ACTUALWASHUPTIME.equals(propertyName)) return CostingRecord.class;
    if (ACTUALTOTALCOST.equals(propertyName)) return CostingRecord.class;
    if (ACTUALLABORCOST.equals(propertyName)) return CostingRecord.class;
    if (ACTUALLABORUNITCOST.equals(propertyName)) return CostingRecord.class;
    if (ACTUALRUNTIME.equals(propertyName)) return CostingRecord.class;
    if (ACTUALSETUPTIME.equals(propertyName)) return CostingRecord.class;
    if (ACTUALMATERIALS.equals(propertyName)) return CostingRecord.class;
    if (ACTUALSPOILAGE.equals(propertyName)) return CostingRecord.class;
    if (ACTUALSTOCKCOST.equals(propertyName)) return CostingRecord.class;
    if (ACTUALUNITCOUNT.equals(propertyName)) return CostingRecord.class;
    if (COSTENTERED.equals(propertyName)) return CostingRecord.class;
    if (DATACOLLECTED.equals(propertyName)) return CostingRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    CostingRecord objT = (CostingRecord)obj;
    if (! SmartEquals(getActualWashupTime(), objT.getActualWashupTime()))
      return false;
    if (! SmartEquals(getActualTotalCost(), objT.getActualTotalCost()))
      return false;
    if (! SmartEquals(getActualLaborCost(), objT.getActualLaborCost()))
      return false;
    if (! SmartEquals(getActualLaborUnitCost(), objT.getActualLaborUnitCost()))
      return false;
    if (! SmartEquals(getActualRunTime(), objT.getActualRunTime()))
      return false;
    if (! SmartEquals(getActualSetupTime(), objT.getActualSetupTime()))
      return false;
    if (! SmartEquals(getActualMaterials(), objT.getActualMaterials()))
      return false;
    if (! SmartEquals(getActualSpoilage(), objT.getActualSpoilage()))
      return false;
    if (! SmartEquals(getActualStockCost(), objT.getActualStockCost()))
      return false;
    if (! SmartEquals(getActualUnitCount(), objT.getActualUnitCount()))
      return false;
    if (! SmartEquals(getCostEntered(), objT.getCostEntered()))
      return false;
    if (! SmartEquals(getDataCollected(), objT.getDataCollected()))
      return false;
    return true;
  }			
}
