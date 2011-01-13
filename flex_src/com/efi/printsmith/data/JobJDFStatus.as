package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JobJDFStatus")]
	[Managed]
	
	public dynamic class JobJDFStatus extends ModelBase
	{

		public function JobJDFStatus() {
			remoteObjectName = "com.efi.printsmith.data.JobJDFStatus";
		}
		public var isDeleted:Boolean=false;
				
		public var lastUpdated:Date = null;
		public var status:String = "";
		public var deviceId:String = "";
		public var queueId:String = "";
	
	}
}