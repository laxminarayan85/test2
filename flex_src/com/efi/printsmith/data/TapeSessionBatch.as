package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeSessionBatch")]
	[Managed]
	
	public dynamic class TapeSessionBatch extends ModelBase
	{

		public function TapeSessionBatch() {
			remoteObjectName = "com.efi.printsmith.data.TapeSessionBatch";
		}
		public var isDeleted:Boolean=false;
				
		public var paymentTransactions:ArrayCollection;
		public var name:String = "";
		public var accumSubTotal:Number = 0;
		public var accumTotal:Number = 0;
		public var accumTaxTotal:Number = 0;
		public var accumTendered:Number = 0;
		public var accumChange:Number = 0;
		public var salesTransactions:ArrayCollection;
		public var sessionID:Number = 0;
	
	}
}