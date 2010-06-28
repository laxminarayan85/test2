package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesAccounting")]
	[Managed]
	
	public dynamic class PreferencesAccounting extends ModelBase
	{

		public function PreferencesAccounting() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesAccounting";
		}
				
		public var creditLimit:Number = 0;
		public var financeChange:Number = 0;
		public var inactivePeriod:Number = 0;
		public var removeDraftsFromDeposit:Boolean = false;
		public var defaultSalesRep:String = "";
		public var defaultShipping:String = "";
		public var pastDue:int = 0;
		public var pastDueNote:String = "";
		public var delinquent:int = 0;
		public var delinquentNote:String = "";
		public var frozen:int = 0;
		public var frozenNote:String = "";
		public var activateCreditCardApproval:Boolean = false;
		public var invoicePrefix:String = "";
		public var invoiceDocument:String = "";
		public var invoiceSuffix:String = "";
		public var invoiceAllowPrefixMod:Boolean = false;
		public var invoiceAllowSuffixMod:Boolean = false;
		public var estimatePrefix:String = "";
		public var estimateDocument:String = "";
		public var estimateSuffix:String = "";
		public var estimateAllowPrefixMod:Boolean = false;
		public var estimateAllowSuffixMod:Boolean = false;
		public var printDocument:Boolean = false;
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
		public var useObsoleteDropFolder:Boolean = false;
		public var useSkipJackProcessor:Boolean = false;
		public var useEfsProcessor:Boolean = false;
		public var creditCardDropFolder:String = "";
		public var skipJackMode:int = 0;
		public var internetURL:String = "";
		public var serialNumber:String = "";
		public var developmentNumber:String = "";
		public var portNumber:String = "";
		public var merchantID:String = "";
		public var merchantKey:String = "";
		public var useAddressValidation:Boolean = false;
		public var promptUserForValidationInfo:Boolean = false;
		
		public var creditCardProcessor:String="";
	
	}
}