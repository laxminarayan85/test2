package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PreferenceProgramType")]
	public class PreferenceProgramType
	{
	 	public static const FullSystem:String = "FullSystem";
	 	public static const EstimatorOnly:String = "EstimatorOnly";
	 	public static const CopyShop:String = "CopyShop";
	
		public function PreferenceProgramType() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("PreferenceProgramType", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PreferenceProgramType);
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