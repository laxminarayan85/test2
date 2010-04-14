package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.JobBase")]

	public class JobBase extends ModelBase
	{

		public function JobBase() {
			remoteObjectName = "com.efi.printsmith.data.JobBase";
		}
				
		public var jobNumber:String = "";
		public var jobIndex:Number = 0;
		public var salesCategory:SalesCategory;
		public var productCode:ProductCode;
		public var children:ArrayCollection;
		public var charges:ArrayCollection;
		public var jobNotes:String = "";
		public var jobTicketNotes:Boolean = true;
		public var brokered:Boolean = true;
		public var taxable:Boolean = true;
		public var finished:Boolean = true;
		public var location:Location;
		public var comment:String = "";
		public var description:String = "";
		public var qtyOrdered:Number = 0;
		public var oversUnders:Number = 0;
		public var inSetsOf:Number = 0;
		public var inSetsOfOverride:Boolean = true;
		public var sheets:Number = 0;
		public var numUp:Number = 0;
		public var numOn:Number = 0;
		public var press:PressDefinition;
		public var binderyWaste:Number = 0;
		public var binderyWasteOverride:Boolean = true;
		public var estWaste:Number = 0;
		public var estWasteOverride:Boolean = true;
		public var signatures:Number = 0;
		public var pricingPress:PressDefinition;
		public var costingPress:PressDefinition;
		public var runMethod:String = "";
		public var stock:StockDefinition;
		public var parentSize:String = "";
		public var runSize:String = "";
		public var finishSize:String = "";
		public var foldedSize:String = "";
		public var frontColors:int = 0;
		public var backColors:int = 0;
		public var frontPasses:int = 0;
		public var backPasses:int = 0;
		public var frontWashes:int = 0;
		public var backWashes:int = 0;
		public var frontInks:ArrayCollection;
		public var backInks:InkColor;
		public var pressQty:Number = 0;
		public var pricingRecord:PricingRecord;
		public var pricingCopier:CopierDefinition;
		public var costingCopier:CopierDefinition;
		public var pricingMethod:PreferencesPricingMethod;
		public var doubleSided:Boolean = true;
		public var singleSided:Boolean = true;
		public var costingRecord:CostingRecord;
		public var weight:Number = 0;
		public var totalCopies:Number = 0;
		public var numCopies:Number = 0;
		public var numCopiesOverride:Boolean = true;
		public var stockQty:Number = 0;
		public var cutOff:Number = 0;
		public var impositionsPerRun:Number = 0;
		public var totalImpositions:Number = 0;
		public var markup:Number = 0;
		public var totalCost:Number = 0;
		public var unitCost:Number = 0;
	
	}
}