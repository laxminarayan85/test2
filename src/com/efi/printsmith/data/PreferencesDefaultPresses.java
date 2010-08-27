
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
  @NamedQuery(name = "PreferencesDefaultPresses.findall", query = "from PreferencesDefaultPresses"),
  @NamedQuery(name = "PreferencesDefaultPresses.byId", query = "select a from PreferencesDefaultPresses a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencesdefaultpresses")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from preferencesdefaultpresses where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesDefaultPresses extends ModelBase {
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
	public static final String DEFAULTLARGEFORMAT = "DefaultLargeFormat";
	/**
	 * @generated
	 */
	public static final String DEFAULTROLLFEDPRESS = "DefaultRollFedPress";
	/**
	 * @generated
	 */
	public static final String DEFAULTSHEETFEDPRESS = "DefaultSheetFedPress";

	/**
	 * @generated
	 */
	public PreferencesDefaultPresses() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
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
    @ManyToOne()
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
    @ManyToOne()
	private CopierDefinition defaultLargeFormat;
	
	/**
	 * @generated
 	 */
	public CopierDefinition getDefaultLargeFormat(){
    return defaultLargeFormat; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultLargeFormat(CopierDefinition newVal) {
    this.defaultLargeFormat = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private PressDefinition defaultRollFedPress;
	
	/**
	 * @generated
 	 */
	public PressDefinition getDefaultRollFedPress(){
    return defaultRollFedPress; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultRollFedPress(PressDefinition newVal) {
    this.defaultRollFedPress = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private PressDefinition defaultSheetFedPress;
	
	/**
	 * @generated
 	 */
	public PressDefinition getDefaultSheetFedPress(){
    return defaultSheetFedPress; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultSheetFedPress(PressDefinition newVal) {
    this.defaultSheetFedPress = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (DEFAULTBWCOPIER.equals(propertyName)) return getDefaultBWCopier();
    if (DEFAULTCOLORCOPIER.equals(propertyName)) return getDefaultColorCopier();
    if (DEFAULTLARGEFORMAT.equals(propertyName)) return getDefaultLargeFormat();
    if (DEFAULTROLLFEDPRESS.equals(propertyName)) return getDefaultRollFedPress();
    if (DEFAULTSHEETFEDPRESS.equals(propertyName)) return getDefaultSheetFedPress();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (DEFAULTBWCOPIER.equals(propertyName)) setDefaultBWCopier((CopierDefinition)newValue); else
    if (DEFAULTCOLORCOPIER.equals(propertyName)) setDefaultColorCopier((CopierDefinition)newValue); else
    if (DEFAULTLARGEFORMAT.equals(propertyName)) setDefaultLargeFormat((CopierDefinition)newValue); else
    if (DEFAULTROLLFEDPRESS.equals(propertyName)) setDefaultRollFedPress((PressDefinition)newValue); else
    if (DEFAULTSHEETFEDPRESS.equals(propertyName)) setDefaultSheetFedPress((PressDefinition)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (DEFAULTBWCOPIER.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    if (DEFAULTCOLORCOPIER.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    if (DEFAULTLARGEFORMAT.equals(propertyName)) 
      return new Class<?>[] {CopierDefinition.class};		
    if (DEFAULTROLLFEDPRESS.equals(propertyName)) 
      return new Class<?>[] {PressDefinition.class};		
    if (DEFAULTSHEETFEDPRESS.equals(propertyName)) 
      return new Class<?>[] {PressDefinition.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (DEFAULTBWCOPIER.equals(propertyName)) return PreferencesDefaultPresses.class;
    if (DEFAULTCOLORCOPIER.equals(propertyName)) return PreferencesDefaultPresses.class;
    if (DEFAULTLARGEFORMAT.equals(propertyName)) return PreferencesDefaultPresses.class;
    if (DEFAULTROLLFEDPRESS.equals(propertyName)) return PreferencesDefaultPresses.class;
    if (DEFAULTSHEETFEDPRESS.equals(propertyName)) return PreferencesDefaultPresses.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesDefaultPresses objT = (PreferencesDefaultPresses)obj;
    if (! SmartEquals(getDefaultBWCopier(), objT.getDefaultBWCopier()))
      return false;
    if (! SmartEquals(getDefaultColorCopier(), objT.getDefaultColorCopier()))
      return false;
    if (! SmartEquals(getDefaultLargeFormat(), objT.getDefaultLargeFormat()))
      return false;
    if (! SmartEquals(getDefaultRollFedPress(), objT.getDefaultRollFedPress()))
      return false;
    if (! SmartEquals(getDefaultSheetFedPress(), objT.getDefaultSheetFedPress()))
      return false;
    return true;
  }			
}
