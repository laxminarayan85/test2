package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceTemplate")]

	public class InvoiceTemplate extends InvoiceBase
	{

		public function InvoiceTemplate() {
			remoteObjectName = "com.efi.printsmith.data.InvoiceTemplate";
		}
				
	
	}
}