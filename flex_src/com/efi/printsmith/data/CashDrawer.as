package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CashDrawer")]
	[Managed]
	
	public dynamic class CashDrawer extends ModelBase
	{

		public function CashDrawer() {
			remoteObjectName = "com.efi.printsmith.data.CashDrawer";
		}
		public var isDeleted:Boolean=false;
				
		public var amount:Number = 0;
		public var transactionDate:Date = new Date();
		public var held:Boolean = false;
		public var fund:Number = 0;
		public var checkCount:int = 0;
		public var cardCount:int = 0;
		public var checkTotal:Number = 0;
		public var cardTotal:Number = 0;
		public var cashTotal:Number = 0;
		public var arBalance:Number = 0;
		public var changeFund:Number = 0;
		public var paidOuts:Number = 0;
		public var lastCloseOutDate:Date = new Date();
		public var lastStartupDate:Date = new Date();
		public var prevArBalance:Number = 0;
	
	}
}