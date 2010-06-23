package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockOrder")]
	[Managed]
	
	public class StockOrder extends ModelBase
	{

		public function StockOrder() {
			remoteObjectName = "com.efi.printsmith.data.StockOrder";
		}
				
		public var name:String = "";
		public var stockUnit:int = 0;
		public var invoiceNumber:String = "";
		public var jobNumber:String = "";
		public var vendor:Vendor;
		public var orderNumber:String = "";
		public var color:StockColors;
		public var finish:StockFinish;
		public var coated:String = "";
		public var weight:Number = 0;
		public var sheetSize:String = "";
		public var cost:Number = 0;
		public var per:Number = 0;
		public var rollWeight:Number = 0;
		public var rollWidth:String = "";
		public var orderQuantity:int = 0;
		public var vendorStockNumber:String = "";
		public var stockOrderNumber:String = "";
		public var deliveryDate:Date = new Date();
		public var enterDate:Date = new Date();
		public var allowModifaction:Boolean = false;
		public var poNumber:String = "";
		public var customerName:String = "";
		public var receivedQuantity:int = 0;
		public var placed:Boolean = false;
		public var filled:Boolean = false;
	
	}
}