package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DailySales")]
	[Managed]
	
	public dynamic class DailySales extends ModelBase
	{

		public function DailySales() {
			remoteObjectName = "com.efi.printsmith.data.DailySales";
		}
		public var isDeleted:Boolean=false;
				
		public var salesCat:SalesCategory;
		public var subTotal:Number = 0;
		public var taxTable:TaxTable;
		public var taxCode:TaxCodes;
		public var taxAmount:Number = 0;
		public var totalAmount:Number = 0;
	
	}
}