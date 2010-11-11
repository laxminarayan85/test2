package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeSaleRecord")]
	[Managed]
	
	public dynamic class TapeSaleRecord extends Transactions
	{

		public function TapeSaleRecord() {
			remoteObjectName = "com.efi.printsmith.data.TapeSaleRecord";
		}
		public override var isDeleted:Boolean=false;
				
		public var isPickup:Boolean = false;
		public var opPrice:Boolean = false;
		public var orRate:Boolean = false;
		public var cashRegisterDept:PreferencesCashRegister;
		public var unitPrice:Number = 0;
		public var total:Number = 0;
		public var amountPaid:Number = 0;
		public var quantity:Number = 0;
		public var department:String = "";
		public var paymode:String = "";
		public var salesCategory:SalesCategory;
		public var invoice:Invoice;
		public var accountHistoryData:AccountHistoryData;
		public var contact:Contact;
	
	}
}