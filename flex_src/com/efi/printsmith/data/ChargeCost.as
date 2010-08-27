package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.ChargeCost")]
	[Managed]
	
	public dynamic class ChargeCost extends ModelBase
	{

		public function ChargeCost() {
			remoteObjectName = "com.efi.printsmith.data.ChargeCost";
		}
		public var isDeleted:Boolean=false;
				
		public var setupCost:Number = 0;
		public var unitCost:Number = 0;
		public var rateTable:PriceList;
		public var fixedMaterials:Number = 0;
		public var unitMaterials:Number = 0;
		public var laborRate:Number = 0;
		public var setupMinutes:Number = 0;
		public var piecesPerHour:Number = 0;
		public var totalUnitCost:Number = 0;
		public var costingMethod:String = "";
		public var speedTable:SpeedTable;
	
	}
}