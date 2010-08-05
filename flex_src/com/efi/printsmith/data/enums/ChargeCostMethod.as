package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeCostMethod")]
	public class ChargeCostMethod
	{
	 	public static const TimeAndMaterial:String = "TimeAndMaterial";
	 	public static const NoCost:String = "NoCost";
	 	public static const HundredPercent:String = "HundredPercent";
	 	public static const UnitCost:String = "UnitCost";
	
		public function ChargeCostMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeCostMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeCostMethod);
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