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
				
		public var amount:Number = 0;
		public var transactionDate:Date = new Date();
		public var held:Boolean = false;
		public var fund:Number = 0;
	
	}
}