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
 * @!generated
 */	
@NamedQueries({
	@NamedQuery(name = "StockChanges.findall", query = "from StockChanges"),
	@NamedQuery(name = "StockChanges.byId", query = "select a from StockChanges a where a.id= :id")
})


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
	public static final String USER = "User";
	/**
	 * @generated
	 */
	public static final String DATE = "Date";
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
 	
	
 	@Basic
	private String user;
	
	/**
	 * @generated
 	 */
	public String getUser(){
		return user; 
	}

	/**
	 * @generated
	 */	
	public void setUser(String newVal) {
		this.user = newVal;
	}
 	
	
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
 	
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
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
		if (USER.equals(propertyName)) return getUser();
		if (DATE.equals(propertyName)) return getDate();
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
		if (USER.equals(propertyName)) setUser((String)newValue); else
		if (DATE.equals(propertyName)) setDate((Date)newValue); else
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
		if (USER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DATE.equals(propertyName)) 
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
		if (USER.equals(propertyName)) return StockChanges.class;
		if (DATE.equals(propertyName)) return StockChanges.class;
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
		if (! SmartEquals(getUser(), objT.getUser()))
			return false;
		if (! SmartEquals(getDate(), objT.getDate()))
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