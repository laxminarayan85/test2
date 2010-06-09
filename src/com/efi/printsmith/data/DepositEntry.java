
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
  @NamedQuery(name = "DepositEntry.findall", query = "from DepositEntry"),
  @NamedQuery(name = "DepositEntry.byId", query = "select a from DepositEntry a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "depositentry")
public class DepositEntry extends ModelBase {
	/**
	 * @generated
	 */
	public static final String REFERENCENUMBER = "ReferenceNumber";
	/**
	 * @generated
	 */
	public static final String DATE = "Date";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String CREDITCARDTYPE = "CreditCardType";

	/**
	 * @generated
	 */
	public DepositEntry() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String referenceNumber;
	
	/**
	 * @generated
 	 */
	public String getReferenceNumber(){
    return referenceNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setReferenceNumber(String newVal) {
    this.referenceNumber = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date date;
	
	/**
	 * @generated
 	 */
	public Date getDate(){
    return date; 
  }

	
	/**
	 * @generated
	 */	
	public void setDate(Date newVal) {
    this.date = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double amount;
	
	/**
	 * @generated
 	 */
	public Double getAmount(){
    return amount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmount(Double newVal) {
    this.amount = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private DepositType type;
	
	/**
	 * @generated
 	 */
	public DepositType getType(){
    return type; 
  }

	
	/**
	 * @generated
	 */	
	public void setType(DepositType newVal) {
    this.type = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer creditCardType;
	
	/**
	 * @generated
 	 */
	public Integer getCreditCardType(){
    return creditCardType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardType(Integer newVal) {
    this.creditCardType = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (REFERENCENUMBER.equals(propertyName)) return getReferenceNumber();
    if (DATE.equals(propertyName)) return getDate();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (TYPE.equals(propertyName)) return getType();
    if (CREDITCARDTYPE.equals(propertyName)) return getCreditCardType();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (REFERENCENUMBER.equals(propertyName)) setReferenceNumber((String)newValue); else
    if (DATE.equals(propertyName)) setDate((Date)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
    if (TYPE.equals(propertyName)) setType((DepositType)newValue); else
    if (CREDITCARDTYPE.equals(propertyName)) setCreditCardType((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (REFERENCENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {DepositType.class};		
    if (CREDITCARDTYPE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (REFERENCENUMBER.equals(propertyName)) return DepositEntry.class;
    if (DATE.equals(propertyName)) return DepositEntry.class;
    if (AMOUNT.equals(propertyName)) return DepositEntry.class;
    if (TYPE.equals(propertyName)) return DepositEntry.class;
    if (CREDITCARDTYPE.equals(propertyName)) return DepositEntry.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DepositEntry objT = (DepositEntry)obj;
    if (! SmartEquals(getReferenceNumber(), objT.getReferenceNumber()))
      return false;
    if (! SmartEquals(getDate(), objT.getDate()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getCreditCardType(), objT.getCreditCardType()))
      return false;
    return true;
  }			
}
