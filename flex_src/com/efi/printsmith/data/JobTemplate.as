package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.JobTemplate")]

	public class JobTemplate extends Job
	{

		public function JobTemplate() {
			remoteObjectName = "com.efi.printsmith.data.JobTemplate";
		}
				
		public var templateName:int = 0;
	
	}
}