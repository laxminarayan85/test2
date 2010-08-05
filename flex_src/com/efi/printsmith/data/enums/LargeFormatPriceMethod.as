package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.LargeFormatPriceMethod")]
	public class LargeFormatPriceMethod
	{
	 	public static const SquareAreaAndCopies:String = "SquareAreaAndCopies";
	 	public static const SquareAreaAndOriginals:String = "SquareAreaAndOriginals";
	 	public static const SquareAreaPerCopy:String = "SquareAreaPerCopy";
	 	public static const TotalSquareArea:String = "TotalSquareArea";
	
		public function LargeFormatPriceMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("LargeFormatPriceMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(LargeFormatPriceMethod);
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