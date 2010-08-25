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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("LargeFormatPriceMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(SquareAreaAndCopies);
			object.data = SquareAreaAndCopies;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareAreaAndOriginals);
			object.data = SquareAreaAndOriginals;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareAreaPerCopy);
			object.data = SquareAreaPerCopy;
			returnArray.push(object);
			object = new Object();
			object.label = getString(TotalSquareArea);
			object.data = TotalSquareArea;
			returnArray.push(object);
			return returnArray;
		}
	}
}