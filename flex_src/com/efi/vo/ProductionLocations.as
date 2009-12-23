package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionLocations")]

	public class ProductionLocations extends ModelBase
	{

		public function ProductionLocations() {
			remoteObjectName = "com.efi.printsmith.data.ProductionLocations";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}