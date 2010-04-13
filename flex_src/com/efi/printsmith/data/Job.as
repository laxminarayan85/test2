package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Job")]

	public class Job extends JobBase
	{

		public function Job() {
			remoteObjectName = "com.efi.printsmith.data.Job";
		}
				
	
	}
}