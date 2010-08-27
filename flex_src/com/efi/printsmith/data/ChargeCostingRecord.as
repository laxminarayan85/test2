package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeCostingRecord")]
	[Managed]
	
	public dynamic class ChargeCostingRecord extends ModelBase
	{

		public function ChargeCostingRecord() {
			remoteObjectName = "com.efi.printsmith.data.ChargeCostingRecord";
		}
		public var isDeleted:Boolean=false;
				
		public var impressions:Number = 0;
		public var totalImpressions:Number = 0;
		public var actualUnitCount:Number = 0;
		public var actualSpoilage:Number = 0;
		public var actualMaterials:Number = 0;
		public var setupTime:Number = 0;
		public var runTime:Number = 0;
		public var laborUnitCost:Number = 0;
		public var laborCost:Number = 0;
		public var totalCost:Number = 0;
		public var actualCount:Number = 0;
	
	}
}