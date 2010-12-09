
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
  @NamedQuery(name = "PreferencesSequenceValues.findall", query = "from PreferencesSequenceValues"),
  @NamedQuery(name = "PreferencesSequenceValues.byId", query = "select a from PreferencesSequenceValues a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencessequencevalues")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from preferencessequencevalues where modelbase.id=?")
@SQLDelete(sql="update preferencessequencevalues set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class PreferencesSequenceValues extends ModelBase {
	/**
	 * @generated
	 */
	public static final String INVOICE = "Invoice";
	/**
	 * @generated
	 */
	public static final String JOB = "Job";
	/**
	 * @generated
	 */
	public static final String PRESSDEFINITION = "PressDefinition";
	/**
	 * @generated
	 */
	public static final String CHARGEDEFINITION = "ChargeDefinition";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String STOCKDEFINITION = "StockDefinition";
	/**
	 * @generated
	 */
	public static final String EMPLOYEE = "Employee";
	/**
	 * @generated
	 */
	public static final String BROKER = "Broker";
	/**
	 * @generated
	 */
	public static final String COPIERDEFINITION = "CopierDefinition";
	/**
	 * @generated
	 */
	public static final String CAMPAIGN = "Campaign";
	/**
	 * @generated
	 */
	public static final String GRADE = "Grade";
	/**
	 * @generated
	 */
	public static final String CREDITCARD = "CreditCard";
	/**
	 * @generated
	 */
	public static final String ESTIMATE = "Estimate";
	/**
	 * @generated
	 */
	public static final String STOCKORDER = "StockOrder";

	/**
   * @generated
   */
  public static final String DELIVERYTICKET = "DeliveryTicket";

	/**

   * @generated

   */

  public static final String CHARGE = "Charge";

	/**
	 * @generated
	 */
	public PreferencesSequenceValues() {
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
	private Long invoice;
	
	/**
	 * @generated
 	 */
	public Long getInvoice(){
    return invoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setInvoice(Long newVal) {
    this.invoice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long job;
	
	/**
	 * @generated
 	 */
	public Long getJob(){
    return job; 
  }

	
	/**
	 * @generated
	 */	
	public void setJob(Long newVal) {
    this.job = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long pressDefinition;
	
	/**
	 * @generated
 	 */
	public Long getPressDefinition(){
    return pressDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setPressDefinition(Long newVal) {
    this.pressDefinition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long chargeDefinition;
	
	/**
	 * @generated
 	 */
	public Long getChargeDefinition(){
    return chargeDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setChargeDefinition(Long newVal) {
    this.chargeDefinition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long account;
	
	/**
	 * @generated
 	 */
	public Long getAccount(){
    return account; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccount(Long newVal) {
    this.account = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long contact;
	
	/**
	 * @generated
 	 */
	public Long getContact(){
    return contact; 
  }

	
	/**
	 * @generated
	 */	
	public void setContact(Long newVal) {
    this.contact = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long stockDefinition;
	
	/**
	 * @generated
 	 */
	public Long getStockDefinition(){
    return stockDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockDefinition(Long newVal) {
    this.stockDefinition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long employee;
	
	/**
	 * @generated
 	 */
	public Long getEmployee(){
    return employee; 
  }

	
	/**
	 * @generated
	 */	
	public void setEmployee(Long newVal) {
    this.employee = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long broker;
	
	/**
	 * @generated
 	 */
	public Long getBroker(){
    return broker; 
  }

	
	/**
	 * @generated
	 */	
	public void setBroker(Long newVal) {
    this.broker = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long copierDefinition;
	
	/**
	 * @generated
 	 */
	public Long getCopierDefinition(){
    return copierDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setCopierDefinition(Long newVal) {
    this.copierDefinition = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long campaign;
	
	/**
	 * @generated
 	 */
	public Long getCampaign(){
    return campaign; 
  }

	
	/**
	 * @generated
	 */	
	public void setCampaign(Long newVal) {
    this.campaign = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long grade;
	
	/**
	 * @generated
 	 */
	public Long getGrade(){
    return grade; 
  }

	
	/**
	 * @generated
	 */	
	public void setGrade(Long newVal) {
    this.grade = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long creditCard;
	
	/**
	 * @generated
 	 */
	public Long getCreditCard(){
    return creditCard; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCard(Long newVal) {
    this.creditCard = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long estimate;
	
	/**
	 * @generated
 	 */
	public Long getEstimate(){
    return estimate; 
  }

	
	/**
	 * @generated
	 */	
	public void setEstimate(Long newVal) {
    this.estimate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long stockOrder;
	
	/**
	 * @generated
 	 */
	public Long getStockOrder(){
    return stockOrder; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockOrder(Long newVal) {
    this.stockOrder = newVal;
  }
	
	/**
   * @generated
   */	
 	@Basic
  private Long deliveryTicket;

	/**
   * @generated
 	 */
  public Long getDeliveryTicket(){
    return deliveryTicket; 
  }

	/**
   * @generated
   */	
  public void setDeliveryTicket(Long newVal) {
    this.deliveryTicket = newVal;
  }

	/**

   * @generated

   */	

 	@Basic

  private Long charge;

	/**

   * @generated

 	 */

  public Long getCharge(){
    return charge; 
  }

	/**

   * @generated

   */	

  public void setCharge(Long newVal) {
    this.charge = newVal;
  }

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (INVOICE.equals(propertyName)) return getInvoice();
    if (JOB.equals(propertyName)) return getJob();
    if (PRESSDEFINITION.equals(propertyName)) return getPressDefinition();
    if (CHARGEDEFINITION.equals(propertyName)) return getChargeDefinition();
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (CONTACT.equals(propertyName)) return getContact();
    if (STOCKDEFINITION.equals(propertyName)) return getStockDefinition();
    if (EMPLOYEE.equals(propertyName)) return getEmployee();
    if (BROKER.equals(propertyName)) return getBroker();
    if (COPIERDEFINITION.equals(propertyName)) return getCopierDefinition();
    if (CAMPAIGN.equals(propertyName)) return getCampaign();
    if (GRADE.equals(propertyName)) return getGrade();
    if (CREDITCARD.equals(propertyName)) return getCreditCard();
    if (ESTIMATE.equals(propertyName)) return getEstimate();
    if (STOCKORDER.equals(propertyName)) return getStockOrder();
    if (DELIVERYTICKET.equals(propertyName)) return getDeliveryTicket();
    if (CHARGE.equals(propertyName)) return getCharge();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (INVOICE.equals(propertyName)) setInvoice((Long)newValue); else
    if (JOB.equals(propertyName)) setJob((Long)newValue); else
    if (PRESSDEFINITION.equals(propertyName)) setPressDefinition((Long)newValue); else
    if (CHARGEDEFINITION.equals(propertyName)) setChargeDefinition((Long)newValue); else
    if (ACCOUNT.equals(propertyName)) setAccount((Long)newValue); else
    if (CONTACT.equals(propertyName)) setContact((Long)newValue); else
    if (STOCKDEFINITION.equals(propertyName)) setStockDefinition((Long)newValue); else
    if (EMPLOYEE.equals(propertyName)) setEmployee((Long)newValue); else
    if (BROKER.equals(propertyName)) setBroker((Long)newValue); else
    if (COPIERDEFINITION.equals(propertyName)) setCopierDefinition((Long)newValue); else
    if (CAMPAIGN.equals(propertyName)) setCampaign((Long)newValue); else
    if (GRADE.equals(propertyName)) setGrade((Long)newValue); else
    if (CREDITCARD.equals(propertyName)) setCreditCard((Long)newValue); else
    if (ESTIMATE.equals(propertyName)) setEstimate((Long)newValue); else
    if (STOCKORDER.equals(propertyName)) setStockOrder((Long)newValue); else
    if (DELIVERYTICKET.equals(propertyName)) setDeliveryTicket((Long)newValue); else
    if (CHARGE.equals(propertyName)) setCharge((Long)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (INVOICE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (JOB.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PRESSDEFINITION.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CHARGEDEFINITION.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CONTACT.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (STOCKDEFINITION.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (EMPLOYEE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (BROKER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (COPIERDEFINITION.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CAMPAIGN.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (GRADE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CREDITCARD.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (ESTIMATE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (STOCKORDER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (DELIVERYTICKET.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (CHARGE.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (INVOICE.equals(propertyName)) return PreferencesSequenceValues.class;
    if (JOB.equals(propertyName)) return PreferencesSequenceValues.class;
    if (PRESSDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
    if (CHARGEDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
    if (ACCOUNT.equals(propertyName)) return PreferencesSequenceValues.class;
    if (CONTACT.equals(propertyName)) return PreferencesSequenceValues.class;
    if (STOCKDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
    if (EMPLOYEE.equals(propertyName)) return PreferencesSequenceValues.class;
    if (BROKER.equals(propertyName)) return PreferencesSequenceValues.class;
    if (COPIERDEFINITION.equals(propertyName)) return PreferencesSequenceValues.class;
    if (CAMPAIGN.equals(propertyName)) return PreferencesSequenceValues.class;
    if (GRADE.equals(propertyName)) return PreferencesSequenceValues.class;
    if (CREDITCARD.equals(propertyName)) return PreferencesSequenceValues.class;
    if (ESTIMATE.equals(propertyName)) return PreferencesSequenceValues.class;
    if (STOCKORDER.equals(propertyName)) return PreferencesSequenceValues.class;
    if (DELIVERYTICKET.equals(propertyName)) return PreferencesSequenceValues.class;
    if (CHARGE.equals(propertyName)) return PreferencesSequenceValues.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesSequenceValues objT = (PreferencesSequenceValues)obj;
    if (! SmartEquals(getInvoice(), objT.getInvoice()))
      return false;
    if (! SmartEquals(getJob(), objT.getJob()))
      return false;
    if (! SmartEquals(getPressDefinition(), objT.getPressDefinition()))
      return false;
    if (! SmartEquals(getChargeDefinition(), objT.getChargeDefinition()))
      return false;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getContact(), objT.getContact()))
      return false;
    if (! SmartEquals(getStockDefinition(), objT.getStockDefinition()))
      return false;
    if (! SmartEquals(getEmployee(), objT.getEmployee()))
      return false;
    if (! SmartEquals(getBroker(), objT.getBroker()))
      return false;
    if (! SmartEquals(getCopierDefinition(), objT.getCopierDefinition()))
      return false;
    if (! SmartEquals(getCampaign(), objT.getCampaign()))
      return false;
    if (! SmartEquals(getGrade(), objT.getGrade()))
      return false;
    if (! SmartEquals(getCreditCard(), objT.getCreditCard()))
      return false;
    if (! SmartEquals(getEstimate(), objT.getEstimate()))
      return false;
    if (! SmartEquals(getStockOrder(), objT.getStockOrder()))
      return false;
    if (! SmartEquals(getDeliveryTicket(), objT.getDeliveryTicket()))
      return false;
    if (! SmartEquals(getCharge(), objT.getCharge()))
      return false;
    return true;
  }			
}
