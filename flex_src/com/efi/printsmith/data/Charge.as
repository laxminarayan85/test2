package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Charge")]

	public class Charge extends ModelBase
	{

		public function Charge() {
			remoteObjectName = "com.efi.printsmith.data.Charge";
		}
				
		public var chargeDefinition:ChargeDefinition;
		public var description:String = "";
		public var notes:String = "";
		public var productionLocation:Location;
		public var showNotes:Boolean = true;
		public var finished:Boolean = true;
		public var taxable:Boolean = true;
		public var brokered:Boolean = true;
		public var displayQty:Boolean = true;
		public var hidden:Boolean = true;
		public var hidePrice:Boolean = true;
		public var price:Number = 0;
		public var overridePrice:Boolean = true;
		public var quantity:Number = 0;
		public var overrideQuantity:Boolean = true;
		public var materialQty:Number = 0;
		public var overrideMaterialQuantity:Boolean = true;
		public var rate:Number = 0;
		public var overrideRate:Boolean = true;
		public var up:int = 0;
		public var overrideUp:Boolean = true;
		public var parentJob:JobBase;
		public var parentInvoice:Invoice;
		public var minimumCharge:Number = 0;
		public var sets:Number = 0;
		public var materialSets:Number = 0;
		public var qtyPerSet:Number = 0;
		public var startTime:Date = new Date();
		public var endTime:Date = new Date();
	
	}
}