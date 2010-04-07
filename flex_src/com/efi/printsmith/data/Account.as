package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Account")]
	[Managed]
	public class Account extends ModelBase
	{

		public function Account() {
			remoteObjectName = "com.efi.printsmith.data.Account";
		}
				
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
		public var dollarDiscount:Boolean = true;
		public var oneTimeDiscount:Boolean = true;
		public var fileOriginals:Boolean = true;
		public var webAccessEnabled:Boolean = true;
		public var prospect:Boolean = true;
		public var autoPayEnabled:Boolean = true;
		public var optOutMarketing:Boolean = true;
		public var acctIsIndividual:Boolean = true;
		public var taxExempt:Boolean = true;
		public var payCommissions:Boolean = true;
		public var poRequired:Boolean = true;
		public var applyFinanceCharges:Boolean = true;
		public var generateStatements:Boolean = true;
		public var externalRef:String = "";
		public var salesRep:SalesRep;
		public var shippingMode:ShippingMethod;
		public var lastInvoiceDate:Date = new Date();
		public var lastEstimateDate:Date = new Date();
		public var firstInvoiceDate:Date = new Date();
		public var firstEstimateDate:Date = new Date();
		public var lastAgedDate:Date = new Date();
		public var lastBilledDate:Date = new Date();
		public var marketing:Marketing;
		public var lastPaymentDate:Date = new Date();
		public var lastPostingDate:int = 0;
		public var lastRankingDate:Date = new Date();
		public var creditCardExpiration:Date = new Date();
		public var creditCardInfo:String = "";
		public var autoPayMode:Number = 0;
		public var autoPayInterval:Number = 0;
		public var creditCardType:String = "";
		public var autoPayMinimum:Number = 0;
		public var autoPayMaximum:Number = 0;
		public var autoPayTotal:Number = 0;
		public var autoPayAmount:Number = 0;
		public var autoPayStop:Date = new Date();
		public var autoPayStart:Date = new Date();
		public var autoPayLastPosted:Date = new Date();
		public var autoPayPaymentQty:Number = 0;
		public var lastNotifiedDate:Date = new Date();
		public var resaleCertExpirationDate:Date = new Date();
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
	
	}
}