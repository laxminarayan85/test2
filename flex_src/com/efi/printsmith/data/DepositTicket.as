package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DepositTicket")]
	[Managed]
	
	public dynamic class DepositTicket extends ModelBase
	{

		public function DepositTicket() {
			remoteObjectName = "com.efi.printsmith.data.DepositTicket";
		}
		public var isDeleted:Boolean=false;
				
		public var type:String = "";
		public var ref:String = "";
		public var creditCardType:String = "";
		public var amount:Number = 0;
		public var checkNum:int = 0;
	
	}
}