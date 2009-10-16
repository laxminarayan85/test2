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
	@NamedQuery(name = "Job.findall", query = "from Job"),
	@NamedQuery(name = "Job.byId", query = "select a from Job a where a.id= :id")
})


@Entity
@Table(name = "job")
public class Job extends ModelBase {
	/**
	 * @generated
	 */
	public static final String JOBNUMBER = "JobNumber";
	/**
	 * @generated
	 */
	public static final String JOBINDEX = "JobIndex";
	/**
	 * @generated
	 */
	public static final String SALESCATEGORY = "SalesCategory";
	/**
	 * @generated
	 */
	public static final String PRODUCTCODE = "ProductCode";
	/**
	 * @generated
	 */
	public static final String CHILDREN = "Children";
	/**
	 * @generated
	 */
	public static final String CHARGES = "Charges";
	/**
	 * @generated
	 */
	public static final String JOBNOTES = "JobNotes";
	/**
	 * @generated
	 */
	public static final String JOBTICKETNOTES = "JobTicketNotes";
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
	public static final String FINISHED = "Finished";
	/**
	 * @generated
	 */
	public static final String LOCATION = "Location";
	/**
	 * @generated
	 */
	public static final String COMMENT = "Comment";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String QTYORDERED = "QtyOrdered";
	/**
	 * @generated
	 */
	public static final String OVERSUNDERS = "OversUnders";
	/**
	 * @generated
	 */
	public static final String INSETSOF = "InSetsOf";
	/**
	 * @generated
	 */
	public static final String SHEETS = "Sheets";
	/**
	 * @generated
	 */
	public static final String UP = "Up";
	/**
	 * @generated
	 */
	public static final String ON = "On";
	/**
	 * @generated
	 */
	public static final String PRESS = "Press";
	/**
	 * @generated
	 */
	public static final String BINDERYWASTE = "BinderyWaste";
	/**
	 * @generated
	 */
	public static final String ESTWASTE = "EstWaste";
	/**
	 * @generated
	 */
	public static final String SIGNATURES = "Signatures";
	/**
	 * @generated
	 */
	public static final String PRICINGPRESS = "PricingPress";
	/**
	 * @generated
	 */
	public static final String COSTINGPRESS = "CostingPress";
	/**
	 * @generated
	 */
	public static final String RUNMETHOD = "RunMethod";

	/**
	 * @generated
	 */
	public Job() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String jobNumber;
	/**
	 * @generated
 	 */
	public String getJobNumber(){
		return jobNumber; 
	}

	/**
	 * @generated
	 */	
	public void setJobNumber(String newVal) {
		this.jobNumber = newVal;
	}
 	
	
 	@Basic
	private Long jobIndex;
	/**
	 * @generated
 	 */
	public Long getJobIndex(){
		return jobIndex; 
	}

	/**
	 * @generated
	 */	
	public void setJobIndex(Long newVal) {
		this.jobIndex = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Job> children;
	/**
	 * @generated
 	 */
	public java.util.List<Job> getChildren(){
		return children; 
	}

	public void addChildren(Job obj) {
		if (children == null) {
			children = new java.util.ArrayList<Job>();
		}
		children.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<Job> newVal) {
		this.children = newVal;
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
	private String jobNotes;
	/**
	 * @generated
 	 */
	public String getJobNotes(){
		return jobNotes; 
	}

	/**
	 * @generated
	 */	
	public void setJobNotes(String newVal) {
		this.jobNotes = newVal;
	}
 	
	
 	@Basic
	private String jobTicketNotes;
	/**
	 * @generated
 	 */
	public String getJobTicketNotes(){
		return jobTicketNotes; 
	}

	/**
	 * @generated
	 */	
	public void setJobTicketNotes(String newVal) {
		this.jobTicketNotes = newVal;
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
 	
	
 	@Basic
	private String comment;
	/**
	 * @generated
 	 */
	public String getComment(){
		return comment; 
	}

	/**
	 * @generated
	 */	
	public void setComment(String newVal) {
		this.comment = newVal;
	}
 	
	
 	@Basic
	private String description;
	/**
	 * @generated
 	 */
	public String getDescription(){
		return description; 
	}

	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
		this.description = newVal;
	}
 	
	
 	@Basic
	private Long qtyOrdered;
	/**
	 * @generated
 	 */
	public Long getQtyOrdered(){
		return qtyOrdered; 
	}

	/**
	 * @generated
	 */	
	public void setQtyOrdered(Long newVal) {
		this.qtyOrdered = newVal;
	}
 	
	
 	@Basic
	private Long oversUnders;
	/**
	 * @generated
 	 */
	public Long getOversUnders(){
		return oversUnders; 
	}

	/**
	 * @generated
	 */	
	public void setOversUnders(Long newVal) {
		this.oversUnders = newVal;
	}
 	
	
 	@Basic
	private Long inSetsOf;
	/**
	 * @generated
 	 */
	public Long getInSetsOf(){
		return inSetsOf; 
	}

	/**
	 * @generated
	 */	
	public void setInSetsOf(Long newVal) {
		this.inSetsOf = newVal;
	}
 	
	
 	@Basic
	private Long sheets;
	/**
	 * @generated
 	 */
	public Long getSheets(){
		return sheets; 
	}

	/**
	 * @generated
	 */	
	public void setSheets(Long newVal) {
		this.sheets = newVal;
	}
 	
	
 	@Basic
	private Long up;
	/**
	 * @generated
 	 */
	public Long getUp(){
		return up; 
	}

	/**
	 * @generated
	 */	
	public void setUp(Long newVal) {
		this.up = newVal;
	}
 	
	
 	@Basic
	private Long on;
	/**
	 * @generated
 	 */
	public Long getOn(){
		return on; 
	}

	/**
	 * @generated
	 */	
	public void setOn(Long newVal) {
		this.on = newVal;
	}
 	
	
 	@Basic
	private Long press;
	/**
	 * @generated
 	 */
	public Long getPress(){
		return press; 
	}

	/**
	 * @generated
	 */	
	public void setPress(Long newVal) {
		this.press = newVal;
	}
 	
	
 	@Basic
	private Long binderyWaste;
	/**
	 * @generated
 	 */
	public Long getBinderyWaste(){
		return binderyWaste; 
	}

	/**
	 * @generated
	 */	
	public void setBinderyWaste(Long newVal) {
		this.binderyWaste = newVal;
	}
 	
	
 	@Basic
	private Long estWaste;
	/**
	 * @generated
 	 */
	public Long getEstWaste(){
		return estWaste; 
	}

	/**
	 * @generated
	 */	
	public void setEstWaste(Long newVal) {
		this.estWaste = newVal;
	}
 	
	
 	@Basic
	private Long signatures;
	/**
	 * @generated
 	 */
	public Long getSignatures(){
		return signatures; 
	}

	/**
	 * @generated
	 */	
	public void setSignatures(Long newVal) {
		this.signatures = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PressDefinition pricingPress;
	/**
	 * @generated
 	 */
	public PressDefinition getPricingPress(){
		return pricingPress; 
	}

	/**
	 * @generated
	 */	
	public void setPricingPress(PressDefinition newVal) {
		this.pricingPress = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PressDefinition costingPress;
	/**
	 * @generated
 	 */
	public PressDefinition getCostingPress(){
		return costingPress; 
	}

	/**
	 * @generated
	 */	
	public void setCostingPress(PressDefinition newVal) {
		this.costingPress = newVal;
	}
 	
	
 	@Basic
	private String runMethod;
	/**
	 * @generated
 	 */
	public String getRunMethod(){
		return runMethod; 
	}

	/**
	 * @generated
	 */	
	public void setRunMethod(String newVal) {
		this.runMethod = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (JOBNUMBER.equals(propertyName)) return getJobNumber();
		if (JOBINDEX.equals(propertyName)) return getJobIndex();
		if (SALESCATEGORY.equals(propertyName)) return getSalesCategory();
		if (PRODUCTCODE.equals(propertyName)) return getProductCode();
		if (CHILDREN.equals(propertyName)) return getChildren();
		if (CHARGES.equals(propertyName)) return getCharges();
		if (JOBNOTES.equals(propertyName)) return getJobNotes();
		if (JOBTICKETNOTES.equals(propertyName)) return getJobTicketNotes();
		if (BROKERED.equals(propertyName)) return getBrokered();
		if (TAXABLE.equals(propertyName)) return getTaxable();
		if (FINISHED.equals(propertyName)) return getFinished();
		if (LOCATION.equals(propertyName)) return getLocation();
		if (COMMENT.equals(propertyName)) return getComment();
		if (DESCRIPTION.equals(propertyName)) return getDescription();
		if (QTYORDERED.equals(propertyName)) return getQtyOrdered();
		if (OVERSUNDERS.equals(propertyName)) return getOversUnders();
		if (INSETSOF.equals(propertyName)) return getInSetsOf();
		if (SHEETS.equals(propertyName)) return getSheets();
		if (UP.equals(propertyName)) return getUp();
		if (ON.equals(propertyName)) return getOn();
		if (PRESS.equals(propertyName)) return getPress();
		if (BINDERYWASTE.equals(propertyName)) return getBinderyWaste();
		if (ESTWASTE.equals(propertyName)) return getEstWaste();
		if (SIGNATURES.equals(propertyName)) return getSignatures();
		if (PRICINGPRESS.equals(propertyName)) return getPricingPress();
		if (COSTINGPRESS.equals(propertyName)) return getCostingPress();
		if (RUNMETHOD.equals(propertyName)) return getRunMethod();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (JOBNUMBER.equals(propertyName)) setJobNumber((String)newValue); else
		if (JOBINDEX.equals(propertyName)) setJobIndex((Long)newValue); else
		if (SALESCATEGORY.equals(propertyName)) setSalesCategory((SalesCategory)newValue); else
		if (PRODUCTCODE.equals(propertyName)) setProductCode((ProductCode)newValue); else
		if (CHILDREN.equals(propertyName)) setChildren((java.util.List<Job>)newValue); else
		if (CHARGES.equals(propertyName)) setCharges((java.util.List<Charge>)newValue); else
		if (JOBNOTES.equals(propertyName)) setJobNotes((String)newValue); else
		if (JOBTICKETNOTES.equals(propertyName)) setJobTicketNotes((String)newValue); else
		if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else
		if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
		if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else
		if (LOCATION.equals(propertyName)) setLocation((Location)newValue); else
		if (COMMENT.equals(propertyName)) setComment((String)newValue); else
		if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
		if (QTYORDERED.equals(propertyName)) setQtyOrdered((Long)newValue); else
		if (OVERSUNDERS.equals(propertyName)) setOversUnders((Long)newValue); else
		if (INSETSOF.equals(propertyName)) setInSetsOf((Long)newValue); else
		if (SHEETS.equals(propertyName)) setSheets((Long)newValue); else
		if (UP.equals(propertyName)) setUp((Long)newValue); else
		if (ON.equals(propertyName)) setOn((Long)newValue); else
		if (PRESS.equals(propertyName)) setPress((Long)newValue); else
		if (BINDERYWASTE.equals(propertyName)) setBinderyWaste((Long)newValue); else
		if (ESTWASTE.equals(propertyName)) setEstWaste((Long)newValue); else
		if (SIGNATURES.equals(propertyName)) setSignatures((Long)newValue); else
		if (PRICINGPRESS.equals(propertyName)) setPricingPress((PressDefinition)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((PressDefinition)newValue); else
		if (RUNMETHOD.equals(propertyName)) setRunMethod((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (JOBNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (JOBINDEX.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SALESCATEGORY.equals(propertyName)) 
			return new Class<?>[] {SalesCategory.class};		
		if (PRODUCTCODE.equals(propertyName)) 
			return new Class<?>[] {ProductCode.class};		
		if (CHILDREN.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Job.class};		
		if (CHARGES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, Charge.class};		
		if (JOBNOTES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (JOBTICKETNOTES.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (BROKERED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (TAXABLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FINISHED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LOCATION.equals(propertyName)) 
			return new Class<?>[] {Location.class};		
		if (COMMENT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DESCRIPTION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (QTYORDERED.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (OVERSUNDERS.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (INSETSOF.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHEETS.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (UP.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ON.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PRESS.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (BINDERYWASTE.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ESTWASTE.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SIGNATURES.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PRICINGPRESS.equals(propertyName)) 
			return new Class<?>[] {PressDefinition.class};		
		if (COSTINGPRESS.equals(propertyName)) 
			return new Class<?>[] {PressDefinition.class};		
		if (RUNMETHOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (JOBNUMBER.equals(propertyName)) return Job.class;
		if (JOBINDEX.equals(propertyName)) return Job.class;
		if (SALESCATEGORY.equals(propertyName)) return Job.class;
		if (PRODUCTCODE.equals(propertyName)) return Job.class;
		if (CHILDREN.equals(propertyName)) return Job.class;
		if (CHARGES.equals(propertyName)) return Job.class;
		if (JOBNOTES.equals(propertyName)) return Job.class;
		if (JOBTICKETNOTES.equals(propertyName)) return Job.class;
		if (BROKERED.equals(propertyName)) return Job.class;
		if (TAXABLE.equals(propertyName)) return Job.class;
		if (FINISHED.equals(propertyName)) return Job.class;
		if (LOCATION.equals(propertyName)) return Job.class;
		if (COMMENT.equals(propertyName)) return Job.class;
		if (DESCRIPTION.equals(propertyName)) return Job.class;
		if (QTYORDERED.equals(propertyName)) return Job.class;
		if (OVERSUNDERS.equals(propertyName)) return Job.class;
		if (INSETSOF.equals(propertyName)) return Job.class;
		if (SHEETS.equals(propertyName)) return Job.class;
		if (UP.equals(propertyName)) return Job.class;
		if (ON.equals(propertyName)) return Job.class;
		if (PRESS.equals(propertyName)) return Job.class;
		if (BINDERYWASTE.equals(propertyName)) return Job.class;
		if (ESTWASTE.equals(propertyName)) return Job.class;
		if (SIGNATURES.equals(propertyName)) return Job.class;
		if (PRICINGPRESS.equals(propertyName)) return Job.class;
		if (COSTINGPRESS.equals(propertyName)) return Job.class;
		if (RUNMETHOD.equals(propertyName)) return Job.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Job objT = (Job)obj;
		if (! SmartEquals(getJobNumber(), objT.getJobNumber()))
			return false;
		if (! SmartEquals(getJobIndex(), objT.getJobIndex()))
			return false;
		if (! SmartEquals(getSalesCategory(), objT.getSalesCategory()))
			return false;
		if (! SmartEquals(getProductCode(), objT.getProductCode()))
			return false;
		if (! SmartEquals(getChildren(), objT.getChildren()))
			return false;
		if (! SmartEquals(getCharges(), objT.getCharges()))
			return false;
		if (! SmartEquals(getJobNotes(), objT.getJobNotes()))
			return false;
		if (! SmartEquals(getJobTicketNotes(), objT.getJobTicketNotes()))
			return false;
		if (! SmartEquals(getBrokered(), objT.getBrokered()))
			return false;
		if (! SmartEquals(getTaxable(), objT.getTaxable()))
			return false;
		if (! SmartEquals(getFinished(), objT.getFinished()))
			return false;
		if (! SmartEquals(getLocation(), objT.getLocation()))
			return false;
		if (! SmartEquals(getComment(), objT.getComment()))
			return false;
		if (! SmartEquals(getDescription(), objT.getDescription()))
			return false;
		if (! SmartEquals(getQtyOrdered(), objT.getQtyOrdered()))
			return false;
		if (! SmartEquals(getOversUnders(), objT.getOversUnders()))
			return false;
		if (! SmartEquals(getInSetsOf(), objT.getInSetsOf()))
			return false;
		if (! SmartEquals(getSheets(), objT.getSheets()))
			return false;
		if (! SmartEquals(getUp(), objT.getUp()))
			return false;
		if (! SmartEquals(getOn(), objT.getOn()))
			return false;
		if (! SmartEquals(getPress(), objT.getPress()))
			return false;
		if (! SmartEquals(getBinderyWaste(), objT.getBinderyWaste()))
			return false;
		if (! SmartEquals(getEstWaste(), objT.getEstWaste()))
			return false;
		if (! SmartEquals(getSignatures(), objT.getSignatures()))
			return false;
		if (! SmartEquals(getPricingPress(), objT.getPricingPress()))
			return false;
		if (! SmartEquals(getCostingPress(), objT.getCostingPress()))
			return false;
		if (! SmartEquals(getRunMethod(), objT.getRunMethod()))
			return false;
		return true;
	}			
}