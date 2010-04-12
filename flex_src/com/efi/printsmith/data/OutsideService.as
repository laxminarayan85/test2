package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.OutsideService")]
	[Managed]
	public class OutsideService extends PreferencesMarkups
	{

		public function OutsideService() {
			remoteObjectName = "com.efi.printsmith.data.OutsideService";
		}
				
	
	}
}