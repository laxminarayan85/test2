
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
	@NamedQuery(name = "CopierDefinition.findall", query = "from CopierDefinition"),
	@NamedQuery(name = "CopierDefinition.byId", query = "select a from CopierDefinition a where a.id= :id")
})



/**
 * @generated
 */	
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
	public static final String FLATERATE = "FlateRate";
	/**
	 * @generated
	 */
	public static final String COPYMARKUP2 = "CopyMarkup2";
	/**
	 * @generated
	 */
	public static final String FLATRATE = "FlatRate";
	/**
	 * @generated
	 */
	public static final String WASTECHART = "WasteChart";
	/**
	 * @generated
	 */
	public static final String STOCKPRICELIST = "StockPriceList";
	/**
	 * @generated
	 */
	public static final String COPIERPRICELIST = "CopierPriceList";
	/**
	 * @generated
	 */
	public static final String PRICETWOSIDE = "PriceTwoSide";
	/**
	 * @generated
	 */
	public static final String STOCKPRICEMETHOD = "StockPriceMethod";
	/**
	 * @generated
	 */
	public static final String SIDETWOFACTOR = "SideTwoFactor";
	/**
	 * @generated
	 */
	public static final String COPIERMATRIX = "CopierMatrix";
	/**
	 * @generated
	 */
	public static final String USECOPIERSTOCKMARKUP = "UseCopierStockMarkup";
	/**
	 * @generated
	 */
	public static final String MATRIXISCOPYCOST = "MatrixIsCopyCost";
	/**
	 * @generated
	 */
	public static final String MATRIXISDISCOUNTTABLE = "MatrixIsDiscountTable";
	/**
	 * @generated
	 */
	public static final String MATRIXISSTEPTABLE = "MatrixIsStepTable";
	/**
	 * @generated
	 */
	public static final String SQUAREAREAFROMRUNSIZE = "SquareAreaFromRunSize";
	/**
	 * @generated
	 */
	public static final String SQUAREAREAFROMFINISH = "SquareAreaFromFinish";
	/**
	 * @generated
	 */
	public static final String INTERPOLATEMATRIX = "InterpolateMatrix";
	/**
	 * @generated
	 */
	public static final String STOCKMARKUP = "StockMarkup";

	/**
	 * @generated
	 */
	public CopierDefinition() {
		this.created = new Date();
		this.modified = new Date();
	}

	public CopierDefinition(long id, String Name) {
		this.id = id;
		this.name = Name;
	}
	
	public CopierDefinition(long id, String name, String oemID, String machineName) {
		this.id = id;
		this.name =name;
		this.oemDeviceID= oemID;
		this.machineName = machineName;
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double percentUsage;
	
	/**
	 * @generated
 	 */
	public Double getPercentUsage(){
		return percentUsage; 
	}

	
	/**
	 * @generated
	 */	
	public void setPercentUsage(Double newVal) {
		this.percentUsage = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double hourCostRate;
	
	/**
	 * @generated
 	 */
	public Double getHourCostRate(){
		return hourCostRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setHourCostRate(Double newVal) {
		this.hourCostRate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double tonerCopy;
	
	/**
	 * @generated
 	 */
	public Double getTonerCopy(){
		return tonerCopy; 
	}

	
	/**
	 * @generated
	 */	
	public void setTonerCopy(Double newVal) {
		this.tonerCopy = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double developerCopy;
	
	/**
	 * @generated
 	 */
	public Double getDeveloperCopy(){
		return developerCopy; 
	}

	
	/**
	 * @generated
	 */	
	public void setDeveloperCopy(Double newVal) {
		this.developerCopy = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copyMarkup;
	
	/**
	 * @generated
 	 */
	public Double getCopyMarkup(){
		return copyMarkup; 
	}

	
	/**
	 * @generated
	 */	
	public void setCopyMarkup(Double newVal) {
		this.copyMarkup = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double monthlyMaintenance;
	
	/**
	 * @generated
 	 */
	public Double getMonthlyMaintenance(){
		return monthlyMaintenance; 
	}

	
	/**
	 * @generated
	 */	
	public void setMonthlyMaintenance(Double newVal) {
		this.monthlyMaintenance = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double machineCostPerCopy;
	
	/**
	 * @generated
 	 */
	public Double getMachineCostPerCopy(){
		return machineCostPerCopy; 
	}

	
	/**
	 * @generated
	 */	
	public void setMachineCostPerCopy(Double newVal) {
		this.machineCostPerCopy = newVal;
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
    @ManyToOne
	private SalesCategory salesCat;
	
	/**
	 * @generated
 	 */
	public SalesCategory getSalesCat(){
		return salesCat; 
	}

	
	/**
	 * @generated
	 */	
	public void setSalesCat(SalesCategory newVal) {
		this.salesCat = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double monthlyBurdenRate;
	
	/**
	 * @generated
 	 */
	public Double getMonthlyBurdenRate(){
		return monthlyBurdenRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setMonthlyBurdenRate(Double newVal) {
		this.monthlyBurdenRate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copyMinutes;
	
	/**
	 * @generated
 	 */
	public Double getCopyMinutes(){
		return copyMinutes; 
	}

	
	/**
	 * @generated
	 */	
	public void setCopyMinutes(Double newVal) {
		this.copyMinutes = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( fetch=FetchType.EAGER)
    @IndexColumn(name="chargescopierdefinition")
    @JoinTable( name = "copierdefinition_charges")
	private java.util.List<ChargeDefinition> charges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getCharges(){
		return charges; 
	}

	/**
	 * @generated
	 */	
	public void addCharges(ChargeDefinition obj) {
		if (charges == null) {
			charges = new java.util.ArrayList<ChargeDefinition>();
		}
		charges.add(obj);
	}
	
	/**
	 * @generated
	 */	
	public void setCharges(java.util.List<ChargeDefinition> newVal) {
		this.charges = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	@Basic
	private Double flateRate;
	
	/**
	 * @generated
 	 */
	public Double getFlateRate(){
		return flateRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setFlateRate(Double newVal) {
		this.flateRate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copyMarkup2;
	
	/**
	 * @generated
 	 */
	public Double getCopyMarkup2(){
		return copyMarkup2; 
	}

	
	/**
	 * @generated
	 */	
	public void setCopyMarkup2(Double newVal) {
		this.copyMarkup2 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double flatRate;
	
	/**
	 * @generated
 	 */
	public Double getFlatRate(){
		return flatRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setFlatRate(Double newVal) {
		this.flatRate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
    @ManyToOne
	private PriceList stockPriceList;
	
	/**
	 * @generated
 	 */
	public PriceList getStockPriceList(){
		return stockPriceList; 
	}

	
	/**
	 * @generated
	 */	
	public void setStockPriceList(PriceList newVal) {
		this.stockPriceList = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private PriceList copierPriceList;
	
	/**
	 * @generated
 	 */
	public PriceList getCopierPriceList(){
		return copierPriceList; 
	}

	
	/**
	 * @generated
	 */	
	public void setCopierPriceList(PriceList newVal) {
		this.copierPriceList = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String priceTwoSide;
	
	/**
	 * @generated
 	 */
	public String getPriceTwoSide(){
		return priceTwoSide; 
	}

	
	/**
	 * @generated
	 */	
	public void setPriceTwoSide(String newVal) {
		this.priceTwoSide = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String stockPriceMethod;
	
	/**
	 * @generated
 	 */
	public String getStockPriceMethod(){
		return stockPriceMethod; 
	}

	
	/**
	 * @generated
	 */	
	public void setStockPriceMethod(String newVal) {
		this.stockPriceMethod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double sideTwoFactor;
	
	/**
	 * @generated
 	 */
	public Double getSideTwoFactor(){
		return sideTwoFactor; 
	}

	
	/**
	 * @generated
	 */	
	public void setSideTwoFactor(Double newVal) {
		this.sideTwoFactor = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private Matrix copierMatrix;
	
	/**
	 * @generated
 	 */
	public Matrix getCopierMatrix(){
		return copierMatrix; 
	}

	
	/**
	 * @generated
	 */	
	public void setCopierMatrix(Matrix newVal) {
		this.copierMatrix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useCopierStockMarkup;
	
	/**
	 * @generated
 	 */
	public Boolean getUseCopierStockMarkup(){
		return useCopierStockMarkup; 
	}

	
	/**
	 * @generated
	 */	
	public void setUseCopierStockMarkup(Boolean newVal) {
		this.useCopierStockMarkup = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean matrixIsCopyCost;
	
	/**
	 * @generated
 	 */
	public Boolean getMatrixIsCopyCost(){
		return matrixIsCopyCost; 
	}

	
	/**
	 * @generated
	 */	
	public void setMatrixIsCopyCost(Boolean newVal) {
		this.matrixIsCopyCost = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean matrixIsDiscountTable;
	
	/**
	 * @generated
 	 */
	public Boolean getMatrixIsDiscountTable(){
		return matrixIsDiscountTable; 
	}

	
	/**
	 * @generated
	 */	
	public void setMatrixIsDiscountTable(Boolean newVal) {
		this.matrixIsDiscountTable = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean matrixIsStepTable;
	
	/**
	 * @generated
 	 */
	public Boolean getMatrixIsStepTable(){
		return matrixIsStepTable; 
	}

	
	/**
	 * @generated
	 */	
	public void setMatrixIsStepTable(Boolean newVal) {
		this.matrixIsStepTable = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean squareAreaFromRunSize;
	
	/**
	 * @generated
 	 */
	public Boolean getSquareAreaFromRunSize(){
		return squareAreaFromRunSize; 
	}

	
	/**
	 * @generated
	 */	
	public void setSquareAreaFromRunSize(Boolean newVal) {
		this.squareAreaFromRunSize = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean squareAreaFromFinish;
	
	/**
	 * @generated
 	 */
	public Boolean getSquareAreaFromFinish(){
		return squareAreaFromFinish; 
	}

	
	/**
	 * @generated
	 */	
	public void setSquareAreaFromFinish(Boolean newVal) {
		this.squareAreaFromFinish = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean interpolateMatrix;
	
	/**
	 * @generated
 	 */
	public Boolean getInterpolateMatrix(){
		return interpolateMatrix; 
	}

	
	/**
	 * @generated
	 */	
	public void setInterpolateMatrix(Boolean newVal) {
		this.interpolateMatrix = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stockMarkup;
	
	/**
	 * @generated
 	 */
	public Double getStockMarkup(){
		return stockMarkup; 
	}

	
	/**
	 * @generated
	 */	
	public void setStockMarkup(Double newVal) {
		this.stockMarkup = newVal;
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
		if (FLATERATE.equals(propertyName)) return getFlateRate();
		if (COPYMARKUP2.equals(propertyName)) return getCopyMarkup2();
		if (FLATRATE.equals(propertyName)) return getFlatRate();
		if (WASTECHART.equals(propertyName)) return getWasteChart();
		if (STOCKPRICELIST.equals(propertyName)) return getStockPriceList();
		if (COPIERPRICELIST.equals(propertyName)) return getCopierPriceList();
		if (PRICETWOSIDE.equals(propertyName)) return getPriceTwoSide();
		if (STOCKPRICEMETHOD.equals(propertyName)) return getStockPriceMethod();
		if (SIDETWOFACTOR.equals(propertyName)) return getSideTwoFactor();
		if (COPIERMATRIX.equals(propertyName)) return getCopierMatrix();
		if (USECOPIERSTOCKMARKUP.equals(propertyName)) return getUseCopierStockMarkup();
		if (MATRIXISCOPYCOST.equals(propertyName)) return getMatrixIsCopyCost();
		if (MATRIXISDISCOUNTTABLE.equals(propertyName)) return getMatrixIsDiscountTable();
		if (MATRIXISSTEPTABLE.equals(propertyName)) return getMatrixIsStepTable();
		if (SQUAREAREAFROMRUNSIZE.equals(propertyName)) return getSquareAreaFromRunSize();
		if (SQUAREAREAFROMFINISH.equals(propertyName)) return getSquareAreaFromFinish();
		if (INTERPOLATEMATRIX.equals(propertyName)) return getInterpolateMatrix();
		if (STOCKMARKUP.equals(propertyName)) return getStockMarkup();
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
		if (PERCENTUSAGE.equals(propertyName)) setPercentUsage((Double)newValue); else
		if (HOURCOSTRATE.equals(propertyName)) setHourCostRate((Double)newValue); else
		if (TONERCOPY.equals(propertyName)) setTonerCopy((Double)newValue); else
		if (DEVELOPERCOPY.equals(propertyName)) setDeveloperCopy((Double)newValue); else
		if (COPYMARKUP.equals(propertyName)) setCopyMarkup((Double)newValue); else
		if (HOURSOPEN.equals(propertyName)) setHoursOpen((Integer)newValue); else
		if (MONTHLYMAINTENANCE.equals(propertyName)) setMonthlyMaintenance((Double)newValue); else
		if (MACHINECOSTPERCOPY.equals(propertyName)) setMachineCostPerCopy((Double)newValue); else
		if (METHOD.equals(propertyName)) setMethod((String)newValue); else
		if (SALESCAT.equals(propertyName)) setSalesCat((SalesCategory)newValue); else
		if (COPYID.equals(propertyName)) setCopyID((Integer)newValue); else
		if (MONTHLYBURDENRATE.equals(propertyName)) setMonthlyBurdenRate((Double)newValue); else
		if (COPYMINUTES.equals(propertyName)) setCopyMinutes((Double)newValue); else
		if (CHARGES.equals(propertyName)) setCharges((java.util.List<ChargeDefinition>)newValue); else
		if (COPIERID.equals(propertyName)) setCopierId((String)newValue); else
		if (FLATERATE.equals(propertyName)) setFlateRate((Double)newValue); else
		if (COPYMARKUP2.equals(propertyName)) setCopyMarkup2((Double)newValue); else
		if (FLATRATE.equals(propertyName)) setFlatRate((Double)newValue); else
		if (WASTECHART.equals(propertyName)) setWasteChart((WasteChart)newValue); else
		if (STOCKPRICELIST.equals(propertyName)) setStockPriceList((PriceList)newValue); else
		if (COPIERPRICELIST.equals(propertyName)) setCopierPriceList((PriceList)newValue); else
		if (PRICETWOSIDE.equals(propertyName)) setPriceTwoSide((String)newValue); else
		if (STOCKPRICEMETHOD.equals(propertyName)) setStockPriceMethod((String)newValue); else
		if (SIDETWOFACTOR.equals(propertyName)) setSideTwoFactor((Double)newValue); else
		if (COPIERMATRIX.equals(propertyName)) setCopierMatrix((Matrix)newValue); else
		if (USECOPIERSTOCKMARKUP.equals(propertyName)) setUseCopierStockMarkup((Boolean)newValue); else
		if (MATRIXISCOPYCOST.equals(propertyName)) setMatrixIsCopyCost((Boolean)newValue); else
		if (MATRIXISDISCOUNTTABLE.equals(propertyName)) setMatrixIsDiscountTable((Boolean)newValue); else
		if (MATRIXISSTEPTABLE.equals(propertyName)) setMatrixIsStepTable((Boolean)newValue); else
		if (SQUAREAREAFROMRUNSIZE.equals(propertyName)) setSquareAreaFromRunSize((Boolean)newValue); else
		if (SQUAREAREAFROMFINISH.equals(propertyName)) setSquareAreaFromFinish((Boolean)newValue); else
		if (INTERPOLATEMATRIX.equals(propertyName)) setInterpolateMatrix((Boolean)newValue); else
		if (STOCKMARKUP.equals(propertyName)) setStockMarkup((Double)newValue); else
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
			return new Class<?>[] {Double.class};		
		if (HOURCOSTRATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TONERCOPY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (DEVELOPERCOPY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (COPYMARKUP.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (HOURSOPEN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MONTHLYMAINTENANCE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (MACHINECOSTPERCOPY.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (METHOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESCAT.equals(propertyName)) 
			return new Class<?>[] {SalesCategory.class};		
		if (COPYID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MONTHLYBURDENRATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (COPYMINUTES.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (CHARGES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
		if (COPIERID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FLATERATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (COPYMARKUP2.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (FLATRATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (WASTECHART.equals(propertyName)) 
			return new Class<?>[] {WasteChart.class};		
		if (STOCKPRICELIST.equals(propertyName)) 
			return new Class<?>[] {PriceList.class};		
		if (COPIERPRICELIST.equals(propertyName)) 
			return new Class<?>[] {PriceList.class};		
		if (PRICETWOSIDE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STOCKPRICEMETHOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SIDETWOFACTOR.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (COPIERMATRIX.equals(propertyName)) 
			return new Class<?>[] {Matrix.class};		
		if (USECOPIERSTOCKMARKUP.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MATRIXISCOPYCOST.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MATRIXISDISCOUNTTABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MATRIXISSTEPTABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SQUAREAREAFROMRUNSIZE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SQUAREAREAFROMFINISH.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTERPOLATEMATRIX.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (STOCKMARKUP.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
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
		if (FLATERATE.equals(propertyName)) return CopierDefinition.class;
		if (COPYMARKUP2.equals(propertyName)) return CopierDefinition.class;
		if (FLATRATE.equals(propertyName)) return CopierDefinition.class;
		if (WASTECHART.equals(propertyName)) return CopierDefinition.class;
		if (STOCKPRICELIST.equals(propertyName)) return CopierDefinition.class;
		if (COPIERPRICELIST.equals(propertyName)) return CopierDefinition.class;
		if (PRICETWOSIDE.equals(propertyName)) return CopierDefinition.class;
		if (STOCKPRICEMETHOD.equals(propertyName)) return CopierDefinition.class;
		if (SIDETWOFACTOR.equals(propertyName)) return CopierDefinition.class;
		if (COPIERMATRIX.equals(propertyName)) return CopierDefinition.class;
		if (USECOPIERSTOCKMARKUP.equals(propertyName)) return CopierDefinition.class;
		if (MATRIXISCOPYCOST.equals(propertyName)) return CopierDefinition.class;
		if (MATRIXISDISCOUNTTABLE.equals(propertyName)) return CopierDefinition.class;
		if (MATRIXISSTEPTABLE.equals(propertyName)) return CopierDefinition.class;
		if (SQUAREAREAFROMRUNSIZE.equals(propertyName)) return CopierDefinition.class;
		if (SQUAREAREAFROMFINISH.equals(propertyName)) return CopierDefinition.class;
		if (INTERPOLATEMATRIX.equals(propertyName)) return CopierDefinition.class;
		if (STOCKMARKUP.equals(propertyName)) return CopierDefinition.class;
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
		if (! SmartEquals(getFlateRate(), objT.getFlateRate()))
			return false;
		if (! SmartEquals(getCopyMarkup2(), objT.getCopyMarkup2()))
			return false;
		if (! SmartEquals(getFlatRate(), objT.getFlatRate()))
			return false;
		if (! SmartEquals(getWasteChart(), objT.getWasteChart()))
			return false;
		if (! SmartEquals(getStockPriceList(), objT.getStockPriceList()))
			return false;
		if (! SmartEquals(getCopierPriceList(), objT.getCopierPriceList()))
			return false;
		if (! SmartEquals(getPriceTwoSide(), objT.getPriceTwoSide()))
			return false;
		if (! SmartEquals(getStockPriceMethod(), objT.getStockPriceMethod()))
			return false;
		if (! SmartEquals(getSideTwoFactor(), objT.getSideTwoFactor()))
			return false;
		if (! SmartEquals(getCopierMatrix(), objT.getCopierMatrix()))
			return false;
		if (! SmartEquals(getUseCopierStockMarkup(), objT.getUseCopierStockMarkup()))
			return false;
		if (! SmartEquals(getMatrixIsCopyCost(), objT.getMatrixIsCopyCost()))
			return false;
		if (! SmartEquals(getMatrixIsDiscountTable(), objT.getMatrixIsDiscountTable()))
			return false;
		if (! SmartEquals(getMatrixIsStepTable(), objT.getMatrixIsStepTable()))
			return false;
		if (! SmartEquals(getSquareAreaFromRunSize(), objT.getSquareAreaFromRunSize()))
			return false;
		if (! SmartEquals(getSquareAreaFromFinish(), objT.getSquareAreaFromFinish()))
			return false;
		if (! SmartEquals(getInterpolateMatrix(), objT.getInterpolateMatrix()))
			return false;
		if (! SmartEquals(getStockMarkup(), objT.getStockMarkup()))
			return false;
		return true;
	}			
}