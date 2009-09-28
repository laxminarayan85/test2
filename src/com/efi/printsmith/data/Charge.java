package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
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
	@NamedQuery(name = "Charge.findall", query = "from Charge"),
	@NamedQuery(name = "Charge.byId", query = "select a from Charge a where a.id= :id")
})


@Entity
@Table(name = "charge")
public class Charge extends ModelBase {
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
	public static final String LABEL = "Label";

	/**
	 * @generated
	 */
	public Charge() {
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
	private Integer useRate;
	/**
	 * @generated
 	 */
	public Integer getUseRate(){
		return useRate; 
	}

	/**
	 * @generated
	 */	
	public void setUseRate(Integer newVal) {
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
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private PriceListElement priceList;
	/**
	 * @generated
 	 */
	public PriceListElement getPriceList(){
		return priceList; 
	}

	/**
	 * @generated
	 */	
	public void setPriceList(PriceListElement newVal) {
		this.priceList = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
	private Integer useMultiplyUpCount;
	/**
	 * @generated
 	 */
	public Integer getUseMultiplyUpCount(){
		return useMultiplyUpCount; 
	}

	/**
	 * @generated
	 */	
	public void setUseMultiplyUpCount(Integer newVal) {
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
	private Integer integratedCTP;
	/**
	 * @generated
 	 */
	public Integer getIntegratedCTP(){
		return integratedCTP; 
	}

	/**
	 * @generated
	 */	
	public void setIntegratedCTP(Integer newVal) {
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
		if (LABEL.equals(propertyName)) return getLabel();
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
		if (USERATE.equals(propertyName)) setUseRate((Integer)newValue); else
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
		if (PRICELIST.equals(propertyName)) setPriceList((PriceListElement)newValue); else
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
		if (USEMULTIPLYUPCOUNT.equals(propertyName)) setUseMultiplyUpCount((Integer)newValue); else
		if (ADJUSTUPS.equals(propertyName)) setAdjustUps((Boolean)newValue); else
		if (CUTSAREPREPRESS.equals(propertyName)) setCutsArePrePress((Boolean)newValue); else
		if (INTEGRATEDCTP.equals(propertyName)) setIntegratedCTP((Integer)newValue); else
		if (SKU.equals(propertyName)) setSku((String)newValue); else
		if (CATEGORY.equals(propertyName)) setCategory((String)newValue); else
		if (LABEL.equals(propertyName)) setLabel((String)newValue); else
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
			return new Class<?>[] {Integer.class};		
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
			return new Class<?>[] {PriceListElement.class};		
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
			return new Class<?>[] {Integer.class};		
		if (ADJUSTUPS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (CUTSAREPREPRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTEGRATEDCTP.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SKU.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CATEGORY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LABEL.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (METHOD.equals(propertyName)) return Charge.class;
		if (QUANTITYTYPE.equals(propertyName)) return Charge.class;
		if (MARKUPTYPE.equals(propertyName)) return Charge.class;
		if (JOBQTY.equals(propertyName)) return Charge.class;
		if (PRICEMETHOD.equals(propertyName)) return Charge.class;
		if (INKCOVERAGE.equals(propertyName)) return Charge.class;
		if (USESIDES.equals(propertyName)) return Charge.class;
		if (NODISCOUNT.equals(propertyName)) return Charge.class;
		if (NOMATERIALQUANTITY.equals(propertyName)) return Charge.class;
		if (NOOVERRIDES.equals(propertyName)) return Charge.class;
		if (ADJUSTSETS.equals(propertyName)) return Charge.class;
		if (ENTERRATE.equals(propertyName)) return Charge.class;
		if (ENTERMATERIAL.equals(propertyName)) return Charge.class;
		if (USEMATERIAL.equals(propertyName)) return Charge.class;
		if (USERATE.equals(propertyName)) return Charge.class;
		if (USERATESETS.equals(propertyName)) return Charge.class;
		if (USEMERCHANDISESETS.equals(propertyName)) return Charge.class;
		if (USEMINIMUMCHARGE.equals(propertyName)) return Charge.class;
		if (USECOLORS.equals(propertyName)) return Charge.class;
		if (USEORIGINALS.equals(propertyName)) return Charge.class;
		if (RATESETCOUNT.equals(propertyName)) return Charge.class;
		if (MATERIALSETCOUNT.equals(propertyName)) return Charge.class;
		if (RATE.equals(propertyName)) return Charge.class;
		if (MATERIAL.equals(propertyName)) return Charge.class;
		if (MINIMUM.equals(propertyName)) return Charge.class;
		if (MARKUP.equals(propertyName)) return Charge.class;
		if (PRICELIST.equals(propertyName)) return Charge.class;
		if (WASTECHART.equals(propertyName)) return Charge.class;
		if (FIXEDWASTE.equals(propertyName)) return Charge.class;
		if (WASTEPERCENTAGE.equals(propertyName)) return Charge.class;
		if (BASELINEARNUMBER.equals(propertyName)) return Charge.class;
		if (LOCATION.equals(propertyName)) return Charge.class;
		if (COSTCENTER.equals(propertyName)) return Charge.class;
		if (SUBSTRATE.equals(propertyName)) return Charge.class;
		if (MINIMUMTIME.equals(propertyName)) return Charge.class;
		if (SIZEX.equals(propertyName)) return Charge.class;
		if (SIZEY.equals(propertyName)) return Charge.class;
		if (PLATETHICKNESS.equals(propertyName)) return Charge.class;
		if (FOLDTEMPLATE.equals(propertyName)) return Charge.class;
		if (EXCLUDEFROMPRODUCTIONLIST.equals(propertyName)) return Charge.class;
		if (PREPRODUCTION.equals(propertyName)) return Charge.class;
		if (USEMINIMUMTIME.equals(propertyName)) return Charge.class;
		if (USEDIVIDEBYUPCOUNT.equals(propertyName)) return Charge.class;
		if (USEMULTIPLYUPCOUNT.equals(propertyName)) return Charge.class;
		if (ADJUSTUPS.equals(propertyName)) return Charge.class;
		if (CUTSAREPREPRESS.equals(propertyName)) return Charge.class;
		if (INTEGRATEDCTP.equals(propertyName)) return Charge.class;
		if (SKU.equals(propertyName)) return Charge.class;
		if (CATEGORY.equals(propertyName)) return Charge.class;
		if (LABEL.equals(propertyName)) return Charge.class;
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
		if (! SmartEquals(getLabel(), objT.getLabel()))
			return false;
		return true;
	}			
}