package com.efi.printsmith.common.components
{
	import mx.validators.Validator;
	import mx.validators.ValidationResult;
	
	public class CustomComboBoxValidator extends Validator
	{
		public var keyName:String;
		
		public var keyValue:Object;
		
		private var results:Array;

        override protected function doValidation(value:Object):Array {
        	results = [];
        	//results = super.doValidation(value);
        	if(keyValue){
	        	if(value[keyName]==keyValue && required){
	        		results.push(new ValidationResult(true, "ComboBox", "InavlidError", "Invalid Selection"));
	        		return results;
	        	}
        	}
        	return results;
        }
	}
}