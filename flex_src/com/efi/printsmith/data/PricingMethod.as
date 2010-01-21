package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PricingMethod")]

	public class PricingMethod extends ModelBase
	{

		public function PricingMethod() {
			remoteObjectName = "com.efi.printsmith.data.PricingMethod";
		}
				
		public var name:String = "";
	
	}
}