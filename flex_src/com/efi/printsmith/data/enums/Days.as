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
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("Days", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Days);
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