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
	@NamedQuery(name = "CostCenter.findall", query = "from CostCenter"),
	@NamedQuery(name = "CostCenter.byId", query = "select a from CostCenter a where a.id= :id")
})


@Entity
@Table(name = "costcenter")
public class CostCenter extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String CODE = "Code";
	/**
	 * @generated
	 */
	public static final String DEVICEID = "DeviceId";
	/**
	 * @generated
	 */
	public static final String MINMINUTESPERJOB = "MinMinutesPerJob";
	/**
	 * @generated
	 */
	public static final String DEPARTMENT = "Department";
	/**
	 * @generated
	 */
	public static final String IMAGEFILE = "ImageFile";
	/**
	 * @generated
	 */
	public static final String PROCESSSTAGE = "ProcessStage";
	/**
	 * @generated
	 */
	public static final String PROCESSSTAGETYPE = "ProcessStageType";
	/**
	 * @generated
	 */
	public static final String DELAYMINBEFORE = "DelayMinBefore";
	/**
	 * @generated
	 */
	public static final String DELAYMINAFTER = "DelayMinAfter";
	/**
	 * @generated
	 */
	public static final String DELAYMINBEFORESEQTAG = "DelayMinBeforeSeqTag";
	/**
	 * @generated
	 */
	public static final String DELAYMINAFTERSEQTAG = "DelayMinAfterSeqTag";
	/**
	 * @generated
	 */
	public static final String LOCATIONXREF = "LocationXRef";
	/**
	 * @generated
	 */
	public static final String MARKINVREADYPICKUP = "MarkInvReadyPickup";
	/**
	 * @generated
	 */
	public static final String TREATASNONPROD = "TreatAsNonProd";
	/**
	 * @generated
	 */
	public static final String COMPLETIONCATEGORY = "CompletionCategory";

	/**
	 * @generated
	 */
	public CostCenter() {
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
	private String code;
	/**
	 * @generated
 	 */
	public String getCode(){
		return code; 
	}

	/**
	 * @generated
	 */	
	public void setCode(String newVal) {
		this.code = newVal;
	}
 	
	
 	@Basic
	private String deviceId;
	/**
	 * @generated
 	 */
	public String getDeviceId(){
		return deviceId; 
	}

	/**
	 * @generated
	 */	
	public void setDeviceId(String newVal) {
		this.deviceId = newVal;
	}
 	
	
 	@Basic
	private Integer minMinutesPerJob;
	/**
	 * @generated
 	 */
	public Integer getMinMinutesPerJob(){
		return minMinutesPerJob; 
	}

	/**
	 * @generated
	 */	
	public void setMinMinutesPerJob(Integer newVal) {
		this.minMinutesPerJob = newVal;
	}
 	
	
 	@Basic
	private String department;
	/**
	 * @generated
 	 */
	public String getDepartment(){
		return department; 
	}

	/**
	 * @generated
	 */	
	public void setDepartment(String newVal) {
		this.department = newVal;
	}
 	
	
 	@Basic
	private String imageFile;
	/**
	 * @generated
 	 */
	public String getImageFile(){
		return imageFile; 
	}

	/**
	 * @generated
	 */	
	public void setImageFile(String newVal) {
		this.imageFile = newVal;
	}
 	
	
 	@Basic
	private Integer processStage;
	/**
	 * @generated
 	 */
	public Integer getProcessStage(){
		return processStage; 
	}

	/**
	 * @generated
	 */	
	public void setProcessStage(Integer newVal) {
		this.processStage = newVal;
	}
 	
	
 	@Basic
	private String processStageType;
	/**
	 * @generated
 	 */
	public String getProcessStageType(){
		return processStageType; 
	}

	/**
	 * @generated
	 */	
	public void setProcessStageType(String newVal) {
		this.processStageType = newVal;
	}
 	
	
 	@Basic
	private Integer delayMinBefore;
	/**
	 * @generated
 	 */
	public Integer getDelayMinBefore(){
		return delayMinBefore; 
	}

	/**
	 * @generated
	 */	
	public void setDelayMinBefore(Integer newVal) {
		this.delayMinBefore = newVal;
	}
 	
	
 	@Basic
	private Integer delayMinAfter;
	/**
	 * @generated
 	 */
	public Integer getDelayMinAfter(){
		return delayMinAfter; 
	}

	/**
	 * @generated
	 */	
	public void setDelayMinAfter(Integer newVal) {
		this.delayMinAfter = newVal;
	}
 	
	
 	@Basic
	private Integer delayMinBeforeSeqTag;
	/**
	 * @generated
 	 */
	public Integer getDelayMinBeforeSeqTag(){
		return delayMinBeforeSeqTag; 
	}

	/**
	 * @generated
	 */	
	public void setDelayMinBeforeSeqTag(Integer newVal) {
		this.delayMinBeforeSeqTag = newVal;
	}
 	
	
 	@Basic
	private Integer delayMinAfterSeqTag;
	/**
	 * @generated
 	 */
	public Integer getDelayMinAfterSeqTag(){
		return delayMinAfterSeqTag; 
	}

	/**
	 * @generated
	 */	
	public void setDelayMinAfterSeqTag(Integer newVal) {
		this.delayMinAfterSeqTag = newVal;
	}
 	
	
 	@Basic
	private String locationXRef;
	/**
	 * @generated
 	 */
	public String getLocationXRef(){
		return locationXRef; 
	}

	/**
	 * @generated
	 */	
	public void setLocationXRef(String newVal) {
		this.locationXRef = newVal;
	}
 	
	
 	@Basic
	private Boolean markInvReadyPickup;
	/**
	 * @generated
 	 */
	public Boolean getMarkInvReadyPickup(){
		return markInvReadyPickup; 
	}

	/**
	 * @generated
	 */	
	public void setMarkInvReadyPickup(Boolean newVal) {
		this.markInvReadyPickup = newVal;
	}
 	
	
 	@Basic
	private Boolean treatAsNonProd;
	/**
	 * @generated
 	 */
	public Boolean getTreatAsNonProd(){
		return treatAsNonProd; 
	}

	/**
	 * @generated
	 */	
	public void setTreatAsNonProd(Boolean newVal) {
		this.treatAsNonProd = newVal;
	}
 	
	
 	@Basic
	private String completionCategory;
	/**
	 * @generated
 	 */
	public String getCompletionCategory(){
		return completionCategory; 
	}

	/**
	 * @generated
	 */	
	public void setCompletionCategory(String newVal) {
		this.completionCategory = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (NAME.equals(propertyName)) return getName();
		if (CODE.equals(propertyName)) return getCode();
		if (DEVICEID.equals(propertyName)) return getDeviceId();
		if (MINMINUTESPERJOB.equals(propertyName)) return getMinMinutesPerJob();
		if (DEPARTMENT.equals(propertyName)) return getDepartment();
		if (IMAGEFILE.equals(propertyName)) return getImageFile();
		if (PROCESSSTAGE.equals(propertyName)) return getProcessStage();
		if (PROCESSSTAGETYPE.equals(propertyName)) return getProcessStageType();
		if (DELAYMINBEFORE.equals(propertyName)) return getDelayMinBefore();
		if (DELAYMINAFTER.equals(propertyName)) return getDelayMinAfter();
		if (DELAYMINBEFORESEQTAG.equals(propertyName)) return getDelayMinBeforeSeqTag();
		if (DELAYMINAFTERSEQTAG.equals(propertyName)) return getDelayMinAfterSeqTag();
		if (LOCATIONXREF.equals(propertyName)) return getLocationXRef();
		if (MARKINVREADYPICKUP.equals(propertyName)) return getMarkInvReadyPickup();
		if (TREATASNONPROD.equals(propertyName)) return getTreatAsNonProd();
		if (COMPLETIONCATEGORY.equals(propertyName)) return getCompletionCategory();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (CODE.equals(propertyName)) setCode((String)newValue); else
		if (DEVICEID.equals(propertyName)) setDeviceId((String)newValue); else
		if (MINMINUTESPERJOB.equals(propertyName)) setMinMinutesPerJob((Integer)newValue); else
		if (DEPARTMENT.equals(propertyName)) setDepartment((String)newValue); else
		if (IMAGEFILE.equals(propertyName)) setImageFile((String)newValue); else
		if (PROCESSSTAGE.equals(propertyName)) setProcessStage((Integer)newValue); else
		if (PROCESSSTAGETYPE.equals(propertyName)) setProcessStageType((String)newValue); else
		if (DELAYMINBEFORE.equals(propertyName)) setDelayMinBefore((Integer)newValue); else
		if (DELAYMINAFTER.equals(propertyName)) setDelayMinAfter((Integer)newValue); else
		if (DELAYMINBEFORESEQTAG.equals(propertyName)) setDelayMinBeforeSeqTag((Integer)newValue); else
		if (DELAYMINAFTERSEQTAG.equals(propertyName)) setDelayMinAfterSeqTag((Integer)newValue); else
		if (LOCATIONXREF.equals(propertyName)) setLocationXRef((String)newValue); else
		if (MARKINVREADYPICKUP.equals(propertyName)) setMarkInvReadyPickup((Boolean)newValue); else
		if (TREATASNONPROD.equals(propertyName)) setTreatAsNonProd((Boolean)newValue); else
		if (COMPLETIONCATEGORY.equals(propertyName)) setCompletionCategory((String)newValue); else
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
		if (CODE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DEVICEID.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MINMINUTESPERJOB.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DEPARTMENT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (IMAGEFILE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PROCESSSTAGE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PROCESSSTAGETYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DELAYMINBEFORE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DELAYMINAFTER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DELAYMINBEFORESEQTAG.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (DELAYMINAFTERSEQTAG.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (LOCATIONXREF.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MARKINVREADYPICKUP.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TREATASNONPROD.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (COMPLETIONCATEGORY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (NAME.equals(propertyName)) return CostCenter.class;
		if (CODE.equals(propertyName)) return CostCenter.class;
		if (DEVICEID.equals(propertyName)) return CostCenter.class;
		if (MINMINUTESPERJOB.equals(propertyName)) return CostCenter.class;
		if (DEPARTMENT.equals(propertyName)) return CostCenter.class;
		if (IMAGEFILE.equals(propertyName)) return CostCenter.class;
		if (PROCESSSTAGE.equals(propertyName)) return CostCenter.class;
		if (PROCESSSTAGETYPE.equals(propertyName)) return CostCenter.class;
		if (DELAYMINBEFORE.equals(propertyName)) return CostCenter.class;
		if (DELAYMINAFTER.equals(propertyName)) return CostCenter.class;
		if (DELAYMINBEFORESEQTAG.equals(propertyName)) return CostCenter.class;
		if (DELAYMINAFTERSEQTAG.equals(propertyName)) return CostCenter.class;
		if (LOCATIONXREF.equals(propertyName)) return CostCenter.class;
		if (MARKINVREADYPICKUP.equals(propertyName)) return CostCenter.class;
		if (TREATASNONPROD.equals(propertyName)) return CostCenter.class;
		if (COMPLETIONCATEGORY.equals(propertyName)) return CostCenter.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		CostCenter objT = (CostCenter)obj;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getCode(), objT.getCode()))
			return false;
		if (! SmartEquals(getDeviceId(), objT.getDeviceId()))
			return false;
		if (! SmartEquals(getMinMinutesPerJob(), objT.getMinMinutesPerJob()))
			return false;
		if (! SmartEquals(getDepartment(), objT.getDepartment()))
			return false;
		if (! SmartEquals(getImageFile(), objT.getImageFile()))
			return false;
		if (! SmartEquals(getProcessStage(), objT.getProcessStage()))
			return false;
		if (! SmartEquals(getProcessStageType(), objT.getProcessStageType()))
			return false;
		if (! SmartEquals(getDelayMinBefore(), objT.getDelayMinBefore()))
			return false;
		if (! SmartEquals(getDelayMinAfter(), objT.getDelayMinAfter()))
			return false;
		if (! SmartEquals(getDelayMinBeforeSeqTag(), objT.getDelayMinBeforeSeqTag()))
			return false;
		if (! SmartEquals(getDelayMinAfterSeqTag(), objT.getDelayMinAfterSeqTag()))
			return false;
		if (! SmartEquals(getLocationXRef(), objT.getLocationXRef()))
			return false;
		if (! SmartEquals(getMarkInvReadyPickup(), objT.getMarkInvReadyPickup()))
			return false;
		if (! SmartEquals(getTreatAsNonProd(), objT.getTreatAsNonProd()))
			return false;
		if (! SmartEquals(getCompletionCategory(), objT.getCompletionCategory()))
			return false;
		return true;
	}			
}