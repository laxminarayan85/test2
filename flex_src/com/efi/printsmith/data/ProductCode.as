package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ProductCode")]

	public class ProductCode extends ModelBase
	{

		public function ProductCode() {
			remoteObjectName = "com.efi.printsmith.data.ProductCode";
		}
				
		public var name:String = "";
	
	}
}