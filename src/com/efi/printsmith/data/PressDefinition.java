package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

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
	@NamedQuery(name = "PressDefinition.findall", query = "from PressDefinition"),
	@NamedQuery(name = "PressDefinition.byId", query = "select a from PressDefinition a where a.id= :id")
})


@Entity
@Table(name = "pressdefinition")
public class PressDefinition extends ModelBase {
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
	public static final String OEMDEVICEID = "OEMDeviceID";
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
	public PressDefinition() {
	}

 	
	
 	@Basic
	private Long pressDefID;
	/**
	 * @generated
 	 */
	public Long getPressDefID(){
		return pressDefID; 
	}

	/**
	 * @generated
	 */	
	public void setPressDefID(Long newVal) {
		this.pressDefID = newVal;
	}
 	
	
 	@Basic
	private String pressDefName;
	/**
	 * @generated
 	 */
	public String getPressDefName(){
		return pressDefName; 
	}

	/**
	 * @generated
	 */	
	public void setPressDefName(String newVal) {
		this.pressDefName = newVal;
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
	private String oEMDeviceID;
	/**
	 * @generated
 	 */
	public String getOEMDeviceID(){
		return oEMDeviceID; 
	}

	/**
	 * @generated
	 */	
	public void setOEMDeviceID(String newVal) {
		this.oEMDeviceID = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean rolltoRoll;
	/**
	 * @generated
 	 */
	public Boolean getRolltoRoll(){
		return rolltoRoll; 
	}

	/**
	 * @generated
	 */	
	public void setRolltoRoll(Boolean newVal) {
		this.rolltoRoll = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (PRESSDEFID.equals(propertyName)) return getPressDefID();
		if (PRESSDEFNAME.equals(propertyName)) return getPressDefName();
		if (MACHINENAME.equals(propertyName)) return getMachineName();
		if (OUTPUTDESCRIP.equals(propertyName)) return getOutputDescrip();
		if (PRODUCTIONLOCATION.equals(propertyName)) return getProductionLocation();
		if (COSTCENTER.equals(propertyName)) return getCostCenter();
		if (OEMDEVICEID.equals(propertyName)) return getOEMDeviceID();
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
		if (PRESSDEFID.equals(propertyName)) setPressDefID((Long)newValue); else
		if (PRESSDEFNAME.equals(propertyName)) setPressDefName((String)newValue); else
		if (MACHINENAME.equals(propertyName)) setMachineName((String)newValue); else
		if (OUTPUTDESCRIP.equals(propertyName)) setOutputDescrip((String)newValue); else
		if (PRODUCTIONLOCATION.equals(propertyName)) setProductionLocation((String)newValue); else
		if (COSTCENTER.equals(propertyName)) setCostCenter((String)newValue); else
		if (OEMDEVICEID.equals(propertyName)) setOEMDeviceID((String)newValue); else
		if (MACHINEID.equals(propertyName)) setMachineID((Long)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((Boolean)newValue); else
		if (SHEETFED.equals(propertyName)) setSheetFed((Boolean)newValue); else
		if (ROLLTOROLL.equals(propertyName)) setRolltoRoll((Boolean)newValue); else
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
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (PRESSDEFID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
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
		if (OEMDEVICEID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MACHINEID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COSTINGPRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHEETFED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ROLLTOROLL.equals(propertyName)) 
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
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (PRESSDEFID.equals(propertyName)) return PressDefinition.class;
		if (PRESSDEFNAME.equals(propertyName)) return PressDefinition.class;
		if (MACHINENAME.equals(propertyName)) return PressDefinition.class;
		if (OUTPUTDESCRIP.equals(propertyName)) return PressDefinition.class;
		if (PRODUCTIONLOCATION.equals(propertyName)) return PressDefinition.class;
		if (COSTCENTER.equals(propertyName)) return PressDefinition.class;
		if (OEMDEVICEID.equals(propertyName)) return PressDefinition.class;
		if (MACHINEID.equals(propertyName)) return PressDefinition.class;
		if (COSTINGPRESS.equals(propertyName)) return PressDefinition.class;
		if (SHEETFED.equals(propertyName)) return PressDefinition.class;
		if (ROLLTOROLL.equals(propertyName)) return PressDefinition.class;
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
		if (! SmartEquals(getOEMDeviceID(), objT.getOEMDeviceID()))
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