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
	@NamedQuery(name = "PressDefinition.findall", query = "from PressDefinition"),
	@NamedQuery(name = "PressDefinition.byId", query = "select a from PressDefinition a where a.id= :id")
})


@Entity
@Table(name = "pressdefinition")
public class PressDefinition extends ModelBase {
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
	public static final String MACHINEID = "MachineID";
	/**
	 * @generated
	 */
	public static final String COSTINGPRESS = "CostingPress";
	/**
	 * @generated
	 */
	public static final String INTEGRATEDDEVICE = "IntegratedDevice";
	/**
	 * @generated
	 */
	public static final String MAXPAPERSIZE = "MaxPaperSize";
	/**
	 * @generated
	 */
	public static final String MINPAPERSIZE = "MinPaperSize";
	/**
	 * @generated
	 */
	public static final String LABORRATE = "LaborRate";
	/**
	 * @generated
	 */
	public static final String LABORMARKUP = "LaborMarkup";
	/**
	 * @generated
	 */
	public static final String FIXEDWASTE = "FixedWaste";
	/**
	 * @generated
	 */
	public static final String MINLABOR = "MinLabor";
	/**
	 * @generated
	 */
	public static final String SETUPMIN = "SetupMin";
	/**
	 * @generated
	 */
	public static final String SETUPADDSIG = "SetupAddSig";
	/**
	 * @generated
	 */
	public static final String WORKTURNSETUP = "WorkTurnSetup";
	/**
	 * @generated
	 */
	public static final String SETUPADDHEAD = "SetupAddHead";
	/**
	 * @generated
	 */
	public static final String WASHUPFEE = "WashupFee";
	/**
	 * @generated
	 */
	public static final String ADDSIGADDHEAD = "AddSigAddHead";
	/**
	 * @generated
	 */
	public static final String WASHUPMIN = "WashupMin";
	/**
	 * @generated
	 */
	public static final String WASHUPPERFOUNTAIN = "WashupPerFountain";
	/**
	 * @generated
	 */
	public static final String GRIPEDGE = "GripEdge";
	/**
	 * @generated
	 */
	public static final String PERFECTOR = "Perfector";
	/**
	 * @generated
	 */
	public static final String AVGIMPRESSPERHOUR = "AvgImpressPerHour";
	/**
	 * @generated
	 */
	public static final String NUMBERHEADS = "NumberHeads";
	/**
	 * @generated
	 */
	public static final String SETUPADDRUN = "SetupAddRun";
	/**
	 * @generated
	 */
	public static final String SHEETFED = "SheetFed";
	/**
	 * @generated
	 */
	public static final String ROLLFED = "RollFed";
	/**
	 * @generated
	 */
	public static final String WASTECHART = "WasteChart";
	/**
	 * @generated
	 */
	public static final String PRESSPRICELIST = "PressPriceList";
	/**
	 * @generated
	 */
	public static final String STOCKPRICELIST = "StockPriceList";
	/**
	 * @generated
	 */
	public static final String SPEEDTABLE = "SpeedTable";
	/**
	 * @generated
	 */
	public static final String CUTOFFLENGTH = "CutoffLength";
	/**
	 * @generated
	 */
	public static final String PRESSID = "PressId";
	/**
	 * @generated
	 */
	public static final String CHARGES = "Charges";
	/**
	 * @generated
	 */
	public static final String MAXROLLWIDTH = "MaxRollWidth";
	/**
	 * @generated
	 */
	public static final String MINROLLWIDTH = "MinRollWidth";
	/**
	 * @generated
	 */
	public static final String SALESCAT = "SalesCat";

	/**
	 * @generated
	 */
	public PressDefinition() {
		this.created = new Date();
		this.modified = new Date();
	}

	public PressDefinition(long id, String Name) {
		this.id = id;
		this.name = Name;
	}
	public PressDefinition(long id, String name, long MachineID, String machineName) {
		this.id = id;
		this.name =name;
		this.machineID= MachineID;
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
	private Long machineID;
	
	/**
	 * @generated
 	 */
	public Long getMachineID(){
		return machineID; 
	}

	
	/**
	 * @generated
	 */	
	public void setMachineID(Long newVal) {
		this.machineID = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean costingPress;
	
	/**
	 * @generated
 	 */
	public Boolean getCostingPress(){
		return costingPress; 
	}

	
	/**
	 * @generated
	 */	
	public void setCostingPress(Boolean newVal) {
		this.costingPress = newVal;
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
	private String maxPaperSize;
	
	/**
	 * @generated
 	 */
	public String getMaxPaperSize(){
		return maxPaperSize; 
	}

	
	/**
	 * @generated
	 */	
	public void setMaxPaperSize(String newVal) {
		this.maxPaperSize = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String minPaperSize;
	
	/**
	 * @generated
 	 */
	public String getMinPaperSize(){
		return minPaperSize; 
	}

	
	/**
	 * @generated
	 */	
	public void setMinPaperSize(String newVal) {
		this.minPaperSize = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double laborRate;
	
	/**
	 * @generated
 	 */
	public Double getLaborRate(){
		return laborRate; 
	}

	
	/**
	 * @generated
	 */	
	public void setLaborRate(Double newVal) {
		this.laborRate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double laborMarkup;
	
	/**
	 * @generated
 	 */
	public Double getLaborMarkup(){
		return laborMarkup; 
	}

	
	/**
	 * @generated
	 */	
	public void setLaborMarkup(Double newVal) {
		this.laborMarkup = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double fixedWaste;
	
	/**
	 * @generated
 	 */
	public Double getFixedWaste(){
		return fixedWaste; 
	}

	
	/**
	 * @generated
	 */	
	public void setFixedWaste(Double newVal) {
		this.fixedWaste = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double minLabor;
	
	/**
	 * @generated
 	 */
	public Double getMinLabor(){
		return minLabor; 
	}

	
	/**
	 * @generated
	 */	
	public void setMinLabor(Double newVal) {
		this.minLabor = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double setupMin;
	
	/**
	 * @generated
 	 */
	public Double getSetupMin(){
		return setupMin; 
	}

	
	/**
	 * @generated
	 */	
	public void setSetupMin(Double newVal) {
		this.setupMin = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long setupAddSig;
	
	/**
	 * @generated
 	 */
	public Long getSetupAddSig(){
		return setupAddSig; 
	}

	
	/**
	 * @generated
	 */	
	public void setSetupAddSig(Long newVal) {
		this.setupAddSig = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double workTurnSetup;
	
	/**
	 * @generated
 	 */
	public Double getWorkTurnSetup(){
		return workTurnSetup; 
	}

	
	/**
	 * @generated
	 */	
	public void setWorkTurnSetup(Double newVal) {
		this.workTurnSetup = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long setupAddHead;
	
	/**
	 * @generated
 	 */
	public Long getSetupAddHead(){
		return setupAddHead; 
	}

	
	/**
	 * @generated
	 */	
	public void setSetupAddHead(Long newVal) {
		this.setupAddHead = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double washupFee;
	
	/**
	 * @generated
 	 */
	public Double getWashupFee(){
		return washupFee; 
	}

	
	/**
	 * @generated
	 */	
	public void setWashupFee(Double newVal) {
		this.washupFee = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long addSigAddHead;
	
	/**
	 * @generated
 	 */
	public Long getAddSigAddHead(){
		return addSigAddHead; 
	}

	
	/**
	 * @generated
	 */	
	public void setAddSigAddHead(Long newVal) {
		this.addSigAddHead = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long washupMin;
	
	/**
	 * @generated
 	 */
	public Long getWashupMin(){
		return washupMin; 
	}

	
	/**
	 * @generated
	 */	
	public void setWashupMin(Long newVal) {
		this.washupMin = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double washupPerFountain;
	
	/**
	 * @generated
 	 */
	public Double getWashupPerFountain(){
		return washupPerFountain; 
	}

	
	/**
	 * @generated
	 */	
	public void setWashupPerFountain(Double newVal) {
		this.washupPerFountain = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double gripEdge;
	
	/**
	 * @generated
 	 */
	public Double getGripEdge(){
		return gripEdge; 
	}

	
	/**
	 * @generated
	 */	
	public void setGripEdge(Double newVal) {
		this.gripEdge = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean perfector;
	
	/**
	 * @generated
 	 */
	public Boolean getPerfector(){
		return perfector; 
	}

	
	/**
	 * @generated
	 */	
	public void setPerfector(Boolean newVal) {
		this.perfector = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long avgImpressPerHour;
	
	/**
	 * @generated
 	 */
	public Long getAvgImpressPerHour(){
		return avgImpressPerHour; 
	}

	
	/**
	 * @generated
	 */	
	public void setAvgImpressPerHour(Long newVal) {
		this.avgImpressPerHour = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long numberHeads;
	
	/**
	 * @generated
 	 */
	public Long getNumberHeads(){
		return numberHeads; 
	}

	
	/**
	 * @generated
	 */	
	public void setNumberHeads(Long newVal) {
		this.numberHeads = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long setupAddRun;
	
	/**
	 * @generated
 	 */
	public Long getSetupAddRun(){
		return setupAddRun; 
	}

	
	/**
	 * @generated
	 */	
	public void setSetupAddRun(Long newVal) {
		this.setupAddRun = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean sheetFed;
	
	/**
	 * @generated
 	 */
	public Boolean getSheetFed(){
		return sheetFed; 
	}

	
	/**
	 * @generated
	 */	
	public void setSheetFed(Boolean newVal) {
		this.sheetFed = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean rollFed;
	
	/**
	 * @generated
 	 */
	public Boolean getRollFed(){
		return rollFed; 
	}

	
	/**
	 * @generated
	 */	
	public void setRollFed(Boolean newVal) {
		this.rollFed = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PriceList pressPriceList;
	
	/**
	 * @generated
 	 */
	public PriceList getPressPriceList(){
		return pressPriceList; 
	}

	
	/**
	 * @generated
	 */	
	public void setPressPriceList(PriceList newVal) {
		this.pressPriceList = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private SpeedTable speedTable;
	
	/**
	 * @generated
 	 */
	public SpeedTable getSpeedTable(){
		return speedTable; 
	}

	
	/**
	 * @generated
	 */	
	public void setSpeedTable(SpeedTable newVal) {
		this.speedTable = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cutoffLength;
	
	/**
	 * @generated
 	 */
	public Double getCutoffLength(){
		return cutoffLength; 
	}

	
	/**
	 * @generated
	 */	
	public void setCutoffLength(Double newVal) {
		this.cutoffLength = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String pressId;
	
	/**
	 * @generated
 	 */
	public String getPressId(){
		return pressId; 
	}

	
	/**
	 * @generated
	 */	
	public void setPressId(String newVal) {
		this.pressId = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "pressdefinition_charges")
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
	private String maxRollWidth;
	
	/**
	 * @generated
 	 */
	public String getMaxRollWidth(){
		return maxRollWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setMaxRollWidth(String newVal) {
		this.maxRollWidth = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String minRollWidth;
	
	/**
	 * @generated
 	 */
	public String getMinRollWidth(){
		return minRollWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setMinRollWidth(String newVal) {
		this.minRollWidth = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (MACHINENAME.equals(propertyName)) return getMachineName();
		if (OUTPUTDESCRIP.equals(propertyName)) return getOutputDescrip();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (COSTCENTER.equals(propertyName)) return getCostCenter();
		if (OEMDEVICEID.equals(propertyName)) return getOemDeviceID();
		if (MACHINEID.equals(propertyName)) return getMachineID();
		if (COSTINGPRESS.equals(propertyName)) return getCostingPress();
		if (INTEGRATEDDEVICE.equals(propertyName)) return getIntegratedDevice();
		if (MAXPAPERSIZE.equals(propertyName)) return getMaxPaperSize();
		if (MINPAPERSIZE.equals(propertyName)) return getMinPaperSize();
		if (LABORRATE.equals(propertyName)) return getLaborRate();
		if (LABORMARKUP.equals(propertyName)) return getLaborMarkup();
		if (FIXEDWASTE.equals(propertyName)) return getFixedWaste();
		if (MINLABOR.equals(propertyName)) return getMinLabor();
		if (SETUPMIN.equals(propertyName)) return getSetupMin();
		if (SETUPADDSIG.equals(propertyName)) return getSetupAddSig();
		if (WORKTURNSETUP.equals(propertyName)) return getWorkTurnSetup();
		if (SETUPADDHEAD.equals(propertyName)) return getSetupAddHead();
		if (WASHUPFEE.equals(propertyName)) return getWashupFee();
		if (ADDSIGADDHEAD.equals(propertyName)) return getAddSigAddHead();
		if (WASHUPMIN.equals(propertyName)) return getWashupMin();
		if (WASHUPPERFOUNTAIN.equals(propertyName)) return getWashupPerFountain();
		if (GRIPEDGE.equals(propertyName)) return getGripEdge();
		if (PERFECTOR.equals(propertyName)) return getPerfector();
		if (AVGIMPRESSPERHOUR.equals(propertyName)) return getAvgImpressPerHour();
		if (NUMBERHEADS.equals(propertyName)) return getNumberHeads();
		if (SETUPADDRUN.equals(propertyName)) return getSetupAddRun();
		if (SHEETFED.equals(propertyName)) return getSheetFed();
		if (ROLLFED.equals(propertyName)) return getRollFed();
		if (WASTECHART.equals(propertyName)) return getWasteChart();
		if (PRESSPRICELIST.equals(propertyName)) return getPressPriceList();
		if (STOCKPRICELIST.equals(propertyName)) return getStockPriceList();
		if (SPEEDTABLE.equals(propertyName)) return getSpeedTable();
		if (CUTOFFLENGTH.equals(propertyName)) return getCutoffLength();
		if (PRESSID.equals(propertyName)) return getPressId();
		if (CHARGES.equals(propertyName)) return getCharges();
		if (MAXROLLWIDTH.equals(propertyName)) return getMaxRollWidth();
		if (MINROLLWIDTH.equals(propertyName)) return getMinRollWidth();
		if (SALESCAT.equals(propertyName)) return getSalesCat();
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
		if (MACHINEID.equals(propertyName)) setMachineID((Long)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((Boolean)newValue); else
		if (INTEGRATEDDEVICE.equals(propertyName)) setIntegratedDevice((Boolean)newValue); else
		if (MAXPAPERSIZE.equals(propertyName)) setMaxPaperSize((String)newValue); else
		if (MINPAPERSIZE.equals(propertyName)) setMinPaperSize((String)newValue); else
		if (LABORRATE.equals(propertyName)) setLaborRate((Double)newValue); else
		if (LABORMARKUP.equals(propertyName)) setLaborMarkup((Double)newValue); else
		if (FIXEDWASTE.equals(propertyName)) setFixedWaste((Double)newValue); else
		if (MINLABOR.equals(propertyName)) setMinLabor((Double)newValue); else
		if (SETUPMIN.equals(propertyName)) setSetupMin((Double)newValue); else
		if (SETUPADDSIG.equals(propertyName)) setSetupAddSig((Long)newValue); else
		if (WORKTURNSETUP.equals(propertyName)) setWorkTurnSetup((Double)newValue); else
		if (SETUPADDHEAD.equals(propertyName)) setSetupAddHead((Long)newValue); else
		if (WASHUPFEE.equals(propertyName)) setWashupFee((Double)newValue); else
		if (ADDSIGADDHEAD.equals(propertyName)) setAddSigAddHead((Long)newValue); else
		if (WASHUPMIN.equals(propertyName)) setWashupMin((Long)newValue); else
		if (WASHUPPERFOUNTAIN.equals(propertyName)) setWashupPerFountain((Double)newValue); else
		if (GRIPEDGE.equals(propertyName)) setGripEdge((Double)newValue); else
		if (PERFECTOR.equals(propertyName)) setPerfector((Boolean)newValue); else
		if (AVGIMPRESSPERHOUR.equals(propertyName)) setAvgImpressPerHour((Long)newValue); else
		if (NUMBERHEADS.equals(propertyName)) setNumberHeads((Long)newValue); else
		if (SETUPADDRUN.equals(propertyName)) setSetupAddRun((Long)newValue); else
		if (SHEETFED.equals(propertyName)) setSheetFed((Boolean)newValue); else
		if (ROLLFED.equals(propertyName)) setRollFed((Boolean)newValue); else
		if (WASTECHART.equals(propertyName)) setWasteChart((WasteChart)newValue); else
		if (PRESSPRICELIST.equals(propertyName)) setPressPriceList((PriceList)newValue); else
		if (STOCKPRICELIST.equals(propertyName)) setStockPriceList((PriceList)newValue); else
		if (SPEEDTABLE.equals(propertyName)) setSpeedTable((SpeedTable)newValue); else
		if (CUTOFFLENGTH.equals(propertyName)) setCutoffLength((Double)newValue); else
		if (PRESSID.equals(propertyName)) setPressId((String)newValue); else
		if (CHARGES.equals(propertyName)) setCharges((java.util.List<ChargeDefinition>)newValue); else
		if (MAXROLLWIDTH.equals(propertyName)) setMaxRollWidth((String)newValue); else
		if (MINROLLWIDTH.equals(propertyName)) setMinRollWidth((String)newValue); else
		if (SALESCAT.equals(propertyName)) setSalesCat((SalesCategory)newValue); else
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
		if (MACHINEID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COSTINGPRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTEGRATEDDEVICE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (MAXPAPERSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINPAPERSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LABORRATE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (LABORMARKUP.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (FIXEDWASTE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (MINLABOR.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SETUPMIN.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SETUPADDSIG.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WORKTURNSETUP.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (SETUPADDHEAD.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WASHUPFEE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (ADDSIGADDHEAD.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WASHUPMIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WASHUPPERFOUNTAIN.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (GRIPEDGE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PERFECTOR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (AVGIMPRESSPERHOUR.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (NUMBERHEADS.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SETUPADDRUN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHEETFED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ROLLFED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (WASTECHART.equals(propertyName)) 
			return new Class<?>[] {WasteChart.class};		
		if (PRESSPRICELIST.equals(propertyName)) 
			return new Class<?>[] {PriceList.class};		
		if (STOCKPRICELIST.equals(propertyName)) 
			return new Class<?>[] {PriceList.class};		
		if (SPEEDTABLE.equals(propertyName)) 
			return new Class<?>[] {SpeedTable.class};		
		if (CUTOFFLENGTH.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (PRESSID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CHARGES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
		if (MAXROLLWIDTH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINROLLWIDTH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SALESCAT.equals(propertyName)) 
			return new Class<?>[] {SalesCategory.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return PressDefinition.class;
		if (MACHINENAME.equals(propertyName)) return PressDefinition.class;
		if (OUTPUTDESCRIP.equals(propertyName)) return PressDefinition.class;
		if (PRODUCTIONLOCATION.equals(propertyName)) return PressDefinition.class;
		if (COSTCENTER.equals(propertyName)) return PressDefinition.class;
		if (OEMDEVICEID.equals(propertyName)) return PressDefinition.class;
		if (MACHINEID.equals(propertyName)) return PressDefinition.class;
		if (COSTINGPRESS.equals(propertyName)) return PressDefinition.class;
		if (INTEGRATEDDEVICE.equals(propertyName)) return PressDefinition.class;
		if (MAXPAPERSIZE.equals(propertyName)) return PressDefinition.class;
		if (MINPAPERSIZE.equals(propertyName)) return PressDefinition.class;
		if (LABORRATE.equals(propertyName)) return PressDefinition.class;
		if (LABORMARKUP.equals(propertyName)) return PressDefinition.class;
		if (FIXEDWASTE.equals(propertyName)) return PressDefinition.class;
		if (MINLABOR.equals(propertyName)) return PressDefinition.class;
		if (SETUPMIN.equals(propertyName)) return PressDefinition.class;
		if (SETUPADDSIG.equals(propertyName)) return PressDefinition.class;
		if (WORKTURNSETUP.equals(propertyName)) return PressDefinition.class;
		if (SETUPADDHEAD.equals(propertyName)) return PressDefinition.class;
		if (WASHUPFEE.equals(propertyName)) return PressDefinition.class;
		if (ADDSIGADDHEAD.equals(propertyName)) return PressDefinition.class;
		if (WASHUPMIN.equals(propertyName)) return PressDefinition.class;
		if (WASHUPPERFOUNTAIN.equals(propertyName)) return PressDefinition.class;
		if (GRIPEDGE.equals(propertyName)) return PressDefinition.class;
		if (PERFECTOR.equals(propertyName)) return PressDefinition.class;
		if (AVGIMPRESSPERHOUR.equals(propertyName)) return PressDefinition.class;
		if (NUMBERHEADS.equals(propertyName)) return PressDefinition.class;
		if (SETUPADDRUN.equals(propertyName)) return PressDefinition.class;
		if (SHEETFED.equals(propertyName)) return PressDefinition.class;
		if (ROLLFED.equals(propertyName)) return PressDefinition.class;
		if (WASTECHART.equals(propertyName)) return PressDefinition.class;
		if (PRESSPRICELIST.equals(propertyName)) return PressDefinition.class;
		if (STOCKPRICELIST.equals(propertyName)) return PressDefinition.class;
		if (SPEEDTABLE.equals(propertyName)) return PressDefinition.class;
		if (CUTOFFLENGTH.equals(propertyName)) return PressDefinition.class;
		if (PRESSID.equals(propertyName)) return PressDefinition.class;
		if (CHARGES.equals(propertyName)) return PressDefinition.class;
		if (MAXROLLWIDTH.equals(propertyName)) return PressDefinition.class;
		if (MINROLLWIDTH.equals(propertyName)) return PressDefinition.class;
		if (SALESCAT.equals(propertyName)) return PressDefinition.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PressDefinition objT = (PressDefinition)obj;
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
		if (! SmartEquals(getMachineID(), objT.getMachineID()))
			return false;
		if (! SmartEquals(getCostingPress(), objT.getCostingPress()))
			return false;
		if (! SmartEquals(getIntegratedDevice(), objT.getIntegratedDevice()))
			return false;
		if (! SmartEquals(getMaxPaperSize(), objT.getMaxPaperSize()))
			return false;
		if (! SmartEquals(getMinPaperSize(), objT.getMinPaperSize()))
			return false;
		if (! SmartEquals(getLaborRate(), objT.getLaborRate()))
			return false;
		if (! SmartEquals(getLaborMarkup(), objT.getLaborMarkup()))
			return false;
		if (! SmartEquals(getFixedWaste(), objT.getFixedWaste()))
			return false;
		if (! SmartEquals(getMinLabor(), objT.getMinLabor()))
			return false;
		if (! SmartEquals(getSetupMin(), objT.getSetupMin()))
			return false;
		if (! SmartEquals(getSetupAddSig(), objT.getSetupAddSig()))
			return false;
		if (! SmartEquals(getWorkTurnSetup(), objT.getWorkTurnSetup()))
			return false;
		if (! SmartEquals(getSetupAddHead(), objT.getSetupAddHead()))
			return false;
		if (! SmartEquals(getWashupFee(), objT.getWashupFee()))
			return false;
		if (! SmartEquals(getAddSigAddHead(), objT.getAddSigAddHead()))
			return false;
		if (! SmartEquals(getWashupMin(), objT.getWashupMin()))
			return false;
		if (! SmartEquals(getWashupPerFountain(), objT.getWashupPerFountain()))
			return false;
		if (! SmartEquals(getGripEdge(), objT.getGripEdge()))
			return false;
		if (! SmartEquals(getPerfector(), objT.getPerfector()))
			return false;
		if (! SmartEquals(getAvgImpressPerHour(), objT.getAvgImpressPerHour()))
			return false;
		if (! SmartEquals(getNumberHeads(), objT.getNumberHeads()))
			return false;
		if (! SmartEquals(getSetupAddRun(), objT.getSetupAddRun()))
			return false;
		if (! SmartEquals(getSheetFed(), objT.getSheetFed()))
			return false;
		if (! SmartEquals(getRollFed(), objT.getRollFed()))
			return false;
		if (! SmartEquals(getWasteChart(), objT.getWasteChart()))
			return false;
		if (! SmartEquals(getPressPriceList(), objT.getPressPriceList()))
			return false;
		if (! SmartEquals(getStockPriceList(), objT.getStockPriceList()))
			return false;
		if (! SmartEquals(getSpeedTable(), objT.getSpeedTable()))
			return false;
		if (! SmartEquals(getCutoffLength(), objT.getCutoffLength()))
			return false;
		if (! SmartEquals(getPressId(), objT.getPressId()))
			return false;
		if (! SmartEquals(getCharges(), objT.getCharges()))
			return false;
		if (! SmartEquals(getMaxRollWidth(), objT.getMaxRollWidth()))
			return false;
		if (! SmartEquals(getMinRollWidth(), objT.getMinRollWidth()))
			return false;
		if (! SmartEquals(getSalesCat(), objT.getSalesCat()))
			return false;
		return true;
	}			
}