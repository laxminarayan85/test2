package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Invoice")]
	[Managed]
	
	public dynamic class Invoice extends InvoiceBase
	{

		public function Invoice() {
			remoteObjectName = "com.efi.printsmith.data.Invoice";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}