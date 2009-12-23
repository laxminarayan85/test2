package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Invoice")]

	public class Invoice extends InvoiceBase
	{

		public function Invoice() {
			remoteObjectName = "com.efi.printsmith.data.Invoice";
		}
				
	
	}
}