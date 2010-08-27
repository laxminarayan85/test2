package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Zip")]
	[Managed]
	
	public dynamic class Zip extends ModelBase
	{

		public function Zip() {
			remoteObjectName = "com.efi.printsmith.data.Zip";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}