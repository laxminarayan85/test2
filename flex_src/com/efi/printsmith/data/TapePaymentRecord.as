package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapePaymentRecord")]
	[Managed]
	
	public dynamic class TapePaymentRecord extends ModelBase
	{

		public function TapePaymentRecord() {
			remoteObjectName = "com.efi.printsmith.data.TapePaymentRecord";
		}
		public var isDeleted:Boolean=false;
				
		public var paymentMethod:String = "";
		public var refNumber:String = "";
		public var checkNumber:String = "";
		public var cct:CreditCardTransactions;
		public var invoice:Invoice;
		public var total:Number = 0;
		public var orRate:Boolean = false;
		public var opPrice:Boolean = false;
		public var taxExempt:Boolean = false;
		public var taxAmount:Number = 0;
		public var taxCode:TaxCodes;
		public var taxTable:TaxTable;
		public var isDeletedRecord:Boolean = false;
		public var amountBalance:Number = 0;
		public var changeAmount:Number = 0;
		public var refundAmount:Number = 0;
		public var subTotal:Number = 0;
	
	}
}