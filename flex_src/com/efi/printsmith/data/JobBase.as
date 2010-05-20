package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JobBase")]
	[Managed]
	
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
		public var jobTicketNotes:Boolean = false;
		public var brokered:Boolean = false;
		public var taxable:Boolean = false;
		public var finished:Boolean = false;
		public var location:Location;
		public var comment:String = "";
		public var description:String = "";
		public var qtyOrdered:Number = 0;
		public var oversUnders:Number = 0;
		public var inSetsOf:Number = 0;
		public var inSetsOfOverride:Boolean = false;
		public var sheets:Number = 0;
		public var numUp:Number = 0;
		public var numOn:Number = 0;
		public var press:PressDefinition;
		public var binderyWaste:Number = 0;
		public var binderyWasteOverride:Boolean = false;
		public var estWaste:Number = 0;
		public var estWasteOverride:Boolean = false;
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
		public var doubleSided:Boolean = false;
		public var singleSided:Boolean = false;
		public var costingRecord:CostingRecord;
		public var weight:Number = 0;
		public var totalCopies:Number = 0;
		public var numCopies:Number = 0;
		public var numCopiesOverride:Boolean = false;
		public var stockQty:Number = 0;
		public var cutOff:Number = 0;
		public var impositionsPerRun:Number = 0;
		public var totalImpositions:Number = 0;
		public var markup:Number = 0;
		public var totalCost:Number = 0;
		public var unitCost:Number = 0;
		public var notes:String = "";
		public var showNotes:Boolean = false;
		public var vendor:Vendor;
		public var numberOfLines:Number = 0;
		public var numberOfInches:Number = 0;
		public var specialOrderStock:Boolean = false;
		public var customerSuppliedStock:Boolean = false;
		public var paperPrice:PaperPrice;
		public var jdfStatus:JobJDFStatus;
		public var paperCal:PaperCalculator;
		public var orQtyOrder:Boolean = false;
		public var orSets:Boolean = false;
		public var orRuntime:Boolean = false;
		public var orSetupTime:Boolean = false;
		public var orWashupTime:Boolean = false;
		public var orStockUnits:Boolean = false;
		public var orStockMarkup:Boolean = false;
		public var orStockCost:Boolean = false;
		public var orWaste:Boolean = false;
		public var orProduction:Boolean = false;
		public var orUnit:Boolean = false;
		public var orPrice:Boolean = false;
		public var orRunOut:Boolean = false;
		public var orLaborMarkup:Boolean = false;
		public var orLaborRate:Boolean = false;
		public var orAvgImpression:Boolean = false;
		public var orPassFront:Boolean = false;
		public var orPassBack:Boolean = false;
		public var orParentSize:Boolean = false;
		public var orBinderyWaste:Boolean = false;
		public var orRunCuts:Boolean = false;
		public var orFinishCuts:Boolean = false;
		public var orUp:Boolean = false;
		public var orParentOut:Boolean = false;
	
	}
}