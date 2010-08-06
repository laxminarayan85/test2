
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
  @NamedQuery(name = "PreferencesStocks.findall", query = "from PreferencesStocks"),
  @NamedQuery(name = "PreferencesStocks.byId", query = "select a from PreferencesStocks a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesstocks")
public class PreferencesStocks extends ModelBase {
	/**
	 * @generated
	 */
	public static final String WEIGHT = "Weight";
	/**
	 * @generated
	 */
	public static final String POINTS = "Points";
	/**
	 * @generated
	 */
	public static final String MICRONS = "Microns";
	/**
	 * @generated
	 */
	public static final String PLIES = "Plies";
	/**
	 * @generated
	 */
	public static final String MILLIMETERS = "Millimeters";
	/**
	 * @generated
	 */
	public static final String CUSTOMERCOST = "CustomerCost";
	/**
	 * @generated
	 */
	public static final String CUSTOMERQUANTITY = "CustomerQuantity";
	/**
	 * @generated
	 */
	public static final String CUSTOMERMARKUP = "CustomerMarkup";
	/**
	 * @generated
	 */
	public static final String MARKUPONLY = "MarkupOnly";
	/**
	 * @generated
	 */
	public static final String STDQTY1 = "StdQty1";
	/**
	 * @generated
	 */
	public static final String STDQTY2 = "StdQty2";
	/**
	 * @generated
	 */
	public static final String STDQTY3 = "StdQty3";
	/**
	 * @generated
	 */
	public static final String STDQTY4 = "StdQty4";
	/**
	 * @generated
	 */
	public static final String STDQTY5 = "StdQty5";
	/**
	 * @generated
	 */
	public static final String STDQTY6 = "StdQty6";
	/**
	 * @generated
	 */
	public static final String STDMARKUP1 = "StdMarkup1";
	/**
	 * @generated
	 */
	public static final String STDMARKUP2 = "StdMarkup2";
	/**
	 * @generated
	 */
	public static final String STDMARKUP3 = "StdMarkup3";
	/**
	 * @generated
	 */
	public static final String STDMARKUP4 = "StdMarkup4";
	/**
	 * @generated
	 */
	public static final String STDMARKUP5 = "StdMarkup5";
	/**
	 * @generated
	 */
	public static final String STDMARKUP6 = "StdMarkup6";
	/**
	 * @generated
	 */
	public static final String BLANKQTY1 = "BlankQty1";
	/**
	 * @generated
	 */
	public static final String BLANKQTY2 = "BlankQty2";
	/**
	 * @generated
	 */
	public static final String BLANKQTY3 = "BlankQty3";
	/**
	 * @generated
	 */
	public static final String BLANKQTY4 = "BlankQty4";
	/**
	 * @generated
	 */
	public static final String BLANKQTY5 = "BlankQty5";
	/**
	 * @generated
	 */
	public static final String BLANKQTY6 = "BlankQty6";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP1 = "BlankMarkup1";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP2 = "BlankMarkup2";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP3 = "BlankMarkup3";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP4 = "BlankMarkup4";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP5 = "BlankMarkup5";
	/**
	 * @generated
	 */
	public static final String BLANKMARKUP6 = "BlankMarkup6";
	/**
	 * @generated
	 */
	public static final String SIZETABLE = "SizeTable";

	/**
	 * @generated
	 */
	public PreferencesStocks() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String weight;
	
	/**
	 * @generated
 	 */
	public String getWeight(){
    return weight; 
  }

	
	/**
	 * @generated
	 */	
	public void setWeight(String newVal) {
    this.weight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String points;
	
	/**
	 * @generated
 	 */
	public String getPoints(){
    return points; 
  }

	
	/**
	 * @generated
	 */	
	public void setPoints(String newVal) {
    this.points = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String microns;
	
	/**
	 * @generated
 	 */
	public String getMicrons(){
    return microns; 
  }

	
	/**
	 * @generated
	 */	
	public void setMicrons(String newVal) {
    this.microns = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String plies;
	
	/**
	 * @generated
 	 */
	public String getPlies(){
    return plies; 
  }

	
	/**
	 * @generated
	 */	
	public void setPlies(String newVal) {
    this.plies = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String millimeters;
	
	/**
	 * @generated
 	 */
	public String getMillimeters(){
    return millimeters; 
  }

	
	/**
	 * @generated
	 */	
	public void setMillimeters(String newVal) {
    this.millimeters = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal customerCost;
	
	/**
	 * @generated
 	 */
	public BigDecimal getCustomerCost(){
    return customerCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerCost(BigDecimal newVal) {
    this.customerCost = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setCustomerCost(double newVal) {
    this.customerCost = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer customerQuantity;
	
	/**
	 * @generated
 	 */
	public Integer getCustomerQuantity(){
    return customerQuantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerQuantity(Integer newVal) {
    this.customerQuantity = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double customerMarkup;
	
	/**
	 * @generated
 	 */
	public Double getCustomerMarkup(){
    return customerMarkup; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerMarkup(Double newVal) {
    this.customerMarkup = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean markupOnly;
	
	/**
	 * @generated
 	 */
	public Boolean getMarkupOnly(){
    return markupOnly; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkupOnly(Boolean newVal) {
    this.markupOnly = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty1;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty1(){
    return stdQty1; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty1(Integer newVal) {
    this.stdQty1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty2;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty2(){
    return stdQty2; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty2(Integer newVal) {
    this.stdQty2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty3;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty3(){
    return stdQty3; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty3(Integer newVal) {
    this.stdQty3 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty4;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty4(){
    return stdQty4; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty4(Integer newVal) {
    this.stdQty4 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty5;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty5(){
    return stdQty5; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty5(Integer newVal) {
    this.stdQty5 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stdQty6;
	
	/**
	 * @generated
 	 */
	public Integer getStdQty6(){
    return stdQty6; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdQty6(Integer newVal) {
    this.stdQty6 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup1;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup1(){
    return stdMarkup1; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup1(Double newVal) {
    this.stdMarkup1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup2;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup2(){
    return stdMarkup2; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup2(Double newVal) {
    this.stdMarkup2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup3;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup3(){
    return stdMarkup3; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup3(Double newVal) {
    this.stdMarkup3 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup4;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup4(){
    return stdMarkup4; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup4(Double newVal) {
    this.stdMarkup4 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup5;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup5(){
    return stdMarkup5; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup5(Double newVal) {
    this.stdMarkup5 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double stdMarkup6;
	
	/**
	 * @generated
 	 */
	public Double getStdMarkup6(){
    return stdMarkup6; 
  }

	
	/**
	 * @generated
	 */	
	public void setStdMarkup6(Double newVal) {
    this.stdMarkup6 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty1;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty1(){
    return blankQty1; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty1(Integer newVal) {
    this.blankQty1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty2;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty2(){
    return blankQty2; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty2(Integer newVal) {
    this.blankQty2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty3;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty3(){
    return blankQty3; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty3(Integer newVal) {
    this.blankQty3 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty4;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty4(){
    return blankQty4; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty4(Integer newVal) {
    this.blankQty4 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty5;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty5(){
    return blankQty5; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty5(Integer newVal) {
    this.blankQty5 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankQty6;
	
	/**
	 * @generated
 	 */
	public Integer getBlankQty6(){
    return blankQty6; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankQty6(Integer newVal) {
    this.blankQty6 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup1;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup1(){
    return blankMarkup1; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup1(Double newVal) {
    this.blankMarkup1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup2;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup2(){
    return blankMarkup2; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup2(Double newVal) {
    this.blankMarkup2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup3;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup3(){
    return blankMarkup3; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup3(Double newVal) {
    this.blankMarkup3 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup4;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup4(){
    return blankMarkup4; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup4(Double newVal) {
    this.blankMarkup4 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup5;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup5(){
    return blankMarkup5; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup5(Double newVal) {
    this.blankMarkup5 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankMarkup6;
	
	/**
	 * @generated
 	 */
	public Double getBlankMarkup6(){
    return blankMarkup6; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankMarkup6(Double newVal) {
    this.blankMarkup6 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private SizeTable sizeTable;
	
	/**
	 * @generated
 	 */
	public SizeTable getSizeTable(){
    return sizeTable; 
  }

	
	/**
	 * @generated
	 */	
	public void setSizeTable(SizeTable newVal) {
    this.sizeTable = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (WEIGHT.equals(propertyName)) return getWeight();
    if (POINTS.equals(propertyName)) return getPoints();
    if (MICRONS.equals(propertyName)) return getMicrons();
    if (PLIES.equals(propertyName)) return getPlies();
    if (MILLIMETERS.equals(propertyName)) return getMillimeters();
    if (CUSTOMERCOST.equals(propertyName)) return getCustomerCost();
    if (CUSTOMERQUANTITY.equals(propertyName)) return getCustomerQuantity();
    if (CUSTOMERMARKUP.equals(propertyName)) return getCustomerMarkup();
    if (MARKUPONLY.equals(propertyName)) return getMarkupOnly();
    if (STDQTY1.equals(propertyName)) return getStdQty1();
    if (STDQTY2.equals(propertyName)) return getStdQty2();
    if (STDQTY3.equals(propertyName)) return getStdQty3();
    if (STDQTY4.equals(propertyName)) return getStdQty4();
    if (STDQTY5.equals(propertyName)) return getStdQty5();
    if (STDQTY6.equals(propertyName)) return getStdQty6();
    if (STDMARKUP1.equals(propertyName)) return getStdMarkup1();
    if (STDMARKUP2.equals(propertyName)) return getStdMarkup2();
    if (STDMARKUP3.equals(propertyName)) return getStdMarkup3();
    if (STDMARKUP4.equals(propertyName)) return getStdMarkup4();
    if (STDMARKUP5.equals(propertyName)) return getStdMarkup5();
    if (STDMARKUP6.equals(propertyName)) return getStdMarkup6();
    if (BLANKQTY1.equals(propertyName)) return getBlankQty1();
    if (BLANKQTY2.equals(propertyName)) return getBlankQty2();
    if (BLANKQTY3.equals(propertyName)) return getBlankQty3();
    if (BLANKQTY4.equals(propertyName)) return getBlankQty4();
    if (BLANKQTY5.equals(propertyName)) return getBlankQty5();
    if (BLANKQTY6.equals(propertyName)) return getBlankQty6();
    if (BLANKMARKUP1.equals(propertyName)) return getBlankMarkup1();
    if (BLANKMARKUP2.equals(propertyName)) return getBlankMarkup2();
    if (BLANKMARKUP3.equals(propertyName)) return getBlankMarkup3();
    if (BLANKMARKUP4.equals(propertyName)) return getBlankMarkup4();
    if (BLANKMARKUP5.equals(propertyName)) return getBlankMarkup5();
    if (BLANKMARKUP6.equals(propertyName)) return getBlankMarkup6();
    if (SIZETABLE.equals(propertyName)) return getSizeTable();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (WEIGHT.equals(propertyName)) setWeight((String)newValue); else
    if (POINTS.equals(propertyName)) setPoints((String)newValue); else
    if (MICRONS.equals(propertyName)) setMicrons((String)newValue); else
    if (PLIES.equals(propertyName)) setPlies((String)newValue); else
    if (MILLIMETERS.equals(propertyName)) setMillimeters((String)newValue); else
    if (CUSTOMERCOST.equals(propertyName)) setCustomerCost((BigDecimal)newValue); else
    if (CUSTOMERQUANTITY.equals(propertyName)) setCustomerQuantity((Integer)newValue); else
    if (CUSTOMERMARKUP.equals(propertyName)) setCustomerMarkup((Double)newValue); else
    if (MARKUPONLY.equals(propertyName)) setMarkupOnly((Boolean)newValue); else
    if (STDQTY1.equals(propertyName)) setStdQty1((Integer)newValue); else
    if (STDQTY2.equals(propertyName)) setStdQty2((Integer)newValue); else
    if (STDQTY3.equals(propertyName)) setStdQty3((Integer)newValue); else
    if (STDQTY4.equals(propertyName)) setStdQty4((Integer)newValue); else
    if (STDQTY5.equals(propertyName)) setStdQty5((Integer)newValue); else
    if (STDQTY6.equals(propertyName)) setStdQty6((Integer)newValue); else
    if (STDMARKUP1.equals(propertyName)) setStdMarkup1((Double)newValue); else
    if (STDMARKUP2.equals(propertyName)) setStdMarkup2((Double)newValue); else
    if (STDMARKUP3.equals(propertyName)) setStdMarkup3((Double)newValue); else
    if (STDMARKUP4.equals(propertyName)) setStdMarkup4((Double)newValue); else
    if (STDMARKUP5.equals(propertyName)) setStdMarkup5((Double)newValue); else
    if (STDMARKUP6.equals(propertyName)) setStdMarkup6((Double)newValue); else
    if (BLANKQTY1.equals(propertyName)) setBlankQty1((Integer)newValue); else
    if (BLANKQTY2.equals(propertyName)) setBlankQty2((Integer)newValue); else
    if (BLANKQTY3.equals(propertyName)) setBlankQty3((Integer)newValue); else
    if (BLANKQTY4.equals(propertyName)) setBlankQty4((Integer)newValue); else
    if (BLANKQTY5.equals(propertyName)) setBlankQty5((Integer)newValue); else
    if (BLANKQTY6.equals(propertyName)) setBlankQty6((Integer)newValue); else
    if (BLANKMARKUP1.equals(propertyName)) setBlankMarkup1((Double)newValue); else
    if (BLANKMARKUP2.equals(propertyName)) setBlankMarkup2((Double)newValue); else
    if (BLANKMARKUP3.equals(propertyName)) setBlankMarkup3((Double)newValue); else
    if (BLANKMARKUP4.equals(propertyName)) setBlankMarkup4((Double)newValue); else
    if (BLANKMARKUP5.equals(propertyName)) setBlankMarkup5((Double)newValue); else
    if (BLANKMARKUP6.equals(propertyName)) setBlankMarkup6((Double)newValue); else
    if (SIZETABLE.equals(propertyName)) setSizeTable((SizeTable)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (WEIGHT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (POINTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (MICRONS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PLIES.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (MILLIMETERS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUSTOMERCOST.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CUSTOMERQUANTITY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CUSTOMERMARKUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUPONLY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STDQTY1.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDQTY2.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDQTY3.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDQTY4.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDQTY5.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDQTY6.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (STDMARKUP1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STDMARKUP2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STDMARKUP3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STDMARKUP4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STDMARKUP5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STDMARKUP6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKQTY1.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKQTY2.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKQTY3.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKQTY4.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKQTY5.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKQTY6.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKMARKUP1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKMARKUP2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKMARKUP3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKMARKUP4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKMARKUP5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKMARKUP6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SIZETABLE.equals(propertyName)) 
      return new Class<?>[] {SizeTable.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (WEIGHT.equals(propertyName)) return PreferencesStocks.class;
    if (POINTS.equals(propertyName)) return PreferencesStocks.class;
    if (MICRONS.equals(propertyName)) return PreferencesStocks.class;
    if (PLIES.equals(propertyName)) return PreferencesStocks.class;
    if (MILLIMETERS.equals(propertyName)) return PreferencesStocks.class;
    if (CUSTOMERCOST.equals(propertyName)) return PreferencesStocks.class;
    if (CUSTOMERQUANTITY.equals(propertyName)) return PreferencesStocks.class;
    if (CUSTOMERMARKUP.equals(propertyName)) return PreferencesStocks.class;
    if (MARKUPONLY.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY1.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY2.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY3.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY4.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY5.equals(propertyName)) return PreferencesStocks.class;
    if (STDQTY6.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP1.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP2.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP3.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP4.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP5.equals(propertyName)) return PreferencesStocks.class;
    if (STDMARKUP6.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY1.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY2.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY3.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY4.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY5.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKQTY6.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP1.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP2.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP3.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP4.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP5.equals(propertyName)) return PreferencesStocks.class;
    if (BLANKMARKUP6.equals(propertyName)) return PreferencesStocks.class;
    if (SIZETABLE.equals(propertyName)) return PreferencesStocks.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesStocks objT = (PreferencesStocks)obj;
    if (! SmartEquals(getWeight(), objT.getWeight()))
      return false;
    if (! SmartEquals(getPoints(), objT.getPoints()))
      return false;
    if (! SmartEquals(getMicrons(), objT.getMicrons()))
      return false;
    if (! SmartEquals(getPlies(), objT.getPlies()))
      return false;
    if (! SmartEquals(getMillimeters(), objT.getMillimeters()))
      return false;
    if (! SmartEquals(getCustomerCost(), objT.getCustomerCost()))
      return false;
    if (! SmartEquals(getCustomerQuantity(), objT.getCustomerQuantity()))
      return false;
    if (! SmartEquals(getCustomerMarkup(), objT.getCustomerMarkup()))
      return false;
    if (! SmartEquals(getMarkupOnly(), objT.getMarkupOnly()))
      return false;
    if (! SmartEquals(getStdQty1(), objT.getStdQty1()))
      return false;
    if (! SmartEquals(getStdQty2(), objT.getStdQty2()))
      return false;
    if (! SmartEquals(getStdQty3(), objT.getStdQty3()))
      return false;
    if (! SmartEquals(getStdQty4(), objT.getStdQty4()))
      return false;
    if (! SmartEquals(getStdQty5(), objT.getStdQty5()))
      return false;
    if (! SmartEquals(getStdQty6(), objT.getStdQty6()))
      return false;
    if (! SmartEquals(getStdMarkup1(), objT.getStdMarkup1()))
      return false;
    if (! SmartEquals(getStdMarkup2(), objT.getStdMarkup2()))
      return false;
    if (! SmartEquals(getStdMarkup3(), objT.getStdMarkup3()))
      return false;
    if (! SmartEquals(getStdMarkup4(), objT.getStdMarkup4()))
      return false;
    if (! SmartEquals(getStdMarkup5(), objT.getStdMarkup5()))
      return false;
    if (! SmartEquals(getStdMarkup6(), objT.getStdMarkup6()))
      return false;
    if (! SmartEquals(getBlankQty1(), objT.getBlankQty1()))
      return false;
    if (! SmartEquals(getBlankQty2(), objT.getBlankQty2()))
      return false;
    if (! SmartEquals(getBlankQty3(), objT.getBlankQty3()))
      return false;
    if (! SmartEquals(getBlankQty4(), objT.getBlankQty4()))
      return false;
    if (! SmartEquals(getBlankQty5(), objT.getBlankQty5()))
      return false;
    if (! SmartEquals(getBlankQty6(), objT.getBlankQty6()))
      return false;
    if (! SmartEquals(getBlankMarkup1(), objT.getBlankMarkup1()))
      return false;
    if (! SmartEquals(getBlankMarkup2(), objT.getBlankMarkup2()))
      return false;
    if (! SmartEquals(getBlankMarkup3(), objT.getBlankMarkup3()))
      return false;
    if (! SmartEquals(getBlankMarkup4(), objT.getBlankMarkup4()))
      return false;
    if (! SmartEquals(getBlankMarkup5(), objT.getBlankMarkup5()))
      return false;
    if (! SmartEquals(getBlankMarkup6(), objT.getBlankMarkup6()))
      return false;
    if (! SmartEquals(getSizeTable(), objT.getSizeTable()))
      return false;
    return true;
  }			
}
