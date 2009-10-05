package com.efi.vo
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargePriceMethod")]
	public class ChargePriceMethod
	{
	 	public static const PIECEPRICE:String = "PiecePrice";
	 	public static const COSTPLUS:String = "CostPlus";
	
		public function ChargePriceMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargePriceMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargePriceMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}