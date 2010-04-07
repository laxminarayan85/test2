package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.BasicSize")]

	public class BasicSize extends ModelBase
	{

		public function BasicSize() {
			remoteObjectName = "com.efi.printsmith.data.BasicSize";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}