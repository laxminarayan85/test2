package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockChange")]
	[Managed]
	
	public dynamic class StockChange extends ModelBase
	{

		public function StockChange() {
			remoteObjectName = "com.efi.printsmith.data.StockChange";
		}
		public var isDeleted:Boolean=false;
				
		public var stockChangeID:Number = 0;
		public var pSUser:String = "";
		public var stockChangeDate:Date = null;
		public var howChanged:String = "";
		public var quantity:int = 0;
		public var reference:String = "";
		public var stockDefinition:StockDefinition;
	
	}
}