package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PriceScheduleMethod")]
	public class PriceScheduleMethod
	{
	 	public static const UseOrderedQuantity:String = "UseOrderedQuantity";
	 	public static const UsePressSheets:String = "UsePressSheets";
	 	public static const UseSheetsAndBinderyWaste:String = "UseSheetsAndBinderyWaste";
	 	public static const UseOrderedQuantityPerSheet:String = "UseOrderedQuantityPerSheet";
	
		public function PriceScheduleMethod() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("PriceScheduleMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(UseOrderedQuantity);
			object.data = UseOrderedQuantity;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UsePressSheets);
			object.data = UsePressSheets;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UseSheetsAndBinderyWaste);
			object.data = UseSheetsAndBinderyWaste;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UseOrderedQuantityPerSheet);
			object.data = UseOrderedQuantityPerSheet;
			returnArray.push(object);
			return returnArray;
		}
	}
}