package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockGroup")]
	[Managed]
	
	public dynamic class StockGroup extends ModelBase
	{

		public function StockGroup() {
			remoteObjectName = "com.efi.printsmith.data.StockGroup";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
		public var orderby:int = 0;
	
	}
}