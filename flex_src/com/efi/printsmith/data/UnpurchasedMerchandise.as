package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.UnpurchasedMerchandise")]
	[Managed]
	
	public dynamic class UnpurchasedMerchandise extends ModelBase
	{

		public function UnpurchasedMerchandise() {
			remoteObjectName = "com.efi.printsmith.data.UnpurchasedMerchandise";
		}
		public var isDeleted:Boolean=false;
				
		public var account:Account;
		public var transactionDate:Date = new Date();
		public var saleRecord:TapeSaleRecord;
		public var amountDue:Number = 0;
	
	}
}