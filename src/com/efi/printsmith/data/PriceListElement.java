package com.efi.printsmith.data;

import java.util.Date;
import java.util.List;

import com.efi.printsmith.data.*;
import com.efi.printsmith.data.enums.*;
import com.efi.printsmith.exceptions.*;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
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
	@NamedQuery(name = "PriceListElement.findall", query = "from PriceListElement"),
	@NamedQuery(name = "PriceListElement.byId", query = "select a from PriceListElement a where a.id= :id")
})


@Entity
@Table(name = "pricelistelement")
public class PriceListElement extends ModelBase {
	/**
	 * @generated
	 */
	public static final String QUANTITY = "Quantity";
	/**
	 * @generated
	 */
	public static final String AMOUNT = "Amount";
	/**
	 * @generated
	 */
	public static final String IGNOREPRICEADJUSTMENTS = "IgnorePriceAdjustments";
	/**
	 * @generated
	 */
	public static final String ISDISCOUNT = "IsDiscount";
	/**
	 * @generated
	 */
	public static final String ISRATE = "IsRate";
	/**
	 * @generated
	 */
	public static final String INTERPOLATE = "Interpolate";
	/**
	 * @generated
	 */
	public static final String ISDOLLAR = "IsDollar";
	/**
	 * @generated
	 */
	public static final String FILLALL = "FillAll";
	/**
	 * @generated
	 */
	public static final String SEQUENCE = "Sequence";
	/**
	 * @generated
	 */
	public static final String ISPERCENT = "IsPercent";
	/**
	 * @generated
	 */
	public static final String DOADDITIONALQTY = "DoAdditionalQty";

	/**
	 * @generated
	 */
	public PriceListElement() {
	}

 	
	
 	@Basic
	private Long quantity;
	/**
	 * @generated
 	 */
	public Long getQuantity(){
		return quantity; 
	}

	/**
	 * @generated
	 */	
	public void setQuantity(Long newVal) {
		this.quantity = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Boolean ignorePriceAdjustments;
	/**
	 * @generated
 	 */
	public Boolean getIgnorePriceAdjustments(){
		return ignorePriceAdjustments; 
	}

	/**
	 * @generated
	 */	
	public void setIgnorePriceAdjustments(Boolean newVal) {
		this.ignorePriceAdjustments = newVal;
	}
 	
	
 	@Basic
	private Boolean isDiscount;
	/**
	 * @generated
 	 */
	public Boolean getIsDiscount(){
		return isDiscount; 
	}

	/**
	 * @generated
	 */	
	public void setIsDiscount(Boolean newVal) {
		this.isDiscount = newVal;
	}
 	
	
 	@Basic
	private Boolean isRate;
	/**
	 * @generated
 	 */
	public Boolean getIsRate(){
		return isRate; 
	}

	/**
	 * @generated
	 */	
	public void setIsRate(Boolean newVal) {
		this.isRate = newVal;
	}
 	
	
 	@Basic
	private Boolean interpolate;
	/**
	 * @generated
 	 */
	public Boolean getInterpolate(){
		return interpolate; 
	}

	/**
	 * @generated
	 */	
	public void setInterpolate(Boolean newVal) {
		this.interpolate = newVal;
	}
 	
	
 	@Basic
	private Boolean isDollar;
	/**
	 * @generated
 	 */
	public Boolean getIsDollar(){
		return isDollar; 
	}

	/**
	 * @generated
	 */	
	public void setIsDollar(Boolean newVal) {
		this.isDollar = newVal;
	}
 	
	
 	@Basic
	private Boolean fillAll;
	/**
	 * @generated
 	 */
	public Boolean getFillAll(){
		return fillAll; 
	}

	/**
	 * @generated
	 */	
	public void setFillAll(Boolean newVal) {
		this.fillAll = newVal;
	}
 	
	
 	@Basic
	private Boolean sequence;
	/**
	 * @generated
 	 */
	public Boolean getSequence(){
		return sequence; 
	}

	/**
	 * @generated
	 */	
	public void setSequence(Boolean newVal) {
		this.sequence = newVal;
	}
 	
	
 	@Basic
	private Boolean isPercent;
	/**
	 * @generated
 	 */
	public Boolean getIsPercent(){
		return isPercent; 
	}

	/**
	 * @generated
	 */	
	public void setIsPercent(Boolean newVal) {
		this.isPercent = newVal;
	}
 	
	
 	@Basic
	private Boolean doAdditionalQty;
	/**
	 * @generated
 	 */
	public Boolean getDoAdditionalQty(){
		return doAdditionalQty; 
	}

	/**
	 * @generated
	 */	
	public void setDoAdditionalQty(Boolean newVal) {
		this.doAdditionalQty = newVal;
	}

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (QUANTITY.equals(propertyName)) return getQuantity();
		if (AMOUNT.equals(propertyName)) return getAmount();
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return getIgnorePriceAdjustments();
		if (ISDISCOUNT.equals(propertyName)) return getIsDiscount();
		if (ISRATE.equals(propertyName)) return getIsRate();
		if (INTERPOLATE.equals(propertyName)) return getInterpolate();
		if (ISDOLLAR.equals(propertyName)) return getIsDollar();
		if (FILLALL.equals(propertyName)) return getFillAll();
		if (SEQUENCE.equals(propertyName)) return getSequence();
		if (ISPERCENT.equals(propertyName)) return getIsPercent();
		if (DOADDITIONALQTY.equals(propertyName)) return getDoAdditionalQty();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (QUANTITY.equals(propertyName)) setQuantity((Long)newValue); else
		if (AMOUNT.equals(propertyName)) setAmount((Double)newValue); else
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) setIgnorePriceAdjustments((Boolean)newValue); else
		if (ISDISCOUNT.equals(propertyName)) setIsDiscount((Boolean)newValue); else
		if (ISRATE.equals(propertyName)) setIsRate((Boolean)newValue); else
		if (INTERPOLATE.equals(propertyName)) setInterpolate((Boolean)newValue); else
		if (ISDOLLAR.equals(propertyName)) setIsDollar((Boolean)newValue); else
		if (FILLALL.equals(propertyName)) setFillAll((Boolean)newValue); else
		if (SEQUENCE.equals(propertyName)) setSequence((Boolean)newValue); else
		if (ISPERCENT.equals(propertyName)) setIsPercent((Boolean)newValue); else
		if (DOADDITIONALQTY.equals(propertyName)) setDoAdditionalQty((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (AMOUNT.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISDISCOUNT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISRATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INTERPOLATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISDOLLAR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (FILLALL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SEQUENCE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISPERCENT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DOADDITIONALQTY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (QUANTITY.equals(propertyName)) return PriceListElement.class;
		if (AMOUNT.equals(propertyName)) return PriceListElement.class;
		if (IGNOREPRICEADJUSTMENTS.equals(propertyName)) return PriceListElement.class;
		if (ISDISCOUNT.equals(propertyName)) return PriceListElement.class;
		if (ISRATE.equals(propertyName)) return PriceListElement.class;
		if (INTERPOLATE.equals(propertyName)) return PriceListElement.class;
		if (ISDOLLAR.equals(propertyName)) return PriceListElement.class;
		if (FILLALL.equals(propertyName)) return PriceListElement.class;
		if (SEQUENCE.equals(propertyName)) return PriceListElement.class;
		if (ISPERCENT.equals(propertyName)) return PriceListElement.class;
		if (DOADDITIONALQTY.equals(propertyName)) return PriceListElement.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PriceListElement objT = (PriceListElement)obj;
		if (! SmartEquals(getQuantity(), objT.getQuantity()))
			return false;
		if (! SmartEquals(getAmount(), objT.getAmount()))
			return false;
		if (! SmartEquals(getIgnorePriceAdjustments(), objT.getIgnorePriceAdjustments()))
			return false;
		if (! SmartEquals(getIsDiscount(), objT.getIsDiscount()))
			return false;
		if (! SmartEquals(getIsRate(), objT.getIsRate()))
			return false;
		if (! SmartEquals(getInterpolate(), objT.getInterpolate()))
			return false;
		if (! SmartEquals(getIsDollar(), objT.getIsDollar()))
			return false;
		if (! SmartEquals(getFillAll(), objT.getFillAll()))
			return false;
		if (! SmartEquals(getSequence(), objT.getSequence()))
			return false;
		if (! SmartEquals(getIsPercent(), objT.getIsPercent()))
			return false;
		if (! SmartEquals(getDoAdditionalQty(), objT.getDoAdditionalQty()))
			return false;
		return true;
	}			
}