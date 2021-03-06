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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("ChargeMethod", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(JobAware);
			object.data = JobAware;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Markup);
			object.data = Markup;
			returnArray.push(object);
			object = new Object();
			object.label = getString(FlatRate);
			object.data = FlatRate;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Ask);
			object.data = Ask;
			returnArray.push(object);
			object = new Object();
			object.label = getString(PriceList);
			object.data = PriceList;
			returnArray.push(object);
			object = new Object();
			object.label = getString(RateList);
			object.data = RateList;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Cut);
			object.data = Cut;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Ink);
			object.data = Ink;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Shipping);
			object.data = Shipping;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Fold);
			object.data = Fold;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Linear);
			object.data = Linear;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SquareArea);
			object.data = SquareArea;
			returnArray.push(object);
			return returnArray;
		}
	}
}