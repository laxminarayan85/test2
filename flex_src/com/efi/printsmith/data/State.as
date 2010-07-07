package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.State")]
	[Managed]
	
	public dynamic class State extends ModelBase
	{

		public function State() {
			remoteObjectName = "com.efi.printsmith.data.State";
		}
				
		public var name:String = "";
	
	}
}