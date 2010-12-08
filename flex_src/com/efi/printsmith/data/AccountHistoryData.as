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
		public var invoice:InvoiceBase;
		public var financeCharge:int = 0;
		public var storeNumber:String = "";
		public var postedDate:Date = new Date();
		public var paymentDueDate:Date = new Date();
		public var finalPaymentDate:Date = new Date();
		public var subTotalPosted:Number = 0;
		public var total:Number = 0;
		public var refundTotal:Number = 0;
		public var balance:Number = 0;
		public var recordType:String = "";
		public var partialPay:TapePaymentRecord;
		public var partialPayCnt:Number = 0;
		public var partialPayTotal:Number = 0;
		public var finalPay:TapePaymentRecord;
		public var taxDetail:TaxTable;
		public var webReferenceID:Number = 0;
		public var storeNum:String = "";
		public var custPO:String = "";
		public var salesRep:SalesRep;
		public var orderNoDisplay:String = "";
	
	}
}