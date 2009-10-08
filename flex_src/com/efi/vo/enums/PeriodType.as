package com.efi.vo.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PeriodType")]
	public class PeriodType
	{
	 	public static const WEEKLY:String = "Weekly";
	 	public static const BIWEEKLY:String = "BiWeekly";
	 	public static const SEMIMONTHLY:String = "SemiMonthly";
	 	public static const MONTHLY:String = "Monthly";
	 	public static const CUSTOM:String = "Custom";
	
		public function PeriodType() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PeriodType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = PeriodType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}