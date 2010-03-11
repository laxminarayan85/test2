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
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "Charge.findall", query = "from Charge"),
	@NamedQuery(name = "Charge.byId", query = "select a from Charge a where a.id= :id")
})


@Entity
@Table(name = "charge")
public class Charge extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CHARGEDEFINITION = "ChargeDefinition";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String NOTES = "Notes";
	/**
	 * @generated
	 */
	public static final String PRODUCTIONLOCATION = "ProductionLocation";
	/**
	 * @generated
	 */
	public static final String SHOWNOTES = "ShowNotes";
	/**
	 * @generated
	 */
	public static final String FINISHED = "Finished";
	/**
	 * @generated
	 */
	public static final String TAXABLE = "Taxable";
	/**
	 * @generated
	 */
	public static final String BROKERED = "Brokered";
	/**
	 * @generated
	 */
	public static final String DISPLAYQTY = "DisplayQty";
	/**
	 * @generated
	 */
	public static final String HIDDEN = "Hidden";
	/**
	 * @generated
	 */
	public static final String HIDEPRICE = "HidePrice";
	/**
	 * @generated
	 */
	public static final String PRICE = "Price";
	/**
	 * @generated
	 */
	public static final String OVERRIDEPRICE = "OverridePrice";
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String OVERRIDEQUANTITY = "OverrideQuantity";
	/**
	 * @generated
	 */
	public static final String MATERIALQTY = "MaterialQty";
	/**
	 * @generated
	 */
	public static final String OVERRIDEMATERIALQUANTITY = "OverrideMaterialQuantity";
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String OVERRIDERATE = "OverrideRate";

	/**
	 * @generated
	 */
	public Charge() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private ChargeDefinition chargeDefinition;
	
	/**
	 * @generated
 	 */
	public ChargeDefinition getChargeDefinition(){
		return chargeDefinition; 
	}

	
	/**
	 * @generated
	 */	
	public void setChargeDefinition(ChargeDefinition newVal) {
		this.chargeDefinition = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
		return description; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
		this.description = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String notes;
	
	/**
	 * @generated
 	 */
	public String getNotes(){
		return notes; 
	}

	
	/**
	 * @generated
	 */	
	public void setNotes(String newVal) {
		this.notes = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Location productionLocation;
	
	/**
	 * @generated
 	 */
	public Location getProductionLocation(){
		return productionLocation; 
	}

	
	/**
	 * @generated
	 */	
	public void setProductionLocation(Location newVal) {
		this.productionLocation = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showNotes;
	
	/**
	 * @generated
 	 */
	public Boolean getShowNotes(){
		return showNotes; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowNotes(Boolean newVal) {
		this.showNotes = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean finished;
	
	/**
	 * @generated
 	 */
	public Boolean getFinished(){
		return finished; 
	}

	
	/**
	 * @generated
	 */	
	public void setFinished(Boolean newVal) {
		this.finished = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxable;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxable(){
		return taxable; 
	}

	
	/**
	 * @generated
	 */	
	public void setTaxable(Boolean newVal) {
		this.taxable = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean brokered;
	
	/**
	 * @generated
 	 */
	public Boolean getBrokered(){
		return brokered; 
	}

	
	/**
	 * @generated
	 */	
	public void setBrokered(Boolean newVal) {
		this.brokered = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean displayQty;
	
	/**
	 * @generated
 	 */
	public Boolean getDisplayQty(){
		return displayQty; 
	}

	
	/**
	 * @generated
	 */	
	public void setDisplayQty(Boolean newVal) {
		this.displayQty = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hidden;
	
	/**
	 * @generated
 	 */
	public Boolean getHidden(){
		return hidden; 
	}

	
	/**
	 * @generated
	 */	
	public void setHidden(Boolean newVal) {
		this.hidden = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hidePrice;
	
	/**
	 * @generated
 	 */
	public Boolean getHidePrice(){
		return hidePrice; 
	}

	
	/**
	 * @generated
	 */	
	public void setHidePrice(Boolean newVal) {
		this.hidePrice = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double price;
	
	/**
	 * @generated
 	 */
	public Double getPrice(){
		return price; 
	}

	
	/**
	 * @generated
	 */	
	public void setPrice(Double newVal) {
		this.price = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overridePrice;
	
	/**
	 * @generated
 	 */
	public Boolean getOverridePrice(){
		return overridePrice; 
	}

	
	/**
	 * @generated
	 */	
	public void setOverridePrice(Boolean newVal) {
		this.overridePrice = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double quantity;
	
	/**
	 * @generated
 	 */
	public Double getQuantity(){
		return quantity; 
	}

	
	/**
	 * @generated
	 */	
	public void setQuantity(Double newVal) {
		this.quantity = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideQuantity;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideQuantity(){
		return overrideQuantity; 
	}

	
	/**
	 * @generated
	 */	
	public void setOverrideQuantity(Boolean newVal) {
		this.overrideQuantity = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double materialQty;
	
	/**
	 * @generated
 	 */
	public Double getMaterialQty(){
		return materialQty; 
	}

	
	/**
	 * @generated
	 */	
	public void setMaterialQty(Double newVal) {
		this.materialQty = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideMaterialQuantity;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideMaterialQuantity(){
		return overrideMaterialQuantity; 
	}

	
	/**
	 * @generated
	 */	
	public void setOverrideMaterialQuantity(Boolean newVal) {
		this.overrideMaterialQuantity = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double rate;
	
	/**
	 * @generated
 	 */
	public Double getRate(){
		return rate; 
	}

	
	/**
	 * @generated
	 */	
	public void setRate(Double newVal) {
		this.rate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideRate;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideRate(){
		return overrideRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setOverrideRate(Boolean newVal) {
		this.overrideRate = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CHARGEDEFINITION.equals(propertyName)) return getChargeDefinition();
		if (DESCRIPTION.equals(propertyName)) return getDescription();
		if (NOTES.equals(propertyName)) return getNotes();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (SHOWNOTES.equals(propertyName)) return getShowNotes();
		if (FINISHED.equals(propertyName)) return getFinished();
		if (TAXABLE.equals(propertyName)) return getTaxable();
		if (BROKERED.equals(propertyName)) return getBrokered();
		if (DISPLAYQTY.equals(propertyName)) return getDisplayQty();
		if (HIDDEN.equals(propertyName)) return getHidden();
		if (HIDEPRICE.equals(propertyName)) return getHidePrice();
		if (PRICE.equals(propertyName)) return getPrice();
		if (OVERRIDEPRICE.equals(propertyName)) return getOverridePrice();
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (OVERRIDEQUANTITY.equals(propertyName)) return getOverrideQuantity();
		if (MATERIALQTY.equals(propertyName)) return getMaterialQty();
		if (OVERRIDEMATERIALQUANTITY.equals(propertyName)) return getOverrideMaterialQuantity();
		if (RATE.equals(propertyName)) return getRate();
		if (OVERRIDERATE.equals(propertyName)) return getOverrideRate();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CHARGEDEFINITION.equals(propertyName)) setChargeDefinition((ChargeDefinition)newValue); else
		if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
		if (NOTES.equals(propertyName)) setNotes((String)newValue); else
		if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((Location)newValue); else
		if (SHOWNOTES.equals(propertyName)) setShowNotes((Boolean)newValue); else
		if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else
		if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
		if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else
		if (DISPLAYQTY.equals(propertyName)) setDisplayQty((Boolean)newValue); else
		if (HIDDEN.equals(propertyName)) setHidden((Boolean)newValue); else
		if (HIDEPRICE.equals(propertyName)) setHidePrice((Boolean)newValue); else
		if (PRICE.equals(propertyName)) setPrice((Double)newValue); else
		if (OVERRIDEPRICE.equals(propertyName)) setOverridePrice((Boolean)newValue); else
		if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else
		if (OVERRIDEQUANTITY.equals(propertyName)) setOverrideQuantity((Boolean)newValue); else
		if (MATERIALQTY.equals(propertyName)) setMaterialQty((Double)newValue); else
		if (OVERRIDEMATERIALQUANTITY.equals(propertyName)) setOverrideMaterialQuantity((Boolean)newValue); else
		if (RATE.equals(propertyName)) setRate((Double)newValue); else
		if (OVERRIDERATE.equals(propertyName)) setOverrideRate((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CHARGEDEFINITION.equals(propertyName)) 
			return new Class<?>[] {ChargeDefinition.class};		
		if (DESCRIPTION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PRODUCTIONLOCATION.equals(propertyName)) 
			return new Class<?>[] {Location.class};		
		if (SHOWNOTES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FINISHED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (BROKERED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DISPLAYQTY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HIDDEN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HIDEPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRICE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (OVERRIDEPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (QUANTITY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (OVERRIDEQUANTITY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MATERIALQTY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (OVERRIDEMATERIALQUANTITY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (RATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (OVERRIDERATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CHARGEDEFINITION.equals(propertyName)) return Charge.class;
		if (DESCRIPTION.equals(propertyName)) return Charge.class;
		if (NOTES.equals(propertyName)) return Charge.class;
		if (PRODUCTIONLOCATION.equals(propertyName)) return Charge.class;
		if (SHOWNOTES.equals(propertyName)) return Charge.class;
		if (FINISHED.equals(propertyName)) return Charge.class;
		if (TAXABLE.equals(propertyName)) return Charge.class;
		if (BROKERED.equals(propertyName)) return Charge.class;
		if (DISPLAYQTY.equals(propertyName)) return Charge.class;
		if (HIDDEN.equals(propertyName)) return Charge.class;
		if (HIDEPRICE.equals(propertyName)) return Charge.class;
		if (PRICE.equals(propertyName)) return Charge.class;
		if (OVERRIDEPRICE.equals(propertyName)) return Charge.class;
		if (QUANTITY.equals(propertyName)) return Charge.class;
		if (OVERRIDEQUANTITY.equals(propertyName)) return Charge.class;
		if (MATERIALQTY.equals(propertyName)) return Charge.class;
		if (OVERRIDEMATERIALQUANTITY.equals(propertyName)) return Charge.class;
		if (RATE.equals(propertyName)) return Charge.class;
		if (OVERRIDERATE.equals(propertyName)) return Charge.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Charge objT = (Charge)obj;
		if (! SmartEquals(getChargeDefinition(), objT.getChargeDefinition()))
			return false;
		if (! SmartEquals(getDescription(), objT.getDescription()))
			return false;
		if (! SmartEquals(getNotes(), objT.getNotes()))
			return false;
		if (! SmartEquals(getProductionLocation(), objT.getProductionLocation()))
			return false;
		if (! SmartEquals(getShowNotes(), objT.getShowNotes()))
			return false;
		if (! SmartEquals(getFinished(), objT.getFinished()))
			return false;
		if (! SmartEquals(getTaxable(), objT.getTaxable()))
			return false;
		if (! SmartEquals(getBrokered(), objT.getBrokered()))
			return false;
		if (! SmartEquals(getDisplayQty(), objT.getDisplayQty()))
			return false;
		if (! SmartEquals(getHidden(), objT.getHidden()))
			return false;
		if (! SmartEquals(getHidePrice(), objT.getHidePrice()))
			return false;
		if (! SmartEquals(getPrice(), objT.getPrice()))
			return false;
		if (! SmartEquals(getOverridePrice(), objT.getOverridePrice()))
			return false;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getOverrideQuantity(), objT.getOverrideQuantity()))
			return false;
		if (! SmartEquals(getMaterialQty(), objT.getMaterialQty()))
			return false;
		if (! SmartEquals(getOverrideMaterialQuantity(), objT.getOverrideMaterialQuantity()))
			return false;
		if (! SmartEquals(getRate(), objT.getRate()))
			return false;
		if (! SmartEquals(getOverrideRate(), objT.getOverrideRate()))
			return false;
		return true;
	}			
}