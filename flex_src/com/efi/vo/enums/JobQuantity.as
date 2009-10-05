package com.efi.vo.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.JobQuantity")]
	public class JobQuantity
	{
	 	public static const ENUMERATIONLITERAL1:String = "EnumerationLiteral1";
	
		public function JobQuantity() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(JobQuantity);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = JobQuantity[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}