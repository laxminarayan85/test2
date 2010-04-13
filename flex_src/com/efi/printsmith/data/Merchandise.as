package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Merchandise")]

	public class Merchandise extends PreferencesMarkups
	{

		public function Merchandise() {
			remoteObjectName = "com.efi.printsmith.data.Merchandise";
		}
				
	
	}
}