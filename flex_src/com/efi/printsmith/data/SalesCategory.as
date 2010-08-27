package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SalesCategory")]
	[Managed]
	
	public dynamic class SalesCategory extends ModelBase
	{

		public function SalesCategory() {
			remoteObjectName = "com.efi.printsmith.data.SalesCategory";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
		public var glAccount:String = "";
	
	}
}