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
				
		public var transactions:ArrayCollection;
		public var name:String = "";
		public var accumSubTotal:Number = 0;
		public var accumTotal:Number = 0;
		public var accumTaxTotal:Number = 0;
		public var accumTendered:Number = 0;
		public var accumChange:Number = 0;
		public var sessionID:Number = 0;
		public var roundAmount:Number = 0;
		public var user:Users;
		public var workstation:String = "";
		public var account:Account;
		public var isVoided:Boolean = false;
		public var refundMethod:String = "";
		public var isPOSbatch:Boolean = false;
	
	}
}