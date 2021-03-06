package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[RemoteClass(alias="com.efi.printsmith.data.PreferencesMarkups")]
	[Managed]
	
	public dynamic class PreferencesMarkups extends ModelBase
	{

		public function PreferencesMarkups() {
			remoteObjectName = "com.efi.printsmith.data.PreferencesMarkups";
		}
		public var isDeleted:Boolean=false;
				
		public var totalCost:Number = 0;
		public var markup:Number = 0;
		public var above:Boolean = false;
		public var markupType:int = 0;
	
	}
}