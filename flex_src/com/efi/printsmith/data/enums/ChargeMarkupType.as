package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeMarkupType")]
	public class ChargeMarkupType
	{
	 	public static const OnlyJob:String = "OnlyJob";
	 	public static const Charges:String = "Charges";
	 	public static const EntireJob:String = "EntireJob";
	 	public static const Invoice:String = "Invoice";
	
		public function ChargeMarkupType() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeMarkupType", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeMarkupType);
			for each (var v:XML in classInfo..constant)
			{
				var object:Object = new Object();
				object.label = getString(v.@name);
				object.data = String(v.@name);
			    returnArray.push(object);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}