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
				var name:String = String(v.@name);
				var value:String = getString(v.@name);
			    returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}