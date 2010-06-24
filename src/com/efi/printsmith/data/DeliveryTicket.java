
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
  @NamedQuery(name = "DeliveryTicket.findall", query = "from DeliveryTicket"),
  @NamedQuery(name = "DeliveryTicket.byId", query = "select a from DeliveryTicket a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "deliveryticket")
public class DeliveryTicket extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String TICKETNUMBER = "TicketNumber";
	/**
	 * @generated
	 */
	public static final String TOADDRESS = "ToAddress";
	/**
	 * @generated
	 */
	public static final String FROMADDRESS = "FromAddress";
	/**
	 * @generated
	 */
	public static final String TOADDRESSID = "ToAddressID";
	/**
	 * @generated
	 */
	public static final String FROMADDRESSID = "FromAddressID";
	/**
	 * @generated
	 */
	public static final String DELIVERYCONTACT = "DeliveryContact";
	/**
	 * @generated
	 */
	public static final String TAKENBY = "TakenBy";
	/**
	 * @generated
	 */
	public static final String DELIVERYDATE = "DeliveryDate";
	/**
	 * @generated
	 */
	public static final String CUSTOMERPO = "CustomerPO";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBER = "OrderNumber";
	/**
	 * @generated
	 */
	public static final String TRACKINGNUMBER = "TrackingNumber";
	/**
	 * @generated
	 */
	public static final String PARTNUMBER = "PartNumber";
	/**
	 * @generated
	 */
	public static final String REFERENCE = "Reference";
	/**
	 * @generated
	 */
	public static final String SHIPMODE = "ShipMode";
	/**
	 * @generated
	 */
	public static final String SHIPCOST = "ShipCost";
	/**
	 * @generated
	 */
	public static final String TOTALWEIGHT = "TotalWeight";
	/**
	 * @generated
	 */
	public static final String CARTONCOUNT = "CartonCount";
	/**
	 * @generated
	 */
	public static final String ITEMSPERCARTON = "ItemsPerCarton";
	/**
	 * @generated
	 */
	public static final String TOTALITEMSINCARTON = "TotalItemsInCarton";
	/**
	 * @generated
	 */
	public static final String LABELSKIPCOUNT = "LabelSkipCount";
	/**
	 * @generated
	 */
	public static final String PRECOMMENT = "PreComment";
	/**
	 * @generated
	 */
	public static final String POSTCOMMENT = "PostComment";
	/**
	 * @generated
	 */
	public static final String LABELSTARTCOUNT = "LabelStartCount";
	/**
	 * @generated
	 */
	public static final String DRIVER = "Driver";
	/**
	 * @generated
	 */
	public static final String WEBORDERSHIPPINGID = "WebOrderShippingID";
	/**
	 * @generated
	 */
	public static final String FROMOTHER = "FromOther";
	/**
	 * @generated
	 */
	public static final String TOOTHER = "ToOther";
	/**
	 * @generated
	 */
	public static final String ATTOTHER = "AttOther";
	/**
	 * @generated
	 */
	public static final String OWEIGHT = "OWeight";
	/**
	 * @generated
	 */
	public static final String COD = "Cod";
	/**
	 * @generated
	 */
	public static final String EMAILOTHER = "EmailOther";
	/**
	 * @generated
	 */
	public static final String EMAIL = "Email";
	/**
	 * @generated
	 */
	public static final String ARCHIVE = "Archive";
	/**
	 * @generated
	 */
	public static final String ATTNAMECHECK = "AttNameCheck";
	/**
	 * @generated
	 */
	public static final String CUSTOMERNAMECHECK = "CustomerNameCheck";
	/**
	 * @generated
	 */
	public static final String ADDRESSCHECK = "AddressCheck";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBERCHECK = "OrderNumberCheck";
	/**
	 * @generated
	 */
	public static final String DELIVERYDESCCHECK = "DeliveryDescCheck";
	/**
	 * @generated
	 */
	public static final String DELIVERYCOMMENTSCHECK = "DeliveryCommentsCheck";
	/**
	 * @generated
	 */
	public static final String PONUMBERCHECK = "PoNumberCheck";
	/**
	 * @generated
	 */
	public static final String ESTWEIGHTCHECK = "EstWeightCheck";
	/**
	 * @generated
	 */
	public static final String DATETYPE = "DateType";
	/**
	 * @generated
	 */
	public static final String DELIVERYJOBS = "DeliveryJobs";

	/**
	 * @generated
	 */
	public DeliveryTicket() {
    this.created = new Date();
    this.modified = new Date();
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
	private Integer ticketNumber;
	
	/**
	 * @generated
 	 */
	public Integer getTicketNumber(){
    return ticketNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setTicketNumber(Integer newVal) {
    this.ticketNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Address toAddress;
	
	/**
	 * @generated
 	 */
	public Address getToAddress(){
    return toAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setToAddress(Address newVal) {
    this.toAddress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Address fromAddress;
	
	/**
	 * @generated
 	 */
	public Address getFromAddress(){
    return fromAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setFromAddress(Address newVal) {
    this.fromAddress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long toAddressID;
	
	/**
	 * @generated
 	 */
	public Long getToAddressID(){
    return toAddressID; 
  }

	
	/**
	 * @generated
	 */	
	public void setToAddressID(Long newVal) {
    this.toAddressID = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fromAddressID;
	
	/**
	 * @generated
 	 */
	public Long getFromAddressID(){
    return fromAddressID; 
  }

	
	/**
	 * @generated
	 */	
	public void setFromAddressID(Long newVal) {
    this.fromAddressID = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Contact deliveryContact;
	
	/**
	 * @generated
 	 */
	public Contact getDeliveryContact(){
    return deliveryContact; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeliveryContact(Contact newVal) {
    this.deliveryContact = newVal;
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
	private Date deliveryDate;
	
	/**
	 * @generated
 	 */
	public Date getDeliveryDate(){
    return deliveryDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeliveryDate(Date newVal) {
    this.deliveryDate = newVal;
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
	private Integer orderNumber;
	
	/**
	 * @generated
 	 */
	public Integer getOrderNumber(){
    return orderNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderNumber(Integer newVal) {
    this.orderNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String trackingNumber;
	
	/**
	 * @generated
 	 */
	public String getTrackingNumber(){
    return trackingNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackingNumber(String newVal) {
    this.trackingNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String partNumber;
	
	/**
	 * @generated
 	 */
	public String getPartNumber(){
    return partNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setPartNumber(String newVal) {
    this.partNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String reference;
	
	/**
	 * @generated
 	 */
	public String getReference(){
    return reference; 
  }

	
	/**
	 * @generated
	 */	
	public void setReference(String newVal) {
    this.reference = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private ShippingMethod shipMode;
	
	/**
	 * @generated
 	 */
	public ShippingMethod getShipMode(){
    return shipMode; 
  }

	
	/**
	 * @generated
	 */	
	public void setShipMode(ShippingMethod newVal) {
    this.shipMode = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal shipCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getShipCost(){
    return shipCost; 
  }

	
	/**
   * @generated
   */	
  public void setShipCost(BigDecimal newVal) {
    this.shipCost = newVal;
  }


	/**
   * @generated
   */	
  public void setShipCost(double newVal) {
    this.shipCost = BigDecimal.valueOf(newVal);
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Float totalWeight;
	
	/**
	 * @generated
 	 */
	public Float getTotalWeight(){
    return totalWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalWeight(Float newVal) {
    this.totalWeight = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer cartonCount;
	
	/**
	 * @generated
 	 */
	public Integer getCartonCount(){
    return cartonCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setCartonCount(Integer newVal) {
    this.cartonCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer itemsPerCarton;
	
	/**
	 * @generated
 	 */
	public Integer getItemsPerCarton(){
    return itemsPerCarton; 
  }

	
	/**
	 * @generated
	 */	
	public void setItemsPerCarton(Integer newVal) {
    this.itemsPerCarton = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer totalItemsInCarton;
	
	/**
	 * @generated
 	 */
	public Integer getTotalItemsInCarton(){
    return totalItemsInCarton; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalItemsInCarton(Integer newVal) {
    this.totalItemsInCarton = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer labelSkipCount;
	
	/**
	 * @generated
 	 */
	public Integer getLabelSkipCount(){
    return labelSkipCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setLabelSkipCount(Integer newVal) {
    this.labelSkipCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String preComment;
	
	/**
	 * @generated
 	 */
	public String getPreComment(){
    return preComment; 
  }

	
	/**
	 * @generated
	 */	
	public void setPreComment(String newVal) {
    this.preComment = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String postComment;
	
	/**
	 * @generated
 	 */
	public String getPostComment(){
    return postComment; 
  }

	
	/**
	 * @generated
	 */	
	public void setPostComment(String newVal) {
    this.postComment = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer labelStartCount;
	
	/**
	 * @generated
 	 */
	public Integer getLabelStartCount(){
    return labelStartCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setLabelStartCount(Integer newVal) {
    this.labelStartCount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private Driver driver;
	
	/**
	 * @generated
 	 */
	public Driver getDriver(){
    return driver; 
  }

	
	/**
	 * @generated
	 */	
	public void setDriver(Driver newVal) {
    this.driver = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long webOrderShippingID;
	
	/**
	 * @generated
 	 */
	public Long getWebOrderShippingID(){
    return webOrderShippingID; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebOrderShippingID(Long newVal) {
    this.webOrderShippingID = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean fromOther;
	
	/**
	 * @generated
 	 */
	public Boolean getFromOther(){
    return fromOther; 
  }

	
	/**
	 * @generated
	 */	
	public void setFromOther(Boolean newVal) {
    this.fromOther = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean toOther;
	
	/**
	 * @generated
 	 */
	public Boolean getToOther(){
    return toOther; 
  }

	
	/**
	 * @generated
	 */	
	public void setToOther(Boolean newVal) {
    this.toOther = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean attOther;
	
	/**
	 * @generated
 	 */
	public Boolean getAttOther(){
    return attOther; 
  }

	
	/**
	 * @generated
	 */	
	public void setAttOther(Boolean newVal) {
    this.attOther = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean oWeight;
	
	/**
	 * @generated
 	 */
	public Boolean getOWeight(){
    return oWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setOWeight(Boolean newVal) {
    this.oWeight = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean cod;
	
	/**
	 * @generated
 	 */
	public Boolean getCod(){
    return cod; 
  }

	
	/**
	 * @generated
	 */	
	public void setCod(Boolean newVal) {
    this.cod = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean emailOther;
	
	/**
	 * @generated
 	 */
	public Boolean getEmailOther(){
    return emailOther; 
  }

	
	/**
	 * @generated
	 */	
	public void setEmailOther(Boolean newVal) {
    this.emailOther = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String email;
	
	/**
	 * @generated
 	 */
	public String getEmail(){
    return email; 
  }

	
	/**
	 * @generated
	 */	
	public void setEmail(String newVal) {
    this.email = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean archive;
	
	/**
	 * @generated
 	 */
	public Boolean getArchive(){
    return archive; 
  }

	
	/**
	 * @generated
	 */	
	public void setArchive(Boolean newVal) {
    this.archive = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean attNameCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getAttNameCheck(){
    return attNameCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setAttNameCheck(Boolean newVal) {
    this.attNameCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean customerNameCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getCustomerNameCheck(){
    return customerNameCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerNameCheck(Boolean newVal) {
    this.customerNameCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean addressCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getAddressCheck(){
    return addressCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddressCheck(Boolean newVal) {
    this.addressCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean orderNumberCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getOrderNumberCheck(){
    return orderNumberCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderNumberCheck(Boolean newVal) {
    this.orderNumberCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean deliveryDescCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getDeliveryDescCheck(){
    return deliveryDescCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeliveryDescCheck(Boolean newVal) {
    this.deliveryDescCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean deliveryCommentsCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getDeliveryCommentsCheck(){
    return deliveryCommentsCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setDeliveryCommentsCheck(Boolean newVal) {
    this.deliveryCommentsCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean poNumberCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getPoNumberCheck(){
    return poNumberCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoNumberCheck(Boolean newVal) {
    this.poNumberCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean estWeightCheck;
	
	/**
	 * @generated
 	 */
	public Boolean getEstWeightCheck(){
    return estWeightCheck; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstWeightCheck(Boolean newVal) {
    this.estWeightCheck = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String dateType;
	
	/**
	 * @generated
 	 */
	public String getDateType(){
    return dateType; 
  }

	
	/**
	 * @generated
	 */	
	public void setDateType(String newVal) {
    this.dateType = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "deliveryticket_deliveryjobs")
	private java.util.List<DeliveryTicketJobs> deliveryJobs;
	
	/**
	 * @generated
 	 */
	public java.util.List<DeliveryTicketJobs> getDeliveryJobs(){
    return deliveryJobs; 
  }

	/**
	 * @generated
	 */	
	public void addDeliveryJobs(DeliveryTicketJobs obj) {
    if (deliveryJobs == null) {
      deliveryJobs = new java.util.ArrayList<DeliveryTicketJobs>();
    }
    deliveryJobs.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setDeliveryJobs(java.util.List<DeliveryTicketJobs> newVal) {
    this.deliveryJobs = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (TICKETNUMBER.equals(propertyName)) return getTicketNumber();
    if (TOADDRESS.equals(propertyName)) return getToAddress();
    if (FROMADDRESS.equals(propertyName)) return getFromAddress();
    if (TOADDRESSID.equals(propertyName)) return getToAddressID();
    if (FROMADDRESSID.equals(propertyName)) return getFromAddressID();
    if (DELIVERYCONTACT.equals(propertyName)) return getDeliveryContact();
    if (TAKENBY.equals(propertyName)) return getTakenBy();
    if (DELIVERYDATE.equals(propertyName)) return getDeliveryDate();
    if (CUSTOMERPO.equals(propertyName)) return getCustomerPO();
    if (ORDERNUMBER.equals(propertyName)) return getOrderNumber();
    if (TRACKINGNUMBER.equals(propertyName)) return getTrackingNumber();
    if (PARTNUMBER.equals(propertyName)) return getPartNumber();
    if (REFERENCE.equals(propertyName)) return getReference();
    if (SHIPMODE.equals(propertyName)) return getShipMode();
    if (SHIPCOST.equals(propertyName)) return getShipCost();
    if (TOTALWEIGHT.equals(propertyName)) return getTotalWeight();
    if (CARTONCOUNT.equals(propertyName)) return getCartonCount();
    if (ITEMSPERCARTON.equals(propertyName)) return getItemsPerCarton();
    if (TOTALITEMSINCARTON.equals(propertyName)) return getTotalItemsInCarton();
    if (LABELSKIPCOUNT.equals(propertyName)) return getLabelSkipCount();
    if (PRECOMMENT.equals(propertyName)) return getPreComment();
    if (POSTCOMMENT.equals(propertyName)) return getPostComment();
    if (LABELSTARTCOUNT.equals(propertyName)) return getLabelStartCount();
    if (DRIVER.equals(propertyName)) return getDriver();
    if (WEBORDERSHIPPINGID.equals(propertyName)) return getWebOrderShippingID();
    if (FROMOTHER.equals(propertyName)) return getFromOther();
    if (TOOTHER.equals(propertyName)) return getToOther();
    if (ATTOTHER.equals(propertyName)) return getAttOther();
    if (OWEIGHT.equals(propertyName)) return getOWeight();
    if (COD.equals(propertyName)) return getCod();
    if (EMAILOTHER.equals(propertyName)) return getEmailOther();
    if (EMAIL.equals(propertyName)) return getEmail();
    if (ARCHIVE.equals(propertyName)) return getArchive();
    if (ATTNAMECHECK.equals(propertyName)) return getAttNameCheck();
    if (CUSTOMERNAMECHECK.equals(propertyName)) return getCustomerNameCheck();
    if (ADDRESSCHECK.equals(propertyName)) return getAddressCheck();
    if (ORDERNUMBERCHECK.equals(propertyName)) return getOrderNumberCheck();
    if (DELIVERYDESCCHECK.equals(propertyName)) return getDeliveryDescCheck();
    if (DELIVERYCOMMENTSCHECK.equals(propertyName)) return getDeliveryCommentsCheck();
    if (PONUMBERCHECK.equals(propertyName)) return getPoNumberCheck();
    if (ESTWEIGHTCHECK.equals(propertyName)) return getEstWeightCheck();
    if (DATETYPE.equals(propertyName)) return getDateType();
    if (DELIVERYJOBS.equals(propertyName)) return getDeliveryJobs();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (TICKETNUMBER.equals(propertyName)) setTicketNumber((Integer)newValue); else
    if (TOADDRESS.equals(propertyName)) setToAddress((Address)newValue); else
    if (FROMADDRESS.equals(propertyName)) setFromAddress((Address)newValue); else
    if (TOADDRESSID.equals(propertyName)) setToAddressID((Long)newValue); else
    if (FROMADDRESSID.equals(propertyName)) setFromAddressID((Long)newValue); else
    if (DELIVERYCONTACT.equals(propertyName)) setDeliveryContact((Contact)newValue); else
    if (TAKENBY.equals(propertyName)) setTakenBy((String)newValue); else
    if (DELIVERYDATE.equals(propertyName)) setDeliveryDate((Date)newValue); else
    if (CUSTOMERPO.equals(propertyName)) setCustomerPO((String)newValue); else
    if (ORDERNUMBER.equals(propertyName)) setOrderNumber((Integer)newValue); else
    if (TRACKINGNUMBER.equals(propertyName)) setTrackingNumber((String)newValue); else
    if (PARTNUMBER.equals(propertyName)) setPartNumber((String)newValue); else
    if (REFERENCE.equals(propertyName)) setReference((String)newValue); else
    if (SHIPMODE.equals(propertyName)) setShipMode((ShippingMethod)newValue); else
    if (SHIPCOST.equals(propertyName)) setShipCost((BigDecimal)newValue); else
    if (TOTALWEIGHT.equals(propertyName)) setTotalWeight((Float)newValue); else
    if (CARTONCOUNT.equals(propertyName)) setCartonCount((Integer)newValue); else
    if (ITEMSPERCARTON.equals(propertyName)) setItemsPerCarton((Integer)newValue); else
    if (TOTALITEMSINCARTON.equals(propertyName)) setTotalItemsInCarton((Integer)newValue); else
    if (LABELSKIPCOUNT.equals(propertyName)) setLabelSkipCount((Integer)newValue); else
    if (PRECOMMENT.equals(propertyName)) setPreComment((String)newValue); else
    if (POSTCOMMENT.equals(propertyName)) setPostComment((String)newValue); else
    if (LABELSTARTCOUNT.equals(propertyName)) setLabelStartCount((Integer)newValue); else
    if (DRIVER.equals(propertyName)) setDriver((Driver)newValue); else
    if (WEBORDERSHIPPINGID.equals(propertyName)) setWebOrderShippingID((Long)newValue); else
    if (FROMOTHER.equals(propertyName)) setFromOther((Boolean)newValue); else
    if (TOOTHER.equals(propertyName)) setToOther((Boolean)newValue); else
    if (ATTOTHER.equals(propertyName)) setAttOther((Boolean)newValue); else
    if (OWEIGHT.equals(propertyName)) setOWeight((Boolean)newValue); else
    if (COD.equals(propertyName)) setCod((Boolean)newValue); else
    if (EMAILOTHER.equals(propertyName)) setEmailOther((Boolean)newValue); else
    if (EMAIL.equals(propertyName)) setEmail((String)newValue); else
    if (ARCHIVE.equals(propertyName)) setArchive((Boolean)newValue); else
    if (ATTNAMECHECK.equals(propertyName)) setAttNameCheck((Boolean)newValue); else
    if (CUSTOMERNAMECHECK.equals(propertyName)) setCustomerNameCheck((Boolean)newValue); else
    if (ADDRESSCHECK.equals(propertyName)) setAddressCheck((Boolean)newValue); else
    if (ORDERNUMBERCHECK.equals(propertyName)) setOrderNumberCheck((Boolean)newValue); else
    if (DELIVERYDESCCHECK.equals(propertyName)) setDeliveryDescCheck((Boolean)newValue); else
    if (DELIVERYCOMMENTSCHECK.equals(propertyName)) setDeliveryCommentsCheck((Boolean)newValue); else
    if (PONUMBERCHECK.equals(propertyName)) setPoNumberCheck((Boolean)newValue); else
    if (ESTWEIGHTCHECK.equals(propertyName)) setEstWeightCheck((Boolean)newValue); else
    if (DATETYPE.equals(propertyName)) setDateType((String)newValue); else
    if (DELIVERYJOBS.equals(propertyName)) setDeliveryJobs((java.util.List<DeliveryTicketJobs>)newValue); else
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
    if (TICKETNUMBER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TOADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (FROMADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (TOADDRESSID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (FROMADDRESSID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (DELIVERYCONTACT.equals(propertyName)) 
      return new Class<?>[] {Contact.class};		
    if (TAKENBY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DELIVERYDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CUSTOMERPO.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ORDERNUMBER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TRACKINGNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARTNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REFERENCE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHIPMODE.equals(propertyName)) 
      return new Class<?>[] {ShippingMethod.class};		
    if (SHIPCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (TOTALWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Float.class};		
    if (CARTONCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ITEMSPERCARTON.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TOTALITEMSINCARTON.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LABELSKIPCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (PRECOMMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (POSTCOMMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (LABELSTARTCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DRIVER.equals(propertyName)) 
      return new Class<?>[] {Driver.class};		
    if (WEBORDERSHIPPINGID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (FROMOTHER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TOOTHER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ATTOTHER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (OWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EMAILOTHER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EMAIL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ARCHIVE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ATTNAMECHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CUSTOMERNAMECHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADDRESSCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ORDERNUMBERCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DELIVERYDESCCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DELIVERYCOMMENTSCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PONUMBERCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ESTWEIGHTCHECK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DATETYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DELIVERYJOBS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, DeliveryTicketJobs.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return DeliveryTicket.class;
    if (TICKETNUMBER.equals(propertyName)) return DeliveryTicket.class;
    if (TOADDRESS.equals(propertyName)) return DeliveryTicket.class;
    if (FROMADDRESS.equals(propertyName)) return DeliveryTicket.class;
    if (TOADDRESSID.equals(propertyName)) return DeliveryTicket.class;
    if (FROMADDRESSID.equals(propertyName)) return DeliveryTicket.class;
    if (DELIVERYCONTACT.equals(propertyName)) return DeliveryTicket.class;
    if (TAKENBY.equals(propertyName)) return DeliveryTicket.class;
    if (DELIVERYDATE.equals(propertyName)) return DeliveryTicket.class;
    if (CUSTOMERPO.equals(propertyName)) return DeliveryTicket.class;
    if (ORDERNUMBER.equals(propertyName)) return DeliveryTicket.class;
    if (TRACKINGNUMBER.equals(propertyName)) return DeliveryTicket.class;
    if (PARTNUMBER.equals(propertyName)) return DeliveryTicket.class;
    if (REFERENCE.equals(propertyName)) return DeliveryTicket.class;
    if (SHIPMODE.equals(propertyName)) return DeliveryTicket.class;
    if (SHIPCOST.equals(propertyName)) return DeliveryTicket.class;
    if (TOTALWEIGHT.equals(propertyName)) return DeliveryTicket.class;
    if (CARTONCOUNT.equals(propertyName)) return DeliveryTicket.class;
    if (ITEMSPERCARTON.equals(propertyName)) return DeliveryTicket.class;
    if (TOTALITEMSINCARTON.equals(propertyName)) return DeliveryTicket.class;
    if (LABELSKIPCOUNT.equals(propertyName)) return DeliveryTicket.class;
    if (PRECOMMENT.equals(propertyName)) return DeliveryTicket.class;
    if (POSTCOMMENT.equals(propertyName)) return DeliveryTicket.class;
    if (LABELSTARTCOUNT.equals(propertyName)) return DeliveryTicket.class;
    if (DRIVER.equals(propertyName)) return DeliveryTicket.class;
    if (WEBORDERSHIPPINGID.equals(propertyName)) return DeliveryTicket.class;
    if (FROMOTHER.equals(propertyName)) return DeliveryTicket.class;
    if (TOOTHER.equals(propertyName)) return DeliveryTicket.class;
    if (ATTOTHER.equals(propertyName)) return DeliveryTicket.class;
    if (OWEIGHT.equals(propertyName)) return DeliveryTicket.class;
    if (COD.equals(propertyName)) return DeliveryTicket.class;
    if (EMAILOTHER.equals(propertyName)) return DeliveryTicket.class;
    if (EMAIL.equals(propertyName)) return DeliveryTicket.class;
    if (ARCHIVE.equals(propertyName)) return DeliveryTicket.class;
    if (ATTNAMECHECK.equals(propertyName)) return DeliveryTicket.class;
    if (CUSTOMERNAMECHECK.equals(propertyName)) return DeliveryTicket.class;
    if (ADDRESSCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (ORDERNUMBERCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (DELIVERYDESCCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (DELIVERYCOMMENTSCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (PONUMBERCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (ESTWEIGHTCHECK.equals(propertyName)) return DeliveryTicket.class;
    if (DATETYPE.equals(propertyName)) return DeliveryTicket.class;
    if (DELIVERYJOBS.equals(propertyName)) return DeliveryTicket.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DeliveryTicket objT = (DeliveryTicket)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getTicketNumber(), objT.getTicketNumber()))
      return false;
    if (! SmartEquals(getToAddress(), objT.getToAddress()))
      return false;
    if (! SmartEquals(getFromAddress(), objT.getFromAddress()))
      return false;
    if (! SmartEquals(getToAddressID(), objT.getToAddressID()))
      return false;
    if (! SmartEquals(getFromAddressID(), objT.getFromAddressID()))
      return false;
    if (! SmartEquals(getDeliveryContact(), objT.getDeliveryContact()))
      return false;
    if (! SmartEquals(getTakenBy(), objT.getTakenBy()))
      return false;
    if (! SmartEquals(getDeliveryDate(), objT.getDeliveryDate()))
      return false;
    if (! SmartEquals(getCustomerPO(), objT.getCustomerPO()))
      return false;
    if (! SmartEquals(getOrderNumber(), objT.getOrderNumber()))
      return false;
    if (! SmartEquals(getTrackingNumber(), objT.getTrackingNumber()))
      return false;
    if (! SmartEquals(getPartNumber(), objT.getPartNumber()))
      return false;
    if (! SmartEquals(getReference(), objT.getReference()))
      return false;
    if (! SmartEquals(getShipMode(), objT.getShipMode()))
      return false;
    if (! SmartEquals(getShipCost(), objT.getShipCost()))
      return false;
    if (! SmartEquals(getTotalWeight(), objT.getTotalWeight()))
      return false;
    if (! SmartEquals(getCartonCount(), objT.getCartonCount()))
      return false;
    if (! SmartEquals(getItemsPerCarton(), objT.getItemsPerCarton()))
      return false;
    if (! SmartEquals(getTotalItemsInCarton(), objT.getTotalItemsInCarton()))
      return false;
    if (! SmartEquals(getLabelSkipCount(), objT.getLabelSkipCount()))
      return false;
    if (! SmartEquals(getPreComment(), objT.getPreComment()))
      return false;
    if (! SmartEquals(getPostComment(), objT.getPostComment()))
      return false;
    if (! SmartEquals(getLabelStartCount(), objT.getLabelStartCount()))
      return false;
    if (! SmartEquals(getDriver(), objT.getDriver()))
      return false;
    if (! SmartEquals(getWebOrderShippingID(), objT.getWebOrderShippingID()))
      return false;
    if (! SmartEquals(getFromOther(), objT.getFromOther()))
      return false;
    if (! SmartEquals(getToOther(), objT.getToOther()))
      return false;
    if (! SmartEquals(getAttOther(), objT.getAttOther()))
      return false;
    if (! SmartEquals(getOWeight(), objT.getOWeight()))
      return false;
    if (! SmartEquals(getCod(), objT.getCod()))
      return false;
    if (! SmartEquals(getEmailOther(), objT.getEmailOther()))
      return false;
    if (! SmartEquals(getEmail(), objT.getEmail()))
      return false;
    if (! SmartEquals(getArchive(), objT.getArchive()))
      return false;
    if (! SmartEquals(getAttNameCheck(), objT.getAttNameCheck()))
      return false;
    if (! SmartEquals(getCustomerNameCheck(), objT.getCustomerNameCheck()))
      return false;
    if (! SmartEquals(getAddressCheck(), objT.getAddressCheck()))
      return false;
    if (! SmartEquals(getOrderNumberCheck(), objT.getOrderNumberCheck()))
      return false;
    if (! SmartEquals(getDeliveryDescCheck(), objT.getDeliveryDescCheck()))
      return false;
    if (! SmartEquals(getDeliveryCommentsCheck(), objT.getDeliveryCommentsCheck()))
      return false;
    if (! SmartEquals(getPoNumberCheck(), objT.getPoNumberCheck()))
      return false;
    if (! SmartEquals(getEstWeightCheck(), objT.getEstWeightCheck()))
      return false;
    if (! SmartEquals(getDateType(), objT.getDateType()))
      return false;
    if (! SmartEquals(getDeliveryJobs(), objT.getDeliveryJobs()))
      return false;
    return true;
  }			
}
