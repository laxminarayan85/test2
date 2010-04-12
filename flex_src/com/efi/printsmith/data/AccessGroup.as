package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.AccessGroup")]
	[Managed]
	public class AccessGroup extends ModelBase
	{

		public function AccessGroup() {
			remoteObjectName = "com.efi.printsmith.data.AccessGroup";
		}
				
		public var name:String = "";
	
	}
}