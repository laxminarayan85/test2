package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.Merchandise")]
	[Managed]
	
	public dynamic class Merchandise extends PreferencesMarkups
	{

		public function Merchandise() {
			remoteObjectName = "com.efi.printsmith.data.Merchandise";
		}
		public override var isDeleted:Boolean=false;
				
	
	}
}