package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesAccounting")]

	public class PreferencesAccounting extends ModelBase
	{

		public function PreferencesAccounting() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesAccounting";
		}
				
		public var creditLimit:Number = 0;
		public var financeChange:Number = 0;
		public var inactivePeriod:Number = 0;
		public var removeDraftsFromDeposit:Boolean = true;
		public var defaultSalesRep:String = "";
		public var defaultShipping:String = "";
		public var pastDue:int = 0;
		public var pastDueNote:String = "";
		public var delinquent:int = 0;
		public var delinquentNote:String = "";
		public var frozen:int = 0;
		public var frozenNote:String = "";
		public var activateCreditCardApproval:Boolean = true;
		public var creditCardDropFolder:String = "";
		public var pollingInterval:int = 0;
		public var useAddressValidation:Boolean = true;
		public var promptUserForValidation:Boolean = true;
		public var invoicePrefix:String = "";
		public var invoiceDocument:String = "";
		public var invoiceSuffix:String = "";
		public var invoiceAllowPrefixMod:Boolean = true;
		public var invoiceAllowSuffixMod:Boolean = true;
		public var estimatePrefix:String = "";
		public var estimateDocument:String = "";
		public var estimateSuffix:String = "";
		public var estimateAllowPrefixMod:Boolean = true;
		public var estimateAllowSuffixMod:Boolean = true;
		public var printDocument:Boolean = true;
		public var journalDocumentPreference:String = "";
		public var accountingLinkTo:String = "";
		public var shippingCollected:String = "";
		public var actualBankDeposit:String = "";
		public var undepositedReceipts:String = "";
		public var discounts:String = "";
		public var salesTax:String = "";
		public var totalARReceipts:String = "";
		public var depositsOnInvoices:String = "";
		public var newChargesToAR:String = "";
		public var cashOverShort:String = "";
		public var paidOut:String = "";
		public var refundChecks:String = "";
	
	}
}