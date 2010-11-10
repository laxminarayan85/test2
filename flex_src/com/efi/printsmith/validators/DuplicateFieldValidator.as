package com.efi.printsmith.validators
{
	import mx.collections.ArrayCollection;
	import mx.validators.ValidationResult;
	import mx.validators.Validator;

	public class DuplicateFieldValidator extends Validator
	{
		private var _existingItems:ArrayCollection;
		private var _propId:String;
		private var _propName:String;
		private var _results:Array;
		private var _originalObj:Object;
		
		public function set existingItems (val:ArrayCollection):void	{
			_existingItems = val;
		}
		
		public function get existingItems ():ArrayCollection	{
			return _existingItems;
		}
		
		public function set propName(val:String):void	{
			_propName = val;
		}
		
		public function get propName():String	{
			return _propName;
		}
		
		public function set propId(val:String):void	{
			_propId = val;
		}
		
		public function get propId():String	{
			return _propId;
		}
		
		public function set originalObj(val:Object):void	{
			_originalObj = val;
		}
		
		public function get originalObj():Object	{
			return _originalObj;
		}
		
		public function DuplicateFieldValidator()
		{
			super();
		}
		
		 override protected function doValidation(value:Object):Array {
		 	
		 	_results = [];
		 	
		 	_results = super.doValidation(value);        
            
            // Return if there are errors.
            if (_results.length > 0)
                return _results;
                
		 	
		 	if (existingItems && propName)	{
		 		for (var i:int=0; i< existingItems.length; i++)	{
		 			var item:Object = existingItems.getItemAt(i);
		 			if (
		 					(originalObj == null)
		 					||
		 					((originalObj != null) && (propId != null) && (originalObj[propId] != item[propId]))
		 				)	{
		 					
				 			if ((item[propName] as String).toUpperCase() == (value as String).toUpperCase())	{
				 				 	
				 				_results.push(new ValidationResult(true, null, "Duplicate","Duplicate entry found"));
				 				return _results;
				 			}
				 		}
		 		}
		 	}
		 	
		 	return _results;	
		 }
		
	}
}