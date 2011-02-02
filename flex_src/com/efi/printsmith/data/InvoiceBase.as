package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceBase")]
	[Managed]
	
	public dynamic class InvoiceBase extends ModelBase
	{

		public function InvoiceBase() {
			remoteObjectName = "com.efi.printsmith.data.InvoiceBase";
		}
		public var isDeleted:Boolean=false;
				
		public var invoiceNumber:String = "";
		public var version:Number = 0;
		public var name:String = "";
		public var salesRep:SalesRep;
		public var customerPO:String = "";
		public var expenseCode:String = "";
		public var billToAddress:Address;
		public var shipToAddress:Address;
		public var contact:Contact;
		public var salesCode:String = "";
		public var resaleId:String = "";
		public var shippingMethod:ShippingMethod;
		public var printCount:Number = 0;
		public var account:Account;
		public var jobs:ArrayCollection;
		public var charges:ArrayCollection;
		public var markupCharges:ArrayCollection;
		public var specialInstructions:SpecialInstructions;
		public var notes:NotePad;
		public var holdState:HoldState;
		public var orderedDate:Date = null;
		public var wantedDate:Date = null;
		public var proofDate:Date = null;
		public var completedDate:Date = null;
		public var customerNotificationDate:Date = null;
		public var pickupDate:Date = null;
		public var reorderDate:Date = null;
		public var locationChangeDate:Date = null;
		public var deliveryIntentDate:Date = null;
		public var shipCharges:Number = 0;
		public var markups:Number = 0;
		public var discountFactor:Number = 0;
		public var dollarDiscount:Number = 0;
		public var discount:Number = 0;
		public var taxTable:TaxTable;
		public var subTotal:Number = 0;
		public var grandTotal:Number = 0;
		public var amountDue:Number = 0;
		public var totalCost:Number = 0;
		public var addressOverriden:Boolean = false;
		public var costed:Boolean = false;
		public var openNotesOnOpen:int = 0;
		public var completed:Boolean = false;
		public var priceLocked:Boolean = false;
		public var onPendingList:Boolean = false;
		public var locked:Boolean = false;
		public var taxShipping:Boolean = false;
		public var poRequired:Boolean = false;
		public var fileOriginals:Boolean = false;
		public var notTaxable:Boolean = false;
		public var firmWantedByDate:Boolean = false;
		public var priceTotal:Number = 0;
		public var containsInventoriedStock:Boolean = false;
		public var discountIsDollars:Boolean = false;
		public var discountIsOneTime:Boolean = false;
		public var takenBy:String = "";
		public var priceSubTotal:Number = 0;
		public var shipPrice:Number = 0;
		public var tax:Number = 0;
		public var releasedToProduction:Boolean = false;
		public var oldEstimateNumber:String = "";
		public var oldInvoiceNumber:String = "";
		public var convertedInvoiceNo:String = "";
		public var offPendingDate:Date = null;
		public var estimateNotes:String = "";
		public var status:String = "";
		public var readyToPickup:Boolean = false;
		public var taxCode:TaxCodes;
		public var creditCard:CreditCard;
		public var webPaymentAmount:Number = 0;
		public var webPaymentAuthWaiting:Boolean = false;
		public var webPaymentComplete:Boolean = false;
		public var webPaymentApprovalCode:String = "";
		public var webPaymentType:String = "";
		public var invoiceNumberPrefix:String = "";
		public var invoiceNumberSuffix:String = "";
		public var deposits:ArrayCollection;
		public var accountHistoryData:AccountHistoryData;
		public var taxRate:Number = 0;
		public var actualSubtotal:Number = 0;
		public var taxableSubtotal:Number = 0;
		public var discountableSubtotal:Number = 0;
		public var voided:Boolean = false;
	
	}
}