package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.AccountsReceivable")]
	[Managed]
	
	public dynamic class AccountsReceivable extends ModelBase
	{

		public function AccountsReceivable() {
			remoteObjectName = "com.efi.printsmith.data.AccountsReceivable";
		}
		public var isDeleted:Boolean=false;
				
		public var account:Account;
		public var transactionDate:Date = null;
		public var amount:Number = 0;
	
	}
}