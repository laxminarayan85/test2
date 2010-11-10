package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DeliveryTicketJobs")]
	[Managed]
	
	public dynamic class DeliveryTicketJobs extends ModelBase
	{

		public function DeliveryTicketJobs() {
			remoteObjectName = "com.efi.printsmith.data.DeliveryTicketJobs";
		}
		public var isDeleted:Boolean=false;
				
		public var account:Account;
		public var orderNumber:int = 0;
		public var documentType:String = "";
		public var description:String = "";
		public var jobNumber:Number = 0;
		public var lineNumber:int = 0;
		public var qtyOrder:int = 0;
		public var qtyShipped:int = 0;
		public var weight:Number = 0;
		public var completed:Boolean = false;
		public var manualNonInvoiceItem:Boolean = false;
		public var parentDeliveryTicket:DeliveryTicket;
		public var invoiceNumber:String = "";
		public var invoiceId:Number = 0;
		public var jobId:Number = 0;
		public var jobBase:JobBase;
		public var weightUpdated:Boolean = false;
	
	}
}