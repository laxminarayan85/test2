
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
  @NamedQuery(name = "PricingRecord.findall", query = "from PricingRecord"),
  @NamedQuery(name = "PricingRecord.byId", query = "select a from PricingRecord a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "pricingrecord")
public class PricingRecord extends ModelBase {
	/**
	 * @generated
	 */
	public static final String PRICELOGENTRY = "PriceLogEntry";
	/**
	 * @generated
	 */
	public static final String UNITPRICE = "UnitPrice";
	/**
	 * @generated
	 */
	public static final String TOTALPRICE = "TotalPrice";
	/**
	 * @generated
	 */
	public static final String OTHERCHARGEPRICE = "OtherChargePrice";
	/**
	 * @generated
	 */
	public static final String PREPPRICE = "PrepPrice";
	/**
	 * @generated
	 */
	public static final String OVERSTOTALPRICE = "OversTotalPrice";
	/**
	 * @generated
	 */
	public static final String BINDPRICE = "BindPrice";
	/**
	 * @generated
	 */
	public static final String OVERSUNITPRICE = "OversUnitPrice";
	/**
	 * @generated
	 */
	public static final String UNITPRICEOVERRIDE = "UnitPriceOverride";
	/**
	 * @generated
	 */
	public static final String TOTALPRICEOVERRIDE = "TotalPriceOverride";
	/**
	 * @generated
	 */
	public static final String LABORTOTALPRICE = "LaborTotalPrice";
	/**
	 * @generated
	 */
	public static final String LABORTOTALPRICEOVERRIDE = "LaborTotalPriceOverride";
	/**
	 * @generated
	 */
	public static final String STOCKTOTALPRICE = "StockTotalPrice";
	/**
	 * @generated
	 */
	public static final String STOCKTOTALPRICEOVERRIDE = "StockTotalPriceOverride";
	/**
	 * @generated
	 */
	public static final String STOCKMARKUP = "StockMarkup";

	/**
	 * @generated
	 */
	public PricingRecord() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private PriceLogEntry priceLogEntry;
	
	/**
	 * @generated
 	 */
	public PriceLogEntry getPriceLogEntry(){
    return priceLogEntry; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceLogEntry(PriceLogEntry newVal) {
    this.priceLogEntry = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double unitPrice;
	
	/**
	 * @generated
 	 */
	public Double getUnitPrice(){
    return unitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitPrice(Double newVal) {
    this.unitPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double totalPrice;
	
	/**
	 * @generated
 	 */
	public Double getTotalPrice(){
    return totalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalPrice(Double newVal) {
    this.totalPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double otherChargePrice;
	
	/**
	 * @generated
 	 */
	public Double getOtherChargePrice(){
    return otherChargePrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOtherChargePrice(Double newVal) {
    this.otherChargePrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double prepPrice;
	
	/**
	 * @generated
 	 */
	public Double getPrepPrice(){
    return prepPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrepPrice(Double newVal) {
    this.prepPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double oversTotalPrice;
	
	/**
	 * @generated
 	 */
	public Double getOversTotalPrice(){
    return oversTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOversTotalPrice(Double newVal) {
    this.oversTotalPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bindPrice;
	
	/**
	 * @generated
 	 */
	public Double getBindPrice(){
    return bindPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setBindPrice(Double newVal) {
    this.bindPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double oversUnitPrice;
	
	/**
	 * @generated
 	 */
	public Double getOversUnitPrice(){
    return oversUnitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOversUnitPrice(Double newVal) {
    this.oversUnitPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean unitPriceOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getUnitPriceOverride(){
    return unitPriceOverride; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitPriceOverride(Boolean newVal) {
    this.unitPriceOverride = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean totalPriceOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getTotalPriceOverride(){
    return totalPriceOverride; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalPriceOverride(Boolean newVal) {
    this.totalPriceOverride = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double laborTotalPrice;
	
	/**
	 * @generated
 	 */
	public Double getLaborTotalPrice(){
    return laborTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborTotalPrice(Double newVal) {
    this.laborTotalPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean laborTotalPriceOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getLaborTotalPriceOverride(){
    return laborTotalPriceOverride; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborTotalPriceOverride(Boolean newVal) {
    this.laborTotalPriceOverride = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stockTotalPrice;
	
	/**
	 * @generated
 	 */
	public Double getStockTotalPrice(){
    return stockTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockTotalPrice(Double newVal) {
    this.stockTotalPrice = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean stockTotalPriceOverride;
	
	/**
	 * @generated
 	 */
	public Boolean getStockTotalPriceOverride(){
    return stockTotalPriceOverride; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockTotalPriceOverride(Boolean newVal) {
    this.stockTotalPriceOverride = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stockMarkup;
	
	/**
	 * @generated
 	 */
	public Double getStockMarkup(){
    return stockMarkup; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockMarkup(Double newVal) {
    this.stockMarkup = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PRICELOGENTRY.equals(propertyName)) return getPriceLogEntry();
    if (UNITPRICE.equals(propertyName)) return getUnitPrice();
    if (TOTALPRICE.equals(propertyName)) return getTotalPrice();
    if (OTHERCHARGEPRICE.equals(propertyName)) return getOtherChargePrice();
    if (PREPPRICE.equals(propertyName)) return getPrepPrice();
    if (OVERSTOTALPRICE.equals(propertyName)) return getOversTotalPrice();
    if (BINDPRICE.equals(propertyName)) return getBindPrice();
    if (OVERSUNITPRICE.equals(propertyName)) return getOversUnitPrice();
    if (UNITPRICEOVERRIDE.equals(propertyName)) return getUnitPriceOverride();
    if (TOTALPRICEOVERRIDE.equals(propertyName)) return getTotalPriceOverride();
    if (LABORTOTALPRICE.equals(propertyName)) return getLaborTotalPrice();
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) return getLaborTotalPriceOverride();
    if (STOCKTOTALPRICE.equals(propertyName)) return getStockTotalPrice();
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) return getStockTotalPriceOverride();
    if (STOCKMARKUP.equals(propertyName)) return getStockMarkup();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PRICELOGENTRY.equals(propertyName)) setPriceLogEntry((PriceLogEntry)newValue); else
    if (UNITPRICE.equals(propertyName)) setUnitPrice((Double)newValue); else
    if (TOTALPRICE.equals(propertyName)) setTotalPrice((Double)newValue); else
    if (OTHERCHARGEPRICE.equals(propertyName)) setOtherChargePrice((Double)newValue); else
    if (PREPPRICE.equals(propertyName)) setPrepPrice((Double)newValue); else
    if (OVERSTOTALPRICE.equals(propertyName)) setOversTotalPrice((Double)newValue); else
    if (BINDPRICE.equals(propertyName)) setBindPrice((Double)newValue); else
    if (OVERSUNITPRICE.equals(propertyName)) setOversUnitPrice((Double)newValue); else
    if (UNITPRICEOVERRIDE.equals(propertyName)) setUnitPriceOverride((Boolean)newValue); else
    if (TOTALPRICEOVERRIDE.equals(propertyName)) setTotalPriceOverride((Boolean)newValue); else
    if (LABORTOTALPRICE.equals(propertyName)) setLaborTotalPrice((Double)newValue); else
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) setLaborTotalPriceOverride((Boolean)newValue); else
    if (STOCKTOTALPRICE.equals(propertyName)) setStockTotalPrice((Double)newValue); else
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) setStockTotalPriceOverride((Boolean)newValue); else
    if (STOCKMARKUP.equals(propertyName)) setStockMarkup((Double)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PRICELOGENTRY.equals(propertyName)) 
      return new Class<?>[] {PriceLogEntry.class};		
    if (UNITPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (OTHERCHARGEPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PREPPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (OVERSTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BINDPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (OVERSUNITPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (UNITPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LABORTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKMARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PRICELOGENTRY.equals(propertyName)) return PricingRecord.class;
    if (UNITPRICE.equals(propertyName)) return PricingRecord.class;
    if (TOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (OTHERCHARGEPRICE.equals(propertyName)) return PricingRecord.class;
    if (PREPPRICE.equals(propertyName)) return PricingRecord.class;
    if (OVERSTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (BINDPRICE.equals(propertyName)) return PricingRecord.class;
    if (OVERSUNITPRICE.equals(propertyName)) return PricingRecord.class;
    if (UNITPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (TOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (LABORTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (STOCKTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (STOCKMARKUP.equals(propertyName)) return PricingRecord.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PricingRecord objT = (PricingRecord)obj;
    if (! SmartEquals(getPriceLogEntry(), objT.getPriceLogEntry()))
      return false;
    if (! SmartEquals(getUnitPrice(), objT.getUnitPrice()))
      return false;
    if (! SmartEquals(getTotalPrice(), objT.getTotalPrice()))
      return false;
    if (! SmartEquals(getOtherChargePrice(), objT.getOtherChargePrice()))
      return false;
    if (! SmartEquals(getPrepPrice(), objT.getPrepPrice()))
      return false;
    if (! SmartEquals(getOversTotalPrice(), objT.getOversTotalPrice()))
      return false;
    if (! SmartEquals(getBindPrice(), objT.getBindPrice()))
      return false;
    if (! SmartEquals(getOversUnitPrice(), objT.getOversUnitPrice()))
      return false;
    if (! SmartEquals(getUnitPriceOverride(), objT.getUnitPriceOverride()))
      return false;
    if (! SmartEquals(getTotalPriceOverride(), objT.getTotalPriceOverride()))
      return false;
    if (! SmartEquals(getLaborTotalPrice(), objT.getLaborTotalPrice()))
      return false;
    if (! SmartEquals(getLaborTotalPriceOverride(), objT.getLaborTotalPriceOverride()))
      return false;
    if (! SmartEquals(getStockTotalPrice(), objT.getStockTotalPrice()))
      return false;
    if (! SmartEquals(getStockTotalPriceOverride(), objT.getStockTotalPriceOverride()))
      return false;
    if (! SmartEquals(getStockMarkup(), objT.getStockMarkup()))
      return false;
    return true;
  }			
}
