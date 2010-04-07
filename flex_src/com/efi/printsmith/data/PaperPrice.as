package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PaperPrice")]
	[Managed]
	public class PaperPrice extends PriceListBase
	{

		public function PaperPrice() {
			remoteObjectName = "com.efi.printsmith.data.PaperPrice";
		}
				
	
	}
}