package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Estimate")]

	public class Estimate extends InvoiceBase
	{

		public function Estimate() {
			remoteObjectName = "com.efi.printsmith.data.Estimate";
		}
				
	
	}
}