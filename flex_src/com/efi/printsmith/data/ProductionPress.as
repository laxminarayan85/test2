package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionPress")]
	[Managed]
	public class ProductionPress extends ModelBase
	{

		public function ProductionPress() {
			remoteObjectName = "com.efi.printsmith.data.ProductionPress";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}