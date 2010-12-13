package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.StockPriceMethod")]
	public class StockPriceMethod
	{
	 	public static const IncludedInRate:String = "IncludedInRate";
	 	public static const MarkedUpStockCost:String = "MarkedUpStockCost";
	 	public static const FromCopier1InStockDefinition:String = "FromCopier1InStockDefinition";
	 	public static const FromCopier2InStockDefinition:String = "FromCopier2InStockDefinition";
	 	public static const FromCopier3InStockDefinition:String = "FromCopier3InStockDefinition";
	
		public function StockPriceMethod() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("StockPriceMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(IncludedInRate);
			object.data = IncludedInRate;
			returnArray.push(object);
			object = new Object();
			object.label = getString(MarkedUpStockCost);
			object.data = MarkedUpStockCost;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FromCopier1InStockDefinition);
			object.data = FromCopier1InStockDefinition;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FromCopier2InStockDefinition);
			object.data = FromCopier2InStockDefinition;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FromCopier3InStockDefinition);
			object.data = FromCopier3InStockDefinition;
			returnArray.push(object);
			return returnArray;
		}
	}
}