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
				
		public var account:Account;
		public var amount:Number = 0;
		public var transactionDate:Date = new Date();
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
		public var tax:Number = 0;
		public var subtotal:Number = 0;
	
	}
}