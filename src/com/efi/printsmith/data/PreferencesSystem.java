
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
  @NamedQuery(name = "PreferencesSystem.findall", query = "from PreferencesSystem"),
  @NamedQuery(name = "PreferencesSystem.byId", query = "select a from PreferencesSystem a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "preferencessystem")
public class PreferencesSystem extends ModelBase {
	/**
	 * @generated
	 */
	public static final String ELIMINATEWARNINGMESSAGES = "EliminateWarningMessages";
	/**
	 * @generated
	 */
	public static final String ONLYPOSTMARKEDREADYINVOICES = "OnlyPostMarkedReadyInvoices";
	/**
	 * @generated
	 */
	public static final String ENABLEPRICINGSYSTEM = "EnablePricingSystem";
	/**
	 * @generated
	 */
	public static final String ACTIVATEUSEREVENTLOGGING = "ActivateUserEventLogging";
	/**
	 * @generated
	 */
	public static final String ENABLEAUTOLOGOUT = "EnableAutoLogOut";
	/**
	 * @generated
	 */
	public static final String SECONDSOFINACTIVITY = "SecondsOfInactivity";
	/**
	 * @generated
	 */
	public static final String AUTOLOGOUTSECONDS = "AutoLogOutSeconds";
	/**
	 * @generated
	 */
	public static final String TRIGGERAFTERPOSTING = "TriggerAfterPosting";
	/**
	 * @generated
	 */
	public static final String SHOWINVOICESWITHTODAY = "ShowInvoicesWithToday";
	/**
	 * @generated
	 */
	public static final String LINEITEMTAXES = "LineItemTaxes";
	/**
	 * @generated
	 */
	public static final String AUTOMATICQUIT = "AutomaticQuit";
	/**
	 * @generated
	 */
	public static final String QUITTIME = "QuitTime";
	/**
	 * @generated
	 */
	public static final String SHUTDOWNMESSAGE = "ShutdownMessage";
	/**
	 * @generated
	 */
	public static final String COMPANYADDRESS = "CompanyAddress";
	/**
	 * @generated
	 */
	public static final String COMPANYPHONE = "CompanyPhone";
	/**
	 * @generated
	 */
	public static final String COMPANYFAX = "CompanyFax";
	/**
	 * @generated
	 */
	public static final String COMPANYEMAIL = "CompanyEmail";
	/**
	 * @generated
	 */
	public static final String COMPANYOTHER1 = "CompanyOther1";
	/**
	 * @generated
	 */
	public static final String COMPANYOTHER2 = "CompanyOther2";
	/**
	 * @generated
	 */
	public static final String COMPANYIDLABEL = "CompanyIdLabel";
	/**
	 * @generated
	 */
	public static final String COMPANYID = "CompanyId";
	/**
	 * @generated
	 */
	public static final String COMPANYSTORENUMBER = "CompanyStoreNumber";
	/**
	 * @generated
	 */
	public static final String COMPANYSTORELOCATIONREF = "CompanyStoreLocationRef";
	/**
	 * @generated
	 */
	public static final String FISCALYEARSTARTMONTH = "FiscalYearStartMonth";
	/**
	 * @generated
	 */
	public static final String WORKSUNDAY = "WorkSunday";
	/**
	 * @generated
	 */
	public static final String WORKMONDAY = "WorkMonday";
	/**
	 * @generated
	 */
	public static final String WORKTUESDAY = "WorkTuesday";
	/**
	 * @generated
	 */
	public static final String WORKWEDNESDAY = "WorkWednesday";
	/**
	 * @generated
	 */
	public static final String WORKTHURSDAY = "WorkThursday";
	/**
	 * @generated
	 */
	public static final String WORKFRIDAY = "WorkFriday";
	/**
	 * @generated
	 */
	public static final String WORKSATURDAY = "WorkSaturday";
	/**
	 * @generated
	 */
	public static final String WORKFIRSTDAYOFWEEK = "WorkFirstDayOfWeek";
	/**
	 * @generated
	 */
	public static final String FUTUREDATESEXCLUDECLOSED = "FutureDatesExcludeClosed";
	/**
	 * @generated
	 */
	public static final String NUMBERSINTEGERS = "NumbersIntegers";
	/**
	 * @generated
	 */
	public static final String NUMBERSPERCENTAGES = "NumbersPercentages";
	/**
	 * @generated
	 */
	public static final String NUMBERSAMOUNT = "NumbersAmount";
	/**
	 * @generated
	 */
	public static final String NUMBERSTAXRATE = "NumbersTaxRate";
	/**
	 * @generated
	 */
	public static final String NUMBERSRATE = "NumbersRate";
	/**
	 * @generated
	 */
	public static final String NUMBERSFACTOR = "NumbersFactor";
	/**
	 * @generated
	 */
	public static final String NUMBERSINVOICE = "NumbersInvoice";
	/**
	 * @generated
	 */
	public static final String NUMBERSSHORTPERCENT = "NumbersShortPercent";
	/**
	 * @generated
	 */
	public static final String NUMBERSROUNDTO = "NumbersRoundto";
	/**
	 * @generated
	 */
	public static final String ALWAYSROUNDDOWN = "AlwaysRoundDown";
	/**
	 * @generated
	 */
	public static final String ROUNDTAXUP = "RoundTaxUp";
	/**
	 * @generated
	 */
	public static final String USEALTERNATECURRENCY = "UseAlternateCurrency";
	/**
	 * @generated
	 */
	public static final String DISPLAYFORMAT = "DisplayFormat";
	/**
	 * @generated
	 */
	public static final String CONVERSIONFACTOR = "ConversionFactor";
	/**
	 * @generated
	 */
	public static final String ALTERNATEROUNDTO = "AlternateRoundto";
	/**
	 * @generated
	 */
	public static final String ALTERNATEALWAYSROUNDDOWN = "AlternateAlwaysRoundDown";
	/**
	 * @generated
	 */
	public static final String DISABLETEXTSTYLES = "DisableTextStyles";
	/**
	 * @generated
	 */
	public static final String AUSTRAILIANINVOICEROUNDING = "AustrailianInvoiceRounding";
	/**
	 * @generated
	 */
	public static final String DISABLENONTAXABLEOPTIONS = "DisableNonTaxableOptions";
	/**
	 * @generated
	 */
	public static final String INKWEIGHTSINGULAR = "InkWeightSingular";
	/**
	 * @generated
	 */
	public static final String INKWEIGHTPLURAL = "InkWeightPlural";
	/**
	 * @generated
	 */
	public static final String AUTHORIZEDECRYPT = "AuthorizeDecrypt";
	/**
	 * @generated
	 */
	public static final String CREDITCARDAPPROVAL = "CreditCardApproval";
	/**
	 * @generated
	 */
	public static final String TRACKERDATACOLLECTION = "TrackerDataCollection";
	/**
	 * @generated
	 */
	public static final String DEFAULTCOUNTRY = "DefaultCountry";
	/**
	 * @generated
	 */
	public static final String SERIALNUMBER = "SerialNumber";
	/**
	 * @generated
	 */
	public static final String PROGRAMTYPE = "ProgramType";
	/**
	 * @generated
	 */
	public static final String WEBENABLED = "WebEnabled";
	/**
	 * @generated
	 */
	public static final String PAYMENTPLANENABLED = "PaymentPlanEnabled";
	/**
	 * @generated
	 */
	public static final String SCHEDULERENABLED = "SchedulerEnabled";
	/**
	 * @generated
	 */
	public static final String TRACKERENABLED = "TrackerEnabled";
	/**
	 * @generated
	 */
	public static final String MAXIMUMNODECOUNT = "MaximumNodeCount";
	/**
	 * @generated
	 */
	public static final String EXPIRATIONDATE = "ExpirationDate";
	/**
	 * @generated
	 */
	public static final String CCENCRYPTIONDATA = "CCEncryptionData";
	/**
	 * @generated
	 */
	public static final String CONFIG = "Config";
	/**
	 * @generated
	 */
	public static final String PROCESS = "Process";
	/**
	 * @generated
	 */
	public static final String SLOGAN = "Slogan";
	/**
	 * @generated
	 */
	public static final String REPORTWRITERENABLED = "ReportWriterEnabled";
	/**
	 * @generated
	 */
	public static final String EXTENDEDPRICEBOOKENABLED = "ExtendedPriceBookEnabled";
	/**
	 * @generated
	 */
	public static final String MAXIMUMTRANSACTIONCOUNT = "MaximumTransactionCount";
	/**
	 * @generated
	 */
	public static final String SETTINGS = "Settings";
	/**
	 * @generated
	 */
	public static final String OCONFIG = "Oconfig";
	/**
	 * @generated
	 */
	public static final String OPROCESS = "Oprocess";
	/**
	 * @generated
	 */
	public static final String OSLOGAN = "Oslogan";
	/**
	 * @generated
	 */
	public static final String OSETTINGS = "Osettings";

	/**
	 * @generated
	 */
	public PreferencesSystem() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean eliminateWarningMessages;
	
	/**
	 * @generated
 	 */
	public Boolean getEliminateWarningMessages(){
    return eliminateWarningMessages; 
  }

	
	/**
	 * @generated
	 */	
	public void setEliminateWarningMessages(Boolean newVal) {
    this.eliminateWarningMessages = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean onlyPostMarkedReadyInvoices;
	
	/**
	 * @generated
 	 */
	public Boolean getOnlyPostMarkedReadyInvoices(){
    return onlyPostMarkedReadyInvoices; 
  }

	
	/**
	 * @generated
	 */	
	public void setOnlyPostMarkedReadyInvoices(Boolean newVal) {
    this.onlyPostMarkedReadyInvoices = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean enablePricingSystem;
	
	/**
	 * @generated
 	 */
	public Boolean getEnablePricingSystem(){
    return enablePricingSystem; 
  }

	
	/**
	 * @generated
	 */	
	public void setEnablePricingSystem(Boolean newVal) {
    this.enablePricingSystem = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean activateUserEventLogging;
	
	/**
	 * @generated
 	 */
	public Boolean getActivateUserEventLogging(){
    return activateUserEventLogging; 
  }

	
	/**
	 * @generated
	 */	
	public void setActivateUserEventLogging(Boolean newVal) {
    this.activateUserEventLogging = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean enableAutoLogOut;
	
	/**
	 * @generated
 	 */
	public Boolean getEnableAutoLogOut(){
    return enableAutoLogOut; 
  }

	
	/**
	 * @generated
	 */	
	public void setEnableAutoLogOut(Boolean newVal) {
    this.enableAutoLogOut = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean secondsOfInactivity;
	
	/**
	 * @generated
 	 */
	public Boolean getSecondsOfInactivity(){
    return secondsOfInactivity; 
  }

	
	/**
	 * @generated
	 */	
	public void setSecondsOfInactivity(Boolean newVal) {
    this.secondsOfInactivity = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer autoLogOutSeconds;
	
	/**
	 * @generated
 	 */
	public Integer getAutoLogOutSeconds(){
    return autoLogOutSeconds; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutoLogOutSeconds(Integer newVal) {
    this.autoLogOutSeconds = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean triggerAfterPosting;
	
	/**
	 * @generated
 	 */
	public Boolean getTriggerAfterPosting(){
    return triggerAfterPosting; 
  }

	
	/**
	 * @generated
	 */	
	public void setTriggerAfterPosting(Boolean newVal) {
    this.triggerAfterPosting = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showInvoicesWithToday;
	
	/**
	 * @generated
 	 */
	public Boolean getShowInvoicesWithToday(){
    return showInvoicesWithToday; 
  }

	
	/**
	 * @generated
	 */	
	public void setShowInvoicesWithToday(Boolean newVal) {
    this.showInvoicesWithToday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean lineItemTaxes;
	
	/**
	 * @generated
 	 */
	public Boolean getLineItemTaxes(){
    return lineItemTaxes; 
  }

	
	/**
	 * @generated
	 */	
	public void setLineItemTaxes(Boolean newVal) {
    this.lineItemTaxes = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean automaticQuit;
	
	/**
	 * @generated
 	 */
	public Boolean getAutomaticQuit(){
    return automaticQuit; 
  }

	
	/**
	 * @generated
	 */	
	public void setAutomaticQuit(Boolean newVal) {
    this.automaticQuit = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String quitTime;
	
	/**
	 * @generated
 	 */
	public String getQuitTime(){
    return quitTime; 
  }

	
	/**
	 * @generated
	 */	
	public void setQuitTime(String newVal) {
    this.quitTime = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String shutdownMessage;
	
	/**
	 * @generated
 	 */
	public String getShutdownMessage(){
    return shutdownMessage; 
  }

	
	/**
	 * @generated
	 */	
	public void setShutdownMessage(String newVal) {
    this.shutdownMessage = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL}, optional=true)
	private Address companyAddress;
	
	/**
	 * @generated
 	 */
	public Address getCompanyAddress(){
    return companyAddress; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyAddress(Address newVal) {
    this.companyAddress = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyPhone;
	
	/**
	 * @generated
 	 */
	public String getCompanyPhone(){
    return companyPhone; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyPhone(String newVal) {
    this.companyPhone = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyFax;
	
	/**
	 * @generated
 	 */
	public String getCompanyFax(){
    return companyFax; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyFax(String newVal) {
    this.companyFax = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyEmail;
	
	/**
	 * @generated
 	 */
	public String getCompanyEmail(){
    return companyEmail; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyEmail(String newVal) {
    this.companyEmail = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyOther1;
	
	/**
	 * @generated
 	 */
	public String getCompanyOther1(){
    return companyOther1; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyOther1(String newVal) {
    this.companyOther1 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyOther2;
	
	/**
	 * @generated
 	 */
	public String getCompanyOther2(){
    return companyOther2; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyOther2(String newVal) {
    this.companyOther2 = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyIdLabel;
	
	/**
	 * @generated
 	 */
	public String getCompanyIdLabel(){
    return companyIdLabel; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyIdLabel(String newVal) {
    this.companyIdLabel = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyId;
	
	/**
	 * @generated
 	 */
	public String getCompanyId(){
    return companyId; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyId(String newVal) {
    this.companyId = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyStoreNumber;
	
	/**
	 * @generated
 	 */
	public String getCompanyStoreNumber(){
    return companyStoreNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyStoreNumber(String newVal) {
    this.companyStoreNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String companyStoreLocationRef;
	
	/**
	 * @generated
 	 */
	public String getCompanyStoreLocationRef(){
    return companyStoreLocationRef; 
  }

	
	/**
	 * @generated
	 */	
	public void setCompanyStoreLocationRef(String newVal) {
    this.companyStoreLocationRef = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String fiscalYearStartMonth;
	
	/**
	 * @generated
 	 */
	public String getFiscalYearStartMonth(){
    return fiscalYearStartMonth; 
  }

	
	/**
	 * @generated
	 */	
	public void setFiscalYearStartMonth(String newVal) {
    this.fiscalYearStartMonth = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workSunday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkSunday(){
    return workSunday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkSunday(Boolean newVal) {
    this.workSunday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workMonday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkMonday(){
    return workMonday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkMonday(Boolean newVal) {
    this.workMonday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workTuesday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkTuesday(){
    return workTuesday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkTuesday(Boolean newVal) {
    this.workTuesday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workWednesday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkWednesday(){
    return workWednesday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkWednesday(Boolean newVal) {
    this.workWednesday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workThursday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkThursday(){
    return workThursday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkThursday(Boolean newVal) {
    this.workThursday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workFriday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkFriday(){
    return workFriday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkFriday(Boolean newVal) {
    this.workFriday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean workSaturday;
	
	/**
	 * @generated
 	 */
	public Boolean getWorkSaturday(){
    return workSaturday; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkSaturday(Boolean newVal) {
    this.workSaturday = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer workFirstDayOfWeek;
	
	/**
	 * @generated
 	 */
	public Integer getWorkFirstDayOfWeek(){
    return workFirstDayOfWeek; 
  }

	
	/**
	 * @generated
	 */	
	public void setWorkFirstDayOfWeek(Integer newVal) {
    this.workFirstDayOfWeek = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean futureDatesExcludeClosed;
	
	/**
	 * @generated
 	 */
	public Boolean getFutureDatesExcludeClosed(){
    return futureDatesExcludeClosed; 
  }

	
	/**
	 * @generated
	 */	
	public void setFutureDatesExcludeClosed(Boolean newVal) {
    this.futureDatesExcludeClosed = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersIntegers;
	
	/**
	 * @generated
 	 */
	public String getNumbersIntegers(){
    return numbersIntegers; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersIntegers(String newVal) {
    this.numbersIntegers = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersPercentages;
	
	/**
	 * @generated
 	 */
	public String getNumbersPercentages(){
    return numbersPercentages; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersPercentages(String newVal) {
    this.numbersPercentages = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersAmount;
	
	/**
	 * @generated
 	 */
	public String getNumbersAmount(){
    return numbersAmount; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersAmount(String newVal) {
    this.numbersAmount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersTaxRate;
	
	/**
	 * @generated
 	 */
	public String getNumbersTaxRate(){
    return numbersTaxRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersTaxRate(String newVal) {
    this.numbersTaxRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersRate;
	
	/**
	 * @generated
 	 */
	public String getNumbersRate(){
    return numbersRate; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersRate(String newVal) {
    this.numbersRate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersFactor;
	
	/**
	 * @generated
 	 */
	public String getNumbersFactor(){
    return numbersFactor; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersFactor(String newVal) {
    this.numbersFactor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersInvoice;
	
	/**
	 * @generated
 	 */
	public String getNumbersInvoice(){
    return numbersInvoice; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersInvoice(String newVal) {
    this.numbersInvoice = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String numbersShortPercent;
	
	/**
	 * @generated
 	 */
	public String getNumbersShortPercent(){
    return numbersShortPercent; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersShortPercent(String newVal) {
    this.numbersShortPercent = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer numbersRoundto;
	
	/**
	 * @generated
 	 */
	public Integer getNumbersRoundto(){
    return numbersRoundto; 
  }

	
	/**
	 * @generated
	 */	
	public void setNumbersRoundto(Integer newVal) {
    this.numbersRoundto = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean alwaysRoundDown;
	
	/**
	 * @generated
 	 */
	public Boolean getAlwaysRoundDown(){
    return alwaysRoundDown; 
  }

	
	/**
	 * @generated
	 */	
	public void setAlwaysRoundDown(Boolean newVal) {
    this.alwaysRoundDown = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean roundTaxUp;
	
	/**
	 * @generated
 	 */
	public Boolean getRoundTaxUp(){
    return roundTaxUp; 
  }

	
	/**
	 * @generated
	 */	
	public void setRoundTaxUp(Boolean newVal) {
    this.roundTaxUp = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean useAlternateCurrency;
	
	/**
	 * @generated
 	 */
	public Boolean getUseAlternateCurrency(){
    return useAlternateCurrency; 
  }

	
	/**
	 * @generated
	 */	
	public void setUseAlternateCurrency(Boolean newVal) {
    this.useAlternateCurrency = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String displayFormat;
	
	/**
	 * @generated
 	 */
	public String getDisplayFormat(){
    return displayFormat; 
  }

	
	/**
	 * @generated
	 */	
	public void setDisplayFormat(String newVal) {
    this.displayFormat = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double conversionFactor;
	
	/**
	 * @generated
 	 */
	public Double getConversionFactor(){
    return conversionFactor; 
  }

	
	/**
	 * @generated
	 */	
	public void setConversionFactor(Double newVal) {
    this.conversionFactor = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer alternateRoundto;
	
	/**
	 * @generated
 	 */
	public Integer getAlternateRoundto(){
    return alternateRoundto; 
  }

	
	/**
	 * @generated
	 */	
	public void setAlternateRoundto(Integer newVal) {
    this.alternateRoundto = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean alternateAlwaysRoundDown;
	
	/**
	 * @generated
 	 */
	public Boolean getAlternateAlwaysRoundDown(){
    return alternateAlwaysRoundDown; 
  }

	
	/**
	 * @generated
	 */	
	public void setAlternateAlwaysRoundDown(Boolean newVal) {
    this.alternateAlwaysRoundDown = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean disableTextStyles;
	
	/**
	 * @generated
 	 */
	public Boolean getDisableTextStyles(){
    return disableTextStyles; 
  }

	
	/**
	 * @generated
	 */	
	public void setDisableTextStyles(Boolean newVal) {
    this.disableTextStyles = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean austrailianInvoiceRounding;
	
	/**
	 * @generated
 	 */
	public Boolean getAustrailianInvoiceRounding(){
    return austrailianInvoiceRounding; 
  }

	
	/**
	 * @generated
	 */	
	public void setAustrailianInvoiceRounding(Boolean newVal) {
    this.austrailianInvoiceRounding = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean disableNonTaxableOptions;
	
	/**
	 * @generated
 	 */
	public Boolean getDisableNonTaxableOptions(){
    return disableNonTaxableOptions; 
  }

	
	/**
	 * @generated
	 */	
	public void setDisableNonTaxableOptions(Boolean newVal) {
    this.disableNonTaxableOptions = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String inkWeightSingular;
	
	/**
	 * @generated
 	 */
	public String getInkWeightSingular(){
    return inkWeightSingular; 
  }

	
	/**
	 * @generated
	 */	
	public void setInkWeightSingular(String newVal) {
    this.inkWeightSingular = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String inkWeightPlural;
	
	/**
	 * @generated
 	 */
	public String getInkWeightPlural(){
    return inkWeightPlural; 
  }

	
	/**
	 * @generated
	 */	
	public void setInkWeightPlural(String newVal) {
    this.inkWeightPlural = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String authorizeDecrypt;
	
	/**
	 * @generated
 	 */
	public String getAuthorizeDecrypt(){
    return authorizeDecrypt; 
  }

	
	/**
	 * @generated
	 */	
	public void setAuthorizeDecrypt(String newVal) {
    this.authorizeDecrypt = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String creditCardApproval;
	
	/**
	 * @generated
 	 */
	public String getCreditCardApproval(){
    return creditCardApproval; 
  }

	
	/**
	 * @generated
	 */	
	public void setCreditCardApproval(String newVal) {
    this.creditCardApproval = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String trackerDataCollection;
	
	/**
	 * @generated
 	 */
	public String getTrackerDataCollection(){
    return trackerDataCollection; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackerDataCollection(String newVal) {
    this.trackerDataCollection = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer defaultCountry;
	
	/**
	 * @generated
 	 */
	public Integer getDefaultCountry(){
    return defaultCountry; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultCountry(Integer newVal) {
    this.defaultCountry = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long serialNumber;
	
	/**
	 * @generated
 	 */
	public Long getSerialNumber(){
    return serialNumber; 
  }

	
	/**
	 * @generated
	 */	
	public void setSerialNumber(Long newVal) {
    this.serialNumber = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String programType;
	
	/**
	 * @generated
 	 */
	public String getProgramType(){
    return programType; 
  }

	
	/**
	 * @generated
	 */	
	public void setProgramType(String newVal) {
    this.programType = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean webEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getWebEnabled(){
    return webEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebEnabled(Boolean newVal) {
    this.webEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean paymentPlanEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getPaymentPlanEnabled(){
    return paymentPlanEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setPaymentPlanEnabled(Boolean newVal) {
    this.paymentPlanEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean schedulerEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getSchedulerEnabled(){
    return schedulerEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setSchedulerEnabled(Boolean newVal) {
    this.schedulerEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean trackerEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getTrackerEnabled(){
    return trackerEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setTrackerEnabled(Boolean newVal) {
    this.trackerEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer maximumNodeCount;
	
	/**
	 * @generated
 	 */
	public Integer getMaximumNodeCount(){
    return maximumNodeCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setMaximumNodeCount(Integer newVal) {
    this.maximumNodeCount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date expirationDate;
	
	/**
	 * @generated
 	 */
	public Date getExpirationDate(){
    return expirationDate; 
  }

	
	/**
	 * @generated
	 */	
	public void setExpirationDate(Date newVal) {
    this.expirationDate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String cCEncryptionData;
	
	/**
	 * @generated
 	 */
	public String getCCEncryptionData(){
    return cCEncryptionData; 
  }

	
	/**
	 * @generated
	 */	
	public void setCCEncryptionData(String newVal) {
    this.cCEncryptionData = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String config;
	
	/**
	 * @generated
 	 */
	public String getConfig(){
    return config; 
  }

	
	/**
	 * @generated
	 */	
	public void setConfig(String newVal) {
    this.config = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String process;
	
	/**
	 * @generated
 	 */
	public String getProcess(){
    return process; 
  }

	
	/**
	 * @generated
	 */	
	public void setProcess(String newVal) {
    this.process = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String slogan;
	
	/**
	 * @generated
 	 */
	public String getSlogan(){
    return slogan; 
  }

	
	/**
	 * @generated
	 */	
	public void setSlogan(String newVal) {
    this.slogan = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean reportWriterEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getReportWriterEnabled(){
    return reportWriterEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setReportWriterEnabled(Boolean newVal) {
    this.reportWriterEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean extendedPriceBookEnabled;
	
	/**
	 * @generated
 	 */
	public Boolean getExtendedPriceBookEnabled(){
    return extendedPriceBookEnabled; 
  }

	
	/**
	 * @generated
	 */	
	public void setExtendedPriceBookEnabled(Boolean newVal) {
    this.extendedPriceBookEnabled = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer maximumTransactionCount;
	
	/**
	 * @generated
 	 */
	public Integer getMaximumTransactionCount(){
    return maximumTransactionCount; 
  }

	
	/**
	 * @generated
	 */	
	public void setMaximumTransactionCount(Integer newVal) {
    this.maximumTransactionCount = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String settings;
	
	/**
	 * @generated
 	 */
	public String getSettings(){
    return settings; 
  }

	
	/**
	 * @generated
	 */	
	public void setSettings(String newVal) {
    this.settings = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String oconfig;
	
	/**
	 * @generated
 	 */
	public String getOconfig(){
    return oconfig; 
  }

	
	/**
	 * @generated
	 */	
	public void setOconfig(String newVal) {
    this.oconfig = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String oprocess;
	
	/**
	 * @generated
 	 */
	public String getOprocess(){
    return oprocess; 
  }

	
	/**
	 * @generated
	 */	
	public void setOprocess(String newVal) {
    this.oprocess = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String oslogan;
	
	/**
	 * @generated
 	 */
	public String getOslogan(){
    return oslogan; 
  }

	
	/**
	 * @generated
	 */	
	public void setOslogan(String newVal) {
    this.oslogan = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String osettings;
	
	/**
	 * @generated
 	 */
	public String getOsettings(){
    return osettings; 
  }

	
	/**
	 * @generated
	 */	
	public void setOsettings(String newVal) {
    this.osettings = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (ELIMINATEWARNINGMESSAGES.equals(propertyName)) return getEliminateWarningMessages();
    if (ONLYPOSTMARKEDREADYINVOICES.equals(propertyName)) return getOnlyPostMarkedReadyInvoices();
    if (ENABLEPRICINGSYSTEM.equals(propertyName)) return getEnablePricingSystem();
    if (ACTIVATEUSEREVENTLOGGING.equals(propertyName)) return getActivateUserEventLogging();
    if (ENABLEAUTOLOGOUT.equals(propertyName)) return getEnableAutoLogOut();
    if (SECONDSOFINACTIVITY.equals(propertyName)) return getSecondsOfInactivity();
    if (AUTOLOGOUTSECONDS.equals(propertyName)) return getAutoLogOutSeconds();
    if (TRIGGERAFTERPOSTING.equals(propertyName)) return getTriggerAfterPosting();
    if (SHOWINVOICESWITHTODAY.equals(propertyName)) return getShowInvoicesWithToday();
    if (LINEITEMTAXES.equals(propertyName)) return getLineItemTaxes();
    if (AUTOMATICQUIT.equals(propertyName)) return getAutomaticQuit();
    if (QUITTIME.equals(propertyName)) return getQuitTime();
    if (SHUTDOWNMESSAGE.equals(propertyName)) return getShutdownMessage();
    if (COMPANYADDRESS.equals(propertyName)) return getCompanyAddress();
    if (COMPANYPHONE.equals(propertyName)) return getCompanyPhone();
    if (COMPANYFAX.equals(propertyName)) return getCompanyFax();
    if (COMPANYEMAIL.equals(propertyName)) return getCompanyEmail();
    if (COMPANYOTHER1.equals(propertyName)) return getCompanyOther1();
    if (COMPANYOTHER2.equals(propertyName)) return getCompanyOther2();
    if (COMPANYIDLABEL.equals(propertyName)) return getCompanyIdLabel();
    if (COMPANYID.equals(propertyName)) return getCompanyId();
    if (COMPANYSTORENUMBER.equals(propertyName)) return getCompanyStoreNumber();
    if (COMPANYSTORELOCATIONREF.equals(propertyName)) return getCompanyStoreLocationRef();
    if (FISCALYEARSTARTMONTH.equals(propertyName)) return getFiscalYearStartMonth();
    if (WORKSUNDAY.equals(propertyName)) return getWorkSunday();
    if (WORKMONDAY.equals(propertyName)) return getWorkMonday();
    if (WORKTUESDAY.equals(propertyName)) return getWorkTuesday();
    if (WORKWEDNESDAY.equals(propertyName)) return getWorkWednesday();
    if (WORKTHURSDAY.equals(propertyName)) return getWorkThursday();
    if (WORKFRIDAY.equals(propertyName)) return getWorkFriday();
    if (WORKSATURDAY.equals(propertyName)) return getWorkSaturday();
    if (WORKFIRSTDAYOFWEEK.equals(propertyName)) return getWorkFirstDayOfWeek();
    if (FUTUREDATESEXCLUDECLOSED.equals(propertyName)) return getFutureDatesExcludeClosed();
    if (NUMBERSINTEGERS.equals(propertyName)) return getNumbersIntegers();
    if (NUMBERSPERCENTAGES.equals(propertyName)) return getNumbersPercentages();
    if (NUMBERSAMOUNT.equals(propertyName)) return getNumbersAmount();
    if (NUMBERSTAXRATE.equals(propertyName)) return getNumbersTaxRate();
    if (NUMBERSRATE.equals(propertyName)) return getNumbersRate();
    if (NUMBERSFACTOR.equals(propertyName)) return getNumbersFactor();
    if (NUMBERSINVOICE.equals(propertyName)) return getNumbersInvoice();
    if (NUMBERSSHORTPERCENT.equals(propertyName)) return getNumbersShortPercent();
    if (NUMBERSROUNDTO.equals(propertyName)) return getNumbersRoundto();
    if (ALWAYSROUNDDOWN.equals(propertyName)) return getAlwaysRoundDown();
    if (ROUNDTAXUP.equals(propertyName)) return getRoundTaxUp();
    if (USEALTERNATECURRENCY.equals(propertyName)) return getUseAlternateCurrency();
    if (DISPLAYFORMAT.equals(propertyName)) return getDisplayFormat();
    if (CONVERSIONFACTOR.equals(propertyName)) return getConversionFactor();
    if (ALTERNATEROUNDTO.equals(propertyName)) return getAlternateRoundto();
    if (ALTERNATEALWAYSROUNDDOWN.equals(propertyName)) return getAlternateAlwaysRoundDown();
    if (DISABLETEXTSTYLES.equals(propertyName)) return getDisableTextStyles();
    if (AUSTRAILIANINVOICEROUNDING.equals(propertyName)) return getAustrailianInvoiceRounding();
    if (DISABLENONTAXABLEOPTIONS.equals(propertyName)) return getDisableNonTaxableOptions();
    if (INKWEIGHTSINGULAR.equals(propertyName)) return getInkWeightSingular();
    if (INKWEIGHTPLURAL.equals(propertyName)) return getInkWeightPlural();
    if (AUTHORIZEDECRYPT.equals(propertyName)) return getAuthorizeDecrypt();
    if (CREDITCARDAPPROVAL.equals(propertyName)) return getCreditCardApproval();
    if (TRACKERDATACOLLECTION.equals(propertyName)) return getTrackerDataCollection();
    if (DEFAULTCOUNTRY.equals(propertyName)) return getDefaultCountry();
    if (SERIALNUMBER.equals(propertyName)) return getSerialNumber();
    if (PROGRAMTYPE.equals(propertyName)) return getProgramType();
    if (WEBENABLED.equals(propertyName)) return getWebEnabled();
    if (PAYMENTPLANENABLED.equals(propertyName)) return getPaymentPlanEnabled();
    if (SCHEDULERENABLED.equals(propertyName)) return getSchedulerEnabled();
    if (TRACKERENABLED.equals(propertyName)) return getTrackerEnabled();
    if (MAXIMUMNODECOUNT.equals(propertyName)) return getMaximumNodeCount();
    if (EXPIRATIONDATE.equals(propertyName)) return getExpirationDate();
    if (CCENCRYPTIONDATA.equals(propertyName)) return getCCEncryptionData();
    if (CONFIG.equals(propertyName)) return getConfig();
    if (PROCESS.equals(propertyName)) return getProcess();
    if (SLOGAN.equals(propertyName)) return getSlogan();
    if (REPORTWRITERENABLED.equals(propertyName)) return getReportWriterEnabled();
    if (EXTENDEDPRICEBOOKENABLED.equals(propertyName)) return getExtendedPriceBookEnabled();
    if (MAXIMUMTRANSACTIONCOUNT.equals(propertyName)) return getMaximumTransactionCount();
    if (SETTINGS.equals(propertyName)) return getSettings();
    if (OCONFIG.equals(propertyName)) return getOconfig();
    if (OPROCESS.equals(propertyName)) return getOprocess();
    if (OSLOGAN.equals(propertyName)) return getOslogan();
    if (OSETTINGS.equals(propertyName)) return getOsettings();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (ELIMINATEWARNINGMESSAGES.equals(propertyName)) setEliminateWarningMessages((Boolean)newValue); else
    if (ONLYPOSTMARKEDREADYINVOICES.equals(propertyName)) setOnlyPostMarkedReadyInvoices((Boolean)newValue); else
    if (ENABLEPRICINGSYSTEM.equals(propertyName)) setEnablePricingSystem((Boolean)newValue); else
    if (ACTIVATEUSEREVENTLOGGING.equals(propertyName)) setActivateUserEventLogging((Boolean)newValue); else
    if (ENABLEAUTOLOGOUT.equals(propertyName)) setEnableAutoLogOut((Boolean)newValue); else
    if (SECONDSOFINACTIVITY.equals(propertyName)) setSecondsOfInactivity((Boolean)newValue); else
    if (AUTOLOGOUTSECONDS.equals(propertyName)) setAutoLogOutSeconds((Integer)newValue); else
    if (TRIGGERAFTERPOSTING.equals(propertyName)) setTriggerAfterPosting((Boolean)newValue); else
    if (SHOWINVOICESWITHTODAY.equals(propertyName)) setShowInvoicesWithToday((Boolean)newValue); else
    if (LINEITEMTAXES.equals(propertyName)) setLineItemTaxes((Boolean)newValue); else
    if (AUTOMATICQUIT.equals(propertyName)) setAutomaticQuit((Boolean)newValue); else
    if (QUITTIME.equals(propertyName)) setQuitTime((String)newValue); else
    if (SHUTDOWNMESSAGE.equals(propertyName)) setShutdownMessage((String)newValue); else
    if (COMPANYADDRESS.equals(propertyName)) setCompanyAddress((Address)newValue); else
    if (COMPANYPHONE.equals(propertyName)) setCompanyPhone((String)newValue); else
    if (COMPANYFAX.equals(propertyName)) setCompanyFax((String)newValue); else
    if (COMPANYEMAIL.equals(propertyName)) setCompanyEmail((String)newValue); else
    if (COMPANYOTHER1.equals(propertyName)) setCompanyOther1((String)newValue); else
    if (COMPANYOTHER2.equals(propertyName)) setCompanyOther2((String)newValue); else
    if (COMPANYIDLABEL.equals(propertyName)) setCompanyIdLabel((String)newValue); else
    if (COMPANYID.equals(propertyName)) setCompanyId((String)newValue); else
    if (COMPANYSTORENUMBER.equals(propertyName)) setCompanyStoreNumber((String)newValue); else
    if (COMPANYSTORELOCATIONREF.equals(propertyName)) setCompanyStoreLocationRef((String)newValue); else
    if (FISCALYEARSTARTMONTH.equals(propertyName)) setFiscalYearStartMonth((String)newValue); else
    if (WORKSUNDAY.equals(propertyName)) setWorkSunday((Boolean)newValue); else
    if (WORKMONDAY.equals(propertyName)) setWorkMonday((Boolean)newValue); else
    if (WORKTUESDAY.equals(propertyName)) setWorkTuesday((Boolean)newValue); else
    if (WORKWEDNESDAY.equals(propertyName)) setWorkWednesday((Boolean)newValue); else
    if (WORKTHURSDAY.equals(propertyName)) setWorkThursday((Boolean)newValue); else
    if (WORKFRIDAY.equals(propertyName)) setWorkFriday((Boolean)newValue); else
    if (WORKSATURDAY.equals(propertyName)) setWorkSaturday((Boolean)newValue); else
    if (WORKFIRSTDAYOFWEEK.equals(propertyName)) setWorkFirstDayOfWeek((Integer)newValue); else
    if (FUTUREDATESEXCLUDECLOSED.equals(propertyName)) setFutureDatesExcludeClosed((Boolean)newValue); else
    if (NUMBERSINTEGERS.equals(propertyName)) setNumbersIntegers((String)newValue); else
    if (NUMBERSPERCENTAGES.equals(propertyName)) setNumbersPercentages((String)newValue); else
    if (NUMBERSAMOUNT.equals(propertyName)) setNumbersAmount((String)newValue); else
    if (NUMBERSTAXRATE.equals(propertyName)) setNumbersTaxRate((String)newValue); else
    if (NUMBERSRATE.equals(propertyName)) setNumbersRate((String)newValue); else
    if (NUMBERSFACTOR.equals(propertyName)) setNumbersFactor((String)newValue); else
    if (NUMBERSINVOICE.equals(propertyName)) setNumbersInvoice((String)newValue); else
    if (NUMBERSSHORTPERCENT.equals(propertyName)) setNumbersShortPercent((String)newValue); else
    if (NUMBERSROUNDTO.equals(propertyName)) setNumbersRoundto((Integer)newValue); else
    if (ALWAYSROUNDDOWN.equals(propertyName)) setAlwaysRoundDown((Boolean)newValue); else
    if (ROUNDTAXUP.equals(propertyName)) setRoundTaxUp((Boolean)newValue); else
    if (USEALTERNATECURRENCY.equals(propertyName)) setUseAlternateCurrency((Boolean)newValue); else
    if (DISPLAYFORMAT.equals(propertyName)) setDisplayFormat((String)newValue); else
    if (CONVERSIONFACTOR.equals(propertyName)) setConversionFactor((Double)newValue); else
    if (ALTERNATEROUNDTO.equals(propertyName)) setAlternateRoundto((Integer)newValue); else
    if (ALTERNATEALWAYSROUNDDOWN.equals(propertyName)) setAlternateAlwaysRoundDown((Boolean)newValue); else
    if (DISABLETEXTSTYLES.equals(propertyName)) setDisableTextStyles((Boolean)newValue); else
    if (AUSTRAILIANINVOICEROUNDING.equals(propertyName)) setAustrailianInvoiceRounding((Boolean)newValue); else
    if (DISABLENONTAXABLEOPTIONS.equals(propertyName)) setDisableNonTaxableOptions((Boolean)newValue); else
    if (INKWEIGHTSINGULAR.equals(propertyName)) setInkWeightSingular((String)newValue); else
    if (INKWEIGHTPLURAL.equals(propertyName)) setInkWeightPlural((String)newValue); else
    if (AUTHORIZEDECRYPT.equals(propertyName)) setAuthorizeDecrypt((String)newValue); else
    if (CREDITCARDAPPROVAL.equals(propertyName)) setCreditCardApproval((String)newValue); else
    if (TRACKERDATACOLLECTION.equals(propertyName)) setTrackerDataCollection((String)newValue); else
    if (DEFAULTCOUNTRY.equals(propertyName)) setDefaultCountry((Integer)newValue); else
    if (SERIALNUMBER.equals(propertyName)) setSerialNumber((Long)newValue); else
    if (PROGRAMTYPE.equals(propertyName)) setProgramType((String)newValue); else
    if (WEBENABLED.equals(propertyName)) setWebEnabled((Boolean)newValue); else
    if (PAYMENTPLANENABLED.equals(propertyName)) setPaymentPlanEnabled((Boolean)newValue); else
    if (SCHEDULERENABLED.equals(propertyName)) setSchedulerEnabled((Boolean)newValue); else
    if (TRACKERENABLED.equals(propertyName)) setTrackerEnabled((Boolean)newValue); else
    if (MAXIMUMNODECOUNT.equals(propertyName)) setMaximumNodeCount((Integer)newValue); else
    if (EXPIRATIONDATE.equals(propertyName)) setExpirationDate((Date)newValue); else
    if (CCENCRYPTIONDATA.equals(propertyName)) setCCEncryptionData((String)newValue); else
    if (CONFIG.equals(propertyName)) setConfig((String)newValue); else
    if (PROCESS.equals(propertyName)) setProcess((String)newValue); else
    if (SLOGAN.equals(propertyName)) setSlogan((String)newValue); else
    if (REPORTWRITERENABLED.equals(propertyName)) setReportWriterEnabled((Boolean)newValue); else
    if (EXTENDEDPRICEBOOKENABLED.equals(propertyName)) setExtendedPriceBookEnabled((Boolean)newValue); else
    if (MAXIMUMTRANSACTIONCOUNT.equals(propertyName)) setMaximumTransactionCount((Integer)newValue); else
    if (SETTINGS.equals(propertyName)) setSettings((String)newValue); else
    if (OCONFIG.equals(propertyName)) setOconfig((String)newValue); else
    if (OPROCESS.equals(propertyName)) setOprocess((String)newValue); else
    if (OSLOGAN.equals(propertyName)) setOslogan((String)newValue); else
    if (OSETTINGS.equals(propertyName)) setOsettings((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (ELIMINATEWARNINGMESSAGES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ONLYPOSTMARKEDREADYINVOICES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ENABLEPRICINGSYSTEM.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ACTIVATEUSEREVENTLOGGING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ENABLEAUTOLOGOUT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SECONDSOFINACTIVITY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AUTOLOGOUTSECONDS.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (TRIGGERAFTERPOSTING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SHOWINVOICESWITHTODAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (LINEITEMTAXES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AUTOMATICQUIT.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (QUITTIME.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SHUTDOWNMESSAGE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYADDRESS.equals(propertyName)) 
      return new Class<?>[] {Address.class};		
    if (COMPANYPHONE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYFAX.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYEMAIL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYOTHER1.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYOTHER2.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYIDLABEL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYSTORENUMBER.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (COMPANYSTORELOCATIONREF.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (FISCALYEARSTARTMONTH.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WORKSUNDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKMONDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKTUESDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKWEDNESDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKTHURSDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKFRIDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKSATURDAY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (WORKFIRSTDAYOFWEEK.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (FUTUREDATESEXCLUDECLOSED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (NUMBERSINTEGERS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSPERCENTAGES.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSAMOUNT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSTAXRATE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSRATE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSFACTOR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSINVOICE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSSHORTPERCENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (NUMBERSROUNDTO.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ALWAYSROUNDDOWN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (ROUNDTAXUP.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (USEALTERNATECURRENCY.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DISPLAYFORMAT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CONVERSIONFACTOR.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ALTERNATEROUNDTO.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (ALTERNATEALWAYSROUNDDOWN.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DISABLETEXTSTYLES.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (AUSTRAILIANINVOICEROUNDING.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (DISABLENONTAXABLEOPTIONS.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (INKWEIGHTSINGULAR.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (INKWEIGHTPLURAL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (AUTHORIZEDECRYPT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CREDITCARDAPPROVAL.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (TRACKERDATACOLLECTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DEFAULTCOUNTRY.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (SERIALNUMBER.equals(propertyName)) 
      return new Class<?>[] {Long.class};		
    if (PROGRAMTYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (PAYMENTPLANENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (SCHEDULERENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (TRACKERENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MAXIMUMNODECOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (EXPIRATIONDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (CCENCRYPTIONDATA.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (CONFIG.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (PROCESS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (SLOGAN.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (REPORTWRITERENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (EXTENDEDPRICEBOOKENABLED.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
    if (MAXIMUMTRANSACTIONCOUNT.equals(propertyName)) 
      return new Class<?>[] {Integer.class};		
    if (SETTINGS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (OCONFIG.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (OPROCESS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (OSLOGAN.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (OSETTINGS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (ELIMINATEWARNINGMESSAGES.equals(propertyName)) return PreferencesSystem.class;
    if (ONLYPOSTMARKEDREADYINVOICES.equals(propertyName)) return PreferencesSystem.class;
    if (ENABLEPRICINGSYSTEM.equals(propertyName)) return PreferencesSystem.class;
    if (ACTIVATEUSEREVENTLOGGING.equals(propertyName)) return PreferencesSystem.class;
    if (ENABLEAUTOLOGOUT.equals(propertyName)) return PreferencesSystem.class;
    if (SECONDSOFINACTIVITY.equals(propertyName)) return PreferencesSystem.class;
    if (AUTOLOGOUTSECONDS.equals(propertyName)) return PreferencesSystem.class;
    if (TRIGGERAFTERPOSTING.equals(propertyName)) return PreferencesSystem.class;
    if (SHOWINVOICESWITHTODAY.equals(propertyName)) return PreferencesSystem.class;
    if (LINEITEMTAXES.equals(propertyName)) return PreferencesSystem.class;
    if (AUTOMATICQUIT.equals(propertyName)) return PreferencesSystem.class;
    if (QUITTIME.equals(propertyName)) return PreferencesSystem.class;
    if (SHUTDOWNMESSAGE.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYADDRESS.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYPHONE.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYFAX.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYEMAIL.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYOTHER1.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYOTHER2.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYIDLABEL.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYID.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYSTORENUMBER.equals(propertyName)) return PreferencesSystem.class;
    if (COMPANYSTORELOCATIONREF.equals(propertyName)) return PreferencesSystem.class;
    if (FISCALYEARSTARTMONTH.equals(propertyName)) return PreferencesSystem.class;
    if (WORKSUNDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKMONDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKTUESDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKWEDNESDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKTHURSDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKFRIDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKSATURDAY.equals(propertyName)) return PreferencesSystem.class;
    if (WORKFIRSTDAYOFWEEK.equals(propertyName)) return PreferencesSystem.class;
    if (FUTUREDATESEXCLUDECLOSED.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSINTEGERS.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSPERCENTAGES.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSAMOUNT.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSTAXRATE.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSRATE.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSFACTOR.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSINVOICE.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSSHORTPERCENT.equals(propertyName)) return PreferencesSystem.class;
    if (NUMBERSROUNDTO.equals(propertyName)) return PreferencesSystem.class;
    if (ALWAYSROUNDDOWN.equals(propertyName)) return PreferencesSystem.class;
    if (ROUNDTAXUP.equals(propertyName)) return PreferencesSystem.class;
    if (USEALTERNATECURRENCY.equals(propertyName)) return PreferencesSystem.class;
    if (DISPLAYFORMAT.equals(propertyName)) return PreferencesSystem.class;
    if (CONVERSIONFACTOR.equals(propertyName)) return PreferencesSystem.class;
    if (ALTERNATEROUNDTO.equals(propertyName)) return PreferencesSystem.class;
    if (ALTERNATEALWAYSROUNDDOWN.equals(propertyName)) return PreferencesSystem.class;
    if (DISABLETEXTSTYLES.equals(propertyName)) return PreferencesSystem.class;
    if (AUSTRAILIANINVOICEROUNDING.equals(propertyName)) return PreferencesSystem.class;
    if (DISABLENONTAXABLEOPTIONS.equals(propertyName)) return PreferencesSystem.class;
    if (INKWEIGHTSINGULAR.equals(propertyName)) return PreferencesSystem.class;
    if (INKWEIGHTPLURAL.equals(propertyName)) return PreferencesSystem.class;
    if (AUTHORIZEDECRYPT.equals(propertyName)) return PreferencesSystem.class;
    if (CREDITCARDAPPROVAL.equals(propertyName)) return PreferencesSystem.class;
    if (TRACKERDATACOLLECTION.equals(propertyName)) return PreferencesSystem.class;
    if (DEFAULTCOUNTRY.equals(propertyName)) return PreferencesSystem.class;
    if (SERIALNUMBER.equals(propertyName)) return PreferencesSystem.class;
    if (PROGRAMTYPE.equals(propertyName)) return PreferencesSystem.class;
    if (WEBENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (PAYMENTPLANENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (SCHEDULERENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (TRACKERENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (MAXIMUMNODECOUNT.equals(propertyName)) return PreferencesSystem.class;
    if (EXPIRATIONDATE.equals(propertyName)) return PreferencesSystem.class;
    if (CCENCRYPTIONDATA.equals(propertyName)) return PreferencesSystem.class;
    if (CONFIG.equals(propertyName)) return PreferencesSystem.class;
    if (PROCESS.equals(propertyName)) return PreferencesSystem.class;
    if (SLOGAN.equals(propertyName)) return PreferencesSystem.class;
    if (REPORTWRITERENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (EXTENDEDPRICEBOOKENABLED.equals(propertyName)) return PreferencesSystem.class;
    if (MAXIMUMTRANSACTIONCOUNT.equals(propertyName)) return PreferencesSystem.class;
    if (SETTINGS.equals(propertyName)) return PreferencesSystem.class;
    if (OCONFIG.equals(propertyName)) return PreferencesSystem.class;
    if (OPROCESS.equals(propertyName)) return PreferencesSystem.class;
    if (OSLOGAN.equals(propertyName)) return PreferencesSystem.class;
    if (OSETTINGS.equals(propertyName)) return PreferencesSystem.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    PreferencesSystem objT = (PreferencesSystem)obj;
    if (! SmartEquals(getEliminateWarningMessages(), objT.getEliminateWarningMessages()))
      return false;
    if (! SmartEquals(getOnlyPostMarkedReadyInvoices(), objT.getOnlyPostMarkedReadyInvoices()))
      return false;
    if (! SmartEquals(getEnablePricingSystem(), objT.getEnablePricingSystem()))
      return false;
    if (! SmartEquals(getActivateUserEventLogging(), objT.getActivateUserEventLogging()))
      return false;
    if (! SmartEquals(getEnableAutoLogOut(), objT.getEnableAutoLogOut()))
      return false;
    if (! SmartEquals(getSecondsOfInactivity(), objT.getSecondsOfInactivity()))
      return false;
    if (! SmartEquals(getAutoLogOutSeconds(), objT.getAutoLogOutSeconds()))
      return false;
    if (! SmartEquals(getTriggerAfterPosting(), objT.getTriggerAfterPosting()))
      return false;
    if (! SmartEquals(getShowInvoicesWithToday(), objT.getShowInvoicesWithToday()))
      return false;
    if (! SmartEquals(getLineItemTaxes(), objT.getLineItemTaxes()))
      return false;
    if (! SmartEquals(getAutomaticQuit(), objT.getAutomaticQuit()))
      return false;
    if (! SmartEquals(getQuitTime(), objT.getQuitTime()))
      return false;
    if (! SmartEquals(getShutdownMessage(), objT.getShutdownMessage()))
      return false;
    if (! SmartEquals(getCompanyAddress(), objT.getCompanyAddress()))
      return false;
    if (! SmartEquals(getCompanyPhone(), objT.getCompanyPhone()))
      return false;
    if (! SmartEquals(getCompanyFax(), objT.getCompanyFax()))
      return false;
    if (! SmartEquals(getCompanyEmail(), objT.getCompanyEmail()))
      return false;
    if (! SmartEquals(getCompanyOther1(), objT.getCompanyOther1()))
      return false;
    if (! SmartEquals(getCompanyOther2(), objT.getCompanyOther2()))
      return false;
    if (! SmartEquals(getCompanyIdLabel(), objT.getCompanyIdLabel()))
      return false;
    if (! SmartEquals(getCompanyId(), objT.getCompanyId()))
      return false;
    if (! SmartEquals(getCompanyStoreNumber(), objT.getCompanyStoreNumber()))
      return false;
    if (! SmartEquals(getCompanyStoreLocationRef(), objT.getCompanyStoreLocationRef()))
      return false;
    if (! SmartEquals(getFiscalYearStartMonth(), objT.getFiscalYearStartMonth()))
      return false;
    if (! SmartEquals(getWorkSunday(), objT.getWorkSunday()))
      return false;
    if (! SmartEquals(getWorkMonday(), objT.getWorkMonday()))
      return false;
    if (! SmartEquals(getWorkTuesday(), objT.getWorkTuesday()))
      return false;
    if (! SmartEquals(getWorkWednesday(), objT.getWorkWednesday()))
      return false;
    if (! SmartEquals(getWorkThursday(), objT.getWorkThursday()))
      return false;
    if (! SmartEquals(getWorkFriday(), objT.getWorkFriday()))
      return false;
    if (! SmartEquals(getWorkSaturday(), objT.getWorkSaturday()))
      return false;
    if (! SmartEquals(getWorkFirstDayOfWeek(), objT.getWorkFirstDayOfWeek()))
      return false;
    if (! SmartEquals(getFutureDatesExcludeClosed(), objT.getFutureDatesExcludeClosed()))
      return false;
    if (! SmartEquals(getNumbersIntegers(), objT.getNumbersIntegers()))
      return false;
    if (! SmartEquals(getNumbersPercentages(), objT.getNumbersPercentages()))
      return false;
    if (! SmartEquals(getNumbersAmount(), objT.getNumbersAmount()))
      return false;
    if (! SmartEquals(getNumbersTaxRate(), objT.getNumbersTaxRate()))
      return false;
    if (! SmartEquals(getNumbersRate(), objT.getNumbersRate()))
      return false;
    if (! SmartEquals(getNumbersFactor(), objT.getNumbersFactor()))
      return false;
    if (! SmartEquals(getNumbersInvoice(), objT.getNumbersInvoice()))
      return false;
    if (! SmartEquals(getNumbersShortPercent(), objT.getNumbersShortPercent()))
      return false;
    if (! SmartEquals(getNumbersRoundto(), objT.getNumbersRoundto()))
      return false;
    if (! SmartEquals(getAlwaysRoundDown(), objT.getAlwaysRoundDown()))
      return false;
    if (! SmartEquals(getRoundTaxUp(), objT.getRoundTaxUp()))
      return false;
    if (! SmartEquals(getUseAlternateCurrency(), objT.getUseAlternateCurrency()))
      return false;
    if (! SmartEquals(getDisplayFormat(), objT.getDisplayFormat()))
      return false;
    if (! SmartEquals(getConversionFactor(), objT.getConversionFactor()))
      return false;
    if (! SmartEquals(getAlternateRoundto(), objT.getAlternateRoundto()))
      return false;
    if (! SmartEquals(getAlternateAlwaysRoundDown(), objT.getAlternateAlwaysRoundDown()))
      return false;
    if (! SmartEquals(getDisableTextStyles(), objT.getDisableTextStyles()))
      return false;
    if (! SmartEquals(getAustrailianInvoiceRounding(), objT.getAustrailianInvoiceRounding()))
      return false;
    if (! SmartEquals(getDisableNonTaxableOptions(), objT.getDisableNonTaxableOptions()))
      return false;
    if (! SmartEquals(getInkWeightSingular(), objT.getInkWeightSingular()))
      return false;
    if (! SmartEquals(getInkWeightPlural(), objT.getInkWeightPlural()))
      return false;
    if (! SmartEquals(getAuthorizeDecrypt(), objT.getAuthorizeDecrypt()))
      return false;
    if (! SmartEquals(getCreditCardApproval(), objT.getCreditCardApproval()))
      return false;
    if (! SmartEquals(getTrackerDataCollection(), objT.getTrackerDataCollection()))
      return false;
    if (! SmartEquals(getDefaultCountry(), objT.getDefaultCountry()))
      return false;
    if (! SmartEquals(getSerialNumber(), objT.getSerialNumber()))
      return false;
    if (! SmartEquals(getProgramType(), objT.getProgramType()))
      return false;
    if (! SmartEquals(getWebEnabled(), objT.getWebEnabled()))
      return false;
    if (! SmartEquals(getPaymentPlanEnabled(), objT.getPaymentPlanEnabled()))
      return false;
    if (! SmartEquals(getSchedulerEnabled(), objT.getSchedulerEnabled()))
      return false;
    if (! SmartEquals(getTrackerEnabled(), objT.getTrackerEnabled()))
      return false;
    if (! SmartEquals(getMaximumNodeCount(), objT.getMaximumNodeCount()))
      return false;
    if (! SmartEquals(getExpirationDate(), objT.getExpirationDate()))
      return false;
    if (! SmartEquals(getCCEncryptionData(), objT.getCCEncryptionData()))
      return false;
    if (! SmartEquals(getConfig(), objT.getConfig()))
      return false;
    if (! SmartEquals(getProcess(), objT.getProcess()))
      return false;
    if (! SmartEquals(getSlogan(), objT.getSlogan()))
      return false;
    if (! SmartEquals(getReportWriterEnabled(), objT.getReportWriterEnabled()))
      return false;
    if (! SmartEquals(getExtendedPriceBookEnabled(), objT.getExtendedPriceBookEnabled()))
      return false;
    if (! SmartEquals(getMaximumTransactionCount(), objT.getMaximumTransactionCount()))
      return false;
    if (! SmartEquals(getSettings(), objT.getSettings()))
      return false;
    if (! SmartEquals(getOconfig(), objT.getOconfig()))
      return false;
    if (! SmartEquals(getOprocess(), objT.getOprocess()))
      return false;
    if (! SmartEquals(getOslogan(), objT.getOslogan()))
      return false;
    if (! SmartEquals(getOsettings(), objT.getOsettings()))
      return false;
    return true;
  }			
}
