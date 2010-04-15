package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JobTemplate")]
	[Managed]
	
	public class JobTemplate extends Job
	{

		public function JobTemplate() {
			remoteObjectName = "com.efi.printsmith.data.JobTemplate";
		}
				
		public var templateName:int = 0;
		public var user:Users;
		public var shared:Boolean = false;
		public var account:Account;
	
	}
}