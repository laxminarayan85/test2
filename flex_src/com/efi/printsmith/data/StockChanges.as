package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StockChanges")]
	[Managed]
	
	public class StockChanges extends ModelBase
	{

		public function StockChanges() {
			remoteObjectName = "com.efi.printsmith.data.StockChanges";
		}
				
		public var stockChangeID:Number = 0;
		public var pSUser:String = "";
		public var stockChangeDate:Date = new Date();
		public var howChanged:String = "";
		public var quantity:int = 0;
		public var reference:String = "";
		public var stockDefinition:StockDefinition;
	
	}
}