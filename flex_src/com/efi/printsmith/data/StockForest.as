package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockForest")]
	[Managed]
	
	public dynamic class StockForest extends ModelBase
	{

		public function StockForest() {
			remoteObjectName = "com.efi.printsmith.data.StockForest";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
	
	}
}