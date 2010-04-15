package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.CustomerLog")]
	[Managed]
	
	public class CustomerLog extends ModelBase
	{

		public function CustomerLog() {
			remoteObjectName = "com.efi.printsmith.data.CustomerLog";
		}
				
		public var logEntry:String = "";
	
	}
}