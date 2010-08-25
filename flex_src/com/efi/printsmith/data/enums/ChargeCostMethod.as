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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeCostMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(TimeAndMaterial);
			object.data = TimeAndMaterial;
			returnArray.push(object);
			object = new Object();
			object.label = getString(NoCost);
			object.data = NoCost;
			returnArray.push(object);
			object = new Object();
			object.label = getString(HundredPercent);
			object.data = HundredPercent;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UnitCost);
			object.data = UnitCost;
			returnArray.push(object);
			return returnArray;
		}
	}
}