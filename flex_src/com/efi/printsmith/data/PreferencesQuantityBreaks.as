package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesQuantityBreaks")]

	public class PreferencesQuantityBreaks extends ModelBase
	{

		public function PreferencesQuantityBreaks() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesQuantityBreaks";
		}
				
		public var quantity:int = 0;
		public var qtyBreak:Boolean = false;
		public var jobMethod:JobMethod;
	
	}
}