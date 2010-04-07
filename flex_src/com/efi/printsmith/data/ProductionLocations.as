package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionLocations")]
	[Managed]
	public class ProductionLocations extends ModelBase
	{

		public function ProductionLocations() {
			remoteObjectName = "com.efi.printsmith.data.ProductionLocations";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}