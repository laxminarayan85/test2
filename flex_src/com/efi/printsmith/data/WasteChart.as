package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WasteChart")]
	[Managed]
	
	public dynamic class WasteChart extends PriceListBase
	{

		public function WasteChart() {
			remoteObjectName = "com.efi.printsmith.data.WasteChart";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}