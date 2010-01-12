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
	@NamedQuery(name = "ChargeDefinition.findall", query = "from ChargeDefinition"),
	@NamedQuery(name = "ChargeDefinition.byId", query = "select a from ChargeDefinition a where a.id= :id")
})


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
	public static final String NODISCOUNT = "NoDiscount";
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
	public static final String ADJUSTSETS = "AdjustSets";
	/**
	 * @generated
	 */
	public static final String ENTERRATE = "EnterRate";
	/**
	 * @generated
	 */
	public static final String ENTERMATERIAL = "EnterMaterial";
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
	public static final String EXCLUDEFROMPRODUCTIONLIST = "ExcludeFromProductionList";
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
	public ChargeDefinition() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
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
 	
	
 	@Basic
	private Boolean noDiscount;
	/**
	 * @generated
 	 */
	public Boolean getNoDiscount(){
		return noDiscount; 
	}

	/**
	 * @generated
	 */	
	public void setNoDiscount(Boolean newVal) {
		this.noDiscount = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean adjustSets;
	/**
	 * @generated
 	 */
	public Boolean getAdjustSets(){
		return adjustSets; 
	}

	/**
	 * @generated
	 */	
	public void setAdjustSets(Boolean newVal) {
		this.adjustSets = newVal;
	}
 	
	
 	@Basic
	private Boolean enterRate;
	/**
	 * @generated
 	 */
	public Boolean getEnterRate(){
		return enterRate; 
	}

	/**
	 * @generated
	 */	
	public void setEnterRate(Boolean newVal) {
		this.enterRate = newVal;
	}
 	
	
 	@Basic
	private Boolean enterMaterial;
	/**
	 * @generated
 	 */
	public Boolean getEnterMaterial(){
		return enterMaterial; 
	}

	/**
	 * @generated
	 */	
	public void setEnterMaterial(Boolean newVal) {
		this.enterMaterial = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Double material;
	/**
	 * @generated
 	 */
	public Double getMaterial(){
		return material; 
	}

	/**
	 * @generated
	 */	
	public void setMaterial(Double newVal) {
		this.material = newVal;
	}
 	
	
 	@Basic
	private Double minimum;
	/**
	 * @generated
 	 */
	public Double getMinimum(){
		return minimum; 
	}

	/**
	 * @generated
	 */	
	public void setMinimum(Double newVal) {
		this.minimum = newVal;
	}
 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Location location;
	/**
	 * @generated
 	 */
	public Location getLocation(){
		return location; 
	}

	/**
	 * @generated
	 */	
	public void setLocation(Location newVal) {
		this.location = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
 	@Basic
	private Boolean excludeFromProductionList;
	/**
	 * @generated
 	 */
	public Boolean getExcludeFromProductionList(){
		return excludeFromProductionList; 
	}

	/**
	 * @generated
	 */	
	public void setExcludeFromProductionList(Boolean newVal) {
		this.excludeFromProductionList = newVal;
	}
 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
		if (NODISCOUNT.equals(propertyName)) return getNoDiscount();
		if (NOMATERIALQUANTITY.equals(propertyName)) return getNoMaterialQuantity();
		if (NOOVERRIDES.equals(propertyName)) return getNoOverrides();
		if (ADJUSTSETS.equals(propertyName)) return getAdjustSets();
		if (ENTERRATE.equals(propertyName)) return getEnterRate();
		if (ENTERMATERIAL.equals(propertyName)) return getEnterMaterial();
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
		if (EXCLUDEFROMPRODUCTIONLIST.equals(propertyName)) return getExcludeFromProductionList();
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
		if (LABEL.equals(propertyName)) return getLabel();
		if (BINDERYCHARGE.equals(propertyName)) return getBinderyCharge();
		if (NAME.equals(propertyName)) return getName();
		if (PARENT.equals(propertyName)) return getParent();
		if (USEAREA.equals(propertyName)) return getUseArea();
		if (USESETUP.equals(propertyName)) return getUseSetup();
		if (CHARGECOST.equals(propertyName)) return getChargeCost();
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
		if (NODISCOUNT.equals(propertyName)) setNoDiscount((Boolean)newValue); else
		if (NOMATERIALQUANTITY.equals(propertyName)) setNoMaterialQuantity((Boolean)newValue); else
		if (NOOVERRIDES.equals(propertyName)) setNoOverrides((Boolean)newValue); else
		if (ADJUSTSETS.equals(propertyName)) setAdjustSets((Boolean)newValue); else
		if (ENTERRATE.equals(propertyName)) setEnterRate((Boolean)newValue); else
		if (ENTERMATERIAL.equals(propertyName)) setEnterMaterial((Boolean)newValue); else
		if (USEMATERIAL.equals(propertyName)) setUseMaterial((Boolean)newValue); else
		if (USERATE.equals(propertyName)) setUseRate((Boolean)newValue); else
		if (USERATESETS.equals(propertyName)) setUseRateSets((Boolean)newValue); else
		if (USEMERCHANDISESETS.equals(propertyName)) setUseMerchandiseSets((Boolean)newValue); else
		if (USEMINIMUMCHARGE.equals(propertyName)) setUseMinimumCharge((Boolean)newValue); else
		if (USECOLORS.equals(propertyName)) setUseColors((Boolean)newValue); else
		if (USEORIGINALS.equals(propertyName)) setUseOriginals((Boolean)newValue); else
		if (RATESETCOUNT.equals(propertyName)) setRateSetCount((Double)newValue); else
		if (MATERIALSETCOUNT.equals(propertyName)) setMaterialSetCount((Double)newValue); else
		if (RATE.equals(propertyName)) setRate((Double)newValue); else
		if (MATERIAL.equals(propertyName)) setMaterial((Double)newValue); else
		if (MINIMUM.equals(propertyName)) setMinimum((Double)newValue); else
		if (MARKUP.equals(propertyName)) setMarkup((Double)newValue); else
		if (PRICELIST.equals(propertyName)) setPriceList((PriceList)newValue); else
		if (WASTECHART.equals(propertyName)) setWasteChart((WasteChart)newValue); else
		if (FIXEDWASTE.equals(propertyName)) setFixedWaste((Long)newValue); else
		if (WASTEPERCENTAGE.equals(propertyName)) setWastePercentage((Double)newValue); else
		if (BASELINEARNUMBER.equals(propertyName)) setBaseLinearNumber((Long)newValue); else
		if (LOCATION.equals(propertyName)) setLocation((Location)newValue); else
		if (COSTCENTER.equals(propertyName)) setCostCenter((CostCenter)newValue); else
		if (SUBSTRATE.equals(propertyName)) setSubstrate((Substrate)newValue); else
		if (MINIMUMTIME.equals(propertyName)) setMinimumTime((Long)newValue); else
		if (SIZEX.equals(propertyName)) setSizeX((Double)newValue); else
		if (SIZEY.equals(propertyName)) setSizeY((Double)newValue); else
		if (PLATETHICKNESS.equals(propertyName)) setPlateThickness((Double)newValue); else
		if (FOLDTEMPLATE.equals(propertyName)) setFoldTemplate((FoldTemplate)newValue); else
		if (EXCLUDEFROMPRODUCTIONLIST.equals(propertyName)) setExcludeFromProductionList((Boolean)newValue); else
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
		if (LABEL.equals(propertyName)) setLabel((String)newValue); else
		if (BINDERYCHARGE.equals(propertyName)) setBinderyCharge((Boolean)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (PARENT.equals(propertyName)) setParent((ChargeCategory)newValue); else
		if (USEAREA.equals(propertyName)) setUseArea((Boolean)newValue); else
		if (USESETUP.equals(propertyName)) setUseSetup((Boolean)newValue); else
		if (CHARGECOST.equals(propertyName)) setChargeCost((ChargeCost)newValue); else
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
		if (NODISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NOMATERIALQUANTITY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NOOVERRIDES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ADJUSTSETS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ENTERRATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ENTERMATERIAL.equals(propertyName)) 
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
			return new Class<?>[] {Double.class};		
		if (MATERIAL.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (MINIMUM.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
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
			return new Class<?>[] {Location.class};		
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
		if (EXCLUDEFROMPRODUCTIONLIST.equals(propertyName)) 
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
		if (NODISCOUNT.equals(propertyName)) return ChargeDefinition.class;
		if (NOMATERIALQUANTITY.equals(propertyName)) return ChargeDefinition.class;
		if (NOOVERRIDES.equals(propertyName)) return ChargeDefinition.class;
		if (ADJUSTSETS.equals(propertyName)) return ChargeDefinition.class;
		if (ENTERRATE.equals(propertyName)) return ChargeDefinition.class;
		if (ENTERMATERIAL.equals(propertyName)) return ChargeDefinition.class;
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
		if (EXCLUDEFROMPRODUCTIONLIST.equals(propertyName)) return ChargeDefinition.class;
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
		if (HIDDEN.equals(propertyName)) return ChargeDefinition.class;
		if (DELETEDPRESET.equals(propertyName)) return ChargeDefinition.class;
		if (IGNORECUTS.equals(propertyName)) return ChargeDefinition.class;
		if (USESIGNATURES.equals(propertyName)) return ChargeDefinition.class;
		if (STOCKCHARGE.equals(propertyName)) return ChargeDefinition.class;
		if (OVERRIDENUMBEROFCUTS.equals(propertyName)) return ChargeDefinition.class;
		if (SHOWNOTES.equals(propertyName)) return ChargeDefinition.class;
		if (FINISHED.equals(propertyName)) return ChargeDefinition.class;
		if (BROKERED.equals(propertyName)) return ChargeDefinition.class;
		if (TAXABLE.equals(propertyName)) return ChargeDefinition.class;
		if (DISPLAYQTY.equals(propertyName)) return ChargeDefinition.class;
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
		if (IGNOREPRICEADJUSTMENT.equals(propertyName)) return ChargeDefinition.class;
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
		if (! SmartEquals(getNoDiscount(), objT.getNoDiscount()))
			return false;
		if (! SmartEquals(getNoMaterialQuantity(), objT.getNoMaterialQuantity()))
			return false;
		if (! SmartEquals(getNoOverrides(), objT.getNoOverrides()))
			return false;
		if (! SmartEquals(getAdjustSets(), objT.getAdjustSets()))
			return false;
		if (! SmartEquals(getEnterRate(), objT.getEnterRate()))
			return false;
		if (! SmartEquals(getEnterMaterial(), objT.getEnterMaterial()))
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
		if (! SmartEquals(getExcludeFromProductionList(), objT.getExcludeFromProductionList()))
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
		return true;
	}			
}