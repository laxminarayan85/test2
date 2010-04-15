package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CashRegister")]
	[Managed]
	
	public class CashRegister extends ModelBase
	{

		public function CashRegister() {
			remoteObjectName = "com.efi.printsmith.data.CashRegister";
		}
				
		public var customerAccount:Account;
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
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
		public var creditCard:PreferencesCreditCard;
		public var refNumber:String = "";
		public var paymentAmount:Number = 0;
		public var checkNumber:String = "";
	
	}
}