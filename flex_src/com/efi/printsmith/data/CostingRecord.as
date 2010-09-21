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
		public var isDeleted:Boolean=false;
				
		public var actualWashupTime:Number = 0;
		public var actualTotalCost:Number = 0;
		public var acualLaborCost:Number = 0;
		public var actualLaborUnitCost:Number = 0;
		public var actualRunTime:Number = 0;
		public var actualSetupTime:Number = 0;
		public var actualMaterials:Number = 0;
		public var actualSpoilage:Number = 0;
		public var actualCost:Number = 0;
		public var actualUnitCount:Number = 0;
	
	}
}