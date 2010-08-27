
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
  @NamedQuery(name = "PreferencesCreditCard.findall", query = "from PreferencesCreditCard"),
  @NamedQuery(name = "PreferencesCreditCard.byId", query = "select a from PreferencesCreditCard a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencescreditcard")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from preferencescreditcard where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesCreditCard extends ModelBase {
	/**
	 * @generated
	 */
	public static final String USED = "Used";
	/**
	 * @generated
	 */
	public static final String CARDTYPE = "CardType";
	/**
	 * @generated
	 */
	public static final String ABBREVIATION = "Abbreviation";
	/**
	 * @generated
	 */
	public static final String CODE = "Code";

	/**
	 * @generated
	 */
	public PreferencesCreditCard() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean used;
	
	/**
	 * @generated
 	 */
	public Boolean getUsed(){
    return used; 
  }

	
	/**
	 * @generated
	 */	
	public void setUsed(Boolean newVal) {
    this.used = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cardType;
	
	/**
	 * @generated
 	 */
	public String getCardType(){
    return cardType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCardType(String newVal) {
    this.cardType = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String abbreviation;
	
	/**
	 * @generated
 	 */
	public String getAbbreviation(){
    return abbreviation; 
  }

	
	/**
	 * @generated
	 */	
	public void setAbbreviation(String newVal) {
    this.abbreviation = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String code;
	
	/**
	 * @generated
 	 */
	public String getCode(){
    return code; 
  }

	
	/**
	 * @generated
	 */	
	public void setCode(String newVal) {
    this.code = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (USED.equals(propertyName)) return getUsed();
    if (CARDTYPE.equals(propertyName)) return getCardType();
    if (ABBREVIATION.equals(propertyName)) return getAbbreviation();
    if (CODE.equals(propertyName)) return getCode();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (USED.equals(propertyName)) setUsed((Boolean)newValue); else
    if (CARDTYPE.equals(propertyName)) setCardType((String)newValue); else
    if (ABBREVIATION.equals(propertyName)) setAbbreviation((String)newValue); else
    if (CODE.equals(propertyName)) setCode((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (USED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CARDTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ABBREVIATION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (USED.equals(propertyName)) return PreferencesCreditCard.class;
    if (CARDTYPE.equals(propertyName)) return PreferencesCreditCard.class;
    if (ABBREVIATION.equals(propertyName)) return PreferencesCreditCard.class;
    if (CODE.equals(propertyName)) return PreferencesCreditCard.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesCreditCard objT = (PreferencesCreditCard)obj;
    if (! SmartEquals(getUsed(), objT.getUsed()))
      return false;
    if (! SmartEquals(getCardType(), objT.getCardType()))
      return false;
    if (! SmartEquals(getAbbreviation(), objT.getAbbreviation()))
      return false;
    if (! SmartEquals(getCode(), objT.getCode()))
      return false;
    return true;
  }			
}
