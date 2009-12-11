package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

/**
 * @generated
 */
 
 
/**
 * @!generated
 */	
@NamedQueries({
	@NamedQuery(name = "ChargeCost.findall", query = "from ChargeCost"),
	@NamedQuery(name = "ChargeCost.byId", query = "select a from ChargeCost a where a.id= :id")
})


@Entity
@Table(name = "chargecost")
public class ChargeCost extends ModelBase {
	/**
	 * @generated
	 */
	public static final String SETUPCOST = "SetupCost";
	/**
	 * @generated
	 */
	public static final String UNITCOST = "UnitCost";
	/**
	 * @generated
	 */
	public static final String RATETABLE = "RateTable";
	/**
	 * @generated
	 */
	public static final String FIXEDMATERIALS = "FixedMaterials";
	/**
	 * @generated
	 */
	public static final String UNITMATERIALS = "UnitMaterials";
	/**
	 * @generated
	 */
	public static final String LABORRATE = "LaborRate";
	/**
	 * @generated
	 */
	public static final String SETUPMINUTES = "SetupMinutes";
	/**
	 * @generated
	 */
	public static final String PIECESPERHOUR = "PiecesPerHour";
	/**
	 * @generated
	 */
	public static final String TOTALUNITCOST = "TotalUnitCost";
	/**
	 * @generated
	 */
	public static final String SPEEDTABLE = "SpeedTable";
	/**
	 * @generated
	 */
	public static final String COSTINGMETHOD = "CostingMethod";

	/**
	 * @generated
	 */
	public ChargeCost() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Double setupCost;
	/**
	 * @generated
 	 */
	public Double getSetupCost(){
		return setupCost; 
	}

	/**
	 * @generated
	 */	
	public void setSetupCost(Double newVal) {
		this.setupCost = newVal;
	}
 	
	
 	@Basic
	private Double unitCost;
	/**
	 * @generated
 	 */
	public Double getUnitCost(){
		return unitCost; 
	}

	/**
	 * @generated
	 */	
	public void setUnitCost(Double newVal) {
		this.unitCost = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private RateTable rateTable;
	/**
	 * @generated
 	 */
	public RateTable getRateTable(){
		return rateTable; 
	}

	/**
	 * @generated
	 */	
	public void setRateTable(RateTable newVal) {
		this.rateTable = newVal;
	}
 	
	
 	@Basic
	private Double fixedMaterials;
	/**
	 * @generated
 	 */
	public Double getFixedMaterials(){
		return fixedMaterials; 
	}

	/**
	 * @generated
	 */	
	public void setFixedMaterials(Double newVal) {
		this.fixedMaterials = newVal;
	}
 	
	
 	@Basic
	private Double unitMaterials;
	/**
	 * @generated
 	 */
	public Double getUnitMaterials(){
		return unitMaterials; 
	}

	/**
	 * @generated
	 */	
	public void setUnitMaterials(Double newVal) {
		this.unitMaterials = newVal;
	}
 	
	
 	@Basic
	private Double laborRate;
	/**
	 * @generated
 	 */
	public Double getLaborRate(){
		return laborRate; 
	}

	/**
	 * @generated
	 */	
	public void setLaborRate(Double newVal) {
		this.laborRate = newVal;
	}
 	
	
 	@Basic
	private Double setupMinutes;
	/**
	 * @generated
 	 */
	public Double getSetupMinutes(){
		return setupMinutes; 
	}

	/**
	 * @generated
	 */	
	public void setSetupMinutes(Double newVal) {
		this.setupMinutes = newVal;
	}
 	
	
 	@Basic
	private Long piecesPerHour;
	/**
	 * @generated
 	 */
	public Long getPiecesPerHour(){
		return piecesPerHour; 
	}

	/**
	 * @generated
	 */	
	public void setPiecesPerHour(Long newVal) {
		this.piecesPerHour = newVal;
	}
 	
	
 	@Basic
	private Double totalUnitCost;
	/**
	 * @generated
 	 */
	public Double getTotalUnitCost(){
		return totalUnitCost; 
	}

	/**
	 * @generated
	 */	
	public void setTotalUnitCost(Double newVal) {
		this.totalUnitCost = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private SpeedTable speedTable;
	/**
	 * @generated
 	 */
	public SpeedTable getSpeedTable(){
		return speedTable; 
	}

	/**
	 * @generated
	 */	
	public void setSpeedTable(SpeedTable newVal) {
		this.speedTable = newVal;
	}
 	
	
 	@Basic
	private String costingMethod;
	/**
	 * @generated
 	 */
	public String getCostingMethod(){
		return costingMethod; 
	}

	/**
	 * @generated
	 */	
	public void setCostingMethod(String newVal) {
		this.costingMethod = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (SETUPCOST.equals(propertyName)) return getSetupCost();
		if (UNITCOST.equals(propertyName)) return getUnitCost();
		if (RATETABLE.equals(propertyName)) return getRateTable();
		if (FIXEDMATERIALS.equals(propertyName)) return getFixedMaterials();
		if (UNITMATERIALS.equals(propertyName)) return getUnitMaterials();
		if (LABORRATE.equals(propertyName)) return getLaborRate();
		if (SETUPMINUTES.equals(propertyName)) return getSetupMinutes();
		if (PIECESPERHOUR.equals(propertyName)) return getPiecesPerHour();
		if (TOTALUNITCOST.equals(propertyName)) return getTotalUnitCost();
		if (SPEEDTABLE.equals(propertyName)) return getSpeedTable();
		if (COSTINGMETHOD.equals(propertyName)) return getCostingMethod();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (SETUPCOST.equals(propertyName)) setSetupCost((Double)newValue); else
		if (UNITCOST.equals(propertyName)) setUnitCost((Double)newValue); else
		if (RATETABLE.equals(propertyName)) setRateTable((RateTable)newValue); else
		if (FIXEDMATERIALS.equals(propertyName)) setFixedMaterials((Double)newValue); else
		if (UNITMATERIALS.equals(propertyName)) setUnitMaterials((Double)newValue); else
		if (LABORRATE.equals(propertyName)) setLaborRate((Double)newValue); else
		if (SETUPMINUTES.equals(propertyName)) setSetupMinutes((Double)newValue); else
		if (PIECESPERHOUR.equals(propertyName)) setPiecesPerHour((Long)newValue); else
		if (TOTALUNITCOST.equals(propertyName)) setTotalUnitCost((Double)newValue); else
		if (SPEEDTABLE.equals(propertyName)) setSpeedTable((SpeedTable)newValue); else
		if (COSTINGMETHOD.equals(propertyName)) setCostingMethod((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (SETUPCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (UNITCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (RATETABLE.equals(propertyName)) 
			return new Class<?>[] {RateTable.class};		
		if (FIXEDMATERIALS.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (UNITMATERIALS.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORRATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SETUPMINUTES.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PIECESPERHOUR.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TOTALUNITCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SPEEDTABLE.equals(propertyName)) 
			return new Class<?>[] {SpeedTable.class};		
		if (COSTINGMETHOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (SETUPCOST.equals(propertyName)) return ChargeCost.class;
		if (UNITCOST.equals(propertyName)) return ChargeCost.class;
		if (RATETABLE.equals(propertyName)) return ChargeCost.class;
		if (FIXEDMATERIALS.equals(propertyName)) return ChargeCost.class;
		if (UNITMATERIALS.equals(propertyName)) return ChargeCost.class;
		if (LABORRATE.equals(propertyName)) return ChargeCost.class;
		if (SETUPMINUTES.equals(propertyName)) return ChargeCost.class;
		if (PIECESPERHOUR.equals(propertyName)) return ChargeCost.class;
		if (TOTALUNITCOST.equals(propertyName)) return ChargeCost.class;
		if (SPEEDTABLE.equals(propertyName)) return ChargeCost.class;
		if (COSTINGMETHOD.equals(propertyName)) return ChargeCost.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ChargeCost objT = (ChargeCost)obj;
		if (! SmartEquals(getSetupCost(), objT.getSetupCost()))
			return false;
		if (! SmartEquals(getUnitCost(), objT.getUnitCost()))
			return false;
		if (! SmartEquals(getRateTable(), objT.getRateTable()))
			return false;
		if (! SmartEquals(getFixedMaterials(), objT.getFixedMaterials()))
			return false;
		if (! SmartEquals(getUnitMaterials(), objT.getUnitMaterials()))
			return false;
		if (! SmartEquals(getLaborRate(), objT.getLaborRate()))
			return false;
		if (! SmartEquals(getSetupMinutes(), objT.getSetupMinutes()))
			return false;
		if (! SmartEquals(getPiecesPerHour(), objT.getPiecesPerHour()))
			return false;
		if (! SmartEquals(getTotalUnitCost(), objT.getTotalUnitCost()))
			return false;
		if (! SmartEquals(getSpeedTable(), objT.getSpeedTable()))
			return false;
		if (! SmartEquals(getCostingMethod(), objT.getCostingMethod()))
			return false;
		return true;
	}			
}