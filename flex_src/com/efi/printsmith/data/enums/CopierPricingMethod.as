package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.CopierPricingMethod")]
	public class CopierPricingMethod
	{
	 	public static const CostPlus:String = "CostPlus";
	 	public static const FlatRate:String = "FlatRate";
	 	public static const CopiesAndOriginals:String = "CopiesAndOriginals";
	 	public static const CopiesPerOriginals:String = "CopiesPerOriginals";
	 	public static const TotalOfAllCopies:String = "TotalOfAllCopies";
	 	public static const SquareAreaOfOriginals:String = "SquareAreaOfOriginals";
	 	public static const TotalSquareArea:String = "TotalSquareArea";
	 	public static const SquareAreaAndCopies:String = "SquareAreaAndCopies";
	 	public static const SquareAreaPerCopy:String = "SquareAreaPerCopy";
	
		public function CopierPricingMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("CopierPricingMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(CopierPricingMethod);
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