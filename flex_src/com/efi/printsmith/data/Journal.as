package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Journal")]
	[Managed]
	
	public dynamic class Journal extends ModelBase
	{

		public function Journal() {
			remoteObjectName = "com.efi.printsmith.data.Journal";
		}
				
		public var account:Account;
		public var invoice:Invoice;
		public var salesCat:SalesCategory;
		public var name:String = "";
		public var status:String = "";
		public var taxable:Boolean = false;
		public var balance:Number = 0;
		public var subtotal:Number = 0;
		public var tax:Number = 0;
		public var total:Number = 0;
		public var taxtable:TaxTable;
		public var comment:String = "";
		public var description:String = "";
		public var salesRep:Boolean = false;
		public var affectSales:int = 0;
		public var customerStats:Boolean = false;
	
	}
}