package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DataManager")]
	[Managed]
	
	public dynamic class DataManager extends ModelBase
	{

		public function DataManager() {
			remoteObjectName = "com.efi.printsmith.data.DataManager";
		}
		public var isDeleted:Boolean=false;
				
		public var dataloaded:Boolean = false;
	
	}
}