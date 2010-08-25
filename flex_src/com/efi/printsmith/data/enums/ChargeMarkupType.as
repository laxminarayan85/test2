package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeMarkupType")]
	public class ChargeMarkupType
	{
	 	public static const OnlyJob:String = "OnlyJob";
	 	public static const Charges:String = "Charges";
	 	public static const EntireJob:String = "EntireJob";
	 	public static const Invoice:String = "Invoice";
	
		public function ChargeMarkupType() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeMarkupType", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(OnlyJob);
			object.data = OnlyJob;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Charges);
			object.data = Charges;
			returnArray.push(object);
			object = new Object();
			object.label = getString(EntireJob);
			object.data = EntireJob;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Invoice);
			object.data = Invoice;
			returnArray.push(object);
			return returnArray;
		}
	}
}