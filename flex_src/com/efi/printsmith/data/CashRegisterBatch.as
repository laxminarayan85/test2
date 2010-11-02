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
		public var isDeleted:Boolean=false;
				
		public var transactions:ArrayCollection;
		public var name:String = "";
	
	}
}