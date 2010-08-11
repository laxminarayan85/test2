package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CreditCard")]
	[Managed]
	
	public dynamic class CreditCard extends ModelBase
	{

		public function CreditCard() {
			remoteObjectName = "com.efi.printsmith.data.CreditCard";
		}
				
		public var cardHolderName:String = "";
		public var cardNumber:String = "";
		public var expiresDate:Date = new Date();
		public var address:Address;
		public var creditCardID:String = "";
		public var type:String = "";
		public var encryption:String = "";
		public var cardDisplayNumber:String = "";
	
	}
}