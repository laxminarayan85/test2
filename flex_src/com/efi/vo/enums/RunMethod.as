package com.efi.vo.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.RunMethod")]
	public class RunMethod
	{
	 	public static const SHEETWISE:String = "Sheetwise";
	 	public static const WORKANDTURN:String = "WorkAndTurn";
	 	public static const WORKANDTUMBLE:String = "WorkAndTumble";
	
		public function RunMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(RunMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = RunMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}