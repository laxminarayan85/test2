package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Estimate")]
	[Managed]
	
	public dynamic class Estimate extends InvoiceBase
	{

		public function Estimate() {
			remoteObjectName = "com.efi.printsmith.data.Estimate";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}