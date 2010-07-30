package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2SideFlateRate")]
	public class Price2SideFlateRate
	{
	 	public static const NOTCHANGINGPRICE:String = "NotChangingPrice";
	 	public static const USINGSIDEFACTOR:String = "UsingSideFactor";
	
		public function Price2SideFlateRate() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Price2SideFlateRate);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = Price2SideFlateRate[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}