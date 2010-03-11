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
	public static final String INSETSOFOVERRIDE = "InSetsOfOverride";
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
	public static final String BINDERYWASTEOVERRIDE = "BinderyWasteOverride";
	/**
	 * @generated
	 */
	public static final String ESTWASTE = "EstWaste";
	/**
	 * @generated
	 */
	public static final String ESTWASTEOVERRIDE = "EstWasteOverride";
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
	public static final String PRESSQTY = "PressQty";
	/**
	 * @generated
	 */
	public static final String PRICINGRECORD = "PricingRecord";
	/**
	 * @generated
	 */
	public static final String PRICINGCOPIER = "PricingCopier";
	/**
	 * @generated
	 */
	public static final String COSTINGCOPIER = "CostingCopier";
	/**
	 * @generated
	 */
	public static final String PRICINGMETHOD = "PricingMethod";
	/**
	 * @generated
	 */
	public static final String DOUBLESIDED = "DoubleSided";
	/**
	 * @generated
	 */
	public static final String SINGLESIDED = "SingleSided";
	/**
	 * @generated
	 */
	public static final String COSTINGRECORD = "CostingRecord";
	/**
	 * @generated
	 */
	public static final String WEIGHT = "Weight";
	/**
	 * @generated
	 */
	public static final String TOTALCOPIES = "TotalCopies";
	/**
	 * @generated
	 */
	public static final String NUMCOPIES = "NumCopies";
	/**
	 * @generated
	 */
	public static final String NUMCOPIESOVERRIDE = "NumCopiesOverride";
	/**
	 * @generated
	 */
	public static final String STOCKQTY = "StockQty";

	/**
	 * @generated
	 */
	public Job() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "job_children")
	private java.util.List<Job> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<Job> getChildren(){
		return children; 
	}

	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "job_charges")
	private java.util.List<Charge> charges;
	
	/**
	 * @generated
 	 */
	public java.util.List<Charge> getCharges(){
		return charges; 
	}

	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean inSetsOfOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getInSetsOfOverride(){
		return inSetsOfOverride; 
	}

	
	/**
	 * @generated
	 */	
	public void setInSetsOfOverride(Boolean newVal) {
		this.inSetsOfOverride = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean binderyWasteOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getBinderyWasteOverride(){
		return binderyWasteOverride; 
	}

	
	/**
	 * @generated
	 */	
	public void setBinderyWasteOverride(Boolean newVal) {
		this.binderyWasteOverride = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean estWasteOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getEstWasteOverride(){
		return estWasteOverride; 
	}

	
	/**
	 * @generated
	 */	
	public void setEstWasteOverride(Boolean newVal) {
		this.estWasteOverride = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinTable( name = "job_frontinks")
	private java.util.List<InkColor> frontInks;
	
	/**
	 * @generated
 	 */
	public java.util.List<InkColor> getFrontInks(){
		return frontInks; 
	}

	/**
	 * @generated
	 */	
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
 	
	
	/**
	 * @generated
	 */	
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
 	@Basic
	private Long pressQty;
	
	/**
	 * @generated
 	 */
	public Long getPressQty(){
		return pressQty; 
	}

	
	/**
	 * @generated
	 */	
	public void setPressQty(Long newVal) {
		this.pressQty = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PricingRecord pricingRecord;
	
	/**
	 * @generated
 	 */
	public PricingRecord getPricingRecord(){
		return pricingRecord; 
	}

	
	/**
	 * @generated
	 */	
	public void setPricingRecord(PricingRecord newVal) {
		this.pricingRecord = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private CopierDefinition pricingCopier;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getPricingCopier(){
		return pricingCopier; 
	}

	
	/**
	 * @generated
	 */	
	public void setPricingCopier(CopierDefinition newVal) {
		this.pricingCopier = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private CopierDefinition costingCopier;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getCostingCopier(){
		return costingCopier; 
	}

	
	/**
	 * @generated
	 */	
	public void setCostingCopier(CopierDefinition newVal) {
		this.costingCopier = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private PreferencesPricingMethod pricingMethod;
	
	/**
	 * @generated
 	 */
	public PreferencesPricingMethod getPricingMethod(){
		return pricingMethod; 
	}

	
	/**
	 * @generated
	 */	
	public void setPricingMethod(PreferencesPricingMethod newVal) {
		this.pricingMethod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean doubleSided;
	
	/**
	 * @generated
 	 */
	public Boolean getDoubleSided(){
		return doubleSided; 
	}

	
	/**
	 * @generated
	 */	
	public void setDoubleSided(Boolean newVal) {
		this.doubleSided = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean singleSided;
	
	/**
	 * @generated
 	 */
	public Boolean getSingleSided(){
		return singleSided; 
	}

	
	/**
	 * @generated
	 */	
	public void setSingleSided(Boolean newVal) {
		this.singleSided = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private CostingRecord costingRecord;
	
	/**
	 * @generated
 	 */
	public CostingRecord getCostingRecord(){
		return costingRecord; 
	}

	
	/**
	 * @generated
	 */	
	public void setCostingRecord(CostingRecord newVal) {
		this.costingRecord = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double weight;
	
	/**
	 * @generated
 	 */
	public Double getWeight(){
		return weight; 
	}

	
	/**
	 * @generated
	 */	
	public void setWeight(Double newVal) {
		this.weight = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long totalCopies;
	
	/**
	 * @generated
 	 */
	public Long getTotalCopies(){
		return totalCopies; 
	}

	
	/**
	 * @generated
	 */	
	public void setTotalCopies(Long newVal) {
		this.totalCopies = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long numCopies;
	
	/**
	 * @generated
 	 */
	public Long getNumCopies(){
		return numCopies; 
	}

	
	/**
	 * @generated
	 */	
	public void setNumCopies(Long newVal) {
		this.numCopies = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean numCopiesOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getNumCopiesOverride(){
		return numCopiesOverride; 
	}

	
	/**
	 * @generated
	 */	
	public void setNumCopiesOverride(Boolean newVal) {
		this.numCopiesOverride = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long stockQty;
	
	/**
	 * @generated
 	 */
	public Long getStockQty(){
		return stockQty; 
	}

	
	/**
	 * @generated
	 */	
	public void setStockQty(Long newVal) {
		this.stockQty = newVal;
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
		if (INSETSOFOVERRIDE.equals(propertyName)) return getInSetsOfOverride();
		if (SHEETS.equals(propertyName)) return getSheets();
		if (NUMUP.equals(propertyName)) return getNumUp();
		if (NUMON.equals(propertyName)) return getNumOn();
		if (PRESS.equals(propertyName)) return getPress();
		if (BINDERYWASTE.equals(propertyName)) return getBinderyWaste();
		if (BINDERYWASTEOVERRIDE.equals(propertyName)) return getBinderyWasteOverride();
		if (ESTWASTE.equals(propertyName)) return getEstWaste();
		if (ESTWASTEOVERRIDE.equals(propertyName)) return getEstWasteOverride();
		if (SIGNATURES.equals(propertyName)) return getSignatures();
		if (PRICINGPRESS.equals(propertyName)) return getPricingPress();
		if (COSTINGPRESS.equals(propertyName)) return getCostingPress();
		if (RUNMETHOD.equals(propertyName)) return getRunMethod();
		if (STOCK.equals(propertyName)) return getStock();
		if (PARENTSIZE.equals(propertyName)) return getParentSize();
		if (RUNSIZE.equals(propertyName)) return getRunSize();
		if (FINISHSIZE.equals(propertyName)) return getFinishSize();
		if (FOLDEDSIZE.equals(propertyName)) return getFoldedSize();
		if (FRONTCOLORS.equals(propertyName)) return getFrontColors();
		if (BACKCOLORS.equals(propertyName)) return getBackColors();
		if (FRONTPASSES.equals(propertyName)) return getFrontPasses();
		if (BACKPASSES.equals(propertyName)) return getBackPasses();
		if (FRONTWASHES.equals(propertyName)) return getFrontWashes();
		if (BACKWASHES.equals(propertyName)) return getBackWashes();
		if (FRONTINKS.equals(propertyName)) return getFrontInks();
		if (BACKINKS.equals(propertyName)) return getBackInks();
		if (PRESSQTY.equals(propertyName)) return getPressQty();
		if (PRICINGRECORD.equals(propertyName)) return getPricingRecord();
		if (PRICINGCOPIER.equals(propertyName)) return getPricingCopier();
		if (COSTINGCOPIER.equals(propertyName)) return getCostingCopier();
		if (PRICINGMETHOD.equals(propertyName)) return getPricingMethod();
		if (DOUBLESIDED.equals(propertyName)) return getDoubleSided();
		if (SINGLESIDED.equals(propertyName)) return getSingleSided();
		if (COSTINGRECORD.equals(propertyName)) return getCostingRecord();
		if (WEIGHT.equals(propertyName)) return getWeight();
		if (TOTALCOPIES.equals(propertyName)) return getTotalCopies();
		if (NUMCOPIES.equals(propertyName)) return getNumCopies();
		if (NUMCOPIESOVERRIDE.equals(propertyName)) return getNumCopiesOverride();
		if (STOCKQTY.equals(propertyName)) return getStockQty();
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
		if (INSETSOFOVERRIDE.equals(propertyName)) setInSetsOfOverride((Boolean)newValue); else
		if (SHEETS.equals(propertyName)) setSheets((Long)newValue); else
		if (NUMUP.equals(propertyName)) setNumUp((Long)newValue); else
		if (NUMON.equals(propertyName)) setNumOn((Long)newValue); else
		if (PRESS.equals(propertyName)) setPress((PressDefinition)newValue); else
		if (BINDERYWASTE.equals(propertyName)) setBinderyWaste((Long)newValue); else
		if (BINDERYWASTEOVERRIDE.equals(propertyName)) setBinderyWasteOverride((Boolean)newValue); else
		if (ESTWASTE.equals(propertyName)) setEstWaste((Long)newValue); else
		if (ESTWASTEOVERRIDE.equals(propertyName)) setEstWasteOverride((Boolean)newValue); else
		if (SIGNATURES.equals(propertyName)) setSignatures((Long)newValue); else
		if (PRICINGPRESS.equals(propertyName)) setPricingPress((PressDefinition)newValue); else
		if (COSTINGPRESS.equals(propertyName)) setCostingPress((PressDefinition)newValue); else
		if (RUNMETHOD.equals(propertyName)) setRunMethod((String)newValue); else
		if (STOCK.equals(propertyName)) setStock((StockDefinition)newValue); else
		if (PARENTSIZE.equals(propertyName)) setParentSize((String)newValue); else
		if (RUNSIZE.equals(propertyName)) setRunSize((String)newValue); else
		if (FINISHSIZE.equals(propertyName)) setFinishSize((String)newValue); else
		if (FOLDEDSIZE.equals(propertyName)) setFoldedSize((String)newValue); else
		if (FRONTCOLORS.equals(propertyName)) setFrontColors((Integer)newValue); else
		if (BACKCOLORS.equals(propertyName)) setBackColors((Integer)newValue); else
		if (FRONTPASSES.equals(propertyName)) setFrontPasses((Integer)newValue); else
		if (BACKPASSES.equals(propertyName)) setBackPasses((Integer)newValue); else
		if (FRONTWASHES.equals(propertyName)) setFrontWashes((Integer)newValue); else
		if (BACKWASHES.equals(propertyName)) setBackWashes((Integer)newValue); else
		if (FRONTINKS.equals(propertyName)) setFrontInks((java.util.List<InkColor>)newValue); else
		if (BACKINKS.equals(propertyName)) setBackInks((InkColor)newValue); else
		if (PRESSQTY.equals(propertyName)) setPressQty((Long)newValue); else
		if (PRICINGRECORD.equals(propertyName)) setPricingRecord((PricingRecord)newValue); else
		if (PRICINGCOPIER.equals(propertyName)) setPricingCopier((CopierDefinition)newValue); else
		if (COSTINGCOPIER.equals(propertyName)) setCostingCopier((CopierDefinition)newValue); else
		if (PRICINGMETHOD.equals(propertyName)) setPricingMethod((PreferencesPricingMethod)newValue); else
		if (DOUBLESIDED.equals(propertyName)) setDoubleSided((Boolean)newValue); else
		if (SINGLESIDED.equals(propertyName)) setSingleSided((Boolean)newValue); else
		if (COSTINGRECORD.equals(propertyName)) setCostingRecord((CostingRecord)newValue); else
		if (WEIGHT.equals(propertyName)) setWeight((Double)newValue); else
		if (TOTALCOPIES.equals(propertyName)) setTotalCopies((Long)newValue); else
		if (NUMCOPIES.equals(propertyName)) setNumCopies((Long)newValue); else
		if (NUMCOPIESOVERRIDE.equals(propertyName)) setNumCopiesOverride((Boolean)newValue); else
		if (STOCKQTY.equals(propertyName)) setStockQty((Long)newValue); else
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
		if (INSETSOFOVERRIDE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
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
		if (BINDERYWASTEOVERRIDE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ESTWASTE.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ESTWASTEOVERRIDE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
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
		if (PRESSQTY.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PRICINGRECORD.equals(propertyName)) 
			return new Class<?>[] {PricingRecord.class};		
		if (PRICINGCOPIER.equals(propertyName)) 
			return new Class<?>[] {CopierDefinition.class};		
		if (COSTINGCOPIER.equals(propertyName)) 
			return new Class<?>[] {CopierDefinition.class};		
		if (PRICINGMETHOD.equals(propertyName)) 
			return new Class<?>[] {PreferencesPricingMethod.class};		
		if (DOUBLESIDED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SINGLESIDED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (COSTINGRECORD.equals(propertyName)) 
			return new Class<?>[] {CostingRecord.class};		
		if (WEIGHT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TOTALCOPIES.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (NUMCOPIES.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (NUMCOPIESOVERRIDE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (STOCKQTY.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
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
		if (INSETSOFOVERRIDE.equals(propertyName)) return Job.class;
		if (SHEETS.equals(propertyName)) return Job.class;
		if (NUMUP.equals(propertyName)) return Job.class;
		if (NUMON.equals(propertyName)) return Job.class;
		if (PRESS.equals(propertyName)) return Job.class;
		if (BINDERYWASTE.equals(propertyName)) return Job.class;
		if (BINDERYWASTEOVERRIDE.equals(propertyName)) return Job.class;
		if (ESTWASTE.equals(propertyName)) return Job.class;
		if (ESTWASTEOVERRIDE.equals(propertyName)) return Job.class;
		if (SIGNATURES.equals(propertyName)) return Job.class;
		if (PRICINGPRESS.equals(propertyName)) return Job.class;
		if (COSTINGPRESS.equals(propertyName)) return Job.class;
		if (RUNMETHOD.equals(propertyName)) return Job.class;
		if (STOCK.equals(propertyName)) return Job.class;
		if (PARENTSIZE.equals(propertyName)) return Job.class;
		if (RUNSIZE.equals(propertyName)) return Job.class;
		if (FINISHSIZE.equals(propertyName)) return Job.class;
		if (FOLDEDSIZE.equals(propertyName)) return Job.class;
		if (FRONTCOLORS.equals(propertyName)) return Job.class;
		if (BACKCOLORS.equals(propertyName)) return Job.class;
		if (FRONTPASSES.equals(propertyName)) return Job.class;
		if (BACKPASSES.equals(propertyName)) return Job.class;
		if (FRONTWASHES.equals(propertyName)) return Job.class;
		if (BACKWASHES.equals(propertyName)) return Job.class;
		if (FRONTINKS.equals(propertyName)) return Job.class;
		if (BACKINKS.equals(propertyName)) return Job.class;
		if (PRESSQTY.equals(propertyName)) return Job.class;
		if (PRICINGRECORD.equals(propertyName)) return Job.class;
		if (PRICINGCOPIER.equals(propertyName)) return Job.class;
		if (COSTINGCOPIER.equals(propertyName)) return Job.class;
		if (PRICINGMETHOD.equals(propertyName)) return Job.class;
		if (DOUBLESIDED.equals(propertyName)) return Job.class;
		if (SINGLESIDED.equals(propertyName)) return Job.class;
		if (COSTINGRECORD.equals(propertyName)) return Job.class;
		if (WEIGHT.equals(propertyName)) return Job.class;
		if (TOTALCOPIES.equals(propertyName)) return Job.class;
		if (NUMCOPIES.equals(propertyName)) return Job.class;
		if (NUMCOPIESOVERRIDE.equals(propertyName)) return Job.class;
		if (STOCKQTY.equals(propertyName)) return Job.class;
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
		if (! SmartEquals(getInSetsOfOverride(), objT.getInSetsOfOverride()))
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
		if (! SmartEquals(getBinderyWasteOverride(), objT.getBinderyWasteOverride()))
			return false;
		if (! SmartEquals(getEstWaste(), objT.getEstWaste()))
			return false;
		if (! SmartEquals(getEstWasteOverride(), objT.getEstWasteOverride()))
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
		if (! SmartEquals(getPressQty(), objT.getPressQty()))
			return false;
		if (! SmartEquals(getPricingRecord(), objT.getPricingRecord()))
			return false;
		if (! SmartEquals(getPricingCopier(), objT.getPricingCopier()))
			return false;
		if (! SmartEquals(getCostingCopier(), objT.getCostingCopier()))
			return false;
		if (! SmartEquals(getPricingMethod(), objT.getPricingMethod()))
			return false;
		if (! SmartEquals(getDoubleSided(), objT.getDoubleSided()))
			return false;
		if (! SmartEquals(getSingleSided(), objT.getSingleSided()))
			return false;
		if (! SmartEquals(getCostingRecord(), objT.getCostingRecord()))
			return false;
		if (! SmartEquals(getWeight(), objT.getWeight()))
			return false;
		if (! SmartEquals(getTotalCopies(), objT.getTotalCopies()))
			return false;
		if (! SmartEquals(getNumCopies(), objT.getNumCopies()))
			return false;
		if (! SmartEquals(getNumCopiesOverride(), objT.getNumCopiesOverride()))
			return false;
		if (! SmartEquals(getStockQty(), objT.getStockQty()))
			return false;
		return true;
	}			
}