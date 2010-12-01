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
		formPreferences.setLogoAcrossWidth(216D);
		formPreferences.setLogoDownWidth(72D);
		formPreferences.setFromAddressTopPosition(90D);
		formPreferences.setFromAddressAcrossWidth(180D);
		formPreferences.setFromAddressDownWidth(90D);
		formPreferences.setToAddressLeftPosition(190D);
		formPreferences.setToAddressTopPosition(90D);
		formPreferences.setToAddressAcrossWidth(180D);
		formPreferences.setToAddressDownWidth(90D);
		formPreferences.setAttnLeftPosition(375D);
		formPreferences.setAttnTopPosition(90D);
		formPreferences.setAttnAcrossWidth(180D);
		formPreferences.setAttnDownWidth(90D);
		formPreferences.setLineTopPosition(236D);
		formPreferences.setLineAcrossWidth(522D);
		formPreferences.setLineDownWidth(216D);
		formPreferences.setCommentTopPosition(475D);
		formPreferences.setCommentAcrossWidth(540D);
		formPreferences.setCommentDownWidth(100D);
		formPreferences.setDeliveryDateLeftPosition(480D);
		formPreferences.setDeliveryDateTopPosition(25D);
		formPreferences.setReferenceLeftPosition(480D);
		formPreferences.setReferenceTopPosition(45D);
		formPreferences.setShipViaLeftPosition(480D);
		formPreferences.setShipViaTopPosition(35D);
		formPreferences.setCustomerPOLeftPosition(275D);
		formPreferences.setCustomerPOTopPosition(35D);
		formPreferences.setOrderNumberLeftPosition(275D);
		formPreferences.setOrderNumberTopPosition(25D);
		formPreferences.setPartNumberLeftPosition(275D);
		formPreferences.setPartNumberTopPosition(45D);
		formPreferences.setTrackingNumberLeftPosition(275D);
		formPreferences.setTrackingNumberTopPosition(55D);
		formPreferences.setDeliveryNumberLeftPosition(480D);
		formPreferences.setDeliveryNumberTopPosition(15D);
		formPreferences.setDriverLeftPosition(40D);
		formPreferences.setDriverTopPosition(15D);
		formPreferences.setCartonCountLeftPosition(40D);
		formPreferences.setCartonCountTopPosition(27D);
		formPreferences.setCodLeftPosition(190D);
		formPreferences.setCodTopPosition(65D);
		formPreferences.setDescriptionTopPosition(200D);
		formPreferences.setSignatureTopPosition(700D);
		formPreferences.setShowDeliveryDateTitle(true);
		formPreferences.setShowDriverTitle(true);
		formPreferences.setShowCartonCountTitle(true);
		formPreferences.setInvoiceNumberMargin(3D);
		formPreferences.setInvoiceNumberWidth(50D);
		formPreferences.setOrderedQtyMargin(5D);
		formPreferences.setOrderedQtyWidth(60D);
		formPreferences.setShippedQtyMargin(5D);
		formPreferences.setShippedQtyWidth(60D);
		formPreferences.setDescriptionMargin(5D);
		formPreferences.setDescriptionWidth(310D);
		formPreferences.setWeightMargin(3D);
		formPreferences.setWeightWidth(55D);
		Double totalWidth = formPreferences.getInvoiceNumberMargin()+formPreferences.getInvoiceNumberWidth()+formPreferences.getOrderedQtyMargin()
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
