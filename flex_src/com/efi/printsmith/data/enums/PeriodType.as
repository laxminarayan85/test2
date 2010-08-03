package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PeriodType")]
	public class PeriodType
	{
	 	public static const Weekly:String = "Weekly";
	 	public static const BiWeekly:String = "BiWeekly";
	 	public static const SemiMonthly:String = "SemiMonthly";
	 	public static const Monthly:String = "Monthly";
	 	public static const Custom:String = "Custom";
	
		public function PeriodType() {}
	 
	 	public static function getString(value:String):String
	 	{
	 		return Snowmass.getInstance().getLocalizedEnum("PeriodType", value);
	 	}
	 	
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PeriodType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
				var value:String = getString(v.@name);
			    returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}
	}
}