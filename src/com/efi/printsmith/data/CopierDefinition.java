package com.efi.printsmith.data;

import java.util.Date;

import com.efi.printsmith.data.*;
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
	@NamedQuery(name = "CopierDefinition.findall", query = "from CopierDefinition"),
	@NamedQuery(name = "CopierDefinition.byId", query = "select a from CopierDefinition a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.data.CopierDefinition")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "copierdefinition")
public class CopierDefinition extends ModelBase {
	/**
	 * @generated
	 */
	public static final String COPYDEFID = "CopyDefID";
	/**
	 * @generated
	 */
	public static final String COPYDEFNAME = "CopyDefName";
	/**
	 * @generated
	 */
	public static final String MACHINENAME = "MachineName";
	/**
	 * @generated
	 */
	public static final String OUTPUTDESCRIP = "OutputDescrip";
	/**
	 * @generated
	 */
	public static final String PRODUCTIONLOCATION = "ProductionLocation";
	/**
	 * @generated
	 */
	public static final String COSTCENTER = "CostCenter";
	/**
	 * @generated
	 */
	public static final String OEMDEVICEID = "OEMDeviceID";
	/**
	 * @generated
	 */
	public static final String COSTINGCOPY = "CostingCopy";
	/**
	 * @generated
	 */
	public static final String BLACKWHITE = "Blackwhite";
	/**
	 * @generated
	 */
	public static final String COLOR = "Color";
	/**
	 * @generated
	 */
	public static final String INTEGRATEDDEVICE = "IntegratedDevice";
	/**
	 * @generated
	 */
	public static final String MAXSIZE = "MaxSize";
	/**
	 * @generated
	 */
	public static final String MINSIZE = "MinSize";
	/**
	 * @generated
	 */
	public static final String MONTHLYLABOR = "MonthlyLabor";
	/**
	 * @generated
	 */
	public static final String CLICKCOST = "ClickCost";
	/**
	 * @generated
	 */
	public static final String LABORCOPY = "LaborCopy";
	/**
	 * @generated
	 */
	public static final String LARGEFORMAT = "LargeFormat";
	/**
	 * @generated
	 */
	public static final String MAXWIDTH = "MaxWidth";
	/**
	 * @generated
	 */
	public static final String MINWIDTH = "MinWidth";
	/**
	 * @generated
	 */
	public static final String DAYSOPEN = "DaysOpen";
	/**
	 * @generated
	 */
	public static final String MONTHLYPAYMENT = "MonthlyPayment";
	/**
	 * @generated
	 */
	public static final String PERCENTUSAGE = "PercentUsage";
	/**
	 * @generated
	 */
	public static final String HOURCOSTRATE = "HourCostRate";
	/**
	 * @generated
	 */
	public static final String TONERCOPY = "TonerCopy";
	/**
	 * @generated
	 */
	public static final String DEVELOPERCOPY = "DeveloperCopy";
	/**
	 * @generated
	 */
	public static final String COPYMARKUP = "CopyMarkup";
	/**
	 * @generated
	 */
	public static final String HOURSOPEN = "HoursOpen";
	/**
	 * @generated
	 */
	public static final String MONTHLYMAINTENANCE = "MonthlyMaintenance";
	/**
	 * @generated
	 */
	public static final String MACHINECOSTPERCOPY = "MachineCostPerCopy";
	/**
	 * @generated
	 */
	public static final String METHOD = "Method";
	/**
	 * @generated
	 */
	public static final String SALESCAT = "SalesCat";
	/**
	 * @generated
	 */
	public static final String COPYID = "CopyID";
	/**
	 * @generated
	 */
	public static final String MONTHLYBURDENRATE = "MonthlyBurdenRate";
	/**
	 * @generated
	 */
	public static final String COPYMINUTES = "CopyMinutes";

	/**
	 * @generated
	 */
	public CopierDefinition() {
	}

 	
	
	private Long copyDefID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="copydefid", nullable=true, unique=false)
	public Long getCopyDefID(){
		return copyDefID; 
	}

	/**
	 * @generated
	 */	
	public Long setCopyDefID(Long newVal) {
		return this.copyDefID = newVal;
	}
 	
	
	private String copyDefName;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="copydefname", nullable=true, unique=false)
	public String getCopyDefName(){
		return copyDefName; 
	}

	/**
	 * @generated
	 */	
	public String setCopyDefName(String newVal) {
		return this.copyDefName = newVal;
	}
 	
	
	private String machineName;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="machinename", nullable=true, unique=false)
	public String getMachineName(){
		return machineName; 
	}

	/**
	 * @generated
	 */	
	public String setMachineName(String newVal) {
		return this.machineName = newVal;
	}
 	
	
	private String outputDescrip;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="outputdescrip", nullable=true, unique=false)
	public String getOutputDescrip(){
		return outputDescrip; 
	}

	/**
	 * @generated
	 */	
	public String setOutputDescrip(String newVal) {
		return this.outputDescrip = newVal;
	}
 	
	
	private String productionLocation;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="productionlocation", nullable=true, unique=false)
	public String getProductionLocation(){
		return productionLocation; 
	}

	/**
	 * @generated
	 */	
	public String setProductionLocation(String newVal) {
		return this.productionLocation = newVal;
	}
 	
	
	private String costCenter;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="costcenter", nullable=true, unique=false)
	public String getCostCenter(){
		return costCenter; 
	}

	/**
	 * @generated
	 */	
	public String setCostCenter(String newVal) {
		return this.costCenter = newVal;
	}
 	
	
	private String oEMDeviceID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="oemdeviceid", nullable=true, unique=false)
	public String getOEMDeviceID(){
		return oEMDeviceID; 
	}

	/**
	 * @generated
	 */	
	public String setOEMDeviceID(String newVal) {
		return this.oEMDeviceID = newVal;
	}
 	
	
	private Boolean costingCopy;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="costingcopy", nullable=true, unique=false)
	public Boolean getCostingCopy(){
		return costingCopy; 
	}

	/**
	 * @generated
	 */	
	public Boolean setCostingCopy(Boolean newVal) {
		return this.costingCopy = newVal;
	}
 	
	
	private Boolean blackwhite;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="blackwhite", nullable=true, unique=false)
	public Boolean getBlackwhite(){
		return blackwhite; 
	}

	/**
	 * @generated
	 */	
	public Boolean setBlackwhite(Boolean newVal) {
		return this.blackwhite = newVal;
	}
 	
	
	private Boolean color;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="color", nullable=true, unique=false)
	public Boolean getColor(){
		return color; 
	}

	/**
	 * @generated
	 */	
	public Boolean setColor(Boolean newVal) {
		return this.color = newVal;
	}
 	
	
	private Boolean integratedDevice;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="integrateddevice", nullable=true, unique=false)
	public Boolean getIntegratedDevice(){
		return integratedDevice; 
	}

	/**
	 * @generated
	 */	
	public Boolean setIntegratedDevice(Boolean newVal) {
		return this.integratedDevice = newVal;
	}
 	
	
	private String maxSize;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="maxsize", nullable=true, unique=false)
	public String getMaxSize(){
		return maxSize; 
	}

	/**
	 * @generated
	 */	
	public String setMaxSize(String newVal) {
		return this.maxSize = newVal;
	}
 	
	
	private String minSize;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minsize", nullable=true, unique=false)
	public String getMinSize(){
		return minSize; 
	}

	/**
	 * @generated
	 */	
	public String setMinSize(String newVal) {
		return this.minSize = newVal;
	}
 	
	
	private Double monthlyLabor;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="monthlylabor", nullable=true, unique=false)
	public Double getMonthlyLabor(){
		return monthlyLabor; 
	}

	/**
	 * @generated
	 */	
	public Double setMonthlyLabor(Double newVal) {
		return this.monthlyLabor = newVal;
	}
 	
	
	private Double clickCost;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="clickcost", nullable=true, unique=false)
	public Double getClickCost(){
		return clickCost; 
	}

	/**
	 * @generated
	 */	
	public Double setClickCost(Double newVal) {
		return this.clickCost = newVal;
	}
 	
	
	private Double laborCopy;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="laborcopy", nullable=true, unique=false)
	public Double getLaborCopy(){
		return laborCopy; 
	}

	/**
	 * @generated
	 */	
	public Double setLaborCopy(Double newVal) {
		return this.laborCopy = newVal;
	}
 	
	
	private Boolean largeFormat;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="largeformat", nullable=true, unique=false)
	public Boolean getLargeFormat(){
		return largeFormat; 
	}

	/**
	 * @generated
	 */	
	public Boolean setLargeFormat(Boolean newVal) {
		return this.largeFormat = newVal;
	}
 	
	
	private String maxWidth;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="maxwidth", nullable=true, unique=false)
	public String getMaxWidth(){
		return maxWidth; 
	}

	/**
	 * @generated
	 */	
	public String setMaxWidth(String newVal) {
		return this.maxWidth = newVal;
	}
 	
	
	private String minWidth;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minwidth", nullable=true, unique=false)
	public String getMinWidth(){
		return minWidth; 
	}

	/**
	 * @generated
	 */	
	public String setMinWidth(String newVal) {
		return this.minWidth = newVal;
	}
 	
	
	private Integer daysOpen;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="daysopen", nullable=true, unique=false)
	public Integer getDaysOpen(){
		return daysOpen; 
	}

	/**
	 * @generated
	 */	
	public Integer setDaysOpen(Integer newVal) {
		return this.daysOpen = newVal;
	}
 	
	
	private Double monthlyPayment;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="monthlypayment", nullable=true, unique=false)
	public Double getMonthlyPayment(){
		return monthlyPayment; 
	}

	/**
	 * @generated
	 */	
	public Double setMonthlyPayment(Double newVal) {
		return this.monthlyPayment = newVal;
	}
 	
	
	private String percentUsage;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="percentusage", nullable=true, unique=false)
	public String getPercentUsage(){
		return percentUsage; 
	}

	/**
	 * @generated
	 */	
	public String setPercentUsage(String newVal) {
		return this.percentUsage = newVal;
	}
 	
	
	private Integer hourCostRate;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="hourcostrate", nullable=true, unique=false)
	public Integer getHourCostRate(){
		return hourCostRate; 
	}

	/**
	 * @generated
	 */	
	public Integer setHourCostRate(Integer newVal) {
		return this.hourCostRate = newVal;
	}
 	
	
	private Integer tonerCopy;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="tonercopy", nullable=true, unique=false)
	public Integer getTonerCopy(){
		return tonerCopy; 
	}

	/**
	 * @generated
	 */	
	public Integer setTonerCopy(Integer newVal) {
		return this.tonerCopy = newVal;
	}
 	
	
	private Integer developerCopy;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="developercopy", nullable=true, unique=false)
	public Integer getDeveloperCopy(){
		return developerCopy; 
	}

	/**
	 * @generated
	 */	
	public Integer setDeveloperCopy(Integer newVal) {
		return this.developerCopy = newVal;
	}
 	
	
	private Integer copyMarkup;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="copymarkup", nullable=true, unique=false)
	public Integer getCopyMarkup(){
		return copyMarkup; 
	}

	/**
	 * @generated
	 */	
	public Integer setCopyMarkup(Integer newVal) {
		return this.copyMarkup = newVal;
	}
 	
	
	private Integer hoursOpen;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="hoursopen", nullable=true, unique=false)
	public Integer getHoursOpen(){
		return hoursOpen; 
	}

	/**
	 * @generated
	 */	
	public Integer setHoursOpen(Integer newVal) {
		return this.hoursOpen = newVal;
	}
 	
	
	private Integer monthlyMaintenance;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="monthlymaintenance", nullable=true, unique=false)
	public Integer getMonthlyMaintenance(){
		return monthlyMaintenance; 
	}

	/**
	 * @generated
	 */	
	public Integer setMonthlyMaintenance(Integer newVal) {
		return this.monthlyMaintenance = newVal;
	}
 	
	
	private Integer machineCostPerCopy;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="machinecostpercopy", nullable=true, unique=false)
	public Integer getMachineCostPerCopy(){
		return machineCostPerCopy; 
	}

	/**
	 * @generated
	 */	
	public Integer setMachineCostPerCopy(Integer newVal) {
		return this.machineCostPerCopy = newVal;
	}
 	
	
	private String method;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="method", nullable=true, unique=false)
	public String getMethod(){
		return method; 
	}

	/**
	 * @generated
	 */	
	public String setMethod(String newVal) {
		return this.method = newVal;
	}
 	
	
	private String salesCat;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="salescat", nullable=true, unique=false)
	public String getSalesCat(){
		return salesCat; 
	}

	/**
	 * @generated
	 */	
	public String setSalesCat(String newVal) {
		return this.salesCat = newVal;
	}
 	
	
	private Integer copyID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="copyid", nullable=true, unique=false)
	public Integer getCopyID(){
		return copyID; 
	}

	/**
	 * @generated
	 */	
	public Integer setCopyID(Integer newVal) {
		return this.copyID = newVal;
	}
 	
	
	private Integer monthlyBurdenRate;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="monthlyburdenrate", nullable=true, unique=false)
	public Integer getMonthlyBurdenRate(){
		return monthlyBurdenRate; 
	}

	/**
	 * @generated
	 */	
	public Integer setMonthlyBurdenRate(Integer newVal) {
		return this.monthlyBurdenRate = newVal;
	}
 	
	
	private Integer copyMinutes;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="copyminutes", nullable=true, unique=false)
	public Integer getCopyMinutes(){
		return copyMinutes; 
	}

	/**
	 * @generated
	 */	
	public Integer setCopyMinutes(Integer newVal) {
		return this.copyMinutes = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (COPYDEFID.equals(propertyName)) return getCopyDefID();
		if (COPYDEFNAME.equals(propertyName)) return getCopyDefName();
		if (MACHINENAME.equals(propertyName)) return getMachineName();
		if (OUTPUTDESCRIP.equals(propertyName)) return getOutputDescrip();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (COSTCENTER.equals(propertyName)) return getCostCenter();
		if (OEMDEVICEID.equals(propertyName)) return getOEMDeviceID();
		if (COSTINGCOPY.equals(propertyName)) return getCostingCopy();
		if (BLACKWHITE.equals(propertyName)) return getBlackwhite();
		if (COLOR.equals(propertyName)) return getColor();
		if (INTEGRATEDDEVICE.equals(propertyName)) return getIntegratedDevice();
		if (MAXSIZE.equals(propertyName)) return getMaxSize();
		if (MINSIZE.equals(propertyName)) return getMinSize();
		if (MONTHLYLABOR.equals(propertyName)) return getMonthlyLabor();
		if (CLICKCOST.equals(propertyName)) return getClickCost();
		if (LABORCOPY.equals(propertyName)) return getLaborCopy();
		if (LARGEFORMAT.equals(propertyName)) return getLargeFormat();
		if (MAXWIDTH.equals(propertyName)) return getMaxWidth();
		if (MINWIDTH.equals(propertyName)) return getMinWidth();
		if (DAYSOPEN.equals(propertyName)) return getDaysOpen();
		if (MONTHLYPAYMENT.equals(propertyName)) return getMonthlyPayment();
		if (PERCENTUSAGE.equals(propertyName)) return getPercentUsage();
		if (HOURCOSTRATE.equals(propertyName)) return getHourCostRate();
		if (TONERCOPY.equals(propertyName)) return getTonerCopy();
		if (DEVELOPERCOPY.equals(propertyName)) return getDeveloperCopy();
		if (COPYMARKUP.equals(propertyName)) return getCopyMarkup();
		if (HOURSOPEN.equals(propertyName)) return getHoursOpen();
		if (MONTHLYMAINTENANCE.equals(propertyName)) return getMonthlyMaintenance();
		if (MACHINECOSTPERCOPY.equals(propertyName)) return getMachineCostPerCopy();
		if (METHOD.equals(propertyName)) return getMethod();
		if (SALESCAT.equals(propertyName)) return getSalesCat();
		if (COPYID.equals(propertyName)) return getCopyID();
		if (MONTHLYBURDENRATE.equals(propertyName)) return getMonthlyBurdenRate();
		if (COPYMINUTES.equals(propertyName)) return getCopyMinutes();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (COPYDEFID.equals(propertyName)) setCopyDefID((Long)newValue); else
		if (COPYDEFNAME.equals(propertyName)) setCopyDefName((String)newValue); else
		if (MACHINENAME.equals(propertyName)) setMachineName((String)newValue); else
		if (OUTPUTDESCRIP.equals(propertyName)) setOutputDescrip((String)newValue); else
		if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((String)newValue); else
		if (COSTCENTER.equals(propertyName)) setCostCenter((String)newValue); else
		if (OEMDEVICEID.equals(propertyName)) setOEMDeviceID((String)newValue); else
		if (COSTINGCOPY.equals(propertyName)) setCostingCopy((Boolean)newValue); else
		if (BLACKWHITE.equals(propertyName)) setBlackwhite((Boolean)newValue); else
		if (COLOR.equals(propertyName)) setColor((Boolean)newValue); else
		if (INTEGRATEDDEVICE.equals(propertyName)) setIntegratedDevice((Boolean)newValue); else
		if (MAXSIZE.equals(propertyName)) setMaxSize((String)newValue); else
		if (MINSIZE.equals(propertyName)) setMinSize((String)newValue); else
		if (MONTHLYLABOR.equals(propertyName)) setMonthlyLabor((Double)newValue); else
		if (CLICKCOST.equals(propertyName)) setClickCost((Double)newValue); else
		if (LABORCOPY.equals(propertyName)) setLaborCopy((Double)newValue); else
		if (LARGEFORMAT.equals(propertyName)) setLargeFormat((Boolean)newValue); else
		if (MAXWIDTH.equals(propertyName)) setMaxWidth((String)newValue); else
		if (MINWIDTH.equals(propertyName)) setMinWidth((String)newValue); else
		if (DAYSOPEN.equals(propertyName)) setDaysOpen((Integer)newValue); else
		if (MONTHLYPAYMENT.equals(propertyName)) setMonthlyPayment((Double)newValue); else
		if (PERCENTUSAGE.equals(propertyName)) setPercentUsage((String)newValue); else
		if (HOURCOSTRATE.equals(propertyName)) setHourCostRate((Integer)newValue); else
		if (TONERCOPY.equals(propertyName)) setTonerCopy((Integer)newValue); else
		if (DEVELOPERCOPY.equals(propertyName)) setDeveloperCopy((Integer)newValue); else
		if (COPYMARKUP.equals(propertyName)) setCopyMarkup((Integer)newValue); else
		if (HOURSOPEN.equals(propertyName)) setHoursOpen((Integer)newValue); else
		if (MONTHLYMAINTENANCE.equals(propertyName)) setMonthlyMaintenance((Integer)newValue); else
		if (MACHINECOSTPERCOPY.equals(propertyName)) setMachineCostPerCopy((Integer)newValue); else
		if (METHOD.equals(propertyName)) setMethod((String)newValue); else
		if (SALESCAT.equals(propertyName)) setSalesCat((String)newValue); else
		if (COPYID.equals(propertyName)) setCopyID((Integer)newValue); else
		if (MONTHLYBURDENRATE.equals(propertyName)) setMonthlyBurdenRate((Integer)newValue); else
		if (COPYMINUTES.equals(propertyName)) setCopyMinutes((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (COPYDEFID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COPYDEFNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MACHINENAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (OUTPUTDESCRIP.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PRODUCTIONLOCATION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COSTCENTER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (OEMDEVICEID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COSTINGCOPY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (BLACKWHITE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (COLOR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTEGRATEDDEVICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MAXSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MONTHLYLABOR.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (CLICKCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORCOPY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LARGEFORMAT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MAXWIDTH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINWIDTH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DAYSOPEN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MONTHLYPAYMENT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PERCENTUSAGE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (HOURCOSTRATE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (TONERCOPY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DEVELOPERCOPY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COPYMARKUP.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (HOURSOPEN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MONTHLYMAINTENANCE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MACHINECOSTPERCOPY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (METHOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESCAT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COPYID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MONTHLYBURDENRATE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COPYMINUTES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (COPYDEFID.equals(propertyName)) return CopierDefinition.class;
		if (COPYDEFNAME.equals(propertyName)) return CopierDefinition.class;
		if (MACHINENAME.equals(propertyName)) return CopierDefinition.class;
		if (OUTPUTDESCRIP.equals(propertyName)) return CopierDefinition.class;
		if (PRODUCTIONLOCATION.equals(propertyName)) return CopierDefinition.class;
		if (COSTCENTER.equals(propertyName)) return CopierDefinition.class;
		if (OEMDEVICEID.equals(propertyName)) return CopierDefinition.class;
		if (COSTINGCOPY.equals(propertyName)) return CopierDefinition.class;
		if (BLACKWHITE.equals(propertyName)) return CopierDefinition.class;
		if (COLOR.equals(propertyName)) return CopierDefinition.class;
		if (INTEGRATEDDEVICE.equals(propertyName)) return CopierDefinition.class;
		if (MAXSIZE.equals(propertyName)) return CopierDefinition.class;
		if (MINSIZE.equals(propertyName)) return CopierDefinition.class;
		if (MONTHLYLABOR.equals(propertyName)) return CopierDefinition.class;
		if (CLICKCOST.equals(propertyName)) return CopierDefinition.class;
		if (LABORCOPY.equals(propertyName)) return CopierDefinition.class;
		if (LARGEFORMAT.equals(propertyName)) return CopierDefinition.class;
		if (MAXWIDTH.equals(propertyName)) return CopierDefinition.class;
		if (MINWIDTH.equals(propertyName)) return CopierDefinition.class;
		if (DAYSOPEN.equals(propertyName)) return CopierDefinition.class;
		if (MONTHLYPAYMENT.equals(propertyName)) return CopierDefinition.class;
		if (PERCENTUSAGE.equals(propertyName)) return CopierDefinition.class;
		if (HOURCOSTRATE.equals(propertyName)) return CopierDefinition.class;
		if (TONERCOPY.equals(propertyName)) return CopierDefinition.class;
		if (DEVELOPERCOPY.equals(propertyName)) return CopierDefinition.class;
		if (COPYMARKUP.equals(propertyName)) return CopierDefinition.class;
		if (HOURSOPEN.equals(propertyName)) return CopierDefinition.class;
		if (MONTHLYMAINTENANCE.equals(propertyName)) return CopierDefinition.class;
		if (MACHINECOSTPERCOPY.equals(propertyName)) return CopierDefinition.class;
		if (METHOD.equals(propertyName)) return CopierDefinition.class;
		if (SALESCAT.equals(propertyName)) return CopierDefinition.class;
		if (COPYID.equals(propertyName)) return CopierDefinition.class;
		if (MONTHLYBURDENRATE.equals(propertyName)) return CopierDefinition.class;
		if (COPYMINUTES.equals(propertyName)) return CopierDefinition.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		CopierDefinition objT = (CopierDefinition)obj;
		if (! SmartEquals(getCopyDefID(), objT.getCopyDefID()))
			return false;
		if (! SmartEquals(getCopyDefName(), objT.getCopyDefName()))
			return false;
		if (! SmartEquals(getMachineName(), objT.getMachineName()))
			return false;
		if (! SmartEquals(getOutputDescrip(), objT.getOutputDescrip()))
			return false;
		if (! SmartEquals(getProductionLocation(), objT.getProductionLocation()))
			return false;
		if (! SmartEquals(getCostCenter(), objT.getCostCenter()))
			return false;
		if (! SmartEquals(getOEMDeviceID(), objT.getOEMDeviceID()))
			return false;
		if (! SmartEquals(getCostingCopy(), objT.getCostingCopy()))
			return false;
		if (! SmartEquals(getBlackwhite(), objT.getBlackwhite()))
			return false;
		if (! SmartEquals(getColor(), objT.getColor()))
			return false;
		if (! SmartEquals(getIntegratedDevice(), objT.getIntegratedDevice()))
			return false;
		if (! SmartEquals(getMaxSize(), objT.getMaxSize()))
			return false;
		if (! SmartEquals(getMinSize(), objT.getMinSize()))
			return false;
		if (! SmartEquals(getMonthlyLabor(), objT.getMonthlyLabor()))
			return false;
		if (! SmartEquals(getClickCost(), objT.getClickCost()))
			return false;
		if (! SmartEquals(getLaborCopy(), objT.getLaborCopy()))
			return false;
		if (! SmartEquals(getLargeFormat(), objT.getLargeFormat()))
			return false;
		if (! SmartEquals(getMaxWidth(), objT.getMaxWidth()))
			return false;
		if (! SmartEquals(getMinWidth(), objT.getMinWidth()))
			return false;
		if (! SmartEquals(getDaysOpen(), objT.getDaysOpen()))
			return false;
		if (! SmartEquals(getMonthlyPayment(), objT.getMonthlyPayment()))
			return false;
		if (! SmartEquals(getPercentUsage(), objT.getPercentUsage()))
			return false;
		if (! SmartEquals(getHourCostRate(), objT.getHourCostRate()))
			return false;
		if (! SmartEquals(getTonerCopy(), objT.getTonerCopy()))
			return false;
		if (! SmartEquals(getDeveloperCopy(), objT.getDeveloperCopy()))
			return false;
		if (! SmartEquals(getCopyMarkup(), objT.getCopyMarkup()))
			return false;
		if (! SmartEquals(getHoursOpen(), objT.getHoursOpen()))
			return false;
		if (! SmartEquals(getMonthlyMaintenance(), objT.getMonthlyMaintenance()))
			return false;
		if (! SmartEquals(getMachineCostPerCopy(), objT.getMachineCostPerCopy()))
			return false;
		if (! SmartEquals(getMethod(), objT.getMethod()))
			return false;
		if (! SmartEquals(getSalesCat(), objT.getSalesCat()))
			return false;
		if (! SmartEquals(getCopyID(), objT.getCopyID()))
			return false;
		if (! SmartEquals(getMonthlyBurdenRate(), objT.getMonthlyBurdenRate()))
			return false;
		if (! SmartEquals(getCopyMinutes(), objT.getCopyMinutes()))
			return false;
		return true;
	}			
}