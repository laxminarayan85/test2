package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeMethod")]
	public class ChargeMethod
	{
	 	public static const JOBAWARE:String = "JobAware";
	 	public static const MARKUP:String = "Markup";
	 	public static const FLATRATE:String = "FlatRate";
	 	public static const ASK:String = "Ask";
	 	public static const PRICELIST:String = "PriceList";
	 	public static const RATELIST:String = "RateList";
	 	public static const CUT:String = "Cut";
	 	public static const INK:String = "Ink";
	 	public static const SHIPPING:String = "Shipping";
	 	public static const FOLD:String = "Fold";
	 	public static const LINEAR:String = "Linear";
	 	public static const SQUAREAREA:String = "SquareArea";
	
		public function ChargeMethod() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeMethod);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeMethod[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}