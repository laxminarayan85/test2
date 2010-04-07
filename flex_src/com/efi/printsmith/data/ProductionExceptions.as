package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionExceptions")]

	public class ProductionExceptions extends ModelBase
	{

		public function ProductionExceptions() {
			remoteObjectName = "com.efi.printsmith.data.ProductionExceptions";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}