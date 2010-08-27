package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SpeedTable")]
	[Managed]
	
	public dynamic class SpeedTable extends PriceListBase
	{

		public function SpeedTable() {
			remoteObjectName = "com.efi.printsmith.data.SpeedTable";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}