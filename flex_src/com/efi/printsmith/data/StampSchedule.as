package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.StampSchedule")]
	[Managed]
	
	public dynamic class StampSchedule extends Matrix
	{

		public function StampSchedule() {
			remoteObjectName = "com.efi.printsmith.data.StampSchedule";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}