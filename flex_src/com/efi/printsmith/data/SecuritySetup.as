package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SecuritySetup")]
	[Managed]
	
	public dynamic class SecuritySetup extends ModelBase
	{

		public function SecuritySetup() {
			remoteObjectName = "com.efi.printsmith.data.SecuritySetup";
		}
		public var isDeleted:Boolean=false;
				
		public var accessGroup:AccessGroup;
		public var securityCmd:SecurityCommands;
	
	}
}