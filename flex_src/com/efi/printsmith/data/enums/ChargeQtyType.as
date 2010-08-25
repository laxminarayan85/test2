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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeQtyType", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(Sets);
			object.data = Sets;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Quantity);
			object.data = Quantity;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Time);
			object.data = Time;
			returnArray.push(object);
			object = new Object();
			object.label = getString(None);
			object.data = None;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SetupSets);
			object.data = SetupSets;
			returnArray.push(object);
			object = new Object();
			object.label = getString(TotalWeight);
			object.data = TotalWeight;
			returnArray.push(object);
			object = new Object();
			object.label = getString(ShippingQty);
			object.data = ShippingQty;
			returnArray.push(object);
			return returnArray;
		}
	}
}