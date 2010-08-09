
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "ChargeDefinition.findall", query = "from ChargeDefinition"),
  @NamedQuery(name = "ChargeDefinition.byId", query = "select a from ChargeDefinition a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "chargedefinition")
public class ChargeDefinition extends ModelBase {
	/**
	 * @generated
	 */
	public static final String METHOD = "Method";
	/**
	 * @generated
	 */
	public static final String QUANTITYTYPE = "QuantityType";
	/**
	 * @generated
	 */
	public static final String MARKUPTYPE = "MarkupType";
	/**
	 * @generated
	 */
	public static final String JOBQTY = "JobQty";
	/**
	 * @generated
	 */
	public static final String PRICEMETHOD = "PriceMethod";
	/**
	 * @generated
	 */
	public static final String INKCOVERAGE = "InkCoverage";
	/**
	 * @generated
	 */
	public static final String USESIDES = "UseSides";
	/**
	 * @generated
	 */
	public static final String DONOTDISCOUNT = "DoNotDiscount";
	/**
	 * @generated
	 */
	public static final String NOMATERIALQUANTITY = "NoMaterialQuantity";
	/**
	 * @generated
	 */
	public static final String NOOVERRIDES = "NoOverrides";
	/**
	 * @generated
	 */
	public static final String ADJUSTABLESETS = "AdjustableSets";
	/**
	 * @generated
	 */
	public static final String ADJUSTABLERATE = "AdjustableRate";
	/**
	 * @generated
	 */
	public static final String ADJUSTABLEMATERIAL = "AdjustableMaterial";
	/**
	 * @generated
	 */
	public static final String USEMATERIAL = "UseMaterial";
	/**
	 * @generated
	 */
	public static final String USERATE = "UseRate";
	/**
	 * @generated
	 */
	public static final String USERATESETS = "UseRateSets";
	/**
	 * @generated
	 */
	public static final String USEMERCHANDISESETS = "UseMerchandiseSets";
	/**
	 * @generated
	 */
	public static final String USEMINIMUMCHARGE = "UseMinimumCharge";
	/**
	 * @generated
	 */
	public static final String USECOLORS = "UseColors";
	/**
	 * @generated
	 */
	public static final String USEORIGINALS = "UseOriginals";
	/**
	 * @generated
	 */
	public static final String RATESETCOUNT = "RateSetCount";
	/**
	 * @generated
	 */
	public static final String MATERIALSETCOUNT = "MaterialSetCount";
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String MATERIAL = "Material";
	/**
	 * @generated
	 */
	public static final String MINIMUM = "Minimum";
	/**
	 * @generated
	 */
	public static final String MARKUP = "Markup";
	/**
	 * @generated
	 */
	public static final String PRICELIST = "PriceList";
	/**
	 * @generated
	 */
	public static final String WASTECHART = "WasteChart";
	/**
	 * @generated
	 */
	public static final String FIXEDWASTE = "FixedWaste";
	/**
	 * @generated
	 */
	public static final String WASTEPERCENTAGE = "WastePercentage";
	/**
	 * @generated
	 */
	public static final String BASELINEARNUMBER = "BaseLinearNumber";
	/**
	 * @generated
	 */
	public static final String LOCATION = "Location";
	/**
	 * @generated
	 */
	public static final String COSTCENTER = "CostCenter";
	/**
	 * @generated
	 */
	public static final String SUBSTRATE = "Substrate";
	/**
	 * @generated
	 */
	public static final String MINIMUMTIME = "MinimumTime";
	/**
	 * @generated
	 */
	public static final String SIZEX = "SizeX";
	/**
	 * @generated
	 */
	public static final String SIZEY = "SizeY";
	/**
	 * @generated
	 */
	public static final String PLATETHICKNESS = "PlateThickness";
	/**
	 * @generated
	 */
	public static final String FOLDTEMPLATE = "FoldTemplate";
	/**
	 * @generated
	 */
	public static final String EXCLUDEDFROMWORKFLOW = "ExcludedFromWorkflow";
	/**
	 * @generated
	 */
	public static final String PREPRODUCTION = "Preproduction";
	/**
	 * @generated
	 */
	public static final String USEMINIMUMTIME = "UseMinimumTime";
	/**
	 * @generated
	 */
	public static final String USEDIVIDEBYUPCOUNT = "UseDivideByUpCount";
	/**
	 * @generated
	 */
	public static final String USEMULTIPLYUPCOUNT = "UseMultiplyUpCount";
	/**
	 * @generated
	 */
	public static final String ADJUSTUPS = "AdjustUps";
	/**
	 * @generated
	 */
	public static final String CUTSAREPREPRESS = "CutsArePrePress";
	/**
	 * @generated
	 */
	public static final String INTEGRATEDCTP = "IntegratedCTP";
	/**
	 * @generated
	 */
	public static final String SKU = "Sku";
	/**
	 * @generated
	 */
	public static final String CATEGORY = "Category";
	/**
	 * @generated
	 */
	public static final String OVERRIDERATE = "OverrideRate";
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
	public static final String CHARGEGROUP = "ChargeGroup";
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
	public static final String HIDECHARGEINPRINTOUTS = "HideChargeInPrintouts";
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
	public static final String IGNOREGLOBALPRICECHANGES = "IgnoreGlobalPriceChanges";
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
	public static final String LABEL = "Label";
	/**
	 * @generated
	 */
	public static final String BINDERYCHARGE = "BinderyCharge";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String PARENT = "Parent";
	/**
	 * @generated
	 */
	public static final String USEAREA = "UseArea";
	/**
	 * @generated
	 */
	public static final String USESETUP = "UseSetup";
	/**
	 * @generated
	 */
	public static final String CHARGECOST = "ChargeCost";
	/**
	 * @generated
	 */
	public static final String AREA = "Area";
	/**
	 * @generated
	 */
	public static final String COVERLB_CHECK = "Coverlb_check";
	/**
	 * @generated
	 */
	public static final String SHEET_LIFT_CHECK = "Sheet_lift_check";
	/**
	 * @generated
	 */
	public static final String SHIP_MARKUP_CHECK = "Ship_markup_check";
	/**
	 * @generated
	 */
	public static final String COVERLBINK = "CoverlbInk";
	/**
	 * @generated
	 */
	public static final String SHEETLIFTCUT = "SheetliftCut";
	/**
	 * @generated
	 */
	public static final String SHIPMARKUP = "ShipMarkup";
	/**
	 * @generated
	 */
	public static final String USERUNAREA = "UseRunArea";
	/**
	 * @generated
	 */
	public static final String SETUPPRICE = "SetupPrice";

	/**
   * @generated
   */
  public static final String COSTINGUNITPRICE = "CostingUnitPrice";
	/**
   * @generated
   */
  public static final String COSTINGSETUPPRICE = "CostingSetupPrice";

	/**
   * @generated
   */
  public static final String PRODUCTCODE = "ProductCode";

	/**
   * @generated
   */
  public static final String PRESETDESCRIPTION = "PresetDescription";
	/**
   * @generated
   */
  public static final String PRESETDESCRIPTIONLABEL = "PresetDescriptionLabel";
	/**
   * @generated
   */
  public static final String PRESETNOTES = "PresetNotes";
	/**
   * @generated
   */
  public static final String PRESETNOTESLABEL = "PresetNotesLabel";
	/**
   * @generated
   */
  public static final String PRESETQUANTITY = "PresetQuantity";
	/**
   * @generated
   */
  public static final String PRESETQUANTITYLABEL = "PresetQuantityLabel";
	/**
   * @generated
   */
  public static final String PRESETSHOWNOTES = "PresetShowNotes";
	/**
   * @generated
   */
  public static final String PRESETPRODUCTIONLOCATION = "PresetProductionLocation";
	/**
   * @generated
   */
  public static final String PRESETPRICE = "PresetPrice";
	/**
   * @generated
   */
  public static final String PRESETPRICELABEL = "PresetPriceLabel";
	/**
   * @generated
   */
  public static final String PRESETTAXTABLE = "PresetTaxTable";
	/**
   * @generated
   */
  public static final String PRESETFINISHED = "PresetFinished";
	/**
   * @generated
   */
  public static final String PRESETTAXABLE = "PresetTaxable";
	/**
   * @generated
   */
  public static final String PRESETRATE = "PresetRate";
	/**
   * @generated
   */
  public static final String PRESETRATELABEL = "PresetRateLabel";
	/**
   * @generated
   */
  public static final String PRESETBROKERED = "PresetBrokered";
	/**
   * @generated
   */
  public static final String PRESETDISPLAYQUANTITY = "PresetDisplayQuantity";
	/**
   * @generated
   */
  public static final String PRESETHIDDEN = "PresetHidden";
	/**
   * @generated
   */
  public static final String PRESETUP = "PresetUp";
	/**
   * @generated
   */
  public static final String PRESETUPLABEL = "PresetUpLabel";
	/**
   * @generated
   */
  public static final String PRESETINSETSOF = "PresetInSetsOf";
	/**
   * @generated
   */
  public static final String PRESETINSETSOFLABEL = "PresetInSetsOfLabel";
	/**
   * @generated
   */
  public static final String PRESETMATERIALQUANTITY = "PresetMaterialQuantity";
	/**
   * @generated
   */
  public static final String PRESETMATERIALQUANTITYLABEL = "PresetMaterialQuantityLabel";
	/**
   * @generated
   */
  public static final String PRESETMATERIALSETSOF = "PresetMaterialSetsOf";
	/**
   * @generated
   */
  public static final String PRESETMATERIALSETSOFLABEL = "PresetMaterialSetsOfLabel";
	/**
   * @generated
   */
  public static final String PRESETMATERIALRATE = "PresetMaterialRate";
	/**
   * @generated
   */
  public static final String PRESETMATERIALRATELABEL = "PresetMaterialRateLabel";

	/**
   * @generated
   */
  public static final String PRESETQUANTITYPERSET = "PresetQuantityPerSet";
	/**
   * @generated
   */
  public static final String PRESETQUANTITYPERSETLABEL = "PresetQuantityPerSetLabel";

	/**
	 * @generated
	 */
	public ChargeDefinition() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String method;
	
	/**
	 * @generated
 	 */
	public String getMethod(){
    return method; 
  }

	
	/**
	 * @generated
	 */	
	public void setMethod(String newVal) {
    this.method = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String quantityType;
	
	/**
	 * @generated
 	 */
	public String getQuantityType(){
    return quantityType; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuantityType(String newVal) {
    this.quantityType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String markupType;
	
	/**
	 * @generated
 	 */
	public String getMarkupType(){
    return markupType; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkupType(String newVal) {
    this.markupType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String jobQty;
	
	/**
	 * @generated
 	 */
	public String getJobQty(){
    return jobQty; 
  }

	
	/**
	 * @generated
	 */	
	public void setJobQty(String newVal) {
    this.jobQty = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String priceMethod;
	
	/**
	 * @generated
 	 */
	public String getPriceMethod(){
    return priceMethod; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceMethod(String newVal) {
    this.priceMethod = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String inkCoverage;
	
	/**
	 * @generated
 	 */
	public String getInkCoverage(){
    return inkCoverage; 
  }

	
	/**
	 * @generated
	 */	
	public void setInkCoverage(String newVal) {
    this.inkCoverage = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useSides;
	
	/**
	 * @generated
 	 */
	public Boolean getUseSides(){
    return useSides; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseSides(Boolean newVal) {
    this.useSides = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean doNotDiscount;
	
	/**
	 * @generated
 	 */
	public Boolean getDoNotDiscount(){
    return doNotDiscount; 
  }

	
	/**
	 * @generated
	 */	
	public void setDoNotDiscount(Boolean newVal) {
    this.doNotDiscount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noMaterialQuantity;
	
	/**
	 * @generated
 	 */
	public Boolean getNoMaterialQuantity(){
    return noMaterialQuantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoMaterialQuantity(Boolean newVal) {
    this.noMaterialQuantity = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noOverrides;
	
	/**
	 * @generated
 	 */
	public Boolean getNoOverrides(){
    return noOverrides; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoOverrides(Boolean newVal) {
    this.noOverrides = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean adjustableSets;
	
	/**
	 * @generated
 	 */
	public Boolean getAdjustableSets(){
    return adjustableSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdjustableSets(Boolean newVal) {
    this.adjustableSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean adjustableRate;
	
	/**
	 * @generated
 	 */
	public Boolean getAdjustableRate(){
    return adjustableRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdjustableRate(Boolean newVal) {
    this.adjustableRate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean adjustableMaterial;
	
	/**
	 * @generated
 	 */
	public Boolean getAdjustableMaterial(){
    return adjustableMaterial; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdjustableMaterial(Boolean newVal) {
    this.adjustableMaterial = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useMaterial;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMaterial(){
    return useMaterial; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseMaterial(Boolean newVal) {
    this.useMaterial = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useRate;
	
	/**
	 * @generated
 	 */
	public Boolean getUseRate(){
    return useRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseRate(Boolean newVal) {
    this.useRate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useRateSets;
	
	/**
	 * @generated
 	 */
	public Boolean getUseRateSets(){
    return useRateSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseRateSets(Boolean newVal) {
    this.useRateSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useMerchandiseSets;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMerchandiseSets(){
    return useMerchandiseSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseMerchandiseSets(Boolean newVal) {
    this.useMerchandiseSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useMinimumCharge;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMinimumCharge(){
    return useMinimumCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseMinimumCharge(Boolean newVal) {
    this.useMinimumCharge = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useColors;
	
	/**
	 * @generated
 	 */
	public Boolean getUseColors(){
    return useColors; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseColors(Boolean newVal) {
    this.useColors = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useOriginals;
	
	/**
	 * @generated
 	 */
	public Boolean getUseOriginals(){
    return useOriginals; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseOriginals(Boolean newVal) {
    this.useOriginals = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double rateSetCount;
	
	/**
	 * @generated
 	 */
	public Double getRateSetCount(){
    return rateSetCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setRateSetCount(Double newVal) {
    this.rateSetCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double materialSetCount;
	
	/**
	 * @generated
 	 */
	public Double getMaterialSetCount(){
    return materialSetCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setMaterialSetCount(Double newVal) {
    this.materialSetCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="rate", precision=19, scale=4)
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
    this.rate.setScale(4, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setRate(double newVal) {
    this.rate = BigDecimal.valueOf(newVal);
    this.rate.setScale(4, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="material", precision=19, scale=4)
	private BigDecimal material;
	
	/**
	 * @generated
 	 */
	public BigDecimal getMaterial(){
    return material; 
  }

	
	/**
   * @generated
   */	
  public void setMaterial(BigDecimal newVal) {
    this.material = newVal;
    this.material.setScale(4, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setMaterial(double newVal) {
    this.material = BigDecimal.valueOf(newVal);
    this.material.setScale(4, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal minimum;
	
	/**
	 * @generated
 	 */
	public BigDecimal getMinimum(){
    return minimum; 
  }

	
	/**
   * @generated
   */	
  public void setMinimum(BigDecimal newVal) {
    this.minimum = newVal;
  }


	/**
   * @generated
   */	
  public void setMinimum(double newVal) {
    this.minimum = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Double markup;
	
	/**
	 * @generated
 	 */
	public Double getMarkup(){
    return markup; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup(Double newVal) {
    this.markup = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private PriceList priceList;
	
	/**
	 * @generated
 	 */
	public PriceList getPriceList(){
    return priceList; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceList(PriceList newVal) {
    this.priceList = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private WasteChart wasteChart;
	
	/**
	 * @generated
 	 */
	public WasteChart getWasteChart(){
    return wasteChart; 
  }

	
	/**
	 * @generated
	 */	
	public void setWasteChart(WasteChart newVal) {
    this.wasteChart = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fixedWaste;
	
	/**
	 * @generated
 	 */
	public Long getFixedWaste(){
    return fixedWaste; 
  }

	
	/**
	 * @generated
	 */	
	public void setFixedWaste(Long newVal) {
    this.fixedWaste = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double wastePercentage;
	
	/**
	 * @generated
 	 */
	public Double getWastePercentage(){
    return wastePercentage; 
  }

	
	/**
	 * @generated
	 */	
	public void setWastePercentage(Double newVal) {
    this.wastePercentage = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long baseLinearNumber;
	
	/**
	 * @generated
 	 */
	public Long getBaseLinearNumber(){
    return baseLinearNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setBaseLinearNumber(Long newVal) {
    this.baseLinearNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private ProductionLocations location;
	
	/**
	 * @generated
 	 */
	public ProductionLocations getLocation(){
    return location; 
  }

	
	/**
   * @generated
   */	
  public void setLocation(ProductionLocations newVal) {
    this.location = newVal;
  }


	/**
	 * @generated
	 */	
    @ManyToOne()
	private CostCenter costCenter;
	
	/**
	 * @generated
 	 */
	public CostCenter getCostCenter(){
    return costCenter; 
  }

	
	/**
	 * @generated
	 */	
	public void setCostCenter(CostCenter newVal) {
    this.costCenter = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Substrate substrate;
	
	/**
	 * @generated
 	 */
	public Substrate getSubstrate(){
    return substrate; 
  }

	
	/**
	 * @generated
	 */	
	public void setSubstrate(Substrate newVal) {
    this.substrate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long minimumTime;
	
	/**
	 * @generated
 	 */
	public Long getMinimumTime(){
    return minimumTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setMinimumTime(Long newVal) {
    this.minimumTime = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double sizeX;
	
	/**
	 * @generated
 	 */
	public Double getSizeX(){
    return sizeX; 
  }

	
	/**
	 * @generated
	 */	
	public void setSizeX(Double newVal) {
    this.sizeX = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double sizeY;
	
	/**
	 * @generated
 	 */
	public Double getSizeY(){
    return sizeY; 
  }

	
	/**
	 * @generated
	 */	
	public void setSizeY(Double newVal) {
    this.sizeY = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double plateThickness;
	
	/**
	 * @generated
 	 */
	public Double getPlateThickness(){
    return plateThickness; 
  }

	
	/**
	 * @generated
	 */	
	public void setPlateThickness(Double newVal) {
    this.plateThickness = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private FoldTemplate foldTemplate;
	
	/**
	 * @generated
 	 */
	public FoldTemplate getFoldTemplate(){
    return foldTemplate; 
  }

	
	/**
	 * @generated
	 */	
	public void setFoldTemplate(FoldTemplate newVal) {
    this.foldTemplate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean excludedFromWorkflow;
	
	/**
	 * @generated
 	 */
	public Boolean getExcludedFromWorkflow(){
    return excludedFromWorkflow; 
  }

	
	/**
	 * @generated
	 */	
	public void setExcludedFromWorkflow(Boolean newVal) {
    this.excludedFromWorkflow = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean preproduction;
	
	/**
	 * @generated
 	 */
	public Boolean getPreproduction(){
    return preproduction; 
  }

	
	/**
	 * @generated
	 */	
	public void setPreproduction(Boolean newVal) {
    this.preproduction = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useMinimumTime;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMinimumTime(){
    return useMinimumTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseMinimumTime(Boolean newVal) {
    this.useMinimumTime = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useDivideByUpCount;
	
	/**
	 * @generated
 	 */
	public Boolean getUseDivideByUpCount(){
    return useDivideByUpCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseDivideByUpCount(Boolean newVal) {
    this.useDivideByUpCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useMultiplyUpCount;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMultiplyUpCount(){
    return useMultiplyUpCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseMultiplyUpCount(Boolean newVal) {
    this.useMultiplyUpCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean adjustUps;
	
	/**
	 * @generated
 	 */
	public Boolean getAdjustUps(){
    return adjustUps; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdjustUps(Boolean newVal) {
    this.adjustUps = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean cutsArePrePress;
	
	/**
	 * @generated
 	 */
	public Boolean getCutsArePrePress(){
    return cutsArePrePress; 
  }

	
	/**
	 * @generated
	 */	
	public void setCutsArePrePress(Boolean newVal) {
    this.cutsArePrePress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean integratedCTP;
	
	/**
	 * @generated
 	 */
	public Boolean getIntegratedCTP(){
    return integratedCTP; 
  }

	
	/**
	 * @generated
	 */	
	public void setIntegratedCTP(Boolean newVal) {
    this.integratedCTP = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String sku;
	
	/**
	 * @generated
 	 */
	public String getSku(){
    return sku; 
  }

	
	/**
	 * @generated
	 */	
	public void setSku(String newVal) {
    this.sku = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String category;
	
	/**
	 * @generated
 	 */
	public String getCategory(){
    return category; 
  }

	
	/**
	 * @generated
	 */	
	public void setCategory(String newVal) {
    this.category = newVal;
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String chargeGroup;
	
	/**
	 * @generated
 	 */
	public String getChargeGroup(){
    return chargeGroup; 
  }

	
	/**
	 * @generated
	 */	
	public void setChargeGroup(String newVal) {
    this.chargeGroup = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private SalesCategory salesCategory;
	
	/**
	 * @generated
 	 */
	public SalesCategory getSalesCategory(){
    return salesCategory; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesCategory(SalesCategory newVal) {
    this.salesCategory = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hideChargeInPrintouts;
	
	/**
	 * @generated
 	 */
	public Boolean getHideChargeInPrintouts(){
    return hideChargeInPrintouts; 
  }

	
	/**
	 * @generated
	 */	
	public void setHideChargeInPrintouts(Boolean newVal) {
    this.hideChargeInPrintouts = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
	private Boolean ignoreGlobalPriceChanges;
	
	/**
	 * @generated
 	 */
	public Boolean getIgnoreGlobalPriceChanges(){
    return ignoreGlobalPriceChanges; 
  }

	
	/**
	 * @generated
	 */	
	public void setIgnoreGlobalPriceChanges(Boolean newVal) {
    this.ignoreGlobalPriceChanges = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
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
 	@Basic
	private String label;
	
	/**
	 * @generated
 	 */
	public String getLabel(){
    return label; 
  }

	
	/**
	 * @generated
	 */	
	public void setLabel(String newVal) {
    this.label = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean binderyCharge;
	
	/**
	 * @generated
 	 */
	public Boolean getBinderyCharge(){
    return binderyCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setBinderyCharge(Boolean newVal) {
    this.binderyCharge = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String name;
	
	/**
	 * @generated
 	 */
	public String getName(){
    return name; 
  }

	
	/**
	 * @generated
	 */	
	public void setName(String newVal) {
    this.name = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private ChargeCategory parent;
	
	/**
	 * @generated
 	 */
	public ChargeCategory getParent(){
    return parent; 
  }

	
	/**
	 * @generated
	 */	
	public void setParent(ChargeCategory newVal) {
    this.parent = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useArea;
	
	/**
	 * @generated
 	 */
	public Boolean getUseArea(){
    return useArea; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseArea(Boolean newVal) {
    this.useArea = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useSetup;
	
	/**
	 * @generated
 	 */
	public Boolean getUseSetup(){
    return useSetup; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseSetup(Boolean newVal) {
    this.useSetup = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	private ChargeCost chargeCost;
	
	/** 
	 * @generated
 	 */
	public ChargeCost getChargeCost(){
    return chargeCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setChargeCost(ChargeCost newVal) {
    this.chargeCost = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double area;
	
	/**
	 * @generated
 	 */
	public Double getArea(){
    return area; 
  }

	
	/**
	 * @generated
	 */	
	public void setArea(Double newVal) {
    this.area = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean coverlb_check;
	
	/**
	 * @generated
 	 */
	public Boolean getCoverlb_check(){
    return coverlb_check; 
  }

	
	/**
	 * @generated
	 */	
	public void setCoverlb_check(Boolean newVal) {
    this.coverlb_check = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean sheet_lift_check;
	
	/**
	 * @generated
 	 */
	public Boolean getSheet_lift_check(){
    return sheet_lift_check; 
  }

	
	/**
	 * @generated
	 */	
	public void setSheet_lift_check(Boolean newVal) {
    this.sheet_lift_check = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean ship_markup_check;
	
	/**
	 * @generated
 	 */
	public Boolean getShip_markup_check(){
    return ship_markup_check; 
  }

	
	/**
	 * @generated
	 */	
	public void setShip_markup_check(Boolean newVal) {
    this.ship_markup_check = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="coverlbInk", precision=19, scale=4)
	private BigDecimal coverlbInk;
	
	/**
	 * @generated
 	 */
	public BigDecimal getCoverlbInk(){
    return coverlbInk; 
  }

	
	/**
   * @generated
   */	
  public void setCoverlbInk(BigDecimal newVal) {
    this.coverlbInk = newVal;
    this.coverlbInk.setScale(4, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setCoverlbInk(double newVal) {
    this.coverlbInk = BigDecimal.valueOf(newVal);
    this.coverlbInk.setScale(4, RoundingMode.HALF_UP);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Double sheetliftCut;
	
	/**
	 * @generated
 	 */
	public Double getSheetliftCut(){
    return sheetliftCut; 
  }

	
	/**
   * @generated
   */	
  public void setSheetliftCut(Double newVal) {
    this.sheetliftCut = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Double shipMarkup;
	
	/**
	 * @generated
 	 */
	public Double getShipMarkup(){
    return shipMarkup; 
  }

	
	/**
	 * @generated
	 */	
	public void setShipMarkup(Double newVal) {
    this.shipMarkup = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useRunArea;
	
	/**
	 * @generated
 	 */
	public Boolean getUseRunArea(){
    return useRunArea; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseRunArea(Boolean newVal) {
    this.useRunArea = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="setupPrice", precision=19, scale=4)
	private BigDecimal setupPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSetupPrice(){
    return setupPrice; 
  }

	
	/**
   * @generated
   */	
  public void setSetupPrice(BigDecimal newVal) {
    this.setupPrice = newVal;
    this.setupPrice.setScale(4, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
  public void setSetupPrice(double newVal) {
    this.setupPrice = BigDecimal.valueOf(newVal);
    this.setupPrice.setScale(4, RoundingMode.HALF_UP);
  }


	/**
   * @generated
   */	
 	@Basic
  private BigDecimal costingUnitPrice;

	/**
   * @generated
 	 */
  public BigDecimal getCostingUnitPrice(){
    return costingUnitPrice; 
  }


	/**
   * @generated
   */	
  public void setCostingUnitPrice(BigDecimal newVal) {
    this.costingUnitPrice = newVal;
  }


	/**
   * @generated
   */	
  public void setCostingUnitPrice(double newVal) {
    this.costingUnitPrice = BigDecimal.valueOf(newVal);
  }


	/**
   * @generated
   */	
 	@Basic
  private BigDecimal costingSetupPrice;

	/**
   * @generated
 	 */
  public BigDecimal getCostingSetupPrice(){
    return costingSetupPrice; 
  }


	/**
   * @generated
   */	
  public void setCostingSetupPrice(BigDecimal newVal) {
    this.costingSetupPrice = newVal;
  }


	/**
   * @generated
   */	
  public void setCostingSetupPrice(double newVal) {
    this.costingSetupPrice = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
    @ManyToOne()
  private ProductCode productCode;

	/**
   * @generated
 	 */
  public ProductCode getProductCode(){
    return productCode; 
  }


	/**
   * @generated
   */	
  public void setProductCode(ProductCode newVal) {
    this.productCode = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private String presetDescription;

	/**
   * @generated
 	 */
  public String getPresetDescription(){
    return presetDescription; 
  }


	/**
   * @generated
   */	
  public void setPresetDescription(String newVal) {
    this.presetDescription = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetDescriptionLabel;

	/**
   * @generated
 	 */
  public String getPresetDescriptionLabel(){
    return presetDescriptionLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetDescriptionLabel(String newVal) {
    this.presetDescriptionLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetNotes;

	/**
   * @generated
 	 */
  public String getPresetNotes(){
    return presetNotes; 
  }


	/**
   * @generated
   */	
  public void setPresetNotes(String newVal) {
    this.presetNotes = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetNotesLabel;

	/**
   * @generated
 	 */
  public String getPresetNotesLabel(){
    return presetNotesLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetNotesLabel(String newVal) {
    this.presetNotesLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Integer presetQuantity;

	/**
   * @generated
 	 */
  public Integer getPresetQuantity(){
    return presetQuantity; 
  }


	/**
   * @generated
   */	
  public void setPresetQuantity(Integer newVal) {
    this.presetQuantity = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Integer presetQuantityLabel;

	/**
   * @generated
 	 */
  public Integer getPresetQuantityLabel(){
    return presetQuantityLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetQuantityLabel(Integer newVal) {
    this.presetQuantityLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetShowNotes;

	/**
   * @generated
 	 */
  public Boolean getPresetShowNotes(){
    return presetShowNotes; 
  }


	/**
   * @generated
   */	
  public void setPresetShowNotes(Boolean newVal) {
    this.presetShowNotes = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
  private ProductionLocations presetProductionLocation;

	/**
   * @generated
 	 */
  public ProductionLocations getPresetProductionLocation(){
    return presetProductionLocation; 
  }


	/**
   * @generated
   */	
  public void setPresetProductionLocation(ProductionLocations newVal) {
    this.presetProductionLocation = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private BigDecimal presetPrice;

	/**
   * @generated
 	 */
  public BigDecimal getPresetPrice(){
    return presetPrice; 
  }


	/**
   * @generated
   */	
  public void setPresetPrice(BigDecimal newVal) {
    this.presetPrice = newVal;
  }


	/**
   * @generated
   */	
  public void setPresetPrice(double newVal) {
    this.presetPrice = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetPriceLabel;

	/**
   * @generated
 	 */
  public String getPresetPriceLabel(){
    return presetPriceLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetPriceLabel(String newVal) {
    this.presetPriceLabel = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
  private TaxTable presetTaxTable;

	/**
   * @generated
 	 */
  public TaxTable getPresetTaxTable(){
    return presetTaxTable; 
  }


	/**
   * @generated
   */	
  public void setPresetTaxTable(TaxTable newVal) {
    this.presetTaxTable = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetFinished;

	/**
   * @generated
 	 */
  public Boolean getPresetFinished(){
    return presetFinished; 
  }


	/**
   * @generated
   */	
  public void setPresetFinished(Boolean newVal) {
    this.presetFinished = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetTaxable;

	/**
   * @generated
 	 */
  public Boolean getPresetTaxable(){
    return presetTaxable; 
  }


	/**
   * @generated
   */	
  public void setPresetTaxable(Boolean newVal) {
    this.presetTaxable = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal presetRate;

	/**
   * @generated
 	 */
  public BigDecimal getPresetRate(){
    return presetRate; 
  }


	/**
   * @generated
   */	
  public void setPresetRate(BigDecimal newVal) {
    this.presetRate = newVal;
  }


	/**
   * @generated
   */	
  public void setPresetRate(double newVal) {
    this.presetRate = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetRateLabel;

	/**
   * @generated
 	 */
  public String getPresetRateLabel(){
    return presetRateLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetRateLabel(String newVal) {
    this.presetRateLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetBrokered;

	/**
   * @generated
 	 */
  public Boolean getPresetBrokered(){
    return presetBrokered; 
  }


	/**
   * @generated
   */	
  public void setPresetBrokered(Boolean newVal) {
    this.presetBrokered = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetDisplayQuantity;

	/**
   * @generated
 	 */
  public Boolean getPresetDisplayQuantity(){
    return presetDisplayQuantity; 
  }


	/**
   * @generated
   */	
  public void setPresetDisplayQuantity(Boolean newVal) {
    this.presetDisplayQuantity = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean presetHidden;

	/**
   * @generated
 	 */
  public Boolean getPresetHidden(){
    return presetHidden; 
  }


	/**
   * @generated
   */	
  public void setPresetHidden(Boolean newVal) {
    this.presetHidden = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double presetUp;

	/**
   * @generated
 	 */
  public Double getPresetUp(){
    return presetUp; 
  }


	/**
   * @generated
   */	
  public void setPresetUp(Double newVal) {
    this.presetUp = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetUpLabel;

	/**
   * @generated
 	 */
  public String getPresetUpLabel(){
    return presetUpLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetUpLabel(String newVal) {
    this.presetUpLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Long presetInSetsOf;

	/**
   * @generated
 	 */
  public Long getPresetInSetsOf(){
    return presetInSetsOf; 
  }


	/**
   * @generated
   */	
  public void setPresetInSetsOf(Long newVal) {
    this.presetInSetsOf = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetInSetsOfLabel;

	/**
   * @generated
 	 */
  public String getPresetInSetsOfLabel(){
    return presetInSetsOfLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetInSetsOfLabel(String newVal) {
    this.presetInSetsOfLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double presetMaterialQuantity;

	/**
   * @generated
 	 */
  public Double getPresetMaterialQuantity(){
    return presetMaterialQuantity; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialQuantity(Double newVal) {
    this.presetMaterialQuantity = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetMaterialQuantityLabel;

	/**
   * @generated
 	 */
  public String getPresetMaterialQuantityLabel(){
    return presetMaterialQuantityLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialQuantityLabel(String newVal) {
    this.presetMaterialQuantityLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Long presetMaterialSetsOf;

	/**
   * @generated
 	 */
  public Long getPresetMaterialSetsOf(){
    return presetMaterialSetsOf; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialSetsOf(Long newVal) {
    this.presetMaterialSetsOf = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetMaterialSetsOfLabel;

	/**
   * @generated
 	 */
  public String getPresetMaterialSetsOfLabel(){
    return presetMaterialSetsOfLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialSetsOfLabel(String newVal) {
    this.presetMaterialSetsOfLabel = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal presetMaterialRate;

	/**
   * @generated
 	 */
  public BigDecimal getPresetMaterialRate(){
    return presetMaterialRate; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialRate(BigDecimal newVal) {
    this.presetMaterialRate = newVal;
  }


	/**
   * @generated
   */	
  public void setPresetMaterialRate(double newVal) {
    this.presetMaterialRate = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetMaterialRateLabel;

	/**
   * @generated
 	 */
  public String getPresetMaterialRateLabel(){
    return presetMaterialRateLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetMaterialRateLabel(String newVal) {
    this.presetMaterialRateLabel = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Long presetQuantityPerSet;

	/**
   * @generated
 	 */
  public Long getPresetQuantityPerSet(){
    return presetQuantityPerSet; 
  }


	/**
   * @generated
   */	
  public void setPresetQuantityPerSet(Long newVal) {
    this.presetQuantityPerSet = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String presetQuantityPerSetLabel;

	/**
   * @generated
 	 */
  public String getPresetQuantityPerSetLabel(){
    return presetQuantityPerSetLabel; 
  }


	/**
   * @generated
   */	
  public void setPresetQuantityPerSetLabel(String newVal) {
    this.presetQuantityPerSetLabel = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (METHOD.equals(propertyName)) return getMethod();
    if (QUANTITYTYPE.equals(propertyName)) return getQuantityType();
    if (MARKUPTYPE.equals(propertyName)) return getMarkupType();
    if (JOBQTY.equals(propertyName)) return getJobQty();
    if (PRICEMETHOD.equals(propertyName)) return getPriceMethod();
    if (INKCOVERAGE.equals(propertyName)) return getInkCoverage();
    if (USESIDES.equals(propertyName)) return getUseSides();
    if (DONOTDISCOUNT.equals(propertyName)) return getDoNotDiscount();
    if (NOMATERIALQUANTITY.equals(propertyName)) return getNoMaterialQuantity();
    if (NOOVERRIDES.equals(propertyName)) return getNoOverrides();
    if (ADJUSTABLESETS.equals(propertyName)) return getAdjustableSets();
    if (ADJUSTABLERATE.equals(propertyName)) return getAdjustableRate();
    if (ADJUSTABLEMATERIAL.equals(propertyName)) return getAdjustableMaterial();
    if (USEMATERIAL.equals(propertyName)) return getUseMaterial();
    if (USERATE.equals(propertyName)) return getUseRate();
    if (USERATESETS.equals(propertyName)) return getUseRateSets();
    if (USEMERCHANDISESETS.equals(propertyName)) return getUseMerchandiseSets();
    if (USEMINIMUMCHARGE.equals(propertyName)) return getUseMinimumCharge();
    if (USECOLORS.equals(propertyName)) return getUseColors();
    if (USEORIGINALS.equals(propertyName)) return getUseOriginals();
    if (RATESETCOUNT.equals(propertyName)) return getRateSetCount();
    if (MATERIALSETCOUNT.equals(propertyName)) return getMaterialSetCount();
    if (RATE.equals(propertyName)) return getRate();
    if (MATERIAL.equals(propertyName)) return getMaterial();
    if (MINIMUM.equals(propertyName)) return getMinimum();
    if (MARKUP.equals(propertyName)) return getMarkup();
    if (PRICELIST.equals(propertyName)) return getPriceList();
    if (WASTECHART.equals(propertyName)) return getWasteChart();
    if (FIXEDWASTE.equals(propertyName)) return getFixedWaste();
    if (WASTEPERCENTAGE.equals(propertyName)) return getWastePercentage();
    if (BASELINEARNUMBER.equals(propertyName)) return getBaseLinearNumber();
    if (LOCATION.equals(propertyName)) return getLocation();
    if (COSTCENTER.equals(propertyName)) return getCostCenter();
    if (SUBSTRATE.equals(propertyName)) return getSubstrate();
    if (MINIMUMTIME.equals(propertyName)) return getMinimumTime();
    if (SIZEX.equals(propertyName)) return getSizeX();
    if (SIZEY.equals(propertyName)) return getSizeY();
    if (PLATETHICKNESS.equals(propertyName)) return getPlateThickness();
    if (FOLDTEMPLATE.equals(propertyName)) return getFoldTemplate();
    if (EXCLUDEDFROMWORKFLOW.equals(propertyName)) return getExcludedFromWorkflow();
    if (PREPRODUCTION.equals(propertyName)) return getPreproduction();
    if (USEMINIMUMTIME.equals(propertyName)) return getUseMinimumTime();
    if (USEDIVIDEBYUPCOUNT.equals(propertyName)) return getUseDivideByUpCount();
    if (USEMULTIPLYUPCOUNT.equals(propertyName)) return getUseMultiplyUpCount();
    if (ADJUSTUPS.equals(propertyName)) return getAdjustUps();
    if (CUTSAREPREPRESS.equals(propertyName)) return getCutsArePrePress();
    if (INTEGRATEDCTP.equals(propertyName)) return getIntegratedCTP();
    if (SKU.equals(propertyName)) return getSku();
    if (CATEGORY.equals(propertyName)) return getCategory();
    if (OVERRIDERATE.equals(propertyName)) return getOverrideRate();
    if (TITLE.equals(propertyName)) return getTitle();
    if (NOTE.equals(propertyName)) return getNote();
    if (CHARGEGROUP.equals(propertyName)) return getChargeGroup();
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
    if (HIDECHARGEINPRINTOUTS.equals(propertyName)) return getHideChargeInPrintouts();
    if (DELETEDPRESET.equals(propertyName)) return getDeletedPreset();
    if (IGNORECUTS.equals(propertyName)) return getIgnoreCuts();
    if (USESIGNATURES.equals(propertyName)) return getUseSignatures();
    if (STOCKCHARGE.equals(propertyName)) return getStockCharge();
    if (OVERRIDENUMBEROFCUTS.equals(propertyName)) return getOverrideNumberOfCuts();
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
    if (IGNOREGLOBALPRICECHANGES.equals(propertyName)) return getIgnoreGlobalPriceChanges();
    if (COSTINGPRESSCHARGE.equals(propertyName)) return getCostingPressCharge();
    if (LINEARX1.equals(propertyName)) return getLinearX1();
    if (LINEARX2.equals(propertyName)) return getLinearX2();
    if (LINEARY1.equals(propertyName)) return getLinearY1();
    if (LINEARY2.equals(propertyName)) return getLinearY2();
    if (LABEL.equals(propertyName)) return getLabel();
    if (BINDERYCHARGE.equals(propertyName)) return getBinderyCharge();
    if (NAME.equals(propertyName)) return getName();
    if (PARENT.equals(propertyName)) return getParent();
    if (USEAREA.equals(propertyName)) return getUseArea();
    if (USESETUP.equals(propertyName)) return getUseSetup();
    if (CHARGECOST.equals(propertyName)) return getChargeCost();
    if (AREA.equals(propertyName)) return getArea();
    if (COVERLB_CHECK.equals(propertyName)) return getCoverlb_check();
    if (SHEET_LIFT_CHECK.equals(propertyName)) return getSheet_lift_check();
    if (SHIP_MARKUP_CHECK.equals(propertyName)) return getShip_markup_check();
    if (COVERLBINK.equals(propertyName)) return getCoverlbInk();
    if (SHEETLIFTCUT.equals(propertyName)) return getSheetliftCut();
    if (SHIPMARKUP.equals(propertyName)) return getShipMarkup();
    if (USERUNAREA.equals(propertyName)) return getUseRunArea();
    if (SETUPPRICE.equals(propertyName)) return getSetupPrice();
    if (COSTINGUNITPRICE.equals(propertyName)) return getCostingUnitPrice();
    if (COSTINGSETUPPRICE.equals(propertyName)) return getCostingSetupPrice();
    if (PRODUCTCODE.equals(propertyName)) return getProductCode();
    if (PRESETDESCRIPTION.equals(propertyName)) return getPresetDescription();
    if (PRESETDESCRIPTIONLABEL.equals(propertyName)) return getPresetDescriptionLabel();
    if (PRESETNOTES.equals(propertyName)) return getPresetNotes();
    if (PRESETNOTESLABEL.equals(propertyName)) return getPresetNotesLabel();
    if (PRESETQUANTITY.equals(propertyName)) return getPresetQuantity();
    if (PRESETQUANTITYLABEL.equals(propertyName)) return getPresetQuantityLabel();
    if (PRESETSHOWNOTES.equals(propertyName)) return getPresetShowNotes();
    if (PRESETPRODUCTIONLOCATION.equals(propertyName)) return getPresetProductionLocation();
    if (PRESETPRICE.equals(propertyName)) return getPresetPrice();
    if (PRESETPRICELABEL.equals(propertyName)) return getPresetPriceLabel();
    if (PRESETTAXTABLE.equals(propertyName)) return getPresetTaxTable();
    if (PRESETFINISHED.equals(propertyName)) return getPresetFinished();
    if (PRESETTAXABLE.equals(propertyName)) return getPresetTaxable();
    if (PRESETRATE.equals(propertyName)) return getPresetRate();
    if (PRESETRATELABEL.equals(propertyName)) return getPresetRateLabel();
    if (PRESETBROKERED.equals(propertyName)) return getPresetBrokered();
    if (PRESETDISPLAYQUANTITY.equals(propertyName)) return getPresetDisplayQuantity();
    if (PRESETHIDDEN.equals(propertyName)) return getPresetHidden();
    if (PRESETUP.equals(propertyName)) return getPresetUp();
    if (PRESETUPLABEL.equals(propertyName)) return getPresetUpLabel();
    if (PRESETINSETSOF.equals(propertyName)) return getPresetInSetsOf();
    if (PRESETINSETSOFLABEL.equals(propertyName)) return getPresetInSetsOfLabel();
    if (PRESETMATERIALQUANTITY.equals(propertyName)) return getPresetMaterialQuantity();
    if (PRESETMATERIALQUANTITYLABEL.equals(propertyName)) return getPresetMaterialQuantityLabel();
    if (PRESETMATERIALSETSOF.equals(propertyName)) return getPresetMaterialSetsOf();
    if (PRESETMATERIALSETSOFLABEL.equals(propertyName)) return getPresetMaterialSetsOfLabel();
    if (PRESETMATERIALRATE.equals(propertyName)) return getPresetMaterialRate();
    if (PRESETMATERIALRATELABEL.equals(propertyName)) return getPresetMaterialRateLabel();
    if (PRESETQUANTITYPERSET.equals(propertyName)) return getPresetQuantityPerSet();
    if (PRESETQUANTITYPERSETLABEL.equals(propertyName)) return getPresetQuantityPerSetLabel();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (METHOD.equals(propertyName)) setMethod((String)newValue); else
    if (QUANTITYTYPE.equals(propertyName)) setQuantityType((String)newValue); else
    if (MARKUPTYPE.equals(propertyName)) setMarkupType((String)newValue); else
    if (JOBQTY.equals(propertyName)) setJobQty((String)newValue); else
    if (PRICEMETHOD.equals(propertyName)) setPriceMethod((String)newValue); else
    if (INKCOVERAGE.equals(propertyName)) setInkCoverage((String)newValue); else
    if (USESIDES.equals(propertyName)) setUseSides((Boolean)newValue); else
    if (DONOTDISCOUNT.equals(propertyName)) setDoNotDiscount((Boolean)newValue); else
    if (NOMATERIALQUANTITY.equals(propertyName)) setNoMaterialQuantity((Boolean)newValue); else
    if (NOOVERRIDES.equals(propertyName)) setNoOverrides((Boolean)newValue); else
    if (ADJUSTABLESETS.equals(propertyName)) setAdjustableSets((Boolean)newValue); else
    if (ADJUSTABLERATE.equals(propertyName)) setAdjustableRate((Boolean)newValue); else
    if (ADJUSTABLEMATERIAL.equals(propertyName)) setAdjustableMaterial((Boolean)newValue); else
    if (USEMATERIAL.equals(propertyName)) setUseMaterial((Boolean)newValue); else
    if (USERATE.equals(propertyName)) setUseRate((Boolean)newValue); else
    if (USERATESETS.equals(propertyName)) setUseRateSets((Boolean)newValue); else
    if (USEMERCHANDISESETS.equals(propertyName)) setUseMerchandiseSets((Boolean)newValue); else
    if (USEMINIMUMCHARGE.equals(propertyName)) setUseMinimumCharge((Boolean)newValue); else
    if (USECOLORS.equals(propertyName)) setUseColors((Boolean)newValue); else
    if (USEORIGINALS.equals(propertyName)) setUseOriginals((Boolean)newValue); else
    if (RATESETCOUNT.equals(propertyName)) setRateSetCount((Double)newValue); else
    if (MATERIALSETCOUNT.equals(propertyName)) setMaterialSetCount((Double)newValue); else
    if (RATE.equals(propertyName)) setRate((BigDecimal)newValue); else
    if (MATERIAL.equals(propertyName)) setMaterial((BigDecimal)newValue); else
    if (MINIMUM.equals(propertyName)) setMinimum((BigDecimal)newValue); else
    if (MARKUP.equals(propertyName)) setMarkup((Double)newValue); else
    if (PRICELIST.equals(propertyName)) setPriceList((PriceList)newValue); else
    if (WASTECHART.equals(propertyName)) setWasteChart((WasteChart)newValue); else
    if (FIXEDWASTE.equals(propertyName)) setFixedWaste((Long)newValue); else
    if (WASTEPERCENTAGE.equals(propertyName)) setWastePercentage((Double)newValue); else
    if (BASELINEARNUMBER.equals(propertyName)) setBaseLinearNumber((Long)newValue); else
    if (LOCATION.equals(propertyName)) setLocation((ProductionLocations)newValue); else
    if (COSTCENTER.equals(propertyName)) setCostCenter((CostCenter)newValue); else
    if (SUBSTRATE.equals(propertyName)) setSubstrate((Substrate)newValue); else
    if (MINIMUMTIME.equals(propertyName)) setMinimumTime((Long)newValue); else
    if (SIZEX.equals(propertyName)) setSizeX((Double)newValue); else
    if (SIZEY.equals(propertyName)) setSizeY((Double)newValue); else
    if (PLATETHICKNESS.equals(propertyName)) setPlateThickness((Double)newValue); else
    if (FOLDTEMPLATE.equals(propertyName)) setFoldTemplate((FoldTemplate)newValue); else
    if (EXCLUDEDFROMWORKFLOW.equals(propertyName)) setExcludedFromWorkflow((Boolean)newValue); else
    if (PREPRODUCTION.equals(propertyName)) setPreproduction((Boolean)newValue); else
    if (USEMINIMUMTIME.equals(propertyName)) setUseMinimumTime((Boolean)newValue); else
    if (USEDIVIDEBYUPCOUNT.equals(propertyName)) setUseDivideByUpCount((Boolean)newValue); else
    if (USEMULTIPLYUPCOUNT.equals(propertyName)) setUseMultiplyUpCount((Boolean)newValue); else
    if (ADJUSTUPS.equals(propertyName)) setAdjustUps((Boolean)newValue); else
    if (CUTSAREPREPRESS.equals(propertyName)) setCutsArePrePress((Boolean)newValue); else
    if (INTEGRATEDCTP.equals(propertyName)) setIntegratedCTP((Boolean)newValue); else
    if (SKU.equals(propertyName)) setSku((String)newValue); else
    if (CATEGORY.equals(propertyName)) setCategory((String)newValue); else
    if (OVERRIDERATE.equals(propertyName)) setOverrideRate((Boolean)newValue); else
    if (TITLE.equals(propertyName)) setTitle((String)newValue); else
    if (NOTE.equals(propertyName)) setNote((String)newValue); else
    if (CHARGEGROUP.equals(propertyName)) setChargeGroup((String)newValue); else
    if (SALESCATEGORY.equals(propertyName)) setSalesCategory((SalesCategory)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (RATEQTY.equals(propertyName)) setRateQty((Double)newValue); else
    if (MATERIALQTY.equals(propertyName)) setMaterialQty((Double)newValue); else
    if (GROUPQTY.equals(propertyName)) setGroupQty((Double)newValue); else
    if (PRICE.equals(propertyName)) setPrice((BigDecimal)newValue); else
    if (TIMESTART.equals(propertyName)) setTimeStart((Date)newValue); else
    if (TIMEEND.equals(propertyName)) setTimeEnd((Date)newValue); else
    if (CUSTOMERCHARGE.equals(propertyName)) setCustomerCharge((Boolean)newValue); else
    if (PRESSCHARGE.equals(propertyName)) setPressCharge((Boolean)newValue); else
    if (HIDECHARGEINPRINTOUTS.equals(propertyName)) setHideChargeInPrintouts((Boolean)newValue); else
    if (DELETEDPRESET.equals(propertyName)) setDeletedPreset((Boolean)newValue); else
    if (IGNORECUTS.equals(propertyName)) setIgnoreCuts((Boolean)newValue); else
    if (USESIGNATURES.equals(propertyName)) setUseSignatures((Boolean)newValue); else
    if (STOCKCHARGE.equals(propertyName)) setStockCharge((Boolean)newValue); else
    if (OVERRIDENUMBEROFCUTS.equals(propertyName)) setOverrideNumberOfCuts((Boolean)newValue); else
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
    if (IGNOREGLOBALPRICECHANGES.equals(propertyName)) setIgnoreGlobalPriceChanges((Boolean)newValue); else
    if (COSTINGPRESSCHARGE.equals(propertyName)) setCostingPressCharge((Boolean)newValue); else
    if (LINEARX1.equals(propertyName)) setLinearX1((Boolean)newValue); else
    if (LINEARX2.equals(propertyName)) setLinearX2((Boolean)newValue); else
    if (LINEARY1.equals(propertyName)) setLinearY1((Boolean)newValue); else
    if (LINEARY2.equals(propertyName)) setLinearY2((Boolean)newValue); else
    if (LABEL.equals(propertyName)) setLabel((String)newValue); else
    if (BINDERYCHARGE.equals(propertyName)) setBinderyCharge((Boolean)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (PARENT.equals(propertyName)) setParent((ChargeCategory)newValue); else
    if (USEAREA.equals(propertyName)) setUseArea((Boolean)newValue); else
    if (USESETUP.equals(propertyName)) setUseSetup((Boolean)newValue); else
    if (CHARGECOST.equals(propertyName)) setChargeCost((ChargeCost)newValue); else
    if (AREA.equals(propertyName)) setArea((Double)newValue); else
    if (COVERLB_CHECK.equals(propertyName)) setCoverlb_check((Boolean)newValue); else
    if (SHEET_LIFT_CHECK.equals(propertyName)) setSheet_lift_check((Boolean)newValue); else
    if (SHIP_MARKUP_CHECK.equals(propertyName)) setShip_markup_check((Boolean)newValue); else
    if (COVERLBINK.equals(propertyName)) setCoverlbInk((BigDecimal)newValue); else
    if (SHEETLIFTCUT.equals(propertyName)) setSheetliftCut((Double)newValue); else
    if (SHIPMARKUP.equals(propertyName)) setShipMarkup((Double)newValue); else
    if (USERUNAREA.equals(propertyName)) setUseRunArea((Boolean)newValue); else
    if (SETUPPRICE.equals(propertyName)) setSetupPrice((BigDecimal)newValue); else
    if (COSTINGUNITPRICE.equals(propertyName)) setCostingUnitPrice((BigDecimal)newValue); else
    if (COSTINGSETUPPRICE.equals(propertyName)) setCostingSetupPrice((BigDecimal)newValue); else
    if (PRODUCTCODE.equals(propertyName)) setProductCode((ProductCode)newValue); else
    if (PRESETDESCRIPTION.equals(propertyName)) setPresetDescription((String)newValue); else
    if (PRESETDESCRIPTIONLABEL.equals(propertyName)) setPresetDescriptionLabel((String)newValue); else
    if (PRESETNOTES.equals(propertyName)) setPresetNotes((String)newValue); else
    if (PRESETNOTESLABEL.equals(propertyName)) setPresetNotesLabel((String)newValue); else
    if (PRESETQUANTITY.equals(propertyName)) setPresetQuantity((Integer)newValue); else
    if (PRESETQUANTITYLABEL.equals(propertyName)) setPresetQuantityLabel((Integer)newValue); else
    if (PRESETSHOWNOTES.equals(propertyName)) setPresetShowNotes((Boolean)newValue); else
    if (PRESETPRODUCTIONLOCATION.equals(propertyName)) setPresetProductionLocation((ProductionLocations)newValue); else
    if (PRESETPRICE.equals(propertyName)) setPresetPrice((BigDecimal)newValue); else
    if (PRESETPRICELABEL.equals(propertyName)) setPresetPriceLabel((String)newValue); else
    if (PRESETTAXTABLE.equals(propertyName)) setPresetTaxTable((TaxTable)newValue); else
    if (PRESETFINISHED.equals(propertyName)) setPresetFinished((Boolean)newValue); else
    if (PRESETTAXABLE.equals(propertyName)) setPresetTaxable((Boolean)newValue); else
    if (PRESETRATE.equals(propertyName)) setPresetRate((BigDecimal)newValue); else
    if (PRESETRATELABEL.equals(propertyName)) setPresetRateLabel((String)newValue); else
    if (PRESETBROKERED.equals(propertyName)) setPresetBrokered((Boolean)newValue); else
    if (PRESETDISPLAYQUANTITY.equals(propertyName)) setPresetDisplayQuantity((Boolean)newValue); else
    if (PRESETHIDDEN.equals(propertyName)) setPresetHidden((Boolean)newValue); else
    if (PRESETUP.equals(propertyName)) setPresetUp((Double)newValue); else
    if (PRESETUPLABEL.equals(propertyName)) setPresetUpLabel((String)newValue); else
    if (PRESETINSETSOF.equals(propertyName)) setPresetInSetsOf((Long)newValue); else
    if (PRESETINSETSOFLABEL.equals(propertyName)) setPresetInSetsOfLabel((String)newValue); else
    if (PRESETMATERIALQUANTITY.equals(propertyName)) setPresetMaterialQuantity((Double)newValue); else
    if (PRESETMATERIALQUANTITYLABEL.equals(propertyName)) setPresetMaterialQuantityLabel((String)newValue); else
    if (PRESETMATERIALSETSOF.equals(propertyName)) setPresetMaterialSetsOf((Long)newValue); else
    if (PRESETMATERIALSETSOFLABEL.equals(propertyName)) setPresetMaterialSetsOfLabel((String)newValue); else
    if (PRESETMATERIALRATE.equals(propertyName)) setPresetMaterialRate((BigDecimal)newValue); else
    if (PRESETMATERIALRATELABEL.equals(propertyName)) setPresetMaterialRateLabel((String)newValue); else
    if (PRESETQUANTITYPERSET.equals(propertyName)) setPresetQuantityPerSet((Long)newValue); else
    if (PRESETQUANTITYPERSETLABEL.equals(propertyName)) setPresetQuantityPerSetLabel((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (METHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (QUANTITYTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (MARKUPTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBQTY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRICEMETHOD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (INKCOVERAGE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (USESIDES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DONOTDISCOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NOMATERIALQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NOOVERRIDES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADJUSTABLESETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADJUSTABLERATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADJUSTABLEMATERIAL.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEMATERIAL.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USERATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USERATESETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEMERCHANDISESETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEMINIMUMCHARGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USECOLORS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEORIGINALS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RATESETCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MATERIALSETCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (RATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (MATERIAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (MINIMUM.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (MARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICELIST.equals(propertyName)) 
      return new Class<?>[] {PriceList.class};		
    if (WASTECHART.equals(propertyName)) 
      return new Class<?>[] {WasteChart.class};		
    if (FIXEDWASTE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (WASTEPERCENTAGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BASELINEARNUMBER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (LOCATION.equals(propertyName)) 
      return new Class<?>[] {ProductionLocations.class};		
    if (COSTCENTER.equals(propertyName)) 
      return new Class<?>[] {CostCenter.class};		
    if (SUBSTRATE.equals(propertyName)) 
      return new Class<?>[] {Substrate.class};		
    if (MINIMUMTIME.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (SIZEX.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SIZEY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PLATETHICKNESS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FOLDTEMPLATE.equals(propertyName)) 
      return new Class<?>[] {FoldTemplate.class};		
    if (EXCLUDEDFROMWORKFLOW.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PREPRODUCTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEMINIMUMTIME.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEDIVIDEBYUPCOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEMULTIPLYUPCOUNT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADJUSTUPS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CUTSAREPREPRESS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INTEGRATEDCTP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SKU.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CATEGORY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (OVERRIDERATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TITLE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NOTE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHARGEGROUP.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESCATEGORY.equals(propertyName)) 
      return new Class<?>[] {SalesCategory.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (RATEQTY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MATERIALQTY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (GROUPQTY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TIMESTART.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (TIMEEND.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CUSTOMERCHARGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESSCHARGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (HIDECHARGEINPRINTOUTS.equals(propertyName)) 
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
    if (IGNOREGLOBALPRICECHANGES.equals(propertyName)) 
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
    if (LABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (BINDERYCHARGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARENT.equals(propertyName)) 
      return new Class<?>[] {ChargeCategory.class};		
    if (USEAREA.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USESETUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CHARGECOST.equals(propertyName)) 
      return new Class<?>[] {ChargeCost.class};		
    if (AREA.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COVERLB_CHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHEET_LIFT_CHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHIP_MARKUP_CHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COVERLBINK.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SHEETLIFTCUT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHIPMARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USERUNAREA.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SETUPPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (COSTINGUNITPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (COSTINGSETUPPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRODUCTCODE.equals(propertyName)) 
      return new Class<?>[] {ProductCode.class};		
    if (PRESETDESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETDESCRIPTIONLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETNOTES.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETNOTESLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (PRESETQUANTITYLABEL.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (PRESETSHOWNOTES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETPRODUCTIONLOCATION.equals(propertyName)) 
      return new Class<?>[] {ProductionLocations.class};		
    if (PRESETPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRESETPRICELABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETTAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (PRESETFINISHED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETTAXABLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETRATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRESETRATELABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETBROKERED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETDISPLAYQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETHIDDEN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRESETUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRESETUPLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETINSETSOF.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PRESETINSETSOFLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETMATERIALQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRESETMATERIALQUANTITYLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETMATERIALSETSOF.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PRESETMATERIALSETSOFLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETMATERIALRATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRESETMATERIALRATELABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRESETQUANTITYPERSET.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PRESETQUANTITYPERSETLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (METHOD.equals(propertyName)) return ChargeDefinition.class;
    if (QUANTITYTYPE.equals(propertyName)) return ChargeDefinition.class;
    if (MARKUPTYPE.equals(propertyName)) return ChargeDefinition.class;
    if (JOBQTY.equals(propertyName)) return ChargeDefinition.class;
    if (PRICEMETHOD.equals(propertyName)) return ChargeDefinition.class;
    if (INKCOVERAGE.equals(propertyName)) return ChargeDefinition.class;
    if (USESIDES.equals(propertyName)) return ChargeDefinition.class;
    if (DONOTDISCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (NOMATERIALQUANTITY.equals(propertyName)) return ChargeDefinition.class;
    if (NOOVERRIDES.equals(propertyName)) return ChargeDefinition.class;
    if (ADJUSTABLESETS.equals(propertyName)) return ChargeDefinition.class;
    if (ADJUSTABLERATE.equals(propertyName)) return ChargeDefinition.class;
    if (ADJUSTABLEMATERIAL.equals(propertyName)) return ChargeDefinition.class;
    if (USEMATERIAL.equals(propertyName)) return ChargeDefinition.class;
    if (USERATE.equals(propertyName)) return ChargeDefinition.class;
    if (USERATESETS.equals(propertyName)) return ChargeDefinition.class;
    if (USEMERCHANDISESETS.equals(propertyName)) return ChargeDefinition.class;
    if (USEMINIMUMCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (USECOLORS.equals(propertyName)) return ChargeDefinition.class;
    if (USEORIGINALS.equals(propertyName)) return ChargeDefinition.class;
    if (RATESETCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (MATERIALSETCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (RATE.equals(propertyName)) return ChargeDefinition.class;
    if (MATERIAL.equals(propertyName)) return ChargeDefinition.class;
    if (MINIMUM.equals(propertyName)) return ChargeDefinition.class;
    if (MARKUP.equals(propertyName)) return ChargeDefinition.class;
    if (PRICELIST.equals(propertyName)) return ChargeDefinition.class;
    if (WASTECHART.equals(propertyName)) return ChargeDefinition.class;
    if (FIXEDWASTE.equals(propertyName)) return ChargeDefinition.class;
    if (WASTEPERCENTAGE.equals(propertyName)) return ChargeDefinition.class;
    if (BASELINEARNUMBER.equals(propertyName)) return ChargeDefinition.class;
    if (LOCATION.equals(propertyName)) return ChargeDefinition.class;
    if (COSTCENTER.equals(propertyName)) return ChargeDefinition.class;
    if (SUBSTRATE.equals(propertyName)) return ChargeDefinition.class;
    if (MINIMUMTIME.equals(propertyName)) return ChargeDefinition.class;
    if (SIZEX.equals(propertyName)) return ChargeDefinition.class;
    if (SIZEY.equals(propertyName)) return ChargeDefinition.class;
    if (PLATETHICKNESS.equals(propertyName)) return ChargeDefinition.class;
    if (FOLDTEMPLATE.equals(propertyName)) return ChargeDefinition.class;
    if (EXCLUDEDFROMWORKFLOW.equals(propertyName)) return ChargeDefinition.class;
    if (PREPRODUCTION.equals(propertyName)) return ChargeDefinition.class;
    if (USEMINIMUMTIME.equals(propertyName)) return ChargeDefinition.class;
    if (USEDIVIDEBYUPCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (USEMULTIPLYUPCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (ADJUSTUPS.equals(propertyName)) return ChargeDefinition.class;
    if (CUTSAREPREPRESS.equals(propertyName)) return ChargeDefinition.class;
    if (INTEGRATEDCTP.equals(propertyName)) return ChargeDefinition.class;
    if (SKU.equals(propertyName)) return ChargeDefinition.class;
    if (CATEGORY.equals(propertyName)) return ChargeDefinition.class;
    if (OVERRIDERATE.equals(propertyName)) return ChargeDefinition.class;
    if (TITLE.equals(propertyName)) return ChargeDefinition.class;
    if (NOTE.equals(propertyName)) return ChargeDefinition.class;
    if (CHARGEGROUP.equals(propertyName)) return ChargeDefinition.class;
    if (SALESCATEGORY.equals(propertyName)) return ChargeDefinition.class;
    if (TAXTABLE.equals(propertyName)) return ChargeDefinition.class;
    if (RATEQTY.equals(propertyName)) return ChargeDefinition.class;
    if (MATERIALQTY.equals(propertyName)) return ChargeDefinition.class;
    if (GROUPQTY.equals(propertyName)) return ChargeDefinition.class;
    if (PRICE.equals(propertyName)) return ChargeDefinition.class;
    if (TIMESTART.equals(propertyName)) return ChargeDefinition.class;
    if (TIMEEND.equals(propertyName)) return ChargeDefinition.class;
    if (CUSTOMERCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESSCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (HIDECHARGEINPRINTOUTS.equals(propertyName)) return ChargeDefinition.class;
    if (DELETEDPRESET.equals(propertyName)) return ChargeDefinition.class;
    if (IGNORECUTS.equals(propertyName)) return ChargeDefinition.class;
    if (USESIGNATURES.equals(propertyName)) return ChargeDefinition.class;
    if (STOCKCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (OVERRIDENUMBEROFCUTS.equals(propertyName)) return ChargeDefinition.class;
    if (OVERRIDEPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (OVERRIDERATEQUANTITY.equals(propertyName)) return ChargeDefinition.class;
    if (OVERRIDEMATERIALQTY.equals(propertyName)) return ChargeDefinition.class;
    if (VERSION.equals(propertyName)) return ChargeDefinition.class;
    if (SHIPMODE.equals(propertyName)) return ChargeDefinition.class;
    if (ADJUSTUPSCOUNT.equals(propertyName)) return ChargeDefinition.class;
    if (HASLINKPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (NEEDLINKPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (HASSHIPPED.equals(propertyName)) return ChargeDefinition.class;
    if (SHOULDSHIP.equals(propertyName)) return ChargeDefinition.class;
    if (JOBTASKLIST.equals(propertyName)) return ChargeDefinition.class;
    if (HIDEPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (IGNOREGLOBALPRICECHANGES.equals(propertyName)) return ChargeDefinition.class;
    if (COSTINGPRESSCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (LINEARX1.equals(propertyName)) return ChargeDefinition.class;
    if (LINEARX2.equals(propertyName)) return ChargeDefinition.class;
    if (LINEARY1.equals(propertyName)) return ChargeDefinition.class;
    if (LINEARY2.equals(propertyName)) return ChargeDefinition.class;
    if (LABEL.equals(propertyName)) return ChargeDefinition.class;
    if (BINDERYCHARGE.equals(propertyName)) return ChargeDefinition.class;
    if (NAME.equals(propertyName)) return ChargeDefinition.class;
    if (PARENT.equals(propertyName)) return ChargeDefinition.class;
    if (USEAREA.equals(propertyName)) return ChargeDefinition.class;
    if (USESETUP.equals(propertyName)) return ChargeDefinition.class;
    if (CHARGECOST.equals(propertyName)) return ChargeDefinition.class;
    if (AREA.equals(propertyName)) return ChargeDefinition.class;
    if (COVERLB_CHECK.equals(propertyName)) return ChargeDefinition.class;
    if (SHEET_LIFT_CHECK.equals(propertyName)) return ChargeDefinition.class;
    if (SHIP_MARKUP_CHECK.equals(propertyName)) return ChargeDefinition.class;
    if (COVERLBINK.equals(propertyName)) return ChargeDefinition.class;
    if (SHEETLIFTCUT.equals(propertyName)) return ChargeDefinition.class;
    if (SHIPMARKUP.equals(propertyName)) return ChargeDefinition.class;
    if (USERUNAREA.equals(propertyName)) return ChargeDefinition.class;
    if (SETUPPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (COSTINGUNITPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (COSTINGSETUPPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (PRODUCTCODE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETDESCRIPTION.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETDESCRIPTIONLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETNOTES.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETNOTESLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETQUANTITY.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETQUANTITYLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETSHOWNOTES.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETPRODUCTIONLOCATION.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETPRICE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETPRICELABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETTAXTABLE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETFINISHED.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETTAXABLE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETRATE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETRATELABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETBROKERED.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETDISPLAYQUANTITY.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETHIDDEN.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETUP.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETUPLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETINSETSOF.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETINSETSOFLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALQUANTITY.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALQUANTITYLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALSETSOF.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALSETSOFLABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALRATE.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETMATERIALRATELABEL.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETQUANTITYPERSET.equals(propertyName)) return ChargeDefinition.class;
    if (PRESETQUANTITYPERSETLABEL.equals(propertyName)) return ChargeDefinition.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    ChargeDefinition objT = (ChargeDefinition)obj;
    if (! SmartEquals(getMethod(), objT.getMethod()))
      return false;
    if (! SmartEquals(getQuantityType(), objT.getQuantityType()))
      return false;
    if (! SmartEquals(getMarkupType(), objT.getMarkupType()))
      return false;
    if (! SmartEquals(getJobQty(), objT.getJobQty()))
      return false;
    if (! SmartEquals(getPriceMethod(), objT.getPriceMethod()))
      return false;
    if (! SmartEquals(getInkCoverage(), objT.getInkCoverage()))
      return false;
    if (! SmartEquals(getUseSides(), objT.getUseSides()))
      return false;
    if (! SmartEquals(getDoNotDiscount(), objT.getDoNotDiscount()))
      return false;
    if (! SmartEquals(getNoMaterialQuantity(), objT.getNoMaterialQuantity()))
      return false;
    if (! SmartEquals(getNoOverrides(), objT.getNoOverrides()))
      return false;
    if (! SmartEquals(getAdjustableSets(), objT.getAdjustableSets()))
      return false;
    if (! SmartEquals(getAdjustableRate(), objT.getAdjustableRate()))
      return false;
    if (! SmartEquals(getAdjustableMaterial(), objT.getAdjustableMaterial()))
      return false;
    if (! SmartEquals(getUseMaterial(), objT.getUseMaterial()))
      return false;
    if (! SmartEquals(getUseRate(), objT.getUseRate()))
      return false;
    if (! SmartEquals(getUseRateSets(), objT.getUseRateSets()))
      return false;
    if (! SmartEquals(getUseMerchandiseSets(), objT.getUseMerchandiseSets()))
      return false;
    if (! SmartEquals(getUseMinimumCharge(), objT.getUseMinimumCharge()))
      return false;
    if (! SmartEquals(getUseColors(), objT.getUseColors()))
      return false;
    if (! SmartEquals(getUseOriginals(), objT.getUseOriginals()))
      return false;
    if (! SmartEquals(getRateSetCount(), objT.getRateSetCount()))
      return false;
    if (! SmartEquals(getMaterialSetCount(), objT.getMaterialSetCount()))
      return false;
    if (! SmartEquals(getRate(), objT.getRate()))
      return false;
    if (! SmartEquals(getMaterial(), objT.getMaterial()))
      return false;
    if (! SmartEquals(getMinimum(), objT.getMinimum()))
      return false;
    if (! SmartEquals(getMarkup(), objT.getMarkup()))
      return false;
    if (! SmartEquals(getPriceList(), objT.getPriceList()))
      return false;
    if (! SmartEquals(getWasteChart(), objT.getWasteChart()))
      return false;
    if (! SmartEquals(getFixedWaste(), objT.getFixedWaste()))
      return false;
    if (! SmartEquals(getWastePercentage(), objT.getWastePercentage()))
      return false;
    if (! SmartEquals(getBaseLinearNumber(), objT.getBaseLinearNumber()))
      return false;
    if (! SmartEquals(getLocation(), objT.getLocation()))
      return false;
    if (! SmartEquals(getCostCenter(), objT.getCostCenter()))
      return false;
    if (! SmartEquals(getSubstrate(), objT.getSubstrate()))
      return false;
    if (! SmartEquals(getMinimumTime(), objT.getMinimumTime()))
      return false;
    if (! SmartEquals(getSizeX(), objT.getSizeX()))
      return false;
    if (! SmartEquals(getSizeY(), objT.getSizeY()))
      return false;
    if (! SmartEquals(getPlateThickness(), objT.getPlateThickness()))
      return false;
    if (! SmartEquals(getFoldTemplate(), objT.getFoldTemplate()))
      return false;
    if (! SmartEquals(getExcludedFromWorkflow(), objT.getExcludedFromWorkflow()))
      return false;
    if (! SmartEquals(getPreproduction(), objT.getPreproduction()))
      return false;
    if (! SmartEquals(getUseMinimumTime(), objT.getUseMinimumTime()))
      return false;
    if (! SmartEquals(getUseDivideByUpCount(), objT.getUseDivideByUpCount()))
      return false;
    if (! SmartEquals(getUseMultiplyUpCount(), objT.getUseMultiplyUpCount()))
      return false;
    if (! SmartEquals(getAdjustUps(), objT.getAdjustUps()))
      return false;
    if (! SmartEquals(getCutsArePrePress(), objT.getCutsArePrePress()))
      return false;
    if (! SmartEquals(getIntegratedCTP(), objT.getIntegratedCTP()))
      return false;
    if (! SmartEquals(getSku(), objT.getSku()))
      return false;
    if (! SmartEquals(getCategory(), objT.getCategory()))
      return false;
    if (! SmartEquals(getOverrideRate(), objT.getOverrideRate()))
      return false;
    if (! SmartEquals(getTitle(), objT.getTitle()))
      return false;
    if (! SmartEquals(getNote(), objT.getNote()))
      return false;
    if (! SmartEquals(getChargeGroup(), objT.getChargeGroup()))
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
    if (! SmartEquals(getHideChargeInPrintouts(), objT.getHideChargeInPrintouts()))
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
    if (! SmartEquals(getIgnoreGlobalPriceChanges(), objT.getIgnoreGlobalPriceChanges()))
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
    if (! SmartEquals(getLabel(), objT.getLabel()))
      return false;
    if (! SmartEquals(getBinderyCharge(), objT.getBinderyCharge()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getParent(), objT.getParent()))
      return false;
    if (! SmartEquals(getUseArea(), objT.getUseArea()))
      return false;
    if (! SmartEquals(getUseSetup(), objT.getUseSetup()))
      return false;
    if (! SmartEquals(getChargeCost(), objT.getChargeCost()))
      return false;
    if (! SmartEquals(getArea(), objT.getArea()))
      return false;
    if (! SmartEquals(getCoverlb_check(), objT.getCoverlb_check()))
      return false;
    if (! SmartEquals(getSheet_lift_check(), objT.getSheet_lift_check()))
      return false;
    if (! SmartEquals(getShip_markup_check(), objT.getShip_markup_check()))
      return false;
    if (! SmartEquals(getCoverlbInk(), objT.getCoverlbInk()))
      return false;
    if (! SmartEquals(getSheetliftCut(), objT.getSheetliftCut()))
      return false;
    if (! SmartEquals(getShipMarkup(), objT.getShipMarkup()))
      return false;
    if (! SmartEquals(getUseRunArea(), objT.getUseRunArea()))
      return false;
    if (! SmartEquals(getSetupPrice(), objT.getSetupPrice()))
      return false;
    if (! SmartEquals(getCostingUnitPrice(), objT.getCostingUnitPrice()))
      return false;
    if (! SmartEquals(getCostingSetupPrice(), objT.getCostingSetupPrice()))
      return false;
    if (! SmartEquals(getProductCode(), objT.getProductCode()))
      return false;
    if (! SmartEquals(getPresetDescription(), objT.getPresetDescription()))
      return false;
    if (! SmartEquals(getPresetDescriptionLabel(), objT.getPresetDescriptionLabel()))
      return false;
    if (! SmartEquals(getPresetNotes(), objT.getPresetNotes()))
      return false;
    if (! SmartEquals(getPresetNotesLabel(), objT.getPresetNotesLabel()))
      return false;
    if (! SmartEquals(getPresetQuantity(), objT.getPresetQuantity()))
      return false;
    if (! SmartEquals(getPresetQuantityLabel(), objT.getPresetQuantityLabel()))
      return false;
    if (! SmartEquals(getPresetShowNotes(), objT.getPresetShowNotes()))
      return false;
    if (! SmartEquals(getPresetProductionLocation(), objT.getPresetProductionLocation()))
      return false;
    if (! SmartEquals(getPresetPrice(), objT.getPresetPrice()))
      return false;
    if (! SmartEquals(getPresetPriceLabel(), objT.getPresetPriceLabel()))
      return false;
    if (! SmartEquals(getPresetTaxTable(), objT.getPresetTaxTable()))
      return false;
    if (! SmartEquals(getPresetFinished(), objT.getPresetFinished()))
      return false;
    if (! SmartEquals(getPresetTaxable(), objT.getPresetTaxable()))
      return false;
    if (! SmartEquals(getPresetRate(), objT.getPresetRate()))
      return false;
    if (! SmartEquals(getPresetRateLabel(), objT.getPresetRateLabel()))
      return false;
    if (! SmartEquals(getPresetBrokered(), objT.getPresetBrokered()))
      return false;
    if (! SmartEquals(getPresetDisplayQuantity(), objT.getPresetDisplayQuantity()))
      return false;
    if (! SmartEquals(getPresetHidden(), objT.getPresetHidden()))
      return false;
    if (! SmartEquals(getPresetUp(), objT.getPresetUp()))
      return false;
    if (! SmartEquals(getPresetUpLabel(), objT.getPresetUpLabel()))
      return false;
    if (! SmartEquals(getPresetInSetsOf(), objT.getPresetInSetsOf()))
      return false;
    if (! SmartEquals(getPresetInSetsOfLabel(), objT.getPresetInSetsOfLabel()))
      return false;
    if (! SmartEquals(getPresetMaterialQuantity(), objT.getPresetMaterialQuantity()))
      return false;
    if (! SmartEquals(getPresetMaterialQuantityLabel(), objT.getPresetMaterialQuantityLabel()))
      return false;
    if (! SmartEquals(getPresetMaterialSetsOf(), objT.getPresetMaterialSetsOf()))
      return false;
    if (! SmartEquals(getPresetMaterialSetsOfLabel(), objT.getPresetMaterialSetsOfLabel()))
      return false;
    if (! SmartEquals(getPresetMaterialRate(), objT.getPresetMaterialRate()))
      return false;
    if (! SmartEquals(getPresetMaterialRateLabel(), objT.getPresetMaterialRateLabel()))
      return false;
    if (! SmartEquals(getPresetQuantityPerSet(), objT.getPresetQuantityPerSet()))
      return false;
    if (! SmartEquals(getPresetQuantityPerSetLabel(), objT.getPresetQuantityPerSetLabel()))
      return false;
    return true;
  }			
}
