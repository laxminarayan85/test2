package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesDefaultPresses")]
	[Managed]
	public class PreferencesDefaultPresses extends ModelBase
	{

		public function PreferencesDefaultPresses() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesDefaultPresses";
		}
				
		public var defaultBWCopier:CopierDefinition;
		public var defaultColorCopier:CopierDefinition;
		public var defaultLargeFormat:CopierDefinition;
		public var defaultRollFedPress:PressDefinition;
		public var defaultSheetFedPress:PressDefinition;
	
	}
}