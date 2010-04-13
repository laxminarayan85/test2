package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PriceList")]

	public class PriceList extends PriceListBase
	{

		public function PriceList() {
			remoteObjectName = "com.efi.printsmith.data.PriceList";
		}
				
	
	}
}