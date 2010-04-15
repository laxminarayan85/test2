package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceBase")]
	[Managed]
	
	public class InvoiceBase extends ModelBase
	{

		public function InvoiceBase() {
			remoteObjectName = "com.efi.printsmith.data.InvoiceBase";
		}
				
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
		public var orderedDate:Date = new Date();
		public var wantedDate:Date = new Date();
		public var proofDate:Date = new Date();
		public var completedDate:Date = new Date();
		public var customerNotificationDate:Date = new Date();
		public var pickupDate:Date = new Date();
		public var reorderDate:Date = new Date();
		public var locationChangeDate:Date = new Date();
		public var deliveryIntentDate:Date = new Date();
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
		public var releasedToProduction:Boolean = false;
		public var priceTotal:Number = 0;
		public var containsInventoriedStock:Boolean = false;
		public var discountIsDollars:Boolean = false;
		public var discountIsOneTime:Boolean = false;
		public var takenBy:String = "";
		public var priceSubTotal:Number = 0;
		public var shipPrice:Number = 0;
		public var tax:Number = 0;
	
	}
}