
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
  @NamedQuery(name = "CreditCard.findall", query = "from CreditCard"),
  @NamedQuery(name = "CreditCard.byId", query = "select a from CreditCard a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "creditcard")
@SQLDelete(sql="update creditcard set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
  public static final String ACCOUNTNUMBER = "AccountNumber";
	/**
   * @generated
   */
  public static final String ZIPCODE = "ZipCode";
	/**
   * @generated
   */
  public static final String ADDRESS1 = "Address1";
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
  public static final String PERMANENT = "Permanent";
	/**
	 * @generated
	 */
	public CreditCard() {
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
 	@Basic
  private Long accountNumber;
	/**
   * @generated
 	 */
  public Long getAccountNumber(){
    return accountNumber; 
  }


	/**
   * @generated
   */	
  public void setAccountNumber(Long newVal) {
    this.accountNumber = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String zipCode;
	/**
   * @generated
 	 */
  public String getZipCode(){
    return zipCode; 
  }


	/**
   * @generated
   */	
  public void setZipCode(String newVal) {
    this.zipCode = newVal;
  }



	/**
   * @generated
   */	
 	@Basic
  private String address1;
	/**
   * @generated
 	 */
  public String getAddress1(){
    return address1; 
  }


	/**
   * @generated
   */	
  public void setAddress1(String newVal) {
    this.address1 = newVal;
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
 	@Basic
  private Integer permanent;
	/**
   * @generated
 	 */
  public Integer getPermanent(){
    return permanent; 
  }


	/**
   * @generated
   */	
  public void setPermanent(Integer newVal) {
    this.permanent = newVal;
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
    if (ACCOUNTNUMBER.equals(propertyName)) return getAccountNumber();
    if (ZIPCODE.equals(propertyName)) return getZipCode();
    if (ADDRESS1.equals(propertyName)) return getAddress1();
    if (CREDITCARDID.equals(propertyName)) return getCreditCardID();
    if (TYPE.equals(propertyName)) return getType();
    if (ENCRYPTION.equals(propertyName)) return getEncryption();
    if (CARDDISPLAYNUMBER.equals(propertyName)) return getCardDisplayNumber();
    if (PERMANENT.equals(propertyName)) return getPermanent();
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
    if (ACCOUNTNUMBER.equals(propertyName)) setAccountNumber((Long)newValue); else
    if (ZIPCODE.equals(propertyName)) setZipCode((String)newValue); else
    if (ADDRESS1.equals(propertyName)) setAddress1((String)newValue); else
    if (CREDITCARDID.equals(propertyName)) setCreditCardID((String)newValue); else
    if (TYPE.equals(propertyName)) setType((String)newValue); else
    if (ENCRYPTION.equals(propertyName)) setEncryption((String)newValue); else
    if (CARDDISPLAYNUMBER.equals(propertyName)) setCardDisplayNumber((String)newValue); else
    if (PERMANENT.equals(propertyName)) setPermanent((Integer)newValue); else
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
    if (ACCOUNTNUMBER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ZIPCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ADDRESS1.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CREDITCARDID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ENCRYPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CARDDISPLAYNUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PERMANENT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
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
    if (ACCOUNTNUMBER.equals(propertyName)) return CreditCard.class;
    if (ZIPCODE.equals(propertyName)) return CreditCard.class;
    if (ADDRESS1.equals(propertyName)) return CreditCard.class;
    if (CREDITCARDID.equals(propertyName)) return CreditCard.class;
    if (TYPE.equals(propertyName)) return CreditCard.class;
    if (ENCRYPTION.equals(propertyName)) return CreditCard.class;
    if (CARDDISPLAYNUMBER.equals(propertyName)) return CreditCard.class;
    if (PERMANENT.equals(propertyName)) return CreditCard.class;
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
    if (! SmartEquals(getAccountNumber(), objT.getAccountNumber()))
      return false;
    if (! SmartEquals(getZipCode(), objT.getZipCode()))
      return false;
    if (! SmartEquals(getAddress1(), objT.getAddress1()))
      return false;
    if (! SmartEquals(getCreditCardID(), objT.getCreditCardID()))
      return false;
    if (! SmartEquals(getType(), objT.getType()))
      return false;
    if (! SmartEquals(getEncryption(), objT.getEncryption()))
      return false;
    if (! SmartEquals(getCardDisplayNumber(), objT.getCardDisplayNumber()))
      return false;
    if (! SmartEquals(getPermanent(), objT.getPermanent()))
      return false;
    return true;
  }			
}
