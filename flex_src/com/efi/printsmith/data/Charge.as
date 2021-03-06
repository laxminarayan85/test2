package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Charge")]
	[Managed]
	
	public dynamic class Charge extends ModelBase
	{

		public function Charge() {
			remoteObjectName = "com.efi.printsmith.data.Charge";
		}
		public var isDeleted:Boolean=false;
				
		public var chargeDefinition:ChargeDefinition;
		public var description:String = "";
		public var notes:String = "";
		public var productionLocation:ProductionLocations;
		public var showNotes:Boolean = false;
		public var finished:Boolean = false;
		public var taxable:Boolean = false;
		public var brokered:Boolean = false;
		public var displayQty:Boolean = false;
		public var hidden:Boolean = false;
		public var hidePrice:Boolean = false;
		public var price:Number = 0;
		public var overridePrice:Boolean = false;
		public var quantity:Number = 0;
		public var overrideQuantity:Boolean = false;
		public var materialQty:Number = 0;
		public var overrideMaterialQuantity:Boolean = false;
		public var rate:Number = 0;
		public var overrideRate:Boolean = false;
		public var up:int = 0;
		public var overrideUp:Boolean = false;
		public var parentJob:JobBase;
		public var parentInvoice:InvoiceBase;
		public var minimumCharge:Number = 0;
		public var sets:Number = 0;
		public var materialSets:Number = 0;
		public var qtyPerSet:Number = 0;
		public var startHours:int = 0;
		public var endHours:int = 0;
		public var chargeCostingRecord:ChargeCostingRecord;
		public var nextRecord:String = "";
		public var startMinutes:int = 0;
		public var endMinutes:int = 0;
		public var overrideWeight:Boolean = false;
		public var linearX1:Boolean = false;
		public var linearX2:Boolean = false;
		public var linearY1:Boolean = false;
		public var linearY2:Boolean = false;
		public var taxTable:TaxTable;
		public var chargeNumber:Number = 0;
		public var fromAccount:Boolean = false;
		public var jobIndex:Number = 0;
		public var chargeIndex:Number = 0;
		public var originalPrice:Number = 0;
		public var originalQty:Number = 0;
	
	}
}