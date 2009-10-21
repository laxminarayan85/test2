package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SecuritySetup")]

	public class SecuritySetup extends ModelBase
	{

		public function SecuritySetup() {
		
		}
		public var enable:Boolean = true;
		public var menu:String = "";
		public var commandName:String = "";
		public var accessGroup:ArrayCollection;
	
	}
}