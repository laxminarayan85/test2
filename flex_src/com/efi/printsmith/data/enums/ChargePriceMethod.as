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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargePriceMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(PiecePrice);
			object.data = PiecePrice;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CostPlus);
			object.data = CostPlus;
			returnArray.push(object);
			return returnArray;
		}
	}
}