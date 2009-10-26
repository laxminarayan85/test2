package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesEstimating")]

	public class PreferencesEstimating extends ModelBase
	{

		public function PreferencesEstimating() {
		
		}
		public var closeAfterCopy:Boolean = true;
		public var stockCostInEstimator:Boolean = true;
		public var canChangeAddress:Boolean = true;
		public var showPaperCalculator:Boolean = true;
		public var useStockParentSize:Boolean = true;
		public var calculateReOrderDate:Boolean = true;
		public var validateSalesRep:Boolean = true;
		public var leaveFoldedSizeEmpty:Boolean = true;
		public var doNotCostDuringPost:Boolean = true;
		public var autoShowCharges:Boolean = true;
		public var showSinglePassWorkTurnOptions:Boolean = true;
		public var neverUsePresetPressOnStockChanges:Boolean = true;
		public var addFixedWasteForEachPass:Boolean = true;
		public var addFixedWasteForEachColor:Boolean = true;
		public var calculateInkbyImpressions:Boolean = true;
		public var useHistoryTitleforNewTitle:Boolean = true;
		public var normalDueDateDays:int = 0;
		public var closeInvoiceAfterPrintingTicket:Boolean = true;
		public var closeInvoicesAndEstimateAfterPrinting:Boolean = true;
		public var defaultInvoice:int = 0;
		public var defaultEstimate:int = 0;
		public var numberOfDaysBeforeDue:int = 0;
		public var dueFrom:int = 0;
		public var useGripEdgeGap:Boolean = true;
		public var gripEdgeGap:Number = 0;
		public var useFolioEdge:Boolean = true;
		public var folioEdge:Number = 0;
		public var useColorBar:Boolean = true;
		public var colorBar:Number = 0;
		public var useWhiteSpace:Boolean = true;
		public var whiteSpace:Number = 0;
		public var whiteSpaceTop:Number = 0;
		public var whiteSpaceRight:Number = 0;
		public var whiteSpaceBottom:Number = 0;
		public var useGutter:Boolean = true;
		public var gutter:Number = 0;
		public var gutterHorizontal:Number = 0;
		public var useBleed:Boolean = true;
		public var bleed:Number = 0;
		public var bleedTop:Number = 0;
		public var bleedRight:Number = 0;
		public var bleedBottom:Number = 0;
		public var defaultPressCuttOff:Number = 0;
		public var backTrimParent:Boolean = true;
		public var trimFourSides:Boolean = true;
		public var workandTumble:Boolean = true;
		public var runToFinishGrain:String = "";
		public var printParentToFinishSection:Boolean = true;
		public var printParentToRunSection:Boolean = true;
		public var printRunToFinishSection:Boolean = true;
		public var attachToJobTicket:Boolean = true;
		public var jobTicketFormat:String = "";
		public var customJobTicket:String = "";
		public var showAmountOnTicket:Boolean = true;
		public var addTrackingBarCode:Boolean = true;
		public var showCustomerReferenceNumber:Boolean = true;
		public var chargeDescription:String = "";
	
	}
}