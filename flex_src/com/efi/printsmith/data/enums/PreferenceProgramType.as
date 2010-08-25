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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("PreferenceProgramType", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(FullSystem);
			object.data = FullSystem;
			returnArray.push(object);
			object = new Object();
			object.label = getString(EstimatorOnly);
			object.data = EstimatorOnly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CopyShop);
			object.data = CopyShop;
			returnArray.push(object);
			return returnArray;
		}
	}
}