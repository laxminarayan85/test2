package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.LargeFormatPriceMethod")]
	public class LargeFormatPriceMethod
	{
	 	public static const SQUAREAREAANDCOPIES:String = "SquareAreaAndCopies";
	 	public static const SQUAREAREAANDORIGINALS:String = "SquareAreaAndOriginals";
	 	public static const SQUAREAREAPERCOPY:String = "SquareAreaPerCopy";
	 	public static const TOTALSQUAREAREA:String = "TotalSquareArea";
	
		public function LargeFormatPriceMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(LargeFormatPriceMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = LargeFormatPriceMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}