package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.SecurityCommands")]
	[Managed]
	
	public dynamic class SecurityCommands extends ModelBase
	{

		public function SecurityCommands() {
			remoteObjectName = "com.efi.printsmith.data.SecurityCommands";
		}
		public var isDeleted:Boolean=false;
				
		public var menu:String = "";
		public var commandName:String = "";
		public var commandId:String = "";
	
	}
}