package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PaperPrice")]
	[Managed]
	
	public dynamic class PaperPrice extends Matrix
	{

		public function PaperPrice() {
			remoteObjectName = "com.efi.printsmith.data.PaperPrice";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}