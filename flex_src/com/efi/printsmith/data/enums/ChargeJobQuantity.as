package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeJobQuantity")]
	public class ChargeJobQuantity
	{
	 	public static const None:String = "None";
	 	public static const Press:String = "Press";
	 	public static const Finish:String = "Finish";
	 	public static const Parent:String = "Parent";
	
		public function ChargeJobQuantity() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeJobQuantity", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(None);
			object.data = None;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Press);
			object.data = Press;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Finish);
			object.data = Finish;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Parent);
			object.data = Parent;
			returnArray.push(object);
			return returnArray;
		}
	}
}