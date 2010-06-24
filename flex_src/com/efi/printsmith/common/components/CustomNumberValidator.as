package com.efi.printsmith.common.components
{
	import mx.validators.NumberValidator;
	import mx.utils.StringUtil;
	import mx.validators.ValidationResult;
	
	[Bindable]
	public class CustomNumberValidator extends NumberValidator
	{
		private var results:Array;
		
		public var numberLengthBeforeDecimal:int;
		
		public var allowSymbol:Boolean = false;
		
		public var symbolString:String;
		
		override protected function doValidation(value:Object):Array {
			if(allowSymbol){
  				value = removeSymbol(value.toString());
  			}
        	results = [];
        	results = super.doValidation(value);        
        	if (results.length > 0)
                return results;
            // Return if there are errors.
            if(numberLengthBeforeDecimal!=0){
            	if(!checkCount(value.toString())){
            		results.push(new ValidationResult(true, "Number", "NumberLengthBeforeDecimalError", "Number count before decimal should be "+numberLengthBeforeDecimal));
            	}
            	return results;
            }
            return results;
  		}
  		
  		public function checkCount(inputValue:String):Boolean{
  			inputValue = removeCommas(inputValue);
  			if(allowSymbol){
  				inputValue = removeSymbol(inputValue);
  			}
  			if(inputValue!=""){
	  			var number:String = "";
	  			if(inputValue.split(".")){
	  				number = inputValue.split(".")[0];
	  				if(number.length>numberLengthBeforeDecimal){
	  					return false;
	  				}
	  			}
	  			else {
	  				if(inputValue.length>numberLengthBeforeDecimal){
	  					return false;
	  				}
	  			}
  			}
  			return true;
  		}
  		
  		private function removeCommas(dataFromControl:String):String {
			for (;dataFromControl.indexOf(",", 0) != -1;) {
					dataFromControl = dataFromControl.replace(",","");
			}
			return dataFromControl;
		}
		
		private function removeSymbol(dataFromControl:String):String{
			for (;dataFromControl.indexOf(symbolString, 0) != -1;) {
					dataFromControl = dataFromControl.replace(symbolString,"");
			}
			return dataFromControl;
		}
	}
}