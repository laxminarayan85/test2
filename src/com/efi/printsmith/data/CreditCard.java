
package com.efi.printsmith.data;

import java.math.BigDecimal;
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
  @NamedQuery(name = "CreditCard.findall", query = "from CreditCard"),
  @NamedQuery(name = "CreditCard.byId", query = "select a from CreditCard a where a.id= :id")
})



/**
 * @generated
 */	
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
  public static final String ENCRYPTION = "Encryption";
	/**
   * @generated
   */
  public static final String CARDDISPLAYNUMBER = "CardDisplayNumber";

	/**
   * @generated
   */
  public static final String CREDITCARDTRANSACTIONS = "CreditCardTransactions";

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
    @ManyToOne( cascade = {CascadeType.ALL}, optional=true)
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
	private String creditCardID;
	
	/**
	 * @generated
 	 */
	public String getCreditCardID(){
    return creditCardID; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardID(String newVal) {
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
 	@Basic
  private String encryption;

	/**
   * @generated
 	 */
  public String getEncryption(){
    return encryption; 
  }


	/**
   * @generated
   */	
  public void setEncryption(String newVal) {
    this.encryption = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String cardDisplayNumber;

	/**
   * @generated
 	 */
  public String getCardDisplayNumber(){
    return cardDisplayNumber; 
  }


	/**
   * @generated
   */	
  public void setCardDisplayNumber(String newVal) {
    this.cardDisplayNumber = newVal;
  }


	/**
   * @generated
   */	
    @OneToMany(  cascade = {CascadeType.ALL})
    @JoinTable( name = "creditcard_creditcardtransactions")
  private java.util.List<CreditCardTransactions> creditCardTransactions;

	/**
   * @generated
 	 */
  public java.util.List<CreditCardTransactions> getCreditCardTransactions(){
    return creditCardTransactions; 
  }


	/**
   * @generated
   */	
  public void addCreditCardTransactions(CreditCardTransactions obj) {
    if (creditCardTransactions == null) {
      creditCardTransactions = new java.util.ArrayList<CreditCardTransactions>();
    }
    creditCardTransactions.add(obj);
  }


	/**
   * @generated
   */	
  public void setCreditCardTransactions(java.util.List<CreditCardTransactions> newVal) {
    this.creditCardTransactions = newVal;
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
    if (ENCRYPTION.equals(propertyName)) return getEncryption();
    if (CARDDISPLAYNUMBER.equals(propertyName)) return getCardDisplayNumber();
    if (CREDITCARDTRANSACTIONS.equals(propertyName)) return getCreditCardTransactions();
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
    if (CREDITCARDID.equals(propertyName)) setCreditCardID((String)newValue); else
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (ENCRYPTION.equals(propertyName)) setEncryption((String)newValue); else
    if (CARDDISPLAYNUMBER.equals(propertyName)) setCardDisplayNumber((String)newValue); else
    if (CREDITCARDTRANSACTIONS.equals(propertyName)) setCreditCardTransactions((java.util.List<CreditCardTransactions>)newValue); else
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
      return new Class<?>[] {String.class};		
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ENCRYPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CARDDISPLAYNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CREDITCARDTRANSACTIONS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, CreditCardTransactions.class};		
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
    if (ENCRYPTION.equals(propertyName)) return CreditCard.class;
    if (CARDDISPLAYNUMBER.equals(propertyName)) return CreditCard.class;
    if (CREDITCARDTRANSACTIONS.equals(propertyName)) return CreditCard.class;
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
    if (! SmartEquals(getEncryption(), objT.getEncryption()))
      return false;
    if (! SmartEquals(getCardDisplayNumber(), objT.getCardDisplayNumber()))
      return false;
    if (! SmartEquals(getCreditCardTransactions(), objT.getCreditCardTransactions()))
      return false;
    return true;
  }			
}
