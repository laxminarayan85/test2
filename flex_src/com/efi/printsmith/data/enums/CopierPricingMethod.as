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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("CopierPricingMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(CostPlus);
			object.data = CostPlus;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FlatRate);
			object.data = FlatRate;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CopiesAndOriginals);
			object.data = CopiesAndOriginals;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CopiesPerOriginals);
			object.data = CopiesPerOriginals;
			returnArray.push(object);
			object = new Object();
			object.label = getString(TotalOfAllCopies);
			object.data = TotalOfAllCopies;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareAreaOfOriginals);
			object.data = SquareAreaOfOriginals;
			returnArray.push(object);
			object = new Object();
			object.label = getString(TotalSquareArea);
			object.data = TotalSquareArea;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareAreaAndCopies);
			object.data = SquareAreaAndCopies;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareAreaPerCopy);
			object.data = SquareAreaPerCopy;
			returnArray.push(object);
			return returnArray;
		}
	}
}