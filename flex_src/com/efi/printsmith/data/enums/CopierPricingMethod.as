package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.CopierPricingMethod")]
	public class CopierPricingMethod
	{
	 	public static const COSTPLUS:String = "CostPlus";
	 	public static const FLATRATE:String = "FlatRate";
	 	public static const COPIESANDORIGINALS:String = "CopiesAndOriginals";
	 	public static const COPIESPERORIGINALS:String = "CopiesPerOriginals";
	 	public static const TOTALOFALLCOPIES:String = "TotalOfAllCopies";
	 	public static const SQUAREAREAOFORIGINALS:String = "SquareAreaOfOriginals";
	 	public static const TOTALSQUAREAREA:String = "TotalSquareArea";
	 	public static const SQUAREAREAANDCOPIES:String = "SquareAreaAndCopies";
	 	public static const SQUAREAREAPERCOPY:String = "SquareAreaPerCopy";
	
		public function CopierPricingMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(CopierPricingMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = CopierPricingMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}