package com.efi.printsmith.validators
{
	import mx.validators.Validator;
	import mx.validators.ValidationResult;
	
	public class URLValidator extends Validator
	{
        public function URLValidator()
        {
            super();
        }
       
        override protected function doValidation(value:Object):Array
        {
            // Clear results Array.
            var results:Array = [];

            // Call base class doValidation().
            results = super.doValidation(value);       
            // Return if there are errors.
            if (results.length > 0)
                return results;
           
            // match regex pattern
//            var pattern:RegExp = new RegExp("^http[s]?\:\\/\\/([^\\/]+)\\/");
			var pattern:RegExp = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
            // run the pattern, but don't error if there is no value and this is not required
            if (!(!required && !value) && !pattern.exec(String(value))) {
                results.push(new ValidationResult(true, null, "notURL",
                    "You must enter a valid URL in the form \"http://xxx.xxx.xxx.xxx:xxxx\"  For example: http://192.168.1.2:8010"));
                return results;
            }
           
            return results;
        }		
	}
}