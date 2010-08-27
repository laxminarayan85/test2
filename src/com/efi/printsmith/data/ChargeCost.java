
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
  @NamedQuery(name = "ChargeCost.findall", query = "from ChargeCost"),
  @NamedQuery(name = "ChargeCost.byId", query = "select a from ChargeCost a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargecost")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from chargecost where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
	public static final String COSTINGMETHOD = "CostingMethod";
	/**
	 * @generated
	 */
	public static final String SPEEDTABLE = "SpeedTable";

	/**
	 * @generated
	 */
	public ChargeCost() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal setupCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSetupCost(){
    return setupCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setSetupCost(BigDecimal newVal) {
    this.setupCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setSetupCost(double newVal) {
    this.setupCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal unitCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getUnitCost(){
    return unitCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitCost(BigDecimal newVal) {
    this.unitCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setUnitCost(double newVal) {
    this.unitCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private PriceList rateTable;
	
	/**
	 * @generated
 	 */
	public PriceList getRateTable(){
    return rateTable; 
  }

	
	/**
	 * @generated
	 */	
	public void setRateTable(PriceList newVal) {
    this.rateTable = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal fixedMaterials;
	
	/**
	 * @generated
 	 */
	public BigDecimal getFixedMaterials(){
    return fixedMaterials; 
  }

	
	/**
	 * @generated
	 */	
	public void setFixedMaterials(BigDecimal newVal) {
    this.fixedMaterials = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setFixedMaterials(double newVal) {
    this.fixedMaterials = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal unitMaterials;
	
	/**
	 * @generated
 	 */
	public BigDecimal getUnitMaterials(){
    return unitMaterials; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitMaterials(BigDecimal newVal) {
    this.unitMaterials = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setUnitMaterials(double newVal) {
    this.unitMaterials = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal laborRate;
	
	/**
	 * @generated
 	 */
	public BigDecimal getLaborRate(){
    return laborRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborRate(BigDecimal newVal) {
    this.laborRate = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setLaborRate(double newVal) {
    this.laborRate = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
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
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double piecesPerHour;
	
	/**
	 * @generated
 	 */
	public Double getPiecesPerHour(){
    return piecesPerHour; 
  }

	
	/**
	 * @generated
	 */	
	public void setPiecesPerHour(Double newVal) {
    this.piecesPerHour = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal totalUnitCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalUnitCost(){
    return totalUnitCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalUnitCost(BigDecimal newVal) {
    this.totalUnitCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotalUnitCost(double newVal) {
    this.totalUnitCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
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
    @ManyToOne()
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
    if (COSTINGMETHOD.equals(propertyName)) return getCostingMethod();
    if (SPEEDTABLE.equals(propertyName)) return getSpeedTable();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SETUPCOST.equals(propertyName)) setSetupCost((BigDecimal)newValue); else
    if (UNITCOST.equals(propertyName)) setUnitCost((BigDecimal)newValue); else
    if (RATETABLE.equals(propertyName)) setRateTable((PriceList)newValue); else
    if (FIXEDMATERIALS.equals(propertyName)) setFixedMaterials((BigDecimal)newValue); else
    if (UNITMATERIALS.equals(propertyName)) setUnitMaterials((BigDecimal)newValue); else
    if (LABORRATE.equals(propertyName)) setLaborRate((BigDecimal)newValue); else
    if (SETUPMINUTES.equals(propertyName)) setSetupMinutes((Double)newValue); else
    if (PIECESPERHOUR.equals(propertyName)) setPiecesPerHour((Double)newValue); else
    if (TOTALUNITCOST.equals(propertyName)) setTotalUnitCost((BigDecimal)newValue); else
    if (COSTINGMETHOD.equals(propertyName)) setCostingMethod((String)newValue); else
    if (SPEEDTABLE.equals(propertyName)) setSpeedTable((SpeedTable)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (SETUPCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (UNITCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (RATETABLE.equals(propertyName)) 
      return new Class<?>[] {PriceList.class};		
    if (FIXEDMATERIALS.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (UNITMATERIALS.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORRATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SETUPMINUTES.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PIECESPERHOUR.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOTALUNITCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (COSTINGMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SPEEDTABLE.equals(propertyName)) 
      return new Class<?>[] {SpeedTable.class};		
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
    if (COSTINGMETHOD.equals(propertyName)) return ChargeCost.class;
    if (SPEEDTABLE.equals(propertyName)) return ChargeCost.class;
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
    if (! SmartEquals(getCostingMethod(), objT.getCostingMethod()))
      return false;
    if (! SmartEquals(getSpeedTable(), objT.getSpeedTable()))
      return false;
    return true;
  }			
}
