package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DepositEntry")]
	[Managed]
	
	public class DepositEntry extends ModelBase
	{

		public function DepositEntry() {
			remoteObjectName = "com.efi.printsmith.data.DepositEntry";
		}
				
		public var referenceNumber:String = "";
		public var date:Date = new Date();
		public var amount:Number = 0;
		public var type:DepositType;
		public var creditCardType:int = 0;
	
	}
}