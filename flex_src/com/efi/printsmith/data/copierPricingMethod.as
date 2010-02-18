package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.copierPricingMethod")]

	public class copierPricingMethod extends ModelBase
	{

		public function copierPricingMethod() {
			remoteObjectName = "com.efi.printsmith.data.copierPricingMethod";
		}
				
		public var name:String = "";
	
	}
}