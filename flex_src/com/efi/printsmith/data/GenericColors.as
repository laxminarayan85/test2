package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.GenericColors")]
	[Managed]
	public class GenericColors extends ModelBase
	{

		public function GenericColors() {
			remoteObjectName = "com.efi.printsmith.data.GenericColors";
		}
				
		public var name:String = "";
	
	}
}