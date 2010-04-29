package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DeliveryTicket")]
	[Managed]
	
	public class DeliveryTicket extends ModelBase
	{

		public function DeliveryTicket() {
			remoteObjectName = "com.efi.printsmith.data.DeliveryTicket";
		}
				
		public var name:String = "";
		public var ticketNumber:int = 0;
		public var toAddress:Address;
		public var fromAddress:Address;
		public var toAddressID:Number = 0;
		public var fromAddressID:Number = 0;
		public var deliveryContact:Contact;
		public var takenBy:String = "";
		public var deliveryDate:Date = new Date();
		public var customerPO:String = "";
		public var orderNumber:int = 0;
		public var trackingNumber:String = "";
		public var partNumber:String = "";
		public var reference:String = "";
		public var shipMode:ShippingMethod;
		public var shipCost:Number = 0;
		public var totalWeight:Number = 0;
		public var cartonCount:int = 0;
		public var itemsPerCarton:int = 0;
		public var totalItemsInCarton:int = 0;
		public var labelSkipCount:int = 0;
		public var preComment:String = "";
		public var postComment:String = "";
		public var labelStartCount:int = 0;
		public var driver:Driver;
		public var webOrderShippingID:Number = 0;
		public var fromOther:Boolean = false;
		public var toOther:Boolean = false;
		public var attOther:Boolean = false;
		public var oWeight:Boolean = false;
		public var cod:Boolean = false;
		public var emailOther:Boolean = false;
		public var email:String = "";
		public var archive:Boolean = false;
		public var attNameCheck:Boolean = false;
		public var customerNameCheck:Boolean = false;
		public var addressCheck:Boolean = false;
		public var orderNumberCheck:Boolean = false;
		public var deliveryDescCheck:Boolean = false;
		public var deliveryCommentsCheck:Boolean = false;
		public var poNumberCheck:Boolean = false;
		public var estWeightCheck:Boolean = false;
		public var dateType:String = "";
		public var deliveryJobs:ArrayCollection;
	
	}
}