package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionCopiers")]
	[Managed]
	public class ProductionCopiers extends ModelBase
	{

		public function ProductionCopiers() {
			remoteObjectName = "com.efi.printsmith.data.ProductionCopiers";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}