package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.chargePricingMethod")]

	public class chargePricingMethod extends ModelBase
	{

		public function chargePricingMethod() {
			remoteObjectName = "com.efi.printsmith.data.chargePricingMethod";
		}
				
		public var name:String = "";
	
	}
}