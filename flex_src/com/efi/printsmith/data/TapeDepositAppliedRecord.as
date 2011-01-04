package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeDepositAppliedRecord")]
	[Managed]
	
	public dynamic class TapeDepositAppliedRecord extends Transaction
	{

		public function TapeDepositAppliedRecord() {
			remoteObjectName = "com.efi.printsmith.data.TapeDepositAppliedRecord";
		}
		public override var isDeleted:Boolean=false;
				
		public var totalDeposits:Number = 0;
		public var invoice:Invoice;
	
	}
}