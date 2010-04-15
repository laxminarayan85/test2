package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductionPriority")]
	[Managed]
	
	public class ProductionPriority extends ModelBase
	{

		public function ProductionPriority() {
			remoteObjectName = "com.efi.printsmith.data.ProductionPriority";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}