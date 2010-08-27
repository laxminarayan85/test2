
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
  @NamedQuery(name = "ChargeCostingRecord.findall", query = "from ChargeCostingRecord"),
  @NamedQuery(name = "ChargeCostingRecord.byId", query = "select a from ChargeCostingRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargecostingrecord")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from chargecostingrecord where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class ChargeCostingRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String IMPRESSIONS = "Impressions";
	/**
	 * @generated
	 */
	public static final String TOTALIMPRESSIONS = "TotalImpressions";
	/**
	 * @generated
	 */
	public static final String ACTUALUNITCOUNT = "ActualUnitCount";
	/**
	 * @generated
	 */
	public static final String ACTUALSPOILAGE = "ActualSpoilage";
	/**
	 * @generated
	 */
	public static final String ACTUALMATERIALS = "ActualMaterials";
	/**
	 * @generated
	 */
	public static final String SETUPTIME = "SetupTime";
	/**
	 * @generated
	 */
	public static final String RUNTIME = "RunTime";
	/**
	 * @generated
	 */
	public static final String LABORUNITCOST = "LaborUnitCost";
	/**
	 * @generated
	 */
	public static final String LABORCOST = "LaborCost";
	/**
	 * @generated
	 */
	public static final String TOTALCOST = "TotalCost";
	/**
	 * @generated
	 */
	public static final String ACTUALCOUNT = "ActualCount";

	/**
	 * @generated
	 */
	public ChargeCostingRecord() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long impressions;
	
	/**
	 * @generated
 	 */
	public Long getImpressions(){
    return impressions; 
  }

	
	/**
	 * @generated
	 */	
	public void setImpressions(Long newVal) {
    this.impressions = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long totalImpressions;
	
	/**
	 * @generated
 	 */
	public Long getTotalImpressions(){
    return totalImpressions; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalImpressions(Long newVal) {
    this.totalImpressions = newVal;
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
	private BigDecimal actualMaterials;
	
	/**
	 * @generated
 	 */
	public BigDecimal getActualMaterials(){
    return actualMaterials; 
  }

	
	/**
	 * @generated
	 */	
	public void setActualMaterials(BigDecimal newVal) {
    this.actualMaterials = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setActualMaterials(double newVal) {
    this.actualMaterials = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double setupTime;
	
	/**
	 * @generated
 	 */
	public Double getSetupTime(){
    return setupTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setSetupTime(Double newVal) {
    this.setupTime = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double runTime;
	
	/**
	 * @generated
 	 */
	public Double getRunTime(){
    return runTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setRunTime(Double newVal) {
    this.runTime = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal laborUnitCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getLaborUnitCost(){
    return laborUnitCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborUnitCost(BigDecimal newVal) {
    this.laborUnitCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setLaborUnitCost(double newVal) {
    this.laborUnitCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal laborCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getLaborCost(){
    return laborCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborCost(BigDecimal newVal) {
    this.laborCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setLaborCost(double newVal) {
    this.laborCost = BigDecimal.valueOf(newVal);
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
	private BigDecimal actualCount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getActualCount(){
    return actualCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setActualCount(BigDecimal newVal) {
    this.actualCount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setActualCount(double newVal) {
    this.actualCount = BigDecimal.valueOf(newVal);
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (IMPRESSIONS.equals(propertyName)) return getImpressions();
    if (TOTALIMPRESSIONS.equals(propertyName)) return getTotalImpressions();
    if (ACTUALUNITCOUNT.equals(propertyName)) return getActualUnitCount();
    if (ACTUALSPOILAGE.equals(propertyName)) return getActualSpoilage();
    if (ACTUALMATERIALS.equals(propertyName)) return getActualMaterials();
    if (SETUPTIME.equals(propertyName)) return getSetupTime();
    if (RUNTIME.equals(propertyName)) return getRunTime();
    if (LABORUNITCOST.equals(propertyName)) return getLaborUnitCost();
    if (LABORCOST.equals(propertyName)) return getLaborCost();
    if (TOTALCOST.equals(propertyName)) return getTotalCost();
    if (ACTUALCOUNT.equals(propertyName)) return getActualCount();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (IMPRESSIONS.equals(propertyName)) setImpressions((Long)newValue); else
    if (TOTALIMPRESSIONS.equals(propertyName)) setTotalImpressions((Long)newValue); else
    if (ACTUALUNITCOUNT.equals(propertyName)) setActualUnitCount((Double)newValue); else
    if (ACTUALSPOILAGE.equals(propertyName)) setActualSpoilage((Double)newValue); else
    if (ACTUALMATERIALS.equals(propertyName)) setActualMaterials((BigDecimal)newValue); else
    if (SETUPTIME.equals(propertyName)) setSetupTime((Double)newValue); else
    if (RUNTIME.equals(propertyName)) setRunTime((Double)newValue); else
    if (LABORUNITCOST.equals(propertyName)) setLaborUnitCost((BigDecimal)newValue); else
    if (LABORCOST.equals(propertyName)) setLaborCost((BigDecimal)newValue); else
    if (TOTALCOST.equals(propertyName)) setTotalCost((BigDecimal)newValue); else
    if (ACTUALCOUNT.equals(propertyName)) setActualCount((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (IMPRESSIONS.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (TOTALIMPRESSIONS.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ACTUALUNITCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALSPOILAGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ACTUALMATERIALS.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SETUPTIME.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (RUNTIME.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LABORUNITCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTUALCOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (IMPRESSIONS.equals(propertyName)) return ChargeCostingRecord.class;
    if (TOTALIMPRESSIONS.equals(propertyName)) return ChargeCostingRecord.class;
    if (ACTUALUNITCOUNT.equals(propertyName)) return ChargeCostingRecord.class;
    if (ACTUALSPOILAGE.equals(propertyName)) return ChargeCostingRecord.class;
    if (ACTUALMATERIALS.equals(propertyName)) return ChargeCostingRecord.class;
    if (SETUPTIME.equals(propertyName)) return ChargeCostingRecord.class;
    if (RUNTIME.equals(propertyName)) return ChargeCostingRecord.class;
    if (LABORUNITCOST.equals(propertyName)) return ChargeCostingRecord.class;
    if (LABORCOST.equals(propertyName)) return ChargeCostingRecord.class;
    if (TOTALCOST.equals(propertyName)) return ChargeCostingRecord.class;
    if (ACTUALCOUNT.equals(propertyName)) return ChargeCostingRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    ChargeCostingRecord objT = (ChargeCostingRecord)obj;
    if (! SmartEquals(getImpressions(), objT.getImpressions()))
      return false;
    if (! SmartEquals(getTotalImpressions(), objT.getTotalImpressions()))
      return false;
    if (! SmartEquals(getActualUnitCount(), objT.getActualUnitCount()))
      return false;
    if (! SmartEquals(getActualSpoilage(), objT.getActualSpoilage()))
      return false;
    if (! SmartEquals(getActualMaterials(), objT.getActualMaterials()))
      return false;
    if (! SmartEquals(getSetupTime(), objT.getSetupTime()))
      return false;
    if (! SmartEquals(getRunTime(), objT.getRunTime()))
      return false;
    if (! SmartEquals(getLaborUnitCost(), objT.getLaborUnitCost()))
      return false;
    if (! SmartEquals(getLaborCost(), objT.getLaborCost()))
      return false;
    if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
      return false;
    if (! SmartEquals(getActualCount(), objT.getActualCount()))
      return false;
    return true;
  }			
}
