
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

  @NamedQuery(name = "Charge.findall", query = "from Charge"),

  @NamedQuery(name = "Charge.byId", query = "select a from Charge a where a.id= :id")

})



/**
 * @generated
 */	
@Entity
@Table(name = "charge")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from charge where modelbase.id=?")
@SQLDelete(sql="update charge set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
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
	public static final String STARTHOURS = "StartHours";
	/**
	 * @generated
	 */
	public static final String ENDHOURS = "EndHours";
	/**
	 * @generated
	 */
	public static final String CHARGECOSTINGRECORD = "ChargeCostingRecord";
	/**
	 * @generated
	 */
	public static final String NEXTRECORD = "NextRecord";
	/**
	 * @generated
	 */
	public static final String STARTMINUTES = "StartMinutes";
	/**
	 * @generated
	 */
	public static final String ENDMINUTES = "EndMinutes";
	/**
	 * @generated
	 */
	public static final String OVERRIDEWEIGHT = "OverrideWeight";
	/**
	 * @generated
	 */
	public static final String LINEARX1 = "LinearX1";
	/**
	 * @generated
	 */
	public static final String LINEARX2 = "LinearX2";
	/**
	 * @generated
	 */
	public static final String LINEARY1 = "LinearY1";
	/**
	 * @generated
	 */
	public static final String LINEARY2 = "LinearY2";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String CHARGENUMBER = "ChargeNumber";
	/**
	 * @generated
	 */
	public static final String FROMACCOUNT = "FromAccount";

	/**

   * @generated

   */

  public static final String JOBINDEX = "JobIndex";
	/**

   * @generated

   */

  public static final String CHARGEINDEX = "ChargeIndex";

	/**
	 * @generated
	 */
	public Charge() {

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
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private ProductionLocations productionLocation;
	
	/**
	 * @generated
 	 */
	public ProductionLocations getProductionLocation(){

    return productionLocation; 

  }

	
	/**
	 * @generated
	 */	
	public void setProductionLocation(ProductionLocations newVal) {

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
	private BigDecimal price;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrice(){

    return price; 

  }

	
	/**
	 * @generated
	 */	
	public void setPrice(BigDecimal newVal) {

    this.price = newVal;

  }
	
	/**
	 * @generated
	 */	
	public void setPrice(double newVal) {

    this.price = BigDecimal.valueOf(newVal);

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
	private BigDecimal rate;
	
	/**
	 * @generated
 	 */
	public BigDecimal getRate(){

    return rate; 

  }

	
	/**
	 * @generated
	 */	
	public void setRate(BigDecimal newVal) {

    this.rate = newVal;

  }
	
	/**
	 * @generated
	 */	
	public void setRate(double newVal) {

    this.rate = BigDecimal.valueOf(newVal);

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
    @ManyToOne(fetch=FetchType.LAZY)
    @Where(clause="isdeleted <> 'TRUE'")
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
    @ManyToOne(fetch=FetchType.LAZY, optional=true)
    @Where(clause="isdeleted <> 'TRUE'")
	private InvoiceBase parentInvoice;
	
	/**
	 * @generated
 	 */
	public InvoiceBase getParentInvoice(){

    return parentInvoice; 

  }

	
	/**
	 * @generated
	 */	
	public void setParentInvoice(InvoiceBase newVal) {

    this.parentInvoice = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal minimumCharge;
	
	/**
	 * @generated
 	 */
	public BigDecimal getMinimumCharge(){

    return minimumCharge; 

  }

	
	/**
	 * @generated
	 */	
	public void setMinimumCharge(BigDecimal newVal) {

    this.minimumCharge = newVal;

  }
	
	/**
	 * @generated
	 */	
	public void setMinimumCharge(double newVal) {

    this.minimumCharge = BigDecimal.valueOf(newVal);

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
	private Integer startHours;
	
	/**
	 * @generated
 	 */
	public Integer getStartHours(){

    return startHours; 

  }

	
	/**
	 * @generated
	 */	
	public void setStartHours(Integer newVal) {

    this.startHours = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer endHours;
	
	/**
	 * @generated
 	 */
	public Integer getEndHours(){

    return endHours; 

  }

	
	/**
	 * @generated
	 */	
	public void setEndHours(Integer newVal) {

    this.endHours = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
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
 	@Basic
	private String nextRecord;
	
	/**
	 * @generated
 	 */
	public String getNextRecord(){

    return nextRecord; 

  }

	
	/**
	 * @generated
	 */	
	public void setNextRecord(String newVal) {

    this.nextRecord = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer startMinutes;
	
	/**
	 * @generated
 	 */
	public Integer getStartMinutes(){

    return startMinutes; 

  }

	
	/**
	 * @generated
	 */	
	public void setStartMinutes(Integer newVal) {

    this.startMinutes = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer endMinutes;
	
	/**
	 * @generated
 	 */
	public Integer getEndMinutes(){

    return endMinutes; 

  }

	
	/**
	 * @generated
	 */	
	public void setEndMinutes(Integer newVal) {

    this.endMinutes = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean overrideWeight;
	
	/**
	 * @generated
 	 */
	public Boolean getOverrideWeight(){

    return overrideWeight; 

  }

	
	/**
	 * @generated
	 */	
	public void setOverrideWeight(Boolean newVal) {

    this.overrideWeight = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean linearX1;
	
	/**
	 * @generated
 	 */
	public Boolean getLinearX1(){

    return linearX1; 

  }

	
	/**
	 * @generated
	 */	
	public void setLinearX1(Boolean newVal) {

    this.linearX1 = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean linearX2;
	
	/**
	 * @generated
 	 */
	public Boolean getLinearX2(){

    return linearX2; 

  }

	
	/**
	 * @generated
	 */	
	public void setLinearX2(Boolean newVal) {

    this.linearX2 = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean linearY1;
	
	/**
	 * @generated
 	 */
	public Boolean getLinearY1(){

    return linearY1; 

  }

	
	/**
	 * @generated
	 */	
	public void setLinearY1(Boolean newVal) {

    this.linearY1 = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean linearY2;
	
	/**
	 * @generated
 	 */
	public Boolean getLinearY2(){

    return linearY2; 

  }

	
	/**
	 * @generated
	 */	
	public void setLinearY2(Boolean newVal) {

    this.linearY2 = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private TaxTable taxTable;
	
	/**
	 * @generated
 	 */
	public TaxTable getTaxTable(){

    return taxTable; 

  }

	
	/**
	 * @generated
	 */	
	public void setTaxTable(TaxTable newVal) {

    this.taxTable = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long chargeNumber;
	
	/**
	 * @generated
 	 */
	public Long getChargeNumber(){

    return chargeNumber; 

  }

	
	/**
	 * @generated
	 */	
	public void setChargeNumber(Long newVal) {

    this.chargeNumber = newVal;

  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean fromAccount;
	
	/**
	 * @generated
 	 */
	public Boolean getFromAccount(){

    return fromAccount; 

  }

	
	/**
	 * @generated
	 */	
	public void setFromAccount(Boolean newVal) {

    this.fromAccount = newVal;

  }
	
	/**

   * @generated

   */	

 	@Basic

  private Long jobIndex;

	/**

   * @generated

 	 */

  public Long getJobIndex(){

    return jobIndex; 

  }

	/**

   * @generated

   */	

  public void setJobIndex(Long newVal) {

    this.jobIndex = newVal;

  }

	/**

   * @generated

   */	

 	@Basic

  private Long chargeIndex;

	/**

   * @generated

 	 */

  public Long getChargeIndex(){

    return chargeIndex; 

  }

	/**

   * @generated

   */	

  public void setChargeIndex(Long newVal) {

    this.chargeIndex = newVal;

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

    if (STARTHOURS.equals(propertyName)) return getStartHours();

    if (ENDHOURS.equals(propertyName)) return getEndHours();

    if (CHARGECOSTINGRECORD.equals(propertyName)) return getChargeCostingRecord();

    if (NEXTRECORD.equals(propertyName)) return getNextRecord();

    if (STARTMINUTES.equals(propertyName)) return getStartMinutes();

    if (ENDMINUTES.equals(propertyName)) return getEndMinutes();

    if (OVERRIDEWEIGHT.equals(propertyName)) return getOverrideWeight();

    if (LINEARX1.equals(propertyName)) return getLinearX1();

    if (LINEARX2.equals(propertyName)) return getLinearX2();

    if (LINEARY1.equals(propertyName)) return getLinearY1();

    if (LINEARY2.equals(propertyName)) return getLinearY2();

    if (TAXTABLE.equals(propertyName)) return getTaxTable();

    if (CHARGENUMBER.equals(propertyName)) return getChargeNumber();

    if (FROMACCOUNT.equals(propertyName)) return getFromAccount();

    if (JOBINDEX.equals(propertyName)) return getJobIndex();

    if (CHARGEINDEX.equals(propertyName)) return getChargeIndex();

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

    if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((ProductionLocations)newValue); else

    if (SHOWNOTES.equals(propertyName)) setShowNotes((Boolean)newValue); else

    if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else

    if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else

    if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else

    if (DISPLAYQTY.equals(propertyName)) setDisplayQty((Boolean)newValue); else

    if (HIDDEN.equals(propertyName)) setHidden((Boolean)newValue); else

    if (HIDEPRICE.equals(propertyName)) setHidePrice((Boolean)newValue); else

    if (PRICE.equals(propertyName)) setPrice((BigDecimal)newValue); else

    if (OVERRIDEPRICE.equals(propertyName)) setOverridePrice((Boolean)newValue); else

    if (QUANTITY.equals(propertyName)) setQuantity((Double)newValue); else

    if (OVERRIDEQUANTITY.equals(propertyName)) setOverrideQuantity((Boolean)newValue); else

    if (MATERIALQTY.equals(propertyName)) setMaterialQty((Double)newValue); else

    if (OVERRIDEMATERIALQUANTITY.equals(propertyName)) setOverrideMaterialQuantity((Boolean)newValue); else

    if (RATE.equals(propertyName)) setRate((BigDecimal)newValue); else

    if (OVERRIDERATE.equals(propertyName)) setOverrideRate((Boolean)newValue); else

    if (UP.equals(propertyName)) setUp((Integer)newValue); else

    if (OVERRIDEUP.equals(propertyName)) setOverrideUp((Boolean)newValue); else

    if (PARENTJOB.equals(propertyName)) setParentJob((JobBase)newValue); else

    if (PARENTINVOICE.equals(propertyName)) setParentInvoice((InvoiceBase)newValue); else

    if (MINIMUMCHARGE.equals(propertyName)) setMinimumCharge((BigDecimal)newValue); else

    if (SETS.equals(propertyName)) setSets((Double)newValue); else

    if (MATERIALSETS.equals(propertyName)) setMaterialSets((Double)newValue); else

    if (QTYPERSET.equals(propertyName)) setQtyPerSet((Double)newValue); else

    if (STARTHOURS.equals(propertyName)) setStartHours((Integer)newValue); else

    if (ENDHOURS.equals(propertyName)) setEndHours((Integer)newValue); else

    if (CHARGECOSTINGRECORD.equals(propertyName)) setChargeCostingRecord((ChargeCostingRecord)newValue); else

    if (NEXTRECORD.equals(propertyName)) setNextRecord((String)newValue); else

    if (STARTMINUTES.equals(propertyName)) setStartMinutes((Integer)newValue); else

    if (ENDMINUTES.equals(propertyName)) setEndMinutes((Integer)newValue); else

    if (OVERRIDEWEIGHT.equals(propertyName)) setOverrideWeight((Boolean)newValue); else

    if (LINEARX1.equals(propertyName)) setLinearX1((Boolean)newValue); else

    if (LINEARX2.equals(propertyName)) setLinearX2((Boolean)newValue); else

    if (LINEARY1.equals(propertyName)) setLinearY1((Boolean)newValue); else

    if (LINEARY2.equals(propertyName)) setLinearY2((Boolean)newValue); else

    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else

    if (CHARGENUMBER.equals(propertyName)) setChargeNumber((Long)newValue); else

    if (FROMACCOUNT.equals(propertyName)) setFromAccount((Boolean)newValue); else

    if (JOBINDEX.equals(propertyName)) setJobIndex((Long)newValue); else

    if (CHARGEINDEX.equals(propertyName)) setChargeIndex((Long)newValue); else

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

      return new Class<?>[] {ProductionLocations.class};		

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

      return new Class<?>[] {BigDecimal.class};		

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

      return new Class<?>[] {BigDecimal.class};		

    if (OVERRIDERATE.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (UP.equals(propertyName)) 

      return new Class<?>[] {Integer.class};		

    if (OVERRIDEUP.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (PARENTJOB.equals(propertyName)) 

      return new Class<?>[] {JobBase.class};		

    if (PARENTINVOICE.equals(propertyName)) 

      return new Class<?>[] {InvoiceBase.class};		

    if (MINIMUMCHARGE.equals(propertyName)) 

      return new Class<?>[] {BigDecimal.class};		

    if (SETS.equals(propertyName)) 

      return new Class<?>[] {Double.class};		

    if (MATERIALSETS.equals(propertyName)) 

      return new Class<?>[] {Double.class};		

    if (QTYPERSET.equals(propertyName)) 

      return new Class<?>[] {Double.class};		

    if (STARTHOURS.equals(propertyName)) 

      return new Class<?>[] {Integer.class};		

    if (ENDHOURS.equals(propertyName)) 

      return new Class<?>[] {Integer.class};		

    if (CHARGECOSTINGRECORD.equals(propertyName)) 

      return new Class<?>[] {ChargeCostingRecord.class};		

    if (NEXTRECORD.equals(propertyName)) 

      return new Class<?>[] {String.class};		

    if (STARTMINUTES.equals(propertyName)) 

      return new Class<?>[] {Integer.class};		

    if (ENDMINUTES.equals(propertyName)) 

      return new Class<?>[] {Integer.class};		

    if (OVERRIDEWEIGHT.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (LINEARX1.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (LINEARX2.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (LINEARY1.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (LINEARY2.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (TAXTABLE.equals(propertyName)) 

      return new Class<?>[] {TaxTable.class};		

    if (CHARGENUMBER.equals(propertyName)) 

      return new Class<?>[] {Long.class};		

    if (FROMACCOUNT.equals(propertyName)) 

      return new Class<?>[] {Boolean.class};		

    if (JOBINDEX.equals(propertyName)) 

      return new Class<?>[] {Long.class};		

    if (CHARGEINDEX.equals(propertyName)) 

      return new Class<?>[] {Long.class};		

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

    if (STARTHOURS.equals(propertyName)) return Charge.class;

    if (ENDHOURS.equals(propertyName)) return Charge.class;

    if (CHARGECOSTINGRECORD.equals(propertyName)) return Charge.class;

    if (NEXTRECORD.equals(propertyName)) return Charge.class;

    if (STARTMINUTES.equals(propertyName)) return Charge.class;

    if (ENDMINUTES.equals(propertyName)) return Charge.class;

    if (OVERRIDEWEIGHT.equals(propertyName)) return Charge.class;

    if (LINEARX1.equals(propertyName)) return Charge.class;

    if (LINEARX2.equals(propertyName)) return Charge.class;

    if (LINEARY1.equals(propertyName)) return Charge.class;

    if (LINEARY2.equals(propertyName)) return Charge.class;

    if (TAXTABLE.equals(propertyName)) return Charge.class;

    if (CHARGENUMBER.equals(propertyName)) return Charge.class;

    if (FROMACCOUNT.equals(propertyName)) return Charge.class;

    if (JOBINDEX.equals(propertyName)) return Charge.class;

    if (CHARGEINDEX.equals(propertyName)) return Charge.class;

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

    if (! SmartEquals(getStartHours(), objT.getStartHours()))

      return false;

    if (! SmartEquals(getEndHours(), objT.getEndHours()))

      return false;

    if (! SmartEquals(getChargeCostingRecord(), objT.getChargeCostingRecord()))

      return false;

    if (! SmartEquals(getNextRecord(), objT.getNextRecord()))

      return false;

    if (! SmartEquals(getStartMinutes(), objT.getStartMinutes()))

      return false;

    if (! SmartEquals(getEndMinutes(), objT.getEndMinutes()))

      return false;

    if (! SmartEquals(getOverrideWeight(), objT.getOverrideWeight()))

      return false;

    if (! SmartEquals(getLinearX1(), objT.getLinearX1()))

      return false;

    if (! SmartEquals(getLinearX2(), objT.getLinearX2()))

      return false;

    if (! SmartEquals(getLinearY1(), objT.getLinearY1()))

      return false;

    if (! SmartEquals(getLinearY2(), objT.getLinearY2()))

      return false;

    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))

      return false;

    if (! SmartEquals(getChargeNumber(), objT.getChargeNumber()))

      return false;

    if (! SmartEquals(getFromAccount(), objT.getFromAccount()))

      return false;

    if (! SmartEquals(getJobIndex(), objT.getJobIndex()))

      return false;

    if (! SmartEquals(getChargeIndex(), objT.getChargeIndex()))

      return false;

    return true;

  }			
}
