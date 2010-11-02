
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
	@NamedQuery(name = "TapeStub.findall", query = "from TapeStub"),
	@NamedQuery(name = "TapeStub.byId", query = "select a from TapeStub a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "tapestub")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from tapestub where modelbase.id=?")
@SQLDelete(sql="update tapestub set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class TapeStub extends ModelBase {
	/**
	 * @generated
	 */
	public static final String BATCHNUMBER = "BatchNumber";
	/**
	 * @generated
	 */
	public static final String ISDELETEDSTUB = "IsDeletedStub";
	/**
	 * @generated
	 */
	public static final String ISVOIDED = "IsVoided";
	/**
	 * @generated
	 */
	public static final String RECEIPTPRINT = "ReceiptPrint";
	/**
	 * @generated
	 */
	public static final String ISHEADER = "IsHeader";
	/**
	 * @generated
	 */
	public static final String ISDETAIL = "IsDetail";
	/**
	 * @generated
	 */
	public static final String POS = "Pos";
	/**
	 * @generated
	 */
	public static final String AR = "Ar";
	/**
	 * @generated
	 */
	public static final String DESCRIPTION = "Description";
	/**
	 * @generated
	 */
	public static final String USER = "User";
	/**
	 * @generated
	 */
	public static final String ACCOUNT = "Account";
	/**
	 * @generated
	 */
	public static final String CONTACT = "Contact";
	/**
	 * @generated
	 */
	public static final String MEMO = "Memo";
	/**
	 * @generated
	 */
	public static final String ARRECORD = "ArRecord";
	/**
	 * @generated
	 */
	public static final String RECORDTYPE = "RecordType";
	/**
	 * @generated
	 */
	public static final String TYPEID = "TypeID";

	/**
	 * @generated
	 */
	public TapeStub() {
		this.created = new Date();
		this.modified = new Date();
		this.isDeleted = false;
	}

	@Basic
	private Boolean isDeleted = false;
	
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Double batchNumber;
	
	/**
	 * @generated
 	 */
	public Double getBatchNumber(){
		return batchNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setBatchNumber(Double newVal) {
		this.batchNumber = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isDeletedStub;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDeletedStub(){
		return isDeletedStub; 
	}

	
	/**
	 * @generated
	 */	
	public void setIsDeletedStub(Boolean newVal) {
		this.isDeletedStub = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isVoided;
	
	/**
	 * @generated
 	 */
	public Boolean getIsVoided(){
		return isVoided; 
	}

	
	/**
	 * @generated
	 */	
	public void setIsVoided(Boolean newVal) {
		this.isVoided = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean receiptPrint;
	
	/**
	 * @generated
 	 */
	public Boolean getReceiptPrint(){
		return receiptPrint; 
	}

	
	/**
	 * @generated
	 */	
	public void setReceiptPrint(Boolean newVal) {
		this.receiptPrint = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isHeader;
	
	/**
	 * @generated
 	 */
	public Boolean getIsHeader(){
		return isHeader; 
	}

	
	/**
	 * @generated
	 */	
	public void setIsHeader(Boolean newVal) {
		this.isHeader = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean isDetail;
	
	/**
	 * @generated
 	 */
	public Boolean getIsDetail(){
		return isDetail; 
	}

	
	/**
	 * @generated
	 */	
	public void setIsDetail(Boolean newVal) {
		this.isDetail = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean pos;
	
	/**
	 * @generated
 	 */
	public Boolean getPos(){
		return pos; 
	}

	
	/**
	 * @generated
	 */	
	public void setPos(Boolean newVal) {
		this.pos = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean ar;
	
	/**
	 * @generated
 	 */
	public Boolean getAr(){
		return ar; 
	}

	
	/**
	 * @generated
	 */	
	public void setAr(Boolean newVal) {
		this.ar = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String description;
	
	/**
	 * @generated
 	 */
	public String getDescription(){
		return description; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescription(String newVal) {
		this.description = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private Users user;
	
	/**
	 * @generated
 	 */
	public Users getUser(){
		return user; 
	}

	
	/**
	 * @generated
	 */	
	public void setUser(Users newVal) {
		this.user = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private Account account;
	
	/**
	 * @generated
 	 */
	public Account getAccount(){
		return account; 
	}

	
	/**
	 * @generated
	 */	
	public void setAccount(Account newVal) {
		this.account = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private Contact contact;
	
	/**
	 * @generated
 	 */
	public Contact getContact(){
		return contact; 
	}

	
	/**
	 * @generated
	 */	
	public void setContact(Contact newVal) {
		this.contact = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private Journal memo;
	
	/**
	 * @generated
 	 */
	public Journal getMemo(){
		return memo; 
	}

	
	/**
	 * @generated
	 */	
	public void setMemo(Journal newVal) {
		this.memo = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Integer arRecord;
	
	/**
	 * @generated
 	 */
	public Integer getArRecord(){
		return arRecord; 
	}

	
	/**
	 * @generated
	 */	
	public void setArRecord(Integer newVal) {
		this.arRecord = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String recordType;
	
	/**
	 * @generated
 	 */
	public String getRecordType(){
		return recordType; 
	}

	
	/**
	 * @generated
	 */	
	public void setRecordType(String newVal) {
		this.recordType = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long typeID;
	
	/**
	 * @generated
 	 */
	public Long getTypeID(){
		return typeID; 
	}

	
	/**
	 * @generated
	 */	
	public void setTypeID(Long newVal) {
		this.typeID = newVal;
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (BATCHNUMBER.equals(propertyName)) return getBatchNumber();
		if (ISDELETEDSTUB.equals(propertyName)) return getIsDeletedStub();
		if (ISVOIDED.equals(propertyName)) return getIsVoided();
		if (RECEIPTPRINT.equals(propertyName)) return getReceiptPrint();
		if (ISHEADER.equals(propertyName)) return getIsHeader();
		if (ISDETAIL.equals(propertyName)) return getIsDetail();
		if (POS.equals(propertyName)) return getPos();
		if (AR.equals(propertyName)) return getAr();
		if (DESCRIPTION.equals(propertyName)) return getDescription();
		if (USER.equals(propertyName)) return getUser();
		if (ACCOUNT.equals(propertyName)) return getAccount();
		if (CONTACT.equals(propertyName)) return getContact();
		if (MEMO.equals(propertyName)) return getMemo();
		if (ARRECORD.equals(propertyName)) return getArRecord();
		if (RECORDTYPE.equals(propertyName)) return getRecordType();
		if (TYPEID.equals(propertyName)) return getTypeID();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (BATCHNUMBER.equals(propertyName)) setBatchNumber((Double)newValue); else
		if (ISDELETEDSTUB.equals(propertyName)) setIsDeletedStub((Boolean)newValue); else
		if (ISVOIDED.equals(propertyName)) setIsVoided((Boolean)newValue); else
		if (RECEIPTPRINT.equals(propertyName)) setReceiptPrint((Boolean)newValue); else
		if (ISHEADER.equals(propertyName)) setIsHeader((Boolean)newValue); else
		if (ISDETAIL.equals(propertyName)) setIsDetail((Boolean)newValue); else
		if (POS.equals(propertyName)) setPos((Boolean)newValue); else
		if (AR.equals(propertyName)) setAr((Boolean)newValue); else
		if (DESCRIPTION.equals(propertyName)) setDescription((String)newValue); else
		if (USER.equals(propertyName)) setUser((Users)newValue); else
		if (ACCOUNT.equals(propertyName)) setAccount((Account)newValue); else
		if (CONTACT.equals(propertyName)) setContact((Contact)newValue); else
		if (MEMO.equals(propertyName)) setMemo((Journal)newValue); else
		if (ARRECORD.equals(propertyName)) setArRecord((Integer)newValue); else
		if (RECORDTYPE.equals(propertyName)) setRecordType((String)newValue); else
		if (TYPEID.equals(propertyName)) setTypeID((Long)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (BATCHNUMBER.equals(propertyName)) 
			return new Class<?>[] {Double.class};		
		if (ISDELETEDSTUB.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISVOIDED.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (RECEIPTPRINT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISHEADER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (ISDETAIL.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (POS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (AR.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (DESCRIPTION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (USER.equals(propertyName)) 
			return new Class<?>[] {Users.class};		
		if (ACCOUNT.equals(propertyName)) 
			return new Class<?>[] {Account.class};		
		if (CONTACT.equals(propertyName)) 
			return new Class<?>[] {Contact.class};		
		if (MEMO.equals(propertyName)) 
			return new Class<?>[] {Journal.class};		
		if (ARRECORD.equals(propertyName)) 
			return new Class<?>[] {Integer.class};		
		if (RECORDTYPE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (TYPEID.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (BATCHNUMBER.equals(propertyName)) return TapeStub.class;
		if (ISDELETEDSTUB.equals(propertyName)) return TapeStub.class;
		if (ISVOIDED.equals(propertyName)) return TapeStub.class;
		if (RECEIPTPRINT.equals(propertyName)) return TapeStub.class;
		if (ISHEADER.equals(propertyName)) return TapeStub.class;
		if (ISDETAIL.equals(propertyName)) return TapeStub.class;
		if (POS.equals(propertyName)) return TapeStub.class;
		if (AR.equals(propertyName)) return TapeStub.class;
		if (DESCRIPTION.equals(propertyName)) return TapeStub.class;
		if (USER.equals(propertyName)) return TapeStub.class;
		if (ACCOUNT.equals(propertyName)) return TapeStub.class;
		if (CONTACT.equals(propertyName)) return TapeStub.class;
		if (MEMO.equals(propertyName)) return TapeStub.class;
		if (ARRECORD.equals(propertyName)) return TapeStub.class;
		if (RECORDTYPE.equals(propertyName)) return TapeStub.class;
		if (TYPEID.equals(propertyName)) return TapeStub.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		TapeStub objT = (TapeStub)obj;
		if (! SmartEquals(getBatchNumber(), objT.getBatchNumber()))
			return false;
		if (! SmartEquals(getIsDeletedStub(), objT.getIsDeletedStub()))
			return false;
		if (! SmartEquals(getIsVoided(), objT.getIsVoided()))
			return false;
		if (! SmartEquals(getReceiptPrint(), objT.getReceiptPrint()))
			return false;
		if (! SmartEquals(getIsHeader(), objT.getIsHeader()))
			return false;
		if (! SmartEquals(getIsDetail(), objT.getIsDetail()))
			return false;
		if (! SmartEquals(getPos(), objT.getPos()))
			return false;
		if (! SmartEquals(getAr(), objT.getAr()))
			return false;
		if (! SmartEquals(getDescription(), objT.getDescription()))
			return false;
		if (! SmartEquals(getUser(), objT.getUser()))
			return false;
		if (! SmartEquals(getAccount(), objT.getAccount()))
			return false;
		if (! SmartEquals(getContact(), objT.getContact()))
			return false;
		if (! SmartEquals(getMemo(), objT.getMemo()))
			return false;
		if (! SmartEquals(getArRecord(), objT.getArRecord()))
			return false;
		if (! SmartEquals(getRecordType(), objT.getRecordType()))
			return false;
		if (! SmartEquals(getTypeID(), objT.getTypeID()))
			return false;
		return true;
	}			
}