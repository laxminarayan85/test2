package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.WebCheckoutTypes")]
	[Managed]
	public class WebCheckoutTypes extends ModelBase
	{

		public function WebCheckoutTypes() {
			remoteObjectName = "com.efi.printsmith.data.WebCheckoutTypes";
		}
				
		public var name:String = "";
	
	}
}