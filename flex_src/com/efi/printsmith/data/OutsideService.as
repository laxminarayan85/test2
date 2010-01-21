package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.OutsideService")]

	public class OutsideService extends PreferencesMarkups
	{

		public function OutsideService() {
			remoteObjectName = "com.efi.printsmith.data.OutsideService";
		}
				
	
	}
}