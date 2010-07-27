
package com.efi.printsmith.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
  @NamedQuery(name = "JobBase.findall", query = "from JobBase"),
  @NamedQuery(name = "JobBase.byId", query = "select a from JobBase a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "jobbase")
public class JobBase extends ModelBase {
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
	public static final String CUTOFF = "CutOff";

	/**
   * @generated
   */
  public static final String IMPOSITIONSPERRUN = "ImpositionsPerRun";
	/**
   * @generated
   */
  public static final String TOTALIMPOSITIONS = "TotalImpositions";

	/**
   * @generated
   */
  public static final String MARKUP = "Markup";
	/**
   * @generated
   */
  public static final String TOTALCOST = "TotalCost";
	/**
   * @generated
   */
  public static final String UNITCOST = "UnitCost";
	/**
   * @generated
   */
  public static final String NOTES = "Notes";
	/**
   * @generated
   */
  public static final String SHOWNOTES = "ShowNotes";
	/**
   * @generated
   */
  public static final String VENDOR = "Vendor";

	/**
   * @generated
   */
  public static final String NUMBEROFLINES = "NumberOfLines";
	/**
   * @generated
   */
  public static final String NUMBEROFINCHES = "NumberOfInches";

	/**
   * @generated
   */
  public static final String SPECIALORDERSTOCK = "SpecialOrderStock";
	/**
   * @generated
   */
  public static final String CUSTOMERSUPPLIEDSTOCK = "CustomerSuppliedStock";

	/**
   * @generated
   */
  public static final String PAPERPRICE = "PaperPrice";
	/**
   * @generated
   */
  public static final String JDFSTATUS = "JdfStatus";

	/**
   * @generated
   */
  public static final String PAPERCAL = "PaperCal";
	/**
   * @generated
   */
  public static final String ORQTYORDER = "OrQtyOrder";
	/**
   * @generated
   */
  public static final String ORSETS = "OrSets";
	/**
   * @generated
   */
  public static final String ORRUNTIME = "OrRuntime";
	/**
   * @generated
   */
  public static final String ORSETUPTIME = "OrSetupTime";
	/**
   * @generated
   */
  public static final String ORWASHUPTIME = "OrWashupTime";
	/**
   * @generated
   */
  public static final String ORSTOCKUNITS = "OrStockUnits";
	/**
   * @generated
   */
  public static final String ORSTOCKMARKUP = "OrStockMarkup";
	/**
   * @generated
   */
  public static final String ORSTOCKCOST = "OrStockCost";
	/**
   * @generated
   */
  public static final String ORWASTE = "OrWaste";
	/**
   * @generated
   */
  public static final String ORPRODUCTION = "OrProduction";
	/**
   * @generated
   */
  public static final String ORUNIT = "OrUnit";
	/**
   * @generated
   */
  public static final String ORPRICE = "OrPrice";
	/**
   * @generated
   */
  public static final String ORRUNOUT = "OrRunOut";
	/**
   * @generated
   */
  public static final String ORLABORMARKUP = "OrLaborMarkup";
	/**
   * @generated
   */
  public static final String ORLABORRATE = "OrLaborRate";
	/**
   * @generated
   */
  public static final String ORAVGIMPRESSION = "OrAvgImpression";
	/**
   * @generated
   */
  public static final String ORPASSFRONT = "OrPassFront";
	/**
   * @generated
   */
  public static final String ORPASSBACK = "OrPassBack";
	/**
   * @generated
   */
  public static final String ORPARENTSIZE = "OrParentSize";
	/**
   * @generated
   */
  public static final String ORBINDERYWASTE = "OrBinderyWaste";
	/**
   * @generated
   */
  public static final String ORRUNCUTS = "OrRunCuts";
	/**
   * @generated
   */
  public static final String ORFINISHCUTS = "OrFinishCuts";
	/**
   * @generated
   */
  public static final String ORUP = "OrUp";
	/**
   * @generated
   */
  public static final String ORPARENTOUT = "OrParentOut";
	/**
   * @generated
   */
  public static final String PARENTINVOICE = "ParentInvoice";
	/**
   * @generated
   */
  public static final String ROOTCHARGERECORD = "RootChargeRecord";
	/**
   * @generated
   */
  public static final String DIGITALASSETS = "DigitalAssets";
	/**
   * @generated
   */
  public static final String TYPESETTINGDATE = "TypeSettingDate";
	/**
   * @generated
   */
  public static final String PROOFBACKDATE = "ProofBackDate";
	/**
   * @generated
   */
  public static final String BLUELINEDATE = "BluelineDate";
	/**
   * @generated
   */
  public static final String BLUELINEBACKDATE = "BluelineBackDate";
	/**
   * @generated
   */
  public static final String STOCKCUTDATE = "StockCutDate";
	/**
   * @generated
   */
  public static final String ATPRESSDATE = "AtPressDate";
	/**
   * @generated
   */
  public static final String PRINTEDDATE = "PrintedDate";
	/**
   * @generated
   */
  public static final String COPIEDDATE = "CopiedDate";
	/**
   * @generated
   */
  public static final String BINDERYDATE = "BinderyDate";
	/**
   * @generated
   */
  public static final String CUTDATE = "CutDate";
	/**
   * @generated
   */
  public static final String FOLDEDDATE = "FoldedDate";
	/**
   * @generated
   */
  public static final String FINISHEDDATE = "FinishedDate";
	/**
   * @generated
   */
  public static final String MAILINGDATE = "MailingDate";
	/**
   * @generated
   */
  public static final String OUTSIDESERVICEDATE = "OutsideServiceDate";
	/**
   * @generated
   */
  public static final String OTHERDATE = "OtherDate";
	/**
   * @generated
   */
  public static final String DELIVEREDDATE = "DeliveredDate";
	/**
	 * @generated
	 */
	public JobBase() {
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
    @ManyToOne()
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
    @ManyToOne()
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
    @OneToMany(  cascade = {CascadeType.ALL})
    @IndexColumn(name="childrenjobbase")
	@JoinTable( name = "jobbase_children")
	private java.util.List<JobBase> children;
	
	/**
	 * @generated
 	 */
	public java.util.List<JobBase> getChildren(){
    return children; 
  }

	/**
	 * @generated
	 */	
	public void addChildren(JobBase obj) {
    if (children == null) {
      children = new java.util.ArrayList<JobBase>();
    }
    children.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setChildren(java.util.List<JobBase> newVal) {
    this.children = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @IndexColumn(name="chargesjobbase")
	@JoinTable( name = "jobbase_charges")
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
    @ManyToOne()
	private ProductionLocations location;
	
	/**
	 * @generated
 	 */
	public ProductionLocations getLocation(){
    return location; 
  }

	
	/**
   * @generated
   */	
  public void setLocation(ProductionLocations newVal) {
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
    @ManyToOne()
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
    @ManyToOne(fetch=FetchType.LAZY)
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
    @ManyToOne(fetch=FetchType.LAZY)
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
    @ManyToOne()
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
 	@ManyToOne()
	@Basic
	private Dimension parentSize;
	
	/**
	 * @generated
 	 */
	public Dimension getParentSize(){
    return parentSize; 
  }

	
	/**
   * @generated
   */	
  public void setParentSize(Dimension newVal) {
    this.parentSize = newVal;
  }


	/**
	 * @generated
	 */	
 	@ManyToOne()
	@Basic
	private Dimension runSize;
	
	/**
	 * @generated
 	 */
	public Dimension getRunSize(){
    return runSize; 
  }

	
	/**
   * @generated
   */	
  public void setRunSize(Dimension newVal) {
    this.runSize = newVal;
  }


	/**
	 * @generated
	 */	
 	@ManyToOne()
	@Basic
	private Dimension finishSize;
	
	/**
	 * @generated
 	 */
	public Dimension getFinishSize(){
    return finishSize; 
  }

	
	/**
   * @generated
   */	
  public void setFinishSize(Dimension newVal) {
    this.finishSize = newVal;
  }


	/**
	 * @generated
	 */	
 	@ManyToOne()
	@Basic
	private Dimension foldedSize;
	
	/**
	 * @generated
 	 */
	public Dimension getFoldedSize(){
    return foldedSize; 
  }

	
	/**
   * @generated
   */	
  public void setFoldedSize(Dimension newVal) {
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
    @OneToMany()
    @IndexColumn(name="frontinksjobbase")
	@JoinTable( name = "jobbase_frontinks")
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
    @OneToMany()
    @IndexColumn(name="backinksjobbase")
	@JoinTable( name = "jobbase_backinks")
	private java.util.List<InkColor> backInks;
	
	/**
	 * @generated
 	 */
	public java.util.List<InkColor> getBackInks(){
    return backInks; 
  }

	
	/**
   * @generated
   */	
  public void addBackInks(InkColor obj) {
    if (backInks == null) {
      backInks = new java.util.ArrayList<InkColor>();
    }
    backInks.add(obj);
  }


	/**
   * @generated
   */	
  public void setBackInks(java.util.List<InkColor> newVal) {
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
    @ManyToOne( cascade = {CascadeType.ALL})
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
    @ManyToOne(fetch=FetchType.LAZY)
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
    @ManyToOne(fetch=FetchType.LAZY)
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
    @ManyToOne()
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
    @ManyToOne()
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
 	@Basic
	private Double cutOff;
	
	/**
	 * @generated
 	 */
	public Double getCutOff(){
    return cutOff; 
  }

	
	/**
	 * @generated
	 */	
	public void setCutOff(Double newVal) {
    this.cutOff = newVal;
  }
	/**
   * @generated
   */	
 	@Basic
  private Long impositionsPerRun;

	/**
   * @generated
 	 */
  public Long getImpositionsPerRun(){
    return impositionsPerRun; 
  }


	/**
   * @generated
   */	
  public void setImpositionsPerRun(Long newVal) {
    this.impositionsPerRun = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Long totalImpositions;

	/**
   * @generated
 	 */
  public Long getTotalImpositions(){
    return totalImpositions; 
  }


	/**
   * @generated
   */	
  public void setTotalImpositions(Long newVal) {
    this.totalImpositions = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Double markup;

	/**
   * @generated
 	 */
  public Double getMarkup(){
    return markup; 
  }


	/**
   * @generated
   */	
  public void setMarkup(Double newVal) {
    this.markup = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal totalCost;

	/**
   * @generated
 	 */
  public BigDecimal getTotalCost(){
    return totalCost; 
  }


	/**
   * @generated
   */	
  public void setTotalCost(BigDecimal newVal) {
    this.totalCost = newVal;
  }


	/**
   * @generated
   */	
  public void setTotalCost(double newVal) {
    this.totalCost = BigDecimal.valueOf(newVal);
  }


	/**
   * @generated
   */	
 	@Basic
  private BigDecimal unitCost;

	/**
   * @generated
 	 */
  public BigDecimal getUnitCost(){
    return unitCost; 
  }


	/**
   * @generated
   */	
  public void setUnitCost(BigDecimal newVal) {
    this.unitCost = newVal;
  }


	/**
   * @generated
   */	
  public void setUnitCost(double newVal) {
    this.unitCost = BigDecimal.valueOf(newVal);
  }


	/**
   * @generated
   */	
 	@Basic
  private String notes;

	/**
   * @generated
 	 */
  public String getNotes(){
    return notes; 
  }


	/**
   * @generated
   */	
  public void setNotes(String newVal) {
    this.notes = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean showNotes;

	/**
   * @generated
 	 */
  public Boolean getShowNotes(){
    return showNotes; 
  }


	/**
   * @generated
   */	
  public void setShowNotes(Boolean newVal) {
    this.showNotes = newVal;
  }



	/**
   * @generated
   */	
    @ManyToOne()
  private Vendor vendor;

	/**
   * @generated
 	 */
  public Vendor getVendor(){
    return vendor; 
  }


	/**
   * @generated
   */	
  public void setVendor(Vendor newVal) {
    this.vendor = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Long numberOfLines;

	/**
   * @generated
 	 */
  public Long getNumberOfLines(){
    return numberOfLines; 
  }


	/**
   * @generated
   */	
  public void setNumberOfLines(Long newVal) {
    this.numberOfLines = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Long numberOfInches;

	/**
   * @generated
 	 */
  public Long getNumberOfInches(){
    return numberOfInches; 
  }


	/**
   * @generated
   */	
  public void setNumberOfInches(Long newVal) {
    this.numberOfInches = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Boolean specialOrderStock;

	/**
   * @generated
 	 */
  public Boolean getSpecialOrderStock(){
    return specialOrderStock; 
  }


	/**
   * @generated
   */	
  public void setSpecialOrderStock(Boolean newVal) {
    this.specialOrderStock = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean customerSuppliedStock;

	/**
   * @generated
 	 */
  public Boolean getCustomerSuppliedStock(){
    return customerSuppliedStock; 
  }


	/**
   * @generated
   */	
  public void setCustomerSuppliedStock(Boolean newVal) {
    this.customerSuppliedStock = newVal;
  }


	/**
   * @generated
   */	
    @ManyToOne()
  private PaperPrice paperPrice;

	/**
   * @generated
 	 */
  public PaperPrice getPaperPrice(){
    return paperPrice; 
  }


	/**
   * @generated
   */	
  public void setPaperPrice(PaperPrice newVal) {
    this.paperPrice = newVal;
  }



	/**
   * @generated
   */	
  @ManyToOne( cascade = {CascadeType.ALL})
  private JobJDFStatus jdfStatus;

	/**
   * @generated
 	 */
  public JobJDFStatus getJdfStatus(){
    return jdfStatus; 
  }


	/**
   * @generated
   */	
  public void setJdfStatus(JobJDFStatus newVal) {
    this.jdfStatus = newVal;
  }


	/**
   * @generated
   */	
    @ManyToOne( cascade = {CascadeType.ALL})
  private PaperCalculator paperCal;

	/**
   * @generated
 	 */
  public PaperCalculator getPaperCal(){
    return paperCal; 
  }


	/**
   * @generated
   */	
  public void setPaperCal(PaperCalculator newVal) {
    this.paperCal = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orQtyOrder;
	/**
   * @generated
 	 */
  public Boolean getOrQtyOrder(){
    return orQtyOrder; 
  }


	/**
   * @generated
   */	
  public void setOrQtyOrder(Boolean newVal) {
    this.orQtyOrder = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orSets;
	/**
   * @generated
 	 */
  public Boolean getOrSets(){
    return orSets; 
  }


	/**
   * @generated
   */	
  public void setOrSets(Boolean newVal) {
    this.orSets = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orRuntime;
	/**
   * @generated
 	 */
  public Boolean getOrRuntime(){
    return orRuntime; 
  }


	/**
   * @generated
   */	
  public void setOrRuntime(Boolean newVal) {
    this.orRuntime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orSetupTime;
	/**
   * @generated
 	 */
  public Boolean getOrSetupTime(){
    return orSetupTime; 
  }


	/**
   * @generated
   */	
  public void setOrSetupTime(Boolean newVal) {
    this.orSetupTime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orWashupTime;
	/**
   * @generated
 	 */
  public Boolean getOrWashupTime(){
    return orWashupTime; 
  }


	/**
   * @generated
   */	
  public void setOrWashupTime(Boolean newVal) {
    this.orWashupTime = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orStockUnits;
	/**
   * @generated
 	 */
  public Boolean getOrStockUnits(){
    return orStockUnits; 
  }


	/**
   * @generated
   */	
  public void setOrStockUnits(Boolean newVal) {
    this.orStockUnits = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orStockMarkup;
	/**
   * @generated
 	 */
  public Boolean getOrStockMarkup(){
    return orStockMarkup; 
  }


	/**
   * @generated
   */	
  public void setOrStockMarkup(Boolean newVal) {
    this.orStockMarkup = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orStockCost;
	/**
   * @generated
 	 */
  public Boolean getOrStockCost(){
    return orStockCost; 
  }


	/**
   * @generated
   */	
  public void setOrStockCost(Boolean newVal) {
    this.orStockCost = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orWaste;
	/**
   * @generated
 	 */
  public Boolean getOrWaste(){
    return orWaste; 
  }


	/**
   * @generated
   */	
  public void setOrWaste(Boolean newVal) {
    this.orWaste = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orProduction;
	/**
   * @generated
 	 */
  public Boolean getOrProduction(){
    return orProduction; 
  }


	/**
   * @generated
   */	
  public void setOrProduction(Boolean newVal) {
    this.orProduction = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orUnit;
	/**
   * @generated
 	 */
  public Boolean getOrUnit(){
    return orUnit; 
  }


	/**
   * @generated
   */	
  public void setOrUnit(Boolean newVal) {
    this.orUnit = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orPrice;
	/**
   * @generated
 	 */
  public Boolean getOrPrice(){
    return orPrice; 
  }


	/**
   * @generated
   */	
  public void setOrPrice(Boolean newVal) {
    this.orPrice = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orRunOut;
	/**
   * @generated
 	 */
  public Boolean getOrRunOut(){
    return orRunOut; 
  }


	/**
   * @generated
   */	
  public void setOrRunOut(Boolean newVal) {
    this.orRunOut = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orLaborMarkup;
	/**
   * @generated
 	 */
  public Boolean getOrLaborMarkup(){
    return orLaborMarkup; 
  }


	/**
   * @generated
   */	
  public void setOrLaborMarkup(Boolean newVal) {
    this.orLaborMarkup = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orLaborRate;
	/**
   * @generated
 	 */
  public Boolean getOrLaborRate(){
    return orLaborRate; 
  }


	/**
   * @generated
   */	
  public void setOrLaborRate(Boolean newVal) {
    this.orLaborRate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orAvgImpression;
	/**
   * @generated
 	 */
  public Boolean getOrAvgImpression(){
    return orAvgImpression; 
  }


	/**
   * @generated
   */	
  public void setOrAvgImpression(Boolean newVal) {
    this.orAvgImpression = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orPassFront;
	/**
   * @generated
 	 */
  public Boolean getOrPassFront(){
    return orPassFront; 
  }


	/**
   * @generated
   */	
  public void setOrPassFront(Boolean newVal) {
    this.orPassFront = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orPassBack;
	/**
   * @generated
 	 */
  public Boolean getOrPassBack(){
    return orPassBack; 
  }


	/**
   * @generated
   */	
  public void setOrPassBack(Boolean newVal) {
    this.orPassBack = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orParentSize;
	/**
   * @generated
 	 */
  public Boolean getOrParentSize(){
    return orParentSize; 
  }


	/**
   * @generated
   */	
  public void setOrParentSize(Boolean newVal) {
    this.orParentSize = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orBinderyWaste;
	/**
   * @generated
 	 */
  public Boolean getOrBinderyWaste(){
    return orBinderyWaste; 
  }


	/**
   * @generated
   */	
  public void setOrBinderyWaste(Boolean newVal) {
    this.orBinderyWaste = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orRunCuts;
	/**
   * @generated
 	 */
  public Boolean getOrRunCuts(){
    return orRunCuts; 
  }


	/**
   * @generated
   */	
  public void setOrRunCuts(Boolean newVal) {
    this.orRunCuts = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orFinishCuts;
	/**
   * @generated
 	 */
  public Boolean getOrFinishCuts(){
    return orFinishCuts; 
  }


	/**
   * @generated
   */	
  public void setOrFinishCuts(Boolean newVal) {
    this.orFinishCuts = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orUp;
	/**
   * @generated
 	 */
  public Boolean getOrUp(){
    return orUp; 
  }


	/**
   * @generated
   */	
  public void setOrUp(Boolean newVal) {
    this.orUp = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean orParentOut;
	/**
   * @generated
 	 */
  public Boolean getOrParentOut(){
    return orParentOut; 
  }


	/**
   * @generated
   */	
  public void setOrParentOut(Boolean newVal) {
    this.orParentOut = newVal;
  }



	/**
   * @generated
   */	
  @ManyToOne(fetch=FetchType.LAZY, optional=true)
  private InvoiceBase parentInvoice;
	/**
   * @generated
 	 */
  public InvoiceBase getParentInvoice(){
    return parentInvoice; 
  }


	/**
   * @generated
   */	
  public void setParentInvoice(InvoiceBase newVal) {
    this.parentInvoice = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private String rootChargeRecord;
	/**
   * @generated
 	 */
  public String getRootChargeRecord(){
    return rootChargeRecord; 
  }


	/**
   * @generated
   */	
  public void setRootChargeRecord(String newVal) {
    this.rootChargeRecord = newVal;
  }



	/**
   * @generated
   */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "jobbase_digitalassets")
  private java.util.List<DigitalAsset> digitalAssets;
	/**
   * @generated
 	 */
  public java.util.List<DigitalAsset> getDigitalAssets(){
    return digitalAssets; 
  }


	/**
   * @generated
   */	
  public void addDigitalAssets(DigitalAsset obj) {
    if (digitalAssets == null) {
      digitalAssets = new java.util.ArrayList<DigitalAsset>();
    }
    digitalAssets.add(obj);
  }


	/**
   * @generated
   */	
  public void setDigitalAssets(java.util.List<DigitalAsset> newVal) {
    this.digitalAssets = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Date typeSettingDate;
	/**
   * @generated
 	 */
  public Date getTypeSettingDate(){
    return typeSettingDate; 
  }


	/**
   * @generated
   */	
  public void setTypeSettingDate(Date newVal) {
    this.typeSettingDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date proofBackDate;
	/**
   * @generated
 	 */
  public Date getProofBackDate(){
    return proofBackDate; 
  }


	/**
   * @generated
   */	
  public void setProofBackDate(Date newVal) {
    this.proofBackDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date bluelineDate;
	/**
   * @generated
 	 */
  public Date getBluelineDate(){
    return bluelineDate; 
  }


	/**
   * @generated
   */	
  public void setBluelineDate(Date newVal) {
    this.bluelineDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date bluelineBackDate;
	/**
   * @generated
 	 */
  public Date getBluelineBackDate(){
    return bluelineBackDate; 
  }


	/**
   * @generated
   */	
  public void setBluelineBackDate(Date newVal) {
    this.bluelineBackDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date stockCutDate;
	/**
   * @generated
 	 */
  public Date getStockCutDate(){
    return stockCutDate; 
  }


	/**
   * @generated
   */	
  public void setStockCutDate(Date newVal) {
    this.stockCutDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date atPressDate;
	/**
   * @generated
 	 */
  public Date getAtPressDate(){
    return atPressDate; 
  }


	/**
   * @generated
   */	
  public void setAtPressDate(Date newVal) {
    this.atPressDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date printedDate;
	/**
   * @generated
 	 */
  public Date getPrintedDate(){
    return printedDate; 
  }


	/**
   * @generated
   */	
  public void setPrintedDate(Date newVal) {
    this.printedDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date copiedDate;
	/**
   * @generated
 	 */
  public Date getCopiedDate(){
    return copiedDate; 
  }


	/**
   * @generated
   */	
  public void setCopiedDate(Date newVal) {
    this.copiedDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date binderyDate;
	/**
   * @generated
 	 */
  public Date getBinderyDate(){
    return binderyDate; 
  }


	/**
   * @generated
   */	
  public void setBinderyDate(Date newVal) {
    this.binderyDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date cutDate;
	/**
   * @generated
 	 */
  public Date getCutDate(){
    return cutDate; 
  }


	/**
   * @generated
   */	
  public void setCutDate(Date newVal) {
    this.cutDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date foldedDate;
	/**
   * @generated
 	 */
  public Date getFoldedDate(){
    return foldedDate; 
  }


	/**
   * @generated
   */	
  public void setFoldedDate(Date newVal) {
    this.foldedDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date finishedDate;
	/**
   * @generated
 	 */
  public Date getFinishedDate(){
    return finishedDate; 
  }


	/**
   * @generated
   */	
  public void setFinishedDate(Date newVal) {
    this.finishedDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date mailingDate;
	/**
   * @generated
 	 */
  public Date getMailingDate(){
    return mailingDate; 
  }


	/**
   * @generated
   */	
  public void setMailingDate(Date newVal) {
    this.mailingDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date outsideServiceDate;
	/**
   * @generated
 	 */
  public Date getOutsideServiceDate(){
    return outsideServiceDate; 
  }


	/**
   * @generated
   */	
  public void setOutsideServiceDate(Date newVal) {
    this.outsideServiceDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date otherDate;
	/**
   * @generated
 	 */
  public Date getOtherDate(){
    return otherDate; 
  }


	/**
   * @generated
   */	
  public void setOtherDate(Date newVal) {
    this.otherDate = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Date deliveredDate;
	/**
   * @generated
 	 */
  public Date getDeliveredDate(){
    return deliveredDate; 
  }


	/**
   * @generated
   */	
  public void setDeliveredDate(Date newVal) {
    this.deliveredDate = newVal;
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
    if (CUTOFF.equals(propertyName)) return getCutOff();
    if (IMPOSITIONSPERRUN.equals(propertyName)) return getImpositionsPerRun();
    if (TOTALIMPOSITIONS.equals(propertyName)) return getTotalImpositions();
    if (MARKUP.equals(propertyName)) return getMarkup();
    if (TOTALCOST.equals(propertyName)) return getTotalCost();
    if (UNITCOST.equals(propertyName)) return getUnitCost();
    if (NOTES.equals(propertyName)) return getNotes();
    if (SHOWNOTES.equals(propertyName)) return getShowNotes();
    if (VENDOR.equals(propertyName)) return getVendor();
    if (NUMBEROFLINES.equals(propertyName)) return getNumberOfLines();
    if (NUMBEROFINCHES.equals(propertyName)) return getNumberOfInches();
    if (SPECIALORDERSTOCK.equals(propertyName)) return getSpecialOrderStock();
    if (CUSTOMERSUPPLIEDSTOCK.equals(propertyName)) return getCustomerSuppliedStock();
    if (PAPERPRICE.equals(propertyName)) return getPaperPrice();
    if (JDFSTATUS.equals(propertyName)) return getJdfStatus();
    if (PAPERCAL.equals(propertyName)) return getPaperCal();
    if (ORQTYORDER.equals(propertyName)) return getOrQtyOrder();
    if (ORSETS.equals(propertyName)) return getOrSets();
    if (ORRUNTIME.equals(propertyName)) return getOrRuntime();
    if (ORSETUPTIME.equals(propertyName)) return getOrSetupTime();
    if (ORWASHUPTIME.equals(propertyName)) return getOrWashupTime();
    if (ORSTOCKUNITS.equals(propertyName)) return getOrStockUnits();
    if (ORSTOCKMARKUP.equals(propertyName)) return getOrStockMarkup();
    if (ORSTOCKCOST.equals(propertyName)) return getOrStockCost();
    if (ORWASTE.equals(propertyName)) return getOrWaste();
    if (ORPRODUCTION.equals(propertyName)) return getOrProduction();
    if (ORUNIT.equals(propertyName)) return getOrUnit();
    if (ORPRICE.equals(propertyName)) return getOrPrice();
    if (ORRUNOUT.equals(propertyName)) return getOrRunOut();
    if (ORLABORMARKUP.equals(propertyName)) return getOrLaborMarkup();
    if (ORLABORRATE.equals(propertyName)) return getOrLaborRate();
    if (ORAVGIMPRESSION.equals(propertyName)) return getOrAvgImpression();
    if (ORPASSFRONT.equals(propertyName)) return getOrPassFront();
    if (ORPASSBACK.equals(propertyName)) return getOrPassBack();
    if (ORPARENTSIZE.equals(propertyName)) return getOrParentSize();
    if (ORBINDERYWASTE.equals(propertyName)) return getOrBinderyWaste();
    if (ORRUNCUTS.equals(propertyName)) return getOrRunCuts();
    if (ORFINISHCUTS.equals(propertyName)) return getOrFinishCuts();
    if (ORUP.equals(propertyName)) return getOrUp();
    if (ORPARENTOUT.equals(propertyName)) return getOrParentOut();
    if (PARENTINVOICE.equals(propertyName)) return getParentInvoice();
    if (ROOTCHARGERECORD.equals(propertyName)) return getRootChargeRecord();
    if (DIGITALASSETS.equals(propertyName)) return getDigitalAssets();
    if (TYPESETTINGDATE.equals(propertyName)) return getTypeSettingDate();
    if (PROOFBACKDATE.equals(propertyName)) return getProofBackDate();
    if (BLUELINEDATE.equals(propertyName)) return getBluelineDate();
    if (BLUELINEBACKDATE.equals(propertyName)) return getBluelineBackDate();
    if (STOCKCUTDATE.equals(propertyName)) return getStockCutDate();
    if (ATPRESSDATE.equals(propertyName)) return getAtPressDate();
    if (PRINTEDDATE.equals(propertyName)) return getPrintedDate();
    if (COPIEDDATE.equals(propertyName)) return getCopiedDate();
    if (BINDERYDATE.equals(propertyName)) return getBinderyDate();
    if (CUTDATE.equals(propertyName)) return getCutDate();
    if (FOLDEDDATE.equals(propertyName)) return getFoldedDate();
    if (FINISHEDDATE.equals(propertyName)) return getFinishedDate();
    if (MAILINGDATE.equals(propertyName)) return getMailingDate();
    if (OUTSIDESERVICEDATE.equals(propertyName)) return getOutsideServiceDate();
    if (OTHERDATE.equals(propertyName)) return getOtherDate();
    if (DELIVEREDDATE.equals(propertyName)) return getDeliveredDate();
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
    if (CHILDREN.equals(propertyName)) setChildren((java.util.List<JobBase>)newValue); else
    if (CHARGES.equals(propertyName)) setCharges((java.util.List<Charge>)newValue); else
    if (JOBNOTES.equals(propertyName)) setJobNotes((String)newValue); else
    if (JOBTICKETNOTES.equals(propertyName)) setJobTicketNotes((Boolean)newValue); else
    if (BROKERED.equals(propertyName)) setBrokered((Boolean)newValue); else
    if (TAXABLE.equals(propertyName)) setTaxable((Boolean)newValue); else
    if (FINISHED.equals(propertyName)) setFinished((Boolean)newValue); else
    if (LOCATION.equals(propertyName)) setLocation((ProductionLocations)newValue); else
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
    if (PARENTSIZE.equals(propertyName)) setParentSize((Dimension)newValue); else
    if (RUNSIZE.equals(propertyName)) setRunSize((Dimension)newValue); else
    if (FINISHSIZE.equals(propertyName)) setFinishSize((Dimension)newValue); else
    if (FOLDEDSIZE.equals(propertyName)) setFoldedSize((Dimension)newValue); else
    if (FRONTCOLORS.equals(propertyName)) setFrontColors((Integer)newValue); else
    if (BACKCOLORS.equals(propertyName)) setBackColors((Integer)newValue); else
    if (FRONTPASSES.equals(propertyName)) setFrontPasses((Integer)newValue); else
    if (BACKPASSES.equals(propertyName)) setBackPasses((Integer)newValue); else
    if (FRONTWASHES.equals(propertyName)) setFrontWashes((Integer)newValue); else
    if (BACKWASHES.equals(propertyName)) setBackWashes((Integer)newValue); else
    if (FRONTINKS.equals(propertyName)) setFrontInks((java.util.List<InkColor>)newValue); else
    if (BACKINKS.equals(propertyName)) setBackInks((java.util.List<InkColor>)newValue); else
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
    if (CUTOFF.equals(propertyName)) setCutOff((Double)newValue); else
    if (IMPOSITIONSPERRUN.equals(propertyName)) setImpositionsPerRun((Long)newValue); else
    if (TOTALIMPOSITIONS.equals(propertyName)) setTotalImpositions((Long)newValue); else
    if (MARKUP.equals(propertyName)) setMarkup((Double)newValue); else
    if (TOTALCOST.equals(propertyName)) setTotalCost((BigDecimal)newValue); else
    if (UNITCOST.equals(propertyName)) setUnitCost((BigDecimal)newValue); else
    if (NOTES.equals(propertyName)) setNotes((String)newValue); else
    if (SHOWNOTES.equals(propertyName)) setShowNotes((Boolean)newValue); else
    if (VENDOR.equals(propertyName)) setVendor((Vendor)newValue); else
    if (NUMBEROFLINES.equals(propertyName)) setNumberOfLines((Long)newValue); else
    if (NUMBEROFINCHES.equals(propertyName)) setNumberOfInches((Long)newValue); else
    if (SPECIALORDERSTOCK.equals(propertyName)) setSpecialOrderStock((Boolean)newValue); else
    if (CUSTOMERSUPPLIEDSTOCK.equals(propertyName)) setCustomerSuppliedStock((Boolean)newValue); else
    if (PAPERPRICE.equals(propertyName)) setPaperPrice((PaperPrice)newValue); else
    if (JDFSTATUS.equals(propertyName)) setJdfStatus((JobJDFStatus)newValue); else
    if (PAPERCAL.equals(propertyName)) setPaperCal((PaperCalculator)newValue); else
    if (ORQTYORDER.equals(propertyName)) setOrQtyOrder((Boolean)newValue); else
    if (ORSETS.equals(propertyName)) setOrSets((Boolean)newValue); else
    if (ORRUNTIME.equals(propertyName)) setOrRuntime((Boolean)newValue); else
    if (ORSETUPTIME.equals(propertyName)) setOrSetupTime((Boolean)newValue); else
    if (ORWASHUPTIME.equals(propertyName)) setOrWashupTime((Boolean)newValue); else
    if (ORSTOCKUNITS.equals(propertyName)) setOrStockUnits((Boolean)newValue); else
    if (ORSTOCKMARKUP.equals(propertyName)) setOrStockMarkup((Boolean)newValue); else
    if (ORSTOCKCOST.equals(propertyName)) setOrStockCost((Boolean)newValue); else
    if (ORWASTE.equals(propertyName)) setOrWaste((Boolean)newValue); else
    if (ORPRODUCTION.equals(propertyName)) setOrProduction((Boolean)newValue); else
    if (ORUNIT.equals(propertyName)) setOrUnit((Boolean)newValue); else
    if (ORPRICE.equals(propertyName)) setOrPrice((Boolean)newValue); else
    if (ORRUNOUT.equals(propertyName)) setOrRunOut((Boolean)newValue); else
    if (ORLABORMARKUP.equals(propertyName)) setOrLaborMarkup((Boolean)newValue); else
    if (ORLABORRATE.equals(propertyName)) setOrLaborRate((Boolean)newValue); else
    if (ORAVGIMPRESSION.equals(propertyName)) setOrAvgImpression((Boolean)newValue); else
    if (ORPASSFRONT.equals(propertyName)) setOrPassFront((Boolean)newValue); else
    if (ORPASSBACK.equals(propertyName)) setOrPassBack((Boolean)newValue); else
    if (ORPARENTSIZE.equals(propertyName)) setOrParentSize((Boolean)newValue); else
    if (ORBINDERYWASTE.equals(propertyName)) setOrBinderyWaste((Boolean)newValue); else
    if (ORRUNCUTS.equals(propertyName)) setOrRunCuts((Boolean)newValue); else
    if (ORFINISHCUTS.equals(propertyName)) setOrFinishCuts((Boolean)newValue); else
    if (ORUP.equals(propertyName)) setOrUp((Boolean)newValue); else
    if (ORPARENTOUT.equals(propertyName)) setOrParentOut((Boolean)newValue); else
    if (PARENTINVOICE.equals(propertyName)) setParentInvoice((InvoiceBase)newValue); else
    if (ROOTCHARGERECORD.equals(propertyName)) setRootChargeRecord((String)newValue); else
    if (DIGITALASSETS.equals(propertyName)) setDigitalAssets((java.util.List<DigitalAsset>)newValue); else
    if (TYPESETTINGDATE.equals(propertyName)) setTypeSettingDate((Date)newValue); else
    if (PROOFBACKDATE.equals(propertyName)) setProofBackDate((Date)newValue); else
    if (BLUELINEDATE.equals(propertyName)) setBluelineDate((Date)newValue); else
    if (BLUELINEBACKDATE.equals(propertyName)) setBluelineBackDate((Date)newValue); else
    if (STOCKCUTDATE.equals(propertyName)) setStockCutDate((Date)newValue); else
    if (ATPRESSDATE.equals(propertyName)) setAtPressDate((Date)newValue); else
    if (PRINTEDDATE.equals(propertyName)) setPrintedDate((Date)newValue); else
    if (COPIEDDATE.equals(propertyName)) setCopiedDate((Date)newValue); else
    if (BINDERYDATE.equals(propertyName)) setBinderyDate((Date)newValue); else
    if (CUTDATE.equals(propertyName)) setCutDate((Date)newValue); else
    if (FOLDEDDATE.equals(propertyName)) setFoldedDate((Date)newValue); else
    if (FINISHEDDATE.equals(propertyName)) setFinishedDate((Date)newValue); else
    if (MAILINGDATE.equals(propertyName)) setMailingDate((Date)newValue); else
    if (OUTSIDESERVICEDATE.equals(propertyName)) setOutsideServiceDate((Date)newValue); else
    if (OTHERDATE.equals(propertyName)) setOtherDate((Date)newValue); else
    if (DELIVEREDDATE.equals(propertyName)) setDeliveredDate((Date)newValue); else
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
      return new Class<?>[] {java.util.List.class, JobBase.class};		
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
      return new Class<?>[] {ProductionLocations.class};		
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
      return new Class<?>[] {Dimension.class};		
    if (RUNSIZE.equals(propertyName)) 
      return new Class<?>[] {Dimension.class};		
    if (FINISHSIZE.equals(propertyName)) 
      return new Class<?>[] {Dimension.class};		
    if (FOLDEDSIZE.equals(propertyName)) 
      return new Class<?>[] {Dimension.class};		
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
      return new Class<?>[] {java.util.List.class, InkColor.class};		
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
    if (CUTOFF.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (IMPOSITIONSPERRUN.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (TOTALIMPOSITIONS.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (MARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOTALCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (UNITCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (NOTES.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHOWNOTES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (VENDOR.equals(propertyName)) 
      return new Class<?>[] {Vendor.class};		
    if (NUMBEROFLINES.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (NUMBEROFINCHES.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (SPECIALORDERSTOCK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CUSTOMERSUPPLIEDSTOCK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PAPERPRICE.equals(propertyName)) 
      return new Class<?>[] {PaperPrice.class};		
    if (JDFSTATUS.equals(propertyName)) 
      return new Class<?>[] {JobJDFStatus.class};		
    if (PAPERCAL.equals(propertyName)) 
      return new Class<?>[] {PaperCalculator.class};		
    if (ORQTYORDER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORSETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORRUNTIME.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORSETUPTIME.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORWASHUPTIME.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORSTOCKUNITS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORSTOCKMARKUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORSTOCKCOST.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORWASTE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPRODUCTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORUNIT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPRICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORRUNOUT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORLABORMARKUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORLABORRATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORAVGIMPRESSION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPASSFRONT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPASSBACK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPARENTSIZE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORBINDERYWASTE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORRUNCUTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORFINISHCUTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORPARENTOUT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PARENTINVOICE.equals(propertyName)) 
      return new Class<?>[] {InvoiceBase.class};		
    if (ROOTCHARGERECORD.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DIGITALASSETS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, DigitalAsset.class};		
    if (TYPESETTINGDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PROOFBACKDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (BLUELINEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (BLUELINEBACKDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (STOCKCUTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ATPRESSDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PRINTEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (COPIEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (BINDERYDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CUTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FOLDEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (FINISHEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (MAILINGDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (OUTSIDESERVICEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (OTHERDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (DELIVEREDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (JOBNUMBER.equals(propertyName)) return JobBase.class;
    if (JOBINDEX.equals(propertyName)) return JobBase.class;
    if (SALESCATEGORY.equals(propertyName)) return JobBase.class;
    if (PRODUCTCODE.equals(propertyName)) return JobBase.class;
    if (CHILDREN.equals(propertyName)) return JobBase.class;
    if (CHARGES.equals(propertyName)) return JobBase.class;
    if (JOBNOTES.equals(propertyName)) return JobBase.class;
    if (JOBTICKETNOTES.equals(propertyName)) return JobBase.class;
    if (BROKERED.equals(propertyName)) return JobBase.class;
    if (TAXABLE.equals(propertyName)) return JobBase.class;
    if (FINISHED.equals(propertyName)) return JobBase.class;
    if (LOCATION.equals(propertyName)) return JobBase.class;
    if (COMMENT.equals(propertyName)) return JobBase.class;
    if (DESCRIPTION.equals(propertyName)) return JobBase.class;
    if (QTYORDERED.equals(propertyName)) return JobBase.class;
    if (OVERSUNDERS.equals(propertyName)) return JobBase.class;
    if (INSETSOF.equals(propertyName)) return JobBase.class;
    if (INSETSOFOVERRIDE.equals(propertyName)) return JobBase.class;
    if (SHEETS.equals(propertyName)) return JobBase.class;
    if (NUMUP.equals(propertyName)) return JobBase.class;
    if (NUMON.equals(propertyName)) return JobBase.class;
    if (PRESS.equals(propertyName)) return JobBase.class;
    if (BINDERYWASTE.equals(propertyName)) return JobBase.class;
    if (BINDERYWASTEOVERRIDE.equals(propertyName)) return JobBase.class;
    if (ESTWASTE.equals(propertyName)) return JobBase.class;
    if (ESTWASTEOVERRIDE.equals(propertyName)) return JobBase.class;
    if (SIGNATURES.equals(propertyName)) return JobBase.class;
    if (PRICINGPRESS.equals(propertyName)) return JobBase.class;
    if (COSTINGPRESS.equals(propertyName)) return JobBase.class;
    if (RUNMETHOD.equals(propertyName)) return JobBase.class;
    if (STOCK.equals(propertyName)) return JobBase.class;
    if (PARENTSIZE.equals(propertyName)) return JobBase.class;
    if (RUNSIZE.equals(propertyName)) return JobBase.class;
    if (FINISHSIZE.equals(propertyName)) return JobBase.class;
    if (FOLDEDSIZE.equals(propertyName)) return JobBase.class;
    if (FRONTCOLORS.equals(propertyName)) return JobBase.class;
    if (BACKCOLORS.equals(propertyName)) return JobBase.class;
    if (FRONTPASSES.equals(propertyName)) return JobBase.class;
    if (BACKPASSES.equals(propertyName)) return JobBase.class;
    if (FRONTWASHES.equals(propertyName)) return JobBase.class;
    if (BACKWASHES.equals(propertyName)) return JobBase.class;
    if (FRONTINKS.equals(propertyName)) return JobBase.class;
    if (BACKINKS.equals(propertyName)) return JobBase.class;
    if (PRESSQTY.equals(propertyName)) return JobBase.class;
    if (PRICINGRECORD.equals(propertyName)) return JobBase.class;
    if (PRICINGCOPIER.equals(propertyName)) return JobBase.class;
    if (COSTINGCOPIER.equals(propertyName)) return JobBase.class;
    if (PRICINGMETHOD.equals(propertyName)) return JobBase.class;
    if (DOUBLESIDED.equals(propertyName)) return JobBase.class;
    if (SINGLESIDED.equals(propertyName)) return JobBase.class;
    if (COSTINGRECORD.equals(propertyName)) return JobBase.class;
    if (WEIGHT.equals(propertyName)) return JobBase.class;
    if (TOTALCOPIES.equals(propertyName)) return JobBase.class;
    if (NUMCOPIES.equals(propertyName)) return JobBase.class;
    if (NUMCOPIESOVERRIDE.equals(propertyName)) return JobBase.class;
    if (STOCKQTY.equals(propertyName)) return JobBase.class;
    if (CUTOFF.equals(propertyName)) return JobBase.class;
    if (IMPOSITIONSPERRUN.equals(propertyName)) return JobBase.class;
    if (TOTALIMPOSITIONS.equals(propertyName)) return JobBase.class;
    if (MARKUP.equals(propertyName)) return JobBase.class;
    if (TOTALCOST.equals(propertyName)) return JobBase.class;
    if (UNITCOST.equals(propertyName)) return JobBase.class;
    if (NOTES.equals(propertyName)) return JobBase.class;
    if (SHOWNOTES.equals(propertyName)) return JobBase.class;
    if (VENDOR.equals(propertyName)) return JobBase.class;
    if (NUMBEROFLINES.equals(propertyName)) return JobBase.class;
    if (NUMBEROFINCHES.equals(propertyName)) return JobBase.class;
    if (SPECIALORDERSTOCK.equals(propertyName)) return JobBase.class;
    if (CUSTOMERSUPPLIEDSTOCK.equals(propertyName)) return JobBase.class;
    if (PAPERPRICE.equals(propertyName)) return JobBase.class;
    if (JDFSTATUS.equals(propertyName)) return JobBase.class;
    if (PAPERCAL.equals(propertyName)) return JobBase.class;
    if (ORQTYORDER.equals(propertyName)) return JobBase.class;
    if (ORSETS.equals(propertyName)) return JobBase.class;
    if (ORRUNTIME.equals(propertyName)) return JobBase.class;
    if (ORSETUPTIME.equals(propertyName)) return JobBase.class;
    if (ORWASHUPTIME.equals(propertyName)) return JobBase.class;
    if (ORSTOCKUNITS.equals(propertyName)) return JobBase.class;
    if (ORSTOCKMARKUP.equals(propertyName)) return JobBase.class;
    if (ORSTOCKCOST.equals(propertyName)) return JobBase.class;
    if (ORWASTE.equals(propertyName)) return JobBase.class;
    if (ORPRODUCTION.equals(propertyName)) return JobBase.class;
    if (ORUNIT.equals(propertyName)) return JobBase.class;
    if (ORPRICE.equals(propertyName)) return JobBase.class;
    if (ORRUNOUT.equals(propertyName)) return JobBase.class;
    if (ORLABORMARKUP.equals(propertyName)) return JobBase.class;
    if (ORLABORRATE.equals(propertyName)) return JobBase.class;
    if (ORAVGIMPRESSION.equals(propertyName)) return JobBase.class;
    if (ORPASSFRONT.equals(propertyName)) return JobBase.class;
    if (ORPASSBACK.equals(propertyName)) return JobBase.class;
    if (ORPARENTSIZE.equals(propertyName)) return JobBase.class;
    if (ORBINDERYWASTE.equals(propertyName)) return JobBase.class;
    if (ORRUNCUTS.equals(propertyName)) return JobBase.class;
    if (ORFINISHCUTS.equals(propertyName)) return JobBase.class;
    if (ORUP.equals(propertyName)) return JobBase.class;
    if (ORPARENTOUT.equals(propertyName)) return JobBase.class;
    if (PARENTINVOICE.equals(propertyName)) return JobBase.class;
    if (ROOTCHARGERECORD.equals(propertyName)) return JobBase.class;
    if (DIGITALASSETS.equals(propertyName)) return JobBase.class;
    if (TYPESETTINGDATE.equals(propertyName)) return JobBase.class;
    if (PROOFBACKDATE.equals(propertyName)) return JobBase.class;
    if (BLUELINEDATE.equals(propertyName)) return JobBase.class;
    if (BLUELINEBACKDATE.equals(propertyName)) return JobBase.class;
    if (STOCKCUTDATE.equals(propertyName)) return JobBase.class;
    if (ATPRESSDATE.equals(propertyName)) return JobBase.class;
    if (PRINTEDDATE.equals(propertyName)) return JobBase.class;
    if (COPIEDDATE.equals(propertyName)) return JobBase.class;
    if (BINDERYDATE.equals(propertyName)) return JobBase.class;
    if (CUTDATE.equals(propertyName)) return JobBase.class;
    if (FOLDEDDATE.equals(propertyName)) return JobBase.class;
    if (FINISHEDDATE.equals(propertyName)) return JobBase.class;
    if (MAILINGDATE.equals(propertyName)) return JobBase.class;
    if (OUTSIDESERVICEDATE.equals(propertyName)) return JobBase.class;
    if (OTHERDATE.equals(propertyName)) return JobBase.class;
    if (DELIVEREDDATE.equals(propertyName)) return JobBase.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    JobBase objT = (JobBase)obj;
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
    if (! SmartEquals(getCutOff(), objT.getCutOff()))
      return false;
    if (! SmartEquals(getImpositionsPerRun(), objT.getImpositionsPerRun()))
      return false;
    if (! SmartEquals(getTotalImpositions(), objT.getTotalImpositions()))
      return false;
    if (! SmartEquals(getMarkup(), objT.getMarkup()))
      return false;
    if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
      return false;
    if (! SmartEquals(getUnitCost(), objT.getUnitCost()))
      return false;
    if (! SmartEquals(getNotes(), objT.getNotes()))
      return false;
    if (! SmartEquals(getShowNotes(), objT.getShowNotes()))
      return false;
    if (! SmartEquals(getVendor(), objT.getVendor()))
      return false;
    if (! SmartEquals(getNumberOfLines(), objT.getNumberOfLines()))
      return false;
    if (! SmartEquals(getNumberOfInches(), objT.getNumberOfInches()))
      return false;
    if (! SmartEquals(getSpecialOrderStock(), objT.getSpecialOrderStock()))
      return false;
    if (! SmartEquals(getCustomerSuppliedStock(), objT.getCustomerSuppliedStock()))
      return false;
    if (! SmartEquals(getPaperPrice(), objT.getPaperPrice()))
      return false;
    if (! SmartEquals(getJdfStatus(), objT.getJdfStatus()))
      return false;
    if (! SmartEquals(getPaperCal(), objT.getPaperCal()))
      return false;
    if (! SmartEquals(getOrQtyOrder(), objT.getOrQtyOrder()))
      return false;
    if (! SmartEquals(getOrSets(), objT.getOrSets()))
      return false;
    if (! SmartEquals(getOrRuntime(), objT.getOrRuntime()))
      return false;
    if (! SmartEquals(getOrSetupTime(), objT.getOrSetupTime()))
      return false;
    if (! SmartEquals(getOrWashupTime(), objT.getOrWashupTime()))
      return false;
    if (! SmartEquals(getOrStockUnits(), objT.getOrStockUnits()))
      return false;
    if (! SmartEquals(getOrStockMarkup(), objT.getOrStockMarkup()))
      return false;
    if (! SmartEquals(getOrStockCost(), objT.getOrStockCost()))
      return false;
    if (! SmartEquals(getOrWaste(), objT.getOrWaste()))
      return false;
    if (! SmartEquals(getOrProduction(), objT.getOrProduction()))
      return false;
    if (! SmartEquals(getOrUnit(), objT.getOrUnit()))
      return false;
    if (! SmartEquals(getOrPrice(), objT.getOrPrice()))
      return false;
    if (! SmartEquals(getOrRunOut(), objT.getOrRunOut()))
      return false;
    if (! SmartEquals(getOrLaborMarkup(), objT.getOrLaborMarkup()))
      return false;
    if (! SmartEquals(getOrLaborRate(), objT.getOrLaborRate()))
      return false;
    if (! SmartEquals(getOrAvgImpression(), objT.getOrAvgImpression()))
      return false;
    if (! SmartEquals(getOrPassFront(), objT.getOrPassFront()))
      return false;
    if (! SmartEquals(getOrPassBack(), objT.getOrPassBack()))
      return false;
    if (! SmartEquals(getOrParentSize(), objT.getOrParentSize()))
      return false;
    if (! SmartEquals(getOrBinderyWaste(), objT.getOrBinderyWaste()))
      return false;
    if (! SmartEquals(getOrRunCuts(), objT.getOrRunCuts()))
      return false;
    if (! SmartEquals(getOrFinishCuts(), objT.getOrFinishCuts()))
      return false;
    if (! SmartEquals(getOrUp(), objT.getOrUp()))
      return false;
    if (! SmartEquals(getOrParentOut(), objT.getOrParentOut()))
      return false;
    if (! SmartEquals(getParentInvoice(), objT.getParentInvoice()))
      return false;
    if (! SmartEquals(getRootChargeRecord(), objT.getRootChargeRecord()))
      return false;
    if (! SmartEquals(getDigitalAssets(), objT.getDigitalAssets()))
      return false;
    if (! SmartEquals(getTypeSettingDate(), objT.getTypeSettingDate()))
      return false;
    if (! SmartEquals(getProofBackDate(), objT.getProofBackDate()))
      return false;
    if (! SmartEquals(getBluelineDate(), objT.getBluelineDate()))
      return false;
    if (! SmartEquals(getBluelineBackDate(), objT.getBluelineBackDate()))
      return false;
    if (! SmartEquals(getStockCutDate(), objT.getStockCutDate()))
      return false;
    if (! SmartEquals(getAtPressDate(), objT.getAtPressDate()))
      return false;
    if (! SmartEquals(getPrintedDate(), objT.getPrintedDate()))
      return false;
    if (! SmartEquals(getCopiedDate(), objT.getCopiedDate()))
      return false;
    if (! SmartEquals(getBinderyDate(), objT.getBinderyDate()))
      return false;
    if (! SmartEquals(getCutDate(), objT.getCutDate()))
      return false;
    if (! SmartEquals(getFoldedDate(), objT.getFoldedDate()))
      return false;
    if (! SmartEquals(getFinishedDate(), objT.getFinishedDate()))
      return false;
    if (! SmartEquals(getMailingDate(), objT.getMailingDate()))
      return false;
    if (! SmartEquals(getOutsideServiceDate(), objT.getOutsideServiceDate()))
      return false;
    if (! SmartEquals(getOtherDate(), objT.getOtherDate()))
      return false;
    if (! SmartEquals(getDeliveredDate(), objT.getDeliveredDate()))
      return false;
    return true;
  }			
}
