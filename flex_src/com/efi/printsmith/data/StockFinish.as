package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockFinish")]
	[Managed]
	
	public dynamic class StockFinish extends ModelBase
	{

		public function StockFinish() {
			remoteObjectName = "com.efi.printsmith.data.StockFinish";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}