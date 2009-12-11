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
	@NamedQuery(name = "Period.findall", query = "from Period"),
	@NamedQuery(name = "Period.byId", query = "select a from Period a where a.id= :id")
})


@Entity
@Table(name = "period")
public class Period extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CUSTOMTODATE = "CustomtoDate";
	/**
	 * @generated
	 */
	public static final String CUSTOMFROMDATE = "CustomfromDate";
	/**
	 * @generated
	 */
	public static final String FROMDATE = "FromDate";
	/**
	 * @generated
	 */
	public static final String TODATE = "ToDate";
	/**
	 * @generated
	 */
	public static final String DAY = "Day";
	/**
	 * @generated
	 */
	public static final String TYPE = "Type";
	/**
	 * @generated
	 */
	public static final String PERIODNUMBER = "PeriodNumber";
	/**
	 * @generated
	 */
	public static final String PERIODCLOSED = "PeriodClosed";

	/**
	 * @generated
	 */
	public Period() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private Date customtoDate;
	/**
	 * @generated
 	 */
	public Date getCustomtoDate(){
		return customtoDate; 
	}

	/**
	 * @generated
	 */	
	public void setCustomtoDate(Date newVal) {
		this.customtoDate = newVal;
	}
 	
	
 	@Basic
	private Date customfromDate;
	/**
	 * @generated
 	 */
	public Date getCustomfromDate(){
		return customfromDate; 
	}

	/**
	 * @generated
	 */	
	public void setCustomfromDate(Date newVal) {
		this.customfromDate = newVal;
	}
 	
	
 	@Basic
	private Date fromDate;
	/**
	 * @generated
 	 */
	public Date getFromDate(){
		return fromDate; 
	}

	/**
	 * @generated
	 */	
	public void setFromDate(Date newVal) {
		this.fromDate = newVal;
	}
 	
	
 	@Basic
	private Date toDate;
	/**
	 * @generated
 	 */
	public Date getToDate(){
		return toDate; 
	}

	/**
	 * @generated
	 */	
	public void setToDate(Date newVal) {
		this.toDate = newVal;
	}
 	
	
 	@Basic
	private String day;
	/**
	 * @generated
 	 */
	public String getDay(){
		return day; 
	}

	/**
	 * @generated
	 */	
	public void setDay(String newVal) {
		this.day = newVal;
	}
 	
	
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
 	
	
 	@Basic
	private Integer periodNumber;
	/**
	 * @generated
 	 */
	public Integer getPeriodNumber(){
		return periodNumber; 
	}

	/**
	 * @generated
	 */	
	public void setPeriodNumber(Integer newVal) {
		this.periodNumber = newVal;
	}
 	
	
 	@Basic
	private Boolean periodClosed;
	/**
	 * @generated
 	 */
	public Boolean getPeriodClosed(){
		return periodClosed; 
	}

	/**
	 * @generated
	 */	
	public void setPeriodClosed(Boolean newVal) {
		this.periodClosed = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CUSTOMTODATE.equals(propertyName)) return getCustomtoDate();
		if (CUSTOMFROMDATE.equals(propertyName)) return getCustomfromDate();
		if (FROMDATE.equals(propertyName)) return getFromDate();
		if (TODATE.equals(propertyName)) return getToDate();
		if (DAY.equals(propertyName)) return getDay();
		if (TYPE.equals(propertyName)) return getType();
		if (PERIODNUMBER.equals(propertyName)) return getPeriodNumber();
		if (PERIODCLOSED.equals(propertyName)) return getPeriodClosed();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CUSTOMTODATE.equals(propertyName)) setCustomtoDate((Date)newValue); else
		if (CUSTOMFROMDATE.equals(propertyName)) setCustomfromDate((Date)newValue); else
		if (FROMDATE.equals(propertyName)) setFromDate((Date)newValue); else
		if (TODATE.equals(propertyName)) setToDate((Date)newValue); else
		if (DAY.equals(propertyName)) setDay((String)newValue); else
		if (TYPE.equals(propertyName)) setType((String)newValue); else
		if (PERIODNUMBER.equals(propertyName)) setPeriodNumber((Integer)newValue); else
		if (PERIODCLOSED.equals(propertyName)) setPeriodClosed((Boolean)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CUSTOMTODATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (CUSTOMFROMDATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (FROMDATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (TODATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (DAY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PERIODNUMBER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (PERIODCLOSED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CUSTOMTODATE.equals(propertyName)) return Period.class;
		if (CUSTOMFROMDATE.equals(propertyName)) return Period.class;
		if (FROMDATE.equals(propertyName)) return Period.class;
		if (TODATE.equals(propertyName)) return Period.class;
		if (DAY.equals(propertyName)) return Period.class;
		if (TYPE.equals(propertyName)) return Period.class;
		if (PERIODNUMBER.equals(propertyName)) return Period.class;
		if (PERIODCLOSED.equals(propertyName)) return Period.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Period objT = (Period)obj;
		if (! SmartEquals(getCustomtoDate(), objT.getCustomtoDate()))
			return false;
		if (! SmartEquals(getCustomfromDate(), objT.getCustomfromDate()))
			return false;
		if (! SmartEquals(getFromDate(), objT.getFromDate()))
			return false;
		if (! SmartEquals(getToDate(), objT.getToDate()))
			return false;
		if (! SmartEquals(getDay(), objT.getDay()))
			return false;
		if (! SmartEquals(getType(), objT.getType()))
			return false;
		if (! SmartEquals(getPeriodNumber(), objT.getPeriodNumber()))
			return false;
		if (! SmartEquals(getPeriodClosed(), objT.getPeriodClosed()))
			return false;
		return true;
	}			
}