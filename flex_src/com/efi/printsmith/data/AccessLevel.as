package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.AccessLevel")]
	[Managed]
	public class AccessLevel extends ModelBase
	{

		public function AccessLevel() {
			remoteObjectName = "com.efi.printsmith.data.AccessLevel";
		}
				
		public var name:String = "";
	
	}
}