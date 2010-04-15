package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.DataManager")]
	[Managed]
	
	public class DataManager extends ModelBase
	{

		public function DataManager() {
			remoteObjectName = "com.efi.printsmith.data.DataManager";
		}
				
		public var dataloaded:Boolean = false;
	
	}
}