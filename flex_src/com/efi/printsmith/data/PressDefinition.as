package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PressDefinition")]

	public class PressDefinition extends ModelBase
	{

		public function PressDefinition() {
			remoteObjectName = "com.efi.printsmith.data.PressDefinition";
		}
				
		public var name:String = "";
		public var machineName:String = "";
		public var outputDescrip:String = "";
		public var productionLocation:String = "";
		public var costCenter:String = "";
		public var oemDeviceID:String = "";
		public var machineID:Number = 0;
		public var costingPress:Boolean = true;
		public var integratedDevice:Boolean = true;
		public var maxPaperSize:String = "";
		public var minPaperSize:String = "";
		public var laborRate:Number = 0;
		public var laborMarkup:Number = 0;
		public var fixedWaste:Number = 0;
		public var minLabor:Number = 0;
		public var setupMin:Number = 0;
		public var setupAddSig:Number = 0;
		public var workTurnSetup:Number = 0;
		public var setupAddHead:Number = 0;
		public var washupFee:Number = 0;
		public var addSigAddHead:Number = 0;
		public var washupMin:Number = 0;
		public var washupPerFountain:Number = 0;
		public var gripEdge:Number = 0;
		public var perfector:Boolean = true;
		public var avgImpressPerHour:Number = 0;
		public var numberHeads:Number = 0;
		public var setupAddRun:Number = 0;
		public var sheetFed:Boolean = true;
		public var rollFed:Boolean = true;
		public var wasteChart:WasteChart;
		public var pressPriceList:PriceList;
		public var stockPriceList:PriceList;
		public var speedTable:SpeedTable;
		public var cutoffLength:Number = 0;
	
	}
}