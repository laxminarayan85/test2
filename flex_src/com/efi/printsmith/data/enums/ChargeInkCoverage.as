package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeInkCoverage")]
	public class ChargeInkCoverage
	{
	 	public static const UnknownArea:String = "UnknownArea";
	 	public static const RunArea:String = "RunArea";
	 	public static const FinishedArea:String = "FinishedArea";
	
		public function ChargeInkCoverage() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeInkCoverage", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(UnknownArea);
			object.data = UnknownArea;
			returnArray.push(object);
			object = new Object();
			object.label = getString(RunArea);
			object.data = RunArea;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FinishedArea);
			object.data = FinishedArea;
			returnArray.push(object);
			return returnArray;
		}
	}
}