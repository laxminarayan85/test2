package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.City")]
	[Managed]
	
	public dynamic class City extends ModelBase
	{

		public function City() {
			remoteObjectName = "com.efi.printsmith.data.City";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}