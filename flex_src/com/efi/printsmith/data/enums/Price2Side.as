package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2Side")]
	public class Price2Side
	{
	 	public static const NOTCHANGINGPRICE:String = "NotChangingPrice";
	 	public static const USINGFIRSTSIDERATE:String = "UsingFirstSideRate";
	 	public static const USINGSECONDSIDERATE:String = "UsingSecondSideRate";
	 	public static const COUNTINGASMOREORIGINALS:String = "CountingAsMoreOriginals";
	 	public static const USINGSIDEFACTOR:String = "UsingSideFactor";
	
		public function Price2Side() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Price2Side);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = Price2Side[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}