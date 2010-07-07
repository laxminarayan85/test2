package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductCode")]
	[Managed]
	
	public dynamic class ProductCode extends ModelBase
	{

		public function ProductCode() {
			remoteObjectName = "com.efi.printsmith.data.ProductCode";
		}
				
		public var name:String = "";
		public var key:int = 0;
	
	}
}