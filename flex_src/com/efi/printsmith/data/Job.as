package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Job")]
	[Managed]
	
	public dynamic class Job extends JobBase
	{

		public function Job() {
			remoteObjectName = "com.efi.printsmith.data.Job";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}