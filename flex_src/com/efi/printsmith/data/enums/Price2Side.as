package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Price2Side")]
	public class Price2Side
	{
	 	public static const NotChangingPrice:String = "NotChangingPrice";
	 	public static const UsingFirstSideRate:String = "UsingFirstSideRate";
	 	public static const UsingSecondSideRate:String = "UsingSecondSideRate";
	 	public static const CountingAsMoreOriginals:String = "CountingAsMoreOriginals";
	 	public static const UsingSideFactor:String = "UsingSideFactor";
	
		public function Price2Side() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("Price2Side", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(NotChangingPrice);
			object.data = NotChangingPrice;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UsingFirstSideRate);
			object.data = UsingFirstSideRate;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UsingSecondSideRate);
			object.data = UsingSecondSideRate;
			returnArray.push(object);
			object = new Object();
			object.label = getString(CountingAsMoreOriginals);
			object.data = CountingAsMoreOriginals;
			returnArray.push(object);
			object = new Object();
			object.label = getString(UsingSideFactor);
			object.data = UsingSideFactor;
			returnArray.push(object);
			return returnArray;
		}
	}
}