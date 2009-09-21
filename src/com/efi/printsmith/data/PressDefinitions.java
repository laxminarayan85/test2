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
	@NamedQuery(name = "PressDefinitions.findall", query = "from PressDefinitions"),
	@NamedQuery(name = "PressDefinitions.byId", query = "select a from PressDefinitions a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.data.PressDefinitions")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "pressdefinitions")
public class PressDefinitions extends ModelBase {
	/**
	 * @generated
	 */
	public static final String PRESSDEFID = "PressDefID";
	/**
	 * @generated
	 */
	public static final String PRESSDEFNAME = "PressDefName";
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
	public static final String OEMDEIVEID = "OEMDeiveID";
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
	public static final String SHEETFED = "SheetFed";
	/**
	 * @generated
	 */
	public static final String ROLLTOROLL = "RolltoRoll";
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
	public PressDefinitions() {
	}

 	
	
	private Integer pressDefID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="pressdefid", nullable=true, unique=false)
	public Integer getPressDefID(){
		return pressDefID; 
	}

	/**
	 * @generated
	 */	
	public Integer setPressDefID(Integer newVal) {
		return this.pressDefID = newVal;
	}
 	
	
	private String pressDefName;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="pressdefname", nullable=true, unique=false)
	public String getPressDefName(){
		return pressDefName; 
	}

	/**
	 * @generated
	 */	
	public String setPressDefName(String newVal) {
		return this.pressDefName = newVal;
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
 	
	
	private Integer oEMDeiveID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="oemdeiveid", nullable=true, unique=false)
	public Integer getOEMDeiveID(){
		return oEMDeiveID; 
	}

	/**
	 * @generated
	 */	
	public Integer setOEMDeiveID(Integer newVal) {
		return this.oEMDeiveID = newVal;
	}
 	
	
	private Integer machineID;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="machineid", nullable=true, unique=false)
	public Integer getMachineID(){
		return machineID; 
	}

	/**
	 * @generated
	 */	
	public Integer setMachineID(Integer newVal) {
		return this.machineID = newVal;
	}
 	
	
	private Short costingPress;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Short getCostingPress(){
		return costingPress; 
	}

	/**
	 * @generated
	 */	
	public Short setCostingPress(Short newVal) {
		return this.costingPress = newVal;
	}
 	
	
	private Short sheetFed;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Short getSheetFed(){
		return sheetFed; 
	}

	/**
	 * @generated
	 */	
	public Short setSheetFed(Short newVal) {
		return this.sheetFed = newVal;
	}
 	
	
	private Short rolltoRoll;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Short getRolltoRoll(){
		return rolltoRoll; 
	}

	/**
	 * @generated
	 */	
	public Short setRolltoRoll(Short newVal) {
		return this.rolltoRoll = newVal;
	}
 	
	
	private Short integratedDevice;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Short getIntegratedDevice(){
		return integratedDevice; 
	}

	/**
	 * @generated
	 */	
	public Short setIntegratedDevice(Short newVal) {
		return this.integratedDevice = newVal;
	}
 	
	
	private String maxPaperSize;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="maxpapersize", nullable=true, unique=false)
	public String getMaxPaperSize(){
		return maxPaperSize; 
	}

	/**
	 * @generated
	 */	
	public String setMaxPaperSize(String newVal) {
		return this.maxPaperSize = newVal;
	}
 	
	
	private String minPaperSize;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minpapersize", nullable=true, unique=false)
	public String getMinPaperSize(){
		return minPaperSize; 
	}

	/**
	 * @generated
	 */	
	public String setMinPaperSize(String newVal) {
		return this.minPaperSize = newVal;
	}
 	
	
	private Integer laborRate;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="laborrate", nullable=true, unique=false)
	public Integer getLaborRate(){
		return laborRate; 
	}

	/**
	 * @generated
	 */	
	public Integer setLaborRate(Integer newVal) {
		return this.laborRate = newVal;
	}
 	
	
	private Integer laborMarkup;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="labormarkup", nullable=true, unique=false)
	public Integer getLaborMarkup(){
		return laborMarkup; 
	}

	/**
	 * @generated
	 */	
	public Integer setLaborMarkup(Integer newVal) {
		return this.laborMarkup = newVal;
	}
 	
	
	private Integer fixedWaste;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="fixedwaste", nullable=true, unique=false)
	public Integer getFixedWaste(){
		return fixedWaste; 
	}

	/**
	 * @generated
	 */	
	public Integer setFixedWaste(Integer newVal) {
		return this.fixedWaste = newVal;
	}
 	
	
	private Integer minLabor;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minlabor", nullable=true, unique=false)
	public Integer getMinLabor(){
		return minLabor; 
	}

	/**
	 * @generated
	 */	
	public Integer setMinLabor(Integer newVal) {
		return this.minLabor = newVal;
	}
 	
	
	private Integer setupMin;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="setupmin", nullable=true, unique=false)
	public Integer getSetupMin(){
		return setupMin; 
	}

	/**
	 * @generated
	 */	
	public Integer setSetupMin(Integer newVal) {
		return this.setupMin = newVal;
	}
 	
	
	private Integer setupAddSig;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="setupaddsig", nullable=true, unique=false)
	public Integer getSetupAddSig(){
		return setupAddSig; 
	}

	/**
	 * @generated
	 */	
	public Integer setSetupAddSig(Integer newVal) {
		return this.setupAddSig = newVal;
	}
 	
	
	private Integer workTurnSetup;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="workturnsetup", nullable=true, unique=false)
	public Integer getWorkTurnSetup(){
		return workTurnSetup; 
	}

	/**
	 * @generated
	 */	
	public Integer setWorkTurnSetup(Integer newVal) {
		return this.workTurnSetup = newVal;
	}
 	
	
	private Integer setupAddHead;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="setupaddhead", nullable=true, unique=false)
	public Integer getSetupAddHead(){
		return setupAddHead; 
	}

	/**
	 * @generated
	 */	
	public Integer setSetupAddHead(Integer newVal) {
		return this.setupAddHead = newVal;
	}
 	
	
	private Integer washupFee;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="washupfee", nullable=true, unique=false)
	public Integer getWashupFee(){
		return washupFee; 
	}

	/**
	 * @generated
	 */	
	public Integer setWashupFee(Integer newVal) {
		return this.washupFee = newVal;
	}
 	
	
	private Integer addSigAddHead;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="addsigaddhead", nullable=true, unique=false)
	public Integer getAddSigAddHead(){
		return addSigAddHead; 
	}

	/**
	 * @generated
	 */	
	public Integer setAddSigAddHead(Integer newVal) {
		return this.addSigAddHead = newVal;
	}
 	
	
	private Integer washupMin;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="washupmin", nullable=true, unique=false)
	public Integer getWashupMin(){
		return washupMin; 
	}

	/**
	 * @generated
	 */	
	public Integer setWashupMin(Integer newVal) {
		return this.washupMin = newVal;
	}
 	
	
	private Integer washupPerFountain;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="washupperfountain", nullable=true, unique=false)
	public Integer getWashupPerFountain(){
		return washupPerFountain; 
	}

	/**
	 * @generated
	 */	
	public Integer setWashupPerFountain(Integer newVal) {
		return this.washupPerFountain = newVal;
	}
 	
	
	private Integer gripEdge;
	/**
	 * @generated
 	 */
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="gripedge", nullable=true, unique=false)
	public Integer getGripEdge(){
		return gripEdge; 
	}

	/**
	 * @generated
	 */	
	public Integer setGripEdge(Integer newVal) {
		return this.gripEdge = newVal;
	}
 	
	
	private Short perfector;
	/**
	 * @generated
 	 */
	@ManyToOne( cascade = CascadeType.ALL )	
	public Short getPerfector(){
		return perfector; 
	}

	/**
	 * @generated
	 */	
	public Short setPerfector(Short newVal) {
		return this.perfector = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (PRESSDEFID.equals(propertyName)) return getPressDefID();
		if (PRESSDEFNAME.equals(propertyName)) return getPressDefName();
		if (MACHINENAME.equals(propertyName)) return getMachineName();
		if (OUTPUTDESCRIP.equals(propertyName)) return getOutputDescrip();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (COSTCENTER.equals(propertyName)) return getCostCenter();
		if (OEMDEIVEID.equals(propertyName)) return getOEMDeiveID();
		if (MACHINEID.equals(propertyName)) return getMachineID();
		if (COSTINGPRESS.equals(propertyName)) return getCostingPress();
		if (SHEETFED.equals(propertyName)) return getSheetFed();
		if (ROLLTOROLL.equals(propertyName)) return getRolltoRoll();
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
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (PRESSDEFID.equals(propertyName)) setPressDefID((Integer)newValue); else
		if (PRESSDEFNAME.equals(propertyName)) setPressDefName((String)newValue); else
		if (MACHINENAME.equals(propertyName)) setMachineName((String)newValue); else
		if (OUTPUTDESCRIP.equals(propertyName)) setOutputDescrip((String)newValue); else
		if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((String)newValue); else
		if (COSTCENTER.equals(propertyName)) setCostCenter((String)newValue); else
		if (OEMDEIVEID.equals(propertyName)) setOEMDeiveID((Integer)newValue); else
		if (MACHINEID.equals(propertyName)) setMachineID((Integer)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((Short)newValue); else
		if (SHEETFED.equals(propertyName)) setSheetFed((Short)newValue); else
		if (ROLLTOROLL.equals(propertyName)) setRolltoRoll((Short)newValue); else
		if (INTEGRATEDDEVICE.equals(propertyName)) setIntegratedDevice((Short)newValue); else
		if (MAXPAPERSIZE.equals(propertyName)) setMaxPaperSize((String)newValue); else
		if (MINPAPERSIZE.equals(propertyName)) setMinPaperSize((String)newValue); else
		if (LABORRATE.equals(propertyName)) setLaborRate((Integer)newValue); else
		if (LABORMARKUP.equals(propertyName)) setLaborMarkup((Integer)newValue); else
		if (FIXEDWASTE.equals(propertyName)) setFixedWaste((Integer)newValue); else
		if (MINLABOR.equals(propertyName)) setMinLabor((Integer)newValue); else
		if (SETUPMIN.equals(propertyName)) setSetupMin((Integer)newValue); else
		if (SETUPADDSIG.equals(propertyName)) setSetupAddSig((Integer)newValue); else
		if (WORKTURNSETUP.equals(propertyName)) setWorkTurnSetup((Integer)newValue); else
		if (SETUPADDHEAD.equals(propertyName)) setSetupAddHead((Integer)newValue); else
		if (WASHUPFEE.equals(propertyName)) setWashupFee((Integer)newValue); else
		if (ADDSIGADDHEAD.equals(propertyName)) setAddSigAddHead((Integer)newValue); else
		if (WASHUPMIN.equals(propertyName)) setWashupMin((Integer)newValue); else
		if (WASHUPPERFOUNTAIN.equals(propertyName)) setWashupPerFountain((Integer)newValue); else
		if (GRIPEDGE.equals(propertyName)) setGripEdge((Integer)newValue); else
		if (PERFECTOR.equals(propertyName)) setPerfector((Short)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (PRESSDEFID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PRESSDEFNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MACHINENAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (OUTPUTDESCRIP.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PRODUCTIONLOCATION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COSTCENTER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (OEMDEIVEID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MACHINEID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COSTINGPRESS.equals(propertyName)) 
			return new Class<?>[] {Short.class};		
		if (SHEETFED.equals(propertyName)) 
			return new Class<?>[] {Short.class};		
		if (ROLLTOROLL.equals(propertyName)) 
			return new Class<?>[] {Short.class};		
		if (INTEGRATEDDEVICE.equals(propertyName)) 
			return new Class<?>[] {Short.class};		
		if (MAXPAPERSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINPAPERSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LABORRATE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (LABORMARKUP.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FIXEDWASTE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MINLABOR.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SETUPMIN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SETUPADDSIG.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (WORKTURNSETUP.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SETUPADDHEAD.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (WASHUPFEE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (ADDSIGADDHEAD.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (WASHUPMIN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (WASHUPPERFOUNTAIN.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (GRIPEDGE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PERFECTOR.equals(propertyName)) 
			return new Class<?>[] {Short.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (PRESSDEFID.equals(propertyName)) return PressDefinitions.class;
		if (PRESSDEFNAME.equals(propertyName)) return PressDefinitions.class;
		if (MACHINENAME.equals(propertyName)) return PressDefinitions.class;
		if (OUTPUTDESCRIP.equals(propertyName)) return PressDefinitions.class;
		if (PRODUCTIONLOCATION.equals(propertyName)) return PressDefinitions.class;
		if (COSTCENTER.equals(propertyName)) return PressDefinitions.class;
		if (OEMDEIVEID.equals(propertyName)) return PressDefinitions.class;
		if (MACHINEID.equals(propertyName)) return PressDefinitions.class;
		if (COSTINGPRESS.equals(propertyName)) return PressDefinitions.class;
		if (SHEETFED.equals(propertyName)) return PressDefinitions.class;
		if (ROLLTOROLL.equals(propertyName)) return PressDefinitions.class;
		if (INTEGRATEDDEVICE.equals(propertyName)) return PressDefinitions.class;
		if (MAXPAPERSIZE.equals(propertyName)) return PressDefinitions.class;
		if (MINPAPERSIZE.equals(propertyName)) return PressDefinitions.class;
		if (LABORRATE.equals(propertyName)) return PressDefinitions.class;
		if (LABORMARKUP.equals(propertyName)) return PressDefinitions.class;
		if (FIXEDWASTE.equals(propertyName)) return PressDefinitions.class;
		if (MINLABOR.equals(propertyName)) return PressDefinitions.class;
		if (SETUPMIN.equals(propertyName)) return PressDefinitions.class;
		if (SETUPADDSIG.equals(propertyName)) return PressDefinitions.class;
		if (WORKTURNSETUP.equals(propertyName)) return PressDefinitions.class;
		if (SETUPADDHEAD.equals(propertyName)) return PressDefinitions.class;
		if (WASHUPFEE.equals(propertyName)) return PressDefinitions.class;
		if (ADDSIGADDHEAD.equals(propertyName)) return PressDefinitions.class;
		if (WASHUPMIN.equals(propertyName)) return PressDefinitions.class;
		if (WASHUPPERFOUNTAIN.equals(propertyName)) return PressDefinitions.class;
		if (GRIPEDGE.equals(propertyName)) return PressDefinitions.class;
		if (PERFECTOR.equals(propertyName)) return PressDefinitions.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PressDefinitions objT = (PressDefinitions)obj;
		if (! SmartEquals(getPressDefID(), objT.getPressDefID()))
			return false;
		if (! SmartEquals(getPressDefName(), objT.getPressDefName()))
			return false;
		if (! SmartEquals(getMachineName(), objT.getMachineName()))
			return false;
		if (! SmartEquals(getOutputDescrip(), objT.getOutputDescrip()))
			return false;
		if (! SmartEquals(getProductionLocation(), objT.getProductionLocation()))
			return false;
		if (! SmartEquals(getCostCenter(), objT.getCostCenter()))
			return false;
		if (! SmartEquals(getOEMDeiveID(), objT.getOEMDeiveID()))
			return false;
		if (! SmartEquals(getMachineID(), objT.getMachineID()))
			return false;
		if (! SmartEquals(getCostingPress(), objT.getCostingPress()))
			return false;
		if (! SmartEquals(getSheetFed(), objT.getSheetFed()))
			return false;
		if (! SmartEquals(getRolltoRoll(), objT.getRolltoRoll()))
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
		return true;
	}			
}