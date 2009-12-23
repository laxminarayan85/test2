package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Merchandise")]

	public class Merchandise extends PreferencesMarkups
	{

		public function Merchandise() {
			remoteObjectName = "com.efi.printsmith.data.Merchandise";
		}
				
	
	}
}