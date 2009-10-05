package com.efi.vo.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.ChargeQtyType")]
	public class ChargeQtyType
	{
	 	public static const SETS:String = "Sets";
	 	public static const QUANTITY:String = "Quantity";
	 	public static const TIME:String = "Time";
	 	public static const NONE:String = "None";
	 	public static const SETUPSETS:String = "SetupSets";
	
		public function ChargeQtyType() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(ChargeQtyType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = ChargeQtyType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}