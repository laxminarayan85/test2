package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargePriceMethod")]
	public class ChargePriceMethod
	{
	 	public static const PiecePrice:String = "PiecePrice";
	 	public static const CostPlus:String = "CostPlus";
	
		public function ChargePriceMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargePriceMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargePriceMethod);
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