package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.QuantityDiscount")]

	public class QuantityDiscount extends PriceListBase
	{

		public function QuantityDiscount() {
			remoteObjectName = "com.efi.printsmith.data.QuantityDiscount";
		}
				
	
	}
}