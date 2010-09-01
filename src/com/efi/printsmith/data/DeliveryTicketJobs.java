
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
  @NamedQuery(name = "DeliveryTicketJobs.findall", query = "from DeliveryTicketJobs"),
  @NamedQuery(name = "DeliveryTicketJobs.byId", query = "select a from DeliveryTicketJobs a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "deliveryticketjobs")
@SQLDelete(sql="update deliveryticketjobs set isdeleted='TRUE' where id=?")
@Where(clause="isdeleted <> 'TRUE'")
public class DeliveryTicketJobs extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBER = "OrderNumber";
	/**
	 * @generated
	 */
	public static final String DOCUMENTTYPE = "DocumentType";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String JOBNUMBER = "JobNumber";
	/**
	 * @generated
	 */
	public static final String LINENUMBER = "LineNumber";
	/**
	 * @generated
	 */
	public static final String QTYORDER = "QtyOrder";
	/**
	 * @generated
	 */
	public static final String QTYSHIPPED = "QtyShipped";
	/**
	 * @generated
	 */
	public static final String WEIGHT = "Weight";
	/**
	 * @generated
	 */
	public static final String COMPLETED = "Completed";
	/**
	 * @generated
	 */
	public static final String MANUALNONINVOICEITEM = "ManualNonInvoiceItem";
	/**
	 * @generated
	 */
	public static final String PARENTDELIVERYTICKET = "ParentDeliveryTicket";

	/**
	 * @generated
	 */
	public DeliveryTicketJobs() {
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
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private Account account;
	
	/**
	 * @generated
 	 */
	public Account getAccount(){
    return account; 
  }

	
	/**
	 * @generated
	 */	
	public void setAccount(Account newVal) {
    this.account = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer orderNumber;
	
	/**
	 * @generated
 	 */
	public Integer getOrderNumber(){
    return orderNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setOrderNumber(Integer newVal) {
    this.orderNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String documentType;
	
	/**
	 * @generated
 	 */
	public String getDocumentType(){
    return documentType; 
  }

	
	/**
	 * @generated
	 */	
	public void setDocumentType(String newVal) {
    this.documentType = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
    return description; 
  }

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
    this.description = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long jobNumber;
	
	/**
	 * @generated
 	 */
	public Long getJobNumber(){
    return jobNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setJobNumber(Long newVal) {
    this.jobNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer lineNumber;
	
	/**
	 * @generated
 	 */
	public Integer getLineNumber(){
    return lineNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setLineNumber(Integer newVal) {
    this.lineNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtyOrder;
	
	/**
	 * @generated
 	 */
	public Integer getQtyOrder(){
    return qtyOrder; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtyOrder(Integer newVal) {
    this.qtyOrder = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer qtyShipped;
	
	/**
	 * @generated
 	 */
	public Integer getQtyShipped(){
    return qtyShipped; 
  }

	
	/**
	 * @generated
	 */	
	public void setQtyShipped(Integer newVal) {
    this.qtyShipped = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double weight;
	
	/**
	 * @generated
 	 */
	public Double getWeight(){
    return weight; 
  }

	
	/**
	 * @generated
	 */	
	public void setWeight(Double newVal) {
    this.weight = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean completed;
	
	/**
	 * @generated
 	 */
	public Boolean getCompleted(){
    return completed; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompleted(Boolean newVal) {
    this.completed = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean manualNonInvoiceItem;
	
	/**
	 * @generated
 	 */
	public Boolean getManualNonInvoiceItem(){
    return manualNonInvoiceItem; 
  }

	
	/**
	 * @generated
	 */	
	public void setManualNonInvoiceItem(Boolean newVal) {
    this.manualNonInvoiceItem = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	@Where(clause="isdeleted <> 'TRUE'")
	private DeliveryTicket parentDeliveryTicket;
	
	/**
	 * @generated
 	 */
	public DeliveryTicket getParentDeliveryTicket(){
    return parentDeliveryTicket; 
  }

	
	/**
	 * @generated
	 */	
	public void setParentDeliveryTicket(DeliveryTicket newVal) {
    this.parentDeliveryTicket = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ACCOUNT.equals(propertyName)) return getAccount();
    if (ORDERNUMBER.equals(propertyName)) return getOrderNumber();
    if (DOCUMENTTYPE.equals(propertyName)) return getDocumentType();
    if (DESCRIPTION.equals(propertyName)) return getDescription();
    if (JOBNUMBER.equals(propertyName)) return getJobNumber();
    if (LINENUMBER.equals(propertyName)) return getLineNumber();
    if (QTYORDER.equals(propertyName)) return getQtyOrder();
    if (QTYSHIPPED.equals(propertyName)) return getQtyShipped();
    if (WEIGHT.equals(propertyName)) return getWeight();
    if (COMPLETED.equals(propertyName)) return getCompleted();
    if (MANUALNONINVOICEITEM.equals(propertyName)) return getManualNonInvoiceItem();
    if (PARENTDELIVERYTICKET.equals(propertyName)) return getParentDeliveryTicket();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
    if (ORDERNUMBER.equals(propertyName)) setOrderNumber((Integer)newValue); else
    if (DOCUMENTTYPE.equals(propertyName)) setDocumentType((String)newValue); else
    if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
    if (JOBNUMBER.equals(propertyName)) setJobNumber((Long)newValue); else
    if (LINENUMBER.equals(propertyName)) setLineNumber((Integer)newValue); else
    if (QTYORDER.equals(propertyName)) setQtyOrder((Integer)newValue); else
    if (QTYSHIPPED.equals(propertyName)) setQtyShipped((Integer)newValue); else
    if (WEIGHT.equals(propertyName)) setWeight((Double)newValue); else
    if (COMPLETED.equals(propertyName)) setCompleted((Boolean)newValue); else
    if (MANUALNONINVOICEITEM.equals(propertyName)) setManualNonInvoiceItem((Boolean)newValue); else
    if (PARENTDELIVERYTICKET.equals(propertyName)) setParentDeliveryTicket((DeliveryTicket)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ACCOUNT.equals(propertyName)) 
      return new Class<?>[] {Account.class};		
    if (ORDERNUMBER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (DOCUMENTTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DESCRIPTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (JOBNUMBER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (LINENUMBER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYORDER.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (QTYSHIPPED.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (WEIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COMPLETED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MANUALNONINVOICEITEM.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PARENTDELIVERYTICKET.equals(propertyName)) 
      return new Class<?>[] {DeliveryTicket.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ACCOUNT.equals(propertyName)) return DeliveryTicketJobs.class;
    if (ORDERNUMBER.equals(propertyName)) return DeliveryTicketJobs.class;
    if (DOCUMENTTYPE.equals(propertyName)) return DeliveryTicketJobs.class;
    if (DESCRIPTION.equals(propertyName)) return DeliveryTicketJobs.class;
    if (JOBNUMBER.equals(propertyName)) return DeliveryTicketJobs.class;
    if (LINENUMBER.equals(propertyName)) return DeliveryTicketJobs.class;
    if (QTYORDER.equals(propertyName)) return DeliveryTicketJobs.class;
    if (QTYSHIPPED.equals(propertyName)) return DeliveryTicketJobs.class;
    if (WEIGHT.equals(propertyName)) return DeliveryTicketJobs.class;
    if (COMPLETED.equals(propertyName)) return DeliveryTicketJobs.class;
    if (MANUALNONINVOICEITEM.equals(propertyName)) return DeliveryTicketJobs.class;
    if (PARENTDELIVERYTICKET.equals(propertyName)) return DeliveryTicketJobs.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    DeliveryTicketJobs objT = (DeliveryTicketJobs)obj;
    if (! SmartEquals(getAccount(), objT.getAccount()))
      return false;
    if (! SmartEquals(getOrderNumber(), objT.getOrderNumber()))
      return false;
    if (! SmartEquals(getDocumentType(), objT.getDocumentType()))
      return false;
    if (! SmartEquals(getDescription(), objT.getDescription()))
      return false;
    if (! SmartEquals(getJobNumber(), objT.getJobNumber()))
      return false;
    if (! SmartEquals(getLineNumber(), objT.getLineNumber()))
      return false;
    if (! SmartEquals(getQtyOrder(), objT.getQtyOrder()))
      return false;
    if (! SmartEquals(getQtyShipped(), objT.getQtyShipped()))
      return false;
    if (! SmartEquals(getWeight(), objT.getWeight()))
      return false;
    if (! SmartEquals(getCompleted(), objT.getCompleted()))
      return false;
    if (! SmartEquals(getManualNonInvoiceItem(), objT.getManualNonInvoiceItem()))
      return false;
    if (! SmartEquals(getParentDeliveryTicket(), objT.getParentDeliveryTicket()))
      return false;
    return true;
  }			
}
