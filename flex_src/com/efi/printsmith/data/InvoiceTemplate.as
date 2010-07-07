package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceTemplate")]
	[Managed]
	
	public dynamic class InvoiceTemplate extends InvoiceBase
	{

		public function InvoiceTemplate() {
			remoteObjectName = "com.efi.printsmith.data.InvoiceTemplate";
		}
				
		public var templateName:String = "";
	
	}
}