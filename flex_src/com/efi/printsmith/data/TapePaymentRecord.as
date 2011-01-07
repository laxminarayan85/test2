package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TapePaymentRecord")]
	[Managed]
	
	public dynamic class TapePaymentRecord extends Transaction
	{

		public function TapePaymentRecord() {
			remoteObjectName = "com.efi.printsmith.data.TapePaymentRecord";
		}
		public override var isDeleted:Boolean=false;
				
		public var paymentMethod:String = "";
		public var invoice:InvoiceBase;
		public var total:Number = 0;
		public var orRate:Boolean = false;
		public var opPrice:Boolean = false;
		public var amountBalance:Number = 0;
		public var changeAmount:Number = 0;
		public var refundAmount:Number = 0;
		public var postAR:Boolean = false;
		public var isPaidOut:int = 0;
	
	}
}