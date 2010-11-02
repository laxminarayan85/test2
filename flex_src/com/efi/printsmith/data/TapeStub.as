package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapeStub")]
	[Managed]
	
	public dynamic class TapeStub extends ModelBase
	{

		public function TapeStub() {
			remoteObjectName = "com.efi.printsmith.data.TapeStub";
		}
		public var isDeleted:Boolean=false;
				
		public var batchNumber:Number = 0;
		public var isDeletedStub:Boolean = false;
		public var isVoided:Boolean = false;
		public var receiptPrint:Boolean = false;
		public var isHeader:Boolean = false;
		public var isDetail:Boolean = false;
		public var pos:Boolean = false;
		public var ar:Boolean = false;
		public var description:String = "";
		public var user:Users;
		public var account:Account;
		public var contact:Contact;
		public var memo:Journal;
		public var arRecord:int = 0;
		public var recordType:String = "";
		public var typeID:Number = 0;
	
	}
}