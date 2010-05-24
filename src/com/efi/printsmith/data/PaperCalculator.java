
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
  @NamedQuery(name = "PaperCalculator.findall", query = "from PaperCalculator"),
  @NamedQuery(name = "PaperCalculator.byId", query = "select a from PaperCalculator a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "papercalculator")
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
	public static final String ATTACHTOJOBTICKET = "AttachToJobTicket";
	/**
	 * @generated
	 */
	public static final String PRINTRUNTOFINISHSECTION = "PrintRunToFinishSection";
	/**
	 * @generated
	 */
	public static final String PARENTSIZE = "ParentSize";
	/**
	 * @generated
	 */
	public static final String FINISHSIZE = "FinishSize";
	/**
	 * @generated
	 */
	public static final String USEGRIPEDGEGAP = "UseGripEdgeGap";
	/**
	 * @generated
	 */
	public static final String RUNSIZE = "RunSize";
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
	public PaperCalculator() {
    this.created = new Date();
    this.modified = new Date();
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
	private Double defaultPressCuttOff;
	
	/**
	 * @generated
 	 */
	public Double getDefaultPressCuttOff(){
    return defaultPressCuttOff; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultPressCuttOff(Double newVal) {
    this.defaultPressCuttOff = newVal;
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
	private String parentSize;
	
	/**
	 * @generated
 	 */
	public String getParentSize(){
    return parentSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setParentSize(String newVal) {
    this.parentSize = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String finishSize;
	
	/**
	 * @generated
 	 */
	public String getFinishSize(){
    return finishSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setFinishSize(String newVal) {
    this.finishSize = newVal;
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
	private String runSize;
	
	/**
	 * @generated
 	 */
	public String getRunSize(){
    return runSize; 
  }

	
	/**
	 * @generated
	 */	
	public void setRunSize(String newVal) {
    this.runSize = newVal;
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
	public Integer getDAcross(){
    return dAcross; 
  }

	
	/**
	 * @generated
	 */	
	public void setDAcross(Integer newVal) {
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
	public Integer getDDown(){
    return dDown; 
  }

	
	/**
	 * @generated
	 */	
	public void setDDown(Integer newVal) {
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
  public Double getRMargin(){
    return rMargin; 
  }


	/**
   * @generated
   */	
  public void setRMargin(Double newVal) {
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
  public Double getBMargin(){
    return bMargin; 
  }


	/**
   * @generated
   */	
  public void setBMargin(Double newVal) {
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
  public Double getTMargin(){
    return tMargin; 
  }


	/**
   * @generated
   */	
  public void setTMargin(Double newVal) {
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
  public Double getLMargin(){
    return lMargin; 
  }


	/**
   * @generated
   */	
  public void setLMargin(Double newVal) {
    this.lMargin = newVal;
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
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) return getDefaultPressCuttOff();
    if (BACKTRIMPARENT.equals(propertyName)) return getBackTrimParent();
    if (TRIMFOURSIDES.equals(propertyName)) return getTrimFourSides();
    if (WORKANDTUMBLE.equals(propertyName)) return getWorkandTumble();
    if (RUNTOFINISHGRAIN.equals(propertyName)) return getRunToFinishGrain();
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return getPrintParentToFinishSection();
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return getPrintParentToRunSection();
    if (ATTACHTOJOBTICKET.equals(propertyName)) return getAttachToJobTicket();
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return getPrintRunToFinishSection();
    if (PARENTSIZE.equals(propertyName)) return getParentSize();
    if (FINISHSIZE.equals(propertyName)) return getFinishSize();
    if (USEGRIPEDGEGAP.equals(propertyName)) return getUseGripEdgeGap();
    if (RUNSIZE.equals(propertyName)) return getRunSize();
    if (GRIPLOCATION.equals(propertyName)) return getGripLocation();
    if (CUTSTOFINISH.equals(propertyName)) return getCutstoFinish();
    if (SHEETSOUT.equals(propertyName)) return getSheetsOut();
    if (FOLIOLOCATION.equals(propertyName)) return getFolioLocation();
    if (CUTSTORUN.equals(propertyName)) return getCutstoRun();
    if (DISABLEFSC.equals(propertyName)) return getDisableFSC();
    if (DOWN.equals(propertyName)) return getDown();
    if (DACROSS.equals(propertyName)) return getDAcross();
    if (DDOWN.equals(propertyName)) return getDDown();
    if (DUTCHBOTTOM.equals(propertyName)) return getDutchBottom();
    if (PARENTSQRAREA.equals(propertyName)) return getParentSqrArea();
    if (USEDSQRAREA.equals(propertyName)) return getUsedSqrArea();
    if (RMARGIN.equals(propertyName)) return getRMargin();
    if (BMARGIN.equals(propertyName)) return getBMargin();
    if (TMARGIN.equals(propertyName)) return getTMargin();
    if (LMARGIN.equals(propertyName)) return getLMargin();
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
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) setDefaultPressCuttOff((Double)newValue); else
    if (BACKTRIMPARENT.equals(propertyName)) setBackTrimParent((Boolean)newValue); else
    if (TRIMFOURSIDES.equals(propertyName)) setTrimFourSides((Boolean)newValue); else
    if (WORKANDTUMBLE.equals(propertyName)) setWorkandTumble((Boolean)newValue); else
    if (RUNTOFINISHGRAIN.equals(propertyName)) setRunToFinishGrain((String)newValue); else
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) setPrintParentToFinishSection((Boolean)newValue); else
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) setPrintParentToRunSection((Boolean)newValue); else
    if (ATTACHTOJOBTICKET.equals(propertyName)) setAttachToJobTicket((Boolean)newValue); else
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) setPrintRunToFinishSection((Boolean)newValue); else
    if (PARENTSIZE.equals(propertyName)) setParentSize((String)newValue); else
    if (FINISHSIZE.equals(propertyName)) setFinishSize((String)newValue); else
    if (USEGRIPEDGEGAP.equals(propertyName)) setUseGripEdgeGap((Boolean)newValue); else
    if (RUNSIZE.equals(propertyName)) setRunSize((String)newValue); else
    if (GRIPLOCATION.equals(propertyName)) setGripLocation((String)newValue); else
    if (CUTSTOFINISH.equals(propertyName)) setCutstoFinish((Integer)newValue); else
    if (SHEETSOUT.equals(propertyName)) setSheetsOut((Integer)newValue); else
    if (FOLIOLOCATION.equals(propertyName)) setFolioLocation((String)newValue); else
    if (CUTSTORUN.equals(propertyName)) setCutstoRun((Integer)newValue); else
    if (DISABLEFSC.equals(propertyName)) setDisableFSC((Boolean)newValue); else
    if (DOWN.equals(propertyName)) setDown((Integer)newValue); else
    if (DACROSS.equals(propertyName)) setDAcross((Integer)newValue); else
    if (DDOWN.equals(propertyName)) setDDown((Integer)newValue); else
    if (DUTCHBOTTOM.equals(propertyName)) setDutchBottom((Integer)newValue); else
    if (PARENTSQRAREA.equals(propertyName)) setParentSqrArea((Double)newValue); else
    if (USEDSQRAREA.equals(propertyName)) setUsedSqrArea((Double)newValue); else
    if (RMARGIN.equals(propertyName)) setRMargin((Double)newValue); else
    if (BMARGIN.equals(propertyName)) setBMargin((Double)newValue); else
    if (TMARGIN.equals(propertyName)) setTMargin((Double)newValue); else
    if (LMARGIN.equals(propertyName)) setLMargin((Double)newValue); else
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
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
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
    if (ATTACHTOJOBTICKET.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PARENTSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FINISHSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (USEGRIPEDGEGAP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RUNSIZE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
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
    if (DEFAULTPRESSCUTTOFF.equals(propertyName)) return PaperCalculator.class;
    if (BACKTRIMPARENT.equals(propertyName)) return PaperCalculator.class;
    if (TRIMFOURSIDES.equals(propertyName)) return PaperCalculator.class;
    if (WORKANDTUMBLE.equals(propertyName)) return PaperCalculator.class;
    if (RUNTOFINISHGRAIN.equals(propertyName)) return PaperCalculator.class;
    if (PRINTPARENTTOFINISHSECTION.equals(propertyName)) return PaperCalculator.class;
    if (PRINTPARENTTORUNSECTION.equals(propertyName)) return PaperCalculator.class;
    if (ATTACHTOJOBTICKET.equals(propertyName)) return PaperCalculator.class;
    if (PRINTRUNTOFINISHSECTION.equals(propertyName)) return PaperCalculator.class;
    if (PARENTSIZE.equals(propertyName)) return PaperCalculator.class;
    if (FINISHSIZE.equals(propertyName)) return PaperCalculator.class;
    if (USEGRIPEDGEGAP.equals(propertyName)) return PaperCalculator.class;
    if (RUNSIZE.equals(propertyName)) return PaperCalculator.class;
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
    if (! SmartEquals(getAttachToJobTicket(), objT.getAttachToJobTicket()))
      return false;
    if (! SmartEquals(getPrintRunToFinishSection(), objT.getPrintRunToFinishSection()))
      return false;
    if (! SmartEquals(getParentSize(), objT.getParentSize()))
      return false;
    if (! SmartEquals(getFinishSize(), objT.getFinishSize()))
      return false;
    if (! SmartEquals(getUseGripEdgeGap(), objT.getUseGripEdgeGap()))
      return false;
    if (! SmartEquals(getRunSize(), objT.getRunSize()))
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
    if (! SmartEquals(getDAcross(), objT.getDAcross()))
      return false;
    if (! SmartEquals(getDDown(), objT.getDDown()))
      return false;
    if (! SmartEquals(getDutchBottom(), objT.getDutchBottom()))
      return false;
    if (! SmartEquals(getParentSqrArea(), objT.getParentSqrArea()))
      return false;
    if (! SmartEquals(getUsedSqrArea(), objT.getUsedSqrArea()))
      return false;
    if (! SmartEquals(getRMargin(), objT.getRMargin()))
      return false;
    if (! SmartEquals(getBMargin(), objT.getBMargin()))
      return false;
    if (! SmartEquals(getTMargin(), objT.getTMargin()))
      return false;
    if (! SmartEquals(getLMargin(), objT.getLMargin()))
      return false;
    return true;
  }			
}
