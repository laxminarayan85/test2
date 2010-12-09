
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
  @NamedQuery(name = "LabelFormat.findall", query = "from LabelFormat"),
  @NamedQuery(name = "LabelFormat.byId", query = "select a from LabelFormat a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "labelformat")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from labelformat where modelbase.id=?")
@SQLDelete(sql="update labelformat set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class LabelFormat extends ModelBase {
	/**
	 * @generated
	 */
	public static final String NAME = "Name";
	/**
	 * @generated
	 */
	public static final String FONTDEFINITION = "FontDefinition";
	/**
	 * @generated
	 */
	public static final String NOOFLABELSACROSS = "NoOfLabelsAcross";
	/**
	 * @generated
	 */
	public static final String NOOFLABELSDOWN = "NoOfLabelsDown";
	/**
	 * @generated
	 */
	public static final String LABELWIDTH = "LabelWidth";
	/**
	 * @generated
	 */
	public static final String LABELHEIGHT = "LabelHeight";
	/**
	 * @generated
	 */
	public static final String LEFTMARGIN = "LeftMargin";
	/**
	 * @generated
	 */
	public static final String TOPMARGIN = "TopMargin";
	/**
	 * @generated
	 */
	public static final String SPACEONRIGHT = "SpaceOnRight";
	/**
	 * @generated
	 */
	public static final String SPACEONBOTTOM = "SpaceOnBottom";
	/**
	 * @generated
	 */
	public static final String MEASUREMENTS = "Measurements";

	/**
	 * @generated
	 */
	public LabelFormat() {
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
    @ManyToOne( cascade = {CascadeType.ALL})
    @Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition fontDefinition;
	
	/**
	 * @generated
 	 */
	public FontDefinition getFontDefinition(){
    return fontDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setFontDefinition(FontDefinition newVal) {
    this.fontDefinition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double noOfLabelsAcross;
	
	/**
	 * @generated
 	 */
	public Double getNoOfLabelsAcross(){
    return noOfLabelsAcross; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoOfLabelsAcross(Double newVal) {
    this.noOfLabelsAcross = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double noOfLabelsDown;
	
	/**
	 * @generated
 	 */
	public Double getNoOfLabelsDown(){
    return noOfLabelsDown; 
  }

	
	/**
	 * @generated
	 */	
	public void setNoOfLabelsDown(Double newVal) {
    this.noOfLabelsDown = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double labelWidth;
	
	/**
	 * @generated
 	 */
	public Double getLabelWidth(){
    return labelWidth; 
  }

	
	/**
	 * @generated
	 */	
	public void setLabelWidth(Double newVal) {
    this.labelWidth = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double labelHeight;
	
	/**
	 * @generated
 	 */
	public Double getLabelHeight(){
    return labelHeight; 
  }

	
	/**
	 * @generated
	 */	
	public void setLabelHeight(Double newVal) {
    this.labelHeight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double leftMargin;
	
	/**
	 * @generated
 	 */
	public Double getLeftMargin(){
    return leftMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void setLeftMargin(Double newVal) {
    this.leftMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double topMargin;
	
	/**
	 * @generated
 	 */
	public Double getTopMargin(){
    return topMargin; 
  }

	
	/**
	 * @generated
	 */	
	public void setTopMargin(Double newVal) {
    this.topMargin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double spaceOnRight;
	
	/**
	 * @generated
 	 */
	public Double getSpaceOnRight(){
    return spaceOnRight; 
  }

	
	/**
	 * @generated
	 */	
	public void setSpaceOnRight(Double newVal) {
    this.spaceOnRight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double spaceOnBottom;
	
	/**
	 * @generated
 	 */
	public Double getSpaceOnBottom(){
    return spaceOnBottom; 
  }

	
	/**
	 * @generated
	 */	
	public void setSpaceOnBottom(Double newVal) {
    this.spaceOnBottom = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String measurements;
	
	/**
	 * @generated
 	 */
	public String getMeasurements(){
    return measurements; 
  }

	
	/**
	 * @generated
	 */	
	public void setMeasurements(String newVal) {
    this.measurements = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (NAME.equals(propertyName)) return getName();
    if (FONTDEFINITION.equals(propertyName)) return getFontDefinition();
    if (NOOFLABELSACROSS.equals(propertyName)) return getNoOfLabelsAcross();
    if (NOOFLABELSDOWN.equals(propertyName)) return getNoOfLabelsDown();
    if (LABELWIDTH.equals(propertyName)) return getLabelWidth();
    if (LABELHEIGHT.equals(propertyName)) return getLabelHeight();
    if (LEFTMARGIN.equals(propertyName)) return getLeftMargin();
    if (TOPMARGIN.equals(propertyName)) return getTopMargin();
    if (SPACEONRIGHT.equals(propertyName)) return getSpaceOnRight();
    if (SPACEONBOTTOM.equals(propertyName)) return getSpaceOnBottom();
    if (MEASUREMENTS.equals(propertyName)) return getMeasurements();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (NAME.equals(propertyName)) setName((String)newValue); else
    if (FONTDEFINITION.equals(propertyName)) setFontDefinition((FontDefinition)newValue); else
    if (NOOFLABELSACROSS.equals(propertyName)) setNoOfLabelsAcross((Double)newValue); else
    if (NOOFLABELSDOWN.equals(propertyName)) setNoOfLabelsDown((Double)newValue); else
    if (LABELWIDTH.equals(propertyName)) setLabelWidth((Double)newValue); else
    if (LABELHEIGHT.equals(propertyName)) setLabelHeight((Double)newValue); else
    if (LEFTMARGIN.equals(propertyName)) setLeftMargin((Double)newValue); else
    if (TOPMARGIN.equals(propertyName)) setTopMargin((Double)newValue); else
    if (SPACEONRIGHT.equals(propertyName)) setSpaceOnRight((Double)newValue); else
    if (SPACEONBOTTOM.equals(propertyName)) setSpaceOnBottom((Double)newValue); else
    if (MEASUREMENTS.equals(propertyName)) setMeasurements((String)newValue); else
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
    if (FONTDEFINITION.equals(propertyName)) 
      return new Class<?>[] {FontDefinition.class};		
    if (NOOFLABELSACROSS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (NOOFLABELSDOWN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LABELWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LABELHEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LEFTMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOPMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SPACEONRIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SPACEONBOTTOM.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MEASUREMENTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (NAME.equals(propertyName)) return LabelFormat.class;
    if (FONTDEFINITION.equals(propertyName)) return LabelFormat.class;
    if (NOOFLABELSACROSS.equals(propertyName)) return LabelFormat.class;
    if (NOOFLABELSDOWN.equals(propertyName)) return LabelFormat.class;
    if (LABELWIDTH.equals(propertyName)) return LabelFormat.class;
    if (LABELHEIGHT.equals(propertyName)) return LabelFormat.class;
    if (LEFTMARGIN.equals(propertyName)) return LabelFormat.class;
    if (TOPMARGIN.equals(propertyName)) return LabelFormat.class;
    if (SPACEONRIGHT.equals(propertyName)) return LabelFormat.class;
    if (SPACEONBOTTOM.equals(propertyName)) return LabelFormat.class;
    if (MEASUREMENTS.equals(propertyName)) return LabelFormat.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    LabelFormat objT = (LabelFormat)obj;
    if (! SmartEquals(getName(), objT.getName()))
      return false;
    if (! SmartEquals(getFontDefinition(), objT.getFontDefinition()))
      return false;
    if (! SmartEquals(getNoOfLabelsAcross(), objT.getNoOfLabelsAcross()))
      return false;
    if (! SmartEquals(getNoOfLabelsDown(), objT.getNoOfLabelsDown()))
      return false;
    if (! SmartEquals(getLabelWidth(), objT.getLabelWidth()))
      return false;
    if (! SmartEquals(getLabelHeight(), objT.getLabelHeight()))
      return false;
    if (! SmartEquals(getLeftMargin(), objT.getLeftMargin()))
      return false;
    if (! SmartEquals(getTopMargin(), objT.getTopMargin()))
      return false;
    if (! SmartEquals(getSpaceOnRight(), objT.getSpaceOnRight()))
      return false;
    if (! SmartEquals(getSpaceOnBottom(), objT.getSpaceOnBottom()))
      return false;
    if (! SmartEquals(getMeasurements(), objT.getMeasurements()))
      return false;
    return true;
  }			
}
