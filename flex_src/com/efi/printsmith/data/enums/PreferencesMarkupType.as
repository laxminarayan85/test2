package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PreferencesMarkupType")]
	public class PreferencesMarkupType
	{
	 	public static const OUTSIDESERVICES:String = "OutsideServices";
	 	public static const MERCHANDISE:String = "Merchandise";
	
		public function PreferencesMarkupType() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PreferencesMarkupType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = PreferencesMarkupType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}