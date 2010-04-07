
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
  @NamedQuery(name = "StockChanges.findall", query = "from StockChanges"),
  @NamedQuery(name = "StockChanges.byId", query = "select a from StockChanges a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "stockchanges")
public class StockChanges extends ModelBase {
	/**
	 * @generated
	 */
	public static final String STOCKCHANGEID = "StockChangeID";
	/**
	 * @generated
	 */
	public static final String PSUSER = "PSUser";
	/**
	 * @generated
	 */
	public static final String STOCKCHANGEDATE = "StockChangeDate";
	/**
	 * @generated
	 */
	public static final String HOWCHANGED = "HowChanged";
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String REFERENCE = "Reference";
	/**
	 * @generated
	 */
	public static final String STOCKDEFINITION = "StockDefinition";

	/**
	 * @generated
	 */
	public StockChanges() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long stockChangeID;
	
	/**
	 * @generated
 	 */
	public Long getStockChangeID(){
    return stockChangeID; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockChangeID(Long newVal) {
    this.stockChangeID = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String pSUser;
	
	/**
	 * @generated
 	 */
	public String getPSUser(){
    return pSUser; 
  }

	
	/**
	 * @generated
	 */	
	public void setPSUser(String newVal) {
    this.pSUser = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date stockChangeDate;
	
	/**
	 * @generated
 	 */
	public Date getStockChangeDate(){
    return stockChangeDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockChangeDate(Date newVal) {
    this.stockChangeDate = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String howChanged;
	
	/**
	 * @generated
 	 */
	public String getHowChanged(){
    return howChanged; 
  }

	
	/**
	 * @generated
	 */	
	public void setHowChanged(String newVal) {
    this.howChanged = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer quantity;
	
	/**
	 * @generated
 	 */
	public Integer getQuantity(){
    return quantity; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuantity(Integer newVal) {
    this.quantity = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String reference;
	
	/**
	 * @generated
 	 */
	public String getReference(){
    return reference; 
  }

	
	/**
	 * @generated
	 */	
	public void setReference(String newVal) {
    this.reference = newVal;
  }
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private StockDefinition stockDefinition;
	
	/**
	 * @generated
 	 */
	public StockDefinition getStockDefinition(){
    return stockDefinition; 
  }

	
	/**
	 * @generated
	 */	
	public void setStockDefinition(StockDefinition newVal) {
    this.stockDefinition = newVal;
  }
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (STOCKCHANGEID.equals(propertyName)) return getStockChangeID();
    if (PSUSER.equals(propertyName)) return getPSUser();
    if (STOCKCHANGEDATE.equals(propertyName)) return getStockChangeDate();
    if (HOWCHANGED.equals(propertyName)) return getHowChanged();
    if (QUANTITY.equals(propertyName)) return getQuantity();
    if (REFERENCE.equals(propertyName)) return getReference();
    if (STOCKDEFINITION.equals(propertyName)) return getStockDefinition();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (STOCKCHANGEID.equals(propertyName)) setStockChangeID((Long)newValue); else
    if (PSUSER.equals(propertyName)) setPSUser((String)newValue); else
    if (STOCKCHANGEDATE.equals(propertyName)) setStockChangeDate((Date)newValue); else
    if (HOWCHANGED.equals(propertyName)) setHowChanged((String)newValue); else
    if (QUANTITY.equals(propertyName)) setQuantity((Integer)newValue); else
    if (REFERENCE.equals(propertyName)) setReference((String)newValue); else
    if (STOCKDEFINITION.equals(propertyName)) setStockDefinition((StockDefinition)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (STOCKCHANGEID.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PSUSER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STOCKCHANGEDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (HOWCHANGED.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (QUANTITY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (REFERENCE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (STOCKDEFINITION.equals(propertyName)) 
      return new Class<?>[] {StockDefinition.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (STOCKCHANGEID.equals(propertyName)) return StockChanges.class;
    if (PSUSER.equals(propertyName)) return StockChanges.class;
    if (STOCKCHANGEDATE.equals(propertyName)) return StockChanges.class;
    if (HOWCHANGED.equals(propertyName)) return StockChanges.class;
    if (QUANTITY.equals(propertyName)) return StockChanges.class;
    if (REFERENCE.equals(propertyName)) return StockChanges.class;
    if (STOCKDEFINITION.equals(propertyName)) return StockChanges.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    StockChanges objT = (StockChanges)obj;
    if (! SmartEquals(getStockChangeID(), objT.getStockChangeID()))
      return false;
    if (! SmartEquals(getPSUser(), objT.getPSUser()))
      return false;
    if (! SmartEquals(getStockChangeDate(), objT.getStockChangeDate()))
      return false;
    if (! SmartEquals(getHowChanged(), objT.getHowChanged()))
      return false;
    if (! SmartEquals(getQuantity(), objT.getQuantity()))
      return false;
    if (! SmartEquals(getReference(), objT.getReference()))
      return false;
    if (! SmartEquals(getStockDefinition(), objT.getStockDefinition()))
      return false;
    return true;
  }			
}
