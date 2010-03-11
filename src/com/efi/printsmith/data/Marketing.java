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
 * @generated
 */	
@NamedQueries({
	@NamedQuery(name = "Marketing.findall", query = "from Marketing"),
	@NamedQuery(name = "Marketing.byId", query = "select a from Marketing a where a.id= :id")
})


@Entity
@Table(name = "marketing")
public class Marketing extends ModelBase {
	/**
	 * @generated
	 */
	public static final String MARKETID = "MarketID";
	/**
	 * @generated
	 */
	public static final String FOLLOWUP = "Followup";
	/**
	 * @generated
	 */
	public static final String BIRTHDATE = "BirthDate";
	/**
	 * @generated
	 */
	public static final String USER3 = "User3";
	/**
	 * @generated
	 */
	public static final String USER4 = "User4";
	/**
	 * @generated
	 */
	public static final String USER5 = "User5";
	/**
	 * @generated
	 */
	public static final String LEADSOURCE = "LeadSource";
	/**
	 * @generated
	 */
	public static final String LEADSOURCE2 = "LeadSource2";
	/**
	 * @generated
	 */
	public static final String COMMONINTERST = "CommonInterst";
	/**
	 * @generated
	 */
	public static final String SPORTSINTERST = "SportsInterst";
	/**
	 * @generated
	 */
	public static final String USER6 = "User6";
	/**
	 * @generated
	 */
	public static final String USER7 = "User7";
	/**
	 * @generated
	 */
	public static final String USER8 = "User8";
	/**
	 * @generated
	 */
	public static final String USER9 = "User9";
	/**
	 * @generated
	 */
	public static final String TYPEWORK = "TypeWork";
	/**
	 * @generated
	 */
	public static final String MAILERTYPE = "MailerType";
	/**
	 * @generated
	 */
	public static final String CUSTOMER = "Customer";
	/**
	 * @generated
	 */
	public static final String PROSPECT = "Prospect";
	/**
	 * @generated
	 */
	public static final String NOMAIL = "NoMail";
	/**
	 * @generated
	 */
	public static final String PERSONALACCT = "PersonalAcct";
	/**
	 * @generated
	 */
	public static final String NUMBEROFEMPLOYEES = "NumberofEmployees";
	/**
	 * @generated
	 */
	public static final String ANNUALREV = "AnnualRev";
	/**
	 * @generated
	 */
	public static final String BUSINESSTYPE = "BusinessType";

	/**
	 * @generated
	 */
	public Marketing() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer marketID;
	
	/**
	 * @generated
 	 */
	public Integer getMarketID(){
		return marketID; 
	}

	
	/**
	 * @generated
	 */	
	public void setMarketID(Integer newVal) {
		this.marketID = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date followup;
	
	/**
	 * @generated
 	 */
	public Date getFollowup(){
		return followup; 
	}

	
	/**
	 * @generated
	 */	
	public void setFollowup(Date newVal) {
		this.followup = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date birthDate;
	
	/**
	 * @generated
 	 */
	public Date getBirthDate(){
		return birthDate; 
	}

	
	/**
	 * @generated
	 */	
	public void setBirthDate(Date newVal) {
		this.birthDate = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date user3;
	
	/**
	 * @generated
 	 */
	public Date getUser3(){
		return user3; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser3(Date newVal) {
		this.user3 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date user4;
	
	/**
	 * @generated
 	 */
	public Date getUser4(){
		return user4; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser4(Date newVal) {
		this.user4 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date user5;
	
	/**
	 * @generated
 	 */
	public Date getUser5(){
		return user5; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser5(Date newVal) {
		this.user5 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String leadSource;
	
	/**
	 * @generated
 	 */
	public String getLeadSource(){
		return leadSource; 
	}

	
	/**
	 * @generated
	 */	
	public void setLeadSource(String newVal) {
		this.leadSource = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String leadSource2;
	
	/**
	 * @generated
 	 */
	public String getLeadSource2(){
		return leadSource2; 
	}

	
	/**
	 * @generated
	 */	
	public void setLeadSource2(String newVal) {
		this.leadSource2 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String commonInterst;
	
	/**
	 * @generated
 	 */
	public String getCommonInterst(){
		return commonInterst; 
	}

	
	/**
	 * @generated
	 */	
	public void setCommonInterst(String newVal) {
		this.commonInterst = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String sportsInterst;
	
	/**
	 * @generated
 	 */
	public String getSportsInterst(){
		return sportsInterst; 
	}

	
	/**
	 * @generated
	 */	
	public void setSportsInterst(String newVal) {
		this.sportsInterst = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String user6;
	
	/**
	 * @generated
 	 */
	public String getUser6(){
		return user6; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser6(String newVal) {
		this.user6 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String user7;
	
	/**
	 * @generated
 	 */
	public String getUser7(){
		return user7; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser7(String newVal) {
		this.user7 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String user8;
	
	/**
	 * @generated
 	 */
	public String getUser8(){
		return user8; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser8(String newVal) {
		this.user8 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String user9;
	
	/**
	 * @generated
 	 */
	public String getUser9(){
		return user9; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser9(String newVal) {
		this.user9 = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String typeWork;
	
	/**
	 * @generated
 	 */
	public String getTypeWork(){
		return typeWork; 
	}

	
	/**
	 * @generated
	 */	
	public void setTypeWork(String newVal) {
		this.typeWork = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String mailerType;
	
	/**
	 * @generated
 	 */
	public String getMailerType(){
		return mailerType; 
	}

	
	/**
	 * @generated
	 */	
	public void setMailerType(String newVal) {
		this.mailerType = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean customer;
	
	/**
	 * @generated
 	 */
	public Boolean getCustomer(){
		return customer; 
	}

	
	/**
	 * @generated
	 */	
	public void setCustomer(Boolean newVal) {
		this.customer = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean prospect;
	
	/**
	 * @generated
 	 */
	public Boolean getProspect(){
		return prospect; 
	}

	
	/**
	 * @generated
	 */	
	public void setProspect(Boolean newVal) {
		this.prospect = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean noMail;
	
	/**
	 * @generated
 	 */
	public Boolean getNoMail(){
		return noMail; 
	}

	
	/**
	 * @generated
	 */	
	public void setNoMail(Boolean newVal) {
		this.noMail = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean personalAcct;
	
	/**
	 * @generated
 	 */
	public Boolean getPersonalAcct(){
		return personalAcct; 
	}

	
	/**
	 * @generated
	 */	
	public void setPersonalAcct(Boolean newVal) {
		this.personalAcct = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer numberofEmployees;
	
	/**
	 * @generated
 	 */
	public Integer getNumberofEmployees(){
		return numberofEmployees; 
	}

	
	/**
	 * @generated
	 */	
	public void setNumberofEmployees(Integer newVal) {
		this.numberofEmployees = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer annualRev;
	
	/**
	 * @generated
 	 */
	public Integer getAnnualRev(){
		return annualRev; 
	}

	
	/**
	 * @generated
	 */	
	public void setAnnualRev(Integer newVal) {
		this.annualRev = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private BusinessType businessType;
	
	/**
	 * @generated
 	 */
	public BusinessType getBusinessType(){
		return businessType; 
	}

	
	/**
	 * @generated
	 */	
	public void setBusinessType(BusinessType newVal) {
		this.businessType = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (MARKETID.equals(propertyName)) return getMarketID();
		if (FOLLOWUP.equals(propertyName)) return getFollowup();
		if (BIRTHDATE.equals(propertyName)) return getBirthDate();
		if (USER3.equals(propertyName)) return getUser3();
		if (USER4.equals(propertyName)) return getUser4();
		if (USER5.equals(propertyName)) return getUser5();
		if (LEADSOURCE.equals(propertyName)) return getLeadSource();
		if (LEADSOURCE2.equals(propertyName)) return getLeadSource2();
		if (COMMONINTERST.equals(propertyName)) return getCommonInterst();
		if (SPORTSINTERST.equals(propertyName)) return getSportsInterst();
		if (USER6.equals(propertyName)) return getUser6();
		if (USER7.equals(propertyName)) return getUser7();
		if (USER8.equals(propertyName)) return getUser8();
		if (USER9.equals(propertyName)) return getUser9();
		if (TYPEWORK.equals(propertyName)) return getTypeWork();
		if (MAILERTYPE.equals(propertyName)) return getMailerType();
		if (CUSTOMER.equals(propertyName)) return getCustomer();
		if (PROSPECT.equals(propertyName)) return getProspect();
		if (NOMAIL.equals(propertyName)) return getNoMail();
		if (PERSONALACCT.equals(propertyName)) return getPersonalAcct();
		if (NUMBEROFEMPLOYEES.equals(propertyName)) return getNumberofEmployees();
		if (ANNUALREV.equals(propertyName)) return getAnnualRev();
		if (BUSINESSTYPE.equals(propertyName)) return getBusinessType();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (MARKETID.equals(propertyName)) setMarketID((Integer)newValue); else
		if (FOLLOWUP.equals(propertyName)) setFollowup((Date)newValue); else
		if (BIRTHDATE.equals(propertyName)) setBirthDate((Date)newValue); else
		if (USER3.equals(propertyName)) setUser3((Date)newValue); else
		if (USER4.equals(propertyName)) setUser4((Date)newValue); else
		if (USER5.equals(propertyName)) setUser5((Date)newValue); else
		if (LEADSOURCE.equals(propertyName)) setLeadSource((String)newValue); else
		if (LEADSOURCE2.equals(propertyName)) setLeadSource2((String)newValue); else
		if (COMMONINTERST.equals(propertyName)) setCommonInterst((String)newValue); else
		if (SPORTSINTERST.equals(propertyName)) setSportsInterst((String)newValue); else
		if (USER6.equals(propertyName)) setUser6((String)newValue); else
		if (USER7.equals(propertyName)) setUser7((String)newValue); else
		if (USER8.equals(propertyName)) setUser8((String)newValue); else
		if (USER9.equals(propertyName)) setUser9((String)newValue); else
		if (TYPEWORK.equals(propertyName)) setTypeWork((String)newValue); else
		if (MAILERTYPE.equals(propertyName)) setMailerType((String)newValue); else
		if (CUSTOMER.equals(propertyName)) setCustomer((Boolean)newValue); else
		if (PROSPECT.equals(propertyName)) setProspect((Boolean)newValue); else
		if (NOMAIL.equals(propertyName)) setNoMail((Boolean)newValue); else
		if (PERSONALACCT.equals(propertyName)) setPersonalAcct((Boolean)newValue); else
		if (NUMBEROFEMPLOYEES.equals(propertyName)) setNumberofEmployees((Integer)newValue); else
		if (ANNUALREV.equals(propertyName)) setAnnualRev((Integer)newValue); else
		if (BUSINESSTYPE.equals(propertyName)) setBusinessType((BusinessType)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (MARKETID.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FOLLOWUP.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (BIRTHDATE.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (USER3.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (USER4.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (USER5.equals(propertyName)) 
			return new Class<?>[] {Date.class};		
		if (LEADSOURCE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LEADSOURCE2.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COMMONINTERST.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SPORTSINTERST.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USER6.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USER7.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USER8.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USER9.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TYPEWORK.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (MAILERTYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CUSTOMER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PROSPECT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NOMAIL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PERSONALACCT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (NUMBEROFEMPLOYEES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (ANNUALREV.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BUSINESSTYPE.equals(propertyName)) 
			return new Class<?>[] {BusinessType.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (MARKETID.equals(propertyName)) return Marketing.class;
		if (FOLLOWUP.equals(propertyName)) return Marketing.class;
		if (BIRTHDATE.equals(propertyName)) return Marketing.class;
		if (USER3.equals(propertyName)) return Marketing.class;
		if (USER4.equals(propertyName)) return Marketing.class;
		if (USER5.equals(propertyName)) return Marketing.class;
		if (LEADSOURCE.equals(propertyName)) return Marketing.class;
		if (LEADSOURCE2.equals(propertyName)) return Marketing.class;
		if (COMMONINTERST.equals(propertyName)) return Marketing.class;
		if (SPORTSINTERST.equals(propertyName)) return Marketing.class;
		if (USER6.equals(propertyName)) return Marketing.class;
		if (USER7.equals(propertyName)) return Marketing.class;
		if (USER8.equals(propertyName)) return Marketing.class;
		if (USER9.equals(propertyName)) return Marketing.class;
		if (TYPEWORK.equals(propertyName)) return Marketing.class;
		if (MAILERTYPE.equals(propertyName)) return Marketing.class;
		if (CUSTOMER.equals(propertyName)) return Marketing.class;
		if (PROSPECT.equals(propertyName)) return Marketing.class;
		if (NOMAIL.equals(propertyName)) return Marketing.class;
		if (PERSONALACCT.equals(propertyName)) return Marketing.class;
		if (NUMBEROFEMPLOYEES.equals(propertyName)) return Marketing.class;
		if (ANNUALREV.equals(propertyName)) return Marketing.class;
		if (BUSINESSTYPE.equals(propertyName)) return Marketing.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		Marketing objT = (Marketing)obj;
		if (! SmartEquals(getMarketID(), objT.getMarketID()))
			return false;
		if (! SmartEquals(getFollowup(), objT.getFollowup()))
			return false;
		if (! SmartEquals(getBirthDate(), objT.getBirthDate()))
			return false;
		if (! SmartEquals(getUser3(), objT.getUser3()))
			return false;
		if (! SmartEquals(getUser4(), objT.getUser4()))
			return false;
		if (! SmartEquals(getUser5(), objT.getUser5()))
			return false;
		if (! SmartEquals(getLeadSource(), objT.getLeadSource()))
			return false;
		if (! SmartEquals(getLeadSource2(), objT.getLeadSource2()))
			return false;
		if (! SmartEquals(getCommonInterst(), objT.getCommonInterst()))
			return false;
		if (! SmartEquals(getSportsInterst(), objT.getSportsInterst()))
			return false;
		if (! SmartEquals(getUser6(), objT.getUser6()))
			return false;
		if (! SmartEquals(getUser7(), objT.getUser7()))
			return false;
		if (! SmartEquals(getUser8(), objT.getUser8()))
			return false;
		if (! SmartEquals(getUser9(), objT.getUser9()))
			return false;
		if (! SmartEquals(getTypeWork(), objT.getTypeWork()))
			return false;
		if (! SmartEquals(getMailerType(), objT.getMailerType()))
			return false;
		if (! SmartEquals(getCustomer(), objT.getCustomer()))
			return false;
		if (! SmartEquals(getProspect(), objT.getProspect()))
			return false;
		if (! SmartEquals(getNoMail(), objT.getNoMail()))
			return false;
		if (! SmartEquals(getPersonalAcct(), objT.getPersonalAcct()))
			return false;
		if (! SmartEquals(getNumberofEmployees(), objT.getNumberofEmployees()))
			return false;
		if (! SmartEquals(getAnnualRev(), objT.getAnnualRev()))
			return false;
		if (! SmartEquals(getBusinessType(), objT.getBusinessType()))
			return false;
		return true;
	}			
}