
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
  @NamedQuery(name = "PreferencesEstimating.findall", query = "from PreferencesEstimating"),
  @NamedQuery(name = "PreferencesEstimating.byId", query = "select a from PreferencesEstimating a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesestimating")
@SQLDelete(sql="update preferencesestimating set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesEstimating extends ModelBase {
	/**
	 * @generated
	 */
	public static final String FOLIOLOCATION = "FolioLocation";
	/**
	 * @generated
	 */
	public static final String GRIPLOCATION = "GripLocation";
	/**
	 * @generated
	 */
	public static final String CLOSEAFTERCOPY = "CloseAfterCopy";
	/**
	 * @generated
	 */
	public static final String STOCKCOSTINESTIMATOR = "StockCostInEstimator";
	/**
	 * @generated
	 */
	public static final String CANCHANGEADDRESS = "CanChangeAddress";
	/**
	 * @generated
	 */
	public static final String SHOWPAPERCALCULATOR = "ShowPaperCalculator";
	/**
	 * @generated
	 */
	public static final String USESTOCKPARENTSIZE = "UseStockParentSize";
	/**
	 * @generated
	 */
	public static final String CALCULATEREORDERDATE = "CalculateReOrderDate";
	/**
	 * @generated
	 */
	public static final String VALIDATESALESREP = "ValidateSalesRep";
	/**
	 * @generated
	 */
	public static final String LEAVEFOLDEDSIZEEMPTY = "LeaveFoldedSizeEmpty";
	/**
	 * @generated
	 */
	public static final String DONOTCOSTDURINGPOST = "DoNotCostDuringPost";
	/**
	 * @generated
	 */
	public static final String AUTOSHOWCHARGES = "AutoShowCharges";
	/**
	 * @generated
	 */
	public static final String NEVERUSEPRESETPRESSONSTOCKCHANGES = "NeverUsePresetPressOnStockChanges";
	/**
	 * @generated
	 */
	public static final String ADDFIXEDWASTEFOREACHPASS = "AddFixedWasteForEachPass";
	/**
	 * @generated
	 */
	public static final String ADDFIXEDWASTEFOREACHCOLOR = "AddFixedWasteForEachColor";
	/**
	 * @generated
	 */
	public static final String CALCULATEINKBYIMPRESSIONS = "CalculateInkbyImpressions";
	/**
	 * @generated
	 */
	public static final String USEHISTORYTITLEFORNEWTITLE = "UseHistoryTitleforNewTitle";
	/**
	 * @generated
	 */
	public static final String NORMALDUEDATEDAYS = "NormalDueDateDays";
	/**
	 * @generated
	 */
	public static final String CLOSEINVOICEAFTERPRINTINGTICKET = "CloseInvoiceAfterPrintingTicket";
	/**
	 * @generated
	 */
	public static final String CLOSEINVOICESANDESTIMATEAFTERPRINTING = "CloseInvoicesAndEstimateAfterPrinting";
	/**
	 * @generated
	 */
	public static final String DEFAULTINVOICE = "DefaultInvoice";
	/**
	 * @generated
	 */
	public static final String DEFAULTESTIMATE = "DefaultEstimate";
	/**
	 * @generated
	 */
	public static final String NUMBEROFDAYSBEFOREDUE = "NumberOfDaysBeforeDue";
	/**
	 * @generated
	 */
	public static final String DUEFROM = "DueFrom";
	/**
	 * @generated
	 */
	public static final String USEGRIPEDGEGAP = "UseGripEdgeGap";
	/**
	 * @generated
	 */
	public static final String GRIPEDGEGAP = "GripEdgeGap";
	/**
	 * @generated
	 */
	public static final String USEFOLIOEDGE = "UseFolioEdge";
	/**
	 * @generated
	 */
	public static final String FOLIOEDGE = "FolioEdge";
	/**
	 * @generated
	 */
	public static final String USECOLORBAR = "UseColorBar";
	/**
	 * @generated
	 */
	public static final String COLORBAR = "ColorBar";
	/**
	 * @generated
	 */
	public static final String USEWHITESPACE = "UseWhiteSpace";
	/**
	 * @generated
	 */
	public static final String WHITESPACE = "WhiteSpace";
	/**
	 * @generated
	 */
	public static final String WHITESPACETOP = "WhiteSpaceTop";
	/**
	 * @generated
	 */
	public static final String WHITESPACERIGHT = "WhiteSpaceRight";
	/**
	 * @generated
	 */
	public static final String WHITESPACEBOTTOM = "WhiteSpaceBottom";
	/**
	 * @generated
	 */
	public static final String USEGUTTER = "UseGutter";
	/**
	 * @generated
	 */
	public static final String GUTTER = "Gutter";
	/**
	 * @generated
	 */
	public static final String GUTTERHORIZONTAL = "GutterHorizontal";
	/**
	 * @generated
	 */
	public static final String USEBLEED = "UseBleed";
	/**
	 * @generated
	 */
	public static final String BLEED = "Bleed";
	/**
	 * @generated
	 */
	public static final String BLEEDTOP = "BleedTop";
	/**
	 * @generated
	 */
	public static final String BLEEDRIGHT = "BleedRight";
	/**
	 * @generated
	 */
	public static final String BLEEDBOTTOM = "BleedBottom";
	/**
	 * @generated
	 */
	public static final String DEFAULTPRESSCUTTOFF = "DefaultPressCuttOff";
	/**
	 * @generated
	 */
	public static final String BACKTRIMPARENT = "BackTrimParent";
	/**
	 * @generated
	 */
	public static final String TRIMFOURSIDES = "TrimFourSides";
	/**
	 * @generated
	 */
	public static final String WORKANDTUMBLE = "WorkandTumble";
	/**
	 * @generated
	 */
	public static final String RUNTOFINISHGRAIN = "RunToFinishGrain";
	/**
	 * @generated
	 */
	public static final String PRINTPARENTTOFINISHSECTION = "PrintParentToFinishSection";
	/**
	 * @generated
	 */
	public static final String PRINTPARENTTORUNSECTION = "PrintParentToRunSection";
	/**
	 * @generated
	 */
	public static final String PRINTRUNTOFINISHSECTION = "PrintRunToFinishSection";
	/**
	 * @generated
	 */
	public static final String ATTACHTOJOBTICKET = "AttachToJobTicket";
	/**
	 * @generated
	 */
	public static final String JOBTICKETFORMAT = "JobTicketFormat";
	/**
	 * @generated
	 */
	public static final String CUSTOMJOBTICKET = "CustomJobTicket";
	/**
	 * @generated
	 */
	public static final String CHARGEDESCRIPTION = "ChargeDescription";
	/**
	 * @generated
	 */
	public static final String SHOWAMOUNTSONTICKET = "ShowAmountsOnTicket";
	/**
	 * @generated
	 */
	public static final String ADDBARCODES = "AddBarCodes";
	/**
	 * @generated
	 */
	public static final String SHOWREFNUMBER = "ShowRefNumber";
	/**
	 * @generated
	 */
	public static final String BARCODEFONT = "BarCodeFont";

	/**
	 * @generated
	 */
	public PreferencesEstimating() {
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
	private String folioLocation;
	
	/**
	 * @generated
 	 */
	public String getFolioLocation(){
    return folioLocation; 
  }

	
	/**
	 * @generated
	 */	
	public void setFolioLocation(String newVal) {
    this.folioLocation = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String gripLocation;
	
	/**
	 * @generated
 	 */
	public String getGripLocation(){
    return gripLocation; 
  }

	
	/**
	 * @generated
	 */	
	public void setGripLocation(String newVal) {
    this.gripLocation = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean closeAfterCopy;
	
	/**
	 * @generated
 	 */
	public Boolean getCloseAfterCopy(){
    return closeAfterCopy; 
  }

	
	/**
	 * @generated
	 */	
	public void setCloseAfterCopy(Boolean newVal) {
    this.closeAfterCopy = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean stockCostInEstimator;
	
	/**
	 * @generated
 	 */
	public Boolean getStockCostInEstimator(){
    return stockCostInEstimator; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockCostInEstimator(Boolean newVal) {
    this.stockCostInEstimator = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean canChangeAddress;
	
	/**
	 * @generated
 	 */
	public Boolean getCanChangeAddress(){
    return canChangeAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setCanChangeAddress(Boolean newVal) {
    this.canChangeAddress = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showPaperCalculator;
	
	/**
	 * @generated
 	 */
	public Boolean getShowPaperCalculator(){
    return showPaperCalculator; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowPaperCalculator(Boolean newVal) {
    this.showPaperCalculator = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useStockParentSize;
	
	/**
	 * @generated
 	 */
	public Boolean getUseStockParentSize(){
    return useStockParentSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseStockParentSize(Boolean newVal) {
    this.useStockParentSize = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean calculateReOrderDate;
	
	/**
	 * @generated
 	 */
	public Boolean getCalculateReOrderDate(){
    return calculateReOrderDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setCalculateReOrderDate(Boolean newVal) {
    this.calculateReOrderDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean validateSalesRep;
	
	/**
	 * @generated
 	 */
	public Boolean getValidateSalesRep(){
    return validateSalesRep; 
  }

	
	/**
	 * @generated
	 */	
	public void setValidateSalesRep(Boolean newVal) {
    this.validateSalesRep = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean leaveFoldedSizeEmpty;
	
	/**
	 * @generated
 	 */
	public Boolean getLeaveFoldedSizeEmpty(){
    return leaveFoldedSizeEmpty; 
  }

	
	/**
	 * @generated
	 */	
	public void setLeaveFoldedSizeEmpty(Boolean newVal) {
    this.leaveFoldedSizeEmpty = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean doNotCostDuringPost;
	
	/**
	 * @generated
 	 */
	public Boolean getDoNotCostDuringPost(){
    return doNotCostDuringPost; 
  }

	
	/**
	 * @generated
	 */	
	public void setDoNotCostDuringPost(Boolean newVal) {
    this.doNotCostDuringPost = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean autoShowCharges;
	
	/**
	 * @generated
 	 */
	public Boolean getAutoShowCharges(){
    return autoShowCharges; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoShowCharges(Boolean newVal) {
    this.autoShowCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean neverUsePresetPressOnStockChanges;
	
	/**
	 * @generated
 	 */
	public Boolean getNeverUsePresetPressOnStockChanges(){
    return neverUsePresetPressOnStockChanges; 
  }

	
	/**
	 * @generated
	 */	
	public void setNeverUsePresetPressOnStockChanges(Boolean newVal) {
    this.neverUsePresetPressOnStockChanges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean addFixedWasteForEachPass;
	
	/**
	 * @generated
 	 */
	public Boolean getAddFixedWasteForEachPass(){
    return addFixedWasteForEachPass; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddFixedWasteForEachPass(Boolean newVal) {
    this.addFixedWasteForEachPass = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean addFixedWasteForEachColor;
	
	/**
	 * @generated
 	 */
	public Boolean getAddFixedWasteForEachColor(){
    return addFixedWasteForEachColor; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddFixedWasteForEachColor(Boolean newVal) {
    this.addFixedWasteForEachColor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean calculateInkbyImpressions;
	
	/**
	 * @generated
 	 */
	public Boolean getCalculateInkbyImpressions(){
    return calculateInkbyImpressions; 
  }

	
	/**
	 * @generated
	 */	
	public void setCalculateInkbyImpressions(Boolean newVal) {
    this.calculateInkbyImpressions = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useHistoryTitleforNewTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getUseHistoryTitleforNewTitle(){
    return useHistoryTitleforNewTitle; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseHistoryTitleforNewTitle(Boolean newVal) {
    this.useHistoryTitleforNewTitle = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer normalDueDateDays;
	
	/**
	 * @generated
 	 */
	public Integer getNormalDueDateDays(){
    return normalDueDateDays; 
  }

	
	/**
	 * @generated
	 */	
	public void setNormalDueDateDays(Integer newVal) {
    this.normalDueDateDays = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean closeInvoiceAfterPrintingTicket;
	
	/**
	 * @generated
 	 */
	public Boolean getCloseInvoiceAfterPrintingTicket(){
    return closeInvoiceAfterPrintingTicket; 
  }

	
	/**
	 * @generated
	 */	
	public void setCloseInvoiceAfterPrintingTicket(Boolean newVal) {
    this.closeInvoiceAfterPrintingTicket = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean closeInvoicesAndEstimateAfterPrinting;
	
	/**
	 * @generated
 	 */
	public Boolean getCloseInvoicesAndEstimateAfterPrinting(){
    return closeInvoicesAndEstimateAfterPrinting; 
  }

	
	/**
	 * @generated
	 */	
	public void setCloseInvoicesAndEstimateAfterPrinting(Boolean newVal) {
    this.closeInvoicesAndEstimateAfterPrinting = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer defaultInvoice;
	
	/**
	 * @generated
 	 */
	public Integer getDefaultInvoice(){
    return defaultInvoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultInvoice(Integer newVal) {
    this.defaultInvoice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer defaultEstimate;
	
	/**
	 * @generated
 	 */
	public Integer getDefaultEstimate(){
    return defaultEstimate; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultEstimate(Integer newVal) {
    this.defaultEstimate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer numberOfDaysBeforeDue;
	
	/**
	 * @generated
 	 */
	public Integer getNumberOfDaysBeforeDue(){
    return numberOfDaysBeforeDue; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumberOfDaysBeforeDue(Integer newVal) {
    this.numberOfDaysBeforeDue = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer dueFrom;
	
	/**
	 * @generated
 	 */
	public Integer getDueFrom(){
    return dueFrom; 
  }

	
	/**
	 * @generated
	 */	
	public void setDueFrom(Integer newVal) {
    this.dueFrom = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useGripEdgeGap;
	
	/**
	 * @generated
 	 */
	public Boolean getUseGripEdgeGap(){
    return useGripEdgeGap; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseGripEdgeGap(Boolean newVal) {
    this.useGripEdgeGap = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double gripEdgeGap;
	
	/**
	 * @generated
 	 */
	public Double getGripEdgeGap(){
    return gripEdgeGap; 
  }

	
	/**
	 * @generated
	 */	
	public void setGripEdgeGap(Double newVal) {
    this.gripEdgeGap = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useFolioEdge;
	
	/**
	 * @generated
 	 */
	public Boolean getUseFolioEdge(){
    return useFolioEdge; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseFolioEdge(Boolean newVal) {
    this.useFolioEdge = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double folioEdge;
	
	/**
	 * @generated
 	 */
	public Double getFolioEdge(){
    return folioEdge; 
  }

	
	/**
	 * @generated
	 */	
	public void setFolioEdge(Double newVal) {
    this.folioEdge = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useColorBar;
	
	/**
	 * @generated
 	 */
	public Boolean getUseColorBar(){
    return useColorBar; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseColorBar(Boolean newVal) {
    this.useColorBar = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double colorBar;
	
	/**
	 * @generated
 	 */
	public Double getColorBar(){
    return colorBar; 
  }

	
	/**
	 * @generated
	 */	
	public void setColorBar(Double newVal) {
    this.colorBar = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useWhiteSpace;
	
	/**
	 * @generated
 	 */
	public Boolean getUseWhiteSpace(){
    return useWhiteSpace; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseWhiteSpace(Boolean newVal) {
    this.useWhiteSpace = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double whiteSpace;
	
	/**
	 * @generated
 	 */
	public Double getWhiteSpace(){
    return whiteSpace; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhiteSpace(Double newVal) {
    this.whiteSpace = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double whiteSpaceTop;
	
	/**
	 * @generated
 	 */
	public Double getWhiteSpaceTop(){
    return whiteSpaceTop; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhiteSpaceTop(Double newVal) {
    this.whiteSpaceTop = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double whiteSpaceRight;
	
	/**
	 * @generated
 	 */
	public Double getWhiteSpaceRight(){
    return whiteSpaceRight; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhiteSpaceRight(Double newVal) {
    this.whiteSpaceRight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double whiteSpaceBottom;
	
	/**
	 * @generated
 	 */
	public Double getWhiteSpaceBottom(){
    return whiteSpaceBottom; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhiteSpaceBottom(Double newVal) {
    this.whiteSpaceBottom = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useGutter;
	
	/**
	 * @generated
 	 */
	public Boolean getUseGutter(){
    return useGutter; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseGutter(Boolean newVal) {
    this.useGutter = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double gutter;
	
	/**
	 * @generated
 	 */
	public Double getGutter(){
    return gutter; 
  }

	
	/**
	 * @generated
	 */	
	public void setGutter(Double newVal) {
    this.gutter = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double gutterHorizontal;
	
	/**
	 * @generated
 	 */
	public Double getGutterHorizontal(){
    return gutterHorizontal; 
  }

	
	/**
	 * @generated
	 */	
	public void setGutterHorizontal(Double newVal) {
    this.gutterHorizontal = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useBleed;
	
	/**
	 * @generated
 	 */
	public Boolean getUseBleed(){
    return useBleed; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseBleed(Boolean newVal) {
    this.useBleed = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bleed;
	
	/**
	 * @generated
 	 */
	public Double getBleed(){
    return bleed; 
  }

	
	/**
	 * @generated
	 */	
	public void setBleed(Double newVal) {
    this.bleed = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bleedTop;
	
	/**
	 * @generated
 	 */
	public Double getBleedTop(){
    return bleedTop; 
  }

	
	/**
	 * @generated
	 */	
	public void setBleedTop(Double newVal) {
    this.bleedTop = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bleedRight;
	
	/**
	 * @generated
 	 */
	public Double getBleedRight(){
    return bleedRight; 
  }

	
	/**
	 * @generated
	 */	
	public void setBleedRight(Double newVal) {
    this.bleedRight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bleedBottom;
	
	/**
	 * @generated
 	 */
	public Double getBleedBottom(){
    return bleedBottom; 
  }

	
	/**
	 * @generated
	 */	
	public void setBleedBottom(Double newVal) {
    this.bleedBottom = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	@Column(name="defaultPressCuttOff", precision=19, scale=4)
	private BigDecimal defaultPressCuttOff;
	
	/**
	 * @generated
 	 */
	public BigDecimal getDefaultPressCuttOff(){
    return defaultPressCuttOff; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultPressCuttOff(BigDecimal newVal) {
    this.defaultPressCuttOff = newVal;
    this.defaultPressCuttOff.setScale(4, RoundingMode.HALF_UP);
  }
	
	/**
	 * @generated
	 */	
	public void setDefaultPressCuttOff(double newVal) {
    this.defaultPressCuttOff = BigDecimal.valueOf(newVal);
    this.defaultPressCuttOff.setScale(4, RoundingMode.HALF_UP);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean backTrimParent;
	
	/**
	 * @generated
 	 */
	public Boolean getBackTrimParent(){
    return backTrimParent; 
  }

	
	/**
	 * @generated
	 */	
	public void setBackTrimParent(Boolean newVal) {
    this.backTrimParent = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean trimFourSides;
	
	/**
	 * @generated
 	 */
	public Boolean getTrimFourSides(){
    return trimFourSides; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrimFourSides(Boolean newVal) {
    this.trimFourSides = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workandTumble;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkandTumble(){
    return workandTumble; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkandTumble(Boolean newVal) {
    this.workandTumble = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String runToFinishGrain;
	
	/**
	 * @generated
 	 */
	public String getRunToFinishGrain(){
    return runToFinishGrain; 
  }

	
	/**
	 * @generated
	 */	
	public void setRunToFinishGrain(String newVal) {
    this.runToFinishGrain = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean printParentToFinishSection;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintParentToFinishSection(){
    return printParentToFinishSection; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrintParentToFinishSection(Boolean newVal) {
    this.printParentToFinishSection = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean printParentToRunSection;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintParentToRunSection(){
    return printParentToRunSection; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrintParentToRunSection(Boolean newVal) {
    this.printParentToRunSection = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean printRunToFinishSection;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintRunToFinishSection(){
    return printRunToFinishSection; 
  }

	
	/**
	 * @generated
	 */	
	public void setPrintRunToFinishSection(Boolean newVal) {
    this.printRunToFinishSection = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean attachToJobTicket;
	
	/**
	 * @generated
 	 */
	public Boolean getAttachToJobTicket(){
    return attachToJobTicket; 
  }

	
	/**
	 * @generated
	 */	
	public void setAttachToJobTicket(Boolean newVal) {
    this.attachToJobTicket = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String jobTicketFormat;
	
	/**
	 * @generated
 	 */
	public String getJobTicketFormat(){
    return jobTicketFormat; 
  }

	
	/**
	 * @generated
	 */	
	public void setJobTicketFormat(String newVal) {
    this.jobTicketFormat = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String customJobTicket;
	
	/**
	 * @generated
 	 */
	public String getCustomJobTicket(){
    return customJobTicket; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomJobTicket(String newVal) {
    this.customJobTicket = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String chargeDescription;
	
	/**
	 * @generated
 	 */
	public String getChargeDescription(){
    return chargeDescription; 
  }

	
	/**
	 * @generated
	 */	
	public void setChargeDescription(String newVal) {
    this.chargeDescription = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showAmountsOnTicket;
	
	/**
	 * @generated
 	 */
	public Boolean getShowAmountsOnTicket(){
    return showAmountsOnTicket; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowAmountsOnTicket(Boolean newVal) {
    this.showAmountsOnTicket = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean addBarCodes;
	
	/**
	 * @generated
 	 */
	public Boolean getAddBarCodes(){
    return addBarCodes; 
  }

	
	/**
	 * @generated
	 */	
	public void setAddBarCodes(Boolean newVal) {
    this.addBarCodes = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showRefNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getShowRefNumber(){
    return showRefNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowRefNumber(Boolean newVal) {
    this.showRefNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition barCodeFont;
	
	/**
	 * @generated
 	 */
	public FontDefinition getBarCodeFont(){
    return barCodeFont; 
  }

	
	/**
	 * @generated
	 */	
	public void setBarCodeFont(FontDefinition newVal) {
    this.barCodeFont = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (FOLIOLOCATION.equals(propertyName)) return getFolioLocation();
    if (GRIPLOCATION.equals(propertyName)) return getGripLocation();
    if (CLOSEAFTERCOPY.equals(propertyName)) return getCloseAfterCopy();
    if (STOCKCOSTINESTIMATOR.equals(propertyName)) return getStockCostInEstimator();
    if (CANCHANGEADDRESS.equals(propertyName)) return getCanChangeAddress();
    if (SHOWPAPERCALCULATOR.equals(propertyName)) return getShowPaperCalculator();
    if (USESTOCKPARENTSIZE.equals(propertyName)) return getUseStockParentSize();
    if (CALCULATEREORDERDATE.equals(propertyName)) return getCalculateReOrderDate();
    if (VALIDATESALESREP.equals(propertyName)) return getValidateSalesRep();
    if (LEAVEFOLDEDSIZEEMPTY.equals(propertyName)) return getLeaveFoldedSizeEmpty();
    if (DONOTCOSTDURINGPOST.equals(propertyName)) return getDoNotCostDuringPost();
    if (AUTOSHOWCHARGES.equals(propertyName)) return getAutoShowCharges();
    if (NEVERUSEPRESETPRESSONSTOCKCHANGES.equals(propertyName)) return getNeverUsePresetPressOnStockChanges();
    if (ADDFIXEDWASTEFOREACHPASS.equals(propertyName)) return getAddFixedWasteForEachPass();
    if (ADDFIXEDWASTEFOREACHCOLOR.equals(propertyName)) return getAddFixedWasteForEachColor();
    if (CALCULATEINKBYIMPRESSIONS.equals(propertyName)) return getCalculateInkbyImpressions();
    if (USEHISTORYTITLEFORNEWTITLE.equals(propertyName)) return getUseHistoryTitleforNewTitle();
    if (NORMALDUEDATEDAYS.equals(propertyName)) return getNormalDueDateDays();
    if (CLOSEINVOICEAFTERPRINTINGTICKET.equals(propertyName)) return getCloseInvoiceAfterPrintingTicket();
    if (CLOSEINVOICESANDESTIMATEAFTERPRINTING.equals(propertyName)) return getCloseInvoicesAndEstimateAfterPrinting();
    if (DEFAULTINVOICE.equals(propertyName)) return getDefaultInvoice();
    if (DEFAULTESTIMATE.equals(propertyName)) return getDefaultEstimate();
    if (NUMBEROFDAYSBEFOREDUE.equals(propertyName)) return getNumberOfDaysBeforeDue();
    if (DUEFROM.equals(propertyName)) return getDueFrom();
    if (USEGRIPEDGEGAP.equals(propertyName)) return getUseGripEdgeGap();
    if (GRIPEDGEGAP.equals(propertyName)) return getGripEdgeGap();
    if (USEFOLIOEDGE.equals(propertyName)) return getUseFolioEdge();
    if (FOLIOEDGE.equals(propertyName)) return getFolioEdge();
    if (USECOLORBAR.equals(propertyName)) return getUseColorBar();
    if (COLORBAR.equals(propertyName)) return getColorBar();
    if (USEWHITESPACE.equals(propertyName)) return getUseWhiteSpace();
    if (WHITESPACE.equals(propertyName)) return getWhiteSpace();
    if (WHITESPACETOP.equals(propertyName)) return getWhiteSpaceTop();
    if (WHITESPACERIGHT.equals(propertyName)) return getWhiteSpaceRight();
    if (WHITESPACEBOTTOM.equals(propertyName)) return getWhiteSpaceBottom();
    if (USEGUTTER.equals(propertyName)) return getUseGutter();
    if (GUTTER.equals(propertyName)) return getGutter();
    if (GUTTERHORIZONTAL.equals(propertyName)) return getGutterHorizontal();
    if (USEBLEED.equals(propertyName)) return getUseBleed();
    if (BLEED.equals(propertyName)) return getBleed();
    if (BLEEDTOP.equals(propertyName)) return getBleedTop();
    if (BLEEDRIGHT.equals(propertyName)) return getBleedRight();
    if (BLEEDBOTTOM.equals(propertyName)) return getBleedBottom();
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) return getDefaultPressCuttOff();
    if (BACKTRIMPARENT.equals(propertyName)) return getBackTrimParent();
    if (TRIMFOURSIDES.equals(propertyName)) return getTrimFourSides();
    if (WORKANDTUMBLE.equals(propertyName)) return getWorkandTumble();
    if (RUNTOFINISHGRAIN.equals(propertyName)) return getRunToFinishGrain();
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return getPrintParentToFinishSection();
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return getPrintParentToRunSection();
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return getPrintRunToFinishSection();
    if (ATTACHTOJOBTICKET.equals(propertyName)) return getAttachToJobTicket();
    if (JOBTICKETFORMAT.equals(propertyName)) return getJobTicketFormat();
    if (CUSTOMJOBTICKET.equals(propertyName)) return getCustomJobTicket();
    if (CHARGEDESCRIPTION.equals(propertyName)) return getChargeDescription();
    if (SHOWAMOUNTSONTICKET.equals(propertyName)) return getShowAmountsOnTicket();
    if (ADDBARCODES.equals(propertyName)) return getAddBarCodes();
    if (SHOWREFNUMBER.equals(propertyName)) return getShowRefNumber();
    if (BARCODEFONT.equals(propertyName)) return getBarCodeFont();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (FOLIOLOCATION.equals(propertyName)) setFolioLocation((String)newValue); else
    if (GRIPLOCATION.equals(propertyName)) setGripLocation((String)newValue); else
    if (CLOSEAFTERCOPY.equals(propertyName)) setCloseAfterCopy((Boolean)newValue); else
    if (STOCKCOSTINESTIMATOR.equals(propertyName)) setStockCostInEstimator((Boolean)newValue); else
    if (CANCHANGEADDRESS.equals(propertyName)) setCanChangeAddress((Boolean)newValue); else
    if (SHOWPAPERCALCULATOR.equals(propertyName)) setShowPaperCalculator((Boolean)newValue); else
    if (USESTOCKPARENTSIZE.equals(propertyName)) setUseStockParentSize((Boolean)newValue); else
    if (CALCULATEREORDERDATE.equals(propertyName)) setCalculateReOrderDate((Boolean)newValue); else
    if (VALIDATESALESREP.equals(propertyName)) setValidateSalesRep((Boolean)newValue); else
    if (LEAVEFOLDEDSIZEEMPTY.equals(propertyName)) setLeaveFoldedSizeEmpty((Boolean)newValue); else
    if (DONOTCOSTDURINGPOST.equals(propertyName)) setDoNotCostDuringPost((Boolean)newValue); else
    if (AUTOSHOWCHARGES.equals(propertyName)) setAutoShowCharges((Boolean)newValue); else
    if (NEVERUSEPRESETPRESSONSTOCKCHANGES.equals(propertyName)) setNeverUsePresetPressOnStockChanges((Boolean)newValue); else
    if (ADDFIXEDWASTEFOREACHPASS.equals(propertyName)) setAddFixedWasteForEachPass((Boolean)newValue); else
    if (ADDFIXEDWASTEFOREACHCOLOR.equals(propertyName)) setAddFixedWasteForEachColor((Boolean)newValue); else
    if (CALCULATEINKBYIMPRESSIONS.equals(propertyName)) setCalculateInkbyImpressions((Boolean)newValue); else
    if (USEHISTORYTITLEFORNEWTITLE.equals(propertyName)) setUseHistoryTitleforNewTitle((Boolean)newValue); else
    if (NORMALDUEDATEDAYS.equals(propertyName)) setNormalDueDateDays((Integer)newValue); else
    if (CLOSEINVOICEAFTERPRINTINGTICKET.equals(propertyName)) setCloseInvoiceAfterPrintingTicket((Boolean)newValue); else
    if (CLOSEINVOICESANDESTIMATEAFTERPRINTING.equals(propertyName)) setCloseInvoicesAndEstimateAfterPrinting((Boolean)newValue); else
    if (DEFAULTINVOICE.equals(propertyName)) setDefaultInvoice((Integer)newValue); else
    if (DEFAULTESTIMATE.equals(propertyName)) setDefaultEstimate((Integer)newValue); else
    if (NUMBEROFDAYSBEFOREDUE.equals(propertyName)) setNumberOfDaysBeforeDue((Integer)newValue); else
    if (DUEFROM.equals(propertyName)) setDueFrom((Integer)newValue); else
    if (USEGRIPEDGEGAP.equals(propertyName)) setUseGripEdgeGap((Boolean)newValue); else
    if (GRIPEDGEGAP.equals(propertyName)) setGripEdgeGap((Double)newValue); else
    if (USEFOLIOEDGE.equals(propertyName)) setUseFolioEdge((Boolean)newValue); else
    if (FOLIOEDGE.equals(propertyName)) setFolioEdge((Double)newValue); else
    if (USECOLORBAR.equals(propertyName)) setUseColorBar((Boolean)newValue); else
    if (COLORBAR.equals(propertyName)) setColorBar((Double)newValue); else
    if (USEWHITESPACE.equals(propertyName)) setUseWhiteSpace((Boolean)newValue); else
    if (WHITESPACE.equals(propertyName)) setWhiteSpace((Double)newValue); else
    if (WHITESPACETOP.equals(propertyName)) setWhiteSpaceTop((Double)newValue); else
    if (WHITESPACERIGHT.equals(propertyName)) setWhiteSpaceRight((Double)newValue); else
    if (WHITESPACEBOTTOM.equals(propertyName)) setWhiteSpaceBottom((Double)newValue); else
    if (USEGUTTER.equals(propertyName)) setUseGutter((Boolean)newValue); else
    if (GUTTER.equals(propertyName)) setGutter((Double)newValue); else
    if (GUTTERHORIZONTAL.equals(propertyName)) setGutterHorizontal((Double)newValue); else
    if (USEBLEED.equals(propertyName)) setUseBleed((Boolean)newValue); else
    if (BLEED.equals(propertyName)) setBleed((Double)newValue); else
    if (BLEEDTOP.equals(propertyName)) setBleedTop((Double)newValue); else
    if (BLEEDRIGHT.equals(propertyName)) setBleedRight((Double)newValue); else
    if (BLEEDBOTTOM.equals(propertyName)) setBleedBottom((Double)newValue); else
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) setDefaultPressCuttOff((BigDecimal)newValue); else
    if (BACKTRIMPARENT.equals(propertyName)) setBackTrimParent((Boolean)newValue); else
    if (TRIMFOURSIDES.equals(propertyName)) setTrimFourSides((Boolean)newValue); else
    if (WORKANDTUMBLE.equals(propertyName)) setWorkandTumble((Boolean)newValue); else
    if (RUNTOFINISHGRAIN.equals(propertyName)) setRunToFinishGrain((String)newValue); else
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) setPrintParentToFinishSection((Boolean)newValue); else
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) setPrintParentToRunSection((Boolean)newValue); else
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) setPrintRunToFinishSection((Boolean)newValue); else
    if (ATTACHTOJOBTICKET.equals(propertyName)) setAttachToJobTicket((Boolean)newValue); else
    if (JOBTICKETFORMAT.equals(propertyName)) setJobTicketFormat((String)newValue); else
    if (CUSTOMJOBTICKET.equals(propertyName)) setCustomJobTicket((String)newValue); else
    if (CHARGEDESCRIPTION.equals(propertyName)) setChargeDescription((String)newValue); else
    if (SHOWAMOUNTSONTICKET.equals(propertyName)) setShowAmountsOnTicket((Boolean)newValue); else
    if (ADDBARCODES.equals(propertyName)) setAddBarCodes((Boolean)newValue); else
    if (SHOWREFNUMBER.equals(propertyName)) setShowRefNumber((Boolean)newValue); else
    if (BARCODEFONT.equals(propertyName)) setBarCodeFont((FontDefinition)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (FOLIOLOCATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (GRIPLOCATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CLOSEAFTERCOPY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (STOCKCOSTINESTIMATOR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CANCHANGEADDRESS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWPAPERCALCULATOR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USESTOCKPARENTSIZE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CALCULATEREORDERDATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (VALIDATESALESREP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LEAVEFOLDEDSIZEEMPTY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DONOTCOSTDURINGPOST.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AUTOSHOWCHARGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NEVERUSEPRESETPRESSONSTOCKCHANGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADDFIXEDWASTEFOREACHPASS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADDFIXEDWASTEFOREACHCOLOR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CALCULATEINKBYIMPRESSIONS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEHISTORYTITLEFORNEWTITLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NORMALDUEDATEDAYS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CLOSEINVOICEAFTERPRINTINGTICKET.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CLOSEINVOICESANDESTIMATEAFTERPRINTING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DEFAULTINVOICE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DEFAULTESTIMATE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (NUMBEROFDAYSBEFOREDUE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DUEFROM.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (USEGRIPEDGEGAP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (GRIPEDGEGAP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USEFOLIOEDGE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FOLIOEDGE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USECOLORBAR.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COLORBAR.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USEWHITESPACE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WHITESPACE.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WHITESPACETOP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WHITESPACERIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WHITESPACEBOTTOM.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USEGUTTER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (GUTTER.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (GUTTERHORIZONTAL.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USEBLEED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (BLEED.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDTOP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDRIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDBOTTOM.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (BACKTRIMPARENT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TRIMFOURSIDES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKANDTUMBLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RUNTOFINISHGRAIN.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ATTACHTOJOBTICKET.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (JOBTICKETFORMAT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUSTOMJOBTICKET.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CHARGEDESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHOWAMOUNTSONTICKET.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ADDBARCODES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWREFNUMBER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (BARCODEFONT.equals(propertyName)) 
      return new Class<?>[] {FontDefinition.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (FOLIOLOCATION.equals(propertyName)) return PreferencesEstimating.class;
    if (GRIPLOCATION.equals(propertyName)) return PreferencesEstimating.class;
    if (CLOSEAFTERCOPY.equals(propertyName)) return PreferencesEstimating.class;
    if (STOCKCOSTINESTIMATOR.equals(propertyName)) return PreferencesEstimating.class;
    if (CANCHANGEADDRESS.equals(propertyName)) return PreferencesEstimating.class;
    if (SHOWPAPERCALCULATOR.equals(propertyName)) return PreferencesEstimating.class;
    if (USESTOCKPARENTSIZE.equals(propertyName)) return PreferencesEstimating.class;
    if (CALCULATEREORDERDATE.equals(propertyName)) return PreferencesEstimating.class;
    if (VALIDATESALESREP.equals(propertyName)) return PreferencesEstimating.class;
    if (LEAVEFOLDEDSIZEEMPTY.equals(propertyName)) return PreferencesEstimating.class;
    if (DONOTCOSTDURINGPOST.equals(propertyName)) return PreferencesEstimating.class;
    if (AUTOSHOWCHARGES.equals(propertyName)) return PreferencesEstimating.class;
    if (NEVERUSEPRESETPRESSONSTOCKCHANGES.equals(propertyName)) return PreferencesEstimating.class;
    if (ADDFIXEDWASTEFOREACHPASS.equals(propertyName)) return PreferencesEstimating.class;
    if (ADDFIXEDWASTEFOREACHCOLOR.equals(propertyName)) return PreferencesEstimating.class;
    if (CALCULATEINKBYIMPRESSIONS.equals(propertyName)) return PreferencesEstimating.class;
    if (USEHISTORYTITLEFORNEWTITLE.equals(propertyName)) return PreferencesEstimating.class;
    if (NORMALDUEDATEDAYS.equals(propertyName)) return PreferencesEstimating.class;
    if (CLOSEINVOICEAFTERPRINTINGTICKET.equals(propertyName)) return PreferencesEstimating.class;
    if (CLOSEINVOICESANDESTIMATEAFTERPRINTING.equals(propertyName)) return PreferencesEstimating.class;
    if (DEFAULTINVOICE.equals(propertyName)) return PreferencesEstimating.class;
    if (DEFAULTESTIMATE.equals(propertyName)) return PreferencesEstimating.class;
    if (NUMBEROFDAYSBEFOREDUE.equals(propertyName)) return PreferencesEstimating.class;
    if (DUEFROM.equals(propertyName)) return PreferencesEstimating.class;
    if (USEGRIPEDGEGAP.equals(propertyName)) return PreferencesEstimating.class;
    if (GRIPEDGEGAP.equals(propertyName)) return PreferencesEstimating.class;
    if (USEFOLIOEDGE.equals(propertyName)) return PreferencesEstimating.class;
    if (FOLIOEDGE.equals(propertyName)) return PreferencesEstimating.class;
    if (USECOLORBAR.equals(propertyName)) return PreferencesEstimating.class;
    if (COLORBAR.equals(propertyName)) return PreferencesEstimating.class;
    if (USEWHITESPACE.equals(propertyName)) return PreferencesEstimating.class;
    if (WHITESPACE.equals(propertyName)) return PreferencesEstimating.class;
    if (WHITESPACETOP.equals(propertyName)) return PreferencesEstimating.class;
    if (WHITESPACERIGHT.equals(propertyName)) return PreferencesEstimating.class;
    if (WHITESPACEBOTTOM.equals(propertyName)) return PreferencesEstimating.class;
    if (USEGUTTER.equals(propertyName)) return PreferencesEstimating.class;
    if (GUTTER.equals(propertyName)) return PreferencesEstimating.class;
    if (GUTTERHORIZONTAL.equals(propertyName)) return PreferencesEstimating.class;
    if (USEBLEED.equals(propertyName)) return PreferencesEstimating.class;
    if (BLEED.equals(propertyName)) return PreferencesEstimating.class;
    if (BLEEDTOP.equals(propertyName)) return PreferencesEstimating.class;
    if (BLEEDRIGHT.equals(propertyName)) return PreferencesEstimating.class;
    if (BLEEDBOTTOM.equals(propertyName)) return PreferencesEstimating.class;
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) return PreferencesEstimating.class;
    if (BACKTRIMPARENT.equals(propertyName)) return PreferencesEstimating.class;
    if (TRIMFOURSIDES.equals(propertyName)) return PreferencesEstimating.class;
    if (WORKANDTUMBLE.equals(propertyName)) return PreferencesEstimating.class;
    if (RUNTOFINISHGRAIN.equals(propertyName)) return PreferencesEstimating.class;
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return PreferencesEstimating.class;
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return PreferencesEstimating.class;
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return PreferencesEstimating.class;
    if (ATTACHTOJOBTICKET.equals(propertyName)) return PreferencesEstimating.class;
    if (JOBTICKETFORMAT.equals(propertyName)) return PreferencesEstimating.class;
    if (CUSTOMJOBTICKET.equals(propertyName)) return PreferencesEstimating.class;
    if (CHARGEDESCRIPTION.equals(propertyName)) return PreferencesEstimating.class;
    if (SHOWAMOUNTSONTICKET.equals(propertyName)) return PreferencesEstimating.class;
    if (ADDBARCODES.equals(propertyName)) return PreferencesEstimating.class;
    if (SHOWREFNUMBER.equals(propertyName)) return PreferencesEstimating.class;
    if (BARCODEFONT.equals(propertyName)) return PreferencesEstimating.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesEstimating objT = (PreferencesEstimating)obj;
    if (! SmartEquals(getFolioLocation(), objT.getFolioLocation()))
      return false;
    if (! SmartEquals(getGripLocation(), objT.getGripLocation()))
      return false;
    if (! SmartEquals(getCloseAfterCopy(), objT.getCloseAfterCopy()))
      return false;
    if (! SmartEquals(getStockCostInEstimator(), objT.getStockCostInEstimator()))
      return false;
    if (! SmartEquals(getCanChangeAddress(), objT.getCanChangeAddress()))
      return false;
    if (! SmartEquals(getShowPaperCalculator(), objT.getShowPaperCalculator()))
      return false;
    if (! SmartEquals(getUseStockParentSize(), objT.getUseStockParentSize()))
      return false;
    if (! SmartEquals(getCalculateReOrderDate(), objT.getCalculateReOrderDate()))
      return false;
    if (! SmartEquals(getValidateSalesRep(), objT.getValidateSalesRep()))
      return false;
    if (! SmartEquals(getLeaveFoldedSizeEmpty(), objT.getLeaveFoldedSizeEmpty()))
      return false;
    if (! SmartEquals(getDoNotCostDuringPost(), objT.getDoNotCostDuringPost()))
      return false;
    if (! SmartEquals(getAutoShowCharges(), objT.getAutoShowCharges()))
      return false;
    if (! SmartEquals(getNeverUsePresetPressOnStockChanges(), objT.getNeverUsePresetPressOnStockChanges()))
      return false;
    if (! SmartEquals(getAddFixedWasteForEachPass(), objT.getAddFixedWasteForEachPass()))
      return false;
    if (! SmartEquals(getAddFixedWasteForEachColor(), objT.getAddFixedWasteForEachColor()))
      return false;
    if (! SmartEquals(getCalculateInkbyImpressions(), objT.getCalculateInkbyImpressions()))
      return false;
    if (! SmartEquals(getUseHistoryTitleforNewTitle(), objT.getUseHistoryTitleforNewTitle()))
      return false;
    if (! SmartEquals(getNormalDueDateDays(), objT.getNormalDueDateDays()))
      return false;
    if (! SmartEquals(getCloseInvoiceAfterPrintingTicket(), objT.getCloseInvoiceAfterPrintingTicket()))
      return false;
    if (! SmartEquals(getCloseInvoicesAndEstimateAfterPrinting(), objT.getCloseInvoicesAndEstimateAfterPrinting()))
      return false;
    if (! SmartEquals(getDefaultInvoice(), objT.getDefaultInvoice()))
      return false;
    if (! SmartEquals(getDefaultEstimate(), objT.getDefaultEstimate()))
      return false;
    if (! SmartEquals(getNumberOfDaysBeforeDue(), objT.getNumberOfDaysBeforeDue()))
      return false;
    if (! SmartEquals(getDueFrom(), objT.getDueFrom()))
      return false;
    if (! SmartEquals(getUseGripEdgeGap(), objT.getUseGripEdgeGap()))
      return false;
    if (! SmartEquals(getGripEdgeGap(), objT.getGripEdgeGap()))
      return false;
    if (! SmartEquals(getUseFolioEdge(), objT.getUseFolioEdge()))
      return false;
    if (! SmartEquals(getFolioEdge(), objT.getFolioEdge()))
      return false;
    if (! SmartEquals(getUseColorBar(), objT.getUseColorBar()))
      return false;
    if (! SmartEquals(getColorBar(), objT.getColorBar()))
      return false;
    if (! SmartEquals(getUseWhiteSpace(), objT.getUseWhiteSpace()))
      return false;
    if (! SmartEquals(getWhiteSpace(), objT.getWhiteSpace()))
      return false;
    if (! SmartEquals(getWhiteSpaceTop(), objT.getWhiteSpaceTop()))
      return false;
    if (! SmartEquals(getWhiteSpaceRight(), objT.getWhiteSpaceRight()))
      return false;
    if (! SmartEquals(getWhiteSpaceBottom(), objT.getWhiteSpaceBottom()))
      return false;
    if (! SmartEquals(getUseGutter(), objT.getUseGutter()))
      return false;
    if (! SmartEquals(getGutter(), objT.getGutter()))
      return false;
    if (! SmartEquals(getGutterHorizontal(), objT.getGutterHorizontal()))
      return false;
    if (! SmartEquals(getUseBleed(), objT.getUseBleed()))
      return false;
    if (! SmartEquals(getBleed(), objT.getBleed()))
      return false;
    if (! SmartEquals(getBleedTop(), objT.getBleedTop()))
      return false;
    if (! SmartEquals(getBleedRight(), objT.getBleedRight()))
      return false;
    if (! SmartEquals(getBleedBottom(), objT.getBleedBottom()))
      return false;
    if (! SmartEquals(getDefaultPressCuttOff(), objT.getDefaultPressCuttOff()))
      return false;
    if (! SmartEquals(getBackTrimParent(), objT.getBackTrimParent()))
      return false;
    if (! SmartEquals(getTrimFourSides(), objT.getTrimFourSides()))
      return false;
    if (! SmartEquals(getWorkandTumble(), objT.getWorkandTumble()))
      return false;
    if (! SmartEquals(getRunToFinishGrain(), objT.getRunToFinishGrain()))
      return false;
    if (! SmartEquals(getPrintParentToFinishSection(), objT.getPrintParentToFinishSection()))
      return false;
    if (! SmartEquals(getPrintParentToRunSection(), objT.getPrintParentToRunSection()))
      return false;
    if (! SmartEquals(getPrintRunToFinishSection(), objT.getPrintRunToFinishSection()))
      return false;
    if (! SmartEquals(getAttachToJobTicket(), objT.getAttachToJobTicket()))
      return false;
    if (! SmartEquals(getJobTicketFormat(), objT.getJobTicketFormat()))
      return false;
    if (! SmartEquals(getCustomJobTicket(), objT.getCustomJobTicket()))
      return false;
    if (! SmartEquals(getChargeDescription(), objT.getChargeDescription()))
      return false;
    if (! SmartEquals(getShowAmountsOnTicket(), objT.getShowAmountsOnTicket()))
      return false;
    if (! SmartEquals(getAddBarCodes(), objT.getAddBarCodes()))
      return false;
    if (! SmartEquals(getShowRefNumber(), objT.getShowRefNumber()))
      return false;
    if (! SmartEquals(getBarCodeFont(), objT.getBarCodeFont()))
      return false;
    return true;
  }			
}
