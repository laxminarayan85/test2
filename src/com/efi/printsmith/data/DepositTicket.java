
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "DepositTicket.findall", query = "from DepositTicket"),
  @NamedQuery(name = "DepositTicket.byId", query = "select a from DepositTicket a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "depositticket")
public class DepositTicket extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String REF = "Ref";
	/**
	 * @generated
	 */
	public static final String CREDITCARDTYPE = "CreditCardType";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String CHECKNUM = "CheckNum";

	/**
	 * @generated
	 */
	public DepositTicket() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String type;
	
	/**
	 * @generated
 	 */
	public String getType(){
    return type; 
  }

	
	/**
	 * @generated
	 */	
	public void setType(String newVal) {
    this.type = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String ref;
	
	/**
	 * @generated
 	 */
	public String getRef(){
    return ref; 
  }

	
	/**
	 * @generated
	 */	
	public void setRef(String newVal) {
    this.ref = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String creditCardType;
	
	/**
	 * @generated
 	 */
	public String getCreditCardType(){
    return creditCardType; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardType(String newVal) {
    this.creditCardType = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal amount;
	
	/**
	 * @generated
 	 */
	public BigDecimal getAmount(){
    return amount; 
  }

	
	/**
	 * @generated
	 */	
	public void setAmount(BigDecimal newVal) {
    this.amount = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setAmount(double newVal) {
    this.amount = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer checkNum;
	
	/**
	 * @generated
 	 */
	public Integer getCheckNum(){
    return checkNum; 
  }

	
	/**
	 * @generated
	 */	
	public void setCheckNum(Integer newVal) {
    this.checkNum = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (TYPE.equals(propertyName)) return getType();
    if (REF.equals(propertyName)) return getRef();
    if (CREDITCARDTYPE.equals(propertyName)) return getCreditCardType();
    if (AMOUNT.equals(propertyName)) return getAmount();
    if (CHECKNUM.equals(propertyName)) return getCheckNum();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (REF.equals(propertyName)) setRef((String)newValue); else
    if (CREDITCARDTYPE.equals(propertyName)) setCreditCardType((String)newValue); else
    if (AMOUNT.equals(propertyName)) setAmount((BigDecimal)newValue); else
    if (CHECKNUM.equals(propertyName)) setCheckNum((Integer)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REF.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CREDITCARDTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AMOUNT.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (CHECKNUM.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (TYPE.equals(propertyName)) return DepositTicket.class;
    if (REF.equals(propertyName)) return DepositTicket.class;
    if (CREDITCARDTYPE.equals(propertyName)) return DepositTicket.class;
    if (AMOUNT.equals(propertyName)) return DepositTicket.class;
    if (CHECKNUM.equals(propertyName)) return DepositTicket.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DepositTicket objT = (DepositTicket)obj;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getRef(), objT.getRef()))
      return false;
    if (! SmartEquals(getCreditCardType(), objT.getCreditCardType()))
      return false;
    if (! SmartEquals(getAmount(), objT.getAmount()))
      return false;
    if (! SmartEquals(getCheckNum(), objT.getCheckNum()))
      return false;
    return true;
  }			
}
