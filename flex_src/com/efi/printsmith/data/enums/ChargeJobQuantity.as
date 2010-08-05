package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeJobQuantity")]
	public class ChargeJobQuantity
	{
	 	public static const None:String = "None";
	 	public static const Press:String = "Press";
	 	public static const Finish:String = "Finish";
	 	public static const Parent:String = "Parent";
	
		public function ChargeJobQuantity() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeJobQuantity", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeJobQuantity);
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