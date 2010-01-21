package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WasteChart")]

	public class WasteChart extends PriceListBase
	{

		public function WasteChart() {
			remoteObjectName = "com.efi.printsmith.data.WasteChart";
		}
				
	
	}
}