
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
	@NamedQuery(name = "TimeCard.findall", query = "from TimeCard"),
	@NamedQuery(name = "TimeCard.byId", query = "select a from TimeCard a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "timecard")
public class TimeCard extends ModelBase {
	/**
	 * @generated
	 */
	public static final String PERIOD = "Period";
	/**
	 * @generated
	 */
	public static final String STARTDATETIME = "StartDateTime";
	/**
	 * @generated
	 */
	public static final String ENDDATETIME = "EndDateTime";
	/**
	 * @generated
	 */
	public static final String BILLABLE = "Billable";
	/**
	 * @generated
	 */
	public static final String ONCLOCK = "OnClock";
	/**
	 * @generated
	 */
	public static final String BREAKTIME = "BreakTime";
	/**
	 * @generated
	 */
	public static final String EMPLOYEE = "Employee";

	/**
	 * @generated
	 */
	public TimeCard() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String period;
	
	/**
	 * @generated
 	 */
	public String getPeriod(){
		return period; 
	}

	
	/**
	 * @generated
	 */	
	public void setPeriod(String newVal) {
		this.period = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date startDateTime;
	
	/**
	 * @generated
 	 */
	public Date getStartDateTime(){
		return startDateTime; 
	}

	
	/**
	 * @generated
	 */	
	public void setStartDateTime(Date newVal) {
		this.startDateTime = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date endDateTime;
	
	/**
	 * @generated
 	 */
	public Date getEndDateTime(){
		return endDateTime; 
	}

	
	/**
	 * @generated
	 */	
	public void setEndDateTime(Date newVal) {
		this.endDateTime = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String billable;
	
	/**
	 * @generated
 	 */
	public String getBillable(){
		return billable; 
	}

	
	/**
	 * @generated
	 */	
	public void setBillable(String newVal) {
		this.billable = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer onClock;
	
	/**
	 * @generated
 	 */
	public Integer getOnClock(){
		return onClock; 
	}

	
	/**
	 * @generated
	 */	
	public void setOnClock(Integer newVal) {
		this.onClock = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date breakTime;
	
	/**
	 * @generated
 	 */
	public Date getBreakTime(){
		return breakTime; 
	}

	
	/**
	 * @generated
	 */	
	public void setBreakTime(Date newVal) {
		this.breakTime = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne
	private Employee employee;
	
	/**
	 * @generated
 	 */
	public Employee getEmployee(){
		return employee; 
	}

	
	/**
	 * @generated
	 */	
	public void setEmployee(Employee newVal) {
		this.employee = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (PERIOD.equals(propertyName)) return getPeriod();
		if (STARTDATETIME.equals(propertyName)) return getStartDateTime();
		if (ENDDATETIME.equals(propertyName)) return getEndDateTime();
		if (BILLABLE.equals(propertyName)) return getBillable();
		if (ONCLOCK.equals(propertyName)) return getOnClock();
		if (BREAKTIME.equals(propertyName)) return getBreakTime();
		if (EMPLOYEE.equals(propertyName)) return getEmployee();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (PERIOD.equals(propertyName)) setPeriod((String)newValue); else
		if (STARTDATETIME.equals(propertyName)) setStartDateTime((Date)newValue); else
		if (ENDDATETIME.equals(propertyName)) setEndDateTime((Date)newValue); else
		if (BILLABLE.equals(propertyName)) setBillable((String)newValue); else
		if (ONCLOCK.equals(propertyName)) setOnClock((Integer)newValue); else
		if (BREAKTIME.equals(propertyName)) setBreakTime((Date)newValue); else
		if (EMPLOYEE.equals(propertyName)) setEmployee((Employee)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (PERIOD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STARTDATETIME.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (ENDDATETIME.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (BILLABLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ONCLOCK.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BREAKTIME.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (EMPLOYEE.equals(propertyName)) 
			return new Class<?>[] {Employee.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (PERIOD.equals(propertyName)) return TimeCard.class;
		if (STARTDATETIME.equals(propertyName)) return TimeCard.class;
		if (ENDDATETIME.equals(propertyName)) return TimeCard.class;
		if (BILLABLE.equals(propertyName)) return TimeCard.class;
		if (ONCLOCK.equals(propertyName)) return TimeCard.class;
		if (BREAKTIME.equals(propertyName)) return TimeCard.class;
		if (EMPLOYEE.equals(propertyName)) return TimeCard.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		TimeCard objT = (TimeCard)obj;
		if (! SmartEquals(getPeriod(), objT.getPeriod()))
			return false;
		if (! SmartEquals(getStartDateTime(), objT.getStartDateTime()))
			return false;
		if (! SmartEquals(getEndDateTime(), objT.getEndDateTime()))
			return false;
		if (! SmartEquals(getBillable(), objT.getBillable()))
			return false;
		if (! SmartEquals(getOnClock(), objT.getOnClock()))
			return false;
		if (! SmartEquals(getBreakTime(), objT.getBreakTime()))
			return false;
		if (! SmartEquals(getEmployee(), objT.getEmployee()))
			return false;
		return true;
	}			
}