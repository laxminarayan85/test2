
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
	@NamedQuery(name = "FormPreferences.findall", query = "from FormPreferences"),
	@NamedQuery(name = "FormPreferences.byId", query = "select a from FormPreferences a where a.id= :id")
})



/**
 * @generated
 */	
@Entity
@Table(name = "formpreferences")
//@SQLDelete(sql="update modelbase set isdeleted='TRUE' from formpreferences where modelbase.id=?")
@SQLDelete(sql="update formpreferences set isdeleted='TRUE' where id=?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause="isdeleted <> 'TRUE'")
public class FormPreferences extends ModelBase {
	/**
	 * @generated
	 */
	public static final String TITLE = "Title";
	/**
	 * @generated
	 */
	public static final String STYLEOPTION = "StyleOption";
	/**
	 * @generated
	 */
	public static final String SHOWFROMADDRESS = "ShowFromAddress";
	/**
	 * @generated
	 */
	public static final String SHOWTOADDRESS = "ShowToAddress";
	/**
	 * @generated
	 */
	public static final String SHOWATTN = "ShowAttn";
	/**
	 * @generated
	 */
	public static final String SHOWSHIPVIA = "ShowShipVia";
	/**
	 * @generated
	 */
	public static final String SHOWDELIVERYDATE = "ShowDeliveryDate";
	/**
	 * @generated
	 */
	public static final String SHOWCUSTOMPO = "ShowCustomPO";
	/**
	 * @generated
	 */
	public static final String SHOWORDERNUMBER = "ShowOrderNumber";
	/**
	 * @generated
	 */
	public static final String SHOWPARTNUMBER = "ShowPartNumber";
	/**
	 * @generated
	 */
	public static final String SHOWTRACKINGNUMBER = "ShowTrackingNumber";
	/**
	 * @generated
	 */
	public static final String SHOWREFERENCE = "ShowReference";
	/**
	 * @generated
	 */
	public static final String SHOWDESCRIPTION = "ShowDescription";
	/**
	 * @generated
	 */
	public static final String SHOWCOMMENT = "ShowComment";
	/**
	 * @generated
	 */
	public static final String SHOWSIGNATURE = "ShowSignature";
	/**
	 * @generated
	 */
	public static final String SHOWBARCODES = "ShowBarCodes";
	/**
	 * @generated
	 */
	public static final String SHOWLOGO = "ShowLogo";
	/**
	 * @generated
	 */
	public static final String SHOWDELIVERYNUMBER = "ShowDeliveryNumber";
	/**
	 * @generated
	 */
	public static final String SHOWDRIVER = "ShowDriver";
	/**
	 * @generated
	 */
	public static final String SHOWCARTONCOUNT = "ShowCartonCount";
	/**
	 * @generated
	 */
	public static final String LOGOLEFTPOSITION = "LogoLeftPosition";
	/**
	 * @generated
	 */
	public static final String LOGOTOPPOSITION = "LogoTopPosition";
	/**
	 * @generated
	 */
	public static final String LOGOACROSSWIDTH = "LogoAcrossWidth";
	/**
	 * @generated
	 */
	public static final String LOGODOWNWIDTH = "LogoDownWidth";
	/**
	 * @generated
	 */
	public static final String FROMADDRESSLEFTPOSITION = "FromAddressLeftPosition";
	/**
	 * @generated
	 */
	public static final String FROMADDRESSTOPPOSITION = "FromAddressTopPosition";
	/**
	 * @generated
	 */
	public static final String FROMADDRESSACROSSWIDTH = "FromAddressAcrossWidth";
	/**
	 * @generated
	 */
	public static final String FROMADDRESSDOWNWIDTH = "FromAddressDownWidth";
	/**
	 * @generated
	 */
	public static final String TOADDRESSLEFTPOSITION = "ToAddressLeftPosition";
	/**
	 * @generated
	 */
	public static final String TOADDRESSTOPPOSITION = "ToAddressTopPosition";
	/**
	 * @generated
	 */
	public static final String TOADDRESSACROSSWIDTH = "ToAddressAcrossWidth";
	/**
	 * @generated
	 */
	public static final String TOADDRESSDOWNWIDTH = "ToAddressDownWidth";
	/**
	 * @generated
	 */
	public static final String ATTNLEFTPOSITION = "AttnLeftPosition";
	/**
	 * @generated
	 */
	public static final String ATTNTOPPOSITION = "AttnTopPosition";
	/**
	 * @generated
	 */
	public static final String ATTNACROSSWIDTH = "AttnAcrossWidth";
	/**
	 * @generated
	 */
	public static final String ATTNDOWNWIDTH = "AttnDownWidth";
	/**
	 * @generated
	 */
	public static final String LINELEFTPOSITION = "LineLeftPosition";
	/**
	 * @generated
	 */
	public static final String LINETOPPOSITION = "LineTopPosition";
	/**
	 * @generated
	 */
	public static final String LINEACROSSWIDTH = "LineAcrossWidth";
	/**
	 * @generated
	 */
	public static final String LINEDOWNWIDTH = "LineDownWidth";
	/**
	 * @generated
	 */
	public static final String COMMENTLEFTPOSITION = "CommentLeftPosition";
	/**
	 * @generated
	 */
	public static final String COMMENTTOPPOSITION = "CommentTopPosition";
	/**
	 * @generated
	 */
	public static final String COMMENTACROSSWIDTH = "CommentAcrossWidth";
	/**
	 * @generated
	 */
	public static final String COMMENTDOWNWIDTH = "CommentDownWidth";
	/**
	 * @generated
	 */
	public static final String DELIVERYDATELEFTPOSITION = "DeliveryDateLeftPosition";
	/**
	 * @generated
	 */
	public static final String DELIVERYDATETOPPOSITION = "DeliveryDateTopPosition";
	/**
	 * @generated
	 */
	public static final String REFERENCELEFTPOSITION = "ReferenceLeftPosition";
	/**
	 * @generated
	 */
	public static final String REFERENCETOPPOSITION = "ReferenceTopPosition";
	/**
	 * @generated
	 */
	public static final String SHIPVIALEFTPOSITION = "ShipViaLeftPosition";
	/**
	 * @generated
	 */
	public static final String SHIPVIATOPPOSITION = "ShipViaTopPosition";
	/**
	 * @generated
	 */
	public static final String CUSTOMERPOLEFTPOSITION = "CustomerPOLeftPosition";
	/**
	 * @generated
	 */
	public static final String CUSTOMERPOTOPPOSITION = "CustomerPOTopPosition";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBERLEFTPOSITION = "OrderNumberLeftPosition";
	/**
	 * @generated
	 */
	public static final String ORDERNUMBERTOPPOSITION = "OrderNumberTopPosition";
	/**
	 * @generated
	 */
	public static final String PARTNUMBERLEFTPOSITION = "PartNumberLeftPosition";
	/**
	 * @generated
	 */
	public static final String PARTNUMBERTOPPOSITION = "PartNumberTopPosition";
	/**
	 * @generated
	 */
	public static final String TRACKINGNUMBERLEFTPOSITION = "TrackingNumberLeftPosition";
	/**
	 * @generated
	 */
	public static final String TRACKINGNUMBERTOPPOSITION = "TrackingNumberTopPosition";
	/**
	 * @generated
	 */
	public static final String DELIVERYNUMBERLEFTPOSITION = "DeliveryNumberLeftPosition";
	/**
	 * @generated
	 */
	public static final String DELIVERYNUMBERTOPPOSITION = "DeliveryNumberTopPosition";
	/**
	 * @generated
	 */
	public static final String DRIVERLEFTPOSITION = "DriverLeftPosition";
	/**
	 * @generated
	 */
	public static final String DRIVERTOPPOSITION = "DriverTopPosition";
	/**
	 * @generated
	 */
	public static final String CARTONCOUNTLEFTPOSITION = "CartonCountLeftPosition";
	/**
	 * @generated
	 */
	public static final String CARTONCOUNTTOPPOSITION = "CartonCountTopPosition";
	/**
	 * @generated
	 */
	public static final String CODLEFTPOSITION = "CodLeftPosition";
	/**
	 * @generated
	 */
	public static final String CODTOPPOSITION = "CodTopPosition";
	/**
	 * @generated
	 */
	public static final String DESCRIPTIONLEFTPOSITION = "DescriptionLeftPosition";
	/**
	 * @generated
	 */
	public static final String DESCRIPTIONTOPPOSITION = "DescriptionTopPosition";
	/**
	 * @generated
	 */
	public static final String SIGNATURELEFTPOSITION = "SignatureLeftPosition";
	/**
	 * @generated
	 */
	public static final String SIGNATURETOPPOSITION = "SignatureTopPosition";
	/**
	 * @generated
	 */
	public static final String SHOWDELIVERYDATETITLE = "ShowDeliveryDateTitle";
	/**
	 * @generated
	 */
	public static final String SHOWREFERENCETITLE = "ShowReferenceTitle";
	/**
	 * @generated
	 */
	public static final String SHOWSHIPVIATITLE = "ShowShipViaTitle";
	/**
	 * @generated
	 */
	public static final String SHOWCUSTOMERPOTITLE = "ShowCustomerPOTitle";
	/**
	 * @generated
	 */
	public static final String SHOWORDERNUMBERTITLE = "ShowOrderNumberTitle";
	/**
	 * @generated
	 */
	public static final String SHOWPARTNUMBERTITLE = "ShowPartNumberTitle";
	/**
	 * @generated
	 */
	public static final String SHOWTRACKINGNUMBERTITLE = "ShowTrackingNumberTitle";
	/**
	 * @generated
	 */
	public static final String SHOWDELIVERYNUMBERTITLE = "ShowDeliveryNumberTitle";
	/**
	 * @generated
	 */
	public static final String SHOWDRIVERTITLE = "ShowDriverTitle";
	/**
	 * @generated
	 */
	public static final String SHOWCARTONCOUNTTITLE = "ShowCartonCountTitle";
	/**
	 * @generated
	 */
	public static final String INVOICENUMBERMARGIN = "InvoiceNumberMargin";
	/**
	 * @generated
	 */
	public static final String ORDEREDQTYMARGIN = "OrderedQtyMargin";
	/**
	 * @generated
	 */
	public static final String SHIPPEDQTYMARGIN = "ShippedQtyMargin";
	/**
	 * @generated
	 */
	public static final String DESCRIPTIONMARGIN = "DescriptionMargin";
	/**
	 * @generated
	 */
	public static final String WEIGHTMARGIN = "WeightMargin";
	/**
	 * @generated
	 */
	public static final String INVOICENUMBERWIDTH = "InvoiceNumberWidth";
	/**
	 * @generated
	 */
	public static final String ORDEREDQTYWIDTH = "OrderedQtyWidth";
	/**
	 * @generated
	 */
	public static final String SHIPPEDQTYWIDTH = "ShippedQtyWidth";
	/**
	 * @generated
	 */
	public static final String DESCRIPTIONWIDTH = "DescriptionWidth";
	/**
	 * @generated
	 */
	public static final String WEIGHTWIDTH = "WeightWidth";
	/**
	 * @generated
	 */
	public static final String WIDTHOFALLITEMS = "WidthOfAllItems";
	/**
	 * @generated
	 */
	public static final String ADDRESSFONTBEAN = "AddressFontBean";
	/**
	 * @generated
	 */
	public static final String DATEFONTBEAN = "DateFontBean";
	/**
	 * @generated
	 */
	public static final String BODYTEXTFONTBEAN = "BodyTextFontBean";
	/**
	 * @generated
	 */
	public static final String FORMFONTBEAN = "FormFontBean";
	/**
	 * @generated
	 */
	public static final String FORMIMAGESOURCE = "FormImageSource";
	/**
	 * @generated
	 */
	public static final String FORMIMAGEPATH = "FormImagePath";
	/**
	 * @generated
	 */
	public static final String LOGOIMAGESOURCE = "LogoImageSource";
	/**
	 * @generated
	 */
	public static final String LOGOIMAGEPATH = "LogoImagePath";
	/**
	 * @generated
	 */
	public static final String DATAOFFSETLEFTRIGHT = "DataOffsetLeftRight";
	/**
	 * @generated
	 */
	public static final String DATAOFFSETDOWNUP = "DataOffsetDownUp";
	/**
	 * @generated
	 */
	public static final String IMAGEOFFSETLEFTRIGHT = "ImageOffsetLeftRight";
	/**
	 * @generated
	 */
	public static final String IMAGEOFFSETDOWNUP = "ImageOffsetDownUp";
	/**
	 * @generated
	 */
	public static final String MEASUREMENT = "Measurement";

	/**
	 * @generated
	 */
	public FormPreferences() {
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
	private String title;
	
	/**
	 * @generated
 	 */
	public String getTitle(){
		return title; 
	}

	
	/**
	 * @generated
	 */	
	public void setTitle(String newVal) {
		this.title = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String styleOption;
	
	/**
	 * @generated
 	 */
	public String getStyleOption(){
		return styleOption; 
	}

	
	/**
	 * @generated
	 */	
	public void setStyleOption(String newVal) {
		this.styleOption = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showFromAddress;
	
	/**
	 * @generated
 	 */
	public Boolean getShowFromAddress(){
		return showFromAddress; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowFromAddress(Boolean newVal) {
		this.showFromAddress = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showToAddress;
	
	/**
	 * @generated
 	 */
	public Boolean getShowToAddress(){
		return showToAddress; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowToAddress(Boolean newVal) {
		this.showToAddress = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showAttn;
	
	/**
	 * @generated
 	 */
	public Boolean getShowAttn(){
		return showAttn; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowAttn(Boolean newVal) {
		this.showAttn = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showShipVia;
	
	/**
	 * @generated
 	 */
	public Boolean getShowShipVia(){
		return showShipVia; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowShipVia(Boolean newVal) {
		this.showShipVia = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDeliveryDate;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDeliveryDate(){
		return showDeliveryDate; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDeliveryDate(Boolean newVal) {
		this.showDeliveryDate = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showCustomPO;
	
	/**
	 * @generated
 	 */
	public Boolean getShowCustomPO(){
		return showCustomPO; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowCustomPO(Boolean newVal) {
		this.showCustomPO = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showOrderNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getShowOrderNumber(){
		return showOrderNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowOrderNumber(Boolean newVal) {
		this.showOrderNumber = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showPartNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getShowPartNumber(){
		return showPartNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowPartNumber(Boolean newVal) {
		this.showPartNumber = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showTrackingNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getShowTrackingNumber(){
		return showTrackingNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowTrackingNumber(Boolean newVal) {
		this.showTrackingNumber = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showReference;
	
	/**
	 * @generated
 	 */
	public Boolean getShowReference(){
		return showReference; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowReference(Boolean newVal) {
		this.showReference = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDescription;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDescription(){
		return showDescription; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDescription(Boolean newVal) {
		this.showDescription = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showComment;
	
	/**
	 * @generated
 	 */
	public Boolean getShowComment(){
		return showComment; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowComment(Boolean newVal) {
		this.showComment = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showSignature;
	
	/**
	 * @generated
 	 */
	public Boolean getShowSignature(){
		return showSignature; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowSignature(Boolean newVal) {
		this.showSignature = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showBarCodes;
	
	/**
	 * @generated
 	 */
	public Boolean getShowBarCodes(){
		return showBarCodes; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowBarCodes(Boolean newVal) {
		this.showBarCodes = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showLogo;
	
	/**
	 * @generated
 	 */
	public Boolean getShowLogo(){
		return showLogo; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowLogo(Boolean newVal) {
		this.showLogo = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDeliveryNumber;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDeliveryNumber(){
		return showDeliveryNumber; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDeliveryNumber(Boolean newVal) {
		this.showDeliveryNumber = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDriver;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDriver(){
		return showDriver; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDriver(Boolean newVal) {
		this.showDriver = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showCartonCount;
	
	/**
	 * @generated
 	 */
	public Boolean getShowCartonCount(){
		return showCartonCount; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowCartonCount(Boolean newVal) {
		this.showCartonCount = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long logoLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getLogoLeftPosition(){
		return logoLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoLeftPosition(Long newVal) {
		this.logoLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long logoTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getLogoTopPosition(){
		return logoTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoTopPosition(Long newVal) {
		this.logoTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long logoAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getLogoAcrossWidth(){
		return logoAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoAcrossWidth(Long newVal) {
		this.logoAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long logoDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getLogoDownWidth(){
		return logoDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoDownWidth(Long newVal) {
		this.logoDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fromAddressLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getFromAddressLeftPosition(){
		return fromAddressLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setFromAddressLeftPosition(Long newVal) {
		this.fromAddressLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fromAddressTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getFromAddressTopPosition(){
		return fromAddressTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setFromAddressTopPosition(Long newVal) {
		this.fromAddressTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fromAddressAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getFromAddressAcrossWidth(){
		return fromAddressAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setFromAddressAcrossWidth(Long newVal) {
		this.fromAddressAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long fromAddressDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getFromAddressDownWidth(){
		return fromAddressDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setFromAddressDownWidth(Long newVal) {
		this.fromAddressDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long toAddressLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getToAddressLeftPosition(){
		return toAddressLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setToAddressLeftPosition(Long newVal) {
		this.toAddressLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long toAddressTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getToAddressTopPosition(){
		return toAddressTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setToAddressTopPosition(Long newVal) {
		this.toAddressTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long toAddressAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getToAddressAcrossWidth(){
		return toAddressAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setToAddressAcrossWidth(Long newVal) {
		this.toAddressAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long toAddressDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getToAddressDownWidth(){
		return toAddressDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setToAddressDownWidth(Long newVal) {
		this.toAddressDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long attnLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getAttnLeftPosition(){
		return attnLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setAttnLeftPosition(Long newVal) {
		this.attnLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long attnTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getAttnTopPosition(){
		return attnTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setAttnTopPosition(Long newVal) {
		this.attnTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long attnAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getAttnAcrossWidth(){
		return attnAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setAttnAcrossWidth(Long newVal) {
		this.attnAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long attnDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getAttnDownWidth(){
		return attnDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setAttnDownWidth(Long newVal) {
		this.attnDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long lineLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getLineLeftPosition(){
		return lineLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setLineLeftPosition(Long newVal) {
		this.lineLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long lineTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getLineTopPosition(){
		return lineTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setLineTopPosition(Long newVal) {
		this.lineTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long lineAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getLineAcrossWidth(){
		return lineAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setLineAcrossWidth(Long newVal) {
		this.lineAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long lineDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getLineDownWidth(){
		return lineDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setLineDownWidth(Long newVal) {
		this.lineDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long commentLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getCommentLeftPosition(){
		return commentLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCommentLeftPosition(Long newVal) {
		this.commentLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long commentTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getCommentTopPosition(){
		return commentTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCommentTopPosition(Long newVal) {
		this.commentTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long commentAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Long getCommentAcrossWidth(){
		return commentAcrossWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setCommentAcrossWidth(Long newVal) {
		this.commentAcrossWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long commentDownWidth;
	
	/**
	 * @generated
 	 */
	public Long getCommentDownWidth(){
		return commentDownWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setCommentDownWidth(Long newVal) {
		this.commentDownWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long deliveryDateLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getDeliveryDateLeftPosition(){
		return deliveryDateLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDeliveryDateLeftPosition(Long newVal) {
		this.deliveryDateLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long deliveryDateTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getDeliveryDateTopPosition(){
		return deliveryDateTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDeliveryDateTopPosition(Long newVal) {
		this.deliveryDateTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long referenceLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getReferenceLeftPosition(){
		return referenceLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setReferenceLeftPosition(Long newVal) {
		this.referenceLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long referenceTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getReferenceTopPosition(){
		return referenceTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setReferenceTopPosition(Long newVal) {
		this.referenceTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long shipViaLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getShipViaLeftPosition(){
		return shipViaLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setShipViaLeftPosition(Long newVal) {
		this.shipViaLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long shipViaTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getShipViaTopPosition(){
		return shipViaTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setShipViaTopPosition(Long newVal) {
		this.shipViaTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long customerPOLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getCustomerPOLeftPosition(){
		return customerPOLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCustomerPOLeftPosition(Long newVal) {
		this.customerPOLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long customerPOTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getCustomerPOTopPosition(){
		return customerPOTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCustomerPOTopPosition(Long newVal) {
		this.customerPOTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long orderNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getOrderNumberLeftPosition(){
		return orderNumberLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setOrderNumberLeftPosition(Long newVal) {
		this.orderNumberLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long orderNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getOrderNumberTopPosition(){
		return orderNumberTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setOrderNumberTopPosition(Long newVal) {
		this.orderNumberTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long partNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getPartNumberLeftPosition(){
		return partNumberLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setPartNumberLeftPosition(Long newVal) {
		this.partNumberLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long partNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getPartNumberTopPosition(){
		return partNumberTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setPartNumberTopPosition(Long newVal) {
		this.partNumberTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long trackingNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getTrackingNumberLeftPosition(){
		return trackingNumberLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setTrackingNumberLeftPosition(Long newVal) {
		this.trackingNumberLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long trackingNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getTrackingNumberTopPosition(){
		return trackingNumberTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setTrackingNumberTopPosition(Long newVal) {
		this.trackingNumberTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long deliveryNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getDeliveryNumberLeftPosition(){
		return deliveryNumberLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDeliveryNumberLeftPosition(Long newVal) {
		this.deliveryNumberLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long deliveryNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getDeliveryNumberTopPosition(){
		return deliveryNumberTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDeliveryNumberTopPosition(Long newVal) {
		this.deliveryNumberTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long driverLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getDriverLeftPosition(){
		return driverLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDriverLeftPosition(Long newVal) {
		this.driverLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long driverTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getDriverTopPosition(){
		return driverTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDriverTopPosition(Long newVal) {
		this.driverTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long cartonCountLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getCartonCountLeftPosition(){
		return cartonCountLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCartonCountLeftPosition(Long newVal) {
		this.cartonCountLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long cartonCountTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getCartonCountTopPosition(){
		return cartonCountTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCartonCountTopPosition(Long newVal) {
		this.cartonCountTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long codLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getCodLeftPosition(){
		return codLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCodLeftPosition(Long newVal) {
		this.codLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long codTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getCodTopPosition(){
		return codTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setCodTopPosition(Long newVal) {
		this.codTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long descriptionLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getDescriptionLeftPosition(){
		return descriptionLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescriptionLeftPosition(Long newVal) {
		this.descriptionLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long descriptionTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getDescriptionTopPosition(){
		return descriptionTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescriptionTopPosition(Long newVal) {
		this.descriptionTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long signatureLeftPosition;
	
	/**
	 * @generated
 	 */
	public Long getSignatureLeftPosition(){
		return signatureLeftPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setSignatureLeftPosition(Long newVal) {
		this.signatureLeftPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long signatureTopPosition;
	
	/**
	 * @generated
 	 */
	public Long getSignatureTopPosition(){
		return signatureTopPosition; 
	}

	
	/**
	 * @generated
	 */	
	public void setSignatureTopPosition(Long newVal) {
		this.signatureTopPosition = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDeliveryDateTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDeliveryDateTitle(){
		return showDeliveryDateTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDeliveryDateTitle(Boolean newVal) {
		this.showDeliveryDateTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showReferenceTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowReferenceTitle(){
		return showReferenceTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowReferenceTitle(Boolean newVal) {
		this.showReferenceTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showShipViaTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowShipViaTitle(){
		return showShipViaTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowShipViaTitle(Boolean newVal) {
		this.showShipViaTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showCustomerPOTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowCustomerPOTitle(){
		return showCustomerPOTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowCustomerPOTitle(Boolean newVal) {
		this.showCustomerPOTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showOrderNumberTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowOrderNumberTitle(){
		return showOrderNumberTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowOrderNumberTitle(Boolean newVal) {
		this.showOrderNumberTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showPartNumberTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowPartNumberTitle(){
		return showPartNumberTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowPartNumberTitle(Boolean newVal) {
		this.showPartNumberTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showTrackingNumberTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowTrackingNumberTitle(){
		return showTrackingNumberTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowTrackingNumberTitle(Boolean newVal) {
		this.showTrackingNumberTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDeliveryNumberTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDeliveryNumberTitle(){
		return showDeliveryNumberTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDeliveryNumberTitle(Boolean newVal) {
		this.showDeliveryNumberTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showDriverTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowDriverTitle(){
		return showDriverTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowDriverTitle(Boolean newVal) {
		this.showDriverTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Boolean showCartonCountTitle;
	
	/**
	 * @generated
 	 */
	public Boolean getShowCartonCountTitle(){
		return showCartonCountTitle; 
	}

	
	/**
	 * @generated
	 */	
	public void setShowCartonCountTitle(Boolean newVal) {
		this.showCartonCountTitle = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long invoiceNumberMargin;
	
	/**
	 * @generated
 	 */
	public Long getInvoiceNumberMargin(){
		return invoiceNumberMargin; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceNumberMargin(Long newVal) {
		this.invoiceNumberMargin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long orderedQtyMargin;
	
	/**
	 * @generated
 	 */
	public Long getOrderedQtyMargin(){
		return orderedQtyMargin; 
	}

	
	/**
	 * @generated
	 */	
	public void setOrderedQtyMargin(Long newVal) {
		this.orderedQtyMargin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long shippedQtyMargin;
	
	/**
	 * @generated
 	 */
	public Long getShippedQtyMargin(){
		return shippedQtyMargin; 
	}

	
	/**
	 * @generated
	 */	
	public void setShippedQtyMargin(Long newVal) {
		this.shippedQtyMargin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long descriptionMargin;
	
	/**
	 * @generated
 	 */
	public Long getDescriptionMargin(){
		return descriptionMargin; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescriptionMargin(Long newVal) {
		this.descriptionMargin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long weightMargin;
	
	/**
	 * @generated
 	 */
	public Long getWeightMargin(){
		return weightMargin; 
	}

	
	/**
	 * @generated
	 */	
	public void setWeightMargin(Long newVal) {
		this.weightMargin = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long invoiceNumberWidth;
	
	/**
	 * @generated
 	 */
	public Long getInvoiceNumberWidth(){
		return invoiceNumberWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setInvoiceNumberWidth(Long newVal) {
		this.invoiceNumberWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long orderedQtyWidth;
	
	/**
	 * @generated
 	 */
	public Long getOrderedQtyWidth(){
		return orderedQtyWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setOrderedQtyWidth(Long newVal) {
		this.orderedQtyWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long shippedQtyWidth;
	
	/**
	 * @generated
 	 */
	public Long getShippedQtyWidth(){
		return shippedQtyWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setShippedQtyWidth(Long newVal) {
		this.shippedQtyWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long descriptionWidth;
	
	/**
	 * @generated
 	 */
	public Long getDescriptionWidth(){
		return descriptionWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setDescriptionWidth(Long newVal) {
		this.descriptionWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long weightWidth;
	
	/**
	 * @generated
 	 */
	public Long getWeightWidth(){
		return weightWidth; 
	}

	
	/**
	 * @generated
	 */	
	public void setWeightWidth(Long newVal) {
		this.weightWidth = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long widthOfAllItems;
	
	/**
	 * @generated
 	 */
	public Long getWidthOfAllItems(){
		return widthOfAllItems; 
	}

	
	/**
	 * @generated
	 */	
	public void setWidthOfAllItems(Long newVal) {
		this.widthOfAllItems = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition addressFontBean;
	
	/**
	 * @generated
 	 */
	public FontDefinition getAddressFontBean(){
		return addressFontBean; 
	}

	
	/**
	 * @generated
	 */	
	public void setAddressFontBean(FontDefinition newVal) {
		this.addressFontBean = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition dateFontBean;
	
	/**
	 * @generated
 	 */
	public FontDefinition getDateFontBean(){
		return dateFontBean; 
	}

	
	/**
	 * @generated
	 */	
	public void setDateFontBean(FontDefinition newVal) {
		this.dateFontBean = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition bodyTextFontBean;
	
	/**
	 * @generated
 	 */
	public FontDefinition getBodyTextFontBean(){
		return bodyTextFontBean; 
	}

	
	/**
	 * @generated
	 */	
	public void setBodyTextFontBean(FontDefinition newVal) {
		this.bodyTextFontBean = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
    @ManyToOne()
    @Where(clause="isdeleted <> 'TRUE'")
	private FontDefinition formFontBean;
	
	/**
	 * @generated
 	 */
	public FontDefinition getFormFontBean(){
		return formFontBean; 
	}

	
	/**
	 * @generated
	 */	
	public void setFormFontBean(FontDefinition newVal) {
		this.formFontBean = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String formImageSource;
	
	/**
	 * @generated
 	 */
	public String getFormImageSource(){
		return formImageSource; 
	}

	
	/**
	 * @generated
	 */	
	public void setFormImageSource(String newVal) {
		this.formImageSource = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String formImagePath;
	
	/**
	 * @generated
 	 */
	public String getFormImagePath(){
		return formImagePath; 
	}

	
	/**
	 * @generated
	 */	
	public void setFormImagePath(String newVal) {
		this.formImagePath = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String logoImageSource;
	
	/**
	 * @generated
 	 */
	public String getLogoImageSource(){
		return logoImageSource; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoImageSource(String newVal) {
		this.logoImageSource = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String logoImagePath;
	
	/**
	 * @generated
 	 */
	public String getLogoImagePath(){
		return logoImagePath; 
	}

	
	/**
	 * @generated
	 */	
	public void setLogoImagePath(String newVal) {
		this.logoImagePath = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long dataOffsetLeftRight;
	
	/**
	 * @generated
 	 */
	public Long getDataOffsetLeftRight(){
		return dataOffsetLeftRight; 
	}

	
	/**
	 * @generated
	 */	
	public void setDataOffsetLeftRight(Long newVal) {
		this.dataOffsetLeftRight = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long dataOffsetDownUp;
	
	/**
	 * @generated
 	 */
	public Long getDataOffsetDownUp(){
		return dataOffsetDownUp; 
	}

	
	/**
	 * @generated
	 */	
	public void setDataOffsetDownUp(Long newVal) {
		this.dataOffsetDownUp = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long imageOffsetLeftRight;
	
	/**
	 * @generated
 	 */
	public Long getImageOffsetLeftRight(){
		return imageOffsetLeftRight; 
	}

	
	/**
	 * @generated
	 */	
	public void setImageOffsetLeftRight(Long newVal) {
		this.imageOffsetLeftRight = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private Long imageOffsetDownUp;
	
	/**
	 * @generated
 	 */
	public Long getImageOffsetDownUp(){
		return imageOffsetDownUp; 
	}

	
	/**
	 * @generated
	 */	
	public void setImageOffsetDownUp(Long newVal) {
		this.imageOffsetDownUp = newVal;
	}
	
 	
	
	/**
	 * @generated
	 */	
 	@Basic
	private String measurement;
	
	/**
	 * @generated
 	 */
	public String getMeasurement(){
		return measurement; 
	}

	
	/**
	 * @generated
	 */	
	public void setMeasurement(String newVal) {
		this.measurement = newVal;
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Object getProperty(String propertyName) throws UnknownPropertyException {
		if (TITLE.equals(propertyName)) return getTitle();
		if (STYLEOPTION.equals(propertyName)) return getStyleOption();
		if (SHOWFROMADDRESS.equals(propertyName)) return getShowFromAddress();
		if (SHOWTOADDRESS.equals(propertyName)) return getShowToAddress();
		if (SHOWATTN.equals(propertyName)) return getShowAttn();
		if (SHOWSHIPVIA.equals(propertyName)) return getShowShipVia();
		if (SHOWDELIVERYDATE.equals(propertyName)) return getShowDeliveryDate();
		if (SHOWCUSTOMPO.equals(propertyName)) return getShowCustomPO();
		if (SHOWORDERNUMBER.equals(propertyName)) return getShowOrderNumber();
		if (SHOWPARTNUMBER.equals(propertyName)) return getShowPartNumber();
		if (SHOWTRACKINGNUMBER.equals(propertyName)) return getShowTrackingNumber();
		if (SHOWREFERENCE.equals(propertyName)) return getShowReference();
		if (SHOWDESCRIPTION.equals(propertyName)) return getShowDescription();
		if (SHOWCOMMENT.equals(propertyName)) return getShowComment();
		if (SHOWSIGNATURE.equals(propertyName)) return getShowSignature();
		if (SHOWBARCODES.equals(propertyName)) return getShowBarCodes();
		if (SHOWLOGO.equals(propertyName)) return getShowLogo();
		if (SHOWDELIVERYNUMBER.equals(propertyName)) return getShowDeliveryNumber();
		if (SHOWDRIVER.equals(propertyName)) return getShowDriver();
		if (SHOWCARTONCOUNT.equals(propertyName)) return getShowCartonCount();
		if (LOGOLEFTPOSITION.equals(propertyName)) return getLogoLeftPosition();
		if (LOGOTOPPOSITION.equals(propertyName)) return getLogoTopPosition();
		if (LOGOACROSSWIDTH.equals(propertyName)) return getLogoAcrossWidth();
		if (LOGODOWNWIDTH.equals(propertyName)) return getLogoDownWidth();
		if (FROMADDRESSLEFTPOSITION.equals(propertyName)) return getFromAddressLeftPosition();
		if (FROMADDRESSTOPPOSITION.equals(propertyName)) return getFromAddressTopPosition();
		if (FROMADDRESSACROSSWIDTH.equals(propertyName)) return getFromAddressAcrossWidth();
		if (FROMADDRESSDOWNWIDTH.equals(propertyName)) return getFromAddressDownWidth();
		if (TOADDRESSLEFTPOSITION.equals(propertyName)) return getToAddressLeftPosition();
		if (TOADDRESSTOPPOSITION.equals(propertyName)) return getToAddressTopPosition();
		if (TOADDRESSACROSSWIDTH.equals(propertyName)) return getToAddressAcrossWidth();
		if (TOADDRESSDOWNWIDTH.equals(propertyName)) return getToAddressDownWidth();
		if (ATTNLEFTPOSITION.equals(propertyName)) return getAttnLeftPosition();
		if (ATTNTOPPOSITION.equals(propertyName)) return getAttnTopPosition();
		if (ATTNACROSSWIDTH.equals(propertyName)) return getAttnAcrossWidth();
		if (ATTNDOWNWIDTH.equals(propertyName)) return getAttnDownWidth();
		if (LINELEFTPOSITION.equals(propertyName)) return getLineLeftPosition();
		if (LINETOPPOSITION.equals(propertyName)) return getLineTopPosition();
		if (LINEACROSSWIDTH.equals(propertyName)) return getLineAcrossWidth();
		if (LINEDOWNWIDTH.equals(propertyName)) return getLineDownWidth();
		if (COMMENTLEFTPOSITION.equals(propertyName)) return getCommentLeftPosition();
		if (COMMENTTOPPOSITION.equals(propertyName)) return getCommentTopPosition();
		if (COMMENTACROSSWIDTH.equals(propertyName)) return getCommentAcrossWidth();
		if (COMMENTDOWNWIDTH.equals(propertyName)) return getCommentDownWidth();
		if (DELIVERYDATELEFTPOSITION.equals(propertyName)) return getDeliveryDateLeftPosition();
		if (DELIVERYDATETOPPOSITION.equals(propertyName)) return getDeliveryDateTopPosition();
		if (REFERENCELEFTPOSITION.equals(propertyName)) return getReferenceLeftPosition();
		if (REFERENCETOPPOSITION.equals(propertyName)) return getReferenceTopPosition();
		if (SHIPVIALEFTPOSITION.equals(propertyName)) return getShipViaLeftPosition();
		if (SHIPVIATOPPOSITION.equals(propertyName)) return getShipViaTopPosition();
		if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) return getCustomerPOLeftPosition();
		if (CUSTOMERPOTOPPOSITION.equals(propertyName)) return getCustomerPOTopPosition();
		if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) return getOrderNumberLeftPosition();
		if (ORDERNUMBERTOPPOSITION.equals(propertyName)) return getOrderNumberTopPosition();
		if (PARTNUMBERLEFTPOSITION.equals(propertyName)) return getPartNumberLeftPosition();
		if (PARTNUMBERTOPPOSITION.equals(propertyName)) return getPartNumberTopPosition();
		if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) return getTrackingNumberLeftPosition();
		if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) return getTrackingNumberTopPosition();
		if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) return getDeliveryNumberLeftPosition();
		if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) return getDeliveryNumberTopPosition();
		if (DRIVERLEFTPOSITION.equals(propertyName)) return getDriverLeftPosition();
		if (DRIVERTOPPOSITION.equals(propertyName)) return getDriverTopPosition();
		if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) return getCartonCountLeftPosition();
		if (CARTONCOUNTTOPPOSITION.equals(propertyName)) return getCartonCountTopPosition();
		if (CODLEFTPOSITION.equals(propertyName)) return getCodLeftPosition();
		if (CODTOPPOSITION.equals(propertyName)) return getCodTopPosition();
		if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) return getDescriptionLeftPosition();
		if (DESCRIPTIONTOPPOSITION.equals(propertyName)) return getDescriptionTopPosition();
		if (SIGNATURELEFTPOSITION.equals(propertyName)) return getSignatureLeftPosition();
		if (SIGNATURETOPPOSITION.equals(propertyName)) return getSignatureTopPosition();
		if (SHOWDELIVERYDATETITLE.equals(propertyName)) return getShowDeliveryDateTitle();
		if (SHOWREFERENCETITLE.equals(propertyName)) return getShowReferenceTitle();
		if (SHOWSHIPVIATITLE.equals(propertyName)) return getShowShipViaTitle();
		if (SHOWCUSTOMERPOTITLE.equals(propertyName)) return getShowCustomerPOTitle();
		if (SHOWORDERNUMBERTITLE.equals(propertyName)) return getShowOrderNumberTitle();
		if (SHOWPARTNUMBERTITLE.equals(propertyName)) return getShowPartNumberTitle();
		if (SHOWTRACKINGNUMBERTITLE.equals(propertyName)) return getShowTrackingNumberTitle();
		if (SHOWDELIVERYNUMBERTITLE.equals(propertyName)) return getShowDeliveryNumberTitle();
		if (SHOWDRIVERTITLE.equals(propertyName)) return getShowDriverTitle();
		if (SHOWCARTONCOUNTTITLE.equals(propertyName)) return getShowCartonCountTitle();
		if (INVOICENUMBERMARGIN.equals(propertyName)) return getInvoiceNumberMargin();
		if (ORDEREDQTYMARGIN.equals(propertyName)) return getOrderedQtyMargin();
		if (SHIPPEDQTYMARGIN.equals(propertyName)) return getShippedQtyMargin();
		if (DESCRIPTIONMARGIN.equals(propertyName)) return getDescriptionMargin();
		if (WEIGHTMARGIN.equals(propertyName)) return getWeightMargin();
		if (INVOICENUMBERWIDTH.equals(propertyName)) return getInvoiceNumberWidth();
		if (ORDEREDQTYWIDTH.equals(propertyName)) return getOrderedQtyWidth();
		if (SHIPPEDQTYWIDTH.equals(propertyName)) return getShippedQtyWidth();
		if (DESCRIPTIONWIDTH.equals(propertyName)) return getDescriptionWidth();
		if (WEIGHTWIDTH.equals(propertyName)) return getWeightWidth();
		if (WIDTHOFALLITEMS.equals(propertyName)) return getWidthOfAllItems();
		if (ADDRESSFONTBEAN.equals(propertyName)) return getAddressFontBean();
		if (DATEFONTBEAN.equals(propertyName)) return getDateFontBean();
		if (BODYTEXTFONTBEAN.equals(propertyName)) return getBodyTextFontBean();
		if (FORMFONTBEAN.equals(propertyName)) return getFormFontBean();
		if (FORMIMAGESOURCE.equals(propertyName)) return getFormImageSource();
		if (FORMIMAGEPATH.equals(propertyName)) return getFormImagePath();
		if (LOGOIMAGESOURCE.equals(propertyName)) return getLogoImageSource();
		if (LOGOIMAGEPATH.equals(propertyName)) return getLogoImagePath();
		if (DATAOFFSETLEFTRIGHT.equals(propertyName)) return getDataOffsetLeftRight();
		if (DATAOFFSETDOWNUP.equals(propertyName)) return getDataOffsetDownUp();
		if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) return getImageOffsetLeftRight();
		if (IMAGEOFFSETDOWNUP.equals(propertyName)) return getImageOffsetDownUp();
		if (MEASUREMENT.equals(propertyName)) return getMeasurement();
		return super.getProperty(propertyName);
	}
	
	/**
	 * @generated
	 */		
	@SuppressWarnings("unchecked")
	@Override
	public void setProperty(String propertyName, Object newValue) throws PropertyException {
		if (TITLE.equals(propertyName)) setTitle((String)newValue); else
		if (STYLEOPTION.equals(propertyName)) setStyleOption((String)newValue); else
		if (SHOWFROMADDRESS.equals(propertyName)) setShowFromAddress((Boolean)newValue); else
		if (SHOWTOADDRESS.equals(propertyName)) setShowToAddress((Boolean)newValue); else
		if (SHOWATTN.equals(propertyName)) setShowAttn((Boolean)newValue); else
		if (SHOWSHIPVIA.equals(propertyName)) setShowShipVia((Boolean)newValue); else
		if (SHOWDELIVERYDATE.equals(propertyName)) setShowDeliveryDate((Boolean)newValue); else
		if (SHOWCUSTOMPO.equals(propertyName)) setShowCustomPO((Boolean)newValue); else
		if (SHOWORDERNUMBER.equals(propertyName)) setShowOrderNumber((Boolean)newValue); else
		if (SHOWPARTNUMBER.equals(propertyName)) setShowPartNumber((Boolean)newValue); else
		if (SHOWTRACKINGNUMBER.equals(propertyName)) setShowTrackingNumber((Boolean)newValue); else
		if (SHOWREFERENCE.equals(propertyName)) setShowReference((Boolean)newValue); else
		if (SHOWDESCRIPTION.equals(propertyName)) setShowDescription((Boolean)newValue); else
		if (SHOWCOMMENT.equals(propertyName)) setShowComment((Boolean)newValue); else
		if (SHOWSIGNATURE.equals(propertyName)) setShowSignature((Boolean)newValue); else
		if (SHOWBARCODES.equals(propertyName)) setShowBarCodes((Boolean)newValue); else
		if (SHOWLOGO.equals(propertyName)) setShowLogo((Boolean)newValue); else
		if (SHOWDELIVERYNUMBER.equals(propertyName)) setShowDeliveryNumber((Boolean)newValue); else
		if (SHOWDRIVER.equals(propertyName)) setShowDriver((Boolean)newValue); else
		if (SHOWCARTONCOUNT.equals(propertyName)) setShowCartonCount((Boolean)newValue); else
		if (LOGOLEFTPOSITION.equals(propertyName)) setLogoLeftPosition((Long)newValue); else
		if (LOGOTOPPOSITION.equals(propertyName)) setLogoTopPosition((Long)newValue); else
		if (LOGOACROSSWIDTH.equals(propertyName)) setLogoAcrossWidth((Long)newValue); else
		if (LOGODOWNWIDTH.equals(propertyName)) setLogoDownWidth((Long)newValue); else
		if (FROMADDRESSLEFTPOSITION.equals(propertyName)) setFromAddressLeftPosition((Long)newValue); else
		if (FROMADDRESSTOPPOSITION.equals(propertyName)) setFromAddressTopPosition((Long)newValue); else
		if (FROMADDRESSACROSSWIDTH.equals(propertyName)) setFromAddressAcrossWidth((Long)newValue); else
		if (FROMADDRESSDOWNWIDTH.equals(propertyName)) setFromAddressDownWidth((Long)newValue); else
		if (TOADDRESSLEFTPOSITION.equals(propertyName)) setToAddressLeftPosition((Long)newValue); else
		if (TOADDRESSTOPPOSITION.equals(propertyName)) setToAddressTopPosition((Long)newValue); else
		if (TOADDRESSACROSSWIDTH.equals(propertyName)) setToAddressAcrossWidth((Long)newValue); else
		if (TOADDRESSDOWNWIDTH.equals(propertyName)) setToAddressDownWidth((Long)newValue); else
		if (ATTNLEFTPOSITION.equals(propertyName)) setAttnLeftPosition((Long)newValue); else
		if (ATTNTOPPOSITION.equals(propertyName)) setAttnTopPosition((Long)newValue); else
		if (ATTNACROSSWIDTH.equals(propertyName)) setAttnAcrossWidth((Long)newValue); else
		if (ATTNDOWNWIDTH.equals(propertyName)) setAttnDownWidth((Long)newValue); else
		if (LINELEFTPOSITION.equals(propertyName)) setLineLeftPosition((Long)newValue); else
		if (LINETOPPOSITION.equals(propertyName)) setLineTopPosition((Long)newValue); else
		if (LINEACROSSWIDTH.equals(propertyName)) setLineAcrossWidth((Long)newValue); else
		if (LINEDOWNWIDTH.equals(propertyName)) setLineDownWidth((Long)newValue); else
		if (COMMENTLEFTPOSITION.equals(propertyName)) setCommentLeftPosition((Long)newValue); else
		if (COMMENTTOPPOSITION.equals(propertyName)) setCommentTopPosition((Long)newValue); else
		if (COMMENTACROSSWIDTH.equals(propertyName)) setCommentAcrossWidth((Long)newValue); else
		if (COMMENTDOWNWIDTH.equals(propertyName)) setCommentDownWidth((Long)newValue); else
		if (DELIVERYDATELEFTPOSITION.equals(propertyName)) setDeliveryDateLeftPosition((Long)newValue); else
		if (DELIVERYDATETOPPOSITION.equals(propertyName)) setDeliveryDateTopPosition((Long)newValue); else
		if (REFERENCELEFTPOSITION.equals(propertyName)) setReferenceLeftPosition((Long)newValue); else
		if (REFERENCETOPPOSITION.equals(propertyName)) setReferenceTopPosition((Long)newValue); else
		if (SHIPVIALEFTPOSITION.equals(propertyName)) setShipViaLeftPosition((Long)newValue); else
		if (SHIPVIATOPPOSITION.equals(propertyName)) setShipViaTopPosition((Long)newValue); else
		if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) setCustomerPOLeftPosition((Long)newValue); else
		if (CUSTOMERPOTOPPOSITION.equals(propertyName)) setCustomerPOTopPosition((Long)newValue); else
		if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) setOrderNumberLeftPosition((Long)newValue); else
		if (ORDERNUMBERTOPPOSITION.equals(propertyName)) setOrderNumberTopPosition((Long)newValue); else
		if (PARTNUMBERLEFTPOSITION.equals(propertyName)) setPartNumberLeftPosition((Long)newValue); else
		if (PARTNUMBERTOPPOSITION.equals(propertyName)) setPartNumberTopPosition((Long)newValue); else
		if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) setTrackingNumberLeftPosition((Long)newValue); else
		if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) setTrackingNumberTopPosition((Long)newValue); else
		if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) setDeliveryNumberLeftPosition((Long)newValue); else
		if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) setDeliveryNumberTopPosition((Long)newValue); else
		if (DRIVERLEFTPOSITION.equals(propertyName)) setDriverLeftPosition((Long)newValue); else
		if (DRIVERTOPPOSITION.equals(propertyName)) setDriverTopPosition((Long)newValue); else
		if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) setCartonCountLeftPosition((Long)newValue); else
		if (CARTONCOUNTTOPPOSITION.equals(propertyName)) setCartonCountTopPosition((Long)newValue); else
		if (CODLEFTPOSITION.equals(propertyName)) setCodLeftPosition((Long)newValue); else
		if (CODTOPPOSITION.equals(propertyName)) setCodTopPosition((Long)newValue); else
		if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) setDescriptionLeftPosition((Long)newValue); else
		if (DESCRIPTIONTOPPOSITION.equals(propertyName)) setDescriptionTopPosition((Long)newValue); else
		if (SIGNATURELEFTPOSITION.equals(propertyName)) setSignatureLeftPosition((Long)newValue); else
		if (SIGNATURETOPPOSITION.equals(propertyName)) setSignatureTopPosition((Long)newValue); else
		if (SHOWDELIVERYDATETITLE.equals(propertyName)) setShowDeliveryDateTitle((Boolean)newValue); else
		if (SHOWREFERENCETITLE.equals(propertyName)) setShowReferenceTitle((Boolean)newValue); else
		if (SHOWSHIPVIATITLE.equals(propertyName)) setShowShipViaTitle((Boolean)newValue); else
		if (SHOWCUSTOMERPOTITLE.equals(propertyName)) setShowCustomerPOTitle((Boolean)newValue); else
		if (SHOWORDERNUMBERTITLE.equals(propertyName)) setShowOrderNumberTitle((Boolean)newValue); else
		if (SHOWPARTNUMBERTITLE.equals(propertyName)) setShowPartNumberTitle((Boolean)newValue); else
		if (SHOWTRACKINGNUMBERTITLE.equals(propertyName)) setShowTrackingNumberTitle((Boolean)newValue); else
		if (SHOWDELIVERYNUMBERTITLE.equals(propertyName)) setShowDeliveryNumberTitle((Boolean)newValue); else
		if (SHOWDRIVERTITLE.equals(propertyName)) setShowDriverTitle((Boolean)newValue); else
		if (SHOWCARTONCOUNTTITLE.equals(propertyName)) setShowCartonCountTitle((Boolean)newValue); else
		if (INVOICENUMBERMARGIN.equals(propertyName)) setInvoiceNumberMargin((Long)newValue); else
		if (ORDEREDQTYMARGIN.equals(propertyName)) setOrderedQtyMargin((Long)newValue); else
		if (SHIPPEDQTYMARGIN.equals(propertyName)) setShippedQtyMargin((Long)newValue); else
		if (DESCRIPTIONMARGIN.equals(propertyName)) setDescriptionMargin((Long)newValue); else
		if (WEIGHTMARGIN.equals(propertyName)) setWeightMargin((Long)newValue); else
		if (INVOICENUMBERWIDTH.equals(propertyName)) setInvoiceNumberWidth((Long)newValue); else
		if (ORDEREDQTYWIDTH.equals(propertyName)) setOrderedQtyWidth((Long)newValue); else
		if (SHIPPEDQTYWIDTH.equals(propertyName)) setShippedQtyWidth((Long)newValue); else
		if (DESCRIPTIONWIDTH.equals(propertyName)) setDescriptionWidth((Long)newValue); else
		if (WEIGHTWIDTH.equals(propertyName)) setWeightWidth((Long)newValue); else
		if (WIDTHOFALLITEMS.equals(propertyName)) setWidthOfAllItems((Long)newValue); else
		if (ADDRESSFONTBEAN.equals(propertyName)) setAddressFontBean((FontDefinition)newValue); else
		if (DATEFONTBEAN.equals(propertyName)) setDateFontBean((FontDefinition)newValue); else
		if (BODYTEXTFONTBEAN.equals(propertyName)) setBodyTextFontBean((FontDefinition)newValue); else
		if (FORMFONTBEAN.equals(propertyName)) setFormFontBean((FontDefinition)newValue); else
		if (FORMIMAGESOURCE.equals(propertyName)) setFormImageSource((String)newValue); else
		if (FORMIMAGEPATH.equals(propertyName)) setFormImagePath((String)newValue); else
		if (LOGOIMAGESOURCE.equals(propertyName)) setLogoImageSource((String)newValue); else
		if (LOGOIMAGEPATH.equals(propertyName)) setLogoImagePath((String)newValue); else
		if (DATAOFFSETLEFTRIGHT.equals(propertyName)) setDataOffsetLeftRight((Long)newValue); else
		if (DATAOFFSETDOWNUP.equals(propertyName)) setDataOffsetDownUp((Long)newValue); else
		if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) setImageOffsetLeftRight((Long)newValue); else
		if (IMAGEOFFSETDOWNUP.equals(propertyName)) setImageOffsetDownUp((Long)newValue); else
		if (MEASUREMENT.equals(propertyName)) setMeasurement((String)newValue); else
		super.setProperty(propertyName, newValue);
	}
	
	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?>[] getPropertyClass(String propertyName) throws UnknownPropertyException {	
		if (TITLE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (STYLEOPTION.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (SHOWFROMADDRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWTOADDRESS.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWATTN.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWSHIPVIA.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDELIVERYDATE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWCUSTOMPO.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWORDERNUMBER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWPARTNUMBER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWTRACKINGNUMBER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWREFERENCE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDESCRIPTION.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWCOMMENT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWSIGNATURE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWBARCODES.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWLOGO.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDELIVERYNUMBER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDRIVER.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWCARTONCOUNT.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (LOGOLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LOGOTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LOGOACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LOGODOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (FROMADDRESSLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (FROMADDRESSTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (FROMADDRESSACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (FROMADDRESSDOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TOADDRESSLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TOADDRESSTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TOADDRESSACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TOADDRESSDOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ATTNLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ATTNTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ATTNACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ATTNDOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LINELEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LINETOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LINEACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (LINEDOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COMMENTLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COMMENTTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COMMENTACROSSWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (COMMENTDOWNWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DELIVERYDATELEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DELIVERYDATETOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (REFERENCELEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (REFERENCETOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHIPVIALEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHIPVIATOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CUSTOMERPOTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ORDERNUMBERTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PARTNUMBERLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (PARTNUMBERTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DRIVERLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DRIVERTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CARTONCOUNTTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CODLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (CODTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DESCRIPTIONTOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SIGNATURELEFTPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SIGNATURETOPPOSITION.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHOWDELIVERYDATETITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWREFERENCETITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWSHIPVIATITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWCUSTOMERPOTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWORDERNUMBERTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWPARTNUMBERTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWTRACKINGNUMBERTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDELIVERYNUMBERTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWDRIVERTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (SHOWCARTONCOUNTTITLE.equals(propertyName)) 
			return new Class<?>[] {Boolean.class};		
		if (INVOICENUMBERMARGIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ORDEREDQTYMARGIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHIPPEDQTYMARGIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DESCRIPTIONMARGIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WEIGHTMARGIN.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (INVOICENUMBERWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ORDEREDQTYWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (SHIPPEDQTYWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DESCRIPTIONWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WEIGHTWIDTH.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (WIDTHOFALLITEMS.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (ADDRESSFONTBEAN.equals(propertyName)) 
			return new Class<?>[] {FontDefinition.class};		
		if (DATEFONTBEAN.equals(propertyName)) 
			return new Class<?>[] {FontDefinition.class};		
		if (BODYTEXTFONTBEAN.equals(propertyName)) 
			return new Class<?>[] {FontDefinition.class};		
		if (FORMFONTBEAN.equals(propertyName)) 
			return new Class<?>[] {FontDefinition.class};		
		if (FORMIMAGESOURCE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (FORMIMAGEPATH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LOGOIMAGESOURCE.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (LOGOIMAGEPATH.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		if (DATAOFFSETLEFTRIGHT.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (DATAOFFSETDOWNUP.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (IMAGEOFFSETDOWNUP.equals(propertyName)) 
			return new Class<?>[] {Long.class};		
		if (MEASUREMENT.equals(propertyName)) 
			return new Class<?>[] {String.class};		
		return super.getPropertyClass(propertyName);
	}
	

	/**
	 * @generated
	 */		
	@Transient
	@Override
	public Class<?> getPropertyOwner(String propertyName) throws UnknownPropertyException {	
		if (TITLE.equals(propertyName)) return FormPreferences.class;
		if (STYLEOPTION.equals(propertyName)) return FormPreferences.class;
		if (SHOWFROMADDRESS.equals(propertyName)) return FormPreferences.class;
		if (SHOWTOADDRESS.equals(propertyName)) return FormPreferences.class;
		if (SHOWATTN.equals(propertyName)) return FormPreferences.class;
		if (SHOWSHIPVIA.equals(propertyName)) return FormPreferences.class;
		if (SHOWDELIVERYDATE.equals(propertyName)) return FormPreferences.class;
		if (SHOWCUSTOMPO.equals(propertyName)) return FormPreferences.class;
		if (SHOWORDERNUMBER.equals(propertyName)) return FormPreferences.class;
		if (SHOWPARTNUMBER.equals(propertyName)) return FormPreferences.class;
		if (SHOWTRACKINGNUMBER.equals(propertyName)) return FormPreferences.class;
		if (SHOWREFERENCE.equals(propertyName)) return FormPreferences.class;
		if (SHOWDESCRIPTION.equals(propertyName)) return FormPreferences.class;
		if (SHOWCOMMENT.equals(propertyName)) return FormPreferences.class;
		if (SHOWSIGNATURE.equals(propertyName)) return FormPreferences.class;
		if (SHOWBARCODES.equals(propertyName)) return FormPreferences.class;
		if (SHOWLOGO.equals(propertyName)) return FormPreferences.class;
		if (SHOWDELIVERYNUMBER.equals(propertyName)) return FormPreferences.class;
		if (SHOWDRIVER.equals(propertyName)) return FormPreferences.class;
		if (SHOWCARTONCOUNT.equals(propertyName)) return FormPreferences.class;
		if (LOGOLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (LOGOTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (LOGOACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (LOGODOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (FROMADDRESSLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (FROMADDRESSTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (FROMADDRESSACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (FROMADDRESSDOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (TOADDRESSLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (TOADDRESSTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (TOADDRESSACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (TOADDRESSDOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (ATTNLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (ATTNTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (ATTNACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (ATTNDOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (LINELEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (LINETOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (LINEACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (LINEDOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (COMMENTLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (COMMENTTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (COMMENTACROSSWIDTH.equals(propertyName)) return FormPreferences.class;
		if (COMMENTDOWNWIDTH.equals(propertyName)) return FormPreferences.class;
		if (DELIVERYDATELEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DELIVERYDATETOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (REFERENCELEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (REFERENCETOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (SHIPVIALEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (SHIPVIATOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CUSTOMERPOTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (ORDERNUMBERTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (PARTNUMBERLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (PARTNUMBERTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DRIVERLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DRIVERTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CARTONCOUNTTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CODLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (CODTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (DESCRIPTIONTOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (SIGNATURELEFTPOSITION.equals(propertyName)) return FormPreferences.class;
		if (SIGNATURETOPPOSITION.equals(propertyName)) return FormPreferences.class;
		if (SHOWDELIVERYDATETITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWREFERENCETITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWSHIPVIATITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWCUSTOMERPOTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWORDERNUMBERTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWPARTNUMBERTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWTRACKINGNUMBERTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWDELIVERYNUMBERTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWDRIVERTITLE.equals(propertyName)) return FormPreferences.class;
		if (SHOWCARTONCOUNTTITLE.equals(propertyName)) return FormPreferences.class;
		if (INVOICENUMBERMARGIN.equals(propertyName)) return FormPreferences.class;
		if (ORDEREDQTYMARGIN.equals(propertyName)) return FormPreferences.class;
		if (SHIPPEDQTYMARGIN.equals(propertyName)) return FormPreferences.class;
		if (DESCRIPTIONMARGIN.equals(propertyName)) return FormPreferences.class;
		if (WEIGHTMARGIN.equals(propertyName)) return FormPreferences.class;
		if (INVOICENUMBERWIDTH.equals(propertyName)) return FormPreferences.class;
		if (ORDEREDQTYWIDTH.equals(propertyName)) return FormPreferences.class;
		if (SHIPPEDQTYWIDTH.equals(propertyName)) return FormPreferences.class;
		if (DESCRIPTIONWIDTH.equals(propertyName)) return FormPreferences.class;
		if (WEIGHTWIDTH.equals(propertyName)) return FormPreferences.class;
		if (WIDTHOFALLITEMS.equals(propertyName)) return FormPreferences.class;
		if (ADDRESSFONTBEAN.equals(propertyName)) return FormPreferences.class;
		if (DATEFONTBEAN.equals(propertyName)) return FormPreferences.class;
		if (BODYTEXTFONTBEAN.equals(propertyName)) return FormPreferences.class;
		if (FORMFONTBEAN.equals(propertyName)) return FormPreferences.class;
		if (FORMIMAGESOURCE.equals(propertyName)) return FormPreferences.class;
		if (FORMIMAGEPATH.equals(propertyName)) return FormPreferences.class;
		if (LOGOIMAGESOURCE.equals(propertyName)) return FormPreferences.class;
		if (LOGOIMAGEPATH.equals(propertyName)) return FormPreferences.class;
		if (DATAOFFSETLEFTRIGHT.equals(propertyName)) return FormPreferences.class;
		if (DATAOFFSETDOWNUP.equals(propertyName)) return FormPreferences.class;
		if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) return FormPreferences.class;
		if (IMAGEOFFSETDOWNUP.equals(propertyName)) return FormPreferences.class;
		if (MEASUREMENT.equals(propertyName)) return FormPreferences.class;
		return super.getPropertyOwner(propertyName);
	}
	
	/**
	 * @generated
	 */			
	@Override
	public boolean deepEquals(Object obj) {
		if (! super.deepEquals(obj))
			return false;
		FormPreferences objT = (FormPreferences)obj;
		if (! SmartEquals(getTitle(), objT.getTitle()))
			return false;
		if (! SmartEquals(getStyleOption(), objT.getStyleOption()))
			return false;
		if (! SmartEquals(getShowFromAddress(), objT.getShowFromAddress()))
			return false;
		if (! SmartEquals(getShowToAddress(), objT.getShowToAddress()))
			return false;
		if (! SmartEquals(getShowAttn(), objT.getShowAttn()))
			return false;
		if (! SmartEquals(getShowShipVia(), objT.getShowShipVia()))
			return false;
		if (! SmartEquals(getShowDeliveryDate(), objT.getShowDeliveryDate()))
			return false;
		if (! SmartEquals(getShowCustomPO(), objT.getShowCustomPO()))
			return false;
		if (! SmartEquals(getShowOrderNumber(), objT.getShowOrderNumber()))
			return false;
		if (! SmartEquals(getShowPartNumber(), objT.getShowPartNumber()))
			return false;
		if (! SmartEquals(getShowTrackingNumber(), objT.getShowTrackingNumber()))
			return false;
		if (! SmartEquals(getShowReference(), objT.getShowReference()))
			return false;
		if (! SmartEquals(getShowDescription(), objT.getShowDescription()))
			return false;
		if (! SmartEquals(getShowComment(), objT.getShowComment()))
			return false;
		if (! SmartEquals(getShowSignature(), objT.getShowSignature()))
			return false;
		if (! SmartEquals(getShowBarCodes(), objT.getShowBarCodes()))
			return false;
		if (! SmartEquals(getShowLogo(), objT.getShowLogo()))
			return false;
		if (! SmartEquals(getShowDeliveryNumber(), objT.getShowDeliveryNumber()))
			return false;
		if (! SmartEquals(getShowDriver(), objT.getShowDriver()))
			return false;
		if (! SmartEquals(getShowCartonCount(), objT.getShowCartonCount()))
			return false;
		if (! SmartEquals(getLogoLeftPosition(), objT.getLogoLeftPosition()))
			return false;
		if (! SmartEquals(getLogoTopPosition(), objT.getLogoTopPosition()))
			return false;
		if (! SmartEquals(getLogoAcrossWidth(), objT.getLogoAcrossWidth()))
			return false;
		if (! SmartEquals(getLogoDownWidth(), objT.getLogoDownWidth()))
			return false;
		if (! SmartEquals(getFromAddressLeftPosition(), objT.getFromAddressLeftPosition()))
			return false;
		if (! SmartEquals(getFromAddressTopPosition(), objT.getFromAddressTopPosition()))
			return false;
		if (! SmartEquals(getFromAddressAcrossWidth(), objT.getFromAddressAcrossWidth()))
			return false;
		if (! SmartEquals(getFromAddressDownWidth(), objT.getFromAddressDownWidth()))
			return false;
		if (! SmartEquals(getToAddressLeftPosition(), objT.getToAddressLeftPosition()))
			return false;
		if (! SmartEquals(getToAddressTopPosition(), objT.getToAddressTopPosition()))
			return false;
		if (! SmartEquals(getToAddressAcrossWidth(), objT.getToAddressAcrossWidth()))
			return false;
		if (! SmartEquals(getToAddressDownWidth(), objT.getToAddressDownWidth()))
			return false;
		if (! SmartEquals(getAttnLeftPosition(), objT.getAttnLeftPosition()))
			return false;
		if (! SmartEquals(getAttnTopPosition(), objT.getAttnTopPosition()))
			return false;
		if (! SmartEquals(getAttnAcrossWidth(), objT.getAttnAcrossWidth()))
			return false;
		if (! SmartEquals(getAttnDownWidth(), objT.getAttnDownWidth()))
			return false;
		if (! SmartEquals(getLineLeftPosition(), objT.getLineLeftPosition()))
			return false;
		if (! SmartEquals(getLineTopPosition(), objT.getLineTopPosition()))
			return false;
		if (! SmartEquals(getLineAcrossWidth(), objT.getLineAcrossWidth()))
			return false;
		if (! SmartEquals(getLineDownWidth(), objT.getLineDownWidth()))
			return false;
		if (! SmartEquals(getCommentLeftPosition(), objT.getCommentLeftPosition()))
			return false;
		if (! SmartEquals(getCommentTopPosition(), objT.getCommentTopPosition()))
			return false;
		if (! SmartEquals(getCommentAcrossWidth(), objT.getCommentAcrossWidth()))
			return false;
		if (! SmartEquals(getCommentDownWidth(), objT.getCommentDownWidth()))
			return false;
		if (! SmartEquals(getDeliveryDateLeftPosition(), objT.getDeliveryDateLeftPosition()))
			return false;
		if (! SmartEquals(getDeliveryDateTopPosition(), objT.getDeliveryDateTopPosition()))
			return false;
		if (! SmartEquals(getReferenceLeftPosition(), objT.getReferenceLeftPosition()))
			return false;
		if (! SmartEquals(getReferenceTopPosition(), objT.getReferenceTopPosition()))
			return false;
		if (! SmartEquals(getShipViaLeftPosition(), objT.getShipViaLeftPosition()))
			return false;
		if (! SmartEquals(getShipViaTopPosition(), objT.getShipViaTopPosition()))
			return false;
		if (! SmartEquals(getCustomerPOLeftPosition(), objT.getCustomerPOLeftPosition()))
			return false;
		if (! SmartEquals(getCustomerPOTopPosition(), objT.getCustomerPOTopPosition()))
			return false;
		if (! SmartEquals(getOrderNumberLeftPosition(), objT.getOrderNumberLeftPosition()))
			return false;
		if (! SmartEquals(getOrderNumberTopPosition(), objT.getOrderNumberTopPosition()))
			return false;
		if (! SmartEquals(getPartNumberLeftPosition(), objT.getPartNumberLeftPosition()))
			return false;
		if (! SmartEquals(getPartNumberTopPosition(), objT.getPartNumberTopPosition()))
			return false;
		if (! SmartEquals(getTrackingNumberLeftPosition(), objT.getTrackingNumberLeftPosition()))
			return false;
		if (! SmartEquals(getTrackingNumberTopPosition(), objT.getTrackingNumberTopPosition()))
			return false;
		if (! SmartEquals(getDeliveryNumberLeftPosition(), objT.getDeliveryNumberLeftPosition()))
			return false;
		if (! SmartEquals(getDeliveryNumberTopPosition(), objT.getDeliveryNumberTopPosition()))
			return false;
		if (! SmartEquals(getDriverLeftPosition(), objT.getDriverLeftPosition()))
			return false;
		if (! SmartEquals(getDriverTopPosition(), objT.getDriverTopPosition()))
			return false;
		if (! SmartEquals(getCartonCountLeftPosition(), objT.getCartonCountLeftPosition()))
			return false;
		if (! SmartEquals(getCartonCountTopPosition(), objT.getCartonCountTopPosition()))
			return false;
		if (! SmartEquals(getCodLeftPosition(), objT.getCodLeftPosition()))
			return false;
		if (! SmartEquals(getCodTopPosition(), objT.getCodTopPosition()))
			return false;
		if (! SmartEquals(getDescriptionLeftPosition(), objT.getDescriptionLeftPosition()))
			return false;
		if (! SmartEquals(getDescriptionTopPosition(), objT.getDescriptionTopPosition()))
			return false;
		if (! SmartEquals(getSignatureLeftPosition(), objT.getSignatureLeftPosition()))
			return false;
		if (! SmartEquals(getSignatureTopPosition(), objT.getSignatureTopPosition()))
			return false;
		if (! SmartEquals(getShowDeliveryDateTitle(), objT.getShowDeliveryDateTitle()))
			return false;
		if (! SmartEquals(getShowReferenceTitle(), objT.getShowReferenceTitle()))
			return false;
		if (! SmartEquals(getShowShipViaTitle(), objT.getShowShipViaTitle()))
			return false;
		if (! SmartEquals(getShowCustomerPOTitle(), objT.getShowCustomerPOTitle()))
			return false;
		if (! SmartEquals(getShowOrderNumberTitle(), objT.getShowOrderNumberTitle()))
			return false;
		if (! SmartEquals(getShowPartNumberTitle(), objT.getShowPartNumberTitle()))
			return false;
		if (! SmartEquals(getShowTrackingNumberTitle(), objT.getShowTrackingNumberTitle()))
			return false;
		if (! SmartEquals(getShowDeliveryNumberTitle(), objT.getShowDeliveryNumberTitle()))
			return false;
		if (! SmartEquals(getShowDriverTitle(), objT.getShowDriverTitle()))
			return false;
		if (! SmartEquals(getShowCartonCountTitle(), objT.getShowCartonCountTitle()))
			return false;
		if (! SmartEquals(getInvoiceNumberMargin(), objT.getInvoiceNumberMargin()))
			return false;
		if (! SmartEquals(getOrderedQtyMargin(), objT.getOrderedQtyMargin()))
			return false;
		if (! SmartEquals(getShippedQtyMargin(), objT.getShippedQtyMargin()))
			return false;
		if (! SmartEquals(getDescriptionMargin(), objT.getDescriptionMargin()))
			return false;
		if (! SmartEquals(getWeightMargin(), objT.getWeightMargin()))
			return false;
		if (! SmartEquals(getInvoiceNumberWidth(), objT.getInvoiceNumberWidth()))
			return false;
		if (! SmartEquals(getOrderedQtyWidth(), objT.getOrderedQtyWidth()))
			return false;
		if (! SmartEquals(getShippedQtyWidth(), objT.getShippedQtyWidth()))
			return false;
		if (! SmartEquals(getDescriptionWidth(), objT.getDescriptionWidth()))
			return false;
		if (! SmartEquals(getWeightWidth(), objT.getWeightWidth()))
			return false;
		if (! SmartEquals(getWidthOfAllItems(), objT.getWidthOfAllItems()))
			return false;
		if (! SmartEquals(getAddressFontBean(), objT.getAddressFontBean()))
			return false;
		if (! SmartEquals(getDateFontBean(), objT.getDateFontBean()))
			return false;
		if (! SmartEquals(getBodyTextFontBean(), objT.getBodyTextFontBean()))
			return false;
		if (! SmartEquals(getFormFontBean(), objT.getFormFontBean()))
			return false;
		if (! SmartEquals(getFormImageSource(), objT.getFormImageSource()))
			return false;
		if (! SmartEquals(getFormImagePath(), objT.getFormImagePath()))
			return false;
		if (! SmartEquals(getLogoImageSource(), objT.getLogoImageSource()))
			return false;
		if (! SmartEquals(getLogoImagePath(), objT.getLogoImagePath()))
			return false;
		if (! SmartEquals(getDataOffsetLeftRight(), objT.getDataOffsetLeftRight()))
			return false;
		if (! SmartEquals(getDataOffsetDownUp(), objT.getDataOffsetDownUp()))
			return false;
		if (! SmartEquals(getImageOffsetLeftRight(), objT.getImageOffsetLeftRight()))
			return false;
		if (! SmartEquals(getImageOffsetDownUp(), objT.getImageOffsetDownUp()))
			return false;
		if (! SmartEquals(getMeasurement(), objT.getMeasurement()))
			return false;
		return true;
	}			
}