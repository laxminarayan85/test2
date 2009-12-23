package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CreditCard")]

	public class CreditCard extends ModelBase
	{

		public function CreditCard() {
			remoteObjectName = "com.efi.printsmith.data.CreditCard";
		}
				
		public var cardHolderName:String = "";
		public var cardNumber:String = "";
		public var expiresDate:Date = new Date();
		public var address:Address;
		public var creditCardID:int = 0;
		public var type:String = "";
	
	}
}