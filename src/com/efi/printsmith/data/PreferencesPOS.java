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
	@NamedQuery(name = "PreferencesPOS.findall", query = "from PreferencesPOS"),
	@NamedQuery(name = "PreferencesPOS.byId", query = "select a from PreferencesPOS a where a.id= :id")
})


@Entity
@Table(name = "preferencespos")
public class PreferencesPOS extends ModelBase {
	/**
	 * @generated
	 */
	public static final String RECEIPTHEADER = "ReceiptHeader";
	/**
	 * @generated
	 */
	public static final String RECEIPTFOOTER = "ReceiptFooter";
	/**
	 * @generated
	 */
	public static final String RECEIPTSTARTNUMBER = "ReceiptStartNumber";
	/**
	 * @generated
	 */
	public static final String STARTINGNUMBER = "StartingNumber";
	/**
	 * @generated
	 */
	public static final String HIDETAXLINES = "HideTaxLines";
	/**
	 * @generated
	 */
	public static final String RECEIPTPRINTERSTATUS = "ReceiptPrinterStatus";
	/**
	 * @generated
	 */
	public static final String DEFAULTPRINTER = "DefaultPrinter";
	/**
	 * @generated
	 */
	public static final String ENABLECASHDRAWER = "EnableCashDrawer";
	/**
	 * @generated
	 */
	public static final String USEMASTERDRAWER = "UseMasterDrawer";
	/**
	 * @generated
	 */
	public static final String PRINTRECEIPTS = "PrintReceipts";
	/**
	 * @generated
	 */
	public static final String PRINT2FORCREDITCARDS = "Print2forCreditCards";
	/**
	 * @generated
	 */
	public static final String PRINT2FORCASH = "Print2forCash";
	/**
	 * @generated
	 */
	public static final String KEEPLOCALSETTINGS = "KeepLocalSettings";
	/**
	 * @generated
	 */
	public static final String PRINTINVOICES = "PrintInvoices";
	/**
	 * @generated
	 */
	public static final String LOCKSETTINGS = "LockSettings";
	/**
	 * @generated
	 */
	public static final String ASCIICODEOPENDRAWER = "AsciiCodeOpenDrawer";
	/**
	 * @generated
	 */
	public static final String BLANKLINESBEFORERECEIPT = "BlankLinesBeforeReceipt";
	/**
	 * @generated
	 */
	public static final String BLANKLINESAFTERRECEIPT = "BlankLinesAfterReceipt";
	/**
	 * @generated
	 */
	public static final String RECEIPTSTARTCODE = "ReceiptStartCode";
	/**
	 * @generated
	 */
	public static final String RECEIPTENDCODE = "ReceiptEndCode";
	/**
	 * @generated
	 */
	public static final String BAUDRATE = "BaudRate";
	/**
	 * @generated
	 */
	public static final String STOPBITS = "StopBits";
	/**
	 * @generated
	 */
	public static final String PARITY = "Parity";
	/**
	 * @generated
	 */
	public static final String DATASIZE = "DataSize";

	/**
	 * @generated
	 */
	public PreferencesPOS() {
		this.created = new Date();
		this.modified = new Date();
	}

 	
	
 	@Basic
	private String receiptHeader;
	
	/**
	 * @generated
 	 */
	public String getReceiptHeader(){
		return receiptHeader; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptHeader(String newVal) {
		this.receiptHeader = newVal;
	}
 	
	
 	@Basic
	private String receiptFooter;
	
	/**
	 * @generated
 	 */
	public String getReceiptFooter(){
		return receiptFooter; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptFooter(String newVal) {
		this.receiptFooter = newVal;
	}
 	
	
 	@Basic
	private Boolean receiptStartNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getReceiptStartNumber(){
		return receiptStartNumber; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptStartNumber(Boolean newVal) {
		this.receiptStartNumber = newVal;
	}
 	
	
 	@Basic
	private Integer startingNumber;
	
	/**
	 * @generated
 	 */
	public Integer getStartingNumber(){
		return startingNumber; 
	}

	/**
	 * @generated
	 */	
	public void setStartingNumber(Integer newVal) {
		this.startingNumber = newVal;
	}
 	
	
 	@Basic
	private Boolean hideTaxLines;
	
	/**
	 * @generated
 	 */
	public Boolean getHideTaxLines(){
		return hideTaxLines; 
	}

	/**
	 * @generated
	 */	
	public void setHideTaxLines(Boolean newVal) {
		this.hideTaxLines = newVal;
	}
 	
	
 	@Basic
	private String receiptPrinterStatus;
	
	/**
	 * @generated
 	 */
	public String getReceiptPrinterStatus(){
		return receiptPrinterStatus; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptPrinterStatus(String newVal) {
		this.receiptPrinterStatus = newVal;
	}
 	
	
 	@Basic
	private String defaultPrinter;
	
	/**
	 * @generated
 	 */
	public String getDefaultPrinter(){
		return defaultPrinter; 
	}

	/**
	 * @generated
	 */	
	public void setDefaultPrinter(String newVal) {
		this.defaultPrinter = newVal;
	}
 	
	
 	@Basic
	private Boolean enableCashDrawer;
	
	/**
	 * @generated
 	 */
	public Boolean getEnableCashDrawer(){
		return enableCashDrawer; 
	}

	/**
	 * @generated
	 */	
	public void setEnableCashDrawer(Boolean newVal) {
		this.enableCashDrawer = newVal;
	}
 	
	
 	@Basic
	private Boolean useMasterDrawer;
	
	/**
	 * @generated
 	 */
	public Boolean getUseMasterDrawer(){
		return useMasterDrawer; 
	}

	/**
	 * @generated
	 */	
	public void setUseMasterDrawer(Boolean newVal) {
		this.useMasterDrawer = newVal;
	}
 	
	
 	@Basic
	private Boolean printReceipts;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintReceipts(){
		return printReceipts; 
	}

	/**
	 * @generated
	 */	
	public void setPrintReceipts(Boolean newVal) {
		this.printReceipts = newVal;
	}
 	
	
 	@Basic
	private Boolean print2forCreditCards;
	
	/**
	 * @generated
 	 */
	public Boolean getPrint2forCreditCards(){
		return print2forCreditCards; 
	}

	/**
	 * @generated
	 */	
	public void setPrint2forCreditCards(Boolean newVal) {
		this.print2forCreditCards = newVal;
	}
 	
	
 	@Basic
	private Boolean print2forCash;
	
	/**
	 * @generated
 	 */
	public Boolean getPrint2forCash(){
		return print2forCash; 
	}

	/**
	 * @generated
	 */	
	public void setPrint2forCash(Boolean newVal) {
		this.print2forCash = newVal;
	}
 	
	
 	@Basic
	private Boolean keepLocalSettings;
	
	/**
	 * @generated
 	 */
	public Boolean getKeepLocalSettings(){
		return keepLocalSettings; 
	}

	/**
	 * @generated
	 */	
	public void setKeepLocalSettings(Boolean newVal) {
		this.keepLocalSettings = newVal;
	}
 	
	
 	@Basic
	private Boolean printInvoices;
	
	/**
	 * @generated
 	 */
	public Boolean getPrintInvoices(){
		return printInvoices; 
	}

	/**
	 * @generated
	 */	
	public void setPrintInvoices(Boolean newVal) {
		this.printInvoices = newVal;
	}
 	
	
 	@Basic
	private Boolean lockSettings;
	
	/**
	 * @generated
 	 */
	public Boolean getLockSettings(){
		return lockSettings; 
	}

	/**
	 * @generated
	 */	
	public void setLockSettings(Boolean newVal) {
		this.lockSettings = newVal;
	}
 	
	
 	@Basic
	private Integer asciiCodeOpenDrawer;
	
	/**
	 * @generated
 	 */
	public Integer getAsciiCodeOpenDrawer(){
		return asciiCodeOpenDrawer; 
	}

	/**
	 * @generated
	 */	
	public void setAsciiCodeOpenDrawer(Integer newVal) {
		this.asciiCodeOpenDrawer = newVal;
	}
 	
	
 	@Basic
	private Integer blankLinesBeforeReceipt;
	
	/**
	 * @generated
 	 */
	public Integer getBlankLinesBeforeReceipt(){
		return blankLinesBeforeReceipt; 
	}

	/**
	 * @generated
	 */	
	public void setBlankLinesBeforeReceipt(Integer newVal) {
		this.blankLinesBeforeReceipt = newVal;
	}
 	
	
 	@Basic
	private Integer blankLinesAfterReceipt;
	
	/**
	 * @generated
 	 */
	public Integer getBlankLinesAfterReceipt(){
		return blankLinesAfterReceipt; 
	}

	/**
	 * @generated
	 */	
	public void setBlankLinesAfterReceipt(Integer newVal) {
		this.blankLinesAfterReceipt = newVal;
	}
 	
	
 	@Basic
	private String receiptStartCode;
	
	/**
	 * @generated
 	 */
	public String getReceiptStartCode(){
		return receiptStartCode; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptStartCode(String newVal) {
		this.receiptStartCode = newVal;
	}
 	
	
 	@Basic
	private String receiptEndCode;
	
	/**
	 * @generated
 	 */
	public String getReceiptEndCode(){
		return receiptEndCode; 
	}

	/**
	 * @generated
	 */	
	public void setReceiptEndCode(String newVal) {
		this.receiptEndCode = newVal;
	}
 	
	
 	@Basic
	private String baudRate;
	
	/**
	 * @generated
 	 */
	public String getBaudRate(){
		return baudRate; 
	}

	/**
	 * @generated
	 */	
	public void setBaudRate(String newVal) {
		this.baudRate = newVal;
	}
 	
	
 	@Basic
	private String stopBits;
	
	/**
	 * @generated
 	 */
	public String getStopBits(){
		return stopBits; 
	}

	/**
	 * @generated
	 */	
	public void setStopBits(String newVal) {
		this.stopBits = newVal;
	}
 	
	
 	@Basic
	private String parity;
	
	/**
	 * @generated
 	 */
	public String getParity(){
		return parity; 
	}

	/**
	 * @generated
	 */	
	public void setParity(String newVal) {
		this.parity = newVal;
	}
 	
	
 	@Basic
	private String dataSize;
	
	/**
	 * @generated
 	 */
	public String getDataSize(){
		return dataSize; 
	}

	/**
	 * @generated
	 */	
	public void setDataSize(String newVal) {
		this.dataSize = newVal;
	}
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (RECEIPTHEADER.equals(propertyName)) return getReceiptHeader();
		if (RECEIPTFOOTER.equals(propertyName)) return getReceiptFooter();
		if (RECEIPTSTARTNUMBER.equals(propertyName)) return getReceiptStartNumber();
		if (STARTINGNUMBER.equals(propertyName)) return getStartingNumber();
		if (HIDETAXLINES.equals(propertyName)) return getHideTaxLines();
		if (RECEIPTPRINTERSTATUS.equals(propertyName)) return getReceiptPrinterStatus();
		if (DEFAULTPRINTER.equals(propertyName)) return getDefaultPrinter();
		if (ENABLECASHDRAWER.equals(propertyName)) return getEnableCashDrawer();
		if (USEMASTERDRAWER.equals(propertyName)) return getUseMasterDrawer();
		if (PRINTRECEIPTS.equals(propertyName)) return getPrintReceipts();
		if (PRINT2FORCREDITCARDS.equals(propertyName)) return getPrint2forCreditCards();
		if (PRINT2FORCASH.equals(propertyName)) return getPrint2forCash();
		if (KEEPLOCALSETTINGS.equals(propertyName)) return getKeepLocalSettings();
		if (PRINTINVOICES.equals(propertyName)) return getPrintInvoices();
		if (LOCKSETTINGS.equals(propertyName)) return getLockSettings();
		if (ASCIICODEOPENDRAWER.equals(propertyName)) return getAsciiCodeOpenDrawer();
		if (BLANKLINESBEFORERECEIPT.equals(propertyName)) return getBlankLinesBeforeReceipt();
		if (BLANKLINESAFTERRECEIPT.equals(propertyName)) return getBlankLinesAfterReceipt();
		if (RECEIPTSTARTCODE.equals(propertyName)) return getReceiptStartCode();
		if (RECEIPTENDCODE.equals(propertyName)) return getReceiptEndCode();
		if (BAUDRATE.equals(propertyName)) return getBaudRate();
		if (STOPBITS.equals(propertyName)) return getStopBits();
		if (PARITY.equals(propertyName)) return getParity();
		if (DATASIZE.equals(propertyName)) return getDataSize();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (RECEIPTHEADER.equals(propertyName)) setReceiptHeader((String)newValue); else
		if (RECEIPTFOOTER.equals(propertyName)) setReceiptFooter((String)newValue); else
		if (RECEIPTSTARTNUMBER.equals(propertyName)) setReceiptStartNumber((Boolean)newValue); else
		if (STARTINGNUMBER.equals(propertyName)) setStartingNumber((Integer)newValue); else
		if (HIDETAXLINES.equals(propertyName)) setHideTaxLines((Boolean)newValue); else
		if (RECEIPTPRINTERSTATUS.equals(propertyName)) setReceiptPrinterStatus((String)newValue); else
		if (DEFAULTPRINTER.equals(propertyName)) setDefaultPrinter((String)newValue); else
		if (ENABLECASHDRAWER.equals(propertyName)) setEnableCashDrawer((Boolean)newValue); else
		if (USEMASTERDRAWER.equals(propertyName)) setUseMasterDrawer((Boolean)newValue); else
		if (PRINTRECEIPTS.equals(propertyName)) setPrintReceipts((Boolean)newValue); else
		if (PRINT2FORCREDITCARDS.equals(propertyName)) setPrint2forCreditCards((Boolean)newValue); else
		if (PRINT2FORCASH.equals(propertyName)) setPrint2forCash((Boolean)newValue); else
		if (KEEPLOCALSETTINGS.equals(propertyName)) setKeepLocalSettings((Boolean)newValue); else
		if (PRINTINVOICES.equals(propertyName)) setPrintInvoices((Boolean)newValue); else
		if (LOCKSETTINGS.equals(propertyName)) setLockSettings((Boolean)newValue); else
		if (ASCIICODEOPENDRAWER.equals(propertyName)) setAsciiCodeOpenDrawer((Integer)newValue); else
		if (BLANKLINESBEFORERECEIPT.equals(propertyName)) setBlankLinesBeforeReceipt((Integer)newValue); else
		if (BLANKLINESAFTERRECEIPT.equals(propertyName)) setBlankLinesAfterReceipt((Integer)newValue); else
		if (RECEIPTSTARTCODE.equals(propertyName)) setReceiptStartCode((String)newValue); else
		if (RECEIPTENDCODE.equals(propertyName)) setReceiptEndCode((String)newValue); else
		if (BAUDRATE.equals(propertyName)) setBaudRate((String)newValue); else
		if (STOPBITS.equals(propertyName)) setStopBits((String)newValue); else
		if (PARITY.equals(propertyName)) setParity((String)newValue); else
		if (DATASIZE.equals(propertyName)) setDataSize((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (RECEIPTHEADER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RECEIPTFOOTER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RECEIPTSTARTNUMBER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (STARTINGNUMBER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (HIDETAXLINES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (RECEIPTPRINTERSTATUS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DEFAULTPRINTER.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (ENABLECASHDRAWER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (USEMASTERDRAWER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRINTRECEIPTS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRINT2FORCREDITCARDS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRINT2FORCASH.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (KEEPLOCALSETTINGS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (PRINTINVOICES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LOCKSETTINGS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ASCIICODEOPENDRAWER.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BLANKLINESBEFORERECEIPT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (BLANKLINESAFTERRECEIPT.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (RECEIPTSTARTCODE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (RECEIPTENDCODE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (BAUDRATE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STOPBITS.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (PARITY.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DATASIZE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (RECEIPTHEADER.equals(propertyName)) return PreferencesPOS.class;
		if (RECEIPTFOOTER.equals(propertyName)) return PreferencesPOS.class;
		if (RECEIPTSTARTNUMBER.equals(propertyName)) return PreferencesPOS.class;
		if (STARTINGNUMBER.equals(propertyName)) return PreferencesPOS.class;
		if (HIDETAXLINES.equals(propertyName)) return PreferencesPOS.class;
		if (RECEIPTPRINTERSTATUS.equals(propertyName)) return PreferencesPOS.class;
		if (DEFAULTPRINTER.equals(propertyName)) return PreferencesPOS.class;
		if (ENABLECASHDRAWER.equals(propertyName)) return PreferencesPOS.class;
		if (USEMASTERDRAWER.equals(propertyName)) return PreferencesPOS.class;
		if (PRINTRECEIPTS.equals(propertyName)) return PreferencesPOS.class;
		if (PRINT2FORCREDITCARDS.equals(propertyName)) return PreferencesPOS.class;
		if (PRINT2FORCASH.equals(propertyName)) return PreferencesPOS.class;
		if (KEEPLOCALSETTINGS.equals(propertyName)) return PreferencesPOS.class;
		if (PRINTINVOICES.equals(propertyName)) return PreferencesPOS.class;
		if (LOCKSETTINGS.equals(propertyName)) return PreferencesPOS.class;
		if (ASCIICODEOPENDRAWER.equals(propertyName)) return PreferencesPOS.class;
		if (BLANKLINESBEFORERECEIPT.equals(propertyName)) return PreferencesPOS.class;
		if (BLANKLINESAFTERRECEIPT.equals(propertyName)) return PreferencesPOS.class;
		if (RECEIPTSTARTCODE.equals(propertyName)) return PreferencesPOS.class;
		if (RECEIPTENDCODE.equals(propertyName)) return PreferencesPOS.class;
		if (BAUDRATE.equals(propertyName)) return PreferencesPOS.class;
		if (STOPBITS.equals(propertyName)) return PreferencesPOS.class;
		if (PARITY.equals(propertyName)) return PreferencesPOS.class;
		if (DATASIZE.equals(propertyName)) return PreferencesPOS.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		PreferencesPOS objT = (PreferencesPOS)obj;
		if (! SmartEquals(getReceiptHeader(), objT.getReceiptHeader()))
			return false;
		if (! SmartEquals(getReceiptFooter(), objT.getReceiptFooter()))
			return false;
		if (! SmartEquals(getReceiptStartNumber(), objT.getReceiptStartNumber()))
			return false;
		if (! SmartEquals(getStartingNumber(), objT.getStartingNumber()))
			return false;
		if (! SmartEquals(getHideTaxLines(), objT.getHideTaxLines()))
			return false;
		if (! SmartEquals(getReceiptPrinterStatus(), objT.getReceiptPrinterStatus()))
			return false;
		if (! SmartEquals(getDefaultPrinter(), objT.getDefaultPrinter()))
			return false;
		if (! SmartEquals(getEnableCashDrawer(), objT.getEnableCashDrawer()))
			return false;
		if (! SmartEquals(getUseMasterDrawer(), objT.getUseMasterDrawer()))
			return false;
		if (! SmartEquals(getPrintReceipts(), objT.getPrintReceipts()))
			return false;
		if (! SmartEquals(getPrint2forCreditCards(), objT.getPrint2forCreditCards()))
			return false;
		if (! SmartEquals(getPrint2forCash(), objT.getPrint2forCash()))
			return false;
		if (! SmartEquals(getKeepLocalSettings(), objT.getKeepLocalSettings()))
			return false;
		if (! SmartEquals(getPrintInvoices(), objT.getPrintInvoices()))
			return false;
		if (! SmartEquals(getLockSettings(), objT.getLockSettings()))
			return false;
		if (! SmartEquals(getAsciiCodeOpenDrawer(), objT.getAsciiCodeOpenDrawer()))
			return false;
		if (! SmartEquals(getBlankLinesBeforeReceipt(), objT.getBlankLinesBeforeReceipt()))
			return false;
		if (! SmartEquals(getBlankLinesAfterReceipt(), objT.getBlankLinesAfterReceipt()))
			return false;
		if (! SmartEquals(getReceiptStartCode(), objT.getReceiptStartCode()))
			return false;
		if (! SmartEquals(getReceiptEndCode(), objT.getReceiptEndCode()))
			return false;
		if (! SmartEquals(getBaudRate(), objT.getBaudRate()))
			return false;
		if (! SmartEquals(getStopBits(), objT.getStopBits()))
			return false;
		if (! SmartEquals(getParity(), objT.getParity()))
			return false;
		if (! SmartEquals(getDataSize(), objT.getDataSize()))
			return false;
		return true;
	}			
}