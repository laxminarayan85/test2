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
	 
	 	public static function getString(value:String):String {
	 		return Snowmass.getInstance().getLocalizedEnum("PeriodType", value);
	 	}
	 	
	 	public static function toArray():Array {
	 		var returnArray:Array = new Array();
			var object:Object;
			object = new Object();
			object.label = getString(Weekly);
			object.data = Weekly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(BiWeekly);
			object.data = BiWeekly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(SemiMonthly);
			object.data = SemiMonthly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Monthly);
			object.data = Monthly;
			returnArray.push(object);
			object = new Object();
			object.label = getString(Custom);
			object.data = Custom;
			returnArray.push(object);
			return returnArray;
		}
	}
}