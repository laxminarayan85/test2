// ActionScript file
import com.efi.printsmith.common.components.CustomEmailTextInputComponent;
import com.efi.printsmith.common.components.CustomNumberValidator;
import com.efi.printsmith.common.components.CustomNumericTextInputComponent;
import com.efi.printsmith.common.components.CustomPhoneNumberTextInputComponent;
import com.efi.printsmith.common.components.CustomStringTextInputComponent;

import mx.core.Container;
import mx.events.ValidationResultEvent;
import mx.validators.EmailValidator;
import mx.validators.PhoneNumberValidator;
import mx.validators.StringValidator;
import mx.validators.Validator;

private function validate(displayObject:Object):Boolean{
	var valid:Boolean = true;
	if(valid){
		if(!validateOutsideDataGrid(displayObject)){
			valid = false;
		}
	}
	return valid;
}
	
	
private function validateOutsideDataGrid(object:Object):Boolean{
	var valid:Boolean = true;
	if(object is Container){
		for(var i:int=0;i<object.getChildren().length;i++){
			if(object.getChildren()[i] is CustomNumericTextInputComponent){
				if(!validateNumericComponent(object.getChildren()[i])){
					valid = false;
					break;
				}
			}
			else if(object.getChildren()[i] is CustomStringTextInputComponent) {
				if(!validateStringComponent(object.getChildren()[i])){
					valid = false;
					break;
				}
			}
			else if(object.getChildren()[i] is CustomEmailTextInputComponent){
				if(!validateEmailComponent(object.getChildren()[i])){
					valid = false;
					break;
				}
			}
			else if(object.getChildren()[i] is CustomPhoneNumberTextInputComponent){
				if(!validatePhoneComponent(object.getChildren()[i])){
					valid = false;
					break;
				}
			}
			valid = validateOutsideDataGrid(object.getChildren()[i]);
			if(!valid){
				break;
			}
		}
	}
	return valid;
}


public function validateNumericComponent(customNumericTextInputComponent:CustomNumericTextInputComponent):Boolean{
	var validateNumber:CustomNumberValidator = new CustomNumberValidator();
	validateNumber.allowNegative=customNumericTextInputComponent.allowNegative; 
	validateNumber.minValue=customNumericTextInputComponent.minValue;
	validateNumber.maxValue=customNumericTextInputComponent.maxValue;
	validateNumber.required=customNumericTextInputComponent.required;
	validateNumber.numberLengthBeforeDecimal=customNumericTextInputComponent.numberLengthBeforeDecimal;
	validateNumber.source=customNumericTextInputComponent;
	validateNumber.listener=customNumericTextInputComponent;
	validateNumber.allowSymbol=customNumericTextInputComponent.allowSymbol;
	validateNumber.symbolString=customNumericTextInputComponent.symbolString;
	validateNumber.property="text";
	var validateEvent:ValidationResultEvent  = validateNumber.validate(customNumericTextInputComponent.text);
	if (validateEvent.type  == ValidationResultEvent.INVALID ) {
		return false;
	}
	return true;
}

public function validateEmailComponent(customEmailTextInputComponent:CustomEmailTextInputComponent):Boolean{
	var validateEmail:EmailValidator = new EmailValidator();
	validateEmail.property = "text";
	validateEmail.source = customEmailTextInputComponent;
	validateEmail.required = customEmailTextInputComponent.required;
	var emailValidateEvent:ValidationResultEvent  = validateEmail.validate(customEmailTextInputComponent.text);
	if (emailValidateEvent.type  == ValidationResultEvent.INVALID ) {
		return false;
	}
	return true;
}

public function validatePhoneComponent(customPhoneNumberTextInputComponent:CustomPhoneNumberTextInputComponent):Boolean{
	var validatePhone:PhoneNumberValidator = new PhoneNumberValidator();
	validatePhone.property = "text";
	validatePhone.source = customPhoneNumberTextInputComponent;
	validatePhone.required = customPhoneNumberTextInputComponent.required;
	var phoneValidateEvent:ValidationResultEvent  = validatePhone.validate(customPhoneNumberTextInputComponent.text);
	if (phoneValidateEvent.type  == ValidationResultEvent.INVALID ) {
		return false;
	}
	return true;
}

public function validateStringComponent(customStringTextInputComponent:CustomStringTextInputComponent):Boolean{
	var validateString:StringValidator = new StringValidator();
	validateString.source = customStringTextInputComponent;
	validateString.property = "text";
	validateString.minLength = customStringTextInputComponent.minValue;
	validateString.maxLength = customStringTextInputComponent.maxValue;
	validateString.required = customStringTextInputComponent.required;
	var stringValidateEvent:ValidationResultEvent  = validateString.validate(customStringTextInputComponent.text);
	if (stringValidateEvent.type  == ValidationResultEvent.INVALID ) {
		return false;
	}
	if(customStringTextInputComponent.validatorClass){
		var customValidate:Validator = customStringTextInputComponent.validatorClass;
		customValidate.source = customStringTextInputComponent;
		customValidate.property = "text";
		var customStringValidateEvent:ValidationResultEvent  = customValidate.validate(customStringTextInputComponent.text);
		if (customStringValidateEvent.type  == ValidationResultEvent.INVALID ) {
			return false;
		}
	}
	return true;
}