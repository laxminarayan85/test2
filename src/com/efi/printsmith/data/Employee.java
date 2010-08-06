
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
import org.hibernate.annotations.Type;

/**
 * @generated
 */

 
/**
 * @generated
 */	
@NamedQueries({
  @NamedQuery(name = "Employee.findall", query = "from Employee"),
  @NamedQuery(name = "Employee.byId", query = "select a from Employee a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "employee")
public class Employee extends Party {
	/**
	 * @generated
	 */
	public static final String SOCIALSECURITY = "SocialSecurity";
	/**
	 * @generated
	 */
	public static final String EXPORTCODE = "ExportCode";
	/**
	 * @generated
	 */
	public static final String CLOCKIN = "ClockIn";
	/**
	 * @generated
	 */
	public static final String CLOCKOUT = "ClockOut";
	/**
	 * @generated
	 */
	public static final String CLOCKBREAK = "ClockBreak";
	/**
	 * @generated
	 */
	public static final String RATE = "Rate";
	/**
	 * @generated
	 */
	public static final String ACTIVE = "Active";
	/**
	 * @generated
	 */
	public static final String PINREQUIRED = "PinRequired";
	/**
	 * @generated
	 */
	public static final String PIN = "Pin";
	/**
	 * @generated
	 */
	public static final String ALLOWOVERRIDECOST = "AllowOverrideCost";
	/**
	 * @generated
	 */
	public static final String COSTINGAMOUNTS = "CostingAmounts";
	/**
	 * @generated
	 */
	public static final String HIDENONRELEASEPRODUCTION = "HideNonReleaseProduction";
	/**
	 * @generated
	 */
	public static final String HIDEESTIMATETIMETRACKER = "HideEstimateTimeTracker";
	/**
	 * @generated
	 */
	public static final String PRODUCTIONSETTINGS = "ProductionSettings";
	/**
	 * @generated
	 */
	public static final String TRACKERNEXTLOCATION = "TrackerNextLocation";
	/**
	 * @generated
	 */
	public static final String TRACKERCLOCKIN = "TrackerClockIn";
	/**
	 * @generated
	 */
	public static final String SHOWWORKCENTER = "ShowWorkCenter";
	/**
	 * @generated
	 */
	public static final String MAGCARDREADER = "MagCardReader";
	/**
	 * @generated
	 */
	public static final String INCLUDEINVOICE = "IncludeInvoice";
	/**
	 * @generated
	 */
	public static final String INCLUDEESTIMATE = "IncludeEstimate";
	/**
	 * @generated
	 */
	public static final String INCLUDEJOBS = "IncludeJobs";
	/**
	 * @generated
	 */
	public static final String INCLUDEJOBCHARGES = "IncludeJobCharges";
	/**
	 * @generated
	 */
	public static final String INCLUDEINVOICECHARGES = "IncludeInvoiceCharges";
	/**
	 * @generated
	 */
	public static final String ALLPRICINGMETHODS = "AllPricingMethods";
	/**
	 * @generated
	 */
	public static final String ALLPRESSES = "AllPresses";
	/**
	 * @generated
	 */
	public static final String ALLCOPIERS = "AllCopiers";
	/**
	 * @generated
	 */
	public static final String ALLCHARGETYPES = "AllChargeTypes";
	/**
	 * @generated
	 */
	public static final String ONLYSHOWPRODUCTIONPARENTS = "OnlyShowProductionParents";
	/**
	 * @generated
	 */
	public static final String EMPLOYEEPRICING = "EmployeePricing";
	/**
	 * @generated
	 */
	public static final String EMPLOYEECHARGES = "EmployeeCharges";
	/**
	 * @generated
	 */
	public static final String EMPLOYEEPRESSES = "EmployeePresses";
	/**
	 * @generated
	 */
	public static final String EMPLOYEECOPIERS = "EmployeeCopiers";
	/**
	 * @generated
	 */
	public static final String ANYPASTDUE = "AnyPastDue";
	/**
	 * @generated
	 */
	public static final String CUSTOMERWANT = "CustomerWant";
	/**
	 * @generated
	 */
	public static final String PRODUCTIONPARENTS = "ProductionParents";
	/**
	 * @generated
	 */
	public static final String AUTOHOUR = "AutoHour";
	/**
	 * @generated
	 */
	public static final String AUTOMIN = "AutoMin";
	/**
	 * @generated
	 */
	public static final String MESSAGE = "Message";
	/**
	 * @generated
	 */
	public static final String SHOWMESSAGECLOCKOUT = "ShowMessageClockout";
	/**
	 * @generated
	 */
	public static final String SHOWMESSAGECLOCKIN = "ShowMessageClockin";
	/**
	 * @generated
	 */
	public static final String EMPLOYEEID = "EmployeeId";
	/**
	 * @generated
	 */
	public static final String ISSELECTED = "IsSelected";
	/**
	 * @generated
	 */
	public static final String ISDISABLED = "IsDisabled";

	/**
	 * @generated
	 */
	public Employee() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String socialSecurity;
	
	/**
	 * @generated
 	 */
	public String getSocialSecurity(){
    return socialSecurity; 
  }

	
	/**
	 * @generated
	 */	
	public void setSocialSecurity(String newVal) {
    this.socialSecurity = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer exportCode;
	
	/**
	 * @generated
 	 */
	public Integer getExportCode(){
    return exportCode; 
  }

	
	/**
	 * @generated
	 */	
	public void setExportCode(Integer newVal) {
    this.exportCode = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean clockIn;
	
	/**
	 * @generated
 	 */
	public Boolean getClockIn(){
    return clockIn; 
  }

	
	/**
	 * @generated
	 */	
	public void setClockIn(Boolean newVal) {
    this.clockIn = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean clockOut;
	
	/**
	 * @generated
 	 */
	public Boolean getClockOut(){
    return clockOut; 
  }

	
	/**
	 * @generated
	 */	
	public void setClockOut(Boolean newVal) {
    this.clockOut = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean clockBreak;
	
	/**
	 * @generated
 	 */
	public Boolean getClockBreak(){
    return clockBreak; 
  }

	
	/**
	 * @generated
	 */	
	public void setClockBreak(Boolean newVal) {
    this.clockBreak = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private BigDecimal rate;
	
	/**
	 * @generated
 	 */
	public BigDecimal getRate(){
    return rate; 
  }

	
	/**
	 * @generated
	 */	
	public void setRate(BigDecimal newVal) {
    this.rate = newVal;
  }
	
	/**
	 * @generated
	 */	
	public void setRate(double newVal) {
    this.rate = BigDecimal.valueOf(newVal);
  }
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean active;
	
	/**
	 * @generated
 	 */
	public Boolean getActive(){
    return active; 
  }

	
	/**
	 * @generated
	 */	
	public void setActive(Boolean newVal) {
    this.active = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean pinRequired;
	
	/**
	 * @generated
 	 */
	public Boolean getPinRequired(){
    return pinRequired; 
  }

	
	/**
	 * @generated
	 */	
	public void setPinRequired(Boolean newVal) {
    this.pinRequired = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String pin;
	
	/**
	 * @generated
 	 */
	public String getPin(){
    return pin; 
  }

	
	/**
	 * @generated
	 */	
	public void setPin(String newVal) {
    this.pin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allowOverrideCost;
	
	/**
	 * @generated
 	 */
	public Boolean getAllowOverrideCost(){
    return allowOverrideCost; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllowOverrideCost(Boolean newVal) {
    this.allowOverrideCost = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean costingAmounts;
	
	/**
	 * @generated
 	 */
	public Boolean getCostingAmounts(){
    return costingAmounts; 
  }

	
	/**
	 * @generated
	 */	
	public void setCostingAmounts(Boolean newVal) {
    this.costingAmounts = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hideNonReleaseProduction;
	
	/**
	 * @generated
 	 */
	public Boolean getHideNonReleaseProduction(){
    return hideNonReleaseProduction; 
  }

	
	/**
	 * @generated
	 */	
	public void setHideNonReleaseProduction(Boolean newVal) {
    this.hideNonReleaseProduction = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hideEstimateTimeTracker;
	
	/**
	 * @generated
 	 */
	public Boolean getHideEstimateTimeTracker(){
    return hideEstimateTimeTracker; 
  }

	
	/**
	 * @generated
	 */	
	public void setHideEstimateTimeTracker(Boolean newVal) {
    this.hideEstimateTimeTracker = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean productionSettings;
	
	/**
	 * @generated
 	 */
	public Boolean getProductionSettings(){
    return productionSettings; 
  }

	
	/**
	 * @generated
	 */	
	public void setProductionSettings(Boolean newVal) {
    this.productionSettings = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean trackerNextLocation;
	
	/**
	 * @generated
 	 */
	public Boolean getTrackerNextLocation(){
    return trackerNextLocation; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackerNextLocation(Boolean newVal) {
    this.trackerNextLocation = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean trackerClockIn;
	
	/**
	 * @generated
 	 */
	public Boolean getTrackerClockIn(){
    return trackerClockIn; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackerClockIn(Boolean newVal) {
    this.trackerClockIn = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showWorkCenter;
	
	/**
	 * @generated
 	 */
	public Boolean getShowWorkCenter(){
    return showWorkCenter; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowWorkCenter(Boolean newVal) {
    this.showWorkCenter = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean magCardReader;
	
	/**
	 * @generated
 	 */
	public Boolean getMagCardReader(){
    return magCardReader; 
  }

	
	/**
	 * @generated
	 */	
	public void setMagCardReader(Boolean newVal) {
    this.magCardReader = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean includeInvoice;
	
	/**
	 * @generated
 	 */
	public Boolean getIncludeInvoice(){
    return includeInvoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setIncludeInvoice(Boolean newVal) {
    this.includeInvoice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean includeEstimate;
	
	/**
	 * @generated
 	 */
	public Boolean getIncludeEstimate(){
    return includeEstimate; 
  }

	
	/**
	 * @generated
	 */	
	public void setIncludeEstimate(Boolean newVal) {
    this.includeEstimate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean includeJobs;
	
	/**
	 * @generated
 	 */
	public Boolean getIncludeJobs(){
    return includeJobs; 
  }

	
	/**
	 * @generated
	 */	
	public void setIncludeJobs(Boolean newVal) {
    this.includeJobs = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean includeJobCharges;
	
	/**
	 * @generated
 	 */
	public Boolean getIncludeJobCharges(){
    return includeJobCharges; 
  }

	
	/**
	 * @generated
	 */	
	public void setIncludeJobCharges(Boolean newVal) {
    this.includeJobCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean includeInvoiceCharges;
	
	/**
	 * @generated
 	 */
	public Boolean getIncludeInvoiceCharges(){
    return includeInvoiceCharges; 
  }

	
	/**
	 * @generated
	 */	
	public void setIncludeInvoiceCharges(Boolean newVal) {
    this.includeInvoiceCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allPricingMethods;
	
	/**
	 * @generated
 	 */
	public Boolean getAllPricingMethods(){
    return allPricingMethods; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllPricingMethods(Boolean newVal) {
    this.allPricingMethods = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allPresses;
	
	/**
	 * @generated
 	 */
	public Boolean getAllPresses(){
    return allPresses; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllPresses(Boolean newVal) {
    this.allPresses = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allCopiers;
	
	/**
	 * @generated
 	 */
	public Boolean getAllCopiers(){
    return allCopiers; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllCopiers(Boolean newVal) {
    this.allCopiers = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean allChargeTypes;
	
	/**
	 * @generated
 	 */
	public Boolean getAllChargeTypes(){
    return allChargeTypes; 
  }

	
	/**
	 * @generated
	 */	
	public void setAllChargeTypes(Boolean newVal) {
    this.allChargeTypes = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean onlyShowProductionParents;
	
	/**
	 * @generated
 	 */
	public Boolean getOnlyShowProductionParents(){
    return onlyShowProductionParents; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnlyShowProductionParents(Boolean newVal) {
    this.onlyShowProductionParents = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "employee_employeepricings")
	private java.util.List<PreferencesPricingMethod> employeePricings;
	
	/**
	 * @generated
 	 */
	public java.util.List<PreferencesPricingMethod> getEmployeePricings(){
    return employeePricings; 
  }

	/**
	 * @generated
	 */	
	public void addEmployeePricings(PreferencesPricingMethod obj) {
    if (employeePricings == null) {
      employeePricings = new java.util.ArrayList<PreferencesPricingMethod>();
    }
    employeePricings.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setEmployeePricings(java.util.List<PreferencesPricingMethod> newVal) {
    this.employeePricings = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "employee_employeecharges")
	private java.util.List<ChargeCommand> employeeCharges;
	
	/**
	 * @generated
 	 */
	public java.util.List<ChargeCommand> getEmployeeCharges(){
    return employeeCharges; 
  }

	/**
	 * @generated
	 */	
	public void addEmployeeCharges(ChargeCommand obj) {
    if (employeeCharges == null) {
      employeeCharges = new java.util.ArrayList<ChargeCommand>();
    }
    employeeCharges.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setEmployeeCharges(java.util.List<ChargeCommand> newVal) {
    this.employeeCharges = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "employee_employeepresses")
	private java.util.List<ProductionPress> employeePresses;
	
	/**
	 * @generated
 	 */
	public java.util.List<ProductionPress> getEmployeePresses(){
    return employeePresses; 
  }

	/**
	 * @generated
	 */	
	public void addEmployeePresses(ProductionPress obj) {
    if (employeePresses == null) {
      employeePresses = new java.util.ArrayList<ProductionPress>();
    }
    employeePresses.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setEmployeePresses(java.util.List<ProductionPress> newVal) {
    this.employeePresses = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "employee_employeecopiers")
	private java.util.List<ProductionCopiers> employeeCopiers;
	
	/**
	 * @generated
 	 */
	public java.util.List<ProductionCopiers> getEmployeeCopiers(){
    return employeeCopiers; 
  }

	/**
	 * @generated
	 */	
	public void addEmployeeCopiers(ProductionCopiers obj) {
    if (employeeCopiers == null) {
      employeeCopiers = new java.util.ArrayList<ProductionCopiers>();
    }
    employeeCopiers.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setEmployeeCopiers(java.util.List<ProductionCopiers> newVal) {
    this.employeeCopiers = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean anyPastDue;
	
	/**
	 * @generated
 	 */
	public Boolean getAnyPastDue(){
    return anyPastDue; 
  }

	
	/**
	 * @generated
	 */	
	public void setAnyPastDue(Boolean newVal) {
    this.anyPastDue = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String customerWant;
	
	/**
	 * @generated
 	 */
	public String getCustomerWant(){
    return customerWant; 
  }

	
	/**
	 * @generated
	 */	
	public void setCustomerWant(String newVal) {
    this.customerWant = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @OneToMany()
    @JoinTable( name = "employee_productionparents")
	private java.util.List<ProductionLocations> productionParents;
	
	/**
	 * @generated
 	 */
	public java.util.List<ProductionLocations> getProductionParents(){
    return productionParents; 
  }

	/**
	 * @generated
	 */	
	public void addProductionParents(ProductionLocations obj) {
    if (productionParents == null) {
      productionParents = new java.util.ArrayList<ProductionLocations>();
    }
    productionParents.add(obj);
  }
	
	/**
	 * @generated
	 */	
	public void setProductionParents(java.util.List<ProductionLocations> newVal) {
    this.productionParents = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer autoHour;
	
	/**
	 * @generated
 	 */
	public Integer getAutoHour(){
    return autoHour; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoHour(Integer newVal) {
    this.autoHour = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer autoMin;
	
	/**
	 * @generated
 	 */
	public Integer getAutoMin(){
    return autoMin; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoMin(Integer newVal) {
    this.autoMin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String message;
	
	/**
	 * @generated
 	 */
	public String getMessage(){
    return message; 
  }

	
	/**
	 * @generated
	 */	
	public void setMessage(String newVal) {
    this.message = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showMessageClockout;
	
	/**
	 * @generated
 	 */
	public Boolean getShowMessageClockout(){
    return showMessageClockout; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowMessageClockout(Boolean newVal) {
    this.showMessageClockout = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showMessageClockin;
	
	/**
	 * @generated
 	 */
	public Boolean getShowMessageClockin(){
    return showMessageClockin; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowMessageClockin(Boolean newVal) {
    this.showMessageClockin = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String employeeId;
	
	/**
	 * @generated
 	 */
	public String getEmployeeId(){
    return employeeId; 
  }

	
	/**
	 * @generated
	 */	
	public void setEmployeeId(String newVal) {
    this.employeeId = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isSelected;
	
	/**
	 * @generated
 	 */
	public Boolean getIsSelected(){
    return isSelected; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsSelected(Boolean newVal) {
    this.isSelected = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isDisabled;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDisabled(){
    return isDisabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setIsDisabled(Boolean newVal) {
    this.isDisabled = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (SOCIALSECURITY.equals(propertyName)) return getSocialSecurity();
    if (EXPORTCODE.equals(propertyName)) return getExportCode();
    if (CLOCKIN.equals(propertyName)) return getClockIn();
    if (CLOCKOUT.equals(propertyName)) return getClockOut();
    if (CLOCKBREAK.equals(propertyName)) return getClockBreak();
    if (RATE.equals(propertyName)) return getRate();
    if (ACTIVE.equals(propertyName)) return getActive();
    if (PINREQUIRED.equals(propertyName)) return getPinRequired();
    if (PIN.equals(propertyName)) return getPin();
    if (ALLOWOVERRIDECOST.equals(propertyName)) return getAllowOverrideCost();
    if (COSTINGAMOUNTS.equals(propertyName)) return getCostingAmounts();
    if (HIDENONRELEASEPRODUCTION.equals(propertyName)) return getHideNonReleaseProduction();
    if (HIDEESTIMATETIMETRACKER.equals(propertyName)) return getHideEstimateTimeTracker();
    if (PRODUCTIONSETTINGS.equals(propertyName)) return getProductionSettings();
    if (TRACKERNEXTLOCATION.equals(propertyName)) return getTrackerNextLocation();
    if (TRACKERCLOCKIN.equals(propertyName)) return getTrackerClockIn();
    if (SHOWWORKCENTER.equals(propertyName)) return getShowWorkCenter();
    if (MAGCARDREADER.equals(propertyName)) return getMagCardReader();
    if (INCLUDEINVOICE.equals(propertyName)) return getIncludeInvoice();
    if (INCLUDEESTIMATE.equals(propertyName)) return getIncludeEstimate();
    if (INCLUDEJOBS.equals(propertyName)) return getIncludeJobs();
    if (INCLUDEJOBCHARGES.equals(propertyName)) return getIncludeJobCharges();
    if (INCLUDEINVOICECHARGES.equals(propertyName)) return getIncludeInvoiceCharges();
    if (ALLPRICINGMETHODS.equals(propertyName)) return getAllPricingMethods();
    if (ALLPRESSES.equals(propertyName)) return getAllPresses();
    if (ALLCOPIERS.equals(propertyName)) return getAllCopiers();
    if (ALLCHARGETYPES.equals(propertyName)) return getAllChargeTypes();
    if (ONLYSHOWPRODUCTIONPARENTS.equals(propertyName)) return getOnlyShowProductionParents();
    if (EMPLOYEEPRICING.equals(propertyName)) return getEmployeePricings();
    if (EMPLOYEECHARGES.equals(propertyName)) return getEmployeeCharges();
    if (EMPLOYEEPRESSES.equals(propertyName)) return getEmployeePresses();
    if (EMPLOYEECOPIERS.equals(propertyName)) return getEmployeeCopiers();
    if (ANYPASTDUE.equals(propertyName)) return getAnyPastDue();
    if (CUSTOMERWANT.equals(propertyName)) return getCustomerWant();
    if (PRODUCTIONPARENTS.equals(propertyName)) return getProductionParents();
    if (AUTOHOUR.equals(propertyName)) return getAutoHour();
    if (AUTOMIN.equals(propertyName)) return getAutoMin();
    if (MESSAGE.equals(propertyName)) return getMessage();
    if (SHOWMESSAGECLOCKOUT.equals(propertyName)) return getShowMessageClockout();
    if (SHOWMESSAGECLOCKIN.equals(propertyName)) return getShowMessageClockin();
    if (EMPLOYEEID.equals(propertyName)) return getEmployeeId();
    if (ISSELECTED.equals(propertyName)) return getIsSelected();
    if (ISDISABLED.equals(propertyName)) return getIsDisabled();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (SOCIALSECURITY.equals(propertyName)) setSocialSecurity((String)newValue); else
    if (EXPORTCODE.equals(propertyName)) setExportCode((Integer)newValue); else
    if (CLOCKIN.equals(propertyName)) setClockIn((Boolean)newValue); else
    if (CLOCKOUT.equals(propertyName)) setClockOut((Boolean)newValue); else
    if (CLOCKBREAK.equals(propertyName)) setClockBreak((Boolean)newValue); else
    if (RATE.equals(propertyName)) setRate((BigDecimal)newValue); else
    if (ACTIVE.equals(propertyName)) setActive((Boolean)newValue); else
    if (PINREQUIRED.equals(propertyName)) setPinRequired((Boolean)newValue); else
    if (PIN.equals(propertyName)) setPin((String)newValue); else
    if (ALLOWOVERRIDECOST.equals(propertyName)) setAllowOverrideCost((Boolean)newValue); else
    if (COSTINGAMOUNTS.equals(propertyName)) setCostingAmounts((Boolean)newValue); else
    if (HIDENONRELEASEPRODUCTION.equals(propertyName)) setHideNonReleaseProduction((Boolean)newValue); else
    if (HIDEESTIMATETIMETRACKER.equals(propertyName)) setHideEstimateTimeTracker((Boolean)newValue); else
    if (PRODUCTIONSETTINGS.equals(propertyName)) setProductionSettings((Boolean)newValue); else
    if (TRACKERNEXTLOCATION.equals(propertyName)) setTrackerNextLocation((Boolean)newValue); else
    if (TRACKERCLOCKIN.equals(propertyName)) setTrackerClockIn((Boolean)newValue); else
    if (SHOWWORKCENTER.equals(propertyName)) setShowWorkCenter((Boolean)newValue); else
    if (MAGCARDREADER.equals(propertyName)) setMagCardReader((Boolean)newValue); else
    if (INCLUDEINVOICE.equals(propertyName)) setIncludeInvoice((Boolean)newValue); else
    if (INCLUDEESTIMATE.equals(propertyName)) setIncludeEstimate((Boolean)newValue); else
    if (INCLUDEJOBS.equals(propertyName)) setIncludeJobs((Boolean)newValue); else
    if (INCLUDEJOBCHARGES.equals(propertyName)) setIncludeJobCharges((Boolean)newValue); else
    if (INCLUDEINVOICECHARGES.equals(propertyName)) setIncludeInvoiceCharges((Boolean)newValue); else
    if (ALLPRICINGMETHODS.equals(propertyName)) setAllPricingMethods((Boolean)newValue); else
    if (ALLPRESSES.equals(propertyName)) setAllPresses((Boolean)newValue); else
    if (ALLCOPIERS.equals(propertyName)) setAllCopiers((Boolean)newValue); else
    if (ALLCHARGETYPES.equals(propertyName)) setAllChargeTypes((Boolean)newValue); else
    if (ONLYSHOWPRODUCTIONPARENTS.equals(propertyName)) setOnlyShowProductionParents((Boolean)newValue); else
    if (EMPLOYEEPRICING.equals(propertyName)) setEmployeePricings((java.util.List<PreferencesPricingMethod>)newValue); else
    if (EMPLOYEECHARGES.equals(propertyName)) setEmployeeCharges((java.util.List<ChargeCommand>)newValue); else
    if (EMPLOYEEPRESSES.equals(propertyName)) setEmployeePresses((java.util.List<ProductionPress>)newValue); else
    if (EMPLOYEECOPIERS.equals(propertyName)) setEmployeeCopiers((java.util.List<ProductionCopiers>)newValue); else
    if (ANYPASTDUE.equals(propertyName)) setAnyPastDue((Boolean)newValue); else
    if (CUSTOMERWANT.equals(propertyName)) setCustomerWant((String)newValue); else
    if (PRODUCTIONPARENTS.equals(propertyName)) setProductionParents((java.util.List<ProductionLocations>)newValue); else
    if (AUTOHOUR.equals(propertyName)) setAutoHour((Integer)newValue); else
    if (AUTOMIN.equals(propertyName)) setAutoMin((Integer)newValue); else
    if (MESSAGE.equals(propertyName)) setMessage((String)newValue); else
    if (SHOWMESSAGECLOCKOUT.equals(propertyName)) setShowMessageClockout((Boolean)newValue); else
    if (SHOWMESSAGECLOCKIN.equals(propertyName)) setShowMessageClockin((Boolean)newValue); else
    if (EMPLOYEEID.equals(propertyName)) setEmployeeId((String)newValue); else
    if (ISSELECTED.equals(propertyName)) setIsSelected((Boolean)newValue); else
    if (ISDISABLED.equals(propertyName)) setIsDisabled((Boolean)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (SOCIALSECURITY.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (EXPORTCODE.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (CLOCKIN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CLOCKOUT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CLOCKBREAK.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (RATE.equals(propertyName)) 
      return new Class<?>[] {BigDecimal.class};		
    if (ACTIVE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PINREQUIRED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PIN.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ALLOWOVERRIDECOST.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (COSTINGAMOUNTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (HIDENONRELEASEPRODUCTION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (HIDEESTIMATETIMETRACKER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PRODUCTIONSETTINGS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TRACKERNEXTLOCATION.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TRACKERCLOCKIN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWWORKCENTER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MAGCARDREADER.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INCLUDEINVOICE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INCLUDEESTIMATE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INCLUDEJOBS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INCLUDEJOBCHARGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INCLUDEINVOICECHARGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ALLPRICINGMETHODS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ALLPRESSES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ALLCOPIERS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ALLCHARGETYPES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ONLYSHOWPRODUCTIONPARENTS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EMPLOYEEPRICING.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, PreferencesPricingMethod.class};		
    if (EMPLOYEECHARGES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ChargeCommand.class};		
    if (EMPLOYEEPRESSES.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ProductionPress.class};		
    if (EMPLOYEECOPIERS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ProductionCopiers.class};		
    if (ANYPASTDUE.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (CUSTOMERWANT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PRODUCTIONPARENTS.equals(propertyName)) 
      return new Class<?>[] {java.util.List.class, ProductionLocations.class};		
    if (AUTOHOUR.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (AUTOMIN.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (MESSAGE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHOWMESSAGECLOCKOUT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWMESSAGECLOCKIN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EMPLOYEEID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (ISSELECTED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ISDISABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (SOCIALSECURITY.equals(propertyName)) return Employee.class;
    if (EXPORTCODE.equals(propertyName)) return Employee.class;
    if (CLOCKIN.equals(propertyName)) return Employee.class;
    if (CLOCKOUT.equals(propertyName)) return Employee.class;
    if (CLOCKBREAK.equals(propertyName)) return Employee.class;
    if (RATE.equals(propertyName)) return Employee.class;
    if (ACTIVE.equals(propertyName)) return Employee.class;
    if (PINREQUIRED.equals(propertyName)) return Employee.class;
    if (PIN.equals(propertyName)) return Employee.class;
    if (ALLOWOVERRIDECOST.equals(propertyName)) return Employee.class;
    if (COSTINGAMOUNTS.equals(propertyName)) return Employee.class;
    if (HIDENONRELEASEPRODUCTION.equals(propertyName)) return Employee.class;
    if (HIDEESTIMATETIMETRACKER.equals(propertyName)) return Employee.class;
    if (PRODUCTIONSETTINGS.equals(propertyName)) return Employee.class;
    if (TRACKERNEXTLOCATION.equals(propertyName)) return Employee.class;
    if (TRACKERCLOCKIN.equals(propertyName)) return Employee.class;
    if (SHOWWORKCENTER.equals(propertyName)) return Employee.class;
    if (MAGCARDREADER.equals(propertyName)) return Employee.class;
    if (INCLUDEINVOICE.equals(propertyName)) return Employee.class;
    if (INCLUDEESTIMATE.equals(propertyName)) return Employee.class;
    if (INCLUDEJOBS.equals(propertyName)) return Employee.class;
    if (INCLUDEJOBCHARGES.equals(propertyName)) return Employee.class;
    if (INCLUDEINVOICECHARGES.equals(propertyName)) return Employee.class;
    if (ALLPRICINGMETHODS.equals(propertyName)) return Employee.class;
    if (ALLPRESSES.equals(propertyName)) return Employee.class;
    if (ALLCOPIERS.equals(propertyName)) return Employee.class;
    if (ALLCHARGETYPES.equals(propertyName)) return Employee.class;
    if (ONLYSHOWPRODUCTIONPARENTS.equals(propertyName)) return Employee.class;
    if (EMPLOYEEPRICING.equals(propertyName)) return Employee.class;
    if (EMPLOYEECHARGES.equals(propertyName)) return Employee.class;
    if (EMPLOYEEPRESSES.equals(propertyName)) return Employee.class;
    if (EMPLOYEECOPIERS.equals(propertyName)) return Employee.class;
    if (ANYPASTDUE.equals(propertyName)) return Employee.class;
    if (CUSTOMERWANT.equals(propertyName)) return Employee.class;
    if (PRODUCTIONPARENTS.equals(propertyName)) return Employee.class;
    if (AUTOHOUR.equals(propertyName)) return Employee.class;
    if (AUTOMIN.equals(propertyName)) return Employee.class;
    if (MESSAGE.equals(propertyName)) return Employee.class;
    if (SHOWMESSAGECLOCKOUT.equals(propertyName)) return Employee.class;
    if (SHOWMESSAGECLOCKIN.equals(propertyName)) return Employee.class;
    if (EMPLOYEEID.equals(propertyName)) return Employee.class;
    if (ISSELECTED.equals(propertyName)) return Employee.class;
    if (ISDISABLED.equals(propertyName)) return Employee.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    Employee objT = (Employee)obj;
    if (! SmartEquals(getSocialSecurity(), objT.getSocialSecurity()))
      return false;
    if (! SmartEquals(getExportCode(), objT.getExportCode()))
      return false;
    if (! SmartEquals(getClockIn(), objT.getClockIn()))
      return false;
    if (! SmartEquals(getClockOut(), objT.getClockOut()))
      return false;
    if (! SmartEquals(getClockBreak(), objT.getClockBreak()))
      return false;
    if (! SmartEquals(getRate(), objT.getRate()))
      return false;
    if (! SmartEquals(getActive(), objT.getActive()))
      return false;
    if (! SmartEquals(getPinRequired(), objT.getPinRequired()))
      return false;
    if (! SmartEquals(getPin(), objT.getPin()))
      return false;
    if (! SmartEquals(getAllowOverrideCost(), objT.getAllowOverrideCost()))
      return false;
    if (! SmartEquals(getCostingAmounts(), objT.getCostingAmounts()))
      return false;
    if (! SmartEquals(getHideNonReleaseProduction(), objT.getHideNonReleaseProduction()))
      return false;
    if (! SmartEquals(getHideEstimateTimeTracker(), objT.getHideEstimateTimeTracker()))
      return false;
    if (! SmartEquals(getProductionSettings(), objT.getProductionSettings()))
      return false;
    if (! SmartEquals(getTrackerNextLocation(), objT.getTrackerNextLocation()))
      return false;
    if (! SmartEquals(getTrackerClockIn(), objT.getTrackerClockIn()))
      return false;
    if (! SmartEquals(getShowWorkCenter(), objT.getShowWorkCenter()))
      return false;
    if (! SmartEquals(getMagCardReader(), objT.getMagCardReader()))
      return false;
    if (! SmartEquals(getIncludeInvoice(), objT.getIncludeInvoice()))
      return false;
    if (! SmartEquals(getIncludeEstimate(), objT.getIncludeEstimate()))
      return false;
    if (! SmartEquals(getIncludeJobs(), objT.getIncludeJobs()))
      return false;
    if (! SmartEquals(getIncludeJobCharges(), objT.getIncludeJobCharges()))
      return false;
    if (! SmartEquals(getIncludeInvoiceCharges(), objT.getIncludeInvoiceCharges()))
      return false;
    if (! SmartEquals(getAllPricingMethods(), objT.getAllPricingMethods()))
      return false;
    if (! SmartEquals(getAllPresses(), objT.getAllPresses()))
      return false;
    if (! SmartEquals(getAllCopiers(), objT.getAllCopiers()))
      return false;
    if (! SmartEquals(getAllChargeTypes(), objT.getAllChargeTypes()))
      return false;
    if (! SmartEquals(getOnlyShowProductionParents(), objT.getOnlyShowProductionParents()))
      return false;
    if (! SmartEquals(getEmployeePricings(), objT.getEmployeePricings()))
      return false;
    if (! SmartEquals(getEmployeeCharges(), objT.getEmployeeCharges()))
      return false;
    if (! SmartEquals(getEmployeePresses(), objT.getEmployeePresses()))
      return false;
    if (! SmartEquals(getEmployeeCopiers(), objT.getEmployeeCopiers()))
      return false;
    if (! SmartEquals(getAnyPastDue(), objT.getAnyPastDue()))
      return false;
    if (! SmartEquals(getCustomerWant(), objT.getCustomerWant()))
      return false;
    if (! SmartEquals(getProductionParents(), objT.getProductionParents()))
      return false;
    if (! SmartEquals(getAutoHour(), objT.getAutoHour()))
      return false;
    if (! SmartEquals(getAutoMin(), objT.getAutoMin()))
      return false;
    if (! SmartEquals(getMessage(), objT.getMessage()))
      return false;
    if (! SmartEquals(getShowMessageClockout(), objT.getShowMessageClockout()))
      return false;
    if (! SmartEquals(getShowMessageClockin(), objT.getShowMessageClockin()))
      return false;
    if (! SmartEquals(getEmployeeId(), objT.getEmployeeId()))
      return false;
    if (! SmartEquals(getIsSelected(), objT.getIsSelected()))
      return false;
    if (! SmartEquals(getIsDisabled(), objT.getIsDisabled()))
      return false;
    return true;
  }			
}
