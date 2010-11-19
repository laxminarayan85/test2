package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Transaction")]
	[Managed]
	
	public dynamic class Transaction extends ModelBase
	{

		public function Transaction() {
			remoteObjectName = "com.efi.printsmith.data.Transaction";
		}
		public var isDeleted:Boolean=false;
				
		public var taxAmount:Number = 0;
		public var taxCode:TaxCodes;
		public var taxExempt:Boolean = false;
		public var taxTable:TaxTable;
		public var isDeletedRecord:Boolean = false;
		public var index:int = 0;
		public var checkNumber:String = "";
		public var subTotal:Number = 0;
		public var refNumber:String = "";
		public var cct:CreditCardTransactions;
		public var accountHistoryData:AccountHistoryData;
	
	}
}