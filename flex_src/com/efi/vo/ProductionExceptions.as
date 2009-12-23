package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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