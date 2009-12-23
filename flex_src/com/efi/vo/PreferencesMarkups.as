package com.efi.vo
{
	import mx.collections.ArrayCollection; 
	import com.efi.vo.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesMarkups")]

	public class PreferencesMarkups extends ModelBase
	{

		public function PreferencesMarkups() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesMarkups";
		}
				
		public var totalCost:Number = 0;
		public var markup:Number = 0;
		public var above:Boolean = true;
	
	}
}