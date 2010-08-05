package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeMethod")]
	public class ChargeMethod
	{
	 	public static const JobAware:String = "JobAware";
	 	public static const Markup:String = "Markup";
	 	public static const FlatRate:String = "FlatRate";
	 	public static const Ask:String = "Ask";
	 	public static const PriceList:String = "PriceList";
	 	public static const RateList:String = "RateList";
	 	public static const Cut:String = "Cut";
	 	public static const Ink:String = "Ink";
	 	public static const Shipping:String = "Shipping";
	 	public static const Fold:String = "Fold";
	 	public static const Linear:String = "Linear";
	 	public static const SquareArea:String = "SquareArea";
	
		public function ChargeMethod() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeMethod", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeMethod);
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