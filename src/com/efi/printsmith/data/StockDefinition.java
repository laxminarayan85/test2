
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
  @NamedQuery(name = "StockDefinition.findall", query = "from StockDefinition"),
  @NamedQuery(name = "StockDefinition.byId", query = "select a from StockDefinition a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "stockdefinition")
public class StockDefinition extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STOCKUNIT = "Stockunit";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String STKGROUP = "Stkgroup";
	/**
	 * @generated
	 */
	public static final String STKCLASS = "Stkclass";
	/**
	 * @generated
	 */
	public static final String STKTYPE = "Stktype";
	/**
	 * @generated
	 */
	public static final String ISMETRIC = "IsMetric";
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
	public static final String STOCKNUMBER = "Stocknumber";
	/**
	 * @generated
	 */
	public static final String VENDOR = "Vendor";
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
	public static final String COMMENTS = "Comments";
	/**
	 * @generated
	 */
	public static final String UOM = "Uom";
	/**
	 * @generated
	 */
	public static final String COSTUNITS = "Costunits";
	/**
	 * @generated
	 */
	public static final String ENTIREORDERCHARGE = "EntireOrderCharge";
	/**
	 * @generated
	 */
	public static final String SHEETSPERSET = "SheetsPerSet";
	/**
	 * @generated
	 */
	public static final String ISCOSTINSETS = "IsCostInSets";
	/**
	 * @generated
	 */
	public static final String PRICEEXPIRES = "PriceExpires";
	/**
	 * @generated
	 */
	public static final String QTYBREAK1 = "Qtybreak1";
	/**
	 * @generated
	 */
	public static final String QTYBREAK2 = "Qtybreak2";
	/**
	 * @generated
	 */
	public static final String QTYBREAK3 = "Qtybreak3";
	/**
	 * @generated
	 */
	public static final String QTYBREAK4 = "Qtybreak4";
	/**
	 * @generated
	 */
	public static final String QTYBREAK5 = "Qtybreak5";
	/**
	 * @generated
	 */
	public static final String QTYBREAK6 = "Qtybreak6";
	/**
	 * @generated
	 */
	public static final String COST1 = "Cost1";
	/**
	 * @generated
	 */
	public static final String COST2 = "Cost2";
	/**
	 * @generated
	 */
	public static final String COST3 = "Cost3";
	/**
	 * @generated
	 */
	public static final String COST4 = "Cost4";
	/**
	 * @generated
	 */
	public static final String COST5 = "Cost5";
	/**
	 * @generated
	 */
	public static final String COST6 = "Cost6";
	/**
	 * @generated
	 */
	public static final String CWT1 = "Cwt1";
	/**
	 * @generated
	 */
	public static final String CWT2 = "Cwt2";
	/**
	 * @generated
	 */
	public static final String CWT3 = "Cwt3";
	/**
	 * @generated
	 */
	public static final String CWT4 = "Cwt4";
	/**
	 * @generated
	 */
	public static final String CWT5 = "Cwt5";
	/**
	 * @generated
	 */
	public static final String CWT6 = "Cwt6";
	/**
	 * @generated
	 */
	public static final String MARKUP1 = "Markup1";
	/**
	 * @generated
	 */
	public static final String MARKUP2 = "Markup2";
	/**
	 * @generated
	 */
	public static final String MARKUP3 = "Markup3";
	/**
	 * @generated
	 */
	public static final String MARKUP4 = "Markup4";
	/**
	 * @generated
	 */
	public static final String MARKUP5 = "Markup5";
	/**
	 * @generated
	 */
	public static final String MARKUP6 = "Markup6";
	/**
	 * @generated
	 */
	public static final String LISTPERM1 = "ListPerM1";
	/**
	 * @generated
	 */
	public static final String LISTPERM2 = "ListPerM2";
	/**
	 * @generated
	 */
	public static final String LISTPERM3 = "ListPerM3";
	/**
	 * @generated
	 */
	public static final String LISTPERM4 = "ListPerM4";
	/**
	 * @generated
	 */
	public static final String LISTPERM5 = "ListPerM5";
	/**
	 * @generated
	 */
	public static final String LISTPERM6 = "ListPerM6";
	/**
	 * @generated
	 */
	public static final String NORMALRUNSIZE = "NormalRunSize";
	/**
	 * @generated
	 */
	public static final String CUTSPER100 = "CutsPer100";
	/**
	 * @generated
	 */
	public static final String MINCUTCHARGE = "MinCutCharge";
	/**
	 * @generated
	 */
	public static final String DEFAULTPRESS = "DefaultPress";
	/**
	 * @generated
	 */
	public static final String AUTOCALCULATEBLANK = "AutoCalculateBlank";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY1 = "BlankSheetqty1";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY2 = "BlankSheetqty2";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY3 = "BlankSheetqty3";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY4 = "BlankSheetqty4";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY5 = "BlankSheetqty5";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETQTY6 = "BlankSheetqty6";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE1 = "BlankSheetPrice1";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE2 = "BlankSheetPrice2";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE3 = "BlankSheetPrice3";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE4 = "BlankSheetPrice4";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE5 = "BlankSheetPrice5";
	/**
	 * @generated
	 */
	public static final String BLANKSHEETPRICE6 = "BlankSheetPrice6";
	/**
	 * @generated
	 */
	public static final String DEFAULTBW = "DefaultBW";
	/**
	 * @generated
	 */
	public static final String DEFAULTCOLOR = "DefaultColor";
	/**
	 * @generated
	 */
	public static final String DEFAULTLARGEFORMAT = "DefaultLargeFormat";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL1 = "Additional1";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL2 = "Additional2";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL3 = "Additional3";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL4 = "Additional4";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL5 = "Additional5";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL6 = "Additional6";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL7 = "Additional7";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL8 = "Additional8";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL9 = "Additional9";
	/**
	 * @generated
	 */
	public static final String ADDITIONAL10 = "Additional10";
	/**
	 * @generated
	 */
	public static final String STANDARDITEM = "StandardItem";
	/**
	 * @generated
	 */
	public static final String ONHAND = "OnHand";
	/**
	 * @generated
	 */
	public static final String COMMITTED = "Committed";
	/**
	 * @generated
	 */
	public static final String AVAILABLE = "Available";
	/**
	 * @generated
	 */
	public static final String ONORDER = "OnOrder";
	/**
	 * @generated
	 */
	public static final String TARGETLEVEL = "TargetLevel";
	/**
	 * @generated
	 */
	public static final String REORDERPOINT = "ReOrderPoint";
	/**
	 * @generated
	 */
	public static final String MINORDERQTY = "MinOrderQty";
	/**
	 * @generated
	 */
	public static final String EVENINCREMENTS = "EvenIncrements";
	/**
	 * @generated
	 */
	public static final String EXPIRES = "Expires";
	/**
	 * @generated
	 */
	public static final String BINLOCATION = "BinLocation";
	/**
	 * @generated
	 */
	public static final String SHELLITEM = "ShellItem";
	/**
	 * @generated
	 */
	public static final String FORESTMANAGEMENT = "ForestManagement";
	/**
	 * @generated
	 */
	public static final String PCWRECYCLEDPERCENT = "PcwRecycledPercent";
	/**
	 * @generated
	 */
	public static final String FSCCERTIFIED = "FscCertified";
	/**
	 * @generated
	 */
	public static final String SFICERTIFIED = "SfiCertified";
	/**
	 * @generated
	 */
	public static final String GREENSEALCERTIFIED = "GreenSealCertified";
	/**
	 * @generated
	 */
	public static final String DEFAULTPRICELIST = "DefaultPriceList";
	/**
	 * @generated
	 */
	public static final String GENERICCOLOR = "GenericColor";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String STOCKID = "StockId";
	/**
	 * @generated
	 */
	public static final String CHARGES = "Charges";
	/**
	 * @generated
	 */
	public static final String COPIER1PRICEPERSHEET = "Copier1PricePerSheet";
	/**
	 * @generated
	 */
	public static final String COPIER2PRICEPERSHEET = "Copier2PricePerSheet";
	/**
	 * @generated
	 */
	public static final String COPIER3PRICEPERSHEET = "Copier3PricePerSheet";
	/**
	 * @generated
	 */
	public static final String STOCKCHANGES = "StockChanges";
	/**
	 * @generated
	 */
	public static final String MILL = "Mill";
	/**
	 * @generated
	 */
	public static final String LOTCOUNT = "Lotcount";
	/**
	 * @generated
	 */
	public static final String CARTONWEIGHT = "CartonWeight";
	/**
	 * @generated
	 */
	public static final String SHEETPERSKID = "SheetperSkid";
	/**
	 * @generated
	 */
	public static final String WEIGHTPERSKID = "WeightperSkid";
	/**
	 * @generated
	 */
	public static final String SHORTGAIN = "Shortgain";
	/**
	 * @generated
	 */
	public static final String NOBROKENCARTON = "NoBrokenCarton";
	/**
	 * @generated
	 */
	public static final String PRICEDINSETS = "PricedinSets";
	/**
	 * @generated
	 */
	public static final String IMPORTED = "Imported";
	/**
	 * @generated
	 */
	public static final String MEASURE = "Measure";
	/**
	 * @generated
	 */
	public static final String ALLOWNEGATIVE = "Allownegative";
	/**
	 * @generated
	 */
	public static final String ROLLWEIGHT = "RollWeight";
	/**
	 * @generated
	 */
	public static final String DEFAULTBWCOPIER = "DefaultBWCopier";
	/**
	 * @generated
	 */
	public static final String DEFAULTCOLORCOPIER = "DefaultColorCopier";
	/**
	 * @generated
	 */
	public static final String DEFAULTLARGECOPIER = "DefaultLargeCopier";

	/**
	 * @generated
	 */
	public StockDefinition() {
    this.created = new Date();
    this.modified = new Date();
  }

	public StockDefinition(long id, String Name, double weight,String parentsize,StockColors color, GenericColors genericcolor,
			StockFinish finish, double thickness, StockGrade grade, double cwt1, Vendor vendor, String stocknumber, int onhand,
			int committed, int ordered, boolean shellitem, String normalrunsize, StockType stocktype,
			StockGroup stkgroup, String coated, int minorder, double cost1, Date priceexpire, String forestmanagement,
			double pcwrecycledpercent, boolean fsccertified, boolean sficertified, boolean greensealcertified) {
		this.id = id;
		this.name = Name;
		this.weight = weight;
		this.parentsize= parentsize;
		this.color =color;
		this.genericColor =genericcolor;
		this.finish =finish;
		this.thickness =thickness;
		this.grade = grade;
		this.cwt1 = cwt1;
		this.vendor =vendor;
		this.stocknumber =stocknumber;
		this.onHand= onhand;
		this.committed =committed;
		this.onOrder = ordered;
		this.shellItem =shellitem;
		this.normalRunSize =normalrunsize;
		this.stktype =stocktype;
		this.stkgroup =stkgroup;
		this.coated =coated;
		this.minorder =minorder;
		this.cost1 =cost1;
		this.priceExpires =priceexpire;
		this.forestManagement =forestmanagement;
		this.pcwRecycledPercent =pcwrecycledpercent;
		this.fscCertified =fsccertified;
		this.sfiCertified =sficertified;
		this.greenSealCertified = greensealcertified;
		
	}
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer stockunit;
	
	/**
	 * @generated
 	 */
	public Integer getStockunit(){
    return stockunit; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockunit(Integer newVal) {
    this.stockunit = newVal;
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
    @ManyToOne
	private StockGroup stkgroup;
	
	/**
	 * @generated
 	 */
	public StockGroup getStkgroup(){
    return stkgroup; 
  }

	
	/**
	 * @generated
	 */	
	public void setStkgroup(StockGroup newVal) {
    this.stkgroup = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private StockClass stkclass;
	
	/**
	 * @generated
 	 */
	public StockClass getStkclass(){
    return stkclass; 
  }

	
	/**
	 * @generated
	 */	
	public void setStkclass(StockClass newVal) {
    this.stkclass = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private StockType stktype;
	
	/**
	 * @generated
 	 */
	public StockType getStktype(){
    return stktype; 
  }

	
	/**
	 * @generated
	 */	
	public void setStktype(StockType newVal) {
    this.stktype = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isMetric;
	
	/**
	 * @generated
 	 */
	public Boolean getIsMetric(){
    return isMetric; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsMetric(Boolean newVal) {
    this.isMetric = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
    @ManyToOne
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
    @ManyToOne
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
	public void setGrade(StockGrade newVal) {
    this.grade = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String coated;
	
	/**
	 * @generated
 	 */
	public String getCoated(){
    return coated; 
  }

	
	/**
	 * @generated
	 */	
	public void setCoated(String newVal) {
    this.coated = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String stocknumber;
	
	/**
	 * @generated
 	 */
	public String getStocknumber(){
    return stocknumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setStocknumber(String newVal) {
    this.stocknumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
	public void setBasicsize(String newVal) {
    this.basicsize = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
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
	public void setParentsize(String newVal) {
    this.parentsize = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double thickness;
	
	/**
	 * @generated
 	 */
	public Double getThickness(){
    return thickness; 
  }

	
	/**
	 * @generated
	 */	
	public void setThickness(Double newVal) {
    this.thickness = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double mweight;
	
	/**
	 * @generated
 	 */
	public Double getMweight(){
    return mweight; 
  }

	
	/**
	 * @generated
	 */	
	public void setMweight(Double newVal) {
    this.mweight = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
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
	public void setSheetspercarton(Integer newVal) {
    this.sheetspercarton = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
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
	public void setMinorder(Integer newVal) {
    this.minorder = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String comments;
	
	/**
	 * @generated
 	 */
	public String getComments(){
    return comments; 
  }

	
	/**
	 * @generated
	 */	
	public void setComments(String newVal) {
    this.comments = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String uom;
	
	/**
	 * @generated
 	 */
	public String getUom(){
    return uom; 
  }

	
	/**
	 * @generated
	 */	
	public void setUom(String newVal) {
    this.uom = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer costunits;
	
	/**
	 * @generated
 	 */
	public Integer getCostunits(){
    return costunits; 
  }

	
	/**
	 * @generated
	 */	
	public void setCostunits(Integer newVal) {
    this.costunits = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean entireOrderCharge;
	
	/**
	 * @generated
 	 */
	public Boolean getEntireOrderCharge(){
    return entireOrderCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setEntireOrderCharge(Boolean newVal) {
    this.entireOrderCharge = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer sheetsPerSet;
	
	/**
	 * @generated
 	 */
	public Integer getSheetsPerSet(){
    return sheetsPerSet; 
  }

	
	/**
	 * @generated
	 */	
	public void setSheetsPerSet(Integer newVal) {
    this.sheetsPerSet = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isCostInSets;
	
	/**
	 * @generated
 	 */
	public Boolean getIsCostInSets(){
    return isCostInSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsCostInSets(Boolean newVal) {
    this.isCostInSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date priceExpires;
	
	/**
	 * @generated
 	 */
	public Date getPriceExpires(){
    return priceExpires; 
  }

	
	/**
	 * @generated
	 */	
	public void setPriceExpires(Date newVal) {
    this.priceExpires = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak1;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak1(){
    return qtybreak1; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak1(Integer newVal) {
    this.qtybreak1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak2;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak2(){
    return qtybreak2; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak2(Integer newVal) {
    this.qtybreak2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak3;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak3(){
    return qtybreak3; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak3(Integer newVal) {
    this.qtybreak3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak4;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak4(){
    return qtybreak4; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak4(Integer newVal) {
    this.qtybreak4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak5;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak5(){
    return qtybreak5; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak5(Integer newVal) {
    this.qtybreak5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtybreak6;
	
	/**
	 * @generated
 	 */
	public Integer getQtybreak6(){
    return qtybreak6; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtybreak6(Integer newVal) {
    this.qtybreak6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost1;
	
	/**
	 * @generated
 	 */
	public Double getCost1(){
    return cost1; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost1(Double newVal) {
    this.cost1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost2;
	
	/**
	 * @generated
 	 */
	public Double getCost2(){
    return cost2; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost2(Double newVal) {
    this.cost2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost3;
	
	/**
	 * @generated
 	 */
	public Double getCost3(){
    return cost3; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost3(Double newVal) {
    this.cost3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost4;
	
	/**
	 * @generated
 	 */
	public Double getCost4(){
    return cost4; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost4(Double newVal) {
    this.cost4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost5;
	
	/**
	 * @generated
 	 */
	public Double getCost5(){
    return cost5; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost5(Double newVal) {
    this.cost5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cost6;
	
	/**
	 * @generated
 	 */
	public Double getCost6(){
    return cost6; 
  }

	
	/**
	 * @generated
	 */	
	public void setCost6(Double newVal) {
    this.cost6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt1;
	
	/**
	 * @generated
 	 */
	public Double getCwt1(){
    return cwt1; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt1(Double newVal) {
    this.cwt1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt2;
	
	/**
	 * @generated
 	 */
	public Double getCwt2(){
    return cwt2; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt2(Double newVal) {
    this.cwt2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt3;
	
	/**
	 * @generated
 	 */
	public Double getCwt3(){
    return cwt3; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt3(Double newVal) {
    this.cwt3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt4;
	
	/**
	 * @generated
 	 */
	public Double getCwt4(){
    return cwt4; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt4(Double newVal) {
    this.cwt4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt5;
	
	/**
	 * @generated
 	 */
	public Double getCwt5(){
    return cwt5; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt5(Double newVal) {
    this.cwt5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cwt6;
	
	/**
	 * @generated
 	 */
	public Double getCwt6(){
    return cwt6; 
  }

	
	/**
	 * @generated
	 */	
	public void setCwt6(Double newVal) {
    this.cwt6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup1;
	
	/**
	 * @generated
 	 */
	public Double getMarkup1(){
    return markup1; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup1(Double newVal) {
    this.markup1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup2;
	
	/**
	 * @generated
 	 */
	public Double getMarkup2(){
    return markup2; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup2(Double newVal) {
    this.markup2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup3;
	
	/**
	 * @generated
 	 */
	public Double getMarkup3(){
    return markup3; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup3(Double newVal) {
    this.markup3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup4;
	
	/**
	 * @generated
 	 */
	public Double getMarkup4(){
    return markup4; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup4(Double newVal) {
    this.markup4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup5;
	
	/**
	 * @generated
 	 */
	public Double getMarkup5(){
    return markup5; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup5(Double newVal) {
    this.markup5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double markup6;
	
	/**
	 * @generated
 	 */
	public Double getMarkup6(){
    return markup6; 
  }

	
	/**
	 * @generated
	 */	
	public void setMarkup6(Double newVal) {
    this.markup6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM1;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM1(){
    return listPerM1; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM1(Integer newVal) {
    this.listPerM1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM2;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM2(){
    return listPerM2; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM2(Integer newVal) {
    this.listPerM2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM3;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM3(){
    return listPerM3; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM3(Integer newVal) {
    this.listPerM3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM4;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM4(){
    return listPerM4; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM4(Integer newVal) {
    this.listPerM4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM5;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM5(){
    return listPerM5; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM5(Integer newVal) {
    this.listPerM5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer listPerM6;
	
	/**
	 * @generated
 	 */
	public Integer getListPerM6(){
    return listPerM6; 
  }

	
	/**
	 * @generated
	 */	
	public void setListPerM6(Integer newVal) {
    this.listPerM6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String normalRunSize;
	
	/**
	 * @generated
 	 */
	public String getNormalRunSize(){
    return normalRunSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setNormalRunSize(String newVal) {
    this.normalRunSize = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer cutsPer100;
	
	/**
	 * @generated
 	 */
	public Integer getCutsPer100(){
    return cutsPer100; 
  }

	
	/**
	 * @generated
	 */	
	public void setCutsPer100(Integer newVal) {
    this.cutsPer100 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double minCutCharge;
	
	/**
	 * @generated
 	 */
	public Double getMinCutCharge(){
    return minCutCharge; 
  }

	
	/**
	 * @generated
	 */	
	public void setMinCutCharge(Double newVal) {
    this.minCutCharge = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private PressDefinition defaultPress;
	
	/**
	 * @generated
 	 */
	public PressDefinition getDefaultPress(){
    return defaultPress; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultPress(PressDefinition newVal) {
    this.defaultPress = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean autoCalculateBlank;
	
	/**
	 * @generated
 	 */
	public Boolean getAutoCalculateBlank(){
    return autoCalculateBlank; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoCalculateBlank(Boolean newVal) {
    this.autoCalculateBlank = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty1;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty1(){
    return blankSheetqty1; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty1(Integer newVal) {
    this.blankSheetqty1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty2;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty2(){
    return blankSheetqty2; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty2(Integer newVal) {
    this.blankSheetqty2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty3;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty3(){
    return blankSheetqty3; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty3(Integer newVal) {
    this.blankSheetqty3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty4;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty4(){
    return blankSheetqty4; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty4(Integer newVal) {
    this.blankSheetqty4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty5;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty5(){
    return blankSheetqty5; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty5(Integer newVal) {
    this.blankSheetqty5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer blankSheetqty6;
	
	/**
	 * @generated
 	 */
	public Integer getBlankSheetqty6(){
    return blankSheetqty6; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetqty6(Integer newVal) {
    this.blankSheetqty6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice1;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice1(){
    return blankSheetPrice1; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice1(Double newVal) {
    this.blankSheetPrice1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice2;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice2(){
    return blankSheetPrice2; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice2(Double newVal) {
    this.blankSheetPrice2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice3;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice3(){
    return blankSheetPrice3; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice3(Double newVal) {
    this.blankSheetPrice3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice4;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice4(){
    return blankSheetPrice4; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice4(Double newVal) {
    this.blankSheetPrice4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice5;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice5(){
    return blankSheetPrice5; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice5(Double newVal) {
    this.blankSheetPrice5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double blankSheetPrice6;
	
	/**
	 * @generated
 	 */
	public Double getBlankSheetPrice6(){
    return blankSheetPrice6; 
  }

	
	/**
	 * @generated
	 */	
	public void setBlankSheetPrice6(Double newVal) {
    this.blankSheetPrice6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String defaultBW;
	
	/**
	 * @generated
 	 */
	public String getDefaultBW(){
    return defaultBW; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultBW(String newVal) {
    this.defaultBW = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String defaultColor;
	
	/**
	 * @generated
 	 */
	public String getDefaultColor(){
    return defaultColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultColor(String newVal) {
    this.defaultColor = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String defaultLargeFormat;
	
	/**
	 * @generated
 	 */
	public String getDefaultLargeFormat(){
    return defaultLargeFormat; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultLargeFormat(String newVal) {
    this.defaultLargeFormat = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional1;
	
	/**
	 * @generated
 	 */
	public String getAdditional1(){
    return additional1; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional1(String newVal) {
    this.additional1 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional2;
	
	/**
	 * @generated
 	 */
	public String getAdditional2(){
    return additional2; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional2(String newVal) {
    this.additional2 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional3;
	
	/**
	 * @generated
 	 */
	public String getAdditional3(){
    return additional3; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional3(String newVal) {
    this.additional3 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional4;
	
	/**
	 * @generated
 	 */
	public String getAdditional4(){
    return additional4; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional4(String newVal) {
    this.additional4 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional5;
	
	/**
	 * @generated
 	 */
	public String getAdditional5(){
    return additional5; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional5(String newVal) {
    this.additional5 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional6;
	
	/**
	 * @generated
 	 */
	public String getAdditional6(){
    return additional6; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional6(String newVal) {
    this.additional6 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional7;
	
	/**
	 * @generated
 	 */
	public String getAdditional7(){
    return additional7; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional7(String newVal) {
    this.additional7 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional8;
	
	/**
	 * @generated
 	 */
	public String getAdditional8(){
    return additional8; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional8(String newVal) {
    this.additional8 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional9;
	
	/**
	 * @generated
 	 */
	public String getAdditional9(){
    return additional9; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional9(String newVal) {
    this.additional9 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String additional10;
	
	/**
	 * @generated
 	 */
	public String getAdditional10(){
    return additional10; 
  }

	
	/**
	 * @generated
	 */	
	public void setAdditional10(String newVal) {
    this.additional10 = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean standardItem;
	
	/**
	 * @generated
 	 */
	public Boolean getStandardItem(){
    return standardItem; 
  }

	
	/**
	 * @generated
	 */	
	public void setStandardItem(Boolean newVal) {
    this.standardItem = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer onHand;
	
	/**
	 * @generated
 	 */
	public Integer getOnHand(){
    return onHand; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnHand(Integer newVal) {
    this.onHand = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer committed;
	
	/**
	 * @generated
 	 */
	public Integer getCommitted(){
    return committed; 
  }

	
	/**
	 * @generated
	 */	
	public void setCommitted(Integer newVal) {
    this.committed = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer available;
	
	/**
	 * @generated
 	 */
	public Integer getAvailable(){
    return available; 
  }

	
	/**
	 * @generated
	 */	
	public void setAvailable(Integer newVal) {
    this.available = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer onOrder;
	
	/**
	 * @generated
 	 */
	public Integer getOnOrder(){
    return onOrder; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnOrder(Integer newVal) {
    this.onOrder = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer targetLevel;
	
	/**
	 * @generated
 	 */
	public Integer getTargetLevel(){
    return targetLevel; 
  }

	
	/**
	 * @generated
	 */	
	public void setTargetLevel(Integer newVal) {
    this.targetLevel = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer reOrderPoint;
	
	/**
	 * @generated
 	 */
	public Integer getReOrderPoint(){
    return reOrderPoint; 
  }

	
	/**
	 * @generated
	 */	
	public void setReOrderPoint(Integer newVal) {
    this.reOrderPoint = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer minOrderQty;
	
	/**
	 * @generated
 	 */
	public Integer getMinOrderQty(){
    return minOrderQty; 
  }

	
	/**
	 * @generated
	 */	
	public void setMinOrderQty(Integer newVal) {
    this.minOrderQty = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean evenIncrements;
	
	/**
	 * @generated
 	 */
	public Boolean getEvenIncrements(){
    return evenIncrements; 
  }

	
	/**
	 * @generated
	 */	
	public void setEvenIncrements(Boolean newVal) {
    this.evenIncrements = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date expires;
	
	/**
	 * @generated
 	 */
	public Date getExpires(){
    return expires; 
  }

	
	/**
	 * @generated
	 */	
	public void setExpires(Date newVal) {
    this.expires = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String binLocation;
	
	/**
	 * @generated
 	 */
	public String getBinLocation(){
    return binLocation; 
  }

	
	/**
	 * @generated
	 */	
	public void setBinLocation(String newVal) {
    this.binLocation = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean shellItem;
	
	/**
	 * @generated
 	 */
	public Boolean getShellItem(){
    return shellItem; 
  }

	
	/**
	 * @generated
	 */	
	public void setShellItem(Boolean newVal) {
    this.shellItem = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String forestManagement;
	
	/**
	 * @generated
 	 */
	public String getForestManagement(){
    return forestManagement; 
  }

	
	/**
	 * @generated
	 */	
	public void setForestManagement(String newVal) {
    this.forestManagement = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double pcwRecycledPercent;
	
	/**
	 * @generated
 	 */
	public Double getPcwRecycledPercent(){
    return pcwRecycledPercent; 
  }

	
	/**
	 * @generated
	 */	
	public void setPcwRecycledPercent(Double newVal) {
    this.pcwRecycledPercent = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean fscCertified;
	
	/**
	 * @generated
 	 */
	public Boolean getFscCertified(){
    return fscCertified; 
  }

	
	/**
	 * @generated
	 */	
	public void setFscCertified(Boolean newVal) {
    this.fscCertified = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean sfiCertified;
	
	/**
	 * @generated
 	 */
	public Boolean getSfiCertified(){
    return sfiCertified; 
  }

	
	/**
	 * @generated
	 */	
	public void setSfiCertified(Boolean newVal) {
    this.sfiCertified = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean greenSealCertified;
	
	/**
	 * @generated
 	 */
	public Boolean getGreenSealCertified(){
    return greenSealCertified; 
  }

	
	/**
	 * @generated
	 */	
	public void setGreenSealCertified(Boolean newVal) {
    this.greenSealCertified = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private PaperPrice defaultPriceList;
	
	/**
	 * @generated
 	 */
	public PaperPrice getDefaultPriceList(){
    return defaultPriceList; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultPriceList(PaperPrice newVal) {
    this.defaultPriceList = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private GenericColors genericColor;
	
	/**
	 * @generated
 	 */
	public GenericColors getGenericColor(){
    return genericColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setGenericColor(GenericColors newVal) {
    this.genericColor = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
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
 	@Basic
	private String stockId;
	
	/**
	 * @generated
 	 */
	public String getStockId(){
    return stockId; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockId(String newVal) {
    this.stockId = newVal;
  }
 	
	
	/**
	 * @generated
	 */
    @OneToMany
    @JoinTable( name = "stockdefinition_charges")
	private java.util.List<ChargeDefinition> charges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeDefinition> getCharges(){
    return charges; 
  }

	/**
	 * @generated
	 */	
	public void addCharges(ChargeDefinition obj) {
    if (charges == null) {
      charges = new java.util.ArrayList<ChargeDefinition>();
    }
    charges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setCharges(java.util.List<ChargeDefinition> newVal) {
    this.charges = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copier1PricePerSheet;
	
	/**
	 * @generated
 	 */
	public Double getCopier1PricePerSheet(){
    return copier1PricePerSheet; 
  }

	
	/**
	 * @generated
	 */	
	public void setCopier1PricePerSheet(Double newVal) {
    this.copier1PricePerSheet = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copier2PricePerSheet;
	
	/**
	 * @generated
 	 */
	public Double getCopier2PricePerSheet(){
    return copier2PricePerSheet; 
  }

	
	/**
	 * @generated
	 */	
	public void setCopier2PricePerSheet(Double newVal) {
    this.copier2PricePerSheet = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double copier3PricePerSheet;
	
	/**
	 * @generated
 	 */
	public Double getCopier3PricePerSheet(){
    return copier3PricePerSheet; 
  }

	
	/**
	 * @generated
	 */	
	public void setCopier3PricePerSheet(Double newVal) {
    this.copier3PricePerSheet = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @OneToMany( fetch=FetchType.EAGER)
    @JoinTable( name = "stockdefinition_stockchanges")
	private java.util.List<StockChanges> stockChanges;
	
	/**
	 * @generated
 	 */
	public java.util.List<StockChanges> getStockChanges(){
    return stockChanges; 
  }

	/**
	 * @generated
	 */	
	public void addStockChanges(StockChanges obj) {
    if (stockChanges == null) {
      stockChanges = new java.util.ArrayList<StockChanges>();
    }
    stockChanges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setStockChanges(java.util.List<StockChanges> newVal) {
    this.stockChanges = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer mill;
	
	/**
	 * @generated
 	 */
	public Integer getMill(){
    return mill; 
  }

	
	/**
	 * @generated
	 */	
	public void setMill(Integer newVal) {
    this.mill = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer lotcount;
	
	/**
	 * @generated
 	 */
	public Integer getLotcount(){
    return lotcount; 
  }

	
	/**
	 * @generated
	 */	
	public void setLotcount(Integer newVal) {
    this.lotcount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double cartonWeight;
	
	/**
	 * @generated
 	 */
	public Double getCartonWeight(){
    return cartonWeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setCartonWeight(Double newVal) {
    this.cartonWeight = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer sheetperSkid;
	
	/**
	 * @generated
 	 */
	public Integer getSheetperSkid(){
    return sheetperSkid; 
  }

	
	/**
	 * @generated
	 */	
	public void setSheetperSkid(Integer newVal) {
    this.sheetperSkid = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double weightperSkid;
	
	/**
	 * @generated
 	 */
	public Double getWeightperSkid(){
    return weightperSkid; 
  }

	
	/**
	 * @generated
	 */	
	public void setWeightperSkid(Double newVal) {
    this.weightperSkid = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer shortgain;
	
	/**
	 * @generated
 	 */
	public Integer getShortgain(){
    return shortgain; 
  }

	
	/**
	 * @generated
	 */	
	public void setShortgain(Integer newVal) {
    this.shortgain = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noBrokenCarton;
	
	/**
	 * @generated
 	 */
	public Boolean getNoBrokenCarton(){
    return noBrokenCarton; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoBrokenCarton(Boolean newVal) {
    this.noBrokenCarton = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean pricedinSets;
	
	/**
	 * @generated
 	 */
	public Boolean getPricedinSets(){
    return pricedinSets; 
  }

	
	/**
	 * @generated
	 */	
	public void setPricedinSets(Boolean newVal) {
    this.pricedinSets = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean imported;
	
	/**
	 * @generated
 	 */
	public Boolean getImported(){
    return imported; 
  }

	
	/**
	 * @generated
	 */	
	public void setImported(Boolean newVal) {
    this.imported = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean measure;
	
	/**
	 * @generated
 	 */
	public Boolean getMeasure(){
    return measure; 
  }

	
	/**
	 * @generated
	 */	
	public void setMeasure(Boolean newVal) {
    this.measure = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allownegative;
	
	/**
	 * @generated
 	 */
	public Boolean getAllownegative(){
    return allownegative; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllownegative(Boolean newVal) {
    this.allownegative = newVal;
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
    @ManyToOne
	private CopierDefinition defaultBWCopier;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getDefaultBWCopier(){
    return defaultBWCopier; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultBWCopier(CopierDefinition newVal) {
    this.defaultBWCopier = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private CopierDefinition defaultColorCopier;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getDefaultColorCopier(){
    return defaultColorCopier; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultColorCopier(CopierDefinition newVal) {
    this.defaultColorCopier = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private CopierDefinition defaultLargeCopier;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getDefaultLargeCopier(){
    return defaultLargeCopier; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultLargeCopier(CopierDefinition newVal) {
    this.defaultLargeCopier = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (STOCKUNIT.equals(propertyName)) return getStockunit();
    if (NAME.equals(propertyName)) return getName();
    if (STKGROUP.equals(propertyName)) return getStkgroup();
    if (STKCLASS.equals(propertyName)) return getStkclass();
    if (STKTYPE.equals(propertyName)) return getStktype();
    if (ISMETRIC.equals(propertyName)) return getIsMetric();
    if (FINISH.equals(propertyName)) return getFinish();
    if (WEIGHT.equals(propertyName)) return getWeight();
    if (COLOR.equals(propertyName)) return getColor();
    if (GRADE.equals(propertyName)) return getGrade();
    if (COATED.equals(propertyName)) return getCoated();
    if (STOCKNUMBER.equals(propertyName)) return getStocknumber();
    if (VENDOR.equals(propertyName)) return getVendor();
    if (BASICSIZE.equals(propertyName)) return getBasicsize();
    if (PARENTSIZE.equals(propertyName)) return getParentsize();
    if (THICKNESS.equals(propertyName)) return getThickness();
    if (MWEIGHT.equals(propertyName)) return getMweight();
    if (SHEETSPERCARTON.equals(propertyName)) return getSheetspercarton();
    if (MINORDER.equals(propertyName)) return getMinorder();
    if (COMMENTS.equals(propertyName)) return getComments();
    if (UOM.equals(propertyName)) return getUom();
    if (COSTUNITS.equals(propertyName)) return getCostunits();
    if (ENTIREORDERCHARGE.equals(propertyName)) return getEntireOrderCharge();
    if (SHEETSPERSET.equals(propertyName)) return getSheetsPerSet();
    if (ISCOSTINSETS.equals(propertyName)) return getIsCostInSets();
    if (PRICEEXPIRES.equals(propertyName)) return getPriceExpires();
    if (QTYBREAK1.equals(propertyName)) return getQtybreak1();
    if (QTYBREAK2.equals(propertyName)) return getQtybreak2();
    if (QTYBREAK3.equals(propertyName)) return getQtybreak3();
    if (QTYBREAK4.equals(propertyName)) return getQtybreak4();
    if (QTYBREAK5.equals(propertyName)) return getQtybreak5();
    if (QTYBREAK6.equals(propertyName)) return getQtybreak6();
    if (COST1.equals(propertyName)) return getCost1();
    if (COST2.equals(propertyName)) return getCost2();
    if (COST3.equals(propertyName)) return getCost3();
    if (COST4.equals(propertyName)) return getCost4();
    if (COST5.equals(propertyName)) return getCost5();
    if (COST6.equals(propertyName)) return getCost6();
    if (CWT1.equals(propertyName)) return getCwt1();
    if (CWT2.equals(propertyName)) return getCwt2();
    if (CWT3.equals(propertyName)) return getCwt3();
    if (CWT4.equals(propertyName)) return getCwt4();
    if (CWT5.equals(propertyName)) return getCwt5();
    if (CWT6.equals(propertyName)) return getCwt6();
    if (MARKUP1.equals(propertyName)) return getMarkup1();
    if (MARKUP2.equals(propertyName)) return getMarkup2();
    if (MARKUP3.equals(propertyName)) return getMarkup3();
    if (MARKUP4.equals(propertyName)) return getMarkup4();
    if (MARKUP5.equals(propertyName)) return getMarkup5();
    if (MARKUP6.equals(propertyName)) return getMarkup6();
    if (LISTPERM1.equals(propertyName)) return getListPerM1();
    if (LISTPERM2.equals(propertyName)) return getListPerM2();
    if (LISTPERM3.equals(propertyName)) return getListPerM3();
    if (LISTPERM4.equals(propertyName)) return getListPerM4();
    if (LISTPERM5.equals(propertyName)) return getListPerM5();
    if (LISTPERM6.equals(propertyName)) return getListPerM6();
    if (NORMALRUNSIZE.equals(propertyName)) return getNormalRunSize();
    if (CUTSPER100.equals(propertyName)) return getCutsPer100();
    if (MINCUTCHARGE.equals(propertyName)) return getMinCutCharge();
    if (DEFAULTPRESS.equals(propertyName)) return getDefaultPress();
    if (AUTOCALCULATEBLANK.equals(propertyName)) return getAutoCalculateBlank();
    if (BLANKSHEETQTY1.equals(propertyName)) return getBlankSheetqty1();
    if (BLANKSHEETQTY2.equals(propertyName)) return getBlankSheetqty2();
    if (BLANKSHEETQTY3.equals(propertyName)) return getBlankSheetqty3();
    if (BLANKSHEETQTY4.equals(propertyName)) return getBlankSheetqty4();
    if (BLANKSHEETQTY5.equals(propertyName)) return getBlankSheetqty5();
    if (BLANKSHEETQTY6.equals(propertyName)) return getBlankSheetqty6();
    if (BLANKSHEETPRICE1.equals(propertyName)) return getBlankSheetPrice1();
    if (BLANKSHEETPRICE2.equals(propertyName)) return getBlankSheetPrice2();
    if (BLANKSHEETPRICE3.equals(propertyName)) return getBlankSheetPrice3();
    if (BLANKSHEETPRICE4.equals(propertyName)) return getBlankSheetPrice4();
    if (BLANKSHEETPRICE5.equals(propertyName)) return getBlankSheetPrice5();
    if (BLANKSHEETPRICE6.equals(propertyName)) return getBlankSheetPrice6();
    if (DEFAULTBW.equals(propertyName)) return getDefaultBW();
    if (DEFAULTCOLOR.equals(propertyName)) return getDefaultColor();
    if (DEFAULTLARGEFORMAT.equals(propertyName)) return getDefaultLargeFormat();
    if (ADDITIONAL1.equals(propertyName)) return getAdditional1();
    if (ADDITIONAL2.equals(propertyName)) return getAdditional2();
    if (ADDITIONAL3.equals(propertyName)) return getAdditional3();
    if (ADDITIONAL4.equals(propertyName)) return getAdditional4();
    if (ADDITIONAL5.equals(propertyName)) return getAdditional5();
    if (ADDITIONAL6.equals(propertyName)) return getAdditional6();
    if (ADDITIONAL7.equals(propertyName)) return getAdditional7();
    if (ADDITIONAL8.equals(propertyName)) return getAdditional8();
    if (ADDITIONAL9.equals(propertyName)) return getAdditional9();
    if (ADDITIONAL10.equals(propertyName)) return getAdditional10();
    if (STANDARDITEM.equals(propertyName)) return getStandardItem();
    if (ONHAND.equals(propertyName)) return getOnHand();
    if (COMMITTED.equals(propertyName)) return getCommitted();
    if (AVAILABLE.equals(propertyName)) return getAvailable();
    if (ONORDER.equals(propertyName)) return getOnOrder();
    if (TARGETLEVEL.equals(propertyName)) return getTargetLevel();
    if (REORDERPOINT.equals(propertyName)) return getReOrderPoint();
    if (MINORDERQTY.equals(propertyName)) return getMinOrderQty();
    if (EVENINCREMENTS.equals(propertyName)) return getEvenIncrements();
    if (EXPIRES.equals(propertyName)) return getExpires();
    if (BINLOCATION.equals(propertyName)) return getBinLocation();
    if (SHELLITEM.equals(propertyName)) return getShellItem();
    if (FORESTMANAGEMENT.equals(propertyName)) return getForestManagement();
    if (PCWRECYCLEDPERCENT.equals(propertyName)) return getPcwRecycledPercent();
    if (FSCCERTIFIED.equals(propertyName)) return getFscCertified();
    if (SFICERTIFIED.equals(propertyName)) return getSfiCertified();
    if (GREENSEALCERTIFIED.equals(propertyName)) return getGreenSealCertified();
    if (DEFAULTPRICELIST.equals(propertyName)) return getDefaultPriceList();
    if (GENERICCOLOR.equals(propertyName)) return getGenericColor();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (STOCKID.equals(propertyName)) return getStockId();
    if (CHARGES.equals(propertyName)) return getCharges();
    if (COPIER1PRICEPERSHEET.equals(propertyName)) return getCopier1PricePerSheet();
    if (COPIER2PRICEPERSHEET.equals(propertyName)) return getCopier2PricePerSheet();
    if (COPIER3PRICEPERSHEET.equals(propertyName)) return getCopier3PricePerSheet();
    if (STOCKCHANGES.equals(propertyName)) return getStockChanges();
    if (MILL.equals(propertyName)) return getMill();
    if (LOTCOUNT.equals(propertyName)) return getLotcount();
    if (CARTONWEIGHT.equals(propertyName)) return getCartonWeight();
    if (SHEETPERSKID.equals(propertyName)) return getSheetperSkid();
    if (WEIGHTPERSKID.equals(propertyName)) return getWeightperSkid();
    if (SHORTGAIN.equals(propertyName)) return getShortgain();
    if (NOBROKENCARTON.equals(propertyName)) return getNoBrokenCarton();
    if (PRICEDINSETS.equals(propertyName)) return getPricedinSets();
    if (IMPORTED.equals(propertyName)) return getImported();
    if (MEASURE.equals(propertyName)) return getMeasure();
    if (ALLOWNEGATIVE.equals(propertyName)) return getAllownegative();
    if (ROLLWEIGHT.equals(propertyName)) return getRollWeight();
    if (DEFAULTBWCOPIER.equals(propertyName)) return getDefaultBWCopier();
    if (DEFAULTCOLORCOPIER.equals(propertyName)) return getDefaultColorCopier();
    if (DEFAULTLARGECOPIER.equals(propertyName)) return getDefaultLargeCopier();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (STOCKUNIT.equals(propertyName)) setStockunit((Integer)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (STKGROUP.equals(propertyName)) setStkgroup((StockGroup)newValue); else
    if (STKCLASS.equals(propertyName)) setStkclass((StockClass)newValue); else
    if (STKTYPE.equals(propertyName)) setStktype((StockType)newValue); else
    if (ISMETRIC.equals(propertyName)) setIsMetric((Boolean)newValue); else
    if (FINISH.equals(propertyName)) setFinish((StockFinish)newValue); else
    if (WEIGHT.equals(propertyName)) setWeight((Double)newValue); else
    if (COLOR.equals(propertyName)) setColor((StockColors)newValue); else
    if (GRADE.equals(propertyName)) setGrade((StockGrade)newValue); else
    if (COATED.equals(propertyName)) setCoated((String)newValue); else
    if (STOCKNUMBER.equals(propertyName)) setStocknumber((String)newValue); else
    if (VENDOR.equals(propertyName)) setVendor((Vendor)newValue); else
    if (BASICSIZE.equals(propertyName)) setBasicsize((String)newValue); else
    if (PARENTSIZE.equals(propertyName)) setParentsize((String)newValue); else
    if (THICKNESS.equals(propertyName)) setThickness((Double)newValue); else
    if (MWEIGHT.equals(propertyName)) setMweight((Double)newValue); else
    if (SHEETSPERCARTON.equals(propertyName)) setSheetspercarton((Integer)newValue); else
    if (MINORDER.equals(propertyName)) setMinorder((Integer)newValue); else
    if (COMMENTS.equals(propertyName)) setComments((String)newValue); else
    if (UOM.equals(propertyName)) setUom((String)newValue); else
    if (COSTUNITS.equals(propertyName)) setCostunits((Integer)newValue); else
    if (ENTIREORDERCHARGE.equals(propertyName)) setEntireOrderCharge((Boolean)newValue); else
    if (SHEETSPERSET.equals(propertyName)) setSheetsPerSet((Integer)newValue); else
    if (ISCOSTINSETS.equals(propertyName)) setIsCostInSets((Boolean)newValue); else
    if (PRICEEXPIRES.equals(propertyName)) setPriceExpires((Date)newValue); else
    if (QTYBREAK1.equals(propertyName)) setQtybreak1((Integer)newValue); else
    if (QTYBREAK2.equals(propertyName)) setQtybreak2((Integer)newValue); else
    if (QTYBREAK3.equals(propertyName)) setQtybreak3((Integer)newValue); else
    if (QTYBREAK4.equals(propertyName)) setQtybreak4((Integer)newValue); else
    if (QTYBREAK5.equals(propertyName)) setQtybreak5((Integer)newValue); else
    if (QTYBREAK6.equals(propertyName)) setQtybreak6((Integer)newValue); else
    if (COST1.equals(propertyName)) setCost1((Double)newValue); else
    if (COST2.equals(propertyName)) setCost2((Double)newValue); else
    if (COST3.equals(propertyName)) setCost3((Double)newValue); else
    if (COST4.equals(propertyName)) setCost4((Double)newValue); else
    if (COST5.equals(propertyName)) setCost5((Double)newValue); else
    if (COST6.equals(propertyName)) setCost6((Double)newValue); else
    if (CWT1.equals(propertyName)) setCwt1((Double)newValue); else
    if (CWT2.equals(propertyName)) setCwt2((Double)newValue); else
    if (CWT3.equals(propertyName)) setCwt3((Double)newValue); else
    if (CWT4.equals(propertyName)) setCwt4((Double)newValue); else
    if (CWT5.equals(propertyName)) setCwt5((Double)newValue); else
    if (CWT6.equals(propertyName)) setCwt6((Double)newValue); else
    if (MARKUP1.equals(propertyName)) setMarkup1((Double)newValue); else
    if (MARKUP2.equals(propertyName)) setMarkup2((Double)newValue); else
    if (MARKUP3.equals(propertyName)) setMarkup3((Double)newValue); else
    if (MARKUP4.equals(propertyName)) setMarkup4((Double)newValue); else
    if (MARKUP5.equals(propertyName)) setMarkup5((Double)newValue); else
    if (MARKUP6.equals(propertyName)) setMarkup6((Double)newValue); else
    if (LISTPERM1.equals(propertyName)) setListPerM1((Integer)newValue); else
    if (LISTPERM2.equals(propertyName)) setListPerM2((Integer)newValue); else
    if (LISTPERM3.equals(propertyName)) setListPerM3((Integer)newValue); else
    if (LISTPERM4.equals(propertyName)) setListPerM4((Integer)newValue); else
    if (LISTPERM5.equals(propertyName)) setListPerM5((Integer)newValue); else
    if (LISTPERM6.equals(propertyName)) setListPerM6((Integer)newValue); else
    if (NORMALRUNSIZE.equals(propertyName)) setNormalRunSize((String)newValue); else
    if (CUTSPER100.equals(propertyName)) setCutsPer100((Integer)newValue); else
    if (MINCUTCHARGE.equals(propertyName)) setMinCutCharge((Double)newValue); else
    if (DEFAULTPRESS.equals(propertyName)) setDefaultPress((PressDefinition)newValue); else
    if (AUTOCALCULATEBLANK.equals(propertyName)) setAutoCalculateBlank((Boolean)newValue); else
    if (BLANKSHEETQTY1.equals(propertyName)) setBlankSheetqty1((Integer)newValue); else
    if (BLANKSHEETQTY2.equals(propertyName)) setBlankSheetqty2((Integer)newValue); else
    if (BLANKSHEETQTY3.equals(propertyName)) setBlankSheetqty3((Integer)newValue); else
    if (BLANKSHEETQTY4.equals(propertyName)) setBlankSheetqty4((Integer)newValue); else
    if (BLANKSHEETQTY5.equals(propertyName)) setBlankSheetqty5((Integer)newValue); else
    if (BLANKSHEETQTY6.equals(propertyName)) setBlankSheetqty6((Integer)newValue); else
    if (BLANKSHEETPRICE1.equals(propertyName)) setBlankSheetPrice1((Double)newValue); else
    if (BLANKSHEETPRICE2.equals(propertyName)) setBlankSheetPrice2((Double)newValue); else
    if (BLANKSHEETPRICE3.equals(propertyName)) setBlankSheetPrice3((Double)newValue); else
    if (BLANKSHEETPRICE4.equals(propertyName)) setBlankSheetPrice4((Double)newValue); else
    if (BLANKSHEETPRICE5.equals(propertyName)) setBlankSheetPrice5((Double)newValue); else
    if (BLANKSHEETPRICE6.equals(propertyName)) setBlankSheetPrice6((Double)newValue); else
    if (DEFAULTBW.equals(propertyName)) setDefaultBW((String)newValue); else
    if (DEFAULTCOLOR.equals(propertyName)) setDefaultColor((String)newValue); else
    if (DEFAULTLARGEFORMAT.equals(propertyName)) setDefaultLargeFormat((String)newValue); else
    if (ADDITIONAL1.equals(propertyName)) setAdditional1((String)newValue); else
    if (ADDITIONAL2.equals(propertyName)) setAdditional2((String)newValue); else
    if (ADDITIONAL3.equals(propertyName)) setAdditional3((String)newValue); else
    if (ADDITIONAL4.equals(propertyName)) setAdditional4((String)newValue); else
    if (ADDITIONAL5.equals(propertyName)) setAdditional5((String)newValue); else
    if (ADDITIONAL6.equals(propertyName)) setAdditional6((String)newValue); else
    if (ADDITIONAL7.equals(propertyName)) setAdditional7((String)newValue); else
    if (ADDITIONAL8.equals(propertyName)) setAdditional8((String)newValue); else
    if (ADDITIONAL9.equals(propertyName)) setAdditional9((String)newValue); else
    if (ADDITIONAL10.equals(propertyName)) setAdditional10((String)newValue); else
    if (STANDARDITEM.equals(propertyName)) setStandardItem((Boolean)newValue); else
    if (ONHAND.equals(propertyName)) setOnHand((Integer)newValue); else
    if (COMMITTED.equals(propertyName)) setCommitted((Integer)newValue); else
    if (AVAILABLE.equals(propertyName)) setAvailable((Integer)newValue); else
    if (ONORDER.equals(propertyName)) setOnOrder((Integer)newValue); else
    if (TARGETLEVEL.equals(propertyName)) setTargetLevel((Integer)newValue); else
    if (REORDERPOINT.equals(propertyName)) setReOrderPoint((Integer)newValue); else
    if (MINORDERQTY.equals(propertyName)) setMinOrderQty((Integer)newValue); else
    if (EVENINCREMENTS.equals(propertyName)) setEvenIncrements((Boolean)newValue); else
    if (EXPIRES.equals(propertyName)) setExpires((Date)newValue); else
    if (BINLOCATION.equals(propertyName)) setBinLocation((String)newValue); else
    if (SHELLITEM.equals(propertyName)) setShellItem((Boolean)newValue); else
    if (FORESTMANAGEMENT.equals(propertyName)) setForestManagement((String)newValue); else
    if (PCWRECYCLEDPERCENT.equals(propertyName)) setPcwRecycledPercent((Double)newValue); else
    if (FSCCERTIFIED.equals(propertyName)) setFscCertified((Boolean)newValue); else
    if (SFICERTIFIED.equals(propertyName)) setSfiCertified((Boolean)newValue); else
    if (GREENSEALCERTIFIED.equals(propertyName)) setGreenSealCertified((Boolean)newValue); else
    if (DEFAULTPRICELIST.equals(propertyName)) setDefaultPriceList((PaperPrice)newValue); else
    if (GENERICCOLOR.equals(propertyName)) setGenericColor((GenericColors)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (STOCKID.equals(propertyName)) setStockId((String)newValue); else
    if (CHARGES.equals(propertyName)) setCharges((java.util.List<ChargeDefinition>)newValue); else
    if (COPIER1PRICEPERSHEET.equals(propertyName)) setCopier1PricePerSheet((Double)newValue); else
    if (COPIER2PRICEPERSHEET.equals(propertyName)) setCopier2PricePerSheet((Double)newValue); else
    if (COPIER3PRICEPERSHEET.equals(propertyName)) setCopier3PricePerSheet((Double)newValue); else
    if (STOCKCHANGES.equals(propertyName)) setStockChanges((java.util.List<StockChanges>)newValue); else
    if (MILL.equals(propertyName)) setMill((Integer)newValue); else
    if (LOTCOUNT.equals(propertyName)) setLotcount((Integer)newValue); else
    if (CARTONWEIGHT.equals(propertyName)) setCartonWeight((Double)newValue); else
    if (SHEETPERSKID.equals(propertyName)) setSheetperSkid((Integer)newValue); else
    if (WEIGHTPERSKID.equals(propertyName)) setWeightperSkid((Double)newValue); else
    if (SHORTGAIN.equals(propertyName)) setShortgain((Integer)newValue); else
    if (NOBROKENCARTON.equals(propertyName)) setNoBrokenCarton((Boolean)newValue); else
    if (PRICEDINSETS.equals(propertyName)) setPricedinSets((Boolean)newValue); else
    if (IMPORTED.equals(propertyName)) setImported((Boolean)newValue); else
    if (MEASURE.equals(propertyName)) setMeasure((Boolean)newValue); else
    if (ALLOWNEGATIVE.equals(propertyName)) setAllownegative((Boolean)newValue); else
    if (ROLLWEIGHT.equals(propertyName)) setRollWeight((Double)newValue); else
    if (DEFAULTBWCOPIER.equals(propertyName)) setDefaultBWCopier((CopierDefinition)newValue); else
    if (DEFAULTCOLORCOPIER.equals(propertyName)) setDefaultColorCopier((CopierDefinition)newValue); else
    if (DEFAULTLARGECOPIER.equals(propertyName)) setDefaultLargeCopier((CopierDefinition)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (STOCKUNIT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STKGROUP.equals(propertyName)) 
      return new Class<?>[] {StockGroup.class};		
    if (STKCLASS.equals(propertyName)) 
      return new Class<?>[] {StockClass.class};		
    if (STKTYPE.equals(propertyName)) 
      return new Class<?>[] {StockType.class};		
    if (ISMETRIC.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FINISH.equals(propertyName)) 
      return new Class<?>[] {StockFinish.class};		
    if (WEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COLOR.equals(propertyName)) 
      return new Class<?>[] {StockColors.class};		
    if (GRADE.equals(propertyName)) 
      return new Class<?>[] {StockGrade.class};		
    if (COATED.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STOCKNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (VENDOR.equals(propertyName)) 
      return new Class<?>[] {Vendor.class};		
    if (BASICSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PARENTSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (THICKNESS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHEETSPERCARTON.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (MINORDER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COMMENTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (UOM.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COSTUNITS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ENTIREORDERCHARGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHEETSPERSET.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ISCOSTINSETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRICEEXPIRES.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (QTYBREAK1.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYBREAK2.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYBREAK3.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYBREAK4.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYBREAK5.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYBREAK6.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COST1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COST2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COST3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COST4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COST5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COST6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CWT6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MARKUP6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LISTPERM1.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LISTPERM2.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LISTPERM3.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LISTPERM4.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LISTPERM5.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LISTPERM6.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (NORMALRUNSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUTSPER100.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (MINCUTCHARGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEFAULTPRESS.equals(propertyName)) 
      return new Class<?>[] {PressDefinition.class};		
    if (AUTOCALCULATEBLANK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (BLANKSHEETQTY1.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETQTY2.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETQTY3.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETQTY4.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETQTY5.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETQTY6.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (BLANKSHEETPRICE1.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKSHEETPRICE2.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKSHEETPRICE3.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKSHEETPRICE4.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKSHEETPRICE5.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLANKSHEETPRICE6.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEFAULTBW.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DEFAULTCOLOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DEFAULTLARGEFORMAT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL1.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL2.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL3.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL4.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL5.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL6.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL7.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL8.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL9.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDITIONAL10.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STANDARDITEM.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ONHAND.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (COMMITTED.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (AVAILABLE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ONORDER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TARGETLEVEL.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (REORDERPOINT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (MINORDERQTY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (EVENINCREMENTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EXPIRES.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (BINLOCATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHELLITEM.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FORESTMANAGEMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PCWRECYCLEDPERCENT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FSCCERTIFIED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SFICERTIFIED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (GREENSEALCERTIFIED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DEFAULTPRICELIST.equals(propertyName)) 
      return new Class<?>[] {PaperPrice.class};		
    if (GENERICCOLOR.equals(propertyName)) 
      return new Class<?>[] {GenericColors.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (STOCKID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeDefinition.class};		
    if (COPIER1PRICEPERSHEET.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COPIER2PRICEPERSHEET.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COPIER3PRICEPERSHEET.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (STOCKCHANGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, StockChanges.class};		
    if (MILL.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (LOTCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CARTONWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHEETPERSKID.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (WEIGHTPERSKID.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHORTGAIN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (NOBROKENCARTON.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRICEDINSETS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (IMPORTED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MEASURE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ALLOWNEGATIVE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ROLLWEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEFAULTBWCOPIER.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    if (DEFAULTCOLORCOPIER.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    if (DEFAULTLARGECOPIER.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (STOCKUNIT.equals(propertyName)) return StockDefinition.class;
    if (NAME.equals(propertyName)) return StockDefinition.class;
    if (STKGROUP.equals(propertyName)) return StockDefinition.class;
    if (STKCLASS.equals(propertyName)) return StockDefinition.class;
    if (STKTYPE.equals(propertyName)) return StockDefinition.class;
    if (ISMETRIC.equals(propertyName)) return StockDefinition.class;
    if (FINISH.equals(propertyName)) return StockDefinition.class;
    if (WEIGHT.equals(propertyName)) return StockDefinition.class;
    if (COLOR.equals(propertyName)) return StockDefinition.class;
    if (GRADE.equals(propertyName)) return StockDefinition.class;
    if (COATED.equals(propertyName)) return StockDefinition.class;
    if (STOCKNUMBER.equals(propertyName)) return StockDefinition.class;
    if (VENDOR.equals(propertyName)) return StockDefinition.class;
    if (BASICSIZE.equals(propertyName)) return StockDefinition.class;
    if (PARENTSIZE.equals(propertyName)) return StockDefinition.class;
    if (THICKNESS.equals(propertyName)) return StockDefinition.class;
    if (MWEIGHT.equals(propertyName)) return StockDefinition.class;
    if (SHEETSPERCARTON.equals(propertyName)) return StockDefinition.class;
    if (MINORDER.equals(propertyName)) return StockDefinition.class;
    if (COMMENTS.equals(propertyName)) return StockDefinition.class;
    if (UOM.equals(propertyName)) return StockDefinition.class;
    if (COSTUNITS.equals(propertyName)) return StockDefinition.class;
    if (ENTIREORDERCHARGE.equals(propertyName)) return StockDefinition.class;
    if (SHEETSPERSET.equals(propertyName)) return StockDefinition.class;
    if (ISCOSTINSETS.equals(propertyName)) return StockDefinition.class;
    if (PRICEEXPIRES.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK1.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK2.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK3.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK4.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK5.equals(propertyName)) return StockDefinition.class;
    if (QTYBREAK6.equals(propertyName)) return StockDefinition.class;
    if (COST1.equals(propertyName)) return StockDefinition.class;
    if (COST2.equals(propertyName)) return StockDefinition.class;
    if (COST3.equals(propertyName)) return StockDefinition.class;
    if (COST4.equals(propertyName)) return StockDefinition.class;
    if (COST5.equals(propertyName)) return StockDefinition.class;
    if (COST6.equals(propertyName)) return StockDefinition.class;
    if (CWT1.equals(propertyName)) return StockDefinition.class;
    if (CWT2.equals(propertyName)) return StockDefinition.class;
    if (CWT3.equals(propertyName)) return StockDefinition.class;
    if (CWT4.equals(propertyName)) return StockDefinition.class;
    if (CWT5.equals(propertyName)) return StockDefinition.class;
    if (CWT6.equals(propertyName)) return StockDefinition.class;
    if (MARKUP1.equals(propertyName)) return StockDefinition.class;
    if (MARKUP2.equals(propertyName)) return StockDefinition.class;
    if (MARKUP3.equals(propertyName)) return StockDefinition.class;
    if (MARKUP4.equals(propertyName)) return StockDefinition.class;
    if (MARKUP5.equals(propertyName)) return StockDefinition.class;
    if (MARKUP6.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM1.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM2.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM3.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM4.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM5.equals(propertyName)) return StockDefinition.class;
    if (LISTPERM6.equals(propertyName)) return StockDefinition.class;
    if (NORMALRUNSIZE.equals(propertyName)) return StockDefinition.class;
    if (CUTSPER100.equals(propertyName)) return StockDefinition.class;
    if (MINCUTCHARGE.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTPRESS.equals(propertyName)) return StockDefinition.class;
    if (AUTOCALCULATEBLANK.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY1.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY2.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY3.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY4.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY5.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETQTY6.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE1.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE2.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE3.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE4.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE5.equals(propertyName)) return StockDefinition.class;
    if (BLANKSHEETPRICE6.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTBW.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTCOLOR.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTLARGEFORMAT.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL1.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL2.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL3.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL4.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL5.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL6.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL7.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL8.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL9.equals(propertyName)) return StockDefinition.class;
    if (ADDITIONAL10.equals(propertyName)) return StockDefinition.class;
    if (STANDARDITEM.equals(propertyName)) return StockDefinition.class;
    if (ONHAND.equals(propertyName)) return StockDefinition.class;
    if (COMMITTED.equals(propertyName)) return StockDefinition.class;
    if (AVAILABLE.equals(propertyName)) return StockDefinition.class;
    if (ONORDER.equals(propertyName)) return StockDefinition.class;
    if (TARGETLEVEL.equals(propertyName)) return StockDefinition.class;
    if (REORDERPOINT.equals(propertyName)) return StockDefinition.class;
    if (MINORDERQTY.equals(propertyName)) return StockDefinition.class;
    if (EVENINCREMENTS.equals(propertyName)) return StockDefinition.class;
    if (EXPIRES.equals(propertyName)) return StockDefinition.class;
    if (BINLOCATION.equals(propertyName)) return StockDefinition.class;
    if (SHELLITEM.equals(propertyName)) return StockDefinition.class;
    if (FORESTMANAGEMENT.equals(propertyName)) return StockDefinition.class;
    if (PCWRECYCLEDPERCENT.equals(propertyName)) return StockDefinition.class;
    if (FSCCERTIFIED.equals(propertyName)) return StockDefinition.class;
    if (SFICERTIFIED.equals(propertyName)) return StockDefinition.class;
    if (GREENSEALCERTIFIED.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTPRICELIST.equals(propertyName)) return StockDefinition.class;
    if (GENERICCOLOR.equals(propertyName)) return StockDefinition.class;
    if (ACCOUNT.equals(propertyName)) return StockDefinition.class;
    if (STOCKID.equals(propertyName)) return StockDefinition.class;
    if (CHARGES.equals(propertyName)) return StockDefinition.class;
    if (COPIER1PRICEPERSHEET.equals(propertyName)) return StockDefinition.class;
    if (COPIER2PRICEPERSHEET.equals(propertyName)) return StockDefinition.class;
    if (COPIER3PRICEPERSHEET.equals(propertyName)) return StockDefinition.class;
    if (STOCKCHANGES.equals(propertyName)) return StockDefinition.class;
    if (MILL.equals(propertyName)) return StockDefinition.class;
    if (LOTCOUNT.equals(propertyName)) return StockDefinition.class;
    if (CARTONWEIGHT.equals(propertyName)) return StockDefinition.class;
    if (SHEETPERSKID.equals(propertyName)) return StockDefinition.class;
    if (WEIGHTPERSKID.equals(propertyName)) return StockDefinition.class;
    if (SHORTGAIN.equals(propertyName)) return StockDefinition.class;
    if (NOBROKENCARTON.equals(propertyName)) return StockDefinition.class;
    if (PRICEDINSETS.equals(propertyName)) return StockDefinition.class;
    if (IMPORTED.equals(propertyName)) return StockDefinition.class;
    if (MEASURE.equals(propertyName)) return StockDefinition.class;
    if (ALLOWNEGATIVE.equals(propertyName)) return StockDefinition.class;
    if (ROLLWEIGHT.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTBWCOPIER.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTCOLORCOPIER.equals(propertyName)) return StockDefinition.class;
    if (DEFAULTLARGECOPIER.equals(propertyName)) return StockDefinition.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    StockDefinition objT = (StockDefinition)obj;
    if (! SmartEquals(getStockunit(), objT.getStockunit()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getStkgroup(), objT.getStkgroup()))
      return false;
    if (! SmartEquals(getStkclass(), objT.getStkclass()))
      return false;
    if (! SmartEquals(getStktype(), objT.getStktype()))
      return false;
    if (! SmartEquals(getIsMetric(), objT.getIsMetric()))
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
    if (! SmartEquals(getStocknumber(), objT.getStocknumber()))
      return false;
    if (! SmartEquals(getVendor(), objT.getVendor()))
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
    if (! SmartEquals(getComments(), objT.getComments()))
      return false;
    if (! SmartEquals(getUom(), objT.getUom()))
      return false;
    if (! SmartEquals(getCostunits(), objT.getCostunits()))
      return false;
    if (! SmartEquals(getEntireOrderCharge(), objT.getEntireOrderCharge()))
      return false;
    if (! SmartEquals(getSheetsPerSet(), objT.getSheetsPerSet()))
      return false;
    if (! SmartEquals(getIsCostInSets(), objT.getIsCostInSets()))
      return false;
    if (! SmartEquals(getPriceExpires(), objT.getPriceExpires()))
      return false;
    if (! SmartEquals(getQtybreak1(), objT.getQtybreak1()))
      return false;
    if (! SmartEquals(getQtybreak2(), objT.getQtybreak2()))
      return false;
    if (! SmartEquals(getQtybreak3(), objT.getQtybreak3()))
      return false;
    if (! SmartEquals(getQtybreak4(), objT.getQtybreak4()))
      return false;
    if (! SmartEquals(getQtybreak5(), objT.getQtybreak5()))
      return false;
    if (! SmartEquals(getQtybreak6(), objT.getQtybreak6()))
      return false;
    if (! SmartEquals(getCost1(), objT.getCost1()))
      return false;
    if (! SmartEquals(getCost2(), objT.getCost2()))
      return false;
    if (! SmartEquals(getCost3(), objT.getCost3()))
      return false;
    if (! SmartEquals(getCost4(), objT.getCost4()))
      return false;
    if (! SmartEquals(getCost5(), objT.getCost5()))
      return false;
    if (! SmartEquals(getCost6(), objT.getCost6()))
      return false;
    if (! SmartEquals(getCwt1(), objT.getCwt1()))
      return false;
    if (! SmartEquals(getCwt2(), objT.getCwt2()))
      return false;
    if (! SmartEquals(getCwt3(), objT.getCwt3()))
      return false;
    if (! SmartEquals(getCwt4(), objT.getCwt4()))
      return false;
    if (! SmartEquals(getCwt5(), objT.getCwt5()))
      return false;
    if (! SmartEquals(getCwt6(), objT.getCwt6()))
      return false;
    if (! SmartEquals(getMarkup1(), objT.getMarkup1()))
      return false;
    if (! SmartEquals(getMarkup2(), objT.getMarkup2()))
      return false;
    if (! SmartEquals(getMarkup3(), objT.getMarkup3()))
      return false;
    if (! SmartEquals(getMarkup4(), objT.getMarkup4()))
      return false;
    if (! SmartEquals(getMarkup5(), objT.getMarkup5()))
      return false;
    if (! SmartEquals(getMarkup6(), objT.getMarkup6()))
      return false;
    if (! SmartEquals(getListPerM1(), objT.getListPerM1()))
      return false;
    if (! SmartEquals(getListPerM2(), objT.getListPerM2()))
      return false;
    if (! SmartEquals(getListPerM3(), objT.getListPerM3()))
      return false;
    if (! SmartEquals(getListPerM4(), objT.getListPerM4()))
      return false;
    if (! SmartEquals(getListPerM5(), objT.getListPerM5()))
      return false;
    if (! SmartEquals(getListPerM6(), objT.getListPerM6()))
      return false;
    if (! SmartEquals(getNormalRunSize(), objT.getNormalRunSize()))
      return false;
    if (! SmartEquals(getCutsPer100(), objT.getCutsPer100()))
      return false;
    if (! SmartEquals(getMinCutCharge(), objT.getMinCutCharge()))
      return false;
    if (! SmartEquals(getDefaultPress(), objT.getDefaultPress()))
      return false;
    if (! SmartEquals(getAutoCalculateBlank(), objT.getAutoCalculateBlank()))
      return false;
    if (! SmartEquals(getBlankSheetqty1(), objT.getBlankSheetqty1()))
      return false;
    if (! SmartEquals(getBlankSheetqty2(), objT.getBlankSheetqty2()))
      return false;
    if (! SmartEquals(getBlankSheetqty3(), objT.getBlankSheetqty3()))
      return false;
    if (! SmartEquals(getBlankSheetqty4(), objT.getBlankSheetqty4()))
      return false;
    if (! SmartEquals(getBlankSheetqty5(), objT.getBlankSheetqty5()))
      return false;
    if (! SmartEquals(getBlankSheetqty6(), objT.getBlankSheetqty6()))
      return false;
    if (! SmartEquals(getBlankSheetPrice1(), objT.getBlankSheetPrice1()))
      return false;
    if (! SmartEquals(getBlankSheetPrice2(), objT.getBlankSheetPrice2()))
      return false;
    if (! SmartEquals(getBlankSheetPrice3(), objT.getBlankSheetPrice3()))
      return false;
    if (! SmartEquals(getBlankSheetPrice4(), objT.getBlankSheetPrice4()))
      return false;
    if (! SmartEquals(getBlankSheetPrice5(), objT.getBlankSheetPrice5()))
      return false;
    if (! SmartEquals(getBlankSheetPrice6(), objT.getBlankSheetPrice6()))
      return false;
    if (! SmartEquals(getDefaultBW(), objT.getDefaultBW()))
      return false;
    if (! SmartEquals(getDefaultColor(), objT.getDefaultColor()))
      return false;
    if (! SmartEquals(getDefaultLargeFormat(), objT.getDefaultLargeFormat()))
      return false;
    if (! SmartEquals(getAdditional1(), objT.getAdditional1()))
      return false;
    if (! SmartEquals(getAdditional2(), objT.getAdditional2()))
      return false;
    if (! SmartEquals(getAdditional3(), objT.getAdditional3()))
      return false;
    if (! SmartEquals(getAdditional4(), objT.getAdditional4()))
      return false;
    if (! SmartEquals(getAdditional5(), objT.getAdditional5()))
      return false;
    if (! SmartEquals(getAdditional6(), objT.getAdditional6()))
      return false;
    if (! SmartEquals(getAdditional7(), objT.getAdditional7()))
      return false;
    if (! SmartEquals(getAdditional8(), objT.getAdditional8()))
      return false;
    if (! SmartEquals(getAdditional9(), objT.getAdditional9()))
      return false;
    if (! SmartEquals(getAdditional10(), objT.getAdditional10()))
      return false;
    if (! SmartEquals(getStandardItem(), objT.getStandardItem()))
      return false;
    if (! SmartEquals(getOnHand(), objT.getOnHand()))
      return false;
    if (! SmartEquals(getCommitted(), objT.getCommitted()))
      return false;
    if (! SmartEquals(getAvailable(), objT.getAvailable()))
      return false;
    if (! SmartEquals(getOnOrder(), objT.getOnOrder()))
      return false;
    if (! SmartEquals(getTargetLevel(), objT.getTargetLevel()))
      return false;
    if (! SmartEquals(getReOrderPoint(), objT.getReOrderPoint()))
      return false;
    if (! SmartEquals(getMinOrderQty(), objT.getMinOrderQty()))
      return false;
    if (! SmartEquals(getEvenIncrements(), objT.getEvenIncrements()))
      return false;
    if (! SmartEquals(getExpires(), objT.getExpires()))
      return false;
    if (! SmartEquals(getBinLocation(), objT.getBinLocation()))
      return false;
    if (! SmartEquals(getShellItem(), objT.getShellItem()))
      return false;
    if (! SmartEquals(getForestManagement(), objT.getForestManagement()))
      return false;
    if (! SmartEquals(getPcwRecycledPercent(), objT.getPcwRecycledPercent()))
      return false;
    if (! SmartEquals(getFscCertified(), objT.getFscCertified()))
      return false;
    if (! SmartEquals(getSfiCertified(), objT.getSfiCertified()))
      return false;
    if (! SmartEquals(getGreenSealCertified(), objT.getGreenSealCertified()))
      return false;
    if (! SmartEquals(getDefaultPriceList(), objT.getDefaultPriceList()))
      return false;
    if (! SmartEquals(getGenericColor(), objT.getGenericColor()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getStockId(), objT.getStockId()))
      return false;
    if (! SmartEquals(getCharges(), objT.getCharges()))
      return false;
    if (! SmartEquals(getCopier1PricePerSheet(), objT.getCopier1PricePerSheet()))
      return false;
    if (! SmartEquals(getCopier2PricePerSheet(), objT.getCopier2PricePerSheet()))
      return false;
    if (! SmartEquals(getCopier3PricePerSheet(), objT.getCopier3PricePerSheet()))
      return false;
    if (! SmartEquals(getStockChanges(), objT.getStockChanges()))
      return false;
    if (! SmartEquals(getMill(), objT.getMill()))
      return false;
    if (! SmartEquals(getLotcount(), objT.getLotcount()))
      return false;
    if (! SmartEquals(getCartonWeight(), objT.getCartonWeight()))
      return false;
    if (! SmartEquals(getSheetperSkid(), objT.getSheetperSkid()))
      return false;
    if (! SmartEquals(getWeightperSkid(), objT.getWeightperSkid()))
      return false;
    if (! SmartEquals(getShortgain(), objT.getShortgain()))
      return false;
    if (! SmartEquals(getNoBrokenCarton(), objT.getNoBrokenCarton()))
      return false;
    if (! SmartEquals(getPricedinSets(), objT.getPricedinSets()))
      return false;
    if (! SmartEquals(getImported(), objT.getImported()))
      return false;
    if (! SmartEquals(getMeasure(), objT.getMeasure()))
      return false;
    if (! SmartEquals(getAllownegative(), objT.getAllownegative()))
      return false;
    if (! SmartEquals(getRollWeight(), objT.getRollWeight()))
      return false;
    if (! SmartEquals(getDefaultBWCopier(), objT.getDefaultBWCopier()))
      return false;
    if (! SmartEquals(getDefaultColorCopier(), objT.getDefaultColorCopier()))
      return false;
    if (! SmartEquals(getDefaultLargeCopier(), objT.getDefaultLargeCopier()))
      return false;
    return true;
  }			
}
