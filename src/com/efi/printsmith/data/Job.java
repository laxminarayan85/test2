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
	public static final String NUMUP = "NumUp";
	/**
	 * @generated
	 */
	public static final String NUMON = "NumOn";
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
	public static final String STOCK = "Stock";
	/**
	 * @generated
	 */
	public static final String PARENTSIZE = "ParentSize";
	/**
	 * @generated
	 */
	public static final String RUNSIZE = "RunSize";
	/**
	 * @generated
	 */
	public static final String FINISHSIZE = "FinishSize";
	/**
	 * @generated
	 */
	public static final String ATTRIBUTE1 = "Attribute1";
	/**
	 * @generated
	 */
	public static final String FOLDEDSIZE = "FoldedSize";
	/**
	 * @generated
	 */
	public static final String FRONTCOLORS = "FrontColors";
	/**
	 * @generated
	 */
	public static final String BACKCOLORS = "BackColors";
	/**
	 * @generated
	 */
	public static final String FRONTPASSES = "FrontPasses";
	/**
	 * @generated
	 */
	public static final String BACKPASSES = "BackPasses";
	/**
	 * @generated
	 */
	public static final String FRONTWASHES = "FrontWashes";
	/**
	 * @generated
	 */
	public static final String BACKWASHES = "BackWashes";
	/**
	 * @generated
	 */
	public static final String FRONTINKS = "FrontInks";
	/**
	 * @generated
	 */
	public static final String BACKINKS = "BackInks";

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
	private Boolean jobTicketNotes;
	/**
	 * @generated
 	 */
	public Boolean getJobTicketNotes(){
		return jobTicketNotes; 
	}

	/**
	 * @generated
	 */	
	public void setJobTicketNotes(Boolean newVal) {
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
	private Long numUp;
	/**
	 * @generated
 	 */
	public Long getNumUp(){
		return numUp; 
	}

	/**
	 * @generated
	 */	
	public void setNumUp(Long newVal) {
		this.numUp = newVal;
	}
 	
	
 	@Basic
	private Long numOn;
	/**
	 * @generated
 	 */
	public Long getNumOn(){
		return numOn; 
	}

	/**
	 * @generated
	 */	
	public void setNumOn(Long newVal) {
		this.numOn = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PressDefinition press;
	/**
	 * @generated
 	 */
	public PressDefinition getPress(){
		return press; 
	}

	/**
	 * @generated
	 */	
	public void setPress(PressDefinition newVal) {
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private StockDefinition stock;
	/**
	 * @generated
 	 */
	public StockDefinition getStock(){
		return stock; 
	}

	/**
	 * @generated
	 */	
	public void setStock(StockDefinition newVal) {
		this.stock = newVal;
	}
 	
	
 	@Basic
	private String parentSize;
	/**
	 * @generated
 	 */
	public String getParentSize(){
		return parentSize; 
	}

	/**
	 * @generated
	 */	
	public void setParentSize(String newVal) {
		this.parentSize = newVal;
	}
 	
	
 	@Basic
	private String runSize;
	/**
	 * @generated
 	 */
	public String getRunSize(){
		return runSize; 
	}

	/**
	 * @generated
	 */	
	public void setRunSize(String newVal) {
		this.runSize = newVal;
	}
 	
	
 	@Basic
	private String finishSize;
	/**
	 * @generated
 	 */
	public String getFinishSize(){
		return finishSize; 
	}

	/**
	 * @generated
	 */	
	public void setFinishSize(String newVal) {
		this.finishSize = newVal;
	}
 	
	
 	@Basic
	private Integer attribute1;
	/**
	 * @generated
 	 */
	public Integer getAttribute1(){
		return attribute1; 
	}

	/**
	 * @generated
	 */	
	public void setAttribute1(Integer newVal) {
		this.attribute1 = newVal;
	}
 	
	
 	@Basic
	private String foldedSize;
	/**
	 * @generated
 	 */
	public String getFoldedSize(){
		return foldedSize; 
	}

	/**
	 * @generated
	 */	
	public void setFoldedSize(String newVal) {
		this.foldedSize = newVal;
	}
 	
	
 	@Basic
	private Integer frontColors;
	/**
	 * @generated
 	 */
	public Integer getFrontColors(){
		return frontColors; 
	}

	/**
	 * @generated
	 */	
	public void setFrontColors(Integer newVal) {
		this.frontColors = newVal;
	}
 	
	
 	@Basic
	private Integer backColors;
	/**
	 * @generated
 	 */
	public Integer getBackColors(){
		return backColors; 
	}

	/**
	 * @generated
	 */	
	public void setBackColors(Integer newVal) {
		this.backColors = newVal;
	}
 	
	
 	@Basic
	private Integer frontPasses;
	/**
	 * @generated
 	 */
	public Integer getFrontPasses(){
		return frontPasses; 
	}

	/**
	 * @generated
	 */	
	public void setFrontPasses(Integer newVal) {
		this.frontPasses = newVal;
	}
 	
	
 	@Basic
	private Integer backPasses;
	/**
	 * @generated
 	 */
	public Integer getBackPasses(){
		return backPasses; 
	}

	/**
	 * @generated
	 */	
	public void setBackPasses(Integer newVal) {
		this.backPasses = newVal;
	}
 	
	
 	@Basic
	private Integer frontWashes;
	/**
	 * @generated
 	 */
	public Integer getFrontWashes(){
		return frontWashes; 
	}

	/**
	 * @generated
	 */	
	public void setFrontWashes(Integer newVal) {
		this.frontWashes = newVal;
	}
 	
	
 	@Basic
	private Integer backWashes;
	/**
	 * @generated
 	 */
	public Integer getBackWashes(){
		return backWashes; 
	}

	/**
	 * @generated
	 */	
	public void setBackWashes(Integer newVal) {
		this.backWashes = newVal;
	}
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<InkColor> frontInks;
	/**
	 * @generated
 	 */
	public java.util.List<InkColor> getFrontInks(){
		return frontInks; 
	}

	public void addFrontInks(InkColor obj) {
		if (frontInks == null) {
			frontInks = new java.util.ArrayList<InkColor>();
		}
		frontInks.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setFrontInks(java.util.List<InkColor> newVal) {
		this.frontInks = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private InkColor backInks;
	/**
	 * @generated
 	 */
	public InkColor getBackInks(){
		return backInks; 
	}

	/**
	 * @generated
	 */	
	public void setBackInks(InkColor newVal) {
		this.backInks = newVal;
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
		if (NUMUP.equals(propertyName)) return getNumUp();
		if (NUMON.equals(propertyName)) return getNumOn();
		if (PRESS.equals(propertyName)) return getPress();
		if (BINDERYWASTE.equals(propertyName)) return getBinderyWaste();
		if (ESTWASTE.equals(propertyName)) return getEstWaste();
		if (SIGNATURES.equals(propertyName)) return getSignatures();
		if (PRICINGPRESS.equals(propertyName)) return getPricingPress();
		if (COSTINGPRESS.equals(propertyName)) return getCostingPress();
		if (RUNMETHOD.equals(propertyName)) return getRunMethod();
		if (STOCK.equals(propertyName)) return getStock();
		if (PARENTSIZE.equals(propertyName)) return getParentSize();
		if (RUNSIZE.equals(propertyName)) return getRunSize();
		if (FINISHSIZE.equals(propertyName)) return getFinishSize();
		if (ATTRIBUTE1.equals(propertyName)) return getAttribute1();
		if (FOLDEDSIZE.equals(propertyName)) return getFoldedSize();
		if (FRONTCOLORS.equals(propertyName)) return getFrontColors();
		if (BACKCOLORS.equals(propertyName)) return getBackColors();
		if (FRONTPASSES.equals(propertyName)) return getFrontPasses();
		if (BACKPASSES.equals(propertyName)) return getBackPasses();
		if (FRONTWASHES.equals(propertyName)) return getFrontWashes();
		if (BACKWASHES.equals(propertyName)) return getBackWashes();
		if (FRONTINKS.equals(propertyName)) return getFrontInks();
		if (BACKINKS.equals(propertyName)) return getBackInks();
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
		if (JOBTICKETNOTES.equals(propertyName)) setJobTicketNotes((Boolean)newValue); else
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
		if (NUMUP.equals(propertyName)) setNumUp((Long)newValue); else
		if (NUMON.equals(propertyName)) setNumOn((Long)newValue); else
		if (PRESS.equals(propertyName)) setPress((PressDefinition)newValue); else
		if (BINDERYWASTE.equals(propertyName)) setBinderyWaste((Long)newValue); else
		if (ESTWASTE.equals(propertyName)) setEstWaste((Long)newValue); else
		if (SIGNATURES.equals(propertyName)) setSignatures((Long)newValue); else
		if (PRICINGPRESS.equals(propertyName)) setPricingPress((PressDefinition)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((PressDefinition)newValue); else
		if (RUNMETHOD.equals(propertyName)) setRunMethod((String)newValue); else
		if (STOCK.equals(propertyName)) setStock((StockDefinition)newValue); else
		if (PARENTSIZE.equals(propertyName)) setParentSize((String)newValue); else
		if (RUNSIZE.equals(propertyName)) setRunSize((String)newValue); else
		if (FINISHSIZE.equals(propertyName)) setFinishSize((String)newValue); else
		if (ATTRIBUTE1.equals(propertyName)) setAttribute1((Integer)newValue); else
		if (FOLDEDSIZE.equals(propertyName)) setFoldedSize((String)newValue); else
		if (FRONTCOLORS.equals(propertyName)) setFrontColors((Integer)newValue); else
		if (BACKCOLORS.equals(propertyName)) setBackColors((Integer)newValue); else
		if (FRONTPASSES.equals(propertyName)) setFrontPasses((Integer)newValue); else
		if (BACKPASSES.equals(propertyName)) setBackPasses((Integer)newValue); else
		if (FRONTWASHES.equals(propertyName)) setFrontWashes((Integer)newValue); else
		if (BACKWASHES.equals(propertyName)) setBackWashes((Integer)newValue); else
		if (FRONTINKS.equals(propertyName)) setFrontInks((java.util.List<InkColor>)newValue); else
		if (BACKINKS.equals(propertyName)) setBackInks((InkColor)newValue); else
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
			return new Class<?>[] {Boolean.class};		
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
		if (NUMUP.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (NUMON.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PRESS.equals(propertyName)) 
			return new Class<?>[] {PressDefinition.class};		
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
		if (STOCK.equals(propertyName)) 
			return new Class<?>[] {StockDefinition.class};		
		if (PARENTSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RUNSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FINISHSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ATTRIBUTE1.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FOLDEDSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FRONTCOLORS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BACKCOLORS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FRONTPASSES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BACKPASSES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FRONTWASHES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BACKWASHES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FRONTINKS.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, InkColor.class};		
		if (BACKINKS.equals(propertyName)) 
			return new Class<?>[] {InkColor.class};		
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
		if (NUMUP.equals(propertyName)) return Job.class;
		if (NUMON.equals(propertyName)) return Job.class;
		if (PRESS.equals(propertyName)) return Job.class;
		if (BINDERYWASTE.equals(propertyName)) return Job.class;
		if (ESTWASTE.equals(propertyName)) return Job.class;
		if (SIGNATURES.equals(propertyName)) return Job.class;
		if (PRICINGPRESS.equals(propertyName)) return Job.class;
		if (COSTINGPRESS.equals(propertyName)) return Job.class;
		if (RUNMETHOD.equals(propertyName)) return Job.class;
		if (STOCK.equals(propertyName)) return Job.class;
		if (PARENTSIZE.equals(propertyName)) return Job.class;
		if (RUNSIZE.equals(propertyName)) return Job.class;
		if (FINISHSIZE.equals(propertyName)) return Job.class;
		if (ATTRIBUTE1.equals(propertyName)) return Job.class;
		if (FOLDEDSIZE.equals(propertyName)) return Job.class;
		if (FRONTCOLORS.equals(propertyName)) return Job.class;
		if (BACKCOLORS.equals(propertyName)) return Job.class;
		if (FRONTPASSES.equals(propertyName)) return Job.class;
		if (BACKPASSES.equals(propertyName)) return Job.class;
		if (FRONTWASHES.equals(propertyName)) return Job.class;
		if (BACKWASHES.equals(propertyName)) return Job.class;
		if (FRONTINKS.equals(propertyName)) return Job.class;
		if (BACKINKS.equals(propertyName)) return Job.class;
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
		if (! SmartEquals(getNumUp(), objT.getNumUp()))
			return false;
		if (! SmartEquals(getNumOn(), objT.getNumOn()))
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
		if (! SmartEquals(getStock(), objT.getStock()))
			return false;
		if (! SmartEquals(getParentSize(), objT.getParentSize()))
			return false;
		if (! SmartEquals(getRunSize(), objT.getRunSize()))
			return false;
		if (! SmartEquals(getFinishSize(), objT.getFinishSize()))
			return false;
		if (! SmartEquals(getAttribute1(), objT.getAttribute1()))
			return false;
		if (! SmartEquals(getFoldedSize(), objT.getFoldedSize()))
			return false;
		if (! SmartEquals(getFrontColors(), objT.getFrontColors()))
			return false;
		if (! SmartEquals(getBackColors(), objT.getBackColors()))
			return false;
		if (! SmartEquals(getFrontPasses(), objT.getFrontPasses()))
			return false;
		if (! SmartEquals(getBackPasses(), objT.getBackPasses()))
			return false;
		if (! SmartEquals(getFrontWashes(), objT.getFrontWashes()))
			return false;
		if (! SmartEquals(getBackWashes(), objT.getBackWashes()))
			return false;
		if (! SmartEquals(getFrontInks(), objT.getFrontInks()))
			return false;
		if (! SmartEquals(getBackInks(), objT.getBackInks()))
			return false;
		return true;
	}			
}