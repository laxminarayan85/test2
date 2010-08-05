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
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("PreferencesMarkupType", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PreferencesMarkupType);
			for each (var v:XML in classInfo..constant)
			{
				var object:Object = new Object();
				object.label = getString(v.@name);
				object.data = String(v.@name);
			    returnArray.push(object);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}