package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebCompany")]

	public class WebCompany extends ModelBase
	{

		public function WebCompany() {
			remoteObjectName = "com.efi.printsmith.data.WebCompany";
		}
				
		public var name:int = 0;
	
	}
}