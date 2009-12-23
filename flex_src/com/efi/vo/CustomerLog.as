package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CustomerLog")]

	public class CustomerLog extends ModelBase
	{

		public function CustomerLog() {
			remoteObjectName = "com.efi.printsmith.data.CustomerLog";
		}
				
		public var logEntry:String = "";
	
	}
}