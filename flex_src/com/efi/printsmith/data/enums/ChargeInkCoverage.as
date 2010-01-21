package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeInkCoverage")]
	public class ChargeInkCoverage
	{
	 	public static const UNKNOWNAREA:String = "UnknownArea";
	 	public static const RUNAREA:String = "RunArea";
	 	public static const FINISHEDAREA:String = "FinishedArea";
	
		public function ChargeInkCoverage() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeInkCoverage);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeInkCoverage[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}