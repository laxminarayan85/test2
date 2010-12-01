package com.efi.printsmith.service;

import com.efi.printsmith.data.FontDefinition;
import com.efi.printsmith.data.FormPreferences;

public class FormPreferencesService extends SnowmassHibernateService {
	
	public FormPreferences createNewFormPreferences(FormPreferences formPreferences) throws Exception {
		DataService dataService = new DataService();
		formPreferences.setStyleOption("GenerateFormImage");
		formPreferences.setShowFromAddress(true);
		formPreferences.setShowToAddress(true);
		formPreferences.setShowAttn(true);
		formPreferences.setShowShipVia(true);
		formPreferences.setShowDeliveryDate(true);
		formPreferences.setShowDescription(true);
		formPreferences.setShowComment(true);
		formPreferences.setShowDeliveryNumber(true);
		formPreferences.setLogoAcrossWidth(216L);
		formPreferences.setLogoDownWidth(72L);
		formPreferences.setFromAddressTopPosition(90L);
		formPreferences.setFromAddressAcrossWidth(180L);
		formPreferences.setFromAddressDownWidth(90L);
		formPreferences.setToAddressLeftPosition(190L);
		formPreferences.setToAddressTopPosition(90L);
		formPreferences.setToAddressAcrossWidth(180L);
		formPreferences.setToAddressDownWidth(90L);
		formPreferences.setAttnLeftPosition(375L);
		formPreferences.setAttnTopPosition(90L);
		formPreferences.setAttnAcrossWidth(180L);
		formPreferences.setAttnDownWidth(90L);
		formPreferences.setLineTopPosition(236L);
		formPreferences.setLineAcrossWidth(522L);
		formPreferences.setLineDownWidth(216L);
		formPreferences.setCommentTopPosition(475L);
		formPreferences.setCommentAcrossWidth(540L);
		formPreferences.setCommentDownWidth(100L);
		formPreferences.setDeliveryDateLeftPosition(480L);
		formPreferences.setDeliveryDateTopPosition(25L);
		formPreferences.setReferenceLeftPosition(480L);
		formPreferences.setReferenceTopPosition(45L);
		formPreferences.setShipViaLeftPosition(480L);
		formPreferences.setShipViaTopPosition(35L);
		formPreferences.setCustomerPOLeftPosition(275L);
		formPreferences.setCustomerPOTopPosition(35L);
		formPreferences.setOrderNumberLeftPosition(275L);
		formPreferences.setOrderNumberTopPosition(25L);
		formPreferences.setPartNumberLeftPosition(275L);
		formPreferences.setPartNumberTopPosition(45L);
		formPreferences.setTrackingNumberLeftPosition(275L);
		formPreferences.setTrackingNumberTopPosition(55L);
		formPreferences.setDeliveryNumberLeftPosition(480L);
		formPreferences.setDeliveryNumberTopPosition(15L);
		formPreferences.setDriverLeftPosition(40L);
		formPreferences.setDriverTopPosition(15L);
		formPreferences.setCartonCountLeftPosition(40L);
		formPreferences.setCartonCountTopPosition(27L);
		formPreferences.setCodLeftPosition(190L);
		formPreferences.setCodTopPosition(65L);
		formPreferences.setDescriptionTopPosition(200L);
		formPreferences.setSignatureTopPosition(700L);
		formPreferences.setShowDeliveryDateTitle(true);
		formPreferences.setShowDriverTitle(true);
		formPreferences.setShowCartonCountTitle(true);
		formPreferences.setInvoiceNumberMargin(3L);
		formPreferences.setInvoiceNumberWidth(50L);
		formPreferences.setOrderedQtyMargin(5L);
		formPreferences.setOrderedQtyWidth(60L);
		formPreferences.setShippedQtyMargin(5L);
		formPreferences.setShippedQtyWidth(60L);
		formPreferences.setDescriptionMargin(5L);
		formPreferences.setDescriptionWidth(310L);
		formPreferences.setWeightMargin(3L);
		formPreferences.setWeightWidth(55L);
		Long totalWidth = formPreferences.getInvoiceNumberMargin()+formPreferences.getInvoiceNumberWidth()+formPreferences.getOrderedQtyMargin()
		+formPreferences.getOrderedQtyWidth()+formPreferences.getShippedQtyMargin()+formPreferences.getShippedQtyWidth()+formPreferences.getDescriptionMargin()
		+formPreferences.getDescriptionWidth()+formPreferences.getWeightMargin()+formPreferences.getWeightWidth();
		formPreferences.setWidthOfAllItems(totalWidth);
		FontDefinition addressFontBean = new FontDefinition();
		addressFontBean.setFontName("Arial");
		addressFontBean.setSize(9);
		formPreferences.setAddressFontBean(addressFontBean);
		FontDefinition dateFontBean = new FontDefinition();
		dateFontBean.setFontName("Arial");
		dateFontBean.setSize(9);
		dateFontBean.setIsBold(true);
		formPreferences.setDateFontBean(dateFontBean);
		FontDefinition bodyTextFontBean = new FontDefinition();
		bodyTextFontBean.setFontName("Arial");
		bodyTextFontBean.setSize(10);
		formPreferences.setBodyTextFontBean(bodyTextFontBean);
		FontDefinition formFontBean = new FontDefinition();
		formFontBean.setFontName("Arial");
		formFontBean.setSize(9);
		formFontBean.setIsBold(true);
		formPreferences.setFormFontBean(formFontBean);
		formPreferences.setFormImageSource("ResourceFile");
		formPreferences.setLogoImageSource("ResourceFile");
		formPreferences.setMeasurement("Pixels");
		formPreferences = (FormPreferences) dataService.addUpdate(formPreferences);
		return formPreferences;
	}

}
