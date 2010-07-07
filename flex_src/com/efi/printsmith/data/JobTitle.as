package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JobTitle")]
	[Managed]
	
	public dynamic class JobTitle extends ModelBase
	{

		public function JobTitle() {
			remoteObjectName = "com.efi.printsmith.data.JobTitle";
		}
				
		public var name:String = "";
	
	}
}