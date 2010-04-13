package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.ShippingMethod")]

	public class ShippingMethod extends ModelBase
	{

		public function ShippingMethod() {
			remoteObjectName = "com.efi.printsmith.data.ShippingMethod";
		}
				
		public var name:String = "";
	
	}
}