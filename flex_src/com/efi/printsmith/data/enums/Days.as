package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Days")]
	public class Days
	{
	 	public static const Monday:String = "Monday";
	 	public static const Tuesday:String = "Tuesday";
	 	public static const Wednesday:String = "Wednesday";
	 	public static const Thursday:String = "Thursday";
	 	public static const Friday:String = "Friday";
	 	public static const Saturday:String = "Saturday";
	 	public static const Sunday:String = "Sunday";
	
		public function Days() {}
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("Days", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(Monday);
			object.data = Monday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Tuesday);
			object.data = Tuesday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Wednesday);
			object.data = Wednesday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Thursday);
			object.data = Thursday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Friday);
			object.data = Friday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Saturday);
			object.data = Saturday;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Sunday);
			object.data = Sunday;
			returnArray.push(object);
			return returnArray;
		}
	}
}