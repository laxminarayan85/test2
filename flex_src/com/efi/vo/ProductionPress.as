package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductionPress")]

	public class ProductionPress extends ModelBase
	{

		public function ProductionPress() {
			remoteObjectName = "com.efi.printsmith.data.ProductionPress";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}