package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.Location")]
	[Managed]
	public class Location extends ModelBase
	{

		public function Location() {
			remoteObjectName = "com.efi.printsmith.data.Location";
		}
				
		public var name:String = "";
	
	}
}