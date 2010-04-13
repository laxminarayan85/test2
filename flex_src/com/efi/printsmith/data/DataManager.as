package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.DataManager")]

	public class DataManager extends ModelBase
	{

		public function DataManager() {
			remoteObjectName = "com.efi.printsmith.data.DataManager";
		}
				
		public var dataloaded:Boolean = false;
	
	}
}