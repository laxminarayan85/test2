package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
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