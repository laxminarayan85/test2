package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
	@NamedQuery(name = "ChargeInit.findall", query = "from ChargeInit"),
	@NamedQuery(name = "ChargeInit.byId", query = "select a from ChargeInit a where a.id= :id")
})


@Entity
@Table(name = "chargeinit")
public class ChargeInit extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String NOTE = "Note";
	/**
	 * @generated
	 */
	public static final String GROUP = "Group";
	/**
	 * @generated
	 */
	public static final String SALESCATEGORY = "SalesCategory";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String RATEQTY = "RateQty";
	/**
	 * @generated
	 */
	public static final String MATERIALQTY = "MaterialQty";
	/**
	 * @generated
	 */
	public static final String GROUPQTY = "GroupQty";
	/**
	 * @generated
	 */
	public static final String PRICE = "Price";
	/**
	 * @generated
	 */
	public static final String TIMESTART = "TimeStart";
	/**
	 * @generated
	 */
	public static final String TIMEEND = "TimeEnd";
	/**
	 * @generated
	 */
	public static final String CUSTOMERCHARGE = "CustomerCharge";
	/**
	 * @generated
	 */
	public static final String PRESSCHARGE = "PressCharge";
	/**
	 * @generated
	 */
	public static final String HIDDEN = "Hidden";
	/**
	 * @generated
	 */
	public static final String DELETEDPRESET = "DeletedPreset";
	/**
	 * @generated
	 */
	public static final String IGNORECUTS = "IgnoreCuts";
	/**
	 * @generated
	 */
	public static final String USESIGNATURES = "UseSignatures";
	/**
	 * @generated
	 */
	public static final String STOCKCHARGE = "StockCharge";
	/**
	 * @generated
	 */
	public static final String OVERRIDENUMBEROFCUTS = "OverrideNumberOfCuts";
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
	public static final String BROKERED = "Brokered";
	/**
	 * @generated
	 */
	public static final String TAXABLE = "Taxable";
	/**
	 * @generated
	 */
	public static final String DISPLAYQTY = "DisplayQty";
	/**
	 * @generated
	 */
	public static final String OVERRIDEPRICE = "OverridePrice";
	/**
	 * @generated
	 */
	public static final String OVERRIDERATEQUANTITY = "OverrideRateQuantity";
	/**
	 * @generated
	 */
	public static final String OVERRIDEMATERIALQTY = "OverrideMaterialQty";
	/**
	 * @generated
	 */
	public static final String VERSION = "Version";
	/**
	 * @generated
	 */
	public static final String SHIPMODE = "ShipMode";
	/**
	 * @generated
	 */
	public static final String ADJUSTUPSCOUNT = "AdjustUpsCount";
	/**
	 * @generated
	 */
	public static final String HASLINKPRICE = "HasLinkPrice";
	/**
	 * @generated
	 */
	public static final String NEEDLINKPRICE = "NeedLinkPrice";
	/**
	 * @generated
	 */
	public static final String HASSHIPPED = "HasShipped";
	/**
	 * @generated
	 */
	public static final String SHOULDSHIP = "ShouldShip";
	/**
	 * @generated
	 */
	public static final String JOBTASKLIST = "JobTaskList";
	/**
	 * @generated
	 */
	public static final String HIDEPRICE = "HidePrice";
	/**
	 * @generated
	 */
	public static final String IGNOREPRICEADJUSTMENT = "IgnorePriceAdjustment";
	/**
	 * @generated
	 */
	public static final String COSTINGPRESSCHARGE = "CostingPressCharge";
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
	public static final String OVERRIDERATE = "OverrideRate";

	/**
	 * @generated
	 */
	public ChargeInit() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String title;
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
 	
	
 	@Basic
	private String note;
	/**
	 * @generated
 	 */
	public String getNote(){
		return note; 
	}

	/**
	 * @generated
	 */	
	public void setNote(String newVal) {
		this.note = newVal;
	}
 	
	
 	@Basic
	private String group;
	/**
	 * @generated
 	 */
	public String getGroup(){
		return group; 
	}

	/**
	 * @generated
	 */	
	public void setGroup(String newVal) {
		this.group = newVal;
	}
 	
	
 	@Basic
	private String salesCategory;
	/**
	 * @generated
 	 */
	public String getSalesCategory(){
		return salesCategory; 
	}

	/**
	 * @generated
	 */	
	public void setSalesCategory(String newVal) {
		this.salesCategory = newVal;
	}
 	
	
	@ManyToOne
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
 	
	
 	@Basic
	private Double rateQty;
	/**
	 * @generated
 	 */
	public Double getRateQty(){
		return rateQty; 
	}

	/**
	 * @generated
	 */	
	public void setRateQty(Double newVal) {
		this.rateQty = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Double groupQty;
	/**
	 * @generated
 	 */
	public Double getGroupQty(){
		return groupQty; 
	}

	/**
	 * @generated
	 */	
	public void setGroupQty(Double newVal) {
		this.groupQty = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Date timeStart;
	/**
	 * @generated
 	 */
	public Date getTimeStart(){
		return timeStart; 
	}

	/**
	 * @generated
	 */	
	public void setTimeStart(Date newVal) {
		this.timeStart = newVal;
	}
 	
	
 	@Basic
	private Date timeEnd;
	/**
	 * @generated
 	 */
	public Date getTimeEnd(){
		return timeEnd; 
	}

	/**
	 * @generated
	 */	
	public void setTimeEnd(Date newVal) {
		this.timeEnd = newVal;
	}
 	
	
 	@Basic
	private Boolean customerCharge;
	/**
	 * @generated
 	 */
	public Boolean getCustomerCharge(){
		return customerCharge; 
	}

	/**
	 * @generated
	 */	
	public void setCustomerCharge(Boolean newVal) {
		this.customerCharge = newVal;
	}
 	
	
 	@Basic
	private Boolean pressCharge;
	/**
	 * @generated
 	 */
	public Boolean getPressCharge(){
		return pressCharge; 
	}

	/**
	 * @generated
	 */	
	public void setPressCharge(Boolean newVal) {
		this.pressCharge = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean deletedPreset;
	/**
	 * @generated
 	 */
	public Boolean getDeletedPreset(){
		return deletedPreset; 
	}

	/**
	 * @generated
	 */	
	public void setDeletedPreset(Boolean newVal) {
		this.deletedPreset = newVal;
	}
 	
	
 	@Basic
	private Boolean ignoreCuts;
	/**
	 * @generated
 	 */
	public Boolean getIgnoreCuts(){
		return ignoreCuts; 
	}

	/**
	 * @generated
	 */	
	public void setIgnoreCuts(Boolean newVal) {
		this.ignoreCuts = newVal;
	}
 	
	
 	@Basic
	private Boolean useSignatures;
	/**
	 * @generated
 	 */
	public Boolean getUseSignatures(){
		return useSignatures; 
	}

	/**
	 * @generated
	 */	
	public void setUseSignatures(Boolean newVal) {
		this.useSignatures = newVal;
	}
 	
	
 	@Basic
	private Boolean stockCharge;
	/**
	 * @generated
 	 */
	public Boolean getStockCharge(){
		return stockCharge; 
	}

	/**
	 * @generated
	 */	
	public void setStockCharge(Boolean newVal) {
		this.stockCharge = newVal;
	}
 	
	
 	@Basic
	private Boolean overrideNumberOfCuts;
	/**
	 * @generated
 	 */
	public Boolean getOverrideNumberOfCuts(){
		return overrideNumberOfCuts; 
	}

	/**
	 * @generated
	 */	
	public void setOverrideNumberOfCuts(Boolean newVal) {
		this.overrideNumberOfCuts = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean overrideRateQuantity;
	/**
	 * @generated
 	 */
	public Boolean getOverrideRateQuantity(){
		return overrideRateQuantity; 
	}

	/**
	 * @generated
	 */	
	public void setOverrideRateQuantity(Boolean newVal) {
		this.overrideRateQuantity = newVal;
	}
 	
	
 	@Basic
	private Boolean overrideMaterialQty;
	/**
	 * @generated
 	 */
	public Boolean getOverrideMaterialQty(){
		return overrideMaterialQty; 
	}

	/**
	 * @generated
	 */	
	public void setOverrideMaterialQty(Boolean newVal) {
		this.overrideMaterialQty = newVal;
	}
 	
	
 	@Basic
	private Integer version;
	/**
	 * @generated
 	 */
	public Integer getVersion(){
		return version; 
	}

	/**
	 * @generated
	 */	
	public void setVersion(Integer newVal) {
		this.version = newVal;
	}
 	
	
	@ManyToOne
	private ShippingMethod shipMode;
	/**
	 * @generated
 	 */
	public ShippingMethod getShipMode(){
		return shipMode; 
	}

	/**
	 * @generated
	 */	
	public void setShipMode(ShippingMethod newVal) {
		this.shipMode = newVal;
	}
 	
	
 	@Basic
	private Integer adjustUpsCount;
	/**
	 * @generated
 	 */
	public Integer getAdjustUpsCount(){
		return adjustUpsCount; 
	}

	/**
	 * @generated
	 */	
	public void setAdjustUpsCount(Integer newVal) {
		this.adjustUpsCount = newVal;
	}
 	
	
 	@Basic
	private Boolean hasLinkPrice;
	/**
	 * @generated
 	 */
	public Boolean getHasLinkPrice(){
		return hasLinkPrice; 
	}

	/**
	 * @generated
	 */	
	public void setHasLinkPrice(Boolean newVal) {
		this.hasLinkPrice = newVal;
	}
 	
	
 	@Basic
	private Boolean needLinkPrice;
	/**
	 * @generated
 	 */
	public Boolean getNeedLinkPrice(){
		return needLinkPrice; 
	}

	/**
	 * @generated
	 */	
	public void setNeedLinkPrice(Boolean newVal) {
		this.needLinkPrice = newVal;
	}
 	
	
 	@Basic
	private Boolean hasShipped;
	/**
	 * @generated
 	 */
	public Boolean getHasShipped(){
		return hasShipped; 
	}

	/**
	 * @generated
	 */	
	public void setHasShipped(Boolean newVal) {
		this.hasShipped = newVal;
	}
 	
	
 	@Basic
	private Boolean shouldShip;
	/**
	 * @generated
 	 */
	public Boolean getShouldShip(){
		return shouldShip; 
	}

	/**
	 * @generated
	 */	
	public void setShouldShip(Boolean newVal) {
		this.shouldShip = newVal;
	}
 	
	
 	@Basic
	private Boolean jobTaskList;
	/**
	 * @generated
 	 */
	public Boolean getJobTaskList(){
		return jobTaskList; 
	}

	/**
	 * @generated
	 */	
	public void setJobTaskList(Boolean newVal) {
		this.jobTaskList = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean ignorePriceAdjustment;
	/**
	 * @generated
 	 */
	public Boolean getIgnorePriceAdjustment(){
		return ignorePriceAdjustment; 
	}

	/**
	 * @generated
	 */	
	public void setIgnorePriceAdjustment(Boolean newVal) {
		this.ignorePriceAdjustment = newVal;
	}
 	
	
 	@Basic
	private Boolean costingPressCharge;
	/**
	 * @generated
 	 */
	public Boolean getCostingPressCharge(){
		return costingPressCharge; 
	}

	/**
	 * @generated
	 */	
	public void setCostingPressCharge(Boolean newVal) {
		this.costingPressCharge = newVal;
	}
 	
	
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
		if (TITLE.equals(propertyName)) return getTitle();
		if (NOTE.equals(propertyName)) return getNote();
		if (GROUP.equals(propertyName)) return getGroup();
		if (SALESCATEGORY.equals(propertyName)) return getSalesCategory();
		if (TAXTABLE.equals(propertyName)) return getTaxTable();
		if (RATEQTY.equals(propertyName)) return getRateQty();
		if (MATERIALQTY.equals(propertyName)) return getMaterialQty();
		if (GROUPQTY.equals(propertyName)) return getGroupQty();
		if (PRICE.equals(propertyName)) return getPrice();
		if (TIMESTART.equals(propertyName)) return getTimeStart();
		if (TIMEEND.equals(propertyName)) return getTimeEnd();
		if (CUSTOMERCHARGE.equals(propertyName)) return getCustomerCharge();
		if (PRESSCHARGE.equals(propertyName)) return getPressCharge();
		if (HIDDEN.equals(propertyName)) return getHidden();
		if (DELETEDPRESET.equals(propertyName)) return getDeletedPreset();
		if (IGNORECUTS.equals(propertyName)) return getIgnoreCuts();
		if (USESIGNATURES.equals(propertyName)) return getUseSignatures();
		if (STOCKCHARGE.equals(propertyName)) return getStockCharge();
		if (OVERRIDENUMBEROFCUTS.equals(propertyName)) return getOverrideNumberOfCuts();
		if (SHOWNOTES.equals(propertyName)) return getShowNotes();
		if (FINISHED.equals(propertyName)) return getFinished();
		if (BROKERED.equals(propertyName)) return getBrokered();
		if (TAXABLE.equals(propertyName)) return getTaxable();
		if (DISPLAYQTY.equals(propertyName)) return getDisplayQty();
		if (OVERRIDEPRICE.equals(propertyName)) return getOverridePrice();
		if (OVERRIDERATEQUANTITY.equals(propertyName)) return getOverrideRateQuantity();
		if (OVERRIDEMATERIALQTY.equals(propertyName)) return getOverrideMaterialQty();
		if (VERSION.equals(propertyName)) return getVersion();
		if (SHIPMODE.equals(propertyName)) return getShipMode();
		if (ADJUSTUPSCOUNT.equals(propertyName)) return getAdjustUpsCount();
		if (HASLINKPRICE.equals(propertyName)) return getHasLinkPrice();
		if (NEEDLINKPRICE.equals(propertyName)) return getNeedLinkPrice();
		if (HASSHIPPED.equals(propertyName)) return getHasShipped();
		if (SHOULDSHIP.equals(propertyName)) return getShouldShip();
		if (JOBTASKLIST.equals(propertyName)) return getJobTaskList();
		if (HIDEPRICE.equals(propertyName)) return getHidePrice();
		if (IGNOREPRICEADJUSTMENT.equals(propertyName)) return getIgnorePriceAdjustment();
		if (COSTINGPRESSCHARGE.equals(propertyName)) return getCostingPressCharge();
		if (LINEARX1.equals(propertyName)) return getLinearX1();
		if (LINEARX2.equals(propertyName)) return getLinearX2();
		if (LINEARY1.equals(propertyName)) return getLinearY1();
		if (LINEARY2.equals(propertyName)) return getLinearY2();
		if (OVERRIDERATE.equals(propertyName)) return getOverrideRate();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (NOTE.equals(propertyName)) setNote((String)newValue); else
		if (GROUP.equals(propertyName)) setGroup((String)newValue); else
		if (SALESCATEGORY.equals(propertyName)) setSalesCategory((String)newValue); else
		if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
		if (RATEQTY.equals(propertyName)) setRateQty((Double)newValue); else
		if (MATERIALQTY.equals(propertyName)) setMaterialQty((Double)newValue); else
		if (GROUPQTY.equals(propertyName)) setGroupQty((Double)newValue); else
		if (PRICE.equals(propertyName)) setPrice((Double)newValue); else
		if (TIMESTART.equals(propertyName)) setTimeStart((Date)newValue); else
		if (TIMEEND.equals(propertyName)) setTimeEnd((Date)newValue); else
		if (CUSTOMERCHARGE.equals(propertyName)) setCustomerCharge((Boolean)newValue); else
		if (PRESSCHARGE.equals(propertyName)) setPressCharge((Boolean)newValue); else
		if (HIDDEN.equals(propertyName)) setHidden((Boolean)newValue); else
		if (DELETEDPRESET.equals(propertyName)) setDeletedPreset((Boolean)newValue); else
		if (IGNORECUTS.equals(propertyName)) setIgnoreCuts((Boolean)newValue); else
		if (USESIGNATURES.equals(propertyName)) setUseSignatures((Boolean)newValue); else
		if (STOCKCHARGE.equals(propertyName)) setStockCharge((Boolean)newValue); else
		if (OVERRIDENUMBEROFCUTS.equals(propertyName)) setOverrideNumberOfCuts((Boolean)newValue); else
		if (SHOWNOTES.equals(propertyName)) setShowNotes((Boolean)newValue); else
		if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else
		if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else
		if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
		if (DISPLAYQTY.equals(propertyName)) setDisplayQty((Boolean)newValue); else
		if (OVERRIDEPRICE.equals(propertyName)) setOverridePrice((Boolean)newValue); else
		if (OVERRIDERATEQUANTITY.equals(propertyName)) setOverrideRateQuantity((Boolean)newValue); else
		if (OVERRIDEMATERIALQTY.equals(propertyName)) setOverrideMaterialQty((Boolean)newValue); else
		if (VERSION.equals(propertyName)) setVersion((Integer)newValue); else
		if (SHIPMODE.equals(propertyName)) setShipMode((ShippingMethod)newValue); else
		if (ADJUSTUPSCOUNT.equals(propertyName)) setAdjustUpsCount((Integer)newValue); else
		if (HASLINKPRICE.equals(propertyName)) setHasLinkPrice((Boolean)newValue); else
		if (NEEDLINKPRICE.equals(propertyName)) setNeedLinkPrice((Boolean)newValue); else
		if (HASSHIPPED.equals(propertyName)) setHasShipped((Boolean)newValue); else
		if (SHOULDSHIP.equals(propertyName)) setShouldShip((Boolean)newValue); else
		if (JOBTASKLIST.equals(propertyName)) setJobTaskList((Boolean)newValue); else
		if (HIDEPRICE.equals(propertyName)) setHidePrice((Boolean)newValue); else
		if (IGNOREPRICEADJUSTMENT.equals(propertyName)) setIgnorePriceAdjustment((Boolean)newValue); else
		if (COSTINGPRESSCHARGE.equals(propertyName)) setCostingPressCharge((Boolean)newValue); else
		if (LINEARX1.equals(propertyName)) setLinearX1((Boolean)newValue); else
		if (LINEARX2.equals(propertyName)) setLinearX2((Boolean)newValue); else
		if (LINEARY1.equals(propertyName)) setLinearY1((Boolean)newValue); else
		if (LINEARY2.equals(propertyName)) setLinearY2((Boolean)newValue); else
		if (OVERRIDERATE.equals(propertyName)) setOverrideRate((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (NOTE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (GROUP.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESCATEGORY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TAXTABLE.equals(propertyName)) 
			return new Class<?>[] {TaxTable.class};		
		if (RATEQTY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (MATERIALQTY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (GROUPQTY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRICE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TIMESTART.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (TIMEEND.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (CUSTOMERCHARGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRESSCHARGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HIDDEN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DELETEDPRESET.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (IGNORECUTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USESIGNATURES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (STOCKCHARGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (OVERRIDENUMBEROFCUTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWNOTES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FINISHED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (BROKERED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DISPLAYQTY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (OVERRIDEPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (OVERRIDERATEQUANTITY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (OVERRIDEMATERIALQTY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (VERSION.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SHIPMODE.equals(propertyName)) 
			return new Class<?>[] {ShippingMethod.class};		
		if (ADJUSTUPSCOUNT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (HASLINKPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NEEDLINKPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HASSHIPPED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOULDSHIP.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (JOBTASKLIST.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HIDEPRICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (IGNOREPRICEADJUSTMENT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (COSTINGPRESSCHARGE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LINEARX1.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LINEARX2.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LINEARY1.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LINEARY2.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
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
		if (TITLE.equals(propertyName)) return ChargeInit.class;
		if (NOTE.equals(propertyName)) return ChargeInit.class;
		if (GROUP.equals(propertyName)) return ChargeInit.class;
		if (SALESCATEGORY.equals(propertyName)) return ChargeInit.class;
		if (TAXTABLE.equals(propertyName)) return ChargeInit.class;
		if (RATEQTY.equals(propertyName)) return ChargeInit.class;
		if (MATERIALQTY.equals(propertyName)) return ChargeInit.class;
		if (GROUPQTY.equals(propertyName)) return ChargeInit.class;
		if (PRICE.equals(propertyName)) return ChargeInit.class;
		if (TIMESTART.equals(propertyName)) return ChargeInit.class;
		if (TIMEEND.equals(propertyName)) return ChargeInit.class;
		if (CUSTOMERCHARGE.equals(propertyName)) return ChargeInit.class;
		if (PRESSCHARGE.equals(propertyName)) return ChargeInit.class;
		if (HIDDEN.equals(propertyName)) return ChargeInit.class;
		if (DELETEDPRESET.equals(propertyName)) return ChargeInit.class;
		if (IGNORECUTS.equals(propertyName)) return ChargeInit.class;
		if (USESIGNATURES.equals(propertyName)) return ChargeInit.class;
		if (STOCKCHARGE.equals(propertyName)) return ChargeInit.class;
		if (OVERRIDENUMBEROFCUTS.equals(propertyName)) return ChargeInit.class;
		if (SHOWNOTES.equals(propertyName)) return ChargeInit.class;
		if (FINISHED.equals(propertyName)) return ChargeInit.class;
		if (BROKERED.equals(propertyName)) return ChargeInit.class;
		if (TAXABLE.equals(propertyName)) return ChargeInit.class;
		if (DISPLAYQTY.equals(propertyName)) return ChargeInit.class;
		if (OVERRIDEPRICE.equals(propertyName)) return ChargeInit.class;
		if (OVERRIDERATEQUANTITY.equals(propertyName)) return ChargeInit.class;
		if (OVERRIDEMATERIALQTY.equals(propertyName)) return ChargeInit.class;
		if (VERSION.equals(propertyName)) return ChargeInit.class;
		if (SHIPMODE.equals(propertyName)) return ChargeInit.class;
		if (ADJUSTUPSCOUNT.equals(propertyName)) return ChargeInit.class;
		if (HASLINKPRICE.equals(propertyName)) return ChargeInit.class;
		if (NEEDLINKPRICE.equals(propertyName)) return ChargeInit.class;
		if (HASSHIPPED.equals(propertyName)) return ChargeInit.class;
		if (SHOULDSHIP.equals(propertyName)) return ChargeInit.class;
		if (JOBTASKLIST.equals(propertyName)) return ChargeInit.class;
		if (HIDEPRICE.equals(propertyName)) return ChargeInit.class;
		if (IGNOREPRICEADJUSTMENT.equals(propertyName)) return ChargeInit.class;
		if (COSTINGPRESSCHARGE.equals(propertyName)) return ChargeInit.class;
		if (LINEARX1.equals(propertyName)) return ChargeInit.class;
		if (LINEARX2.equals(propertyName)) return ChargeInit.class;
		if (LINEARY1.equals(propertyName)) return ChargeInit.class;
		if (LINEARY2.equals(propertyName)) return ChargeInit.class;
		if (OVERRIDERATE.equals(propertyName)) return ChargeInit.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		ChargeInit objT = (ChargeInit)obj;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getNote(), objT.getNote()))
			return false;
		if (! SmartEquals(getGroup(), objT.getGroup()))
			return false;
		if (! SmartEquals(getSalesCategory(), objT.getSalesCategory()))
			return false;
		if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
			return false;
		if (! SmartEquals(getRateQty(), objT.getRateQty()))
			return false;
		if (! SmartEquals(getMaterialQty(), objT.getMaterialQty()))
			return false;
		if (! SmartEquals(getGroupQty(), objT.getGroupQty()))
			return false;
		if (! SmartEquals(getPrice(), objT.getPrice()))
			return false;
		if (! SmartEquals(getTimeStart(), objT.getTimeStart()))
			return false;
		if (! SmartEquals(getTimeEnd(), objT.getTimeEnd()))
			return false;
		if (! SmartEquals(getCustomerCharge(), objT.getCustomerCharge()))
			return false;
		if (! SmartEquals(getPressCharge(), objT.getPressCharge()))
			return false;
		if (! SmartEquals(getHidden(), objT.getHidden()))
			return false;
		if (! SmartEquals(getDeletedPreset(), objT.getDeletedPreset()))
			return false;
		if (! SmartEquals(getIgnoreCuts(), objT.getIgnoreCuts()))
			return false;
		if (! SmartEquals(getUseSignatures(), objT.getUseSignatures()))
			return false;
		if (! SmartEquals(getStockCharge(), objT.getStockCharge()))
			return false;
		if (! SmartEquals(getOverrideNumberOfCuts(), objT.getOverrideNumberOfCuts()))
			return false;
		if (! SmartEquals(getShowNotes(), objT.getShowNotes()))
			return false;
		if (! SmartEquals(getFinished(), objT.getFinished()))
			return false;
		if (! SmartEquals(getBrokered(), objT.getBrokered()))
			return false;
		if (! SmartEquals(getTaxable(), objT.getTaxable()))
			return false;
		if (! SmartEquals(getDisplayQty(), objT.getDisplayQty()))
			return false;
		if (! SmartEquals(getOverridePrice(), objT.getOverridePrice()))
			return false;
		if (! SmartEquals(getOverrideRateQuantity(), objT.getOverrideRateQuantity()))
			return false;
		if (! SmartEquals(getOverrideMaterialQty(), objT.getOverrideMaterialQty()))
			return false;
		if (! SmartEquals(getVersion(), objT.getVersion()))
			return false;
		if (! SmartEquals(getShipMode(), objT.getShipMode()))
			return false;
		if (! SmartEquals(getAdjustUpsCount(), objT.getAdjustUpsCount()))
			return false;
		if (! SmartEquals(getHasLinkPrice(), objT.getHasLinkPrice()))
			return false;
		if (! SmartEquals(getNeedLinkPrice(), objT.getNeedLinkPrice()))
			return false;
		if (! SmartEquals(getHasShipped(), objT.getHasShipped()))
			return false;
		if (! SmartEquals(getShouldShip(), objT.getShouldShip()))
			return false;
		if (! SmartEquals(getJobTaskList(), objT.getJobTaskList()))
			return false;
		if (! SmartEquals(getHidePrice(), objT.getHidePrice()))
			return false;
		if (! SmartEquals(getIgnorePriceAdjustment(), objT.getIgnorePriceAdjustment()))
			return false;
		if (! SmartEquals(getCostingPressCharge(), objT.getCostingPressCharge()))
			return false;
		if (! SmartEquals(getLinearX1(), objT.getLinearX1()))
			return false;
		if (! SmartEquals(getLinearX2(), objT.getLinearX2()))
			return false;
		if (! SmartEquals(getLinearY1(), objT.getLinearY1()))
			return false;
		if (! SmartEquals(getLinearY2(), objT.getLinearY2()))
			return false;
		if (! SmartEquals(getOverrideRate(), objT.getOverrideRate()))
			return false;
		return true;
	}			
}