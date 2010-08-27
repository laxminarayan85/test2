package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductionPress")]
	[Managed]
	
	public dynamic class ProductionPress extends ModelBase
	{

		public function ProductionPress() {
			remoteObjectName = "com.efi.printsmith.data.ProductionPress";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var key:String = "";
	
	}
}