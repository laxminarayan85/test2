package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.TaxElement")]
	[Managed]
	
	public dynamic class TaxElement extends ModelBase
	{

		public function TaxElement() {
			remoteObjectName = "com.efi.printsmith.data.TaxElement";
		}
		public var isDeleted:Boolean=false;
				
		public var rate:Number = 0;
		public var showTax:Boolean = false;
		public var userForSeparateShippingTax:Boolean = false;
		public var tax:TaxTablesElements;
		public var sequenceid:int = 0;
	
	}
}