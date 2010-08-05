package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.StockPriceMethod")]
	public class StockPriceMethod
	{
	 	public static const IncludeInRate:String = "IncludeInRate";
	 	public static const MarkedUpStockCost:String = "MarkedUpStockCost";
	 	public static const FromCopier1InStockDefinition:String = "FromCopier1InStockDefinition";
	 	public static const FromCopier2InStockDefinition:String = "FromCopier2InStockDefinition";
	 	public static const FromCopier3InStockDefinition:String = "FromCopier3InStockDefinition";
	
		public function StockPriceMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("StockPriceMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(StockPriceMethod);
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