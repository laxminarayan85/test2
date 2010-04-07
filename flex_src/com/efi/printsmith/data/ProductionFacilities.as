package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionFacilities")]
	[Managed]
	public class ProductionFacilities extends ModelBase
	{

		public function ProductionFacilities() {
			remoteObjectName = "com.efi.printsmith.data.ProductionFacilities";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}