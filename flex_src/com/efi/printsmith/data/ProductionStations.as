package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ProductionStations")]
	[Managed]
	
	public class ProductionStations extends ModelBase
	{

		public function ProductionStations() {
			remoteObjectName = "com.efi.printsmith.data.ProductionStations";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}