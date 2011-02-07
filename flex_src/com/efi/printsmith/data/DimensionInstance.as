package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DimensionInstance")]
	[Managed]
	
	public dynamic class DimensionInstance extends ModelBase
	{

		public function DimensionInstance() {
			remoteObjectName = "com.efi.printsmith.data.DimensionInstance";
		}
		public var isDeleted:Boolean=false;
				
		public var type:String = "";
		public var name:String = "";
		public var width:Number = 0;
		public var height:Number = 0;
		public var metric:Boolean = false;
	
	}
}