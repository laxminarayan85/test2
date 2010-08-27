package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Vendor")]
	[Managed]
	
	public dynamic class Vendor extends ModelBase
	{

		public function Vendor() {
			remoteObjectName = "com.efi.printsmith.data.Vendor";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}