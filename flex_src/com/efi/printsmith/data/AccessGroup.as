package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.AccessGroup")]
	[Managed]
	
	public dynamic class AccessGroup extends ModelBase
	{

		public function AccessGroup() {
			remoteObjectName = "com.efi.printsmith.data.AccessGroup";
		}
		public var isDeleted:Boolean=false;
				
		public var name:String = "";
	
	}
}