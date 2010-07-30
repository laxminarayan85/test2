package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2SideFlatRate")]
	public class Price2SideFlatRate
	{
	 	public static const NOTCHANGINGPRICE:String = "NotChangingPrice";
	 	public static const USINGSIDEFACTOR:String = "UsingSideFactor";
	
		public function Price2SideFlatRate() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Price2SideFlatRate);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = Price2SideFlatRate[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}