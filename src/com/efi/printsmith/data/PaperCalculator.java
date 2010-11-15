
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
  @NamedQuery(name = "PaperCalculator.findall", query = "from PaperCalculator"),
  @NamedQuery(name = "PaperCalculator.byId", query = "select a from PaperCalculator a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "papercalculator")
@SQLDelete(sql="update papercalculator set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PaperCalculator extends ModelBase {
	/**
	 * @generated
	 */
	public static final String GRIPEDGEGAP = "GripEdgeGap";
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String ACROSS = "Across";
	/**
	 * @generated
	 */
	public static final String WHICHSTARTSIZE = "WhichStartSize";
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
	public static final String WHITESPACELEFT = "WhiteSpaceLeft";
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
	public static final String BLEEDLEFT = "BleedLeft";
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
	public static final String BACKTRIMPARENT = "BackTrimParent";
	/**
   * @generated
   */
  public static final String WORKANDTURN = "WorkandTurn";
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
	public static final String ATTACHTOJOBTICKET = "AttachToJobTicket";
	/**
	 * @generated
	 */
	public static final String PRINTRUNTOFINISHSECTION = "PrintRunToFinishSection";
	/**
	 * @generated
	 */
	public static final String USEGRIPEDGEGAP = "UseGripEdgeGap";
	/**
	 * @generated
	 */
	public static final String GRIPLOCATION = "GripLocation";
	/**
	 * @generated
	 */
	public static final String CUTSTOFINISH = "CutstoFinish";
	/**
	 * @generated
	 */
	public static final String SHEETSOUT = "SheetsOut";
	/**
	 * @generated
	 */
	public static final String FOLIOLOCATION = "FolioLocation";
	/**
	 * @generated
	 */
	public static final String CUTSTORUN = "CutstoRun";
	/**
	 * @generated
	 */
	public static final String DISABLEFSC = "DisableFSC";
	/**
	 * @generated
	 */
	public static final String DOWN = "Down";
	/**
	 * @generated
	 */
	public static final String DACROSS = "DAcross";
	/**
	 * @generated
	 */
	public static final String DDOWN = "DDown";
	/**
	 * @generated
	 */
	public static final String DUTCHBOTTOM = "DutchBottom";
	/**
	 * @generated
	 */
	public static final String PARENTSQRAREA = "ParentSqrArea";
	/**
	 * @generated
	 */
	public static final String USEDSQRAREA = "UsedSqrArea";
	/**
	 * @generated
	 */
	public static final String RMARGIN = "RMargin";
	/**
	 * @generated
	 */
	public static final String BMARGIN = "BMargin";
	/**
	 * @generated
	 */
	public static final String TMARGIN = "TMargin";
	/**
	 * @generated
	 */
	public static final String LMARGIN = "LMargin";
	/**
	 * @generated
	 */
	public static final String BACKTRIMRUN = "BackTrimRun";
	/**
	 * @generated
	 */
	public static final String SWAP = "Swap";
	/**
	 * @generated
	 */
	public static final String RUNOUT = "Runout";

	/**
   * @generated
   */
  public static final String RUNANDTUMBLE = "RunAndTumble";

	/**
   * @generated
   */
  public static final String FINISHOUT = "Finishout";

	/**
	 * @generated
	 */
	public PaperCalculator() {
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
	private Integer across;
	
	/**
	 * @generated
 	 */
	public Integer getAcross(){
    return across; 
  }

	
	/**
	 * @generated
	 */	
	public void setAcross(Integer newVal) {
    this.across = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer whichStartSize;
	
	/**
	 * @generated
 	 */
	public Integer getWhichStartSize(){
    return whichStartSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhichStartSize(Integer newVal) {
    this.whichStartSize = newVal;
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
	private Double whiteSpaceLeft;
	
	/**
	 * @generated
 	 */
	public Double getWhiteSpaceLeft(){
    return whiteSpaceLeft; 
  }

	
	/**
	 * @generated
	 */	
	public void setWhiteSpaceLeft(Double newVal) {
    this.whiteSpaceLeft = newVal;
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
	private Double bleedLeft;
	
	/**
	 * @generated
 	 */
	public Double getBleedLeft(){
    return bleedLeft; 
  }

	
	/**
	 * @generated
	 */	
	public void setBleedLeft(Double newVal) {
    this.bleedLeft = newVal;
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
  private Boolean workandTurn;

	/**
   * @generated
 	 */
  public Boolean getWorkandTurn(){
    return workandTurn; 
  }


	/**
   * @generated
   */	
  public void setWorkandTurn(Boolean newVal) {
    this.workandTurn = newVal;
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
	private Integer cutstoFinish;
	
	/**
	 * @generated
 	 */
	public Integer getCutstoFinish(){
    return cutstoFinish; 
  }

	
	/**
	 * @generated
	 */	
	public void setCutstoFinish(Integer newVal) {
    this.cutstoFinish = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer sheetsOut;
	
	/**
	 * @generated
 	 */
	public Integer getSheetsOut(){
    return sheetsOut; 
  }

	
	/**
	 * @generated
	 */	
	public void setSheetsOut(Integer newVal) {
    this.sheetsOut = newVal;
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
	private Integer cutstoRun;
	
	/**
	 * @generated
 	 */
	public Integer getCutstoRun(){
    return cutstoRun; 
  }

	
	/**
	 * @generated
	 */	
	public void setCutstoRun(Integer newVal) {
    this.cutstoRun = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean disableFSC;
	
	/**
	 * @generated
 	 */
	public Boolean getDisableFSC(){
    return disableFSC; 
  }

	
	/**
	 * @generated
	 */	
	public void setDisableFSC(Boolean newVal) {
    this.disableFSC = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer down;
	
	/**
	 * @generated
 	 */
	public Integer getDown(){
    return down; 
  }

	
	/**
	 * @generated
	 */	
	public void setDown(Integer newVal) {
    this.down = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer dAcross;
	
	/**
	 * @generated
 	 */
	public Integer getdAcross(){
    return dAcross; 
  }

	
	/**
	 * @generated
	 */	
	public void setdAcross(Integer newVal) {
    this.dAcross = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer dDown;
	
	/**
	 * @generated
 	 */
	public Integer getdDown(){
    return dDown; 
  }

	
	/**
	 * @generated
	 */	
	public void setdDown(Integer newVal) {
    this.dDown = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer dutchBottom;
	
	/**
	 * @generated
 	 */
	public Integer getDutchBottom(){
    return dutchBottom; 
  }

	
	/**
	 * @generated
	 */	
	public void setDutchBottom(Integer newVal) {
    this.dutchBottom = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double parentSqrArea;
	
	/**
	 * @generated
 	 */
	public Double getParentSqrArea(){
    return parentSqrArea; 
  }

	
	/**
	 * @generated
	 */	
	public void setParentSqrArea(Double newVal) {
    this.parentSqrArea = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double usedSqrArea;
	
	/**
	 * @generated
 	 */
	public Double getUsedSqrArea(){
    return usedSqrArea; 
  }

	
	/**
	 * @generated
	 */	
	public void setUsedSqrArea(Double newVal) {
    this.usedSqrArea = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double rMargin;
	
	/**
	 * @generated
 	 */
	public Double getrMargin(){
    return rMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void setrMargin(Double newVal) {
    this.rMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double bMargin;
	
	/**
	 * @generated
 	 */
	public Double getbMargin(){
    return bMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void setbMargin(Double newVal) {
    this.bMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double tMargin;
	
	/**
	 * @generated
 	 */
	public Double gettMargin(){
    return tMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void settMargin(Double newVal) {
    this.tMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double lMargin;
	
	/**
	 * @generated
 	 */
	public Double getlMargin(){
    return lMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void setlMargin(Double newVal) {
    this.lMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean backTrimRun;
	
	/**
	 * @generated
 	 */
	public Boolean getBackTrimRun(){
    return backTrimRun; 
  }

	
	/**
	 * @generated
	 */	
	public void setBackTrimRun(Boolean newVal) {
    this.backTrimRun = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean swap;
	
	/**
	 * @generated
 	 */
	public Boolean getSwap(){
    return swap; 
  }

	
	/**
	 * @generated
	 */	
	public void setSwap(Boolean newVal) {
    this.swap = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer runout;
	
	/**
	 * @generated
 	 */
	public Integer getRunout(){
    return runout; 
  }

	
	/**
	 * @generated
	 */	
	public void setRunout(Integer newVal) {
    this.runout = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Boolean runAndTumble;

	/**
   * @generated
 	 */
  public Boolean getRunAndTumble(){
    return runAndTumble; 
  }


	/**
   * @generated
   */	
  public void setRunAndTumble(Boolean newVal) {
    this.runAndTumble = newVal;
  }


	/**
   * @generated
   */	
 	@Basic
  private Integer finishout;

	/**
   * @generated
 	 */
  public Integer getFinishout(){
    return finishout; 
  }


	/**
   * @generated
   */	
  public void setFinishout(Integer newVal) {
    this.finishout = newVal;
  }


	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (GRIPEDGEGAP.equals(propertyName)) return getGripEdgeGap();
    if (NAME.equals(propertyName)) return getName();
    if (ACROSS.equals(propertyName)) return getAcross();
    if (WHICHSTARTSIZE.equals(propertyName)) return getWhichStartSize();
    if (USEFOLIOEDGE.equals(propertyName)) return getUseFolioEdge();
    if (FOLIOEDGE.equals(propertyName)) return getFolioEdge();
    if (USECOLORBAR.equals(propertyName)) return getUseColorBar();
    if (COLORBAR.equals(propertyName)) return getColorBar();
    if (USEWHITESPACE.equals(propertyName)) return getUseWhiteSpace();
    if (WHITESPACELEFT.equals(propertyName)) return getWhiteSpaceLeft();
    if (WHITESPACETOP.equals(propertyName)) return getWhiteSpaceTop();
    if (WHITESPACERIGHT.equals(propertyName)) return getWhiteSpaceRight();
    if (WHITESPACEBOTTOM.equals(propertyName)) return getWhiteSpaceBottom();
    if (USEGUTTER.equals(propertyName)) return getUseGutter();
    if (GUTTER.equals(propertyName)) return getGutter();
    if (GUTTERHORIZONTAL.equals(propertyName)) return getGutterHorizontal();
    if (USEBLEED.equals(propertyName)) return getUseBleed();
    if (BLEEDLEFT.equals(propertyName)) return getBleedLeft();
    if (BLEEDTOP.equals(propertyName)) return getBleedTop();
    if (BLEEDRIGHT.equals(propertyName)) return getBleedRight();
    if (BLEEDBOTTOM.equals(propertyName)) return getBleedBottom();
    if (BACKTRIMPARENT.equals(propertyName)) return getBackTrimParent();
    if (WORKANDTURN.equals(propertyName)) return getWorkandTurn();
    if (RUNTOFINISHGRAIN.equals(propertyName)) return getRunToFinishGrain();
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return getPrintParentToFinishSection();
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return getPrintParentToRunSection();
    if (ATTACHTOJOBTICKET.equals(propertyName)) return getAttachToJobTicket();
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return getPrintRunToFinishSection();
    if (USEGRIPEDGEGAP.equals(propertyName)) return getUseGripEdgeGap();
    if (GRIPLOCATION.equals(propertyName)) return getGripLocation();
    if (CUTSTOFINISH.equals(propertyName)) return getCutstoFinish();
    if (SHEETSOUT.equals(propertyName)) return getSheetsOut();
    if (FOLIOLOCATION.equals(propertyName)) return getFolioLocation();
    if (CUTSTORUN.equals(propertyName)) return getCutstoRun();
    if (DISABLEFSC.equals(propertyName)) return getDisableFSC();
    if (DOWN.equals(propertyName)) return getDown();
    if (DACROSS.equals(propertyName)) return getdAcross();
    if (DDOWN.equals(propertyName)) return getdDown();
    if (DUTCHBOTTOM.equals(propertyName)) return getDutchBottom();
    if (PARENTSQRAREA.equals(propertyName)) return getParentSqrArea();
    if (USEDSQRAREA.equals(propertyName)) return getUsedSqrArea();
    if (RMARGIN.equals(propertyName)) return getrMargin();
    if (BMARGIN.equals(propertyName)) return getbMargin();
    if (TMARGIN.equals(propertyName)) return gettMargin();
    if (LMARGIN.equals(propertyName)) return getlMargin();
    if (BACKTRIMRUN.equals(propertyName)) return getBackTrimRun();
    if (SWAP.equals(propertyName)) return getSwap();
    if (RUNOUT.equals(propertyName)) return getRunout();
    if (RUNANDTUMBLE.equals(propertyName)) return getRunAndTumble();
    if (FINISHOUT.equals(propertyName)) return getFinishout();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (GRIPEDGEGAP.equals(propertyName)) setGripEdgeGap((Double)newValue); else
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (ACROSS.equals(propertyName)) setAcross((Integer)newValue); else
    if (WHICHSTARTSIZE.equals(propertyName)) setWhichStartSize((Integer)newValue); else
    if (USEFOLIOEDGE.equals(propertyName)) setUseFolioEdge((Boolean)newValue); else
    if (FOLIOEDGE.equals(propertyName)) setFolioEdge((Double)newValue); else
    if (USECOLORBAR.equals(propertyName)) setUseColorBar((Boolean)newValue); else
    if (COLORBAR.equals(propertyName)) setColorBar((Double)newValue); else
    if (USEWHITESPACE.equals(propertyName)) setUseWhiteSpace((Boolean)newValue); else
    if (WHITESPACELEFT.equals(propertyName)) setWhiteSpaceLeft((Double)newValue); else
    if (WHITESPACETOP.equals(propertyName)) setWhiteSpaceTop((Double)newValue); else
    if (WHITESPACERIGHT.equals(propertyName)) setWhiteSpaceRight((Double)newValue); else
    if (WHITESPACEBOTTOM.equals(propertyName)) setWhiteSpaceBottom((Double)newValue); else
    if (USEGUTTER.equals(propertyName)) setUseGutter((Boolean)newValue); else
    if (GUTTER.equals(propertyName)) setGutter((Double)newValue); else
    if (GUTTERHORIZONTAL.equals(propertyName)) setGutterHorizontal((Double)newValue); else
    if (USEBLEED.equals(propertyName)) setUseBleed((Boolean)newValue); else
    if (BLEEDLEFT.equals(propertyName)) setBleedLeft((Double)newValue); else
    if (BLEEDTOP.equals(propertyName)) setBleedTop((Double)newValue); else
    if (BLEEDRIGHT.equals(propertyName)) setBleedRight((Double)newValue); else
    if (BLEEDBOTTOM.equals(propertyName)) setBleedBottom((Double)newValue); else
    if (BACKTRIMPARENT.equals(propertyName)) setBackTrimParent((Boolean)newValue); else
    if (WORKANDTURN.equals(propertyName)) setWorkandTurn((Boolean)newValue); else
    if (RUNTOFINISHGRAIN.equals(propertyName)) setRunToFinishGrain((String)newValue); else
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) setPrintParentToFinishSection((Boolean)newValue); else
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) setPrintParentToRunSection((Boolean)newValue); else
    if (ATTACHTOJOBTICKET.equals(propertyName)) setAttachToJobTicket((Boolean)newValue); else
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) setPrintRunToFinishSection((Boolean)newValue); else
    if (USEGRIPEDGEGAP.equals(propertyName)) setUseGripEdgeGap((Boolean)newValue); else
    if (GRIPLOCATION.equals(propertyName)) setGripLocation((String)newValue); else
    if (CUTSTOFINISH.equals(propertyName)) setCutstoFinish((Integer)newValue); else
    if (SHEETSOUT.equals(propertyName)) setSheetsOut((Integer)newValue); else
    if (FOLIOLOCATION.equals(propertyName)) setFolioLocation((String)newValue); else
    if (CUTSTORUN.equals(propertyName)) setCutstoRun((Integer)newValue); else
    if (DISABLEFSC.equals(propertyName)) setDisableFSC((Boolean)newValue); else
    if (DOWN.equals(propertyName)) setDown((Integer)newValue); else
    if (DACROSS.equals(propertyName)) setdAcross((Integer)newValue); else
    if (DDOWN.equals(propertyName)) setdDown((Integer)newValue); else
    if (DUTCHBOTTOM.equals(propertyName)) setDutchBottom((Integer)newValue); else
    if (PARENTSQRAREA.equals(propertyName)) setParentSqrArea((Double)newValue); else
    if (USEDSQRAREA.equals(propertyName)) setUsedSqrArea((Double)newValue); else
    if (RMARGIN.equals(propertyName)) setrMargin((Double)newValue); else
    if (BMARGIN.equals(propertyName)) setbMargin((Double)newValue); else
    if (TMARGIN.equals(propertyName)) settMargin((Double)newValue); else
    if (LMARGIN.equals(propertyName)) setlMargin((Double)newValue); else
    if (BACKTRIMRUN.equals(propertyName)) setBackTrimRun((Boolean)newValue); else
    if (SWAP.equals(propertyName)) setSwap((Boolean)newValue); else
    if (RUNOUT.equals(propertyName)) setRunout((Integer)newValue); else
    if (RUNANDTUMBLE.equals(propertyName)) setRunAndTumble((Boolean)newValue); else
    if (FINISHOUT.equals(propertyName)) setFinishout((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (GRIPEDGEGAP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (NAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ACROSS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (WHICHSTARTSIZE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
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
    if (WHITESPACELEFT.equals(propertyName)) 
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
    if (BLEEDLEFT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDTOP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDRIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BLEEDBOTTOM.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BACKTRIMPARENT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKANDTURN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RUNTOFINISHGRAIN.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ATTACHTOJOBTICKET.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEGRIPEDGEGAP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (GRIPLOCATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUTSTOFINISH.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (SHEETSOUT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (FOLIOLOCATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CUTSTORUN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DISABLEFSC.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DOWN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DACROSS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DDOWN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DUTCHBOTTOM.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (PARENTSQRAREA.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (USEDSQRAREA.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (RMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (BACKTRIMRUN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SWAP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RUNOUT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (RUNANDTUMBLE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (FINISHOUT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (GRIPEDGEGAP.equals(propertyName)) return PaperCalculator.class;
    if (NAME.equals(propertyName)) return PaperCalculator.class;
    if (ACROSS.equals(propertyName)) return PaperCalculator.class;
    if (WHICHSTARTSIZE.equals(propertyName)) return PaperCalculator.class;
    if (USEFOLIOEDGE.equals(propertyName)) return PaperCalculator.class;
    if (FOLIOEDGE.equals(propertyName)) return PaperCalculator.class;
    if (USECOLORBAR.equals(propertyName)) return PaperCalculator.class;
    if (COLORBAR.equals(propertyName)) return PaperCalculator.class;
    if (USEWHITESPACE.equals(propertyName)) return PaperCalculator.class;
    if (WHITESPACELEFT.equals(propertyName)) return PaperCalculator.class;
    if (WHITESPACETOP.equals(propertyName)) return PaperCalculator.class;
    if (WHITESPACERIGHT.equals(propertyName)) return PaperCalculator.class;
    if (WHITESPACEBOTTOM.equals(propertyName)) return PaperCalculator.class;
    if (USEGUTTER.equals(propertyName)) return PaperCalculator.class;
    if (GUTTER.equals(propertyName)) return PaperCalculator.class;
    if (GUTTERHORIZONTAL.equals(propertyName)) return PaperCalculator.class;
    if (USEBLEED.equals(propertyName)) return PaperCalculator.class;
    if (BLEEDLEFT.equals(propertyName)) return PaperCalculator.class;
    if (BLEEDTOP.equals(propertyName)) return PaperCalculator.class;
    if (BLEEDRIGHT.equals(propertyName)) return PaperCalculator.class;
    if (BLEEDBOTTOM.equals(propertyName)) return PaperCalculator.class;
    if (BACKTRIMPARENT.equals(propertyName)) return PaperCalculator.class;
    if (WORKANDTURN.equals(propertyName)) return PaperCalculator.class;
    if (RUNTOFINISHGRAIN.equals(propertyName)) return PaperCalculator.class;
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return PaperCalculator.class;
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return PaperCalculator.class;
    if (ATTACHTOJOBTICKET.equals(propertyName)) return PaperCalculator.class;
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return PaperCalculator.class;
    if (USEGRIPEDGEGAP.equals(propertyName)) return PaperCalculator.class;
    if (GRIPLOCATION.equals(propertyName)) return PaperCalculator.class;
    if (CUTSTOFINISH.equals(propertyName)) return PaperCalculator.class;
    if (SHEETSOUT.equals(propertyName)) return PaperCalculator.class;
    if (FOLIOLOCATION.equals(propertyName)) return PaperCalculator.class;
    if (CUTSTORUN.equals(propertyName)) return PaperCalculator.class;
    if (DISABLEFSC.equals(propertyName)) return PaperCalculator.class;
    if (DOWN.equals(propertyName)) return PaperCalculator.class;
    if (DACROSS.equals(propertyName)) return PaperCalculator.class;
    if (DDOWN.equals(propertyName)) return PaperCalculator.class;
    if (DUTCHBOTTOM.equals(propertyName)) return PaperCalculator.class;
    if (PARENTSQRAREA.equals(propertyName)) return PaperCalculator.class;
    if (USEDSQRAREA.equals(propertyName)) return PaperCalculator.class;
    if (RMARGIN.equals(propertyName)) return PaperCalculator.class;
    if (BMARGIN.equals(propertyName)) return PaperCalculator.class;
    if (TMARGIN.equals(propertyName)) return PaperCalculator.class;
    if (LMARGIN.equals(propertyName)) return PaperCalculator.class;
    if (BACKTRIMRUN.equals(propertyName)) return PaperCalculator.class;
    if (SWAP.equals(propertyName)) return PaperCalculator.class;
    if (RUNOUT.equals(propertyName)) return PaperCalculator.class;
    if (RUNANDTUMBLE.equals(propertyName)) return PaperCalculator.class;
    if (FINISHOUT.equals(propertyName)) return PaperCalculator.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PaperCalculator objT = (PaperCalculator)obj;
    if (! SmartEquals(getGripEdgeGap(), objT.getGripEdgeGap()))
      return false;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getAcross(), objT.getAcross()))
      return false;
    if (! SmartEquals(getWhichStartSize(), objT.getWhichStartSize()))
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
    if (! SmartEquals(getWhiteSpaceLeft(), objT.getWhiteSpaceLeft()))
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
    if (! SmartEquals(getBleedLeft(), objT.getBleedLeft()))
      return false;
    if (! SmartEquals(getBleedTop(), objT.getBleedTop()))
      return false;
    if (! SmartEquals(getBleedRight(), objT.getBleedRight()))
      return false;
    if (! SmartEquals(getBleedBottom(), objT.getBleedBottom()))
      return false;
    if (! SmartEquals(getBackTrimParent(), objT.getBackTrimParent()))
      return false;
    if (! SmartEquals(getWorkandTurn(), objT.getWorkandTurn()))
      return false;
    if (! SmartEquals(getRunToFinishGrain(), objT.getRunToFinishGrain()))
      return false;
    if (! SmartEquals(getPrintParentToFinishSection(), objT.getPrintParentToFinishSection()))
      return false;
    if (! SmartEquals(getPrintParentToRunSection(), objT.getPrintParentToRunSection()))
      return false;
    if (! SmartEquals(getAttachToJobTicket(), objT.getAttachToJobTicket()))
      return false;
    if (! SmartEquals(getPrintRunToFinishSection(), objT.getPrintRunToFinishSection()))
      return false;
    if (! SmartEquals(getUseGripEdgeGap(), objT.getUseGripEdgeGap()))
      return false;
    if (! SmartEquals(getGripLocation(), objT.getGripLocation()))
      return false;
    if (! SmartEquals(getCutstoFinish(), objT.getCutstoFinish()))
      return false;
    if (! SmartEquals(getSheetsOut(), objT.getSheetsOut()))
      return false;
    if (! SmartEquals(getFolioLocation(), objT.getFolioLocation()))
      return false;
    if (! SmartEquals(getCutstoRun(), objT.getCutstoRun()))
      return false;
    if (! SmartEquals(getDisableFSC(), objT.getDisableFSC()))
      return false;
    if (! SmartEquals(getDown(), objT.getDown()))
      return false;
    if (! SmartEquals(getdAcross(), objT.getdAcross()))
      return false;
    if (! SmartEquals(getdDown(), objT.getdDown()))
      return false;
    if (! SmartEquals(getDutchBottom(), objT.getDutchBottom()))
      return false;
    if (! SmartEquals(getParentSqrArea(), objT.getParentSqrArea()))
      return false;
    if (! SmartEquals(getUsedSqrArea(), objT.getUsedSqrArea()))
      return false;
    if (! SmartEquals(getrMargin(), objT.getrMargin()))
      return false;
    if (! SmartEquals(getbMargin(), objT.getbMargin()))
      return false;
    if (! SmartEquals(gettMargin(), objT.gettMargin()))
      return false;
    if (! SmartEquals(getlMargin(), objT.getlMargin()))
      return false;
    if (! SmartEquals(getBackTrimRun(), objT.getBackTrimRun()))
      return false;
    if (! SmartEquals(getSwap(), objT.getSwap()))
      return false;
    if (! SmartEquals(getRunout(), objT.getRunout()))
      return false;
    if (! SmartEquals(getRunAndTumble(), objT.getRunAndTumble()))
      return false;
    if (! SmartEquals(getFinishout(), objT.getFinishout()))
      return false;
    return true;
  }			
}
