package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SecuritySetup")]

	public class SecuritySetup extends ModelBase
	{

		public function SecuritySetup() {
			remoteObjectName = "com.efi.printsmith.data.SecuritySetup";
		}
				
		public var enable:Boolean = true;
		public var menu:String = "";
		public var commandId:String = "";
		public var commandName:String = "";
		public var accessGroup:AccessGroup;
	
	}
}