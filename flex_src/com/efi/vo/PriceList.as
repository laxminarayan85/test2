package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PriceList")]

	public class PriceList extends PriceListBase
	{

		public function PriceList() {
			remoteObjectName = "com.efi.printsmith.data.PriceList";
		}
				
	
	}
}