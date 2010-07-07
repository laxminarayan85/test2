package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Broker")]
	[Managed]
	
	public dynamic class Broker extends Party
	{

		public function Broker() {
			remoteObjectName = "com.efi.printsmith.data.Broker";
		}
				
		public var brokerId:String = "";
	
	}
}