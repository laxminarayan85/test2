package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeQtyType")]
	public class ChargeQtyType
	{
	 	public static const Sets:String = "Sets";
	 	public static const Quantity:String = "Quantity";
	 	public static const Time:String = "Time";
	 	public static const None:String = "None";
	 	public static const SetupSets:String = "SetupSets";
	 	public static const TotalWeight:String = "TotalWeight";
	 	public static const ShippingQty:String = "ShippingQty";
	
		public function ChargeQtyType() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeQtyType", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeQtyType);
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