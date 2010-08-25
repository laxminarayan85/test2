package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.RunMethod")]
	public class RunMethod
	{
	 	public static const Sheetwise:String = "Sheetwise";
	 	public static const WorkAndTurn:String = "WorkAndTurn";
	 	public static const WorkAndTumble:String = "WorkAndTumble";
	
		public function RunMethod() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("RunMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(Sheetwise);
			object.data = Sheetwise;
			returnArray.push(object);
			object = new Object();
			object.label = getString(WorkAndTurn);
			object.data = WorkAndTurn;
			returnArray.push(object);
			object = new Object();
			object.label = getString(WorkAndTumble);
			object.data = WorkAndTumble;
			returnArray.push(object);
			return returnArray;
		}
	}
}