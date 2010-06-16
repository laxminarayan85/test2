package com.efi.printsmith.data.enums
{
	import flash.utils.describeType;
[Bindable]
[RemoteClass(alias="com.efi.printsmith.data.PreferenceProgramType")]
	public class PreferenceProgramType
	{
	 	public static const FULLSYSTEM:String = "FullSystem";
	 	public static const ESTIMATORONLY:String = "EstimatorOnly";
	 	public static const COPYSHOP:String = "CopyShop";
	
		public function PreferenceProgramType() {}
	 
		public static function toArray():Array
		{
			var returnArray:Array = new Array();
			var classInfo:XML = describeType(PreferenceProgramType);
			for each (var v:XML in classInfo..constant)
			{
				var name:String = String(v.@name);
			    	var value:String = PreferenceProgramType[name];
			    	returnArray.push(value);
			}
			returnArray.sort();
			return returnArray;
		}

	}
}