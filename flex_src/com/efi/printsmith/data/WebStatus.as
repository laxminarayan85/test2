package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.WebStatus")]

	public class WebStatus extends ModelBase
	{

		public function WebStatus() {
			remoteObjectName = "com.efi.printsmith.data.WebStatus";
		}
				
		public var name:int = 0;
	
	}
}