package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesDefaultPresses")]

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