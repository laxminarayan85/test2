package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.JobMethod")]
	[Managed]
	
	public dynamic class JobMethod extends ModelBase
	{

		public function JobMethod() {
			remoteObjectName = "com.efi.printsmith.data.JobMethod";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}