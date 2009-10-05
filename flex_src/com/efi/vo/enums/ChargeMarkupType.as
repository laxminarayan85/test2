package com.efi.vo.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeMarkupType")]
	public class ChargeMarkupType
	{
	 	public static const ONLYJOB:String = "OnlyJob";
	 	public static const CHARGES:String = "Charges";
	 	public static const ENTIREJOB:String = "EntireJob";
	 	public static const INVOICE:String = "Invoice";
	
		public function ChargeMarkupType() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeMarkupType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeMarkupType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}