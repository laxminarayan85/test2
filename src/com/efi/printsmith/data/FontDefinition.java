
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
  @NamedQuery(name = "FontDefinition.findall", query = "from FontDefinition"),
  @NamedQuery(name = "FontDefinition.byId", query = "select a from FontDefinition a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "fontdefinition")
@SQLDelete(sql="update fontdefinition set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class FontDefinition extends ModelBase {
	/**
	 * @generated
	 */
	public static final String FONTNAME = "FontName";
	/**
	 * @generated
	 */
	public static final String SIZE = "Size";
	/**
	 * @generated
	 */
	public static final String ISBOLD = "IsBold";
	/**
	 * @generated
	 */
	public static final String ISITALIC = "IsItalic";
	/**
	 * @generated
	 */
	public static final String ISUNDERLINE = "IsUnderline";
	/**
	 * @generated
	 */
	public static final String ISOUTLINE = "IsOutline";
	/**
	 * @generated
	 */
	public static final String ISSHADOW = "IsShadow";
	/**
	 * @generated
	 */
	public static final String ISCONDENSED = "IsCondensed";
	/**
	 * @generated
	 */
	public static final String EXTENDED = "Extended";

	/**
	 * @generated
	 */
	public FontDefinition() {
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
	private String fontName;
	
	/**
	 * @generated
 	 */
	public String getFontName(){
    return fontName; 
  }

	
	/**
	 * @generated
	 */	
	public void setFontName(String newVal) {
    this.fontName = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer size;
	
	/**
	 * @generated
 	 */
	public Integer getSize(){
    return size; 
  }

	
	/**
	 * @generated
	 */	
	public void setSize(Integer newVal) {
    this.size = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isBold;
	
	/**
	 * @generated
 	 */
	public Boolean getIsBold(){
    return isBold; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsBold(Boolean newVal) {
    this.isBold = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isItalic;
	
	/**
	 * @generated
 	 */
	public Boolean getIsItalic(){
    return isItalic; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsItalic(Boolean newVal) {
    this.isItalic = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isUnderline;
	
	/**
	 * @generated
 	 */
	public Boolean getIsUnderline(){
    return isUnderline; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsUnderline(Boolean newVal) {
    this.isUnderline = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isOutline;
	
	/**
	 * @generated
 	 */
	public Boolean getIsOutline(){
    return isOutline; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsOutline(Boolean newVal) {
    this.isOutline = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isShadow;
	
	/**
	 * @generated
 	 */
	public Boolean getIsShadow(){
    return isShadow; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsShadow(Boolean newVal) {
    this.isShadow = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isCondensed;
	
	/**
	 * @generated
 	 */
	public Boolean getIsCondensed(){
    return isCondensed; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsCondensed(Boolean newVal) {
    this.isCondensed = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean extended;
	
	/**
	 * @generated
 	 */
	public Boolean getExtended(){
    return extended; 
  }

	
	/**
	 * @generated
	 */	
	public void setExtended(Boolean newVal) {
    this.extended = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (FONTNAME.equals(propertyName)) return getFontName();
    if (SIZE.equals(propertyName)) return getSize();
    if (ISBOLD.equals(propertyName)) return getIsBold();
    if (ISITALIC.equals(propertyName)) return getIsItalic();
    if (ISUNDERLINE.equals(propertyName)) return getIsUnderline();
    if (ISOUTLINE.equals(propertyName)) return getIsOutline();
    if (ISSHADOW.equals(propertyName)) return getIsShadow();
    if (ISCONDENSED.equals(propertyName)) return getIsCondensed();
    if (EXTENDED.equals(propertyName)) return getExtended();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (FONTNAME.equals(propertyName)) setFontName((String)newValue); else
    if (SIZE.equals(propertyName)) setSize((Integer)newValue); else
    if (ISBOLD.equals(propertyName)) setIsBold((Boolean)newValue); else
    if (ISITALIC.equals(propertyName)) setIsItalic((Boolean)newValue); else
    if (ISUNDERLINE.equals(propertyName)) setIsUnderline((Boolean)newValue); else
    if (ISOUTLINE.equals(propertyName)) setIsOutline((Boolean)newValue); else
    if (ISSHADOW.equals(propertyName)) setIsShadow((Boolean)newValue); else
    if (ISCONDENSED.equals(propertyName)) setIsCondensed((Boolean)newValue); else
    if (EXTENDED.equals(propertyName)) setExtended((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (FONTNAME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SIZE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ISBOLD.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISITALIC.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISUNDERLINE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISOUTLINE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISSHADOW.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISCONDENSED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EXTENDED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (FONTNAME.equals(propertyName)) return FontDefinition.class;
    if (SIZE.equals(propertyName)) return FontDefinition.class;
    if (ISBOLD.equals(propertyName)) return FontDefinition.class;
    if (ISITALIC.equals(propertyName)) return FontDefinition.class;
    if (ISUNDERLINE.equals(propertyName)) return FontDefinition.class;
    if (ISOUTLINE.equals(propertyName)) return FontDefinition.class;
    if (ISSHADOW.equals(propertyName)) return FontDefinition.class;
    if (ISCONDENSED.equals(propertyName)) return FontDefinition.class;
    if (EXTENDED.equals(propertyName)) return FontDefinition.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    FontDefinition objT = (FontDefinition)obj;
    if (! SmartEquals(getFontName(), objT.getFontName()))
      return false;
    if (! SmartEquals(getSize(), objT.getSize()))
      return false;
    if (! SmartEquals(getIsBold(), objT.getIsBold()))
      return false;
    if (! SmartEquals(getIsItalic(), objT.getIsItalic()))
      return false;
    if (! SmartEquals(getIsUnderline(), objT.getIsUnderline()))
      return false;
    if (! SmartEquals(getIsOutline(), objT.getIsOutline()))
      return false;
    if (! SmartEquals(getIsShadow(), objT.getIsShadow()))
      return false;
    if (! SmartEquals(getIsCondensed(), objT.getIsCondensed()))
      return false;
    if (! SmartEquals(getExtended(), objT.getExtended()))
      return false;
    return true;
  }			
}
