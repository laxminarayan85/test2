package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockClass")]
	[Managed]
	
	public dynamic class StockClass extends ModelBase
	{

		public function StockClass() {
			remoteObjectName = "com.efi.printsmith.data.StockClass";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}