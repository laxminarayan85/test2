package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.QuantityDiscount")]
	[Managed]
	
	public class QuantityDiscount extends PriceListBase
	{

		public function QuantityDiscount() {
			remoteObjectName = "com.efi.printsmith.data.QuantityDiscount";
		}
				
	
	}
}