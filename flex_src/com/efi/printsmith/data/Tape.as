package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Tape")]
	[Managed]
	
	public dynamic class Tape extends ModelBase
	{

		public function Tape() {
			remoteObjectName = "com.efi.printsmith.data.Tape";
		}
		public var isDeleted:Boolean=false;
				
		public var transactionDate:Date = new Date();
		public var status:String = "";
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
		public var taxAmount:Number = 0;
		public var type:String = "";
		public var checkNum:String = "";
		public var ref:String = "";
		public var subTotal:Number = 0;
		public var total:Number = 0;
		public var pos:Boolean = false;
		public var ar:Boolean = false;
		public var paymentAmount:Number = 0;
	
	}
}