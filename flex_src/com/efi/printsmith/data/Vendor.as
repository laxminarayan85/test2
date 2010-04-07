package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Vendor")]
	[Managed]
	public class Vendor extends ModelBase
	{

		public function Vendor() {
			remoteObjectName = "com.efi.printsmith.data.Vendor";
		}
				
		public var name:String = "";
	
	}
}