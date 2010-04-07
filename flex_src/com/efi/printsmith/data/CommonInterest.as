package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.CommonInterest")]

	public class CommonInterest extends ModelBase
	{

		public function CommonInterest() {
			remoteObjectName = "com.efi.printsmith.data.CommonInterest";
		}
				
		public var name:String = "";
	
	}
}