package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.DepositEntry")]

	public class DepositEntry extends ModelBase
	{

		public function DepositEntry() {
		
		}
		public var referenceNumber:String = "";
		public var date:Date = new Date();
		public var amount:Number = 0;
		public var type:DepositType = new DepositType();
		public var creditCardType:int = 0;
	
	}
}