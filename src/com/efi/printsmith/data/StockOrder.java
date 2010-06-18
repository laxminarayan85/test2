
package com.efi.printsmith.data;

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
  @NamedQuery(name = "StockOrder.findall", query = "from StockOrder"),
  @NamedQuery(name = "StockOrder.byId", query = "select a from StockOrder a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "stockorder")
public class StockOrder extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
   * @generated
   */
  public static final String STOCKUNIT = "StockUnit";
	/**
	 * @generated
	 */
	public static final String INVOICENUMBER = "InvoiceNumber";
	/**
	 * @generated
	 */
	public static final String JOBNUMBER = "JobNumber";
	/**
	 * @generated
	 */
	public static final String VENDOR = "Vendor";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBER = "OrderNumber";
	/**
	 * @generated
	 */
	public static final String COLOR = "Color";
	/**
	 * @generated
	 */
	public static final String FINISH = "Finish";
	/**
	 * @generated
	 */
	public static final String COATED = "Coated";
	/**
	 * @generated
	 */
	public static final String WEIGHT = "Weight";
	/**
	 * @generated
	 */
	public static final String SHEETSIZE = "SheetSize";
	/**
	 * @generated
	 */
	public static final String COST = "Cost";
	/**
	 * @generated
	 */
	public static final String PER = "Per";
	/**
	 * @generated
	 */
	public static final String ROLLWEIGHT = "RollWeight";
	/**
	 * @generated
	 */
	public static final String ROLLWIDTH = "RollWidth";
	/**
	 * @generated
	 */
	public static final String ORDERQUANTITY = "OrderQuantity";
	/**
	 * @generated
	 */
	public static final String VENDORSTOCKNUMBER = "VendorStockNumber";
	/**
	 * @generated
	 */
	public static final String STOCKORDERNUMBER = "StockOrderNumber";
	/**
	 * @generated
	 */
	public static final String DELIVERYDATE = "DeliveryDate";
	/**
	 * @generated
	 */
	public static final String ENTERDATE = "EnterDate";
	/**
	 * @generated
	 */
	public static final String ALLOWMODIFACTION = "AllowModifaction";
	/**
	 * @generated
	 */
	public static final String PONUMBER = "PoNumber";

	/**
	 * @generated
	 */
	public StockOrder() {
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
  private Integer stockUnit;

	/**
   * @generated
 	 */
  public Integer getStockUnit(){
    return stockUnit; 
  }


	/**
   * @generated
   */	
  public void setStockUnit(Integer newVal) {
    this.stockUnit = newVal;
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
	private String orderNumber;
	
	/**
	 * @generated
 	 */
	public String getOrderNumber(){
    return orderNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderNumber(String newVal) {
    this.orderNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private StockColors color;
	
	/**
	 * @generated
 	 */
	public StockColors getColor(){
    return color; 
  }

	
	/**
	 * @generated
	 */	
	public void setColor(StockColors newVal) {
    this.color = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private StockFinish finish;
	
	/**
	 * @generated
 	 */
	public StockFinish getFinish(){
    return finish; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinish(StockFinish newVal) {
    this.finish = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean coated;
	
	/**
	 * @generated
 	 */
	public Boolean getCoated(){
    return coated; 
  }

	
	/**
	 * @generated
	 */	
	public void setCoated(Boolean newVal) {
    this.coated = newVal;
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
	private String sheetSize;
	
	/**
	 * @generated
 	 */
	public String getSheetSize(){
    return sheetSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setSheetSize(String newVal) {
    this.sheetSize = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost;
	
	/**
	 * @generated
 	 */
	public Double getCost(){
    return cost; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost(Double newVal) {
    this.cost = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double per;
	
	/**
	 * @generated
 	 */
	public Double getPer(){
    return per; 
  }

	
	/**
	 * @generated
	 */	
	public void setPer(Double newVal) {
    this.per = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double rollWeight;
	
	/**
	 * @generated
 	 */
	public Double getRollWeight(){
    return rollWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setRollWeight(Double newVal) {
    this.rollWeight = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String rollWidth;
	
	/**
	 * @generated
 	 */
	public String getRollWidth(){
    return rollWidth; 
  }

	
	/**
   * @generated
   */	
  public void setRollWidth(String newVal) {
    this.rollWidth = newVal;
  }


	/**
	 * @generated
	 */	
 	@Basic
	private Integer orderQuantity;
	
	/**
	 * @generated
 	 */
	public Integer getOrderQuantity(){
    return orderQuantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderQuantity(Integer newVal) {
    this.orderQuantity = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String vendorStockNumber;
	
	/**
	 * @generated
 	 */
	public String getVendorStockNumber(){
    return vendorStockNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setVendorStockNumber(String newVal) {
    this.vendorStockNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String stockOrderNumber;
	
	/**
	 * @generated
 	 */
	public String getStockOrderNumber(){
    return stockOrderNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockOrderNumber(String newVal) {
    this.stockOrderNumber = newVal;
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
	private Date enterDate;
	
	/**
	 * @generated
 	 */
	public Date getEnterDate(){
    return enterDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setEnterDate(Date newVal) {
    this.enterDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allowModifaction;
	
	/**
	 * @generated
 	 */
	public Boolean getAllowModifaction(){
    return allowModifaction; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllowModifaction(Boolean newVal) {
    this.allowModifaction = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String poNumber;
	
	/**
	 * @generated
 	 */
	public String getPoNumber(){
    return poNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoNumber(String newVal) {
    this.poNumber = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (STOCKUNIT.equals(propertyName)) return getStockUnit();
    if (INVOICENUMBER.equals(propertyName)) return getInvoiceNumber();
    if (JOBNUMBER.equals(propertyName)) return getJobNumber();
    if (VENDOR.equals(propertyName)) return getVendor();
    if (ORDERNUMBER.equals(propertyName)) return getOrderNumber();
    if (COLOR.equals(propertyName)) return getColor();
    if (FINISH.equals(propertyName)) return getFinish();
    if (COATED.equals(propertyName)) return getCoated();
    if (WEIGHT.equals(propertyName)) return getWeight();
    if (SHEETSIZE.equals(propertyName)) return getSheetSize();
    if (COST.equals(propertyName)) return getCost();
    if (PER.equals(propertyName)) return getPer();
    if (ROLLWEIGHT.equals(propertyName)) return getRollWeight();
    if (ROLLWIDTH.equals(propertyName)) return getRollWidth();
    if (ORDERQUANTITY.equals(propertyName)) return getOrderQuantity();
    if (VENDORSTOCKNUMBER.equals(propertyName)) return getVendorStockNumber();
    if (STOCKORDERNUMBER.equals(propertyName)) return getStockOrderNumber();
    if (DELIVERYDATE.equals(propertyName)) return getDeliveryDate();
    if (ENTERDATE.equals(propertyName)) return getEnterDate();
    if (ALLOWMODIFACTION.equals(propertyName)) return getAllowModifaction();
    if (PONUMBER.equals(propertyName)) return getPoNumber();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (STOCKUNIT.equals(propertyName)) setStockUnit((Integer)newValue); else
    if (INVOICENUMBER.equals(propertyName)) setInvoiceNumber((String)newValue); else
    if (JOBNUMBER.equals(propertyName)) setJobNumber((String)newValue); else
    if (VENDOR.equals(propertyName)) setVendor((Vendor)newValue); else
    if (ORDERNUMBER.equals(propertyName)) setOrderNumber((String)newValue); else
    if (COLOR.equals(propertyName)) setColor((StockColors)newValue); else
    if (FINISH.equals(propertyName)) setFinish((StockFinish)newValue); else
    if (COATED.equals(propertyName)) setCoated((Boolean)newValue); else
    if (WEIGHT.equals(propertyName)) setWeight((Double)newValue); else
    if (SHEETSIZE.equals(propertyName)) setSheetSize((String)newValue); else
    if (COST.equals(propertyName)) setCost((Double)newValue); else
    if (PER.equals(propertyName)) setPer((Double)newValue); else
    if (ROLLWEIGHT.equals(propertyName)) setRollWeight((Double)newValue); else
    if (ROLLWIDTH.equals(propertyName)) setRollWidth((String)newValue); else
    if (ORDERQUANTITY.equals(propertyName)) setOrderQuantity((Integer)newValue); else
    if (VENDORSTOCKNUMBER.equals(propertyName)) setVendorStockNumber((String)newValue); else
    if (STOCKORDERNUMBER.equals(propertyName)) setStockOrderNumber((String)newValue); else
    if (DELIVERYDATE.equals(propertyName)) setDeliveryDate((Date)newValue); else
    if (ENTERDATE.equals(propertyName)) setEnterDate((Date)newValue); else
    if (ALLOWMODIFACTION.equals(propertyName)) setAllowModifaction((Boolean)newValue); else
    if (PONUMBER.equals(propertyName)) setPoNumber((String)newValue); else
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
    if (STOCKUNIT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (INVOICENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VENDOR.equals(propertyName)) 
      return new Class<?>[] {Vendor.class};		
    if (ORDERNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COLOR.equals(propertyName)) 
      return new Class<?>[] {StockColors.class};		
    if (FINISH.equals(propertyName)) 
      return new Class<?>[] {StockFinish.class};		
    if (COATED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHEETSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COST.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PER.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ROLLWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ROLLWIDTH.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ORDERQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (VENDORSTOCKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STOCKORDERNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DELIVERYDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ENTERDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (ALLOWMODIFACTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PONUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return StockOrder.class;
    if (STOCKUNIT.equals(propertyName)) return StockOrder.class;
    if (INVOICENUMBER.equals(propertyName)) return StockOrder.class;
    if (JOBNUMBER.equals(propertyName)) return StockOrder.class;
    if (VENDOR.equals(propertyName)) return StockOrder.class;
    if (ORDERNUMBER.equals(propertyName)) return StockOrder.class;
    if (COLOR.equals(propertyName)) return StockOrder.class;
    if (FINISH.equals(propertyName)) return StockOrder.class;
    if (COATED.equals(propertyName)) return StockOrder.class;
    if (WEIGHT.equals(propertyName)) return StockOrder.class;
    if (SHEETSIZE.equals(propertyName)) return StockOrder.class;
    if (COST.equals(propertyName)) return StockOrder.class;
    if (PER.equals(propertyName)) return StockOrder.class;
    if (ROLLWEIGHT.equals(propertyName)) return StockOrder.class;
    if (ROLLWIDTH.equals(propertyName)) return StockOrder.class;
    if (ORDERQUANTITY.equals(propertyName)) return StockOrder.class;
    if (VENDORSTOCKNUMBER.equals(propertyName)) return StockOrder.class;
    if (STOCKORDERNUMBER.equals(propertyName)) return StockOrder.class;
    if (DELIVERYDATE.equals(propertyName)) return StockOrder.class;
    if (ENTERDATE.equals(propertyName)) return StockOrder.class;
    if (ALLOWMODIFACTION.equals(propertyName)) return StockOrder.class;
    if (PONUMBER.equals(propertyName)) return StockOrder.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    StockOrder objT = (StockOrder)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getStockUnit(), objT.getStockUnit()))
      return false;
    if (! SmartEquals(getInvoiceNumber(), objT.getInvoiceNumber()))
      return false;
    if (! SmartEquals(getJobNumber(), objT.getJobNumber()))
      return false;
    if (! SmartEquals(getVendor(), objT.getVendor()))
      return false;
    if (! SmartEquals(getOrderNumber(), objT.getOrderNumber()))
      return false;
    if (! SmartEquals(getColor(), objT.getColor()))
      return false;
    if (! SmartEquals(getFinish(), objT.getFinish()))
      return false;
    if (! SmartEquals(getCoated(), objT.getCoated()))
      return false;
    if (! SmartEquals(getWeight(), objT.getWeight()))
      return false;
    if (! SmartEquals(getSheetSize(), objT.getSheetSize()))
      return false;
    if (! SmartEquals(getCost(), objT.getCost()))
      return false;
    if (! SmartEquals(getPer(), objT.getPer()))
      return false;
    if (! SmartEquals(getRollWeight(), objT.getRollWeight()))
      return false;
    if (! SmartEquals(getRollWidth(), objT.getRollWidth()))
      return false;
    if (! SmartEquals(getOrderQuantity(), objT.getOrderQuantity()))
      return false;
    if (! SmartEquals(getVendorStockNumber(), objT.getVendorStockNumber()))
      return false;
    if (! SmartEquals(getStockOrderNumber(), objT.getStockOrderNumber()))
      return false;
    if (! SmartEquals(getDeliveryDate(), objT.getDeliveryDate()))
      return false;
    if (! SmartEquals(getEnterDate(), objT.getEnterDate()))
      return false;
    if (! SmartEquals(getAllowModifaction(), objT.getAllowModifaction()))
      return false;
    if (! SmartEquals(getPoNumber(), objT.getPoNumber()))
      return false;
    return true;
  }			
}
