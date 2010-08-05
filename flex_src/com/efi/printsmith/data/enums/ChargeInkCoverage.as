package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeInkCoverage")]
	public class ChargeInkCoverage
	{
	 	public static const UnknownArea:String = "UnknownArea";
	 	public static const RunArea:String = "RunArea";
	 	public static const FinishedArea:String = "FinishedArea";
	
		public function ChargeInkCoverage() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeInkCoverage", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeInkCoverage);
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