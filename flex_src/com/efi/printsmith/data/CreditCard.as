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
		public var isDeleted:Boolean=false;
				
		public var cardHolderName:String = "";
		public var cardNumber:String = "";
		public var expiresDate:Date = new Date();
		public var accountNumber:Number = 0;
		public var zipCode:String = "";
		public var address1:String = "";
		public var creditCardID:String = "";
		public var type:String = "";
		public var encryption:String = "";
		public var cardDisplayNumber:String = "";
		public var permanent:int = 0;
	
	}
}