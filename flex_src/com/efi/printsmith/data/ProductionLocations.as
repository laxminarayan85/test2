package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductionLocations")]
	[Managed]
	
	public dynamic class ProductionLocations extends ModelBase
	{

		public function ProductionLocations() {
			remoteObjectName = "com.efi.printsmith.data.ProductionLocations";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
	
	}
}