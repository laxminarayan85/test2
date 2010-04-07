package com.efi.printsmith.data
{
	import mx.collections.ArrayCollection; 
	import com.efi.printsmith.data.*;
	
	[Bindable]
	[RemoteClass(alias="com.efi.printsmith.data.SizeUS")]
	[Managed]
	public class SizeUS extends ModelBase
	{

		public function SizeUS() {
			remoteObjectName = "com.efi.printsmith.data.SizeUS";
		}
				
		public var name:String = "";
		public var size:String = "";
	
	}
}