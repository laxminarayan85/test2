package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductionDates")]
	[Managed]
	
	public dynamic class ProductionDates extends ModelBase
	{

		public function ProductionDates() {
			remoteObjectName = "com.efi.printsmith.data.ProductionDates";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
	
	}
}