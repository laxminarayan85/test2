package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Account")]
	[Managed]
	
	public dynamic class Account extends ModelBase
	{

		public function Account() {
			remoteObjectName = "com.efi.printsmith.data.Account";
		}
		public var isDeleted:Boolean=false;
				
		public var status:String = "";
		public var masterAcct:Number = 0;
		public var resaleNumber:String = "";
		public var title:String = "";
		public var customerPO:String = "";
		public var shipToAddress:Address;
		public var billToAddress:Address;
		public var contact:Contact;
		public var billToContact:Contact;
		public var salesRank:Number = 0;
		public var userAcctId:String = "";
		public var externalAcctId:String = "";
		public var dollarDiscount:Boolean = false;
		public var oneTimeDiscount:Boolean = false;
		public var fileOriginals:Boolean = false;
		public var webAccessEnabled:Boolean = false;
		public var prospect:Boolean = false;
		public var autoPayEnabled:Boolean = false;
		public var optOutMarketing:Boolean = false;
		public var acctIsIndividual:Boolean = false;
		public var taxExempt:Boolean = false;
		public var payCommissions:Boolean = false;
		public var poRequired:Boolean = false;
		public var applyFinanceCharges:Boolean = false;
		public var generateStatements:Boolean = false;
		public var externalRef:String = "";
		public var salesRep:SalesRep;
		public var shippingMode:ShippingMethod;
		public var lastInvoiceDate:Date = null;
		public var lastEstimateDate:Date = null;
		public var firstInvoiceDate:Date = null;
		public var firstEstimateDate:Date = null;
		public var lastAgedDate:Date = null;
		public var lastBilledDate:Date = null;
		public var marketing:Marketing;
		public var lastPaymentDate:Date = null;
		public var lastPostingDate:Date = null;
		public var lastRankingDate:Date = null;
		public var creditCardExpiration:Date = null;
		public var creditCardInfo:String = "";
		public var autoPayMode:Number = 0;
		public var autoPayInterval:Number = 0;
		public var creditCardType:String = "";
		public var autoPayMinimum:Number = 0;
		public var autoPayMaximum:Number = 0;
		public var autoPayTotal:Number = 0;
		public var autoPayAmount:Number = 0;
		public var autoPayStop:Date = null;
		public var autoPayStart:Date = null;
		public var autoPayLastPosted:Date = null;
		public var autoPayPaymentQty:Number = 0;
		public var lastNotifiedDate:Date = null;
		public var resaleCertExpirationDate:Date = null;
		public var onAccount:Number = 0;
		public var balance:Number = 0;
		public var salesMonth:Number = 0;
		public var ordersMonth:Number = 0;
		public var salesYear:Number = 0;
		public var salesPriorYear:Number = 0;
		public var ordersYear:Number = 0;
		public var ordersTotal:Number = 0;
		public var estimateCount:Number = 0;
		public var creditLimit:Number = 0;
		public var discount:Number = 0;
		public var termsNet:Number = 0;
		public var termsDiscount:Number = 0;
		public var financeRate:Number = 0;
		public var financeYear:Number = 0;
		public var estimatesWon:Number = 0;
		public var estimatesLost:Number = 0;
		public var discountDollarAmt:Number = 0;
		public var balance30Day:Number = 0;
		public var balance60Day:Number = 0;
		public var balance90Day:Number = 0;
		public var balanceCurrent:Number = 0;
		public var type:String = "";
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
		public var statementNote:String = "";
		public var jobNote:String = "";
		public var accountNote:String = "";
		public var accountId:String = "";
		public var invoiceEstimateCharges:ArrayCollection;
		public var jobCharges:ArrayCollection;
		public var webRegistered:Boolean = false;
		public var webCompanyId:WebCompany;
		public var webCatalog:WebCatalogs;
		public var access_level:int = 0;
		public var walkIn:Boolean = false;
	
	}
}