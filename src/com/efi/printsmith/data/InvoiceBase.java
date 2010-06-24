
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "InvoiceBase.findall", query = "from InvoiceBase"),
  @NamedQuery(name = "InvoiceBase.byId", query = "select a from InvoiceBase a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "invoicebase")
public class InvoiceBase extends ModelBase {
	/**
	 * @generated
	 */
	public static final String INVOICENUMBER = "InvoiceNumber";
	/**
	 * @generated
	 */
	public static final String VERSION = "Version";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String SALESREP = "SalesRep";
	/**
	 * @generated
	 */
	public static final String CUSTOMERPO = "CustomerPO";
	/**
	 * @generated
	 */
	public static final String EXPENSECODE = "ExpenseCode";
	/**
	 * @generated
	 */
	public static final String BILLTOADDRESS = "BillToAddress";
	/**
	 * @generated
	 */
	public static final String SHIPTOADDRESS = "ShipToAddress";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String SALESCODE = "SalesCode";
	/**
	 * @generated
	 */
	public static final String RESALEID = "ResaleId";
	/**
	 * @generated
	 */
	public static final String SHIPPINGMETHOD = "ShippingMethod";
	/**
	 * @generated
	 */
	public static final String PRINTCOUNT = "PrintCount";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String JOBS = "Jobs";
	/**
	 * @generated
	 */
	public static final String CHARGES = "Charges";
	/**
	 * @generated
	 */
	public static final String MARKUPCHARGES = "MarkupCharges";
	/**
	 * @generated
	 */
	public static final String SPECIALINSTRUCTIONS = "SpecialInstructions";
	/**
	 * @generated
	 */
	public static final String NOTES = "Notes";
	/**
	 * @generated
	 */
	public static final String HOLDSTATE = "HoldState";
	/**
	 * @generated
	 */
	public static final String ORDEREDDATE = "OrderedDate";
	/**
	 * @generated
	 */
	public static final String WANTEDDATE = "WantedDate";
	/**
	 * @generated
	 */
	public static final String PROOFDATE = "ProofDate";
	/**
	 * @generated
	 */
	public static final String COMPLETEDDATE = "CompletedDate";
	/**
	 * @generated
	 */
	public static final String CUSTOMERNOTIFICATIONDATE = "CustomerNotificationDate";
	/**
	 * @generated
	 */
	public static final String PICKUPDATE = "PickupDate";
	/**
	 * @generated
	 */
	public static final String REORDERDATE = "ReorderDate";
	/**
	 * @generated
	 */
	public static final String LOCATIONCHANGEDATE = "LocationChangeDate";
	/**
	 * @generated
	 */
	public static final String DELIVERYINTENTDATE = "DeliveryIntentDate";
	/**
	 * @generated
	 */
	public static final String SHIPCHARGES = "ShipCharges";
	/**
	 * @generated
	 */
	public static final String MARKUPS = "Markups";
	/**
	 * @generated
	 */
	public static final String DISCOUNTFACTOR = "DiscountFactor";
	/**
	 * @generated
	 */
	public static final String DOLLARDISCOUNT = "DollarDiscount";
	/**
	 * @generated
	 */
	public static final String DISCOUNT = "Discount";
	/**
	 * @generated
	 */
	public static final String TAXTABLE = "TaxTable";
	/**
	 * @generated
	 */
	public static final String SUBTOTAL = "SubTotal";
	/**
	 * @generated
	 */
	public static final String GRANDTOTAL = "GrandTotal";
	/**
	 * @generated
	 */
	public static final String AMOUNTDUE = "AmountDue";
	/**
	 * @generated
	 */
	public static final String TOTALCOST = "TotalCost";
	/**
	 * @generated
	 */
	public static final String ADDRESSOVERRIDEN = "AddressOverriden";
	/**
	 * @generated
	 */
	public static final String COSTED = "Costed";
	/**
	 * @generated
	 */
	public static final String OPENNOTESONOPEN = "OpenNotesOnOpen";
	/**
	 * @generated
	 */
	public static final String COMPLETED = "Completed";
	/**
	 * @generated
	 */
	public static final String PRICELOCKED = "PriceLocked";
	/**
	 * @generated
	 */
	public static final String ONPENDINGLIST = "OnPendingList";
	/**
	 * @generated
	 */
	public static final String LOCKED = "Locked";
	/**
	 * @generated
	 */
	public static final String TAXSHIPPING = "TaxShipping";
	/**
	 * @generated
	 */
	public static final String POREQUIRED = "PoRequired";
	/**
	 * @generated
	 */
	public static final String FILEORIGINALS = "FileOriginals";
	/**
	 * @generated
	 */
	public static final String NOTTAXABLE = "NotTaxable";
	/**
	 * @generated
	 */
	public static final String FIRMWANTEDBYDATE = "FirmWantedByDate";
	/**
	 * @generated
	 */
	public static final String RELEASEDTOPRODUCTION = "ReleasedToProduction";
	/**
	 * @generated
	 */
	public static final String PRICETOTAL = "PriceTotal";
	/**
	 * @generated
	 */
	public static final String CONTAINSINVENTORIEDSTOCK = "ContainsInventoriedStock";
	/**
	 * @generated
	 */
	public static final String DISCOUNTISDOLLARS = "DiscountIsDollars";
	/**
	 * @generated
	 */
	public static final String DISCOUNTISONETIME = "DiscountIsOneTime";
	/**
	 * @generated
	 */
	public static final String TAKENBY = "TakenBy";
	/**
	 * @generated
	 */
	public static final String PRICESUBTOTAL = "PriceSubTotal";
	/**
	 * @generated
	 */
	public static final String SHIPPRICE = "ShipPrice";
	/**
	 * @generated
	 */
	public static final String TAX = "Tax";

	/**
	 * @generated
	 */
	public InvoiceBase() {
    this.created = new Date();
    this.modified = new Date();
  }

	public InvoiceBase(long id,  String invoiceNumber, Account account, Contact contact) {
		this.id = id;
		this.setInvoiceNumber(invoiceNumber);
	
		this.setAccount(account);
		this.setContact(contact);
	}	
	
	public InvoiceBase(long id,  String invoiceNumber) {
		this.id = id;
		this.setInvoiceNumber(invoiceNumber);
	}	

	/**
	 * @generated
	 */	
 	@Basic
	private String invoiceNumber;
	
	/**
	 * @generated
 	 */
	public String getInvoiceNumber(){
    return invoiceNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setInvoiceNumber(String newVal) {
    this.invoiceNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long version;
	
	/**
	 * @generated
 	 */
	public Long getVersion(){
    return version; 
  }

	
	/**
	 * @generated
	 */	
	public void setVersion(Long newVal) {
    this.version = newVal;
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
    @ManyToOne()
	private SalesRep salesRep;
	
	/**
	 * @generated
 	 */
	public SalesRep getSalesRep(){
    return salesRep; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesRep(SalesRep newVal) {
    this.salesRep = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String customerPO;
	
	/**
	 * @generated
 	 */
	public String getCustomerPO(){
    return customerPO; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerPO(String newVal) {
    this.customerPO = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String expenseCode;
	
	/**
	 * @generated
 	 */
	public String getExpenseCode(){
    return expenseCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setExpenseCode(String newVal) {
    this.expenseCode = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	private Address billToAddress;
	
	/**
	 * @generated
 	 */
	public Address getBillToAddress(){
    return billToAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setBillToAddress(Address newVal) {
    this.billToAddress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
	private Address shipToAddress;
	
	/**
	 * @generated
 	 */
	public Address getShipToAddress(){
    return shipToAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setShipToAddress(Address newVal) {
    this.shipToAddress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Contact contact;
	
	/**
	 * @generated
 	 */
	public Contact getContact(){
    return contact; 
  }

	
	/**
	 * @generated
	 */	
	public void setContact(Contact newVal) {
    this.contact = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String salesCode;
	
	/**
	 * @generated
 	 */
	public String getSalesCode(){
    return salesCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setSalesCode(String newVal) {
    this.salesCode = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String resaleId;
	
	/**
	 * @generated
 	 */
	public String getResaleId(){
    return resaleId; 
  }

	
	/**
	 * @generated
	 */	
	public void setResaleId(String newVal) {
    this.resaleId = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private ShippingMethod shippingMethod;
	
	/**
	 * @generated
 	 */
	public ShippingMethod getShippingMethod(){
    return shippingMethod; 
  }

	
	/**
	 * @generated
	 */	
	public void setShippingMethod(ShippingMethod newVal) {
    this.shippingMethod = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long printCount;
	
	/**
	 * @generated
 	 */
	public Long getPrintCount(){
    return printCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrintCount(Long newVal) {
    this.printCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Account account;
	
	/**
	 * @generated
 	 */
	public Account getAccount(){
    return account; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccount(Account newVal) {
    this.account = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "invoicebase_jobs")
	private java.util.List<Job> jobs;
	
	/**
	 * @generated
 	 */
	public java.util.List<Job> getJobs(){
    return jobs; 
  }

	/**
	 * @generated
	 */	
	public void addJobs(Job obj) {
    if (jobs == null) {
      jobs = new java.util.ArrayList<Job>();
    }
    jobs.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setJobs(java.util.List<Job> newVal) {
    this.jobs = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @IndexColumn(name="chargesinvoicebase")
    @JoinTable( name = "invoicebase_charges")
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
    @OneToMany(  cascade = {CascadeType.ALL})
    @IndexColumn(name="markupchargesinvoicebase")
    @JoinTable( name = "invoicebase_markupcharges")
	private java.util.List<ChargeDefinition> markupCharges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getMarkupCharges(){
    return markupCharges; 
  }

	/**
	 * @generated
	 */	
	public void addMarkupCharges(ChargeDefinition obj) {
    if (markupCharges == null) {
      markupCharges = new java.util.ArrayList<ChargeDefinition>();
    }
    markupCharges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setMarkupCharges(java.util.List<ChargeDefinition> newVal) {
    this.markupCharges = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private SpecialInstructions specialInstructions;
	
	/**
	 * @generated
 	 */
	public SpecialInstructions getSpecialInstructions(){
    return specialInstructions; 
  }

	
	/**
	 * @generated
	 */	
	public void setSpecialInstructions(SpecialInstructions newVal) {
    this.specialInstructions = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private NotePad notes;
	
	/**
	 * @generated
 	 */
	public NotePad getNotes(){
    return notes; 
  }

	
	/**
	 * @generated
	 */	
	public void setNotes(NotePad newVal) {
    this.notes = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private HoldState holdState;
	
	/**
	 * @generated
 	 */
	public HoldState getHoldState(){
    return holdState; 
  }

	
	/**
	 * @generated
	 */	
	public void setHoldState(HoldState newVal) {
    this.holdState = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date orderedDate;
	
	/**
	 * @generated
 	 */
	public Date getOrderedDate(){
    return orderedDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderedDate(Date newVal) {
    this.orderedDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date wantedDate;
	
	/**
	 * @generated
 	 */
	public Date getWantedDate(){
    return wantedDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setWantedDate(Date newVal) {
    this.wantedDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date proofDate;
	
	/**
	 * @generated
 	 */
	public Date getProofDate(){
    return proofDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setProofDate(Date newVal) {
    this.proofDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date completedDate;
	
	/**
	 * @generated
 	 */
	public Date getCompletedDate(){
    return completedDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompletedDate(Date newVal) {
    this.completedDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date customerNotificationDate;
	
	/**
	 * @generated
 	 */
	public Date getCustomerNotificationDate(){
    return customerNotificationDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerNotificationDate(Date newVal) {
    this.customerNotificationDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date pickupDate;
	
	/**
	 * @generated
 	 */
	public Date getPickupDate(){
    return pickupDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setPickupDate(Date newVal) {
    this.pickupDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date reorderDate;
	
	/**
	 * @generated
 	 */
	public Date getReorderDate(){
    return reorderDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setReorderDate(Date newVal) {
    this.reorderDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date locationChangeDate;
	
	/**
	 * @generated
 	 */
	public Date getLocationChangeDate(){
    return locationChangeDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setLocationChangeDate(Date newVal) {
    this.locationChangeDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date deliveryIntentDate;
	
	/**
	 * @generated
 	 */
	public Date getDeliveryIntentDate(){
    return deliveryIntentDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeliveryIntentDate(Date newVal) {
    this.deliveryIntentDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal shipCharges;
	
	/**
	 * @generated
 	 */
	public BigDecimal getShipCharges(){
    return shipCharges; 
  }

	
	/**
   * @generated
   */	
  public void setShipCharges(BigDecimal newVal) {
    this.shipCharges = newVal;
  }

	/**
   * @generated
   */	
  public void setShipCharges(double newVal) {
    this.shipCharges = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double markups;
	
	/**
	 * @generated
 	 */
	public Double getMarkups(){
    return markups; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkups(Double newVal) {
    this.markups = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double discountFactor;
	
	/**
	 * @generated
 	 */
	public Double getDiscountFactor(){
    return discountFactor; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscountFactor(Double newVal) {
    this.discountFactor = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal dollarDiscount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getDollarDiscount(){
    return dollarDiscount; 
  }

	
	/**
   * @generated
   */	
  public void setDollarDiscount(BigDecimal newVal) {
    this.dollarDiscount = newVal;
  }

	/**
   * @generated
   */	
  public void setDollarDiscount(double newVal) {
    this.dollarDiscount = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double discount;
	
	/**
	 * @generated
 	 */
	public Double getDiscount(){
    return discount; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscount(Double newVal) {
    this.discount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private TaxTable taxTable;
	
	/**
	 * @generated
 	 */
	public TaxTable getTaxTable(){
    return taxTable; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxTable(TaxTable newVal) {
    this.taxTable = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal subTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getSubTotal(){
    return subTotal; 
  }

	
	/**
   * @generated
   */	
  public void setSubTotal(BigDecimal newVal) {
    this.subTotal = newVal;
  }

	/**
   * @generated
   */	
  public void setSubTotal(double newVal) {
    this.subTotal = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal grandTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getGrandTotal(){
    return grandTotal; 
  }

	
	/**
   * @generated
   */	
  public void setGrandTotal(BigDecimal newVal) {
    this.grandTotal = newVal;
  }

	/**
   * @generated
   */	
  public void setGrandTotal(double newVal) {
    this.grandTotal = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal amountDue;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAmountDue(){
    return amountDue; 
  }

	
	/**
   * @generated
   */	
  public void setAmountDue(BigDecimal newVal) {
    this.amountDue = newVal;
  }

	/**
   * @generated
   */	
  public void setAmountDue(double newVal) {
    this.amountDue = BigDecimal.valueOf(newVal);
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
	private Boolean addressOverriden;
	
	/**
	 * @generated
 	 */
	public Boolean getAddressOverriden(){
    return addressOverriden; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddressOverriden(Boolean newVal) {
    this.addressOverriden = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean costed;
	
	/**
	 * @generated
 	 */
	public Boolean getCosted(){
    return costed; 
  }

	
	/**
	 * @generated
	 */	
	public void setCosted(Boolean newVal) {
    this.costed = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer openNotesOnOpen;
	
	/**
	 * @generated
 	 */
	public Integer getOpenNotesOnOpen(){
    return openNotesOnOpen; 
  }

	
	/**
	 * @generated
	 */	
	public void setOpenNotesOnOpen(Integer newVal) {
    this.openNotesOnOpen = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean completed;
	
	/**
	 * @generated
 	 */
	public Boolean getCompleted(){
    return completed; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompleted(Boolean newVal) {
    this.completed = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean priceLocked;
	
	/**
	 * @generated
 	 */
	public Boolean getPriceLocked(){
    return priceLocked; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceLocked(Boolean newVal) {
    this.priceLocked = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean onPendingList;
	
	/**
	 * @generated
 	 */
	public Boolean getOnPendingList(){
    return onPendingList; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnPendingList(Boolean newVal) {
    this.onPendingList = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean locked;
	
	/**
	 * @generated
 	 */
	public Boolean getLocked(){
    return locked; 
  }

	
	/**
	 * @generated
	 */	
	public void setLocked(Boolean newVal) {
    this.locked = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean taxShipping;
	
	/**
	 * @generated
 	 */
	public Boolean getTaxShipping(){
    return taxShipping; 
  }

	
	/**
	 * @generated
	 */	
	public void setTaxShipping(Boolean newVal) {
    this.taxShipping = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean poRequired;
	
	/**
	 * @generated
 	 */
	public Boolean getPoRequired(){
    return poRequired; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoRequired(Boolean newVal) {
    this.poRequired = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean fileOriginals;
	
	/**
	 * @generated
 	 */
	public Boolean getFileOriginals(){
    return fileOriginals; 
  }

	
	/**
	 * @generated
	 */	
	public void setFileOriginals(Boolean newVal) {
    this.fileOriginals = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean notTaxable;
	
	/**
	 * @generated
 	 */
	public Boolean getNotTaxable(){
    return notTaxable; 
  }

	
	/**
	 * @generated
	 */	
	public void setNotTaxable(Boolean newVal) {
    this.notTaxable = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean firmWantedByDate;
	
	/**
	 * @generated
 	 */
	public Boolean getFirmWantedByDate(){
    return firmWantedByDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setFirmWantedByDate(Boolean newVal) {
    this.firmWantedByDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean releasedToProduction;
	
	/**
	 * @generated
 	 */
	public Boolean getReleasedToProduction(){
    return releasedToProduction; 
  }

	
	/**
	 * @generated
	 */	
	public void setReleasedToProduction(Boolean newVal) {
    this.releasedToProduction = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal priceTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPriceTotal(){
    return priceTotal; 
  }

	
	/**
   * @generated
   */	
  public void setPriceTotal(BigDecimal newVal) {
    this.priceTotal = newVal;
  }

	/**
   * @generated
   */	
  public void setPriceTotal(double newVal) {
    this.priceTotal = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Boolean containsInventoriedStock;
	
	/**
	 * @generated
 	 */
	public Boolean getContainsInventoriedStock(){
    return containsInventoriedStock; 
  }

	
	/**
	 * @generated
	 */	
	public void setContainsInventoriedStock(Boolean newVal) {
    this.containsInventoriedStock = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean discountIsDollars;
	
	/**
	 * @generated
 	 */
	public Boolean getDiscountIsDollars(){
    return discountIsDollars; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscountIsDollars(Boolean newVal) {
    this.discountIsDollars = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean discountIsOneTime;
	
	/**
	 * @generated
 	 */
	public Boolean getDiscountIsOneTime(){
    return discountIsOneTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setDiscountIsOneTime(Boolean newVal) {
    this.discountIsOneTime = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String takenBy;
	
	/**
	 * @generated
 	 */
	public String getTakenBy(){
    return takenBy; 
  }

	
	/**
	 * @generated
	 */	
	public void setTakenBy(String newVal) {
    this.takenBy = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal priceSubTotal;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPriceSubTotal(){
    return priceSubTotal; 
  }

	
	/**
   * @generated
   */	
  public void setPriceSubTotal(BigDecimal newVal) {
    this.priceSubTotal = newVal;
  }

	/**
   * @generated
   */	
  public void setPriceSubTotal(double newVal) {
    this.priceSubTotal = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal shipPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getShipPrice(){
    return shipPrice; 
  }

	
	/**
   * @generated
   */	
  public void setShipPrice(BigDecimal newVal) {
    this.shipPrice = newVal;
  }

	/**
   * @generated
   */	
  public void setShipPrice(double newVal) {
    this.shipPrice = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal tax;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTax(){
    return tax; 
  }

	
	/**
   * @generated
   */	
  public void setTax(BigDecimal newVal) {
    this.tax = newVal;
  }

	/**
   * @generated
   */	
  public void setTax(double newVal) {
    this.tax = BigDecimal.valueOf(newVal);
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (INVOICENUMBER.equals(propertyName)) return getInvoiceNumber();
    if (VERSION.equals(propertyName)) return getVersion();
    if (NAME.equals(propertyName)) return getName();
    if (SALESREP.equals(propertyName)) return getSalesRep();
    if (CUSTOMERPO.equals(propertyName)) return getCustomerPO();
    if (EXPENSECODE.equals(propertyName)) return getExpenseCode();
    if (BILLTOADDRESS.equals(propertyName)) return getBillToAddress();
    if (SHIPTOADDRESS.equals(propertyName)) return getShipToAddress();
    if (CONTACT.equals(propertyName)) return getContact();
    if (SALESCODE.equals(propertyName)) return getSalesCode();
    if (RESALEID.equals(propertyName)) return getResaleId();
    if (SHIPPINGMETHOD.equals(propertyName)) return getShippingMethod();
    if (PRINTCOUNT.equals(propertyName)) return getPrintCount();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (JOBS.equals(propertyName)) return getJobs();
    if (CHARGES.equals(propertyName)) return getCharges();
    if (MARKUPCHARGES.equals(propertyName)) return getMarkupCharges();
    if (SPECIALINSTRUCTIONS.equals(propertyName)) return getSpecialInstructions();
    if (NOTES.equals(propertyName)) return getNotes();
    if (HOLDSTATE.equals(propertyName)) return getHoldState();
    if (ORDEREDDATE.equals(propertyName)) return getOrderedDate();
    if (WANTEDDATE.equals(propertyName)) return getWantedDate();
    if (PROOFDATE.equals(propertyName)) return getProofDate();
    if (COMPLETEDDATE.equals(propertyName)) return getCompletedDate();
    if (CUSTOMERNOTIFICATIONDATE.equals(propertyName)) return getCustomerNotificationDate();
    if (PICKUPDATE.equals(propertyName)) return getPickupDate();
    if (REORDERDATE.equals(propertyName)) return getReorderDate();
    if (LOCATIONCHANGEDATE.equals(propertyName)) return getLocationChangeDate();
    if (DELIVERYINTENTDATE.equals(propertyName)) return getDeliveryIntentDate();
    if (SHIPCHARGES.equals(propertyName)) return getShipCharges();
    if (MARKUPS.equals(propertyName)) return getMarkups();
    if (DISCOUNTFACTOR.equals(propertyName)) return getDiscountFactor();
    if (DOLLARDISCOUNT.equals(propertyName)) return getDollarDiscount();
    if (DISCOUNT.equals(propertyName)) return getDiscount();
    if (TAXTABLE.equals(propertyName)) return getTaxTable();
    if (SUBTOTAL.equals(propertyName)) return getSubTotal();
    if (GRANDTOTAL.equals(propertyName)) return getGrandTotal();
    if (AMOUNTDUE.equals(propertyName)) return getAmountDue();
    if (TOTALCOST.equals(propertyName)) return getTotalCost();
    if (ADDRESSOVERRIDEN.equals(propertyName)) return getAddressOverriden();
    if (COSTED.equals(propertyName)) return getCosted();
    if (OPENNOTESONOPEN.equals(propertyName)) return getOpenNotesOnOpen();
    if (COMPLETED.equals(propertyName)) return getCompleted();
    if (PRICELOCKED.equals(propertyName)) return getPriceLocked();
    if (ONPENDINGLIST.equals(propertyName)) return getOnPendingList();
    if (LOCKED.equals(propertyName)) return getLocked();
    if (TAXSHIPPING.equals(propertyName)) return getTaxShipping();
    if (POREQUIRED.equals(propertyName)) return getPoRequired();
    if (FILEORIGINALS.equals(propertyName)) return getFileOriginals();
    if (NOTTAXABLE.equals(propertyName)) return getNotTaxable();
    if (FIRMWANTEDBYDATE.equals(propertyName)) return getFirmWantedByDate();
    if (RELEASEDTOPRODUCTION.equals(propertyName)) return getReleasedToProduction();
    if (PRICETOTAL.equals(propertyName)) return getPriceTotal();
    if (CONTAINSINVENTORIEDSTOCK.equals(propertyName)) return getContainsInventoriedStock();
    if (DISCOUNTISDOLLARS.equals(propertyName)) return getDiscountIsDollars();
    if (DISCOUNTISONETIME.equals(propertyName)) return getDiscountIsOneTime();
    if (TAKENBY.equals(propertyName)) return getTakenBy();
    if (PRICESUBTOTAL.equals(propertyName)) return getPriceSubTotal();
    if (SHIPPRICE.equals(propertyName)) return getShipPrice();
    if (TAX.equals(propertyName)) return getTax();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (INVOICENUMBER.equals(propertyName)) setInvoiceNumber((String)newValue); else
    if (VERSION.equals(propertyName)) setVersion((Long)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (SALESREP.equals(propertyName)) setSalesRep((SalesRep)newValue); else
    if (CUSTOMERPO.equals(propertyName)) setCustomerPO((String)newValue); else
    if (EXPENSECODE.equals(propertyName)) setExpenseCode((String)newValue); else
    if (BILLTOADDRESS.equals(propertyName)) setBillToAddress((Address)newValue); else
    if (SHIPTOADDRESS.equals(propertyName)) setShipToAddress((Address)newValue); else
    if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
    if (SALESCODE.equals(propertyName)) setSalesCode((String)newValue); else
    if (RESALEID.equals(propertyName)) setResaleId((String)newValue); else
    if (SHIPPINGMETHOD.equals(propertyName)) setShippingMethod((ShippingMethod)newValue); else
    if (PRINTCOUNT.equals(propertyName)) setPrintCount((Long)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (JOBS.equals(propertyName)) setJobs((java.util.List<Job>)newValue); else
    if (CHARGES.equals(propertyName)) setCharges((java.util.List<Charge>)newValue); else
    if (MARKUPCHARGES.equals(propertyName)) setMarkupCharges((java.util.List<ChargeDefinition>)newValue); else
    if (SPECIALINSTRUCTIONS.equals(propertyName)) setSpecialInstructions((SpecialInstructions)newValue); else
    if (NOTES.equals(propertyName)) setNotes((NotePad)newValue); else
    if (HOLDSTATE.equals(propertyName)) setHoldState((HoldState)newValue); else
    if (ORDEREDDATE.equals(propertyName)) setOrderedDate((Date)newValue); else
    if (WANTEDDATE.equals(propertyName)) setWantedDate((Date)newValue); else
    if (PROOFDATE.equals(propertyName)) setProofDate((Date)newValue); else
    if (COMPLETEDDATE.equals(propertyName)) setCompletedDate((Date)newValue); else
    if (CUSTOMERNOTIFICATIONDATE.equals(propertyName)) setCustomerNotificationDate((Date)newValue); else
    if (PICKUPDATE.equals(propertyName)) setPickupDate((Date)newValue); else
    if (REORDERDATE.equals(propertyName)) setReorderDate((Date)newValue); else
    if (LOCATIONCHANGEDATE.equals(propertyName)) setLocationChangeDate((Date)newValue); else
    if (DELIVERYINTENTDATE.equals(propertyName)) setDeliveryIntentDate((Date)newValue); else
    if (SHIPCHARGES.equals(propertyName)) setShipCharges((BigDecimal)newValue); else
    if (MARKUPS.equals(propertyName)) setMarkups((Double)newValue); else
    if (DISCOUNTFACTOR.equals(propertyName)) setDiscountFactor((Double)newValue); else
    if (DOLLARDISCOUNT.equals(propertyName)) setDollarDiscount((BigDecimal)newValue); else
    if (DISCOUNT.equals(propertyName)) setDiscount((Double)newValue); else
    if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
    if (SUBTOTAL.equals(propertyName)) setSubTotal((BigDecimal)newValue); else
    if (GRANDTOTAL.equals(propertyName)) setGrandTotal((BigDecimal)newValue); else
    if (AMOUNTDUE.equals(propertyName)) setAmountDue((BigDecimal)newValue); else
    if (TOTALCOST.equals(propertyName)) setTotalCost((BigDecimal)newValue); else
    if (ADDRESSOVERRIDEN.equals(propertyName)) setAddressOverriden((Boolean)newValue); else
    if (COSTED.equals(propertyName)) setCosted((Boolean)newValue); else
    if (OPENNOTESONOPEN.equals(propertyName)) setOpenNotesOnOpen((Integer)newValue); else
    if (COMPLETED.equals(propertyName)) setCompleted((Boolean)newValue); else
    if (PRICELOCKED.equals(propertyName)) setPriceLocked((Boolean)newValue); else
    if (ONPENDINGLIST.equals(propertyName)) setOnPendingList((Boolean)newValue); else
    if (LOCKED.equals(propertyName)) setLocked((Boolean)newValue); else
    if (TAXSHIPPING.equals(propertyName)) setTaxShipping((Boolean)newValue); else
    if (POREQUIRED.equals(propertyName)) setPoRequired((Boolean)newValue); else
    if (FILEORIGINALS.equals(propertyName)) setFileOriginals((Boolean)newValue); else
    if (NOTTAXABLE.equals(propertyName)) setNotTaxable((Boolean)newValue); else
    if (FIRMWANTEDBYDATE.equals(propertyName)) setFirmWantedByDate((Boolean)newValue); else
    if (RELEASEDTOPRODUCTION.equals(propertyName)) setReleasedToProduction((Boolean)newValue); else
    if (PRICETOTAL.equals(propertyName)) setPriceTotal((BigDecimal)newValue); else
    if (CONTAINSINVENTORIEDSTOCK.equals(propertyName)) setContainsInventoriedStock((Boolean)newValue); else
    if (DISCOUNTISDOLLARS.equals(propertyName)) setDiscountIsDollars((Boolean)newValue); else
    if (DISCOUNTISONETIME.equals(propertyName)) setDiscountIsOneTime((Boolean)newValue); else
    if (TAKENBY.equals(propertyName)) setTakenBy((String)newValue); else
    if (PRICESUBTOTAL.equals(propertyName)) setPriceSubTotal((BigDecimal)newValue); else
    if (SHIPPRICE.equals(propertyName)) setShipPrice((BigDecimal)newValue); else
    if (TAX.equals(propertyName)) setTax((BigDecimal)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (INVOICENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VERSION.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SALESREP.equals(propertyName)) 
      return new Class<?>[] {SalesRep.class};		
    if (CUSTOMERPO.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (EXPENSECODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (BILLTOADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (SHIPTOADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (CONTACT.equals(propertyName)) 
      return new Class<?>[] {Contact.class};		
    if (SALESCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (RESALEID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHIPPINGMETHOD.equals(propertyName)) 
      return new Class<?>[] {ShippingMethod.class};		
    if (PRINTCOUNT.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (JOBS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, Job.class};		
    if (CHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, Charge.class};		
    if (MARKUPCHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
    if (SPECIALINSTRUCTIONS.equals(propertyName)) 
      return new Class<?>[] {SpecialInstructions.class};		
    if (NOTES.equals(propertyName)) 
      return new Class<?>[] {NotePad.class};		
    if (HOLDSTATE.equals(propertyName)) 
      return new Class<?>[] {HoldState.class};		
    if (ORDEREDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (WANTEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PROOFDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (COMPLETEDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CUSTOMERNOTIFICATIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (PICKUPDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (REORDERDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (LOCATIONCHANGEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (DELIVERYINTENTDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (SHIPCHARGES.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (MARKUPS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DISCOUNTFACTOR.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DOLLARDISCOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (DISCOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TAXTABLE.equals(propertyName)) 
      return new Class<?>[] {TaxTable.class};		
    if (SUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (GRANDTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (AMOUNTDUE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ADDRESSOVERRIDEN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COSTED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OPENNOTESONOPEN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COMPLETED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRICELOCKED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ONPENDINGLIST.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LOCKED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAXSHIPPING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (POREQUIRED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FILEORIGINALS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NOTTAXABLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FIRMWANTEDBYDATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RELEASEDTOPRODUCTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRICETOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CONTAINSINVENTORIEDSTOCK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DISCOUNTISDOLLARS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DISCOUNTISONETIME.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TAKENBY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRICESUBTOTAL.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (SHIPPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TAX.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (INVOICENUMBER.equals(propertyName)) return InvoiceBase.class;
    if (VERSION.equals(propertyName)) return InvoiceBase.class;
    if (NAME.equals(propertyName)) return InvoiceBase.class;
    if (SALESREP.equals(propertyName)) return InvoiceBase.class;
    if (CUSTOMERPO.equals(propertyName)) return InvoiceBase.class;
    if (EXPENSECODE.equals(propertyName)) return InvoiceBase.class;
    if (BILLTOADDRESS.equals(propertyName)) return InvoiceBase.class;
    if (SHIPTOADDRESS.equals(propertyName)) return InvoiceBase.class;
    if (CONTACT.equals(propertyName)) return InvoiceBase.class;
    if (SALESCODE.equals(propertyName)) return InvoiceBase.class;
    if (RESALEID.equals(propertyName)) return InvoiceBase.class;
    if (SHIPPINGMETHOD.equals(propertyName)) return InvoiceBase.class;
    if (PRINTCOUNT.equals(propertyName)) return InvoiceBase.class;
    if (ACCOUNT.equals(propertyName)) return InvoiceBase.class;
    if (JOBS.equals(propertyName)) return InvoiceBase.class;
    if (CHARGES.equals(propertyName)) return InvoiceBase.class;
    if (MARKUPCHARGES.equals(propertyName)) return InvoiceBase.class;
    if (SPECIALINSTRUCTIONS.equals(propertyName)) return InvoiceBase.class;
    if (NOTES.equals(propertyName)) return InvoiceBase.class;
    if (HOLDSTATE.equals(propertyName)) return InvoiceBase.class;
    if (ORDEREDDATE.equals(propertyName)) return InvoiceBase.class;
    if (WANTEDDATE.equals(propertyName)) return InvoiceBase.class;
    if (PROOFDATE.equals(propertyName)) return InvoiceBase.class;
    if (COMPLETEDDATE.equals(propertyName)) return InvoiceBase.class;
    if (CUSTOMERNOTIFICATIONDATE.equals(propertyName)) return InvoiceBase.class;
    if (PICKUPDATE.equals(propertyName)) return InvoiceBase.class;
    if (REORDERDATE.equals(propertyName)) return InvoiceBase.class;
    if (LOCATIONCHANGEDATE.equals(propertyName)) return InvoiceBase.class;
    if (DELIVERYINTENTDATE.equals(propertyName)) return InvoiceBase.class;
    if (SHIPCHARGES.equals(propertyName)) return InvoiceBase.class;
    if (MARKUPS.equals(propertyName)) return InvoiceBase.class;
    if (DISCOUNTFACTOR.equals(propertyName)) return InvoiceBase.class;
    if (DOLLARDISCOUNT.equals(propertyName)) return InvoiceBase.class;
    if (DISCOUNT.equals(propertyName)) return InvoiceBase.class;
    if (TAXTABLE.equals(propertyName)) return InvoiceBase.class;
    if (SUBTOTAL.equals(propertyName)) return InvoiceBase.class;
    if (GRANDTOTAL.equals(propertyName)) return InvoiceBase.class;
    if (AMOUNTDUE.equals(propertyName)) return InvoiceBase.class;
    if (TOTALCOST.equals(propertyName)) return InvoiceBase.class;
    if (ADDRESSOVERRIDEN.equals(propertyName)) return InvoiceBase.class;
    if (COSTED.equals(propertyName)) return InvoiceBase.class;
    if (OPENNOTESONOPEN.equals(propertyName)) return InvoiceBase.class;
    if (COMPLETED.equals(propertyName)) return InvoiceBase.class;
    if (PRICELOCKED.equals(propertyName)) return InvoiceBase.class;
    if (ONPENDINGLIST.equals(propertyName)) return InvoiceBase.class;
    if (LOCKED.equals(propertyName)) return InvoiceBase.class;
    if (TAXSHIPPING.equals(propertyName)) return InvoiceBase.class;
    if (POREQUIRED.equals(propertyName)) return InvoiceBase.class;
    if (FILEORIGINALS.equals(propertyName)) return InvoiceBase.class;
    if (NOTTAXABLE.equals(propertyName)) return InvoiceBase.class;
    if (FIRMWANTEDBYDATE.equals(propertyName)) return InvoiceBase.class;
    if (RELEASEDTOPRODUCTION.equals(propertyName)) return InvoiceBase.class;
    if (PRICETOTAL.equals(propertyName)) return InvoiceBase.class;
    if (CONTAINSINVENTORIEDSTOCK.equals(propertyName)) return InvoiceBase.class;
    if (DISCOUNTISDOLLARS.equals(propertyName)) return InvoiceBase.class;
    if (DISCOUNTISONETIME.equals(propertyName)) return InvoiceBase.class;
    if (TAKENBY.equals(propertyName)) return InvoiceBase.class;
    if (PRICESUBTOTAL.equals(propertyName)) return InvoiceBase.class;
    if (SHIPPRICE.equals(propertyName)) return InvoiceBase.class;
    if (TAX.equals(propertyName)) return InvoiceBase.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    InvoiceBase objT = (InvoiceBase)obj;
    if (! SmartEquals(getInvoiceNumber(), objT.getInvoiceNumber()))
      return false;
    if (! SmartEquals(getVersion(), objT.getVersion()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getSalesRep(), objT.getSalesRep()))
      return false;
    if (! SmartEquals(getCustomerPO(), objT.getCustomerPO()))
      return false;
    if (! SmartEquals(getExpenseCode(), objT.getExpenseCode()))
      return false;
    if (! SmartEquals(getBillToAddress(), objT.getBillToAddress()))
      return false;
    if (! SmartEquals(getShipToAddress(), objT.getShipToAddress()))
      return false;
    if (! SmartEquals(getContact(), objT.getContact()))
      return false;
    if (! SmartEquals(getSalesCode(), objT.getSalesCode()))
      return false;
    if (! SmartEquals(getResaleId(), objT.getResaleId()))
      return false;
    if (! SmartEquals(getShippingMethod(), objT.getShippingMethod()))
      return false;
    if (! SmartEquals(getPrintCount(), objT.getPrintCount()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getJobs(), objT.getJobs()))
      return false;
    if (! SmartEquals(getCharges(), objT.getCharges()))
      return false;
    if (! SmartEquals(getMarkupCharges(), objT.getMarkupCharges()))
      return false;
    if (! SmartEquals(getSpecialInstructions(), objT.getSpecialInstructions()))
      return false;
    if (! SmartEquals(getNotes(), objT.getNotes()))
      return false;
    if (! SmartEquals(getHoldState(), objT.getHoldState()))
      return false;
    if (! SmartEquals(getOrderedDate(), objT.getOrderedDate()))
      return false;
    if (! SmartEquals(getWantedDate(), objT.getWantedDate()))
      return false;
    if (! SmartEquals(getProofDate(), objT.getProofDate()))
      return false;
    if (! SmartEquals(getCompletedDate(), objT.getCompletedDate()))
      return false;
    if (! SmartEquals(getCustomerNotificationDate(), objT.getCustomerNotificationDate()))
      return false;
    if (! SmartEquals(getPickupDate(), objT.getPickupDate()))
      return false;
    if (! SmartEquals(getReorderDate(), objT.getReorderDate()))
      return false;
    if (! SmartEquals(getLocationChangeDate(), objT.getLocationChangeDate()))
      return false;
    if (! SmartEquals(getDeliveryIntentDate(), objT.getDeliveryIntentDate()))
      return false;
    if (! SmartEquals(getShipCharges(), objT.getShipCharges()))
      return false;
    if (! SmartEquals(getMarkups(), objT.getMarkups()))
      return false;
    if (! SmartEquals(getDiscountFactor(), objT.getDiscountFactor()))
      return false;
    if (! SmartEquals(getDollarDiscount(), objT.getDollarDiscount()))
      return false;
    if (! SmartEquals(getDiscount(), objT.getDiscount()))
      return false;
    if (! SmartEquals(getTaxTable(), objT.getTaxTable()))
      return false;
    if (! SmartEquals(getSubTotal(), objT.getSubTotal()))
      return false;
    if (! SmartEquals(getGrandTotal(), objT.getGrandTotal()))
      return false;
    if (! SmartEquals(getAmountDue(), objT.getAmountDue()))
      return false;
    if (! SmartEquals(getTotalCost(), objT.getTotalCost()))
      return false;
    if (! SmartEquals(getAddressOverriden(), objT.getAddressOverriden()))
      return false;
    if (! SmartEquals(getCosted(), objT.getCosted()))
      return false;
    if (! SmartEquals(getOpenNotesOnOpen(), objT.getOpenNotesOnOpen()))
      return false;
    if (! SmartEquals(getCompleted(), objT.getCompleted()))
      return false;
    if (! SmartEquals(getPriceLocked(), objT.getPriceLocked()))
      return false;
    if (! SmartEquals(getOnPendingList(), objT.getOnPendingList()))
      return false;
    if (! SmartEquals(getLocked(), objT.getLocked()))
      return false;
    if (! SmartEquals(getTaxShipping(), objT.getTaxShipping()))
      return false;
    if (! SmartEquals(getPoRequired(), objT.getPoRequired()))
      return false;
    if (! SmartEquals(getFileOriginals(), objT.getFileOriginals()))
      return false;
    if (! SmartEquals(getNotTaxable(), objT.getNotTaxable()))
      return false;
    if (! SmartEquals(getFirmWantedByDate(), objT.getFirmWantedByDate()))
      return false;
    if (! SmartEquals(getReleasedToProduction(), objT.getReleasedToProduction()))
      return false;
    if (! SmartEquals(getPriceTotal(), objT.getPriceTotal()))
      return false;
    if (! SmartEquals(getContainsInventoriedStock(), objT.getContainsInventoriedStock()))
      return false;
    if (! SmartEquals(getDiscountIsDollars(), objT.getDiscountIsDollars()))
      return false;
    if (! SmartEquals(getDiscountIsOneTime(), objT.getDiscountIsOneTime()))
      return false;
    if (! SmartEquals(getTakenBy(), objT.getTakenBy()))
      return false;
    if (! SmartEquals(getPriceSubTotal(), objT.getPriceSubTotal()))
      return false;
    if (! SmartEquals(getShipPrice(), objT.getShipPrice()))
      return false;
    if (! SmartEquals(getTax(), objT.getTax()))
      return false;
    return true;
  }			
}
