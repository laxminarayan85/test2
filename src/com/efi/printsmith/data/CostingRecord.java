
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
	@NamedQuery(name = "CostingRecord.findall", query = "from CostingRecord"),
	@NamedQuery(name = "CostingRecord.byId", query = "select a from CostingRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "costingrecord")
public class CostingRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String UNITCOST = "UnitCost";
	/**
	 * @generated
	 */
	public static final String TOTALCOST = "TotalCost";
	/**
	 * @generated
	 */
	public static final String LABORCOST = "LaborCost";
	/**
	 * @generated
	 */
	public static final String STOCKCOST = "StockCost";

	/**
	 * @generated
	 */
	public CostingRecord() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
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
	private Double stockCost;
	
	/**
	 * @generated
 	 */
	public Double getStockCost(){
		return stockCost; 
	}

	
	/**
	 * @generated
	 */	
	public void setStockCost(Double newVal) {
		this.stockCost = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (UNITCOST.equals(propertyName)) return getUnitCost();
		if (TOTALCOST.equals(propertyName)) return getTotalCost();
		if (LABORCOST.equals(propertyName)) return getLaborCost();
		if (STOCKCOST.equals(propertyName)) return getStockCost();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (UNITCOST.equals(propertyName)) setUnitCost((Double)newValue); else
		if (TOTALCOST.equals(propertyName)) setTotalCost((Double)newValue); else
		if (LABORCOST.equals(propertyName)) setLaborCost((Double)newValue); else
		if (STOCKCOST.equals(propertyName)) setStockCost((Double)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (UNITCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TOTALCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (STOCKCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (UNITCOST.equals(propertyName)) return CostingRecord.class;
		if (TOTALCOST.equals(propertyName)) return CostingRecord.class;
		if (LABORCOST.equals(propertyName)) return CostingRecord.class;
		if (STOCKCOST.equals(propertyName)) return CostingRecord.class;
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
		if (! SmartEquals(getUnitCost(), objT.getUnitCost()))
			return false;
		if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
			return false;
		if (! SmartEquals(getLaborCost(), objT.getLaborCost()))
			return false;
		if (! SmartEquals(getStockCost(), objT.getStockCost()))
			return false;
		return true;
	}			
}