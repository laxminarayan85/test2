package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebLocations")]
	[Managed]
	public class WebLocations extends ModelBase
	{

		public function WebLocations() {
			remoteObjectName = "com.efi.printsmith.data.WebLocations";
		}
				
		public var name:String = "";
		public var key:String = "";
	
	}
}