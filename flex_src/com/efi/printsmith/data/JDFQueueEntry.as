package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JDFQueueEntry")]
	[Managed]
	
	public class JDFQueueEntry extends ModelBase
	{

		public function JDFQueueEntry() {
			remoteObjectName = "com.efi.printsmith.data.JDFQueueEntry";
		}
				
		public var message:String = "";
		public var response:String = "";
		public var sent:Date = new Date();
		public var status:String = "";
	
	}
}