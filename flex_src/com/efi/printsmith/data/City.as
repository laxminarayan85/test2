package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.City")]

	public class City extends ModelBase
	{

		public function City() {
			remoteObjectName = "com.efi.printsmith.data.City";
		}
				
		public var name:String = "";
	
	}
}