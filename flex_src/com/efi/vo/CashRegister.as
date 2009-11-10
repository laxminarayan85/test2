package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CashRegister")]

	public class CashRegister extends ModelBase
	{

		public function CashRegister() {
		
		}
		public var customerAccount:Account = new Account();
		public var taxTable:TaxTable = new TaxTable();
		public var taxCode:TaxCodes = new TaxCodes();
		public var quantity:Number = 0;
		public var unitprice:Number = 0;
		public var totalprice:Number = 0;
		public var description:String = "";
		public var invoiceFormat:String = "";
		public var paymentMethod:String = "";
		public var subtotal:Number = 0;
		public var taxamount:Number = 0;
		public var tendered:Number = 0;
		public var change:Number = 0;
		public var creditCard:PreferencesCreditCard = new PreferencesCreditCard();
		public var refNumber:String = "";
		public var paymentAmount:Number = 0;
		public var checkNumber:String = "";
	
	}
}