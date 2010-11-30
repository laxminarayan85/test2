package com.efi.printsmith.service;

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
		formPreferences = (FormPreferences) dataService.addUpdate(formPreferences);
		return formPreferences;
	}

}
