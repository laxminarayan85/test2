package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SalesCategory")]

	public class SalesCategory extends ModelBase
	{

		public function SalesCategory() {
			remoteObjectName = "com.efi.printsmith.data.SalesCategory";
		}
				
		public var name:String = "";
	
	}
}