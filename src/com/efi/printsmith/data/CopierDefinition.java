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
	@NamedQuery(name = "CopierDefinition.findall", query = "from CopierDefinition"),
	@NamedQuery(name = "CopierDefinition.byId", query = "select a from CopierDefinition a where a.id= :id")
})


@Entity
@Table(name = "copierdefinition")
public class CopierDefinition extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
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
	public static final String OEMDEVICEID = "OemDeviceID";
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
	public static final String CHARGES = "Charges";
	/**
	 * @generated
	 */
	public static final String COPIERID = "CopierId";

	/**
	 * @generated
	 */
	public CopierDefinition() {
		this.created = new Date();
		this.modified = new Date();
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
 	
	
 	@Basic
	private String machineName;
	/**
	 * @generated
 	 */
	public String getMachineName(){
		return machineName; 
	}

	/**
	 * @generated
	 */	
	public void setMachineName(String newVal) {
		this.machineName = newVal;
	}
 	
	
 	@Basic
	private String outputDescrip;
	/**
	 * @generated
 	 */
	public String getOutputDescrip(){
		return outputDescrip; 
	}

	/**
	 * @generated
	 */	
	public void setOutputDescrip(String newVal) {
		this.outputDescrip = newVal;
	}
 	
	
 	@Basic
	private String productionLocation;
	/**
	 * @generated
 	 */
	public String getProductionLocation(){
		return productionLocation; 
	}

	/**
	 * @generated
	 */	
	public void setProductionLocation(String newVal) {
		this.productionLocation = newVal;
	}
 	
	
 	@Basic
	private String costCenter;
	/**
	 * @generated
 	 */
	public String getCostCenter(){
		return costCenter; 
	}

	/**
	 * @generated
	 */	
	public void setCostCenter(String newVal) {
		this.costCenter = newVal;
	}
 	
	
 	@Basic
	private String oemDeviceID;
	/**
	 * @generated
 	 */
	public String getOemDeviceID(){
		return oemDeviceID; 
	}

	/**
	 * @generated
	 */	
	public void setOemDeviceID(String newVal) {
		this.oemDeviceID = newVal;
	}
 	
	
 	@Basic
	private Boolean costingCopy;
	/**
	 * @generated
 	 */
	public Boolean getCostingCopy(){
		return costingCopy; 
	}

	/**
	 * @generated
	 */	
	public void setCostingCopy(Boolean newVal) {
		this.costingCopy = newVal;
	}
 	
	
 	@Basic
	private Boolean blackwhite;
	/**
	 * @generated
 	 */
	public Boolean getBlackwhite(){
		return blackwhite; 
	}

	/**
	 * @generated
	 */	
	public void setBlackwhite(Boolean newVal) {
		this.blackwhite = newVal;
	}
 	
	
 	@Basic
	private Boolean color;
	/**
	 * @generated
 	 */
	public Boolean getColor(){
		return color; 
	}

	/**
	 * @generated
	 */	
	public void setColor(Boolean newVal) {
		this.color = newVal;
	}
 	
	
 	@Basic
	private Boolean integratedDevice;
	/**
	 * @generated
 	 */
	public Boolean getIntegratedDevice(){
		return integratedDevice; 
	}

	/**
	 * @generated
	 */	
	public void setIntegratedDevice(Boolean newVal) {
		this.integratedDevice = newVal;
	}
 	
	
 	@Basic
	private String maxSize;
	/**
	 * @generated
 	 */
	public String getMaxSize(){
		return maxSize; 
	}

	/**
	 * @generated
	 */	
	public void setMaxSize(String newVal) {
		this.maxSize = newVal;
	}
 	
	
 	@Basic
	private String minSize;
	/**
	 * @generated
 	 */
	public String getMinSize(){
		return minSize; 
	}

	/**
	 * @generated
	 */	
	public void setMinSize(String newVal) {
		this.minSize = newVal;
	}
 	
	
 	@Basic
	private Double monthlyLabor;
	/**
	 * @generated
 	 */
	public Double getMonthlyLabor(){
		return monthlyLabor; 
	}

	/**
	 * @generated
	 */	
	public void setMonthlyLabor(Double newVal) {
		this.monthlyLabor = newVal;
	}
 	
	
 	@Basic
	private Double clickCost;
	/**
	 * @generated
 	 */
	public Double getClickCost(){
		return clickCost; 
	}

	/**
	 * @generated
	 */	
	public void setClickCost(Double newVal) {
		this.clickCost = newVal;
	}
 	
	
 	@Basic
	private Double laborCopy;
	/**
	 * @generated
 	 */
	public Double getLaborCopy(){
		return laborCopy; 
	}

	/**
	 * @generated
	 */	
	public void setLaborCopy(Double newVal) {
		this.laborCopy = newVal;
	}
 	
	
 	@Basic
	private Boolean largeFormat;
	/**
	 * @generated
 	 */
	public Boolean getLargeFormat(){
		return largeFormat; 
	}

	/**
	 * @generated
	 */	
	public void setLargeFormat(Boolean newVal) {
		this.largeFormat = newVal;
	}
 	
	
 	@Basic
	private String maxWidth;
	/**
	 * @generated
 	 */
	public String getMaxWidth(){
		return maxWidth; 
	}

	/**
	 * @generated
	 */	
	public void setMaxWidth(String newVal) {
		this.maxWidth = newVal;
	}
 	
	
 	@Basic
	private String minWidth;
	/**
	 * @generated
 	 */
	public String getMinWidth(){
		return minWidth; 
	}

	/**
	 * @generated
	 */	
	public void setMinWidth(String newVal) {
		this.minWidth = newVal;
	}
 	
	
 	@Basic
	private Integer daysOpen;
	/**
	 * @generated
 	 */
	public Integer getDaysOpen(){
		return daysOpen; 
	}

	/**
	 * @generated
	 */	
	public void setDaysOpen(Integer newVal) {
		this.daysOpen = newVal;
	}
 	
	
 	@Basic
	private Double monthlyPayment;
	/**
	 * @generated
 	 */
	public Double getMonthlyPayment(){
		return monthlyPayment; 
	}

	/**
	 * @generated
	 */	
	public void setMonthlyPayment(Double newVal) {
		this.monthlyPayment = newVal;
	}
 	
	
 	@Basic
	private String percentUsage;
	/**
	 * @generated
 	 */
	public String getPercentUsage(){
		return percentUsage; 
	}

	/**
	 * @generated
	 */	
	public void setPercentUsage(String newVal) {
		this.percentUsage = newVal;
	}
 	
	
 	@Basic
	private Integer hourCostRate;
	/**
	 * @generated
 	 */
	public Integer getHourCostRate(){
		return hourCostRate; 
	}

	/**
	 * @generated
	 */	
	public void setHourCostRate(Integer newVal) {
		this.hourCostRate = newVal;
	}
 	
	
 	@Basic
	private Integer tonerCopy;
	/**
	 * @generated
 	 */
	public Integer getTonerCopy(){
		return tonerCopy; 
	}

	/**
	 * @generated
	 */	
	public void setTonerCopy(Integer newVal) {
		this.tonerCopy = newVal;
	}
 	
	
 	@Basic
	private Integer developerCopy;
	/**
	 * @generated
 	 */
	public Integer getDeveloperCopy(){
		return developerCopy; 
	}

	/**
	 * @generated
	 */	
	public void setDeveloperCopy(Integer newVal) {
		this.developerCopy = newVal;
	}
 	
	
 	@Basic
	private Integer copyMarkup;
	/**
	 * @generated
 	 */
	public Integer getCopyMarkup(){
		return copyMarkup; 
	}

	/**
	 * @generated
	 */	
	public void setCopyMarkup(Integer newVal) {
		this.copyMarkup = newVal;
	}
 	
	
 	@Basic
	private Integer hoursOpen;
	/**
	 * @generated
 	 */
	public Integer getHoursOpen(){
		return hoursOpen; 
	}

	/**
	 * @generated
	 */	
	public void setHoursOpen(Integer newVal) {
		this.hoursOpen = newVal;
	}
 	
	
 	@Basic
	private Integer monthlyMaintenance;
	/**
	 * @generated
 	 */
	public Integer getMonthlyMaintenance(){
		return monthlyMaintenance; 
	}

	/**
	 * @generated
	 */	
	public void setMonthlyMaintenance(Integer newVal) {
		this.monthlyMaintenance = newVal;
	}
 	
	
 	@Basic
	private Integer machineCostPerCopy;
	/**
	 * @generated
 	 */
	public Integer getMachineCostPerCopy(){
		return machineCostPerCopy; 
	}

	/**
	 * @generated
	 */	
	public void setMachineCostPerCopy(Integer newVal) {
		this.machineCostPerCopy = newVal;
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
	private String salesCat;
	/**
	 * @generated
 	 */
	public String getSalesCat(){
		return salesCat; 
	}

	/**
	 * @generated
	 */	
	public void setSalesCat(String newVal) {
		this.salesCat = newVal;
	}
 	
	
 	@Basic
	private Integer copyID;
	/**
	 * @generated
 	 */
	public Integer getCopyID(){
		return copyID; 
	}

	/**
	 * @generated
	 */	
	public void setCopyID(Integer newVal) {
		this.copyID = newVal;
	}
 	
	
 	@Basic
	private Integer monthlyBurdenRate;
	/**
	 * @generated
 	 */
	public Integer getMonthlyBurdenRate(){
		return monthlyBurdenRate; 
	}

	/**
	 * @generated
	 */	
	public void setMonthlyBurdenRate(Integer newVal) {
		this.monthlyBurdenRate = newVal;
	}
 	
	
 	@Basic
	private Integer copyMinutes;
	/**
	 * @generated
 	 */
	public Integer getCopyMinutes(){
		return copyMinutes; 
	}

	/**
	 * @generated
	 */	
	public void setCopyMinutes(Integer newVal) {
		this.copyMinutes = newVal;
	}
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Charge> charges;
	/**
	 * @generated
 	 */
	public java.util.List<Charge> getCharges(){
		return charges; 
	}

	public void addCharges(Charge obj) {
		if (charges == null) {
			charges = new java.util.ArrayList<Charge>();
		}
		charges.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setCharges(java.util.List<Charge> newVal) {
		this.charges = newVal;
	}
 	
	
 	@Basic
	private String copierId;
	/**
	 * @generated
 	 */
	public String getCopierId(){
		return copierId; 
	}

	/**
	 * @generated
	 */	
	public void setCopierId(String newVal) {
		this.copierId = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (MACHINENAME.equals(propertyName)) return getMachineName();
		if (OUTPUTDESCRIP.equals(propertyName)) return getOutputDescrip();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (COSTCENTER.equals(propertyName)) return getCostCenter();
		if (OEMDEVICEID.equals(propertyName)) return getOemDeviceID();
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
		if (CHARGES.equals(propertyName)) return getCharges();
		if (COPIERID.equals(propertyName)) return getCopierId();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (MACHINENAME.equals(propertyName)) setMachineName((String)newValue); else
		if (OUTPUTDESCRIP.equals(propertyName)) setOutputDescrip((String)newValue); else
		if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((String)newValue); else
		if (COSTCENTER.equals(propertyName)) setCostCenter((String)newValue); else
		if (OEMDEVICEID.equals(propertyName)) setOemDeviceID((String)newValue); else
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
		if (CHARGES.equals(propertyName)) setCharges((java.util.List<Charge>)newValue); else
		if (COPIERID.equals(propertyName)) setCopierId((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) 
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
		if (CHARGES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Charge.class};		
		if (COPIERID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return CopierDefinition.class;
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
		if (CHARGES.equals(propertyName)) return CopierDefinition.class;
		if (COPIERID.equals(propertyName)) return CopierDefinition.class;
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
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getMachineName(), objT.getMachineName()))
			return false;
		if (! SmartEquals(getOutputDescrip(), objT.getOutputDescrip()))
			return false;
		if (! SmartEquals(getProductionLocation(), objT.getProductionLocation()))
			return false;
		if (! SmartEquals(getCostCenter(), objT.getCostCenter()))
			return false;
		if (! SmartEquals(getOemDeviceID(), objT.getOemDeviceID()))
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
		if (! SmartEquals(getCharges(), objT.getCharges()))
			return false;
		if (! SmartEquals(getCopierId(), objT.getCopierId()))
			return false;
		return true;
	}			
}