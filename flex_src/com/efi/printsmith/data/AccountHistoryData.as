package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.AccountHistoryData")]
	[Managed]
	
	public dynamic class AccountHistoryData extends ModelBase
	{

		public function AccountHistoryData() {
			remoteObjectName = "com.efi.printsmith.data.AccountHistoryData";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var account:Account;
		public var journal:Journal;
		public var invoice:Invoice;
		public var payments:TapePaymentRecord;
		public var financeCharge:int = 0;
		public var depositTaken:int = 0;
		public var depositRefund:int = 0;
		public var storeNumber:String = "";
		public var postedDate:Date = new Date();
		public var paymentDueDate:Date = new Date();
		public var finalPaymentDate:Date = new Date();
		public var subTotalPosted:Number = 0;
		public var total:Number = 0;
		public var refundTotal:Number = 0;
		public var balance:Number = 0;
	
	}
}