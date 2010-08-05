package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2SideFlatRate")]
	public class Price2SideFlatRate
	{
	 	public static const NotChangingPrice:String = "NotChangingPrice";
	 	public static const UsingSideFactor:String = "UsingSideFactor";
	
		public function Price2SideFlatRate() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("Price2SideFlatRate", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Price2SideFlatRate);
			for each (var v:XML in classInfo..constant)
			{
				var object:Object = new Object();
				object.label = getString(v.@name);
				object.data = String(v.@name);
			    returnArray.push(object);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}