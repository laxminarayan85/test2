package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CostingRecord")]
	[Managed]
	
	public dynamic class CostingRecord extends ModelBase
	{

		public function CostingRecord() {
			remoteObjectName = "com.efi.printsmith.data.CostingRecord";
		}
				
		public var unitCost:Number = 0;
		public var totalCost:Number = 0;
		public var laborCost:Number = 0;
		public var stockCost:Number = 0;
	
	}
}