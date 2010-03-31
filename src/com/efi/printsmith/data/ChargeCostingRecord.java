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
	@NamedQuery(name = "ChargeCostingRecord.findall", query = "from ChargeCostingRecord"),
	@NamedQuery(name = "ChargeCostingRecord.byId", query = "select a from ChargeCostingRecord a where a.id= :id")
})


@Entity
@Table(name = "chargecostingrecord")
//@org.hibernate.annotations.Table( appliesTo = "chargecostingrecord", fetch = FetchMode.SELECT, optional=false )
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
	public static final String ATTRIBUTE3 = "Attribute3";
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
	private Integer attribute3;
	
	/**
	 * @generated
 	 */
	public Integer getAttribute3(){
		return attribute3; 
	}

	
	/**
	 * @generated
	 */	
	public void setAttribute3(Integer newVal) {
		this.attribute3 = newVal;
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
	private Double laborUnitCost;
	
	/**
	 * @generated
 	 */
	public Double getLaborUnitCost(){
		return laborUnitCost; 
	}

	
	/**
	 * @generated
	 */	
	public void setLaborUnitCost(Double newVal) {
		this.laborUnitCost = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double laborCost;
	
	/**
	 * @generated
 	 */
	public Double getLaborCost(){
		return laborCost; 
	}

	
	/**
	 * @generated
	 */	
	public void setLaborCost(Double newVal) {
		this.laborCost = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double totalCost;
	
	/**
	 * @generated
 	 */
	public Double getTotalCost(){
		return totalCost; 
	}

	
	/**
	 * @generated
	 */	
	public void setTotalCost(Double newVal) {
		this.totalCost = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double actualCount;
	
	/**
	 * @generated
 	 */
	public Double getActualCount(){
		return actualCount; 
	}

	
	/**
	 * @generated
	 */	
	public void setActualCount(Double newVal) {
		this.actualCount = newVal;
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
		if (ATTRIBUTE3.equals(propertyName)) return getAttribute3();
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
		if (ACTUALMATERIALS.equals(propertyName)) setActualMaterials((Double)newValue); else
		if (ATTRIBUTE3.equals(propertyName)) setAttribute3((Integer)newValue); else
		if (SETUPTIME.equals(propertyName)) setSetupTime((Double)newValue); else
		if (RUNTIME.equals(propertyName)) setRunTime((Double)newValue); else
		if (LABORUNITCOST.equals(propertyName)) setLaborUnitCost((Double)newValue); else
		if (LABORCOST.equals(propertyName)) setLaborCost((Double)newValue); else
		if (TOTALCOST.equals(propertyName)) setTotalCost((Double)newValue); else
		if (ACTUALCOUNT.equals(propertyName)) setActualCount((Double)newValue); else
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
			return new Class<?>[] {Double.class};		
		if (ATTRIBUTE3.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SETUPTIME.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (RUNTIME.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORUNITCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TOTALCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (ACTUALCOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
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
		if (ATTRIBUTE3.equals(propertyName)) return ChargeCostingRecord.class;
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
		if (! SmartEquals(getAttribute3(), objT.getAttribute3()))
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