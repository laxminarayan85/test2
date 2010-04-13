package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Invoice")]

	public class Invoice extends InvoiceBase
	{

		public function Invoice() {
			remoteObjectName = "com.efi.printsmith.data.Invoice";
		}
				
	
	}
}