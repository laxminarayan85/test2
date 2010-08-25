package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PreferencesMarkupType")]
	public class PreferencesMarkupType
	{
	 	public static const OutsideServices:String = "OutsideServices";
	 	public static const Merchandise:String = "Merchandise";
	
		public function PreferencesMarkupType() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("PreferencesMarkupType", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(OutsideServices);
			object.data = OutsideServices;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Merchandise);
			object.data = Merchandise;
			returnArray.push(object);
			return returnArray;
		}
	}
}