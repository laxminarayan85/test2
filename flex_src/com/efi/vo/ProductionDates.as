package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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