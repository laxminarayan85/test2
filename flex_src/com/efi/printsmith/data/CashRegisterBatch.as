package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CashRegisterBatch")]
	[Managed]
	
	public dynamic class CashRegisterBatch extends ModelBase
	{

		public function CashRegisterBatch() {
			remoteObjectName = "com.efi.printsmith.data.CashRegisterBatch";
		}
				
		public var change:Number = 0;
		public var tendered:Number = 0;
		public var subTotal:Number = 0;
		public var quantity:Number = 0;
		public var taxAmount:Number = 0;
		public var totalPrice:Number = 0;
		public var transactions:ArrayCollection;
		public var name:String = "";
	
	}
}