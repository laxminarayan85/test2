
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
  @NamedQuery(name = "Charge.findall", query = "from Charge"),
  @NamedQuery(name = "Charge.byId", query = "select a from Charge a where a.id= :id")
})



/**
 * @generated
 */	
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
	public static final String UP = "Up";
	/**
	 * @generated
	 */
	public static final String OVERRIDEUP = "OverrideUp";
	/**
	 * @generated
	 */
	public static final String PARENTJOB = "ParentJob";
	/**
	 * @generated
	 */
	public static final String PARENTINVOICE = "ParentInvoice";
	/**
	 * @generated
	 */
	public static final String MINIMUMCHARGE = "MinimumCharge";
	/**
	 * @generated
	 */
	public static final String SETS = "Sets";
	/**
	 * @generated
	 */
	public static final String MATERIALSETS = "MaterialSets";
	/**
	 * @generated
	 */
	public static final String QTYPERSET = "QtyPerSet";
	/**
	 * @generated
	 */
	public static final String STARTTIME = "StartTime";
	/**
	 * @generated
	 */
	public static final String ENDTIME = "EndTime";
	/**
	 * @generated
	 */
	public static final String CHARGECOSTINGRECORD = "ChargeCostingRecord";

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
    @ManyToOne
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
    @ManyToOne
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
 	@Basic
	private Integer up;
	
	/**
	 * @generated
 	 */
	public Integer getUp(){
    return up; 
  }

	
	/**
	 * @generated
	 */	
	public void setUp(Integer newVal) {
    this.up = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideUp;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideUp(){
    return overrideUp; 
  }

	
	/**
	 * @generated
	 */	
	public void setOverrideUp(Boolean newVal) {
    this.overrideUp = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private JobBase parentJob;
	
	/**
	 * @generated
 	 */
	public JobBase getParentJob(){
    return parentJob; 
  }

	
	/**
	 * @generated
	 */	
	public void setParentJob(JobBase newVal) {
    this.parentJob = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private Invoice parentInvoice;
	
	/**
	 * @generated
 	 */
	public Invoice getParentInvoice(){
    return parentInvoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setParentInvoice(Invoice newVal) {
    this.parentInvoice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double minimumCharge;
	
	/**
	 * @generated
 	 */
	public Double getMinimumCharge(){
    return minimumCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setMinimumCharge(Double newVal) {
    this.minimumCharge = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double sets;
	
	/**
	 * @generated
 	 */
	public Double getSets(){
    return sets; 
  }

	
	/**
	 * @generated
	 */	
	public void setSets(Double newVal) {
    this.sets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double materialSets;
	
	/**
	 * @generated
 	 */
	public Double getMaterialSets(){
    return materialSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setMaterialSets(Double newVal) {
    this.materialSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double qtyPerSet;
	
	/**
	 * @generated
 	 */
	public Double getQtyPerSet(){
    return qtyPerSet; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtyPerSet(Double newVal) {
    this.qtyPerSet = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date startTime;
	
	/**
	 * @generated
 	 */
	public Date getStartTime(){
    return startTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setStartTime(Date newVal) {
    this.startTime = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date endTime;
	
	/**
	 * @generated
 	 */
	public Date getEndTime(){
    return endTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setEndTime(Date newVal) {
    this.endTime = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private ChargeCostingRecord chargeCostingRecord;
	
	/**
	 * @generated
 	 */
	public ChargeCostingRecord getChargeCostingRecord(){
    return chargeCostingRecord; 
  }

	
	/**
	 * @generated
	 */	
	public void setChargeCostingRecord(ChargeCostingRecord newVal) {
    this.chargeCostingRecord = newVal;
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
    if (UP.equals(propertyName)) return getUp();
    if (OVERRIDEUP.equals(propertyName)) return getOverrideUp();
    if (PARENTJOB.equals(propertyName)) return getParentJob();
    if (PARENTINVOICE.equals(propertyName)) return getParentInvoice();
    if (MINIMUMCHARGE.equals(propertyName)) return getMinimumCharge();
    if (SETS.equals(propertyName)) return getSets();
    if (MATERIALSETS.equals(propertyName)) return getMaterialSets();
    if (QTYPERSET.equals(propertyName)) return getQtyPerSet();
    if (STARTTIME.equals(propertyName)) return getStartTime();
    if (ENDTIME.equals(propertyName)) return getEndTime();
    if (CHARGECOSTINGRECORD.equals(propertyName)) return getChargeCostingRecord();
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
    if (UP.equals(propertyName)) setUp((Integer)newValue); else
    if (OVERRIDEUP.equals(propertyName)) setOverrideUp((Boolean)newValue); else
    if (PARENTJOB.equals(propertyName)) setParentJob((JobBase)newValue); else
    if (PARENTINVOICE.equals(propertyName)) setParentInvoice((Invoice)newValue); else
    if (MINIMUMCHARGE.equals(propertyName)) setMinimumCharge((Double)newValue); else
    if (SETS.equals(propertyName)) setSets((Double)newValue); else
    if (MATERIALSETS.equals(propertyName)) setMaterialSets((Double)newValue); else
    if (QTYPERSET.equals(propertyName)) setQtyPerSet((Double)newValue); else
    if (STARTTIME.equals(propertyName)) setStartTime((Date)newValue); else
    if (ENDTIME.equals(propertyName)) setEndTime((Date)newValue); else
    if (CHARGECOSTINGRECORD.equals(propertyName)) setChargeCostingRecord((ChargeCostingRecord)newValue); else
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
    if (UP.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (OVERRIDEUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PARENTJOB.equals(propertyName)) 
      return new Class<?>[] {JobBase.class};		
    if (PARENTINVOICE.equals(propertyName)) 
      return new Class<?>[] {Invoice.class};		
    if (MINIMUMCHARGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SETS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MATERIALSETS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (QTYPERSET.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STARTTIME.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ENDTIME.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CHARGECOSTINGRECORD.equals(propertyName)) 
      return new Class<?>[] {ChargeCostingRecord.class};		
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
    if (UP.equals(propertyName)) return Charge.class;
    if (OVERRIDEUP.equals(propertyName)) return Charge.class;
    if (PARENTJOB.equals(propertyName)) return Charge.class;
    if (PARENTINVOICE.equals(propertyName)) return Charge.class;
    if (MINIMUMCHARGE.equals(propertyName)) return Charge.class;
    if (SETS.equals(propertyName)) return Charge.class;
    if (MATERIALSETS.equals(propertyName)) return Charge.class;
    if (QTYPERSET.equals(propertyName)) return Charge.class;
    if (STARTTIME.equals(propertyName)) return Charge.class;
    if (ENDTIME.equals(propertyName)) return Charge.class;
    if (CHARGECOSTINGRECORD.equals(propertyName)) return Charge.class;
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
    if (! SmartEquals(getUp(), objT.getUp()))
      return false;
    if (! SmartEquals(getOverrideUp(), objT.getOverrideUp()))
      return false;
    if (! SmartEquals(getParentJob(), objT.getParentJob()))
      return false;
    if (! SmartEquals(getParentInvoice(), objT.getParentInvoice()))
      return false;
    if (! SmartEquals(getMinimumCharge(), objT.getMinimumCharge()))
      return false;
    if (! SmartEquals(getSets(), objT.getSets()))
      return false;
    if (! SmartEquals(getMaterialSets(), objT.getMaterialSets()))
      return false;
    if (! SmartEquals(getQtyPerSet(), objT.getQtyPerSet()))
      return false;
    if (! SmartEquals(getStartTime(), objT.getStartTime()))
      return false;
    if (! SmartEquals(getEndTime(), objT.getEndTime()))
      return false;
    if (! SmartEquals(getChargeCostingRecord(), objT.getChargeCostingRecord()))
      return false;
    return true;
  }			
}
