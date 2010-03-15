package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
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
	@NamedQuery(name = "CreditCard.findall", query = "from CreditCard"),
	@NamedQuery(name = "CreditCard.byId", query = "select a from CreditCard a where a.id= :id")
})


@Entity
@Table(name = "creditcard")
public class CreditCard extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CARDHOLDERNAME = "CardHolderName";
	/**
	 * @generated
	 */
	public static final String CARDNUMBER = "CardNumber";
	/**
	 * @generated
	 */
	public static final String EXPIRESDATE = "ExpiresDate";
	/**
	 * @generated
	 */
	public static final String ADDRESS = "Address";
	/**
	 * @generated
	 */
	public static final String CREDITCARDID = "CreditCardID";
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";

	/**
	 * @generated
	 */
	public CreditCard() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cardHolderName;
	
	/**
	 * @generated
 	 */
	public String getCardHolderName(){
		return cardHolderName; 
	}

	
	/**
	 * @generated
	 */	
	public void setCardHolderName(String newVal) {
		this.cardHolderName = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cardNumber;
	
	/**
	 * @generated
 	 */
	public String getCardNumber(){
		return cardNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setCardNumber(String newVal) {
		this.cardNumber = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date expiresDate;
	
	/**
	 * @generated
 	 */
	public Date getExpiresDate(){
		return expiresDate; 
	}

	
	/**
	 * @generated
	 */	
	public void setExpiresDate(Date newVal) {
		this.expiresDate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Address address;
	
	/**
	 * @generated
 	 */
	public Address getAddress(){
		return address; 
	}

	
	/**
	 * @generated
	 */	
	public void setAddress(Address newVal) {
		this.address = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer creditCardID;
	
	/**
	 * @generated
 	 */
	public Integer getCreditCardID(){
		return creditCardID; 
	}

	
	/**
	 * @generated
	 */	
	public void setCreditCardID(Integer newVal) {
		this.creditCardID = newVal;
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
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CARDHOLDERNAME.equals(propertyName)) return getCardHolderName();
		if (CARDNUMBER.equals(propertyName)) return getCardNumber();
		if (EXPIRESDATE.equals(propertyName)) return getExpiresDate();
		if (ADDRESS.equals(propertyName)) return getAddress();
		if (CREDITCARDID.equals(propertyName)) return getCreditCardID();
		if (TYPE.equals(propertyName)) return getType();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CARDHOLDERNAME.equals(propertyName)) setCardHolderName((String)newValue); else
		if (CARDNUMBER.equals(propertyName)) setCardNumber((String)newValue); else
		if (EXPIRESDATE.equals(propertyName)) setExpiresDate((Date)newValue); else
		if (ADDRESS.equals(propertyName)) setAddress((Address)newValue); else
		if (CREDITCARDID.equals(propertyName)) setCreditCardID((Integer)newValue); else
		if (TYPE.equals(propertyName)) setType((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CARDHOLDERNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CARDNUMBER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (EXPIRESDATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (ADDRESS.equals(propertyName)) 
			return new Class<?>[] {Address.class};		
		if (CREDITCARDID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (TYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CARDHOLDERNAME.equals(propertyName)) return CreditCard.class;
		if (CARDNUMBER.equals(propertyName)) return CreditCard.class;
		if (EXPIRESDATE.equals(propertyName)) return CreditCard.class;
		if (ADDRESS.equals(propertyName)) return CreditCard.class;
		if (CREDITCARDID.equals(propertyName)) return CreditCard.class;
		if (TYPE.equals(propertyName)) return CreditCard.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		CreditCard objT = (CreditCard)obj;
		if (! SmartEquals(getCardHolderName(), objT.getCardHolderName()))
			return false;
		if (! SmartEquals(getCardNumber(), objT.getCardNumber()))
			return false;
		if (! SmartEquals(getExpiresDate(), objT.getExpiresDate()))
			return false;
		if (! SmartEquals(getAddress(), objT.getAddress()))
			return false;
		if (! SmartEquals(getCreditCardID(), objT.getCreditCardID()))
			return false;
		if (! SmartEquals(getType(), objT.getType()))
			return false;
		return true;
	}			
}