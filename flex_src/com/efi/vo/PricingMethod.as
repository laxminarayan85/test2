package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PricingMethod")]

	public class PricingMethod extends ModelBase
	{

		public function PricingMethod() {
			remoteObjectName = "com.efi.printsmith.data.PricingMethod";
		}
				
		public var name:int = 0;
	
	}
}