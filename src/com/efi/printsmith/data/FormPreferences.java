
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
	public static final String DEFAULTFLAG = "DefaultFlag";

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
	private Double logoLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getLogoLeftPosition(){
    return logoLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setLogoLeftPosition(Double newVal) {
    this.logoLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double logoTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getLogoTopPosition(){
    return logoTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setLogoTopPosition(Double newVal) {
    this.logoTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double logoAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getLogoAcrossWidth(){
    return logoAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setLogoAcrossWidth(Double newVal) {
    this.logoAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double logoDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getLogoDownWidth(){
    return logoDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setLogoDownWidth(Double newVal) {
    this.logoDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double fromAddressLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getFromAddressLeftPosition(){
    return fromAddressLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setFromAddressLeftPosition(Double newVal) {
    this.fromAddressLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double fromAddressTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getFromAddressTopPosition(){
    return fromAddressTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setFromAddressTopPosition(Double newVal) {
    this.fromAddressTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double fromAddressAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getFromAddressAcrossWidth(){
    return fromAddressAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setFromAddressAcrossWidth(Double newVal) {
    this.fromAddressAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double fromAddressDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getFromAddressDownWidth(){
    return fromAddressDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setFromAddressDownWidth(Double newVal) {
    this.fromAddressDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double toAddressLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getToAddressLeftPosition(){
    return toAddressLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setToAddressLeftPosition(Double newVal) {
    this.toAddressLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double toAddressTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getToAddressTopPosition(){
    return toAddressTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setToAddressTopPosition(Double newVal) {
    this.toAddressTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double toAddressAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getToAddressAcrossWidth(){
    return toAddressAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setToAddressAcrossWidth(Double newVal) {
    this.toAddressAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double toAddressDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getToAddressDownWidth(){
    return toAddressDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setToAddressDownWidth(Double newVal) {
    this.toAddressDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double attnLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getAttnLeftPosition(){
    return attnLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setAttnLeftPosition(Double newVal) {
    this.attnLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double attnTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getAttnTopPosition(){
    return attnTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setAttnTopPosition(Double newVal) {
    this.attnTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double attnAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getAttnAcrossWidth(){
    return attnAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setAttnAcrossWidth(Double newVal) {
    this.attnAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double attnDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getAttnDownWidth(){
    return attnDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setAttnDownWidth(Double newVal) {
    this.attnDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double lineLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getLineLeftPosition(){
    return lineLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setLineLeftPosition(Double newVal) {
    this.lineLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double lineTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getLineTopPosition(){
    return lineTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setLineTopPosition(Double newVal) {
    this.lineTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double lineAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getLineAcrossWidth(){
    return lineAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setLineAcrossWidth(Double newVal) {
    this.lineAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double lineDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getLineDownWidth(){
    return lineDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setLineDownWidth(Double newVal) {
    this.lineDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double commentLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getCommentLeftPosition(){
    return commentLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCommentLeftPosition(Double newVal) {
    this.commentLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double commentTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getCommentTopPosition(){
    return commentTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCommentTopPosition(Double newVal) {
    this.commentTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double commentAcrossWidth;
	
	/**
	 * @generated
 	 */
	public Double getCommentAcrossWidth(){
    return commentAcrossWidth; 
  }

	
	/**
   * @generated
   */	
  public void setCommentAcrossWidth(Double newVal) {
    this.commentAcrossWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double commentDownWidth;
	
	/**
	 * @generated
 	 */
	public Double getCommentDownWidth(){
    return commentDownWidth; 
  }

	
	/**
   * @generated
   */	
  public void setCommentDownWidth(Double newVal) {
    this.commentDownWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double deliveryDateLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getDeliveryDateLeftPosition(){
    return deliveryDateLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDeliveryDateLeftPosition(Double newVal) {
    this.deliveryDateLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double deliveryDateTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getDeliveryDateTopPosition(){
    return deliveryDateTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDeliveryDateTopPosition(Double newVal) {
    this.deliveryDateTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double referenceLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getReferenceLeftPosition(){
    return referenceLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setReferenceLeftPosition(Double newVal) {
    this.referenceLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double referenceTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getReferenceTopPosition(){
    return referenceTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setReferenceTopPosition(Double newVal) {
    this.referenceTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double shipViaLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getShipViaLeftPosition(){
    return shipViaLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setShipViaLeftPosition(Double newVal) {
    this.shipViaLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double shipViaTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getShipViaTopPosition(){
    return shipViaTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setShipViaTopPosition(Double newVal) {
    this.shipViaTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double customerPOLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getCustomerPOLeftPosition(){
    return customerPOLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCustomerPOLeftPosition(Double newVal) {
    this.customerPOLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double customerPOTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getCustomerPOTopPosition(){
    return customerPOTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCustomerPOTopPosition(Double newVal) {
    this.customerPOTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double orderNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getOrderNumberLeftPosition(){
    return orderNumberLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setOrderNumberLeftPosition(Double newVal) {
    this.orderNumberLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double orderNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getOrderNumberTopPosition(){
    return orderNumberTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setOrderNumberTopPosition(Double newVal) {
    this.orderNumberTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double partNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getPartNumberLeftPosition(){
    return partNumberLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setPartNumberLeftPosition(Double newVal) {
    this.partNumberLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double partNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getPartNumberTopPosition(){
    return partNumberTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setPartNumberTopPosition(Double newVal) {
    this.partNumberTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double trackingNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getTrackingNumberLeftPosition(){
    return trackingNumberLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setTrackingNumberLeftPosition(Double newVal) {
    this.trackingNumberLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double trackingNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getTrackingNumberTopPosition(){
    return trackingNumberTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setTrackingNumberTopPosition(Double newVal) {
    this.trackingNumberTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double deliveryNumberLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getDeliveryNumberLeftPosition(){
    return deliveryNumberLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDeliveryNumberLeftPosition(Double newVal) {
    this.deliveryNumberLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double deliveryNumberTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getDeliveryNumberTopPosition(){
    return deliveryNumberTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDeliveryNumberTopPosition(Double newVal) {
    this.deliveryNumberTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double driverLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getDriverLeftPosition(){
    return driverLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDriverLeftPosition(Double newVal) {
    this.driverLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double driverTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getDriverTopPosition(){
    return driverTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDriverTopPosition(Double newVal) {
    this.driverTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double cartonCountLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getCartonCountLeftPosition(){
    return cartonCountLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCartonCountLeftPosition(Double newVal) {
    this.cartonCountLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double cartonCountTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getCartonCountTopPosition(){
    return cartonCountTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCartonCountTopPosition(Double newVal) {
    this.cartonCountTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double codLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getCodLeftPosition(){
    return codLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCodLeftPosition(Double newVal) {
    this.codLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double codTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getCodTopPosition(){
    return codTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setCodTopPosition(Double newVal) {
    this.codTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double descriptionLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getDescriptionLeftPosition(){
    return descriptionLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDescriptionLeftPosition(Double newVal) {
    this.descriptionLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double descriptionTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getDescriptionTopPosition(){
    return descriptionTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setDescriptionTopPosition(Double newVal) {
    this.descriptionTopPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double signatureLeftPosition;
	
	/**
	 * @generated
 	 */
	public Double getSignatureLeftPosition(){
    return signatureLeftPosition; 
  }

	
	/**
   * @generated
   */	
  public void setSignatureLeftPosition(Double newVal) {
    this.signatureLeftPosition = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double signatureTopPosition;
	
	/**
	 * @generated
 	 */
	public Double getSignatureTopPosition(){
    return signatureTopPosition; 
  }

	
	/**
   * @generated
   */	
  public void setSignatureTopPosition(Double newVal) {
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
	private Double invoiceNumberMargin;
	
	/**
	 * @generated
 	 */
	public Double getInvoiceNumberMargin(){
    return invoiceNumberMargin; 
  }

	
	/**
   * @generated
   */	
  public void setInvoiceNumberMargin(Double newVal) {
    this.invoiceNumberMargin = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double orderedQtyMargin;
	
	/**
	 * @generated
 	 */
	public Double getOrderedQtyMargin(){
    return orderedQtyMargin; 
  }

	
	/**
   * @generated
   */	
  public void setOrderedQtyMargin(Double newVal) {
    this.orderedQtyMargin = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double shippedQtyMargin;
	
	/**
	 * @generated
 	 */
	public Double getShippedQtyMargin(){
    return shippedQtyMargin; 
  }

	
	/**
   * @generated
   */	
  public void setShippedQtyMargin(Double newVal) {
    this.shippedQtyMargin = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double descriptionMargin;
	
	/**
	 * @generated
 	 */
	public Double getDescriptionMargin(){
    return descriptionMargin; 
  }

	
	/**
   * @generated
   */	
  public void setDescriptionMargin(Double newVal) {
    this.descriptionMargin = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double weightMargin;
	
	/**
	 * @generated
 	 */
	public Double getWeightMargin(){
    return weightMargin; 
  }

	
	/**
   * @generated
   */	
  public void setWeightMargin(Double newVal) {
    this.weightMargin = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double invoiceNumberWidth;
	
	/**
	 * @generated
 	 */
	public Double getInvoiceNumberWidth(){
    return invoiceNumberWidth; 
  }

	
	/**
   * @generated
   */	
  public void setInvoiceNumberWidth(Double newVal) {
    this.invoiceNumberWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double orderedQtyWidth;
	
	/**
	 * @generated
 	 */
	public Double getOrderedQtyWidth(){
    return orderedQtyWidth; 
  }

	
	/**
   * @generated
   */	
  public void setOrderedQtyWidth(Double newVal) {
    this.orderedQtyWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double shippedQtyWidth;
	
	/**
	 * @generated
 	 */
	public Double getShippedQtyWidth(){
    return shippedQtyWidth; 
  }

	
	/**
   * @generated
   */	
  public void setShippedQtyWidth(Double newVal) {
    this.shippedQtyWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double descriptionWidth;
	
	/**
	 * @generated
 	 */
	public Double getDescriptionWidth(){
    return descriptionWidth; 
  }

	
	/**
   * @generated
   */	
  public void setDescriptionWidth(Double newVal) {
    this.descriptionWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double weightWidth;
	
	/**
	 * @generated
 	 */
	public Double getWeightWidth(){
    return weightWidth; 
  }

	
	/**
   * @generated
   */	
  public void setWeightWidth(Double newVal) {
    this.weightWidth = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double widthOfAllItems;
	
	/**
	 * @generated
 	 */
	public Double getWidthOfAllItems(){
    return widthOfAllItems; 
  }

	
	/**
   * @generated
   */	
  public void setWidthOfAllItems(Double newVal) {
    this.widthOfAllItems = newVal;
  }

	/**
	 * @generated
	 */	
    @ManyToOne( cascade = {CascadeType.ALL})
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
	@ManyToOne( cascade = {CascadeType.ALL})
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
	@ManyToOne( cascade = {CascadeType.ALL})
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
	@ManyToOne( cascade = {CascadeType.ALL})
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
	private Double dataOffsetLeftRight;
	
	/**
	 * @generated
 	 */
	public Double getDataOffsetLeftRight(){
    return dataOffsetLeftRight; 
  }

	
	/**
   * @generated
   */	
  public void setDataOffsetLeftRight(Double newVal) {
    this.dataOffsetLeftRight = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double dataOffsetDownUp;
	
	/**
	 * @generated
 	 */
	public Double getDataOffsetDownUp(){
    return dataOffsetDownUp; 
  }

	
	/**
   * @generated
   */	
  public void setDataOffsetDownUp(Double newVal) {
    this.dataOffsetDownUp = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double imageOffsetLeftRight;
	
	/**
	 * @generated
 	 */
	public Double getImageOffsetLeftRight(){
    return imageOffsetLeftRight; 
  }

	
	/**
   * @generated
   */	
  public void setImageOffsetLeftRight(Double newVal) {
    this.imageOffsetLeftRight = newVal;
  }

	/**
	 * @generated
	 */	
 	@Basic
	private Double imageOffsetDownUp;
	
	/**
	 * @generated
 	 */
	public Double getImageOffsetDownUp(){
    return imageOffsetDownUp; 
  }

	
	/**
   * @generated
   */	
  public void setImageOffsetDownUp(Double newVal) {
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
 	@Basic
	private Boolean defaultFlag;
	
	/**
	 * @generated
 	 */
	public Boolean getDefaultFlag(){
    return defaultFlag; 
  }

	
	/**
	 * @generated
	 */	
	public void setDefaultFlag(Boolean newVal) {
    this.defaultFlag = newVal;
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
    if (DEFAULTFLAG.equals(propertyName)) return getDefaultFlag();
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
    if (LOGOLEFTPOSITION.equals(propertyName)) setLogoLeftPosition((Double)newValue); else
    if (LOGOTOPPOSITION.equals(propertyName)) setLogoTopPosition((Double)newValue); else
    if (LOGOACROSSWIDTH.equals(propertyName)) setLogoAcrossWidth((Double)newValue); else
    if (LOGODOWNWIDTH.equals(propertyName)) setLogoDownWidth((Double)newValue); else
    if (FROMADDRESSLEFTPOSITION.equals(propertyName)) setFromAddressLeftPosition((Double)newValue); else
    if (FROMADDRESSTOPPOSITION.equals(propertyName)) setFromAddressTopPosition((Double)newValue); else
    if (FROMADDRESSACROSSWIDTH.equals(propertyName)) setFromAddressAcrossWidth((Double)newValue); else
    if (FROMADDRESSDOWNWIDTH.equals(propertyName)) setFromAddressDownWidth((Double)newValue); else
    if (TOADDRESSLEFTPOSITION.equals(propertyName)) setToAddressLeftPosition((Double)newValue); else
    if (TOADDRESSTOPPOSITION.equals(propertyName)) setToAddressTopPosition((Double)newValue); else
    if (TOADDRESSACROSSWIDTH.equals(propertyName)) setToAddressAcrossWidth((Double)newValue); else
    if (TOADDRESSDOWNWIDTH.equals(propertyName)) setToAddressDownWidth((Double)newValue); else
    if (ATTNLEFTPOSITION.equals(propertyName)) setAttnLeftPosition((Double)newValue); else
    if (ATTNTOPPOSITION.equals(propertyName)) setAttnTopPosition((Double)newValue); else
    if (ATTNACROSSWIDTH.equals(propertyName)) setAttnAcrossWidth((Double)newValue); else
    if (ATTNDOWNWIDTH.equals(propertyName)) setAttnDownWidth((Double)newValue); else
    if (LINELEFTPOSITION.equals(propertyName)) setLineLeftPosition((Double)newValue); else
    if (LINETOPPOSITION.equals(propertyName)) setLineTopPosition((Double)newValue); else
    if (LINEACROSSWIDTH.equals(propertyName)) setLineAcrossWidth((Double)newValue); else
    if (LINEDOWNWIDTH.equals(propertyName)) setLineDownWidth((Double)newValue); else
    if (COMMENTLEFTPOSITION.equals(propertyName)) setCommentLeftPosition((Double)newValue); else
    if (COMMENTTOPPOSITION.equals(propertyName)) setCommentTopPosition((Double)newValue); else
    if (COMMENTACROSSWIDTH.equals(propertyName)) setCommentAcrossWidth((Double)newValue); else
    if (COMMENTDOWNWIDTH.equals(propertyName)) setCommentDownWidth((Double)newValue); else
    if (DELIVERYDATELEFTPOSITION.equals(propertyName)) setDeliveryDateLeftPosition((Double)newValue); else
    if (DELIVERYDATETOPPOSITION.equals(propertyName)) setDeliveryDateTopPosition((Double)newValue); else
    if (REFERENCELEFTPOSITION.equals(propertyName)) setReferenceLeftPosition((Double)newValue); else
    if (REFERENCETOPPOSITION.equals(propertyName)) setReferenceTopPosition((Double)newValue); else
    if (SHIPVIALEFTPOSITION.equals(propertyName)) setShipViaLeftPosition((Double)newValue); else
    if (SHIPVIATOPPOSITION.equals(propertyName)) setShipViaTopPosition((Double)newValue); else
    if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) setCustomerPOLeftPosition((Double)newValue); else
    if (CUSTOMERPOTOPPOSITION.equals(propertyName)) setCustomerPOTopPosition((Double)newValue); else
    if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) setOrderNumberLeftPosition((Double)newValue); else
    if (ORDERNUMBERTOPPOSITION.equals(propertyName)) setOrderNumberTopPosition((Double)newValue); else
    if (PARTNUMBERLEFTPOSITION.equals(propertyName)) setPartNumberLeftPosition((Double)newValue); else
    if (PARTNUMBERTOPPOSITION.equals(propertyName)) setPartNumberTopPosition((Double)newValue); else
    if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) setTrackingNumberLeftPosition((Double)newValue); else
    if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) setTrackingNumberTopPosition((Double)newValue); else
    if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) setDeliveryNumberLeftPosition((Double)newValue); else
    if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) setDeliveryNumberTopPosition((Double)newValue); else
    if (DRIVERLEFTPOSITION.equals(propertyName)) setDriverLeftPosition((Double)newValue); else
    if (DRIVERTOPPOSITION.equals(propertyName)) setDriverTopPosition((Double)newValue); else
    if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) setCartonCountLeftPosition((Double)newValue); else
    if (CARTONCOUNTTOPPOSITION.equals(propertyName)) setCartonCountTopPosition((Double)newValue); else
    if (CODLEFTPOSITION.equals(propertyName)) setCodLeftPosition((Double)newValue); else
    if (CODTOPPOSITION.equals(propertyName)) setCodTopPosition((Double)newValue); else
    if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) setDescriptionLeftPosition((Double)newValue); else
    if (DESCRIPTIONTOPPOSITION.equals(propertyName)) setDescriptionTopPosition((Double)newValue); else
    if (SIGNATURELEFTPOSITION.equals(propertyName)) setSignatureLeftPosition((Double)newValue); else
    if (SIGNATURETOPPOSITION.equals(propertyName)) setSignatureTopPosition((Double)newValue); else
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
    if (INVOICENUMBERMARGIN.equals(propertyName)) setInvoiceNumberMargin((Double)newValue); else
    if (ORDEREDQTYMARGIN.equals(propertyName)) setOrderedQtyMargin((Double)newValue); else
    if (SHIPPEDQTYMARGIN.equals(propertyName)) setShippedQtyMargin((Double)newValue); else
    if (DESCRIPTIONMARGIN.equals(propertyName)) setDescriptionMargin((Double)newValue); else
    if (WEIGHTMARGIN.equals(propertyName)) setWeightMargin((Double)newValue); else
    if (INVOICENUMBERWIDTH.equals(propertyName)) setInvoiceNumberWidth((Double)newValue); else
    if (ORDEREDQTYWIDTH.equals(propertyName)) setOrderedQtyWidth((Double)newValue); else
    if (SHIPPEDQTYWIDTH.equals(propertyName)) setShippedQtyWidth((Double)newValue); else
    if (DESCRIPTIONWIDTH.equals(propertyName)) setDescriptionWidth((Double)newValue); else
    if (WEIGHTWIDTH.equals(propertyName)) setWeightWidth((Double)newValue); else
    if (WIDTHOFALLITEMS.equals(propertyName)) setWidthOfAllItems((Double)newValue); else
    if (ADDRESSFONTBEAN.equals(propertyName)) setAddressFontBean((FontDefinition)newValue); else
    if (DATEFONTBEAN.equals(propertyName)) setDateFontBean((FontDefinition)newValue); else
    if (BODYTEXTFONTBEAN.equals(propertyName)) setBodyTextFontBean((FontDefinition)newValue); else
    if (FORMFONTBEAN.equals(propertyName)) setFormFontBean((FontDefinition)newValue); else
    if (FORMIMAGESOURCE.equals(propertyName)) setFormImageSource((String)newValue); else
    if (FORMIMAGEPATH.equals(propertyName)) setFormImagePath((String)newValue); else
    if (LOGOIMAGESOURCE.equals(propertyName)) setLogoImageSource((String)newValue); else
    if (LOGOIMAGEPATH.equals(propertyName)) setLogoImagePath((String)newValue); else
    if (DATAOFFSETLEFTRIGHT.equals(propertyName)) setDataOffsetLeftRight((Double)newValue); else
    if (DATAOFFSETDOWNUP.equals(propertyName)) setDataOffsetDownUp((Double)newValue); else
    if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) setImageOffsetLeftRight((Double)newValue); else
    if (IMAGEOFFSETDOWNUP.equals(propertyName)) setImageOffsetDownUp((Double)newValue); else
    if (MEASUREMENT.equals(propertyName)) setMeasurement((String)newValue); else
    if (DEFAULTFLAG.equals(propertyName)) setDefaultFlag((Boolean)newValue); else
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
      return new Class<?>[] {Double.class};		
    if (LOGOTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LOGOACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LOGODOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FROMADDRESSLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FROMADDRESSTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FROMADDRESSACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (FROMADDRESSDOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOADDRESSLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOADDRESSTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOADDRESSACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TOADDRESSDOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ATTNLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ATTNTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ATTNACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ATTNDOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LINELEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LINETOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LINEACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (LINEDOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COMMENTLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COMMENTTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COMMENTACROSSWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (COMMENTDOWNWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DELIVERYDATELEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DELIVERYDATETOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (REFERENCELEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (REFERENCETOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHIPVIALEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHIPVIATOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CUSTOMERPOLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CUSTOMERPOTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ORDERNUMBERLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ORDERNUMBERTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PARTNUMBERLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (PARTNUMBERTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TRACKINGNUMBERLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (TRACKINGNUMBERTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DELIVERYNUMBERLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DELIVERYNUMBERTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DRIVERLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DRIVERTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CARTONCOUNTLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CARTONCOUNTTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CODLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (CODTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DESCRIPTIONLEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DESCRIPTIONTOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SIGNATURELEFTPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SIGNATURETOPPOSITION.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
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
      return new Class<?>[] {Double.class};		
    if (ORDEREDQTYMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHIPPEDQTYMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DESCRIPTIONMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WEIGHTMARGIN.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (INVOICENUMBERWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (ORDEREDQTYWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (SHIPPEDQTYWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (DESCRIPTIONWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WEIGHTWIDTH.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (WIDTHOFALLITEMS.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
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
      return new Class<?>[] {Double.class};		
    if (DATAOFFSETDOWNUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (IMAGEOFFSETLEFTRIGHT.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (IMAGEOFFSETDOWNUP.equals(propertyName)) 
      return new Class<?>[] {Double.class};		
    if (MEASUREMENT.equals(propertyName)) 
      return new Class<?>[] {String.class};		
    if (DEFAULTFLAG.equals(propertyName)) 
      return new Class<?>[] {Boolean.class};		
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
    if (DEFAULTFLAG.equals(propertyName)) return FormPreferences.class;
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
    if (! SmartEquals(getDefaultFlag(), objT.getDefaultFlag()))
      return false;
    return true;
  }			
}
