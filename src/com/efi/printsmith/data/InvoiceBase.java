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
	@NamedQuery(name = "InvoiceBase.findall", query = "from InvoiceBase"),
	@NamedQuery(name = "InvoiceBase.byId", query = "select a from InvoiceBase a where a.id= :id")
})


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
	public InvoiceBase() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Job> jobs;
	/**
	 * @generated
 	 */
	public java.util.List<Job> getJobs(){
		return jobs; 
	}

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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<Charge> markupCharges;
	/**
	 * @generated
 	 */
	public java.util.List<Charge> getMarkupCharges(){
		return markupCharges; 
	}

	public void addMarkupCharges(Charge obj) {
		if (markupCharges == null) {
			markupCharges = new java.util.ArrayList<Charge>();
		}
		markupCharges.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setMarkupCharges(java.util.List<Charge> newVal) {
		this.markupCharges = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
    @OneToMany( cascade = {CascadeType.ALL})
	private java.util.List<NotePad> notes;
	/**
	 * @generated
 	 */
	public java.util.List<NotePad> getNotes(){
		return notes; 
	}

	public void addNotes(NotePad obj) {
		if (notes == null) {
			notes = new java.util.ArrayList<NotePad>();
		}
		notes.add(obj);
	}
	/**
	 * @generated
	 */	
	public void setNotes(java.util.List<NotePad> newVal) {
		this.notes = newVal;
	}
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
 	@Basic
	private Double shipCharges;
	/**
	 * @generated
 	 */
	public Double getShipCharges(){
		return shipCharges; 
	}

	/**
	 * @generated
	 */	
	public void setShipCharges(Double newVal) {
		this.shipCharges = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Double dollarDiscount;
	/**
	 * @generated
 	 */
	public Double getDollarDiscount(){
		return dollarDiscount; 
	}

	/**
	 * @generated
	 */	
	public void setDollarDiscount(Double newVal) {
		this.dollarDiscount = newVal;
	}
 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
 	
	
 	@Basic
	private Double subTotal;
	/**
	 * @generated
 	 */
	public Double getSubTotal(){
		return subTotal; 
	}

	/**
	 * @generated
	 */	
	public void setSubTotal(Double newVal) {
		this.subTotal = newVal;
	}
 	
	
 	@Basic
	private Double grandTotal;
	/**
	 * @generated
 	 */
	public Double getGrandTotal(){
		return grandTotal; 
	}

	/**
	 * @generated
	 */	
	public void setGrandTotal(Double newVal) {
		this.grandTotal = newVal;
	}
 	
	
 	@Basic
	private Double amountDue;
	/**
	 * @generated
 	 */
	public Double getAmountDue(){
		return amountDue; 
	}

	/**
	 * @generated
	 */	
	public void setAmountDue(Double newVal) {
		this.amountDue = newVal;
	}
 	
	
 	@Basic
	private Double totalCost;
	/**
	 * @generated
 	 */
	public Double getTotalCost(){
		return totalCost; 
	}

	/**
	 * @generated
	 */	
	public void setTotalCost(Double newVal) {
		this.totalCost = newVal;
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
		if (MARKUPCHARGES.equals(propertyName)) setMarkupCharges((java.util.List<Charge>)newValue); else
		if (SPECIALINSTRUCTIONS.equals(propertyName)) setSpecialInstructions((SpecialInstructions)newValue); else
		if (NOTES.equals(propertyName)) setNotes((java.util.List<NotePad>)newValue); else
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
		if (SHIPCHARGES.equals(propertyName)) setShipCharges((Double)newValue); else
		if (MARKUPS.equals(propertyName)) setMarkups((Double)newValue); else
		if (DISCOUNTFACTOR.equals(propertyName)) setDiscountFactor((Double)newValue); else
		if (DOLLARDISCOUNT.equals(propertyName)) setDollarDiscount((Double)newValue); else
		if (DISCOUNT.equals(propertyName)) setDiscount((Double)newValue); else
		if (TAXTABLE.equals(propertyName)) setTaxTable((TaxTable)newValue); else
		if (SUBTOTAL.equals(propertyName)) setSubTotal((Double)newValue); else
		if (GRANDTOTAL.equals(propertyName)) setGrandTotal((Double)newValue); else
		if (AMOUNTDUE.equals(propertyName)) setAmountDue((Double)newValue); else
		if (TOTALCOST.equals(propertyName)) setTotalCost((Double)newValue); else
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
			return new Class<?>[] {java.util.List.class, Charge.class};		
		if (SPECIALINSTRUCTIONS.equals(propertyName)) 
			return new Class<?>[] {SpecialInstructions.class};		
		if (NOTES.equals(propertyName)) 
			return new Class<?>[] {java.util.List.class, NotePad.class};		
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
			return new Class<?>[] {Double.class};		
		if (MARKUPS.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (DISCOUNTFACTOR.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (DOLLARDISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (DISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TAXTABLE.equals(propertyName)) 
			return new Class<?>[] {TaxTable.class};		
		if (SUBTOTAL.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (GRANDTOTAL.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (AMOUNTDUE.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (TOTALCOST.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
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
		return true;
	}			
}