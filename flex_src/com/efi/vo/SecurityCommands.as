package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SecurityCommands")]

	public class SecurityCommands extends ModelBase
	{

		public function SecurityCommands() {
			remoteObjectName = "com.efi.printsmith.data.SecurityCommands";
		}
				
		public var menu:String = "";
		public var commandName:String = "";
	
	}
}