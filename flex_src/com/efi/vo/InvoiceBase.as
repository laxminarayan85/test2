package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceBase")]

	public class InvoiceBase extends ModelBase
	{

		public function InvoiceBase() {
		
		}
		public var invoiceNumber:String = "";
		public var version:Number = 0;
		public var name:String = "";
		public var salesRep:SalesRep = new SalesRep();
		public var customerPO:String = "";
		public var expenseCode:String = "";
		public var billToAddress:Address = new Address();
		public var shipToAddress:Address = new Address();
		public var contact:Contact = new Contact();
		public var salesCode:String = "";
		public var resaleId:String = "";
		public var shippingMethod:ShippingMethod = new ShippingMethod();
		public var printCount:Number = 0;
		public var account:Account = new Account();
		public var jobs:ArrayCollection;
		public var charges:ArrayCollection;
		public var markupCharges:ArrayCollection;
		public var specialInstructions:SpecialInstructions = new SpecialInstructions();
		public var notes:ArrayCollection;
		public var holdState:HoldState = new HoldState();
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
		public var taxTable:TaxTable = new TaxTable();
		public var subTotal:Number = 0;
		public var grandTotal:Number = 0;
		public var amountDue:Number = 0;
		public var totalCost:Number = 0;
	
	}
}