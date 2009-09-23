package com.efi.printsmith;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
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
	@NamedQuery(name = "Stock.findall", query = "from Stock"),
	@NamedQuery(name = "Stock.byId", query = "select a from Stock a where a.id= :id")
})


@DiscriminatorValue("com.efi.printsmith.Stock")
@DiscriminatorColumn(name="dtype", length=255)
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Table(name = "stock")
public class Stock extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STOCKID = "StockId";
	/**
	 * @generated
	 */
	public static final String GROUP = "Group";
	/**
	 * @generated
	 */
	public static final String CLASS = "Class";
	/**
	 * @generated
	 */
	public static final String ISMETRIC = "Ismetric";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String FINISH = "Finish";
	/**
	 * @generated
	 */
	public static final String WEIGHT = "Weight";
	/**
	 * @generated
	 */
	public static final String COLOR = "Color";
	/**
	 * @generated
	 */
	public static final String GRADE = "Grade";
	/**
	 * @generated
	 */
	public static final String COATED = "Coated";
	/**
	 * @generated
	 */
	public static final String GENERICCOLOR = "GenericColor";
	/**
	 * @generated
	 */
	public static final String VENDOR = "Vendor";
	/**
	 * @generated
	 */
	public static final String STOCKNUMBER = "StockNumber";
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String BASICSIZE = "Basicsize";
	/**
	 * @generated
	 */
	public static final String PARENTSIZE = "Parentsize";
	/**
	 * @generated
	 */
	public static final String THICKNESS = "Thickness";
	/**
	 * @generated
	 */
	public static final String MWEIGHT = "Mweight";
	/**
	 * @generated
	 */
	public static final String SHEETSPERCARTON = "Sheetspercarton";
	/**
	 * @generated
	 */
	public static final String MINORDER = "Minorder";
	/**
	 * @generated
	 */
	public static final String FORESTMGMT = "Forestmgmt";
	/**
	 * @generated
	 */
	public static final String RECYCLEPCT = "Recyclepct";
	/**
	 * @generated
	 */
	public static final String CERTIFICATION = "Certification";
	/**
	 * @generated
	 */
	public static final String QTYADJUSTMENTS = "QtyAdjustments";
	/**
	 * @generated
	 */
	public static final String COMMENTS = "Comments";
	/**
	 * @generated
	 */
	public static final String PRICING = "Pricing";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL = "Additional";
	/**
	 * @generated
	 */
	public static final String INVENTORY = "Inventory";

	/**
	 * @generated
	 */
	public Stock() {
	}

 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="stockid", nullable=true, unique=false)
	private Integer stockId;
	/**
	 * @generated
 	 */
	public Integer getStockId(){
		return stockId; 
	}

	/**
	 * @generated
	 */	
	public Integer setStockId(Integer newVal) {
		return this.stockId = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockGroup group;
	/**
	 * @generated
 	 */
	public StockGroup getGroup(){
		return group; 
	}

	/**
	 * @generated
	 */	
	public StockGroup setGroup(StockGroup newVal) {
		return this.group = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="class", nullable=true, unique=false)
	private String class;
	/**
	 * @generated
 	 */
	public String getClass(){
		return class; 
	}

	/**
	 * @generated
	 */	
	public String setClass(String newVal) {
		return this.class = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="ismetric", nullable=true, unique=false)
	private Boolean ismetric;
	/**
	 * @generated
 	 */
	public Boolean getIsmetric(){
		return ismetric; 
	}

	/**
	 * @generated
	 */	
	public Boolean setIsmetric(Boolean newVal) {
		return this.ismetric = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="name", nullable=true, unique=false)
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
	public String setName(String newVal) {
		return this.name = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
	public StockFinish setFinish(StockFinish newVal) {
		return this.finish = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="weight", nullable=true, unique=false)
	private Float weight;
	/**
	 * @generated
 	 */
	public Float getWeight(){
		return weight; 
	}

	/**
	 * @generated
	 */	
	public Float setWeight(Float newVal) {
		return this.weight = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockColor color;
	/**
	 * @generated
 	 */
	public StockColor getColor(){
		return color; 
	}

	/**
	 * @generated
	 */	
	public StockColor setColor(StockColor newVal) {
		return this.color = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockGrade grade;
	/**
	 * @generated
 	 */
	public StockGrade getGrade(){
		return grade; 
	}

	/**
	 * @generated
	 */	
	public StockGrade setGrade(StockGrade newVal) {
		return this.grade = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="coated", nullable=true, unique=false)
	private Integer coated;
	/**
	 * @generated
 	 */
	public Integer getCoated(){
		return coated; 
	}

	/**
	 * @generated
	 */	
	public Integer setCoated(Integer newVal) {
		return this.coated = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockColor genericColor;
	/**
	 * @generated
 	 */
	public StockColor getGenericColor(){
		return genericColor; 
	}

	/**
	 * @generated
	 */	
	public StockColor setGenericColor(StockColor newVal) {
		return this.genericColor = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
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
	public Vendor setVendor(Vendor newVal) {
		return this.vendor = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="stocknumber", nullable=true, unique=false)
	private String stockNumber;
	/**
	 * @generated
 	 */
	public String getStockNumber(){
		return stockNumber; 
	}

	/**
	 * @generated
	 */	
	public String setStockNumber(String newVal) {
		return this.stockNumber = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockType type;
	/**
	 * @generated
 	 */
	public StockType getType(){
		return type; 
	}

	/**
	 * @generated
	 */	
	public StockType setType(StockType newVal) {
		return this.type = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="basicsize", nullable=true, unique=false)
	private String basicsize;
	/**
	 * @generated
 	 */
	public String getBasicsize(){
		return basicsize; 
	}

	/**
	 * @generated
	 */	
	public String setBasicsize(String newVal) {
		return this.basicsize = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="parentsize", nullable=true, unique=false)
	private String parentsize;
	/**
	 * @generated
 	 */
	public String getParentsize(){
		return parentsize; 
	}

	/**
	 * @generated
	 */	
	public String setParentsize(String newVal) {
		return this.parentsize = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="thickness", nullable=true, unique=false)
	private Integer thickness;
	/**
	 * @generated
 	 */
	public Integer getThickness(){
		return thickness; 
	}

	/**
	 * @generated
	 */	
	public Integer setThickness(Integer newVal) {
		return this.thickness = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="mweight", nullable=true, unique=false)
	private Integer mweight;
	/**
	 * @generated
 	 */
	public Integer getMweight(){
		return mweight; 
	}

	/**
	 * @generated
	 */	
	public Integer setMweight(Integer newVal) {
		return this.mweight = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="sheetspercarton", nullable=true, unique=false)
	private Integer sheetspercarton;
	/**
	 * @generated
 	 */
	public Integer getSheetspercarton(){
		return sheetspercarton; 
	}

	/**
	 * @generated
	 */	
	public Integer setSheetspercarton(Integer newVal) {
		return this.sheetspercarton = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="minorder", nullable=true, unique=false)
	private Integer minorder;
	/**
	 * @generated
 	 */
	public Integer getMinorder(){
		return minorder; 
	}

	/**
	 * @generated
	 */	
	public Integer setMinorder(Integer newVal) {
		return this.minorder = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="forestmgmt", nullable=true, unique=false)
	private String forestmgmt;
	/**
	 * @generated
 	 */
	public String getForestmgmt(){
		return forestmgmt; 
	}

	/**
	 * @generated
	 */	
	public String setForestmgmt(String newVal) {
		return this.forestmgmt = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="recyclepct", nullable=true, unique=false)
	private Integer recyclepct;
	/**
	 * @generated
 	 */
	public Integer getRecyclepct(){
		return recyclepct; 
	}

	/**
	 * @generated
	 */	
	public Integer setRecyclepct(Integer newVal) {
		return this.recyclepct = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockCertification certification;
	/**
	 * @generated
 	 */
	public StockCertification getCertification(){
		return certification; 
	}

	/**
	 * @generated
	 */	
	public StockCertification setCertification(StockCertification newVal) {
		return this.certification = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockQty qtyAdjustments;
	/**
	 * @generated
 	 */
	public StockQty getQtyAdjustments(){
		return qtyAdjustments; 
	}

	/**
	 * @generated
	 */	
	public StockQty setQtyAdjustments(StockQty newVal) {
		return this.qtyAdjustments = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockComments comments;
	/**
	 * @generated
 	 */
	public StockComments getComments(){
		return comments; 
	}

	/**
	 * @generated
	 */	
	public StockComments setComments(StockComments newVal) {
		return this.comments = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockPricing pricing;
	/**
	 * @generated
 	 */
	public StockPricing getPricing(){
		return pricing; 
	}

	/**
	 * @generated
	 */	
	public StockPricing setPricing(StockPricing newVal) {
		return this.pricing = newVal;
	}
 	
	
	@ManyToOne( cascade = CascadeType.ALL )	
	private StockAdditionalCharges additional;
	/**
	 * @generated
 	 */
	public StockAdditionalCharges getAdditional(){
		return additional; 
	}

	/**
	 * @generated
	 */	
	public StockAdditionalCharges setAdditional(StockAdditionalCharges newVal) {
		return this.additional = newVal;
	}
 	
	
 	@Basic(fetch=FetchType.LAZY)
	@Column(name="inventory", nullable=true, unique=false)
	private Integer inventory;
	/**
	 * @generated
 	 */
	public Integer getInventory(){
		return inventory; 
	}

	/**
	 * @generated
	 */	
	public Integer setInventory(Integer newVal) {
		return this.inventory = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (STOCKID.equals(propertyName)) return getStockId();
		if (GROUP.equals(propertyName)) return getGroup();
		if (CLASS.equals(propertyName)) return getClass();
		if (ISMETRIC.equals(propertyName)) return getIsmetric();
		if (NAME.equals(propertyName)) return getName();
		if (FINISH.equals(propertyName)) return getFinish();
		if (WEIGHT.equals(propertyName)) return getWeight();
		if (COLOR.equals(propertyName)) return getColor();
		if (GRADE.equals(propertyName)) return getGrade();
		if (COATED.equals(propertyName)) return getCoated();
		if (GENERICCOLOR.equals(propertyName)) return getGenericColor();
		if (VENDOR.equals(propertyName)) return getVendor();
		if (STOCKNUMBER.equals(propertyName)) return getStockNumber();
		if (TYPE.equals(propertyName)) return getType();
		if (BASICSIZE.equals(propertyName)) return getBasicsize();
		if (PARENTSIZE.equals(propertyName)) return getParentsize();
		if (THICKNESS.equals(propertyName)) return getThickness();
		if (MWEIGHT.equals(propertyName)) return getMweight();
		if (SHEETSPERCARTON.equals(propertyName)) return getSheetspercarton();
		if (MINORDER.equals(propertyName)) return getMinorder();
		if (FORESTMGMT.equals(propertyName)) return getForestmgmt();
		if (RECYCLEPCT.equals(propertyName)) return getRecyclepct();
		if (CERTIFICATION.equals(propertyName)) return getCertification();
		if (QTYADJUSTMENTS.equals(propertyName)) return getQtyAdjustments();
		if (COMMENTS.equals(propertyName)) return getComments();
		if (PRICING.equals(propertyName)) return getPricing();
		if (ADDITIONAL.equals(propertyName)) return getAdditional();
		if (INVENTORY.equals(propertyName)) return getInventory();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (STOCKID.equals(propertyName)) setStockId((Integer)newValue); else
		if (GROUP.equals(propertyName)) setGroup((StockGroup)newValue); else
		if (CLASS.equals(propertyName)) setClass((String)newValue); else
		if (ISMETRIC.equals(propertyName)) setIsmetric((Boolean)newValue); else
		if (NAME.equals(propertyName)) setName((String)newValue); else
		if (FINISH.equals(propertyName)) setFinish((StockFinish)newValue); else
		if (WEIGHT.equals(propertyName)) setWeight((Float)newValue); else
		if (COLOR.equals(propertyName)) setColor((StockColor)newValue); else
		if (GRADE.equals(propertyName)) setGrade((StockGrade)newValue); else
		if (COATED.equals(propertyName)) setCoated((Integer)newValue); else
		if (GENERICCOLOR.equals(propertyName)) setGenericColor((StockColor)newValue); else
		if (VENDOR.equals(propertyName)) setVendor((Vendor)newValue); else
		if (STOCKNUMBER.equals(propertyName)) setStockNumber((String)newValue); else
		if (TYPE.equals(propertyName)) setType((StockType)newValue); else
		if (BASICSIZE.equals(propertyName)) setBasicsize((String)newValue); else
		if (PARENTSIZE.equals(propertyName)) setParentsize((String)newValue); else
		if (THICKNESS.equals(propertyName)) setThickness((Integer)newValue); else
		if (MWEIGHT.equals(propertyName)) setMweight((Integer)newValue); else
		if (SHEETSPERCARTON.equals(propertyName)) setSheetspercarton((Integer)newValue); else
		if (MINORDER.equals(propertyName)) setMinorder((Integer)newValue); else
		if (FORESTMGMT.equals(propertyName)) setForestmgmt((String)newValue); else
		if (RECYCLEPCT.equals(propertyName)) setRecyclepct((Integer)newValue); else
		if (CERTIFICATION.equals(propertyName)) setCertification((StockCertification)newValue); else
		if (QTYADJUSTMENTS.equals(propertyName)) setQtyAdjustments((StockQty)newValue); else
		if (COMMENTS.equals(propertyName)) setComments((StockComments)newValue); else
		if (PRICING.equals(propertyName)) setPricing((StockPricing)newValue); else
		if (ADDITIONAL.equals(propertyName)) setAdditional((StockAdditionalCharges)newValue); else
		if (INVENTORY.equals(propertyName)) setInventory((Integer)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (STOCKID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (GROUP.equals(propertyName)) 
			return new Class<?>[] {StockGroup.class};		
		if (CLASS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ISMETRIC.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FINISH.equals(propertyName)) 
			return new Class<?>[] {StockFinish.class};		
		if (WEIGHT.equals(propertyName)) 
			return new Class<?>[] {Float.class};		
		if (COLOR.equals(propertyName)) 
			return new Class<?>[] {StockColor.class};		
		if (GRADE.equals(propertyName)) 
			return new Class<?>[] {StockGrade.class};		
		if (COATED.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (GENERICCOLOR.equals(propertyName)) 
			return new Class<?>[] {StockColor.class};		
		if (VENDOR.equals(propertyName)) 
			return new Class<?>[] {Vendor.class};		
		if (STOCKNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TYPE.equals(propertyName)) 
			return new Class<?>[] {StockType.class};		
		if (BASICSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PARENTSIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (THICKNESS.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MWEIGHT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (SHEETSPERCARTON.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MINORDER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FORESTMGMT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RECYCLEPCT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (CERTIFICATION.equals(propertyName)) 
			return new Class<?>[] {StockCertification.class};		
		if (QTYADJUSTMENTS.equals(propertyName)) 
			return new Class<?>[] {StockQty.class};		
		if (COMMENTS.equals(propertyName)) 
			return new Class<?>[] {StockComments.class};		
		if (PRICING.equals(propertyName)) 
			return new Class<?>[] {StockPricing.class};		
		if (ADDITIONAL.equals(propertyName)) 
			return new Class<?>[] {StockAdditionalCharges.class};		
		if (INVENTORY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (STOCKID.equals(propertyName)) return Stock.class;
		if (GROUP.equals(propertyName)) return Stock.class;
		if (CLASS.equals(propertyName)) return Stock.class;
		if (ISMETRIC.equals(propertyName)) return Stock.class;
		if (NAME.equals(propertyName)) return Stock.class;
		if (FINISH.equals(propertyName)) return Stock.class;
		if (WEIGHT.equals(propertyName)) return Stock.class;
		if (COLOR.equals(propertyName)) return Stock.class;
		if (GRADE.equals(propertyName)) return Stock.class;
		if (COATED.equals(propertyName)) return Stock.class;
		if (GENERICCOLOR.equals(propertyName)) return Stock.class;
		if (VENDOR.equals(propertyName)) return Stock.class;
		if (STOCKNUMBER.equals(propertyName)) return Stock.class;
		if (TYPE.equals(propertyName)) return Stock.class;
		if (BASICSIZE.equals(propertyName)) return Stock.class;
		if (PARENTSIZE.equals(propertyName)) return Stock.class;
		if (THICKNESS.equals(propertyName)) return Stock.class;
		if (MWEIGHT.equals(propertyName)) return Stock.class;
		if (SHEETSPERCARTON.equals(propertyName)) return Stock.class;
		if (MINORDER.equals(propertyName)) return Stock.class;
		if (FORESTMGMT.equals(propertyName)) return Stock.class;
		if (RECYCLEPCT.equals(propertyName)) return Stock.class;
		if (CERTIFICATION.equals(propertyName)) return Stock.class;
		if (QTYADJUSTMENTS.equals(propertyName)) return Stock.class;
		if (COMMENTS.equals(propertyName)) return Stock.class;
		if (PRICING.equals(propertyName)) return Stock.class;
		if (ADDITIONAL.equals(propertyName)) return Stock.class;
		if (INVENTORY.equals(propertyName)) return Stock.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Stock objT = (Stock)obj;
		if (! SmartEquals(getStockId(), objT.getStockId()))
			return false;
		if (! SmartEquals(getGroup(), objT.getGroup()))
			return false;
		if (! SmartEquals(getClass(), objT.getClass()))
			return false;
		if (! SmartEquals(getIsmetric(), objT.getIsmetric()))
			return false;
		if (! SmartEquals(getName(), objT.getName()))
			return false;
		if (! SmartEquals(getFinish(), objT.getFinish()))
			return false;
		if (! SmartEquals(getWeight(), objT.getWeight()))
			return false;
		if (! SmartEquals(getColor(), objT.getColor()))
			return false;
		if (! SmartEquals(getGrade(), objT.getGrade()))
			return false;
		if (! SmartEquals(getCoated(), objT.getCoated()))
			return false;
		if (! SmartEquals(getGenericColor(), objT.getGenericColor()))
			return false;
		if (! SmartEquals(getVendor(), objT.getVendor()))
			return false;
		if (! SmartEquals(getStockNumber(), objT.getStockNumber()))
			return false;
		if (! SmartEquals(getType(), objT.getType()))
			return false;
		if (! SmartEquals(getBasicsize(), objT.getBasicsize()))
			return false;
		if (! SmartEquals(getParentsize(), objT.getParentsize()))
			return false;
		if (! SmartEquals(getThickness(), objT.getThickness()))
			return false;
		if (! SmartEquals(getMweight(), objT.getMweight()))
			return false;
		if (! SmartEquals(getSheetspercarton(), objT.getSheetspercarton()))
			return false;
		if (! SmartEquals(getMinorder(), objT.getMinorder()))
			return false;
		if (! SmartEquals(getForestmgmt(), objT.getForestmgmt()))
			return false;
		if (! SmartEquals(getRecyclepct(), objT.getRecyclepct()))
			return false;
		if (! SmartEquals(getCertification(), objT.getCertification()))
			return false;
		if (! SmartEquals(getQtyAdjustments(), objT.getQtyAdjustments()))
			return false;
		if (! SmartEquals(getComments(), objT.getComments()))
			return false;
		if (! SmartEquals(getPricing(), objT.getPricing()))
			return false;
		if (! SmartEquals(getAdditional(), objT.getAdditional()))
			return false;
		if (! SmartEquals(getInventory(), objT.getInventory()))
			return false;
		return true;
	}			
}