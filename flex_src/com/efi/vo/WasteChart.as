package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WasteChart")]

	public class WasteChart extends PriceListBase
	{

		public function WasteChart() {
			remoteObjectName = "com.efi.printsmith.data.WasteChart";
		}
				
	
	}
}