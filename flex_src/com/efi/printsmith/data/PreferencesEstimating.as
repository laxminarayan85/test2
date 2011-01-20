package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesEstimating")]
	[Managed]
	
	public dynamic class PreferencesEstimating extends ModelBase
	{

		public function PreferencesEstimating() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesEstimating";
		}
		public var isDeleted:Boolean=false;
				
		public var folioLocation:String = "";
		public var gripLocation:String = "";
		public var closeAfterCopy:Boolean = false;
		public var stockCostInEstimator:Boolean = false;
		public var canChangeAddress:Boolean = false;
		public var showPaperCalculator:Boolean = false;
		public var useStockParentSize:Boolean = false;
		public var calculateReOrderDate:Boolean = false;
		public var validateSalesRep:Boolean = false;
		public var leaveFoldedSizeEmpty:Boolean = false;
		public var doNotCostDuringPost:Boolean = false;
		public var autoShowCharges:Boolean = false;
		public var neverUsePresetPressOnStockChanges:Boolean = false;
		public var addFixedWasteForEachPass:Boolean = false;
		public var addFixedWasteForEachColor:Boolean = false;
		public var calculateInkbyImpressions:Boolean = false;
		public var useHistoryTitleforNewTitle:Boolean = false;
		public var normalDueDateDays:int = 0;
		public var closeInvoiceAfterPrintingTicket:Boolean = false;
		public var closeInvoicesAndEstimateAfterPrinting:Boolean = false;
		public var defaultInvoice:int = 0;
		public var defaultEstimate:int = 0;
		public var numberOfDaysBeforeDue:int = 0;
		public var dueFrom:int = 0;
		public var useGripEdgeGap:Boolean = false;
		public var gripEdgeGap:Number = 0;
		public var useFolioEdge:Boolean = false;
		public var folioEdge:Number = 0;
		public var useColorBar:Boolean = false;
		public var colorBar:Number = 0;
		public var useWhiteSpace:Boolean = false;
		public var whiteSpace:Number = 0;
		public var whiteSpaceTop:Number = 0;
		public var whiteSpaceRight:Number = 0;
		public var whiteSpaceBottom:Number = 0;
		public var useGutter:Boolean = false;
		public var gutter:Number = 0;
		public var gutterHorizontal:Number = 0;
		public var useBleed:Boolean = false;
		public var bleed:Number = 0;
		public var bleedTop:Number = 0;
		public var bleedRight:Number = 0;
		public var bleedBottom:Number = 0;
		public var defaultPressCuttOff:Number = 0;
		public var backTrimParent:Boolean = false;
		public var backTrimRun:Boolean = false;
		public var workandTumble:Boolean = false;
		public var runToFinishGrain:String = "";
		public var printParentToFinishSection:Boolean = false;
		public var printParentToRunSection:Boolean = false;
		public var printRunToFinishSection:Boolean = false;
		public var attachToJobTicket:Boolean = false;
		public var jobTicketFormat:String = "";
		public var customJobTicket:String = "";
		public var chargeDescription:String = "";
		public var showAmountsOnTicket:Boolean = false;
		public var addBarCodes:Boolean = false;
		public var showRefNumber:Boolean = false;
		public var barCodeFont:FontDefinition;
		public var defaultHistoryView:Boolean = false;
		public var twoStageClearSearch:Boolean = false;
		public var fontStyle:String = "";
	
	}
}