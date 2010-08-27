
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
  @NamedQuery(name = "TimeCard.findall", query = "from TimeCard"),
  @NamedQuery(name = "TimeCard.byId", query = "select a from TimeCard a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "timecard")
@SQLDelete(sql="update modelbase set isdeleted='TRUE' from timecard where modelbase.id=?")
@Where(clause="isdeleted <> 'TRUE'")
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
	public static final String BREAKHOUR = "BreakHour";
	/**
	 * @generated
	 */
	public static final String PAIDTIMEOFF = "PaidTimeOff";

	/**
	 * @generated
	 */
	public TimeCard() {
    this.created = new Date();
    this.modified = new Date();
    this.isDeleted = false;
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer period;
	
	/**
	 * @generated
 	 */
	public Integer getPeriod(){
    return period; 
  }

	
	/**
	 * @generated
	 */	
	public void setPeriod(Integer newVal) {
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
    @ManyToOne()
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
 	@Basic
	private String breakHour;
	
	/**
	 * @generated
 	 */
	public String getBreakHour(){
    return breakHour; 
  }

	
	/**
	 * @generated
	 */	
	public void setBreakHour(String newVal) {
    this.breakHour = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean paidTimeOff;
	
	/**
	 * @generated
 	 */
	public Boolean getPaidTimeOff(){
    return paidTimeOff; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaidTimeOff(Boolean newVal) {
    this.paidTimeOff = newVal;
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
    if (BREAKHOUR.equals(propertyName)) return getBreakHour();
    if (PAIDTIMEOFF.equals(propertyName)) return getPaidTimeOff();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (PERIOD.equals(propertyName)) setPeriod((Integer)newValue); else
    if (STARTDATETIME.equals(propertyName)) setStartDateTime((Date)newValue); else
    if (ENDDATETIME.equals(propertyName)) setEndDateTime((Date)newValue); else
    if (BILLABLE.equals(propertyName)) setBillable((String)newValue); else
    if (ONCLOCK.equals(propertyName)) setOnClock((Integer)newValue); else
    if (BREAKTIME.equals(propertyName)) setBreakTime((Date)newValue); else
    if (EMPLOYEE.equals(propertyName)) setEmployee((Employee)newValue); else
    if (BREAKHOUR.equals(propertyName)) setBreakHour((String)newValue); else
    if (PAIDTIMEOFF.equals(propertyName)) setPaidTimeOff((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (PERIOD.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
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
    if (BREAKHOUR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PAIDTIMEOFF.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
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
    if (BREAKHOUR.equals(propertyName)) return TimeCard.class;
    if (PAIDTIMEOFF.equals(propertyName)) return TimeCard.class;
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
    if (! SmartEquals(getBreakHour(), objT.getBreakHour()))
      return false;
    if (! SmartEquals(getPaidTimeOff(), objT.getPaidTimeOff()))
      return false;
    return true;
  }			
}
