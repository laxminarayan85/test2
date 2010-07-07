package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PriceList")]
	[Managed]
	
	public dynamic class PriceList extends PriceListBase
	{

		public function PriceList() {
			remoteObjectName = "com.efi.printsmith.data.PriceList";
		}
				
	
	}
}