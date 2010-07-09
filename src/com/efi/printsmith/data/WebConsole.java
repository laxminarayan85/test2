
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
  @NamedQuery(name = "WebConsole.findall", query = "from WebConsole"),
  @NamedQuery(name = "WebConsole.byId", query = "select a from WebConsole a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "webconsole")
public class WebConsole extends ModelBase {
	/**
	 * @generated
	 */
	public static final String WEBSTATUS = "WebStatus";
	/**
	 * @generated
	 */
	public static final String WEBACTION = "Webaction";
	/**
	 * @generated
	 */
	public static final String WEBPARENTS = "Webparents";
	/**
	 * @generated
	 */
	public static final String WEBMESSAGETYPE = "Webmessagetype";
	/**
	 * @generated
	 */
	public static final String WEBTRANSACTIONID = "WebtransactionID";
	/**
	 * @generated
	 */
	public static final String WEBSENDDATE = "Websenddate";
	/**
	 * @generated
	 */
	public static final String SERVERCODE = "Servercode";

	/**
	 * @generated
	 */
	public WebConsole() {
    this.created = new Date();
    this.modified = new Date();
  }

 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
	private WebStatus webStatus;
	
	/**
	 * @generated
 	 */
	public WebStatus getWebStatus(){
    return webStatus; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebStatus(WebStatus newVal) {
    this.webStatus = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String webaction;
	
	/**
	 * @generated
 	 */
	public String getWebaction(){
    return webaction; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebaction(String newVal) {
    this.webaction = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String webparents;
	
	/**
	 * @generated
 	 */
	public String getWebparents(){
    return webparents; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebparents(String newVal) {
    this.webparents = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String webmessagetype;
	
	/**
	 * @generated
 	 */
	public String getWebmessagetype(){
    return webmessagetype; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebmessagetype(String newVal) {
    this.webmessagetype = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String webtransactionID;
	
	/**
	 * @generated
 	 */
	public String getWebtransactionID(){
    return webtransactionID; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebtransactionID(String newVal) {
    this.webtransactionID = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Date websenddate;
	
	/**
	 * @generated
 	 */
	public Date getWebsenddate(){
    return websenddate; 
  }

	
	/**
	 * @generated
	 */	
	public void setWebsenddate(Date newVal) {
    this.websenddate = newVal;
  }
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String servercode;
	
	/**
	 * @generated
 	 */
	public String getServercode(){
    return servercode; 
  }

	
	/**
	 * @generated
	 */	
	public void setServercode(String newVal) {
    this.servercode = newVal;
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
    if (WEBSTATUS.equals(propertyName)) return getWebStatus();
    if (WEBACTION.equals(propertyName)) return getWebaction();
    if (WEBPARENTS.equals(propertyName)) return getWebparents();
    if (WEBMESSAGETYPE.equals(propertyName)) return getWebmessagetype();
    if (WEBTRANSACTIONID.equals(propertyName)) return getWebtransactionID();
    if (WEBSENDDATE.equals(propertyName)) return getWebsenddate();
    if (SERVERCODE.equals(propertyName)) return getServercode();
    return super.getProperty(propertyName);
  }
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
    if (WEBSTATUS.equals(propertyName)) setWebStatus((WebStatus)newValue); else
    if (WEBACTION.equals(propertyName)) setWebaction((String)newValue); else
    if (WEBPARENTS.equals(propertyName)) setWebparents((String)newValue); else
    if (WEBMESSAGETYPE.equals(propertyName)) setWebmessagetype((String)newValue); else
    if (WEBTRANSACTIONID.equals(propertyName)) setWebtransactionID((String)newValue); else
    if (WEBSENDDATE.equals(propertyName)) setWebsenddate((Date)newValue); else
    if (SERVERCODE.equals(propertyName)) setServercode((String)newValue); else
    super.setProperty(propertyName, newValue);
  }
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
    if (WEBSTATUS.equals(propertyName)) 
      return new Class<?>[] {WebStatus.class};		
    if (WEBACTION.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBPARENTS.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBMESSAGETYPE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBTRANSACTIONID.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (WEBSENDDATE.equals(propertyName)) 
      return new Class<?>[] {Date.class};		
    if (SERVERCODE.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    return super.getPropertyClass(propertyName);
  }
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
    if (WEBSTATUS.equals(propertyName)) return WebConsole.class;
    if (WEBACTION.equals(propertyName)) return WebConsole.class;
    if (WEBPARENTS.equals(propertyName)) return WebConsole.class;
    if (WEBMESSAGETYPE.equals(propertyName)) return WebConsole.class;
    if (WEBTRANSACTIONID.equals(propertyName)) return WebConsole.class;
    if (WEBSENDDATE.equals(propertyName)) return WebConsole.class;
    if (SERVERCODE.equals(propertyName)) return WebConsole.class;
    return super.getPropertyOwner(propertyName);
  }
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
    if (! super.deepEquals(obj))
      return false;
    WebConsole objT = (WebConsole)obj;
    if (! SmartEquals(getWebStatus(), objT.getWebStatus()))
      return false;
    if (! SmartEquals(getWebaction(), objT.getWebaction()))
      return false;
    if (! SmartEquals(getWebparents(), objT.getWebparents()))
      return false;
    if (! SmartEquals(getWebmessagetype(), objT.getWebmessagetype()))
      return false;
    if (! SmartEquals(getWebtransactionID(), objT.getWebtransactionID()))
      return false;
    if (! SmartEquals(getWebsenddate(), objT.getWebsenddate()))
      return false;
    if (! SmartEquals(getServercode(), objT.getServercode()))
      return false;
    return true;
  }			
}
