package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebCompany")]
	[Managed]
	
	public dynamic class WebCompany extends ModelBase
	{

		public function WebCompany() {
			remoteObjectName = "com.efi.printsmith.data.WebCompany";
		}
				
		public var name:int = 0;
	
	}
}