
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql="update pricingrecord set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PricingRecord extends ModelBase {
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
	public static final String OTHERCHARGEPRICE = "OtherChargePrice";
	/**
	 * @generated
	 */
	public static final String PRICELOGENTRY = "PriceLogEntry";
	/**
	 * @generated
	 */
	public static final String TOTALPRICE = "TotalPrice";
	/**
	 * @generated
	 */
	public static final String UNITPRICE = "UnitPrice";
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
  public static final String PRODUCTIONPRICE = "ProductionPrice";
	/**
   * @generated
   */
  public static final String PRODUCTIONPRICEOVERRIDE = "ProductionPriceOverride";
	/**
   * @generated
   */
  public static final String STOCKCOST = "StockCost";
	/**
   * @generated
   */
  public static final String LABORCOST = "LaborCost";

	/**
   * @generated
   */
  public static final String LABORRATE = "LaborRate";
	/**
   * @generated
   */
  public static final String LABORRATEOVERRIDE = "LaborRateOverride";
	/**
   * @generated
   */
  public static final String LABORMARKUP = "LaborMarkup";
	/**
   * @generated
   */
  public static final String LABORMARKUPOVERRIDE = "LaborMarkupOverride";

	/**
	 * @generated
	 */
	public PricingRecord() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	@Basic
  private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
    return isDeleted;
  }


	public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }



	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal prepPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getPrepPrice(){
    return prepPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrepPrice(BigDecimal newVal) {
    this.prepPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setPrepPrice(double newVal) {
    this.prepPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal oversTotalPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getOversTotalPrice(){
    return oversTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOversTotalPrice(BigDecimal newVal) {
    this.oversTotalPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setOversTotalPrice(double newVal) {
    this.oversTotalPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal otherChargePrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getOtherChargePrice(){
    return otherChargePrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOtherChargePrice(BigDecimal newVal) {
    this.otherChargePrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setOtherChargePrice(double newVal) {
    this.otherChargePrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
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
	private BigDecimal totalPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getTotalPrice(){
    return totalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setTotalPrice(BigDecimal newVal) {
    this.totalPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setTotalPrice(double newVal) {
    this.totalPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal unitPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getUnitPrice(){
    return unitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setUnitPrice(BigDecimal newVal) {
    this.unitPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setUnitPrice(double newVal) {
    this.unitPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal bindPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getBindPrice(){
    return bindPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setBindPrice(BigDecimal newVal) {
    this.bindPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setBindPrice(double newVal) {
    this.bindPrice = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal oversUnitPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getOversUnitPrice(){
    return oversUnitPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setOversUnitPrice(BigDecimal newVal) {
    this.oversUnitPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setOversUnitPrice(double newVal) {
    this.oversUnitPrice = BigDecimal.valueOf(newVal);
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
	private BigDecimal laborTotalPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getLaborTotalPrice(){
    return laborTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setLaborTotalPrice(BigDecimal newVal) {
    this.laborTotalPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setLaborTotalPrice(double newVal) {
    this.laborTotalPrice = BigDecimal.valueOf(newVal);
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
	private BigDecimal stockTotalPrice;
	
	/**
	 * @generated
 	 */
	public BigDecimal getStockTotalPrice(){
    return stockTotalPrice; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockTotalPrice(BigDecimal newVal) {
    this.stockTotalPrice = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setStockTotalPrice(double newVal) {
    this.stockTotalPrice = BigDecimal.valueOf(newVal);
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
 	@Basic
  private BigDecimal productionPrice;

	/**
   * @generated
 	 */
  public BigDecimal getProductionPrice(){
    return productionPrice; 
  }


	/**
   * @generated
   */	
  public void setProductionPrice(BigDecimal newVal) {
    this.productionPrice = newVal;
  }


	/**
   * @generated
   */	
  public void setProductionPrice(double newVal) {
    this.productionPrice = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean productionPriceOverride;

	/**
   * @generated
 	 */
  public Boolean getProductionPriceOverride(){
    return productionPriceOverride; 
  }


	/**
   * @generated
   */	
  public void setProductionPriceOverride(Boolean newVal) {
    this.productionPriceOverride = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal stockCost;

	/**
   * @generated
 	 */
  public BigDecimal getStockCost(){
    return stockCost; 
  }


	/**
   * @generated
   */	
  public void setStockCost(BigDecimal newVal) {
    this.stockCost = newVal;
  }


	/**
   * @generated
   */	
  public void setStockCost(double newVal) {
    this.stockCost = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private BigDecimal laborCost;

	/**
   * @generated
 	 */
  public BigDecimal getLaborCost(){
    return laborCost; 
  }


	/**
   * @generated
   */	
  public void setLaborCost(BigDecimal newVal) {
    this.laborCost = newVal;
  }


	/**
   * @generated
   */	
  public void setLaborCost(double newVal) {
    this.laborCost = BigDecimal.valueOf(newVal);
  }


	/**
   * @generated
   */	
 	@Basic
  private BigDecimal laborRate;

	/**
   * @generated
 	 */
  public BigDecimal getLaborRate(){
    return laborRate; 
  }


	/**
   * @generated
   */	
  public void setLaborRate(BigDecimal newVal) {
    this.laborRate = newVal;
  }


	/**
   * @generated
   */	
  public void setLaborRate(double newVal) {
    this.laborRate = BigDecimal.valueOf(newVal);
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean laborRateOverride;

	/**
   * @generated
 	 */
  public Boolean getLaborRateOverride(){
    return laborRateOverride; 
  }


	/**
   * @generated
   */	
  public void setLaborRateOverride(Boolean newVal) {
    this.laborRateOverride = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Double laborMarkup;

	/**
   * @generated
 	 */
  public Double getLaborMarkup(){
    return laborMarkup; 
  }


	/**
   * @generated
   */	
  public void setLaborMarkup(Double newVal) {
    this.laborMarkup = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private Boolean laborMarkupOverride;

	/**
   * @generated
 	 */
  public Boolean getLaborMarkupOverride(){
    return laborMarkupOverride; 
  }


	/**
   * @generated
   */	
  public void setLaborMarkupOverride(Boolean newVal) {
    this.laborMarkupOverride = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (PREPPRICE.equals(propertyName)) return getPrepPrice();
    if (OVERSTOTALPRICE.equals(propertyName)) return getOversTotalPrice();
    if (OTHERCHARGEPRICE.equals(propertyName)) return getOtherChargePrice();
    if (PRICELOGENTRY.equals(propertyName)) return getPriceLogEntry();
    if (TOTALPRICE.equals(propertyName)) return getTotalPrice();
    if (UNITPRICE.equals(propertyName)) return getUnitPrice();
    if (BINDPRICE.equals(propertyName)) return getBindPrice();
    if (OVERSUNITPRICE.equals(propertyName)) return getOversUnitPrice();
    if (UNITPRICEOVERRIDE.equals(propertyName)) return getUnitPriceOverride();
    if (TOTALPRICEOVERRIDE.equals(propertyName)) return getTotalPriceOverride();
    if (LABORTOTALPRICE.equals(propertyName)) return getLaborTotalPrice();
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) return getLaborTotalPriceOverride();
    if (STOCKTOTALPRICE.equals(propertyName)) return getStockTotalPrice();
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) return getStockTotalPriceOverride();
    if (STOCKMARKUP.equals(propertyName)) return getStockMarkup();
    if (PRODUCTIONPRICE.equals(propertyName)) return getProductionPrice();
    if (PRODUCTIONPRICEOVERRIDE.equals(propertyName)) return getProductionPriceOverride();
    if (STOCKCOST.equals(propertyName)) return getStockCost();
    if (LABORCOST.equals(propertyName)) return getLaborCost();
    if (LABORRATE.equals(propertyName)) return getLaborRate();
    if (LABORRATEOVERRIDE.equals(propertyName)) return getLaborRateOverride();
    if (LABORMARKUP.equals(propertyName)) return getLaborMarkup();
    if (LABORMARKUPOVERRIDE.equals(propertyName)) return getLaborMarkupOverride();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PREPPRICE.equals(propertyName)) setPrepPrice((BigDecimal)newValue); else
    if (OVERSTOTALPRICE.equals(propertyName)) setOversTotalPrice((BigDecimal)newValue); else
    if (OTHERCHARGEPRICE.equals(propertyName)) setOtherChargePrice((BigDecimal)newValue); else
    if (PRICELOGENTRY.equals(propertyName)) setPriceLogEntry((PriceLogEntry)newValue); else
    if (TOTALPRICE.equals(propertyName)) setTotalPrice((BigDecimal)newValue); else
    if (UNITPRICE.equals(propertyName)) setUnitPrice((BigDecimal)newValue); else
    if (BINDPRICE.equals(propertyName)) setBindPrice((BigDecimal)newValue); else
    if (OVERSUNITPRICE.equals(propertyName)) setOversUnitPrice((BigDecimal)newValue); else
    if (UNITPRICEOVERRIDE.equals(propertyName)) setUnitPriceOverride((Boolean)newValue); else
    if (TOTALPRICEOVERRIDE.equals(propertyName)) setTotalPriceOverride((Boolean)newValue); else
    if (LABORTOTALPRICE.equals(propertyName)) setLaborTotalPrice((BigDecimal)newValue); else
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) setLaborTotalPriceOverride((Boolean)newValue); else
    if (STOCKTOTALPRICE.equals(propertyName)) setStockTotalPrice((BigDecimal)newValue); else
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) setStockTotalPriceOverride((Boolean)newValue); else
    if (STOCKMARKUP.equals(propertyName)) setStockMarkup((Double)newValue); else
    if (PRODUCTIONPRICE.equals(propertyName)) setProductionPrice((BigDecimal)newValue); else
    if (PRODUCTIONPRICEOVERRIDE.equals(propertyName)) setProductionPriceOverride((Boolean)newValue); else
    if (STOCKCOST.equals(propertyName)) setStockCost((BigDecimal)newValue); else
    if (LABORCOST.equals(propertyName)) setLaborCost((BigDecimal)newValue); else
    if (LABORRATE.equals(propertyName)) setLaborRate((BigDecimal)newValue); else
    if (LABORRATEOVERRIDE.equals(propertyName)) setLaborRateOverride((Boolean)newValue); else
    if (LABORMARKUP.equals(propertyName)) setLaborMarkup((Double)newValue); else
    if (LABORMARKUPOVERRIDE.equals(propertyName)) setLaborMarkupOverride((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PREPPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (OVERSTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (OTHERCHARGEPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRICELOGENTRY.equals(propertyName)) 
      return new Class<?>[] {PriceLogEntry.class};		
    if (TOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (UNITPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BINDPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (OVERSUNITPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (UNITPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LABORTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKTOTALPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKMARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PRODUCTIONPRICE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (PRODUCTIONPRICEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORRATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (LABORRATEOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LABORMARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LABORMARKUPOVERRIDE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (PREPPRICE.equals(propertyName)) return PricingRecord.class;
    if (OVERSTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (OTHERCHARGEPRICE.equals(propertyName)) return PricingRecord.class;
    if (PRICELOGENTRY.equals(propertyName)) return PricingRecord.class;
    if (TOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (UNITPRICE.equals(propertyName)) return PricingRecord.class;
    if (BINDPRICE.equals(propertyName)) return PricingRecord.class;
    if (OVERSUNITPRICE.equals(propertyName)) return PricingRecord.class;
    if (UNITPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (TOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (LABORTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (LABORTOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (STOCKTOTALPRICE.equals(propertyName)) return PricingRecord.class;
    if (STOCKTOTALPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (STOCKMARKUP.equals(propertyName)) return PricingRecord.class;
    if (PRODUCTIONPRICE.equals(propertyName)) return PricingRecord.class;
    if (PRODUCTIONPRICEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (STOCKCOST.equals(propertyName)) return PricingRecord.class;
    if (LABORCOST.equals(propertyName)) return PricingRecord.class;
    if (LABORRATE.equals(propertyName)) return PricingRecord.class;
    if (LABORRATEOVERRIDE.equals(propertyName)) return PricingRecord.class;
    if (LABORMARKUP.equals(propertyName)) return PricingRecord.class;
    if (LABORMARKUPOVERRIDE.equals(propertyName)) return PricingRecord.class;
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
    if (! SmartEquals(getPrepPrice(), objT.getPrepPrice()))
      return false;
    if (! SmartEquals(getOversTotalPrice(), objT.getOversTotalPrice()))
      return false;
    if (! SmartEquals(getOtherChargePrice(), objT.getOtherChargePrice()))
      return false;
    if (! SmartEquals(getPriceLogEntry(), objT.getPriceLogEntry()))
      return false;
    if (! SmartEquals(getTotalPrice(), objT.getTotalPrice()))
      return false;
    if (! SmartEquals(getUnitPrice(), objT.getUnitPrice()))
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
    if (! SmartEquals(getProductionPrice(), objT.getProductionPrice()))
      return false;
    if (! SmartEquals(getProductionPriceOverride(), objT.getProductionPriceOverride()))
      return false;
    if (! SmartEquals(getStockCost(), objT.getStockCost()))
      return false;
    if (! SmartEquals(getLaborCost(), objT.getLaborCost()))
      return false;
    if (! SmartEquals(getLaborRate(), objT.getLaborRate()))
      return false;
    if (! SmartEquals(getLaborRateOverride(), objT.getLaborRateOverride()))
      return false;
    if (! SmartEquals(getLaborMarkup(), objT.getLaborMarkup()))
      return false;
    if (! SmartEquals(getLaborMarkupOverride(), objT.getLaborMarkupOverride()))
      return false;
    return true;
  }			
}
