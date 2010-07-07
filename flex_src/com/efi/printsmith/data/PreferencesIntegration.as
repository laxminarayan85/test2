package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesIntegration")]
	[Managed]
	
	public dynamic class PreferencesIntegration extends ModelBase
	{

		public function PreferencesIntegration() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesIntegration";
		}
				
		public var fieryConnectorURL:String = "";
	
	}
}