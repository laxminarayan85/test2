package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2Side")]
	public class Price2Side
	{
	 	public static const NotChangingPrice:String = "NotChangingPrice";
	 	public static const UsingFirstSideRate:String = "UsingFirstSideRate";
	 	public static const UsingSecondSideRate:String = "UsingSecondSideRate";
	 	public static const CountingAsMoreOriginals:String = "CountingAsMoreOriginals";
	 	public static const UsingSideFactor:String = "UsingSideFactor";
	
		public function Price2Side() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("Price2Side", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Price2Side);
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