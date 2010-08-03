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
				var name:String = String(v.@name);
				var value:String = getString(v.@name);
			    returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}