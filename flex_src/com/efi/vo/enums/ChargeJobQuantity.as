package com.efi.vo
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeJobQuantity")]
	public class ChargeJobQuantity
	{
	 	public static const NONE:String = "None";
	 	public static const PRESS:String = "Press";
	 	public static const FINISH:String = "Finish";
	 	public static const PARENT:String = "Parent";
	
		public function ChargeJobQuantity() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeJobQuantity);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeJobQuantity[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}