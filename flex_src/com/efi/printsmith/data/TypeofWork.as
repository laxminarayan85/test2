package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.TypeofWork")]

	public class TypeofWork extends ModelBase
	{

		public function TypeofWork() {
			remoteObjectName = "com.efi.printsmith.data.TypeofWork";
		}
				
		public var name:String = "";
	
	}
}