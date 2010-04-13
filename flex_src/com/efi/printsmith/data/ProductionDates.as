package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionDates")]

	public class ProductionDates extends ModelBase
	{

		public function ProductionDates() {
			remoteObjectName = "com.efi.printsmith.data.ProductionDates";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}