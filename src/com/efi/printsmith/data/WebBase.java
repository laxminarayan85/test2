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
	@NamedQuery(name = "WebBase.findall", query = "from WebBase"),
	@NamedQuery(name = "WebBase.byId", query = "select a from WebBase a where a.id= :id")
})


@Entity
@Table(name = "webbase")
public class WebBase extends ModelBase {
	/**
	 * @generated
	 */
	public static final String CONTACTNAME = "ContactName";
	/**
	 * @generated
	 */
	public static final String CONTACTPHONE = "ContactPhone";
	/**
	 * @generated
	 */
	public static final String CONTACTEMAIL = "ContactEmail";
	/**
	 * @generated
	 */
	public static final String TRANSFERMETHOD = "TransferMethod";
	/**
	 * @generated
	 */
	public static final String FTPURL = "FtpUrl";
	/**
	 * @generated
	 */
	public static final String FTPUSERNAME = "FtpUserName";
	/**
	 * @generated
	 */
	public static final String FTPPASSWORD = "FtpPassword";
	/**
	 * @generated
	 */
	public static final String FTPMODE = "FtpMode";
	/**
	 * @generated
	 */
	public static final String IGNORELOCALCURRENCYFORMAT = "IgnoreLocalCurrencyFormat";
	/**
	 * @generated
	 */
	public static final String RETRYINTERVAL = "RetryInterval";
	/**
	 * @generated
	 */
	public static final String MAXRETRIES = "MaxRetries";
	/**
	 * @generated
	 */
	public static final String TAKENBY = "TakenBy";
	/**
	 * @generated
	 */
	public static final String RESPONSEDELAY = "ResponseDelay";
	/**
	 * @generated
	 */
	public static final String COMPOSERURL = "ComposerUrl";
	/**
	 * @generated
	 */
	public static final String COMPOSERDELAY = "ComposerDelay";
	/**
	 * @generated
	 */
	public static final String AUTOSTARTCONNECTION = "AutoStartConnection";
	/**
	 * @generated
	 */
	public static final String HIDDENBACKGROUNDTASK = "HiddenBackgroundTask";
	/**
	 * @generated
	 */
	public static final String AUTOOENWEBCONSOLE = "AutoOenWebConsole";
	/**
	 * @generated
	 */
	public static final String SENDOUTGOINGDATAIMMEDIATELY = "SendOutgoingDataImmediately";
	/**
	 * @generated
	 */
	public static final String RECEIVESTATE = "ReceiveState";
	/**
	 * @generated
	 */
	public static final String REJECTSTATE = "RejectState";

	/**
	 * @generated
	 */
	public WebBase() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String contactName;
	
	/**
	 * @generated
 	 */
	public String getContactName(){
		return contactName; 
	}

	
	/**
	 * @generated
	 */	
	public void setContactName(String newVal) {
		this.contactName = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String contactPhone;
	
	/**
	 * @generated
 	 */
	public String getContactPhone(){
		return contactPhone; 
	}

	
	/**
	 * @generated
	 */	
	public void setContactPhone(String newVal) {
		this.contactPhone = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String contactEmail;
	
	/**
	 * @generated
 	 */
	public String getContactEmail(){
		return contactEmail; 
	}

	
	/**
	 * @generated
	 */	
	public void setContactEmail(String newVal) {
		this.contactEmail = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer transferMethod;
	
	/**
	 * @generated
 	 */
	public Integer getTransferMethod(){
		return transferMethod; 
	}

	
	/**
	 * @generated
	 */	
	public void setTransferMethod(Integer newVal) {
		this.transferMethod = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String ftpUrl;
	
	/**
	 * @generated
 	 */
	public String getFtpUrl(){
		return ftpUrl; 
	}

	
	/**
	 * @generated
	 */	
	public void setFtpUrl(String newVal) {
		this.ftpUrl = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String ftpUserName;
	
	/**
	 * @generated
 	 */
	public String getFtpUserName(){
		return ftpUserName; 
	}

	
	/**
	 * @generated
	 */	
	public void setFtpUserName(String newVal) {
		this.ftpUserName = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String ftpPassword;
	
	/**
	 * @generated
 	 */
	public String getFtpPassword(){
		return ftpPassword; 
	}

	
	/**
	 * @generated
	 */	
	public void setFtpPassword(String newVal) {
		this.ftpPassword = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer ftpMode;
	
	/**
	 * @generated
 	 */
	public Integer getFtpMode(){
		return ftpMode; 
	}

	
	/**
	 * @generated
	 */	
	public void setFtpMode(Integer newVal) {
		this.ftpMode = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean ignoreLocalCurrencyFormat;
	
	/**
	 * @generated
 	 */
	public Boolean getIgnoreLocalCurrencyFormat(){
		return ignoreLocalCurrencyFormat; 
	}

	
	/**
	 * @generated
	 */	
	public void setIgnoreLocalCurrencyFormat(Boolean newVal) {
		this.ignoreLocalCurrencyFormat = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer retryInterval;
	
	/**
	 * @generated
 	 */
	public Integer getRetryInterval(){
		return retryInterval; 
	}

	
	/**
	 * @generated
	 */	
	public void setRetryInterval(Integer newVal) {
		this.retryInterval = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer maxRetries;
	
	/**
	 * @generated
 	 */
	public Integer getMaxRetries(){
		return maxRetries; 
	}

	
	/**
	 * @generated
	 */	
	public void setMaxRetries(Integer newVal) {
		this.maxRetries = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String takenBy;
	
	/**
	 * @generated
 	 */
	public String getTakenBy(){
		return takenBy; 
	}

	
	/**
	 * @generated
	 */	
	public void setTakenBy(String newVal) {
		this.takenBy = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer responseDelay;
	
	/**
	 * @generated
 	 */
	public Integer getResponseDelay(){
		return responseDelay; 
	}

	
	/**
	 * @generated
	 */	
	public void setResponseDelay(Integer newVal) {
		this.responseDelay = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String composerUrl;
	
	/**
	 * @generated
 	 */
	public String getComposerUrl(){
		return composerUrl; 
	}

	
	/**
	 * @generated
	 */	
	public void setComposerUrl(String newVal) {
		this.composerUrl = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer composerDelay;
	
	/**
	 * @generated
 	 */
	public Integer getComposerDelay(){
		return composerDelay; 
	}

	
	/**
	 * @generated
	 */	
	public void setComposerDelay(Integer newVal) {
		this.composerDelay = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean autoStartConnection;
	
	/**
	 * @generated
 	 */
	public Boolean getAutoStartConnection(){
		return autoStartConnection; 
	}

	
	/**
	 * @generated
	 */	
	public void setAutoStartConnection(Boolean newVal) {
		this.autoStartConnection = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean hiddenBackgroundTask;
	
	/**
	 * @generated
 	 */
	public Boolean getHiddenBackgroundTask(){
		return hiddenBackgroundTask; 
	}

	
	/**
	 * @generated
	 */	
	public void setHiddenBackgroundTask(Boolean newVal) {
		this.hiddenBackgroundTask = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean autoOenWebConsole;
	
	/**
	 * @generated
 	 */
	public Boolean getAutoOenWebConsole(){
		return autoOenWebConsole; 
	}

	
	/**
	 * @generated
	 */	
	public void setAutoOenWebConsole(Boolean newVal) {
		this.autoOenWebConsole = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean sendOutgoingDataImmediately;
	
	/**
	 * @generated
 	 */
	public Boolean getSendOutgoingDataImmediately(){
		return sendOutgoingDataImmediately; 
	}

	
	/**
	 * @generated
	 */	
	public void setSendOutgoingDataImmediately(Boolean newVal) {
		this.sendOutgoingDataImmediately = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private WebStatus receiveState;
	
	/**
	 * @generated
 	 */
	public WebStatus getReceiveState(){
		return receiveState; 
	}

	
	/**
	 * @generated
	 */	
	public void setReceiveState(WebStatus newVal) {
		this.receiveState = newVal;
	}
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private WebStatus rejectState;
	
	/**
	 * @generated
 	 */
	public WebStatus getRejectState(){
		return rejectState; 
	}

	
	/**
	 * @generated
	 */	
	public void setRejectState(WebStatus newVal) {
		this.rejectState = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (CONTACTNAME.equals(propertyName)) return getContactName();
		if (CONTACTPHONE.equals(propertyName)) return getContactPhone();
		if (CONTACTEMAIL.equals(propertyName)) return getContactEmail();
		if (TRANSFERMETHOD.equals(propertyName)) return getTransferMethod();
		if (FTPURL.equals(propertyName)) return getFtpUrl();
		if (FTPUSERNAME.equals(propertyName)) return getFtpUserName();
		if (FTPPASSWORD.equals(propertyName)) return getFtpPassword();
		if (FTPMODE.equals(propertyName)) return getFtpMode();
		if (IGNORELOCALCURRENCYFORMAT.equals(propertyName)) return getIgnoreLocalCurrencyFormat();
		if (RETRYINTERVAL.equals(propertyName)) return getRetryInterval();
		if (MAXRETRIES.equals(propertyName)) return getMaxRetries();
		if (TAKENBY.equals(propertyName)) return getTakenBy();
		if (RESPONSEDELAY.equals(propertyName)) return getResponseDelay();
		if (COMPOSERURL.equals(propertyName)) return getComposerUrl();
		if (COMPOSERDELAY.equals(propertyName)) return getComposerDelay();
		if (AUTOSTARTCONNECTION.equals(propertyName)) return getAutoStartConnection();
		if (HIDDENBACKGROUNDTASK.equals(propertyName)) return getHiddenBackgroundTask();
		if (AUTOOENWEBCONSOLE.equals(propertyName)) return getAutoOenWebConsole();
		if (SENDOUTGOINGDATAIMMEDIATELY.equals(propertyName)) return getSendOutgoingDataImmediately();
		if (RECEIVESTATE.equals(propertyName)) return getReceiveState();
		if (REJECTSTATE.equals(propertyName)) return getRejectState();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (CONTACTNAME.equals(propertyName)) setContactName((String)newValue); else
		if (CONTACTPHONE.equals(propertyName)) setContactPhone((String)newValue); else
		if (CONTACTEMAIL.equals(propertyName)) setContactEmail((String)newValue); else
		if (TRANSFERMETHOD.equals(propertyName)) setTransferMethod((Integer)newValue); else
		if (FTPURL.equals(propertyName)) setFtpUrl((String)newValue); else
		if (FTPUSERNAME.equals(propertyName)) setFtpUserName((String)newValue); else
		if (FTPPASSWORD.equals(propertyName)) setFtpPassword((String)newValue); else
		if (FTPMODE.equals(propertyName)) setFtpMode((Integer)newValue); else
		if (IGNORELOCALCURRENCYFORMAT.equals(propertyName)) setIgnoreLocalCurrencyFormat((Boolean)newValue); else
		if (RETRYINTERVAL.equals(propertyName)) setRetryInterval((Integer)newValue); else
		if (MAXRETRIES.equals(propertyName)) setMaxRetries((Integer)newValue); else
		if (TAKENBY.equals(propertyName)) setTakenBy((String)newValue); else
		if (RESPONSEDELAY.equals(propertyName)) setResponseDelay((Integer)newValue); else
		if (COMPOSERURL.equals(propertyName)) setComposerUrl((String)newValue); else
		if (COMPOSERDELAY.equals(propertyName)) setComposerDelay((Integer)newValue); else
		if (AUTOSTARTCONNECTION.equals(propertyName)) setAutoStartConnection((Boolean)newValue); else
		if (HIDDENBACKGROUNDTASK.equals(propertyName)) setHiddenBackgroundTask((Boolean)newValue); else
		if (AUTOOENWEBCONSOLE.equals(propertyName)) setAutoOenWebConsole((Boolean)newValue); else
		if (SENDOUTGOINGDATAIMMEDIATELY.equals(propertyName)) setSendOutgoingDataImmediately((Boolean)newValue); else
		if (RECEIVESTATE.equals(propertyName)) setReceiveState((WebStatus)newValue); else
		if (REJECTSTATE.equals(propertyName)) setRejectState((WebStatus)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (CONTACTNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CONTACTPHONE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (CONTACTEMAIL.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TRANSFERMETHOD.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (FTPURL.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FTPUSERNAME.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FTPPASSWORD.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FTPMODE.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (IGNORELOCALCURRENCYFORMAT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (RETRYINTERVAL.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (MAXRETRIES.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (TAKENBY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RESPONSEDELAY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (COMPOSERURL.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (COMPOSERDELAY.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (AUTOSTARTCONNECTION.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (HIDDENBACKGROUNDTASK.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (AUTOOENWEBCONSOLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SENDOUTGOINGDATAIMMEDIATELY.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (RECEIVESTATE.equals(propertyName)) 
			return new Class<?>[] {WebStatus.class};		
		if (REJECTSTATE.equals(propertyName)) 
			return new Class<?>[] {WebStatus.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (CONTACTNAME.equals(propertyName)) return WebBase.class;
		if (CONTACTPHONE.equals(propertyName)) return WebBase.class;
		if (CONTACTEMAIL.equals(propertyName)) return WebBase.class;
		if (TRANSFERMETHOD.equals(propertyName)) return WebBase.class;
		if (FTPURL.equals(propertyName)) return WebBase.class;
		if (FTPUSERNAME.equals(propertyName)) return WebBase.class;
		if (FTPPASSWORD.equals(propertyName)) return WebBase.class;
		if (FTPMODE.equals(propertyName)) return WebBase.class;
		if (IGNORELOCALCURRENCYFORMAT.equals(propertyName)) return WebBase.class;
		if (RETRYINTERVAL.equals(propertyName)) return WebBase.class;
		if (MAXRETRIES.equals(propertyName)) return WebBase.class;
		if (TAKENBY.equals(propertyName)) return WebBase.class;
		if (RESPONSEDELAY.equals(propertyName)) return WebBase.class;
		if (COMPOSERURL.equals(propertyName)) return WebBase.class;
		if (COMPOSERDELAY.equals(propertyName)) return WebBase.class;
		if (AUTOSTARTCONNECTION.equals(propertyName)) return WebBase.class;
		if (HIDDENBACKGROUNDTASK.equals(propertyName)) return WebBase.class;
		if (AUTOOENWEBCONSOLE.equals(propertyName)) return WebBase.class;
		if (SENDOUTGOINGDATAIMMEDIATELY.equals(propertyName)) return WebBase.class;
		if (RECEIVESTATE.equals(propertyName)) return WebBase.class;
		if (REJECTSTATE.equals(propertyName)) return WebBase.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		WebBase objT = (WebBase)obj;
		if (! SmartEquals(getContactName(), objT.getContactName()))
			return false;
		if (! SmartEquals(getContactPhone(), objT.getContactPhone()))
			return false;
		if (! SmartEquals(getContactEmail(), objT.getContactEmail()))
			return false;
		if (! SmartEquals(getTransferMethod(), objT.getTransferMethod()))
			return false;
		if (! SmartEquals(getFtpUrl(), objT.getFtpUrl()))
			return false;
		if (! SmartEquals(getFtpUserName(), objT.getFtpUserName()))
			return false;
		if (! SmartEquals(getFtpPassword(), objT.getFtpPassword()))
			return false;
		if (! SmartEquals(getFtpMode(), objT.getFtpMode()))
			return false;
		if (! SmartEquals(getIgnoreLocalCurrencyFormat(), objT.getIgnoreLocalCurrencyFormat()))
			return false;
		if (! SmartEquals(getRetryInterval(), objT.getRetryInterval()))
			return false;
		if (! SmartEquals(getMaxRetries(), objT.getMaxRetries()))
			return false;
		if (! SmartEquals(getTakenBy(), objT.getTakenBy()))
			return false;
		if (! SmartEquals(getResponseDelay(), objT.getResponseDelay()))
			return false;
		if (! SmartEquals(getComposerUrl(), objT.getComposerUrl()))
			return false;
		if (! SmartEquals(getComposerDelay(), objT.getComposerDelay()))
			return false;
		if (! SmartEquals(getAutoStartConnection(), objT.getAutoStartConnection()))
			return false;
		if (! SmartEquals(getHiddenBackgroundTask(), objT.getHiddenBackgroundTask()))
			return false;
		if (! SmartEquals(getAutoOenWebConsole(), objT.getAutoOenWebConsole()))
			return false;
		if (! SmartEquals(getSendOutgoingDataImmediately(), objT.getSendOutgoingDataImmediately()))
			return false;
		if (! SmartEquals(getReceiveState(), objT.getReceiveState()))
			return false;
		if (! SmartEquals(getRejectState(), objT.getRejectState()))
			return false;
		return true;
	}			
}