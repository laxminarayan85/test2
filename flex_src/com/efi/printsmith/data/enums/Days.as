package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.Days")]
	public class Days
	{
	 	public static const MONDAY:String = "Monday";
	 	public static const TUESDAY:String = "Tuesday";
	 	public static const WEDNESDAY:String = "Wednesday";
	 	public static const THURSDAY:String = "Thursday";
	 	public static const FRIDAY:String = "Friday";
	 	public static const SATURDAY:String = "Saturday";
	 	public static const SUNDAY:String = "Sunday";
	
		public function Days() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(Days);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = Days[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}