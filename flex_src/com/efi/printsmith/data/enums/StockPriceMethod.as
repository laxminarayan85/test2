package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.StockPriceMethod")]
	public class StockPriceMethod
	{
	 	public static const INCLUDEINRATE:String = "IncludeInRate";
	 	public static const MARKEDUPSTOCKCOST:String = "MarkedUpStockCost";
	 	public static const FROMCOPIER1INSTOCKDEFINITION:String = "FromCopier1InStockDefinition";
	 	public static const FROMCOPIER2INSTOCKDEFINITION:String = "FromCopier2InStockDefinition";
	 	public static const FROMCOPIER3INSTOCKDEFINITION:String = "FromCopier3InStockDefinition";
	
		public function StockPriceMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(StockPriceMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = StockPriceMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}