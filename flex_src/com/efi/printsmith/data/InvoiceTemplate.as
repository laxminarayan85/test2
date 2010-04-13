package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.InvoiceTemplate")]

	public class InvoiceTemplate extends InvoiceBase
	{

		public function InvoiceTemplate() {
			remoteObjectName = "com.efi.printsmith.data.InvoiceTemplate";
		}
				
		public var templateName:String = "";
	
	}
}