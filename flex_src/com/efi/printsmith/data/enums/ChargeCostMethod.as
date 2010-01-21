package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeCostMethod")]
	public class ChargeCostMethod
	{
	 	public static const TIMEANDMATERIAL:String = "TimeAndMaterial";
	 	public static const NOCOST:String = "NoCost";
	 	public static const HUNDREDPERCENT:String = "HundredPercent";
	 	public static const UNITCOST:String = "UnitCost";
	
		public function ChargeCostMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeCostMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeCostMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}