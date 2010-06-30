package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Merchandise")]
	[Managed]
	
	public class Merchandise extends PreferencesMarkups
	{

		public function Merchandise() {
			remoteObjectName = "com.efi.printsmith.data.Merchandise";
		}
				
	
	}
}