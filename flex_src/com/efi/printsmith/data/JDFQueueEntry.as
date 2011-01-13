package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JDFQueueEntry")]
	[Managed]
	
	public dynamic class JDFQueueEntry extends ModelBase
	{

		public function JDFQueueEntry() {
			remoteObjectName = "com.efi.printsmith.data.JDFQueueEntry";
		}
		public var isDeleted:Boolean=false;
				
		public var message:String = "";
		public var response:String = "";
		public var sent:Date = null;
		public var status:String = "";
		public var url:String = "";
		public var jobid:Number = 0;
		public var deviceId:String = "";
		public var msgType:String = "";
	
	}
}