package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CopierDefinition")]

	public class CopierDefinition extends ModelBase
	{

		public function CopierDefinition() {
			remoteObjectName = "com.efi.printsmith.data.CopierDefinition";
		}
				
		public var name:String = "";
		public var machineName:String = "";
		public var outputDescrip:String = "";
		public var productionLocation:String = "";
		public var costCenter:String = "";
		public var oemDeviceID:String = "";
		public var costingCopy:Boolean = true;
		public var blackwhite:Boolean = true;
		public var color:Boolean = true;
		public var integratedDevice:Boolean = true;
		public var maxSize:String = "";
		public var minSize:String = "";
		public var monthlyLabor:Number = 0;
		public var clickCost:Number = 0;
		public var laborCopy:Number = 0;
		public var largeFormat:Boolean = true;
		public var maxWidth:String = "";
		public var minWidth:String = "";
		public var daysOpen:int = 0;
		public var monthlyPayment:Number = 0;
		public var percentUsage:String = "";
		public var hourCostRate:Number = 0;
		public var tonerCopy:Number = 0;
		public var developerCopy:Number = 0;
		public var copyMarkup:Number = 0;
		public var hoursOpen:int = 0;
		public var monthlyMaintenance:Number = 0;
		public var machineCostPerCopy:Number = 0;
		public var method:String = "";
		public var salesCat:String = "";
		public var copyID:int = 0;
		public var monthlyBurdenRate:Number = 0;
		public var copyMinutes:Number = 0;
		public var charges:ArrayCollection;
		public var copierId:String = "";
	
	}
}