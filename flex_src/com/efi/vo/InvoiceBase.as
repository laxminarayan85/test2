package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceBase")]

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
		public var addressOverriden:Boolean = true;
		public var costed:Boolean = true;
		public var openNotesOnOpen:int = 0;
		public var completed:Boolean = true;
		public var priceLocked:Boolean = true;
		public var onPendingList:Boolean = true;
		public var locked:Boolean = true;
		public var taxShipping:Boolean = true;
		public var poRequired:Boolean = true;
		public var fileOriginals:Boolean = true;
		public var notTaxable:Boolean = true;
		public var firmWantedByDate:Boolean = true;
		public var releasedToProduction:Boolean = true;
		public var containsInventoriedStock:Boolean = true;
		public var discountIsDollars:Boolean = true;
		public var discountIsOneTime:Boolean = true;
	
	}
}