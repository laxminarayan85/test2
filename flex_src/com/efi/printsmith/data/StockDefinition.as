package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.StockDefinition")]

	public class StockDefinition extends ModelBase
	{

		public function StockDefinition() {
			remoteObjectName = "com.efi.printsmith.data.StockDefinition";
		}
				
		public var stockunit:int = 0;
		public var name:String = "";
		public var stkgroup:StockGroup;
		public var stkclass:StockClass;
		public var stktype:StockType;
		public var isMetric:Boolean = true;
		public var finish:StockFinish;
		public var weight:Number = 0;
		public var color:StockColors;
		public var grade:StockGrade;
		public var coated:String = "";
		public var stocknumber:String = "";
		public var vendor:Vendor;
		public var basicsize:String = "";
		public var parentsize:String = "";
		public var thickness:Number = 0;
		public var mweight:Number = 0;
		public var sheetspercarton:int = 0;
		public var minorder:int = 0;
		public var comments:String = "";
		public var uom:String = "";
		public var costunits:int = 0;
		public var entireOrderCharge:Boolean = true;
		public var sheetsPerSet:int = 0;
		public var isCostInSets:Boolean = true;
		public var priceExpires:Date = new Date();
		public var qtybreak1:int = 0;
		public var qtybreak2:int = 0;
		public var qtybreak3:int = 0;
		public var qtybreak4:int = 0;
		public var qtybreak5:int = 0;
		public var qtybreak6:int = 0;
		public var cost1:Number = 0;
		public var cost2:Number = 0;
		public var cost3:Number = 0;
		public var cost4:Number = 0;
		public var cost5:Number = 0;
		public var cost6:Number = 0;
		public var cwt1:Number = 0;
		public var cwt2:Number = 0;
		public var cwt3:Number = 0;
		public var cwt4:Number = 0;
		public var cwt5:Number = 0;
		public var cwt6:Number = 0;
		public var markup1:Number = 0;
		public var markup2:Number = 0;
		public var markup3:Number = 0;
		public var markup4:Number = 0;
		public var markup5:Number = 0;
		public var markup6:Number = 0;
		public var listPerM1:int = 0;
		public var listPerM2:int = 0;
		public var listPerM3:int = 0;
		public var listPerM4:int = 0;
		public var listPerM5:int = 0;
		public var listPerM6:int = 0;
		public var normalRunSize:String = "";
		public var cutsPer100:int = 0;
		public var minCutCharge:Number = 0;
		public var defaultPress:PressDefinition;
		public var autoCalculateBlank:Boolean = true;
		public var blankSheetqty1:int = 0;
		public var blankSheetqty2:int = 0;
		public var blankSheetqty3:int = 0;
		public var blankSheetqty4:int = 0;
		public var blankSheetqty5:int = 0;
		public var blankSheetqty6:int = 0;
		public var blankSheetPrice1:Number = 0;
		public var blankSheetPrice2:Number = 0;
		public var blankSheetPrice3:Number = 0;
		public var blankSheetPrice4:Number = 0;
		public var blankSheetPrice5:Number = 0;
		public var blankSheetPrice6:Number = 0;
		public var defaultBW:String = "";
		public var defaultColor:String = "";
		public var defaultLargeFormat:String = "";
		public var additional1:String = "";
		public var additional2:String = "";
		public var additional3:String = "";
		public var additional4:String = "";
		public var additional5:String = "";
		public var additional6:String = "";
		public var additional7:String = "";
		public var additional8:String = "";
		public var additional9:String = "";
		public var additional10:String = "";
		public var standardItem:Boolean = true;
		public var onHand:int = 0;
		public var committed:int = 0;
		public var available:int = 0;
		public var onOrder:int = 0;
		public var targetLevel:int = 0;
		public var reOrderPoint:int = 0;
		public var minOrderQty:int = 0;
		public var evenIncrements:Boolean = true;
		public var expires:Date = new Date();
		public var binLocation:String = "";
		public var shellItem:Boolean = true;
		public var forestManagement:String = "";
		public var pcwRecycledPercent:Number = 0;
		public var fscCertified:Boolean = true;
		public var sfiCertified:Boolean = true;
		public var greenSealCertified:Boolean = true;
		public var defaultPriceList:PaperPrice;
		public var genericColor:GenericColors;
		public var account:Account;
		public var stockId:String = "";
		public var charges:ArrayCollection;
		public var copier1PricePerSheet:Number = 0;
		public var copier2PricePerSheet:Number = 0;
		public var copier3PricePerSheet:Number = 0;
		public var stockChanges:ArrayCollection;
		public var mill:int = 0;
		public var lotcount:int = 0;
		public var cartonWeight:Number = 0;
		public var sheetperSkid:int = 0;
		public var weightperSkid:Number = 0;
		public var shortgain:int = 0;
		public var noBrokenCarton:Boolean = true;
		public var pricedinSets:Boolean = true;
		public var imported:Boolean = true;
		public var measure:Boolean = true;
		public var allownegative:Boolean = true;
		public var rollWeight:Number = 0;
	
	}
}