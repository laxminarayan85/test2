package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SecurityCommands")]
	[Managed]
	public class SecurityCommands extends ModelBase
	{

		public function SecurityCommands() {
			remoteObjectName = "com.efi.printsmith.data.SecurityCommands";
		}
				
		public var menu:String = "";
		public var commandName:String = "";
		public var commandId:String = "";
	
	}
}